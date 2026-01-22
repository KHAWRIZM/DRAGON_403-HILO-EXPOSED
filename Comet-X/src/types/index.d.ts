/**
 * 🐉 COMET-X TYPE DECLARATIONS
 */

// Electron API exposed through preload
declare global {
  interface Window {
    electron?: {
      minimize: () => void;
      maximize: () => void;
      close: () => void;
    };
    cometAPI?: {
      tabs: {
        create: (url: string) => Promise<number>;
        close: (tabId: number) => Promise<void>;
        switch: (tabId: number) => Promise<void>;
        list: () => Promise<TabInfo[]>;
        getPageContent: (tabId: number) => Promise<string>;
      };
      computer: {
        click: (tabId: number, x: number, y: number) => Promise<void>;
        type: (tabId: number, text: string) => Promise<void>;
        scroll: (tabId: number, deltaY: number) => Promise<void>;
        screenshot: (tabId: number) => Promise<string>;
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

interface TabInfo {
  id: number;
  url: string;
  title: string;
  favicon: string;
  isLoading: boolean;
}

interface ThreeLobePlan {
  sensory: {
    safe: boolean;
    sanitized: string;
    intent: string;
  };
  cognitive: {
    action: string;
    params: Record<string, any>;
  };
  executive: {
    result: string;
    success: boolean;
  };
}

export {};
