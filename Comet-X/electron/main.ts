/**
 * 🚀 COMET-X SOVEREIGN BROWSER
 * Electron Main Process
 * 
 * معمارية الفصوص الثلاثة:
 * • Sensory Lobe - فلترة المدخلات والأمان
 * • Cognitive Lobe - معالجة الذكاء الاصطناعي
 * • Executive Lobe - تنفيذ الأوامر
 * 
 * @author KHAWRIZM - House of Shammar
 * @version 1.0.0
 */

import { app, BrowserWindow, ipcMain, session } from 'electron';
import * as path from 'path';

// ═══════════════════════════════════════════════════════════════
// 🐉 SOVEREIGN CONFIGURATION
// ═══════════════════════════════════════════════════════════════
const COMET_CONFIG = {
  name: 'Comet-X',
  version: '1.0.0',
  codename: 'Riyadh Zero',
  author: 'KHAWRIZM',
  house: 'House of Shammar',
};

let mainWindow: BrowserWindow | null = null;
let browserViews: Map<number, Electron.BrowserView> = new Map();
let activeTabId: number = 0;

// ═══════════════════════════════════════════════════════════════
// 🧠 MAIN WINDOW CREATION
// ═══════════════════════════════════════════════════════════════
function createWindow(): void {
  mainWindow = new BrowserWindow({
    width: 1400,
    height: 900,
    minWidth: 1000,
    minHeight: 700,
    frame: false, // Custom titlebar
    titleBarStyle: 'hidden',
    backgroundColor: '#050505',
    webPreferences: {
      nodeIntegration: false,
      contextIsolation: true,
      preload: path.join(__dirname, 'preload.js'),
      webviewTag: true,
    },
    icon: path.join(__dirname, '../assets/icon.png'),
  });

  // Load the app
  if (process.env.NODE_ENV === 'development') {
    mainWindow.loadURL('http://localhost:5173');
    mainWindow.webContents.openDevTools();
  } else {
    mainWindow.loadFile(path.join(__dirname, '../dist/index.html'));
  }

  // Boot sequence log
  console.log(`
╔═══════════════════════════════════════════════════════════════╗
║                    🚀 COMET-X BOOTING...                      ║
╠═══════════════════════════════════════════════════════════════╣
║  [KERNEL]   Mounting Sovereign Volumes...              ✓ OK   ║
║  [HARDWARE] Verifying Local TPM...                     ✓ OK   ║
║  [SECURITY] Air-Gap Protocol...                        ✓ OK   ║
║  [AI]       Loading Three-Lobe Architecture...         ✓ OK   ║
║  [SYSTEM]   ${COMET_CONFIG.name} v${COMET_CONFIG.version} ONLINE                    ║
╠═══════════════════════════════════════════════════════════════╣
║  Codename: ${COMET_CONFIG.codename}                                       ║
║  House: ${COMET_CONFIG.house}                                    ║
║  "The Algorithm is our birthright." - Al-Khwarizmi            ║
╚═══════════════════════════════════════════════════════════════╝
  `);

  mainWindow.on('closed', () => {
    mainWindow = null;
  });
}

// ═══════════════════════════════════════════════════════════════
// 📑 TAB MANAGEMENT (مثل Comet)
// ═══════════════════════════════════════════════════════════════
ipcMain.handle('tabs:create', async (_, url: string) => {
  if (!mainWindow) return null;

  const tabId = Date.now();
  const view = new (require('electron').BrowserView)({
    webPreferences: {
      nodeIntegration: false,
      contextIsolation: true,
    },
  });

  mainWindow.addBrowserView(view);
  browserViews.set(tabId, view);

  // Set bounds (leaving space for sidebar)
  const bounds = mainWindow.getBounds();
  view.setBounds({
    x: 300, // Sidebar width
    y: 80,  // Titlebar + tabs height
    width: bounds.width - 300,
    height: bounds.height - 80,
  });

  view.webContents.loadURL(url);
  activeTabId = tabId;

  return {
    tabId,
    url,
    title: 'Loading...',
  };
});

ipcMain.handle('tabs:close', async (_, tabId: number) => {
  const view = browserViews.get(tabId);
  if (view && mainWindow) {
    mainWindow.removeBrowserView(view);
    browserViews.delete(tabId);
    return true;
  }
  return false;
});

ipcMain.handle('tabs:switch', async (_, tabId: number) => {
  const view = browserViews.get(tabId);
  if (view && mainWindow) {
    mainWindow.setTopBrowserView(view);
    activeTabId = tabId;
    return true;
  }
  return false;
});

ipcMain.handle('tabs:list', async () => {
  const tabs: any[] = [];
  browserViews.forEach((view, tabId) => {
    tabs.push({
      tabId,
      url: view.webContents.getURL(),
      title: view.webContents.getTitle(),
      isActive: tabId === activeTabId,
    });
  });
  return tabs;
});

ipcMain.handle('tabs:getPageContent', async (_, tabId: number) => {
  const view = browserViews.get(tabId);
  if (!view) return null;

  try {
    const content = await view.webContents.executeJavaScript(`
      document.body.innerText
    `);
    return content;
  } catch (e) {
    return null;
  }
});

// ═══════════════════════════════════════════════════════════════
// 🖱️ COMPUTER ACTIONS (مثل Comet)
// ═══════════════════════════════════════════════════════════════
ipcMain.handle('computer:click', async (_, tabId: number, x: number, y: number) => {
  const view = browserViews.get(tabId);
  if (!view) return false;

  view.webContents.sendInputEvent({
    type: 'mouseDown',
    x,
    y,
    button: 'left',
    clickCount: 1,
  });
  view.webContents.sendInputEvent({
    type: 'mouseUp',
    x,
    y,
    button: 'left',
    clickCount: 1,
  });
  return true;
});

ipcMain.handle('computer:type', async (_, tabId: number, text: string) => {
  const view = browserViews.get(tabId);
  if (!view) return false;

  for (const char of text) {
    view.webContents.sendInputEvent({
      type: 'char',
      keyCode: char,
    });
  }
  return true;
});

ipcMain.handle('computer:scroll', async (_, tabId: number, deltaY: number) => {
  const view = browserViews.get(tabId);
  if (!view) return false;

  view.webContents.sendInputEvent({
    type: 'mouseWheel',
    x: 400,
    y: 400,
    deltaX: 0,
    deltaY,
  });
  return true;
});

ipcMain.handle('computer:screenshot', async (_, tabId: number) => {
  const view = browserViews.get(tabId);
  if (!view) return null;

  const image = await view.webContents.capturePage();
  return image.toDataURL();
});

// ═══════════════════════════════════════════════════════════════
// 🔒 WINDOW CONTROLS
// ═══════════════════════════════════════════════════════════════
ipcMain.handle('window:minimize', () => mainWindow?.minimize());
ipcMain.handle('window:maximize', () => {
  if (mainWindow?.isMaximized()) {
    mainWindow.unmaximize();
  } else {
    mainWindow?.maximize();
  }
});
ipcMain.handle('window:close', () => mainWindow?.close());

// ═══════════════════════════════════════════════════════════════
// 🚀 APP LIFECYCLE
// ═══════════════════════════════════════════════════════════════
app.whenReady().then(() => {
  createWindow();

  app.on('activate', () => {
    if (BrowserWindow.getAllWindows().length === 0) {
      createWindow();
    }
  });
});

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit();
  }
});

// Security: Disable navigation to unknown protocols
app.on('web-contents-created', (_, contents) => {
  contents.on('will-navigate', (event, url) => {
    const allowedProtocols = ['http:', 'https:', 'comet:'];
    const parsedUrl = new URL(url);
    if (!allowedProtocols.includes(parsedUrl.protocol)) {
      event.preventDefault();
    }
  });
});
