"""
💳 HAFAN-GATEWAY Router
Saudi Payment Gateway (Moyasar)
"""

from fastapi import APIRouter, HTTPException, Request
from pydantic import BaseModel
from typing import Optional, List
from datetime import datetime
from enum import Enum
import logging
import uuid
import hmac
import hashlib
import httpx

import sys
sys.path.append('..')
from config import settings

router = APIRouter()
logger = logging.getLogger("hafan.gateway")

# ═══════════════════════════════════════════════════════════════
# Models
# ═══════════════════════════════════════════════════════════════

class PaymentStatus(str, Enum):
    PENDING = "pending"
    PAID = "paid"
    FAILED = "failed"
    REFUNDED = "refunded"

class PaymentMethod(str, Enum):
    MADA = "mada"
    VISA = "visa"
    MASTERCARD = "mastercard"
    APPLEPAY = "applepay"
    STCPAY = "stcpay"

class SubscriptionTier(str, Enum):
    FREE = "free"
    HUNTER = "hunter"       # $9.99/mo
    WARRIOR = "warrior"     # $29.99/mo
    SOVEREIGN = "sovereign" # $99.99/mo
    ENTERPRISE = "enterprise"

class CreateCheckoutRequest(BaseModel):
    tier: SubscriptionTier
    email: str
    name: Optional[str] = None
    promo_code: Optional[str] = None

class CheckoutResponse(BaseModel):
    checkout_url: str
    session_id: str
    amount_sar: int
    tier: str

class WebhookPayload(BaseModel):
    id: str
    type: str
    data: dict

# ═══════════════════════════════════════════════════════════════
# Pricing (SAR)
# ═══════════════════════════════════════════════════════════════

TIER_PRICES = {
    SubscriptionTier.FREE: 0,
    SubscriptionTier.HUNTER: 37,       # ~$10
    SubscriptionTier.WARRIOR: 112,     # ~$30
    SubscriptionTier.SOVEREIGN: 375,   # ~$100
    SubscriptionTier.ENTERPRISE: 0,    # Custom
}

PROMO_CODES = {
    "DRAGON2026": 50,      # 50% off
    "LAUNCH30": 30,        # 30% off
    "KHAWRIZM": 100,       # 100% off (VIP)
    "HILO_VICTIM": 100,    # Free for HILO fraud victims
}

# ═══════════════════════════════════════════════════════════════
# In-Memory Storage
# ═══════════════════════════════════════════════════════════════

PAYMENTS_DB: dict = {}
SUBSCRIPTIONS_DB: dict = {}

# ═══════════════════════════════════════════════════════════════
# Endpoints
# ═══════════════════════════════════════════════════════════════

@router.get("/plans")
async def list_plans():
    """📋 List subscription plans"""
    return {
        "plans": [
            {
                "id": "free",
                "name": "Free",
                "price_sar": 0,
                "price_usd": 0,
                "features": [
                    "10 AI messages/day",
                    "Basic TTS",
                    "1 case tracking"
                ]
            },
            {
                "id": "hunter",
                "name": "Hunter",
                "price_sar": 37,
                "price_usd": 9.99,
                "features": [
                    "100 AI messages/day",
                    "HD TTS (Arabic)",
                    "5 case tracking",
                    "Evidence export"
                ]
            },
            {
                "id": "warrior",
                "name": "Warrior",
                "price_sar": 112,
                "price_usd": 29.99,
                "features": [
                    "500 AI messages/day",
                    "All TTS voices",
                    "Unlimited cases",
                    "DALL-E images",
                    "Priority support"
                ]
            },
            {
                "id": "sovereign",
                "name": "Sovereign",
                "price_sar": 375,
                "price_usd": 99.99,
                "features": [
                    "Unlimited AI",
                    "All features",
                    "API access",
                    "Custom branding",
                    "Dedicated support"
                ]
            }
        ],
        "currency": "SAR",
        "payment_methods": ["mada", "visa", "mastercard", "applepay", "stcpay"]
    }

@router.post("/checkout", response_model=CheckoutResponse)
async def create_checkout(request: CreateCheckoutRequest):
    """💳 Create payment checkout session (Moyasar)"""
    
    if request.tier == SubscriptionTier.FREE:
        raise HTTPException(status_code=400, detail="Free tier doesn't require payment")
    
    if request.tier == SubscriptionTier.ENTERPRISE:
        raise HTTPException(status_code=400, detail="Contact us for Enterprise pricing")
    
    # Calculate price
    base_price = TIER_PRICES[request.tier]
    discount = 0
    
    if request.promo_code:
        promo_upper = request.promo_code.upper()
        if promo_upper in PROMO_CODES:
            discount = PROMO_CODES[promo_upper]
    
    final_price = int(base_price * (100 - discount) / 100)
    
    # Create Moyasar payment
    session_id = f"pay-{uuid.uuid4().hex[:12]}"
    
    try:
        checkout_url = await _create_moyasar_payment(
            session_id=session_id,
            amount=final_price * 100,  # Moyasar uses halalas
            description=f"Hafan {request.tier.value.title()} Subscription",
            email=request.email,
            name=request.name
        )
    except Exception as e:
        logger.error(f"Moyasar error: {e}")
        # Fallback: return mock URL for testing
        checkout_url = f"https://pay.dragon403.com/checkout/{session_id}"
    
    # Store payment record
    PAYMENTS_DB[session_id] = {
        "id": session_id,
        "tier": request.tier.value,
        "email": request.email,
        "amount_sar": final_price,
        "discount": discount,
        "status": PaymentStatus.PENDING.value,
        "created_at": datetime.now().isoformat()
    }
    
    return CheckoutResponse(
        checkout_url=checkout_url,
        session_id=session_id,
        amount_sar=final_price,
        tier=request.tier.value
    )

@router.post("/webhook")
async def payment_webhook(request: Request):
    """🔔 Moyasar webhook handler"""
    
    body = await request.body()
    signature = request.headers.get("X-Moyasar-Signature", "")
    
    # Verify signature (in production)
    # if not _verify_webhook_signature(body, signature):
    #     raise HTTPException(status_code=401, detail="Invalid signature")
    
    payload = await request.json()
    event_type = payload.get("type", "")
    data = payload.get("data", {})
    
    logger.info(f"Webhook received: {event_type}")
    
    if event_type == "payment.paid":
        payment_id = data.get("id")
        metadata = data.get("metadata", {})
        session_id = metadata.get("session_id")
        
        if session_id and session_id in PAYMENTS_DB:
            PAYMENTS_DB[session_id]["status"] = PaymentStatus.PAID.value
            
            # Create subscription
            SUBSCRIPTIONS_DB[session_id] = {
                "id": session_id,
                "email": PAYMENTS_DB[session_id]["email"],
                "tier": PAYMENTS_DB[session_id]["tier"],
                "started_at": datetime.now().isoformat(),
                "status": "active"
            }
            
            logger.info(f"Payment completed: {session_id}")
    
    elif event_type == "payment.failed":
        session_id = data.get("metadata", {}).get("session_id")
        if session_id and session_id in PAYMENTS_DB:
            PAYMENTS_DB[session_id]["status"] = PaymentStatus.FAILED.value
            logger.warning(f"Payment failed: {session_id}")
    
    return {"status": "received"}

@router.get("/payment/{session_id}")
async def get_payment_status(session_id: str):
    """📊 Get payment status"""
    if session_id not in PAYMENTS_DB:
        raise HTTPException(status_code=404, detail="Payment not found")
    
    return PAYMENTS_DB[session_id]

@router.get("/subscription/{email}")
async def get_subscription(email: str):
    """👤 Get user subscription"""
    for sub in SUBSCRIPTIONS_DB.values():
        if sub["email"] == email:
            return sub
    
    # Return free tier if no subscription
    return {
        "email": email,
        "tier": "free",
        "status": "active"
    }

@router.post("/promo/validate")
async def validate_promo(code: str):
    """🎫 Validate promo code"""
    code_upper = code.upper()
    
    if code_upper in PROMO_CODES:
        return {
            "valid": True,
            "code": code_upper,
            "discount_percent": PROMO_CODES[code_upper]
        }
    
    return {
        "valid": False,
        "code": code,
        "discount_percent": 0
    }

# ═══════════════════════════════════════════════════════════════
# Moyasar Integration
# ═══════════════════════════════════════════════════════════════

async def _create_moyasar_payment(
    session_id: str,
    amount: int,  # In halalas
    description: str,
    email: str,
    name: Optional[str] = None
) -> str:
    """Create Moyasar payment and return checkout URL"""
    
    if not settings.MOYASAR_API_KEY:
        # Return mock URL if no API key
        return f"https://pay.dragon403.com/mock/{session_id}"
    
    url = "https://api.moyasar.com/v1/invoices"
    
    async with httpx.AsyncClient() as client:
        response = await client.post(
            url,
            auth=(settings.MOYASAR_API_KEY, ""),
            json={
                "amount": amount,
                "currency": "SAR",
                "description": description,
                "callback_url": settings.MOYASAR_CALLBACK_URL,
                "metadata": {
                    "session_id": session_id,
                    "email": email
                }
            }
        )
        response.raise_for_status()
        data = response.json()
        
        return data.get("url", f"https://pay.dragon403.com/fallback/{session_id}")

def _verify_webhook_signature(body: bytes, signature: str) -> bool:
    """Verify Moyasar webhook signature"""
    if not settings.MOYASAR_API_KEY:
        return True  # Skip in dev
    
    expected = hmac.new(
        settings.MOYASAR_API_KEY.encode(),
        body,
        hashlib.sha256
    ).hexdigest()
    
    return hmac.compare_digest(expected, signature)
