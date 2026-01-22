/**
 * 🔗 COMET-X PRELOAD SCRIPT
 * Bridge between Renderer and Main Process
 */

import { contextBridge, ipcRenderer } from 'electron';

// ═══════════════════════════════════════════════════════════════
// 🐉 EXPOSE COMET API TO RENDERER
// ═══════════════════════════════════════════════════════════════
contextBridge.exposeInMainWorld('cometAPI', {
  // Tab Management
  tabs: {
    create: (url: string) => ipcRenderer.invoke('tabs:create', url),
    close: (tabId: number) => ipcRenderer.invoke('tabs:close', tabId),
    switch: (tabId: number) => ipcRenderer.invoke('tabs:switch', tabId),
    list: () => ipcRenderer.invoke('tabs:list'),
    getPageContent: (tabId: number) => ipcRenderer.invoke('tabs:getPageContent', tabId),
  },

  // Computer Actions (مثل Comet)
  computer: {
    click: (tabId: number, x: number, y: number) => 
      ipcRenderer.invoke('computer:click', tabId, x, y),
    type: (tabId: number, text: string) => 
      ipcRenderer.invoke('computer:type', tabId, text),
    scroll: (tabId: number, deltaY: number) => 
      ipcRenderer.invoke('computer:scroll', tabId, deltaY),
    screenshot: (tabId: number) => 
      ipcRenderer.invoke('computer:screenshot', tabId),
  },

  // Window Controls
  window: {
    minimize: () => ipcRenderer.invoke('window:minimize'),
    maximize: () => ipcRenderer.invoke('window:maximize'),
    close: () => ipcRenderer.invoke('window:close'),
  },

  // System Info
  system: {
    platform: process.platform,
    version: '1.0.0',
    codename: 'Riyadh Zero',
  },
});

// Type declarations for TypeScript
declare global {
  interface Window {
    cometAPI: {
      tabs: {
        create: (url: string) => Promise<{ tabId: number; url: string; title: string }>;
        close: (tabId: number) => Promise<boolean>;
        switch: (tabId: number) => Promise<boolean>;
        list: () => Promise<Array<{ tabId: number; url: string; title: string; isActive: boolean }>>;
        getPageContent: (tabId: number) => Promise<string | null>;
      };
      computer: {
        click: (tabId: number, x: number, y: number) => Promise<boolean>;
        type: (tabId: number, text: string) => Promise<boolean>;
        scroll: (tabId: number, deltaY: number) => Promise<boolean>;
        screenshot: (tabId: number) => Promise<string | null>;
      };
      window: {
        minimize: () => Promise<void>;
        maximize: () => Promise<void>;
        close: () => Promise<void>;
      };
      system: {
        platform: string;
        version: string;
        codename: string;
      };
    };
  }
}
