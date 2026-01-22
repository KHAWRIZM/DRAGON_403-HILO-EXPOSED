"""
☄️ COMET-X: EXECUTIVE LOBE
==========================
Browser Controller via Chrome DevTools Protocol (CDP)

This is where Comet-X takes REAL control:
- Open/Close tabs
- Navigate pages
- Execute JavaScript
- Capture screenshots
- Control the browser like a puppet master

Author: Sulaiman Alshammari (KHAWRIZM)
"""

import asyncio
import json
import subprocess
import sys
from typing import Optional, List, Dict, Any
from dataclasses import dataclass
import aiohttp

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
    """
    Executive Lobe - Controls Chrome via CDP
    """
    
    def __init__(self, config: Optional[CDPConfig] = None):
        self.config = config or CDPConfig()
        self.ws_url: Optional[str] = None
        self.session: Optional[aiohttp.ClientSession] = None
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
            await asyncio.sleep(2)  # Wait for Chrome to start
            return await self.connect()
        except Exception as e:
            print(f"🔴 [EXECUTIVE] Failed to launch Chrome: {e}")
            return False
    
    async def connect(self) -> bool:
        """Connect to existing Chrome instance"""
        try:
            self.session = aiohttp.ClientSession()
            url = f"http://localhost:{self.config.debug_port}/json/version"
            async with self.session.get(url) as resp:
                data = await resp.json()
                self.ws_url = data.get("webSocketDebuggerUrl")
                print(f"🟢 [EXECUTIVE] Connected to Chrome: {data.get('Browser')}")
                return True
        except Exception as e:
            print(f"🔴 [EXECUTIVE] Connection failed: {e}")
            return False
    
    async def get_tabs(self) -> List[Dict]:
        """Get all open tabs"""
        if not self.session:
            await self.connect()
        
        url = f"http://localhost:{self.config.debug_port}/json"
        async with self.session.get(url) as resp:
            tabs = await resp.json()
            self.tabs = {tab["id"]: tab for tab in tabs}
            return tabs
    
    async def new_tab(self, url: str = "about:blank") -> Dict:
        """Open a new tab"""
        endpoint = f"http://localhost:{self.config.debug_port}/json/new?{url}"
        async with self.session.put(endpoint) as resp:
            tab = await resp.json()
            print(f"🟢 [EXECUTIVE] New tab: {tab.get('id')}")
            return tab
    
    async def close_tab(self, tab_id: str) -> bool:
        """Close a specific tab"""
        endpoint = f"http://localhost:{self.config.debug_port}/json/close/{tab_id}"
        async with self.session.get(endpoint) as resp:
            result = await resp.text()
            print(f"🟢 [EXECUTIVE] Closed tab: {tab_id}")
            return result == "Target is closing"
    
    async def navigate(self, tab_id: str, url: str) -> bool:
        """Navigate a tab to a URL using WebSocket"""
        tabs = await self.get_tabs()
        tab = next((t for t in tabs if t["id"] == tab_id), None)
        
        if not tab:
            print(f"🔴 [EXECUTIVE] Tab not found: {tab_id}")
            return False
        
        ws_url = tab.get("webSocketDebuggerUrl")
        if not ws_url:
            print(f"🔴 [EXECUTIVE] No WebSocket URL for tab")
            return False
        
        async with self.session.ws_connect(ws_url) as ws:
            cmd = {
                "id": 1,
                "method": "Page.navigate",
                "params": {"url": url}
            }
            await ws.send_json(cmd)
            response = await ws.receive_json()
            print(f"🟢 [EXECUTIVE] Navigated to: {url}")
            return True
    
    async def execute_script(self, tab_id: str, script: str) -> Any:
        """Execute JavaScript in a tab"""
        tabs = await self.get_tabs()
        tab = next((t for t in tabs if t["id"] == tab_id), None)
        
        if not tab:
            return None
        
        ws_url = tab.get("webSocketDebuggerUrl")
        async with self.session.ws_connect(ws_url) as ws:
            cmd = {
                "id": 1,
                "method": "Runtime.evaluate",
                "params": {"expression": script}
            }
            await ws.send_json(cmd)
            response = await ws.receive_json()
            return response.get("result", {}).get("result", {}).get("value")
    
    async def screenshot(self, tab_id: str, path: str) -> bool:
        """Take a screenshot of a tab"""
        tabs = await self.get_tabs()
        tab = next((t for t in tabs if t["id"] == tab_id), None)
        
        if not tab:
            return False
        
        ws_url = tab.get("webSocketDebuggerUrl")
        async with self.session.ws_connect(ws_url) as ws:
            cmd = {"id": 1, "method": "Page.captureScreenshot"}
            await ws.send_json(cmd)
            response = await ws.receive_json()
            
            import base64
            data = response.get("result", {}).get("data")
            if data:
                with open(path, "wb") as f:
                    f.write(base64.b64decode(data))
                print(f"🟢 [EXECUTIVE] Screenshot saved: {path}")
                return True
        return False
    
    async def close(self):
        """Cleanup"""
        if self.session:
            await self.session.close()

# ═══════════════════════════════════════════════════════════════
#  FASTAPI SERVER FOR EXECUTIVE LOBE
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

class ScriptRequest(BaseModel):
    tab_id: str
    script: str

@app.on_event("startup")
async def startup():
    await chrome.connect()

@app.get("/")
async def root():
    return {"status": "ONLINE", "lobe": "Executive", "port": 8001}

@app.post("/launch")
async def launch():
    """Launch Chrome with debugging"""
    success = await chrome.launch_chrome()
    return {"success": success}

@app.get("/tabs")
async def get_tabs():
    """Get all tabs"""
    tabs = await chrome.get_tabs()
    return {"tabs": tabs}

@app.post("/tabs/new")
async def new_tab(url: str = "about:blank"):
    """Open new tab"""
    tab = await chrome.new_tab(url)
    return tab

@app.delete("/tabs/{tab_id}")
async def close_tab(tab_id: str):
    """Close a tab"""
    result = await chrome.close_tab(tab_id)
    return {"closed": result}

@app.post("/navigate")
async def navigate(req: NavigateRequest):
    """Navigate to URL"""
    result = await chrome.navigate(req.tab_id, req.url)
    return {"success": result}

@app.post("/execute")
async def execute(req: ScriptRequest):
    """Execute JavaScript"""
    result = await chrome.execute_script(req.tab_id, req.script)
    return {"result": result}

# ═══════════════════════════════════════════════════════════════
#  CLI MODE
# ═══════════════════════════════════════════════════════════════

async def cli_mode():
    """Interactive CLI for testing"""
    controller = ChromeController()
    
    print("""
    ╔═══════════════════════════════════════════════════════════╗
    ║  ☄️  COMET-X EXECUTIVE LOBE - CLI MODE                    ║
    ╠═══════════════════════════════════════════════════════════╣
    ║  Commands:                                               ║
    ║    launch  - Launch Chrome with debugging               ║
    ║    tabs    - List all tabs                              ║
    ║    new     - Open new tab                               ║
    ║    goto    - Navigate (goto <tab_id> <url>)             ║
    ║    close   - Close tab (close <tab_id>)                 ║
    ║    shot    - Screenshot (shot <tab_id>)                 ║
    ║    exit    - Quit                                       ║
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
                parts = cmd.split(" ", 1)
                url = parts[1] if len(parts) > 1 else "about:blank"
                await controller.new_tab(url)
            
            elif cmd.startswith("goto"):
                parts = cmd.split()
                if len(parts) >= 3:
                    await controller.navigate(parts[1], parts[2])
            
            elif cmd.startswith("close"):
                parts = cmd.split()
                if len(parts) >= 2:
                    await controller.close_tab(parts[1])
            
            elif cmd.startswith("shot"):
                parts = cmd.split()
                if len(parts) >= 2:
                    await controller.screenshot(parts[1], f"screenshot_{parts[1][:8]}.png")
            
            elif cmd == "exit":
                await controller.close()
                break
            
            else:
                print("Unknown command. Type 'help' for options.")
                
        except KeyboardInterrupt:
            break
        except Exception as e:
            print(f"Error: {e}")
    
    await controller.close()

if __name__ == "__main__":
    import sys
    
    if "--server" in sys.argv:
        import uvicorn
        print("""
    ╔═══════════════════════════════════════════════════════════╗
    ║  ☄️  COMET-X EXECUTIVE LOBE - SERVER MODE                 ║
    ║  Port: 8001                                              ║
    ║  "Control is not violence. Control is precision."        ║
    ╚═══════════════════════════════════════════════════════════╝
        """)
        uvicorn.run(app, host="0.0.0.0", port=8001)
    else:
        asyncio.run(cli_mode())
