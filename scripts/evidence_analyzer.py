#!/usr/bin/env python3
"""
╔═══════════════════════════════════════════════════════════════════════════════╗
║   🐉 DRAGON403 EVIDENCE ANALYZER                                              ║
║   ═══════════════════════════════════════════════════════════════════════════ ║
║   Analyzes extracted forensic text files from HILO APK decompilation          ║
║   Owner: Sulaiman Alshammari (KHAWRIZM)                                       ║
║   "The Desert Never Forgets" 🔥🇸🇦                                            ║
╚═══════════════════════════════════════════════════════════════════════════════╝
"""

import os
import re
import json
from datetime import datetime
from collections import defaultdict
from pathlib import Path

# ═══════════════════════════════════════════════════════════════════════════════
# 🎯 EVIDENCE PATTERNS
# ═══════════════════════════════════════════════════════════════════════════════

PATTERNS = {
    "google_api_key": r"AIza[0-9A-Za-z\-_]{35}",
    "google_project_id": r"\d{12}",
    "firebase_url": r"https://[a-zA-Z0-9\-]+\.firebase[a-z]+\.com",
    "facebook_app_id": r"facebook_app_id[\"']?\s*[:=]\s*[\"']?(\d{15,16})",
    "facebook_token": r"facebook_client_token[\"']?\s*[:=]\s*[\"']?([a-f0-9]{32})",
    "agora_key": r"[a-f0-9]{32}",
    "oppo_key": r"oppo_push_app_key[\"']?\s*[:=]\s*[\"']?([a-f0-9]{32})",
    "oppo_secret": r"oppo_push_app_secret[\"']?\s*[:=]\s*[\"']?([a-f0-9]{32})",
    "websocket_url": r"wss?://[a-zA-Z0-9.\-]+\.[a-z]{2,}[:/\w]*",
    "api_url": r"https?://api\.[a-zA-Z0-9.\-]+\.[a-z]{2,}[:/\w]*",
    "chinese_server": r"https?://[a-zA-Z0-9.\-]*\.(cn|com\.cn)[:/\w]*",
    "email": r"[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}",
    "ip_address": r"\b(?:\d{1,3}\.){3}\d{1,3}\b",
    "jwt_token": r"eyJ[A-Za-z0-9\-_]+\.eyJ[A-Za-z0-9\-_]+\.[A-Za-z0-9\-_]+",
    "bearer_token": r"Bearer\s+([A-Za-z0-9\-_\.]+)",
    "imei_collection": r"imei[0-9]*|getDeviceId|TelephonyManager",
    "vpn_detection": r"isVpn|VPN|detectVPN|vpnDetect",
    "emulator_detection": r"isEmulator|isSimulator|detectEmulator",
}

# Known HILO infrastructure
HILO_DOMAINS = [
    "faceline.live", "tikhak.com", "hiloconn.com", 
    "whoisamy.shop", "chathot.me", "iludo.live"
]

CHINA_IP_RANGES = ["36.97.", "47.108.", "39.108.", "120.78.", "121.40."]

# ═══════════════════════════════════════════════════════════════════════════════
# 📊 EVIDENCE COLLECTOR
# ═══════════════════════════════════════════════════════════════════════════════

class EvidenceAnalyzer:
    def __init__(self, vault_path: str = "/root/sovereign_ops/vault"):
        self.vault_path = Path(vault_path)
        self.findings = defaultdict(list)
        self.stats = defaultdict(int)
        self.critical_evidence = []
        
    def analyze_file(self, filepath: Path):
        """Analyze a single file for evidence"""
        try:
            with open(filepath, 'r', encoding='utf-8', errors='ignore') as f:
                content = f.read()
                
            filename = filepath.name
            
            for pattern_name, pattern in PATTERNS.items():
                matches = re.findall(pattern, content, re.IGNORECASE)
                for match in matches:
                    if isinstance(match, tuple):
                        match = match[0]
                    if len(str(match)) > 5:  # Filter noise
                        self.findings[pattern_name].append({
                            "value": str(match)[:200],
                            "source": filename,
                            "pattern": pattern_name
                        })
                        self.stats[pattern_name] += 1
            
            # Check for HILO domains
            for domain in HILO_DOMAINS:
                if domain in content.lower():
                    self.findings["hilo_domain"].append({
                        "value": domain,
                        "source": filename,
                        "context": self._extract_context(content, domain)
                    })
                    self.stats["hilo_domain"] += 1
            
            # Check for China IPs
            for ip_prefix in CHINA_IP_RANGES:
                if ip_prefix in content:
                    ips = re.findall(rf"{ip_prefix}\d{{1,3}}\.\d{{1,3}}", content)
                    for ip in ips:
                        self.findings["china_ip"].append({
                            "value": ip,
                            "source": filename
                        })
                        self.stats["china_ip"] += 1
                        
        except Exception as e:
            print(f"⚠️ Error analyzing {filepath}: {e}")
    
    def _extract_context(self, content: str, keyword: str, window: int = 50):
        """Extract surrounding context for a keyword"""
        idx = content.lower().find(keyword.lower())
        if idx == -1:
            return ""
        start = max(0, idx - window)
        end = min(len(content), idx + len(keyword) + window)
        return content[start:end].replace('\n', ' ')
    
    def analyze_vault(self):
        """Analyze all files in the vault"""
        print(f"\n🐉 DRAGON403 EVIDENCE ANALYZER")
        print(f"{'='*60}")
        print(f"📁 Vault: {self.vault_path}")
        print(f"{'='*60}\n")
        
        if not self.vault_path.exists():
            print(f"❌ Vault path not found: {self.vault_path}")
            return None
        
        files = list(self.vault_path.glob("*.txt")) + list(self.vault_path.glob("*.json"))
        print(f"📄 Found {len(files)} files to analyze\n")
        
        for filepath in files:
            print(f"   Analyzing: {filepath.name}")
            self.analyze_file(filepath)
        
        return self.generate_report()
    
    def generate_report(self):
        """Generate forensic report"""
        # Identify critical evidence
        critical_patterns = ["google_api_key", "agora_key", "jwt_token", "china_ip"]
        for pattern in critical_patterns:
            if self.findings[pattern]:
                self.critical_evidence.extend(self.findings[pattern][:5])
        
        report = {
            "metadata": {
                "tool": "DRAGON403 Evidence Analyzer",
                "version": "1.0.0",
                "analyst": "KHAWRIZM",
                "timestamp": datetime.now().isoformat(),
                "vault_path": str(self.vault_path),
            },
            "statistics": dict(self.stats),
            "critical_evidence": self.critical_evidence,
            "findings_by_category": {
                "credentials": {
                    "google_api_keys": self._unique(self.findings["google_api_key"]),
                    "agora_keys": self._unique(self.findings["agora_key"]),
                    "facebook_tokens": self._unique(self.findings["facebook_token"]),
                },
                "infrastructure": {
                    "websockets": self._unique(self.findings["websocket_url"]),
                    "api_endpoints": self._unique(self.findings["api_url"]),
                    "hilo_domains": self._unique(self.findings["hilo_domain"]),
                    "china_ips": self._unique(self.findings["china_ip"]),
                },
                "privacy_violations": {
                    "imei_collection": self.stats["imei_collection"],
                    "vpn_detection": self.stats["vpn_detection"],
                    "emulator_detection": self.stats["emulator_detection"],
                },
                "communication": {
                    "emails": self._unique(self.findings["email"]),
                }
            },
            "risk_assessment": self._assess_risk(),
            "legal_implications": self._legal_analysis(),
        }
        
        return report
    
    def _unique(self, items, max_items=20):
        """Get unique values from findings"""
        seen = set()
        unique = []
        for item in items:
            val = item.get("value", "")
            if val not in seen:
                seen.add(val)
                unique.append(item)
                if len(unique) >= max_items:
                    break
        return unique
    
    def _assess_risk(self):
        """Calculate risk level"""
        score = 0
        score += len(self.findings["google_api_key"]) * 15
        score += len(self.findings["agora_key"]) * 10
        score += len(self.findings["china_ip"]) * 8
        score += self.stats["imei_collection"] * 20
        score += self.stats["vpn_detection"] * 15
        
        if score > 100:
            return {"level": "CRITICAL", "score": score, "color": "🔴"}
        elif score > 50:
            return {"level": "HIGH", "score": score, "color": "🟠"}
        elif score > 20:
            return {"level": "MEDIUM", "score": score, "color": "🟡"}
        else:
            return {"level": "LOW", "score": score, "color": "🟢"}
    
    def _legal_analysis(self):
        """Generate legal implications"""
        violations = []
        
        if self.stats["imei_collection"] > 0:
            violations.append({
                "regulation": "GDPR Article 5",
                "violation": "Collection of device identifiers without consent",
                "severity": "HIGH"
            })
        
        if self.stats["vpn_detection"] > 0:
            violations.append({
                "regulation": "Privacy Laws",
                "violation": "Surveillance of user network configuration",
                "severity": "MEDIUM"
            })
        
        if len(self.findings["china_ip"]) > 0:
            violations.append({
                "regulation": "Data Localization Laws",
                "violation": "Potential unauthorized data transfer to China",
                "severity": "CRITICAL"
            })
        
        if len(self.findings["google_api_key"]) > 0:
            violations.append({
                "regulation": "Security Best Practices",
                "violation": "Hardcoded API credentials in application",
                "severity": "HIGH"
            })
        
        return violations


# ═══════════════════════════════════════════════════════════════════════════════
# 🎯 KNOWN HILO CREDENTIALS (From your extraction)
# ═══════════════════════════════════════════════════════════════════════════════

KNOWN_HILO_EVIDENCE = {
    "google": {
        "api_key": "AIzaSyCygke1pXNS1aWcVqLza2BjbeegalmSlTg",
        "project_id": "432159938851",
        "app_id": "1:432159938851:android:8adf65373a218409d59496",
        "firebase_url": "https://nextvideo-1590999469166.firebaseio.com",
        "storage_bucket": "nextvideo-1590999469166.appspot.com",
        "web_client_id": "432159938851-deoq0s10jrckc2krttv7ejeln5c60h69.apps.googleusercontent.com",
        "server_client_id": "432159938851-i474jljk2fl1g364ro64mivqsuah211f.apps.googleusercontent.com"
    },
    "facebook": {
        "app_id": "579294106051988",
        "client_token": "72f13ea96e1ec07be6c0196910aad5fd",
        "protocol_scheme": "fb579294106051988"
    },
    "agora": {
        "key_1": "6291d069123642d9929a49c734c50719",
        "key_2": "fc3e087f701b4f788099e1924c3cc7b0"
    },
    "oppo": {
        "push_app_key": "b73635b02b714b6691960b6c18418720",
        "push_app_secret": "c3ed4679caeb406480bb8285ded57872"
    },
    "baishun": {
        "app_id_debug": "2976487849",
        "app_id_release": "9870627708"
    },
    "crashlytics": {
        "mapping_file_id": "a896b4b6994341f18016c15db853901a"
    },
    "alibaba": {
        "sender_key": "56fc10fbe8c6ae7d0d895f49c4fb6838"
    },
    "infrastructure": {
        "domains": [
            "faceline.live",
            "tikhak.com", 
            "hiloconn.com",
            "whoisamy.shop",
            "chathot.me",
            "iludo.live"
        ],
        "china_c2": "36.97.126.139",
        "image_cdn": "https://image.whoisamy.shop"
    }
}


def main():
    # Try multiple vault paths
    vault_paths = [
        "/root/sovereign_ops/vault",
        "/home/kali/HelloApp_Decompiled",
        ".",
    ]
    
    vault_path = None
    for path in vault_paths:
        if os.path.exists(path):
            vault_path = path
            break
    
    if not vault_path:
        print("❌ No vault path found!")
        return
    
    analyzer = EvidenceAnalyzer(vault_path)
    report = analyzer.analyze_vault()
    
    if report:
        # Save report
        output_path = os.path.join(vault_path, "evidence_analysis_report.json")
        with open(output_path, 'w', encoding='utf-8') as f:
            json.dump(report, f, indent=2, ensure_ascii=False)
        
        # Also save known evidence
        known_path = os.path.join(vault_path, "known_hilo_credentials.json")
        with open(known_path, 'w', encoding='utf-8') as f:
            json.dump(KNOWN_HILO_EVIDENCE, f, indent=2, ensure_ascii=False)
        
        # Print summary
        print(f"\n{'='*60}")
        print("🐉 ANALYSIS COMPLETE")
        print(f"{'='*60}")
        print(f"📊 Total Patterns Found: {sum(report['statistics'].values())}")
        print(f"🔑 API Keys: {report['statistics'].get('google_api_key', 0)}")
        print(f"📡 Agora Keys: {report['statistics'].get('agora_key', 0)}")
        print(f"🇨🇳 China IPs: {report['statistics'].get('china_ip', 0)}")
        print(f"📱 IMEI Collection: {report['statistics'].get('imei_collection', 0)}")
        print(f"🔒 VPN Detection: {report['statistics'].get('vpn_detection', 0)}")
        print(f"\n⚠️  Risk Level: {report['risk_assessment']['level']} {report['risk_assessment']['color']}")
        print(f"⚖️  Legal Violations: {len(report['legal_implications'])}")
        print(f"\n📁 Report saved to: {output_path}")
        print(f"📁 Known credentials: {known_path}")
        print(f"{'='*60}\n")
        
        # Print critical evidence
        if report['critical_evidence']:
            print("🚨 CRITICAL EVIDENCE:")
            for ev in report['critical_evidence'][:10]:
                print(f"   [{ev.get('pattern', 'unknown')}] {ev.get('value', '')[:60]}...")


if __name__ == "__main__":
    main()
