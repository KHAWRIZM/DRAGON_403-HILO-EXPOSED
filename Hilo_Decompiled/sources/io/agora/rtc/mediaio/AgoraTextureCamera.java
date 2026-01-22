package io.agora.rtc.mediaio;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.WindowManager;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.mediaio.MediaIO;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AgoraTextureCamera extends TextureSource {
    private static final String TAG = "AgoraTextureCamera";
    private Camera camera;
    private Camera.CameraInfo info;
    private Context mContext;

    public AgoraTextureCamera(Context context, int i10, int i11) {
        super(null, i10, i11);
        this.mContext = context;
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

    private int getFrameOrientation() {
        int deviceOrientation = getDeviceOrientation();
        Camera.CameraInfo cameraInfo = this.info;
        if (cameraInfo.facing == 0) {
            deviceOrientation = 360 - deviceOrientation;
        }
        return (cameraInfo.orientation + deviceOrientation) % 360;
    }

    private void openCamera() {
        if (this.camera == null) {
            this.info = new Camera.CameraInfo();
            int numberOfCameras = Camera.getNumberOfCameras();
            int i10 = 0;
            while (true) {
                if (i10 >= numberOfCameras) {
                    break;
                }
                Camera.getCameraInfo(i10, this.info);
                if (this.info.facing == 1) {
                    this.camera = Camera.open(i10);
                    break;
                }
                i10++;
            }
            if (this.camera == null) {
                Log.d(TAG, "No front-facing camera found; opening default");
                this.camera = Camera.open();
            }
            Camera camera = this.camera;
            if (camera != null) {
                Camera.Parameters parameters = camera.getParameters();
                List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                parameters.setPreviewFpsRange(supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1)[0], supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1)[1]);
                parameters.setPreviewSize(this.mWidth, this.mHeight);
                parameters.setRecordingHint(true);
                this.camera.setParameters(parameters);
                Camera.Size previewSize = parameters.getPreviewSize();
                String str = previewSize.width + "x" + previewSize.height;
                Log.i(TAG, "Camera config: " + str);
                return;
            }
            throw new RuntimeException("Unable to open camera");
        }
        throw new RuntimeException("camera already initialized");
    }

    private void releaseCamera() {
        Camera camera = this.camera;
        if (camera != null) {
            camera.stopPreview();
            try {
                this.camera.setPreviewTexture(null);
            } catch (Exception unused) {
                Log.e(TAG, "failed to set Preview Texture");
            }
            this.camera.release();
            this.camera = null;
            Log.d(TAG, "releaseCamera -- done");
        }
    }

    @Override // io.agora.rtc.mediaio.TextureSource
    protected void onCapturerClosed() {
        releaseCamera();
    }

    @Override // io.agora.rtc.mediaio.TextureSource
    protected boolean onCapturerOpened() {
        try {
            openCamera();
            this.camera.setPreviewTexture(getSurfaceTexture());
            this.camera.startPreview();
            return true;
        } catch (IOException unused) {
            Log.e(TAG, "initialize: failed to initalize camera device");
            return false;
        }
    }

    @Override // io.agora.rtc.mediaio.TextureSource
    protected boolean onCapturerStarted() {
        this.camera.startPreview();
        return true;
    }

    @Override // io.agora.rtc.mediaio.TextureSource
    protected void onCapturerStopped() {
        this.camera.stopPreview();
    }

    @Override // io.agora.rtc.mediaio.TextureSource, io.agora.rtc.mediaio.SurfaceTextureHelper.OnTextureFrameAvailableListener
    public void onTextureFrameAvailable(int i10, float[] fArr, long j10) {
        IVideoFrameConsumer iVideoFrameConsumer;
        super.onTextureFrameAvailable(i10, fArr, j10);
        int frameOrientation = getFrameOrientation();
        if (this.info.facing == 1) {
            fArr = RendererCommon.multiplyMatrices(fArr, RendererCommon.horizontalFlipMatrix());
        }
        float[] fArr2 = fArr;
        WeakReference<IVideoFrameConsumer> weakReference = this.mConsumer;
        if (weakReference == null || (iVideoFrameConsumer = weakReference.get()) == null) {
            return;
        }
        iVideoFrameConsumer.consumeTextureFrame(i10, MediaIO.PixelFormat.TEXTURE_OES.intValue(), this.mWidth, this.mHeight, frameOrientation, System.currentTimeMillis(), fArr2);
    }

    public AgoraTextureCamera(Context context, int i10, int i11, boolean z10) {
        super(null, i10, i11, z10);
        this.mContext = context;
    }

    @Override // io.agora.rtc.mediaio.TextureSource, io.agora.rtc.mediaio.SurfaceTextureHelper.OnTextureFrameAvailableListener
    public void onTextureFrameAvailable(int i10, MediaIO.PixelFormat pixelFormat, float[] fArr, long j10) {
        IVideoFrameConsumer iVideoFrameConsumer;
        super.onTextureFrameAvailable(i10, pixelFormat, fArr, j10);
        int frameOrientation = getFrameOrientation();
        if (this.info.facing == 1) {
            fArr = RendererCommon.multiplyMatrices(fArr, RendererCommon.horizontalFlipMatrix());
        }
        float[] fArr2 = fArr;
        WeakReference<IVideoFrameConsumer> weakReference = this.mConsumer;
        if (weakReference == null || (iVideoFrameConsumer = weakReference.get()) == null) {
            return;
        }
        iVideoFrameConsumer.consumeTextureFrame(i10, pixelFormat.intValue(), this.mWidth, this.mHeight, frameOrientation, System.currentTimeMillis(), fArr2);
    }
}
