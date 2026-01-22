package com.tencent.liteav.base.util;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class g {
    public static float a(float f, float f2) {
        if (f < f2) {
            return f2;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }
}
