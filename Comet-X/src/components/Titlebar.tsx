/**
 * 🎯 TITLEBAR COMPONENT
 * شريط العنوان السيادي
 */

import React from 'react';

const Titlebar: React.FC = () => {
  const handleMinimize = () => {
    window.electron?.minimize();
  };

  const handleMaximize = () => {
    window.electron?.maximize();
  };

  const handleClose = () => {
    window.electron?.close();
  };

  return (
    <div className="titlebar">
      {/* Logo */}
      <div className="titlebar-logo">
        <div className="orb"></div>
        <span>COMET-X</span>
        <span className="version">v1.0.0</span>
      </div>

      {/* Center - Drag Area */}
      <div className="titlebar-drag"></div>

      {/* Window Controls */}
      <div className="titlebar-controls">
        <button 
          className="titlebar-btn minimize" 
          onClick={handleMinimize}
          title="Minimize"
        />
        <button 
          className="titlebar-btn maximize" 
          onClick={handleMaximize}
          title="Maximize"
        />
        <button 
          className="titlebar-btn close" 
          onClick={handleClose}
          title="Close"
        />
      </div>
    </div>
  );
};

export default Titlebar;
