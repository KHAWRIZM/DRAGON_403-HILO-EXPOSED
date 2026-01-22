/**
 * 🌐 BROWSER VIEW COMPONENT
 * عرض المتصفح والصفحة الجديدة
 */

import React from 'react';
import { useComet } from '../context/CometContext';

const QUICK_LINKS = [
  { name: 'GitHub', url: 'https://github.com', icon: '🐙' },
  { name: 'Google', url: 'https://google.com', icon: '🔍' },
  { name: 'YouTube', url: 'https://youtube.com', icon: '📺' },
  { name: 'Twitter/X', url: 'https://x.com', icon: '𝕏' },
  { name: 'Gmail', url: 'https://mail.google.com', icon: '📧' },
  { name: 'Azure', url: 'https://portal.azure.com', icon: '☁️' },
];

const BrowserView: React.FC = () => {
  const { tabs, activeTabId, navigate } = useComet();
  const activeTab = tabs.find(t => t.id === activeTabId);

  // New Tab Page
  if (!activeTab?.url || activeTab.url === 'comet://newtab') {
    return (
      <div className="browser-view">
        <div className="new-tab-page">
          {/* Neural Orb */}
          <div className="new-tab-logo">
            <div className="neural-orb"></div>
          </div>

          {/* Title */}
          <h1 className="new-tab-title">COMET-X</h1>
          <p className="new-tab-subtitle">
            Sovereign Browser • Three-Lobe AI • Riyadh Zero
          </p>

          {/* Search Box */}
          <div className="new-tab-search">
            <input
              type="text"
              placeholder="Search the web or enter URL..."
              onKeyPress={(e) => {
                if (e.key === 'Enter') {
                  const query = (e.target as HTMLInputElement).value;
                  if (query.includes('.') || query.startsWith('http')) {
                    navigate(query.startsWith('http') ? query : `https://${query}`);
                  } else {
                    navigate(`https://www.google.com/search?q=${encodeURIComponent(query)}`);
                  }
                }
              }}
            />
          </div>

          {/* Quick Links */}
          <div className="quick-links">
            {QUICK_LINKS.map((link) => (
              <a
                key={link.name}
                className="quick-link"
                onClick={() => navigate(link.url)}
              >
                <span className="quick-link-icon">{link.icon}</span>
                <span className="quick-link-name">{link.name}</span>
              </a>
            ))}
          </div>

          {/* Sovereign Quote */}
          <div className="new-tab-footer">
            <p className="sovereign-quote">
              "The Algorithm is our birthright." - Al-Khwarizmi
            </p>
            <p className="sovereign-house">
              House of Shammar • KHAWRIZM
            </p>
          </div>
        </div>
      </div>
    );
  }

  // WebView for actual pages
  return (
    <div className="browser-view">
      <webview
        className="browser-webview"
        src={activeTab.url}
        // @ts-ignore
        allowpopups="true"
        partition="persist:comet"
      />
    </div>
  );
};

export default BrowserView;
