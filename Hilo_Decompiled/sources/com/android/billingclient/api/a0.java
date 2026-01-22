package com.android.billingclient.api;

import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f٦٩٤٩a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(String str) {
        this.f٦٩٤٩a = new JSONObject(str).optString("externalTransactionToken");
    }
}
