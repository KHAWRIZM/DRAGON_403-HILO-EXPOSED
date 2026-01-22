# PRESS RELEASE
## FOR IMMEDIATE RELEASE

**Contact:** iqd@hotmail.com  
**Website:** https://dragon403.com  
**Date:** January 21, 2026  
**Location:** Riyadh, Saudi Arabia

---

# CYBERSECURITY RESEARCHER EXPOSES $160K FRAUD ENABLED BY APPLE/GOOGLE APP STORE NEGLIGENCE

### Saudi Engineer Who Exposed Hotmail Vulnerabilities in 2011 Documents Systematic Platform Complicity in Chinese Fraud Network

---

**RIYADH, SAUDI ARABIA** — Suliman Alshammari (KHAWRIZM), the cybersecurity researcher who exposed Microsoft Hotmail infrastructure vulnerabilities in 2011, has released a comprehensive technical investigation documenting how Apple and Google enabled a Chinese-operated fraud network to steal over $160,000 from a single victim—despite repeated warnings and an armed robbery report.

The investigation, published at **dragon403.com**, reveals that Guangzhou QiaHaoQingChun Information Technology Co., Ltd. operates the "HILO" application with SDK code that blatantly violates GDPR privacy regulations, collecting IMEI numbers, detecting VPN usage, and tracking carrier information without user consent.

---

## THE ARMED ROBBERY IGNORED

Following an armed robbery in the Philippines in which Alshammari's iPhone was stolen, he immediately reported the theft to Apple and requested his account be locked to prevent unauthorized purchases. **Apple refused**, claiming remote account locking was "not possible"—despite the feature being standard in enterprise mobile device management.

Within days, **27 high-velocity transactions** totaling SAR 600,000 (~$160,000) were processed through Apple Pay for "TikTok Coins" and HILO in-app purchases, all originating from a Singapore IP address while the account owner was located in Riyadh. **Apple's fraud detection systems failed to trigger a single alert.**

---

## GDPR VIOLATIONS DOCUMENTED IN DECOMPILED CODE

Technical analysis of the HILO application reveals systematic privacy violations:

| Violation | Code Evidence | GDPR Article |
|-----------|---------------|--------------|
| IMEI Collection | `addHeader("imei", getUuid())` | Article 5 |
| VPN Detection | `isVPNConnected() → "HI"/"LO"` | Article 6 |
| Carrier Tracking | `addHeader("carrier", ...)` | Article 5 |
| Emulator Detection | `isEmulator() → 1/0` | Anti-research |

The decompiled source code, available for verification, shows these data collection methods operate without user consent and are transmitted to servers in Hong Kong and Singapore.

---

## PLATFORM ACCOUNTABILITY

**Apple and Google approved and continue to host applications containing this code**, raising serious questions about their app review processes:

- Did automated privacy scanners detect IMEI collection patterns?
- Why was VPN detection (a privacy circumvention tool) approved?
- How did emulator detection (anti-research code) pass review?
- What responsibility do platforms bear for enabled fraud?

---

## THE INVESTIGATOR'S CREDENTIALS

Suliman Alshammari's credentials in cybersecurity span over 15 years:

- **2011:** Exposed Microsoft Hotmail infrastructure vulnerabilities, documented with vhotmail.com trophy
- **2011-2013:** Zone-H Archive documents 1,979 verified defacements under Dr.DaShEr and Dr.StUaRt personas
- **2024:** Became victim of HILO fraud network, losing SAR 600,000
- **2026:** Published dragon403.com investigation and HILO SDK analysis

*"This is not revenge. This is documentation,"* Alshammari stated. *"The desert does not forget, and the algorithm is our birthright."*

---

## LEGAL ACTION UNDERWAY

The following legal actions have been initiated or prepared:

| Authority | Status | Jurisdiction |
|-----------|--------|--------------|
| Ireland Data Protection Commission | ⏳ Ready to file | GDPR (Apple Europe) |
| FBI Internet Crime Complaint Center | ⏳ Ready to file | US Cybercrime |
| Federal Trade Commission | ⏳ Ready to file | US Consumer Protection |
| Europol Cybercrime | ⏳ Ready to file | EU Coordination |
| Interpol | ⏳ Ready to file | International |

A formal legal notice was sent to Apple on January 17, 2026, with a 48-hour response deadline. **Apple failed to respond, and the deadline expired on January 19, 2026.**

---

## GLOBAL IMPACT

The HILO fraud network is estimated to have stolen over **$50 million from victims worldwide** through a network of 20+ related applications sharing the same infrastructure and code patterns.

Servers identified in the investigation:
- api.tikhak.com (AWS)
- api.hiloconn.com (Cloudflare)
- h5.chathot.me (Alibaba Cloud Hong Kong)

---

## CALL FOR JOURNALISM

Alshammari is making all technical evidence available to journalists and security researchers for independent verification:

- **Full SDK Analysis:** Decompiled source code available
- **Server Infrastructure:** IP addresses and WHOIS data documented
- **Transaction Records:** Financial evidence preserved
- **Chain of Custody:** All evidence collection methods documented

---

## MEDIA RESOURCES

| Resource | Link |
|----------|------|
| Investigation Portal | https://dragon403.com |
| Technical Evidence | dragon403.com/evidence |
| GitHub Repository | github.com/KHAWRIZM/DRAGON_403-HILO-EXPOSED |
| Media Kit | Available on request |

---

## ABOUT KHAWRIZM

Suliman Nazal Alshammari, known online as KHAWRIZM, is a Saudi cybersecurity researcher and engineer based in Riyadh. The alias honors Al-Khwarizmi, the 9th-century Persian mathematician whose work gave us the word "algorithm." Alshammari is currently developing COMET-X, a sovereign browser with privacy-first architecture.

---

## CONTACT

**Email:** iqd@hotmail.com  
**Website:** https://dragon403.com  
**Location:** Riyadh, Saudi Arabia

---

### # # #

*This press release is part of the DRAGON_403 investigation. All claims are supported by documented evidence available for verification.*
