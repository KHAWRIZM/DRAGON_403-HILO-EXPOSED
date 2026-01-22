package com.tencent.liteav.videobase.common;

import okhttp3.internal.http2.Settings;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public enum c {
    UNKNOWN(Settings.DEFAULT_INITIAL_WINDOW_SIZE),
    IDR(0),
    P(1),
    B(6),
    P_MULTI_REF(7),
    I(8),
    SEI(17),
    SPS(18),
    PPS(19),
    VPS(20);

    private static final c[] k = values();
    public final int mValue;

    c(int i) {
        this.mValue = i;
    }

    public static c a(int i) {
        for (c cVar : k) {
            if (cVar.mValue == i) {
                return cVar;
            }
        }
        return UNKNOWN;
    }
}
