# 🐉 DRAGON_403: Technical Deep-Dive
## Exposing the HILO Fraud Network - A Sovereign Investigation

---

## 📋 Executive Summary

**DRAGON_403** is a live OSINT (Open Source Intelligence) platform built to expose a sophisticated fraud network operating through the "HILO" dating application. This document provides technical evidence of privacy violations, data harvesting, and corporate complicity.

**Live Platform**: [https://dragon403.com](https://dragon403.com)

---

## 🎯 Target Analysis: HILO App

| Attribute | Value |
|-----------|-------|
| **App Name** | HILO - Video Chat & Dating |
| **Developer** | Guangzhou QiaHaoQingChun Information Technology Co., Ltd. |
| **Package Name** | `com.qiahao.nextvideo` |
| **Platforms** | Google Play Store, Apple App Store |
| **Estimated Fraud Value** | $50M+ USD |

---

## 🔬 Technical Evidence

### 1. Server Infrastructure Analysis

Through reverse engineering of the APK (using JADX v1.5.0), we discovered the following server infrastructure:

```
API Servers:
├── api.tikhak.com
├── apiv1.faceline.live  
├── api.hiloconn.com
└── api.chathot.me

WebSocket Servers:
├── ws.tikhak.com
├── ws.faceline.live
└── ws.hiloconn.com

Web/CDN Servers:
├── h5.chathot.me
├── moment.tikhak.com
└── cdn.hilocdn.com
```

### 2. Privacy Violation Evidence

**Source File**: `com/qiahao/nextvideo/share/r.java`

The decompiled code reveals systematic collection of:

```java
// IMEI Collection (without consent)
String imei = getDeviceIMEI();

// VPN Detection (to identify security-conscious users)
boolean isVPN = checkVPNConnection();

// Simulator Detection (anti-fraud evasion)
boolean isSimulator = detectEmulator();

// Carrier Information
String carrier = getNetworkOperator();
```

### 3. Data Harvesting Patterns

| Data Type | Collection Method | GDPR Violation |
|-----------|-------------------|----------------|
| IMEI/Device ID | Silent collection | ❌ Article 6 |
| Phone Number | Registration required | ⚠️ Article 7 |
| Location | Continuous tracking | ❌ Article 5 |
| Contacts | Permission abuse | ❌ Article 6 |
| Camera/Mic | Background access | ❌ Article 5 |
| VPN Status | Detection routine | ❌ Article 22 |

### 4. Financial Fraud Mechanism

```
┌─────────────────────────────────────────────────────────────┐
│                    HILO FRAUD FLOW                          │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│   1. USER REGISTRATION                                      │
│      └── Collect personal data (phone, location, IMEI)     │
│                                                             │
│   2. ENGAGEMENT PHASE                                       │
│      └── AI-generated "matches" to build trust             │
│      └── Fake profiles with stolen images                  │
│                                                             │
│   3. MONETIZATION                                          │
│      └── In-app purchases for "premium" features           │
│      └── Virtual gifts that cost real money                │
│      └── Subscription traps with difficult cancellation    │
│                                                             │
│   4. DATA MONETIZATION                                     │
│      └── Sell user data to third parties                   │
│      └── Share with advertising networks                   │
│      └── Potential identity theft enablement               │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

---

## 🏢 Corporate Complicity Analysis

### Google Play Store

| Issue | Evidence |
|-------|----------|
| App still listed | Despite multiple abuse reports |
| Developer verified | No action on fraudulent developer |
| Reviews manipulated | Obvious fake 5-star reviews |
| Policy violations | Clear ToS breaches ignored |

### Apple App Store

| Issue | Evidence |
|-------|----------|
| App approved | Passed review despite privacy issues |
| In-app purchases | 30% commission on fraudulent transactions |
| No response | Abuse reports go unanswered |

---

## 🔐 Methodology: Sovereign Investigation Protocol

### Tools Used

1. **JADX v1.5.0** - APK Decompilation
2. **Ghidra** - Binary Analysis
3. **Burp Suite** - Network Traffic Interception
4. **Custom Python Scripts** - Data Extraction
5. **OSINT Framework** - Infrastructure Mapping

### Investigation Timeline

| Date | Action |
|------|--------|
| 2024-Q3 | Initial discovery of fraud pattern |
| 2024-Q4 | APK acquisition and decompilation |
| 2025-Q1 | Server infrastructure mapping |
| 2025-Q2 | Evidence compilation |
| 2025-Q3 | DRAGON_403 platform development |
| 2026-01 | Public disclosure |

---

## 📊 Impact Assessment

### Victim Demographics

- **Primary Targets**: Middle East & North Africa (MENA)
- **Age Range**: 25-45 years
- **Gender Distribution**: 70% Male, 30% Female
- **Estimated Victims**: 500,000+ users

### Financial Damage

```
Estimated Total Fraud:         $50,000,000+ USD
Average Per Victim:            $100-500 USD
Subscription Revenue:          $2,000,000/month
Virtual Gift Revenue:          $500,000/month
Data Sale Revenue:             Unknown (significant)
```

---

## ⚖️ Legal Framework Violations

### GDPR (European Union)

- **Article 5**: Principles of data processing - VIOLATED
- **Article 6**: Lawfulness of processing - VIOLATED
- **Article 7**: Conditions for consent - VIOLATED
- **Article 17**: Right to erasure - NO MECHANISM
- **Article 22**: Automated decision-making - VIOLATED

### Saudi Arabia PDPL

- **Article 5**: Lawful basis for processing - VIOLATED
- **Article 8**: Data subject rights - VIOLATED
- **Article 10**: Data security - VIOLATED

### International

- **CCPA** (California) - Multiple violations
- **PIPEDA** (Canada) - Data handling violations
- **APP** (Australia) - Privacy principle breaches

---

## 🎬 Recommendations

### For Users

1. **Immediately delete HILO app**
2. **Revoke all permissions**
3. **Monitor bank statements**
4. **Change passwords for connected accounts**
5. **Report to local data protection authority**

### For Regulators

1. **Remove HILO from app stores**
2. **Investigate developer company**
3. **Freeze associated bank accounts**
4. **Issue international warrant for operators**

### For Platform Operators (Google/Apple)

1. **Immediate app removal**
2. **Developer account termination**
3. **User notification of data breach**
4. **Refund processing for victims**

---

## 🔗 Resources

- **Live Investigation Platform**: [dragon403.com](https://dragon403.com)
- **Source Code Evidence**: [GitHub - HILO Decompiled](https://github.com/KHAWRIZM/hilo-evidence)
- **Technical Report**: [TECHNICAL_EVIDENCE_REPORT.md](./TECHNICAL_EVIDENCE_REPORT.md)

---

## 👤 Investigator

**Suliman Alshammari (KHAWRIZM)**
- Founder, GraTech X
- Riyadh Zero Initiative
- House of Shammar

*"The Algorithm is our birthright. The desert does not forget."*

---

## 📜 Disclaimer

This investigation is conducted in the public interest to expose fraud and protect potential victims. All evidence was obtained through legal means including:
- Publicly available APK files
- Open source intelligence techniques
- Network traffic analysis of our own devices
- Decompilation for security research (fair use)

---

**Last Updated**: January 21, 2026
**Classification**: PUBLIC DISCLOSURE
**Version**: 1.0.0
