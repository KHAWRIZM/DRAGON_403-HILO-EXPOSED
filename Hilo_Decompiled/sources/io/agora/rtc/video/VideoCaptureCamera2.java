package io.agora.rtc.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.SurfaceTextureHelper;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.video.VideoCapture;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

@TargetApi(21)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VideoCaptureCamera2 extends VideoCapture implements SurfaceTextureHelper.OnTextureFrameAvailableListener {
    private static final int DEFAULT_MATCH_FPS = 15;
    private static final float DEFAULT_VALUE = -1.0f;
    private static final String TAG = "CAMERA2";
    private static final boolean VERBOSE = false;
    private static final MeteringRectangle[] ZERO_WEIGHT_3A_REGION = {new MeteringRectangle(0, 0, 0, 0, 0)};
    private static final float ZOOM_UNSUPPORTED_DEFAULT_VALUE = 1.0f;
    private static final double kNanoSecondsToFps = 1.0E-9d;
    private static boolean usingLibyuv;
    private int[] distanceArray;
    private boolean faceDistaneEnabled;
    private boolean isFaceDetectionStarted;
    private MeteringRectangle[] mAFAERegions;
    private CameraCaptureSession.CaptureCallback mAfCaptureCallback;
    private int mAntiBandingMode;
    public CameraManager.AvailabilityCallback mAvailabilityCallback;
    private CameraDevice mCameraDevice;
    private CameraState mCameraState;
    private final Object mCameraStateLock;
    private HandlerThread mCameraStateThread;
    private final CameraCaptureSession.CaptureCallback mCaptureCallback;
    private byte[] mCaptureData;
    private int mCaptureFormat;
    private int mCaptureFps;
    private int mCaptureHeight;
    private CameraCaptureSession mCaptureSession;
    private final Object mCaptureSessionLock;
    private int mCaptureWidth;
    private float mCurZoomRatio;
    private int mEdgeEnhanceMode;
    private int mFaceDetectMode;
    private boolean mFaceDetectSupported;
    private ImageReader mImageReader;
    private final Object mImageReaderLock;
    private boolean mIsAutoFaceFocusEnabled;
    private final boolean mIsCameraFacingFront;
    private float mLastZoomRatio;
    private CameraManager mManager;
    private float mMaxZoom;
    private int mNoiseReductionMode;
    private CaptureRequest.Builder mPreviewBuilder;
    private HandlerThread mPreviewThread;
    private Rect mSensorRect;
    private Handler mStateHandler;
    private Surface mTextureOutputSurface;
    private int mVideoStabilityMode;
    private RectF[] rectArray;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum CameraState {
        OPENING,
        STARTED,
        EVICTED,
        STOPPED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class CaptureSessionListener extends CameraCaptureSession.StateCallback {
        private CaptureSessionListener() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Logging.e(VideoCaptureCamera2.TAG, "onConfigureFailed");
            if (VideoCaptureCamera2.this.mCameraState != CameraState.EVICTED) {
                VideoCaptureCamera2.this.changeCameraStateAndNotify(CameraState.STOPPED);
            }
            VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
            long j10 = videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid;
            if (j10 != 0) {
                videoCaptureCamera2.onCameraError(j10, 101);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            VideoCaptureCamera2.this.mCaptureSession = cameraCaptureSession;
            if (VideoCaptureCamera2.this.createCaptureRequest() != 0) {
                VideoCaptureCamera2.this.changeCameraStateAndNotify(CameraState.STOPPED);
                VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                long j10 = videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid;
                if (j10 != 0) {
                    videoCaptureCamera2.onCameraError(j10, 102);
                    return;
                }
                return;
            }
            VideoCaptureCamera2.this.changeCameraStateAndNotify(CameraState.STARTED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class CrStateListener extends CameraDevice.StateCallback {
        private CrStateListener() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            synchronized (VideoCaptureCamera2.this.mCameraStateLock) {
                try {
                    if (VideoCaptureCamera2.this.mCameraState != CameraState.STOPPED) {
                        Logging.w(VideoCaptureCamera2.TAG, "camera client is evicted by other application");
                        VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                        long j10 = videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid;
                        if (j10 != 0) {
                            videoCaptureCamera2.onCameraError(j10, 6);
                        }
                        Logging.i(VideoCaptureCamera2.TAG, "Camera device enter state: EVICTED");
                        if (VideoCaptureCamera2.this.mCameraDevice != null) {
                            VideoCaptureCamera2.this.mCameraDevice.close();
                            VideoCaptureCamera2.this.mCameraDevice = null;
                        }
                        VideoCaptureCamera2.this.mCameraState = CameraState.EVICTED;
                        VideoCaptureCamera2.this.mCameraStateLock.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i10) {
            if (VideoCaptureCamera2.this.mCameraState == CameraState.EVICTED) {
                return;
            }
            if (VideoCaptureCamera2.this.mCameraDevice != null) {
                VideoCaptureCamera2.this.mCameraDevice.close();
                VideoCaptureCamera2.this.mCameraDevice = null;
            }
            VideoCaptureCamera2.this.changeCameraStateAndNotify(CameraState.STOPPED);
            Logging.e(VideoCaptureCamera2.TAG, "CameraDevice Error :" + Integer.toString(i10));
            VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
            long j10 = videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid;
            if (j10 != 0) {
                int i11 = 1;
                if (i10 != 1) {
                    i11 = 2;
                    if (i10 != 2) {
                        i11 = 3;
                        if (i10 != 3) {
                            i11 = 4;
                            if (i10 != 4) {
                                i11 = 5;
                                if (i10 != 5) {
                                    i11 = VideoCapture.VideoCaptureEvent.kCameraErrorRuntimeUnknown;
                                }
                            }
                        }
                    }
                }
                videoCaptureCamera2.onCameraError(j10, i11);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            VideoCaptureCamera2.this.mCameraDevice = cameraDevice;
            if (VideoCaptureCamera2.this.doStartCapture() < 0) {
                VideoCaptureCamera2.this.doStopCapture();
                if (VideoCaptureCamera2.this.mCameraState != CameraState.EVICTED) {
                    VideoCaptureCamera2.this.changeCameraStateAndNotify(CameraState.STOPPED);
                }
                Logging.e(VideoCaptureCamera2.TAG, "Camera startCapture failed!!");
                VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                long j10 = videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid;
                if (j10 != 0) {
                    videoCaptureCamera2.onCameraError(j10, 100);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class ImageReaderListener implements ImageReader.OnImageAvailableListener {
        private ImageReaderListener() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            synchronized (VideoCaptureCamera2.this.mCameraStateLock) {
                Image image = null;
                try {
                    try {
                        try {
                            if (VideoCaptureCamera2.this.mCameraState == CameraState.STARTED && imageReader != null) {
                                if (VideoCaptureCamera2.this.mCaptureData != null && VideoCaptureCamera2.this.mCaptureData.length != 0 && VideoCaptureCamera2.this.mImageReader != null) {
                                    synchronized (VideoCaptureCamera2.this.mImageReaderLock) {
                                        if (VideoCaptureCamera2.this.mImageReader != null) {
                                            image = imageReader.acquireLatestImage();
                                            if (image == null) {
                                                if (image != null) {
                                                    image.close();
                                                }
                                                return;
                                            }
                                            if (image.getFormat() == 35 && image.getPlanes().length == 3) {
                                                if (imageReader.getWidth() == image.getWidth() && imageReader.getHeight() == image.getHeight()) {
                                                    VideoCaptureCamera2.readImageIntoBuffer(image, VideoCaptureCamera2.this.mCaptureData);
                                                    VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                                                    if (videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid != 0) {
                                                        byte[] bArr = videoCaptureCamera2.mCaptureData;
                                                        VideoCaptureCamera2 videoCaptureCamera22 = VideoCaptureCamera2.this;
                                                        videoCaptureCamera2.onRawBufferAvailable(bArr, videoCaptureCamera22.mExpectedRawBufferSize, videoCaptureCamera22.mCaptureWidth, VideoCaptureCamera2.this.mCaptureHeight, VideoCaptureCamera2.this.mCaptureFormat);
                                                    } else {
                                                        Logging.w(VideoCaptureCamera2.TAG, "warning mNativeVideoCaptureDeviceAndroid = 0, error");
                                                    }
                                                } else {
                                                    throw new IllegalStateException("ImageReader size " + imageReader.getWidth() + "x" + imageReader.getHeight() + " did not match Image size: " + image.getWidth() + "x" + image.getHeight());
                                                }
                                            }
                                            Logging.e(VideoCaptureCamera2.TAG, "Unexpected image format: " + image.getFormat() + "or #planes:" + image.getPlanes().length);
                                            image.close();
                                            return;
                                        }
                                        if (image != null) {
                                            image.close();
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                image.close();
                            }
                            throw th;
                        }
                    } catch (IllegalStateException e10) {
                        Logging.e(VideoCaptureCamera2.TAG, "acquireLastest Image():", e10);
                        if (0 != 0) {
                            image.close();
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static class SafeHandler extends Handler {
        public SafeHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Throwable th) {
                Logging.e(VideoCaptureCamera2.TAG, "handler exception", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoCaptureCamera2(Context context, int i10, int i11, EglBase.Context context2, long j10) {
        super(context, i10, i11, context2, j10);
        this.mCameraDevice = null;
        this.mPreviewBuilder = null;
        this.mCaptureSession = null;
        this.mCameraState = CameraState.STOPPED;
        this.mManager = null;
        this.mStateHandler = null;
        this.mCameraStateThread = null;
        this.mPreviewThread = null;
        this.mCameraStateLock = new Object();
        this.mCaptureWidth = -1;
        this.mCaptureHeight = -1;
        this.mCaptureFps = -1;
        this.mCaptureFormat = 35;
        this.mIsAutoFaceFocusEnabled = false;
        this.isFaceDetectionStarted = false;
        this.rectArray = null;
        this.distanceArray = null;
        this.faceDistaneEnabled = false;
        this.mAFAERegions = ZERO_WEIGHT_3A_REGION;
        this.mLastZoomRatio = DEFAULT_VALUE;
        this.mCurZoomRatio = 1.0f;
        this.mMaxZoom = DEFAULT_VALUE;
        this.mSensorRect = null;
        this.mAntiBandingMode = 3;
        this.mNoiseReductionMode = 1;
        this.mEdgeEnhanceMode = 0;
        this.mVideoStabilityMode = 0;
        this.mCaptureSessionLock = new Object();
        this.mImageReader = null;
        this.mImageReaderLock = new Object();
        this.mAvailabilityCallback = new CameraManager.AvailabilityCallback() { // from class: io.agora.rtc.video.VideoCaptureCamera2.1
            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public synchronized void onCameraAvailable(String str) {
                super.onCameraAvailable(str);
                synchronized (VideoCaptureCamera2.this.mCameraStateLock) {
                    try {
                        if (VideoCaptureCamera2.this.mCameraState == CameraState.EVICTED) {
                            Logging.i(VideoCaptureCamera2.TAG, "Camera " + str + " available, try start capture again");
                            if (VideoCaptureCamera2.this.tryOpenCamera() == 0) {
                                VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                                long j11 = videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid;
                                if (j11 != 0) {
                                    videoCaptureCamera2.onCameraError(j11, 0);
                                }
                            } else {
                                Logging.e(VideoCaptureCamera2.TAG, "start capture failed");
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public synchronized void onCameraUnavailable(String str) {
                super.onCameraUnavailable(str);
                Logging.e(VideoCaptureCamera2.TAG, "Camera " + str + " unavailable");
            }
        };
        this.mCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: io.agora.rtc.video.VideoCaptureCamera2.2
            private long mLastFocusedTs;

            private void notifyCameraFocusAreaChanged(Rect rect, Rect rect2) {
                Rect sensorToNormalizedPreview = CoordinatesTransform.sensorToNormalizedPreview(rect2, VideoCaptureCamera2.this.mCaptureWidth, VideoCaptureCamera2.this.mCaptureHeight, rect);
                Logging.d(VideoCaptureCamera2.TAG, "face bound = " + rect2.toString());
                Logging.d(VideoCaptureCamera2.TAG, "rect (-1000, 1000) = " + sensorToNormalizedPreview.toString());
                boolean z10 = true;
                if (VideoCaptureCamera2.this.mId != 1) {
                    z10 = false;
                }
                RectF normalizedFaceRect = CoordinatesTransform.normalizedFaceRect(sensorToNormalizedPreview, 0, z10);
                Logging.d(VideoCaptureCamera2.TAG, "preview size width = " + VideoCaptureCamera2.this.mCaptureWidth + " height = " + VideoCaptureCamera2.this.mCaptureHeight);
                Logging.d(VideoCaptureCamera2.TAG, "auto face focus left =" + normalizedFaceRect.left + " top = " + normalizedFaceRect.top + " right = " + normalizedFaceRect.right + " bottom = " + normalizedFaceRect.bottom + "isMirror =" + z10);
                float f10 = normalizedFaceRect.left;
                float f11 = normalizedFaceRect.top;
                float width = normalizedFaceRect.width();
                float height = normalizedFaceRect.height();
                VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                long j11 = videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid;
                if (j11 != 0) {
                    videoCaptureCamera2.NotifyCameraFocusAreaChanged(f10, f11, width, height, j11);
                }
            }

            private void notifyFaceDetection(Rect rect, Face[] faceArr) {
                VideoCaptureCamera2.this.rectArray = null;
                VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                int i12 = 0;
                boolean z10 = true;
                if (videoCaptureCamera2.mId != 1) {
                    z10 = false;
                }
                if (faceArr == null || faceArr.length <= 0) {
                    videoCaptureCamera2.rectArray = new RectF[0];
                } else {
                    int length = faceArr.length;
                    videoCaptureCamera2.rectArray = new RectF[length];
                    VideoCaptureCamera2.this.distanceArray = new int[length];
                    for (int i13 = 0; i13 < length; i13++) {
                        VideoCaptureCamera2.this.rectArray[i13] = CoordinatesTransform.normalizedFaceRect(CoordinatesTransform.sensorToNormalizedPreview(faceArr[i13].getBounds(), VideoCaptureCamera2.this.mCaptureWidth, VideoCaptureCamera2.this.mCaptureHeight, rect), 0, z10);
                        VideoCaptureCamera2.this.distanceArray[i13] = 5;
                    }
                    i12 = length;
                }
                Logging.d(VideoCaptureCamera2.TAG, "before notify face");
                VideoCaptureCamera2 videoCaptureCamera22 = VideoCaptureCamera2.this;
                videoCaptureCamera22.NotifyFaceDetection(videoCaptureCamera22.mCaptureWidth, VideoCaptureCamera2.this.mCaptureHeight, VideoCaptureCamera2.this.rectArray, i12, VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid);
            }

            private void process(CaptureResult captureResult) {
                Face[] faceArr = (Face[]) captureResult.get(CaptureResult.STATISTICS_FACES);
                if (faceArr == null || faceArr.length <= 0) {
                    VideoCaptureCamera2.this.mAFAERegions = VideoCaptureCamera2.ZERO_WEIGHT_3A_REGION;
                    return;
                }
                if (System.currentTimeMillis() - this.mLastFocusedTs < 3000) {
                    if (faceArr[0].getScore() > 20) {
                        notifyCameraFocusAreaChanged((Rect) captureResult.get(CaptureResult.SCALER_CROP_REGION), faceArr[0].getBounds());
                        return;
                    }
                    return;
                }
                if (faceArr[0].getScore() <= 50) {
                    return;
                }
                VideoCaptureCamera2.this.mAFAERegions = new MeteringRectangle[]{new MeteringRectangle(faceArr[0].getBounds(), 1000)};
                if (VideoCaptureCamera2.this.mPreviewBuilder == null) {
                    return;
                }
                VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                videoCaptureCamera2.addRegionsToCaptureRequestBuilder(videoCaptureCamera2.mPreviewBuilder);
                if (VideoCaptureCamera2.this.mCameraState != CameraState.STARTED) {
                    return;
                }
                try {
                    Rect rect = (Rect) captureResult.get(CaptureResult.SCALER_CROP_REGION);
                    Logging.d(VideoCaptureCamera2.TAG, "cropRegion = " + rect.toString());
                    Logging.d(VideoCaptureCamera2.TAG, "capture size wxh = " + VideoCaptureCamera2.this.mCaptureWidth + " x " + VideoCaptureCamera2.this.mCaptureHeight);
                    notifyCameraFocusAreaChanged(rect, faceArr[0].getBounds());
                    if (VideoCaptureCamera2.this.mCaptureSession != null) {
                        synchronized (VideoCaptureCamera2.this.mCaptureSessionLock) {
                            try {
                                if (VideoCaptureCamera2.this.mCaptureSession != null) {
                                    VideoCaptureCamera2.this.mCaptureSession.capture(VideoCaptureCamera2.this.mPreviewBuilder.build(), VideoCaptureCamera2.this.mCaptureCallback, null);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    VideoCaptureCamera2.this.createCaptureRequest();
                    this.mLastFocusedTs = System.currentTimeMillis();
                } catch (Exception e10) {
                    Logging.e(VideoCaptureCamera2.TAG, "capture: " + e10);
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                if (VideoCaptureCamera2.this.mIsAutoFaceFocusEnabled && VideoCaptureCamera2.this.isAutoFaceFocusSupported()) {
                    process(totalCaptureResult);
                }
                if (VideoCaptureCamera2.this.faceDistaneEnabled) {
                    notifyFaceDetection((Rect) totalCaptureResult.get(CaptureResult.SCALER_CROP_REGION), (Face[]) totalCaptureResult.get(CaptureResult.STATISTICS_FACES));
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            }
        };
        this.mAfCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: io.agora.rtc.video.VideoCaptureCamera2.3
            private void process(CaptureResult captureResult) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null || VideoCaptureCamera2.this.mPreviewBuilder == null) {
                    return;
                }
                if (4 == num.intValue() || 5 == num.intValue()) {
                    VideoCaptureCamera2.this.mPreviewBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    VideoCaptureCamera2.this.startNormalPreview();
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                process(totalCaptureResult);
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
                process(captureResult);
            }
        };
        this.mIsCameraFacingFront = isCameraFacingFront(context, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRegionsToCaptureRequestBuilder(CaptureRequest.Builder builder) {
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_TRIGGER;
        builder.set(key, 2);
        builder.set(CaptureRequest.CONTROL_AE_REGIONS, this.mAFAERegions);
        builder.set(CaptureRequest.CONTROL_AF_REGIONS, this.mAFAERegions);
        builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        builder.set(key, 0);
        builder.set(key, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCameraStateAndNotify(CameraState cameraState) {
        synchronized (this.mCameraStateLock) {
            this.mCameraState = cameraState;
            this.mCameraStateLock.notifyAll();
        }
    }

    private static int clamp(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i12, i10));
    }

    public static int createCapabilities(int i10, Context context) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(context, i10);
        if (cameraCharacteristics == null) {
            return -1;
        }
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            Logging.e(TAG, "Failed to create capabilities");
            return -1;
        }
        try {
            Logging.i(TAG, "dump configuration map:" + streamConfigurationMap.toString());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(streamConfigurationMap.getOutputSizes(35)));
        if ("SM-G9300".equals(Build.MODEL)) {
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                if (((Size) arrayList.get(i11)).getHeight() >= 720) {
                    arrayList2.add(arrayList.get(i11));
                }
            }
            arrayList = arrayList2;
        }
        String str = "\"id\":" + i10 + ",";
        String valueOf = String.valueOf(15);
        Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (rangeArr != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Range range : rangeArr) {
                arrayList3.add(range.getUpper());
            }
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                sb.append(((Integer) it.next()) + ",");
            }
            if (arrayList3.size() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            valueOf = sb.toString();
        }
        String str2 = "";
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            int width = ((Size) arrayList.get(i12)).getWidth();
            int height = ((Size) arrayList.get(i12)).getHeight();
            if (width >= 240 && height >= 240 && (width >= 320 || height >= 320)) {
                String str3 = "{\"w\":" + width + ",\"h\":" + height + "}";
                if (!str2.isEmpty()) {
                    str2 = str2 + "," + str3;
                } else {
                    str2 = str3;
                }
            }
        }
        VideoCapture.cacheCapability(i10, context, "{" + str + "\"resolution\":[" + str2 + "],\"format\":[" + ("" + VideoCapture.translateToEngineFormat(35)) + "],\"fps\":[" + valueOf + "]}", getCaptureName());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int createCaptureRequest() {
        CameraCaptureSession cameraCaptureSession;
        if (this.mPreviewBuilder == null || this.mPreviewThread == null || (cameraCaptureSession = this.mCaptureSession) == null) {
            return -1;
        }
        if (cameraCaptureSession != null) {
            try {
                synchronized (this.mCaptureSessionLock) {
                    try {
                        if (this.mPreviewBuilder != null && this.mPreviewThread != null && this.mCaptureSession != null) {
                            Handler handler = new Handler(this.mPreviewThread.getLooper());
                            setFaceDetect(this.mPreviewBuilder, this.mFaceDetectMode);
                            CameraCaptureSession cameraCaptureSession2 = this.mCaptureSession;
                            if (cameraCaptureSession2 != null) {
                                cameraCaptureSession2.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return 0;
            } catch (CameraAccessException e10) {
                Logging.e(TAG, "setRepeatingRequest: ", e10);
                return -1;
            } catch (IllegalArgumentException e11) {
                Logging.e(TAG, "setRepeatingRequest: ", e11);
                return -2;
            } catch (IllegalStateException e12) {
                Logging.e(TAG, "capture:" + e12);
                return -4;
            } catch (SecurityException e13) {
                Logging.e(TAG, "setRepeatingRequest: ", e13);
                return -3;
            }
        }
        return 0;
    }

    private Rect cropRegionForZoom(float f10) {
        int width = this.mSensorRect.width() / 2;
        int height = this.mSensorRect.height() / 2;
        int width2 = (int) ((this.mSensorRect.width() * 0.5f) / f10);
        int height2 = (int) ((this.mSensorRect.height() * 0.5f) / f10);
        return new Rect(width - width2, height - height2, width + width2, height + height2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doStartCapture() {
        Range[] rangeArr;
        if (this.mPreviewThread == null) {
            HandlerThread handlerThread = new HandlerThread("CameraPreview");
            this.mPreviewThread = handlerThread;
            handlerThread.start();
        }
        try {
            CaptureRequest.Builder createCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
            this.mPreviewBuilder = createCaptureRequest;
            if (createCaptureRequest == null) {
                Logging.e(TAG, "mPreviewBuilder error");
                return -4;
            }
            CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
            if (cameraCharacteristics != null && (rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES)) != null) {
                if (this.mPQFirst < 1) {
                    Arrays.sort(rangeArr, new Comparator<Range<Integer>>() { // from class: io.agora.rtc.video.VideoCaptureCamera2.4
                        @Override // java.util.Comparator
                        public int compare(Range<Integer> range, Range<Integer> range2) {
                            return range.getLower().intValue() - range2.getLower().intValue();
                        }
                    });
                    Logging.i(TAG, "sorted fps Ranges List:" + Arrays.toString(rangeArr));
                    int length = rangeArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            break;
                        }
                        Range range = rangeArr[i10];
                        if (((Integer) range.getLower()).intValue() >= Math.max(this.mCaptureFps, 15)) {
                            Logging.i(TAG, "set fps :" + range.toString() + " to camera2::fps first, request:" + this.mCaptureFps);
                            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                            break;
                        }
                        i10++;
                    }
                } else {
                    Arrays.sort(rangeArr, new Comparator<Range<Integer>>() { // from class: io.agora.rtc.video.VideoCaptureCamera2.5
                        @Override // java.util.Comparator
                        public int compare(Range<Integer> range2, Range<Integer> range3) {
                            return range2.getUpper().intValue() - range3.getUpper().intValue();
                        }
                    });
                    Logging.i(TAG, "sorted fps Ranges List:" + Arrays.toString(rangeArr));
                    int length2 = rangeArr.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length2) {
                            break;
                        }
                        Range range2 = rangeArr[i11];
                        if (((Integer) range2.getUpper()).intValue() >= this.mCaptureFps) {
                            Logging.i(TAG, "set fps :" + range2.toString() + " to camera2::PQ first, request:" + this.mCaptureFps);
                            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
                            break;
                        }
                        i11++;
                    }
                }
            }
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_MODE, 1);
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AF_MODE, 3);
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
            setFaceDetect(this.mPreviewBuilder, this.mFaceDetectMode);
            ArrayList arrayList = new ArrayList();
            int i12 = this.mCaptureOutputDataType;
            if (i12 == 1 || i12 == 2) {
                SurfaceTextureHelper create = SurfaceTextureHelper.create("Camera2Tex-" + this.mId, this.mShareContext, 8);
                this.mSurfaceTextureHelper = create;
                if (create == null) {
                    Logging.e(TAG, "Failed to create SurfaceTextureHelper, force fallback to raw data type");
                    this.mCaptureOutputDataType = 0;
                } else {
                    create.getSurfaceTexture().setDefaultBufferSize(this.mCaptureWidth, this.mCaptureHeight);
                    this.mSurfaceTextureHelper.startListening(this);
                    this.mEglContext = this.mSurfaceTextureHelper.getEglContext();
                    Surface surface = new Surface(this.mSurfaceTextureHelper.getSurfaceTexture());
                    this.mTextureOutputSurface = surface;
                    this.mPreviewBuilder.addTarget(surface);
                    arrayList.add(this.mTextureOutputSurface);
                    if (this.mCaptureOutputDataType == 2 && this.mTextureAndRawBufferSynchronizer == null) {
                        this.mTextureAndRawBufferSynchronizer = new VideoCapture.TextureAndRawBufferSynchronizer();
                    }
                }
            }
            int i13 = this.mCaptureOutputDataType;
            if (i13 == 0 || i13 == 2) {
                int bitsPerPixel = ((this.mCaptureWidth * this.mCaptureHeight) * ImageFormat.getBitsPerPixel(this.mCaptureFormat)) / 8;
                this.mExpectedRawBufferSize = bitsPerPixel;
                this.mCaptureData = new byte[bitsPerPixel];
                synchronized (this.mImageReaderLock) {
                    this.mImageReader = ImageReader.newInstance(this.mCaptureWidth, this.mCaptureHeight, this.mCaptureFormat, 2);
                    this.mImageReader.setOnImageAvailableListener(new ImageReaderListener(), new Handler(this.mPreviewThread.getLooper()));
                }
                Surface surface2 = this.mImageReader.getSurface();
                this.mPreviewBuilder.addTarget(surface2);
                arrayList.add(surface2);
            }
            try {
                this.mCameraDevice.createCaptureSession(arrayList, new CaptureSessionListener(), null);
                return 0;
            } catch (CameraAccessException e10) {
                Logging.e(TAG, "createCaptureSession :", e10);
                return -1;
            } catch (IllegalArgumentException e11) {
                Logging.e(TAG, "createCaptureSession :", e11);
                return -2;
            } catch (SecurityException e12) {
                Logging.e(TAG, "createCaptureSession :", e12);
                return -3;
            }
        } catch (CameraAccessException e13) {
            Logging.e(TAG, "createCaptureRequest: ", e13);
            return -1;
        } catch (IllegalArgumentException e14) {
            Logging.e(TAG, "createCaptureRequest: ", e14);
            return -2;
        } catch (SecurityException e15) {
            Logging.e(TAG, "createCaptureRequest ", e15);
            return -3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doStopCapture() {
        int i10;
        Logging.i(TAG, "doStopCapture");
        synchronized (this.mCaptureSessionLock) {
            HandlerThread handlerThread = this.mPreviewThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.mPreviewThread = null;
            }
            i10 = -1;
            try {
                try {
                    try {
                        try {
                            CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
                            if (cameraCaptureSession != null) {
                                cameraCaptureSession.abortCaptures();
                                this.mCaptureSession = null;
                            }
                            i10 = 0;
                        } catch (CameraAccessException e10) {
                            Logging.e(TAG, "abortCaptures: ", e10);
                        }
                    } catch (IllegalStateException e11) {
                        Logging.e(TAG, "abortCaptures: ", e11);
                    }
                } catch (IllegalArgumentException e12) {
                    Logging.e(TAG, "abortCaptures: ", e12);
                }
            } catch (Exception e13) {
                Logging.e(TAG, "abortCaptures: ", e13);
            }
        }
        if (this.mImageReader != null) {
            synchronized (this.mImageReaderLock) {
                try {
                    ImageReader imageReader = this.mImageReader;
                    if (imageReader != null) {
                        imageReader.setOnImageAvailableListener(null, null);
                        this.mImageReader.close();
                        this.mImageReader = null;
                    }
                } finally {
                }
            }
        }
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
            this.mEglContext = null;
        }
        Surface surface = this.mTextureOutputSurface;
        if (surface != null) {
            surface.release();
            this.mTextureOutputSurface = null;
        }
        CameraDevice cameraDevice = this.mCameraDevice;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.mCameraDevice = null;
        }
        return i10;
    }

    private static CameraCharacteristics getCameraCharacteristics(Context context, int i10) {
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            Logging.i(TAG, "getCameraCharacteristics error,  camera id: " + i10);
            return null;
        }
        try {
            return ((CameraManager) context.getSystemService("camera")).getCameraCharacteristics(Integer.toString(i10));
        } catch (CameraAccessException e10) {
            Logging.i(TAG, "getNumberOfCameras: getCameraIdList(): " + e10);
            return null;
        } catch (Exception e11) {
            Logging.i(TAG, "getNumberOfCameras: got exception: " + e11);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCaptureName() {
        return "camera2";
    }

    private int getFrameOrientation() {
        int checkOrientation = checkOrientation();
        if (!this.mIsCameraFacingFront) {
            checkOrientation = 360 - checkOrientation;
        }
        return (getSensorOrientation(this.mId, this.mContext) + checkOrientation) % 360;
    }

    public static int getFrontCameraIndex(Context context) {
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        try {
            for (String str : cameraManager.getCameraIdList()) {
                Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
                if (num != null && num.intValue() == 0) {
                    Logging.d(TAG, "getFrontCameraIndex str= " + str + ", int = " + Integer.parseInt(str));
                    return Integer.parseInt(str);
                }
            }
        } catch (Exception e10) {
            Logging.e(TAG, "getFrontCameraIndex: ", e10);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getName(int i10, Context context) {
        String str;
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(context, i10);
        if (cameraCharacteristics == null) {
            return null;
        }
        int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
        StringBuilder sb = new StringBuilder();
        sb.append("camera2 ");
        sb.append(i10);
        sb.append(", facing ");
        if (intValue == 0) {
            str = "front";
        } else {
            str = "back";
        }
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getNumberOfCameras(Context context) {
        try {
            int length = ((CameraManager) context.getSystemService("camera")).getCameraIdList().length;
            Logging.i(TAG, "VideoCaptureCamera2 listCount:" + length);
            return length;
        } catch (Exception e10) {
            Logging.e(TAG, "getNumberOfCameras: getCameraIdList(): ", e10);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getSensorOrientation(int i10, Context context) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(context, i10);
        if (cameraCharacteristics == null) {
            return -1;
        }
        return ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }

    static boolean isCameraFacingFront(Context context, int i10) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(context, i10);
        if (cameraCharacteristics != null) {
            Integer num = 0;
            return num.equals(cameraCharacteristics.get(CameraCharacteristics.LENS_FACING));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isLegacyDevice(Context context, int i10) {
        try {
            CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(context, i10);
            if (cameraCharacteristics == null) {
                return true;
            }
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            Logging.w(TAG, "this is a legacy camera device");
            return true;
        }
    }

    private boolean isMeteringAreaAFSupported() {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        if (((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() < 1) {
            return false;
        }
        return true;
    }

    private static boolean isSupported(int i10, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readImageIntoBuffer(Image image, byte[] bArr) {
        int i10;
        int i11;
        int width = image.getWidth();
        int height = image.getHeight();
        Image.Plane[] planes = image.getPlanes();
        int i12 = 1;
        if (usingLibyuv) {
            Image.Plane plane = planes[0];
            Image.Plane plane2 = planes[1];
            if (VideoCapture.ConvertFrameToI420(width, height, plane.getBuffer(), plane.getRowStride(), plane2.getBuffer(), planes[2].getBuffer(), plane2.getRowStride(), plane2.getPixelStride(), bArr) == 0) {
                return;
            } else {
                Logging.w(TAG, "readImageIntoBuffer: native convert I420 failed, using java method instead");
            }
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < planes.length) {
            ByteBuffer buffer = planes[i13].getBuffer();
            if (buffer == null) {
                Logging.e(TAG, "plane " + i13 + " buffer is null ");
                return;
            }
            int rowStride = planes[i13].getRowStride();
            int pixelStride = planes[i13].getPixelStride();
            if (i13 == 0) {
                i10 = width;
            } else {
                i10 = width / 2;
            }
            if (i13 == 0) {
                i11 = height;
            } else {
                i11 = height / 2;
            }
            if (pixelStride == i12 && rowStride == i10) {
                int i15 = i10 * i11;
                buffer.get(bArr, i14, i15);
                i14 += i15;
            } else {
                byte[] bArr2 = new byte[rowStride];
                for (int i16 = 0; i16 < i11 - 1; i16++) {
                    buffer.get(bArr2, 0, rowStride);
                    int i17 = 0;
                    while (i17 < i10) {
                        bArr[i14] = bArr2[i17 * pixelStride];
                        i17++;
                        i14++;
                    }
                }
                buffer.get(bArr2, 0, Math.min(rowStride, buffer.remaining()));
                int i18 = 0;
                while (i18 < i10) {
                    bArr[i14] = bArr2[i18 * pixelStride];
                    i18++;
                    i14++;
                }
            }
            i13++;
            i12 = 1;
        }
    }

    private void setExposureCompensation_l(int i10) {
        Logging.i(TAG, "setExposureCompensation:" + i10);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            return;
        }
        Rational rational = (Rational) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        Range range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        int intValue = ((Integer) range.getUpper()).intValue();
        int intValue2 = ((Integer) range.getLower()).intValue();
        Logging.i(TAG, "compensation step=" + rational + ", min=" + intValue2 + ", max=" + intValue);
        if (i10 > intValue) {
            i10 = intValue;
        }
        if (i10 >= intValue2) {
            intValue2 = i10;
        }
        if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
            synchronized (this.mCameraStateLock) {
                if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                    Handler handler = new Handler(this.mPreviewThread.getLooper());
                    CaptureRequest.Builder builder = this.mPreviewBuilder;
                    CaptureRequest.Key key = CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION;
                    Logging.i(TAG, "bf cur index=" + ((Integer) builder.get(key)).intValue());
                    this.mPreviewBuilder.set(key, Integer.valueOf(intValue2));
                    try {
                        this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                        int intValue3 = ((Integer) this.mPreviewBuilder.get(key)).intValue();
                        Logging.i(TAG, "af cur index=" + intValue3 + ", ev=" + ((intValue3 * rational.getNumerator()) / rational.getDenominator()));
                    } catch (CameraAccessException e10) {
                        e10.printStackTrace();
                    } catch (IllegalStateException e11) {
                        e11.printStackTrace();
                    }
                }
            }
        }
    }

    private void setFaceDetect(CaptureRequest.Builder builder, int i10) {
        if (this.mFaceDetectSupported) {
            boolean z10 = this.mIsAutoFaceFocusEnabled;
            if (z10 || this.faceDistaneEnabled) {
                if (i10 != 0 && !this.isFaceDetectionStarted) {
                    builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(i10));
                    this.isFaceDetectionStarted = true;
                } else if (i10 == 0) {
                    if (z10) {
                        Logging.w(TAG, "face detect did not turn off due to autoFocus on");
                    } else {
                        builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(i10));
                        this.isFaceDetectionStarted = false;
                    }
                }
            }
        }
    }

    private static void setUsingLibyuv(boolean z10) {
        usingLibyuv = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNormalPreview() {
        if (this.mPreviewBuilder != null && this.mPreviewThread != null && this.mCaptureSession != null) {
            try {
                synchronized (this.mCaptureSessionLock) {
                    try {
                        CaptureRequest.Builder builder = this.mPreviewBuilder;
                        if (builder != null && this.mPreviewThread != null && this.mCaptureSession != null) {
                            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
                            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                            this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, new Handler(this.mPreviewThread.getLooper()));
                        }
                    } finally {
                    }
                }
            } catch (CameraAccessException e10) {
                Logging.e(TAG, "setRepeatingRequest failed, error message : " + e10.getMessage());
            }
        }
    }

    private int toCamera2ABMode(int i10) {
        if (i10 < 0 || i10 > 3) {
            return 3;
        }
        return i10;
    }

    private int toCamera2EdgeEnhanceMode(int i10) {
        if (i10 < 0 || i10 > 3) {
            return 0;
        }
        return i10;
    }

    private int toCamera2NoiseMode(int i10) {
        if (i10 < 0 || i10 > 4) {
            return 0;
        }
        return i10;
    }

    private int toCamera2VideoStabilityMode(int i10) {
        if (i10 < 0 || i10 > 1) {
            return 0;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tryOpenCamera() {
        try {
            this.mManager.openCamera(Integer.toString(this.mId), new CrStateListener(), this.mStateHandler);
            return 0;
        } catch (CameraAccessException e10) {
            Logging.e(TAG, "allocate: manager.openCamera: ", e10);
            return -1;
        } catch (IllegalArgumentException e11) {
            Logging.e(TAG, "allocate: manager.openCamera: ", e11);
            return -2;
        } catch (SecurityException e12) {
            Logging.e(TAG, "allocate: manager.openCamera: ", e12);
            return -3;
        } catch (Exception e13) {
            Logging.e(TAG, "unknown error", e13);
            return -4;
        }
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int UnRegisterNativeHandle() {
        this.mNativeVideoCaptureDeviceAndroid = 0L;
        return 0;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int allocate() {
        synchronized (this.mCameraStateLock) {
            try {
                if (this.mCameraState == CameraState.OPENING) {
                    Logging.e(TAG, "allocate() invoked while Camera is busy opening/configuring");
                    return -1;
                }
                CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
                if (cameraCharacteristics == null) {
                    return -1;
                }
                if (VideoCapture.fetchCapability(this.mId, this.mContext, getCaptureName()) == null) {
                    createCapabilities(this.mId, this.mContext);
                }
                long j10 = this.mNativeVideoCaptureDeviceAndroid;
                if (j10 != 0) {
                    this.mIsAutoFaceFocusEnabled = isAutoFaceFocusEnabled(j10);
                    this.faceDistaneEnabled = isFaceDetectionEnabled(this.mNativeVideoCaptureDeviceAndroid);
                }
                this.mCameraNativeOrientation = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                this.mManager = (CameraManager) this.mContext.getSystemService("camera");
                int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES);
                int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue();
                if (iArr.length > 1 && intValue > 0) {
                    this.mFaceDetectSupported = true;
                    int i10 = 0;
                    for (int i11 : iArr) {
                        i10 += i11;
                    }
                    if (i10 % 2 != 0) {
                        this.mFaceDetectMode = 1;
                    } else {
                        this.mFaceDetectMode = 2;
                    }
                }
                Logging.i(TAG, "allocate() face detection: " + this.mFaceDetectMode + " " + intValue + " " + this.mFaceDetectSupported);
                if (this.mCameraStateThread == null) {
                    HandlerThread handlerThread = new HandlerThread("CameraCallbackThread");
                    this.mCameraStateThread = handlerThread;
                    handlerThread.start();
                    this.mStateHandler = new SafeHandler(this.mCameraStateThread.getLooper());
                }
                this.mManager.registerAvailabilityCallback(this.mAvailabilityCallback, this.mStateHandler);
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.agora.rtc.video.VideoCapture
    public void deallocate() {
        Logging.i(TAG, "deallocate");
        CameraManager cameraManager = this.mManager;
        if (cameraManager != null) {
            cameraManager.unregisterAvailabilityCallback(this.mAvailabilityCallback);
            HandlerThread handlerThread = this.mCameraStateThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.mCameraStateThread = null;
                this.mStateHandler = null;
            }
        }
    }

    @Override // io.agora.rtc.video.VideoCapture
    public float getMaxZoom() {
        if (this.mMaxZoom <= DownloadProgress.UNKNOWN_PROGRESS) {
            CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
            if (cameraCharacteristics == null) {
                Logging.w(TAG, "warning cameraCharacteristics is null");
                return DEFAULT_VALUE;
            }
            this.mMaxZoom = ((Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        }
        return this.mMaxZoom;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public boolean isAutoFaceFocusSupported() {
        if (!isFocusSupported()) {
            return false;
        }
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        if (((Integer) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue() <= 0) {
            return false;
        }
        return true;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public boolean isExposureSupported() {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr != null) {
            for (int i10 = 0; i10 < iArr.length; i10++) {
                Logging.d(TAG, "isExposureSupported AE mode = " + iArr[i10]);
                if (1 == i10) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public boolean isFocusSupported() {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr != null) {
            for (int i10 = 0; i10 < iArr.length; i10++) {
                if (1 == i10) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public boolean isTorchSupported() {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // io.agora.rtc.video.VideoCapture
    public boolean isZoomSupported() {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        if (((Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() <= 1.0f) {
            return false;
        }
        return true;
    }

    @Override // io.agora.rtc.gl.SurfaceTextureHelper.OnTextureFrameAvailableListener
    public void onTextureFrameAvailable(int i10, float[] fArr, long j10) {
        int frameOrientation = getFrameOrientation();
        if (this.mIsCameraFacingFront) {
            fArr = RendererCommon.multiplyMatrices(fArr, RendererCommon.horizontalFlipMatrix());
        }
        VideoFrame.TextureBuffer createTextureBuffer = this.mSurfaceTextureHelper.createTextureBuffer(this.mCaptureWidth, this.mCaptureHeight, RendererCommon.convertMatrixToAndroidGraphicsMatrix(RendererCommon.rotateTextureMatrix(fArr, 360 - frameOrientation)));
        onTextureBufferAvailable(createTextureBuffer, frameOrientation, j10);
        createTextureBuffer.release();
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setAntiBandingMode(int i10) {
        this.mAntiBandingMode = toCamera2ABMode(i10);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            return -1;
        }
        int i11 = this.mAntiBandingMode;
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_ANTIBANDING_MODES);
        if (iArr.length > 0) {
            for (int i12 : iArr) {
                if (i12 == i11) {
                    if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                        synchronized (this.mCaptureSessionLock) {
                            try {
                                if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                                    Handler handler = new Handler(this.mPreviewThread.getLooper());
                                    this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_ANTIBANDING_MODE, Integer.valueOf(i11));
                                    this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                                    return 0;
                                }
                            } catch (CameraAccessException e10) {
                                e10.printStackTrace();
                            } catch (IllegalStateException e11) {
                                e11.printStackTrace();
                            } finally {
                            }
                        }
                    }
                    Logging.i(TAG, "AgoraVideo set anti-banding = " + i11);
                    return 0;
                }
            }
        }
        Logging.i(TAG, "not supported anti-banding = " + i11);
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setAutoFaceFocus(boolean z10) {
        boolean z11;
        Object obj;
        int i10;
        if (this.mIsAutoFaceFocusEnabled != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.mIsAutoFaceFocusEnabled = z10;
        if (this.mFaceDetectSupported && z11) {
            if (this.mPreviewThread != null && this.mPreviewBuilder != null && (obj = this.mCaptureSessionLock) != null) {
                synchronized (obj) {
                    try {
                        if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                            Handler handler = new Handler(this.mPreviewThread.getLooper());
                            if (this.mIsAutoFaceFocusEnabled && (i10 = this.mFaceDetectMode) != 0 && !this.isFaceDetectionStarted) {
                                this.mPreviewBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(i10));
                                this.isFaceDetectionStarted = true;
                            } else {
                                if (this.faceDistaneEnabled) {
                                    Logging.w(TAG, "face detect did not turn off due to faceDistance on");
                                    return 0;
                                }
                                this.mPreviewBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
                                this.isFaceDetectionStarted = false;
                            }
                            this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                            return 0;
                        }
                    } catch (CameraAccessException e10) {
                        e10.printStackTrace();
                    } catch (IllegalStateException e11) {
                        e11.printStackTrace();
                    } finally {
                    }
                }
            }
        } else {
            Logging.w(TAG, "face detect no change");
        }
        return 0;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setCaptureFormat(int i10, int i11, boolean z10) {
        Logging.i(TAG, "setCaptureFormat: " + i10 + " type: " + i11 + " force texture oes: " + z10);
        VideoCapture.FORCE_TEXTURE_OES = z10;
        this.mCaptureOutputDataType = VideoCapture.translateToCaptureOutputDataType(i11);
        if (VideoCapture.translateToAndroidFormat(i10) != this.mCaptureFormat) {
            Logging.e(TAG, "For camera2 api, only YUV_420_888 format are supported");
            return -1;
        }
        return 0;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setEdgeEnhanceMode(int i10) {
        this.mEdgeEnhanceMode = toCamera2EdgeEnhanceMode(i10);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            return -1;
        }
        if (isSupported(this.mEdgeEnhanceMode, (int[]) cameraCharacteristics.get(CameraCharacteristics.EDGE_AVAILABLE_EDGE_MODES)) && this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
            synchronized (this.mCaptureSessionLock) {
                try {
                    if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                        Handler handler = new Handler(this.mPreviewThread.getLooper());
                        this.mPreviewBuilder.set(CaptureRequest.EDGE_MODE, Integer.valueOf(this.mEdgeEnhanceMode));
                        Logging.i(TAG, "setEdgeEnhanceMode = " + i10);
                        this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                        return 0;
                    }
                } catch (CameraAccessException e10) {
                    e10.printStackTrace();
                } catch (IllegalStateException e11) {
                    e11.printStackTrace();
                } finally {
                }
            }
        }
        Logging.e(TAG, "not supported EdgeEnhance Mode = " + i10);
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setExposure(float f10, float f11, boolean z10) {
        int i10;
        int i11;
        Logging.d(TAG, "setExposure called camera api2");
        if (f10 >= DownloadProgress.UNKNOWN_PROGRESS && f10 <= 1.0f && f11 >= DownloadProgress.UNKNOWN_PROGRESS && f11 <= 1.0f) {
            CaptureRequest.Builder builder = this.mPreviewBuilder;
            if (builder == null) {
                Logging.d(TAG, "setExposure mPreviewBuilder is null");
                return -1;
            }
            double d10 = f10;
            double d11 = f11;
            Rect rect = (Rect) builder.get(CaptureRequest.SCALER_CROP_REGION);
            if (rect == null) {
                return -1;
            }
            int width = rect.width();
            int height = rect.height();
            Logging.d(TAG, "crop width = " + width + " crop height = " + height + " capture width = " + this.mCaptureWidth + " capture height = " + this.mCaptureHeight);
            int i12 = this.mCaptureHeight;
            int i13 = width * i12;
            int i14 = this.mCaptureWidth;
            if (i13 > height * i14) {
                i10 = (int) (((width - r14) / 2.0f) + (d10 * ((i14 * height) / i12)));
                i11 = (int) (d11 * height);
            } else {
                i10 = (int) (d10 * width);
                i11 = (int) (((height - r12) / 2.0f) + (d11 * ((i12 * width) / i14)));
            }
            Rect rect2 = new Rect();
            double d12 = i10;
            double d13 = width * 0.05d;
            rect2.left = clamp((int) (d12 - d13), 0, width);
            rect2.right = clamp((int) (d12 + d13), 0, width);
            double d14 = i11;
            double d15 = 0.05d * height;
            rect2.top = clamp((int) (d14 - d15), 0, height);
            rect2.bottom = clamp((int) (d14 + d15), 0, height);
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            if (this.mCaptureSession != null) {
                synchronized (this.mCaptureSessionLock) {
                    CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
                    if (cameraCaptureSession != null) {
                        try {
                            try {
                                cameraCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), null, null);
                            } catch (CameraAccessException e10) {
                                e10.printStackTrace();
                                return -1;
                            }
                        } catch (IllegalStateException e11) {
                            e11.printStackTrace();
                            return -1;
                        }
                    }
                }
            }
            long j10 = this.mNativeVideoCaptureDeviceAndroid;
            if (j10 != 0) {
                NotifyCameraExposureAreaChanged(f10, f11, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, j10);
            }
            return 0;
        }
        Logging.e(TAG, "set exposure unreasonable inputs");
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setExposureCompensation(int i10) {
        setExposureCompensation_l(i10);
        return 0;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setFaceDetection(boolean z10) {
        boolean z11;
        int i10;
        if (this.faceDistaneEnabled != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.faceDistaneEnabled = z10;
        if (this.mFaceDetectSupported && z11) {
            if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                synchronized (this.mCaptureSessionLock) {
                    try {
                        if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                            Handler handler = new Handler(this.mPreviewThread.getLooper());
                            if (this.faceDistaneEnabled && (i10 = this.mFaceDetectMode) != 0 && !this.isFaceDetectionStarted) {
                                this.mPreviewBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(i10));
                                this.isFaceDetectionStarted = true;
                            } else {
                                if (this.mIsAutoFaceFocusEnabled) {
                                    Logging.w(TAG, "face detect did not turn off due to autoFocus on");
                                    return 0;
                                }
                                this.mPreviewBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
                                this.isFaceDetectionStarted = false;
                            }
                            this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                            return 0;
                        }
                    } catch (CameraAccessException e10) {
                        e10.printStackTrace();
                    } catch (IllegalStateException e11) {
                        e11.printStackTrace();
                    } finally {
                    }
                }
            }
        } else {
            Logging.w(TAG, "face detect no change");
        }
        return 0;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setFocus(float f10, float f11, boolean z10) {
        Rect rect;
        int i10;
        int i11;
        if (f10 >= DownloadProgress.UNKNOWN_PROGRESS && f10 <= 1.0f && f11 >= DownloadProgress.UNKNOWN_PROGRESS && f11 <= 1.0f) {
            CaptureRequest.Builder builder = this.mPreviewBuilder;
            if (builder == null) {
                Logging.d(TAG, "setFocus mPreviewBuilder is null");
                return -1;
            }
            double d10 = f10;
            double d11 = f11;
            if (builder == null || (rect = (Rect) builder.get(CaptureRequest.SCALER_CROP_REGION)) == null) {
                return -1;
            }
            int width = rect.width();
            int height = rect.height();
            Logging.d(TAG, "crop width = " + width + " crop height = " + height + " capture width = " + this.mCaptureWidth + " capture height = " + this.mCaptureHeight);
            int i12 = this.mCaptureHeight;
            int i13 = width * i12;
            int i14 = this.mCaptureWidth;
            if (i13 > height * i14) {
                i10 = (int) (((width - r14) / 2.0f) + (d10 * ((i14 * height) / i12)));
                i11 = (int) (d11 * height);
            } else {
                i10 = (int) (d10 * width);
                i11 = (int) (((height - r12) / 2.0f) + (d11 * ((i12 * width) / i14)));
            }
            Rect rect2 = new Rect();
            double d12 = i10;
            double d13 = width * 0.05d;
            rect2.left = clamp((int) (d12 - d13), 0, width);
            rect2.right = clamp((int) (d12 + d13), 0, width);
            double d14 = i11;
            double d15 = 0.05d * height;
            rect2.top = clamp((int) (d14 - d15), 0, height);
            rect2.bottom = clamp((int) (d14 + d15), 0, height);
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AF_MODE, 1);
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            if (this.mPreviewThread != null && this.mCaptureSession != null) {
                synchronized (this.mCaptureSessionLock) {
                    if (this.mPreviewThread != null && this.mCaptureSession != null) {
                        try {
                            this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mAfCaptureCallback, new Handler(this.mPreviewThread.getLooper()));
                        } catch (CameraAccessException e10) {
                            e10.printStackTrace();
                            return -1;
                        } catch (IllegalStateException e11) {
                            e11.printStackTrace();
                            return -1;
                        }
                    }
                }
                long j10 = this.mNativeVideoCaptureDeviceAndroid;
                if (j10 != 0) {
                    NotifyCameraFocusAreaChanged(f10, f11, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, j10);
                }
            }
            return 0;
        }
        Logging.e(TAG, "set focus unreasonable inputs");
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setNoiseReductionMode(int i10) {
        this.mNoiseReductionMode = toCamera2NoiseMode(i10);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            return -1;
        }
        if (isSupported(this.mNoiseReductionMode, (int[]) cameraCharacteristics.get(CameraCharacteristics.NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES)) && this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
            synchronized (this.mCaptureSessionLock) {
                try {
                    if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                        Handler handler = new Handler(this.mPreviewThread.getLooper());
                        this.mPreviewBuilder.set(CaptureRequest.NOISE_REDUCTION_MODE, Integer.valueOf(this.mNoiseReductionMode));
                        Logging.i(TAG, "setNoiseReductionMode = " + i10);
                        this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                        return 0;
                    }
                } catch (CameraAccessException e10) {
                    e10.printStackTrace();
                } catch (IllegalStateException e11) {
                    e11.printStackTrace();
                } finally {
                }
            }
        }
        Logging.e(TAG, "not supported NoiseReductionMode = " + i10);
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setTorchMode(boolean z10) {
        boolean booleanValue;
        Logging.d(TAG, "setFlashMode isTorchOn " + z10);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return -1;
        }
        if (this.mPreviewBuilder == null) {
            return -1;
        }
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        if (booleanValue) {
            if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                synchronized (this.mCaptureSessionLock) {
                    try {
                        if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                            Handler handler = new Handler(this.mPreviewThread.getLooper());
                            if (z10) {
                                this.mPreviewBuilder.set(CaptureRequest.FLASH_MODE, 2);
                            } else {
                                this.mPreviewBuilder.set(CaptureRequest.FLASH_MODE, 0);
                            }
                            this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), null, handler);
                            return 0;
                        }
                    } catch (CameraAccessException e10) {
                        e10.printStackTrace();
                    } catch (IllegalStateException e11) {
                        e11.printStackTrace();
                    } finally {
                    }
                }
            }
        } else {
            Logging.w(TAG, "flash is not supported");
        }
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setVideoStabilityMode(int i10) {
        this.mVideoStabilityMode = toCamera2VideoStabilityMode(i10);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            return -1;
        }
        if (isSupported(this.mVideoStabilityMode, (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) && this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
            synchronized (this.mCaptureSessionLock) {
                try {
                    if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                        Handler handler = new Handler(this.mPreviewThread.getLooper());
                        this.mPreviewBuilder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(this.mVideoStabilityMode));
                        Logging.i(TAG, "setVideoStabilityMode = " + i10);
                        this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                        return 0;
                    }
                } catch (CameraAccessException e10) {
                    e10.printStackTrace();
                } catch (IllegalStateException e11) {
                    e11.printStackTrace();
                } finally {
                }
            }
        }
        Logging.e(TAG, "not supported VideoStability Mode = " + i10);
        return -1;
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int setZoom(float f10) {
        CaptureRequest.Builder builder;
        Logging.d(TAG, "setCameraZoom api2 called zoomValue =" + f10);
        if (this.mPreviewBuilder == null) {
            Logging.d(TAG, "setZoom mPreviewBuilder is null");
            return -1;
        }
        if (this.mSensorRect == null) {
            CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
            if (cameraCharacteristics == null) {
                Logging.w(TAG, "warning cameraCharacteristics is null");
                return -1;
            }
            this.mSensorRect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            this.mMaxZoom = ((Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        }
        if (Math.abs(this.mMaxZoom - 1.0f) < 0.001f) {
            Logging.w(TAG, "Camera " + this.mId + " does not support camera zoom");
            return -1;
        }
        this.mCurZoomRatio = f10;
        if (f10 >= 1.0f && f10 <= this.mMaxZoom && f10 != this.mLastZoomRatio) {
            Rect cropRegionForZoom = cropRegionForZoom(f10);
            if (this.mPreviewThread != null && this.mPreviewBuilder != null && this.mCaptureSession != null) {
                synchronized (this.mCaptureSessionLock) {
                    if (this.mPreviewThread != null && (builder = this.mPreviewBuilder) != null && this.mCaptureSession != null) {
                        builder.set(CaptureRequest.SCALER_CROP_REGION, cropRegionForZoom);
                        this.mLastZoomRatio = this.mCurZoomRatio;
                        try {
                            try {
                                this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, new Handler(this.mPreviewThread.getLooper()));
                            } catch (IllegalStateException e10) {
                                e10.printStackTrace();
                                return -4;
                            }
                        } catch (CameraAccessException e11) {
                            e11.printStackTrace();
                            return -3;
                        }
                    }
                }
                return 0;
            }
            return 0;
        }
        return -2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        return 0;
     */
    @Override // io.agora.rtc.video.VideoCapture
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int startCapture(int i10, int i11, int i12) {
        Logging.i(TAG, "startCapture, w=" + i10 + ", h=" + i11 + ", fps=" + i12);
        this.mCaptureWidth = i10;
        this.mCaptureHeight = i11;
        this.mCaptureFps = i12;
        synchronized (this.mCameraStateLock) {
            while (true) {
                CameraState cameraState = this.mCameraState;
                CameraState cameraState2 = CameraState.STARTED;
                if (cameraState == cameraState2 || cameraState == CameraState.EVICTED || cameraState == CameraState.STOPPED) {
                    break;
                }
                try {
                    this.mCameraStateLock.wait();
                } catch (InterruptedException e10) {
                    Logging.e(TAG, "CaptureStartedEvent: ", e10);
                }
            }
            changeCameraStateAndNotify(CameraState.OPENING);
            int tryOpenCamera = tryOpenCamera();
            if (tryOpenCamera != 0) {
                changeCameraStateAndNotify(CameraState.STOPPED);
            }
            return tryOpenCamera;
        }
    }

    @Override // io.agora.rtc.video.VideoCapture
    public int stopCapture() {
        CameraState cameraState;
        Logging.i(TAG, "stopCapture");
        synchronized (this.mCameraStateLock) {
            while (true) {
                cameraState = this.mCameraState;
                if (cameraState == CameraState.STARTED || cameraState == CameraState.EVICTED || cameraState == CameraState.STOPPED) {
                    break;
                }
                try {
                    this.mCameraStateLock.wait();
                } catch (InterruptedException e10) {
                    Logging.e(TAG, "CaptureStartedEvent: ", e10);
                }
            }
            if (cameraState == CameraState.EVICTED) {
                this.mCameraState = CameraState.STOPPED;
            }
            CameraState cameraState2 = this.mCameraState;
            CameraState cameraState3 = CameraState.STOPPED;
            if (cameraState2 == cameraState3) {
                return 0;
            }
            doStopCapture();
            this.mCameraState = cameraState3;
            this.mCameraStateLock.notifyAll();
            return 0;
        }
    }
}
