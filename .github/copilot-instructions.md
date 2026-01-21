# HILO Case Investigation - AI Agent Guidelines

## Project Overview

This is a **fraud investigation case** documenting evidence against the HILO Android app (developed by Guangzhou QiaHaoQingChun Information Technology Co., Ltd.). The project contains decompiled Android source code, technical evidence reports, and an exposure website.

## Directory Structure

| Path | Purpose |
|------|---------|
| `Hilo_Decompiled/sources/` | JADX-decompiled Java source code from HILO APK |
| `Hilo_Decompiled/sources/com/qiahao/` | Core company packages (`base_common`, `nextvideo`, `hilo_message`) |
| `expose-hilo-website/` | Public-facing exposure website (Arabic RTL + English) |
| `Perplexity_Evidence/` | Browser forensic data (History, Login Data) |
| `TECHNICAL_EVIDENCE_REPORT.md` | **Primary reference** - all technical findings |

## Key Evidence Files

When analyzing privacy violations or server infrastructure, reference these decompiled files:
- **Server URLs**: `com/qiahao/nextvideo/share/r.java` - contains `hiloconn.com` endpoints
- **VIP/Terms**: `com/qiahao/nextvideo/ui/vip/VipViewDialog.java` - policy URLs
- **User data model**: Search for `User.java` files in obfuscated packages
- **Network interceptors**: Look for `HeaderInterceptor` patterns for data collection evidence

## Discovered Server Infrastructure

```
API: api.tikhak.com, apiv1.faceline.live, api.hiloconn.com
WebSocket: ws.tikhak.com, ws.faceline.live, ws.hiloconn.com
Web: h5.chathot.me, moment.tikhak.com
```

## Investigation Conventions

### Document Updates
- Always update `TECHNICAL_EVIDENCE_REPORT.md` when finding new evidence
- Preserve evidence chain format: source file path, line numbers, exact code snippets
- Use tables for structured data (servers, data fields, violations)

### Code Analysis Patterns
- Decompiled code uses **obfuscated package names** (a0/, b1/, c2/, etc.)
- Real company packages are under `com/qiahao/` and `com/qhqc/`
- Look for `ServerConfigureKt`, `HeaderInterceptor` for network/privacy evidence
- Search for `imei`, `VPN`, `isSimulator`, `carrier` to find data collection code

### PowerShell Automation
- Use `Hilo_Actions.ps1` for OSINT functions (IP lookup via ipinfo.io)
- Export functions with `Export-ModuleMember` for reuse

### Website Development
- `expose-hilo-website/` uses Bootstrap RTL for Arabic support
- Dark cyber theme with CSS variables in `:root`
- Code blocks must be `direction: ltr; text-align: left;` for readability

## Critical Context

- **Owner**: Sulaiman Nazal Alshammari (@KHAWRIZM, GraTech X)
- **Decompiler used**: JADX v1.5.0
- **Legal jurisdictions**: GDPR, Saudi Arabia PDPL
- **Parallel task**: Domain rescue for `gratech.sa` (deadline Feb 3, 2026)

## Do NOT

- Modify original decompiled source files - they are legal evidence
- Expose personal victim data publicly
- Make unfounded legal claims without code evidence backing
