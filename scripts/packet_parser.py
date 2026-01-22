#!/usr/bin/env python3
"""
╔═══════════════════════════════════════════════════════════════════════════════╗
║   🐉 DRAGON403 PACKET PARSER - CHINA HUNTER                                   ║
║   ═══════════════════════════════════════════════════════════════════════════ ║
║   Extracts sessions, cookies, and auth tokens from PCAP files                 ║
║   Target: china_direct.pcap (HILO WebSocket C2 Analysis)                      ║
║                                                                               ║
║   Owner: Sulaiman Alshammari (KHAWRIZM)                                       ║
║   Location: Sweden Server (4.223.108.167)                                     ║
║   "The Desert Never Forgets" 🔥🇸🇦                                            ║
╚═══════════════════════════════════════════════════════════════════════════════╝
"""

import os
import sys
import json
import re
import hashlib
from datetime import datetime
from collections import defaultdict
from pathlib import Path

try:
    from scapy.all import rdpcap, TCP, Raw, IP
    SCAPY_AVAILABLE = True
except ImportError:
    SCAPY_AVAILABLE = False
    print("⚠️  Scapy not installed. Run: pip install scapy")

# ═══════════════════════════════════════════════════════════════════════════════
# 🎯 TARGET CONFIGURATION
# ═══════════════════════════════════════════════════════════════════════════════

TARGETS = {
    "HILO_DOMAINS": [
        "faceline.live",
        "tikhak.com", 
        "hiloconn.com",
        "whoisamy.shop",
        "chathot.me",
    ],
    "CHINA_IPS": [
        "36.97.126.139",  # Main WebSocket C2
        "47.108.",        # Alibaba Cloud China
        "39.108.",        # Alibaba Cloud China
        "120.78.",        # Alibaba Cloud China
    ],
    "SESSION_PATTERNS": [
        r"Authorization:\s*Bearer\s+([A-Za-z0-9\-_\.]+)",
        r"Cookie:\s*([^\r\n]+)",
        r"Set-Cookie:\s*([^\r\n]+)",
        r"X-Auth-Token:\s*([A-Za-z0-9\-_\.]+)",
        r"X-Session-ID:\s*([A-Za-z0-9\-_]+)",
        r"token[\"']?\s*[:=]\s*[\"']?([A-Za-z0-9\-_\.]+)",
        r"sessionId[\"']?\s*[:=]\s*[\"']?([A-Za-z0-9\-_]+)",
        r"userId[\"']?\s*[:=]\s*[\"']?(\d+)",
        r"access_token[\"']?\s*[:=]\s*[\"']?([A-Za-z0-9\-_\.]+)",
    ],
    "WEBSOCKET_PATTERNS": [
        r"Sec-WebSocket-Key:\s*([A-Za-z0-9\+/=]+)",
        r"Sec-WebSocket-Accept:\s*([A-Za-z0-9\+/=]+)",
        r"Upgrade:\s*websocket",
    ],
}

# ═══════════════════════════════════════════════════════════════════════════════
# 📊 DATA STRUCTURES
# ═══════════════════════════════════════════════════════════════════════════════

class ForensicFinding:
    def __init__(self, category: str, source_ip: str, dest_ip: str, 
                 port: int, data: str, timestamp: str = None):
        self.category = category
        self.source_ip = source_ip
        self.dest_ip = dest_ip
        self.port = port
        self.data = data
        self.timestamp = timestamp or datetime.now().isoformat()
        self.hash = hashlib.sha256(f"{source_ip}{dest_ip}{data}".encode()).hexdigest()[:16]
    
    def to_dict(self):
        return {
            "category": self.category,
            "source_ip": self.source_ip,
            "dest_ip": self.dest_ip,
            "port": self.port,
            "data": self.data,
            "timestamp": self.timestamp,
            "evidence_hash": self.hash,
        }

# ═══════════════════════════════════════════════════════════════════════════════
# 🔍 PACKET ANALYSIS ENGINE
# ═══════════════════════════════════════════════════════════════════════════════

class DragonPacketParser:
    def __init__(self, pcap_path: str):
        self.pcap_path = pcap_path
        self.findings: list[ForensicFinding] = []
        self.sessions = defaultdict(list)
        self.cookies = []
        self.auth_tokens = []
        self.websocket_handshakes = []
        self.china_connections = []
        self.stats = {
            "total_packets": 0,
            "http_packets": 0,
            "websocket_packets": 0,
            "china_traffic": 0,
            "sessions_found": 0,
            "cookies_found": 0,
            "tokens_found": 0,
        }
    
    def is_china_ip(self, ip: str) -> bool:
        """Check if IP is from China target list"""
        for pattern in TARGETS["CHINA_IPS"]:
            if ip.startswith(pattern) or ip == pattern:
                return True
        return False
    
    def is_hilo_domain(self, data: str) -> bool:
        """Check if packet contains HILO domain references"""
        data_lower = data.lower()
        for domain in TARGETS["HILO_DOMAINS"]:
            if domain in data_lower:
                return True
        return False
    
    def extract_sessions(self, payload: str, src_ip: str, dst_ip: str, port: int):
        """Extract session tokens and auth headers"""
        for pattern in TARGETS["SESSION_PATTERNS"]:
            matches = re.findall(pattern, payload, re.IGNORECASE)
            for match in matches:
                if len(match) > 10:  # Filter short garbage
                    finding = ForensicFinding(
                        category="SESSION_TOKEN",
                        source_ip=src_ip,
                        dest_ip=dst_ip,
                        port=port,
                        data=match[:500],  # Truncate long tokens
                    )
                    self.findings.append(finding)
                    self.auth_tokens.append(finding.to_dict())
                    self.stats["tokens_found"] += 1
    
    def extract_cookies(self, payload: str, src_ip: str, dst_ip: str, port: int):
        """Extract cookies from HTTP headers"""
        cookie_patterns = [
            r"Cookie:\s*([^\r\n]+)",
            r"Set-Cookie:\s*([^\r\n]+)",
        ]
        for pattern in cookie_patterns:
            matches = re.findall(pattern, payload, re.IGNORECASE)
            for match in matches:
                finding = ForensicFinding(
                    category="COOKIE",
                    source_ip=src_ip,
                    dest_ip=dst_ip,
                    port=port,
                    data=match[:1000],
                )
                self.findings.append(finding)
                self.cookies.append(finding.to_dict())
                self.stats["cookies_found"] += 1
    
    def extract_websocket(self, payload: str, src_ip: str, dst_ip: str, port: int):
        """Extract WebSocket handshake information"""
        for pattern in TARGETS["WEBSOCKET_PATTERNS"]:
            if re.search(pattern, payload, re.IGNORECASE):
                finding = ForensicFinding(
                    category="WEBSOCKET_HANDSHAKE",
                    source_ip=src_ip,
                    dest_ip=dst_ip,
                    port=port,
                    data=payload[:2000],
                )
                self.findings.append(finding)
                self.websocket_handshakes.append(finding.to_dict())
                self.stats["websocket_packets"] += 1
                break
    
    def analyze_packet(self, packet):
        """Analyze a single packet"""
        self.stats["total_packets"] += 1
        
        if not packet.haslayer(TCP) or not packet.haslayer(Raw):
            return
        
        try:
            src_ip = packet[IP].src
            dst_ip = packet[IP].dst
            src_port = packet[TCP].sport
            dst_port = packet[TCP].dport
            payload = packet[Raw].load.decode('utf-8', errors='ignore')
            
            # Check for China traffic
            if self.is_china_ip(src_ip) or self.is_china_ip(dst_ip):
                self.stats["china_traffic"] += 1
                self.china_connections.append({
                    "src": src_ip,
                    "dst": dst_ip,
                    "src_port": src_port,
                    "dst_port": dst_port,
                    "preview": payload[:200],
                })
            
            # Check for HILO domain traffic
            if self.is_hilo_domain(payload):
                self.stats["http_packets"] += 1
                
                # Extract all forensic data
                self.extract_sessions(payload, src_ip, dst_ip, dst_port)
                self.extract_cookies(payload, src_ip, dst_ip, dst_port)
                self.extract_websocket(payload, src_ip, dst_ip, dst_port)
                
                # Track session flow
                session_key = f"{src_ip}:{src_port}->{dst_ip}:{dst_port}"
                self.sessions[session_key].append(payload[:500])
                self.stats["sessions_found"] = len(self.sessions)
        
        except Exception as e:
            pass  # Silently skip malformed packets
    
    def parse(self) -> dict:
        """Main parsing function"""
        if not SCAPY_AVAILABLE:
            return {"error": "Scapy not installed"}
        
        if not os.path.exists(self.pcap_path):
            return {"error": f"File not found: {self.pcap_path}"}
        
        print(f"\n🐉 DRAGON403 PACKET PARSER")
        print(f"{'='*60}")
        print(f"📁 Target: {self.pcap_path}")
        print(f"📊 Size: {os.path.getsize(self.pcap_path) / (1024*1024):.2f} MB")
        print(f"{'='*60}\n")
        
        print("⏳ Loading packets (this may take a while for large files)...")
        packets = rdpcap(self.pcap_path)
        
        print(f"📦 Loaded {len(packets)} packets. Analyzing...")
        
        for i, packet in enumerate(packets):
            self.analyze_packet(packet)
            if (i + 1) % 10000 == 0:
                print(f"   Processed {i+1}/{len(packets)} packets...")
        
        return self.generate_report()
    
    def generate_report(self) -> dict:
        """Generate forensic report"""
        report = {
            "metadata": {
                "tool": "DRAGON403 Packet Parser",
                "version": "1.0.0",
                "analyst": "KHAWRIZM",
                "timestamp": datetime.now().isoformat(),
                "target_file": self.pcap_path,
            },
            "statistics": self.stats,
            "findings": {
                "auth_tokens": self.auth_tokens,
                "cookies": self.cookies,
                "websocket_handshakes": self.websocket_handshakes,
                "china_connections": self.china_connections[:50],  # Limit output
            },
            "sessions": {k: v[:5] for k, v in list(self.sessions.items())[:20]},
            "summary": {
                "total_findings": len(self.findings),
                "unique_sessions": len(self.sessions),
                "china_traffic_detected": self.stats["china_traffic"] > 0,
                "risk_level": self._calculate_risk(),
            }
        }
        return report
    
    def _calculate_risk(self) -> str:
        """Calculate risk level based on findings"""
        score = 0
        score += self.stats["tokens_found"] * 10
        score += self.stats["cookies_found"] * 5
        score += self.stats["china_traffic"] * 2
        score += len(self.websocket_handshakes) * 8
        
        if score > 100:
            return "CRITICAL 🔴"
        elif score > 50:
            return "HIGH 🟠"
        elif score > 20:
            return "MEDIUM 🟡"
        else:
            return "LOW 🟢"

# ═══════════════════════════════════════════════════════════════════════════════
# 🎯 MAIN EXECUTION
# ═══════════════════════════════════════════════════════════════════════════════

def main():
    # Default paths for Sweden server
    pcap_paths = [
        "/root/sovereign_ops/vault/china_direct.pcap",
        "/root/china_direct.pcap",
        "./china_direct.pcap",
    ]
    
    # Check command line args
    if len(sys.argv) > 1:
        pcap_paths.insert(0, sys.argv[1])
    
    # Find the PCAP file
    pcap_file = None
    for path in pcap_paths:
        if os.path.exists(path):
            pcap_file = path
            break
    
    if not pcap_file:
        print("❌ PCAP file not found. Checked:")
        for p in pcap_paths:
            print(f"   - {p}")
        print("\nUsage: python3 packet_parser.py <path_to_pcap>")
        sys.exit(1)
    
    # Parse and analyze
    parser = DragonPacketParser(pcap_file)
    report = parser.parse()
    
    # Save report
    output_path = "/root/sovereign_ops/vault/pcap_analysis_report.json"
    if not os.path.exists(os.path.dirname(output_path)):
        output_path = "./pcap_analysis_report.json"
    
    with open(output_path, 'w', encoding='utf-8') as f:
        json.dump(report, f, indent=2, ensure_ascii=False)
    
    # Print summary
    print(f"\n{'='*60}")
    print("🐉 ANALYSIS COMPLETE")
    print(f"{'='*60}")
    print(f"📊 Total Packets:      {report['statistics']['total_packets']:,}")
    print(f"🇨🇳 China Traffic:      {report['statistics']['china_traffic']:,}")
    print(f"🔐 Auth Tokens Found:  {report['statistics']['tokens_found']}")
    print(f"🍪 Cookies Found:      {report['statistics']['cookies_found']}")
    print(f"🔌 WebSocket Sessions: {report['statistics']['websocket_packets']}")
    print(f"⚠️  Risk Level:         {report['summary']['risk_level']}")
    print(f"\n📁 Report saved to: {output_path}")
    print(f"{'='*60}\n")
    
    # Print critical findings
    if report['findings']['auth_tokens']:
        print("🚨 CRITICAL: Auth Tokens Captured!")
        for token in report['findings']['auth_tokens'][:5]:
            print(f"   [{token['source_ip']} → {token['dest_ip']}:{token['port']}]")
            print(f"   Data: {token['data'][:80]}...")
            print()

if __name__ == "__main__":
    main()
