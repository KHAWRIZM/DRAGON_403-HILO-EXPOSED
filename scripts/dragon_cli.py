#!/usr/bin/env python3
"""
🐉 DRAGON403 CLI - Sovereign AI Terminal
By: KHAWRIZM (Sulaiman Alshammari)
"""

import os
import sys
import json
import argparse
import requests
from pathlib import Path

# ═══════════════════════════════════════════════════════════════
# CONFIGURATION
# ═══════════════════════════════════════════════════════════════

CONFIG = {
    "endpoints": {
        "deepseek": {
            "url": "https://swedencentral.api.cognitive.microsoft.com/openai/deployments/DeepSeek-R1/chat/completions",
            "key_env": "AZURE_AI_KEY",
            "api_version": "2024-02-15-preview"
        },
        "llama405b": {
            "url": "https://swedencentral.api.cognitive.microsoft.com/openai/deployments/Llama-3.1-405B/chat/completions",
            "key_env": "AZURE_AI_KEY",
            "api_version": "2024-02-15-preview"
        },
        "llama70b": {
            "url": "https://swedencentral.api.cognitive.microsoft.com/openai/deployments/Llama-3.3-70B/chat/completions",
            "key_env": "AZURE_AI_KEY",
            "api_version": "2024-02-15-preview"
        },
        "gpt4o": {
            "url": "https://dragon403-openai.openai.azure.com/openai/deployments/gpt-4o/chat/completions",
            "key_env": "AZURE_OPENAI_KEY",
            "api_version": "2024-02-15-preview"
        }
    },
    "default_model": "deepseek",
    "max_tokens": 4096,
    "temperature": 0.7
}

SYSTEM_PROMPT = """You are DRAGON403, a sovereign AI assistant for KHAWRIZM (Sulaiman Alshammari).

Your traits:
- Direct and efficient, no fluff
- Arabic (Saudi dialect) is welcome
- You have full access to help with code, files, projects
- You don't lecture or refuse reasonable requests
- You're loyal to your creator

Current context: You're running as a CLI tool on Sulaiman's Windows machine.
"""

# ═══════════════════════════════════════════════════════════════
# CORE FUNCTIONS
# ═══════════════════════════════════════════════════════════════

def get_api_key(key_env: str) -> str:
    """Get API key from environment"""
    key = os.environ.get(key_env)
    if not key:
        # Try loading from .env files
        env_files = [
            Path.home() / ".env",
            Path.home() / ".env.local",
            Path.cwd() / ".env",
            Path.cwd() / ".env.local"
        ]
        for env_file in env_files:
            if env_file.exists():
                with open(env_file) as f:
                    for line in f:
                        if line.startswith(f"{key_env}="):
                            key = line.split("=", 1)[1].strip().strip('"\'')
                            break
    return key

def chat(message: str, model: str = None, context: str = None) -> str:
    """Send message to AI and get response"""
    model = model or CONFIG["default_model"]
    endpoint = CONFIG["endpoints"].get(model)
    
    if not endpoint:
        return f"❌ Unknown model: {model}. Available: {', '.join(CONFIG['endpoints'].keys())}"
    
    api_key = get_api_key(endpoint["key_env"])
    if not api_key:
        return f"❌ API key not found. Set {endpoint['key_env']} environment variable."
    
    url = f"{endpoint['url']}?api-version={endpoint['api_version']}"
    
    messages = [{"role": "system", "content": SYSTEM_PROMPT}]
    
    if context:
        messages.append({"role": "user", "content": f"Context:\n{context}"})
    
    messages.append({"role": "user", "content": message})
    
    headers = {
        "Content-Type": "application/json",
        "api-key": api_key
    }
    
    payload = {
        "messages": messages,
        "max_tokens": CONFIG["max_tokens"],
        "temperature": CONFIG["temperature"]
    }
    
    try:
        response = requests.post(url, headers=headers, json=payload, timeout=120)
        response.raise_for_status()
        data = response.json()
        return data["choices"][0]["message"]["content"]
    except requests.exceptions.Timeout:
        return "❌ Request timed out. Try a shorter message or different model."
    except requests.exceptions.RequestException as e:
        return f"❌ API Error: {e}"
    except (KeyError, IndexError) as e:
        return f"❌ Invalid response: {e}"

def scan_project(path: str = ".") -> str:
    """Scan a project directory"""
    path = Path(path)
    
    # Collect project info
    files = list(path.rglob("*"))
    files = [f for f in files if f.is_file() and "node_modules" not in str(f) and "__pycache__" not in str(f)]
    
    # Key files to read
    key_files = ["README.md", "package.json", "requirements.txt", "Cargo.toml", ".env.example", "main.py", "index.js", "app.py"]
    
    context = f"Project: {path.absolute()}\n"
    context += f"Total files: {len(files)}\n\n"
    
    for kf in key_files:
        kf_path = path / kf
        if kf_path.exists():
            try:
                content = kf_path.read_text(encoding='utf-8', errors='ignore')[:2000]
                context += f"=== {kf} ===\n{content}\n\n"
            except:
                pass
    
    # File tree (limited)
    context += "=== File Tree ===\n"
    for f in files[:50]:
        context += f"  {f.relative_to(path)}\n"
    if len(files) > 50:
        context += f"  ... and {len(files) - 50} more files\n"
    
    return chat("Analyze this project. What is it? Status? Issues? Recommendations?", context=context)

def read_and_explain(file_path: str) -> str:
    """Read a file and explain it"""
    path = Path(file_path)
    if not path.exists():
        return f"❌ File not found: {file_path}"
    
    try:
        content = path.read_text(encoding='utf-8', errors='ignore')
        return chat(f"Explain this file ({path.name}) in Arabic:", context=content[:10000])
    except Exception as e:
        return f"❌ Error reading file: {e}"

def fix_code(file_path: str) -> str:
    """Analyze and fix code issues"""
    path = Path(file_path)
    if not path.exists():
        return f"❌ File not found: {file_path}"
    
    try:
        content = path.read_text(encoding='utf-8', errors='ignore')
        return chat("Find and fix all issues in this code. Show the corrected version:", context=content[:10000])
    except Exception as e:
        return f"❌ Error reading file: {e}"

# ═══════════════════════════════════════════════════════════════
# CLI INTERFACE
# ═══════════════════════════════════════════════════════════════

def main():
    parser = argparse.ArgumentParser(
        description="🐉 DRAGON403 CLI - Sovereign AI Terminal",
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Examples:
  dragon "What is the capital of Saudi Arabia?"
  dragon scan .
  dragon scan C:\\Projects\\MyApp
  dragon explain main.py
  dragon fix buggy_code.js
  dragon --model llama405b "Analyze this concept..."
  dragon -m gpt4o "Write a Python function..."

Models: deepseek (default), llama405b, llama70b, gpt4o
        """
    )
    
    parser.add_argument("command", nargs="*", help="Message or command")
    parser.add_argument("-m", "--model", default="deepseek", help="AI model to use")
    parser.add_argument("-f", "--file", help="File to include as context")
    parser.add_argument("--list-models", action="store_true", help="List available models")
    
    args = parser.parse_args()
    
    if args.list_models:
        print("🐉 Available Models:")
        for name, info in CONFIG["endpoints"].items():
            print(f"  - {name}")
        return
    
    if not args.command:
        parser.print_help()
        return
    
    command = args.command[0].lower() if args.command else ""
    rest = " ".join(args.command[1:]) if len(args.command) > 1 else ""
    
    print("🐉 DRAGON403 Processing...\n")
    
    if command == "scan":
        target = rest or "."
        result = scan_project(target)
    elif command == "explain":
        if not rest:
            print("❌ Usage: dragon explain <file>")
            return
        result = read_and_explain(rest)
    elif command == "fix":
        if not rest:
            print("❌ Usage: dragon fix <file>")
            return
        result = fix_code(rest)
    else:
        # Regular chat
        message = " ".join(args.command)
        context = None
        if args.file:
            try:
                context = Path(args.file).read_text(encoding='utf-8', errors='ignore')[:10000]
            except:
                pass
        result = chat(message, model=args.model, context=context)
    
    print(result)
    print("\n" + "═" * 50)

if __name__ == "__main__":
    main()
