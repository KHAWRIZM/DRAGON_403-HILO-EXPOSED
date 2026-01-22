
import React from 'react';
import { LegalStrike, StrikeStatus, Priority } from '../types';
import { ICONS as UI_ICONS } from '../constants';

interface StrikeCardProps {
  strike: LegalStrike;
  onTogglePriority: (id: string) => void;
}

export const StrikeCard: React.FC<StrikeCardProps> = ({ strike, onTogglePriority }) => {
  const getStatusColor = (status: StrikeStatus) => {
    switch (status) {
      case StrikeStatus.COMPLETED: return 'text-white bg-red-600';
      case StrikeStatus.IN_PROGRESS: return 'text-red-500 bg-red-500/10 border border-red-500/20';
      case StrikeStatus.FAILED: return 'text-zinc-600 bg-zinc-800';
      default: return 'text-zinc-400 border border-zinc-800';
    }
  };

  const isHigh = strike.priority === Priority.HIGH;

  return (
    <div className={`group relative h-full bg-black border border-white/5 p-5 transition-all hover:bg-white/[0.03] ${isHigh ? 'shadow-[inset_0_0_10px_rgba(255,0,0,0.1)]' : ''}`}>
      <div className="absolute top-0 left-0 w-full h-[1px] bg-gradient-to-r from-transparent via-white/10 to-transparent scale-x-0 group-hover:scale-x-100 transition-transform duration-500"></div>
      
      <div className="flex justify-between items-start mb-4">
        <div className="flex flex-col">
          <span className="text-[8px] font-mono text-zinc-600 uppercase mb-1 tracking-widest">{strike.platform}</span>
          <h3 className="text-[12px] font-black uppercase tracking-widest text-white leading-none">
            {strike.entity}
          </h3>
        </div>
        <button 
          onClick={() => onTogglePriority(strike.id)}
          className={`transition-all hover:scale-110 ${isHigh ? 'text-red-600' : 'text-zinc-800 hover:text-zinc-600'}`}
        >
          <UI_ICONS.Star filled={isHigh} />
        </button>
      </div>

      <p className="text-[10px] text-zinc-500 font-medium leading-relaxed mb-6 h-12 overflow-hidden line-clamp-3">
        {strike.description}
      </p>

      <div className="flex justify-between items-center mt-auto pt-4 border-t border-white/5">
        <div className={`px-2 py-0.5 text-[7px] font-black uppercase tracking-widest ${getStatusColor(strike.status)}`}>
          {strike.status}
        </div>
        <span className="text-[8px] font-mono text-zinc-700">{strike.timestamp.split(' ')[0]}</span>
      </div>
    </div>
  );
};
