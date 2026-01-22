package com.qiahao.nextvideo.utilities;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class p0 {
    public static final float a = Resources.getSystem().getDisplayMetrics().density;
    private static Boolean b = null;

    public static int a(Context context, int i) {
        return (int) ((b(context) * i) + 0.5d);
    }

    public static float b(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int c(Context context) {
        if (QMUIDeviceHelper.isXiaomi()) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean d(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), "display_notch_status", 0) != 0) {
            return false;
        }
        return true;
    }
}
