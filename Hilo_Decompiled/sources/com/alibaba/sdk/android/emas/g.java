package com.alibaba.sdk.android.emas;

import android.text.TextUtils;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g {

    /* renamed from: h, reason: collision with root package name */
    String f٦٤١٢h;

    /* renamed from: i, reason: collision with root package name */
    String f٦٤١٣i;
    long timestamp;

    public g(String str, String str2, long j10) {
        this.f٦٤١٣i = str;
        this.f٦٤١٢h = str2;
        this.timestamp = j10;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eventId", this.f٦٤١٣i);
            jSONObject.put("rawLog", this.f٦٤١٢h);
            jSONObject.put(HeaderInterceptor.TIMESTAMP, this.timestamp);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public int length() {
        return this.f٦٤١٢h.getBytes(Charset.forName("UTF-8")).length;
    }

    public static g a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("eventId");
        String optString2 = jSONObject.optString("rawLog");
        long optLong = jSONObject.optLong(HeaderInterceptor.TIMESTAMP);
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || optLong == 0) {
            return null;
        }
        return new g(optString, optString2, optLong);
    }
}
