package io.agora.rtc.video;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.ATrace;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.video.TextureRendererHelper;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class ViEAndroidGLES20 extends GLSurfaceView implements GLSurfaceView.Renderer, GLRendererController {
    private static final boolean DEBUG = false;
    private static String TAG = "ViEAndroidGLES20";
    private static final boolean VERBOSE = false;
    private int mLastRotation;
    private ReentrantLock nativeFunctionLock;
    private boolean nativeFunctionsRegisted;
    private int nativeGLPragram;
    private boolean nativeGLResourceUpdated;
    private int[] nativeGLTextureId;
    private long nativeObject;
    private int nativeOesGLPragram;
    private boolean openGLCreated;
    private boolean surfaceCreated;
    private TextureRendererHelper textureRendererHelper;
    private int viewHeight;
    private int viewWidth;

    public ViEAndroidGLES20(Context context) {
        this(context, false, 0, 0);
    }

    private native int CreateOpenGLNative(long j10, int i10, int i11);

    private native void DrawNative(long j10);

    private native void DrawNativeTexture(long j10, int i10, int i11, int i12, int i13, int i14, long j11, long j12, boolean z10);

    public static boolean IsSupported(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo == null || deviceConfigurationInfo.reqGlEsVersion < 131072) {
            return false;
        }
        return true;
    }

    private native void OnCfgChangedNative(long j10, int i10);

    public static boolean UseOpenGL2(Object obj) {
        return ViEAndroidGLES20.class.isInstance(obj);
    }

    private static void checkEglError(String str, EGL10 egl10) {
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError != 12288) {
                try {
                    Logging.e(TAG, String.format("%s: EGL error: 0x%x", str, Integer.valueOf(eglGetError)));
                } catch (Exception unused) {
                    Log.e("AGORA_SDK", "egl error!!, video may not displayed!!");
                }
            } else {
                return;
            }
        }
    }

    private int checkOrientation() {
        Display defaultDisplay;
        if (getContext() != null && getContext().getSystemService("window") != null && (defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay()) != null) {
            try {
                return defaultDisplay.getRotation();
            } catch (RuntimeException unused) {
                Logging.e(TAG, "checkOrientation display getRotation throwout exception");
                return this.mLastRotation;
            }
        }
        return this.mLastRotation;
    }

    private void doDrawFrame(boolean z10) {
        if (z10) {
            try {
                this.textureRendererHelper.onDrawFrame(this);
            } catch (Exception e10) {
                Logging.e(TAG, "onDrawFrame Exception: " + e10.toString());
            }
            if (this.textureRendererHelper.useJavaRender()) {
                return;
            }
        }
        updateOrientation();
        this.nativeFunctionLock.lock();
        if (this.nativeFunctionsRegisted && this.surfaceCreated) {
            if (!this.openGLCreated) {
                ATrace.beginSection("CreateOpenGLNative");
                if (CreateOpenGLNative(this.nativeObject, this.viewWidth, this.viewHeight) != 0) {
                    this.nativeFunctionLock.unlock();
                    return;
                } else {
                    this.openGLCreated = true;
                    ATrace.endSection();
                }
            }
            ATrace.beginSection("DrawNative");
            if (z10) {
                TextureRendererHelper.TextureFrame textureFrame = this.textureRendererHelper.getTextureFrame();
                if (textureFrame != null) {
                    DrawNativeTexture(this.nativeObject, textureFrame.textureType, textureFrame.texId, textureFrame.frameWidth, textureFrame.frameHeight, textureFrame.rotation, textureFrame.renderMs, textureFrame.firstRecvTimestamp, textureFrame.isDummy);
                }
            } else {
                DrawNative(this.nativeObject);
            }
            ATrace.endSection();
            this.nativeFunctionLock.unlock();
            return;
        }
        this.nativeFunctionLock.unlock();
    }

    private void init(boolean z10, int i10, int i11) {
        ConfigChooser configChooser;
        if (z10) {
            getHolder().setFormat(-3);
        }
        setEGLContextClientVersion(2);
        if (z10) {
            configChooser = new ConfigChooser(8, 8, 8, 8, i10, i11);
        } else {
            configChooser = new ConfigChooser(5, 6, 5, 0, i10, i11);
        }
        setEGLConfigChooser(configChooser);
        setRenderer(this);
        setRenderMode(0);
    }

    private void updateOrientation() {
        int checkOrientation = checkOrientation();
        if (checkOrientation != this.mLastRotation) {
            this.nativeFunctionLock.lock();
            if (this.nativeFunctionsRegisted) {
                OnCfgChangedNative(this.nativeObject, checkOrientation);
            }
            this.mLastRotation = checkOrientation;
            this.nativeFunctionLock.unlock();
        }
    }

    public void DeRegisterNativeObject() {
        this.nativeFunctionLock.lock();
        this.nativeFunctionsRegisted = false;
        this.openGLCreated = false;
        this.nativeObject = 0L;
        this.nativeFunctionLock.unlock();
        releaseOpenGLResource();
    }

    @Override // io.agora.rtc.video.GLRendererController
    public int GetAPILevel() {
        return Build.VERSION.SDK_INT;
    }

    @Override // io.agora.rtc.video.GLRendererController
    public void ReDraw() {
        if (this.surfaceCreated) {
            requestRender();
        }
    }

    public void RegisterNativeObject(long j10) {
        this.nativeFunctionLock.lock();
        this.nativeObject = j10;
        this.nativeFunctionsRegisted = true;
        this.nativeFunctionLock.unlock();
    }

    public void UpdateOpenGLResource(int[] iArr) {
        this.nativeGLPragram = iArr[0];
        int i10 = 0;
        while (i10 < 3) {
            int i11 = i10 + 1;
            this.nativeGLTextureId[i10] = iArr[i11];
            i10 = i11;
        }
        this.nativeOesGLPragram = iArr[4];
        this.nativeGLResourceUpdated = true;
        Logging.i(TAG, "UpdateOpenGLResource, program = " + iArr[0] + " texture[0~2] = " + iArr[1] + " ," + iArr[2] + " ," + iArr[3]);
    }

    public void deliverVideoTextureFrame(VideoFrame.TextureBuffer textureBuffer, int i10, long j10, long j11, boolean z10) {
        this.textureRendererHelper.setTextureSourceIncoming(true);
        synchronized (this) {
            this.textureRendererHelper.onTextureFrameArrived(textureBuffer, i10, j10, j11, z10);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateOrientation();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.textureRendererHelper.isTextureSourceIncoming()) {
            synchronized (this) {
                doDrawFrame(true);
            }
        } else {
            doDrawFrame(false);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.textureRendererHelper.isTextureSourceIncoming()) {
            this.textureRendererHelper.onFrameAvailable(this);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
        this.surfaceCreated = true;
        this.viewWidth = i10;
        this.viewHeight = i11;
        synchronized (this) {
            try {
                this.textureRendererHelper.onSurfaceChanged(this, i10, i11);
                if (this.textureRendererHelper.useJavaRender()) {
                    return;
                }
                Logging.i("AGORA_SDK", "Surface changed to width " + i10 + " height " + i11);
                this.nativeFunctionLock.lock();
                try {
                    try {
                        if (this.nativeFunctionsRegisted && CreateOpenGLNative(this.nativeObject, i10, i11) == 0) {
                            this.openGLCreated = true;
                        }
                    } catch (Exception unused) {
                        Log.w("AGORA_SDK", "Exception occurs when create RtcEngine");
                    }
                } finally {
                    this.nativeFunctionLock.unlock();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    public void reDrawJavaI420(VideoFrame.I420Buffer i420Buffer, int i10, long j10) {
        this.textureRendererHelper.setTextureSourceIncoming(false);
        AgoraVideoDebugger.onI420Buffer(i420Buffer, i10, j10);
        ReDraw();
    }

    public void reDrawNativeI420() {
        this.textureRendererHelper.setTextureSourceIncoming(false);
        ReDraw();
    }

    public void releaseOpenGLResource() {
        if (!this.nativeGLResourceUpdated) {
            return;
        }
        queueEvent(new Runnable() { // from class: io.agora.rtc.video.ViEAndroidGLES20.2
            @Override // java.lang.Runnable
            public void run() {
                Logging.i(ViEAndroidGLES20.TAG, "releaseOpenGLResource, value = " + ViEAndroidGLES20.this.nativeGLPragram + " ," + ViEAndroidGLES20.this.nativeGLTextureId[0] + " ," + ViEAndroidGLES20.this.nativeGLTextureId[1] + " ," + ViEAndroidGLES20.this.nativeGLTextureId[2] + ", " + ViEAndroidGLES20.this.nativeOesGLPragram);
                if (ViEAndroidGLES20.this.nativeGLPragram > 0) {
                    GLES20.glDeleteProgram(ViEAndroidGLES20.this.nativeGLPragram);
                }
                if (ViEAndroidGLES20.this.nativeGLTextureId[0] > 0) {
                    GLES20.glDeleteTextures(3, ViEAndroidGLES20.this.nativeGLTextureId, 0);
                }
                if (ViEAndroidGLES20.this.nativeOesGLPragram > 0) {
                    GLES20.glDeleteProgram(ViEAndroidGLES20.this.nativeOesGLPragram);
                }
                int glGetError = GLES20.glGetError();
                if (glGetError != 0) {
                    Logging.e(ViEAndroidGLES20.TAG, "glDelete error: " + glGetError);
                }
            }
        });
        this.nativeGLResourceUpdated = false;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        queueEvent(new Runnable() { // from class: io.agora.rtc.video.ViEAndroidGLES20.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ViEAndroidGLES20.this) {
                    ViEAndroidGLES20.this.surfaceCreated = false;
                    ViEAndroidGLES20.this.textureRendererHelper.releaseSurfaceTexture();
                }
            }
        });
        super.surfaceDestroyed(surfaceHolder);
    }

    public void textureRenderThreadWillExit() {
        synchronized (this) {
            Logging.i(TAG, "texture render thread will exit");
            this.textureRendererHelper.releaseProducerResourceIfNotYet();
        }
    }

    public ViEAndroidGLES20(Context context, boolean z10, int i10, int i11) {
        super(context);
        this.surfaceCreated = false;
        this.openGLCreated = false;
        this.nativeFunctionsRegisted = false;
        this.nativeFunctionLock = new ReentrantLock();
        this.nativeObject = 0L;
        this.viewWidth = 0;
        this.viewHeight = 0;
        this.nativeGLPragram = 0;
        this.nativeGLTextureId = new int[]{0, 0, 0};
        this.nativeOesGLPragram = 0;
        this.nativeGLResourceUpdated = false;
        this.mLastRotation = -1;
        this.textureRendererHelper = new TextureRendererHelper();
        init(z10, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class ConfigChooser implements GLSurfaceView.EGLConfigChooser {
        private static int EGL_OPENGL_ES2_BIT = 4;
        private static int[] s_configAttribs2 = {12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ConfigChooser(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.mRedSize = i10;
            this.mGreenSize = i11;
            this.mBlueSize = i12;
            this.mAlphaSize = i13;
            this.mDepthSize = i14;
            this.mStencilSize = i15;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i10, int i11) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i10, this.mValue)) {
                return this.mValue[0];
            }
            return i11;
        }

        private void printConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
            String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            for (int i10 = 0; i10 < 33; i10++) {
                int i11 = iArr[i10];
                String str = strArr[i10];
                if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i11, iArr2)) {
                    Logging.w(ViEAndroidGLES20.TAG, String.format("  %s: %d\n", str, Integer.valueOf(iArr2[0])));
                }
                do {
                } while (egl10.eglGetError() != 12288);
            }
        }

        private void printConfigs(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            Logging.w(ViEAndroidGLES20.TAG, String.format("%d configurations", Integer.valueOf(length)));
            for (int i10 = 0; i10 < length; i10++) {
                Logging.w(ViEAndroidGLES20.TAG, String.format("Configuration %d:\n", Integer.valueOf(i10)));
                printConfig(egl10, eGLDisplay, eGLConfigArr[i10]);
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, null, 0, iArr);
            int i10 = iArr[0];
            if (i10 <= 0) {
                Logging.w(ViEAndroidGLES20.TAG, "no configurations found");
                return null;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i10];
            egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, eGLConfigArr, i10, iArr);
            return chooseConfig(egl10, eGLDisplay, eGLConfigArr);
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            Logging.w(ViEAndroidGLES20.TAG, "The specified config was not found, use the first config. configs.length=" + eGLConfigArr.length);
            if (eGLConfigArr.length > 0) {
                return eGLConfigArr[0];
            }
            return null;
        }
    }
}
