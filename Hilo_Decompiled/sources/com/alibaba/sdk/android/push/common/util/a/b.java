package com.alibaba.sdk.android.push.common.util.a;

import com.alibaba.sdk.android.error.ErrorCode;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f٦٦١٦a;

    /* renamed from: b, reason: collision with root package name */
    public int f٦٦١٧b;

    /* renamed from: c, reason: collision with root package name */
    public ErrorCode f٦٦١٨c;

    /* renamed from: d, reason: collision with root package name */
    public d f٦٦١٩d;

    public b() {
        this.f٦٦١٨c = com.alibaba.sdk.android.push.common.a.d.f٦٥٨٩a;
        this.f٦٦١٦a = "";
        this.f٦٦١٧b = 0;
        this.f٦٦١٩d = d.UNKNOWN_TYPE;
    }

    public b(int i10) {
        this.f٦٦١٨c = com.alibaba.sdk.android.push.common.a.d.f٦٥٨٩a;
        for (d dVar : d.values()) {
            if (dVar.a() == i10) {
                this.f٦٦١٩d = dVar;
            }
        }
        this.f٦٦١٦a = "";
        this.f٦٦١٧b = 0;
    }
}
