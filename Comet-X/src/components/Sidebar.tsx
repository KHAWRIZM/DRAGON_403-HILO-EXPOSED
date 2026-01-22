/**
 * 🤖 SIDEBAR COMPONENT
 * AI Assistant Panel - Three-Lobe Architecture
 */

import React, { useState } from 'react';
import { useComet } from '../context/CometContext';

interface Message {
  id: string;
  role: 'user' | 'ai' | 'system';
  content: string;
  timestamp: Date;
  lobe?: 'sensory' | 'cognitive' | 'executive';
}

const Sidebar: React.FC = () => {
  const { isProcessing, currentLobe, executeCommand } = useComet();
  const [messages, setMessages] = useState<Message[]>([
    {
      id: '1',
      role: 'system',
      content: '🐉 COMET-X AI Assistant initialized.\nThree-Lobe Architecture: ACTIVE\n\nType a command or ask me anything.',
      timestamp: new Date(),
    }
  ]);
  const [input, setInput] = useState('');
  const [isCollapsed, setIsCollapsed] = useState(false);

  const handleSend = async () => {
    if (!input.trim()) return;

    const userMessage: Message = {
      id: Date.now().toString(),
      role: 'user',
      content: input,
      timestamp: new Date(),
    };

    setMessages(prev => [...prev, userMessage]);
    setInput('');

    // Process through Three-Lobe Architecture
    try {
      const response = await executeCommand(input);
      
      const aiMessage: Message = {
        id: (Date.now() + 1).toString(),
        role: 'ai',
        content: response,
        timestamp: new Date(),
        lobe: currentLobe,
      };

      setMessages(prev => [...prev, aiMessage]);
    } catch (error) {
      const errorMessage: Message = {
        id: (Date.now() + 1).toString(),
        role: 'system',
        content: `❌ Error: ${error}`,
        timestamp: new Date(),
      };
      setMessages(prev => [...prev, errorMessage]);
    }
  };

  const handleKeyPress = (e: React.KeyboardEvent) => {
    if (e.key === 'Enter' && !e.shiftKey) {
      e.preventDefault();
      handleSend();
    }
  };

  if (isCollapsed) {
    return (
      <div className="sidebar collapsed">
        <button 
          className="sidebar-toggle"
          onClick={() => setIsCollapsed(false)}
          title="Expand Sidebar"
        >
          🤖
        </button>
      </div>
    );
  }

  return (
    <div className="sidebar">
      {/* Header */}
      <div className="sidebar-header">
        <div className="ai-avatar">🐉</div>
        <div className="ai-info">
          <h3>COMET-X AI</h3>
          <p>Sovereign Assistant</p>
        </div>
        <div className="ai-status">
          <span className="status-dot"></span>
          <span>{isProcessing ? 'THINKING' : 'ONLINE'}</span>
        </div>
        <button 
          className="sidebar-toggle"
          onClick={() => setIsCollapsed(true)}
          title="Collapse Sidebar"
        >
          ◀
        </button>
      </div>

      {/* Three-Lobe Indicators */}
      <div className="lobe-indicators">
        <div className={`lobe-indicator sensory ${currentLobe === 'sensory' ? 'active' : ''}`}>
          <span className="lobe-icon">👁️</span>
          <span className="lobe-name">Sensory</span>
          <span className="lobe-status">{currentLobe === 'sensory' ? 'ACTIVE' : 'READY'}</span>
        </div>
        <div className={`lobe-indicator cognitive ${currentLobe === 'cognitive' ? 'active' : ''}`}>
          <span className="lobe-icon">🧠</span>
          <span className="lobe-name">Cognitive</span>
          <span className="lobe-status">{currentLobe === 'cognitive' ? 'ACTIVE' : 'READY'}</span>
        </div>
        <div className={`lobe-indicator executive ${currentLobe === 'executive' ? 'active' : ''}`}>
          <span className="lobe-icon">⚡</span>
          <span className="lobe-name">Executive</span>
          <span className="lobe-status">{currentLobe === 'executive' ? 'ACTIVE' : 'READY'}</span>
        </div>
      </div>

      {/* Chat Messages */}
      <div className="sidebar-chat">
        {messages.map((msg) => (
          <div key={msg.id} className={`message ${msg.role}`}>
            <div className="message-avatar">
              {msg.role === 'user' ? '👤' : msg.role === 'ai' ? '🐉' : '⚙️'}
            </div>
            <div className="message-content">
              <pre>{msg.content}</pre>
              {msg.lobe && (
                <span className="message-lobe">via {msg.lobe} lobe</span>
              )}
            </div>
          </div>
        ))}
        
        {isProcessing && (
          <div className="message ai processing">
            <div className="message-avatar">🐉</div>
            <div className="message-content">
              <span className="thinking-indicator">
                <span className="dot"></span>
                <span className="dot"></span>
                <span className="dot"></span>
              </span>
              Processing through {currentLobe} lobe...
            </div>
          </div>
        )}
      </div>

      {/* Input Area */}
      <div className="sidebar-input">
        <div className="sidebar-input-wrapper">
          <input
            type="text"
            placeholder="Ask anything... (comet mission [command])"
            value={input}
            onChange={(e) => setInput(e.target.value)}
            onKeyPress={handleKeyPress}
            disabled={isProcessing}
          />
          <button 
            className="sidebar-send-btn"
            onClick={handleSend}
            disabled={isProcessing || !input.trim()}
          >
            ▶
          </button>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;
