package com.tencent.liteav.videobase.egl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class b implements e<EGLContext> {
    private static final int[] h = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};
    private static final int[] i = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};
    private final int d;
    private final int e;
    private EGLConfig f = null;
    EGLDisplay a = EGL14.EGL_NO_DISPLAY;
    private EGLContext g = EGL14.EGL_NO_CONTEXT;
    EGLSurface b = EGL14.EGL_NO_SURFACE;
    private final String c = "EGL14Helper@" + hashCode();

    private b(int i2, int i3) {
        this.d = i2;
        this.e = i3;
    }

    public static b a(EGLContext eGLContext, Surface surface, int i2, int i3) throws d {
        b bVar = new b(i2, i3);
        try {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            bVar.a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int i4 = 2;
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    if (EGL14.eglChooseConfig(bVar.a, surface == null ? i : h, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                        bVar.f = eGLConfigArr[0];
                        if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
                            try {
                                bVar.g = a(bVar.a, bVar.f, 2, eGLContext);
                            } catch (d unused) {
                                LiteavLog.i(bVar.c, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
                                bVar.g = a(bVar.a, bVar.f, 3, eGLContext);
                                i4 = 3;
                            }
                        } else {
                            bVar.g = a(bVar.a, bVar.f, 2, eGLContext);
                        }
                        LiteavLog.i(bVar.c, "create eglContext " + bVar.g + " sharedContext: " + eGLContext + " version:" + i4);
                        if (surface == null) {
                            bVar.b = EGL14.eglCreatePbufferSurface(bVar.a, bVar.f, new int[]{12375, bVar.d, 12374, bVar.e, 12344}, 0);
                        } else {
                            try {
                                bVar.b = EGL14.eglCreateWindowSurface(bVar.a, bVar.f, surface, new int[]{12344}, 0);
                            } catch (Throwable th) {
                                throw new d(EGL14.eglGetError(), "", th);
                            }
                        }
                        g();
                        EGLDisplay eGLDisplay = bVar.a;
                        EGLSurface eGLSurface = bVar.b;
                        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, bVar.g)) {
                            g();
                        }
                        return bVar;
                    }
                    throw new d(0);
                }
                bVar.a = null;
                LiteavLog.e(bVar.c, "unable to initialize EGL14");
                throw new d(0);
            }
            LiteavLog.e(bVar.c, "unable to get EGL14 display");
            throw new d(0);
        } catch (d e) {
            bVar.c();
            throw e;
        }
    }

    private static void g() throws d {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
        } else {
            throw new d(eglGetError);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void b() throws d {
        EGLDisplay eGLDisplay = this.a;
        EGLSurface eGLSurface = this.b;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.g)) {
            g();
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void c() {
        EGLDisplay eGLDisplay = this.a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGLSurface eGLSurface2 = this.b;
            if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.a, eGLSurface2);
                this.b = EGL14.EGL_NO_SURFACE;
            }
            if (this.g != EGL14.EGL_NO_CONTEXT) {
                LiteavLog.i(this.c, "destroy eglContext " + this.g);
                EGL14.eglDestroyContext(this.a, this.g);
                this.g = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.a);
        }
        this.a = EGL14.EGL_NO_DISPLAY;
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void d() {
        EGLDisplay eGLDisplay = this.a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final Size e() {
        int[] iArr = new int[2];
        boolean eglQuerySurface = EGL14.eglQuerySurface(this.a, this.b, 12375, iArr, 0);
        boolean eglQuerySurface2 = EGL14.eglQuerySurface(this.a, this.b, 12374, iArr, 1);
        if (eglQuerySurface && eglQuerySurface2) {
            return new Size(iArr[0], iArr[1]);
        }
        return new Size(0, 0);
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final /* bridge */ /* synthetic */ EGLContext f() {
        return this.g;
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void a() throws d {
        GLES20.glFinish();
        if (EGL14.eglSwapBuffers(this.a, this.b)) {
            return;
        }
        g();
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, EGLContext eGLContext) throws d {
        int[] iArr = {12440, i2, 12344};
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr, 0);
        g();
        return eglCreateContext;
    }
}
