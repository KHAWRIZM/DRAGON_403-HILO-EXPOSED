
import React, { useState, useEffect, useRef, useImperativeHandle, forwardRef } from 'react';
import { generateRadioBroadcast, generateWarRoomDialogue } from '../services/geminiService';
import { SupportedLanguage } from '../types';

const DEFAULT_MUSIC = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-8.mp3";

interface QueueItem {
  id: string;
  type: 'MUSIC_URL' | 'GENERATED_SCRIPT' | 'CUSTOM_TEXT';
  content: string;
  label: string;
  timestamp: Date;
}

export interface RadioRef {
  start: () => void;
  stop: () => void;
}

export const RadioModule = forwardRef<RadioRef, { lang: SupportedLanguage, evidenceContext?: string }>((props, ref) => {
  const [isPlaying, setIsPlaying] = useState(false);
  const [isTalking, setIsTalking] = useState(false);
  const [status, setStatus] = useState("UPLINK::STANDBY");
  const [visualizer, setVisualizer] = useState<number[]>(new Array(60).fill(2));
  const [queue, setQueue] = useState<QueueItem[]>([
    { id: '1', type: 'MUSIC_URL', content: DEFAULT_MUSIC, label: 'Standard War Frequency', timestamp: new Date() }
  ]);
  const [radioLogs, setRadioLogs] = useState<string[]>(["[KERNEL] OMEGA_RADIO_V18 INITIALIZED."]);
  const [customInput, setCustomInput] = useState('');
  const [showManager, setShowManager] = useState(false);
  const [terminalInput, setTerminalInput] = useState('');
  
  const ctxRef = useRef<AudioContext | null>(null);
  const musicGain = useRef<GainNode | null>(null);
  const voiceNode = useRef<AudioBufferSourceNode | null>(null);
  const musicNode = useRef<AudioBufferSourceNode | null>(null);
  const queueIndex = useRef(0);
  const logEndRef = useRef<HTMLDivElement>(null);

  useImperativeHandle(ref, () => ({
    start: startSystem,
    stop: stopSystem
  }));

  const addLog = (msg: string) => {
    setRadioLogs(prev => [...prev.slice(-30), `[${new Date().toLocaleTimeString()}] ${msg}`]);
  };

  useEffect(() => {
    logEndRef.current?.scrollIntoView({ behavior: 'smooth' });
  }, [radioLogs]);

  useEffect(() => {
    let interval: any;
    if (isPlaying) {
      interval = setInterval(() => {
        const time = Date.now() / 1000;
        setVisualizer(new Array(60).fill(0).map((_, i) => {
          // Sophisticated visualizer simulation using sine waves and noise
          const base = Math.sin(time * 3 + i * 0.15) * 20 + 30;
          const harmonics = Math.sin(time * 1.5 - i * 0.3) * 10;
          const noise = Math.random() * (isTalking ? 60 : 15);
          const intensity = isTalking ? 1.4 : 0.7;
          return Math.max(5, Math.min(100, (base + harmonics + noise) * intensity));
        }));
      }, 50);
    } else {
      setVisualizer(new Array(60).fill(2));
    }
    return () => clearInterval(interval);
  }, [isPlaying, isTalking]);

  const initAudio = () => {
    if (!ctxRef.current) {
      ctxRef.current = new (window.AudioContext || (window as any).webkitAudioContext)({ sampleRate: 24000 });
      musicGain.current = ctxRef.current.createGain();
      musicGain.current.connect(ctxRef.current.destination);
    }
    if (ctxRef.current?.state === 'suspended') ctxRef.current.resume();
    return ctxRef.current;
  };

  const playNextInQueue = async () => {
    if (!isPlaying) return;
    const current = queue[queueIndex.current % queue.length];
    addLog(`UPLINK::LOADED::${current.label.toUpperCase()}`);
    
    if (current.type === 'MUSIC_URL') {
      await startBackgroundMusic(current.content);
      setTimeout(() => broadcastCycle(), 5000);
    } else if (current.type === 'CUSTOM_TEXT') {
      broadcastCycle(current.content);
    } else {
      broadcastCycle();
    }
    
    queueIndex.current++;
  };

  const startBackgroundMusic = async (url: string) => {
    const ctx = initAudio();
    try {
      addLog(`FETCHING_STREAM[${url.substring(0, 20)}...]`);
      const res = await fetch(url);
      const buffer = await ctx.decodeAudioData(await res.arrayBuffer());
      
      if (musicNode.current) musicNode.current.stop();
      
      const source = ctx.createBufferSource();
      source.buffer = buffer;
      source.loop = true;
      source.connect(musicGain.current!);
      musicGain.current!.gain.value = 0.15;
      source.start();
      musicNode.current = source;
      addLog("UPLINK_STABLE::BATTLE_MUSIC_LAYER");
    } catch (e) {
      addLog("CRITICAL_ERR::UPLINK_BYPASS_ENGAGED");
      setStatus("MUSIC_BYPASS_ENGAGED");
    }
  };

  const broadcastCycle = async (customScript?: string) => {
    if (!isPlaying || !ctxRef.current || !musicGain.current) return;
    
    setStatus("NEURAL_SYNTHESIS...");
    const script = customScript || await generateWarRoomDialogue(props.lang, props.evidenceContext || "");
    
    addLog(`BROADCAST_PAYLOAD_READY[${script.length}b]`);
    setIsTalking(true);
    setStatus("WAR_ROOM_LIVE");
    
    // Smooth audio ducking
    musicGain.current.gain.linearRampToValueAtTime(0.02, ctxRef.current.currentTime + 1.2);

    try {
      const b64 = await generateRadioBroadcast(script);
      if (b64 && isPlaying) {
        const bytes = atob(b64).split('').map(c => c.charCodeAt(0));
        const dataInt16 = new Int16Array(new Uint8Array(bytes).buffer);
        const buffer = ctxRef.current.createBuffer(1, dataInt16.length, 24000);
        const channel = buffer.getChannelData(0);
        for (let i = 0; i < dataInt16.length; i++) channel[i] = dataInt16[i] / 32768.0;

        const source = ctxRef.current.createBufferSource();
        source.buffer = buffer;
        source.connect(ctxRef.current.destination);
        
        source.onended = () => {
          setIsTalking(false);
          addLog("VOICE_TRANSMISSION_COMPLETE");
          musicGain.current?.gain.linearRampToValueAtTime(0.15, ctxRef.current!.currentTime + 1.5);
          setStatus("MONITORING...");
          if (isPlaying) setTimeout(playNextInQueue, 15000); 
        };
        
        source.start();
        voiceNode.current = source;
      }
    } catch (e) {
      addLog("ERR::VOICE_SYNTHESIS_FAIL");
      setIsTalking(false);
      musicGain.current.gain.linearRampToValueAtTime(0.15, ctxRef.current.currentTime + 1);
      if (isPlaying) setTimeout(playNextInQueue, 15000);
    }
  };

  async function startSystem() {
    initAudio();
    setIsPlaying(true);
    addLog("RADIO_OS_V18::BOOT_SUCCESS");
    playNextInQueue();
  }

  function stopSystem() {
    voiceNode.current?.stop();
    musicNode.current?.stop();
    setIsPlaying(false);
    setIsTalking(false);
    setStatus("UPLINK::OFFLINE");
    addLog("RADIO_OS_V18::SYSTEM_SHUTDOWN");
  }

  const handleTerminalSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (!terminalInput.trim()) return;
    
    const cmd = terminalInput.trim().toLowerCase();
    addLog(`architect@radio:~$ ${cmd}`);
    
    if (cmd === 'clear') {
      setRadioLogs(["[SYSTEM] Log cleared."]);
    } else if (cmd === 'status') {
      addLog(`ENGINE_V18: ${status} | QUEUE: ${queue.length} | TALKING: ${isTalking}`);
    } else if (cmd === 'skip') {
      addLog("MANUAL_SKIP_INITIATED");
      if (voiceNode.current) voiceNode.current.stop();
      playNextInQueue();
    } else {
      addLog(`ERR::UNKNOWN_CMD: ${cmd}`);
    }
    
    setTerminalInput('');
  };

  const addToQueue = (type: QueueItem['type']) => {
    if (!customInput.trim()) return;
    const newItem: QueueItem = {
      id: Date.now().toString(),
      type,
      content: customInput,
      label: type === 'MUSIC_URL' ? 'External Freq' : 'Intel Override',
      timestamp: new Date()
    };
    setQueue(prev => [...prev, newItem]);
    setCustomInput('');
    addLog(`CONFIG_LOADED::${newItem.label.toUpperCase()}`);
  };

  const removeFromQueue = (id: string) => {
    setQueue(prev => prev.filter(item => item.id !== id));
    addLog("QUEUE_ITEM_PURGED");
  };

  return (
    <div className={`fixed bottom-8 right-8 z-[100] transition-all duration-700 ${showManager ? 'w-[550px]' : 'w-[450px]'} bt4-glass border-b-8 border-red-600 p-8 bg-black/98 shadow-[0_0_150px_rgba(255,0,0,0.5)] flex flex-col gap-6`}>
      <div className="flex justify-between items-center">
        <div className="flex items-center gap-5">
          <div className="relative">
            <div className={`w-5 h-5 rounded-full ${isPlaying ? 'bg-red-600 animate-pulse shadow-[0_0_25px_red]' : 'bg-zinc-900'}`}></div>
            {isTalking && <div className="absolute -inset-2 border-2 border-red-500/30 rounded-full animate-ping"></div>}
          </div>
          <div className="flex flex-col">
            <span className="text-[14px] font-black text-red-600 uppercase tracking-[0.5em] italic leading-none">OMEGA_RADIO_V18</span>
            <span className="text-[9px] text-zinc-600 font-black uppercase mt-1 tracking-widest">Sovereign_Broadcast_Network</span>
          </div>
        </div>
        <div className="flex gap-4">
           <button onClick={() => setShowManager(!showManager)} className={`w-12 h-12 border-4 transition-all flex items-center justify-center ${showManager ? 'bg-red-950 border-red-600 text-red-500' : 'bg-zinc-950 border-zinc-900 text-zinc-600 hover:text-red-500 hover:border-red-600'}`}>
              <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="3"><path d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"></path><path d="M18.5 2.5a2.121 2.121 0 1 1 3 3L12 15l-4 1 1-4 9.5-9.5z"></path></svg>
           </button>
           <button onClick={isPlaying ? stopSystem : startSystem} className={`w-14 h-14 flex items-center justify-center border-4 transition-all shadow-2xl active:scale-90 ${isPlaying ? 'bg-red-600 border-white text-white' : 'bg-zinc-950 border-red-900 text-red-900 hover:border-red-600 hover:border-red-600'}`}>
            {isPlaying ? (
              <svg width="24" height="24" viewBox="0 0 24 24" fill="currentColor"><rect x="6" y="6" width="12" height="12"></rect></svg>
            ) : (
              <svg width="24" height="24" viewBox="0 0 24 24" fill="currentColor"><polygon points="5 3 19 12 5 21 5 3"></polygon></svg>
            )}
          </button>
        </div>
      </div>

      <div className="h-40 flex items-end justify-center gap-[2px] bg-red-950/5 border-2 border-red-900/10 rounded-2xl overflow-hidden relative shadow-inner">
        <div className="absolute inset-0 bg-[radial-gradient(circle_at_center,rgba(255,0,0,0.08),transparent)] pointer-events-none"></div>
        <div className="absolute top-0 left-0 w-full h-[1px] bg-red-600/10 animate-scan"></div>
        {visualizer.map((h, i) => (
          <div 
            key={i} 
            className={`flex-1 transition-all duration-75 ${isTalking ? 'bg-white shadow-[0_0_15px_white] scale-x-110' : 'bg-red-600/30'}`} 
            style={{ 
              height: `${h}%`,
              opacity: 0.3 + (h / 100) * 0.7,
              transform: `skewY(${Math.sin(i * 0.2 + (Date.now()/1000)) * 10}deg)`
            }}
          ></div>
        ))}
      </div>

      <div className="flex flex-col gap-4">
        {/* RADIO_TERMINAL */}
        <div className="bg-[#020000] border-2 border-red-900/30 p-6 h-48 overflow-y-auto font-mono text-[10px] text-red-950/80 space-y-2 relative group shadow-inner">
          <div className="absolute top-2 right-4 text-[8px] font-black opacity-20 uppercase tracking-widest">Live_Broadcast_Data</div>
          {radioLogs.map((log, i) => (
            <div key={i} className="flex gap-4">
              <span className="opacity-20 shrink-0 select-none">[{String(i).padStart(2, '0')}]</span>
              <span className={`break-all ${log.includes('ERROR') || log.includes('ERR') ? 'text-red-600 font-black underline' : log.includes('UPLINK') ? 'text-cyan-600 font-bold' : ''}`}>{log}</span>
            </div>
          ))}
          <div ref={logEndRef}></div>
        </div>

        {/* TERMINAL_COMMAND_INPUT */}
        <form onSubmit={handleTerminalSubmit} className="flex bg-zinc-950 border-2 border-zinc-900 px-4 py-2 shadow-lg">
           <span className="text-red-900 font-black mr-4 select-none italic">radio@omega:~$</span>
           <input 
             type="text" 
             value={terminalInput}
             onChange={(e) => setTerminalInput(e.target.value)}
             placeholder="ENTER_COMMAND (clear, status, skip)..."
             className="flex-1 bg-transparent text-white font-mono text-[11px] outline-none placeholder:text-zinc-900"
           />
        </form>

        {showManager && (
          <div className="space-y-4 animate-in fade-in slide-in-from-top-6 duration-500 border-t-2 border-red-900/10 pt-6">
            <h4 className="text-[11px] font-black text-red-600 uppercase tracking-widest italic flex items-center gap-2">
              <div className="w-2 h-2 bg-red-600"></div>
              BROADCAST_QUEUE_CONFIG
            </h4>
            
            <div className="flex flex-col gap-3">
              <textarea 
                value={customInput}
                onChange={(e) => setCustomInput(e.target.value)}
                placeholder="Target URL or Custom Intelligence Script Payload..."
                className="w-full bg-zinc-950 border-2 border-red-900/20 px-5 py-3 text-[11px] font-mono text-white outline-none focus:border-red-600 h-24 resize-none"
              />
              <div className="grid grid-cols-2 gap-4">
                <button 
                  onClick={() => addToQueue('MUSIC_URL')} 
                  className="bg-red-950/10 border-2 border-red-900/40 py-3 text-[10px] font-black uppercase tracking-[0.2em] text-red-600 hover:bg-red-600 hover:text-white transition-all shadow-lg"
                >
                  Inject Audio URL
                </button>
                <button 
                  onClick={() => addToQueue('CUSTOM_TEXT')} 
                  className="bg-red-950/10 border-2 border-red-900/40 py-3 text-[10px] font-black uppercase tracking-[0.2em] text-red-600 hover:bg-red-600 hover:text-white transition-all shadow-lg"
                >
                  Inject Intel Script
                </button>
              </div>
            </div>

            <div className="max-h-40 overflow-y-auto space-y-2 border-t border-red-900/10 pt-4 scrollbar-hide">
               {queue.map((item) => (
                 <div key={item.id} className="flex justify-between items-center bg-red-950/5 p-3 border border-red-900/10 group">
                    <div className="flex flex-col">
                       <span className="text-[9px] font-black text-red-600 uppercase tracking-widest">{item.type}</span>
                       <span className="text-[10px] text-zinc-500 truncate max-w-[300px]">{item.content}</span>
                    </div>
                    <button onClick={() => removeFromQueue(item.id)} className="text-zinc-800 hover:text-red-600 p-2 transition-colors opacity-0 group-hover:opacity-100">×</button>
                 </div>
               ))}
            </div>
          </div>
        )}

        <div className="bg-red-950/10 py-4 px-6 border-2 border-red-900/20 flex justify-between items-center group overflow-hidden relative">
          <div className="absolute inset-0 bg-red-600/5 translate-x-[-100%] group-hover:translate-x-[100%] transition-transform duration-1000"></div>
          <div className="text-[12px] font-black text-red-500 uppercase tracking-tighter truncate relative z-10">{status}</div>
          <div className="text-[10px] font-black text-red-900/40 animate-pulse relative z-10">Ω_V18</div>
        </div>
      </div>
    </div>
  );
});
