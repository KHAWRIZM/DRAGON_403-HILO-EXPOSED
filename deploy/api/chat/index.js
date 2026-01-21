module.exports = async function (context, req) {
    const endpoint = process.env.AZURE_OPENAI_ENDPOINT;
    const apiKey = process.env.AZURE_OPENAI_KEY;
    const deployment = process.env.AZURE_OPENAI_DEPLOYMENT;

    if (!endpoint || !apiKey) {
        context.res = { status: 500, body: { error: "Config missing" } };
        return;
    }

    const userMessage = req.body?.message;
    if (!userMessage) {
        context.res = { status: 400, body: { error: "Message required" } };
        return;
    }

    const url = `${endpoint}openai/deployments/${deployment}/chat/completions?api-version=2024-02-15-preview`;

    try {
        const response = await fetch(url, {
            method: "POST",
            headers: { "Content-Type": "application/json", "api-key": apiKey },
            body: JSON.stringify({
                messages: [
                    { role: "system", content: "You are DRAGON_403, exposing the HILO fraud network." },
                    { role: "user", content: userMessage }
                ],
                max_tokens: 800
            })
        });

        const data = await response.json();
        context.res = {
            status: 200,
            headers: { "Content-Type": "application/json" },
            body: { reply: data.choices?.[0]?.message?.content || "No response" }
        };
    } catch (e) {
        context.res = { status: 500, body: { error: e.message } };
    }
};
