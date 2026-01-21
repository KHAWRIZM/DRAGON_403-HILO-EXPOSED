# 📧 Email Templates for Media Outreach

---

## Template 1: Arabic Media (العربية، الجزيرة، سكاي نيوز)

**Subject:** تحقيق حصري: شبكة احتيال صينية تستهدف 50 مليون مستخدم عربي - أدلة تقنية كاملة

---

السادة المحررين الكرام،

أتواصل معكم بخصوص تحقيق استقصائي قمت بإعداده يكشف شبكة احتيال إلكتروني منظمة تستهدف المستخدمين العرب بشكل خاص.

**الملخص:**
- شركة صينية تدير 20+ تطبيق تواصل اجتماعي تحت غطاء شركة سنغافورية
- 50 مليون+ مستخدم متضرر
- 50 مليون دولار+ إيرادات احتيالية
- Google و Apple يحصلان على 30% من كل عملية نصب

**الأدلة:**
- كود مُفكك من التطبيق يثبت جمع بيانات غير مصرح به
- عناوين سيرفرات مكتشفة
- هيكل الشركة الواجهة موثق
- بلاغات متكررة لـ Google و Apple بدون استجابة

**لماذا هذه القصة مهمة:**
1. تستهدف المستخدمين العرب بشكل رئيسي
2. تكشف تواطؤ منصات التقنية الكبرى
3. أول تحقيق تقني عربي من نوعه

أنا مستعد لتقديم:
- مقابلة حصرية
- كافة الوثائق التقنية
- شرح مبسط للجمهور العام

للتواصل: @KHAWRIZM على Twitter/X

مع التقدير،
سليمان نزال الشمري
GraTech X | Dragon403

---

## Template 2: English Media (BBC, Guardian, Reuters, TechCrunch)

**Subject:** Exclusive: Chinese Fraud Network Targeting 50M Users - Google/Apple Complicity Evidence

---

Dear Editor,

I am a Saudi cybersecurity researcher writing to share findings from an investigation that reveals a significant consumer protection story with global implications.

**Key Points:**
- A Chinese company operates 20+ dating/social apps through a Singapore shell company
- 50 million+ affected users (primarily Middle East/Arab countries)
- $50 million+ in estimated fraudulent revenue
- Google and Apple receive 30% commission on all transactions
- Both platforms have ignored multiple fraud reports

**Technical Evidence Includes:**
- Decompiled source code showing unauthorized IMEI collection
- VPN detection to identify privacy-conscious users
- Emulator detection to block security researchers
- Documented shell company structure

**Why This Matters:**
1. First comprehensive technical exposure of this fraud network
2. Demonstrates platform complicity in app store fraud
3. Raises serious GDPR and data protection concerns
4. Pattern likely exists in other app categories

**I Can Provide:**
- Full technical documentation
- Decompiled source code
- Server infrastructure mapping
- Exclusive interview
- Expert commentary on technical aspects

**Contact:** @KHAWRIZM on Twitter/X

Best regards,
Sulaiman Nazal Alshammari
GraTech X | Dragon403
Saudi Arabia

---

## Template 3: Tech-Specific Media (Ars Technica, Wired, The Verge)

**Subject:** Technical Deep-Dive: How I Decompiled 20+ Fraud Apps and Found a Chinese Crime Network

---

Hi,

I'm Dragon403, a security researcher from Saudi Arabia. I've completed a technical investigation that might interest your readers.

**The Story:**
I decompiled the HILO Android app and discovered it's part of a 20+ app fraud network. Same Chinese company, Singapore shell corporation, same codebase with different skins.

**Technical Highlights:**
```java
// Actual code from HeaderInterceptor.java
newBuilder.addHeader("imei", getUuid());
if (isVPNConnected()) str = "HI"; else str = "LO";
if (isEmulator()) i10 = 1; else i10 = 0;
```

**What I Found:**
- IMEI collection without consent
- VPN detection (flagging privacy users)
- Emulator detection (anti-researcher measures)
- Server infrastructure: api.tikhak.com, api.hiloconn.com, etc.

**The Bigger Picture:**
- Shell company: Partycome PTE.LTD. (Singapore)
- Real company: Guangzhou QiaHaoQingChun (China)
- 50M+ downloads across all apps
- Google/Apple taking 30% cut of fraud revenue

**Available Materials:**
- Full decompiled source (JADX output)
- Technical evidence report
- Network analysis
- Company structure documentation

I've built a full exposure website with Kali Linux terminal simulation to present the evidence. Happy to share everything.

DM me: @KHAWRIZM

— Dragon403

---

## Template 4: Data Protection Authorities

**Subject:** GDPR Complaint - Systematic Data Collection Violations by Partycome PTE.LTD. Applications

---

To Whom It May Concern,

I am filing a formal complaint regarding systematic violations of GDPR by applications published by Partycome PTE.LTD. on Google Play Store.

**Complaint Summary:**

The following applications collect personal data without lawful basis:
- HILO (10M+ downloads)
- StarChat, Farah, Falla, Famy, and 15+ additional apps

**Specific Violations:**

1. **Article 5(1)(c) - Data Minimization**
   - Collection of IMEI device identifier
   - Not necessary for application functionality

2. **Article 6 - Lawful Processing**
   - No legitimate interest for VPN detection
   - No consent obtained for carrier tracking

3. **Article 7 - Consent Conditions**
   - No explicit consent mechanism for data collection
   - Buried disclosures in lengthy terms

**Technical Evidence:**
Source code extracted through APK decompilation confirms:
```java
newBuilder.addHeader("imei", getUuid());
if (isVPNConnected()) str = "HI";
addHeader("carrier", getCarrier());
```

**Data Controller Information:**
- Publisher: Partycome PTE.LTD. (Singapore)
- Actual Operator: Guangzhou QiaHaoQingChun Information Technology Co., Ltd. (China)

**Request:**
1. Investigation into data processing practices
2. Enforcement action against the data controller
3. Coordination with Google regarding app removal

I am available to provide full technical documentation upon request.

Respectfully,
Sulaiman Nazal Alshammari
[Contact Information]

---

## Media Contact List

### Arabic Media
- **Al Jazeera:** tips@aljazeera.net
- **Al Arabiya:** news@alarabiya.net
- **Sky News Arabia:** contact form
- **Independent Arabia:** tips form

### English Media
- **BBC:** newsgathering@bbc.co.uk
- **The Guardian:** tips@theguardian.com
- **Reuters:** tips@reuters.com
- **TechCrunch:** tips@techcrunch.com
- **Wired:** submit@wired.com
- **Ars Technica:** tips@arstechnica.com
- **The Verge:** tips@theverge.com

### Security-Focused
- **Krebs on Security:** @braborian
- **Bleeping Computer:** tips
- **Threatpost:** tips

### Data Protection
- **EU DPA:** Contact local authority
- **UK ICO:** casework@ico.org.uk
- **Saudi NDMO:** Contact form
