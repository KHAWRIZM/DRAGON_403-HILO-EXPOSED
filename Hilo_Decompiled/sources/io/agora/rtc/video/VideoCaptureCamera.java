package io.agora.rtc.video;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import com.facebook.login.widget.ToolTipPopup;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.SurfaceTextureHelper;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.DeviceUtils;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.utils.ThreadUtils;
import io.agora.rtc.video.VideoCapture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.DebugKt;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VideoCaptureCamera extends VideoCapture implements Camera.PreviewCallback, SurfaceTextureHelper.OnTextureFrameAvailableListener {
    private static final int CAMERA_ALLOCATE_TIMEOUT_MS = 6000;
    private static final long CAMERA_OPEN_REQUEST_INTERVAL = 2000;
    private static final int NUM_OF_CAPTURE_BUFFERS = 3;
    private static final String TAG = "CAMERA1";
    private static final boolean VERBOSE = false;
    private int[] distanceArray;
    private boolean faceDetectEnabled;
    private boolean isCaptureRunning;
    private boolean isCaptureStarted;
    private boolean isFaceDetectionStarted;
    private boolean isSurfaceReady;
    private volatile int mAllocated;
    private String mAntiBandingMode;
    protected Camera mCamera;
    private HandlerThread mCameraPreviewHandlerThread;
    private int mCaptureFormat;
    private int mCaptureFps;
    private int mCaptureHeight;
    private ReentrantLock mCaptureLock;
    private int mCaptureWidth;
    private SurfaceTexture mDummySurfaceTexture;
    private boolean mIsAutoFaceFocusEnabled;
    private final boolean mIsCameraFacingFront;
    private Object mObjectLock;
    protected ReentrantLock mPreviewBufferLock;
    private Handler mPreviewHandler;
    private RectF[] rectArray;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoCaptureCamera(Context context, int i10, int i11, EglBase.Context context2, long j10) {
        super(context, i10, i11, context2, j10);
        this.mPreviewBufferLock = new ReentrantLock();
        this.mCaptureLock = new ReentrantLock();
        this.isCaptureStarted = false;
        this.isCaptureRunning = false;
        this.isSurfaceReady = false;
        this.isFaceDetectionStarted = false;
        this.mCaptureWidth = -1;
        this.mCaptureHeight = -1;
        this.mCaptureFps = -1;
        this.mCaptureFormat = 17;
        this.mCameraPreviewHandlerThread = null;
        this.mPreviewHandler = null;
        this.mObjectLock = new Object();
        this.mIsAutoFaceFocusEnabled = false;
        this.rectArray = null;
        this.distanceArray = null;
        this.faceDetectEnabled = false;
        this.mAntiBandingMode = "auto";
        this.mDummySurfaceTexture = null;
        this.mIsCameraFacingFront = isCameraFacingFront(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int allocate_l() {
        try {
            this.mCamera = Camera.open(this.mId);
            Camera.CameraInfo cameraInfo = getCameraInfo(this.mId);
            if (cameraInfo == null) {
                this.mCamera.release();
                this.mCamera = null;
                return -2;
            }
            if (VideoCapture.fetchCapability(this.mId, this.mContext, getCaptureName()) == null) {
                createCapabilities();
            }
            this.mCameraNativeOrientation = cameraInfo.orientation;
            long j10 = this.mNativeVideoCaptureDeviceAndroid;
            if (j10 != 0) {
                this.mIsAutoFaceFocusEnabled = isAutoFaceFocusEnabled(j10);
            }
            this.faceDetectEnabled = isFaceDetectionEnabled(this.mNativeVideoCaptureDeviceAndroid);
            return 0;
        } catch (RuntimeException e10) {
            Logging.e(TAG, "allocate: Camera.open: ", e10);
            return -1;
        }
    }

    private static Rect calculateTapArea(float f10, float f11, float f12) {
        int i10 = (int) ((f10 * 2000.0f) - 1000.0f);
        int i11 = (int) ((f11 * 2000.0f) - 1000.0f);
        int intValue = Float.valueOf(f12 * 300.0f).intValue() / 2;
        RectF rectF = new RectF(clamp(i10 - intValue, -1000, 1000), clamp(i11 - intValue, -1000, 1000), clamp(i10 + intValue, -1000, 1000), clamp(i11 + intValue, -1000, 1000));
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    private static int clamp(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i12, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deallocate_l() {
        this.mNativeVideoCaptureDeviceAndroid = 0L;
        stopCapture();
        this.mCaptureLock.lock();
        try {
            try {
                Camera camera = this.mCamera;
                if (camera != null) {
                    camera.release();
                    this.mCamera = null;
                }
            } catch (Exception e10) {
                Logging.e(TAG, "Camera release failed, " + e10);
            }
        } finally {
            this.mCaptureLock.unlock();
        }
    }

    protected static Camera.CameraInfo getCameraInfo(int i10) {
        if (i10 >= 0 && i10 <= Camera.getNumberOfCameras() - 1) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            try {
                Camera.getCameraInfo(i10, cameraInfo);
                return cameraInfo;
            } catch (RuntimeException e10) {
                Logging.e(TAG, "getCameraInfo: Camera.getCameraInfo: ", e10);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCaptureName() {
        return "camera1";
    }

    private int getFrameOrientation() {
        int checkOrientation = checkOrientation();
        if (!this.mIsCameraFacingFront) {
            checkOrientation = 360 - checkOrientation;
        }
        return (getSensorOrientation(this.mId) + checkOrientation) % 360;
    }

    public static int getFrontCameraIndex() {
        try {
            if (Camera.getNumberOfCameras() <= 1) {
                return 0;
            }
            return 1;
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMaxZoom_l() {
        int i10;
        if (this.mCamera != null) {
            Camera.Parameters cameraParameters = getCameraParameters();
            if (isZoomSupported(cameraParameters)) {
                i10 = cameraParameters.getMaxZoom();
            } else {
                i10 = 0;
            }
            List<Integer> zoomRatios = getZoomRatios();
            if (zoomRatios != null && zoomRatios.size() > i10) {
                return zoomRatios.get(i10).intValue() / 100.0f;
            }
            return -1.0f;
        }
        return -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getName(int i10) {
        String str;
        Camera.CameraInfo cameraInfo = getCameraInfo(i10);
        if (cameraInfo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("camera ");
        sb.append(i10);
        sb.append(", facing ");
        if (cameraInfo.facing == 1) {
            str = "front";
        } else {
            str = "back";
        }
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getNumberOfCameras() {
        int numberOfCameras = Camera.getNumberOfCameras();
        Logging.e(TAG, "camera1 listCount:" + numberOfCameras);
        return numberOfCameras;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getSensorOrientation(int i10) {
        Camera.CameraInfo cameraInfo = getCameraInfo(i10);
        if (cameraInfo == null) {
            return -1;
        }
        return cameraInfo.orientation;
    }

    private List<Integer> getZoomRatios() {
        if (this.mCamera != null) {
            Camera.Parameters cameraParameters = getCameraParameters();
            if (isZoomSupported(cameraParameters)) {
                return cameraParameters.getZoomRatios();
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAutoFaceFocusSupported_l() {
        Camera.Parameters cameraParameters;
        if (this.mCamera != null && (cameraParameters = getCameraParameters()) != null && cameraParameters.getMaxNumDetectedFaces() > 0 && cameraParameters.getMaxNumFocusAreas() > 0 && isSupported("auto", cameraParameters.getSupportedFocusModes())) {
            return true;
        }
        return false;
    }

    static boolean isCameraFacingFront(int i10) {
        Camera.CameraInfo cameraInfo = getCameraInfo(i10);
        if (cameraInfo == null || cameraInfo.facing == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isExposureSupported_l() {
        Camera.Parameters cameraParameters;
        if (this.mCamera == null || (cameraParameters = getCameraParameters()) == null || cameraParameters.getMaxNumMeteringAreas() <= 0) {
            return false;
        }
        return true;
    }

    private boolean isFaceDetectedSupported() {
        Camera.Parameters cameraParameters;
        if (this.mCamera != null && (cameraParameters = getCameraParameters()) != null && cameraParameters.getMaxNumDetectedFaces() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFocusSupported_l() {
        Camera.Parameters cameraParameters;
        if (this.mCamera == null || (cameraParameters = getCameraParameters()) == null || cameraParameters.getMaxNumFocusAreas() <= 0 || !isSupported("auto", cameraParameters.getSupportedFocusModes())) {
            return false;
        }
        return true;
    }

    private static boolean isSupported(String str, List<String> list) {
        if (list == null || list.indexOf(str) < 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTorchSupported_l() {
        Camera.Parameters cameraParameters;
        if (this.mCamera != null && (cameraParameters = getCameraParameters()) != null) {
            return isSupported("torch", cameraParameters.getSupportedFlashModes());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isZoomSupported_l() {
        Camera.Parameters cameraParameters;
        if (this.mCamera != null && (cameraParameters = getCameraParameters()) != null) {
            return cameraParameters.isZoomSupported();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCameraFocusAreaChanged(Rect rect) {
        boolean z10 = true;
        if (this.mId != 1) {
            z10 = false;
        }
        RectF normalizedFaceRect = CoordinatesTransform.normalizedFaceRect(rect, 0, z10);
        float f10 = normalizedFaceRect.left;
        float f11 = normalizedFaceRect.top;
        float width = normalizedFaceRect.width();
        float height = normalizedFaceRect.height();
        Logging.d(TAG, "auto face focus left =" + normalizedFaceRect.left + " top = " + normalizedFaceRect.top + " right = " + normalizedFaceRect.right + " bottom = " + normalizedFaceRect.bottom);
        NotifyCameraFocusAreaChanged(f10, f11, width, height, this.mNativeVideoCaptureDeviceAndroid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFaceDetection(Camera.Face[] faceArr) {
        this.rectArray = null;
        int i10 = 0;
        boolean z10 = true;
        if (this.mId != 1) {
            z10 = false;
        }
        if (faceArr != null && faceArr.length > 0) {
            int length = faceArr.length;
            this.rectArray = new RectF[length];
            this.distanceArray = new int[length];
            for (int i11 = 0; i11 < length; i11++) {
                this.rectArray[i11] = CoordinatesTransform.normalizedFaceRect(faceArr[i11].rect, 0, z10);
                this.distanceArray[i11] = 5;
            }
            i10 = length;
        } else {
            this.rectArray = new RectF[0];
        }
        NotifyFaceDetection(this.mCaptureWidth, this.mCaptureHeight, this.rectArray, i10, this.mNativeVideoCaptureDeviceAndroid);
    }

    private void setAdvancedCameraParameters(Camera.Parameters parameters) {
        if (isSupported(DebugKt.DEBUG_PROPERTY_VALUE_OFF, parameters.getSupportedFlashModes())) {
            Logging.i(TAG, "AgoraVideo set flash mode = FLASH_MODE_OFF");
            parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        }
        if (isSupported("auto", parameters.getSupportedWhiteBalance())) {
            Logging.i(TAG, "AgoraVideo set white blance = WHITE_BALANCE_AUTO");
            parameters.setWhiteBalance("auto");
        }
        if (isSupported("continuous-video", parameters.getSupportedFocusModes())) {
            Logging.i(TAG, "AgoraVideo set Focus mode = FOCUS_MODE_CONTINUOUS_VIDEO");
            parameters.setFocusMode("continuous-video");
        }
        String str = this.mAntiBandingMode;
        if (isSupported(str, parameters.getSupportedAntibanding())) {
            Logging.i(TAG, "AgoraVideo set anti-banding = " + this.mAntiBandingMode);
            parameters.setAntibanding(str);
        }
        if (isSupported("auto", parameters.getSupportedSceneModes())) {
            Logging.i(TAG, "AgoraVideo set sence mode = auto");
            if (parameters.getSceneMode() != "auto") {
                parameters.setSceneMode("auto");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setAntiBandingMode_l(int i10) {
        Camera.Parameters parameters;
        this.mAntiBandingMode = toCamera1ABMode(i10);
        Camera camera = this.mCamera;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return -1;
        }
        String str = this.mAntiBandingMode;
        if (isSupported(str, parameters.getSupportedAntibanding())) {
            Logging.i(TAG, "AgoraVideo set anti-banding = " + str);
            parameters.setAntibanding(str);
            try {
                this.mCamera.setParameters(parameters);
                return 0;
            } catch (Exception e10) {
                Logging.e(TAG, "anti banding got exception:" + e10);
                return 0;
            }
        }
        Logging.i(TAG, "not supported anti-banding = " + str);
        return -1;
    }

    private void setDeviceSpecificParameters(Camera.Parameters parameters) {
        String buildDeviceId = DeviceUtils.buildDeviceId();
        String cpuName = DeviceUtils.getCpuName();
        String cpuABI = DeviceUtils.getCpuABI();
        int numberOfCPUCores = DeviceUtils.getNumberOfCPUCores();
        int cPUMaxFreqKHz = DeviceUtils.getCPUMaxFreqKHz();
        Logging.i(TAG, "Current Device: " + buildDeviceId);
        Logging.i(TAG, "CPU name: " + cpuName + ", with " + numberOfCPUCores + " cores, arch: " + cpuABI + ", max Freq: " + cPUMaxFreqKHz);
        if (buildDeviceId.contains("xiaomi/mi note")) {
            Logging.i(TAG, "set MiNote config");
            parameters.set("scene-detect", DebugKt.DEBUG_PROPERTY_VALUE_ON);
            parameters.set("xiaomi-still-beautify-values", "i:3");
            parameters.set("skinToneEnhancement", "enable");
            parameters.set("auto-exposure", "center-weighted");
        }
        if (buildDeviceId.contains("oppo/r7c/r7c")) {
            Logging.i(TAG, "set oppo r7c config");
            parameters.set("skinToneEnhancement", 1);
            parameters.set("face-beautify", 100);
            parameters.set("auto-exposure", "center-weighted");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExposureCompensation_l(int i10) {
        Camera.Parameters parameters;
        Logging.i(TAG, "setExposureCompensation:" + i10);
        Camera camera = this.mCamera;
        if (camera != null && (parameters = camera.getParameters()) != null) {
            float exposureCompensationStep = parameters.getExposureCompensationStep();
            int minExposureCompensation = parameters.getMinExposureCompensation();
            int maxExposureCompensation = parameters.getMaxExposureCompensation();
            Logging.i(TAG, "compensation step=" + exposureCompensationStep + ", min=" + minExposureCompensation + ", max=" + maxExposureCompensation + ", cur index=" + parameters.getExposureCompensation());
            if (i10 > maxExposureCompensation) {
                i10 = maxExposureCompensation;
            }
            if (i10 >= minExposureCompensation) {
                minExposureCompensation = i10;
            }
            parameters.setExposureCompensation(minExposureCompensation);
            try {
                this.mCamera.setParameters(parameters);
            } catch (Exception e10) {
                Logging.e(TAG, "exposure compensation got exception:" + e10);
            }
            int exposureCompensation = parameters.getExposureCompensation();
            Logging.i(TAG, "cur index=" + exposureCompensation + ", ev=" + (exposureCompensationStep * exposureCompensation));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setExposure_l(float f10, float f11, boolean z10) {
        Logging.d(TAG, "setExposure called camera api1 x = " + f10 + " y = " + f11);
        if (this.mCamera == null) {
            return -1;
        }
        if (f10 >= DownloadProgress.UNKNOWN_PROGRESS && f10 <= 1.0f && f11 >= DownloadProgress.UNKNOWN_PROGRESS && f11 <= 1.0f) {
            Rect calculateTapArea = calculateTapArea(f10, f11, 1.5f);
            if (this.mCamera != null) {
                Camera.Parameters cameraParameters = getCameraParameters();
                if (cameraParameters == null) {
                    return -1;
                }
                if (cameraParameters.getMaxNumMeteringAreas() > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Camera.Area(calculateTapArea, 800));
                    cameraParameters.setMeteringAreas(arrayList);
                } else {
                    Logging.i(TAG, "metering areas not supported");
                }
                try {
                    this.mCamera.setParameters(cameraParameters);
                    this.mCamera.startPreview();
                } catch (Exception e10) {
                    Logging.e(TAG, "setExposure failed, " + e10);
                    return -1;
                }
            }
            long j10 = this.mNativeVideoCaptureDeviceAndroid;
            if (j10 != 0) {
                NotifyCameraExposureAreaChanged(f10, f11, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, j10);
                return 0;
            }
            return 0;
        }
        Logging.e(TAG, "set exposure unreasonable inputs");
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setFocus_l(float f10, float f11, boolean z10) {
        Logging.d(TAG, "setFocus called camera api1");
        if (this.mCamera == null) {
            return -1;
        }
        if (f10 >= DownloadProgress.UNKNOWN_PROGRESS && f10 <= 1.0f && f11 >= DownloadProgress.UNKNOWN_PROGRESS && f11 <= 1.0f) {
            Rect calculateTapArea = calculateTapArea(f10, f11, 1.0f);
            Rect calculateTapArea2 = calculateTapArea(f10, f11, 1.5f);
            try {
                this.mCamera.cancelAutoFocus();
            } catch (RuntimeException e10) {
                Logging.w(TAG, "Failed to cancle AutoFocus" + e10);
            }
            Camera.Parameters cameraParameters = getCameraParameters();
            if (cameraParameters == null) {
                return -1;
            }
            if (cameraParameters.getMaxNumFocusAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(calculateTapArea, 800));
                cameraParameters.setFocusAreas(arrayList);
            } else {
                Logging.i(TAG, "focus areas not supported");
            }
            if (cameraParameters.getMaxNumMeteringAreas() > 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new Camera.Area(calculateTapArea2, 800));
                cameraParameters.setMeteringAreas(arrayList2);
            } else {
                Logging.i(TAG, "metering areas not supported");
            }
            final String focusMode = cameraParameters.getFocusMode();
            if (isSupported("macro", cameraParameters.getSupportedFocusModes())) {
                cameraParameters.setFocusMode("macro");
                synchronized (this.mObjectLock) {
                    this.mCamera.setParameters(cameraParameters);
                }
            } else {
                Logging.i("focus", "FOCUS_MODE_MACRO is not supported");
            }
            try {
                this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: io.agora.rtc.video.VideoCaptureCamera.11
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z11, Camera camera) {
                        if (VideoCaptureCamera.this.mCamera == null) {
                            return;
                        }
                        Camera.Parameters parameters = camera.getParameters();
                        parameters.setFocusMode(focusMode);
                        synchronized (VideoCaptureCamera.this.mObjectLock) {
                            camera.setParameters(parameters);
                        }
                    }
                });
                long j10 = this.mNativeVideoCaptureDeviceAndroid;
                if (j10 != 0) {
                    NotifyCameraFocusAreaChanged(f10, f11, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, j10);
                    return 0;
                }
                return 0;
            } catch (Exception e11) {
                Logging.w(TAG, "mCamera.autoFocus Exception: " + e11);
                return -1;
            }
        }
        Logging.e(TAG, "set focus unreasonable inputs");
        return -1;
    }

    private void setPreviewFrameRateModeFPS(Camera.Parameters parameters, int i10) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange != null && supportedPreviewFpsRange.size() > 0) {
            int i11 = 0;
            while (true) {
                if (i11 >= supportedPreviewFpsRange.size()) {
                    break;
                }
                if (supportedPreviewFpsRange.get(i11)[0] >= i10 * 1000) {
                    parameters.setPreviewFpsRange(supportedPreviewFpsRange.get(i11)[0], supportedPreviewFpsRange.get(i11)[1]);
                    break;
                }
                i11++;
            }
            if (i11 == supportedPreviewFpsRange.size()) {
                int i12 = i11 - 1;
                parameters.setPreviewFpsRange(supportedPreviewFpsRange.get(i12)[0], supportedPreviewFpsRange.get(i12)[1]);
                return;
            }
            return;
        }
        parameters.setPreviewFrameRate(i10);
    }

    private void setPreviewFrameRateModePQ(Camera.Parameters parameters, int i10) {
        List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates != null && supportedPreviewFrameRates.size() != 0) {
            Logging.w(TAG, "getSupportedPreviewFrameRates: " + supportedPreviewFrameRates.toString());
            int abs = Math.abs(supportedPreviewFrameRates.get(0).intValue() - i10);
            int intValue = supportedPreviewFrameRates.get(0).intValue();
            for (Integer num : supportedPreviewFrameRates) {
                int abs2 = Math.abs(num.intValue() - i10);
                if (abs2 < abs) {
                    intValue = num.intValue();
                    abs = abs2;
                }
            }
            parameters.setPreviewFrameRate(intValue);
            return;
        }
        Logging.w(TAG, "setPreviewFrameRate: camera don't supported PQ first.");
        setPreviewFrameRateModeFPS(parameters, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setTorchMode_l(boolean z10) {
        Camera.Parameters cameraParameters;
        if (this.mCamera != null && (cameraParameters = getCameraParameters()) != null) {
            List<String> supportedFlashModes = cameraParameters.getSupportedFlashModes();
            if (supportedFlashModes != null && supportedFlashModes.contains("torch")) {
                if (z10) {
                    cameraParameters.setFlashMode("torch");
                } else {
                    cameraParameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                }
                this.mCamera.setParameters(cameraParameters);
                return 0;
            }
            return -1;
        }
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setZoom_l(float f10) {
        if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
            return -1;
        }
        int i10 = (int) ((f10 * 100.0f) + 0.5f);
        List<Integer> zoomRatios = getZoomRatios();
        if (zoomRatios == null) {
            return -1;
        }
        int i11 = 0;
        while (true) {
            if (i11 < zoomRatios.size()) {
                if (i10 <= zoomRatios.get(i11).intValue()) {
                    break;
                }
                i11++;
            } else {
                i11 = 0;
                break;
            }
        }
        if (this.mCamera != null) {
            Camera.Parameters cameraParameters = getCameraParameters();
            if (isZoomSupported(cameraParameters)) {
                if (i11 > cameraParameters.getMaxZoom()) {
                    Logging.w(TAG, "zoom value is larger than maxZoom value");
                    return -1;
                }
                cameraParameters.setZoom(i11);
                try {
                    this.mCamera.setParameters(cameraParameters);
                } catch (Exception e10) {
                    Logging.w(TAG, "setParameters failed, zoomLevel: " + i11 + ", " + e10);
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int startCapture_l(int i10, int i11, int i12) {
        SurfaceTexture surfaceTexture;
        Logging.i(TAG, "startCapture, w=" + i10 + ", h=" + i11 + ", fps=" + i12);
        int i13 = -1;
        if (this.mCamera == null) {
            Logging.e(TAG, "startCapture: camera is null!!");
            return -1;
        }
        int i14 = this.mCaptureOutputDataType;
        int i15 = 0;
        if (i14 == 1 || i14 == 2) {
            SurfaceTextureHelper create = SurfaceTextureHelper.create("Camera1Tex-" + this.mId, this.mShareContext, 8);
            this.mSurfaceTextureHelper = create;
            if (create == null) {
                Logging.e(TAG, "Failed to create SurfaceTextureHelper, force fallback to raw data type");
                this.mCaptureOutputDataType = 0;
            } else {
                create.getSurfaceTexture().setDefaultBufferSize(i10, i11);
                this.mSurfaceTextureHelper.startListening(this);
                this.mEglContext = this.mSurfaceTextureHelper.getEglContext();
                surfaceTexture = this.mSurfaceTextureHelper.getSurfaceTexture();
                if (this.mCaptureOutputDataType == 2 && this.mTextureAndRawBufferSynchronizer == null) {
                    this.mTextureAndRawBufferSynchronizer = new VideoCapture.TextureAndRawBufferSynchronizer();
                }
                if (this.mCaptureOutputDataType == 0) {
                    if (this.mDummySurfaceTexture == null) {
                        try {
                            this.mDummySurfaceTexture = new SurfaceTexture(42);
                        } catch (Surface.OutOfResourcesException unused) {
                            Logging.e(TAG, "failed to create dummy SurfaceTexture!");
                        }
                    }
                    surfaceTexture = this.mDummySurfaceTexture;
                }
                if (surfaceTexture != null) {
                    this.mCaptureLock.lock();
                    try {
                        this.mCamera.setPreviewTexture(surfaceTexture);
                    } catch (Exception unused2) {
                        Logging.e(TAG, "failed to set preview texture, invalid surfaceTexture!");
                        this.mDummySurfaceTexture = null;
                    } finally {
                    }
                    if (i15 != 0) {
                        return i15;
                    }
                    this.mCaptureLock.lock();
                    this.isCaptureStarted = true;
                    this.mCaptureWidth = i10;
                    this.mCaptureHeight = i11;
                    this.mCaptureFps = i12;
                    try {
                        i13 = tryStartCapture(i10, i11, i12);
                    } finally {
                        try {
                            return i13;
                        } finally {
                        }
                    }
                    return i13;
                }
                i15 = -1;
                if (i15 != 0) {
                }
            }
        }
        surfaceTexture = null;
        if (this.mCaptureOutputDataType == 0) {
        }
        if (surfaceTexture != null) {
        }
        i15 = -1;
        if (i15 != 0) {
        }
    }

    private void startFaceDetection() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, new Runnable() { // from class: io.agora.rtc.video.VideoCaptureCamera.5
                @Override // java.lang.Runnable
                public void run() {
                    VideoCaptureCamera.this.startFaceDetection_l();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFaceDetection_l() {
        if (this.mCamera == null) {
            return;
        }
        try {
            Logging.i(TAG, "enable face detection");
            this.mCamera.startFaceDetection();
            this.isFaceDetectionStarted = true;
        } catch (Exception e10) {
            Logging.e(TAG, "start face detection failed:" + e10);
            this.mCamera.stopFaceDetection();
            this.isFaceDetectionStarted = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int stopCapture_l() {
        int i10;
        if (!this.isCaptureStarted) {
            Logging.w(TAG, "already stop capture");
            return 0;
        }
        try {
            if (this.isFaceDetectionStarted) {
                stopFaceDetection();
                this.mCamera.setFaceDetectionListener(null);
            }
        } catch (RuntimeException e10) {
            Logging.e(TAG, "Failed to stop face detection", e10);
        }
        try {
            this.mCamera.cancelAutoFocus();
        } catch (RuntimeException e11) {
            Logging.e(TAG, "Failed to cancle AutoFocus", e11);
        }
        try {
            this.mPreviewBufferLock.lock();
            this.isCaptureRunning = false;
            this.mCamera.stopPreview();
            this.mCamera.setErrorCallback(null);
            AgoraVideoDebugger.reset();
            this.mDroppedTextureBufferCount = 0;
            VideoCapture.TextureAndRawBufferSynchronizer textureAndRawBufferSynchronizer = this.mTextureAndRawBufferSynchronizer;
            if (textureAndRawBufferSynchronizer != null) {
                textureAndRawBufferSynchronizer.reset();
            }
            SurfaceTextureHelper surfaceTextureHelper = this.mSurfaceTextureHelper;
            if (surfaceTextureHelper != null) {
                surfaceTextureHelper.stopListening();
                this.mSurfaceTextureHelper.dispose();
                this.mSurfaceTextureHelper = null;
            }
            this.mEglContext = null;
            int i11 = this.mCaptureOutputDataType;
            if (i11 == 0 || i11 == 2) {
                this.mCamera.setPreviewCallbackWithBuffer(null);
            }
            i10 = 0;
        } catch (RuntimeException e12) {
            Logging.e(TAG, "Failed to stop camera", e12);
            i10 = -1;
        }
        this.mPreviewBufferLock.unlock();
        if (i10 == 0) {
            this.isCaptureStarted = false;
        }
        return i10;
    }

    private void stopFaceDetection() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, new Runnable() { // from class: io.agora.rtc.video.VideoCaptureCamera.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoCaptureCamera.this.stopFaceDetection_l();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopFaceDetection_l() {
        if (this.mCamera == null) {
            return;
        }
        Logging.i(TAG, "disable face detection");
        this.mCamera.stopFaceDetection();
        this.isFaceDetectionStarted = false;
    }

    private String toCamera1ABMode(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return "auto";
                }
                return "60hz";
            }
            return "50hz";
        }
        return DebugKt.DEBUG_PROPERTY_VALUE_OFF;
    }

    private int tryStartCapture(int i10, int i11, int i12) {
        int bitsPerPixel;
        if (this.mCamera == null) {
            Logging.e(TAG, "Camera not initialized %d" + this.mId);
            return -1;
        }
        Logging.i(TAG, "tryStartCapture: " + i10 + "*" + i11 + ", frameRate: " + i12 + ", isCaptureRunning: " + this.isCaptureRunning + ", isSurfaceReady: " + this.isSurfaceReady + ", isCaptureStarted: " + this.isCaptureStarted + ", outputDataType: " + this.mCaptureOutputDataType);
        if (!this.isCaptureRunning && this.isCaptureStarted) {
            Camera.Parameters parameters = this.mCamera.getParameters();
            parameters.setPreviewSize(i10, i11);
            parameters.setPreviewFormat(this.mCaptureFormat);
            if (this.mPQFirst < 1) {
                Logging.i(TAG, "camera1::fps first");
                setPreviewFrameRateModeFPS(parameters, i12);
            } else {
                Logging.i(TAG, "camera1::PQ first");
                setPreviewFrameRateModePQ(parameters, i12);
            }
            setAdvancedCameraParameters(parameters);
            setDeviceSpecificParameters(parameters);
            this.mCamera.setParameters(parameters);
            int i13 = this.mCaptureOutputDataType;
            if (i13 != 0 && i13 != 2) {
                bitsPerPixel = 0;
            } else {
                bitsPerPixel = (((i10 * i11) * ImageFormat.getBitsPerPixel(this.mCaptureFormat)) / 8) + 4096;
                for (int i14 = 0; i14 < 3; i14++) {
                    this.mCamera.addCallbackBuffer(new byte[bitsPerPixel]);
                }
                this.mCamera.setPreviewCallbackWithBuffer(this);
            }
            this.mCamera.setErrorCallback(new Camera.ErrorCallback() { // from class: io.agora.rtc.video.VideoCaptureCamera.2
                @Override // android.hardware.Camera.ErrorCallback
                public void onError(int i15, Camera camera) {
                    int i16;
                    Logging.e(VideoCaptureCamera.TAG, "onError: error code " + i15);
                    VideoCaptureCamera videoCaptureCamera = VideoCaptureCamera.this;
                    if (videoCaptureCamera.mCamera != null) {
                        videoCaptureCamera.stopCapture();
                        VideoCaptureCamera.this.mCaptureLock.lock();
                        try {
                            try {
                                Camera camera2 = VideoCaptureCamera.this.mCamera;
                                if (camera2 != null) {
                                    camera2.release();
                                    VideoCaptureCamera.this.mCamera = null;
                                }
                            } catch (Exception e10) {
                                Logging.e(VideoCaptureCamera.TAG, "Camera release failed, " + e10);
                            }
                        } finally {
                            VideoCaptureCamera.this.mCaptureLock.unlock();
                        }
                    }
                    VideoCaptureCamera videoCaptureCamera2 = VideoCaptureCamera.this;
                    long j10 = videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid;
                    if (j10 != 0) {
                        if (i15 == 2) {
                            i16 = 6;
                        } else if (i15 == 100) {
                            i16 = 5;
                        } else {
                            i16 = VideoCapture.VideoCaptureEvent.kCameraErrorRuntimeUnknown;
                        }
                        videoCaptureCamera2.onCameraError(j10, i16);
                    }
                }
            });
            this.mCamera.startPreview();
            if (isAutoFaceFocusSupported()) {
                this.mCamera.setFaceDetectionListener(new Camera.FaceDetectionListener() { // from class: io.agora.rtc.video.VideoCaptureCamera.3
                    private long mLastFocusedTs;

                    @Override // android.hardware.Camera.FaceDetectionListener
                    public void onFaceDetection(Camera.Face[] faceArr, Camera camera) {
                        if (VideoCaptureCamera.this.faceDetectEnabled) {
                            VideoCaptureCamera.this.notifyFaceDetection(faceArr);
                        }
                        if (faceArr != null && faceArr.length != 0 && camera != null && VideoCaptureCamera.this.mIsAutoFaceFocusEnabled) {
                            if (System.currentTimeMillis() - this.mLastFocusedTs < 3000) {
                                Camera.Face face = faceArr[0];
                                if (face.score > 20) {
                                    VideoCaptureCamera.this.notifyCameraFocusAreaChanged(face.rect);
                                    return;
                                }
                                return;
                            }
                            if (faceArr[0].score <= 50) {
                                Logging.i(VideoCaptureCamera.TAG, "face score = " + faceArr[0].score);
                                return;
                            }
                            try {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(new Camera.Area(faceArr[0].rect, 1000));
                                if (camera.getParameters().getMaxNumFocusAreas() > 0) {
                                    camera.getParameters().setFocusAreas(arrayList);
                                }
                                if (camera.getParameters().getMaxNumMeteringAreas() > 0) {
                                    camera.getParameters().setMeteringAreas(arrayList);
                                }
                                VideoCaptureCamera.this.notifyCameraFocusAreaChanged(faceArr[0].rect);
                                camera.autoFocus(new Camera.AutoFocusCallback() { // from class: io.agora.rtc.video.VideoCaptureCamera.3.1
                                    @Override // android.hardware.Camera.AutoFocusCallback
                                    public void onAutoFocus(boolean z10, Camera camera2) {
                                        Logging.d(VideoCaptureCamera.TAG, "auto face focus called api1 every 3 seconds");
                                        if (camera2 != null) {
                                            try {
                                                camera2.cancelAutoFocus();
                                            } catch (RuntimeException e10) {
                                                Logging.w(VideoCaptureCamera.TAG, "Exception in cancelAutoFocus: " + Log.getStackTraceString(e10));
                                            }
                                        }
                                    }
                                });
                                this.mLastFocusedTs = System.currentTimeMillis();
                            } catch (RuntimeException e10) {
                                Logging.w(VideoCaptureCamera.TAG, "Exception in onFaceDetection callback: " + Log.getStackTraceString(e10));
                            }
                        }
                    }
                });
                if ((this.mIsAutoFaceFocusEnabled || this.faceDetectEnabled) && !this.isFaceDetectionStarted) {
                    startFaceDetection();
                }
            } else if (isFaceDetectedSupported()) {
                this.mCamera.setFaceDetectionListener(new Camera.FaceDetectionListener() { // from class: io.agora.rtc.video.VideoCaptureCamera.4
                    @Override // android.hardware.Camera.FaceDetectionListener
                    public void onFaceDetection(Camera.Face[] faceArr, Camera camera) {
                        if (VideoCaptureCamera.this.faceDetectEnabled) {
                            VideoCaptureCamera.this.notifyFaceDetection(faceArr);
                        }
                    }
                });
                if (this.faceDetectEnabled && !this.isFaceDetectionStarted) {
                    startFaceDetection();
                }
            }
            this.mPreviewBufferLock.lock();
            this.mExpectedRawBufferSize = bitsPerPixel;
            this.isCaptureRunning = true;
            this.mPreviewBufferLock.unlock();
            Logging.i(TAG, "Params: " + this.mCamera.getParameters().flatten());
            return 0;
        }
        Logging.w(TAG, "tryStartCapture return");
        return 0;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int UnRegisterNativeHandle() {
        Logging.d(TAG, "UnRegisterNativeHandle called");
        this.mNativeVideoCaptureDeviceAndroid = 0L;
        return 0;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int allocate() {
        if (this.mCameraPreviewHandlerThread == null) {
            HandlerThread handlerThread = new HandlerThread("camera-preview-thread");
            this.mCameraPreviewHandlerThread = handlerThread;
            handlerThread.start();
            if (this.mCameraPreviewHandlerThread != null) {
                this.mPreviewHandler = new Handler(this.mCameraPreviewHandlerThread.getLooper());
            }
        }
        this.mAllocated = -1;
        if (this.mPreviewHandler != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mPreviewHandler.postAtFrontOfQueue(new Runnable() { // from class: io.agora.rtc.video.VideoCaptureCamera.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoCaptureCamera videoCaptureCamera = VideoCaptureCamera.this;
                    videoCaptureCamera.mAllocated = videoCaptureCamera.allocate_l();
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
        return this.mAllocated;
    }

    public int createCapabilities() {
        String str;
        boolean z10;
        Camera.Parameters cameraParameters = getCameraParameters();
        if (cameraParameters != null) {
            String str2 = "\"id\":" + this.mId + ",";
            List<Camera.Size> supportedPreviewSizes = cameraParameters.getSupportedPreviewSizes();
            String str3 = "";
            String str4 = "";
            for (int i10 = 0; i10 < supportedPreviewSizes.size(); i10++) {
                int i11 = supportedPreviewSizes.get(i10).width;
                int i12 = supportedPreviewSizes.get(i10).height;
                if (i11 >= 240 && i12 >= 240 && (i11 >= 320 || i12 >= 320)) {
                    String str5 = "{\"w\":" + i11 + ",\"h\":" + i12 + "}";
                    if (!str4.isEmpty()) {
                        str4 = str4 + "," + str5;
                    } else {
                        str4 = str5;
                    }
                }
            }
            List<Integer> supportedPreviewFormats = cameraParameters.getSupportedPreviewFormats();
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr != null && strArr[0].startsWith("x86")) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (VideoCapture.isEmulator() || (z10 && supportedPreviewFormats.size() > 1)) {
                supportedPreviewFormats.remove((Object) 842094169);
            }
            String str6 = "";
            for (int i13 = 0; i13 < supportedPreviewFormats.size(); i13++) {
                int translateToEngineFormat = VideoCapture.translateToEngineFormat(supportedPreviewFormats.get(i13).intValue());
                if (i13 != supportedPreviewFormats.size() - 1) {
                    str6 = str6 + translateToEngineFormat + ",";
                } else {
                    str6 = str6 + translateToEngineFormat;
                }
            }
            List<Integer> supportedPreviewFrameRates = cameraParameters.getSupportedPreviewFrameRates();
            for (int i14 = 0; i14 < supportedPreviewFrameRates.size(); i14++) {
                int intValue = supportedPreviewFrameRates.get(i14).intValue();
                if (i14 != supportedPreviewFrameRates.size() - 1) {
                    str3 = str3 + intValue + ",";
                } else {
                    str3 = str3 + intValue;
                }
            }
            str = "{" + str2 + "\"resolution\":[" + str4 + "],\"format\":[" + str6 + "],\"fps\":[" + str3 + "]}";
        } else {
            str = null;
        }
        VideoCapture.cacheCapability(this.mId, this.mContext, str, getCaptureName());
        return 0;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public void deallocate() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, new Runnable() { // from class: io.agora.rtc.video.VideoCaptureCamera.20
                @Override // java.lang.Runnable
                public void run() {
                    VideoCaptureCamera.this.deallocate_l();
                }
            });
        }
        Handler handler2 = this.mPreviewHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread = this.mCameraPreviewHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mCameraPreviewHandlerThread = null;
            this.mPreviewHandler = null;
        }
    }

    public Camera.Parameters getCameraParameters() {
        try {
            return this.mCamera.getParameters();
        } catch (RuntimeException e10) {
            Logging.e(TAG, "getCameraParameters: Camera.getParameters: ", e10);
            Camera camera = this.mCamera;
            if (camera != null) {
                camera.release();
                this.mCamera = null;
            }
            return null;
        }
    }

    @Override // io.agora.rtc.video.VideoCapture
    public float getMaxZoom() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Float) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Float>() { // from class: io.agora.rtc.video.VideoCaptureCamera.8
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Float call() {
                    return Float.valueOf(VideoCaptureCamera.this.getMaxZoom_l());
                }
            })).floatValue();
        }
        return -1.0f;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public boolean isAutoFaceFocusSupported() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Boolean>() { // from class: io.agora.rtc.video.VideoCaptureCamera.19
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() {
                    return Boolean.valueOf(VideoCaptureCamera.this.isAutoFaceFocusSupported_l());
                }
            })).booleanValue();
        }
        return false;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public boolean isExposureSupported() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Boolean>() { // from class: io.agora.rtc.video.VideoCaptureCamera.17
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() {
                    return Boolean.valueOf(VideoCaptureCamera.this.isExposureSupported_l());
                }
            })).booleanValue();
        }
        return false;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public boolean isFocusSupported() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Boolean>() { // from class: io.agora.rtc.video.VideoCaptureCamera.16
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() {
                    return Boolean.valueOf(VideoCaptureCamera.this.isFocusSupported_l());
                }
            })).booleanValue();
        }
        return false;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public boolean isTorchSupported() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Boolean>() { // from class: io.agora.rtc.video.VideoCaptureCamera.15
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() {
                    return Boolean.valueOf(VideoCaptureCamera.this.isTorchSupported_l());
                }
            })).booleanValue();
        }
        return false;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public boolean isZoomSupported() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Boolean>() { // from class: io.agora.rtc.video.VideoCaptureCamera.18
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() {
                    return Boolean.valueOf(VideoCaptureCamera.this.isZoomSupported_l());
                }
            })).booleanValue();
        }
        return false;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        try {
            this.mPreviewBufferLock.lock();
            if (bArr != null && this.isCaptureRunning) {
                int length = bArr.length;
                int i10 = this.mExpectedRawBufferSize;
                if (length == i10 && this.mNativeVideoCaptureDeviceAndroid != 0) {
                    onRawBufferAvailable(bArr, i10, this.mCaptureWidth, this.mCaptureHeight, this.mCaptureFormat);
                } else if (this.mNativeVideoCaptureDeviceAndroid == 0) {
                    Logging.w(TAG, "warning mNativeVideoCaptureDeviceAndroid = 0, error");
                }
                if (camera != null && this.isCaptureRunning) {
                    camera.addCallbackBuffer(bArr);
                }
                this.mPreviewBufferLock.unlock();
            }
        } finally {
            if (camera != null && this.isCaptureRunning) {
                camera.addCallbackBuffer(bArr);
            }
            this.mPreviewBufferLock.unlock();
        }
    }

    @Override // io.agora.rtc.gl.SurfaceTextureHelper.OnTextureFrameAvailableListener
    public void onTextureFrameAvailable(int i10, float[] fArr, long j10) {
        int frameOrientation = getFrameOrientation();
        if (this.mIsCameraFacingFront) {
            fArr = RendererCommon.multiplyMatrices(fArr, RendererCommon.horizontalFlipMatrix());
        }
        VideoFrame.TextureBuffer createTextureBuffer = this.mSurfaceTextureHelper.createTextureBuffer(this.mCaptureWidth, this.mCaptureHeight, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr));
        onTextureBufferAvailable(createTextureBuffer, frameOrientation, j10);
        createTextureBuffer.release();
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setAntiBandingMode(final int i10) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() { // from class: io.agora.rtc.video.VideoCaptureCamera.21
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.setAntiBandingMode_l(i10));
                }
            })).intValue();
        }
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setAutoFaceFocus(boolean z10) {
        boolean z11;
        Logging.d(TAG, "setAutoFaceFocus: " + z10);
        if (this.mIsAutoFaceFocusEnabled != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.mIsAutoFaceFocusEnabled = z10;
        if (isAutoFaceFocusSupported() && z11) {
            boolean z12 = this.mIsAutoFaceFocusEnabled;
            if (z12 && !this.isFaceDetectionStarted) {
                startFaceDetection();
            } else if (!z12 && this.isFaceDetectionStarted && !this.faceDetectEnabled) {
                stopFaceDetection();
            }
        }
        return 0;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setCaptureFormat(int i10, int i11, boolean z10) {
        Logging.i(TAG, "setCaptureFormat: " + i10 + " type: " + i11 + " force texture oes: " + z10);
        VideoCapture.FORCE_TEXTURE_OES = z10;
        this.mCaptureOutputDataType = VideoCapture.translateToCaptureOutputDataType(i11);
        int translateToAndroidFormat = VideoCapture.translateToAndroidFormat(i10);
        this.mCaptureFormat = translateToAndroidFormat;
        if (translateToAndroidFormat == 0) {
            Logging.e(TAG, "setCaptureFormat failed, unkonwn format: " + i10);
            return -1;
        }
        return 0;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setEdgeEnhanceMode(int i10) {
        Logging.e(TAG, "EdgeEnhancement not supported in camera1 ");
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setExposure(final float f10, final float f11, final boolean z10) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() { // from class: io.agora.rtc.video.VideoCaptureCamera.12
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.setExposure_l(f10, f11, z10));
                }
            })).intValue();
        }
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setExposureCompensation(final int i10) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() { // from class: io.agora.rtc.video.VideoCaptureCamera.22
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    VideoCaptureCamera.this.setExposureCompensation_l(i10);
                    return 0;
                }
            })).intValue();
        }
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setFaceDetection(boolean z10) {
        boolean z11;
        Logging.d(TAG, "setFaceDetection: " + z10);
        if (this.faceDetectEnabled != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.faceDetectEnabled = z10;
        if (isFaceDetectedSupported() && z11) {
            boolean z12 = this.faceDetectEnabled;
            if (z12 && !this.isFaceDetectionStarted) {
                startFaceDetection();
            } else if (!z12 && this.isFaceDetectionStarted && !this.mIsAutoFaceFocusEnabled) {
                stopFaceDetection();
            }
        }
        return 0;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setFocus(final float f10, final float f11, final boolean z10) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() { // from class: io.agora.rtc.video.VideoCaptureCamera.10
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.setFocus_l(f10, f11, z10));
                }
            })).intValue();
        }
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setNoiseReductionMode(int i10) {
        Logging.e(TAG, "NoiseReduction not supported in camera1 ");
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setTorchMode(final boolean z10) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() { // from class: io.agora.rtc.video.VideoCaptureCamera.9
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.setTorchMode_l(z10));
                }
            })).intValue();
        }
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setVideoStabilityMode(int i10) {
        Logging.e(TAG, "VideoStability not supported in camera1 ");
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setZoom(final float f10) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() { // from class: io.agora.rtc.video.VideoCaptureCamera.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.setZoom_l(f10));
                }
            })).intValue();
        }
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int startCapture(final int i10, final int i11, final int i12) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() { // from class: io.agora.rtc.video.VideoCaptureCamera.13
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.startCapture_l(i10, i11, i12));
                }
            })).intValue();
        }
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int stopCapture() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() { // from class: io.agora.rtc.video.VideoCaptureCamera.14
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.stopCapture_l());
                }
            })).intValue();
        }
        return -1;
    }

    private boolean isZoomSupported(Camera.Parameters parameters) {
        if (parameters != null) {
            if (parameters.isZoomSupported()) {
                return true;
            }
            Logging.w(TAG, "camera zoom is not supported ");
        }
        return false;
    }
}
