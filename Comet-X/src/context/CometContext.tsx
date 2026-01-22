/**
 * 🧠 COMET CONTEXT
 * Three-Lobe Architecture State Management
 * Connected to Python Backend (Port 8080)
 */

import React, { createContext, useContext, useState, useCallback, ReactNode } from 'react';
import { v4 as uuidv4 } from 'uuid';

// Backend API URL
const BRAIN_API = 'http://localhost:8080';

// Types
interface Tab {
  id: string;
  url: string;
  title: string;
  favicon?: string;
  isLoading: boolean;
}

type Lobe = 'sensory' | 'cognitive' | 'executive' | null;

interface CometContextType {
  // Tabs
  tabs: Tab[];
  activeTabId: string | null;
  setActiveTab: (id: string) => void;
  createTab: (url?: string) => void;
  closeTab: (id: string) => void;
  navigate: (url: string) => void;

  // AI State
  isProcessing: boolean;
  currentLobe: Lobe;
  executeCommand: (command: string) => Promise<string>;
}

const CometContext = createContext<CometContextType | null>(null);

// ═══════════════════════════════════════════════════════════════
// 🧠 THREE-LOBE ARCHITECTURE
// ═══════════════════════════════════════════════════════════════

/**
 * SENSORY LOBE - Input Filter & Security
 */
const sensoryLobe = {
  process: (input: string): { safe: boolean; sanitized: string; intent: string } => {
    // Security check
    const dangerousPatterns = [/<script/gi, /javascript:/gi, /eval\(/gi];
    const safe = !dangerousPatterns.some(p => p.test(input));

    // Intent detection
    let intent = 'unknown';
    if (input.startsWith('comet ') || input.startsWith('comet mission')) {
      intent = 'command';
    } else if (input.includes('?')) {
      intent = 'question';
    } else if (input.match(/^https?:\/\//)) {
      intent = 'navigate';
    } else {
      intent = 'search';
    }

    return {
      safe,
      sanitized: input.trim(),
      intent,
    };
  },
};

/**
 * COGNITIVE LOBE - AI Processing & Planning
 */
const cognitiveLobe = {
  process: async (input: string, intent: string): Promise<{ action: string; params: any }> => {
    // Parse commands
    if (intent === 'command') {
      const parts = input.replace(/^comet (mission )?/i, '').split(' ');
      const action = parts[0];
      const params = parts.slice(1).join(' ');

      switch (action) {
        case 'open':
        case 'goto':
          return { action: 'navigate', params: { url: params } };
        case 'search':
          return { action: 'search', params: { query: params } };
        case 'newtab':
          return { action: 'newtab', params: {} };
        case 'close':
          return { action: 'close', params: {} };
        case 'tabs':
          return { action: 'list-tabs', params: {} };
        case 'ask':
          return { action: 'ai-query', params: { question: params } };
        default:
          return { action: 'unknown', params: { raw: input } };
      }
    }

    if (intent === 'navigate') {
      return { action: 'navigate', params: { url: input } };
    }

    if (intent === 'search') {
      return { action: 'search', params: { query: input } };
    }

    return { action: 'ai-query', params: { question: input } };
  },
};

/**
 * EXECUTIVE LOBE - Action Execution
 */
const executiveLobe = {
  execute: async (
    action: string,
    params: any,
    context: {
      createTab: (url?: string) => void;
      closeTab: (id: string) => void;
      navigate: (url: string) => void;
      tabs: Tab[];
      activeTabId: string | null;
    }
  ): Promise<string> => {
    switch (action) {
      case 'navigate':
        const url = params.url.startsWith('http') ? params.url : `https://${params.url}`;
        context.navigate(url);
        return `✓ Navigating to: ${url}`;

      case 'search':
        const searchUrl = `https://www.google.com/search?q=${encodeURIComponent(params.query)}`;
        context.navigate(searchUrl);
        return `✓ Searching for: ${params.query}`;

      case 'newtab':
        context.createTab();
        return '✓ New tab created';

      case 'close':
        if (context.activeTabId) {
          context.closeTab(context.activeTabId);
          return '✓ Tab closed';
        }
        return '✗ No active tab to close';

      case 'list-tabs':
        const tabList = context.tabs
          .map((t, i) => `${i + 1}. ${t.title || 'New Tab'} - ${t.url || 'comet://newtab'}`)
          .join('\n');
        return `📑 Open Tabs:\n${tabList}`;

      case 'ai-query':
        // Connect to Brain API for AI queries
        try {
          const response = await fetch(`${BRAIN_API}/mission`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ command: params.question })
          });
          const data = await response.json();
          return `🧠 AI Response:\n${data.final_response || data.status}`;
        } catch (error) {
          return `🧠 AI Response (Offline Mode):\nBackend not available. Processing locally...\n\nQuestion: "${params.question}"`;
        }

      default:
        return `❓ Unknown command. Type 'help' for available commands.`;
    }
  },
};

// ═══════════════════════════════════════════════════════════════
// 🚀 PROVIDER COMPONENT
// ═══════════════════════════════════════════════════════════════

export const CometProvider: React.FC<{ children: ReactNode }> = ({ children }) => {
  // Tab State
  const [tabs, setTabs] = useState<Tab[]>([
    { id: uuidv4(), url: 'comet://newtab', title: 'New Tab', isLoading: false },
  ]);
  const [activeTabId, setActiveTabId] = useState<string | null>(tabs[0]?.id || null);

  // AI State
  const [isProcessing, setIsProcessing] = useState(false);
  const [currentLobe, setCurrentLobe] = useState<Lobe>(null);

  // Tab Actions
  const setActiveTab = useCallback((id: string) => {
    setActiveTabId(id);
  }, []);

  const createTab = useCallback((url?: string) => {
    const newTab: Tab = {
      id: uuidv4(),
      url: url || 'comet://newtab',
      title: url ? 'Loading...' : 'New Tab',
      isLoading: !!url,
    };
    setTabs(prev => [...prev, newTab]);
    setActiveTabId(newTab.id);
  }, []);

  const closeTab = useCallback((id: string) => {
    setTabs(prev => {
      const newTabs = prev.filter(t => t.id !== id);
      if (newTabs.length === 0) {
        // Always keep at least one tab
        const newTab: Tab = {
          id: uuidv4(),
          url: 'comet://newtab',
          title: 'New Tab',
          isLoading: false,
        };
        return [newTab];
      }
      return newTabs;
    });

    // Update active tab if needed
    if (activeTabId === id) {
      setTabs(prev => {
        const index = prev.findIndex(t => t.id === id);
        const newActiveId = prev[index - 1]?.id || prev[index + 1]?.id || prev[0]?.id;
        setActiveTabId(newActiveId);
        return prev;
      });
    }
  }, [activeTabId]);

  const navigate = useCallback((url: string) => {
    if (!activeTabId) {
      createTab(url);
      return;
    }

    setTabs(prev =>
      prev.map(t =>
        t.id === activeTabId
          ? { ...t, url, title: 'Loading...', isLoading: true }
          : t
      )
    );
  }, [activeTabId, createTab]);

  // Three-Lobe Command Execution
  const executeCommand = useCallback(async (command: string): Promise<string> => {
    setIsProcessing(true);

    try {
      // 1. SENSORY LOBE - Input processing
      setCurrentLobe('sensory');
      await new Promise(r => setTimeout(r, 200)); // Visual delay
      const sensoryResult = sensoryLobe.process(command);

      if (!sensoryResult.safe) {
        setCurrentLobe(null);
        setIsProcessing(false);
        return '🛡️ SECURITY: Potentially unsafe input blocked.';
      }

      // 2. COGNITIVE LOBE - Planning
      setCurrentLobe('cognitive');
      await new Promise(r => setTimeout(r, 300)); // Visual delay
      const cognitiveResult = await cognitiveLobe.process(
        sensoryResult.sanitized,
        sensoryResult.intent
      );

      // 3. EXECUTIVE LOBE - Execution
      setCurrentLobe('executive');
      await new Promise(r => setTimeout(r, 200)); // Visual delay
      const result = await executiveLobe.execute(cognitiveResult.action, cognitiveResult.params, {
        createTab,
        closeTab,
        navigate,
        tabs,
        activeTabId,
      });

      return result;
    } finally {
      setCurrentLobe(null);
      setIsProcessing(false);
    }
  }, [createTab, closeTab, navigate, tabs, activeTabId]);

  const value: CometContextType = {
    tabs,
    activeTabId,
    setActiveTab,
    createTab,
    closeTab,
    navigate,
    isProcessing,
    currentLobe,
    executeCommand,
  };

  return (
    <CometContext.Provider value={value}>
      {children}
    </CometContext.Provider>
  );
};

// Hook
export const useComet = (): CometContextType => {
  const context = useContext(CometContext);
  if (!context) {
    throw new Error('useComet must be used within CometProvider');
  }
  return context;
};

export default CometContext;
