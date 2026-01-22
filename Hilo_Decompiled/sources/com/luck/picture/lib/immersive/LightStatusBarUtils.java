package com.luck.picture.lib.immersive;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class LightStatusBarUtils {
    private static void initStatusBarStyle(Activity activity, boolean z10, boolean z11) {
        if (z10 && z11) {
            activity.getWindow().getDecorView().setSystemUiVisibility(256);
            return;
        }
        if (!z10 && !z11) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else if (!z10 && z11) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        }
    }

    @TargetApi(11)
    private static void setAndroidNativeLightStatusBar(Activity activity, boolean z10, boolean z11, boolean z12, boolean z13) {
        try {
            if (z12) {
                Window window = activity.getWindow();
                int i10 = Build.VERSION.SDK_INT;
                if (z10 && z11) {
                    if (z13 && i10 >= 23) {
                        window.getDecorView().setSystemUiVisibility(8448);
                    } else {
                        window.getDecorView().setSystemUiVisibility(256);
                    }
                } else if (!z10 && !z11) {
                    if (z13 && i10 >= 23) {
                        window.getDecorView().setSystemUiVisibility(9472);
                    } else {
                        window.getDecorView().setSystemUiVisibility(1280);
                    }
                } else if (!z10 && z11) {
                    if (z13 && i10 >= 23) {
                        window.getDecorView().setSystemUiVisibility(9472);
                    } else {
                        window.getDecorView().setSystemUiVisibility(1280);
                    }
                }
            } else {
                View decorView = activity.getWindow().getDecorView();
                if (z13 && Build.VERSION.SDK_INT >= 23) {
                    decorView.setSystemUiVisibility(8192);
                } else {
                    decorView.setSystemUiVisibility(0);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static boolean setFlymeLightStatusBar(Activity activity, boolean z10, boolean z11, boolean z12, boolean z13) {
        int i10;
        boolean z14 = false;
        if (activity == null) {
            return false;
        }
        initStatusBarStyle(activity, z10, z11);
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i11 = declaredField.getInt(null);
            int i12 = declaredField2.getInt(attributes);
            if (z13) {
                i10 = i11 | i12;
            } else {
                i10 = (~i11) & i12;
            }
            declaredField2.setInt(attributes, i10);
            activity.getWindow().setAttributes(attributes);
        } catch (Exception unused) {
        }
        try {
            if (RomUtils.getFlymeVersion() >= 7) {
                setAndroidNativeLightStatusBar(activity, z10, z11, z12, z13);
            }
            return true;
        } catch (Exception unused2) {
            z14 = true;
            setAndroidNativeLightStatusBar(activity, z10, z11, z12, z13);
            return z14;
        }
    }

    public static void setLightStatusBar(Activity activity, boolean z10) {
        setLightStatusBar(activity, false, false, false, z10);
    }

    public static void setLightStatusBarAboveAPI23(Activity activity, boolean z10, boolean z11, boolean z12, boolean z13) {
        if (Build.VERSION.SDK_INT >= 23) {
            setLightStatusBar(activity, z10, z11, z12, z13);
        }
    }

    private static boolean setMIUILightStatusBar(Activity activity, boolean z10, boolean z11, boolean z12, boolean z13) {
        int i10;
        initStatusBarStyle(activity, z10, z11);
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i11 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Window window = activity.getWindow();
            if (z13) {
                i10 = i11;
            } else {
                i10 = 0;
            }
            method.invoke(window, Integer.valueOf(i10), Integer.valueOf(i11));
            return true;
        } catch (Exception unused) {
            setAndroidNativeLightStatusBar(activity, z10, z11, z12, z13);
            return false;
        }
    }

    public static void setLightStatusBar(Activity activity, boolean z10, boolean z11, boolean z12, boolean z13) {
        int lightStatusBarAvailableRomType = RomUtils.getLightStatusBarAvailableRomType();
        if (lightStatusBarAvailableRomType == 1) {
            if (RomUtils.getMIUIVersionCode() >= 7) {
                setAndroidNativeLightStatusBar(activity, z10, z11, z12, z13);
                return;
            } else {
                setMIUILightStatusBar(activity, z10, z11, z12, z13);
                return;
            }
        }
        if (lightStatusBarAvailableRomType == 2) {
            setFlymeLightStatusBar(activity, z10, z11, z12, z13);
        } else {
            if (lightStatusBarAvailableRomType != 3) {
                return;
            }
            setAndroidNativeLightStatusBar(activity, z10, z11, z12, z13);
        }
    }
}
