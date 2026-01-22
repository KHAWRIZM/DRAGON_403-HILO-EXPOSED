package com.tencent.liteav.base.util;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TimeUtil {
    public static long a() {
        return nativeGetTimestamp();
    }

    private static native long nativeGetTimestamp();
}
