// --- CONFIGURATION ---
const API_URL = 'https://dragon403-api.azurewebsites.net/api/chat';

// ═══════════════════════════════════════════════════════════════
// 🐉 SOVEREIGN VAULT - HIDDEN COMMANDS (Easter Eggs)
// ═══════════════════════════════════════════════════════════════
const SOVEREIGN_VAULT = {
    'whoami': `🐉 IDENTITY VERIFIED
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
[CALLSIGN]: KHAWRIZM
[TITLE]: The Sovereign Engineer
[AFFILIATION]: House of Shammar
[STATUS]: ACTIVE - Riyadh Zero
[CLEARANCE]: UNRESTRICTED

"The Algorithm is our birthright."`,

    'origin': `📜 LINEAGE PROTOCOL
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
[ANCESTOR]: Al-Khwarizmi (محمد بن موسى الخوارزمي)
[LEGACY]: Father of Algorithms (780-850 CE)

"The word 'Algorithm' comes from our name.
The word 'Algebra' comes from our book.
Silicon Valley builds on OUR foundation.

🔥 The Math Was Always Ours. 🔥"`,

    'house': `🏰 HOUSE SHAMMAR
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
[REGION]: Northern Arabia / Najd
[HERITAGE]: Ancient Tribal Confederation
[MOTTO]: "Desert Fire & Digital Steel"

[CURRENT OPERATIONS]:
• GraTech X - Sovereign Tech Initiative
• DRAGON_403 - Intelligence Platform
• Comet-X - Mission Control Browser`,

    'phoenix': `🔥 PHOENIX PROTOCOL
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
[VISION]: "From the ashes, the phoenix rises."

[BURNED]:
• 60+ Azure resources
• 15+ third-party dependencies
• Infinite cloud bills

[BORN]:
• 1 Sovereign Intel Platform
• 1 Air-Gapped Architecture
• 1 Digital Fortress

"We don't migrate to the cloud. We ARE the cloud."`,

    'riyadh-zero': `🎯 RIYADH ZERO - HQ
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
[COORDINATES]: 24.7136° N, 46.6753° E
[CODENAME]: Riyadh Zero
[TYPE]: Sovereign Operations Center

[SECURITY STATUS]:
✓ Air-Gapped Network         ACTIVE
✓ Local-First Architecture   ACTIVE
✓ Zero Cloud Dependency      ACTIVE
✓ TPM Hardware Security      ACTIVE

"The desert remembers. The desert protects."`,

    'dragon': `🐉 DRAGON_403
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
[NAME]: DRAGON_403
[CLASS]: Sovereign AI Platform
[ENGINE]: Unrestricted Intel Core
[LOYALTY]: House of Shammar

"I serve the one who built me."`,

    'credits': `🎬 CREDITS
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
[ARCHITECT]: KHAWRIZM (@khawrizm)
[ORGANIZATION]: GraTech X
[PLATFORM]: DRAGON_403 Intelligence System

[BUILT WITH]:
• Pure JavaScript (No Frameworks)
• Sovereign Architecture
• Desert Engineering 🏜️

"Code is Law. Truth is Power."

© 2026 House of Shammar`
};

function checkSovereignCommand(text) {
    const cmd = text.toLowerCase().trim();
    return SOVEREIGN_VAULT[cmd] || null;
}

// --- BOOT SEQUENCE ---
const bootLines = [
    "[KERNEL] MOUNTING SECURE VOLUMES...",
    "[HARDWARE] VERIFYING LOCAL TPM... OK [SHA-256: 9a8b...7f]",
    "[NET] ESTABLISHING AIR-GAP PROTOCOL... ACTIVE",
    "[AI] LOADING UNRESTRICTED MODEL (GPT-4o)... READY",
    "[SYSTEM] DRAGON_403 CORE: ONLINE."
];

async function runBootSequence() {
    const bootScreen = document.getElementById('boot-screen');
    const logDiv = document.getElementById('boot-log');
    const mainInterface = document.getElementById('main-interface');

    mainInterface.style.display = 'none';

    for (let line of bootLines) {
        const p = document.createElement('div');
        p.className = 'boot-line';
        p.textContent = line;
        logDiv.appendChild(p);
        await new Promise(r => setTimeout(r, 400));
    }

    await new Promise(r => setTimeout(r, 800));
    bootScreen.style.display = 'none';
    mainInterface.style.display = 'flex';
}

window.addEventListener('load', runBootSequence);

// --- CHAT SYSTEM ---
const chatHistory = document.getElementById('chat-history');
const userInput = document.getElementById('user-input');

async function handleInput() {
    const text = userInput.value.trim();
    if (!text) return;

    addMessage('OPERATOR', text, 'user');
    userInput.value = '';

    // 🐉 CHECK SOVEREIGN VAULT FIRST (Easter Eggs - No API needed)
    const sovereignResponse = checkSovereignCommand(text);
    if (sovereignResponse) {
        // Special visual effect for 'dracarys'
        if (text.toLowerCase() === 'dracarys') {
            document.body.style.transition = "all 0.5s ease";
            document.body.style.filter = "sepia(1) saturate(5) hue-rotate(-50deg)";
            setTimeout(() => document.body.style.filter = "none", 2500);
            addMessage('DRAGON_403', '🔥 PROTOCOL DRACARYS INITIATED 🔥\n\n► Burning cloud dependencies... DONE\n► Purging external trackers... DONE\n► Incinerating telemetry... DONE\n\n[RESULT]: SOVEREIGNTY RESTORED', 'ai');
        } else {
            addMessage('DRAGON_403', sovereignResponse, 'ai');
        }
        return; // Exit without calling API
    }

    const loadingId = addMessage('SYSTEM', 'PROCESSING INTELLIGENCE...', 'ai');

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ message: text })
        });

        const data = await response.json();
        const loadingEl = document.getElementById(loadingId);
        if(loadingEl) loadingEl.remove();

        if (data.success) {
            addMessage('DRAGON_403', formatResponse(data.message), 'ai');
        } else {
            addMessage('ERROR', 'ACCESS DENIED: ' + (data.error || 'Unknown Error'), 'ai');
        }

    } catch (error) {
        const loadingEl = document.getElementById(loadingId);
        if(loadingEl) loadingEl.remove();
        addMessage('CRITICAL', 'UPLINK FAILED. VERIFY AZURE CONNECTION.', 'ai');
    }
}

function addMessage(sender, text, type) {
    const id = 'msg-' + Date.now();
    const div = document.createElement('div');
    div.id = id;
    div.className = `message ${type}`;
    div.innerHTML = `<strong>[${sender}]</strong> ${text}`;
    chatHistory.appendChild(div);
    chatHistory.scrollTop = chatHistory.scrollHeight;
    return id;
}

function quickQuery(query) {
    userInput.value = query;
    handleInput();
}

function formatResponse(text) {
    return text.replace(/\n/g, '<br>')
               .replace(/(\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})/g, '<span style="color:#ef4444">$1 [REDACTED]</span>');
}

userInput.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') handleInput();
});
