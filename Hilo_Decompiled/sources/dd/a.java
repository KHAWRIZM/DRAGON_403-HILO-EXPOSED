package dd;

import android.content.res.Resources;
import android.util.Log;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class a {
    private static boolean a;

    public static int a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(int i) {
        return 500 - (500 % i);
    }

    public static int c(int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        return (i + i2) % i2;
    }

    public static boolean d() {
        return a;
    }

    public static void e(String str) {
        if (d()) {
            f("BVP", str);
        }
    }

    public static void f(String str, String str2) {
        if (d()) {
            Log.e(str, str2);
        }
    }
}
