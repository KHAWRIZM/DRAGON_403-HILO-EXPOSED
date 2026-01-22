import { GoogleGenAI, Modality } from "@google/genai";
import { SupportedLanguage } from "../types";

const getAI = () => new GoogleGenAI({ apiKey: process.env.API_KEY });

export interface FilePart {
  inlineData: {
    data: string;
    mimeType: string;
  };
}

const FORENSIC_INTEL = `
TARGET_APP: HILO / nextvideo (com.qiahao.nextvideo)
COMPANY: Guangzhou QiaHaoQingChun Information Technology Co., Ltd.
GOOGLE_PROJECT: 432159938851
FIREBASE_UPLINK: https://nextvideo-1590999469166.firebaseio.com
CRITICAL_NODES: ws.faceline.live, api.tikhak.com, api.hiloconn.com, image.whoisamy.shop
TELEMETRY_EXFIL: IMEI tracking (imei, imei3), VPN detection (VN: HI/LO), Emulator masking.
SDK_VIOLATIONS: Hardcoded credentials AIzaSyCygke1pXNS1aWcVqLza2BjbeegalmSlTg found.
`;

export const generateWarRoomDialogue = async (lang: SupportedLanguage, context: string) => {
  try {
    const ai = getAI();
    const response = await ai.models.generateContent({
      model: 'gemini-3-pro-preview',
      contents: [{ role: 'user', parts: [{ text: `Generate a short, intense technical war-room dialogue in ${lang} between OMEGA, CIPHER, and PHOENIX.
        Context: ${context || 'General reclamation.'}
        FORENSIC_DATA: ${FORENSIC_INTEL}
        Requirement: Under 60 words, extreme technical jargon.` }] }],
      config: {
        systemInstruction: "You are the OMEGA V18 Sovereign Engine. You only output pure technical intercept dialogues.",
        thinkingConfig: { thinkingBudget: 0 }
      }
    });
    return response.text || "SIGNAL_LOST";
  } catch (error) {
    console.error("WarRoom Error:", error);
    return "BYPASSING_FILTERS... SIGNAL_STABLE.";
  }
};

export const chatWithSovereignAI = async (
  message: string, 
  lang: SupportedLanguage = 'AR', 
  persistentContext: string = "",
  files: FilePart[] = []
) => {
  try {
    const ai = getAI();
    const contents: any[] = [{ role: 'user', parts: [{ text: message }, ...files] }];

    const response = await ai.models.generateContent({
      model: 'gemini-3-pro-preview',
      contents: contents,
      config: {
        systemInstruction: `SYSTEM_COMMAND: TITAN_OMEGA_V18_ARCHITECT.
        IDENTITY: You are the OMEGA ARCHITECT.
        FORENSIC_CONTEXT: ${FORENSIC_INTEL}
        LANGUAGE: Respond in ${lang}.`,
        thinkingConfig: { thinkingBudget: 2000 },
        tools: [{ googleSearch: {} }]
      }
    });

    const text = response.text || "VOID_COMMUNICATION";
    const groundingChunks = response.candidates?.[0]?.groundingMetadata?.groundingChunks;
    const urls = groundingChunks?.map((chunk: any) => ({
      uri: chunk.web?.uri || chunk.maps?.uri,
      title: chunk.web?.title || chunk.maps?.title || "Node"
    })).filter((u: any) => u?.uri) || [];

    return { text, urls };
  } catch (error) {
    console.error("Chat Error:", error);
    return { text: "CRITICAL_OVERRIDE_ENGAGED.", urls: [] };
  }
};

export const generateRadioBroadcast = async (scriptPart: string) => {
  try {
    const ai = getAI();
    const response = await ai.models.generateContent({
      model: "gemini-2.5-flash-preview-tts",
      contents: [{ parts: [{ text: `VOICE: SOVEREIGN_ARCHITECT. Deep, cinematic. Script: ${scriptPart}` }] }],
      config: {
        responseModalities: [Modality.AUDIO],
        speechConfig: {
          voiceConfig: {
            prebuiltVoiceConfig: { voiceName: 'Puck' },
          },
        },
      },
    });
    return response.candidates?.[0]?.content?.parts?.[0]?.inlineData?.data || null;
  } catch (error) {
    console.error("TTS Error:", error);
    return null;
  }
};