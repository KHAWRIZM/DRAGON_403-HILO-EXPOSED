import React, { useState, useEffect, useRef, useImperativeHandle, forwardRef } from 'react';
import { generateRadioBroadcast, generateWarRoomDialogue } from '../services/geminiService';
import { SupportedLanguage } from '../types';

interface Station {
  id: string;
  name: string;
  url: string;
  genre: string;
}

const STATIONS: Station[] = [
  { id: 'sov-01', name: 'OMEGA_PRIME', url: "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-8.mp3", genre: 'INDUSTRIAL' },
  { id: 'sov-02', name: 'NEURAL_STATIC', url: "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-16.mp3", genre: 'AMBIENT' },
  { id: 'sov-03', name: 'CYPHER_BEATS', url: "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3", genre: 'TECHNO' },
  { id: 'sov-04', name: 'VOID_SIGNAL', url: "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3", genre: 'DARK_WAVE' }
];

// PCM Decoder to handle raw bytes from Gemini TTS
async function decodePCM(data: Uint8Array, ctx: AudioContext, sampleRate: number): Promise<AudioBuffer> {
  const dataInt16 = new Int16Array(data.buffer, data.byteOffset, data.byteLength / 2);
  const buffer = ctx.createBuffer(1, dataInt16.length, sampleRate);
  const channelData = buffer.getChannelData(0);
  for (let i = 0; i < dataInt16.length; i++) {
    channelData[i] = dataInt16[i] / 32768.0;
  }
  return buffer;
}

function decodeBase64(base64: string): Uint8Array {
  try {
    const binaryString = atob(base64);
    const bytes = new Uint8Array(binaryString.length);
    for (let i = 0; i < binaryString.length; i++) {
      bytes[i] = binaryString.charCodeAt(i);
    }
    return bytes;
  } catch (e) {
    console.error("Base64 decoding failed", e);
    return new Uint8Array(0);
  }
}

export interface RadioRef {
  start: () => void;
  stop: () => void;
}

export const RadioModule = forwardRef<RadioRef, { lang: SupportedLanguage, evidenceContext?: string }>((props, ref) => {
  const [isPlaying, setIsPlaying] = useState(false);
  const [isTalking, setIsTalking] = useState(false);
  const [activeStation, setActiveStation] = useState<Station>(STATIONS[0]);
  const [status, setStatus] = useState("UPLINK::STANDBY");
  const [visualizer, setVisualizer] = useState<number[]>(new Array(40).fill(5));
  const [logs, setLogs] = useState<string[]>(["[OS] RADIO_V18 READY"]);
  
  const ctxRef = useRef<AudioContext | null>(null);
  const musicGain = useRef<GainNode | null>(null);
  const musicNode = useRef<AudioBufferSourceNode | null>(null);
  const voiceNode = useRef<AudioBufferSourceNode | null>(null);
  const analyserRef = useRef<AnalyserNode | null>(null);
  const timeoutRef = useRef<number | null>(null);

  useImperativeHandle(ref, () => ({
    start: startSystem,
    stop: stopSystem
  }));

  const addLog = (msg: string) => {
    setLogs(p => [...p.slice(-12), `[${new Date().toLocaleTimeString()}] ${String(msg || 'UNKNOWN_SIGNAL')}`]);
  };

  useEffect(() => {
    let animationFrame: number;
    const updateVisualizer = () => {
      if (isPlaying && analyserRef.current) {
        const dataArray = new Uint8Array(analyserRef.current.frequencyBinCount);
        analyserRef.current.getByteFrequencyData(dataArray);
        
        const segmentSize = Math.floor(dataArray.length / 40);
        const newVisuals = new Array(40).fill(0).map((_, i) => {
          let sum = 0;
          for (let j = 0; j < segmentSize; j++) {
            sum += dataArray[i * segmentSize + j];
          }
          const avg = sum / (segmentSize || 1);
          // Boost reactivity if talking
          const sensitivity = isTalking ? 1.4 : 1.0;
          const height = (avg / 255) * 100 * sensitivity;
          const jitter = Math.random() * 5;
          return Math.max(5, Math.min(100, height + jitter + (isTalking ? 20 : 0)));
        });
        setVisualizer(newVisuals);
      } else {
        setVisualizer(new Array(40).fill(2).map(() => Math.random() * 5));
      }
      animationFrame = requestAnimationFrame(updateVisualizer);
    };
    updateVisualizer();
    return () => cancelAnimationFrame(animationFrame);
  }, [isPlaying, isTalking]);

  const initAudio = () => {
    if (!ctxRef.current) {
      const AudioCtx = window.AudioContext || (window as any).webkitAudioContext;
      ctxRef.current = new AudioCtx({ sampleRate: 24000 });
      musicGain.current = ctxRef.current.createGain();
      analyserRef.current = ctxRef.current.createAnalyser();
      analyserRef.current.fftSize = 256;
      analyserRef.current.smoothingTimeConstant = 0.8;
      
      musicGain.current.connect(analyserRef.current);
      analyserRef.current.connect(ctxRef.current.destination);
      musicGain.current.gain.value = 0.15;
    }
    if (ctxRef.current.state === 'suspended') {
      ctxRef.current.resume();
    }
    return ctxRef.current;
  };

  const playBackgroundMusic = async (station: Station) => {
    const ctx = initAudio();
    try {
      addLog(`TUNING::${station.name} (${station.genre})`);
      const res = await fetch(station.url);
      if (!res.ok) throw new Error(`HTTP Error ${res.status}`);
      
      const buffer = await ctx.decodeAudioData(await res.arrayBuffer());
      if (musicNode.current) {
        try { musicNode.current.stop(); } catch(e) {}
      }
      
      const source = ctx.createBufferSource();
      source.buffer = buffer;
      source.loop = true;
      source.connect(musicGain.current!);
      source.start();
      musicNode.current = source;
      addLog("UPLINK_STABLE::BROADCAST_START");
    } catch (e) {
      addLog("ERR::STATION_UNREACHABLE - RETRYING_MESH");
      setTimeout(() => isPlaying && playBackgroundMusic(station), 5000);
    }
  };

  const broadcastTruth = async () => {
    if (!isPlaying) return;
    const ctx = initAudio();
    setStatus("DECODING_INTEL...");
    
    try {
      const script = await generateWarRoomDialogue(props.lang, props.evidenceContext || "Digital sovereignty maintenance and asset reclamation.");
      const b64 = await generateRadioBroadcast(script);
      
      if (b64 && isPlaying) {
        setIsTalking(true);
        setStatus("BROADCASTING_TRUTH");
        
        // Duck the music smoothly
        musicGain.current!.gain.setTargetAtTime(0.02, ctx.currentTime, 0.8);

        const bytes = decodeBase64(b64);
        const audioBuffer = await decodePCM(bytes, ctx, 24000);

        if (voiceNode.current) {
          try { voiceNode.current.stop(); } catch(e) {}
        }
        
        const source = ctx.createBufferSource();
        source.buffer = audioBuffer;
        source.connect(analyserRef.current!);
        
        source.onended = () => {
          setIsTalking(false);
          addLog("TRANSMISSION_COMPLETE");
          musicGain.current!.gain.setTargetAtTime(0.15, ctx.currentTime, 1.2);
          setStatus("GRID_MONITORING");
          if (isPlaying) {
            const nextDelay = 20000 + Math.random() * 20000;
            timeoutRef.current = window.setTimeout(broadcastTruth, nextDelay);
          }
        };
        
        source.start();
        voiceNode.current = source;
      }
    } catch (e) {
      addLog("ERR::SIGNAL_INTERRUPTED_BY_WAF");
      setStatus("RECONNECTING...");
      if (isPlaying) {
        timeoutRef.current = window.setTimeout(broadcastTruth, 10000);
      }
    }
  };

  function startSystem() {
    setIsPlaying(true);
    addLog("RADIO_BOOT::OMEGA_CORE_ENGAGED");
    playBackgroundMusic(activeStation);
    timeoutRef.current = window.setTimeout(broadcastTruth, 4000);
  }

  function stopSystem() {
    setIsPlaying(false);
    setIsTalking(false);
    setStatus("UPLINK::OFFLINE");
    addLog("RADIO_SHUTDOWN::GRACEFUL");
    if (timeoutRef.current) clearTimeout(timeoutRef.current);
    try {
      musicNode.current?.stop();
      voiceNode.current?.stop();
    } catch (e) {}
  }

  const switchStation = (s: Station) => {
    setActiveStation(s);
    if (isPlaying) {
      playBackgroundMusic(s);
    }
  };

  return (
    <div className={`fixed bottom-6 right-6 z-[100] transition-all duration-700 ${isPlaying ? 'w-96' : 'w-72'} bt4-glass border-r-4 border-red-600 bg-black/98 p-6 shadow-[0_0_50px_rgba(255,0,0,0.15)] flex flex-col gap-4 overflow-hidden`}>
      <div className="flex justify-between items-center">
        <div className="flex items-center gap-3">
          <div className={`w-3 h-3 rounded-full transition-all duration-500 ${isPlaying ? 'bg-red-600 animate-pulse shadow-[0_0_15px_red]' : 'bg-zinc-800'}`}></div>
          <div className="flex flex-col">
            <span className="text-[10px] font-black uppercase tracking-widest text-red-600 leading-none">OMEGA_RADIO_V18</span>
            <span className="text-[8px] text-zinc-600 font-mono mt-1">FREQ: 403.18 MHz</span>
          </div>
        </div>
        <button 
          onClick={isPlaying ? stopSystem : startSystem}
          className={`w-12 h-12 flex items-center justify-center border-2 transition-all ${isPlaying ? 'bg-red-600 border-white text-white' : 'bg-black border-red-950 text-red-950 hover:text-red-500 hover:border-red-600'}`}
        >
          {isPlaying ? (
             <svg width="20" height="20" viewBox="0 0 24 24" fill="currentColor"><rect x="6" y="6" width="12" height="12"></rect></svg>
          ) : (
             <svg width="20" height="20" viewBox="0 0 24 24" fill="currentColor"><polygon points="5 3 19 12 5 21 5 3"></polygon></svg>
          )}
        </button>
      </div>

      <div className="h-20 flex items-end gap-[2px] bg-red-950/10 border border-red-900/10 rounded-sm overflow-hidden p-2 relative">
        <div className="absolute inset-0 bg-gradient-to-t from-red-600/5 to-transparent pointer-events-none"></div>
        {visualizer.map((h, i) => (
          <div 
            key={i} 
            className={`flex-1 transition-all duration-100 ${isTalking ? 'bg-white shadow-[0_0_10px_white]' : 'bg-red-600/60 shadow-[0_0_5px_red]'}`} 
            style={{ height: `${h}%` }}
          ></div>
        ))}
      </div>

      <div className="grid grid-cols-2 gap-2">
        {STATIONS.map(s => (
          <button
            key={s.id}
            onClick={() => switchStation(s)}
            className={`px-3 py-2 text-[8px] font-black uppercase border transition-all ${activeStation.id === s.id ? 'bg-red-600 border-white text-white' : 'bg-zinc-950 border-red-900/30 text-zinc-600 hover:border-red-600'}`}
          >
            {s.name}
          </button>
        ))}
      </div>

      <div className="bg-[#020000] border border-red-950/40 p-3 h-28 overflow-y-auto font-mono text-[9px] text-zinc-500 space-y-1.5 scrollbar-hide select-none">
        {logs.map((log, i) => (
          <div key={i} className="flex gap-2 animate-in fade-in duration-300">
            <span className="opacity-20 shrink-0">[{String(i).padStart(2, '0')}]</span>
            <span className={log.includes('ERR') ? 'text-red-800' : log.includes('STABLE') ? 'text-zinc-300' : ''}>{String(log)}</span>
          </div>
        ))}
      </div>

      <div className="flex justify-between items-center px-1 border-t border-red-900/10 pt-2">
        <div className="flex flex-col">
          <span className="text-[9px] font-black text-red-500 uppercase tracking-tighter truncate max-w-[140px] italic drop-shadow-[0_0_5px_rgba(255,0,0,0.3)]">{status}</span>
          <span className="text-[7px] text-zinc-800 uppercase font-black tracking-widest mt-0.5">SOVEREIGN_MESH_ACTIVE</span>
        </div>
        <div className="flex flex-col items-end">
          <span className="text-[8px] text-white font-black tracking-widest uppercase">{activeStation.genre}</span>
          <span className="text-[7px] text-zinc-700 font-mono mt-0.5">LATENCY: 14ms</span>
        </div>
      </div>
    </div>
  );
});