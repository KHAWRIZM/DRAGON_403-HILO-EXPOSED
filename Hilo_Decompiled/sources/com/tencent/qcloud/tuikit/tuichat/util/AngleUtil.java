package com.tencent.qcloud.tuikit.tuichat.util;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AngleUtil {
    public static int getSensorAngle(float f, float f2) {
        if (Math.abs(f) > Math.abs(f2)) {
            if (f > 4.0f) {
                return 270;
            }
            if (f >= -4.0f) {
                return 0;
            }
            return 90;
        }
        if (f2 > 7.0f || f2 >= -7.0f) {
            return 0;
        }
        return 180;
    }
}
