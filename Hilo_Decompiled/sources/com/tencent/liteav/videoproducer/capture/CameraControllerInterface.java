package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Process;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.q;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class CameraControllerInterface {
    public static final int CAMERA_ERROR_DEVICE = 4;
    public static final int CAMERA_ERROR_DISABLED = 2;
    public static final int CAMERA_ERROR_OCCUPIED = 1;
    public static final int CAMERA_ERROR_SERVER_DIED = 3;
    public static final int CAMERA_ERROR_UNKNOWN = 0;
    public static final int CAMERA_FACE_AE_STRATEGY_ALWAYS_ON = 1;
    public static final int CAMERA_FACE_AE_STRATEGY_BACK_ONLY = 3;
    public static final int CAMERA_FACE_AE_STRATEGY_FRONT_ONLY = 2;
    public static final int CAMERA_FACE_AE_STRATEGY_OFF = 0;
    private static final String TAG = "CameraControllerInterface";

    /* renamed from: com.tencent.liteav.videoproducer.capture.CameraControllerInterface$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.CAMERA_2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.CAMERA_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum a {
        MOCK(0),
        CAMERA_1(1),
        CAMERA_2(2);

        private final int mValue;

        a(int i) {
            this.mValue = i;
        }

        public static a a(int i) {
            for (a aVar : values()) {
                if (aVar.mValue == i) {
                    return aVar;
                }
            }
            return CAMERA_1;
        }
    }

    public static CameraControllerInterface createCameraController(int i, final Handler handler) {
        CameraControllerInterface aVar;
        a a2 = a.a(i);
        if (AnonymousClass1.a[a2.ordinal()] != 1) {
            aVar = new com.tencent.liteav.videoproducer.capture.a.a();
        } else {
            handler.getClass();
            aVar = new com.tencent.liteav.videoproducer.capture.b.a(new q(handler) { // from class: com.tencent.liteav.videoproducer.capture.a
                private final Handler a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = handler;
                }

                @Override // com.tencent.liteav.base.util.q
                public final void a(Runnable runnable) {
                    this.a.post(runnable);
                }
            });
        }
        LiteavLog.i(TAG, "createCameraController, CameraAPIType:" + a2 + ", return camera controller: " + aVar);
        return aVar;
    }

    public static boolean hasCameraPermission() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || LiteavSystemInfo.getSystemOSVersionInt() < 23 || applicationContext.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0) {
            return true;
        }
        return false;
    }

    public abstract void enableCameraDynamicFps(boolean z);

    public abstract void enableFaceDetection(boolean z);

    public abstract void enableTapToFocus(boolean z);

    public abstract FaceRect getCameraFaceRect();

    public abstract k getCameraSystemRotation();

    public abstract int getCameraSystemRotationValue();

    public abstract int getCurrentCameraISO();

    public abstract float getExposureCompensationStep();

    public abstract int getMaxZoom();

    public abstract Size getPreviewSize();

    public abstract boolean isCameraAutoFocusFaceModeSupported();

    public abstract boolean isCameraFocusPositionInPreviewSupported();

    public abstract boolean isCurrentPreviewSizeAspectRatioMatch(int i, int i2, boolean z);

    public abstract boolean isTorchSupported();

    public abstract boolean isZoomSupported();

    public abstract void setCameraRotationCorrectionValue(int i);

    public abstract void setExposureCompensation(int i);

    public abstract void setExposureCompensationNormalization(float f);

    public abstract void setFaceAEStrategy(int i);

    public abstract void setZoom(float f);

    public abstract void startAutoFocusAtPosition(int i, int i2);

    public abstract boolean startCapture(CameraCaptureParams cameraCaptureParams, SurfaceTexture surfaceTexture, CameraEventCallback cameraEventCallback);

    public abstract void stopCapture();

    public abstract void turnOnTorch(boolean z);
}
