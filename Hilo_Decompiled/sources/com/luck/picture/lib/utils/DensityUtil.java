package com.luck.picture.lib.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.luck.picture.lib.immersive.RomUtils;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DensityUtil {
    public static int dip2px(Context context, float f10) {
        return (int) ((f10 * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int getInternalDimensionSize(Context context, String str) {
        float f10;
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                float f11 = (dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                if (f11 >= DownloadProgress.UNKNOWN_PROGRESS) {
                    f10 = f11 + 0.5f;
                } else {
                    f10 = f11 - 0.5f;
                }
                return (int) f10;
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    @TargetApi(14)
    public static int getNavigationBarHeight(Context context) {
        String str;
        boolean z10 = true;
        if (context.getResources().getConfiguration().orientation != 1) {
            z10 = false;
        }
        if (!isNavBarVisible(context)) {
            return 0;
        }
        if (z10) {
            str = "navigation_bar_height";
        } else {
            str = "navigation_bar_height_landscape";
        }
        return getInternalDimensionSize(context, str);
    }

    @TargetApi(14)
    public static int getNavigationBarWidth(Context context) {
        if (isNavBarVisible(context)) {
            return getInternalDimensionSize(context, "navigation_bar_width");
        }
        return 0;
    }

    public static int getRealScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static int getRealScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    private static String getResNameById(Context context, int i10) {
        try {
            return context.getResources().getResourceEntryName(i10);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getScreenHeight(Context context) {
        return getRealScreenHeight(context) - getStatusNavigationBarHeight(context);
    }

    @SuppressLint({"NewApi"})
    private static float getSmallestWidthDp(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        float f10 = displayMetrics.widthPixels;
        float f11 = displayMetrics.density;
        return Math.min(f10 / f11, displayMetrics.heightPixels / f11);
    }

    public static int getStatusBarHeight(Context context) {
        int statusBarHeight;
        int dimensionPixelSize;
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(identifier);
                dimensionPixelSize = system.getDimensionPixelSize(identifier);
                if (dimensionPixelSize < dimensionPixelSize2) {
                    float f10 = (dimensionPixelSize2 * system.getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                    dimensionPixelSize = (int) (f10 >= DownloadProgress.UNKNOWN_PROGRESS ? f10 + 0.5f : f10 - 0.5f);
                }
            } catch (Exception unused) {
                statusBarHeight = getStatusBarHeight();
            }
        } else {
            dimensionPixelSize = 0;
        }
        statusBarHeight = dimensionPixelSize;
        return statusBarHeight == 0 ? dip2px(context, 26.0f) : statusBarHeight;
    }

    private static int getStatusNavigationBarHeight(Context context) {
        if (isNavBarVisible(context)) {
            return getStatusBarHeight(context) + getNavigationBarHeight(context);
        }
        return getStatusBarHeight(context);
    }

    public static boolean isNavBarVisible(Context context) {
        boolean z10;
        boolean z11 = false;
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 < childCount) {
                View childAt = viewGroup.getChildAt(i10);
                int id = childAt.getId();
                if (id != -1 && "navigationBarBackground".equals(getResNameById(activity, id)) && childAt.getVisibility() == 0) {
                    z10 = true;
                    break;
                }
                i10++;
            } else {
                z10 = false;
                break;
            }
        }
        if (z10) {
            if (RomUtils.isSamsung() && Build.VERSION.SDK_INT < 29) {
                try {
                    if (Settings.Global.getInt(activity.getContentResolver(), "navigationbar_hide_bar_enabled") != 0) {
                        return false;
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            if ((viewGroup.getSystemUiVisibility() & 2) == 0) {
                z11 = true;
            }
            return z11;
        }
        return z10;
    }

    public static boolean isNavigationAtBottom(Activity activity) {
        boolean z10;
        if (activity.getResources().getConfiguration().orientation == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getSmallestWidthDp(activity) < 600.0f && !z10) {
            return false;
        }
        return true;
    }

    public static int getStatusBarHeight() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }
}
