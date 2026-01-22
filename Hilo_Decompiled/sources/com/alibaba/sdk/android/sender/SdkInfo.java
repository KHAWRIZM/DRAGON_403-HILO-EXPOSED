package com.alibaba.sdk.android.sender;

import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SdkInfo {

    /* renamed from: a, reason: collision with root package name */
    Map<String, String> f٦٨٠٥a;

    /* renamed from: b, reason: collision with root package name */
    private String f٦٨٠٦b;

    /* renamed from: c, reason: collision with root package name */
    private String f٦٨٠٧c;

    /* renamed from: d, reason: collision with root package name */
    private String f٦٨٠٨d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f٦٨٠٦b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f٦٨٠٧c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.f٦٨٠٨d;
    }

    public SdkInfo setAppKey(String str) {
        this.f٦٨٠٨d = str;
        return this;
    }

    public SdkInfo setExt(Map<String, String> map) {
        this.f٦٨٠٥a = map;
        return this;
    }

    public SdkInfo setSdkId(String str) {
        this.f٦٨٠٦b = str;
        return this;
    }

    public SdkInfo setSdkVersion(String str) {
        this.f٦٨٠٧c = str;
        return this;
    }
}
