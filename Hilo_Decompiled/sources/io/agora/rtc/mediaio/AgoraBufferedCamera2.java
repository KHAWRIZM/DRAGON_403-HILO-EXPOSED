package io.agora.rtc.mediaio;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.view.WindowManager;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.mediaio.MediaIO;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AgoraBufferedCamera2 extends CameraSource {
    private static final int STATE_PREVIEW = 0;
    private static final int STATE_WAITING_LOCK = 1;
    private static final int STATE_WAITING_NON_PRECAPTURE = 3;
    private static final int STATE_WAITING_PRECAPTURE = 2;
    private static final String TAG = "AgoraBufferedCamera2";
    private int cameraOrientation;
    private boolean isCameraFrontFacing;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    private byte[] mBufferArrayData;
    private ByteBuffer mByteBufferData;
    private CameraDevice mCameraDevice;
    private String mCameraId;
    private CameraCaptureSession mCaptureSession;
    private CameraCharacteristics mCharacteristics;
    private Context mContext;
    private boolean mFlashSupported;
    private ImageReader mImageReader;
    private CaptureParameters mParameters;
    private CaptureRequest mPreviewRequest;
    private CaptureRequest.Builder mPreviewRequestBuilder;
    private int mState = 0;
    private Semaphore mCameraOpenCloseLock = new Semaphore(1);
    private final ImageReader.OnImageAvailableListener mOnImageAvailableListener = new ImageReader.OnImageAvailableListener() { // from class: io.agora.rtc.mediaio.AgoraBufferedCamera2.1
        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image image = null;
            try {
                try {
                    Image acquireLatestImage = imageReader.acquireLatestImage();
                    if (acquireLatestImage == null) {
                        if (acquireLatestImage != null) {
                            acquireLatestImage.close();
                            return;
                        }
                        return;
                    }
                    if (acquireLatestImage.getFormat() == 35 && acquireLatestImage.getPlanes().length == 3) {
                        if (imageReader.getWidth() == acquireLatestImage.getWidth() && imageReader.getHeight() == acquireLatestImage.getHeight()) {
                            AgoraBufferedCamera2.readImageIntoBuffer(acquireLatestImage, AgoraBufferedCamera2.this.mBufferArrayData);
                            int frameOrientation = AgoraBufferedCamera2.this.getFrameOrientation();
                            AgoraBufferedCamera2 agoraBufferedCamera2 = AgoraBufferedCamera2.this;
                            if (agoraBufferedCamera2.consumer != null && agoraBufferedCamera2.mParameters.bufferType == MediaIO.BufferType.BYTE_ARRAY.intValue()) {
                                AgoraBufferedCamera2 agoraBufferedCamera22 = AgoraBufferedCamera2.this;
                                agoraBufferedCamera22.consumer.consumeByteArrayFrame(agoraBufferedCamera22.mBufferArrayData, AgoraBufferedCamera2.this.mParameters.pixelFormat, acquireLatestImage.getWidth(), acquireLatestImage.getHeight(), frameOrientation, System.currentTimeMillis());
                            } else {
                                AgoraBufferedCamera2 agoraBufferedCamera23 = AgoraBufferedCamera2.this;
                                if (agoraBufferedCamera23.consumer != null && agoraBufferedCamera23.mParameters.bufferType == MediaIO.BufferType.BYTE_BUFFER.intValue()) {
                                    AgoraBufferedCamera2.this.mByteBufferData.rewind();
                                    AgoraBufferedCamera2.this.mByteBufferData.put(AgoraBufferedCamera2.this.mBufferArrayData, 0, AgoraBufferedCamera2.this.mBufferArrayData.length);
                                    AgoraBufferedCamera2 agoraBufferedCamera24 = AgoraBufferedCamera2.this;
                                    agoraBufferedCamera24.consumer.consumeByteBufferFrame(agoraBufferedCamera24.mByteBufferData, AgoraBufferedCamera2.this.mParameters.pixelFormat, acquireLatestImage.getWidth(), acquireLatestImage.getHeight(), frameOrientation, System.currentTimeMillis());
                                }
                            }
                            acquireLatestImage.close();
                            return;
                        }
                        throw new IllegalStateException("ImageReader size " + imageReader.getWidth() + "x" + imageReader.getHeight() + " did not match Image size: " + acquireLatestImage.getWidth() + "x" + acquireLatestImage.getHeight());
                    }
                    Logging.e(AgoraBufferedCamera2.TAG, "Unexpected image format: " + acquireLatestImage.getFormat() + "or #planes:" + acquireLatestImage.getPlanes().length);
                    acquireLatestImage.close();
                } catch (IllegalStateException e10) {
                    Log.e(AgoraBufferedCamera2.TAG, "acquireLastest Image():", e10);
                    if (0 != 0) {
                        image.close();
                    }
                } catch (Exception unused) {
                    Log.e(AgoraBufferedCamera2.TAG, "fetch image failed...");
                    if (0 != 0) {
                        image.close();
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    image.close();
                }
                throw th;
            }
        }
    };
    private final CameraDevice.StateCallback mStateCallback = new CameraDevice.StateCallback() { // from class: io.agora.rtc.mediaio.AgoraBufferedCamera2.2
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            AgoraBufferedCamera2.this.mCameraDevice = null;
            AgoraBufferedCamera2.this.mCameraOpenCloseLock.release();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i10) {
            cameraDevice.close();
            AgoraBufferedCamera2.this.mCameraDevice = null;
            AgoraBufferedCamera2.this.mCameraOpenCloseLock.release();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            AgoraBufferedCamera2.this.mCameraDevice = cameraDevice;
            AgoraBufferedCamera2.this.createCameraPreviewSession();
            AgoraBufferedCamera2.this.mCameraOpenCloseLock.release();
        }
    };
    private CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: io.agora.rtc.mediaio.AgoraBufferedCamera2.3
        private void process(CaptureResult captureResult) {
            int i10 = AgoraBufferedCamera2.this.mState;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        return;
                    }
                    return;
                } else {
                    Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num == null || num.intValue() == 5 || num.intValue() == 4) {
                        AgoraBufferedCamera2.this.mState = 3;
                        return;
                    }
                    return;
                }
            }
            Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (num2 != null) {
                if (4 == num2.intValue() || 5 == num2.intValue()) {
                }
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

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static class CompareSizesByArea implements Comparator<Size> {
        CompareSizesByArea() {
        }

        @Override // java.util.Comparator
        public int compare(Size size, Size size2) {
            return Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
        }
    }

    public AgoraBufferedCamera2(Context context) {
        this.mContext = context;
        CaptureParameters captureParameters = new CaptureParameters();
        this.mParameters = captureParameters;
        captureParameters.width = 640;
        captureParameters.height = 480;
        captureParameters.fps = 15;
        captureParameters.pixelFormat = MediaIO.PixelFormat.I420.intValue();
        this.mParameters.bufferType = MediaIO.BufferType.BYTE_BUFFER.intValue();
        this.mParameters.captureType = MediaIO.CaptureType.CAMERA.intValue();
        this.mParameters.contentHint = MediaIO.ContentHint.NONE.intValue();
    }

    private void allocateBuffer(int i10) {
        int i11;
        if (i10 == MediaIO.PixelFormat.I420.intValue()) {
            CaptureParameters captureParameters = this.mParameters;
            i11 = ((captureParameters.width * captureParameters.height) * ImageFormat.getBitsPerPixel(35)) / 8;
        } else {
            i11 = 0;
        }
        if (this.mParameters.bufferType == MediaIO.BufferType.BYTE_ARRAY.intValue()) {
            this.mBufferArrayData = new byte[i11];
        } else if (this.mParameters.bufferType == MediaIO.BufferType.BYTE_BUFFER.intValue()) {
            this.mBufferArrayData = new byte[i11];
            this.mByteBufferData = ByteBuffer.allocateDirect(i11);
        }
    }

    private static Size chooseOptimalSize(Size[] sizeArr, int i10, int i11, int i12, int i13, Size size) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int width = size.getWidth();
        int height = size.getHeight();
        for (Size size2 : sizeArr) {
            if (size2.getWidth() <= i12 && size2.getHeight() <= i13 && size2.getHeight() == (size2.getWidth() * height) / width) {
                if (size2.getWidth() >= i10 && size2.getHeight() >= i11) {
                    arrayList.add(size2);
                } else {
                    arrayList2.add(size2);
                }
            }
        }
        if (arrayList.size() > 0) {
            return (Size) Collections.min(arrayList, new CompareSizesByArea());
        }
        if (arrayList2.size() > 0) {
            return (Size) Collections.max(arrayList2, new CompareSizesByArea());
        }
        Log.e(TAG, "Couldn't find any suitable preview size");
        return sizeArr[0];
    }

    private void closeCamera() {
        try {
            try {
                this.mCameraOpenCloseLock.acquire();
                CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.close();
                    this.mCaptureSession = null;
                }
                CameraDevice cameraDevice = this.mCameraDevice;
                if (cameraDevice != null) {
                    cameraDevice.close();
                    this.mCameraDevice = null;
                }
                ImageReader imageReader = this.mImageReader;
                if (imageReader != null) {
                    imageReader.close();
                    this.mImageReader = null;
                }
                this.mCameraOpenCloseLock.release();
            } catch (InterruptedException e10) {
                throw new RuntimeException("Interrupted while trying to lock camera closing.", e10);
            }
        } catch (Throwable th) {
            this.mCameraOpenCloseLock.release();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCameraPreviewSession() {
        try {
            CaptureRequest.Builder createCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
            this.mPreviewRequestBuilder = createCaptureRequest;
            CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
            createCaptureRequest.set(key, 1);
            this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_MODE, 1);
            this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 3);
            this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            if (this.mFlashSupported) {
                this.mPreviewRequestBuilder.set(key, 2);
            }
            this.mPreviewRequestBuilder.addTarget(this.mImageReader.getSurface());
            this.mCameraDevice.createCaptureSession(Arrays.asList(this.mImageReader.getSurface()), new CameraCaptureSession.StateCallback() { // from class: io.agora.rtc.mediaio.AgoraBufferedCamera2.4
                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                    Log.e(AgoraBufferedCamera2.TAG, "Configure camera failed");
                }

                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    if (AgoraBufferedCamera2.this.mCameraDevice != null) {
                        AgoraBufferedCamera2.this.mCaptureSession = cameraCaptureSession;
                        try {
                            AgoraBufferedCamera2 agoraBufferedCamera2 = AgoraBufferedCamera2.this;
                            agoraBufferedCamera2.mPreviewRequest = agoraBufferedCamera2.mPreviewRequestBuilder.build();
                            AgoraBufferedCamera2.this.mCaptureSession.setRepeatingRequest(AgoraBufferedCamera2.this.mPreviewRequest, AgoraBufferedCamera2.this.mCaptureCallback, AgoraBufferedCamera2.this.mBackgroundHandler);
                        } catch (CameraAccessException | IllegalStateException e10) {
                            e10.printStackTrace();
                        }
                    }
                }
            }, null);
        } catch (CameraAccessException e10) {
            e10.printStackTrace();
        }
    }

    private void doStop() {
        closeCamera();
        stopBackgroundThread();
    }

    private int getAndroidImageFormat(int i10) {
        if (i10 == MediaIO.PixelFormat.I420.intValue()) {
            return 35;
        }
        return 0;
    }

    private int getDeviceOrientation() {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return SubsamplingScaleImageView.ORIENTATION_270;
            }
            return 180;
        }
        return 90;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrameOrientation() {
        int deviceOrientation = getDeviceOrientation();
        if (!this.isCameraFrontFacing) {
            deviceOrientation = 360 - deviceOrientation;
        }
        return (this.cameraOrientation + deviceOrientation) % 360;
    }

    private void openCamera(int i10, int i11) {
        setUpCameraOutputs(i10, i11);
        CameraManager cameraManager = (CameraManager) this.mContext.getSystemService("camera");
        try {
            if (this.mCameraOpenCloseLock.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                cameraManager.openCamera(this.mCameraId, this.mStateCallback, this.mBackgroundHandler);
                return;
            }
            throw new RuntimeException("Time out waiting to lock camera opening.");
        } catch (CameraAccessException e10) {
            Log.e(TAG, e10.toString());
        } catch (InterruptedException e11) {
            throw new RuntimeException("Interrupted while trying to lock camera opening.", e11);
        } catch (SecurityException e12) {
            Log.e(TAG, e12.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readImageIntoBuffer(Image image, byte[] bArr) {
        int i10;
        int i11;
        int width = image.getWidth();
        int height = image.getHeight();
        Image.Plane[] planes = image.getPlanes();
        int i12 = 0;
        for (int i13 = 0; i13 < planes.length; i13++) {
            ByteBuffer buffer = planes[i13].getBuffer();
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
            if (pixelStride == 1 && rowStride == i10) {
                int i14 = i10 * i11;
                buffer.get(bArr, i12, i14);
                i12 += i14;
            } else {
                byte[] bArr2 = new byte[rowStride];
                for (int i15 = 0; i15 < i11 - 1; i15++) {
                    buffer.get(bArr2, 0, rowStride);
                    int i16 = 0;
                    while (i16 < i10) {
                        bArr[i12] = bArr2[i16 * pixelStride];
                        i16++;
                        i12++;
                    }
                }
                buffer.get(bArr2, 0, Math.min(rowStride, buffer.remaining()));
                int i17 = 0;
                while (i17 < i10) {
                    bArr[i12] = bArr2[i17 * pixelStride];
                    i17++;
                    i12++;
                }
            }
        }
    }

    private void setUpCameraOutputs(int i10, int i11) {
        boolean booleanValue;
        CameraManager cameraManager = (CameraManager) this.mContext.getSystemService("camera");
        try {
            for (String str : cameraManager.getCameraIdList()) {
                this.mCameraId = str;
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                this.mCharacteristics = cameraCharacteristics;
                this.cameraOrientation = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                Boolean bool = (Boolean) this.mCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                if (bool == null) {
                    booleanValue = false;
                } else {
                    booleanValue = bool.booleanValue();
                }
                this.mFlashSupported = booleanValue;
                if (!this.isCameraFrontFacing || ((Integer) this.mCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                    break;
                }
            }
            CaptureParameters captureParameters = this.mParameters;
            ImageReader newInstance = ImageReader.newInstance(captureParameters.width, captureParameters.height, getAndroidImageFormat(captureParameters.pixelFormat), 2);
            this.mImageReader = newInstance;
            newInstance.setOnImageAvailableListener(this.mOnImageAvailableListener, this.mBackgroundHandler);
        } catch (CameraAccessException e10) {
            e10.printStackTrace();
        } catch (NullPointerException unused) {
        }
    }

    private void startBackgroundThread() {
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.mBackgroundThread = handlerThread;
        handlerThread.start();
        this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        HandlerThread handlerThread = this.mBackgroundThread;
        if (handlerThread == null) {
            return;
        }
        handlerThread.quitSafely();
        try {
            this.mBackgroundThread.join();
            this.mBackgroundThread = null;
            this.mBackgroundHandler = null;
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public int getBufferType() {
        return this.mParameters.bufferType;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public int getCaptureType() {
        return this.mParameters.captureType;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public int getContentHint() {
        return this.mParameters.contentHint;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public void onDispose() {
        doStop();
        this.mBufferArrayData = null;
        this.mByteBufferData = null;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public boolean onInitialize(IVideoFrameConsumer iVideoFrameConsumer) {
        this.consumer = iVideoFrameConsumer;
        allocateBuffer(this.mParameters.pixelFormat);
        return true;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public boolean onStart() {
        startBackgroundThread();
        CaptureParameters captureParameters = this.mParameters;
        openCamera(captureParameters.width, captureParameters.height);
        return true;
    }

    @Override // io.agora.rtc.mediaio.IVideoSource
    public void onStop() {
        doStop();
    }

    public void useFrontCamera(boolean z10) {
        this.isCameraFrontFacing = z10;
    }

    public AgoraBufferedCamera2(Context context, CaptureParameters captureParameters) {
        this.mContext = context;
        if (captureParameters != null) {
            CaptureParameters captureParameters2 = new CaptureParameters();
            this.mParameters = captureParameters2;
            captureParameters2.width = captureParameters.width;
            captureParameters2.height = captureParameters.height;
            captureParameters2.fps = captureParameters.fps;
            captureParameters2.pixelFormat = captureParameters.pixelFormat;
            captureParameters2.bufferType = captureParameters.bufferType;
            captureParameters2.captureType = captureParameters.captureType;
            captureParameters2.contentHint = captureParameters.contentHint;
        }
    }
}
