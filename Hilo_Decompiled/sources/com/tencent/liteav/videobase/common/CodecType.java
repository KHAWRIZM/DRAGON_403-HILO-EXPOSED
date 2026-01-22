package com.tencent.liteav.videobase.common;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public enum CodecType {
    UNKNOWN(-1),
    H264(0),
    H265(1),
    VP8(2),
    KAV1(3);

    private static final CodecType[] f = values();
    public final int mValue;

    CodecType(int i) {
        this.mValue = i;
    }

    public static CodecType a(int i) {
        for (CodecType codecType : f) {
            if (i == codecType.mValue) {
                return codecType;
            }
        }
        return H264;
    }
}
