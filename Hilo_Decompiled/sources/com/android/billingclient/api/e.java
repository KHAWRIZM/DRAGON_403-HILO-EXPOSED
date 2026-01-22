package com.android.billingclient.api;

import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f٦٩٧٠a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str) {
        this.f٦٩٧٠a = new JSONObject(str).optString("externalTransactionToken");
    }
}
