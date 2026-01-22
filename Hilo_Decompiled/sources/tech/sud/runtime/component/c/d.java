package tech.sud.runtime.component.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.view.TextureView;
import android.view.View;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import tech.sud.runtime.core.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class d extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
    private static final String a = "d";
    private static final g c = new g();
    private tech.sud.runtime.component.d.a b;
    private final WeakReference<d> d;
    private f e;
    private GLSurfaceView.Renderer f;
    private d.a g;
    private boolean h;
    private GLSurfaceView.EGLConfigChooser i;
    private GLSurfaceView.EGLContextFactory j;
    private GLSurfaceView.EGLWindowSurfaceFactory k;
    private GLSurfaceView.GLWrapper l;
    private int m;
    private int n;
    private boolean o;
    private final List<TextureView.SurfaceTextureListener> p;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public abstract class a implements GLSurfaceView.EGLConfigChooser {
        protected int[] a;

        public a(int[] iArr) {
            this.a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (d.this.n != 2 && d.this.n != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (d.this.n == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
                        EGLConfig a = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a != null) {
                            return a;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public class c implements GLSurfaceView.EGLContextFactory {
        private int b;

        private c() {
            this.b = 12440;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.b, d.this.n, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (d.this.n == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                tech.sud.runtime.component.h.f.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                StringBuilder sb2 = new StringBuilder("tid=");
                sb2.append(Thread.currentThread().getId());
                tech.sud.runtime.component.h.f.c("DefaultContextFactory", sb2.toString());
                e.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* renamed from: tech.sud.runtime.component.c.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class C٠٠٥٧d implements GLSurfaceView.EGLWindowSurfaceFactory {
        private C٠٠٥٧d() {
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                tech.sud.runtime.component.h.f.b(d.a, "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class f extends Thread {
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean r;
        private e v;
        private WeakReference<d> w;
        private final String a = "GLThread";
        private ArrayList<Runnable> s = new ArrayList<>();
        private boolean t = true;
        private Runnable u = null;
        private int m = 0;
        private int n = 0;
        private boolean p = true;
        private int o = 1;
        private boolean q = false;

        public f(WeakReference<d> weakReference) {
            this.w = weakReference;
        }

        private void d() {
            if (this.j) {
                this.j = false;
                this.v.e();
            }
        }

        private void e() {
            if (this.i) {
                this.v.f();
                this.i = false;
                d.c.b(this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:101:0x0470, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x0467, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0472, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x0242, code lost:
        
            if (r14 == null) goto L٢٣٥;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x0250, code lost:
        
            if (r5 == false) goto L٢٣٧;
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x0252, code lost:
        
            tech.sud.runtime.component.h.f.d("GLThread", "egl createSurface");
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x025f, code lost:
        
            if (r1.v.b() == false) goto L٢٣٩;
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x0261, code lost:
        
            r3 = tech.sud.runtime.component.c.d.c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x0265, code lost:
        
            monitor-enter(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x0267, code lost:
        
            r1.k = true;
            tech.sud.runtime.component.c.d.c.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x0270, code lost:
        
            monitor-exit(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x0271, code lost:
        
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x0290, code lost:
        
            if (r6 == false) goto L١٢٣;
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x0292, code lost:
        
            r3 = (javax.microedition.khronos.opengles.GL10) r1.v.c();
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x029f, code lost:
        
            if (r4 == false) goto L١٢٩;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x02a1, code lost:
        
            tech.sud.runtime.component.h.f.d("GLThread", "onSurfaceCreated");
            r0 = r1.w.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x02b0, code lost:
        
            if (r0 == null) goto L١٢٨;
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x02b2, code lost:
        
            r0.f.onSurfaceCreated(r3, r1.v.d);
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x02bd, code lost:
        
            r4 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x02be, code lost:
        
            if (r8 == false) goto L٢١٥;
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x02c0, code lost:
        
            tech.sud.runtime.component.h.f.d("GLThread", "onSurfaceChanged(" + r12 + ", " + r13 + ")");
            r0 = r1.w.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x02eb, code lost:
        
            if (r0 == null) goto L١٣٣;
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x02ed, code lost:
        
            r0.f.onSurfaceChanged(r3, r12, r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x02f4, code lost:
        
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x02f5, code lost:
        
            r0 = r1.w.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x02fd, code lost:
        
            if (r0 == null) goto L١٤٣;
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x02ff, code lost:
        
            r0.f.onDrawFrame(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x030a, code lost:
        
            if (r0.g == null) goto L١٣٩;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x030c, code lost:
        
            r0 = r0.g.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x0314, code lost:
        
            if (r15 == null) goto L١٤٤;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x0316, code lost:
        
            r15.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x0319, code lost:
        
            r15 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x031c, code lost:
        
            if (r0 == false) goto L١٦٤;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x031e, code lost:
        
            r0 = r1.v.d();
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x0326, code lost:
        
            if (r0 == 12288) goto L١٦٤;
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x032a, code lost:
        
            if (r0 == 12302) goto L١٥٩;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x032c, code lost:
        
            r16 = r3;
            tech.sud.runtime.component.c.d.e.a("GLThread", "eglSwapBuffers", r0);
            r2 = tech.sud.runtime.component.c.d.c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x0339, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x033b, code lost:
        
            r1.g = true;
            tech.sud.runtime.component.c.d.c.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x0344, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x0370, code lost:
        
            if (r9 == false) goto L١٦٨;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x0372, code lost:
        
            r9 = false;
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:167:0x0374, code lost:
        
            r1 = r21;
            r3 = r16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:174:0x0349, code lost:
        
            r16 = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:175:0x034c, code lost:
        
            tech.sud.runtime.component.h.f.c("GLThread", "egl context lost tid=" + getId());
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x0366, code lost:
        
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x036d, code lost:
        
            r16 = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:178:0x0313, code lost:
        
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:179:0x031b, code lost:
        
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:181:0x0368, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:182:0x0369, code lost:
        
            r2 = r21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:183:0x029d, code lost:
        
            r3 = r19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:189:0x0276, code lost:
        
            r3 = tech.sud.runtime.component.c.d.c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:190:0x027a, code lost:
        
            monitor-enter(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:193:0x027c, code lost:
        
            r1.k = true;
            r1.g = true;
            tech.sud.runtime.component.c.d.c.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:194:0x0287, code lost:
        
            monitor-exit(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:195:0x0288, code lost:
        
            r3 = r19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:203:0x0244, code lost:
        
            r14.run();
            r14 = r2;
            r3 = r19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0423, code lost:
        
            r1 = tech.sud.runtime.component.c.d.c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0427, code lost:
        
            monitor-enter(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0428, code lost:
        
            r0 = r2.w.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0430, code lost:
        
            if (r0 == null) goto L١٨٧;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0432, code lost:
        
            r0.b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0438, code lost:
        
            d();
            e();
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x043e, code lost:
        
            monitor-exit(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x043f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0436, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0441, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0459, code lost:
        
            r3 = r2.w.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0461, code lost:
        
            if (r3 != null) goto L٢٠٢;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0463, code lost:
        
            r3.b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0469, code lost:
        
            d();
            e();
         */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0459 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void f() {
            f fVar;
            GL10 gl10;
            Runnable runnable;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            d dVar;
            f fVar2 = this;
            fVar2.v = new e(fVar2.w);
            fVar2.i = false;
            fVar2.j = false;
            fVar2.q = false;
            GL10 gl102 = null;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            int i = 0;
            int i2 = 0;
            Runnable runnable2 = null;
            Runnable runnable3 = null;
            while (true) {
                try {
                    synchronized (d.c) {
                        while (!fVar2.b) {
                            try {
                                if (!fVar2.s.isEmpty()) {
                                    runnable2 = fVar2.s.remove(0);
                                    gl10 = gl102;
                                    runnable = null;
                                } else {
                                    boolean z13 = fVar2.e;
                                    boolean z14 = fVar2.d;
                                    if (z13 != z14) {
                                        fVar2.e = z14;
                                        d.c.notifyAll();
                                        z2 = z14;
                                        StringBuilder sb2 = new StringBuilder();
                                        gl10 = gl102;
                                        sb2.append("mPaused is now ");
                                        sb2.append(fVar2.e);
                                        sb2.append(" tid=");
                                        z = z5;
                                        sb2.append(getId());
                                        tech.sud.runtime.component.h.f.c("GLThread", sb2.toString());
                                    } else {
                                        gl10 = gl102;
                                        z = z5;
                                        z2 = false;
                                    }
                                    if (fVar2.l) {
                                        tech.sud.runtime.component.h.f.c("GLThread", "releasing EGL context because asked to tid=" + getId());
                                        d();
                                        e();
                                        fVar2.l = false;
                                        z12 = true;
                                    }
                                    if (z8) {
                                        d();
                                        e();
                                        z8 = false;
                                    }
                                    if (z2 && fVar2.j) {
                                        tech.sud.runtime.component.h.f.c("GLThread", "releasing EGL surface because paused tid=" + getId());
                                        d();
                                    }
                                    if (z2 && fVar2.i && ((dVar = fVar2.w.get()) == null || !dVar.o)) {
                                        e();
                                        tech.sud.runtime.component.h.f.c("GLThread", "releasing EGL context because paused tid=" + getId());
                                    }
                                    if (!fVar2.f && !fVar2.h) {
                                        tech.sud.runtime.component.h.f.c("GLThread", "noticed textureView surface lost tid=" + getId());
                                        if (fVar2.j) {
                                            d();
                                        }
                                        fVar2.h = true;
                                        fVar2.g = false;
                                        d.c.notifyAll();
                                    }
                                    if (fVar2.f && fVar2.h) {
                                        tech.sud.runtime.component.h.f.c("GLThread", "noticed textureView surface acquired tid=" + getId());
                                        fVar2.h = false;
                                        d.c.notifyAll();
                                    }
                                    if (z11) {
                                        tech.sud.runtime.component.h.f.c("GLThread", "sending render notification tid=" + getId());
                                        fVar2.q = false;
                                        fVar2.r = true;
                                        d.c.notifyAll();
                                        z11 = false;
                                    }
                                    Runnable runnable4 = fVar2.u;
                                    if (runnable4 != null) {
                                        runnable = null;
                                        fVar2.u = null;
                                        runnable3 = runnable4;
                                    } else {
                                        runnable = null;
                                    }
                                    if (g()) {
                                        if (fVar2.i) {
                                            z5 = z;
                                        } else if (z12) {
                                            z5 = z;
                                            z12 = false;
                                        } else {
                                            try {
                                                fVar2.v.a();
                                                fVar2.i = true;
                                                d.c.notifyAll();
                                                z5 = true;
                                            } catch (RuntimeException e) {
                                                d.c.b(fVar2);
                                                throw e;
                                            }
                                        }
                                        if (fVar2.i && !fVar2.j) {
                                            fVar2.j = true;
                                            z6 = true;
                                            z7 = true;
                                            z9 = true;
                                        }
                                        if (fVar2.j) {
                                            if (fVar2.t) {
                                                i = fVar2.m;
                                                i2 = fVar2.n;
                                                fVar2.q = true;
                                                StringBuilder sb3 = new StringBuilder();
                                                sb3.append("noticing that we want render notification tid=");
                                                z3 = z5;
                                                sb3.append(getId());
                                                tech.sud.runtime.component.h.f.c("GLThread", sb3.toString());
                                                fVar2.t = false;
                                                z4 = false;
                                                z6 = true;
                                                z9 = true;
                                            } else {
                                                z3 = z5;
                                                z4 = false;
                                            }
                                            fVar2.p = z4;
                                            d.c.notifyAll();
                                            z5 = z3;
                                            if (fVar2.q) {
                                                z10 = true;
                                            }
                                        }
                                    } else if (runnable3 != null) {
                                        tech.sud.runtime.component.h.f.d("GLThread", "Warning, !readyToDraw() but waiting for draw finished! Early reporting draw finished.");
                                        runnable3.run();
                                        z5 = z;
                                        runnable3 = null;
                                    } else {
                                        z5 = z;
                                    }
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("waiting tid=");
                                    sb4.append(getId());
                                    sb4.append(" mHaveEglContext: ");
                                    fVar = this;
                                    try {
                                        sb4.append(fVar.i);
                                        sb4.append(" mHaveEglSurface: ");
                                        sb4.append(fVar.j);
                                        sb4.append(" mFinishedCreatingEglSurface: ");
                                        sb4.append(fVar.k);
                                        sb4.append(" mPaused: ");
                                        sb4.append(fVar.e);
                                        sb4.append(" mHasSurface: ");
                                        sb4.append(fVar.f);
                                        sb4.append(" mSurfaceIsBad: ");
                                        sb4.append(fVar.g);
                                        sb4.append(" mWaitingForSurface: ");
                                        sb4.append(fVar.h);
                                        sb4.append(" mWidth: ");
                                        sb4.append(fVar.m);
                                        sb4.append(" mHeight: ");
                                        sb4.append(fVar.n);
                                        sb4.append(" mRequestRender: ");
                                        sb4.append(fVar.p);
                                        sb4.append(" mRenderMode: ");
                                        sb4.append(fVar.o);
                                        tech.sud.runtime.component.h.f.c("GLThread", sb4.toString());
                                        if (!fVar.b) {
                                            d.c.wait();
                                            fVar2 = fVar;
                                            gl102 = gl10;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            synchronized (d.c) {
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fVar = fVar2;
                            }
                            try {
                            } catch (Throwable th4) {
                                th = th4;
                                fVar = this;
                                throw th;
                            }
                        }
                    }
                    synchronized (d.c) {
                        try {
                            d dVar2 = fVar2.w.get();
                            if (dVar2 != null) {
                                dVar2.b();
                            }
                            d();
                            e();
                        } finally {
                        }
                    }
                    return;
                } catch (Throwable th5) {
                    th = th5;
                    fVar = fVar2;
                    synchronized (d.c) {
                    }
                }
            }
        }

        private boolean g() {
            if (!this.e && this.f && !this.g && this.m > 0 && this.n > 0) {
                if (this.p || this.o == 1) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public int b() {
            int i;
            synchronized (d.c) {
                i = this.o;
            }
            return i;
        }

        public void c() {
            synchronized (d.c) {
                this.p = true;
                d.c.notifyAll();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            tech.sud.runtime.component.h.f.c("GLThread", "starting tid=" + getId());
            try {
                f();
            } catch (InterruptedException unused) {
            } finally {
                d.c.a(this);
            }
        }

        public boolean a() {
            return this.i && this.j && g();
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (d.c) {
                    this.o = i;
                    d.c.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void b(tech.sud.runtime.component.d.a aVar) {
            synchronized (d.c) {
                try {
                    tech.sud.runtime.component.h.f.c("GLThread", "surfaceDestroyed tid=" + getId());
                    boolean z = false;
                    this.f = false;
                    d.c.notifyAll();
                    while (!this.h && !this.c) {
                        if (z) {
                            try {
                                d.c.wait();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        } else {
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            long millis = timeUnit.toMillis(System.nanoTime());
                            d.c.wait(4000L);
                            if (timeUnit.toMillis(System.nanoTime()) - millis >= 4000) {
                                z = true;
                                tech.sud.runtime.component.h.f.c("GLThread", "surfaceDestroyed 触发了anr监控");
                                if (aVar != null) {
                                    aVar.a("onGameANRDetected", "");
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void d(tech.sud.runtime.component.d.a aVar) {
            synchronized (d.c) {
                try {
                    tech.sud.runtime.component.h.f.c("GLThread", "onResume tid=" + getId());
                    boolean z = false;
                    this.d = false;
                    this.p = true;
                    this.r = false;
                    d.c.notifyAll();
                    while (!this.c && this.e && !this.r) {
                        tech.sud.runtime.component.h.f.c("GLThread", "onResume waiting for !mPaused.");
                        if (z) {
                            try {
                                d.c.wait();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        } else {
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            long millis = timeUnit.toMillis(System.nanoTime());
                            d.c.wait(4000L);
                            if (timeUnit.toMillis(System.nanoTime()) - millis >= 4000) {
                                try {
                                    tech.sud.runtime.component.h.f.c("GLThread", "onResume 触发了anr监控");
                                    if (aVar != null) {
                                        aVar.a("onGameANRDetected", "");
                                    }
                                    z = true;
                                } catch (InterruptedException unused2) {
                                    z = true;
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void e(tech.sud.runtime.component.d.a aVar) {
            tech.sud.runtime.component.h.f.c("GLThread", "requestExitAndWait");
            synchronized (d.c) {
                try {
                    this.b = true;
                    d.c.notifyAll();
                    boolean z = false;
                    while (!this.c) {
                        if (z) {
                            try {
                                d.c.wait();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        } else {
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            long millis = timeUnit.toMillis(System.nanoTime());
                            d.c.wait(4000L);
                            if (timeUnit.toMillis(System.nanoTime()) - millis >= 4000) {
                                try {
                                    tech.sud.runtime.component.h.f.c("GLThread", "requestExitAndWait 触发了anr监控");
                                    if (aVar != null) {
                                        aVar.a("onGameANRDetected", "");
                                    }
                                    z = true;
                                } catch (InterruptedException unused2) {
                                    z = true;
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c(tech.sud.runtime.component.d.a aVar) {
            synchronized (d.c) {
                try {
                    tech.sud.runtime.component.h.f.c("GLThread", "onPause tid=" + getId());
                    this.d = true;
                    d.c.notifyAll();
                    boolean z = false;
                    while (!this.c && !this.e) {
                        tech.sud.runtime.component.h.f.c("GLThread", "onPause waiting for mPaused.");
                        if (z) {
                            try {
                                d.c.wait();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        } else {
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            long millis = timeUnit.toMillis(System.nanoTime());
                            d.c.wait(4000L);
                            if (timeUnit.toMillis(System.nanoTime()) - millis >= 4000) {
                                try {
                                    tech.sud.runtime.component.h.f.c("GLThread", "onPause 触发了anr监控");
                                    if (aVar != null) {
                                        aVar.a("onGameANRDetected", "");
                                    }
                                    z = true;
                                } catch (InterruptedException unused2) {
                                    z = true;
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void a(tech.sud.runtime.component.d.a aVar) {
            synchronized (d.c) {
                try {
                    tech.sud.runtime.component.h.f.c("GLThread", "surfaceCreated tid=" + getId());
                    this.f = true;
                    boolean z = false;
                    this.k = false;
                    d.c.notifyAll();
                    while (this.h && !this.k && !this.c) {
                        if (z) {
                            try {
                                d.c.wait();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        } else {
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            long millis = timeUnit.toMillis(System.nanoTime());
                            d.c.wait(4000L);
                            if (timeUnit.toMillis(System.nanoTime()) - millis >= 4000) {
                                try {
                                    tech.sud.runtime.component.h.f.c("GLThread", "surfaceCreated 触发了anr监控");
                                    if (aVar != null) {
                                        aVar.a("onGameANRDetected", "");
                                    }
                                    z = true;
                                } catch (InterruptedException unused2) {
                                    z = true;
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void a(tech.sud.runtime.component.d.a aVar, int i, int i2) {
            synchronized (d.c) {
                try {
                    this.m = i;
                    this.n = i2;
                    this.t = true;
                    this.p = true;
                    boolean z = false;
                    this.r = false;
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    d.c.notifyAll();
                    while (!this.c && !this.e && !this.r && a()) {
                        tech.sud.runtime.component.h.f.c("GLThread", "onWindowResize waiting for render complete from tid=" + getId());
                        if (z) {
                            try {
                                d.c.wait();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        } else {
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            long millis = timeUnit.toMillis(System.nanoTime());
                            d.c.wait(4000L);
                            if (timeUnit.toMillis(System.nanoTime()) - millis >= 4000) {
                                try {
                                    tech.sud.runtime.component.h.f.c("GLThread", "onWindowResize 触发了anr监控");
                                    if (aVar != null) {
                                        aVar.a("onGameANRDetected", "");
                                    }
                                    z = true;
                                } catch (InterruptedException unused2) {
                                    z = true;
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (d.c) {
                    this.s.add(runnable);
                    d.c.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class g {
        private static String a = "GLThreadManager";

        private g() {
        }

        public synchronized void a(f fVar) {
            tech.sud.runtime.component.h.f.c(a, "exiting tid=" + fVar.getId());
            fVar.c = true;
            notifyAll();
        }

        public void b(f fVar) {
            notifyAll();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class h extends Writer {
        private StringBuilder a = new StringBuilder();

        private void a() {
            if (this.a.length() > 0) {
                tech.sud.runtime.component.h.f.a("GLTextureView", this.a.toString());
                StringBuilder sb2 = this.a;
                sb2.delete(0, sb2.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    a();
                } else {
                    this.a.append(c);
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public class i extends b {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public i(boolean z) {
            super(8, 8, 8, 0, r6, 0);
            int i;
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
        }
    }

    public d(Context context) {
        super(context);
        this.d = new WeakReference<>(this);
        this.p = new ArrayList();
        e();
    }

    public void a_() {
        this.e.c();
    }

    public void b() {
    }

    public void finalize() {
        tech.sud.runtime.component.h.f.b(a, "finalize");
        try {
            f fVar = this.e;
            if (fVar != null) {
                fVar.e(this.b);
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.m;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.o;
    }

    public int getRenderMode() {
        return this.e.b();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        int i2;
        super.onAttachedToWindow();
        tech.sud.runtime.component.h.f.b(a, "onAttachedToWindow reattach =" + this.h);
        if (this.h && this.f != null) {
            tech.sud.runtime.component.d.a aVar = this.b;
            if (aVar != null) {
                aVar.a("GameViewOnAttachedToWindowReload", "");
                this.h = false;
                return;
            }
            f fVar = this.e;
            if (fVar != null) {
                i2 = fVar.b();
            } else {
                i2 = 1;
            }
            f fVar2 = new f(this.d);
            this.e = fVar2;
            if (i2 != 1) {
                fVar2.a(i2);
            }
            this.e.start();
        }
        this.h = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        tech.sud.runtime.component.h.f.b(a, "onDetachedFromWindow");
        f fVar = this.e;
        if (fVar != null) {
            fVar.e(this.b);
        }
        this.h = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        a(getSurfaceTexture(), 0, i4 - i2, i5 - i3);
    }

    public void onPause() {
        this.e.c(this.b);
    }

    public void onResume() {
        this.e.d(this.b);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        tech.sud.runtime.component.d.a aVar = this.b;
        if (aVar != null) {
            aVar.a("GameViewOnSurfaceCreated", "");
        }
        a(surfaceTexture);
        a(surfaceTexture, 0, i2, i3);
        Iterator<TextureView.SurfaceTextureListener> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceTextureAvailable(surfaceTexture, i2, i3);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        tech.sud.runtime.component.d.a aVar = this.b;
        if (aVar != null) {
            aVar.a("GameViewOnSurfaceDestroyed", "");
        }
        b(surfaceTexture);
        Iterator<TextureView.SurfaceTextureListener> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceTextureDestroyed(surfaceTexture);
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        a(surfaceTexture, 0, i2, i3);
        Iterator<TextureView.SurfaceTextureListener> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        a_();
        Iterator<TextureView.SurfaceTextureListener> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    public void queueEvent(Runnable runnable) {
        this.e.a(runnable);
    }

    public void setDebugFlags(int i2) {
        this.m = i2;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        f();
        this.i = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i2) {
        f();
        this.n = i2;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        f();
        this.j = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        f();
        this.k = eGLWindowSurfaceFactory;
    }

    public void setExternalInterface(tech.sud.runtime.component.d.a aVar) {
        this.b = aVar;
    }

    public void setGLWrapper(GLSurfaceView.GLWrapper gLWrapper) {
        this.l = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.o = z;
    }

    public void setRenderMode(int i2) {
        this.e.a(i2);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        f();
        if (this.i == null) {
            this.i = new i(true);
        }
        if (this.j == null) {
            this.j = new c();
        }
        if (this.k == null) {
            this.k = new C٠٠٥٧d();
        }
        this.f = renderer;
        if (renderer instanceof tech.sud.runtime.core.d) {
            this.g = ((tech.sud.runtime.core.d) renderer).f();
        }
        f fVar = new f(this.d);
        this.e = fVar;
        fVar.start();
    }

    private void e() {
        setSurfaceTextureListener(this);
    }

    private void f() {
        if (this.e != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.e.a(this.b);
    }

    public void a(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        this.e.a(this.b, i3, i4);
    }

    public void b(SurfaceTexture surfaceTexture) {
        this.e.b(this.b);
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new i(z));
    }

    public static String a(int i2) {
        switch (i2) {
            case 12288:
                return "EGL_SUCCESS";
            case 12289:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return b(i2);
        }
    }

    private static String b(int i2) {
        return "0x" + Integer.toHexString(i2);
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public class b extends a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.j = new int[1];
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
        }

        @Override // tech.sud.runtime.component.c.d.a
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.g && a2 >= this.h) {
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a3 == this.c && a4 == this.d && a5 == this.e && a6 == this.f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.j) ? this.j[0] : i2;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class e {
        EGL10 a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<d> f;

        public e(WeakReference<d> weakReference) {
            this.f = weakReference;
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.c;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                d dVar = this.f.get();
                if (dVar != null) {
                    dVar.k.destroySurface(this.a, this.b, this.c);
                }
                this.c = null;
            }
        }

        public void a() {
            tech.sud.runtime.component.h.f.d("EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.a = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.b = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.a.eglInitialize(eglGetDisplay, new int[2])) {
                    d dVar = this.f.get();
                    if (dVar != null) {
                        this.d = dVar.i.chooseConfig(this.a, this.b);
                        this.e = dVar.j.createContext(this.a, this.b, this.d);
                    } else {
                        this.d = null;
                        this.e = null;
                    }
                    EGLContext eGLContext = this.e;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.e = null;
                        a("createContext");
                    }
                    tech.sud.runtime.component.h.f.d("EglHelper", "createContext " + this.e + " tid=" + Thread.currentThread().getId());
                    this.c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean b() {
            tech.sud.runtime.component.h.f.d("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.a != null) {
                if (this.b != null) {
                    if (this.d != null) {
                        g();
                        d dVar = this.f.get();
                        if (dVar != null) {
                            this.c = dVar.k.createWindowSurface(this.a, this.b, this.d, dVar.getSurfaceTexture());
                        } else {
                            this.c = null;
                        }
                        EGLSurface eGLSurface = this.c;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.e)) {
                                return true;
                            }
                            a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
                            return false;
                        }
                        if (this.a.eglGetError() == 12299) {
                            tech.sud.runtime.component.h.f.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public GL c() {
            h hVar;
            GL gl = this.e.getGL();
            d dVar = this.f.get();
            if (dVar != null) {
                if (dVar.l != null) {
                    gl = dVar.l.wrap(gl);
                }
                if ((dVar.m & 3) != 0) {
                    int i = 1;
                    if ((dVar.m & 1) == 0) {
                        i = 0;
                    }
                    if ((dVar.m & 2) != 0) {
                        hVar = new h();
                    } else {
                        hVar = null;
                    }
                    return GLDebugHelper.wrap(gl, i, hVar);
                }
                return gl;
            }
            return gl;
        }

        public int d() {
            if (!this.a.eglSwapBuffers(this.b, this.c)) {
                return this.a.eglGetError();
            }
            return 12288;
        }

        public void e() {
            tech.sud.runtime.component.h.f.d("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            g();
        }

        public void f() {
            tech.sud.runtime.component.h.f.d("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.e != null) {
                d dVar = this.f.get();
                if (dVar != null) {
                    dVar.j.destroyContext(this.a, this.b, this.e);
                }
                this.e = null;
            }
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != null) {
                this.a.eglTerminate(eGLDisplay);
                this.b = null;
            }
        }

        public static String b(String str, int i) {
            return str + " failed: " + d.a(i);
        }

        private void a(String str) {
            a(str, this.a.eglGetError());
        }

        public static void a(String str, int i) {
            String b = b(str, i);
            tech.sud.runtime.component.h.f.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + b);
            throw new RuntimeException(b);
        }

        public static void a(String str, String str2, int i) {
            tech.sud.runtime.component.h.f.d(str, b(str2, i));
        }
    }
}
