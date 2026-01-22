
import React from 'react';
import { Evidence, Priority } from '../types';
import { ICONS } from '../constants';

interface EvidenceModalProps {
  evidence: Evidence | null;
  onClose: () => void;
}

export const EvidenceModal: React.FC<EvidenceModalProps> = ({ evidence, onClose }) => {
  if (!evidence) return null;

  // Mock hex dump for the 'fucking real' feel
  const mockHexDump = Array.from({ length: 8 }, (_, i) => {
    const offset = (i * 16).toString(16).padStart(8, '0');
    const hex = Array.from({ length: 16 }, () => Math.floor(Math.random() * 256).toString(16).padStart(2, '0')).join(' ');
    const ascii = "................".split('').map(() => String.fromCharCode(Math.floor(Math.random() * 95) + 32)).join('');
    return `${offset}  ${hex}  |${ascii}|`;
  }).join('\n');

  return (
    <div className="fixed inset-0 z-[100] flex items-center justify-center p-4 bg-black/98 backdrop-blur-3xl">
      <div className="bg-black border-2 border-red-600/50 w-full max-w-4xl overflow-hidden animate-in fade-in zoom-in duration-500 relative shadow-[0_0_50px_rgba(255,0,0,0.2)]">
        <div className="absolute top-0 left-0 w-full h-1 bg-gradient-to-r from-transparent via-red-600 to-transparent"></div>
        <div className="absolute top-0 left-0 w-full h-full bg-[radial-gradient(circle_at_top,rgba(255,0,0,0.1),transparent)] pointer-events-none"></div>
        
        <div className="p-8 border-b border-red-900/30 flex justify-between items-center bg-red-950/10">
          <div className="flex items-center gap-8">
            <div className="w-14 h-14 flex items-center justify-center bg-red-600 text-white transform rotate-12 shadow-[0_0_30px_rgba(255,0,0,0.4)] border-2 border-white/20">
               <div className="transform -rotate-12 scale-125"><ICONS.File /></div>
            </div>
            <div>
              <h2 className="text-3xl font-black italic uppercase tracking-tighter text-white red-text-glow">{evidence.title}</h2>
              <div className="flex items-center gap-4 mt-2">
                <span className="text-[10px] font-black uppercase text-red-500 tracking-[0.3em] bg-red-950 px-2 py-0.5 border border-red-900/50">{evidence.caseId}</span>
                <span className="text-[10px] font-mono text-zinc-500 uppercase font-black">HASH: SHA-256_{Math.random().toString(16).slice(2, 10)}</span>
              </div>
            </div>
          </div>
          <button onClick={onClose} className="w-12 h-12 flex items-center justify-center border border-red-900/30 text-zinc-600 hover:text-white hover:border-red-600 transition-all bg-black group">
            <svg className="group-hover:rotate-90 transition-transform" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="3" strokeLinecap="round" strokeLinejoin="round"><line x1="18" y1="6" x2="6" y2="18"></line><line x1="6" y1="6" x2="18" y2="18"></line></svg>
          </button>
        </div>

        <div className="p-10 space-y-10">
          <div className="grid grid-cols-1 md:grid-cols-4 gap-6">
            <div className="p-5 bg-red-950/10 border border-red-900/20">
              <p className="skinny-caps text-zinc-600 mb-2">Severity</p>
              <p className={`text-base font-black italic uppercase ${evidence.severity === 'CRITICAL' ? 'text-red-500' : 'text-white'}`}>{evidence.severity}</p>
            </div>
            <div className="p-5 bg-red-950/10 border border-red-900/20">
              <p className="skinny-caps text-zinc-600 mb-2">Priority</p>
              <p className={`text-base font-black italic uppercase ${evidence.priority === Priority.HIGH ? 'text-red-500 animate-pulse' : 'text-white'}`}>{evidence.priority}</p>
            </div>
            <div className="p-5 bg-red-950/10 border border-red-900/20">
              <p className="skinny-caps text-zinc-600 mb-2">Node Type</p>
              <p className="text-base font-black italic uppercase text-zinc-300">{evidence.type}</p>
            </div>
            <div className="p-5 bg-red-950/10 border border-red-900/20">
              <p className="skinny-caps text-zinc-600 mb-2">Exfil Status</p>
              <p className="text-base font-black italic uppercase text-green-500 font-mono">COMPLETE_403</p>
            </div>
          </div>

          <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
            <div>
              <p className="skinny-caps text-zinc-500 mb-4 flex items-center gap-3">
                <span className="w-1.5 h-1.5 bg-red-600 shadow-[0_0_5px_red]"></span> Intelligence summary
              </p>
              <div className="bg-zinc-950 p-8 border border-red-900/20 font-mono text-[13px] leading-relaxed text-zinc-300 min-h-[250px] shadow-inner relative">
                <div className="absolute top-2 right-4 text-[9px] text-red-900 font-black">MODE::READ_ONLY</div>
                <div className="text-red-900 mb-6 font-black opacity-30 select-none tracking-widest">--- DECRYPTED_INTEL_START ---</div>
                <p className="font-bold">{evidence.details || evidence.summary}</p>
                <div className="text-red-900 mt-6 font-black opacity-30 select-none tracking-widest">--- DECRYPTED_INTEL_END ---</div>
              </div>
            </div>

            <div>
              <p className="skinny-caps text-zinc-500 mb-4 flex items-center gap-3">
                <span className="w-1.5 h-1.5 bg-red-600 shadow-[0_0_5px_red]"></span> RAW_DATA_HEX_PREVIEW
              </p>
              <div className="bg-black p-6 border border-zinc-900 font-mono text-[10px] leading-tight text-zinc-600 select-none h-full max-h-[250px] overflow-hidden group">
                <pre className="group-hover:text-zinc-500 transition-colors">
                  {mockHexDump}
                </pre>
                <div className="mt-4 text-red-900 font-black animate-pulse">[!] AUTHENTIC_REVENGE_STREAM_ACTIVE</div>
              </div>
            </div>
          </div>

          <div className="flex flex-col md:flex-row justify-between items-center gap-6 pt-6 border-t border-red-900/20">
             <div className="text-[10px] mono text-red-900 font-black tracking-widest flex items-center gap-3">
               <div className="w-2 h-2 bg-red-600 animate-ping"></div>
               SOVEREIGN_HACK_PROTOCOL_V4.0.3_ACTIVE
             </div>
             <div className="flex gap-4 w-full md:w-auto">
                <button onClick={onClose} className="flex-1 px-10 py-4 bg-transparent border-2 border-red-900/30 text-[11px] font-black uppercase tracking-widest hover:border-red-600 hover:text-white transition-all">Close Uplink</button>
                <button className="flex-1 px-10 py-4 bg-red-600 text-white text-[11px] font-black uppercase tracking-widest hover:bg-red-700 transition-all shadow-[0_0_30px_rgba(255,0,0,0.3)] border-2 border-red-500">Exfiltrate Logs</button>
             </div>
          </div>
        </div>
      </div>
    </div>
  );
};
