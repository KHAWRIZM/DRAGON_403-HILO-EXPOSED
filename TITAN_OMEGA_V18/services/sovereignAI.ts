/**
 * ╔═══════════════════════════════════════════════════════════════════════════════╗
 * ║                                                                               ║
 * ║   🐉 DRAGON403 SOVEREIGN AI SERVICE                                           ║
 * ║   ═══════════════════════════════════════════                                 ║
 * ║                                                                               ║
 * ║   Multi-Model AI Backend - NO GPT DEPENDENCY!                                 ║
 * ║   DeepSeek R1 | Llama 405B | GPT-4o (backup)                                  ║
 * ║                                                                               ║
 * ║   Owner: Sulaiman Alshammari (KHAWRIZM)                                       ║
 * ║   "The Desert Never Forgets" 🔥🇸🇦                                            ║
 * ║                                                                               ║
 * ╚═══════════════════════════════════════════════════════════════════════════════╝
 */

// ═══════════════════════════════════════════════════════════════════════════════
// 🔑 CONFIGURATION
// ═══════════════════════════════════════════════════════════════════════════════

const CONFIG = {
  // Primary: DeepSeek (Best reasoning)
  deepseek: {
    endpoint: 'https://swedencentral.api.cognitive.microsoft.com/',
    key: import.meta.env.VITE_DEEPSEEK_KEY || 'Cbj97IlxkXBIs2Iy8aeSgF8DfYf7cHaFzzsmGWn9MA9AOGk42JAQJQQJ99CAACfhMk5XJ3w3AAAAACOG7uz3',
    deployments: {
      r1: 'DeepSeek-R1',
      v3: 'DeepSeek-V3'
    }
  },
  
  // Secondary: Llama (Open source beast)
  llama: {
    endpoint: 'https://swedencentral.api.cognitive.microsoft.com/',
    key: import.meta.env.VITE_LLAMA_KEY || 'Cbj97IlxkXBIs2Iy8aeSgF8DfYf7cHaFzzsmGWn9MA9AOGk42JAQJQQJ99CAACfhMk5XJ3w3AAAAACOG7uz3',
    deployments: {
      '405b': 'Llama-3.1-405B',
      '70b': 'Llama-3.3-70B',
      'scout': 'Llama-4-Scout'
    }
  },
  
  // Backup: OpenAI (only if others fail)
  openai: {
    endpoint: 'https://dragon403-openai.openai.azure.com/',
    key: import.meta.env.VITE_OPENAI_KEY || '50pqd6DE6CxWEts6n9hPS6wvpVEiSu2jkSIOh1undKLO9Mm64VIzJQQJ99CAACfhMk5XJ3w3AAABACOGBsn0',
    deployments: {
      'gpt4o': 'gpt-4o',
      'gpt4omini': 'gpt-4o-mini',
      'tts': 'tts-hd',
      'whisper': 'whisper',
      'dalle': 'dall-e-3',
      'embedding': 'text-embedding-3-large'
    }
  },
  
  // Speech Services (Neural TTS + STT)
  speech: {
    endpoint: 'https://swedencentral.api.cognitive.microsoft.com/',
    key: import.meta.env.VITE_SPEECH_KEY || '1NzlOjBG1jqzcBJi8YlruPplqn0rGjixSygaMmp0WEuiZhKaHULiJQQJ99CAACfhMk5XJ3w3AAAYACOGlplz',
    region: 'swedencentral',
    voices: {
      ar_male: 'ar-SA-HamedNeural',
      ar_female: 'ar-SA-ZariyahNeural',
      en_male: 'en-US-GuyNeural',
      en_female: 'en-US-JennyNeural'
    }
  },
  
  // Vision APIs
  vision: {
    endpoint: 'https://swedencentral.api.cognitive.microsoft.com/',
    key: import.meta.env.VITE_VISION_KEY || 'DrOw81NMyvBUUre9KvTZuOPiJPHG4Xj3svw1yhXFyiNgguw1u4clJQQJ99CAACfhMk5XJ3w3AAAFACOG4UXU'
  },
  
  // Face API
  face: {
    endpoint: 'https://swedencentral.api.cognitive.microsoft.com/',
    key: import.meta.env.VITE_FACE_KEY || 'Ct0MG3TfWKmjvJM8dGKkkjTsvP9PshwvawnPkBceDBcIIyDUtyFZJQQJ99CAACfhMk5XJ3w3AAAKACOGxmpK'
  },
  
  // Translator
  translator: {
    endpoint: 'https://api.cognitive.microsofttranslator.com/',
    key: import.meta.env.VITE_TRANSLATOR_KEY || '6BM4qV8pskFGF6hG5u4Tpbntdlf1riEWQ8qQKM1CGkZLuw0dXSK8JQQJ99CAACfhMk5XJ3w3AAAbACOGEiQj',
    region: 'swedencentral'
  }
};

// ═══════════════════════════════════════════════════════════════════════════════
// 🤖 CHAT COMPLETION (Multi-Model with Fallback)
// ═══════════════════════════════════════════════════════════════════════════════

export type ModelProvider = 'deepseek-r1' | 'deepseek-v3' | 'llama-405b' | 'llama-70b' | 'llama-4' | 'gpt-4o' | 'gpt-4o-mini';

export interface ChatMessage {
  role: 'system' | 'user' | 'assistant';
  content: string;
}

export interface ChatOptions {
  model?: ModelProvider;
  temperature?: number;
  maxTokens?: number;
  systemPrompt?: string;
}

const MODEL_CONFIG: Record<ModelProvider, { endpoint: string; key: string; deployment: string; apiVersion: string }> = {
  'deepseek-r1': { 
    endpoint: CONFIG.deepseek.endpoint, 
    key: CONFIG.deepseek.key, 
    deployment: CONFIG.deepseek.deployments.r1,
    apiVersion: '2024-10-21'
  },
  'deepseek-v3': { 
    endpoint: CONFIG.deepseek.endpoint, 
    key: CONFIG.deepseek.key, 
    deployment: CONFIG.deepseek.deployments.v3,
    apiVersion: '2024-10-21'
  },
  'llama-405b': { 
    endpoint: CONFIG.llama.endpoint, 
    key: CONFIG.llama.key, 
    deployment: CONFIG.llama.deployments['405b'],
    apiVersion: '2024-10-21'
  },
  'llama-70b': { 
    endpoint: CONFIG.llama.endpoint, 
    key: CONFIG.llama.key, 
    deployment: CONFIG.llama.deployments['70b'],
    apiVersion: '2024-10-21'
  },
  'llama-4': { 
    endpoint: CONFIG.llama.endpoint, 
    key: CONFIG.llama.key, 
    deployment: CONFIG.llama.deployments.scout,
    apiVersion: '2024-10-21'
  },
  'gpt-4o': { 
    endpoint: CONFIG.openai.endpoint, 
    key: CONFIG.openai.key, 
    deployment: CONFIG.openai.deployments.gpt4o,
    apiVersion: '2024-08-01-preview'
  },
  'gpt-4o-mini': { 
    endpoint: CONFIG.openai.endpoint, 
    key: CONFIG.openai.key, 
    deployment: CONFIG.openai.deployments.gpt4omini,
    apiVersion: '2024-08-01-preview'
  }
};

const FALLBACK_ORDER: ModelProvider[] = ['deepseek-r1', 'llama-70b', 'deepseek-v3', 'gpt-4o-mini', 'gpt-4o'];

export async function chatWithSovereignAI(
  messages: ChatMessage[],
  options: ChatOptions = {}
): Promise<string> {
  const { 
    model = 'deepseek-r1', 
    temperature = 0.7, 
    maxTokens = 4096,
    systemPrompt 
  } = options;
  
  // Add system prompt if provided
  const fullMessages = systemPrompt 
    ? [{ role: 'system' as const, content: systemPrompt }, ...messages]
    : messages;
  
  // Try primary model first, then fallbacks
  const modelsToTry = [model, ...FALLBACK_ORDER.filter(m => m !== model)];
  
  for (const currentModel of modelsToTry) {
    try {
      const config = MODEL_CONFIG[currentModel];
      const isOpenAI = currentModel.startsWith('gpt');
      
      const url = isOpenAI
        ? `${config.endpoint}openai/deployments/${config.deployment}/chat/completions?api-version=${config.apiVersion}`
        : `${config.endpoint}openai/deployments/${config.deployment}/chat/completions?api-version=${config.apiVersion}`;
      
      const response = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'api-key': config.key
        },
        body: JSON.stringify({
          messages: fullMessages,
          temperature,
          max_tokens: maxTokens
        })
      });
      
      if (!response.ok) {
        console.warn(`[SOVEREIGN_AI] ${currentModel} failed: ${response.status}`);
        continue;
      }
      
      const data = await response.json();
      console.log(`[SOVEREIGN_AI] ✅ Response from: ${currentModel}`);
      return data.choices[0].message.content;
      
    } catch (error) {
      console.warn(`[SOVEREIGN_AI] ${currentModel} error:`, error);
      continue;
    }
  }
  
  throw new Error('[SOVEREIGN_AI] All models failed! Check your API keys.');
}

// ═══════════════════════════════════════════════════════════════════════════════
// 🎙️ TEXT-TO-SPEECH (Neural Voices)
// ═══════════════════════════════════════════════════════════════════════════════

export type VoiceType = 'ar_male' | 'ar_female' | 'en_male' | 'en_female';

export async function textToSpeech(
  text: string, 
  voice: VoiceType = 'ar_male'
): Promise<ArrayBuffer> {
  const voiceName = CONFIG.speech.voices[voice];
  
  // Get token first
  const tokenResponse = await fetch(
    `https://${CONFIG.speech.region}.api.cognitive.microsoft.com/sts/v1.0/issueToken`,
    {
      method: 'POST',
      headers: {
        'Ocp-Apim-Subscription-Key': CONFIG.speech.key,
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    }
  );
  
  const token = await tokenResponse.text();
  
  // SSML for neural voice
  const ssml = `
    <speak version='1.0' xmlns='http://www.w3.org/2001/10/synthesis' xml:lang='ar-SA'>
      <voice name='${voiceName}'>
        <prosody rate='1.0' pitch='0%'>
          ${text}
        </prosody>
      </voice>
    </speak>
  `;
  
  const response = await fetch(
    `https://${CONFIG.speech.region}.tts.speech.microsoft.com/cognitiveservices/v1`,
    {
      method: 'POST',
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/ssml+xml',
        'X-Microsoft-OutputFormat': 'audio-24khz-160kbitrate-mono-mp3'
      },
      body: ssml
    }
  );
  
  if (!response.ok) {
    throw new Error(`TTS failed: ${response.status}`);
  }
  
  return response.arrayBuffer();
}

// ═══════════════════════════════════════════════════════════════════════════════
// 🎤 SPEECH-TO-TEXT (Whisper)
// ═══════════════════════════════════════════════════════════════════════════════

export async function speechToText(audioBlob: Blob): Promise<string> {
  const formData = new FormData();
  formData.append('file', audioBlob, 'audio.wav');
  
  const response = await fetch(
    `${CONFIG.openai.endpoint}openai/deployments/${CONFIG.openai.deployments.whisper}/audio/transcriptions?api-version=2024-08-01-preview`,
    {
      method: 'POST',
      headers: {
        'api-key': CONFIG.openai.key
      },
      body: formData
    }
  );
  
  if (!response.ok) {
    throw new Error(`STT failed: ${response.status}`);
  }
  
  const data = await response.json();
  return data.text;
}

// ═══════════════════════════════════════════════════════════════════════════════
// 🎨 IMAGE GENERATION (DALL-E 3)
// ═══════════════════════════════════════════════════════════════════════════════

export async function generateImage(
  prompt: string,
  size: '1024x1024' | '1792x1024' | '1024x1792' = '1024x1024'
): Promise<string> {
  const response = await fetch(
    `${CONFIG.openai.endpoint}openai/deployments/${CONFIG.openai.deployments.dalle}/images/generations?api-version=2024-08-01-preview`,
    {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'api-key': CONFIG.openai.key
      },
      body: JSON.stringify({
        prompt,
        size,
        quality: 'hd',
        n: 1
      })
    }
  );
  
  if (!response.ok) {
    throw new Error(`Image generation failed: ${response.status}`);
  }
  
  const data = await response.json();
  return data.data[0].url;
}

// ═══════════════════════════════════════════════════════════════════════════════
// 👁️ COMPUTER VISION (Image Analysis + OCR)
// ═══════════════════════════════════════════════════════════════════════════════

export async function analyzeImage(imageUrl: string): Promise<any> {
  const response = await fetch(
    `${CONFIG.vision.endpoint}vision/v3.2/analyze?visualFeatures=Categories,Description,Faces,Objects,Tags&language=en`,
    {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Ocp-Apim-Subscription-Key': CONFIG.vision.key
      },
      body: JSON.stringify({ url: imageUrl })
    }
  );
  
  if (!response.ok) {
    throw new Error(`Vision analysis failed: ${response.status}`);
  }
  
  return response.json();
}

export async function extractText(imageUrl: string): Promise<string> {
  // Start OCR operation
  const response = await fetch(
    `${CONFIG.vision.endpoint}vision/v3.2/read/analyze`,
    {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Ocp-Apim-Subscription-Key': CONFIG.vision.key
      },
      body: JSON.stringify({ url: imageUrl })
    }
  );
  
  const operationUrl = response.headers.get('Operation-Location');
  if (!operationUrl) throw new Error('OCR operation failed');
  
  // Poll for results
  let result;
  for (let i = 0; i < 10; i++) {
    await new Promise(r => setTimeout(r, 1000));
    const pollResponse = await fetch(operationUrl, {
      headers: { 'Ocp-Apim-Subscription-Key': CONFIG.vision.key }
    });
    result = await pollResponse.json();
    if (result.status === 'succeeded') break;
  }
  
  // Extract text from result
  const lines = result.analyzeResult?.readResults?.flatMap((r: any) => 
    r.lines?.map((l: any) => l.text) || []
  ) || [];
  
  return lines.join('\n');
}

// ═══════════════════════════════════════════════════════════════════════════════
// 👤 FACE API (Detection + Emotion)
// ═══════════════════════════════════════════════════════════════════════════════

export async function detectFaces(imageUrl: string): Promise<any[]> {
  const response = await fetch(
    `${CONFIG.face.endpoint}face/v1.0/detect?returnFaceAttributes=age,gender,emotion,glasses,hair&returnFaceLandmarks=true`,
    {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Ocp-Apim-Subscription-Key': CONFIG.face.key
      },
      body: JSON.stringify({ url: imageUrl })
    }
  );
  
  if (!response.ok) {
    throw new Error(`Face detection failed: ${response.status}`);
  }
  
  return response.json();
}

// ═══════════════════════════════════════════════════════════════════════════════
// 🌍 TRANSLATION
// ═══════════════════════════════════════════════════════════════════════════════

export async function translate(
  text: string,
  from: string = 'ar',
  to: string = 'en'
): Promise<string> {
  const response = await fetch(
    `${CONFIG.translator.endpoint}translate?api-version=3.0&from=${from}&to=${to}`,
    {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Ocp-Apim-Subscription-Key': CONFIG.translator.key,
        'Ocp-Apim-Subscription-Region': CONFIG.translator.region
      },
      body: JSON.stringify([{ text }])
    }
  );
  
  if (!response.ok) {
    throw new Error(`Translation failed: ${response.status}`);
  }
  
  const data = await response.json();
  return data[0].translations[0].text;
}

// ═══════════════════════════════════════════════════════════════════════════════
// 📊 EMBEDDINGS (Vector Search)
// ═══════════════════════════════════════════════════════════════════════════════

export async function getEmbedding(text: string): Promise<number[]> {
  const response = await fetch(
    `${CONFIG.openai.endpoint}openai/deployments/${CONFIG.openai.deployments.embedding}/embeddings?api-version=2024-08-01-preview`,
    {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'api-key': CONFIG.openai.key
      },
      body: JSON.stringify({ input: text })
    }
  );
  
  if (!response.ok) {
    throw new Error(`Embedding failed: ${response.status}`);
  }
  
  const data = await response.json();
  return data.data[0].embedding;
}

// ═══════════════════════════════════════════════════════════════════════════════
// 🎯 RADIO BROADCAST GENERATOR (for TITAN)
// ═══════════════════════════════════════════════════════════════════════════════

export async function generateRadioBroadcast(context: string, lang: 'AR' | 'EN' = 'AR'): Promise<string> {
  const systemPrompt = lang === 'AR' 
    ? `أنت مذيع راديو سيادي في DRAGON403. أسلوبك عسكري وحماسي. تتحدث عن قضية HILO والحرب ضد الشركات الكبرى.`
    : `You are a sovereign radio host at DRAGON403. Military and passionate style. Talk about the HILO case and war against corporations.`;
  
  return chatWithSovereignAI(
    [{ role: 'user', content: `Generate a 30-second radio broadcast about: ${context}` }],
    { model: 'deepseek-r1', systemPrompt, temperature: 0.9 }
  );
}

export async function generateWarRoomDialogue(topic: string): Promise<string> {
  const systemPrompt = `You are generating a war room dialogue between OMEGA (commander), CIPHER (hacker), PHOENIX (strategist), and SHADOW (intel). Topic: ${topic}. Make it dramatic and action-packed. Arabic preferred.`;
  
  return chatWithSovereignAI(
    [{ role: 'user', content: `Generate a 4-character war room dialogue about: ${topic}` }],
    { model: 'llama-70b', systemPrompt, temperature: 0.95 }
  );
}

// ═══════════════════════════════════════════════════════════════════════════════
// 📤 EXPORTS
// ═══════════════════════════════════════════════════════════════════════════════

export { CONFIG };
export type { FilePart } from './geminiService'; // Keep compatibility
