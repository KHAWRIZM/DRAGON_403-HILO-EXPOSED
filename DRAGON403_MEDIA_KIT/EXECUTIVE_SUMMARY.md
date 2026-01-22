# DRAGON_403: HILO FRAUD INVESTIGATION
## Executive Summary for Press & Legal Authorities

**Date:** January 21, 2026  
**Location:** Riyadh, Saudi Arabia  
**Investigator:** Suliman Nazal Alshammari (KHAWRIZM)  
**Total Damage:** SAR 600,000 (~USD $160,000)  
**Global Impact:** $50M+ stolen from victims worldwide

---

## THE CASE IN 60 SECONDS

A Saudi cybersecurity researcher who exposed Microsoft Hotmail infrastructure vulnerabilities in 2011 (vhotmail.com trophy) has documented a sophisticated fraud network operating through Apple App Store and Google Play Store with **full platform complicity**.

### The Core Problem:
- **Chinese company** (Guangzhou QiaHaoQingChun Information Technology Co., Ltd.) operates HILO app with malicious SDK
- **Apple/Google** approved apps containing GDPR-violating code (IMEI collection, VPN detection, carrier tracking)
- **Armed robbery victim** reported stolen iPhone to Apple - **request to lock account IGNORED**
- **Fraudulent transactions** of SAR 600,000 processed through Apple Pay while device tracked to Singapore
- **27 high-velocity transactions** for "TikTok Coins" and "HILO" in-app purchases - **NO fraud detection triggered**

---

## WHY THIS MATTERS

| Issue | Impact | Evidence |
|-------|--------|----------|
| **Platform Accountability** | Apple/Google approved SDK code violating GDPR Articles 5, 6, 32 | Decompiled source code |
| **Duty of Care Failure** | Apple refused to lock compromised account despite armed robbery report | Support ticket logs |
| **Global Scale** | 20+ apps in network, $50M+ stolen from victims worldwide | Transaction analysis |
| **Evidence Quality** | Full technical audit with decompiled SDK, server mapping, live website | dragon403.com |

---

## CURRENT STATUS

| Component | Status | Link |
|-----------|--------|------|
| Technical Documentation | ✅ LIVE | https://dragon403.com |
| Source Code Analysis | ✅ COMPLETE | Decompiled HILO SDK |
| Server Infrastructure | ✅ MAPPED | 4 active servers (HK, SG) |
| Ireland DPC Complaint | ⏳ READY | GDPR jurisdiction |
| Apple Legal Notice | ❌ EXPIRED | Sent Jan 17, no response |
| FBI IC3 Report | ⏳ READY | Cybercrime complaint |

---

## KEY EVIDENCE

### Company Identified
```
English:  Guangzhou QiaHaoQingChun Information Technology Co., Ltd.
Chinese:  广州俏好青春信息技术有限公司
Package:  com.qiahao.base_common
Location: Guangzhou, China
```

### Active Infrastructure
| Endpoint | IP Address | Status |
|----------|------------|--------|
| api.tikhak.com | 15.197.148.33 | 🟢 ACTIVE |
| api.hiloconn.com | 104.18.25.166 | 🟢 ACTIVE |
| ws.tikhak.com | WebSocket | 🟢 ACTIVE |
| h5.chathot.me | 170.33.8.126 | 🟢 ACTIVE |

### Privacy Violations (CRITICAL)
```java
// IMEI Collection - GDPR Article 5 Violation
newBuilder.addHeader("imei", getUuid());

// VPN Detection - Privacy Circumvention
isVPNConnected() → "HI"/"LO"

// Emulator Detection - Anti-Research
isEmulator() → 1/0

// Carrier Tracking - Article 5 Violation
addHeader("carrier", networkOperatorName);
```

---

## THE INVESTIGATOR

**Suliman Nazal Alshammari (KHAWRIZM)**

| Year | Achievement |
|------|-------------|
| 2011 | Exposed Microsoft Hotmail infrastructure (vhotmail.com) |
| 2011-2013 | Zone-H Archive: 1,979 verified defacements |
| 2024 | Victim of HILO fraud ($160K loss) |
| 2026 | Building COMET-X sovereign browser |

**Aliases:** Dr.DaShEr (1,904 defacements), Dr.StUaRt (75 defacements)  
**Contact:** iqd@hotmail.com (active)  
**Frozen Accounts:** v@hotmail.com, iqb@hotmail.com (Microsoft froze - badge of war)

---

## MEDIA CONTACT

| Channel | Link |
|---------|------|
| Investigation Portal | https://dragon403.com |
| GitHub Repository | https://github.com/KHAWRIZM/DRAGON_403-HILO-EXPOSED |
| Email | iqd@hotmail.com |
| CMA Reference | EXT27421 (October 23, 2024) |

---

## THE NARRATIVE

> "This is not revenge. This is documentation. The desert does not forget, and the algorithm is our birthright. We are not asking for a seat at their table. We are building a new table."

— **KHAWRIZM**, descendant of Al-Khwarizmi, Riyadh Zero

---

## CALL TO ACTION

1. **Journalists:** Review technical evidence at dragon403.com
2. **Regulators:** GDPR violations documented, complaint ready
3. **Security Researchers:** Verify findings - APK decompilation reproducible
4. **Victims:** Join the investigation - contact iqd@hotmail.com

---

*This document is part of the DRAGON_403 Media Kit - January 2026*
