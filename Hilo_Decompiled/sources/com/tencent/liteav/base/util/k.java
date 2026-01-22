package com.tencent.liteav.base.util;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public enum k {
    NORMAL(0),
    ROTATION_90(90),
    ROTATION_180(180),
    ROTATION_270(270);

    private static final k[] e = values();
    public final int mValue;

    k(int i) {
        this.mValue = i;
    }

    public static k a(int i) {
        for (k kVar : e) {
            if (kVar.mValue == i) {
                return kVar;
            }
        }
        return NORMAL;
    }

    public static boolean b(int i) {
        return i == 0 || i == 90 || i == 180 || i == 270;
    }

    public static int a(k kVar) {
        if (kVar != null) {
            return kVar.mValue;
        }
        return NORMAL.mValue;
    }
}
