package tech.sud.runtime.component.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.n2;
import java.util.List;
import org.android.agoo.message.MessageService;
import tech.sud.runtime.component.c.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class g {
    private static int a = -1;
    private static int b = -1;

    /* renamed from: tech.sud.runtime.component.c.g$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.a.values().length];
            a = iArr;
            try {
                iArr[b.a.huawei.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.a.xiaomi.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.a.oppo.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.a.vivo.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.a.smartisan.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static boolean a(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return b(context);
        }
        if (i < 26) {
            return false;
        }
        int i2 = AnonymousClass1.a[b.a().ordinal()];
        if (i2 == 1) {
            return c(context);
        }
        if (i2 == 2) {
            return a();
        }
        if (i2 == 3) {
            return f(context);
        }
        if (i2 == 4) {
            return g(context);
        }
        if (i2 != 5) {
            return false;
        }
        return h(context);
    }

    public static int b() {
        return 82;
    }

    public static int c() {
        return 104;
    }

    public static boolean d(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), "display_notch_status", 0) == 1) {
            return false;
        }
        return true;
    }

    public static boolean e(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "force_black", 0) == 1) {
            return false;
        }
        return true;
    }

    public static boolean f(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean g(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean h(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("smartisanos.api.DisplayUtilsSmt");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 1)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
    
        r6 = r6.getBoundingRects();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] i(Context context) {
        List boundingRects;
        Rect rect;
        int[] iArr = {0, 0};
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            WindowInsets a2 = com.google.android.material.bottomsheet.a.a(((Activity) context).getWindow().getDecorView());
            if (a2 != null && (r6 = n2.a(a2)) != null && boundingRects != null && boundingRects.size() > 0 && (rect = (Rect) boundingRects.get(0)) != null) {
                iArr[0] = rect.width();
                iArr[1] = rect.height();
                return iArr;
            }
        } else if (i >= 26) {
            int i2 = AnonymousClass1.a[b.a().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3 && i2 != 4) {
                        if (i2 == 5) {
                            iArr[0] = c();
                            iArr[1] = b();
                            return iArr;
                        }
                    } else {
                        iArr[1] = m(context);
                        return iArr;
                    }
                } else {
                    iArr[0] = k(context);
                    iArr[1] = l(context);
                    return iArr;
                }
            } else {
                int[] j = j(context);
                iArr[0] = j[0];
                iArr[1] = j[1];
            }
        }
        return iArr;
    }

    public static int[] j(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) loadClass.getMethod("getNotchSize", null).invoke(loadClass, null);
        } catch (Exception e) {
            e.printStackTrace();
            return iArr;
        }
    }

    public static int k(Context context) {
        int identifier;
        if (a == -1 && (identifier = context.getResources().getIdentifier("notch_width", "dimen", "android")) > 0) {
            a = context.getResources().getDimensionPixelSize(identifier);
        }
        return a;
    }

    public static int l(Context context) {
        int identifier;
        if (b == -1 && (identifier = context.getResources().getIdentifier("notch_height", "dimen", "android")) > 0) {
            b = context.getResources().getDimensionPixelSize(identifier);
        }
        return b;
    }

    public static int m(Context context) {
        int identifier;
        if (b == -1 && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            b = context.getResources().getDimensionPixelSize(identifier);
        }
        return b;
    }

    public static void n(Context context) {
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        q6.c.a(attributes, 2);
        window.setAttributes(attributes);
    }

    public static void o(Context context) {
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        q6.c.a(attributes, 1);
        window.setAttributes(attributes);
    }

    public static void p(Context context) {
        try {
            Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(((Activity) context).getWindow(), 1792);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void q(Context context) {
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        try {
            Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
            cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
            ((Activity) context).getWindowManager().updateViewLayout(window.getDecorView(), window.getDecorView().getLayoutParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean b(Context context) {
        DisplayCutout a2;
        List boundingRects;
        WindowInsets a3 = com.google.android.material.bottomsheet.a.a(((Activity) context).getWindow().getDecorView());
        if (a3 != null && (a2 = n2.a(a3)) != null) {
            boundingRects = a2.getBoundingRects();
            if (boundingRects != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", null).invoke(loadClass, null)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a() {
        return j.a().a("ro.miui.notch").equals(MessageService.MSG_DB_NOTIFY_REACHED);
    }
}
