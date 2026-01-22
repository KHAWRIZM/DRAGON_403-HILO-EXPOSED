"""
🏛️ HAFAN Configuration
Environment settings and secrets
"""

from pydantic_settings import BaseSettings
from typing import Optional
import os

class Settings(BaseSettings):
    """Application settings loaded from environment"""
    
    # General
    DEBUG: bool = True
    DOMAIN: str = "dragon403.com"
    SECRET_KEY: str = "hafan-sovereign-key-change-in-production"
    
    # Azure AI - DeepSeek
    AZURE_DEEPSEEK_ENDPOINT: str = "https://dragon403-deepseek.services.ai.azure.com"
    AZURE_DEEPSEEK_KEY: str = ""
    AZURE_DEEPSEEK_MODEL: str = "DeepSeek-R1"
    
    # Azure AI - OpenAI (GPT, DALL-E, TTS)
    AZURE_OPENAI_ENDPOINT: str = "https://dragon403-openai.openai.azure.com"
    AZURE_OPENAI_KEY: str = ""
    AZURE_OPENAI_MODEL: str = "gpt-4o"
    
    # Azure AI - Llama
    AZURE_LLAMA_ENDPOINT: str = "https://cometx-llama.services.ai.azure.com"
    AZURE_LLAMA_KEY: str = ""
    AZURE_LLAMA_MODEL: str = "Llama-3.1-405B-Instruct"
    
    # Azure Speech (TTS)
    AZURE_SPEECH_KEY: str = ""
    AZURE_SPEECH_REGION: str = "swedencentral"
    
    # Payment - Moyasar (Saudi)
    MOYASAR_API_KEY: str = ""
    MOYASAR_PUBLISHABLE_KEY: str = ""
    MOYASAR_CALLBACK_URL: str = "https://dragon403.com/api/v1/pay/callback"
    
    # Database - Cosmos DB
    COSMOS_CONNECTION_STRING: str = ""
    COSMOS_DATABASE: str = "hafan"
    
    # JWT Auth
    JWT_SECRET: str = "hafan-jwt-secret-change-me"
    JWT_ALGORITHM: str = "HS256"
    JWT_EXPIRY_HOURS: int = 24
    
    class Config:
        env_file = ".env"
        case_sensitive = True

settings = Settings()

# Load from .env file if exists
def load_env_file():
    """Load environment variables from .env file"""
    env_path = os.path.join(os.path.dirname(__file__), ".env")
    if os.path.exists(env_path):
        with open(env_path) as f:
            for line in f:
                line = line.strip()
                if line and not line.startswith("#") and "=" in line:
                    key, value = line.split("=", 1)
                    os.environ.setdefault(key.strip(), value.strip())

load_env_file()
