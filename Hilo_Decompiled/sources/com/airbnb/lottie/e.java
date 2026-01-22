package com.airbnb.lottie;

import android.content.Context;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f٦١٦٠a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f٦١٦١b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f٦١٦٢c = true;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f٦١٦٣d = true;

    /* renamed from: e, reason: collision with root package name */
    private static a f٦١٦٤e = a.AUTOMATIC;

    /* renamed from: f, reason: collision with root package name */
    private static u3.f f٦١٦٥f;

    /* renamed from: g, reason: collision with root package name */
    private static u3.e f٦١٦٦g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile u3.h f٦١٦٧h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile u3.g f٦١٦٨i;

    /* renamed from: j, reason: collision with root package name */
    private static ThreadLocal f٦١٦٩j;

    public static void b(String str) {
        if (!f٦١٦١b) {
            return;
        }
        f().a(str);
    }

    public static float c(String str) {
        if (!f٦١٦١b) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return f().b(str);
    }

    public static a d() {
        return f٦١٦٤e;
    }

    public static boolean e() {
        return f٦١٦٣d;
    }

    private static x3.h f() {
        x3.h hVar = (x3.h) f٦١٦٩j.get();
        if (hVar == null) {
            x3.h hVar2 = new x3.h();
            f٦١٦٩j.set(hVar2);
            return hVar2;
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ File g(Context context) {
        return new File(context.getCacheDir(), "lottie_network_cache");
    }

    public static u3.g h(Context context) {
        if (!f٦١٦٢c) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        u3.g gVar = f٦١٦٨i;
        if (gVar == null) {
            synchronized (u3.g.class) {
                try {
                    gVar = f٦١٦٨i;
                    if (gVar == null) {
                        u3.e eVar = f٦١٦٦g;
                        if (eVar == null) {
                            eVar = new u3.e() { // from class: com.airbnb.lottie.d
                                @Override // u3.e
                                public final File a() {
                                    File g10;
                                    g10 = e.g(applicationContext);
                                    return g10;
                                }
                            };
                        }
                        gVar = new u3.g(eVar);
                        f٦١٦٨i = gVar;
                    }
                } finally {
                }
            }
        }
        return gVar;
    }

    public static u3.h i(Context context) {
        u3.h hVar = f٦١٦٧h;
        if (hVar == null) {
            synchronized (u3.h.class) {
                try {
                    hVar = f٦١٦٧h;
                    if (hVar == null) {
                        u3.g h10 = h(context);
                        u3.f fVar = f٦١٦٥f;
                        if (fVar == null) {
                            fVar = new u3.b();
                        }
                        hVar = new u3.h(h10, fVar);
                        f٦١٦٧h = hVar;
                    }
                } finally {
                }
            }
        }
        return hVar;
    }
}
