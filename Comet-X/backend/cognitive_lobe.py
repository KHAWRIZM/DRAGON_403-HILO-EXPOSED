"""
☄️ COMET-X: COGNITIVE LOBE
==========================
AI Processing Hub - Connects to Ollama for local LLM

This is the "brain" that processes commands after Sensory filtering
and before Executive action.

Author: Sulaiman Alshammari (KHAWRIZM)
"""

import httpx
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
from typing import Optional, List
import asyncio

# ═══════════════════════════════════════════════════════════════
#  CONFIGURATION
# ═══════════════════════════════════════════════════════════════

OLLAMA_URL = "http://localhost:11434"
DEFAULT_MODEL = "llama3.2"  # أو أي موديل عندك

app = FastAPI(title="☄️ Comet-X Cognitive Lobe")

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
)

# ═══════════════════════════════════════════════════════════════
#  DATA MODELS
# ═══════════════════════════════════════════════════════════════

class ThinkRequest(BaseModel):
    prompt: str
    context: Optional[str] = None
    model: Optional[str] = DEFAULT_MODEL
    system: Optional[str] = """You are Comet, a sovereign AI assistant built into the Comet-X browser. 
You help users browse the web, analyze content, and execute commands.
You are direct, efficient, and privacy-focused.
Protocol: Vice Habibi - No hedging, pure execution."""

class ThinkResponse(BaseModel):
    status: str
    response: str
    model: str
    lobe: str = "Cognitive"

class CommandParseRequest(BaseModel):
    user_input: str

class ParsedCommand(BaseModel):
    intent: str  # search, navigate, open, close, ask, unknown
    action: str
    parameters: dict
    confidence: float

# ═══════════════════════════════════════════════════════════════
#  OLLAMA INTEGRATION
# ═══════════════════════════════════════════════════════════════

async def query_ollama(prompt: str, model: str = DEFAULT_MODEL, system: str = "") -> str:
    """Query Ollama for LLM response"""
    try:
        async with httpx.AsyncClient(timeout=60.0) as client:
            response = await client.post(
                f"{OLLAMA_URL}/api/generate",
                json={
                    "model": model,
                    "prompt": prompt,
                    "system": system,
                    "stream": False
                }
            )
            
            if response.status_code == 200:
                data = response.json()
                return data.get("response", "")
            else:
                return f"Error: Ollama returned {response.status_code}"
                
    except httpx.ConnectError:
        return "Error: Cannot connect to Ollama. Make sure it's running on localhost:11434"
    except Exception as e:
        return f"Error: {str(e)}"

async def check_ollama() -> dict:
    """Check if Ollama is running and list models"""
    try:
        async with httpx.AsyncClient(timeout=5.0) as client:
            response = await client.get(f"{OLLAMA_URL}/api/tags")
            if response.status_code == 200:
                models = response.json().get("models", [])
                return {
                    "online": True,
                    "models": [m["name"] for m in models]
                }
    except:
        pass
    return {"online": False, "models": []}

# ═══════════════════════════════════════════════════════════════
#  COMMAND PARSER (Local Intelligence)
# ═══════════════════════════════════════════════════════════════

COMMAND_PATTERNS = {
    "search": ["search for", "search", "find", "look up", "google", "بحث عن", "ابحث"],
    "navigate": ["go to", "open", "visit", "navigate to", "روح", "افتح"],
    "newtab": ["new tab", "open tab", "tab new", "تاب جديد"],
    "close": ["close", "close tab", "اقفل", "سكر"],
    "ask": ["what is", "who is", "how to", "explain", "ايش", "شنو", "كيف"],
}

def parse_command_locally(user_input: str) -> ParsedCommand:
    """Parse user input without LLM - fast local parsing"""
    input_lower = user_input.lower()
    
    for intent, patterns in COMMAND_PATTERNS.items():
        for pattern in patterns:
            if pattern in input_lower:
                # Extract the rest as parameters
                idx = input_lower.find(pattern)
                query = user_input[idx + len(pattern):].strip()
                
                return ParsedCommand(
                    intent=intent,
                    action=f"{intent}:{query}",
                    parameters={"query": query, "pattern_matched": pattern},
                    confidence=0.8
                )
    
    # Default: treat as search or ask
    if "?" in user_input or any(w in input_lower for w in ["what", "who", "how", "ايش", "كيف"]):
        return ParsedCommand(
            intent="ask",
            action=f"ask:{user_input}",
            parameters={"query": user_input},
            confidence=0.6
        )
    
    return ParsedCommand(
        intent="search",
        action=f"search:{user_input}",
        parameters={"query": user_input},
        confidence=0.5
    )

# ═══════════════════════════════════════════════════════════════
#  API ENDPOINTS
# ═══════════════════════════════════════════════════════════════

@app.get("/")
async def root():
    ollama_status = await check_ollama()
    return {
        "status": "ONLINE",
        "lobe": "Cognitive",
        "port": 8002,
        "ollama": ollama_status
    }

@app.get("/models")
async def list_models():
    """List available Ollama models"""
    return await check_ollama()

@app.post("/think", response_model=ThinkResponse)
async def think(request: ThinkRequest):
    """
    Main thinking endpoint - processes prompts through Ollama
    """
    print(f"\n🔵 [COGNITIVE] Processing: {request.prompt[:50]}...")
    
    full_prompt = request.prompt
    if request.context:
        full_prompt = f"Context: {request.context}\n\nUser: {request.prompt}"
    
    response = await query_ollama(full_prompt, request.model, request.system)
    
    status = "SUCCESS" if not response.startswith("Error:") else "ERROR"
    print(f"{'🟢' if status == 'SUCCESS' else '🔴'} [COGNITIVE] {status}")
    
    return ThinkResponse(
        status=status,
        response=response,
        model=request.model
    )

@app.post("/parse", response_model=ParsedCommand)
async def parse_command(request: CommandParseRequest):
    """
    Parse user input into structured command
    Fast local parsing without LLM
    """
    return parse_command_locally(request.user_input)

@app.post("/parse/smart", response_model=ParsedCommand)
async def smart_parse(request: CommandParseRequest):
    """
    Smart parsing using LLM for complex commands
    """
    # First try local parsing
    local_result = parse_command_locally(request.user_input)
    
    if local_result.confidence >= 0.7:
        return local_result
    
    # Use LLM for unclear commands
    prompt = f"""Parse this user command and return ONLY a JSON object:
User: "{request.user_input}"

Return format:
{{"intent": "search|navigate|newtab|close|ask", "action": "description", "parameters": {{"key": "value"}}}}
"""
    
    response = await query_ollama(prompt)
    
    try:
        import json
        parsed = json.loads(response)
        return ParsedCommand(
            intent=parsed.get("intent", "unknown"),
            action=parsed.get("action", request.user_input),
            parameters=parsed.get("parameters", {}),
            confidence=0.9
        )
    except:
        return local_result

# ═══════════════════════════════════════════════════════════════
#  STARTUP
# ═══════════════════════════════════════════════════════════════

if __name__ == "__main__":
    import uvicorn
    print("""
    ╔═══════════════════════════════════════════════════════════╗
    ║  ☄️  COMET-X COGNITIVE LOBE                               ║
    ║  ─────────────────────────────────────────────────────── ║
    ║  Status: ACTIVE                                          ║
    ║  Port: 8002                                              ║
    ║  LLM: Ollama (localhost:11434)                           ║
    ║  "Think before you act. Act before they react."          ║
    ╚═══════════════════════════════════════════════════════════╝
    """)
    uvicorn.run(app, host="0.0.0.0", port=8002, log_level="info")
