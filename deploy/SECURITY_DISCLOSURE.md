# 🐉 DRAGON403 - HILO Fraud Network Exposed

[![Azure Static Web Apps](https://img.shields.io/badge/Azure-Live-blue?logo=microsoft-azure)](https://dragon403.com)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Twitter](https://img.shields.io/badge/Twitter-@KHAWRIZM-1DA1F2?logo=twitter)](https://twitter.com/KHAWRIZM)

## 🚨 SECURITY DISCLOSURE

**This repository contains evidence of a massive fraud network targeting 50+ million users.**

### The Network

| Entity | Details |
|--------|---------|
| **Shell Company** | Partycome PTE.LTD. (Singapore 🇸🇬) |
| **Real Owner** | Guangzhou QiaHaoQingChun (China 🇨🇳) |
| **Apps Affected** | 20+ applications |
| **Users Affected** | 50,000,000+ |
| **Estimated Fraud** | $50,000,000+ |
| **Google/Apple Cut** | $15,000,000+ (30%) |

### 📱 Affected Applications

All published by **Partycome PTE.LTD.**:

- HILO (10M+ downloads)
- Falla (10M+ downloads)
- StarChat (5M+ downloads)
- Farah (5M+ downloads)
- Famy (5M+ downloads)
- YoYo, Wink, Yalla, MeetU, Ahlan, Hayya, Sawa...
- **+10 more under investigation**

### 💻 Technical Evidence

Decompiled using JADX. Found in `HeaderInterceptor.java`:

```java
// IMEI Collection (without consent)
newBuilder.addHeader("imei", getUuid());

// VPN Detection (flagging privacy users)
if (isVPNConnected()) {
    str = "HI";  // VPN detected
} else {
    str = "LO";  // No VPN
}

// Emulator Detection (blocking researchers)
if (isEmulator()) {
    i10 = 1;
}

// Carrier Tracking
newBuilder.addHeader("carrier", getCarrier());
```

### 🌐 Discovered Servers

| Server | IP | Provider |
|--------|-----|----------|
| api.tikhak.com | 15.197.148.33 | AWS |
| api.hiloconn.com | 104.18.25.166 | Cloudflare |
| ws.tikhak.com | - | WebSocket |
| h5.chathot.me | 170.33.8.126 | Unknown |

### ⚖️ Legal Violations

- **GDPR (EU)**: Articles 5, 6, 7 - Data minimization, consent
- **Saudi PDPL**: Personal data protection violations
- **Consumer Protection Laws**: Multiple jurisdictions

### 🔴 Platform Response

| Platform | Reports Filed | Response | Apps Removed |
|----------|---------------|----------|--------------|
| Google Play | Multiple | **NONE** | 0 |
| Apple App Store | Multiple | **NONE** | 0 |

**Both platforms continue to profit from 30% commission on fraudulent transactions.**

---

## 🌐 Live Evidence Site

### **[https://dragon403.com](https://dragon403.com)**

---

## 📢 Media Coverage

- Twitter Thread: [@KHAWRIZM](https://twitter.com/KHAWRIZM)
- Full Technical Report: [TECHNICAL_EVIDENCE_REPORT.md](TECHNICAL_EVIDENCE_REPORT.md)

---

## 🎯 Call to Action

1. **Report** these apps on Google Play & App Store
2. **Share** this repository
3. **Warn** friends and family
4. **Contact** journalists and regulators

---

## 👤 Researcher

**Sulaiman Nazal Alshammari** (Dragon403)
- Twitter: [@KHAWRIZM](https://twitter.com/KHAWRIZM)
- Project: GraTech X
- Location: Saudi Arabia 🇸🇦

---

## 📜 Disclaimer

This research was conducted for security and consumer protection purposes. All evidence was obtained through legal means (public APK decompilation). No systems were accessed without authorization.

---

> *"I have nothing to lose. I don't want their money. I want justice."*
> 
> — Dragon403

---

## 🏷️ Tags

`security` `fraud` `privacy` `android` `apk-analysis` `consumer-protection` `gdpr` `data-privacy` `scam` `investigation`

---

**⭐ Star this repo to help spread awareness!**
