
import React, { useState, useEffect, useRef } from 'react';
import { INITIAL_STRIKES, ICONS, TRANSLATIONS } from './constants';
import { LegalStrike, ChatMessage, SupportedLanguage, Evidence, Priority, StrikeStatus } from './types';
import { Terminal } from './components/Terminal';
import { chatWithSovereignAI, FilePart } from './services/geminiService';
import { RadioModule, RadioRef } from './components/RadioModule';
import { SovereignBrowser } from './components/SovereignBrowser';
import { StrikeForm } from './components/StrikeForm';
import { StrikeCard } from './components/StrikeCard';
import { HackingToolkit } from './components/HackingToolkit';
import { NodeRadar } from './components/NodeRadar';
import { ForensicLab } from './components/ForensicLab';
import { EvidenceModal } from './components/EvidenceModal';

type ViewMode = 'COMMAND' | 'ASSETS' | 'MESH' | 'TOOLS';

const App: React.FC = () => {
  const [isAuthorized, setIsAuthorized] = useState(false);
  const [booting, setBooting] = useState(true);
  const [lang, setLang] = useState<SupportedLanguage>('AR');
  const [viewMode, setViewMode] = useState<ViewMode>('COMMAND');
  const [logs, setLogs] = useState<string[]>([]);
  const [chatInput, setChatInput] = useState('');
  const [attachedFiles, setAttachedFiles] = useState<{name: string, data: string, mime: string}[]>([]);
  const [messages, setMessages] = useState<ChatMessage[]>([]);
  const [isTyping, setIsTyping] = useState(false);
  const [strikes, setStrikes] = useState<LegalStrike[]>(INITIAL_STRIKES);
  const [showStrikeForm, setShowStrikeForm] = useState(false);
  const [bootProgress, setBootProgress] = useState(0);
  const [selectedEvidence, setSelectedEvidence] = useState<Evidence | null>(null);
  
  const chatScrollRef = useRef<HTMLDivElement>(null);
  const fileInputRef = useRef<HTMLInputElement>(null);
  const radioRef = useRef<RadioRef>(null);

  const t = TRANSLATIONS[lang] || TRANSLATIONS.EN;

  const [persistentMemory, setPersistentMemory] = useState<string>(() => {
    return localStorage.getItem('TITAN_V18_ARCHITECT_MEMORY') || "SOVEREIGN CORE V18 INITIALIZED. RIYADH ZERO MESH ONLINE.";
  });

  useEffect(() => {
    if (isAuthorized) {
      const bootSequence = [
        "AUTHENTICATING_DNA_SIGNATURE...",
        "DECRYPTING_SOVEREIGN_MANIFESTO...",
        "CONNECTING_TO_RIYADH_ZERO_NODES...",
        "BYPASSING_CORPORATE_TELEMETRY...",
        "STRIKE_FORCE_UPLINK::STABLE",
        "WELCOME_BACK_ARCHITECT."
      ];
      
      let progress = 0;
      const interval = setInterval(() => {
        progress += 2;
        setBootProgress(p => Math.min(p + 2, 100));
        
        if (progress >= 100) {
          clearInterval(interval);
          setTimeout(() => setBooting(false), 1000);
        }
        
        const logIdx = Math.floor((progress / 100) * bootSequence.length);
        if (bootSequence[logIdx] && !logs.includes(bootSequence[logIdx])) {
          setLogs(prev => [...prev, bootSequence[logIdx]]);
        }
      }, 60);

      const radioTimer = setTimeout(() => radioRef.current?.start(), 2000);
      return () => { clearInterval(interval); clearTimeout(radioTimer); };
    }
  }, [isAuthorized]);

  useEffect(() => {
    if (chatScrollRef.current) chatScrollRef.current.scrollTop = chatScrollRef.current.scrollHeight;
  }, [messages, isTyping]);

  const handleFileUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    const files = e.target.files;
    if (!files) return;
    Array.from(files).forEach(file => {
      const reader = new FileReader();
      reader.onload = (ev) => {
        const base64 = (ev.target?.result as string).split(',')[1];
        setAttachedFiles(prev => [...prev, { name: file.name, data: base64, mime: file.type || 'application/octet-stream' }]);
        setLogs(prev => [...prev, `FORENSIC_INGESTION::${file.name.toUpperCase()}`]);
      };
      reader.readAsDataURL(file);
    });
  };

  const handleSendMessage = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!chatInput.trim() && attachedFiles.length === 0) return;

    const userMsg: ChatMessage = { 
      role: 'user', 
      content: chatInput || `[ANALYZING_INGESTED_ASSETS: ${attachedFiles.map(f => f.name).join(', ')}]`, 
      timestamp: new Date() 
    };
    
    setMessages(prev => [...prev, userMsg]);
    const currentFiles = [...attachedFiles];
    setChatInput('');
    setIsTyping(true);

    const fileParts: FilePart[] = currentFiles.map(f => ({
      inlineData: { data: f.data, mimeType: f.mime }
    }));

    const result = await chatWithSovereignAI(chatInput || "Execute forensic deconstruction protocol.", lang, persistentMemory, fileParts);
    
    const newMemory = `${persistentMemory}\nArchitect_Action: ${chatInput.substring(0, 60)}...`;
    localStorage.setItem('TITAN_V18_ARCHITECT_MEMORY', newMemory);
    setPersistentMemory(newMemory);

    setMessages(prev => [...prev, { 
      role: 'model', 
      content: result.text, 
      timestamp: new Date(),
      groundingUrls: result.urls
    }]);
    setIsTyping(false);
  };

  const handleAddStrike = (newStrikeData: Omit<LegalStrike, 'id'>) => {
    const newStrike: LegalStrike = {
      ...newStrikeData,
      id: `strike-${Date.now()}`
    };
    setStrikes(prev => [newStrike, ...prev]);
    setLogs(prev => [...prev, `STRIKE_DEPLOYED::${newStrike.entity.toUpperCase()}`]);
  };

  const handleTogglePriority = (id: string) => {
    setStrikes(prev => prev.map(s => 
      s.id === id 
        ? { ...s, priority: s.priority === Priority.HIGH ? Priority.MEDIUM : Priority.HIGH } 
        : s
    ));
    setLogs(prev => [...prev, `PRIORITY_ADJUSTED::${id.toUpperCase()}`]);
  };

  if (!isAuthorized) {
    return (
      <div className="min-h-screen bg-black flex flex-col items-center justify-center p-10 font-mono relative overflow-hidden">
        <div className="scanner-line opacity-50"></div>
        <div className="absolute inset-0 bg-[linear-gradient(rgba(18,16,16,0)_50%,rgba(0,0,0,0.25)_50%),linear-gradient(90deg,rgba(255,0,0,0.06),rgba(0,255,0,0.02),rgba(0,0,255,0.06))] bg-[length:100%_2px,2px_100%] pointer-events-none"></div>
        <div className="z-10 text-center space-y-24">
          <div className="relative inline-block animate-pulse">
            <h1 className="text-red-600 text-[14rem] font-black italic tracking-tighter uppercase red-text-glow leading-none">V18</h1>
            <div className="absolute -top-12 -right-12 bg-red-600 text-white px-6 py-2 font-black text-2xl italic skew-x-12 border-4 border-white">SOVEREIGN</div>
          </div>
          <p className="text-zinc-600 uppercase tracking-[1.8em] text-[16px] font-black max-w-5xl mx-auto leading-relaxed flicker">{t.wolf_proverb}</p>
          <div className="flex gap-12 justify-center">
             <button onClick={() => { setLang('AR'); setIsAuthorized(true); }} className="px-32 py-16 border-4 border-red-600 text-red-600 text-6xl font-black uppercase hover:bg-red-600 hover:text-white transition-all shadow-[0_0_120px_rgba(255,0,0,0.4)] group relative overflow-hidden">
                <span className="relative z-10">العربية</span>
                <div className="absolute inset-0 bg-red-600/20 translate-y-full group-hover:translate-y-0 transition-transform duration-500"></div>
             </button>
             <button onClick={() => { setLang('EN'); setIsAuthorized(true); }} className="px-32 py-16 border-4 border-red-600 text-red-600 text-6xl font-black uppercase hover:bg-red-600 hover:text-white transition-all shadow-[0_0_120px_rgba(255,0,0,0.4)] group relative overflow-hidden">
                <span className="relative z-10">ENGLISH</span>
                <div className="absolute inset-0 bg-red-600/20 translate-y-full group-hover:translate-y-0 transition-transform duration-500"></div>
             </button>
          </div>
        </div>
      </div>
    );
  }

  if (booting) {
    return (
      <div className="min-h-screen bg-black flex flex-col items-center justify-center p-20 font-mono relative">
        <div className="scanner-line opacity-30"></div>
        <div className="text-red-600 text-8xl font-black italic uppercase animate-pulse mb-12 tracking-tighter">TITAN_BOOT_INIT</div>
        <div className="w-[1000px] h-4 bg-zinc-950 border-2 border-red-900/40 relative shadow-[0_0_100px_rgba(255,0,0,0.2)]">
          <div className="h-full bg-red-600 shadow-[0_0_40px_red] transition-all duration-75" style={{ width: `${bootProgress}%` }}></div>
        </div>
        <div className="mt-12 text-zinc-700 text-[14px] font-black uppercase tracking-[1.2em]">{bootProgress.toFixed(0)}% // KERNEL_LOADED</div>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-black text-white flex overflow-hidden font-mono relative selection:bg-red-600 selection:text-white">
      {/* Global OS Effects */}
      <div className="absolute inset-0 pointer-events-none z-50 overflow-hidden">
         <div className="absolute top-0 left-0 w-full h-full bg-[linear-gradient(rgba(18,16,16,0)_50%,rgba(0,0,0,0.1)_50%)] bg-[length:100%_4px]"></div>
         <div className="absolute top-0 left-0 w-full h-full bg-[radial-gradient(circle_at_center,rgba(60,0,0,0.05),transparent)] animate-pulse"></div>
      </div>
      
      <RadioModule ref={radioRef} lang={lang} evidenceContext={attachedFiles.map(f => f.name).join(', ')} />

      {/* OS Navigation Sidebar */}
      <aside className="w-48 bg-[#020000] border-r border-red-900/20 flex flex-col items-center py-12 gap-12 z-[60] shadow-[50px_0_150px_rgba(0,0,0,1)]">
        <div className="relative group cursor-pointer">
           <div className="w-28 h-28 bg-red-600 flex items-center justify-center text-black font-black text-6xl italic shadow-[0_0_80px_red] border-4 border-white/10 transition-all duration-1000 group-hover:rotate-[360deg]">Ω</div>
           <div className="absolute -inset-6 border-4 border-red-600/10 rounded-full animate-spin-slow"></div>
        </div>
        
        <nav className="flex flex-col gap-8 w-full px-6">
          {[
            { id: 'COMMAND', icon: <ICONS.Terminal />, label: t.command },
            { id: 'ASSETS', icon: <ICONS.File />, label: 'FORENSICS' },
            { id: 'MESH', icon: <ICONS.Globe />, label: t.mesh },
            { id: 'TOOLS', icon: <ICONS.Activity />, label: t.tools }
          ].map(item => (
            <button key={item.id} onClick={() => setViewMode(item.id as any)} className={`w-full h-28 flex flex-col items-center justify-center gap-3 border-4 transition-all relative ${viewMode === item.id ? 'bg-red-600 border-white shadow-[0_0_50px_red]' : 'border-zinc-900 text-zinc-700 hover:border-red-600'}`}>
              {item.icon}
              <span className="text-[10px] font-black uppercase tracking-widest">{item.label}</span>
              {viewMode === item.id && <div className="absolute -right-1 top-0 w-1.5 h-full bg-white"></div>}
            </button>
          ))}
        </nav>

        <div className="mt-auto grid grid-cols-2 gap-4 w-full px-6 border-t border-red-900/10 pt-8">
           {['AR', 'EN'].map(l => (
             <button key={l} onClick={() => setLang(l as any)} className={`h-12 text-[11px] font-black border-2 transition-all ${lang === l ? 'bg-white text-black border-white' : 'text-zinc-800 border-zinc-900 hover:border-red-600'}`}>{l}</button>
           ))}
        </div>
      </aside>

      {/* Operational Matrix */}
      <main className="flex-1 flex flex-col relative overflow-hidden">
        <header className="h-40 border-b border-red-900/30 flex items-center px-16 justify-between bg-black/98 backdrop-blur-3xl z-40 relative">
          <div className="flex flex-col">
            <h1 className="text-8xl font-black italic tracking-tighter text-red-600 red-text-glow uppercase leading-none">TITAN_V18</h1>
            <div className="flex gap-4 items-center mt-3">
              <span className="text-[11px] font-black text-zinc-600 tracking-[1em] uppercase">Sovereign_Logic_Stable</span>
              <div className="h-[2px] w-20 bg-red-950"></div>
              <span className="text-[11px] font-black text-red-900 uppercase">Riyadh_Zero_Core</span>
            </div>
          </div>
          
          <div className="flex gap-12 items-center">
             <div className="flex flex-col items-end border-r-4 border-red-600 pr-10">
                <span className="text-[16px] font-black uppercase text-red-500 tracking-[0.3em]">Operational Status</span>
                <span className="text-[11px] text-green-500 font-black animate-pulse">RECLAMATION_NODE_ACTIVE</span>
             </div>
             <button onClick={() => setShowStrikeForm(true)} className="bg-red-600 h-20 px-20 text-[18px] font-black uppercase tracking-[0.5em] hover:bg-red-700 transition-all shadow-[0_0_80px_rgba(255,0,0,0.5)] border-4 border-white/20 active:scale-95">
                {t.deploy_strike}
             </button>
          </div>
        </header>

        <div className="flex-1 p-12 grid grid-cols-1 lg:grid-cols-4 gap-12 overflow-hidden">
          {/* Left Wing: Monitoring */}
          <div className="lg:col-span-1 flex flex-col gap-12 overflow-hidden">
             <NodeRadar />
             <Terminal logs={logs} />
             <div className="bt4-glass p-10 border-l-[12px] border-red-600 flex-1 overflow-hidden flex flex-col bg-red-950/5 relative shadow-3xl">
                <div className="flex justify-between items-center mb-8 border-b-2 border-red-900/20 pb-6">
                  <h3 className="text-[14px] font-black text-red-500 uppercase tracking-widest italic flex items-center gap-4">
                    <div className="w-3 h-3 bg-red-600 rounded-full animate-ping"></div>
                    Deep_Cache_v18
                  </h3>
                </div>
                <div className="flex-1 text-[16px] text-zinc-500 overflow-y-auto italic font-mono leading-[2.2] opacity-80 scrollbar-hide">
                   {persistentMemory}
                </div>
             </div>
          </div>

          {/* Right Wing: Core Modules */}
          <div className="lg:col-span-3 flex flex-col gap-12 overflow-hidden">
            {viewMode === 'COMMAND' ? (
              <div className="flex-1 flex flex-col gap-12 overflow-hidden animate-in fade-in zoom-in duration-1000">
                <div className="flex-1 bt4-glass flex flex-col bg-black/95 border-t-[12px] border-red-600 overflow-hidden relative shadow-[0_0_200px_rgba(0,0,0,1)]">
                  <div className="absolute top-6 right-10 text-[12px] text-red-950 font-black opacity-30 tracking-[1.5em] uppercase italic pointer-events-none">Consensus_Environment_Alpha</div>
                  
                  <div className="flex-1 overflow-y-auto p-16 space-y-16 scrollbar-hide" ref={chatScrollRef}>
                    {messages.length === 0 && (
                      <div className="h-full flex flex-col items-center justify-center opacity-10 grayscale group">
                         <div className="w-80 h-80 border-[30px] border-red-950 flex items-center justify-center animate-spin-slow group-hover:border-red-600 transition-all duration-1000">
                           <div className="text-red-950 text-[12rem] font-black italic group-hover:text-red-600 transition-all">Ω</div>
                         </div>
                         <p className="mt-20 text-3xl font-black tracking-[3em] uppercase text-red-900">Awaiting_Architect</p>
                      </div>
                    )}
                    {messages.map((msg, i) => (
                      <div key={i} className={`flex flex-col ${msg.role === 'user' ? 'items-end' : 'items-start'} animate-in fade-in slide-in-from-bottom-8 duration-600`}>
                        <div className={`max-w-[85%] p-14 border-2 transition-all relative ${msg.role === 'user' ? 'bg-red-950/10 border-red-900/40 text-red-50 italic' : 'bg-[#030000] border-zinc-900 text-zinc-100 border-l-[24px] border-l-red-600 shadow-[40px_40px_100px_rgba(0,0,0,1)]'}`}>
                          <div className="text-[24px] font-bold leading-[1.8] whitespace-pre-wrap">{msg.content}</div>
                          {msg.groundingUrls && msg.groundingUrls.length > 0 && (
                            <div className="mt-12 pt-12 border-t-2 border-zinc-950 grid grid-cols-1 md:grid-cols-2 gap-8">
                               {msg.groundingUrls.map((u, idx) => (
                                 <a key={idx} href={u.uri} target="_blank" className="bg-black p-8 border-4 border-red-950 hover:border-red-600 hover:bg-red-950/20 transition-all flex items-center justify-between group">
                                    <span className="text-[14px] uppercase font-black text-red-500">>> {u.title}</span>
                                    <span className="opacity-0 group-hover:opacity-100 transition-all text-2xl">→</span>
                                 </a>
                               ))}
                            </div>
                          )}
                        </div>
                        <span className="mt-4 text-[12px] text-zinc-800 font-black uppercase tracking-[0.8em]">{msg.role === 'user' ? 'Uplink' : 'Omega_Core_v18'} // {msg.timestamp.toLocaleTimeString()}</span>
                      </div>
                    ))}
                    {isTyping && (
                      <div className="flex items-center gap-12 text-red-600 animate-pulse px-10 py-6 bg-red-950/5 border-2 border-red-900/20 w-fit">
                        <div className="w-8 h-8 bg-red-600 shadow-[0_0_40px_red]"></div>
                        <span className="text-[18px] font-black uppercase tracking-[1.5em]">{t.thinking}</span>
                      </div>
                    )}
                  </div>

                  {/* Operational Input */}
                  <div className="p-14 border-t-4 border-red-900/40 bg-[#010000] relative shadow-[0_-30px_100px_rgba(0,0,0,0.9)]">
                    <form onSubmit={handleSendMessage} className="flex gap-10 h-28">
                      <button type="button" onClick={() => fileInputRef.current?.click()} className="w-28 bg-zinc-950 border-8 border-zinc-900 flex items-center justify-center text-zinc-800 hover:text-red-600 hover:border-red-600 transition-all group relative overflow-hidden">
                        <div className="group-hover:scale-[2] transition-transform z-10"><ICONS.Plus /></div>
                        <div className="absolute inset-0 bg-red-600/10 opacity-0 group-hover:opacity-100 transition-opacity"></div>
                      </button>
                      <input type="file" ref={fileInputRef} multiple hidden onChange={handleFileUpload} />
                      <div className="flex-1 relative h-full">
                        <input type="text" value={chatInput} onChange={(e) => setChatInput(e.target.value)} placeholder="DECONSTRUCT_INFRASTRUCTURE_INPUT_V18..." className="w-full h-full bg-zinc-950 border-8 border-zinc-900 px-12 text-[32px] outline-none text-white italic font-black focus:border-red-600 transition-all placeholder:text-zinc-950" />
                        <div className="absolute right-12 top-1/2 -translate-y-1/2 text-[12px] text-zinc-900 font-black uppercase tracking-[1em] opacity-40">Architect_Verified</div>
                      </div>
                      <button type="submit" className="px-24 bg-red-600 hover:bg-red-700 transition-all font-black uppercase text-2xl tracking-[0.5em] border-4 border-white/20 shadow-[0_0_120px_rgba(255,0,0,0.6)] active:scale-95">
                        {t.execute}
                      </button>
                    </form>
                  </div>
                </div>
              </div>
            ) : viewMode === 'ASSETS' ? (
              <div className="flex-1 flex flex-col gap-12 overflow-hidden animate-in slide-in-from-right duration-1000">
                 <div className="h-28 flex items-center justify-between px-10 border-b-4 border-red-900/20 bg-red-950/5">
                    <h2 className="text-4xl font-black uppercase italic tracking-widest text-red-600 red-text-glow">Forensic_Analysis_Lab</h2>
                    <div className="flex items-center gap-8">
                      <span className="text-[12px] text-zinc-700 font-black tracking-[1em] uppercase animate-pulse">Deep_Scan_Active_v18</span>
                      <div className="w-4 h-4 bg-red-600 rounded-full animate-ping"></div>
                    </div>
                 </div>
                 <div className="flex-1 overflow-y-auto space-y-12 pr-6">
                    <div className="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 gap-10">
                      {strikes.map(s => (
                        <div key={s.id} onClick={() => {}} className="cursor-pointer h-full">
                          <StrikeCard strike={s} onTogglePriority={handleTogglePriority} />
                        </div>
                      ))}
                    </div>
                    <ForensicLab files={attachedFiles} onViewDetails={(ev) => setSelectedEvidence(ev)} />
                 </div>
              </div>
            ) : viewMode === 'MESH' ? (
              <SovereignBrowser lang={lang} memory={persistentMemory} />
            ) : (
              <HackingToolkit />
            )}
          </div>
        </div>
      </main>

      {showStrikeForm && <StrikeForm cases={[{ id: 'OMEGA-STRIKE', title: 'Global Strike Registry' }]} onSubmit={handleAddStrike} onClose={() => setShowStrikeForm(false)} />}
      {selectedEvidence && <EvidenceModal evidence={selectedEvidence} onClose={() => setSelectedEvidence(null)} />}
    </div>
  );
};

export default App;
