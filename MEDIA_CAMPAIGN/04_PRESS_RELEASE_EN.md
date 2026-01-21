# 📰 Press Release - English
## For International Media

---

# PRESS RELEASE
## Saudi Security Researcher Exposes Chinese Fraud Network Targeting 50 Million Users

**FOR IMMEDIATE RELEASE**
**Date:** January 20, 2026

---

### Executive Summary

Saudi cybersecurity researcher **Sulaiman Nazal Alshammari** (@KHAWRIZM), operating under the alias **Dragon403**, has uncovered a sophisticated fraud network operated by a Chinese company through a Singapore shell corporation. The network targets Arab users through over 20 social/dating applications, with estimated damages exceeding $50 million.

---

### Key Facts

| Item | Details |
|------|---------|
| **Shell Company** | Partycome PTE.LTD. (Singapore) |
| **Actual Company** | Guangzhou QiaHaoQingChun Information Technology Co., Ltd. (China) |
| **Number of Apps** | 20+ applications |
| **Notable Apps** | HILO, StarChat, Farah, Falla, Famy, YoYo, Wink |
| **Total Downloads** | 50,000,000+ |
| **Estimated Revenue** | $50,000,000+ |
| **Google/Apple Cut** | $15,000,000+ (30% commission) |

---

### Technical Evidence

The researcher decompiled the applications using JADX and discovered:

1. **IMEI Collection** - Device tracking without user consent
2. **VPN Detection** - Identifying privacy-conscious users
3. **Emulator Detection** - Blocking security researchers
4. **Carrier/Location Tracking** - Geolocation inference

```java
// Actual code extracted from the application
newBuilder.addHeader("imei", getUuid());
if (isVPNConnected()) str = "HI"; else str = "LO";
if (isEmulator()) i10 = 1; else i10 = 0;
addHeader("carrier", getCarrier());
```

**Source File:** `HeaderInterceptor.java`

---

### Discovered Server Infrastructure

| Server | IP Address | Provider |
|--------|------------|----------|
| api.tikhak.com | 15.197.148.33 | AWS |
| api.hiloconn.com | 104.18.25.166 | Cloudflare |
| h5.chathot.me | 170.33.8.126 | Unknown |
| ws.tikhak.com | - | WebSocket Server |

---

### Fraud Mechanics

1. **Fake Profiles** - Using stolen or AI-generated photos of women
2. **Pay-Per-Message** - Charging for each chat message
3. **Virtual Gifts** - Real money for virtual items
4. **Bot Responses** - Automated replies, not real humans
5. **False VIP Promises** - Misleading premium subscriptions

---

### Platform Complicity

Despite multiple reports filed with both Google Play and Apple App Store, all applications remain available for download. The researcher alleges this is due to both platforms receiving 30% commission on all in-app purchases, creating a financial incentive to ignore fraud reports.

---

### Legal Violations

- **GDPR (EU):** Articles 5, 6, 7 - Data minimization, lawful processing, consent
- **Saudi PDPL:** Articles 5, 6, 10 - Personal data protection, transparency
- **Consumer Protection Laws:** Multiple jurisdictions

---

### Researcher Statement

> "I have nothing to lose. They took more than money from me. I want justice, nothing else. The truth is out, and no one can bury it now."
> 
> — Sulaiman Nazal Alshammari (Dragon403)

---

### Contact Information

- **Researcher:** Sulaiman Nazal Alshammari
- **Twitter/X:** @KHAWRIZM
- **Project:** GraTech X
- **Evidence Website:** [To be added after publication]
- **Email:** [To be added]
- **Location:** Saudi Arabia 🇸🇦

---

### Available Documentation

- Full Technical Evidence Report
- Decompiled source code samples
- Server infrastructure mapping
- Complete list of fraudulent applications
- Timeline of ignored reports to Google/Apple

---

### Suggested Media Angles

1. **Consumer Protection:** How app stores profit from fraud
2. **Data Privacy:** Illegal data collection in dating apps
3. **Shell Companies:** Chinese tech companies hiding behind Singapore registrations
4. **Platform Accountability:** Google and Apple's responsibility
5. **Cybersecurity:** How researchers expose app fraud

---

### Hashtags
#HILOScam #TechFraud #Dragon403 #GoogleComplicity #DataPrivacy #ConsumerProtection

---

*This press release is available for publication with attribution*

**Media Inquiries:** @KHAWRIZM on Twitter/X
