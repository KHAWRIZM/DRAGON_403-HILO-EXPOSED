"""
🏛️ HAFAN - Sovereign AI Gateway
Main FastAPI Application
"""

from fastapi import FastAPI, Request
from fastapi.middleware.cors import CORSMiddleware
from fastapi.responses import JSONResponse
from contextlib import asynccontextmanager
import logging

from config import settings
from core.router import router as core_router
from ledger.router import router as ledger_router
from gateway.router import router as gateway_router

# Setup logging
logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s | %(levelname)s | %(message)s"
)
logger = logging.getLogger("hafan")

@asynccontextmanager
async def lifespan(app: FastAPI):
    """Startup and shutdown events"""
    logger.info("🏛️ HAFAN Gateway Starting...")
    logger.info(f"   Domain: {settings.DOMAIN}")
    logger.info(f"   AI Provider: Azure (DeepSeek + Llama + GPT)")
    logger.info(f"   Payment: Moyasar (Saudi)")
    yield
    logger.info("🏛️ HAFAN Gateway Shutting Down...")

app = FastAPI(
    title="HAFAN - Sovereign AI Gateway",
    description="GraTech's Sovereign AI Runtime - dragon403.com",
    version="1.0.0",
    docs_url="/docs",
    redoc_url="/redoc",
    lifespan=lifespan
)

# CORS - Allow frontend access
app.add_middleware(
    CORSMiddleware,
    allow_origins=[
        "http://localhost:3000",
        "http://localhost:5173",
        "https://dragon403.com",
        "https://www.dragon403.com",
        "https://app.dragon403.com",
    ],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# Include routers
app.include_router(core_router, prefix="/api/v1/ai", tags=["AI Core"])
app.include_router(ledger_router, prefix="/api/v1/ledger", tags=["Legal Ledger"])
app.include_router(gateway_router, prefix="/api/v1/pay", tags=["Payment Gateway"])

@app.get("/")
async def root():
    """Health check and info"""
    return {
        "service": "HAFAN",
        "status": "operational",
        "version": "1.0.0",
        "domain": settings.DOMAIN,
        "modules": {
            "core": "AI Runtime (DeepSeek, Llama, GPT)",
            "ledger": "Legal Evidence Management",
            "gateway": "Sovereign Payment (Moyasar)"
        },
        "architect": "KHAWRIZM"
    }

@app.get("/health")
async def health():
    """Detailed health check"""
    return {
        "status": "healthy",
        "services": {
            "ai": "online",
            "ledger": "online", 
            "payment": "online"
        }
    }

@app.exception_handler(Exception)
async def global_exception_handler(request: Request, exc: Exception):
    """Global error handler"""
    logger.error(f"Error: {exc}")
    return JSONResponse(
        status_code=500,
        content={
            "error": "internal_error",
            "message": str(exc) if settings.DEBUG else "An error occurred"
        }
    )

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(
        "main:app",
        host="0.0.0.0",
        port=8000,
        reload=settings.DEBUG
    )
