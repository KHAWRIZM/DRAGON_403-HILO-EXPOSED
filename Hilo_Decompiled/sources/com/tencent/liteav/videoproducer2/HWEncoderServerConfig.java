package com.tencent.liteav.videoproducer2;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HWEncoderServerConfig {
    private Boolean hardwareEncoderBitrateModeCBRSupported;
    private int mHardwareEncodeType = 2;
    private boolean mHardwareEncoderHighProfileEnable = true;
    private boolean mHardwareEncoderHighProfileSupport = true;

    public static boolean isHWHevcEncodeAllowed() {
        return nativeIsHardwareHevcEncodeAllowed();
    }

    private static native boolean nativeIsHardwareHevcEncodeAllowed();

    public int getHardwareEncodeType() {
        return this.mHardwareEncodeType;
    }

    public boolean getHardwareEncoderHighProfileEnable() {
        return this.mHardwareEncoderHighProfileEnable;
    }

    public boolean getHardwareEncoderHighProfileSupport() {
        return this.mHardwareEncoderHighProfileSupport;
    }

    public boolean isHardwareEncoderAllowed() {
        if (this.mHardwareEncodeType != 0) {
            return true;
        }
        return false;
    }

    public Boolean isHardwareEncoderBitrateModeCBRSupported() {
        return this.hardwareEncoderBitrateModeCBRSupported;
    }

    public boolean isHardwareEncoderHighProfileAllowed() {
        if (this.mHardwareEncodeType == 2 && this.mHardwareEncoderHighProfileEnable && this.mHardwareEncoderHighProfileSupport) {
            return true;
        }
        return false;
    }

    public void setHardwareEncodeType(int i) {
        this.mHardwareEncodeType = i;
    }

    public void setHardwareEncoderBitrateModeCBRSupported(boolean z) {
        this.hardwareEncoderBitrateModeCBRSupported = Boolean.valueOf(z);
    }

    public void setHardwareEncoderHighProfileEnable(boolean z) {
        this.mHardwareEncoderHighProfileEnable = z;
    }

    public void setHardwareEncoderHighProfileSupport(boolean z) {
        this.mHardwareEncoderHighProfileSupport = z;
    }
}
