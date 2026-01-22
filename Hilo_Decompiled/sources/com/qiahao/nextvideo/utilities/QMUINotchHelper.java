package com.qiahao.nextvideo.utilities;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.n2;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class QMUINotchHelper {
    private static final String MIUI_NOTCH = "ro.miui.notch";
    private static final int NOTCH_IN_SCREEN_VOIO = 32;
    private static final String TAG = "QMUINotchHelper";
    private static Boolean sHasNotch;
    private static Boolean sHuaweiIsNotchSetToShow;
    private static int[] sNotchSizeInHawei;
    private static Rect sRotation0SafeInset;
    private static Rect sRotation180SafeInset;
    private static Rect sRotation270SafeInset;
    private static Rect sRotation90SafeInset;

    @TargetApi(28)
    private static boolean attachHasOfficialNotch(View view) {
        WindowInsets a = com.google.android.material.bottomsheet.a.a(view);
        boolean z = false;
        if (a == null) {
            return false;
        }
        if (n2.a(a) != null) {
            z = true;
        }
        sHasNotch = Boolean.valueOf(z);
        return true;
    }

    private static void clearAllRectInfo() {
        sRotation0SafeInset = null;
        sRotation90SafeInset = null;
        sRotation180SafeInset = null;
        sRotation270SafeInset = null;
    }

    private static void clearLandscapeRectInfo() {
        sRotation90SafeInset = null;
        sRotation270SafeInset = null;
    }

    private static void clearPortraitRectInfo() {
        sRotation0SafeInset = null;
        sRotation180SafeInset = null;
    }

    private static Rect get3rdSafeInsetRect(Context context) {
        if (QMUIDeviceHelper.isHuawei()) {
            boolean d = p0.d(context);
            Boolean bool = sHuaweiIsNotchSetToShow;
            if (bool != null && bool.booleanValue() != d) {
                clearLandscapeRectInfo();
            }
            sHuaweiIsNotchSetToShow = Boolean.valueOf(d);
        }
        int screenRotation = getScreenRotation(context);
        if (screenRotation == 1) {
            if (sRotation90SafeInset == null) {
                sRotation90SafeInset = getRectInfoRotation90(context);
            }
            return sRotation90SafeInset;
        }
        if (screenRotation == 2) {
            if (sRotation180SafeInset == null) {
                sRotation180SafeInset = getRectInfoRotation180(context);
            }
            return sRotation180SafeInset;
        }
        if (screenRotation == 3) {
            if (sRotation270SafeInset == null) {
                sRotation270SafeInset = getRectInfoRotation270(context);
            }
            return sRotation270SafeInset;
        }
        if (sRotation0SafeInset == null) {
            sRotation0SafeInset = getRectInfoRotation0(context);
        }
        return sRotation0SafeInset;
    }

    public static int getNotchHeightInVivo(Context context) {
        return p0.a(context, 27);
    }

    public static int getNotchHeightInXiaomi(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return p0.c(context);
    }

    public static int[] getNotchSizeInHuawei(Context context) {
        if (sNotchSizeInHawei == null) {
            sNotchSizeInHawei = new int[]{0, 0};
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                sNotchSizeInHawei = (int[]) loadClass.getMethod("getNotchSize", null).invoke(loadClass, null);
            } catch (ClassNotFoundException unused) {
                Log.e(TAG, "getNotchSizeInHuawei ClassNotFoundException");
            } catch (NoSuchMethodException unused2) {
                Log.e(TAG, "getNotchSizeInHuawei NoSuchMethodException");
            } catch (Exception unused3) {
                Log.e(TAG, "getNotchSizeInHuawei Exception");
            }
        }
        return sNotchSizeInHawei;
    }

    public static int getNotchWidthInVivo(Context context) {
        return p0.a(context, 100);
    }

    public static int getNotchWidthInXiaomi(Context context) {
        int identifier = context.getResources().getIdentifier("notch_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    @TargetApi(28)
    private static void getOfficialSafeInsetRect(View view, Rect rect) {
        WindowInsets a;
        DisplayCutout a2;
        int safeInsetLeft;
        int safeInsetTop;
        int safeInsetRight;
        int safeInsetBottom;
        if (view != null && (a = com.google.android.material.bottomsheet.a.a(view)) != null && (a2 = n2.a(a)) != null) {
            safeInsetLeft = a2.getSafeInsetLeft();
            safeInsetTop = a2.getSafeInsetTop();
            safeInsetRight = a2.getSafeInsetRight();
            safeInsetBottom = a2.getSafeInsetBottom();
            rect.set(safeInsetLeft, safeInsetTop, safeInsetRight, safeInsetBottom);
        }
    }

    private static Rect getRectInfoRotation0(Context context) {
        Rect rect = new Rect();
        if (QMUIDeviceHelper.isVivo()) {
            rect.top = getNotchHeightInVivo(context);
            rect.bottom = 0;
        } else if (QMUIDeviceHelper.isOppo()) {
            rect.top = QMUIStatusBarHelper.getStatusbarHeight(context);
            rect.bottom = 0;
        } else if (QMUIDeviceHelper.isHuawei()) {
            rect.top = getNotchSizeInHuawei(context)[1];
            rect.bottom = 0;
        } else if (QMUIDeviceHelper.isXiaomi()) {
            rect.top = getNotchHeightInXiaomi(context);
            rect.bottom = 0;
        }
        return rect;
    }

    private static Rect getRectInfoRotation180(Context context) {
        Rect rect = new Rect();
        if (QMUIDeviceHelper.isVivo()) {
            rect.top = 0;
            rect.bottom = getNotchHeightInVivo(context);
        } else if (QMUIDeviceHelper.isOppo()) {
            rect.top = 0;
            rect.bottom = QMUIStatusBarHelper.getStatusbarHeight(context);
        } else if (QMUIDeviceHelper.isHuawei()) {
            int[] notchSizeInHuawei = getNotchSizeInHuawei(context);
            rect.top = 0;
            rect.bottom = notchSizeInHuawei[1];
        } else if (QMUIDeviceHelper.isXiaomi()) {
            rect.top = 0;
            rect.bottom = getNotchHeightInXiaomi(context);
        }
        return rect;
    }

    private static Rect getRectInfoRotation270(Context context) {
        Rect rect = new Rect();
        if (QMUIDeviceHelper.isVivo()) {
            rect.right = getNotchHeightInVivo(context);
            rect.left = 0;
        } else if (QMUIDeviceHelper.isOppo()) {
            rect.right = QMUIStatusBarHelper.getStatusbarHeight(context);
            rect.left = 0;
        } else if (QMUIDeviceHelper.isHuawei()) {
            if (sHuaweiIsNotchSetToShow.booleanValue()) {
                rect.right = getNotchSizeInHuawei(context)[1];
            } else {
                rect.right = 0;
            }
            rect.left = 0;
        } else if (QMUIDeviceHelper.isXiaomi()) {
            rect.right = getNotchHeightInXiaomi(context);
            rect.left = 0;
        }
        return rect;
    }

    private static Rect getRectInfoRotation90(Context context) {
        Rect rect = new Rect();
        if (QMUIDeviceHelper.isVivo()) {
            rect.left = getNotchHeightInVivo(context);
            rect.right = 0;
        } else if (QMUIDeviceHelper.isOppo()) {
            rect.left = QMUIStatusBarHelper.getStatusbarHeight(context);
            rect.right = 0;
        } else if (QMUIDeviceHelper.isHuawei()) {
            if (sHuaweiIsNotchSetToShow.booleanValue()) {
                rect.left = getNotchSizeInHuawei(context)[1];
            } else {
                rect.left = 0;
            }
            rect.right = 0;
        } else if (QMUIDeviceHelper.isXiaomi()) {
            rect.left = getNotchHeightInXiaomi(context);
            rect.right = 0;
        }
        return rect;
    }

    public static int getSafeInsetBottom(Activity activity) {
        if (hasNotch(activity)) {
            return getSafeInsetRect(activity).bottom;
        }
        return 0;
    }

    public static int getSafeInsetLeft(Activity activity) {
        if (hasNotch(activity)) {
            return getSafeInsetRect(activity).left;
        }
        return 0;
    }

    private static Rect getSafeInsetRect(Activity activity) {
        if (isNotchOfficialSupport()) {
            Rect rect = new Rect();
            getOfficialSafeInsetRect(activity.getWindow().getDecorView(), rect);
            return rect;
        }
        return get3rdSafeInsetRect(activity);
    }

    public static int getSafeInsetRight(Activity activity) {
        if (hasNotch(activity)) {
            return getSafeInsetRect(activity).right;
        }
        return 0;
    }

    public static int getSafeInsetTop(Activity activity) {
        if (hasNotch(activity)) {
            return getSafeInsetRect(activity).top;
        }
        return 0;
    }

    private static int getScreenRotation(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        return defaultDisplay.getRotation();
    }

    public static boolean has3rdNotch(Context context) {
        if (QMUIDeviceHelper.isHuawei()) {
            return hasNotchInHuawei(context);
        }
        if (QMUIDeviceHelper.isVivo()) {
            return hasNotchInVivo(context);
        }
        if (QMUIDeviceHelper.isOppo()) {
            return hasNotchInOppo(context);
        }
        if (QMUIDeviceHelper.isXiaomi()) {
            return hasNotchInXiaomi(context);
        }
        return false;
    }

    public static boolean hasNotch(View view) {
        if (sHasNotch == null) {
            if (isNotchOfficialSupport()) {
                if (!attachHasOfficialNotch(view)) {
                    return false;
                }
            } else {
                sHasNotch = Boolean.valueOf(has3rdNotch(view.getContext()));
            }
        }
        return sHasNotch.booleanValue();
    }

    public static boolean hasNotchInHuawei(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", null).invoke(loadClass, null)).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.i(TAG, "hasNotchInHuawei ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            Log.e(TAG, "hasNotchInHuawei NoSuchMethodException");
            return false;
        } catch (Exception unused3) {
            Log.e(TAG, "hasNotchInHuawei Exception");
            return false;
        }
    }

    public static boolean hasNotchInOppo(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchInVivo(Context context) {
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
            Log.i(TAG, "hasNotchInVivo ClassNotFoundException");
            return false;
        } catch (Exception unused2) {
            Log.e(TAG, "hasNotchInVivo Exception");
            return false;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static boolean hasNotchInXiaomi(Context context) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", String.class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            if (((Integer) declaredMethod.invoke(null, MIUI_NOTCH, 0)).intValue() == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isNotchOfficialSupport() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    public static boolean needFixLandscapeNotchAreaFitSystemWindow(View view) {
        if ((QMUIDeviceHelper.isXiaomi() || QMUIDeviceHelper.isVivo()) && hasNotch(view)) {
            return true;
        }
        return false;
    }

    public static int getSafeInsetBottom(View view) {
        if (hasNotch(view)) {
            return getSafeInsetRect(view).bottom;
        }
        return 0;
    }

    public static int getSafeInsetLeft(View view) {
        if (hasNotch(view)) {
            return getSafeInsetRect(view).left;
        }
        return 0;
    }

    public static int getSafeInsetRight(View view) {
        if (hasNotch(view)) {
            return getSafeInsetRect(view).right;
        }
        return 0;
    }

    public static int getSafeInsetTop(View view) {
        if (hasNotch(view)) {
            return getSafeInsetRect(view).top;
        }
        return 0;
    }

    private static Rect getSafeInsetRect(View view) {
        if (isNotchOfficialSupport()) {
            Rect rect = new Rect();
            getOfficialSafeInsetRect(view, rect);
            return rect;
        }
        return get3rdSafeInsetRect(view.getContext());
    }

    public static boolean hasNotch(Activity activity) {
        View decorView;
        if (sHasNotch == null) {
            if (isNotchOfficialSupport()) {
                Window window = activity.getWindow();
                if (window == null || (decorView = window.getDecorView()) == null || !attachHasOfficialNotch(decorView)) {
                    return false;
                }
            } else {
                sHasNotch = Boolean.valueOf(has3rdNotch(activity));
            }
        }
        return sHasNotch.booleanValue();
    }
}
