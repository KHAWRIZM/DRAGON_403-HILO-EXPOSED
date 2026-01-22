package p9;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private Context f١٦٩٧٩a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f١٦٩٨٠b;

    /* renamed from: c, reason: collision with root package name */
    private Object f١٦٩٨١c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static e f١٦٩٨٢a = new e();
    }

    public static e b() {
        return b.f١٦٩٨٢a;
    }

    private SharedPreferences c() {
        Context context;
        SharedPreferences sharedPreferences = this.f١٦٩٨٠b;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.f١٦٩٨١c) {
            try {
                SharedPreferences sharedPreferences2 = this.f١٦٩٨٠b;
                if (sharedPreferences2 == null && (context = this.f١٦٩٧٩a) != null) {
                    SharedPreferences sharedPreferences3 = context.getSharedPreferences("shared_msg_sdk", 0);
                    this.f١٦٩٨٠b = sharedPreferences3;
                    return sharedPreferences3;
                }
                return sharedPreferences2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Context d(Context context) {
        Context createDeviceProtectedStorageContext;
        boolean b10 = p9.a.b();
        d.a("fbeVersion is " + b10);
        if (b10 && Build.VERSION.SDK_INT >= 24) {
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            return createDeviceProtectedStorageContext;
        }
        return context.getApplicationContext();
    }

    public String a() {
        SharedPreferences c10 = c();
        if (c10 == null) {
            return "DES";
        }
        return c10.getString("decryptTag", "DES");
    }

    public boolean e() {
        SharedPreferences c10 = c();
        if (c10 == null) {
            return false;
        }
        return c10.getBoolean("hasDefaultChannelCreated", false);
    }

    public void f(String str) {
        SharedPreferences c10 = c();
        if (c10 != null) {
            c10.edit().putString("decryptTag", str).commit();
        }
    }

    public void g(boolean z10) {
        SharedPreferences c10 = c();
        if (c10 != null) {
            c10.edit().putBoolean("hasDefaultChannelCreated", z10).commit();
        }
    }

    private e() {
        this.f١٦٩٨١c = new Object();
        Context f10 = i9.d.h().f();
        if (f10 != null) {
            this.f١٦٩٧٩a = d(f10);
        }
        Context context = this.f١٦٩٧٩a;
        if (context != null) {
            this.f١٦٩٨٠b = context.getSharedPreferences("shared_msg_sdk", 0);
        }
    }
}
