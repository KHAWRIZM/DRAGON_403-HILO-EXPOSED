package com.qiahao.nextvideo.utilities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.d1;
import androidx.core.view.n2;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class QMUIStatusBarHelper {
    private static final int STATUSBAR_TYPE_ANDROID6 = 3;
    private static final int STATUSBAR_TYPE_DEFAULT = 0;
    private static final int STATUSBAR_TYPE_FLYME = 2;
    private static final int STATUSBAR_TYPE_MIUI = 1;
    private static final int STATUS_BAR_DEFAULT_HEIGHT_DP = 25;
    private static int mStatuBarType = 0;
    private static int sStatusbarHeight = -1;
    private static Integer sTransparentValue = null;
    public static float sVirtualDensity = -1.0f;
    public static float sVirtualDensityDpi = -1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ Window a;

        a(Window window) {
            this.a = window;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            QMUIStatusBarHelper.realHandleDisplayCutoutMode(this.a, view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    @TargetApi(23)
    private static boolean Android6SetStatusBarLightMode(Window window, boolean z) {
        int i;
        View decorView = window.getDecorView();
        if (z) {
            i = 8192;
        } else {
            i = 256;
        }
        decorView.setSystemUiVisibility(changeStatusBarModeRetainFlag(window, i));
        if (QMUIDeviceHelper.isMIUIV9()) {
            MIUISetStatusBarLightMode(window, z);
            return true;
        }
        return true;
    }

    public static boolean FlymeSetStatusBarLightMode(Window window, boolean z) {
        int i;
        if (window != null) {
            Android6SetStatusBarLightMode(window, z);
            if (!QMUIDeviceHelper.isFlymeLowerThan(7)) {
                return true;
            }
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt(null);
                int i3 = declaredField2.getInt(attributes);
                if (z) {
                    i = i3 | i2;
                } else {
                    i = (~i2) & i3;
                }
                declaredField2.setInt(attributes, i);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean MIUISetStatusBarLightMode(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Class<?> cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls3, cls3);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @TargetApi(23)
    private static int changeStatusBarModeRetainFlag(Window window, int i) {
        return retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, retainSystemUiFlag(window, i, LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY), 4), 2), 4096), LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY), 512);
    }

    public static Integer getStatusBarAPITransparentValue(Context context) {
        Integer num = sTransparentValue;
        if (num != null) {
            return num;
        }
        String str = null;
        for (String str2 : context.getPackageManager().getSystemSharedLibraryNames()) {
            if ("touchwiz".equals(str2)) {
                str = "SYSTEM_UI_FLAG_TRANSPARENT_BACKGROUND";
            } else if (str2.startsWith("com.sonyericsson.navigationbar")) {
                str = "SYSTEM_UI_FLAG_TRANSPARENT";
            }
        }
        if (str != null) {
            try {
                Field field = View.class.getField(str);
                if (field != null && field.getType() == Integer.TYPE) {
                    sTransparentValue = Integer.valueOf(field.getInt(null));
                }
            } catch (Exception unused) {
            }
        }
        return sTransparentValue;
    }

    public static int getStatusbarHeight(Context context) {
        if (sStatusbarHeight == -1) {
            initStatusBarHeight(context);
        }
        return sStatusbarHeight;
    }

    @TargetApi(28)
    private static void handleDisplayCutoutMode(Window window) {
        View decorView = window.getDecorView();
        if (decorView != null) {
            if (d1.U(decorView)) {
                realHandleDisplayCutoutMode(window, decorView);
            } else {
                decorView.addOnAttachStateChangeListener(new a(window));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void initStatusBarHeight(Context context) {
        Throwable th;
        Field field;
        Object obj;
        Class<?> cls;
        Field field2 = null;
        try {
            cls = Class.forName("com.android.internal.R$dimen");
            obj = cls.newInstance();
        } catch (Throwable th2) {
            th = th2;
            field = null;
        }
        try {
            if (QMUIDeviceHelper.isMeizu()) {
                try {
                    field2 = cls.getField("status_bar_height_large");
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            if (field2 == null) {
                field2 = cls.getField("status_bar_height");
            }
        } catch (Throwable th4) {
            field = field2;
            field2 = obj;
            th = th4;
            th.printStackTrace();
            obj = field2;
            field2 = field;
            if (field2 != null) {
                try {
                    sStatusbarHeight = context.getResources().getDimensionPixelSize(Integer.parseInt(field2.get(obj).toString()));
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            if (!QMUIDeviceHelper.isTablet(context)) {
            }
            if (sStatusbarHeight > 0) {
            }
        }
        if (field2 != null && obj != null) {
            sStatusbarHeight = context.getResources().getDimensionPixelSize(Integer.parseInt(field2.get(obj).toString()));
        }
        if (!QMUIDeviceHelper.isTablet(context) && sStatusbarHeight > p0.a(context, 25)) {
            sStatusbarHeight = 0;
            return;
        }
        if (sStatusbarHeight > 0) {
            float f = sVirtualDensity;
            if (f == -1.0f) {
                sStatusbarHeight = p0.a(context, 25);
            } else {
                sStatusbarHeight = (int) ((f * 25.0f) + 0.5f);
            }
        }
    }

    public static boolean isFullScreen(Activity activity) {
        try {
            if ((activity.getWindow().getAttributes().flags & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isMIUICustomStatusBarLightModeImpl() {
        if ((QMUIDeviceHelper.isMIUIV9() && Build.VERSION.SDK_INT < 23) || QMUIDeviceHelper.isMIUIV5() || QMUIDeviceHelper.isMIUIV6() || QMUIDeviceHelper.isMIUIV7() || QMUIDeviceHelper.isMIUIV8()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(28)
    public static void realHandleDisplayCutoutMode(Window window, View view) {
        if (com.google.android.material.bottomsheet.a.a(view) != null && n2.a(com.google.android.material.bottomsheet.a.a(view)) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            q6.c.a(attributes, 1);
            window.setAttributes(attributes);
        }
    }

    public static int retainSystemUiFlag(Window window, int i, int i2) {
        if ((window.getDecorView().getSystemUiVisibility() & i2) == i2) {
            return i | i2;
        }
        return i;
    }

    public static boolean setStatusBarDarkMode(Activity activity) {
        if (activity == null) {
            return false;
        }
        int i = mStatuBarType;
        if (i == 0) {
            return true;
        }
        if (i == 1) {
            return MIUISetStatusBarLightMode(activity.getWindow(), false);
        }
        if (i == 2) {
            return FlymeSetStatusBarLightMode(activity.getWindow(), false);
        }
        if (i != 3) {
            return true;
        }
        return Android6SetStatusBarLightMode(activity.getWindow(), false);
    }

    public static boolean setStatusBarLightMode(Activity activity) {
        if (activity == null || QMUIDeviceHelper.isZTKC2016()) {
            return false;
        }
        int i = mStatuBarType;
        if (i != 0) {
            return setStatusBarLightMode(activity, i);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (isMIUICustomStatusBarLightModeImpl() && MIUISetStatusBarLightMode(activity.getWindow(), true)) {
            mStatuBarType = 1;
            return true;
        }
        if (FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
            mStatuBarType = 2;
            return true;
        }
        if (i2 < 23) {
            return false;
        }
        Android6SetStatusBarLightMode(activity.getWindow(), true);
        mStatuBarType = 3;
        return true;
    }

    public static void setVirtualDensity(float f) {
        sVirtualDensity = f;
    }

    public static void setVirtualDensityDpi(float f) {
        sVirtualDensityDpi = f;
    }

    public static boolean supportTransclentStatusBar6() {
        if (!QMUIDeviceHelper.isZUKZ1() && !QMUIDeviceHelper.isZTKC2016()) {
            return true;
        }
        return false;
    }

    private static boolean supportTranslucent() {
        int i = Build.VERSION.SDK_INT;
        if (QMUIDeviceHelper.isEssentialPhone() && i < 26) {
            return false;
        }
        return true;
    }

    public static void translucent(Activity activity) {
        translucent(activity.getWindow());
    }

    public static void translucent(Window window) {
        translucent(window, 1073741824);
    }

    public static void translucent(Activity activity, int i) {
        translucent(activity.getWindow(), i);
    }

    @TargetApi(19)
    public static void translucent(Window window, int i) {
        if (supportTranslucent()) {
            if (QMUINotchHelper.isNotchOfficialSupport()) {
                handleDisplayCutoutMode(window);
            }
            if (!QMUIDeviceHelper.isFlymeLowerThan(8) && (!QMUIDeviceHelper.isMIUI() || Build.VERSION.SDK_INT >= 23)) {
                int i2 = Build.VERSION.SDK_INT;
                window.getDecorView().setSystemUiVisibility(1280);
                if (i2 >= 23 && supportTransclentStatusBar6()) {
                    window.clearFlags(67108864);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(0);
                    return;
                } else {
                    window.clearFlags(67108864);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(i);
                    return;
                }
            }
            window.setFlags(67108864, 67108864);
        }
    }

    private static boolean setStatusBarLightMode(Activity activity, int i) {
        if (i == 1) {
            return MIUISetStatusBarLightMode(activity.getWindow(), true);
        }
        if (i == 2) {
            return FlymeSetStatusBarLightMode(activity.getWindow(), true);
        }
        if (i == 3) {
            return Android6SetStatusBarLightMode(activity.getWindow(), true);
        }
        return false;
    }
}
