"""
☄️ COMET-X: UNIFIED BRAIN
=========================
Orchestrates all Three Lobes into one coherent system

Flow:
USER INPUT → SENSORY (filter) → COGNITIVE (think) → EXECUTIVE (act)

Author: Sulaiman Alshammari (KHAWRIZM)
"""

import uvicorn
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
from typing import Optional
import httpx

# ═══════════════════════════════════════════════════════════════
#  CONFIGURATION
# ═══════════════════════════════════════════════════════════════

SENSORY_URL = "http://localhost:8000"
COGNITIVE_URL = "http://localhost:8002"
EXECUTIVE_URL = "http://localhost:8001"

app = FastAPI(
    title="☄️ Comet-X Brain",
    description="Unified Three-Lobe Orchestrator"
)

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
)

# ═══════════════════════════════════════════════════════════════
#  DATA MODELS
# ═══════════════════════════════════════════════════════════════

class MissionRequest(BaseModel):
    command: str
    context: Optional[str] = None

class MissionResponse(BaseModel):
    status: str
    stages: dict
    final_response: str

# ═══════════════════════════════════════════════════════════════
#  ORCHESTRATION
# ═══════════════════════════════════════════════════════════════

async def call_lobe(url: str, endpoint: str, data: dict) -> dict:
    """Call a lobe's endpoint"""
    try:
        async with httpx.AsyncClient(timeout=30.0) as client:
            response = await client.post(f"{url}{endpoint}", json=data)
            return response.json()
    except Exception as e:
        return {"error": str(e)}

@app.get("/")
async def root():
    """Health check for all lobes"""
    status = {"brain": "ONLINE", "lobes": {}}
    
    async with httpx.AsyncClient(timeout=5.0) as client:
        for name, url in [("sensory", SENSORY_URL), ("cognitive", COGNITIVE_URL), ("executive", EXECUTIVE_URL)]:
            try:
                resp = await client.get(f"{url}/")
                status["lobes"][name] = "ONLINE" if resp.status_code == 200 else "ERROR"
            except:
                status["lobes"][name] = "OFFLINE"
    
    return status

@app.post("/mission", response_model=MissionResponse)
async def execute_mission(request: MissionRequest):
    """
    Execute a full mission through all three lobes
    
    1. SENSORY: Filter and sanitize input
    2. COGNITIVE: Understand and parse command  
    3. EXECUTIVE: Execute the action
    """
    stages = {}
    
    # ═══════════════════════════════════════════════════════════
    # STAGE 1: SENSORY LOBE - Filter Input
    # ═══════════════════════════════════════════════════════════
    print(f"\n{'='*60}")
    print(f"🎯 MISSION: {request.command}")
    print(f"{'='*60}")
    
    print("\n🔵 STAGE 1: SENSORY LOBE")
    sensory_result = await call_lobe(SENSORY_URL, "/mission/scan", {
        "command": request.command,
        "context": request.context
    })
    stages["sensory"] = sensory_result
    
    if sensory_result.get("status") == "DENIED":
        print("🔴 MISSION ABORTED: Privacy violation detected")
        return MissionResponse(
            status="DENIED",
            stages=stages,
            final_response="🛡️ Command blocked by Sensory Lobe - Privacy protection active"
        )
    
    # Use filtered payload
    clean_command = sensory_result.get("payload", request.command)
    print(f"   ✓ Status: {sensory_result.get('status')}")
    
    # ═══════════════════════════════════════════════════════════
    # STAGE 2: COGNITIVE LOBE - Understand Command
    # ═══════════════════════════════════════════════════════════
    print("\n🔵 STAGE 2: COGNITIVE LOBE")
    cognitive_result = await call_lobe(COGNITIVE_URL, "/parse", {
        "user_input": clean_command
    })
    stages["cognitive"] = cognitive_result
    
    intent = cognitive_result.get("intent", "unknown")
    params = cognitive_result.get("parameters", {})
    print(f"   ✓ Intent: {intent}")
    print(f"   ✓ Confidence: {cognitive_result.get('confidence', 0)}")
    
    # ═══════════════════════════════════════════════════════════
    # STAGE 3: EXECUTIVE LOBE - Execute Action
    # ═══════════════════════════════════════════════════════════
    print("\n🔵 STAGE 3: EXECUTIVE LOBE")
    
    executive_result = {"action": "none", "status": "SKIPPED"}
    final_response = ""
    
    if intent == "navigate" or intent == "search":
        query = params.get("query", clean_command)
        if intent == "search":
            url = f"https://www.google.com/search?q={query}"
        else:
            url = query if query.startswith("http") else f"https://{query}"
        
        # Get tabs and navigate
        tabs_result = await call_lobe(EXECUTIVE_URL, "/tabs", {})
        if tabs_result.get("tabs"):
            tab_id = tabs_result["tabs"][0]["id"]
            nav_result = await call_lobe(EXECUTIVE_URL, "/navigate", {
                "tab_id": tab_id,
                "url": url
            })
            executive_result = {"action": "navigate", "url": url, "result": nav_result}
            final_response = f"🌐 Navigating to: {url}"
        else:
            final_response = f"⚠️ No tabs available. Launch Chrome first."
    
    elif intent == "newtab":
        new_tab = await call_lobe(EXECUTIVE_URL, "/tabs/new", {})
        executive_result = {"action": "newtab", "result": new_tab}
        final_response = f"📑 New tab opened"
    
    elif intent == "ask":
        # Use Cognitive Lobe to answer
        think_result = await call_lobe(COGNITIVE_URL, "/think", {
            "prompt": clean_command,
            "context": request.context
        })
        stages["think"] = think_result
        executive_result = {"action": "answer", "status": "COMPLETED"}
        final_response = think_result.get("response", "I couldn't process that question.")
    
    else:
        final_response = f"🤔 I understood: {intent}. But I'm not sure what to do with: {clean_command}"
    
    stages["executive"] = executive_result
    print(f"   ✓ Action: {executive_result.get('action')}")
    
    print(f"\n{'='*60}")
    print(f"✅ MISSION COMPLETE")
    print(f"{'='*60}\n")
    
    return MissionResponse(
        status="SUCCESS",
        stages=stages,
        final_response=final_response
    )

# ═══════════════════════════════════════════════════════════════
#  STARTUP
# ═══════════════════════════════════════════════════════════════

if __name__ == "__main__":
    print("""
    ╔═══════════════════════════════════════════════════════════════════╗
    ║                                                                   ║
    ║   ☄️  COMET-X UNIFIED BRAIN                                       ║
    ║   ═══════════════════════════════════════════════════════════    ║
    ║                                                                   ║
    ║   Three-Lobe Architecture Orchestrator                           ║
    ║                                                                   ║
    ║   ┌─────────────┐    ┌─────────────┐    ┌─────────────┐          ║
    ║   │  SENSORY    │ -> │  COGNITIVE  │ -> │  EXECUTIVE  │          ║
    ║   │  (Filter)   │    │  (Think)    │    │  (Act)      │          ║
    ║   │  :8000      │    │  :8002      │    │  :8001      │          ║
    ║   └─────────────┘    └─────────────┘    └─────────────┘          ║
    ║                                                                   ║
    ║   Brain Port: 8080                                               ║
    ║   "The whole is greater than the sum of its parts."              ║
    ║                                                                   ║
    ╚═══════════════════════════════════════════════════════════════════╝
    """)
    uvicorn.run(app, host="0.0.0.0", port=8080, log_level="info")
