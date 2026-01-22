package com.alibaba.sdk.android.push.e.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.sdk.android.ams.common.util.StringUtil;
import com.alibaba.sdk.android.push.common.util.AppInfoUtil;
import com.alibaba.sdk.android.push.common.util.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements com.alibaba.sdk.android.ams.common.b.b {

    /* renamed from: b, reason: collision with root package name */
    private String f٦٦٥٢b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f٦٦٥٣c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f٦٦٥٤d = null;

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f٦٦٥١a = com.alibaba.sdk.android.ams.common.a.a.j();

    private static int a(Context context, String str) {
        return context.getResources().getIdentifier(str, "string", context.getPackageName());
    }

    private String f() {
        return "mps_deviceId_" + a();
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String b() {
        String str = this.f٦٦٥٤d;
        if (str != null) {
            return str;
        }
        String string = this.f٦٦٥١a.getString(f(), "");
        if (System.currentTimeMillis() - this.f٦٦٥١a.getLong("mps_device_store_time", 0L) > 604800000) {
            return "";
        }
        this.f٦٦٥٤d = string;
        return string;
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String c() {
        return this.f٦٦٥١a.getString("mps_utdid", "");
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String d() {
        if (!StringUtil.isEmpty(this.f٦٦٥٣c)) {
            return this.f٦٦٥٣c;
        }
        String a10 = com.alibaba.sdk.android.ams.common.a.a.a("com.alibaba.app.appsecret");
        this.f٦٦٥٣c = a10;
        if (!StringUtil.isEmpty(a10)) {
            return this.f٦٦٥٣c;
        }
        String b10 = b(com.alibaba.sdk.android.ams.common.a.a.b(), "ams_appSecret");
        this.f٦٦٥٣c = b10;
        return b10;
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String e() {
        return AppInfoUtil.getAppVersionName(com.alibaba.sdk.android.ams.common.a.a.b());
    }

    private static String b(Context context, String str) {
        try {
            return context.getResources().getString(a(context, str));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String a() {
        if (!StringUtil.isEmpty(this.f٦٦٥٢b)) {
            return this.f٦٦٥٢b;
        }
        String a10 = com.alibaba.sdk.android.ams.common.a.a.a("com.alibaba.app.appkey");
        this.f٦٦٥٢b = a10;
        if (!StringUtil.isEmpty(a10)) {
            return this.f٦٦٥٢b;
        }
        String b10 = b(com.alibaba.sdk.android.ams.common.a.a.b(), "ams_appKey");
        this.f٦٦٥٢b = b10;
        return b10;
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String c(String str) {
        return this.f٦٦٥١a.getString(str, "");
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public void d(String str) {
        this.f٦٦٥٢b = str;
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public void e(String str) {
        this.f٦٦٥٣c = str;
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public String a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        arrayList.add("appSecret");
        Collections.sort(arrayList);
        for (String str2 : arrayList) {
            if (!str2.equals("VipRequestType")) {
                boolean equals = "appSecret".equals(str2);
                sb.append(str2);
                sb.append(equals ? d() : map.get(str2));
            }
        }
        if (map.containsKey("VipRequestType")) {
            int parseInt = Integer.parseInt(map.get("VipRequestType"));
            map.remove("VipRequestType");
            if (parseInt > d.b()) {
                return com.alibaba.sdk.android.ams.common.util.b.a().a(sb.toString());
            }
        }
        return com.alibaba.sdk.android.ams.common.util.b.a().b(sb.toString());
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public void b(String str) {
        this.f٦٦٥١a.edit().putString("mps_utdid", str).commit();
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public void a(String str) {
        this.f٦٦٥٤d = str;
        this.f٦٦٥١a.edit().putString(f(), str).putLong("mps_device_store_time", System.currentTimeMillis()).commit();
    }

    @Override // com.alibaba.sdk.android.ams.common.b.b
    public void a(String str, String str2) {
        this.f٦٦٥١a.edit().putString(str, str2).commit();
    }
}
