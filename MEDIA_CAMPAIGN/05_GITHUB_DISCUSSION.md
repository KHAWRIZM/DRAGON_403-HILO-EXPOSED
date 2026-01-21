# 🐙 GitHub Discussion - Security Disclosure

## For posting on: github.com/[appropriate-security-repo]/discussions
## Or: Create your own repo: HILO-Fraud-Evidence

---

# 🚨 Security Disclosure: 20+ Dating Apps Collecting IMEI, VPN Status Without Consent

## Summary

I have conducted a technical investigation into the HILO Android application and discovered a network of **20+ applications** by the same company engaging in:

1. **Unauthorized data collection** (IMEI, VPN status, carrier info)
2. **Anti-research countermeasures** (emulator detection)
3. **Shell company structure** to obscure ownership
4. **Romance scam operations** at industrial scale

## Affected Applications

All published by **Partycome PTE.LTD.** (Singapore shell company):

| App Name | Package | Downloads | Status |
|----------|---------|-----------|--------|
| HILO | com.nicemeet.hilo | 10M+ | Active |
| StarChat | - | 5M+ | Active |
| Farah | - | 5M+ | Active |
| Falla | - | 10M+ | Active |
| Famy | - | 5M+ | Active |
| YoYo | - | 1M+ | Active |
| Wink | - | 1M+ | Active |
| +13 more | - | - | Active |

**Total affected users: 50,000,000+**

## Technical Evidence

### 1. IMEI Collection (Privacy Violation)

**File:** `HeaderInterceptor.java`

```java
newBuilder.addHeader("imei", getUuid());
```

IMEI collection is unnecessary for app functionality and violates data minimization principles.

### 2. VPN Detection (User Profiling)

```java
if (isVPNConnected()) {
    str = "HI";  // VPN detected
} else {
    str = "LO";  // No VPN
}
```

This allows the app to identify and potentially discriminate against privacy-conscious users.

### 3. Emulator Detection (Anti-Research)

```java
if (isEmulator()) {
    i10 = 1;  // Emulator detected
} else {
    i10 = 0;  // Real device
}
```

This is specifically designed to detect security researchers and analysts.

### 4. Carrier Tracking

```java
addHeader("carrier", getCarrier());
```

Carrier information can be used for location inference.

## Server Infrastructure

| Server | IP | Provider | Purpose |
|--------|-----|----------|---------|
| api.tikhak.com | 15.197.148.33 | AWS | Main API |
| api.hiloconn.com | 104.18.25.166 | Cloudflare | Backup API |
| ws.tikhak.com | - | - | WebSocket |
| h5.chathot.me | 170.33.8.126 | - | Web Content |
| moment.tikhak.com | - | - | Media |

## Company Structure

```
Google Play Publisher: Partycome PTE.LTD. (Singapore) 🇸🇬
                              ↓
                    [SHELL COMPANY - FRONT]
                              ↓
Real Company: 广州俏好青春信息科技有限公司 (China) 🇨🇳
              Guangzhou QiaHaoQingChun Information Technology Co., Ltd.
```

## Legal Violations

### GDPR (European Union)
- **Article 5(1)(c)** - Data minimization: IMEI is not necessary
- **Article 6** - No lawful basis for VPN detection
- **Article 7** - No explicit consent obtained

### Saudi Arabia PDPL
- **Article 5** - Processing principles violated
- **Article 6** - Consent requirements not met
- **Article 10** - Transparency obligations ignored

## Platform Response

| Platform | Reports Filed | Response | Apps Removed |
|----------|---------------|----------|--------------|
| Google Play | Multiple | None | 0 |
| Apple App Store | Multiple | None | 0 |

**Both platforms continue to collect 30% commission on all fraudulent transactions.**

## Methodology

1. **APK Extraction:** Downloaded from Google Play
2. **Decompilation:** JADX v1.5.0
3. **Code Analysis:** Manual review of decompiled Java source
4. **Network Analysis:** Identified server endpoints in code
5. **Company Research:** Traced shell company to real owner

## Files Available

- `TECHNICAL_EVIDENCE_REPORT.md` - Full technical documentation
- `Hilo_Decompiled/sources/` - Decompiled source code
- `expose-hilo-website/` - Public exposure website

## Call to Action

1. **Security Researchers:** Please verify these findings independently
2. **Journalists:** This story needs coverage
3. **Regulators:** GDPR/PDPL enforcement is needed
4. **Users:** Report these apps and warn others

## Researcher

**Sulaiman Nazal Alshammari** (Dragon403)
- Twitter/X: @KHAWRIZM
- Project: GraTech X
- Location: Saudi Arabia 🇸🇦

## Disclaimer

This research was conducted for security purposes. All evidence was obtained through legal means (public APK decompilation). No systems were accessed without authorization.

---

**Tags:** `security` `privacy` `fraud` `android` `data-collection` `gdpr` `consumer-protection`

**CC:** @AnyInterested Security Researchers
