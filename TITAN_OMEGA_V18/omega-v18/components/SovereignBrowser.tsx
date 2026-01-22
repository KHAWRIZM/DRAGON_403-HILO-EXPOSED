
import React, { useState } from 'react';
import { chatWithSovereignAI } from '../services/geminiService';
import { SupportedLanguage } from '../types';

interface SovereignBrowserProps {
  lang: SupportedLanguage;
  memory: string;
}

export const SovereignBrowser: React.FC<SovereignBrowserProps> = ({ lang, memory }) => {
  const [urlInput, setUrlInput] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  const [result, setResult] = useState<{ text: string; urls: any[] } | null>(null);

  const handleSearch = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!urlInput.trim()) return;
    setIsLoading(true);
    const res = await chatWithSovereignAI(`PERCEPTION_LOBE_QUERY: ${urlInput}. Pierce the internet filth. Extract architectural truth and provide direct nodes.`, lang, memory);
    setResult(res);
    setIsLoading(false);
  };

  return (
    <div className="h-full flex flex-col space-y-8 animate-in slide-in-from-right-10 duration-700">
      <div className="bt4-glass p-10 bg-[#000505] border-cyan-900/40 shadow-[0_0_60px_rgba(0,255,255,0.05)] border-l-8 border-l-cyan-600">
        <div className="mb-6">
          <h2 className="text-cyan-600 font-black text-xs uppercase tracking-[0.5em] italic">Lobe_1: Perception_Eye // External_Uplink</h2>
        </div>
        <form onSubmit={handleSearch} className="flex gap-6">
           <div className="flex-1 bg-black border-2 border-cyan-950 flex items-center px-8 shadow-inner">
              <span className="text-cyan-900 font-black mr-6 uppercase text-[11px] tracking-widest select-none">OMEGA://BROWSE/</span>
              <input 
                type="text" 
                value={urlInput}
                onChange={(e) => setUrlInput(e.target.value)}
                placeholder="TARGET_NODE_OR_REAL_WORLD_QUERY..."
                className="flex-1 bg-transparent py-5 text-white outline-none font-black text-[16px] placeholder:text-zinc-900"
              />
           </div>
           <button 
             disabled={isLoading}
             className="bg-cyan-600 px-14 font-black uppercase tracking-[0.3em] text-[13px] hover:bg-cyan-500 shadow-[0_0_30px_cyan] disabled:opacity-50 transition-all border-2 border-white/10"
           >
             {isLoading ? 'PIERCING...' : 'EXPOSE'}
           </button>
        </form>
      </div>

      <div className="flex-1 bg-[#010303] border-4 border-cyan-950/30 overflow-hidden flex flex-col relative shadow-2xl">
        <div className="absolute inset-0 pointer-events-none bg-[linear-gradient(rgba(0,255,255,0.03)_1px,transparent_1px)] bg-[length:100%_30px]"></div>
        
        {!result && !isLoading && (
          <div className="flex-1 flex flex-col items-center justify-center opacity-20 space-y-8">
             <div className="w-32 h-32 border-8 border-cyan-900 flex items-center justify-center animate-spin-slow">
                <div className="w-20 h-20 bg-cyan-600/20 flex items-center justify-center">
                  <div className="w-10 h-10 bg-cyan-600"></div>
                </div>
             </div>
             <p className="text-sm font-black tracking-[1.2em] uppercase text-cyan-500">Awaiting External Uplink</p>
          </div>
        )}

        {isLoading && (
          <div className="flex-1 flex flex-col items-center justify-center space-y-10">
            <div className="w-full max-w-2xl bg-zinc-950 border-2 border-cyan-900 p-2 shadow-[0_0_40px_cyan]">
               <div className="h-4 bg-cyan-600 animate-progress origin-left"></div>
            </div>
            <div className="text-center space-y-2">
              <p className="text-[12px] font-black tracking-widest text-cyan-400 animate-pulse uppercase">Piercing_Firewalls // Grounding_Reality_v14</p>
              <p className="text-[9px] text-zinc-700 font-mono italic">Extracting raw nodes from public infrastructure...</p>
            </div>
          </div>
        )}

        {result && (
          <div className="flex-1 overflow-y-auto p-12 space-y-12">
            <div className="space-y-6">
              <div className="flex items-center gap-4">
                <div className="w-3 h-3 bg-cyan-600"></div>
                <h3 className="text-cyan-600 font-black uppercase text-xs tracking-[0.5em] italic">Omega Perception Analysis</h3>
              </div>
              <div className="text-[18px] font-bold text-white leading-relaxed whitespace-pre-wrap bg-zinc-950/80 p-10 border-l-8 border-cyan-600 shadow-2xl">
                {result.text}
              </div>
            </div>

            <div className="space-y-8">
              <div className="flex items-center gap-4">
                <div className="w-3 h-3 bg-cyan-600"></div>
                <h3 className="text-cyan-600 font-black uppercase text-xs tracking-[0.5em] italic">External Reality Nodes</h3>
              </div>
              <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
                {result.urls.map((u, i) => (
                  <a key={i} href={u.uri} target="_blank" className="p-8 bg-black border-2 border-cyan-900/50 hover:border-cyan-400 transition-all group relative overflow-hidden shadow-lg hover:shadow-[0_0_30px_rgba(0,255,255,0.1)]">
                    <div className="absolute top-0 right-0 p-4 opacity-10 group-hover:opacity-100 transition-opacity">
                      <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="4"><path d="M18 13v6a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h6"></path><polyline points="15 3 21 3 21 9"></polyline><line x1="10" y1="14" x2="21" y2="3"></line></svg>
                    </div>
                    <div className="text-[8px] text-cyan-900 font-black mb-3 uppercase">Node_ID: {i+1}</div>
                    <p className="text-[13px] font-black uppercase text-white truncate mb-3">{u.title}</p>
                    <p className="text-[9px] font-mono text-zinc-600 truncate border-t border-zinc-900 pt-3">{u.uri}</p>
                  </a>
                ))}
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};
