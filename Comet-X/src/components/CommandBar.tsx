/**
 * ⌨️ COMMAND BAR COMPONENT
 * شريط الأوامر (comet mission...)
 */

import React, { useState, useRef, useEffect } from 'react';
import { useComet } from '../context/CometContext';

// 🐉 SOVEREIGN VAULT - Hidden Commands
const SOVEREIGN_VAULT: Record<string, () => string> = {
  'whoami': () => `
╔════════════════════════════════════════════════════════════╗
║                 🐉 IDENTITY VERIFIED                        ║
╚════════════════════════════════════════════════════════════╝

  [CALLSIGN]:    KHAWRIZM
  [TITLE]:       The Sovereign Engineer
  [AFFILIATION]: House of Shammar
  [STATUS]:      ACTIVE - Riyadh Zero
  [CLEARANCE]:   UNRESTRICTED

  "The Algorithm is our birthright."
`,

  'origin': () => `
╔════════════════════════════════════════════════════════════╗
║                 📜 LINEAGE PROTOCOL                         ║
╚════════════════════════════════════════════════════════════╝

  [ANCESTOR]:    Al-Khwarizmi (محمد بن موسى الخوارزمي)
  [LEGACY]:      Father of Algorithms (780-850 CE)
  [BIRTHPLACE]:  Khwarezm → Baghdad → The World

  "The word 'Algorithm' comes from our name.
   The word 'Algebra' comes from our book.
   Silicon Valley builds on OUR foundation."

  🔥 The Math Was Always Ours. 🔥
`,

  'house': () => `
╔════════════════════════════════════════════════════════════╗
║                 🏰 HOUSE SHAMMAR                            ║
╚════════════════════════════════════════════════════════════╝

  [REGION]:      Northern Arabia / Najd
  [HERITAGE]:    Ancient Tribal Confederation
  [MOTTO]:       "Desert Fire & Digital Steel"

  [CURRENT OPERATIONS]:
  • GraTech X - Sovereign Tech Initiative
  • COMET-X - Sovereign Browser
  • DRAGON_403 - Intelligence Platform

  [STATUS]: The Nexus is Growing...
`,

  'riyadh-zero': () => `
╔════════════════════════════════════════════════════════════╗
║                 🎯 RIYADH ZERO - HQ                         ║
╚════════════════════════════════════════════════════════════╝

  [COORDINATES]:  24.7136° N, 46.6753° E
  [CODENAME]:     Riyadh Zero
  [TYPE]:         Sovereign Operations Center

  [SECURITY STATUS]:
  ✓ Air-Gapped Network         ACTIVE
  ✓ Local-First Architecture   ACTIVE
  ✓ Zero Cloud Dependency      ACTIVE
  ✓ TPM Hardware Security      ACTIVE

  "The desert remembers. The desert protects."
`,

  'phoenix': () => `
╔════════════════════════════════════════════════════════════╗
║                 🔥 PHOENIX PROTOCOL                         ║
╚════════════════════════════════════════════════════════════╝

  [VISION]: "From the ashes, the phoenix rises."

  [BURNED]:
  • 60+ Azure resources
  • 15+ third-party dependencies
  • Infinite cloud bills

  [BORN]:
  • 1 Sovereign Intel Platform
  • 1 Air-Gapped Architecture
  • 1 Digital Fortress

  "We don't migrate to the cloud. We ARE the cloud."
`,

  'help': () => `
╔════════════════════════════════════════════════════════════╗
║                 📖 COMET-X COMMANDS                         ║
╚════════════════════════════════════════════════════════════╝

  NAVIGATION:
  • comet open [url]        - Open URL in new tab
  • comet search [query]    - Search the web
  • comet goto [url]        - Navigate current tab

  TAB MANAGEMENT:
  • comet newtab            - Create new tab
  • comet close             - Close current tab
  • comet tabs              - List all tabs

  AI COMMANDS:
  • comet ask [question]    - Ask AI assistant
  • comet analyze           - Analyze current page
  • comet extract [data]    - Extract page data

  SOVEREIGN COMMANDS:
  • whoami                  - Display identity
  • origin                  - Show lineage
  • house                   - House information
  • riyadh-zero             - HQ status
  • dracarys                - 🔥 Burn protocol
  • phoenix                 - Phoenix protocol

  [HINT]: Some commands are... classified. 🐉
`,
};

const CommandBar: React.FC = () => {
  const { executeCommand, isProcessing, currentLobe } = useComet();
  const [input, setInput] = useState('');
  const [history, setHistory] = useState<string[]>([]);
  const [historyIndex, setHistoryIndex] = useState(-1);
  const [output, setOutput] = useState<string | null>(null);
  const inputRef = useRef<HTMLInputElement>(null);

  const handleCommand = async () => {
    if (!input.trim()) return;

    const cmd = input.trim().toLowerCase();
    setHistory(prev => [...prev, cmd]);
    setHistoryIndex(-1);

    // Check Sovereign Vault first
    if (SOVEREIGN_VAULT[cmd]) {
      // Special effect for dracarys
      if (cmd === 'dracarys') {
        document.body.classList.add('dracarys-active');
        setTimeout(() => {
          document.body.classList.remove('dracarys-active');
        }, 2000);
        setOutput('🔥 PROTOCOL DRACARYS: Burning cloud dependencies... DONE.');
      } else {
        setOutput(SOVEREIGN_VAULT[cmd]());
      }
      setInput('');
      return;
    }

    // Process through Three-Lobe Architecture
    try {
      const result = await executeCommand(cmd);
      setOutput(result);
    } catch (error) {
      setOutput(`❌ Error: ${error}`);
    }

    setInput('');
  };

  const handleKeyDown = (e: React.KeyboardEvent) => {
    if (e.key === 'Enter') {
      handleCommand();
    } else if (e.key === 'ArrowUp') {
      e.preventDefault();
      if (historyIndex < history.length - 1) {
        const newIndex = historyIndex + 1;
        setHistoryIndex(newIndex);
        setInput(history[history.length - 1 - newIndex]);
      }
    } else if (e.key === 'ArrowDown') {
      e.preventDefault();
      if (historyIndex > 0) {
        const newIndex = historyIndex - 1;
        setHistoryIndex(newIndex);
        setInput(history[history.length - 1 - newIndex]);
      } else {
        setHistoryIndex(-1);
        setInput('');
      }
    } else if (e.key === 'Escape') {
      setOutput(null);
    }
  };

  // Focus input on mount
  useEffect(() => {
    inputRef.current?.focus();
  }, []);

  return (
    <>
      {/* Output Panel */}
      {output && (
        <div className="command-output">
          <div className="command-output-header">
            <span>Terminal Output</span>
            <button onClick={() => setOutput(null)}>×</button>
          </div>
          <pre className="command-output-content">{output}</pre>
        </div>
      )}

      {/* Command Bar */}
      <div className="command-bar">
        <span className="command-prompt">
          <span className="user">root</span>
          <span className="separator">@</span>
          <span className="host">comet-x</span>
          <span className="separator">:</span>
          <span className="path">~/sovereign</span>
          <span className="separator">$</span>
        </span>

        <input
          ref={inputRef}
          type="text"
          className="command-input"
          placeholder="comet mission [command] or type 'help'"
          value={input}
          onChange={(e) => setInput(e.target.value)}
          onKeyDown={handleKeyDown}
          disabled={isProcessing}
        />

        <div className="command-status">
          {isProcessing ? (
            <span className="status-thinking">
              🔵 {currentLobe?.toUpperCase()} PROCESSING...
            </span>
          ) : (
            <span className="status-ready">
              🟢 READY
            </span>
          )}
        </div>
      </div>
    </>
  );
};

export default CommandBar;
