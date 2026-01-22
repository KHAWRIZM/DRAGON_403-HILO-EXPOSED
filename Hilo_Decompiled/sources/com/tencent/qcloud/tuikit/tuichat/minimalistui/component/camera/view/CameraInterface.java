package com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.widget.ImageView;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.taobao.accs.flowcontrol.FlowControl;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.listener.ErrorListener;
import com.tencent.qcloud.tuikit.tuichat.util.AngleUtil;
import com.tencent.qcloud.tuikit.tuichat.util.CameraParamUtil;
import com.tencent.qcloud.tuikit.tuichat.util.CheckPermission;
import com.tencent.qcloud.tuikit.tuichat.util.DeviceUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CameraInterface implements Camera.PreviewCallback {
    private static final String TAG = "CameraInterface";
    public static final int TYPE_CAPTURE = 145;
    public static final int TYPE_RECORDER = 144;
    private static volatile CameraInterface mCameraInterface;
    private int SELECTED_CAMERA;
    private ErrorListener errorLisenter;
    private byte[] firstFrame_data;
    private Camera mCamera;
    private ImageView mFlashLamp;
    private Camera.Parameters mParams;
    private ImageView mSwitchView;
    private MediaRecorder mediaRecorder;
    private int nowAngle;
    private int preview_height;
    private int preview_width;
    private String videoFileAbsPath;
    private String videoFileName;
    int handlerTime = 0;
    private boolean isPreviewing = false;
    private int CAMERA_POST_POSITION = -1;
    private int CAMERA_FRONT_POSITION = -1;
    private SurfaceHolder mHolder = null;
    private float screenProp = -1.0f;
    private boolean isRecorder = false;
    private String saveVideoPath = TUIConfig.getMediaDir();
    private Bitmap videoFirstFrame = null;
    private int angle = 0;
    private int cameraAngle = 90;
    private int rotation = 0;
    private int nowScaleRate = 0;
    private int recordScleRate = 0;
    private int mediaQuality = 1600000;
    private SensorManager sm = null;
    private SensorEventListener sensorEventListener = new SensorEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.view.CameraInterface.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (1 != sensorEvent.sensor.getType()) {
                return;
            }
            float[] fArr = sensorEvent.values;
            CameraInterface.this.angle = AngleUtil.getSensorAngle(fArr[0], fArr[1]);
            CameraInterface.this.rotationAnimation();
        }
    };

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface CameraOpenOverCallback {
        void cameraHasOpened();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface ErrorCallback {
        void onError();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface FocusCallback {
        void focusSuccess();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface StopRecordCallback {
        void recordResult(String str, Bitmap bitmap);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface TakePictureCallback {
        void captureResult(Bitmap bitmap, boolean z);
    }

    private CameraInterface() {
        this.SELECTED_CAMERA = -1;
        findAvailableCameras();
        this.SELECTED_CAMERA = this.CAMERA_POST_POSITION;
    }

    private static Rect calculateTapArea(float f, float f2, float f3, Context context) {
        int screenWidth = (int) (((f / ScreenUtil.getScreenWidth(context)) * 2000.0f) - 1000.0f);
        int screenHeight = (int) (((f2 / ScreenUtil.getScreenHeight(context)) * 2000.0f) - 1000.0f);
        int intValue = Float.valueOf(f3 * 300.0f).intValue() / 2;
        RectF rectF = new RectF(clamp(screenWidth - intValue, FlowControl.DELAY_MAX_BRUSH, 1000), clamp(screenHeight - intValue, FlowControl.DELAY_MAX_BRUSH, 1000), r2 + r4, r3 + r4);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    private static int clamp(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public static void destroyCameraInterface() {
        if (mCameraInterface != null) {
            mCameraInterface.doDestroyCamera();
            mCameraInterface = null;
        }
    }

    private void findAvailableCameras() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            int i2 = cameraInfo.facing;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.CAMERA_FRONT_POSITION = i2;
                }
            } else {
                this.CAMERA_POST_POSITION = i2;
            }
        }
    }

    public static synchronized CameraInterface getInstance() {
        CameraInterface cameraInterface;
        synchronized (CameraInterface.class) {
            try {
                if (mCameraInterface == null) {
                    synchronized (CameraInterface.class) {
                        try {
                            if (mCameraInterface == null) {
                                mCameraInterface = new CameraInterface();
                            }
                        } finally {
                        }
                    }
                }
                cameraInterface = mCameraInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cameraInterface;
    }

    private synchronized void openCamera(int i) {
        try {
            this.mCamera = Camera.open(i);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorListener errorListener = this.errorLisenter;
            if (errorListener != null) {
                errorListener.onError();
            }
        }
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.enableShutterSound(false);
            } catch (Exception e2) {
                e2.printStackTrace();
                TUIChatLog.e(TAG, "enable shutter sound faild");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotationAnimation() {
        int i;
        int i2;
        int i3;
        ImageView imageView = this.mSwitchView;
        if (imageView != null && (i = this.rotation) != (i2 = this.angle)) {
            int i4 = -90;
            int i5 = 270;
            if (i != 0) {
                i3 = 180;
                if (i != 90) {
                    if (i != 180) {
                        if (i != 270) {
                            i4 = 0;
                        } else if (i2 == 0 || i2 != 180) {
                            i4 = 90;
                        } else {
                            i4 = 90;
                        }
                        i3 = 0;
                    } else {
                        if (i2 != 90) {
                            if (i2 != 270) {
                                i5 = 0;
                            } else {
                                i5 = 90;
                            }
                        }
                        i3 = i5;
                        i4 = 180;
                    }
                } else {
                    if (i2 != 0 && i2 == 180) {
                        i3 = -180;
                    }
                    i3 = 0;
                }
            } else {
                if (i2 != 90) {
                    if (i2 != 270) {
                        i4 = 0;
                    } else {
                        i4 = 90;
                    }
                }
                i3 = i4;
                i4 = 0;
            }
            float f = i4;
            float f2 = i3;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", f, f2);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mFlashLamp, "rotation", f, f2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.setDuration(500L);
            animatorSet.start();
            this.rotation = this.angle;
        }
    }

    private void setFlashModel() {
        Camera.Parameters parameters = this.mCamera.getParameters();
        this.mParams = parameters;
        parameters.setFlashMode("torch");
        this.mCamera.setParameters(this.mParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroyCamera() {
        this.errorLisenter = null;
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.mSwitchView = null;
                this.mFlashLamp = null;
                this.mCamera.stopPreview();
                this.mCamera.setPreviewDisplay(null);
                this.mHolder = null;
                this.isPreviewing = false;
                this.mCamera.release();
                this.mCamera = null;
                TUIChatLog.i(TAG, "=== Destroy Camera ===");
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        TUIChatLog.i(TAG, "=== Camera  Null===");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doOpenCamera(CameraOpenOverCallback cameraOpenOverCallback) {
        ErrorListener errorListener;
        if (Build.VERSION.SDK_INT < 23 && !CheckPermission.isCameraUseable(this.SELECTED_CAMERA) && (errorListener = this.errorLisenter) != null) {
            errorListener.onError();
            return;
        }
        if (this.mCamera == null) {
            openCamera(this.SELECTED_CAMERA);
        }
        cameraOpenOverCallback.cameraHasOpened();
    }

    public void doStartPreview(SurfaceHolder surfaceHolder, float f) {
        if (this.isPreviewing) {
            TUIChatLog.i(TAG, "doStartPreview isPreviewing");
        }
        if (this.screenProp < 0.0f) {
            this.screenProp = f;
        }
        if (surfaceHolder == null) {
            return;
        }
        this.mHolder = surfaceHolder;
        if (this.mCamera != null) {
            try {
                if (DeviceUtil.isVivoX21()) {
                    Camera camera = this.mCamera;
                    if (camera != null) {
                        camera.release();
                        this.mCamera = null;
                    }
                    openCamera(this.SELECTED_CAMERA);
                }
                this.mParams = this.mCamera.getParameters();
                Camera.Size previewSize = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedPreviewSizes(), 1000, f);
                Camera.Size pictureSize = CameraParamUtil.getInstance().getPictureSize(this.mParams.getSupportedPictureSizes(), 1200, f);
                this.mParams.setPreviewSize(previewSize.width, previewSize.height);
                this.preview_width = previewSize.width;
                this.preview_height = previewSize.height;
                this.mParams.setPictureSize(pictureSize.width, pictureSize.height);
                if (CameraParamUtil.getInstance().isSupportedFocusMode(this.mParams.getSupportedFocusModes(), "auto")) {
                    this.mParams.setFocusMode("auto");
                }
                if (CameraParamUtil.getInstance().isSupportedPictureFormats(this.mParams.getSupportedPictureFormats(), 256)) {
                    this.mParams.setPictureFormat(256);
                    this.mParams.setJpegQuality(100);
                }
                this.mCamera.setParameters(this.mParams);
                this.mParams = this.mCamera.getParameters();
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.setDisplayOrientation(this.cameraAngle);
                this.mCamera.setPreviewCallback(this);
                this.mCamera.startPreview();
                this.isPreviewing = true;
                TUIChatLog.i(TAG, "=== Start Preview ===");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void doStopPreview() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.mCamera.stopPreview();
                this.mCamera.setPreviewDisplay(null);
                this.isPreviewing = false;
                TUIChatLog.i(TAG, "=== Stop Preview ===");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleFocus(final Context context, final float f, final float f2, final FocusCallback focusCallback) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        Rect calculateTapArea = calculateTapArea(f, f2, 1.0f, context);
        this.mCamera.cancelAutoFocus();
        if (parameters.getMaxNumFocusAreas() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(calculateTapArea, RoomEvent.ROOM_MIC_EMOJI));
            parameters.setFocusAreas(arrayList);
            final String focusMode = parameters.getFocusMode();
            try {
                parameters.setFocusMode("auto");
                this.mCamera.setParameters(parameters);
                this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.view.CameraInterface.3
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z, Camera camera2) {
                        CameraInterface cameraInterface;
                        int i;
                        if (!z && (i = (cameraInterface = CameraInterface.this).handlerTime) <= 10) {
                            cameraInterface.handlerTime = i + 1;
                            cameraInterface.handleFocus(context, f, f2, focusCallback);
                            return;
                        }
                        Camera.Parameters parameters2 = camera2.getParameters();
                        parameters2.setFocusMode(focusMode);
                        camera2.setParameters(parameters2);
                        CameraInterface.this.handlerTime = 0;
                        focusCallback.focusSuccess();
                    }
                });
                return;
            } catch (Exception unused) {
                TUIChatLog.e(TAG, "autoFocus failer");
                return;
            }
        }
        TUIChatLog.i(TAG, "focus areas not supported");
        focusCallback.focusSuccess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void isPreview(boolean z) {
        this.isPreviewing = z;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.firstFrame_data = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerSensorManager(Context context) {
        if (this.sm == null) {
            this.sm = (SensorManager) context.getSystemService("sensor");
        }
        SensorManager sensorManager = this.sm;
        sensorManager.registerListener(this.sensorEventListener, sensorManager.getDefaultSensor(1), 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setErrorLinsenter(ErrorListener errorListener) {
        this.errorLisenter = errorListener;
    }

    public void setFlashMode(String str) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(str);
        this.mCamera.setParameters(parameters);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMediaQuality(int i) {
        this.mediaQuality = i;
    }

    public void setSwitchView(ImageView imageView, ImageView imageView2) {
        this.mSwitchView = imageView;
        this.mFlashLamp = imageView2;
        if (imageView != null) {
            this.cameraAngle = CameraParamUtil.getInstance().getCameraDisplayOrientation(imageView.getContext(), this.SELECTED_CAMERA);
        }
    }

    public void setZoom(float f, int i) {
        int i2;
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        if (this.mParams == null) {
            this.mParams = camera.getParameters();
        }
        if (this.mParams.isZoomSupported() && this.mParams.isSmoothZoomSupported()) {
            if (i != 144) {
                if (i != 145 || this.isRecorder) {
                    return;
                }
                int i3 = (int) (f / 50.0f);
                if (i3 < this.mParams.getMaxZoom()) {
                    int i4 = this.nowScaleRate + i3;
                    this.nowScaleRate = i4;
                    if (i4 < 0) {
                        this.nowScaleRate = 0;
                    } else if (i4 > this.mParams.getMaxZoom()) {
                        this.nowScaleRate = this.mParams.getMaxZoom();
                    }
                    this.mParams.setZoom(this.nowScaleRate);
                    this.mCamera.setParameters(this.mParams);
                }
                TUIChatLog.i(TAG, "setZoom = " + this.nowScaleRate);
                return;
            }
            if (this.isRecorder && f >= 0.0f && (i2 = (int) (f / 40.0f)) <= this.mParams.getMaxZoom() && i2 >= this.nowScaleRate && this.recordScleRate != i2) {
                this.mParams.setZoom(i2);
                this.mCamera.setParameters(this.mParams);
                this.recordScleRate = i2;
            }
        }
    }

    public void startRecord(Surface surface, float f, ErrorCallback errorCallback) {
        Camera.Size previewSize;
        this.mCamera.setPreviewCallback(null);
        int i = (this.angle + 90) % 360;
        Camera.Parameters parameters = this.mCamera.getParameters();
        int i2 = parameters.getPreviewSize().width;
        int i3 = parameters.getPreviewSize().height;
        YuvImage yuvImage = new YuvImage(this.firstFrame_data, parameters.getPreviewFormat(), i2, i3, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i2, i3), 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.videoFirstFrame = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Matrix matrix = new Matrix();
        int i4 = this.SELECTED_CAMERA;
        if (i4 == this.CAMERA_POST_POSITION) {
            matrix.setRotate(i);
        } else if (i4 == this.CAMERA_FRONT_POSITION) {
            matrix.setRotate(270.0f);
        }
        Bitmap bitmap = this.videoFirstFrame;
        this.videoFirstFrame = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.videoFirstFrame.getHeight(), matrix, true);
        if (this.isRecorder) {
            return;
        }
        if (this.mCamera == null) {
            openCamera(this.SELECTED_CAMERA);
        }
        if (this.mediaRecorder == null) {
            this.mediaRecorder = new MediaRecorder();
        }
        if (this.mParams == null) {
            this.mParams = this.mCamera.getParameters();
        }
        if (this.mParams.getSupportedFocusModes().contains("continuous-video")) {
            this.mParams.setFocusMode("continuous-video");
        }
        this.mCamera.setParameters(this.mParams);
        this.mCamera.unlock();
        this.mediaRecorder.reset();
        if (DeviceUtil.isVivoX21()) {
            this.mCamera.release();
            this.mCamera = null;
            openCamera(this.SELECTED_CAMERA);
            this.mCamera.setDisplayOrientation(90);
            this.mCamera.unlock();
        }
        this.mediaRecorder.setCamera(this.mCamera);
        this.mediaRecorder.setVideoSource(1);
        this.mediaRecorder.setAudioSource(1);
        this.mediaRecorder.setOutputFormat(2);
        this.mediaRecorder.setVideoEncoder(2);
        this.mediaRecorder.setAudioEncoder(3);
        if (this.mParams.getSupportedVideoSizes() == null) {
            previewSize = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedPreviewSizes(), 600, f);
        } else {
            previewSize = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedVideoSizes(), 600, f);
        }
        TUIChatLog.i(TAG, "setVideoSize    width = " + previewSize.width + "height = " + previewSize.height);
        int i5 = previewSize.width;
        int i6 = previewSize.height;
        if (i5 == i6) {
            this.mediaRecorder.setVideoSize(this.preview_width, this.preview_height);
        } else {
            this.mediaRecorder.setVideoSize(i5, i6);
        }
        if (this.SELECTED_CAMERA == this.CAMERA_FRONT_POSITION) {
            if (this.cameraAngle == 270) {
                if (i == 0) {
                    this.mediaRecorder.setOrientationHint(180);
                } else if (i == 270) {
                    this.mediaRecorder.setOrientationHint(270);
                } else {
                    this.mediaRecorder.setOrientationHint(90);
                }
            } else if (i == 90) {
                this.mediaRecorder.setOrientationHint(270);
            } else if (i == 270) {
                this.mediaRecorder.setOrientationHint(90);
            } else {
                this.mediaRecorder.setOrientationHint(i);
            }
        } else {
            this.mediaRecorder.setOrientationHint(i);
        }
        if (DeviceUtil.isHuaWeiOrHonor()) {
            this.mediaRecorder.setVideoEncodingBitRate(400000);
        } else {
            this.mediaRecorder.setVideoEncodingBitRate(this.mediaQuality);
        }
        this.mediaRecorder.setPreviewDisplay(surface);
        this.videoFileName = "video_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".mp4";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.saveVideoPath);
        sb2.append(this.videoFileName);
        String sb3 = sb2.toString();
        this.videoFileAbsPath = sb3;
        this.mediaRecorder.setOutputFile(sb3);
        try {
            this.mediaRecorder.prepare();
            this.mediaRecorder.start();
            this.isRecorder = true;
        } catch (IOException e) {
            e.printStackTrace();
            TUIChatLog.i(TAG, "startRecord IOException");
            ErrorListener errorListener = this.errorLisenter;
            if (errorListener != null) {
                errorListener.onError();
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            TUIChatLog.i(TAG, "startRecord IllegalStateException");
            ErrorListener errorListener2 = this.errorLisenter;
            if (errorListener2 != null) {
                errorListener2.onError();
            }
        } catch (RuntimeException unused) {
            TUIChatLog.i(TAG, "startRecord RuntimeException");
        }
    }

    public void stopRecord(boolean z, StopRecordCallback stopRecordCallback) {
        MediaRecorder mediaRecorder;
        if (this.isRecorder && (mediaRecorder = this.mediaRecorder) != null) {
            mediaRecorder.setOnErrorListener(null);
            this.mediaRecorder.setOnInfoListener(null);
            this.mediaRecorder.setPreviewDisplay(null);
            try {
                try {
                    this.mediaRecorder.stop();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    this.mediaRecorder = null;
                    MediaRecorder mediaRecorder2 = new MediaRecorder();
                    this.mediaRecorder = mediaRecorder2;
                }
            } finally {
                MediaRecorder mediaRecorder3 = this.mediaRecorder;
                if (mediaRecorder3 != null) {
                    mediaRecorder3.release();
                }
                this.mediaRecorder = null;
                this.isRecorder = false;
            }
        } else {
            return;
        }
        if (z) {
            if (FileUtil.deleteFile(this.videoFileAbsPath)) {
                stopRecordCallback.recordResult(null, null);
            }
        } else {
            doStopPreview();
            stopRecordCallback.recordResult(this.saveVideoPath + this.videoFileName, this.videoFirstFrame);
        }
    }

    public synchronized void switchCamera(SurfaceHolder surfaceHolder, float f) {
        try {
            int i = this.SELECTED_CAMERA;
            int i2 = this.CAMERA_POST_POSITION;
            if (i == i2) {
                this.SELECTED_CAMERA = this.CAMERA_FRONT_POSITION;
            } else {
                this.SELECTED_CAMERA = i2;
            }
            doDestroyCamera();
            TUIChatLog.i(TAG, "open start");
            openCamera(this.SELECTED_CAMERA);
            Camera camera = this.mCamera;
            if (camera != null) {
                try {
                    camera.enableShutterSound(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            TUIChatLog.i(TAG, "open end");
            doStartPreview(surfaceHolder, f);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void takePicture(final TakePictureCallback takePictureCallback) {
        if (this.mCamera == null) {
            return;
        }
        int i = this.cameraAngle;
        if (i != 90) {
            if (i == 270) {
                this.nowAngle = Math.abs(i - this.angle);
            }
        } else {
            this.nowAngle = Math.abs(this.angle + i) % 360;
        }
        TUIChatLog.i(TAG, this.angle + " = " + this.cameraAngle + " = " + this.nowAngle);
        this.mCamera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.view.CameraInterface.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                Matrix matrix = new Matrix();
                if (CameraInterface.this.SELECTED_CAMERA == CameraInterface.this.CAMERA_POST_POSITION) {
                    matrix.setRotate(CameraInterface.this.nowAngle);
                } else if (CameraInterface.this.SELECTED_CAMERA == CameraInterface.this.CAMERA_FRONT_POSITION) {
                    matrix.setRotate(360 - CameraInterface.this.nowAngle);
                    matrix.postScale(-1.0f, 1.0f);
                }
                Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                if (takePictureCallback != null) {
                    if (CameraInterface.this.nowAngle != 90 && CameraInterface.this.nowAngle != 270) {
                        takePictureCallback.captureResult(createBitmap, false);
                    } else {
                        takePictureCallback.captureResult(createBitmap, true);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterSensorManager(Context context) {
        if (this.sm == null) {
            this.sm = (SensorManager) context.getSystemService("sensor");
        }
        this.sm.unregisterListener(this.sensorEventListener);
    }
}
