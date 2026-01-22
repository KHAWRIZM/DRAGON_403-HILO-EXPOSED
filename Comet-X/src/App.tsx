/**
 * 🚀 COMET-X SOVEREIGN BROWSER
 * Main Application Component
 * 
 * @author KHAWRIZM - House of Shammar
 */

import React, { useState, useEffect } from 'react';
import BootScreen from './components/BootScreen';
import Titlebar from './components/Titlebar';
import Sidebar from './components/Sidebar';
import TabBar from './components/TabBar';
import BrowserView from './components/BrowserView';
import CommandBar from './components/CommandBar';
import { CometProvider } from './context/CometContext';
import './styles/global.css';

const App: React.FC = () => {
  const [isBooting, setIsBooting] = useState(true);
  const [bootComplete, setBootComplete] = useState(false);

  useEffect(() => {
    // Boot sequence duration
    const bootTimer = setTimeout(() => {
      setBootComplete(true);
      setTimeout(() => setIsBooting(false), 500);
    }, 3500);

    return () => clearTimeout(bootTimer);
  }, []);

  if (isBooting) {
    return <BootScreen complete={bootComplete} />;
  }

  return (
    <CometProvider>
      <div className="comet-app">
        {/* Custom Titlebar */}
        <Titlebar />

        <div className="comet-main">
          {/* AI Sidebar */}
          <Sidebar />

          <div className="comet-browser-area">
            {/* Tab Bar */}
            <TabBar />

            {/* Browser View */}
            <BrowserView />

            {/* Command Bar (comet mission...) */}
            <CommandBar />
          </div>
        </div>
      </div>
    </CometProvider>
  );
};

export default App;
