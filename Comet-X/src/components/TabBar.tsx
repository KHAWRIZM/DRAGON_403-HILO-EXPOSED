/**
 * 📑 TABBAR COMPONENT
 * إدارة التبويبات
 */

import React from 'react';
import { useComet } from '../context/CometContext';

const TabBar: React.FC = () => {
  const { tabs, activeTabId, setActiveTab, createTab, closeTab } = useComet();

  return (
    <div className="tabbar">
      {/* Tabs */}
      {tabs.map((tab) => (
        <div
          key={tab.id}
          className={`tab ${tab.id === activeTabId ? 'active' : ''}`}
          onClick={() => setActiveTab(tab.id)}
        >
          <img 
            src={tab.favicon || '🌐'} 
            alt="" 
            className="tab-favicon"
            onError={(e) => {
              (e.target as HTMLImageElement).style.display = 'none';
            }}
          />
          <span className="tab-title">{tab.title || 'New Tab'}</span>
          <button
            className="tab-close"
            onClick={(e) => {
              e.stopPropagation();
              closeTab(tab.id);
            }}
          >
            ×
          </button>
        </div>
      ))}

      {/* New Tab Button */}
      <button className="tab-new" onClick={() => createTab()}>
        +
      </button>

      {/* Tab Actions */}
      <div className="tabbar-actions">
        <button className="tabbar-btn" title="Tab Overview">
          ▤
        </button>
      </div>
    </div>
  );
};

export default TabBar;
