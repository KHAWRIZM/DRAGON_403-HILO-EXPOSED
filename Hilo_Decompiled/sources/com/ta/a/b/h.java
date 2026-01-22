package com.ta.a.b;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class h implements Runnable {
    private static volatile boolean a;
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    private void a() {
        com.ta.a.c.f.e();
        if (com.ta.a.c.d.b(this.mContext) && !a) {
            a = true;
            try {
                b();
            } catch (Throwable unused) {
            }
            a = false;
        }
    }

    private void b() {
        com.ta.a.c.f.e();
        String e = e();
        if (TextUtils.isEmpty(e)) {
            com.ta.a.c.f.m١٢٧a("postData is empty", new Object[0]);
        } else if (a(e)) {
            com.ta.a.c.f.m١٢٧a("", "upload success");
        } else {
            com.ta.a.c.f.m١٢٧a("", "upload fail");
        }
    }

    private String e() {
        String m = com.ta.utdid2.device.a.a().m();
        if (TextUtils.isEmpty(m)) {
            return null;
        }
        String a2 = com.ta.a.a.a.a(m);
        if (com.ta.a.c.f.m١٢٨a()) {
            com.ta.a.c.f.b("", a2);
        }
        return com.ta.a.a.b.b(a2);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable th) {
            com.ta.a.c.f.a("", th, new Object[0]);
        }
    }

    private boolean a(String str) {
        a a2 = b.a("https://mpush-api.aliyun.com/v2.0/a/audid/req/", str, true);
        if (a2 == null) {
            return false;
        }
        return com.ta.utdid2.device.e.a(a2);
    }
}
