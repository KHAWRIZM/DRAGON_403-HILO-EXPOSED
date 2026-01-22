package com.tencent.liteav.videoproducer2;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.common.c;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MediaCodecFrameJni {
    public ByteBuffer data;
    public c nalType = c.UNKNOWN;
    public long pts;

    public static MediaCodecFrameJni create() {
        return new MediaCodecFrameJni();
    }

    public ByteBuffer getData() {
        return this.data;
    }

    public int getNalType() {
        return this.nalType.mValue;
    }

    public long getPTS() {
        return this.pts;
    }
}
