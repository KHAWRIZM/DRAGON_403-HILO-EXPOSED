package com.android.billingclient.api;

import android.text.TextUtils;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class PurchaseHistoryRecord {

    /* renamed from: a, reason: collision with root package name */
    private final String f٦٩٤٤a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٦٩٤٥b;

    /* renamed from: c, reason: collision with root package name */
    private final JSONObject f٦٩٤٦c;

    public PurchaseHistoryRecord(String str, String str2) {
        this.f٦٩٤٤a = str;
        this.f٦٩٤٥b = str2;
        this.f٦٩٤٦c = new JSONObject(str);
    }

    public String a() {
        return this.f٦٩٤٤a;
    }

    public String b() {
        JSONObject jSONObject = this.f٦٩٤٦c;
        return jSONObject.optString(HeaderInterceptor.TOKEN, jSONObject.optString("purchaseToken"));
    }

    public String c() {
        return this.f٦٩٤٥b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseHistoryRecord)) {
            return false;
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
        if (TextUtils.equals(this.f٦٩٤٤a, purchaseHistoryRecord.a()) && TextUtils.equals(this.f٦٩٤٥b, purchaseHistoryRecord.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f٦٩٤٤a.hashCode();
    }

    public String toString() {
        return "PurchaseHistoryRecord. Json: ".concat(String.valueOf(this.f٦٩٤٤a));
    }
}
