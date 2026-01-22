"""
🧠 HAFAN-CORE Router
AI API Endpoints
"""

from fastapi import APIRouter, HTTPException, Depends
from pydantic import BaseModel
from typing import Optional, List
import logging

from .sovereign_ai import SovereignAI

router = APIRouter()
logger = logging.getLogger("hafan.core")
ai = SovereignAI()

# ═══════════════════════════════════════════════════════════════
# Request/Response Models
# ═══════════════════════════════════════════════════════════════

class ChatRequest(BaseModel):
    message: str
    model: Optional[str] = "auto"  # auto, deepseek, llama, gpt
    context: Optional[str] = None
    temperature: Optional[float] = 0.7
    max_tokens: Optional[int] = 2000
    
class ChatResponse(BaseModel):
    text: str
    model_used: str
    tokens_used: int
    
class TTSRequest(BaseModel):
    text: str
    voice: Optional[str] = "ar-SA-HamedNeural"  # Arabic male
    speed: Optional[float] = 1.0
    
class TTSResponse(BaseModel):
    audio_url: str
    duration_seconds: float
    
class ImageRequest(BaseModel):
    prompt: str
    size: Optional[str] = "1024x1024"
    quality: Optional[str] = "hd"
    style: Optional[str] = "vivid"
    
class ImageResponse(BaseModel):
    image_url: str
    revised_prompt: str

class TranslateRequest(BaseModel):
    text: str
    source_lang: Optional[str] = "auto"
    target_lang: str = "ar"

class TranslateResponse(BaseModel):
    translated_text: str
    detected_language: str

# ═══════════════════════════════════════════════════════════════
# Endpoints
# ═══════════════════════════════════════════════════════════════

@router.post("/chat", response_model=ChatResponse)
async def chat(request: ChatRequest):
    """
    🗣️ Multi-model AI Chat
    
    Models:
    - auto: Best model selection based on query
    - deepseek: DeepSeek-R1 (reasoning)
    - llama: Llama-3.1-405B (general)
    - gpt: GPT-4o (creative)
    """
    try:
        result = await ai.chat(
            message=request.message,
            model=request.model,
            context=request.context,
            temperature=request.temperature,
            max_tokens=request.max_tokens
        )
        return ChatResponse(
            text=result["text"],
            model_used=result["model"],
            tokens_used=result.get("tokens", 0)
        )
    except Exception as e:
        logger.error(f"Chat error: {e}")
        raise HTTPException(status_code=500, detail=str(e))

@router.post("/tts", response_model=TTSResponse)
async def text_to_speech(request: TTSRequest):
    """
    🔊 Arabic Neural Text-to-Speech
    
    Voices:
    - ar-SA-HamedNeural (Male)
    - ar-SA-ZariyahNeural (Female)
    """
    try:
        result = await ai.text_to_speech(
            text=request.text,
            voice=request.voice,
            speed=request.speed
        )
        return TTSResponse(
            audio_url=result["url"],
            duration_seconds=result["duration"]
        )
    except Exception as e:
        logger.error(f"TTS error: {e}")
        raise HTTPException(status_code=500, detail=str(e))

@router.post("/image", response_model=ImageResponse)
async def generate_image(request: ImageRequest):
    """
    🎨 DALL-E 3 Image Generation
    """
    try:
        result = await ai.generate_image(
            prompt=request.prompt,
            size=request.size,
            quality=request.quality,
            style=request.style
        )
        return ImageResponse(
            image_url=result["url"],
            revised_prompt=result["revised_prompt"]
        )
    except Exception as e:
        logger.error(f"Image generation error: {e}")
        raise HTTPException(status_code=500, detail=str(e))

@router.post("/translate", response_model=TranslateResponse)
async def translate(request: TranslateRequest):
    """
    🌍 Translation (100+ languages)
    """
    try:
        result = await ai.translate(
            text=request.text,
            source_lang=request.source_lang,
            target_lang=request.target_lang
        )
        return TranslateResponse(
            translated_text=result["text"],
            detected_language=result["detected"]
        )
    except Exception as e:
        logger.error(f"Translation error: {e}")
        raise HTTPException(status_code=500, detail=str(e))

@router.get("/models")
async def list_models():
    """
    📋 List available AI models
    """
    return {
        "models": [
            {
                "id": "deepseek",
                "name": "DeepSeek-R1",
                "description": "Best for reasoning and analysis",
                "provider": "Azure"
            },
            {
                "id": "llama",
                "name": "Llama-3.1-405B-Instruct",
                "description": "Best for general tasks",
                "provider": "Azure"
            },
            {
                "id": "gpt",
                "name": "GPT-4o",
                "description": "Best for creative writing",
                "provider": "Azure OpenAI"
            }
        ],
        "default": "auto"
    }

@router.get("/voices")
async def list_voices():
    """
    🎤 List available TTS voices
    """
    return {
        "voices": [
            {"id": "ar-SA-HamedNeural", "name": "Hamed", "language": "Arabic (Saudi)", "gender": "Male"},
            {"id": "ar-SA-ZariyahNeural", "name": "Zariyah", "language": "Arabic (Saudi)", "gender": "Female"},
            {"id": "ar-EG-SalmaNeural", "name": "Salma", "language": "Arabic (Egypt)", "gender": "Female"},
            {"id": "ar-AE-FatimaNeural", "name": "Fatima", "language": "Arabic (UAE)", "gender": "Female"},
            {"id": "en-US-JennyNeural", "name": "Jenny", "language": "English (US)", "gender": "Female"},
            {"id": "en-GB-RyanNeural", "name": "Ryan", "language": "English (UK)", "gender": "Male"},
        ],
        "default": "ar-SA-HamedNeural"
    }
