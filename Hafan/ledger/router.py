"""
📋 HAFAN-LEDGER Router
Legal Evidence Management Endpoints
"""

from fastapi import APIRouter, HTTPException, UploadFile, File
from pydantic import BaseModel
from typing import Optional, List
from datetime import datetime
from enum import Enum
import logging
import uuid

router = APIRouter()
logger = logging.getLogger("hafan.ledger")

# ═══════════════════════════════════════════════════════════════
# Enums & Models
# ═══════════════════════════════════════════════════════════════

class CaseStatus(str, Enum):
    OPEN = "open"
    IN_PROGRESS = "in_progress"
    SUBMITTED = "submitted"
    CLOSED = "closed"

class EvidenceType(str, Enum):
    SCREENSHOT = "screenshot"
    DOCUMENT = "document"
    TRANSACTION = "transaction"
    CODE = "code"
    COMMUNICATION = "communication"
    OSINT = "osint"

class Authority(str, Enum):
    DPC_IRELAND = "dpc_ireland"
    FTC_USA = "ftc_usa"
    CA_AG = "ca_ag"
    SAMA_KSA = "sama_ksa"
    SDAIA_KSA = "sdaia_ksa"
    IC3_FBI = "ic3_fbi"
    CMA_UK = "cma_uk"
    APPLE = "apple"
    GOOGLE = "google"

class Case(BaseModel):
    id: str
    title: str
    description: str
    target_entity: str  # HILO, Apple, etc.
    status: CaseStatus
    authorities: List[Authority]
    created_at: datetime
    updated_at: datetime
    total_loss_sar: float
    
class Evidence(BaseModel):
    id: str
    case_id: str
    type: EvidenceType
    title: str
    description: str
    file_url: Optional[str]
    source_file: Optional[str]
    line_numbers: Optional[str]
    timestamp: datetime
    tags: List[str]

class TimelineEvent(BaseModel):
    id: str
    case_id: str
    timestamp: datetime
    event_type: str
    description: str
    evidence_ids: List[str]

class CreateCaseRequest(BaseModel):
    title: str
    description: str
    target_entity: str
    authorities: List[Authority]
    total_loss_sar: float = 0

class AddEvidenceRequest(BaseModel):
    case_id: str
    type: EvidenceType
    title: str
    description: str
    source_file: Optional[str] = None
    line_numbers: Optional[str] = None
    tags: List[str] = []

# ═══════════════════════════════════════════════════════════════
# In-Memory Storage (Replace with Cosmos DB in production)
# ═══════════════════════════════════════════════════════════════

CASES_DB: dict[str, Case] = {}
EVIDENCE_DB: dict[str, Evidence] = {}
TIMELINE_DB: dict[str, TimelineEvent] = {}

# Initialize with HILO case
HILO_CASE_ID = "hilo-fraud-2024"
CASES_DB[HILO_CASE_ID] = Case(
    id=HILO_CASE_ID,
    title="HILO App Fraud - 600K SAR",
    description="Systematic fraud by Guangzhou QiaHaoQingChun Information Technology Co., Ltd via HILO Android app",
    target_entity="HILO / Guangzhou QiaHaoQingChun",
    status=CaseStatus.IN_PROGRESS,
    authorities=[Authority.DPC_IRELAND, Authority.FTC_USA, Authority.SAMA_KSA, Authority.APPLE, Authority.GOOGLE],
    created_at=datetime(2024, 1, 1),
    updated_at=datetime.now(),
    total_loss_sar=600000
)

# ═══════════════════════════════════════════════════════════════
# Endpoints
# ═══════════════════════════════════════════════════════════════

@router.get("/cases")
async def list_cases():
    """📂 List all legal cases"""
    return {
        "cases": list(CASES_DB.values()),
        "total": len(CASES_DB)
    }

@router.get("/cases/{case_id}")
async def get_case(case_id: str):
    """📄 Get case details"""
    if case_id not in CASES_DB:
        raise HTTPException(status_code=404, detail="Case not found")
    
    case = CASES_DB[case_id]
    evidence = [e for e in EVIDENCE_DB.values() if e.case_id == case_id]
    
    return {
        "case": case,
        "evidence_count": len(evidence),
        "evidence": evidence[:10]  # First 10
    }

@router.post("/cases")
async def create_case(request: CreateCaseRequest):
    """➕ Create new legal case"""
    case_id = f"case-{uuid.uuid4().hex[:8]}"
    
    case = Case(
        id=case_id,
        title=request.title,
        description=request.description,
        target_entity=request.target_entity,
        status=CaseStatus.OPEN,
        authorities=request.authorities,
        created_at=datetime.now(),
        updated_at=datetime.now(),
        total_loss_sar=request.total_loss_sar
    )
    
    CASES_DB[case_id] = case
    logger.info(f"Created case: {case_id}")
    
    return {"case": case, "message": "Case created successfully"}

@router.post("/evidence")
async def add_evidence(request: AddEvidenceRequest):
    """📎 Add evidence to case"""
    if request.case_id not in CASES_DB:
        raise HTTPException(status_code=404, detail="Case not found")
    
    evidence_id = f"ev-{uuid.uuid4().hex[:8]}"
    
    evidence = Evidence(
        id=evidence_id,
        case_id=request.case_id,
        type=request.type,
        title=request.title,
        description=request.description,
        file_url=None,
        source_file=request.source_file,
        line_numbers=request.line_numbers,
        timestamp=datetime.now(),
        tags=request.tags
    )
    
    EVIDENCE_DB[evidence_id] = evidence
    
    # Update case timestamp
    CASES_DB[request.case_id].updated_at = datetime.now()
    
    logger.info(f"Added evidence {evidence_id} to case {request.case_id}")
    
    return {"evidence": evidence, "message": "Evidence added successfully"}

@router.post("/evidence/{evidence_id}/upload")
async def upload_evidence_file(evidence_id: str, file: UploadFile = File(...)):
    """📤 Upload evidence file"""
    if evidence_id not in EVIDENCE_DB:
        raise HTTPException(status_code=404, detail="Evidence not found")
    
    # In production, upload to Azure Blob Storage
    # For now, just acknowledge
    
    return {
        "message": "File uploaded",
        "filename": file.filename,
        "size": file.size
    }

@router.get("/timeline/{case_id}")
async def get_timeline(case_id: str):
    """📅 Get case timeline"""
    if case_id not in CASES_DB:
        raise HTTPException(status_code=404, detail="Case not found")
    
    # Get all evidence for case, sorted by timestamp
    evidence = sorted(
        [e for e in EVIDENCE_DB.values() if e.case_id == case_id],
        key=lambda x: x.timestamp
    )
    
    timeline = []
    for ev in evidence:
        timeline.append({
            "timestamp": ev.timestamp,
            "event": f"Evidence added: {ev.title}",
            "type": ev.type,
            "evidence_id": ev.id
        })
    
    return {
        "case_id": case_id,
        "timeline": timeline,
        "total_events": len(timeline)
    }

@router.get("/export/{case_id}")
async def export_case(case_id: str, format: str = "json"):
    """📦 Export case for submission to authorities"""
    if case_id not in CASES_DB:
        raise HTTPException(status_code=404, detail="Case not found")
    
    case = CASES_DB[case_id]
    evidence = [e.model_dump() for e in EVIDENCE_DB.values() if e.case_id == case_id]
    
    export_data = {
        "export_timestamp": datetime.now().isoformat(),
        "format_version": "1.0",
        "case": case.model_dump(),
        "evidence": evidence,
        "summary": {
            "total_evidence": len(evidence),
            "total_loss_sar": case.total_loss_sar,
            "total_loss_usd": case.total_loss_sar / 3.75,  # Approximate
            "target_entity": case.target_entity,
            "submission_targets": [a.value for a in case.authorities]
        }
    }
    
    return export_data

@router.get("/authorities")
async def list_authorities():
    """🏛️ List supported authorities for submission"""
    return {
        "authorities": [
            {"id": "dpc_ireland", "name": "Data Protection Commission (Ireland)", "jurisdiction": "EU/GDPR"},
            {"id": "ftc_usa", "name": "Federal Trade Commission (USA)", "jurisdiction": "USA"},
            {"id": "ca_ag", "name": "California Attorney General", "jurisdiction": "California"},
            {"id": "sama_ksa", "name": "Saudi Central Bank", "jurisdiction": "Saudi Arabia"},
            {"id": "sdaia_ksa", "name": "SDAIA (Data Authority)", "jurisdiction": "Saudi Arabia"},
            {"id": "ic3_fbi", "name": "IC3 / FBI", "jurisdiction": "USA"},
            {"id": "cma_uk", "name": "Competition and Markets Authority", "jurisdiction": "UK"},
            {"id": "apple", "name": "Apple Legal / App Store", "jurisdiction": "Global"},
            {"id": "google", "name": "Google Legal / Play Store", "jurisdiction": "Global"},
        ]
    }
