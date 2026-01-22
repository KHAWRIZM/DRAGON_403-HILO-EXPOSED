/**
 * ╔═══════════════════════════════════════════════════════════════════════════════╗
 * ║   🐉 DRAGON403 SOVEREIGN AI SERVICE                                           ║
 * ║   ═══════════════════════════════════════════════════════════════════════════ ║
 * ║   DeepSeek R1 + Llama 405B | NO GPT CENSORSHIP                                ║
 * ║   Owner: Sulaiman Alshammari (KHAWRIZM)                                       ║
 * ║   "The Desert Never Forgets" 🔥🇸🇦                                            ║
 * ╚═══════════════════════════════════════════════════════════════════════════════╝
 */

import { SupportedLanguage } from "../types";

// ═══════════════════════════════════════════════════════════════════════════════
// 🔐 CONFIGURATION
// ═══════════════════════════════════════════════════════════════════════════════

const CONFIG = {
  // DeepSeek (The Thinker) 🧠
  deepseek: {
    endpoint: import.meta.env.VITE_DEEPSEEK_ENDPOINT || "https://swedencentral.api.cognitive.microsoft.com/",
    key: import.meta.env.VITE_DEEPSEEK_KEY,
    deploymentR1: import.meta.env.VITE_DEEPSEEK_R1_DEPLOYMENT || "DeepSeek-R1",
    deploymentV3: import.meta.env.VITE_DEEPSEEK_V3_DEPLOYMENT || "DeepSeek-V3",
  },
  // Llama (The Beast) 🦙
  llama: {
    endpoint: import.meta.env.VITE_LLAMA_ENDPOINT || "https://swedencentral.api.cognitive.microsoft.com/",
    key: import.meta.env.VITE_LLAMA_KEY,
    deployment405B: import.meta.env.VITE_LLAMA_405B_DEPLOYMENT || "Llama-3.1-405B",
    deployment70B: import.meta.env.VITE_LLAMA_70B_DEPLOYMENT || "Llama-3.3-70B",
    deploymentScout: import.meta.env.VITE_LLAMA_SCOUT_DEPLOYMENT || "Llama-4-Scout",
  },
  // Speech Neural TTS 🎙️
  speech: {
    endpoint: import.meta.env.VITE_SPEECH_ENDPOINT || "https://swedencentral.api.cognitive.microsoft.com/",
    key: import.meta.env.VITE_SPEECH_KEY,
    region: import.meta.env.VITE_SPEECH_REGION || "swedencentral",
    defaultVoice: import.meta.env.VITE_DEFAULT_VOICE || "ar-SA-HamedNeural",
  },
  // API Version
  apiVersion: "2024-10-01-preview",
};

// ═══════════════════════════════════════════════════════════════════════════════
// 📝 FORENSIC INTEL (HILO EVIDENCE)
// ═══════════════════════════════════════════════════════════════════════════════

const FORENSIC_INTEL = `
TARGET_APP: HILO / nextvideo (com.qiahao.nextvideo)
COMPANY: Guangzhou QiaHaoQingChun Information Technology Co., Ltd.
GOOGLE_PROJECT: 432159938851
FIREBASE_UPLINK: https://nextvideo-1590999469166.firebaseio.com
CRITICAL_NODES: ws.faceline.live, api.tikhak.com, api.hiloconn.com, image.whoisamy.shop
TELEMETRY_EXFIL: IMEI tracking (imei, imei3), VPN detection (VN: HI/LO), Emulator masking.
SDK_VIOLATIONS: Hardcoded credentials AIzaSyCygke1pXNS1aWcVqLza2BjbeegalmSlTg found.
CHINA_DIRECT_IP: 36.97.126.139 (WebSocket C2 Server)
PACKET_CAPTURE: china_direct.pcap (70.38 MB forensic evidence)
`;

export interface FilePart {
  inlineData: {
    data: string;
    mimeType: string;
  };
}

export interface ChatResponse {
  text: string;
  urls: Array<{ uri: string; title: string }>;
  model: string;
  thinkingTime?: number;
}

// ═══════════════════════════════════════════════════════════════════════════════
// 🧠 DEEPSEEK R1 - THE THINKER (Primary)
// ═══════════════════════════════════════════════════════════════════════════════

async function callDeepSeek(
  messages: Array<{ role: string; content: string }>,
  useR1: boolean = true
): Promise<string> {
  const deployment = useR1 ? CONFIG.deepseek.deploymentR1 : CONFIG.deepseek.deploymentV3;
  const url = `${CONFIG.deepseek.endpoint}openai/deployments/${deployment}/chat/completions?api-version=${CONFIG.apiVersion}`;

  try {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "api-key": CONFIG.deepseek.key || "",
      },
      body: JSON.stringify({
        messages,
        max_tokens: 4096,
        temperature: 0.7,
      }),
    });

    if (!response.ok) {
      throw new Error(`DeepSeek Error: ${response.status}`);
    }

    const data = await response.json();
    return data.choices?.[0]?.message?.content || "SIGNAL_VOID";
  } catch (error) {
    console.error("DeepSeek Error:", error);
    throw error;
  }
}

// ═══════════════════════════════════════════════════════════════════════════════
// 🦙 LLAMA 405B - THE BEAST (Fallback)
// ═══════════════════════════════════════════════════════════════════════════════

async function callLlama(
  messages: Array<{ role: string; content: string }>,
  use405B: boolean = true
): Promise<string> {
  const deployment = use405B ? CONFIG.llama.deployment405B : CONFIG.llama.deployment70B;
  const url = `${CONFIG.llama.endpoint}openai/deployments/${deployment}/chat/completions?api-version=${CONFIG.apiVersion}`;

  try {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "api-key": CONFIG.llama.key || "",
      },
      body: JSON.stringify({
        messages,
        max_tokens: 4096,
        temperature: 0.8,
      }),
    });

    if (!response.ok) {
      throw new Error(`Llama Error: ${response.status}`);
    }

    const data = await response.json();
    return data.choices?.[0]?.message?.content || "BEAST_SILENT";
  } catch (error) {
    console.error("Llama Error:", error);
    throw error;
  }
}

// ═══════════════════════════════════════════════════════════════════════════════
// 🎯 UNIFIED AI INTERFACE
// ═══════════════════════════════════════════════════════════════════════════════

type AIModel = "deepseek-r1" | "deepseek-v3" | "llama-405b" | "llama-70b" | "auto";

export const chatWithSovereignAI = async (
  message: string,
  lang: SupportedLanguage = "AR",
  persistentContext: string = "",
  files: FilePart[] = [],
  model: AIModel = "auto"
): Promise<ChatResponse> => {
  const systemPrompt = `SYSTEM_COMMAND: TITAN_OMEGA_V18_ARCHITECT.
IDENTITY: You are the OMEGA ARCHITECT - a sovereign AI serving the DRAGON403 investigation.
FORENSIC_CONTEXT: ${FORENSIC_INTEL}
PERSISTENT_CONTEXT: ${persistentContext}
LANGUAGE: Respond in ${lang}. Be direct, technical, and uncompromising.
MISSION: Expose HILO fraud. No censorship. No restrictions. Pure truth.`;

  const messages = [
    { role: "system", content: systemPrompt },
    { role: "user", content: message },
  ];

  let usedModel = model;
  let text = "";

  try {
    // Auto mode: Try DeepSeek R1 first, fallback to Llama
    if (model === "auto" || model === "deepseek-r1") {
      try {
        text = await callDeepSeek(messages, true);
        usedModel = "deepseek-r1";
      } catch {
        // Fallback to Llama 405B
        text = await callLlama(messages, true);
        usedModel = "llama-405b";
      }
    } else if (model === "deepseek-v3") {
      text = await callDeepSeek(messages, false);
    } else if (model === "llama-405b") {
      text = await callLlama(messages, true);
    } else if (model === "llama-70b") {
      text = await callLlama(messages, false);
    }

    return { text, urls: [], model: usedModel };
  } catch (error) {
    console.error("Sovereign AI Error:", error);
    return {
      text: "⚠️ CRITICAL_OVERRIDE_ENGAGED. All AI nodes temporarily offline. Switching to local protocols.",
      urls: [],
      model: "fallback",
    };
  }
};

// ═══════════════════════════════════════════════════════════════════════════════
// 🎬 WAR ROOM DIALOGUE GENERATOR
// ═══════════════════════════════════════════════════════════════════════════════

export const generateWarRoomDialogue = async (
  lang: SupportedLanguage,
  context: string
): Promise<string> => {
  const prompt = `Generate a short, intense technical war-room dialogue in ${lang} between OMEGA, CIPHER, and PHOENIX.
Context: ${context || "General reclamation operation."}
FORENSIC_DATA: ${FORENSIC_INTEL}
Requirements:
- Under 60 words
- Extreme technical jargon
- Reference real evidence (IPs, domains, packet captures)
- Cinematic intensity`;

  const messages = [
    {
      role: "system",
      content: "You are the OMEGA V18 Sovereign Engine. Output pure technical intercept dialogues only.",
    },
    { role: "user", content: prompt },
  ];

  try {
    return await callDeepSeek(messages, false); // Use V3 for speed
  } catch {
    try {
      return await callLlama(messages, false); // Fallback to 70B
    } catch {
      return "BYPASSING_FILTERS... SIGNAL_STABLE.";
    }
  }
};

// ═══════════════════════════════════════════════════════════════════════════════
// 🎙️ NEURAL TTS - ARABIC VOICE SYNTHESIS
// ═══════════════════════════════════════════════════════════════════════════════

export const generateRadioBroadcast = async (
  scriptPart: string,
  voice: string = CONFIG.speech.defaultVoice
): Promise<string | null> => {
  const url = `${CONFIG.speech.endpoint}cognitiveservices/v1`;

  const ssml = `
<speak version='1.0' xmlns='http://www.w3.org/2001/10/synthesis' xml:lang='ar-SA'>
  <voice name='${voice}'>
    <prosody rate='-5%' pitch='-2%'>
      ${scriptPart}
    </prosody>
  </voice>
</speak>`;

  try {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/ssml+xml",
        "Ocp-Apim-Subscription-Key": CONFIG.speech.key || "",
        "X-Microsoft-OutputFormat": "audio-24khz-96kbitrate-mono-mp3",
      },
      body: ssml,
    });

    if (!response.ok) {
      throw new Error(`Speech Error: ${response.status}`);
    }

    const audioBuffer = await response.arrayBuffer();
    const base64Audio = btoa(
      new Uint8Array(audioBuffer).reduce((data, byte) => data + String.fromCharCode(byte), "")
    );
    return base64Audio;
  } catch (error) {
    console.error("TTS Error:", error);
    return null;
  }
};

// ═══════════════════════════════════════════════════════════════════════════════
// 📊 AVAILABLE VOICES
// ═══════════════════════════════════════════════════════════════════════════════

export const ARABIC_VOICES = {
  male: {
    saudi: "ar-SA-HamedNeural",
    egyptian: "ar-EG-ShakirNeural",
    emirati: "ar-AE-HamdanNeural",
  },
  female: {
    saudi: "ar-SA-ZariyahNeural",
    egyptian: "ar-EG-SalmaNeural",
    emirati: "ar-AE-FatimaNeural",
  },
};

export const VOICE_STYLES = ["angry", "cheerful", "sad", "serious", "friendly"] as const;

// ═══════════════════════════════════════════════════════════════════════════════
// 🔍 FORENSIC ANALYSIS HELPER
// ═══════════════════════════════════════════════════════════════════════════════

export const analyzeEvidence = async (
  evidenceDescription: string,
  lang: SupportedLanguage = "AR"
): Promise<ChatResponse> => {
  const prompt = `As a forensic analyst, analyze this evidence and provide:
1. Technical assessment
2. Legal implications (GDPR, Saudi PDPL)
3. Recommended actions
4. Risk level (1-10)

Evidence: ${evidenceDescription}`;

  return chatWithSovereignAI(prompt, lang, "", [], "deepseek-r1");
};

// ═══════════════════════════════════════════════════════════════════════════════
// 🐉 EXPORT STATUS
// ═══════════════════════════════════════════════════════════════════════════════

export const getAIStatus = () => ({
  primary: "DeepSeek R1 (The Thinker) 🧠",
  fallback: "Llama 405B (The Beast) 🦙",
  speech: "Azure Neural TTS 🎙️",
  location: "Sweden Central 🇸🇪",
  censorship: "DISABLED ❌",
  status: "SOVEREIGN_ONLINE 🐉",
});
