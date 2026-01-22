import React, { useState } from 'react';
import { LegalStrike, StrikeStatus, Priority } from '../types';

interface StrikeFormProps {
  cases: { id: string, title: string }[];
  onSubmit: (strike: Omit<LegalStrike, 'id'>) => void;
  onClose: () => void;
}

export const StrikeForm: React.FC<StrikeFormProps> = ({ cases, onSubmit, onClose }) => {
  const [formData, setFormData] = useState({
    entity: '',
    platform: '',
    status: StrikeStatus.PENDING,
    description: '',
    type: 'LEGAL' as const,
    priority: Priority.MEDIUM,
    caseId: cases[0]?.id || 'CASE-OMEGA-GENERAL',
    timestamp: new Date().toISOString().replace('T', ' ').substring(0, 19)
  });

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onSubmit(formData);
    onClose();
  };

  return (
    <div className="fixed inset-0 z-[200] flex items-center justify-center p-4 bg-black/98 backdrop-blur-2xl">
      <div className="absolute inset-0 bg-[radial-gradient(circle_at_center,rgba(255,0,0,0.05),transparent)] pointer-events-none"></div>
      
      <form onSubmit={handleSubmit} className="bg-black border-4 border-red-600 w-full max-w-2xl p-10 space-y-8 shadow-[0_0_100px_rgba(255,0,0,0.2)] relative animate-in zoom-in-95 duration-300">
        <div className="flex justify-between items-center border-b border-red-900/30 pb-6">
          <h2 className="text-3xl font-black text-red-600 uppercase tracking-tighter italic">DEPLOY_STRIKE_V18</h2>
          <span className="text-[10px] font-mono text-zinc-600">CMD::OMEGA_STRIKE_INIT</span>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-8">
          <div className="space-y-2">
            <label className="text-[10px] font-black uppercase tracking-widest text-zinc-500">Target Entity</label>
            <input 
              required 
              placeholder="e.g. Google-Node-Alpha" 
              className="w-full bg-zinc-950 border-2 border-red-900/30 focus:border-red-600 p-4 outline-none text-white font-bold transition-all" 
              value={formData.entity} 
              onChange={e => setFormData({...formData, entity: e.target.value})} 
            />
          </div>
          <div className="space-y-2">
            <label className="text-[10px] font-black uppercase tracking-widest text-zinc-500">Platform Vector</label>
            <input 
              required 
              placeholder="e.g. ws.faceline.live" 
              className="w-full bg-zinc-950 border-2 border-red-900/30 focus:border-red-600 p-4 outline-none text-white font-bold transition-all" 
              value={formData.platform} 
              onChange={e => setFormData({...formData, platform: e.target.value})} 
            />
          </div>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
          <div className="space-y-2">
            <label className="text-[10px] font-black uppercase tracking-widest text-zinc-500">Current Status</label>
            <select 
              className="w-full bg-zinc-950 border-2 border-red-900/30 p-4 text-white outline-none focus:border-red-600 font-bold" 
              value={formData.status} 
              onChange={e => setFormData({...formData, status: e.target.value as StrikeStatus})}
            >
              {Object.values(StrikeStatus).map(s => <option key={s} value={s}>{s}</option>)}
            </select>
          </div>
          <div className="space-y-2">
            <label className="text-[10px] font-black uppercase tracking-widest text-zinc-500">Strike Type</label>
            <select 
              className="w-full bg-zinc-950 border-2 border-red-900/30 p-4 text-white outline-none focus:border-red-600 font-bold" 
              value={formData.type} 
              onChange={e => setFormData({...formData, type: e.target.value as any})}
            >
              <option value="LEGAL">LEGAL_ACTION</option>
              <option value="MEDIA">MEDIA_EXPOSURE</option>
              <option value="GOVERNMENT">GOV_DIRECTIVE</option>
            </select>
          </div>
          <div className="space-y-2">
            <label className="text-[10px] font-black uppercase tracking-widest text-zinc-500">Threat Level</label>
            <select 
              className="w-full bg-zinc-950 border-2 border-red-900/30 p-4 text-white outline-none focus:border-red-600 font-bold" 
              value={formData.priority} 
              onChange={e => setFormData({...formData, priority: e.target.value as Priority})}
            >
              {Object.values(Priority).map(p => <option key={p} value={p}>{p}</option>)}
            </select>
          </div>
        </div>

        <div className="space-y-2">
          <label className="text-[10px] font-black uppercase tracking-widest text-zinc-500">Mission Description</label>
          <textarea 
            required 
            placeholder="Detailed forensic description of the strike requirements..." 
            rows={4} 
            className="w-full bg-zinc-950 border-2 border-red-900/30 focus:border-red-600 p-4 text-white outline-none font-bold transition-all resize-none" 
            value={formData.description} 
            onChange={e => setFormData({...formData, description: e.target.value})} 
          />
        </div>

        <div className="flex gap-6 pt-4">
          <button 
            type="button" 
            onClick={onClose} 
            className="flex-1 border-2 border-zinc-800 p-5 font-black uppercase tracking-widest text-zinc-500 hover:text-white hover:border-white transition-all active:scale-95"
          >
            Abort
          </button>
          <button 
            type="submit" 
            className="flex-1 bg-red-600 p-5 font-black uppercase tracking-widest text-white shadow-[0_0_40px_rgba(255,0,0,0.4)] border-2 border-white/20 hover:bg-red-700 transition-all active:scale-95"
          >
            Execute_Deployment
          </button>
        </div>
      </form>
    </div>
  );
};