package io.agora.rtc.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.RectF;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.SurfaceTextureHelper;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.ATrace;
import io.agora.rtc.internal.Logging;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class VideoCapture {
    public static boolean FORCE_TEXTURE_OES = false;
    protected static final int MAX_BUFFER_CNT = 8;
    private static final String TAG = "VideoCapture";
    public static final int kCaptureFpsDefault = 0;
    public static final int kCaptureFpsLowPower = 1;
    public static final int kCaptureFpsUnknown = -1;
    private static final int kVideoI420 = 0;
    private static final int kVideoNV12 = 11;
    private static final int kVideoNV21 = 12;
    private static final int kVideoUnknown = 99;
    private static final int kVideoYUY2 = 2;
    private static final int kVideoYV12 = 1;
    protected int mCameraNativeOrientation;
    protected final Context mContext;
    protected EglBase.Context mEglContext;
    protected final int mId;
    protected long mNativeVideoCaptureDeviceAndroid;
    protected int mPQFirst;
    protected final EglBase.Context mShareContext;
    protected SurfaceTextureHelper mSurfaceTextureHelper;

    @CaptureOutputDataType
    protected int mCaptureOutputDataType = 0;
    protected int mExpectedRawBufferSize = 0;
    protected TextureAndRawBufferSynchronizer mTextureAndRawBufferSynchronizer = null;
    protected int mDroppedTextureBufferCount = 0;
    private int mLastRotation = -1;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    @interface CaptureOutputDataType {
        public static final int CAPTURE_OUTPUT_RAW = 0;
        public static final int CAPTURE_OUTPUT_TEXTURE = 1;
        public static final int CAPTURE_OUTPUT_TEXTURE_AND_RAW = 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class RawBuffer {
        byte[] data;
        int length;

        RawBuffer(byte[] bArr, int i10) {
            this.data = bArr;
            this.length = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class TexBuffer {
        int rotation;
        VideoFrame.TextureBuffer textureBuffer;
        long timestampNs;

        TexBuffer(VideoFrame.TextureBuffer textureBuffer, int i10, long j10) {
            this.textureBuffer = textureBuffer;
            this.rotation = i10;
            this.timestampNs = j10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    protected class TextureAndRawBufferSynchronizer {
        Queue<RawBuffer> rawBufferQueue = new LinkedList();
        Queue<TexBuffer> texBufferQueue = new LinkedList();
        int pendingRemoveRawBufferCount = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        public TextureAndRawBufferSynchronizer() {
        }

        private void checkAndResetIfNeeded() {
            String str;
            if (this.texBufferQueue.size() > 16 || this.rawBufferQueue.size() > 16) {
                if (this.texBufferQueue.size() > 16) {
                    str = "raw";
                } else {
                    str = "texture";
                }
                Logging.e(VideoCapture.TAG, str + " buffer stall, something is broken!");
                reset();
            }
        }

        void onDropTextureBuffer(long j10) {
            if (this.rawBufferQueue.poll() == null) {
                this.pendingRemoveRawBufferCount++;
            }
        }

        void onRawBufferAvailable(byte[] bArr, int i10) {
            checkAndResetIfNeeded();
            int i11 = this.pendingRemoveRawBufferCount;
            if (i11 > 0) {
                this.pendingRemoveRawBufferCount = i11 - 1;
                return;
            }
            TexBuffer poll = this.texBufferQueue.poll();
            if (poll != null) {
                VideoCapture.this.onTextureAndRawBufferAvailable(poll.textureBuffer, poll.rotation, poll.timestampNs, bArr, i10);
                poll.textureBuffer.release();
            } else {
                this.rawBufferQueue.offer(new RawBuffer(Arrays.copyOf(bArr, i10), i10));
            }
        }

        void onTextureBufferAvailable(VideoFrame.TextureBuffer textureBuffer, int i10, long j10) {
            checkAndResetIfNeeded();
            RawBuffer poll = this.rawBufferQueue.poll();
            if (poll != null) {
                VideoCapture.this.onTextureAndRawBufferAvailable(textureBuffer, i10, j10, poll.data, poll.length);
            } else {
                textureBuffer.retain();
                this.texBufferQueue.offer(new TexBuffer(textureBuffer, i10, j10));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void reset() {
            Logging.i(VideoCapture.TAG, "TextureAndRawBufferSynchronizer reset");
            this.rawBufferQueue.clear();
            Iterator<TexBuffer> it = this.texBufferQueue.iterator();
            while (it.hasNext()) {
                it.next().textureBuffer.release();
            }
            this.texBufferQueue.clear();
            this.pendingRemoveRawBufferCount = 0;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    @interface VideoCaptureDropFrameReason {
        public static final int kCameraDropFrameReasonTextureCopy = 1;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    @interface VideoCaptureEvent {
        public static final int kCameraErrorCameraDevice = 4;
        public static final int kCameraErrorCameraDisabled = 3;
        public static final int kCameraErrorCameraInUse = 1;
        public static final int kCameraErrorCameraService = 5;
        public static final int kCameraErrorConfigureInitiation = 100;
        public static final int kCameraErrorConfigureRequest = 102;
        public static final int kCameraErrorConfigureSession = 101;
        public static final int kCameraErrorDeviceNotFound = 7;
        public static final int kCameraErrorDisconnected = 6;
        public static final int kCameraErrorMaxCamerasInUse = 2;
        public static final int kCameraErrorNoPermission = 8;
        public static final int kCameraErrorRuntimeUnknown = 901;
        public static final int kVideoCaptureEventNone = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoCapture(Context context, int i10, int i11, EglBase.Context context2, long j10) {
        this.mNativeVideoCaptureDeviceAndroid = j10;
        this.mContext = context;
        this.mId = i10;
        this.mPQFirst = i11;
        this.mShareContext = context2;
    }

    public static native int ConvertFrameToI420(int i10, int i11, ByteBuffer byteBuffer, int i12, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i13, int i14, byte[] bArr);

    private native void ProvideCameraTexture(VideoFrame.TextureBuffer textureBuffer, int i10, long j10, long j11);

    private native void ProvideCameraTextureAndRaw(VideoFrame.TextureBuffer textureBuffer, int i10, long j10, byte[] bArr, int i11, long j11);

    public static void cacheCapability(int i10, Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("CamCaps2", 0).edit();
        edit.putString("Cam_" + i10, str);
        edit.putString("CaptureName", str2);
        edit.commit();
    }

    public static boolean checkVideoPermission(Context context) {
        if (context != null && context.checkCallingOrSelfPermission("android.permission.CAMERA") == 0) {
            return true;
        }
        return false;
    }

    public static void clearCapabilityCache(Context context) {
        context.getSharedPreferences("CamCaps2", 0).edit().clear().commit();
    }

    public static String fetchCapability(int i10, Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("CamCaps2", 0);
        String string = sharedPreferences.getString("CaptureName", null);
        if (string != null && string.equals(str)) {
            return sharedPreferences.getString("Cam_" + i10, null);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.commit();
        return null;
    }

    public static boolean isEmulator() {
        String str;
        String str2 = Build.MANUFACTURER;
        if ("nokia".equalsIgnoreCase(str2) && ("Nokia_N1".equalsIgnoreCase(Build.DEVICE) || "N1".equalsIgnoreCase(Build.MODEL))) {
            return false;
        }
        String str3 = Build.FINGERPRINT;
        if (str3 != null && (str3.startsWith("generic") || str3.toLowerCase().contains("vbox") || str3.toLowerCase().contains("test-keys"))) {
            return true;
        }
        String str4 = Build.MODEL;
        if (str4 != null && (str4.contains("google_sdk") || str4.contains("Emulator") || str4.contains("Android SDK built for x86") || str4.equalsIgnoreCase("MuMu"))) {
            return true;
        }
        if (str2 != null && str2.contains("Genymotion")) {
            return true;
        }
        String str5 = Build.BRAND;
        if ((str5 != null && str5.startsWith("generic") && (str = Build.DEVICE) != null && str.startsWith("generic")) || "google_sdk".equalsIgnoreCase(Build.PRODUCT)) {
            return true;
        }
        try {
            Process start = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            bufferedReader.close();
            String lowerCase = stringBuffer.toString().toLowerCase();
            if (!lowerCase.contains("intel") && !lowerCase.contains("amd")) {
                return false;
            }
            return true;
        } catch (IOException | Exception unused) {
            return false;
        }
    }

    public static int translateToAndroidFormat(int i10) {
        if (i10 == 0) {
            return 35;
        }
        if (i10 == 1) {
            return 842094169;
        }
        if (i10 != 2) {
            return i10 != 12 ? 0 : 17;
        }
        return 20;
    }

    @CaptureOutputDataType
    public static int translateToCaptureOutputDataType(int i10) {
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2) {
                return 0;
            }
        }
        return i11;
    }

    public static int translateToEngineFormat(int i10) {
        if (i10 == 17) {
            return 12;
        }
        if (i10 == 20) {
            return 2;
        }
        if (i10 != 35) {
            return i10 != 842094169 ? 99 : 1;
        }
        return 0;
    }

    public native void NotifyCameraExposureAreaChanged(float f10, float f11, float f12, float f13, long j10);

    public native void NotifyCameraFocusAreaChanged(float f10, float f11, float f12, float f13, long j10);

    public native void NotifyFaceDetection(int i10, int i11, RectF[] rectFArr, long j10, long j11);

    public native void ProvideCameraFrame(byte[] bArr, int i10, long j10);

    public abstract int UnRegisterNativeHandle();

    public abstract int allocate();

    /* JADX INFO: Access modifiers changed from: protected */
    public int checkOrientation() {
        Display defaultDisplay;
        Context context = this.mContext;
        if (context != null && context.getSystemService("window") != null && (defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay()) != null) {
            try {
                return defaultDisplay.getRotation();
            } catch (RuntimeException unused) {
                Logging.e(TAG, "video capture checkOrientation display getRotation throwout exception");
                return this.mLastRotation;
            }
        }
        return this.mLastRotation;
    }

    public abstract void deallocate();

    public abstract float getMaxZoom();

    public native boolean isAutoFaceFocusEnabled(long j10);

    public abstract boolean isAutoFaceFocusSupported();

    public abstract boolean isExposureSupported();

    public native boolean isFaceDetectionEnabled(long j10);

    public abstract boolean isFocusSupported();

    public abstract boolean isTorchSupported();

    public abstract boolean isZoomSupported();

    public native void onCameraError(long j10, @VideoCaptureEvent int i10);

    public native void onCameraFrameDropped(long j10, @VideoCaptureDropFrameReason int i10);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRawBufferAvailable(byte[] bArr, int i10, int i11, int i12, int i13) {
        AgoraVideoDebugger.onRawBufferAvailable(this, bArr, i10, i11, i12, i13);
        int i14 = this.mCaptureOutputDataType;
        if (i14 == 0) {
            ProvideCameraFrame(bArr, i10, this.mNativeVideoCaptureDeviceAndroid);
        } else if (i14 == 2) {
            this.mTextureAndRawBufferSynchronizer.onRawBufferAvailable(bArr, i10);
        }
    }

    protected void onTextureAndRawBufferAvailable(VideoFrame.TextureBuffer textureBuffer, int i10, long j10, byte[] bArr, int i11) {
        AgoraVideoDebugger.onTextureAndRawBufferAvailable(this, textureBuffer, i10, j10, bArr, i11);
        ProvideCameraTextureAndRaw(textureBuffer, i10, j10, bArr, i11, this.mNativeVideoCaptureDeviceAndroid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTextureBufferAvailable(VideoFrame.TextureBuffer textureBuffer, int i10, long j10) {
        SurfaceTextureHelper surfaceTextureHelper = this.mSurfaceTextureHelper;
        if (surfaceTextureHelper != null) {
            if (!FORCE_TEXTURE_OES) {
                textureBuffer = surfaceTextureHelper.textureCopy(textureBuffer);
            }
        } else {
            textureBuffer = null;
        }
        if (textureBuffer == null) {
            int i11 = this.mDroppedTextureBufferCount + 1;
            this.mDroppedTextureBufferCount = i11;
            if (i11 % 50 == 1) {
                Logging.w(TAG, "Dropped texture buffer count: " + this.mDroppedTextureBufferCount);
            }
            if (this.mCaptureOutputDataType == 2) {
                this.mTextureAndRawBufferSynchronizer.onDropTextureBuffer(j10);
            }
            AgoraVideoDebugger.onDropTextureBuffer(j10);
            onCameraFrameDropped(this.mNativeVideoCaptureDeviceAndroid, 1);
            return;
        }
        ATrace.beginSection("onTextureBufferAvailable");
        AgoraVideoDebugger.onTextureBufferAvailable(this, this.mEglContext, textureBuffer, i10, j10);
        int i12 = this.mCaptureOutputDataType;
        if (i12 == 1) {
            ProvideCameraTexture(textureBuffer, i10, j10, this.mNativeVideoCaptureDeviceAndroid);
        } else if (i12 == 2) {
            this.mTextureAndRawBufferSynchronizer.onTextureBufferAvailable(textureBuffer, i10, j10);
        }
        ATrace.endSection();
        textureBuffer.release();
    }

    public abstract int setAntiBandingMode(int i10);

    public abstract int setAutoFaceFocus(boolean z10);

    public abstract int setCaptureFormat(int i10, int i11, boolean z10);

    public abstract int setEdgeEnhanceMode(int i10);

    public abstract int setExposure(float f10, float f11, boolean z10);

    public abstract int setExposureCompensation(int i10);

    public abstract int setFaceDetection(boolean z10);

    public abstract int setFocus(float f10, float f11, boolean z10);

    public abstract int setNoiseReductionMode(int i10);

    public abstract int setTorchMode(boolean z10);

    public abstract int setVideoStabilityMode(int i10);

    public abstract int setZoom(float f10);

    public abstract int startCapture(int i10, int i11, int i12);

    public abstract int stopCapture();
}
