import React, { useState, useEffect, useRef } from 'react';
import { INITIAL_STRIKES, ICONS, TRANSLATIONS, INITIAL_CASES } from './constants';
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
  const [booting, setBooting] = useState(false);
  const [bootProgress, setBootProgress] = useState(0);
  const [lang, setLang] = useState<SupportedLanguage>('AR');
  const [viewMode, setViewMode] = useState<ViewMode>('COMMAND');
  const [logs, setLogs] = useState<string[]>([]);
  const [messages, setMessages] = useState<ChatMessage[]>([]);
  const [chatInput, setChatInput] = useState('');
  const [isTyping, setIsTyping] = useState(false);
  const [attachedFiles, setAttachedFiles] = useState<{name: string, data: string, mime: string}[]>([]);
  const [strikes, setStrikes] = useState<LegalStrike[]>(INITIAL_STRIKES);
  const [showStrikeForm, setShowStrikeForm] = useState(false);
  const [selectedEvidence, setSelectedEvidence] = useState<Evidence | null>(null);
  const [isGlitching, setIsGlitching] = useState(false);
  const [integrity, setIntegrity] = useState(100);

  const chatScrollRef = useRef<HTMLDivElement>(null);
  const fileInputRef = useRef<HTMLInputElement>(null);
  const radioRef = useRef<RadioRef>(null);

  const t = TRANSLATIONS[lang] || TRANSLATIONS.EN;

  const [memory, setMemory] = useState<string>(() => {
    return localStorage.getItem('TITAN_V18_MEMORY') || 
      "RIYADH_ZERO_PROTOCOL_V18_ACTIVE. MISSION: HILO RECLAMATION. Accountable parties mapped.";
  });

  useEffect(() => {
    if (isAuthorized) {
      setBooting(true);
      const sequence = [
        "AUTH_DNA_VERIFIED...", 
        "DECRYPT_MANIFESTO_RIYADH_ZERO...", 
        "BYPASS_CORPORATE_TELEMETRY...", 
        "HILO_STRIKE_v2_BURST_MODE...", 
        "WELCOME_ARCHITECT_KHAWRIZM."
      ];
      let p = 0;
      const interval = setInterval(() => {
        p += 1;
        setBootProgress(p);
        const logIdx = Math.floor((p / 100) * sequence.length);
        const logToDisplay = sequence[logIdx];
        
        if (logToDisplay) {
          setLogs(prev => {
            const current = Array.isArray(prev) ? prev : [];
            if (typeof current.includes === 'function' && current.includes(logToDisplay)) return current;
            return [...current, logToDisplay];
          });
        }
        
        if (p >= 100) {
          clearInterval(interval);
          setBooting(false);
          // Auto-start radio after boot
          setTimeout(() => {
            if (radioRef.current) radioRef.current.start();
          }, 1000);
        }
      }, 30);
      return () => clearInterval(interval);
    }
  }, [isAuthorized]);

  useEffect(() => {
    if (integrity < 100) {
      const timer = setTimeout(() => setIntegrity(i => Math.min(100, i + 1)), 5000);
      return () => clearTimeout(timer);
    }
  }, [integrity]);

  useEffect(() => {
    const glitcher = setInterval(() => {
      if (integrity < 30 || Math.random() > 0.98) {
        setIsGlitching(true);
        document.body.classList.add('is-glitching');
        setTimeout(() => {
          setIsGlitching(false);
          document.body.classList.remove('is-glitching');
        }, 150);
      }
    }, 2000);
    return () => clearInterval(glitcher);
  }, [integrity]);

  useEffect(() => {
    if (chatScrollRef.current) chatScrollRef.current.scrollTop = chatScrollRef.current.scrollHeight;
  }, [messages, isTyping]);

  const handleSendMessage = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!chatInput.trim() && attachedFiles.length === 0) return;

    const safeInput = String(chatInput || "");
    const userMsg: ChatMessage = { 
      role: 'user', 
      content: safeInput || (attachedFiles.length > 0 ? "ATTACHED_FILES_SIGNAL" : ""), 
      timestamp: new Date() 
    };
    
    setMessages(prev => [...prev, userMsg]);
    setChatInput('');
    setIsTyping(true);
    setLogs(prev => [...(Array.isArray(prev) ? prev : []), `[USER_UPLINK] ${userMsg.content.substring(0, 30)}...`]);

    try {
      const fileParts: FilePart[] = (attachedFiles || []).map(f => ({
        inlineData: { data: f.data, mimeType: f.mime }
      }));

      const res = await chatWithSovereignAI(userMsg.content, lang, memory, fileParts);
      
      const modelMsg: ChatMessage = {
        role: 'model',
        content: res.text || "NO_DATA_RETURNED",
        timestamp: new Date(),
        groundingUrls: res.urls || []
      };

      setMessages(prev => [...prev, modelMsg]);
      setAttachedFiles([]);
      if (res.text) {
        setMemory(prev => `${String(prev || '')}\nARCHITECT: ${safeInput.substring(0, 50)}`);
      }
    } catch (err) {
      setLogs(prev => [...(Array.isArray(prev) ? prev : []), "[ERR] OMEGA_NEURAL_ROUTING_FAILED"]);
    } finally {
      setIsTyping(false);
    }
  };

  const handleFileUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    const files = e.target.files;
    if (!files) return;

    Array.from(files).forEach((file: File) => {
      const reader = new FileReader();
      reader.onload = (rev) => {
        const base64 = (rev.target?.result as string).split(',')[1];
        setAttachedFiles(prev => [...(Array.isArray(prev) ? prev : []), { 
          name: file.name, 
          data: base64, 
          mime: file.type || 'application/octet-stream' 
        }]);
        setLogs(prev => [...(Array.isArray(prev) ? prev : []), `[FILE_STAGED] ${file.name}`]);
      };
      reader.readAsDataURL(file);
    });
  };

  const addNewStrike = (strike: Omit<LegalStrike, 'id'>) => {
    const newStrike: LegalStrike = {
      ...strike,
      id: `manual-${Date.now()}`
    };
    setStrikes(prev => [newStrike, ...prev]);
    setLogs(prev => [...prev, `[STRIKE_DEPLOYED] Target: ${newStrike.entity}`]);
  };

  if (!isAuthorized) {
    return (
      <div className="min-h-screen bg-[#050000] flex items-center justify-center p-6 overflow-hidden relative">
        <div className="absolute inset-0 bg-[radial-gradient(circle_at_center,rgba(255,0,0,0.1),transparent)]"></div>
        <div className="bt4-glass border-4 border-red-900 p-16 max-w-2xl w-full text-center space-y-12 relative shadow-[0_0_100px_rgba(255,0,0,0.2)]">
           <div className="space-y-4">
              <h1 className="text-6xl font-black italic text-white uppercase tracking-tighter red-text-glow">TITAN_OMEGA</h1>
              <p className="text-red-600 font-mono text-xs uppercase tracking-[0.5em] font-black">Sovereign Reclamation Engine v18.0.3</p>
           </div>
           <div className="bg-black/50 p-8 border border-red-900/30 text-zinc-500 font-mono text-[11px] leading-relaxed text-left">
             <span className="text-red-900 font-black">MANIFESTO:</span> {String(memory || '').substring(0, 200)}...
           </div>
           <button 
             onClick={() => setIsAuthorized(true)}
             className="w-full bg-red-600 hover:bg-red-700 text-white py-6 text-xl font-black uppercase tracking-[1em] transition-all transform hover:scale-[1.02] shadow-[0_0_50px_rgba(255,0,0,0.4)] border-2 border-white/20 active:scale-95"
           >
             AUTHORIZE_DNA
           </button>
        </div>
      </div>
    );
  }

  if (booting) {
    return (
      <div className="min-h-screen bg-[#050000] flex flex-col items-center justify-center p-12 gap-16">
        <div className="w-full max-w-4xl space-y-6">
           <div className="flex justify-between items-end">
              <span className="text-red-600 font-black text-xs uppercase tracking-widest animate-pulse">BOOTING_CORE_LOBES...</span>
              <span className="text-zinc-700 font-mono text-xs">{bootProgress}%</span>
           </div>
           <div className="h-4 bg-zinc-950 border-2 border-red-900/20 p-1 shadow-[0_0_20px_rgba(255,0,0,0.1)]">
              <div className="h-full bg-red-600 transition-all duration-300 shadow-[0_0_15px_red]" style={{ width: `${bootProgress}%` }}></div>
           </div>
        </div>
        <div className="w-full max-w-lg">
           <Terminal logs={logs} />
        </div>
      </div>
    );
  }

  return (
    <div className={`min-h-screen bg-black text-white font-sans flex flex-col selection:bg-red-600 selection:text-white ${isGlitching ? 'opacity-90 grayscale-[0.5]' : ''}`}>
      <header className="h-20 border-b-2 border-zinc-900 flex items-center justify-between px-10 bg-black sticky top-0 z-50">
        <div className="flex items-center gap-10">
          <div className="flex flex-col">
            <h1 className="text-2xl font-black italic tracking-tighter text-white uppercase leading-none">{t.arsenal}</h1>
            <span className="text-[10px] text-red-600 font-mono font-black uppercase tracking-[0.4em] mt-1">{t.status}</span>
          </div>
          <nav className="flex gap-1">
            {(['COMMAND', 'ASSETS', 'MESH', 'TOOLS'] as ViewMode[]).map(m => (
              <button 
                key={m} 
                onClick={() => setViewMode(m)}
                className={`px-8 py-3 text-[10px] font-black uppercase tracking-widest transition-all ${viewMode === m ? 'bg-white text-black italic' : 'text-zinc-500 hover:text-white'}`}
              >
                {t[m.toLowerCase()] || m}
              </button>
            ))}
          </nav>
        </div>
        <div className="flex items-center gap-10">
           <div className="flex gap-4">
              {Object.keys(TRANSLATIONS).map(l => (
                <button 
                  key={l} 
                  onClick={() => setLang(l as SupportedLanguage)}
                  className={`text-[10px] font-black uppercase tracking-tighter ${lang === l ? 'text-red-600' : 'text-zinc-700 hover:text-zinc-400'}`}
                >
                  {l}
                </button>
              ))}
           </div>
           <div className="h-10 w-[1px] bg-zinc-900"></div>
           <div className="flex flex-col items-end">
              <span className="text-[9px] text-zinc-700 font-mono uppercase">System_Integrity</span>
              <div className="w-32 h-1.5 bg-zinc-950 border border-zinc-900 mt-1">
                <div className={`h-full transition-all duration-1000 ${integrity < 30 ? 'bg-red-600' : 'bg-green-600'}`} style={{ width: `${integrity}%` }}></div>
              </div>
           </div>
        </div>
      </header>

      <main className="flex-1 flex overflow-hidden">
        <aside className="w-[450px] border-r-2 border-zinc-900 flex flex-col bg-[#020202]">
           {viewMode === 'COMMAND' && (
             <div className="flex-1 flex flex-col p-8 space-y-8">
                <div className="space-y-4">
                   <div className="flex justify-between items-center">
                      <h3 className="text-zinc-600 font-black text-[10px] uppercase tracking-widest">{t.dashboard}</h3>
                      <button onClick={() => setShowStrikeForm(true)} className="w-8 h-8 flex items-center justify-center bg-red-600 hover:bg-red-700 transition-all shadow-[0_0_15px_red]">
                        <ICONS.Plus />
                      </button>
                   </div>
                   <div className="grid grid-cols-1 gap-4 overflow-y-auto max-h-[600px] pr-2 scrollbar-hide">
                      {(strikes || []).map(strike => (
                        <StrikeCard 
                          key={strike.id} 
                          strike={strike} 
                          onTogglePriority={(id) => setStrikes(prev => (prev || []).map(s => s.id === id ? {...s, priority: s.priority === Priority.HIGH ? Priority.LOW : Priority.HIGH} : s))}
                        />
                      ))}
                   </div>
                </div>
                <NodeRadar />
                <div className="mt-auto">
                   <Terminal logs={(logs || []).slice(-20)} />
                </div>
             </div>
           )}

           {viewMode === 'ASSETS' && (
             <div className="flex-1 flex flex-col p-8">
                <div className="mb-10 flex justify-between items-center">
                  <h3 className="text-zinc-600 font-black text-[10px] uppercase tracking-widest">Evidence_Storage</h3>
                  <button 
                    onClick={() => fileInputRef.current?.click()}
                    className="px-6 py-2 bg-zinc-900 text-[10px] font-black uppercase tracking-widest hover:bg-red-600 transition-all"
                  >
                    Ingest_Node
                  </button>
                  <input ref={fileInputRef} type="file" multiple className="hidden" onChange={handleFileUpload} />
                </div>
                <div className="flex-1 overflow-y-auto space-y-4 pr-2 scrollbar-hide">
                  {(!attachedFiles || attachedFiles.length === 0) && <div className="text-zinc-800 text-center py-20 font-mono text-xs italic">AWAITING_FORENSIC_INGESTION</div>}
                  {(attachedFiles || []).map((f, i) => (
                    <div key={i} className="p-4 bg-zinc-950 border border-zinc-900 flex items-center gap-4 group">
                      <div className="text-red-900"><ICONS.File /></div>
                      <span className="text-[11px] font-black uppercase text-zinc-500 group-hover:text-white truncate">{f.name}</span>
                    </div>
                  ))}
                </div>
             </div>
           )}

           {viewMode === 'MESH' && <div className="p-8 text-zinc-800 italic font-mono text-xs">MESH_VISUALIZER_v18_LOADING...</div>}
           {viewMode === 'TOOLS' && <div className="p-8 text-zinc-800 italic font-mono text-xs">TOOLKIT_V18_OFFLINE_FOR_MAINTENANCE</div>}
        </aside>

        <section className="flex-1 flex flex-col relative bg-black">
          {viewMode === 'COMMAND' && (
            <div className="flex-1 flex flex-col p-12">
               <div className="flex-1 overflow-y-auto space-y-12 mb-12 pr-4 scrollbar-hide" ref={chatScrollRef}>
                 {(!messages || messages.length === 0) && (
                   <div className="h-full flex flex-col items-center justify-center space-y-8 opacity-20 grayscale hover:grayscale-0 transition-all duration-1000">
                      <div className="scale-[4] mb-10 text-red-600"><ICONS.Terminal /></div>
                      <p className="max-w-md text-center text-sm font-black tracking-[1.5em] leading-relaxed uppercase">Awaiting_Command_Directives</p>
                   </div>
                 )}
                 {(messages || []).map((m, i) => (
                   <div key={i} className={`flex flex-col ${m.role === 'user' ? 'items-end' : 'items-start'} animate-in fade-in slide-in-from-bottom-4 duration-500`}>
                      <div className="flex items-center gap-3 mb-2">
                        <span className="text-[9px] font-black uppercase text-zinc-700 tracking-widest">{m.role === 'user' ? 'ARCHITECT' : 'TITAN_OMEGA'}</span>
                        <span className="text-[8px] text-zinc-800 font-mono">{m.timestamp ? m.timestamp.toLocaleTimeString() : ''}</span>
                      </div>
                      <div className={`max-w-[80%] p-8 ${m.role === 'user' ? 'bg-zinc-950 border-r-8 border-white' : 'bg-[#050000] border-l-8 border-red-600 shadow-[0_0_40px_rgba(255,0,0,0.05)]'}`}>
                         <p className={`text-[16px] leading-relaxed font-bold ${m.role === 'user' ? 'text-zinc-300' : 'text-white'}`}>{m.content}</p>
                      </div>
                   </div>
                 ))}
                 {isTyping && (
                   <div className="flex flex-col items-start">
                      <div className="flex items-center gap-3 mb-2">
                        <span className="text-[9px] font-black uppercase text-zinc-700 tracking-widest italic animate-pulse">TITAN_OMEGA::THINKING</span>
                      </div>
                      <div className="p-8 bg-zinc-950/20 border-l-8 border-red-900/40 w-[200px]">
                         <div className="flex gap-2">
                            <div className="w-2 h-2 bg-red-600 animate-bounce"></div>
                            <div className="w-2 h-2 bg-red-600 animate-bounce [animation-delay:0.2s]"></div>
                            <div className="w-2 h-2 bg-red-600 animate-bounce [animation-delay:0.4s]"></div>
                         </div>
                      </div>
                   </div>
                 )}
               </div>

               <form onSubmit={handleSendMessage} className="h-24 bg-zinc-950 border-2 border-zinc-900 flex items-center px-10 gap-8 focus-within:border-red-600 transition-all shadow-2xl">
                 <button type="button" onClick={() => fileInputRef.current?.click()} className="text-zinc-700 hover:text-white transition-colors"><ICONS.File /></button>
                 <input 
                   type="text" 
                   value={chatInput}
                   onChange={e => setChatInput(e.target.value)}
                   placeholder="COMMAND_DIRECTIVE_HERE..."
                   className="flex-1 bg-transparent text-white font-black uppercase text-lg outline-none placeholder:text-zinc-800"
                 />
                 <button type="submit" className="bg-white text-black px-12 h-14 font-black uppercase tracking-[0.4em] italic text-[11px] hover:bg-red-600 hover:text-white transition-all">
                   {t.execute}
                 </button>
               </form>
            </div>
          )}

          {viewMode === 'ASSETS' && <ForensicLab files={attachedFiles} onViewDetails={setSelectedEvidence} />}
          {viewMode === 'MESH' && <SovereignBrowser lang={lang} memory={memory} />}
          {viewMode === 'TOOLS' && <HackingToolkit />}
        </section>
      </main>

      <RadioModule ref={radioRef} lang={lang} evidenceContext={messages && messages.length > 0 ? messages[messages.length-1].content : ""} />
      {showStrikeForm && <StrikeForm cases={INITIAL_CASES} onSubmit={addNewStrike} onClose={() => setShowStrikeForm(false)} />}
      {selectedEvidence && <EvidenceModal evidence={selectedEvidence} onClose={() => setSelectedEvidence(null)} />}

      <div className="fixed inset-0 pointer-events-none bg-[radial-gradient(circle_at_center,transparent_30%,rgba(0,0,0,0.4)_100%)] z-[1000]"></div>
      <div className="fixed inset-0 pointer-events-none opacity-[0.03] bg-[linear-gradient(rgba(18,16,16,0)_50%,rgba(0,0,0,0.25)_50%)] bg-[length:100%_4px] z-[1001]"></div>
    </div>
  );
};

export default App;