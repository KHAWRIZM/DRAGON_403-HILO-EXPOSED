package com.tencent.liteav.videoproducer2;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MediaCodecExceptionJni {
    public boolean hasException = false;
    public int systemErrorCode = 0;
    public boolean isErrorRecoverable = true;

    public static MediaCodecExceptionJni createException() {
        return new MediaCodecExceptionJni();
    }

    public int getSystemErrorCode() {
        return this.systemErrorCode;
    }

    public boolean hasException() {
        return this.hasException;
    }

    public boolean isErrorRecoverable() {
        return this.isErrorRecoverable;
    }
}
