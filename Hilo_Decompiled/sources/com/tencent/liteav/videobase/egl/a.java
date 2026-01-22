package com.tencent.liteav.videobase.egl;

import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class a implements e<EGLContext> {
    private static final int[] i = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};
    private static final int[] j = {12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};
    private final int b;
    private final int c;
    private EGL10 g;
    private EGLConfig h;
    private EGLDisplay d = EGL10.EGL_NO_DISPLAY;
    private EGLContext e = EGL10.EGL_NO_CONTEXT;
    private EGLSurface f = EGL10.EGL_NO_SURFACE;
    private final String a = "EGL10Helper@" + hashCode();

    private a(int i2, int i3) {
        this.b = i2;
        this.c = i3;
    }

    public static a a(EGLContext eGLContext, Surface surface, int i2, int i3) throws d {
        a aVar = new a(i2, i3);
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            aVar.g = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            aVar.d = eglGetDisplay;
            int i4 = 2;
            aVar.g.eglInitialize(eglGetDisplay, new int[2]);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            aVar.g.eglChooseConfig(aVar.d, surface == null ? i : j, eGLConfigArr, 1, new int[1]);
            aVar.h = eGLConfigArr[0];
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
                try {
                    aVar.e = aVar.a(aVar.d, aVar.h, 2, eGLContext);
                } catch (d unused) {
                    LiteavLog.i(aVar.a, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
                    i4 = 3;
                    aVar.e = aVar.a(aVar.d, aVar.h, 3, eGLContext);
                }
            } else {
                aVar.e = aVar.a(aVar.d, aVar.h, 2, eGLContext);
            }
            LiteavLog.i(aVar.a, "create eglContext " + aVar.e + " sharedContext: " + eGLContext + " version:" + i4);
            if (surface == null) {
                aVar.f = aVar.g.eglCreatePbufferSurface(aVar.d, aVar.h, new int[]{12375, aVar.b, 12374, aVar.c, 12344});
            } else {
                try {
                    aVar.f = aVar.g.eglCreateWindowSurface(aVar.d, aVar.h, surface, null);
                } catch (Throwable th) {
                    throw new d(aVar.g.eglGetError(), "", th);
                }
            }
            if (aVar.f == EGL10.EGL_NO_SURFACE) {
                aVar.h();
            }
            EGL10 egl102 = aVar.g;
            EGLDisplay eGLDisplay = aVar.d;
            EGLSurface eGLSurface = aVar.f;
            if (!egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, aVar.e)) {
                aVar.h();
            }
            return aVar;
        } catch (d e) {
            aVar.c();
            throw e;
        }
    }

    private void g() throws d {
        EGLSurface eGLSurface = this.f;
        EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
        if (eGLSurface != eGLSurface2) {
            d();
            if (!this.g.eglDestroySurface(this.d, this.f)) {
                h();
            }
            this.f = eGLSurface2;
        }
    }

    private void h() throws d {
        int eglGetError = this.g.eglGetError();
        if (eglGetError == 12288) {
        } else {
            throw new d(eglGetError);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void b() throws d {
        EGL10 egl10 = this.g;
        EGLDisplay eGLDisplay = this.d;
        EGLSurface eGLSurface = this.f;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.e)) {
            h();
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void c() throws d {
        EGLDisplay eGLDisplay = this.d;
        EGLDisplay eGLDisplay2 = EGL10.EGL_NO_DISPLAY;
        if (eGLDisplay != eGLDisplay2) {
            d();
            g();
            EGLContext eGLContext = this.e;
            EGLContext eGLContext2 = EGL10.EGL_NO_CONTEXT;
            if (eGLContext != eGLContext2) {
                LiteavLog.i(this.a, "destroy eglContext " + this.e);
                this.g.eglDestroyContext(this.d, this.e);
                this.e = eGLContext2;
            }
            this.g.eglTerminate(this.d);
        }
        this.d = eGLDisplay2;
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void d() {
        EGLDisplay eGLDisplay = this.d;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.g;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final Size e() {
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        boolean eglQuerySurface = this.g.eglQuerySurface(this.d, this.f, 12375, iArr);
        boolean eglQuerySurface2 = this.g.eglQuerySurface(this.d, this.f, 12374, iArr2);
        if (eglQuerySurface && eglQuerySurface2) {
            return new Size(iArr[0], iArr2[0]);
        }
        return new Size(0, 0);
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final /* bridge */ /* synthetic */ EGLContext f() {
        return this.e;
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void a() throws d {
        GLES20.glFinish();
        if (this.g.eglSwapBuffers(this.d, this.f)) {
            return;
        }
        h();
    }

    private EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, EGLContext eGLContext) throws d {
        int[] iArr = {12440, i2, 12344};
        if (eGLContext == null) {
            eGLContext = EGL10.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = this.g.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        h();
        return eglCreateContext;
    }
}
