package com.alibaba.sdk.android.crashdefend.a;

import com.alibaba.sdk.android.crashdefend.CrashDefendCallback;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f٦٣٧٥a;

    /* renamed from: b, reason: collision with root package name */
    public String f٦٣٧٦b;

    /* renamed from: c, reason: collision with root package name */
    public int f٦٣٧٧c;

    /* renamed from: d, reason: collision with root package name */
    public int f٦٣٧٨d;

    /* renamed from: e, reason: collision with root package name */
    public int f٦٣٧٩e;

    /* renamed from: f, reason: collision with root package name */
    public long f٦٣٨٠f;

    /* renamed from: g, reason: collision with root package name */
    public long f٦٣٨١g;

    /* renamed from: h, reason: collision with root package name */
    public int f٦٣٨٢h = 0;

    /* renamed from: i, reason: collision with root package name */
    public long f٦٣٨٣i = 0;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f٦٣٨٤j = false;

    /* renamed from: k, reason: collision with root package name */
    public CrashDefendCallback f٦٣٨٥k = null;

    public Object clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException e10) {
            com.alibaba.sdk.android.crashdefend.c.b.a("CrashSDK", "clone fail: ", e10);
            return null;
        }
    }
}
