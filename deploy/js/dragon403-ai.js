// --- CONFIGURATION ---
const API_URL = 'https://dragon403-api.azurewebsites.net/api/chat';

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
