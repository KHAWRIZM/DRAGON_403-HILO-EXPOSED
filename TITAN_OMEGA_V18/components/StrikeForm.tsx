
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
    type: 'LEGAL' as 'MEDIA' | 'LEGAL' | 'GOVERNMENT',
    priority: Priority.MEDIUM,
    caseId: cases[0]?.id || 'OMEGA-V18',
    timestamp: new Date().toISOString().replace('T', ' ').substring(0, 19)
  });

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onSubmit(formData);
    onClose();
  };

  return (
    <div className="fixed inset-0 z-[200] flex items-center justify-center p-4 bg-black/98 backdrop-blur-3xl overflow-y-auto">
      <form onSubmit={handleSubmit} className="bg-black border-4 border-red-600 w-full max-w-3xl my-auto overflow-hidden animate-in fade-in zoom-in duration-500 shadow-[0_0_120px_rgba(255,0,0,0.5)] relative">
        <div className="absolute top-0 left-0 w-full h-1 bg-red-600 animate-pulse"></div>
        <div className="absolute inset-0 bg-[radial-gradient(circle_at_top,rgba(255,0,0,0.05),transparent)] pointer-events-none"></div>
        
        <div className="p-12 border-b-2 border-red-900/30 bg-red-950/10 flex justify-between items-center relative">
          <div className="flex items-center gap-8">
            <div className="w-6 h-6 bg-red-600 rounded-full animate-ping"></div>
            <div>
              <h2 className="text-4xl font-black uppercase tracking-[0.4em] text-red-600 italic leading-none">STRIKE_REGISTRY_v18</h2>
              <p className="text-[10px] text-red-900 font-black uppercase tracking-[0.8em] mt-2">Manual_Intelligence_Entry</p>
            </div>
          </div>
          <button type="button" onClick={onClose} className="w-14 h-14 border-2 border-red-900/30 flex items-center justify-center text-zinc-600 hover:text-white hover:border-red-600 transition-all transform hover:rotate-90">
            <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="4" strokeLinecap="round" strokeLinejoin="round"><line x1="18" y1="6" x2="6" y2="18"></line><line x1="6" y1="6" x2="18" y2="18"></line></svg>
          </button>
        </div>
        
        <div className="p-12 space-y-12">
          <div className="grid grid-cols-1 md:grid-cols-2 gap-12">
            <div className="space-y-4">
              <label className="text-[12px] uppercase font-black text-red-900 block tracking-[0.3em] italic">Target_Entity</label>
              <input 
                required
                className="w-full bg-red-950/5 border-2 border-red-900/20 px-8 py-5 text-lg focus:border-red-600 outline-none text-white font-mono transition-all shadow-inner" 
                value={formData.entity}
                onChange={e => setFormData(prev => ({ ...prev, entity: e.target.value }))}
                placeholder="Subject Node / Violator"
              />
            </div>
            <div className="space-y-4">
              <label className="text-[12px] uppercase font-black text-red-900 block tracking-[0.3em] italic">Origin_Platform</label>
              <input 
                required
                className="w-full bg-red-950/5 border-2 border-red-900/20 px-8 py-5 text-lg focus:border-red-600 outline-none text-white font-mono transition-all shadow-inner" 
                value={formData.platform}
                onChange={e => setFormData(prev => ({ ...prev, platform: e.target.value }))}
                placeholder="IP, URL, or Cloud Context"
              />
            </div>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-3 gap-10">
            <div className="space-y-4">
              <label className="text-[11px] uppercase font-black text-red-900 block tracking-[0.3em] italic">Operational_Status</label>
              <select 
                className="w-full bg-zinc-950 border-2 border-red-900/20 px-8 py-5 text-sm font-mono focus:border-red-600 outline-none text-zinc-300"
                value={formData.status}
                onChange={e => setFormData(prev => ({ ...prev, status: e.target.value as StrikeStatus }))}
              >
                {Object.values(StrikeStatus).map(s => <option key={s} value={s}>{s}</option>)}
              </select>
            </div>
            <div className="space-y-4">
              <label className="text-[11px] uppercase font-black text-red-900 block tracking-[0.3em] italic">Action_Domain</label>
              <select 
                className="w-full bg-zinc-950 border-2 border-red-900/20 px-8 py-5 text-sm font-mono focus:border-red-600 outline-none text-zinc-300"
                value={formData.type}
                onChange={e => setFormData(prev => ({ ...prev, type: e.target.value as any }))}
              >
                <option value="LEGAL">LEGAL_RECLAMATION</option>
                <option value="MEDIA">PUBLIC_EXPOSURE</option>
                <option value="GOVERNMENT">INTEL_INTERVENTION</option>
              </select>
            </div>
            <div className="space-y-4">
              <label className="text-[11px] uppercase font-black text-red-900 block tracking-[0.3em] italic">Threat_Priority</label>
              <select 
                className="w-full bg-zinc-950 border-2 border-red-900/20 px-8 py-5 text-sm font-mono focus:border-red-600 outline-none text-zinc-300"
                value={formData.priority}
                onChange={e => setFormData(prev => ({ ...prev, priority: e.target.value as Priority }))}
              >
                {Object.values(Priority).map(p => <option key={p} value={p}>{p}</option>)}
              </select>
            </div>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-2 gap-12">
            <div className="space-y-4">
              <label className="text-[12px] uppercase font-black text-red-900 block tracking-[0.3em] italic">Deployment_Timestamp</label>
              <input 
                required
                className="w-full bg-red-950/5 border-2 border-red-900/20 px-8 py-5 text-base focus:border-red-600 outline-none text-zinc-400 font-mono transition-all" 
                value={formData.timestamp}
                onChange={e => setFormData(prev => ({ ...prev, timestamp: e.target.value }))}
                placeholder="YYYY-MM-DD HH:MM:SS"
              />
            </div>
            <div className="space-y-4">
               <label className="text-[12px] uppercase font-black text-red-900 block tracking-[0.3em] italic">Case_Identifier</label>
               <select 
                className="w-full bg-zinc-950 border-2 border-red-900/20 px-8 py-5 text-sm font-mono focus:border-red-600 outline-none text-zinc-300"
                value={formData.caseId}
                onChange={e => setFormData(prev => ({ ...prev, caseId: e.target.value }))}
              >
                {cases.map(c => <option key={c.id} value={c.id}>{c.title}</option>)}
              </select>
            </div>
          </div>

          <div className="space-y-4">
            <label className="text-[12px] uppercase font-black text-red-900 block tracking-[0.3em] italic">Detailed_Operational_Log</label>
            <textarea 
              required
              rows={5}
              className="w-full bg-red-950/5 border-2 border-red-900/20 px-8 py-8 text-lg focus:border-red-600 outline-none font-mono text-zinc-300 resize-none leading-relaxed shadow-inner" 
              value={formData.description}
              onChange={e => setFormData(prev => ({ ...prev, description: e.target.value }))}
              placeholder="Exfiltrate violation data here..."
            />
          </div>

          <div className="pt-8 flex gap-8">
            <button 
              type="submit" 
              className="flex-1 bg-red-600 hover:bg-red-700 text-white py-8 text-2xl font-black uppercase tracking-[0.8em] transition-all transform hover:scale-[1.02] shadow-[0_0_80px_rgba(255,0,0,0.6)] border-4 border-white/20 active:scale-95"
            >
              DEPLOY_STRIKE
            </button>
          </div>
        </div>
      </form>
    </div>
  );
};
