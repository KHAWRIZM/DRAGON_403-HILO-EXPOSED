package com.android.billingclient.api;

import com.android.billingclient.api.e0;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class t2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f٧١٥٥a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٧١٥٦b;

    /* renamed from: c, reason: collision with root package name */
    private final String f٧١٥٧c;

    /* renamed from: d, reason: collision with root package name */
    private final String f٧١٥٨d;

    /* renamed from: e, reason: collision with root package name */
    private final String f٧١٥٩e;

    /* renamed from: f, reason: collision with root package name */
    private final e0.c f٧١٦٠f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t2(JSONObject jSONObject) {
        e0.c cVar;
        this.f٧١٥٥a = jSONObject.getString("productId");
        this.f٧١٥٦b = jSONObject.optString("title");
        this.f٧١٥٧c = jSONObject.optString("name");
        this.f٧١٥٨d = jSONObject.optString("description");
        this.f٧١٥٩e = jSONObject.optString("basePlanId");
        JSONObject optJSONObject = jSONObject.optJSONObject("pricingPhase");
        if (optJSONObject == null) {
            cVar = null;
        } else {
            cVar = new e0.c(optJSONObject);
        }
        this.f٧١٦٠f = cVar;
    }
}
