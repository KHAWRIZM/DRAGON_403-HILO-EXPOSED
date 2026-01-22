package com.alibaba.sdk.android.push.d;

import android.app.Application;
import android.content.Context;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AmsLogger f٦٦٤٧a = AmsLogger.getLogger("MPS:ReportManager");

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f٦٦٤٨b = null;

    /* renamed from: c, reason: collision with root package name */
    private long f٦٦٤٩c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٦٦٥٠d = true;

    private a(Context context) {
        this.f٦٦٤٩c = 0L;
        if (context != null && (context.getApplicationContext() instanceof Application) && this.f٦٦٤٩c == 0) {
            this.f٦٦٤٩c = System.currentTimeMillis();
        }
    }

    public static a a() {
        return f٦٦٤٨b;
    }

    public static a a(Context context) {
        if (f٦٦٤٨b == null) {
            synchronized (a.class) {
                try {
                    if (f٦٦٤٨b == null) {
                        f٦٦٤٨b = new a(context);
                    }
                } finally {
                }
            }
        }
        return f٦٦٤٨b;
    }

    public void a(String str) {
    }

    public void a(String str, String str2, int i10) {
        if (this.f٦٦٥٠d) {
            return;
        }
        f٦٦٤٧a.e("report switch turned off");
    }

    public void a(String str, String str2, long j10) {
        if (this.f٦٦٥٠d) {
            return;
        }
        f٦٦٤٧a.e("report switch turned off");
    }

    public void a(String str, String str2, String str3) {
        if (this.f٦٦٥٠d) {
            return;
        }
        f٦٦٤٧a.e("report switch turned off");
    }

    public void a(String str, String str2, String str3, String str4) {
        if (this.f٦٦٥٠d) {
            return;
        }
        f٦٦٤٧a.e("report switch turned off");
    }

    public void a(boolean z10) {
        synchronized (a.class) {
            this.f٦٦٥٠d = z10;
        }
    }
}
