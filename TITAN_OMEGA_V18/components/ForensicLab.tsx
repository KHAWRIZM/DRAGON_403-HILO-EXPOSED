
import React from 'react';
import { ICONS } from '../constants';

interface ForensicLabProps {
  files: Array<{ name: string, data: string, mime: string }>;
  onViewDetails: (file: any) => void;
}

export const ForensicLab: React.FC<ForensicLabProps> = ({ files, onViewDetails }) => {
  if (files.length === 0) return (
    <div className="flex-1 flex flex-col items-center justify-center border-4 border-dashed border-red-900/10 opacity-20 grayscale group hover:grayscale-0 transition-all duration-1000">
      <div className="scale-[4] mb-20 animate-pulse"><ICONS.Shield /></div>
      <p className="text-2xl font-black tracking-[2em] uppercase text-red-950">Awaiting_Evidence</p>
    </div>
  );

  return (
    <div className="flex-1 space-y-10">
      {files.map((file, idx) => (
        <div key={idx} className="bt4-glass border-l-[20px] border-red-600 p-12 bg-black/80 animate-in slide-in-from-right duration-700 shadow-3xl group relative">
          <button 
            onClick={() => onViewDetails({
              id: `ev-${idx}-${Date.now()}`,
              title: file.name,
              type: file.mime.includes('code') ? 'CODE' : 'LOG',
              severity: 'CRITICAL',
              summary: `Forensic payload analysis for asset ${file.name}. High-entropy tracking signatures detected.`,
              priority: 'HIGH',
              caseId: 'OMEGA-V18',
              details: `Deep deconstruction of ${file.name} reveals unauthorized exfiltration points and embedded Chinese SDK markers (com.qiahao). Metadata signature suggests direct linkage to Singapore tracking nodes.`
            })}
            className="absolute top-8 right-8 w-16 h-16 flex items-center justify-center border-4 border-red-900/30 text-zinc-600 hover:text-white hover:border-red-600 transition-all z-10 bg-black shadow-2xl active:scale-90"
            title="DECONSTRUCT_NODE"
          >
            <div className="scale-150 rotate-45 group-hover:rotate-0 transition-transform"><ICONS.Plus /></div>
          </button>
          
          <div className="flex justify-between items-start mb-10 pr-20">
            <div className="flex items-center gap-10">
              <div className="p-6 bg-red-600 text-white transform group-hover:rotate-[360deg] transition-all duration-1000 shadow-[0_0_40px_red] border-2 border-white/20">
                <div className="scale-[2.5]"><ICONS.File /></div>
              </div>
              <div>
                <h4 className="text-4xl font-black text-white uppercase tracking-tighter group-hover:text-red-500 transition-colors leading-none">{file.name}</h4>
                <p className="text-[13px] text-zinc-500 font-mono mt-3 tracking-widest uppercase font-black">{file.mime} // SHA256_{Math.random().toString(16).slice(2, 14).toUpperCase()}</p>
              </div>
            </div>
            <div className="flex flex-col items-end gap-4">
              <span className="text-[14px] font-black text-red-500 bg-red-950 px-6 py-3 border-2 border-red-600 shadow-[0_0_20px_red] animate-pulse">CRITICAL_VULNERABILITY</span>
              <span className="text-[11px] text-zinc-700 font-black uppercase tracking-[0.6em] italic">Deconstruction_Level_0x18</span>
            </div>
          </div>
          
          <div className="grid grid-cols-1 lg:grid-cols-2 gap-12">
            <div className="bg-[#050000] p-10 border-4 border-red-900/30 font-mono text-[12px] text-red-400/40 h-56 overflow-hidden relative shadow-inner group-hover:border-red-600/30 transition-all">
               <div className="absolute top-3 right-6 text-[10px] text-red-900 font-black opacity-40 italic">RAW_HEX_PREVIEW</div>
               <div className="absolute inset-0 bg-gradient-to-t from-[#050000] via-transparent to-transparent z-10 pointer-events-none"></div>
               <pre className="leading-tight">
                 {Array.from({ length: 18 }).map((_, i) => (
                   <div key={i}>{`${(i * 16).toString(16).padStart(8, '0')}  ${Array.from({ length: 8 }).map(() => Math.floor(Math.random() * 256).toString(16).padStart(2, '0')).join(' ')}  |${Math.random().toString(36).substring(7).padEnd(16, '.')}|`}</div>
                 ))}
               </pre>
            </div>
            
            <div className="space-y-8">
               <p className="text-[12px] font-black text-zinc-500 uppercase tracking-[0.5em] flex items-center gap-4">
                 <div className="w-3 h-3 bg-red-600 animate-pulse"></div>
                 Extracted_Payload_Strings
               </p>
               <div className="grid grid-cols-2 gap-5">
                  {[
                    "com.qiahao.base_common",
                    "getIMEI_V3_RECLAMATION",
                    "api.tikhak.com_EXFIL",
                    "VPN_DETECTION_ENGAGED",
                    "carrier_tracking_node",
                    "exfiltrate_device_DNA",
                    "FindMy_Circumvention",
                    "SecureEnclave_Infiltration"
                  ].map((s, i) => (
                    <div key={i} className="bg-zinc-950 p-5 border-2 border-zinc-900 text-[11px] font-black text-zinc-600 uppercase tracking-tighter hover:border-red-600 hover:text-white transition-all cursor-default shadow-lg">
                       {s}
                    </div>
                  ))}
               </div>
            </div>
          </div>
          
          <div className="mt-12 pt-10 border-t-4 border-zinc-950 flex justify-between items-center">
             <div className="flex gap-12">
                <div className="text-[11px] font-black text-zinc-800 uppercase tracking-widest">Entropy: <span className="text-red-600">7.994 (EXTREME)</span></div>
                <div className="text-[11px] font-black text-zinc-800 uppercase tracking-widest">Packed: <span className="text-red-600">YES (ARMOR_V18)</span></div>
             </div>
             <div className="flex gap-6">
                <button 
                   onClick={() => onViewDetails({ title: file.name, summary: 'Analyzing architectural vulnerabilities...' })}
                   className="px-10 py-4 border-2 border-red-900/40 text-zinc-600 text-[11px] font-black uppercase tracking-[0.5em] hover:text-white hover:border-red-600 transition-all active:scale-95"
                >
                  DEEP_INSPECT
                </button>
                <button className="px-12 py-4 bg-red-600 text-white text-[11px] font-black uppercase tracking-[0.5em] hover:bg-red-700 transition-all shadow-[0_0_50px_rgba(255,0,0,0.4)] border-2 border-white/20 active:scale-95">
                  DEPLOY_TO_REGISTRY
                </button>
             </div>
          </div>
        </div>
      ))}
    </div>
  );
};
