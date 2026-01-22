
import React, { useState, useEffect } from 'react';

export const NodeRadar: React.FC = () => {
  const [nodes, setNodes] = useState<Array<{ id: number, x: number, y: number, type: 'FRAUD' | 'SOVEREIGN', status: 'ACTIVE' | 'NEUTRALIZED' }>>([]);

  useEffect(() => {
    // Fix: Explicitly type initialNodes to match the state definition to prevent type widening of 'FRAUD' | 'SOVEREIGN' and 'ACTIVE' literals to 'string'.
    const initialNodes: Array<{ id: number, x: number, y: number, type: 'FRAUD' | 'SOVEREIGN', status: 'ACTIVE' | 'NEUTRALIZED' }> = Array.from({ length: 15 }, (_, i) => ({
      id: i,
      x: Math.random() * 100,
      y: Math.random() * 100,
      type: Math.random() > 0.7 ? 'SOVEREIGN' : 'FRAUD',
      status: 'ACTIVE'
    }));
    setNodes(initialNodes);

    const interval = setInterval(() => {
      setNodes(prev => prev.map(node => 
        (node.type === 'FRAUD' && Math.random() > 0.9) 
          ? { ...node, status: 'NEUTRALIZED' as const } 
          : node
      ));
    }, 3000);

    return () => clearInterval(interval);
  }, []);

  return (
    <div className="relative w-full h-64 bg-[#050000] border-2 border-red-900/30 overflow-hidden group">
      <div className="absolute inset-0 opacity-20 bg-[radial-gradient(circle_at_center,rgba(255,0,0,0.2),transparent)]"></div>
      <div className="absolute top-2 left-4 text-[9px] font-black text-red-600 uppercase tracking-[0.4em]">Global_Infra_Radar_v18</div>
      
      {/* Radar Sweeper */}
      <div className="absolute top-1/2 left-1/2 w-[150%] h-[2px] bg-red-600/20 -translate-x-1/2 -translate-y-1/2 animate-[spin_4s_linear_infinite] origin-center"></div>
      
      <div className="relative w-full h-full p-4">
        {nodes.map(node => (
          <div 
            key={node.id}
            className={`absolute w-2 h-2 rounded-full transition-all duration-1000 ${
              node.status === 'NEUTRALIZED' 
                ? 'bg-zinc-800 scale-50 opacity-20' 
                : node.type === 'SOVEREIGN' 
                  ? 'bg-cyan-500 shadow-[0_0_10px_cyan] animate-pulse' 
                  : 'bg-red-600 shadow-[0_0_10px_red]'
            }`}
            style={{ left: `${node.x}%`, top: `${node.y}%` }}
          >
            {node.status === 'ACTIVE' && node.type === 'FRAUD' && (
              <div className="absolute -inset-2 border border-red-600/30 rounded-full animate-ping"></div>
            )}
          </div>
        ))}
      </div>
      
      <div className="absolute bottom-2 right-4 flex gap-4 text-[8px] font-black uppercase tracking-widest">
        <div className="flex items-center gap-1"><div className="w-1.5 h-1.5 bg-red-600"></div> Fraud_Nodes</div>
        <div className="flex items-center gap-1"><div className="w-1.5 h-1.5 bg-cyan-500"></div> Sovereign_Nodes</div>
      </div>
    </div>
  );
};
