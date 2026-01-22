/**
 * 🚀 COMET-X SOVEREIGN BROWSER
 * Main Entry Point
 */

import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import './styles/global.css';
import './styles/components.css';

// 🐉 SOVEREIGN CONSOLE MESSAGE
console.log(`
╔═══════════════════════════════════════════════════════════════╗
║                                                               ║
║   🚀 COMET-X SOVEREIGN BROWSER                                ║
║   Version: 1.0.0 | Codename: Riyadh Zero                      ║
║                                                               ║
║   Three-Lobe Architecture: ACTIVE                             ║
║   • Sensory Lobe    ✓ READY                                   ║
║   • Cognitive Lobe  ✓ READY                                   ║
║   • Executive Lobe  ✓ READY                                   ║
║                                                               ║
║   "The Algorithm is our birthright." - Al-Khwarizmi           ║
║                                                               ║
║   House of Shammar • KHAWRIZM                                 ║
║                                                               ║
╚═══════════════════════════════════════════════════════════════╝
`);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
