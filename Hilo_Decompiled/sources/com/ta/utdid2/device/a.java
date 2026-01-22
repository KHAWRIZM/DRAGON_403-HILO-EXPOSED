package com.ta.utdid2.device;

import android.content.Context;
import android.text.TextUtils;
import com.qiahao.nextvideo.view.youtube.FadeViewHelper;
import com.ta.a.b.h;
import com.ta.a.c.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    private static final a a = new a();
    private static long c = FadeViewHelper.DEFAULT_FADE_OUT_DELAY;
    private String d = "";

    private a() {
    }

    public static a a() {
        return a;
    }

    private void f() {
        f.e();
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        try {
            final Context context = com.ta.a.a.a().getContext();
            boolean z = c.m١٢٩c(context);
            f.m١٢٧a("", "isMainProcess", Boolean.valueOf(z));
            if (!z) {
                return;
            }
            new Thread(new Runnable() { // from class: com.ta.utdid2.device.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(a.c);
                    } catch (Exception unused) {
                    }
                    if (!com.ta.a.b.e.m١٢٥a(context)) {
                        f.m١٢٧a("", "unable upload!");
                    } else {
                        new h(context).run();
                    }
                }
            }).start();
        } catch (Throwable th) {
            f.m١٢٧a("", th);
        }
    }

    private String l() {
        if (com.ta.a.a.a().getContext() == null) {
            return "";
        }
        String d = com.ta.a.b.e.d();
        if (d.m١٣٠c(d)) {
            f.m١٢٧a("AppUtdid", "read utdid from V5AppFile");
            d.setType(7);
            return d;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getUtdid(Context context) {
        if (!TextUtils.isEmpty(this.d)) {
            return this.d;
        }
        try {
            com.ta.a.c.c.c();
            String l = l();
            if (TextUtils.isEmpty(l)) {
                l = d.a(context).getValue();
            }
            if (!TextUtils.isEmpty(l)) {
                this.d = l;
                f();
                return this.d;
            }
            return "ffffffffffffffffffffffff";
        } catch (Throwable th) {
            try {
                f.a("AppUtdid", th, new Object[0]);
                return "ffffffffffffffffffffffff";
            } finally {
                com.ta.a.c.c.d();
            }
        }
    }

    public synchronized String m() {
        return this.d;
    }
}
