"""
☄️ COMET-X: SENSORY LOBE
========================
The First Line of Defense - Data Filter & Privacy Guardian

Architecture: Three-Lobe System
├── SENSORY (This) → Filters input, blocks sensitive data
├── COGNITIVE      → AI Processing (Ollama/LLM)
└── EXECUTIVE      → Browser Control (CDP)

Author: Sulaiman Alshammari (KHAWRIZM)
Protocol: Vice Habibi - No Hedging, Pure Execution
"""

import uvicorn
from fastapi import FastAPI, Request, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from fastapi.responses import JSONResponse
from pydantic import BaseModel
from typing import Optional, List
import re
from datetime import datetime

# ═══════════════════════════════════════════════════════════════
#  SOVEREIGN CONFIGURATION
# ═══════════════════════════════════════════════════════════════

app = FastAPI(
    title="☄️ Comet-X Sensory Lobe",
    description="Privacy-First Input Filter for Sovereign Browser",
    version="1.0.0"
)

# CORS للتواصل مع Frontend
app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:5173", "http://localhost:3000"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# ═══════════════════════════════════════════════════════════════
#  PRIVACY PATTERNS - ما يجب حجبه
# ═══════════════════════════════════════════════════════════════

PRIVACY_PATTERNS = {
    "credit_card": r"\b(?:\d{4}[-\s]?){3}\d{4}\b",
    "ssn": r"\b\d{3}-\d{2}-\d{4}\b",
    "email": r"\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}\b",
    "phone_sa": r"\b(?:\+966|00966|0)?5\d{8}\b",  # Saudi phone
    "api_key": r"\b(?:sk-|pk-|api[_-]?key)[a-zA-Z0-9]{20,}\b",
    "password": r"(?i)password\s*[:=]\s*\S+",
}

BLOCKED_KEYWORDS = [
    "secret", "password", "api_key", "private_key",
    "credit_card", "ssn", "bank_account"
]

# ═══════════════════════════════════════════════════════════════
#  DATA MODELS
# ═══════════════════════════════════════════════════════════════

class SensoryInput(BaseModel):
    command: str
    context: Optional[str] = None
    source: Optional[str] = "user"

class SensoryOutput(BaseModel):
    status: str  # CLEARED, FILTERED, DENIED
    payload: str
    filtered_items: List[str] = []
    lobe: str = "Sensory"
    timestamp: str

class HealthCheck(BaseModel):
    status: str
    lobe: str
    uptime: str
    version: str

# ═══════════════════════════════════════════════════════════════
#  SOVEREIGN FILTER LOGIC
# ═══════════════════════════════════════════════════════════════

def scan_for_privacy_violations(text: str) -> tuple[str, list]:
    """
    Scans input for sensitive data patterns.
    Returns (filtered_text, list_of_violations)
    """
    violations = []
    filtered_text = text
    
    for pattern_name, pattern in PRIVACY_PATTERNS.items():
        matches = re.findall(pattern, text, re.IGNORECASE)
        if matches:
            violations.append(f"{pattern_name}: {len(matches)} found")
            # Redact the sensitive data
            filtered_text = re.sub(pattern, f"[REDACTED:{pattern_name.upper()}]", filtered_text, flags=re.IGNORECASE)
    
    return filtered_text, violations

def check_blocked_keywords(text: str) -> bool:
    """Check if text contains blocked keywords"""
    text_lower = text.lower()
    return any(keyword in text_lower for keyword in BLOCKED_KEYWORDS)

# ═══════════════════════════════════════════════════════════════
#  API ENDPOINTS
# ═══════════════════════════════════════════════════════════════

@app.get("/", response_model=HealthCheck)
async def root():
    """Health check endpoint"""
    return HealthCheck(
        status="ONLINE",
        lobe="Sensory",
        uptime=datetime.now().isoformat(),
        version="1.0.0"
    )

@app.post("/mission/scan", response_model=SensoryOutput)
async def sensory_scan(input_data: SensoryInput):
    """
    Main Sensory Filter - Scans and sanitizes user input
    before passing to Cognitive Lobe
    """
    command = input_data.command
    timestamp = datetime.now().isoformat()
    
    print(f"\n🔵 [SENSORY] Scanning: {command[:50]}...")
    
    # Check for blocked keywords first
    if check_blocked_keywords(command):
        print(f"🔴 [SENSORY] DENIED - Blocked keyword detected")
        return SensoryOutput(
            status="DENIED",
            payload="",
            filtered_items=["Blocked keyword detected"],
            timestamp=timestamp
        )
    
    # Scan for privacy violations
    filtered_text, violations = scan_for_privacy_violations(command)
    
    if violations:
        print(f"🟡 [SENSORY] FILTERED - {len(violations)} violations")
        return SensoryOutput(
            status="FILTERED",
            payload=filtered_text,
            filtered_items=violations,
            timestamp=timestamp
        )
    
    print(f"🟢 [SENSORY] CLEARED")
    return SensoryOutput(
        status="CLEARED",
        payload=command,
        filtered_items=[],
        timestamp=timestamp
    )

@app.post("/mission/batch")
async def batch_scan(inputs: List[SensoryInput]):
    """Batch scan multiple inputs"""
    results = []
    for input_data in inputs:
        result = await sensory_scan(input_data)
        results.append(result)
    return {"results": results, "total": len(results)}

@app.get("/patterns")
async def get_patterns():
    """List all privacy patterns being monitored"""
    return {
        "patterns": list(PRIVACY_PATTERNS.keys()),
        "blocked_keywords": BLOCKED_KEYWORDS
    }

# ═══════════════════════════════════════════════════════════════
#  STARTUP
# ═══════════════════════════════════════════════════════════════

if __name__ == "__main__":
    print("""
    ╔═══════════════════════════════════════════════════════════╗
    ║  ☄️  COMET-X SENSORY LOBE                                 ║
    ║  ─────────────────────────────────────────────────────── ║
    ║  Status: ACTIVE                                          ║
    ║  Port: 8000                                              ║
    ║  Protocol: Vice Habibi                                   ║
    ║  "The desert does not forget."                           ║
    ╚═══════════════════════════════════════════════════════════╝
    """)
    uvicorn.run(app, host="0.0.0.0", port=8000, log_level="info")
