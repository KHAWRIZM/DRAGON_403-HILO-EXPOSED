
import React from 'react';
import { StrikeStatus, LegalStrike, Evidence, Priority, Case, SupportedLanguage } from './types';

export const TRANSLATIONS: Record<SupportedLanguage, any> = {
  AR: {
    wolf_proverb: "السيادة الرقمية هي السلاح الوحيد ضد نفاق السحابة",
    action_quote: "حيث تنتهي اشتراكاتكم، تبدأ سيادتنا المطلقة",
    arsenal: "الترسانة السيادية V18",
    dashboard: "مركز قيادة الأحرار",
    status: "الحالة: استقلال تام",
    threat: "مستوى الردع العميق",
    uplink: "اتصال الأوميغا",
    thinking: "تفكيك البنية التحتية للمنافقين...",
    execute: "تنفيذ",
    upload: "رفع ملفات تقنية",
    radio_mode_truth: "بث الحقيقة",
    radio_mode_music: "موسيقى الحرب",
    deploy_strike: "نشر ضربة سيادية",
    infra: "البنية التحتية",
    command: "مركز القيادة",
    mesh: "الشبكة المستقلة",
    tools: "الأدوات التقنية"
  },
  EN: {
    wolf_proverb: "Digital sovereignty is the only weapon against cloud hypocrisy",
    action_quote: "Where your subscriptions end, our absolute sovereignty begins",
    arsenal: "Sovereign Arsenal V18",
    dashboard: "Free Peoples Command Center",
    status: "Status: Absolute Autonomy",
    threat: "Deep Deterrence Level",
    uplink: "Omega Uplink",
    thinking: "Deconstructing Hypocrite Infrastructure...",
    execute: "EXECUTE",
    upload: "UPLOAD TECHNICAL FILES",
    radio_mode_truth: "TRUTH BROADCAST",
    radio_mode_music: "WAR MUSIC",
    deploy_strike: "DEPLOY SOVEREIGN STRIKE",
    infra: "INFRASTRUCTURE",
    command: "COMMAND CENTER",
    mesh: "SOVEREIGN MESH",
    tools: "TECHNICAL TOOLS"
  },
  ZH: { wolf_proverb: "数字主权是对抗云端虚伪的唯一武器", action_quote: "主权由此开始", arsenal: "主权军械库", dashboard: "指挥基地", status: "状态：独立", threat: "威慑级别", uplink: "欧米茄链路", thinking: "正在解构...", execute: "执行", upload: "上传文件", radio_mode_truth: "真相广播", radio_mode_music: "战争音乐", deploy_strike: "部署打击", infra: "基础设施", command: "指挥", mesh: "网格", tools: "工具" },
  RU: { wolf_proverb: "Цифровой суверенитет — оружие против лицемерия", action_quote: "Начинается суверенитет", arsenal: "Арсенал", dashboard: "База", status: "Статус: Независим", threat: "Уровень сдерживания", uplink: "Омега", thinking: "Деконструкция...", execute: "ВЫПОЛНИТЬ", upload: "ЗАГРУЗИТЬ", radio_mode_truth: "ПРАВДА", radio_mode_music: "МУЗЫКА", deploy_strike: "УДАР", infra: "Инфраструктура", command: "Команда", mesh: "Сеть", tools: "Инструменты" },
  ES: { wolf_proverb: "La soberanía digital es el arma", action_quote: "Soberanía absoluta", arsenal: "Arsenal", dashboard: "Base", status: "Estado: Independiente", threat: "Disuasión", uplink: "Omega", thinking: "Desconstruyendo...", execute: "EJECUTAR", upload: "SUBIR", radio_mode_truth: "VERDAD", radio_mode_music: "MÚSICA", deploy_strike: "GOLPE", infra: "Infra", command: "Mando", mesh: "Malla", tools: "Herramientas" },
  FR: { wolf_proverb: "La souveraineté numérique est l'arme", action_quote: "Souveraineté absolue", arsenal: "Arsenal", dashboard: "Base", status: "Statut : Indépendant", threat: "Dissuasion", uplink: "Omega", thinking: "Déconstruction...", execute: "EXÉCUTER", upload: "CHARGER", radio_mode_truth: "VÉRITÉ", radio_mode_music: "MUSIQUE", deploy_strike: "FRAPPE", infra: "Infra", command: "Commande", mesh: "Maillage", tools: "Outils" },
  JA: { wolf_proverb: "デジタル主権は武器である", action_quote: "絶対的主権", arsenal: "アーセナル", dashboard: "基地", status: "ステータス：独立", threat: "抑止レベル", uplink: "オメガ", thinking: "解体中...", execute: "実行", upload: "アップロード", radio_mode_truth: "真実", radio_mode_music: "音楽", deploy_strike: "ストライク", infra: "インフラ", command: "コマンド", mesh: "メッシュ", tools: "ツール" },
  DE: { wolf_proverb: "Digitale Souveränität ist die Waffe", action_quote: "Absolute Souveränität", arsenal: "Arsenal", dashboard: "Basis", status: "Status: Unabhängig", threat: "Abschreckung", uplink: "Omega", thinking: "Dekonstruktion...", execute: "AUSFÜHREN", upload: "HOCHLADEN", radio_mode_truth: "WAHRHEIT", radio_mode_music: "MUSIK", deploy_strike: "SCHLAG", infra: "Infra", command: "Kommando", mesh: "Netz", tools: "Werkzeuge" },
  TR: { wolf_proverb: "Dijital egemenlik silahtır", action_quote: "Mutlak egemenlik", arsenal: "Arsenal", dashboard: "Üs", status: "Durum: Bağımsız", threat: "Caydırıcılık", uplink: "Omega", thinking: "Bozuluyor...", execute: "ÇALIŞTIR", upload: "YÜKLE", radio_mode_truth: "GERÇEK", radio_mode_music: "MÜZİK", deploy_strike: "DARBE", infra: "Altyapı", command: "Komut", mesh: "Ağ", tools: "Araçlar" },
  HI: { wolf_proverb: "डिजिटल संप्रभुता हथियार है", action_quote: "पूर्ण संप्रभुता", arsenal: "शस्त्रागार", dashboard: "बेस", status: "स्थिति: स्वतंत्र", threat: "निवारण", uplink: "ओमेगा", thinking: "विखंडन...", execute: "चलाएं", upload: "अपलोड", radio_mode_truth: "सच्चाई", radio_mode_music: "संगीत", deploy_strike: "स्ट्राइक", infra: "बुनियादी ढांचा", command: "कमान", mesh: "मेश", tools: "उपकरण" },
  PT: { wolf_proverb: "Soberania digital é a arma", action_quote: "Soberania absoluta", arsenal: "Arsenal", dashboard: "Base", status: "Estado: Independente", threat: "Dissuasão", uplink: "Omega", thinking: "Desconstruindo...", execute: "EXECUTAR", upload: "SUBIR", radio_mode_truth: "VERDADE", radio_mode_music: "MÚSICA", deploy_strike: "GOLPE", infra: "Infra", command: "Comando", mesh: "Malha", tools: "Ferramentas" }
};

export const INITIAL_CASES: Case[] = [
  { 
    id: 'CASE-SOVEREIGN-V18', 
    title: "TITAN OMEGA V18 ARCHITECT", 
    description: "Full infrastructure reclamation protocol. Neutralizing corporate data exfiltration." 
  }
];

export const INITIAL_STRIKES: LegalStrike[] = [
  {
    id: 'strike-v18-01',
    entity: 'Global Telemetry Reclamation',
    platform: 'Sovereign Core V18',
    status: StrikeStatus.COMPLETED,
    timestamp: '2026-02-14 04:03 AM',
    description: "Corporate tracking node identified and neutralized. Sovereignty established.",
    type: 'LEGAL',
    priority: Priority.HIGH,
    caseId: 'CASE-SOVEREIGN-V18'
  }
];

export const ICONS = {
  Terminal: () => (
    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"><polyline points="4 17 10 11 4 5"></polyline><line x1="12" y1="19" x2="20" y2="19"></line></svg>
  ),
  Shield: () => (
    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"><path d="M12 22s8-4 8-10V5l-8-3-8 3v7c0 6 8 10 8 10z"></path></svg>
  ),
  File: () => (
    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
  ),
  Activity: () => (
    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"><polyline points="22 12 18 12 15 21 9 3 6 12 2 12"></polyline></svg>
  ),
  Plus: () => (
    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"><line x1="12" y1="5" x2="12" y2="19"></line><line x1="5" y1="12" x2="19" y2="12"></line></svg>
  ),
  Star: ({ filled }: { filled?: boolean }) => (
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill={filled ? "currentColor" : "none"} stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"><polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"></polygon></svg>
  ),
  Globe: () => (
    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"><circle cx="12" cy="12" r="10"></circle><line x1="2" y1="12" x2="22" y2="12"></line><path d="M12 2a15.3 15.3 0 0 1 4 10 15.3 15.3 0 0 1-4 10 15.3 15.3 0 0 1-4-10 15.3 15.3 0 0 1 4-10z"></path></svg>
  )
};
