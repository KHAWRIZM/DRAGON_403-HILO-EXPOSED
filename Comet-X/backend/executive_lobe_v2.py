"""
☄️ COMET-X: EXECUTIVE LOBE (Simplified)
=======================================
Browser Controller via Chrome DevTools Protocol (CDP)
Using httpx instead of aiohttp for Python 3.12 compatibility

Author: Sulaiman Alshammari (KHAWRIZM)
"""

import asyncio
import json
import subprocess
import sys
import base64
from typing import Optional, List, Dict, Any
from dataclasses import dataclass
import httpx
import websockets

# ═══════════════════════════════════════════════════════════════
#  CDP CONNECTION
# ═══════════════════════════════════════════════════════════════

@dataclass
class CDPConfig:
    """Chrome DevTools Protocol Configuration"""
    chrome_path: str = r"C:\Program Files\Google\Chrome\Application\chrome.exe"
    debug_port: int = 9222
    user_data_dir: str = r"C:\Users\admin\Desktop\HILO_CASE\Comet-X\chrome_profile"

class ChromeController:
    """Executive Lobe - Controls Chrome via CDP"""
    
    def __init__(self, config: Optional[CDPConfig] = None):
        self.config = config or CDPConfig()
        self.ws_url: Optional[str] = None
        self.tabs: Dict[str, Any] = {}
        
    async def launch_chrome(self) -> bool:
        """Launch Chrome with remote debugging enabled"""
        cmd = [
            self.config.chrome_path,
            f"--remote-debugging-port={self.config.debug_port}",
            f"--user-data-dir={self.config.user_data_dir}",
            "--no-first-run",
            "--no-default-browser-check",
            "--start-maximized"
        ]
        
        try:
            print(f"🚀 [EXECUTIVE] Launching Chrome on port {self.config.debug_port}...")
            subprocess.Popen(cmd, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
            await asyncio.sleep(2)
            return await self.connect()
        except Exception as e:
            print(f"🔴 [EXECUTIVE] Failed to launch Chrome: {e}")
            return False
    
    async def connect(self) -> bool:
        """Connect to existing Chrome instance"""
        try:
            async with httpx.AsyncClient() as client:
                url = f"http://localhost:{self.config.debug_port}/json/version"
                resp = await client.get(url)
                data = resp.json()
                self.ws_url = data.get("webSocketDebuggerUrl")
                print(f"🟢 [EXECUTIVE] Connected to Chrome: {data.get('Browser')}")
                return True
        except Exception as e:
            print(f"🔴 [EXECUTIVE] Connection failed: {e}")
            return False
    
    async def get_tabs(self) -> List[Dict]:
        """Get all open tabs"""
        try:
            async with httpx.AsyncClient() as client:
                url = f"http://localhost:{self.config.debug_port}/json"
                resp = await client.get(url)
                tabs = resp.json()
                self.tabs = {tab["id"]: tab for tab in tabs}
                return tabs
        except Exception as e:
            print(f"🔴 [EXECUTIVE] Get tabs failed: {e}")
            return []
    
    async def new_tab(self, url: str = "about:blank") -> Dict:
        """Open a new tab"""
        try:
            async with httpx.AsyncClient() as client:
                endpoint = f"http://localhost:{self.config.debug_port}/json/new?{url}"
                resp = await client.put(endpoint)
                tab = resp.json()
                print(f"🟢 [EXECUTIVE] New tab: {tab.get('id', 'unknown')[:8]}...")
                return tab
        except Exception as e:
            print(f"🔴 [EXECUTIVE] New tab failed: {e}")
            return {}
    
    async def close_tab(self, tab_id: str) -> bool:
        """Close a specific tab"""
        try:
            async with httpx.AsyncClient() as client:
                endpoint = f"http://localhost:{self.config.debug_port}/json/close/{tab_id}"
                resp = await client.get(endpoint)
                print(f"🟢 [EXECUTIVE] Closed tab: {tab_id[:8]}...")
                return True
        except Exception as e:
            print(f"🔴 [EXECUTIVE] Close tab failed: {e}")
            return False
    
    async def navigate(self, tab_id: str, url: str) -> bool:
        """Navigate a tab to a URL"""
        tabs = await self.get_tabs()
        tab = next((t for t in tabs if t["id"] == tab_id), None)
        
        if not tab:
            print(f"🔴 [EXECUTIVE] Tab not found: {tab_id}")
            return False
        
        ws_url = tab.get("webSocketDebuggerUrl")
        if not ws_url:
            print(f"🔴 [EXECUTIVE] No WebSocket URL for tab")
            return False
        
        try:
            async with websockets.connect(ws_url) as ws:
                cmd = json.dumps({
                    "id": 1,
                    "method": "Page.navigate",
                    "params": {"url": url}
                })
                await ws.send(cmd)
                response = await ws.recv()
                print(f"🟢 [EXECUTIVE] Navigated to: {url}")
                return True
        except Exception as e:
            print(f"🔴 [EXECUTIVE] Navigate failed: {e}")
            return False

# ═══════════════════════════════════════════════════════════════
#  FASTAPI SERVER
# ═══════════════════════════════════════════════════════════════

from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel

app = FastAPI(title="☄️ Comet-X Executive Lobe")

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
)

chrome = ChromeController()

class NavigateRequest(BaseModel):
    tab_id: str
    url: str

@app.on_event("startup")
async def startup():
    await chrome.connect()

@app.get("/")
async def root():
    return {"status": "ONLINE", "lobe": "Executive", "port": 8001}

@app.post("/launch")
async def launch():
    success = await chrome.launch_chrome()
    return {"success": success}

@app.get("/tabs")
async def get_tabs():
    tabs = await chrome.get_tabs()
    return {"tabs": tabs}

@app.post("/tabs/new")
async def new_tab(url: str = "about:blank"):
    tab = await chrome.new_tab(url)
    return tab

@app.delete("/tabs/{tab_id}")
async def close_tab(tab_id: str):
    result = await chrome.close_tab(tab_id)
    return {"closed": result}

@app.post("/navigate")
async def navigate(req: NavigateRequest):
    result = await chrome.navigate(req.tab_id, req.url)
    return {"success": result}

# ═══════════════════════════════════════════════════════════════
#  STARTUP
# ═══════════════════════════════════════════════════════════════

if __name__ == "__main__":
    import uvicorn
    
    if "--server" in sys.argv:
        print("""
    ╔═══════════════════════════════════════════════════════════╗
    ║  ☄️  COMET-X EXECUTIVE LOBE - SERVER MODE                 ║
    ║  Port: 8001                                              ║
    ║  "Control is not violence. Control is precision."        ║
    ╚═══════════════════════════════════════════════════════════╝
        """)
        uvicorn.run(app, host="0.0.0.0", port=8001)
    else:
        # CLI Mode
        async def cli():
            controller = ChromeController()
            print("""
    ╔═══════════════════════════════════════════════════════════╗
    ║  ☄️  COMET-X EXECUTIVE LOBE - CLI MODE                    ║
    ║  Commands: launch, tabs, new, close <id>, goto <id> <url>║
    ╚═══════════════════════════════════════════════════════════╝
            """)
            
            while True:
                try:
                    cmd = input("\n🐉 EXECUTIVE > ").strip().lower()
                    
                    if cmd == "launch":
                        await controller.launch_chrome()
                    elif cmd == "tabs":
                        tabs = await controller.get_tabs()
                        for i, tab in enumerate(tabs):
                            print(f"  [{i}] {tab['id'][:8]}... | {tab.get('title', 'Untitled')[:40]}")
                    elif cmd.startswith("new"):
                        url = cmd.split(" ", 1)[1] if " " in cmd else "about:blank"
                        await controller.new_tab(url)
                    elif cmd.startswith("close"):
                        tab_id = cmd.split()[1]
                        await controller.close_tab(tab_id)
                    elif cmd.startswith("goto"):
                        parts = cmd.split()
                        if len(parts) >= 3:
                            await controller.navigate(parts[1], parts[2])
                    elif cmd == "exit":
                        break
                except KeyboardInterrupt:
                    break
                except Exception as e:
                    print(f"Error: {e}")
        
        asyncio.run(cli())
