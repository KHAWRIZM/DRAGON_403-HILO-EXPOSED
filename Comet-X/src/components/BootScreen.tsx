/**
 * 🚀 BOOT SCREEN COMPONENT
 * شاشة الإقلاع السيادية
 */

import React, { useState, useEffect } from 'react';
import './BootScreen.css';

interface BootScreenProps {
  complete: boolean;
}

const BOOT_LOGS = [
  { text: '[KERNEL]   Mounting Sovereign Volumes...', delay: 300 },
  { text: '[HARDWARE] Verifying Local TPM...', delay: 400 },
  { text: '[SECURITY] Initializing Air-Gap Protocol...', delay: 500 },
  { text: '[NETWORK]  Establishing Secure Tunnel...', delay: 400 },
  { text: '[AI]       Loading Three-Lobe Architecture...', delay: 600 },
  { text: '[SENSORY]  ► Sensory Lobe... ACTIVE', delay: 300 },
  { text: '[COGNITIVE]► Cognitive Lobe... ACTIVE', delay: 300 },
  { text: '[EXECUTIVE]► Executive Lobe... ACTIVE', delay: 300 },
  { text: '[SYSTEM]   COMET-X v1.0.0 ONLINE', delay: 500 },
];

const BootScreen: React.FC<BootScreenProps> = ({ complete }) => {
  const [logs, setLogs] = useState<string[]>([]);
  const [progress, setProgress] = useState(0);

  useEffect(() => {
    let currentIndex = 0;
    let totalDelay = 0;

    BOOT_LOGS.forEach((log, index) => {
      totalDelay += log.delay;
      setTimeout(() => {
        setLogs(prev => [...prev, log.text]);
        setProgress(((index + 1) / BOOT_LOGS.length) * 100);
      }, totalDelay);
    });
  }, []);

  return (
    <div className={`boot-screen ${complete ? 'fade-out' : ''}`}>
      {/* Neural Orb */}
      <div className="boot-orb">
        <div className="orb-inner"></div>
        <div className="orb-ring"></div>
        <div className="orb-ring delay-1"></div>
        <div className="orb-ring delay-2"></div>
      </div>

      {/* Logo */}
      <div className="boot-logo">
        <span className="logo-icon">🚀</span>
        <span className="logo-text">COMET-X</span>
      </div>

      {/* Subtitle */}
      <p className="boot-subtitle">Sovereign Browser • Riyadh Zero</p>

      {/* Boot Logs */}
      <div className="boot-logs">
        {logs.map((log, index) => (
          <div 
            key={index} 
            className={`boot-log ${log.includes('ONLINE') ? 'success' : ''} ${log.includes('ACTIVE') ? 'active' : ''}`}
          >
            {log}
            {index === logs.length - 1 && !log.includes('ONLINE') && (
              <span className="log-status">✓ OK</span>
            )}
          </div>
        ))}
      </div>

      {/* Progress Bar */}
      <div className="boot-progress">
        <div className="progress-track">
          <div 
            className="progress-fill" 
            style={{ width: `${progress}%` }}
          ></div>
        </div>
        <span className="progress-text">{Math.round(progress)}%</span>
      </div>

      {/* Footer */}
      <div className="boot-footer">
        <p className="boot-quote">"The Algorithm is our birthright." - Al-Khwarizmi</p>
        <p className="boot-house">House of Shammar • KHAWRIZM</p>
      </div>
    </div>
  );
};

export default BootScreen;
