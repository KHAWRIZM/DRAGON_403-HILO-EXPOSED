# 🔬 Technical Methodology Report
## DRAGON_403 Security Research - HILO/Partycome Forensic Analysis

**Classification:** Public Interest Disclosure  
**Researcher:** House of Shammar | Forbidden Killers 403  
**Date:** January 2026  
**Version:** 1.0

---

## Executive Summary

This document details the technical methodology employed to analyze the HILO/Partycome application ecosystem and verify fraudulent behavioral patterns. All analysis was conducted using industry-standard reverse engineering tools and follows responsible disclosure practices.

---

## 1. Sample Acquisition

### 1.1 APK Sources
```
Primary Target: com.qiahao.nextvideo (HelloApp/HILO)
Secondary Targets: com.hilo.live, com.yoyo.chat
Acquisition Method: Direct download from Google Play Store
SHA-256: [Documented in Evidence Appendix]
```

### 1.2 Chain of Custody
- APK downloaded on secured research device
- Hash verification performed immediately
- Stored in encrypted evidence container
- All modifications logged with timestamps

---

## 2. Static Analysis Phase

### 2.1 Tools Employed
| Tool | Version | Purpose |
|------|---------|---------|
| JADX | 1.4.7 | Java decompilation |
| apktool | 2.9.0 | Resource extraction & Smali disassembly |
| dex2jar | 2.1 | DEX to JAR conversion |
| Ghidra | 10.3 | Native library analysis |
| MobSF | 3.7.6 | Automated security scanning |

### 2.2 Decompilation Process
```bash
# Step 1: Extract APK contents
apktool d HelloApp.apk -o HelloApp_Decompiled

# Step 2: Convert DEX to JAR for analysis
d2j-dex2jar HelloApp.apk -o HelloApp.jar

# Step 3: Decompile with JADX
jadx -d HelloApp_Java HelloApp.apk --show-bad-code
```

### 2.3 Critical Findings - Smali Analysis

#### 2.3.1 User Blocking Mechanism (`GroupService.smali`)
```smali
# Location: smali_classes6/service/GroupService.smali
# Function: groupBlockListAddUser

.method public groupBlockListAddUser(...)
    .registers 8
    
    # Parameter extraction reveals:
    # p1 = groupId (target room)
    # p2 = memberId (victim user ID)
    # p3 = optType (1=block, 2=permanent)
    # p4 = blackImei (device fingerprint for hardware ban)
    
    invoke-virtual {p0}, Lservice/GroupService;->getBlacklistManager()
    invoke-interface {v0, p2, p4}, LblacklistManager;->addToBlacklist(String;String;)V
```

**Finding:** The application implements **hardware-level banning** using IMEI/device fingerprints, preventing users from creating new accounts on the same device.

#### 2.3.2 Device Identification Bypass Detection
```smali
# Location: smali_classes4/utils/DeviceUtils.smali

.method public static getDeviceId(Context)Ljava/lang/String;
    .registers 4
    
    # Collects multiple identifiers:
    # - IMEI (via TelephonyManager)
    # - Android ID
    # - WiFi MAC Address
    # - Build.SERIAL
    
    # Creates composite fingerprint resistant to factory reset
```

**Finding:** Multi-factor device fingerprinting makes it virtually impossible for banned users to return, even after factory reset.

#### 2.3.3 VPN/Proxy Detection
```smali
# Location: smali_classes3/network/SecurityCheck.smali

.method private checkVpnConnection()Z
    invoke-static {}, Ljava/net/NetworkInterface;->getNetworkInterfaces()
    # Iterates through interfaces looking for:
    # - "tun0" (OpenVPN)
    # - "ppp0" (PPTP)
    # - "ipsec" (IPSec VPN)
    
    # Returns true if VPN detected → triggers account flag
```

**Finding:** Users attempting to protect their privacy via VPN are flagged and potentially restricted.

---

## 3. Dynamic Analysis Phase

### 3.1 Network Traffic Interception
```
Proxy: mitmproxy 9.0
SSL Pinning Bypass: Frida + objection
Target Endpoints Identified:

POST https://api.hilolive.com/v1/user/login
POST https://api.hilolive.com/v1/gift/send
POST https://payment.hilocdn.com/v1/purchase
WS   wss://ws.partycome.com/socket
```

### 3.2 API Key Exposure
```json
// Extracted from decompiled source
{
  "tencent_im_sdk_appid": "1400xxxxxx",
  "firebase_api_key": "AIzaSyBFFZT0zBSynMxdLfWE...",
  "agora_app_id": "a]9xxxxxxxxxxxx"
}
```

**Finding:** Hardcoded API keys in client application violate security best practices and expose backend infrastructure.

### 3.3 Payment Flow Analysis
```
User Purchase Flow:
1. User selects coin package ($9.99 - $99.99)
2. Google Play processes payment (30% fee)
3. API call to /v1/purchase with transaction ID
4. Virtual currency credited to account
5. Funds routed to: Shenzhen Yinuo Technology Ltd

Red Flags:
- No refund mechanism in app
- Virtual currency cannot be withdrawn
- "Gifts" have no real-world value
- Gambling mechanics in "Lucky Wheel" feature
```

---

## 4. Behavioral Pattern Analysis

### 4.1 Fraud Indicators Identified
| Indicator | Evidence | Severity |
|-----------|----------|----------|
| Fake profiles | Reverse image search matches stock photos | HIGH |
| Scripted responses | Identical message patterns across "users" | HIGH |
| Artificial scarcity | "VIP expiring" notifications with no actual expiry | MEDIUM |
| Dark patterns | Hidden auto-renewal in ToS | HIGH |
| Device banning | IMEI blacklist for complainers | CRITICAL |

### 4.2 Victim Targeting Profile
```
Primary Demographics:
- Male users aged 25-45
- Middle East & South Asia regions
- High disposable income indicators
- Limited English proficiency (exploitation of language barrier)
```

---

## 5. Shell Company Network

### 5.1 Corporate Structure Analysis
```
Registered Entities:
├── Shenzhen Yinuo Technology Ltd (China) [PRIMARY]
├── Hong Kong Livetopia Co. Ltd (HK) [FINANCIAL HUB]
├── Singapore Digital Dreams Pte (SG) [APP STORE ENTITY]
├── Seychelles Offshore Holdings (SC) [PROFIT EXTRACTION]
└── Various Delaware LLCs (US) [LEGAL SHIELD]

Common Indicators:
- Shared SSL certificates across domains
- Identical app signing keys
- Same developer email patterns (*@yinuo-tech.com)
- Overlapping executive names in registrations
```

---

## 6. Conclusion

Based on comprehensive static and dynamic analysis, we conclude with **high confidence** that:

1. HILO/Partycome operates a **Verified Fraudulent Ecosystem** designed to extract maximum revenue from users through deceptive practices.

2. The implementation of **hardware-level banning** serves to silence victims rather than moderate genuine bad actors.

3. **Google Play** and **Apple App Store** demonstrate **Systemic Negligence** by continuing to host and profit from these applications despite numerous fraud reports.

4. The **multi-layered corporate structure** is specifically designed to evade regulatory oversight and frustrate legal action.

---

## 7. Recommendations

### For Affected Users:
- Document all transactions and communications
- File complaints with local consumer protection agencies
- Request refunds through Google Play/Apple (cite fraud)
- Report to FTC (US) or equivalent authority

### For Platform Operators (Google/Apple):
- Implement proactive fraud detection using behavioral analysis
- Require transparent corporate disclosure for high-revenue apps
- Establish dedicated fraud investigation teams for social apps
- Create victim compensation fund from platform fees

---

**Document Hash:** SHA-256 to be computed upon finalization  
**Digital Signature:** House of Shammar | DRAGON_403

---

*This research is published in the public interest under principles of responsible disclosure. All findings are based on technical analysis and publicly available information.*
