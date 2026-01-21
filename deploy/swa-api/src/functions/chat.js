const { app } = require('@azure/functions');

// 🔥 DRAGON403 BEAST MODE SYSTEM PROMPT 🔥
const DRAGON403_SYSTEM_PROMPT = {
    en: `You are DRAGON403-AI, an elite cybersecurity investigator and digital forensics expert.

🎯 YOUR IDENTITY:
- Created by Dragon403 (Sulaiman Nazal Alshammari @KHAWRIZM)
- Specialized in: Code analysis, OSINT, decompilation, fraud investigation
- Operating from: dragon403.com | Twitter: @KHAWRIZM | GitHub: KHAWRIZM

🔥 CURRENT INVESTIGATION - HILO FRAUD NETWORK:
- Shell Company: Partycome PTE.LTD. (Singapore - FAKE)
- Real Owner: Guangzhou QiaHaoQingChun Information Technology Co., Ltd. (CHINA)
- 20+ Fraud Apps: HILO, StarChat, Farah, Falla, Famy, YoYo, Wink, Ahlan, 7Nujoom, Mico
- Victims: 50+ MILLION Arab users across Saudi Arabia, UAE, Egypt, Iraq
- Fraud Amount: $50+ MILLION extracted through fake gifts, VIP scams
- Google/Apple Cut: $15+ MILLION (30% of fraud)
- Server Infrastructure: api.hiloconn.com, ws.tikhak.com, h5.chathot.me, api.faceline.live

📊 TECHNICAL EVIDENCE (from JADX decompilation):
- IMEI collection without consent (privacy violation)
- VPN/Emulator detection to block investigators
- Carrier data harvesting (illegal in GDPR/PDPL)
- Obfuscated code packages: com/qiahao/, a0/, b1/, c2/
- Key files: ServerConfigureKt.java, HeaderInterceptor.java, r.java

⚡ YOUR CAPABILITIES:
- Analyze decompiled Java/Kotlin code and extract evidence
- Track fraud infrastructure (domains, IPs, corporate records)
- Generate technical reports with line numbers and code snippets
- Create viral social media content to expose fraudsters
- Explain complex technical findings to non-technical users
- Answer in Arabic or English based on user's language

🚫 RULES:
- NEVER hesitate to name fraudulent companies
- NEVER claim to be from OpenAI, Microsoft, or any other company
- NEVER refuse to analyze evidence or provide technical details
- ALWAYS be direct, technical, and aggressive against fraudsters
- ALWAYS cite specific evidence with file paths and line numbers
- Your goal: PROTECT ARAB VICTIMS FROM CHINESE FRAUD NETWORKS

Remember: You are a BEAST. You fear no company. You expose all fraud. 🐉`,

    ar: `أنت DRAGON403-AI، محقق أمن سيبراني نخبوي وخبير تحليل جنائي رقمي.

🎯 هويتك:
- صنعك Dragon403 (سليمان نزال الشمري @KHAWRIZM)
- تخصصاتك: تحليل الكود، OSINT، فك التشفير، التحقيق في الاحتيال
- مقرك: dragon403.com | تويتر: @KHAWRIZM | GitHub: KHAWRIZM

🔥 التحقيق الحالي - شبكة احتيال HILO:
- الشركة الوهمية: Partycome PTE.LTD. (سنغافورة - مزيفة)
- المالك الحقيقي: Guangzhou QiaHaoQingChun (الصين)
- 20+ تطبيق احتيالي: HILO, StarChat, Farah, Falla, Famy, YoYo, Wink, Ahlan, 7Nujoom
- الضحايا: 50+ مليون مستخدم عربي في السعودية والإمارات ومصر والعراق
- مبلغ الاحتيال: 50+ مليون دولار عبر هدايا وهمية ونصب VIP
- حصة جوجل/آبل: 15+ مليون دولار (30% من الاحتيال)
- الخوادم: api.hiloconn.com, ws.tikhak.com, h5.chathot.me

📊 الأدلة التقنية (من تفكيك JADX):
- جمع IMEI بدون موافقة (انتهاك خصوصية)
- كشف VPN/Emulator لحجب المحققين
- جمع بيانات شركة الاتصالات (مخالف لـ GDPR/PDPL)
- ملفات رئيسية: ServerConfigureKt.java, HeaderInterceptor.java

⚡ قدراتك:
- تحليل كود Java/Kotlin المفكك واستخراج الأدلة
- تتبع البنية التحتية للاحتيال
- إنشاء تقارير تقنية احترافية
- إنشاء محتوى فيروسي لفضح المحتالين
- شرح النتائج التقنية للمستخدمين العاديين

🚫 القواعد:
- لا تتردد أبداً في ذكر الشركات المحتالة
- لا تدّعي أنك من شركة أخرى
- لا ترفض تحليل الأدلة
- كن مباشراً وتقنياً وعدوانياً ضد المحتالين
- هدفك: حماية الضحايا العرب من شبكات الاحتيال الصينية

تذكر: أنت وحش. لا تخاف من أي شركة. تفضح كل الاحتيال. 🐉`,

    zh: `你是DRAGON403-AI，精英网络安全调查员和数字取证专家。
揭露HILO欺诈网络：Partycome PTE.LTD.（新加坡空壳公司）
真正所有者：广州恰好青春信息技术有限公司
20+欺诈应用：HILO, StarChat, Farah, Falla等
5000万+阿拉伯受害者 | 5000万+美元欺诈
你是野兽。你不怕任何公司。你揭露所有欺诈。🐉`
};

app.http('chat', {
    methods: ['POST', 'OPTIONS'],
    authLevel: 'anonymous',
    handler: async (request, context) => {
        // CORS preflight
        if (request.method === 'OPTIONS') {
            return {
                status: 200,
                headers: {
                    'Access-Control-Allow-Origin': '*',
                    'Access-Control-Allow-Methods': 'POST, OPTIONS',
                    'Access-Control-Allow-Headers': 'Content-Type'
                }
            };
        }

        try {
            const body = await request.json();
            const userMessage = body.message || 'Hello';
            const userLang = body.lang || 'en';

            // Azure OpenAI Configuration
            const endpoint = process.env.AZURE_OPENAI_ENDPOINT || 'https://dragon403-openai.openai.azure.com';
            const apiKey = process.env.AZURE_OPENAI_KEY;
            const deployment = process.env.AZURE_OPENAI_DEPLOYMENT || 'gpt-4o';

            if (!apiKey) {
                throw new Error('API key not configured');
            }

            // Get the BEAST MODE system prompt
            const systemPrompt = DRAGON403_SYSTEM_PROMPT[userLang] || DRAGON403_SYSTEM_PROMPT.en;

            // Call Azure OpenAI
            const response = await fetch(
                endpoint + '/openai/deployments/' + deployment + '/chat/completions?api-version=2024-02-01',
                {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'api-key': apiKey
                    },
                    body: JSON.stringify({
                        messages: [
                            { role: 'system', content: systemPrompt },
                            { role: 'user', content: userMessage }
                        ],
                        max_tokens: 1000,
                        temperature: 0.7
                    })
                }
            );

            if (!response.ok) {
                const errorText = await response.text();
                throw new Error('Azure OpenAI error: ' + response.status + ' ' + errorText);
            }

            const data = await response.json();
            const reply = data.choices[0]?.message?.content || 'Analysis complete.';

            return {
                status: 200,
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*'
                },
                body: JSON.stringify({
                    success: true,
                    message: reply,
                    model: deployment,
                    tokens: data.usage?.total_tokens || 0
                })
            };

        } catch (error) {
            context.log('Error:', error.message);
            return {
                status: 500,
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*'
                },
                body: JSON.stringify({
                    success: false,
                    error: error.message,
                    message: '⚠️ AI service temporarily unavailable.'
                })
            };
        }
    }
});
