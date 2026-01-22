package com.tencent.qcloud.tuicore.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qcloud.tuicore.TUIConfig;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ScreenUtil {
    private static final String TAG = "ScreenUtil";

    public static int dip2px(float f) {
        return (int) ((f * TUIConfig.getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float dp2px(float f, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f, displayMetrics);
    }

    public static int getNavigationBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getPxByDp(float f) {
        return (int) ((f * TUIConfig.getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getRealScreenHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getRealScreenWidth(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int[] scaledSize(int i, int i2, int i3, int i4) {
        Log.i(TAG, "scaledSize  containerWidth: " + i + " containerHeight: " + i2 + " realWidth: " + i3 + " realHeight: " + i4);
        float f = (float) i;
        float f2 = (float) i2;
        float f3 = ((float) i3) / ((float) i4);
        if (f3 < f / f2) {
            i = (int) (f2 * f3);
        } else {
            i2 = (int) (f / f3);
        }
        return new int[]{i, i2};
    }
}
