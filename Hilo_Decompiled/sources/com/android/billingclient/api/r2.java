package com.android.billingclient.api;

import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class r2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f٧١٤٤a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٧١٤٥b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r2(JSONObject jSONObject) {
        this.f٧١٤٤a = jSONObject.getString("rentalPeriod");
        String optString = jSONObject.optString("rentalExpirationPeriod");
        this.f٧١٤٥b = true == optString.isEmpty() ? null : optString;
    }
}
