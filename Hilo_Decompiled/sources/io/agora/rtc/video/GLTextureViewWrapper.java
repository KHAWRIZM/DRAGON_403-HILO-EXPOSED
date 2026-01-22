package io.agora.rtc.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.view.TextureView;
import android.view.View;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import io.agora.rtc.internal.Logging;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class GLTextureViewWrapper implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_GL_STATE = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLTextureViewWrapper";
    private static final GLThreadManager sGLThreadManager = new GLThreadManager();
    private int mDebugFlags;
    private boolean mDetached;
    private EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private EGLContextFactory mEGLContextFactory;
    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private Renderer mRenderer;
    private TextureView mTextureView;
    private final WeakReference<GLTextureViewWrapper> mThisWeakRef = new WeakReference<>(this);

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (GLTextureViewWrapper.this.mEGLContextClientVersion != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i10 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            iArr2[i10] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        @Override // io.agora.rtc.video.GLTextureViewWrapper.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, null, 0, iArr)) {
                int i10 = iArr[0];
                if (i10 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i10];
                    if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i10, iArr)) {
                        EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                        if (chooseConfig != null) {
                            return chooseConfig;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue;

        public ComponentSizeChooser(int i10, int i11, int i12, int i13, int i14, int i15) {
            super(new int[]{12324, i10, 12323, i11, 12322, i12, 12321, i13, 12325, i14, 12326, i15, 12344});
            this.mValue = new int[1];
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

        @Override // io.agora.rtc.video.GLTextureViewWrapper.BaseConfigChooser
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
            return null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // io.agora.rtc.video.GLTextureViewWrapper.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureViewWrapper.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureViewWrapper.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // io.agora.rtc.video.GLTextureViewWrapper.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Logging.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        @Override // io.agora.rtc.video.GLTextureViewWrapper.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e10) {
                Logging.e(GLTextureViewWrapper.TAG, "eglCreateWindowSurface", e10);
                return null;
            }
        }

        @Override // io.agora.rtc.video.GLTextureViewWrapper.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLTextureViewWrapper> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<GLTextureViewWrapper> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.mEglSurface;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GLTextureViewWrapper gLTextureViewWrapper = this.mGLSurfaceViewWeakRef.get();
                if (gLTextureViewWrapper != null) {
                    gLTextureViewWrapper.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
        }

        public static String formatEglError(String str, int i10) {
            return str + " failed: " + i10;
        }

        public static void logEglErrorAsWarning(String str, String str2, int i10) {
            Logging.w(str, formatEglError(str2, i10));
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        GL createGL() {
            LogWriter logWriter;
            GL gl = this.mEglContext.getGL();
            GLTextureViewWrapper gLTextureViewWrapper = this.mGLSurfaceViewWeakRef.get();
            if (gLTextureViewWrapper != null) {
                if (gLTextureViewWrapper.mGLWrapper != null) {
                    gl = gLTextureViewWrapper.mGLWrapper.wrap(gl);
                }
                if ((gLTextureViewWrapper.mDebugFlags & 3) != 0) {
                    int i10 = 1;
                    if ((gLTextureViewWrapper.mDebugFlags & 1) == 0) {
                        i10 = 0;
                    }
                    if ((gLTextureViewWrapper.mDebugFlags & 2) != 0) {
                        logWriter = new LogWriter();
                    } else {
                        logWriter = null;
                    }
                    return GLDebugHelper.wrap(gl, i10, logWriter);
                }
                return gl;
            }
            return gl;
        }

        public boolean createSurface() {
            if (this.mEgl != null) {
                if (this.mEglDisplay != null) {
                    if (this.mEglConfig != null) {
                        destroySurfaceImp();
                        GLTextureViewWrapper gLTextureViewWrapper = this.mGLSurfaceViewWeakRef.get();
                        if (gLTextureViewWrapper.getTextureView().getSurfaceTexture() == null) {
                            Logging.e("EglHelper", "createWindowSurface but  wrapper's textureview texture is null");
                            return false;
                        }
                        EGLSurface createWindowSurface = gLTextureViewWrapper.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gLTextureViewWrapper.getTextureView().getSurfaceTexture());
                        this.mEglSurface = createWindowSurface;
                        if (createWindowSurface != null && createWindowSurface != EGL10.EGL_NO_SURFACE) {
                            if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, createWindowSurface, createWindowSurface, this.mEglContext)) {
                                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                                return false;
                            }
                            return true;
                        }
                        if (this.mEgl.eglGetError() == 12299) {
                            Logging.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        public void finish() {
            if (this.mEglContext != null) {
                GLTextureViewWrapper gLTextureViewWrapper = this.mGLSurfaceViewWeakRef.get();
                if (gLTextureViewWrapper != null) {
                    gLTextureViewWrapper.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        public void start() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.mEgl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(eglGetDisplay, new int[2])) {
                    GLTextureViewWrapper gLTextureViewWrapper = this.mGLSurfaceViewWeakRef.get();
                    if (gLTextureViewWrapper == null) {
                        this.mEglConfig = null;
                        this.mEglContext = null;
                    } else {
                        this.mEglConfig = gLTextureViewWrapper.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                        this.mEglContext = gLTextureViewWrapper.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                    }
                    EGLContext eGLContext = this.mEglContext;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.mEglContext = null;
                        throwEglException("createContext");
                    }
                    this.mEglSurface = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int swap() {
            if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return this.mEgl.eglGetError();
            }
            return MessageConstant$CommandId.COMMAND_BASE;
        }

        public static void throwEglException(String str, int i10) {
            throw new RuntimeException(formatEglError(str, i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class GLThread extends Thread {
        private EglHelper mEglHelper;
        private boolean mExited;
        private WeakReference<GLTextureViewWrapper> mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean mSizeChanged = true;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;

        GLThread(WeakReference<GLTextureViewWrapper> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        private void guardedRun() throws InterruptedException {
            boolean z10;
            boolean z11;
            this.mEglHelper = new EglHelper(this.mGLSurfaceViewWeakRef);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            GL10 gl10 = null;
            boolean z15 = false;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            int i10 = 0;
            int i11 = 0;
            boolean z19 = false;
            while (true) {
                Runnable runnable = null;
                while (true) {
                    try {
                        synchronized (GLTextureViewWrapper.sGLThreadManager) {
                            while (!this.mShouldExit) {
                                if (!this.mEventQueue.isEmpty()) {
                                    runnable = this.mEventQueue.remove(0);
                                } else {
                                    boolean z20 = this.mPaused;
                                    boolean z21 = this.mRequestPaused;
                                    if (z20 != z21) {
                                        this.mPaused = z21;
                                        GLTextureViewWrapper.sGLThreadManager.notifyAll();
                                    } else {
                                        z21 = false;
                                    }
                                    if (this.mShouldReleaseEglContext) {
                                        stopEglSurfaceLocked();
                                        stopEglContextLocked();
                                        this.mShouldReleaseEglContext = false;
                                        z14 = true;
                                    }
                                    if (z12) {
                                        stopEglSurfaceLocked();
                                        stopEglContextLocked();
                                        z12 = false;
                                    }
                                    if (z21 && this.mHaveEglSurface) {
                                        stopEglSurfaceLocked();
                                    }
                                    if (z21 && this.mHaveEglContext) {
                                        GLTextureViewWrapper gLTextureViewWrapper = this.mGLSurfaceViewWeakRef.get();
                                        if (gLTextureViewWrapper != null) {
                                            z11 = gLTextureViewWrapper.mPreserveEGLContextOnPause;
                                        } else {
                                            z11 = false;
                                        }
                                        if (!z11 || GLTextureViewWrapper.sGLThreadManager.shouldReleaseEGLContextWhenPausing()) {
                                            stopEglContextLocked();
                                        }
                                    }
                                    if (z21 && GLTextureViewWrapper.sGLThreadManager.shouldTerminateEGLWhenPausing()) {
                                        this.mEglHelper.finish();
                                    }
                                    if (!this.mHasSurface && !this.mWaitingForSurface) {
                                        if (this.mHaveEglSurface) {
                                            stopEglSurfaceLocked();
                                        }
                                        this.mWaitingForSurface = true;
                                        this.mSurfaceIsBad = false;
                                        GLTextureViewWrapper.sGLThreadManager.notifyAll();
                                    }
                                    if (this.mHasSurface && this.mWaitingForSurface) {
                                        this.mWaitingForSurface = false;
                                        GLTextureViewWrapper.sGLThreadManager.notifyAll();
                                    }
                                    if (z13) {
                                        this.mRenderComplete = true;
                                        GLTextureViewWrapper.sGLThreadManager.notifyAll();
                                        z13 = false;
                                        z19 = false;
                                    }
                                    if (readyToDraw()) {
                                        if (!this.mHaveEglContext) {
                                            if (z14) {
                                                z14 = false;
                                            } else if (GLTextureViewWrapper.sGLThreadManager.tryAcquireEglContextLocked(this)) {
                                                try {
                                                    this.mEglHelper.start();
                                                    this.mHaveEglContext = true;
                                                    GLTextureViewWrapper.sGLThreadManager.notifyAll();
                                                    z15 = true;
                                                } catch (RuntimeException e10) {
                                                    GLTextureViewWrapper.sGLThreadManager.releaseEglContextLocked(this);
                                                    throw e10;
                                                }
                                            }
                                        }
                                        if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                            this.mHaveEglSurface = true;
                                            z16 = true;
                                            z17 = true;
                                            z18 = true;
                                        }
                                        if (this.mHaveEglSurface) {
                                            if (this.mSizeChanged) {
                                                i10 = this.mWidth;
                                                i11 = this.mHeight;
                                                z10 = false;
                                                this.mSizeChanged = false;
                                                z16 = true;
                                                z18 = true;
                                                z19 = true;
                                            } else {
                                                z10 = false;
                                            }
                                            this.mRequestRender = z10;
                                            GLTextureViewWrapper.sGLThreadManager.notifyAll();
                                        }
                                    }
                                    GLTextureViewWrapper.sGLThreadManager.wait();
                                }
                            }
                            synchronized (GLTextureViewWrapper.sGLThreadManager) {
                                stopEglSurfaceLocked();
                                stopEglContextLocked();
                            }
                            return;
                        }
                        if (runnable != null) {
                            break;
                        }
                        if (z16) {
                            if (!this.mEglHelper.createSurface()) {
                                synchronized (GLTextureViewWrapper.sGLThreadManager) {
                                    this.mSurfaceIsBad = true;
                                    GLTextureViewWrapper.sGLThreadManager.notifyAll();
                                }
                            } else {
                                z16 = false;
                            }
                        }
                        if (z17) {
                            GL10 gl102 = (GL10) this.mEglHelper.createGL();
                            GLTextureViewWrapper.sGLThreadManager.checkGLDriver(gl102);
                            gl10 = gl102;
                            z17 = false;
                        }
                        if (z15) {
                            GLTextureViewWrapper gLTextureViewWrapper2 = this.mGLSurfaceViewWeakRef.get();
                            if (gLTextureViewWrapper2 != null) {
                                gLTextureViewWrapper2.mRenderer.onSurfaceCreated(gl10, this.mEglHelper.mEglConfig);
                            }
                            z15 = false;
                        }
                        if (z18) {
                            GLTextureViewWrapper gLTextureViewWrapper3 = this.mGLSurfaceViewWeakRef.get();
                            if (gLTextureViewWrapper3 != null) {
                                gLTextureViewWrapper3.mRenderer.onSurfaceChanged(gl10, i10, i11);
                            }
                            z18 = false;
                        }
                        GLTextureViewWrapper gLTextureViewWrapper4 = this.mGLSurfaceViewWeakRef.get();
                        if (gLTextureViewWrapper4 != null) {
                            gLTextureViewWrapper4.mRenderer.onDrawFrame(gl10);
                        }
                        int swap = this.mEglHelper.swap();
                        if (swap != 12288) {
                            if (swap != 12302) {
                                EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", swap);
                                synchronized (GLTextureViewWrapper.sGLThreadManager) {
                                    this.mSurfaceIsBad = true;
                                    GLTextureViewWrapper.sGLThreadManager.notifyAll();
                                }
                            } else {
                                z12 = true;
                            }
                        }
                        if (z19) {
                            z13 = true;
                        }
                    } catch (Throwable th) {
                        synchronized (GLTextureViewWrapper.sGLThreadManager) {
                            stopEglSurfaceLocked();
                            stopEglContextLocked();
                            throw th;
                        }
                    }
                }
                runnable.run();
            }
        }

        private boolean readyToDraw() {
            if (!this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1)) {
                return true;
            }
            return false;
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLTextureViewWrapper.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        public boolean ableToDraw() {
            if (this.mHaveEglContext && this.mHaveEglSurface && readyToDraw()) {
                return true;
            }
            return false;
        }

        public int getRenderMode() {
            int i10;
            synchronized (GLTextureViewWrapper.sGLThreadManager) {
                i10 = this.mRenderMode;
            }
            return i10;
        }

        public void onPause() {
            synchronized (GLTextureViewWrapper.sGLThreadManager) {
                this.mRequestPaused = true;
                GLTextureViewWrapper.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    try {
                        GLTextureViewWrapper.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (GLTextureViewWrapper.sGLThreadManager) {
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                GLTextureViewWrapper.sGLThreadManager.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    try {
                        GLTextureViewWrapper.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i10, int i11) {
            synchronized (GLTextureViewWrapper.sGLThreadManager) {
                this.mWidth = i10;
                this.mHeight = i11;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                GLTextureViewWrapper.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                    try {
                        GLTextureViewWrapper.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void queueEvent(Runnable runnable) {
            if (runnable != null) {
                synchronized (GLTextureViewWrapper.sGLThreadManager) {
                    this.mEventQueue.add(runnable);
                    GLTextureViewWrapper.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public void requestExitAndWait() {
            synchronized (GLTextureViewWrapper.sGLThreadManager) {
                this.mShouldExit = true;
                GLTextureViewWrapper.sGLThreadManager.notifyAll();
                while (!this.mExited) {
                    try {
                        GLTextureViewWrapper.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GLTextureViewWrapper.sGLThreadManager.notifyAll();
        }

        public void requestRender() {
            synchronized (GLTextureViewWrapper.sGLThreadManager) {
                this.mRequestRender = true;
                GLTextureViewWrapper.sGLThreadManager.notifyAll();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLTextureViewWrapper.sGLThreadManager.threadExiting(this);
                throw th;
            }
            GLTextureViewWrapper.sGLThreadManager.threadExiting(this);
        }

        public void setRenderMode(int i10) {
            if (i10 >= 0 && i10 <= 1) {
                synchronized (GLTextureViewWrapper.sGLThreadManager) {
                    this.mRenderMode = i10;
                    GLTextureViewWrapper.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void surfaceCreated() {
            synchronized (GLTextureViewWrapper.sGLThreadManager) {
                this.mHasSurface = true;
                GLTextureViewWrapper.sGLThreadManager.notifyAll();
                while (this.mWaitingForSurface && !this.mExited) {
                    try {
                        GLTextureViewWrapper.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (GLTextureViewWrapper.sGLThreadManager) {
                this.mHasSurface = false;
                GLTextureViewWrapper.sGLThreadManager.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        GLTextureViewWrapper.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class GLThreadManager {
        private static String TAG = "GLThreadManager";
        private static final int kGLES_20 = 131072;
        private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        private GLThread mEglOwner;
        private boolean mGLESDriverCheckComplete;
        private int mGLESVersion;
        private boolean mGLESVersionCheckComplete;
        private boolean mLimitedGLESContexts;
        private boolean mMultipleGLESContextsAllowed;

        private GLThreadManager() {
        }

        private void checkGLESVersion() {
            if (!this.mGLESVersionCheckComplete) {
                this.mGLESVersionCheckComplete = true;
            }
        }

        public synchronized void checkGLDriver(GL10 gl10) {
            try {
                if (!this.mGLESDriverCheckComplete) {
                    checkGLESVersion();
                    String glGetString = gl10.glGetString(7937);
                    if (this.mGLESVersion < 131072) {
                        this.mMultipleGLESContextsAllowed = !glGetString.startsWith(kMSM7K_RENDERER_PREFIX);
                        notifyAll();
                    }
                    this.mLimitedGLESContexts = !this.mMultipleGLESContextsAllowed;
                    this.mGLESDriverCheckComplete = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public void releaseEglContextLocked(GLThread gLThread) {
            if (this.mEglOwner == gLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            return this.mLimitedGLESContexts;
        }

        public synchronized boolean shouldTerminateEGLWhenPausing() {
            checkGLESVersion();
            return !this.mMultipleGLESContextsAllowed;
        }

        public synchronized void threadExiting(GLThread gLThread) {
            try {
                gLThread.mExited = true;
                if (this.mEglOwner == gLThread) {
                    this.mEglOwner = null;
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }

        public boolean tryAcquireEglContextLocked(GLThread gLThread) {
            GLThread gLThread2 = this.mEglOwner;
            if (gLThread2 != gLThread && gLThread2 != null) {
                checkGLESVersion();
                if (this.mMultipleGLESContextsAllowed) {
                    return true;
                }
                GLThread gLThread3 = this.mEglOwner;
                if (gLThread3 != null) {
                    gLThread3.requestReleaseEglContextLocked();
                    return false;
                }
                return false;
            }
            this.mEglOwner = gLThread;
            notifyAll();
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface GLWrapper {
        GL wrap(GL gl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Logging.d("GLTextureView", this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBuilder();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            flushBuilder();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                char c10 = cArr[i10 + i12];
                if (c10 == '\n') {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c10);
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i10, int i11);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);

        void onSurfaceDestroyed(GL10 gl10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public SimpleEGLConfigChooser(boolean z10) {
            super(8, 8, 8, 0, r6, 0);
            int i10;
            if (z10) {
                i10 = 16;
            } else {
                i10 = 0;
            }
        }
    }

    public GLTextureViewWrapper(TextureView textureView) {
        this.mTextureView = textureView;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachedToWindow() {
        int i10;
        if (this.mDetached && this.mRenderer != null) {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                i10 = gLThread.getRenderMode();
            } else {
                i10 = 1;
            }
            GLThread gLThread2 = new GLThread(this.mThisWeakRef);
            this.mGLThread = gLThread2;
            if (i10 != 1) {
                gLThread2.setRenderMode(i10);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    private void checkRenderThreadState() {
        if (this.mGLThread == null) {
        } else {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detachedFromWindow() {
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.mDetached = true;
    }

    private void init() {
        this.mTextureView.setSurfaceTextureListener(this);
        this.mTextureView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: io.agora.rtc.video.GLTextureViewWrapper.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                GLTextureViewWrapper.this.attachedToWindow();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                GLTextureViewWrapper.this.detachedFromWindow();
            }
        });
    }

    protected void finalize() throws Throwable {
        try {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.mTextureView.getContext();
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public TextureView getTextureView() {
        return this.mTextureView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        surfaceChanged(this.mTextureView.getSurfaceTexture(), 0, i12 - i10, i13 - i11);
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i10, i11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        surfaceChanged(surfaceTexture, 0, i10, i11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.mGLThread.queueEvent(runnable);
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void setDebugFlags(int i10) {
        this.mDebugFlags = i10;
    }

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i10) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i10;
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z10) {
        this.mPreserveEGLContextOnPause = z10;
    }

    public void setRenderMode(int i10) {
        this.mGLThread.setRenderMode(i10);
    }

    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        GLThread gLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.start();
        if (this.mTextureView.isAttachedToWindow()) {
            surfaceCreated(this.mTextureView.getSurfaceTexture());
            surfaceChanged(this.mTextureView.getSurfaceTexture(), 0, this.mTextureView.getWidth(), this.mTextureView.getHeight());
        }
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i10, int i11, int i12) {
        this.mGLThread.onWindowResize(i11, i12);
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        this.mGLThread.surfaceDestroyed();
    }

    public void setEGLConfigChooser(boolean z10) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(z10));
    }

    public void setEGLConfigChooser(int i10, int i11, int i12, int i13, int i14, int i15) {
        setEGLConfigChooser(new ComponentSizeChooser(i10, i11, i12, i13, i14, i15));
    }
}
