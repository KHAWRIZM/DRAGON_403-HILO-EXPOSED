package f7;

import android.os.Build;
import android.util.Log;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {
    private static String a(String str, String str2) {
        String str3 = str + str2;
        if (str3.length() > 23) {
            return str3.substring(0, 23);
        }
        return str3;
    }

    public static void b(String str, String str2, Object obj) {
        String e10 = e(str);
        if (Log.isLoggable(e10, 3)) {
            Log.d(e10, String.format(str2, obj));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        String e10 = e(str);
        if (Log.isLoggable(e10, 3)) {
            Log.d(e10, String.format(str2, objArr));
        }
    }

    public static void d(String str, String str2, Throwable th) {
        String e10 = e(str);
        if (Log.isLoggable(e10, 6)) {
            Log.e(e10, str2, th);
        }
    }

    private static String e(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return a("TRuntime.", str);
        }
        return "TRuntime." + str;
    }

    public static void f(String str, String str2, Object obj) {
        String e10 = e(str);
        if (Log.isLoggable(e10, 4)) {
            Log.i(e10, String.format(str2, obj));
        }
    }

    public static void g(String str, String str2, Object obj) {
        String e10 = e(str);
        if (Log.isLoggable(e10, 5)) {
            Log.w(e10, String.format(str2, obj));
        }
    }
}
