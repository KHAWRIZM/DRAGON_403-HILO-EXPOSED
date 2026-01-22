package com.tencent.liteav.base.util;

import android.graphics.PointF;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class f {
    public static boolean a(float f, float f2) {
        return Math.abs(f - f2) < 1.0E-6f;
    }

    public static float[] a(List<PointF> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        float[] fArr = new float[size * 2];
        for (int i = 0; i < size; i++) {
            PointF pointF = list.get(i);
            int i2 = i * 2;
            fArr[i2] = pointF.x;
            fArr[i2 + 1] = pointF.y;
        }
        return fArr;
    }
}
