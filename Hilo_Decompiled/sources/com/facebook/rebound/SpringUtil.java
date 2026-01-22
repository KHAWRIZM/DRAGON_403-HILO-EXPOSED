package com.facebook.rebound;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SpringUtil {
    public static double clamp(double d10, double d11, double d12) {
        return Math.min(Math.max(d10, d11), d12);
    }

    public static double mapValueFromRangeToRange(double d10, double d11, double d12, double d13, double d14) {
        return d13 + (((d10 - d11) / (d12 - d11)) * (d14 - d13));
    }
}
