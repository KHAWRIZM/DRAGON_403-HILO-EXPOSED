package ic;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.util.DisplayMetrics;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final float f١٤٨٧٤a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f١٤٨٧٥b = null;

    public static int a(Context context, int i10) {
        return (int) ((c(context) * i10) + 0.5d);
    }

    public static int b(int i10) {
        return (int) ((i10 * f١٤٨٧٤a) + 0.5f);
    }

    public static float c(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static DisplayMetrics d(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static float e(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    private static int f(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    public static int g(Context context) {
        int i10 = d(context).heightPixels;
        if (d.o() && l(context)) {
            return i10 + f(context);
        }
        return i10;
    }

    public static int h(Context context) {
        if (d.o()) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier <= 0) {
                return 0;
            }
            return context.getResources().getDimensionPixelSize(identifier);
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            int parseInt = Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString());
            if (parseInt > 0) {
                return context.getResources().getDimensionPixelSize(parseInt);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return 0;
    }

    public static boolean i(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), "display_notch_status", 0) != 0) {
            return false;
        }
        return true;
    }

    public static int j(Context context, int i10) {
        return (int) ((i10 / c(context)) + 0.5d);
    }

    public static int k(Context context, int i10) {
        return (int) ((e(context) * i10) + 0.5d);
    }

    public static boolean l(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
            return false;
        }
        return true;
    }
}
