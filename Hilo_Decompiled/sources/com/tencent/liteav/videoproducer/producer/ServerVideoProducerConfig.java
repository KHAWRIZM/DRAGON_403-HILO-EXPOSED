package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ServerVideoProducerConfig {
    private k gsensorRotationCorrection;
    private Boolean hardwareEncoderBitrateModeCBRSupported;
    private final String mTAG = "ServerVideoProducerConfig_" + hashCode();
    private int hardwareEncodeType = 2;
    private boolean hardwareEncoderHighProfileEnable = true;
    private boolean hardwareEncoderHighProfileSupport = true;
    private int camera2SupportMinApiLevel = Integer.MAX_VALUE;
    private int cameraRotationCorrection = 0;
    private boolean mEnableCameraFpsCorrectionLogic = true;

    private k cameraCloudConfigEnumToRotation(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return k.ROTATION_270;
                }
                return k.ROTATION_180;
            }
            return k.ROTATION_90;
        }
        return k.NORMAL;
    }

    public static boolean isHWHevcEncodeAllowed() {
        return nativeIsHardwareHevcEncodeAllowed();
    }

    private static native boolean nativeIsHardwareHevcEncodeAllowed();

    public int getCamera2SupportMinApiLevel() {
        return this.camera2SupportMinApiLevel;
    }

    public String getCameraRotationCorrectionInfo() {
        return "[CameraV1Front:" + getCameraV1FrontRotationCorrection() + ", CameraV1Back:" + getCameraV1BackRotationCorrection() + ", CameraV2Front:" + getCameraV2FrontRotationCorrection() + ", CameraV2Back:" + getCameraV2BackRotationCorrection() + "]";
    }

    public k getCameraV1BackRotationCorrection() {
        return cameraCloudConfigEnumToRotation((this.cameraRotationCorrection >> 8) & 255);
    }

    public k getCameraV1FrontRotationCorrection() {
        return cameraCloudConfigEnumToRotation(this.cameraRotationCorrection & 255);
    }

    public k getCameraV2BackRotationCorrection() {
        return cameraCloudConfigEnumToRotation((this.cameraRotationCorrection >> 24) & 255);
    }

    public k getCameraV2FrontRotationCorrection() {
        return cameraCloudConfigEnumToRotation((this.cameraRotationCorrection >> 16) & 255);
    }

    public k getGsensorRotationCorrection() {
        return this.gsensorRotationCorrection;
    }

    public boolean isCameraFpsCorrectionLogicEnabled() {
        return this.mEnableCameraFpsCorrectionLogic;
    }

    public boolean isHardwareEncoderAllowed() {
        if (this.hardwareEncodeType != 0) {
            return true;
        }
        return false;
    }

    public Boolean isHardwareEncoderBitrateModeCBRSupported() {
        return this.hardwareEncoderBitrateModeCBRSupported;
    }

    public boolean isHardwareEncoderHighProfileAllowed() {
        if (this.hardwareEncodeType == 2 && this.hardwareEncoderHighProfileEnable && this.hardwareEncoderHighProfileSupport) {
            return true;
        }
        return false;
    }

    public void setCamera2SupportMinApiLevel(int i) {
        this.camera2SupportMinApiLevel = i;
    }

    public void setCameraFpsCorrectionLogicEnabled(boolean z) {
        this.mEnableCameraFpsCorrectionLogic = z;
        LiteavLog.i(this.mTAG, "set camera fps correction logic enabled value is ".concat(String.valueOf(z)));
    }

    public void setCameraRotationCorrection(int i) {
        this.cameraRotationCorrection = i;
        LiteavLog.i(this.mTAG, "set camera rotation correction raw value is %#x.", Integer.valueOf(i));
    }

    public void setGSensorRotationCorrection(int i) {
        if (i >= 0 && i <= 3) {
            this.gsensorRotationCorrection = k.a(i * 90);
        }
    }

    public void setHardwareEncodeType(int i) {
        this.hardwareEncodeType = i;
    }

    public void setHardwareEncoderBitrateModeCBRSupported(boolean z) {
        this.hardwareEncoderBitrateModeCBRSupported = Boolean.valueOf(z);
    }

    public void setHardwareEncoderHighProfileEnable(boolean z) {
        this.hardwareEncoderHighProfileEnable = z;
    }

    public void setHardwareEncoderHighProfileSupport(boolean z) {
        this.hardwareEncoderHighProfileSupport = z;
    }

    public String toString() {
        return "hardwareEncodeType: " + this.hardwareEncodeType + ", hardwareEncoderHighProfileEnable: " + this.hardwareEncoderHighProfileEnable + ", hardwareEncoderHighProfileSupport: " + this.hardwareEncoderHighProfileSupport + ", camera2SupportMinApiLevel: " + this.camera2SupportMinApiLevel + ", hardwareEncoderBitrateModeCBRSupported: " + this.hardwareEncoderBitrateModeCBRSupported + ", gsensorRotationCorrection: " + this.gsensorRotationCorrection + ", cameraRotationCorrection: " + getCameraRotationCorrectionInfo();
    }
}
