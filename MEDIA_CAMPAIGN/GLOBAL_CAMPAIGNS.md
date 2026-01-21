# 🐉 DRAGON403 GLOBAL CAMPAIGNS
## حملات عالمية لفضح شبكة HILO/Partycome

---

## 🔶 1. HACKER NEWS (news.ycombinator.com)

### Title:
```
Show HN: I reverse-engineered 20+ Chinese fraud apps targeting 50M+ Arab users – Google/Apple took $15M+ cut
```

### Post:
```
Hey HN,

I'm a security researcher who spent months reverse-engineering HILO and 20+ related apps using JADX. What I found is disturbing:

**The Setup:**
- Shell company: Partycome PTE.LTD. (Singapore) 
- Real owner: Guangzhou QiaHaoQingChun Information Technology Co., Ltd. (China)
- Apps: HILO, StarChat, Farah, Falla, Famy, YoYo, Wink, 7Nujoom, Mico
- Target: Arab users (Saudi Arabia, UAE, Egypt, Iraq)

**Technical Evidence:**
- IMEI collection without consent (HeaderInterceptor.java)
- VPN/Emulator detection to block investigators
- Carrier data harvesting (GDPR/PDPL violations)
- Servers: api.hiloconn.com, ws.tikhak.com, h5.chathot.me

**The Numbers:**
- 50M+ downloads across all apps
- $50M+ extracted through fake gifts, VIP scams
- Google/Apple's 30% cut = $15M+ from fraud proceeds

**Full technical report + decompiled evidence:**
https://dragon403.com

GitHub: https://github.com/KHAWRIZM/DRAGON_403-HILO-EXPOSED

Questions welcome. The code doesn't lie.

- Dragon403 (@KHAWRIZM)
```

---

## 🔴 2. REDDIT - Multiple Subreddits

### r/cybersecurity (700K members)

**Title:** `[Research] Reverse-engineered 20+ Chinese fraud apps - Found IMEI harvesting, VPN detection, and $50M+ fraud targeting Arab users`

**Post:**
```
TL;DR: Chinese fraud network uses Singapore shell company to run 20+ apps stealing from Arab users. Google/Apple knowingly profit from 30% cut.

**Technical Findings:**
- Decompiled with JADX v1.5.0
- Found HeaderInterceptor collecting IMEI, carrier data
- VPN detection code to block security researchers
- Obfuscated packages: com/qiahao/, a0/, b1/, c2/

**Infrastructure:**
- API: api.hiloconn.com, api.faceline.live
- WebSocket: ws.tikhak.com
- Web: h5.chathot.me

**Evidence repo:** https://github.com/KHAWRIZM/DRAGON_403-HILO-EXPOSED

**Full report:** https://dragon403.com

Happy to share specific code snippets for verification.
```

### r/privacy (1.5M members)

**Title:** `Chinese apps harvesting IMEI and carrier data from 50M+ users - Google/Apple complicit`

### r/Android (3M members)

**Title:** `PSA: HILO and 20+ apps from "Partycome" are harvesting your IMEI - Full decompilation evidence inside`

### r/saudiarabia + r/UAE + r/Egypt + r/arabs

**Title (Arabic):**
```
🚨 تحذير: تطبيقات HILO و20+ تطبيق آخر تسرق بياناتك - أدلة تقنية من فك تشفير الكود
```

---

## 🐦 3. TWITTER/X THREADS (بأسلوب التنين 🐉)

### Thread 1: Technical (English)
```
🧵 THREAD: I spent 6 months reverse-engineering HILO app. What I found will make you delete it immediately.

1/ The app you think is "fun" is actually a sophisticated fraud operation run by Guangzhou QiaHaoQingChun (China) hiding behind "Partycome PTE.LTD." (Singapore shell).

2/ Using JADX, I found code that:
- Collects your IMEI without consent
- Detects if you're using VPN (to block investigators)
- Harvests your carrier data
All illegal under GDPR and Saudi PDPL.

3/ The fraud network includes 20+ apps:
HILO, StarChat, Farah, Falla, Famy, YoYo, Wink, 7Nujoom, Mico, Ahlan...
Same backend. Same scam. Different skins.

4/ They've stolen $50M+ from Arab users through:
- Fake "gifts" that cost real money
- VIP scams
- Emotional manipulation

5/ The kicker? Google and Apple took their 30% cut.
That's $15M+ in PROFIT FROM FRAUD.
They're not victims. They're accomplices.

6/ Full technical evidence:
🔗 https://dragon403.com
📂 https://github.com/KHAWRIZM/DRAGON_403-HILO-EXPOSED

The code doesn't lie. Neither do I.
- Dragon403 🐉

#HILO #Fraud #CyberSecurity #Google #Apple
```

### Thread 2: Arabic (ناري 🔥)
```
🧵 ثريد: قصة أكبر عملية نصب استهدفت العرب

1/ تطبيق HILO اللي تلعبونه؟ مو لعبة. عملية نصب منظمة من الصين.

2/ فككت الكود بنفسي ولقيت:
- يسرقون رقم جهازك (IMEI)
- يكشفون لو تستخدم VPN
- ياخذون بيانات شركة الاتصالات
كله بدون إذنك.

3/ الشركة "Partycome" في سنغافورة؟ واجهة وهمية.
المالك الحقيقي: Guangzhou QiaHaoQingChun في الصين.

4/ مو بس HILO:
StarChat, Farah, Falla, Famy, YoYo, Wink, 7Nujoom
كلهم نفس الشبكة. نفس النصب. غلاف مختلف.

5/ الأرقام:
- 50 مليون+ ضحية
- 50 مليون$+ مسروقة
- 15 مليون$+ راحت لـ Google و Apple كعمولة

6/ جوجل وآبل مو ضحايا. شركاء في الجريمة.
30% من كل عملية نصب راحت لجيوبهم.

7/ كل الأدلة التقنية:
🔗 https://dragon403.com

أنا Dragon403. والحقيقة ما تنكتم. 🐉

#HILO #احتيال #فضيحة
```

---

## 💼 4. LINKEDIN (للمحترفين والصحفيين)

**Post:**
```
🔴 SECURITY DISCLOSURE: $50M+ Fraud Network Exposed

After 6 months of reverse-engineering using JADX, I've documented a massive fraud operation targeting 50+ million Arab users.

Key findings:
• Shell company structure: Partycome PTE.LTD. (Singapore) → Guangzhou QiaHaoQingChun (China)
• 20+ apps including HILO, StarChat, Farah, Falla with identical backend infrastructure
• Privacy violations: IMEI harvesting, VPN detection, carrier data collection
• Estimated fraud: $50M+ with Google/Apple receiving $15M+ in platform fees

Technical documentation: https://dragon403.com
Evidence repository: https://github.com/KHAWRIZM/DRAGON_403-HILO-EXPOSED

I'm reaching out to:
- Journalists covering tech/fraud
- GDPR/PDPL legal experts
- Platform trust & safety teams

This is not about one app. It's about platform accountability.

#CyberSecurity #FraudPrevention #TechEthics #Privacy
```

---

## 📧 5. EMAIL TO ORGANIZATIONS

### Electronic Frontier Foundation (EFF)
**To:** info@eff.org
**Subject:** Documented Evidence of Google/Apple Platform Complicity in $50M+ Fraud

### European Data Protection Board
**To:** edpb@edpb.europa.eu  
**Subject:** GDPR Violation Report - Chinese Apps Harvesting EU Citizen Data

### Saudi NDMO (National Data Management Office)
**To:** info@ndmo.gov.sa
**Subject:** PDPL Violations - Apps Targeting Saudi Users

### TechCrunch / Wired / The Verge
**Subject:** Exclusive: Security Researcher Exposes $50M Chinese Fraud Network, Implicates Google & Apple

---

## 🔧 6. GITHUB SECURITY ADVISORIES

### Google Play Security
**Report to:** https://www.google.com/appserve/security-bugs/m2/new

### Apple App Store
**Report to:** https://developer.apple.com/contact/topic/fraud/

---

## 📋 QUICK COPY LINKS

| Platform | Action |
|----------|--------|
| Hacker News | https://news.ycombinator.com/submit |
| Reddit Cybersec | https://reddit.com/r/cybersecurity/submit |
| Reddit Privacy | https://reddit.com/r/privacy/submit |
| Twitter | https://twitter.com/compose/tweet |
| LinkedIn | https://linkedin.com/feed/ |

---

## 🐉 التنين جاهز للهجوم!

**dragon403.com** 🔥
**@KHAWRIZM** 🐦
**KHAWRIZM/DRAGON_403-HILO-EXPOSED** 📂

