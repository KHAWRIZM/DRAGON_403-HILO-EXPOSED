# 🐉 HILO Fraud Network - Security Disclosure

## Summary

I am a security researcher who has uncovered a massive fraud network operated through Google Play and Apple App Store. This disclosure documents systematic privacy violations and consumer fraud affecting 50+ million users.

## Severity: CRITICAL

### Impact
- **50,000,000+** users affected
- **$50,000,000+** estimated fraud
- **20+** applications involved
- **GDPR & PDPL violations** documented

## Vulnerability Details

### 1. Unauthorized Data Collection

**File:** `HeaderInterceptor.java` (decompiled)

```java
newBuilder.addHeader("imei", getUuid());
addHeader("carrier", getCarrier());
```

**Impact:** Device tracking without user consent, violates GDPR Article 5(1)(c).

### 2. VPN Detection & User Profiling

```java
if (isVPNConnected()) {
    str = "HI";
} else {
    str = "LO";
}
```

**Impact:** Identifying and potentially discriminating against privacy-conscious users.

### 3. Anti-Research Measures

```java
if (isEmulator()) {
    i10 = 1;
}
```

**Impact:** Deliberately blocking security researchers from analysis.

## Affected Products

**Publisher:** Partycome PTE.LTD. (Singapore shell company)
**Real Owner:** Guangzhou QiaHaoQingChun Information Technology (China)

| App | Downloads | Status |
|-----|-----------|--------|
| HILO | 10M+ | Active |
| Falla | 10M+ | Active |
| StarChat | 5M+ | Active |
| Farah | 5M+ | Active |
| Famy | 5M+ | Active |
| +15 more | Various | Active |

## Server Infrastructure

- `api.tikhak.com` (15.197.148.33) - AWS
- `api.hiloconn.com` (104.18.25.166) - Cloudflare
- `ws.tikhak.com` - WebSocket
- `h5.chathot.me` (170.33.8.126)

## Disclosure Timeline

| Date | Action |
|------|--------|
| 2025 | Multiple reports to Google Play |
| 2025 | Multiple reports to Apple App Store |
| 2025 | No response from either platform |
| Jan 2026 | Public disclosure |

## Platform Response

**Google Play:** No action taken despite multiple reports.
**Apple App Store:** No action taken despite multiple reports.

Both platforms continue collecting 30% commission (~$15M) from fraudulent transactions.

## Recommendations

1. **Immediate removal** of all Partycome PTE.LTD. applications
2. **Investigation** into data collection practices
3. **User notification** for affected users
4. **Refund process** for fraud victims

## Evidence

Full technical evidence available at:
- Website: https://dragon403.com
- Repository: https://github.com/KHAWRIZM/DRAGON_403-HILO-EXPOSED

## Contact

**Researcher:** Sulaiman Nazal Alshammari (Dragon403)
**Twitter:** @KHAWRIZM
**Email:** [Available upon request]

## Legal

This research was conducted through legal means:
- Public APK download from official stores
- Decompilation using JADX (legal for security research)
- No unauthorized system access

---

**CVE Request:** Pending (if applicable)

**Coordinated Disclosure:** Attempted with Google/Apple - no response received.
