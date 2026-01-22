import React, { useEffect, useRef, useState } from 'react';

interface TerminalProps {
  logs: string[];
}

export const Terminal: React.FC<TerminalProps> = ({ logs = [] }) => {
  const bottomRef = useRef<HTMLDivElement>(null);
  const [promptVisible, setPromptVisible] = useState(true);

  useEffect(() => {
    bottomRef.current?.scrollIntoView({ behavior: 'smooth' });
  }, [logs]);

  useEffect(() => {
    const interval = setInterval(() => setPromptVisible(v => !v), 500);
    return () => clearInterval(interval);
  }, []);

  return (
    <div className="bt4-glass border-2 border-red-900/40 p-5 font-mono text-[11px] h-64 overflow-y-auto relative bg-[#050000] shadow-[inset_0_0_30px_rgba(255,0,0,0.3)] group scrollbar-hide">
      <div className="sticky top-0 bg-[#0d0000] backdrop-blur-md mb-4 flex items-center justify-between border-b border-red-900/30 pb-2 z-10">
        <div className="flex gap-3 items-center">
          <div className="w-2.5 h-2.5 bg-red-600 animate-pulse shadow-[0_0_12px_red]"></div>
          <span className="text-red-600 uppercase font-black tracking-[0.3em] text-[10px] italic">OMEGA_SOVEREIGN_SHELL</span>
        </div>
        <div className="flex gap-6 items-center">
          <span className="text-[9px] text-zinc-700 font-mono tracking-widest uppercase">KERNEL::OMEGA_V18</span>
          <div className="flex items-center gap-2">
            <span className="text-red-500 font-bold text-[9px] tracking-[0.2em] animate-pulse">UPLINK_LIVE</span>
            <div className="w-1.5 h-1.5 bg-green-500 rounded-full"></div>
          </div>
        </div>
      </div>
      
      <div className="space-y-1.5">
        {(logs || []).map((log, i) => {
          const safeLog = String(log || 'EMPTY_SIGNAL');
          const check = (val: string) => typeof safeLog.includes === 'function' && safeLog.includes(val);

          const isSuccess = check('AUTHORIZED') || check('SUCCESS') || check('ACTIVE') || check('STABLE');
          const isError = check('ERR') || check('FAILED') || check('[!]');

          return (
            <div key={i} className="flex gap-4 items-start animate-in fade-in slide-in-from-left-2 duration-300">
              <span className="text-red-950 font-black opacity-40 shrink-0 select-none">[{String(i+1).padStart(3, '0')}]</span>
              <span className={`tracking-tighter break-all leading-tight ${
                isSuccess ? 'text-white font-black drop-shadow-[0_0_5px_rgba(255,255,255,0.3)]' 
                : isError ? 'text-red-500 font-bold' : 'text-zinc-500 font-medium'
              }`}>
                <span className="text-red-800 mr-2">>></span>{safeLog}
              </span>
            </div>
          );
        })}
        <div ref={bottomRef}></div>
      </div>
    </div>
  );
};