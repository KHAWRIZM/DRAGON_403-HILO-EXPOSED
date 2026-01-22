package com.tencent.liteav.videobase.common;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public enum b {
    UNKNOWN(-1),
    HDR10(0),
    HLG(1),
    UNSUPPORTED(2);

    final int mValue;

    b(int i) {
        this.mValue = i;
    }

    public static b a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return UNKNOWN;
                }
                return UNSUPPORTED;
            }
            return HLG;
        }
        return HDR10;
    }
}
