package ic;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.graphics.b0;
import androidx.core.view.d1;
import androidx.core.view.d2;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f١٤٨٧٨a;

    /* renamed from: b, reason: collision with root package name */
    private static Rect f١٤٨٧٩b;

    /* renamed from: c, reason: collision with root package name */
    private static Rect f١٤٨٨٠c;

    /* renamed from: d, reason: collision with root package name */
    private static Rect f١٤٨٨١d;

    /* renamed from: e, reason: collision with root package name */
    private static Rect f١٤٨٨٢e;

    /* renamed from: f, reason: collision with root package name */
    private static int[] f١٤٨٨٣f;

    /* renamed from: g, reason: collision with root package name */
    private static Boolean f١٤٨٨٤g;

    private static boolean a(View view) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        rootWindowInsets = view.getRootWindowInsets();
        boolean z10 = false;
        if (rootWindowInsets != null) {
            displayCutout = rootWindowInsets.getDisplayCutout();
            if (displayCutout != null) {
                z10 = true;
            }
            f١٤٨٧٨a = Boolean.valueOf(z10);
            return true;
        }
        return false;
    }

    private static void b() {
        f١٤٨٨٠c = null;
        f١٤٨٨٢e = null;
    }

    private static Rect c(Context context) {
        if (d.i()) {
            boolean i10 = e.i(context);
            Boolean bool = f١٤٨٨٤g;
            if (bool != null && bool.booleanValue() != i10) {
                b();
            }
            f١٤٨٨٤g = Boolean.valueOf(i10);
        }
        int q10 = q(context);
        if (q10 == 1) {
            if (f١٤٨٨٠c == null) {
                f١٤٨٨٠c = k(context);
            }
            return f١٤٨٨٠c;
        }
        if (q10 == 2) {
            if (f١٤٨٨١d == null) {
                f١٤٨٨١d = i(context);
            }
            return f١٤٨٨١d;
        }
        if (q10 == 3) {
            if (f١٤٨٨٢e == null) {
                f١٤٨٨٢e = j(context);
            }
            return f١٤٨٨٢e;
        }
        if (f١٤٨٧٩b == null) {
            f١٤٨٧٩b = h(context);
        }
        return f١٤٨٧٩b;
    }

    public static int d(Context context) {
        return e.a(context, 27);
    }

    public static int e(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return e.h(context);
    }

    public static int[] f(Context context) {
        if (f١٤٨٨٣f == null) {
            f١٤٨٨٣f = new int[]{0, 0};
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                f١٤٨٨٣f = (int[]) loadClass.getMethod("getNotchSize", null).invoke(loadClass, null);
            } catch (ClassNotFoundException unused) {
                Log.e("QMUINotchHelper", "getNotchSizeInHuawei ClassNotFoundException");
            } catch (NoSuchMethodException unused2) {
                Log.e("QMUINotchHelper", "getNotchSizeInHuawei NoSuchMethodException");
            } catch (Exception unused3) {
                Log.e("QMUINotchHelper", "getNotchSizeInHuawei Exception");
            }
        }
        return f١٤٨٨٣f;
    }

    private static void g(View view, Rect rect) {
        d2 K;
        if (view == null || (K = d1.K(view)) == null) {
            return;
        }
        b0 f10 = K.f(d2.m.g() | d2.m.a());
        rect.set(f10.f٢٧٩٣a, f10.f٢٧٩٤b, f10.f٢٧٩٥c, f10.f٢٧٩٦d);
    }

    private static Rect h(Context context) {
        Rect rect = new Rect();
        if (d.n()) {
            rect.top = d(context);
            rect.bottom = 0;
        } else if (d.l()) {
            rect.top = j.a(context);
            rect.bottom = 0;
        } else if (d.i()) {
            rect.top = f(context)[1];
            rect.bottom = 0;
        } else if (d.o()) {
            rect.top = e(context);
            rect.bottom = 0;
        }
        return rect;
    }

    private static Rect i(Context context) {
        Rect rect = new Rect();
        if (d.n()) {
            rect.top = 0;
            rect.bottom = d(context);
        } else if (d.l()) {
            rect.top = 0;
            rect.bottom = j.a(context);
        } else if (d.i()) {
            int[] f10 = f(context);
            rect.top = 0;
            rect.bottom = f10[1];
        } else if (d.o()) {
            rect.top = 0;
            rect.bottom = e(context);
        }
        return rect;
    }

    private static Rect j(Context context) {
        Rect rect = new Rect();
        if (d.n()) {
            rect.right = d(context);
            rect.left = 0;
        } else if (d.l()) {
            rect.right = j.a(context);
            rect.left = 0;
        } else if (d.i()) {
            if (f١٤٨٨٤g.booleanValue()) {
                rect.right = f(context)[1];
            } else {
                rect.right = 0;
            }
            rect.left = 0;
        } else if (d.o()) {
            rect.right = e(context);
            rect.left = 0;
        }
        return rect;
    }

    private static Rect k(Context context) {
        Rect rect = new Rect();
        if (d.n()) {
            rect.left = d(context);
            rect.right = 0;
        } else if (d.l()) {
            rect.left = j.a(context);
            rect.right = 0;
        } else if (d.i()) {
            if (f١٤٨٨٤g.booleanValue()) {
                rect.left = f(context)[1];
            } else {
                rect.left = 0;
            }
            rect.right = 0;
        } else if (d.o()) {
            rect.left = e(context);
            rect.right = 0;
        }
        return rect;
    }

    public static int l(View view) {
        if (!s(view)) {
            return 0;
        }
        return n(view).bottom;
    }

    public static int m(View view) {
        if (!s(view)) {
            return 0;
        }
        return n(view).left;
    }

    private static Rect n(View view) {
        if (x()) {
            Rect rect = new Rect();
            g(view, rect);
            return rect;
        }
        return c(view.getContext());
    }

    public static int o(View view) {
        if (!s(view)) {
            return 0;
        }
        return n(view).right;
    }

    public static int p(View view) {
        if (!s(view)) {
            return 0;
        }
        return n(view).top;
    }

    private static int q(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        return defaultDisplay.getRotation();
    }

    public static boolean r(Context context) {
        if (d.i()) {
            return t(context);
        }
        if (d.n()) {
            return v(context);
        }
        if (d.l()) {
            return u(context);
        }
        if (d.o()) {
            return w(context);
        }
        return false;
    }

    public static boolean s(View view) {
        if (f١٤٨٧٨a == null) {
            if (x()) {
                if (!a(view)) {
                    return false;
                }
            } else {
                f١٤٨٧٨a = Boolean.valueOf(r(view.getContext()));
            }
        }
        return f١٤٨٧٨a.booleanValue();
    }

    public static boolean t(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", null).invoke(loadClass, null)).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.i("QMUINotchHelper", "hasNotchInHuawei ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            Log.e("QMUINotchHelper", "hasNotchInHuawei NoSuchMethodException");
            return false;
        } catch (Exception unused3) {
            Log.e("QMUINotchHelper", "hasNotchInHuawei Exception");
            return false;
        }
    }

    public static boolean u(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean v(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            Method[] declaredMethods = loadClass.getDeclaredMethods();
            if (declaredMethods == null) {
                return false;
            }
            for (Method method : declaredMethods) {
                if (method.getName().equalsIgnoreCase("isFeatureSupport")) {
                    return ((Boolean) method.invoke(loadClass, 32)).booleanValue();
                }
            }
            return false;
        } catch (ClassNotFoundException unused) {
            Log.i("QMUINotchHelper", "hasNotchInVivo ClassNotFoundException");
            return false;
        } catch (Exception unused2) {
            Log.e("QMUINotchHelper", "hasNotchInVivo Exception");
            return false;
        }
    }

    public static boolean w(Context context) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", String.class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            if (((Integer) declaredMethod.invoke(null, "ro.miui.notch", 0)).intValue() == 1) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean x() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }
}
