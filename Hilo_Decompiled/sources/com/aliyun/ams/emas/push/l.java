package com.aliyun.ams.emas.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.alibaba.sdk.android.logger.ILog;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.taobao.accs.utl.AccsLogger;
import java.util.Random;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final ILog f٦٨٩٨a = AccsLogger.getLogger("[MPS]");

    /* renamed from: b, reason: collision with root package name */
    public static String f٦٨٩٩b = "com.alibaba.sdk.android.push.NOTIFY_ACTION";

    /* renamed from: c, reason: collision with root package name */
    private static Class f٦٩٠٠c = null;

    /* renamed from: d, reason: collision with root package name */
    private static j f٦٩٠١d = null;

    /* renamed from: e, reason: collision with root package name */
    private static d f٦٩٠٢e = null;

    /* renamed from: f, reason: collision with root package name */
    private static int f٦٩٠٣f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static int f٦٩٠٤g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static SharedPreferences f٦٩٠٥h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Random f٦٩٠٦i = null;

    public static Class a() {
        return f٦٩٠٠c;
    }

    public static void b(int i10, int i11, int i12, int i13, a aVar) {
        f٦٩٠١d.a(i10, i11, i12, i13, aVar);
    }

    public static void c(Context context) {
        f٦٩٠١d = new j(context.getApplicationContext());
        f٦٩٠٥h = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    }

    public static void d(Context context, String str, int i10) {
        d dVar = f٦٩٠٢e;
        if (dVar != null) {
            dVar.reportPushArrive(context, str, i10);
        }
    }

    public static void e(d dVar) {
        f٦٩٠٢e = dVar;
    }

    public static void f(CPushMessage cPushMessage) {
        f٦٩٠١d.b(cPushMessage);
    }

    public static void g(Class cls) {
        f٦٩٠٠c = cls;
    }

    public static void h(boolean z10) {
        f٦٩٠١d.c(z10);
    }

    public static void i(CPushMessage cPushMessage) {
        f٦٩٠١d.e(cPushMessage);
    }

    public static boolean j() {
        return f٦٩٠١d.d();
    }

    public static int k() {
        if (f٦٩٠٤g == 0) {
            if (f٦٩٠٦i == null) {
                f٦٩٠٦i = new Random(System.currentTimeMillis());
            }
            int nextInt = f٦٩٠٦i.nextInt(1000000);
            f٦٩٠٤g = nextInt;
            if (nextInt < 0) {
                f٦٩٠٤g = nextInt * (-1);
            }
        }
        int i10 = f٦٩٠٤g;
        f٦٩٠٤g = i10 + 1;
        return i10;
    }

    public static int l() {
        if (f٦٩٠٣f == 0) {
            if (f٦٩٠٦i == null) {
                f٦٩٠٦i = new Random(System.currentTimeMillis());
            }
            int nextInt = f٦٩٠٦i.nextInt(1000000);
            f٦٩٠٣f = nextInt;
            if (nextInt < 0) {
                f٦٩٠٣f = nextInt * (-1);
            }
        }
        int i10 = f٦٩٠٣f;
        f٦٩٠٣f = i10 + 1;
        return i10;
    }
}
