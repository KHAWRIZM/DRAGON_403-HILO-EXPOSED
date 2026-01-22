"""
🧠 HAFAN-CORE - Sovereign AI Service
Multi-model orchestration with Azure AI
"""

import httpx
import json
import logging
from typing import Optional, Dict, Any
import asyncio

import sys
sys.path.append('..')
from config import settings

logger = logging.getLogger("hafan.core.ai")

class SovereignAI:
    """
    🐉 Sovereign AI - Multi-model orchestration
    
    Models:
    - DeepSeek-R1: Reasoning & analysis
    - Llama-3.1-405B: General tasks
    - GPT-4o: Creative writing
    """
    
    def __init__(self):
        self.timeout = httpx.Timeout(60.0)
        
    async def chat(
        self,
        message: str,
        model: str = "auto",
        context: Optional[str] = None,
        temperature: float = 0.7,
        max_tokens: int = 2000
    ) -> Dict[str, Any]:
        """
        Multi-model chat with automatic fallback
        """
        # Auto-select model based on query
        if model == "auto":
            model = self._select_model(message)
        
        # Build messages
        messages = []
        if context:
            messages.append({"role": "system", "content": context})
        messages.append({"role": "user", "content": message})
        
        # Try models in order with fallback
        models_to_try = [model] if model != "auto" else ["deepseek", "llama", "gpt"]
        
        for m in models_to_try:
            try:
                result = await self._call_model(m, messages, temperature, max_tokens)
                return {
                    "text": result,
                    "model": m,
                    "tokens": len(result.split()) * 2  # Rough estimate
                }
            except Exception as e:
                logger.warning(f"Model {m} failed: {e}, trying next...")
                continue
        
        raise Exception("All AI models failed")
    
    def _select_model(self, message: str) -> str:
        """Auto-select best model for the query"""
        message_lower = message.lower()
        
        # Reasoning tasks → DeepSeek
        if any(word in message_lower for word in ["حلل", "analyze", "explain", "why", "لماذا", "كيف", "how"]):
            return "deepseek"
        
        # Creative tasks → GPT
        if any(word in message_lower for word in ["اكتب", "write", "create", "story", "قصة", "شعر"]):
            return "gpt"
        
        # Default → Llama (fast general purpose)
        return "llama"
    
    async def _call_model(
        self,
        model: str,
        messages: list,
        temperature: float,
        max_tokens: int
    ) -> str:
        """Call specific AI model"""
        
        if model == "deepseek":
            return await self._call_deepseek(messages, temperature, max_tokens)
        elif model == "llama":
            return await self._call_llama(messages, temperature, max_tokens)
        elif model == "gpt":
            return await self._call_gpt(messages, temperature, max_tokens)
        else:
            raise ValueError(f"Unknown model: {model}")
    
    async def _call_deepseek(self, messages: list, temperature: float, max_tokens: int) -> str:
        """Call DeepSeek-R1 via Azure"""
        url = f"{settings.AZURE_DEEPSEEK_ENDPOINT}/models/chat/completions"
        
        async with httpx.AsyncClient(timeout=self.timeout) as client:
            response = await client.post(
                url,
                headers={
                    "Authorization": f"Bearer {settings.AZURE_DEEPSEEK_KEY}",
                    "Content-Type": "application/json"
                },
                json={
                    "messages": messages,
                    "temperature": temperature,
                    "max_tokens": max_tokens,
                    "model": settings.AZURE_DEEPSEEK_MODEL
                }
            )
            response.raise_for_status()
            data = response.json()
            return data["choices"][0]["message"]["content"]
    
    async def _call_llama(self, messages: list, temperature: float, max_tokens: int) -> str:
        """Call Llama via Azure"""
        url = f"{settings.AZURE_LLAMA_ENDPOINT}/models/chat/completions"
        
        async with httpx.AsyncClient(timeout=self.timeout) as client:
            response = await client.post(
                url,
                headers={
                    "Authorization": f"Bearer {settings.AZURE_LLAMA_KEY}",
                    "Content-Type": "application/json"
                },
                json={
                    "messages": messages,
                    "temperature": temperature,
                    "max_tokens": max_tokens,
                    "model": settings.AZURE_LLAMA_MODEL
                }
            )
            response.raise_for_status()
            data = response.json()
            return data["choices"][0]["message"]["content"]
    
    async def _call_gpt(self, messages: list, temperature: float, max_tokens: int) -> str:
        """Call GPT-4o via Azure OpenAI"""
        url = f"{settings.AZURE_OPENAI_ENDPOINT}/openai/deployments/{settings.AZURE_OPENAI_MODEL}/chat/completions?api-version=2024-02-15-preview"
        
        async with httpx.AsyncClient(timeout=self.timeout) as client:
            response = await client.post(
                url,
                headers={
                    "api-key": settings.AZURE_OPENAI_KEY,
                    "Content-Type": "application/json"
                },
                json={
                    "messages": messages,
                    "temperature": temperature,
                    "max_tokens": max_tokens
                }
            )
            response.raise_for_status()
            data = response.json()
            return data["choices"][0]["message"]["content"]
    
    async def text_to_speech(
        self,
        text: str,
        voice: str = "ar-SA-HamedNeural",
        speed: float = 1.0
    ) -> Dict[str, Any]:
        """
        Arabic Neural TTS via Azure Speech
        """
        url = f"https://{settings.AZURE_SPEECH_REGION}.tts.speech.microsoft.com/cognitiveservices/v1"
        
        # SSML with speed control
        ssml = f"""
        <speak version='1.0' xmlns='http://www.w3.org/2001/10/synthesis' xml:lang='ar-SA'>
            <voice name='{voice}'>
                <prosody rate='{speed}'>
                    {text}
                </prosody>
            </voice>
        </speak>
        """
        
        async with httpx.AsyncClient(timeout=self.timeout) as client:
            response = await client.post(
                url,
                headers={
                    "Ocp-Apim-Subscription-Key": settings.AZURE_SPEECH_KEY,
                    "Content-Type": "application/ssml+xml",
                    "X-Microsoft-OutputFormat": "audio-16khz-128kbitrate-mono-mp3"
                },
                content=ssml.encode('utf-8')
            )
            response.raise_for_status()
            
            # In production, save to blob storage and return URL
            # For now, return base64
            import base64
            audio_b64 = base64.b64encode(response.content).decode()
            
            return {
                "url": f"data:audio/mp3;base64,{audio_b64}",
                "duration": len(response.content) / 16000  # Rough estimate
            }
    
    async def generate_image(
        self,
        prompt: str,
        size: str = "1024x1024",
        quality: str = "hd",
        style: str = "vivid"
    ) -> Dict[str, Any]:
        """
        DALL-E 3 Image Generation
        """
        url = f"{settings.AZURE_OPENAI_ENDPOINT}/openai/deployments/dall-e-3/images/generations?api-version=2024-02-15-preview"
        
        async with httpx.AsyncClient(timeout=self.timeout) as client:
            response = await client.post(
                url,
                headers={
                    "api-key": settings.AZURE_OPENAI_KEY,
                    "Content-Type": "application/json"
                },
                json={
                    "prompt": prompt,
                    "size": size,
                    "quality": quality,
                    "style": style,
                    "n": 1
                }
            )
            response.raise_for_status()
            data = response.json()
            
            return {
                "url": data["data"][0]["url"],
                "revised_prompt": data["data"][0].get("revised_prompt", prompt)
            }
    
    async def translate(
        self,
        text: str,
        source_lang: str = "auto",
        target_lang: str = "ar"
    ) -> Dict[str, Any]:
        """
        Translation via Azure Translator
        """
        url = "https://api.cognitive.microsofttranslator.com/translate"
        
        params = {
            "api-version": "3.0",
            "to": target_lang
        }
        if source_lang != "auto":
            params["from"] = source_lang
        
        async with httpx.AsyncClient(timeout=self.timeout) as client:
            response = await client.post(
                url,
                params=params,
                headers={
                    "Ocp-Apim-Subscription-Key": settings.AZURE_OPENAI_KEY,  # Use same key
                    "Ocp-Apim-Subscription-Region": settings.AZURE_SPEECH_REGION,
                    "Content-Type": "application/json"
                },
                json=[{"text": text}]
            )
            response.raise_for_status()
            data = response.json()
            
            return {
                "text": data[0]["translations"][0]["text"],
                "detected": data[0].get("detectedLanguage", {}).get("language", source_lang)
            }
