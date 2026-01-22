package com.tencent.liteav.device;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.device.TXDeviceManager;

@JNINamespace("liteav::manager")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TXDeviceManagerImpl implements TXDeviceManager {
    private long mNativeDeviceMgr;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class CameraCaptureParam {
        private TXDeviceManager.TXCameraCaptureParam mParams;

        public CameraCaptureParam(TXDeviceManager.TXCameraCaptureParam tXCameraCaptureParam) {
            this.mParams = tXCameraCaptureParam;
        }

        public int getHeight() {
            return this.mParams.height;
        }

        public int getMode() {
            return TXDeviceManagerImpl.cameraCaptureModeAsInt(this.mParams.mode);
        }

        public int getWidth() {
            return this.mParams.width;
        }
    }

    public TXDeviceManagerImpl(long j) {
        this.mNativeDeviceMgr = j;
    }

    public static int audioRouteAsInt(TXDeviceManager.TXAudioRoute tXAudioRoute) {
        if (tXAudioRoute == TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone || tXAudioRoute != TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece) {
            return 0;
        }
        return 1;
    }

    public static TXDeviceManager.TXAudioRoute audioRouteFromInt(int i) {
        if (i == 0) {
            return TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone;
        }
        if (i == 1) {
            return TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece;
        }
        return TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone;
    }

    public static int cameraCaptureModeAsInt(TXDeviceManager.TXCameraCaptureMode tXCameraCaptureMode) {
        if (tXCameraCaptureMode == TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto) {
            return 0;
        }
        if (tXCameraCaptureMode == TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyPerformance) {
            return 1;
        }
        if (tXCameraCaptureMode == TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyHighQuality) {
            return 2;
        }
        if (tXCameraCaptureMode != TXDeviceManager.TXCameraCaptureMode.TXCameraCaptureManual) {
            return 0;
        }
        return 3;
    }

    public static TXDeviceManager.TXCameraCaptureMode cameraCaptureModeFromInt(int i) {
        if (i == 0) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto;
        }
        if (i == 1) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyPerformance;
        }
        if (i == 2) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyHighQuality;
        }
        if (i == 3) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraCaptureManual;
        }
        return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto;
    }

    private static native void nativeDestroy(long j);

    private static native int nativeEnableCameraAutoFocus(long j, boolean z);

    private static native boolean nativeEnableCameraTorch(long j, boolean z);

    private static native float nativeGetCameraZoomMaxRatio(long j);

    private static native boolean nativeIsAutoFocusEnabled(long j);

    private static native boolean nativeIsCameraAutoFocusFaceModeSupported(long j);

    private static native boolean nativeIsCameraFocusPositionInPreviewSupported(long j);

    private static native boolean nativeIsCameraTorchSupported(long j);

    private static native boolean nativeIsCameraZoomSupported(long j);

    private static native boolean nativeIsFrontCamera(long j);

    private static native boolean nativeIsLowLatencyEarMonitorSupported(long j);

    private static native int nativeSetAudioRoute(long j, int i);

    private static native void nativeSetCameraCapturerParam(long j, CameraCaptureParam cameraCaptureParam);

    private static native int nativeSetCameraFocusPosition(long j, int i, int i2);

    private static native int nativeSetCameraZoomRatio(long j, float f);

    private static native int nativeSetExposureCompensation(long j, float f);

    private static native int nativeSetSystemVolumeType(long j, int i);

    private static native int nativeSwitchCamera(long j, boolean z);

    public static int systemVolumeTypeAsInt(TXDeviceManager.TXSystemVolumeType tXSystemVolumeType) {
        if (tXSystemVolumeType == TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto) {
            return 0;
        }
        if (tXSystemVolumeType == TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia) {
            return 1;
        }
        if (tXSystemVolumeType != TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP) {
            return 0;
        }
        return 2;
    }

    public static TXDeviceManager.TXSystemVolumeType systemVolumeTypefromInt(int i) {
        if (i == 0) {
            return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
        }
        if (i == 1) {
            return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia;
        }
        if (i == 2) {
            return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP;
        }
        return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int enableCameraAutoFocus(boolean z) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeEnableCameraAutoFocus(j, z);
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public boolean enableCameraTorch(boolean z) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeEnableCameraTorch(j, z);
        }
        return false;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeDeviceMgr = 0L;
        }
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public float getCameraZoomMaxRatio() {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeGetCameraZoomMaxRatio(j);
        }
        return 0.0f;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public boolean isAutoFocusEnabled() {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeIsAutoFocusEnabled(j);
        }
        return false;
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        long j = this.mNativeDeviceMgr;
        if (j == 0) {
            return false;
        }
        return nativeIsCameraAutoFocusFaceModeSupported(j);
    }

    public boolean isCameraFocusPositionInPreviewSupported() {
        long j = this.mNativeDeviceMgr;
        if (j == 0) {
            return false;
        }
        return nativeIsCameraFocusPositionInPreviewSupported(j);
    }

    public boolean isCameraTorchSupported() {
        long j = this.mNativeDeviceMgr;
        if (j == 0) {
            return false;
        }
        return nativeIsCameraTorchSupported(j);
    }

    public boolean isCameraZoomSupported() {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeIsCameraZoomSupported(j);
        }
        return false;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public boolean isFrontCamera() {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeIsFrontCamera(j);
        }
        return false;
    }

    public boolean isLowLatencyEarMonitorSupported() {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeIsLowLatencyEarMonitorSupported(j);
        }
        return false;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setAudioRoute(TXDeviceManager.TXAudioRoute tXAudioRoute) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeSetAudioRoute(j, audioRouteAsInt(tXAudioRoute));
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public void setCameraCapturerParam(TXDeviceManager.TXCameraCaptureParam tXCameraCaptureParam) {
        long j = this.mNativeDeviceMgr;
        if (j != 0 && tXCameraCaptureParam != null) {
            nativeSetCameraCapturerParam(j, new CameraCaptureParam(tXCameraCaptureParam));
        }
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setCameraFocusPosition(int i, int i2) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeSetCameraFocusPosition(j, i, i2);
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setCameraZoomRatio(float f) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeSetCameraZoomRatio(j, f);
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setExposureCompensation(float f) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeSetExposureCompensation(j, f);
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setSystemVolumeType(TXDeviceManager.TXSystemVolumeType tXSystemVolumeType) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeSetSystemVolumeType(j, systemVolumeTypeAsInt(tXSystemVolumeType));
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int switchCamera(boolean z) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeSwitchCamera(j, z);
        }
        return 0;
    }
}
