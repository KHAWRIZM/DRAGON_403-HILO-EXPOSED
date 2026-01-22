package com.yalantis.ucrop.util;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class DensityUtil {
    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getStatusBarHeight(Context context) {
        int i;
        int identifier = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i = context.getResources().getDimensionPixelSize(identifier);
        } else {
            i = 0;
        }
        if (i == 0) {
            return dip2px(context, 26.0f);
        }
        return i;
    }
}
