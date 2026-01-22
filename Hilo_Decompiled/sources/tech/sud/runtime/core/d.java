package tech.sud.runtime.core;

import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class d implements GLSurfaceView.Renderer {
    private boolean b;
    private boolean f;
    private final float g;
    private final g h;
    private long k;
    private tech.sud.runtime.component.e.d l;
    private final c m;
    private final View n;
    private final Object a = new Object();
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private final AtomicBoolean i = new AtomicBoolean();
    private long j = 16666666;
    private a o = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class a {
        public boolean a;
    }

    public <GLViewC extends View & c> d(g gVar, GLViewC glviewc) {
        this.b = false;
        this.f = false;
        this.g = glviewc.getContext().getApplicationContext().getResources().getDisplayMetrics().density;
        this.h = gVar;
        GLViewC glviewc2 = glviewc;
        this.m = glviewc2;
        this.n = glviewc;
        glviewc2.setEGLContextClientVersion(2);
        glviewc.setFocusableInTouchMode(true);
        glviewc2.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
        glviewc2.setEGLContextFactory(new GLSurfaceView.EGLContextFactory() { // from class: tech.sud.runtime.core.d.1
            @Override // android.opengl.GLSurfaceView.EGLContextFactory
            public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            }

            @Override // android.opengl.GLSurfaceView.EGLContextFactory
            public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
                d.this.j();
                if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                    tech.sud.runtime.component.h.f.e("SudNative", "GLView.eglDestroyContext failed");
                }
            }
        });
        this.b = false;
        this.f = true;
        this.k = System.nanoTime();
        glviewc2.setRenderer(this);
        glviewc2.setRenderMode(1);
    }

    private boolean g() {
        if (this.e) {
            return true;
        }
        return this.h.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.c = true;
        if (!this.e) {
            this.h.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!this.e) {
            this.h.g();
        }
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!this.e) {
            this.e = true;
            this.h.h();
        }
    }

    public boolean d() {
        boolean z;
        synchronized (this.a) {
            z = this.d;
        }
        return z;
    }

    public void e() {
        j();
    }

    public a f() {
        return this.o;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (!this.e && !this.c) {
            synchronized (this.a) {
                if (!this.b && !this.f && !this.d) {
                    if (!this.i.get()) {
                        synchronized (this.a) {
                            if (!this.b && !this.f) {
                                boolean g = g();
                                long nanoTime = System.nanoTime() - this.k;
                                long j = this.j;
                                if (nanoTime < j) {
                                    long j2 = j - nanoTime;
                                    if (j2 > 1000000) {
                                        try {
                                            synchronized (this.a) {
                                                this.a.wait(j2 / 1000000);
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                this.k = System.nanoTime();
                                this.o.a = g;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        a(i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        synchronized (this.a) {
            this.f = false;
            this.a.notify();
        }
    }

    public void a() {
        synchronized (this.a) {
            this.d = true;
            this.b = true;
        }
        this.m.queueEvent(new Runnable() { // from class: tech.sud.runtime.core.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.j();
            }
        });
        synchronized (this.a) {
            this.a.notify();
        }
    }

    public void b() {
        this.m.setRenderMode(1);
        this.m.queueEvent(new Runnable() { // from class: tech.sud.runtime.core.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.i();
            }
        });
        synchronized (this.a) {
            this.b = false;
            this.a.notify();
        }
    }

    public void c() {
        synchronized (this.a) {
            this.b = true;
        }
        this.m.setRenderMode(0);
        this.m.queueEvent(new Runnable() { // from class: tech.sud.runtime.core.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.h();
            }
        });
        synchronized (this.a) {
            this.a.notify();
        }
    }

    public void b(boolean z) {
        this.i.set(z);
        if (z) {
            synchronized (this.a) {
                this.a.notify();
            }
        }
    }

    public void a(tech.sud.runtime.component.e.d dVar) {
        this.l = dVar;
    }

    public void a(boolean z) {
        synchronized (this.a) {
            this.f = z;
        }
    }

    private void b(MotionEvent motionEvent) {
        float[] fArr;
        float[] fArr2;
        int[] iArr;
        int actionMasked = motionEvent.getActionMasked();
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount < 0) {
            return;
        }
        if (actionMasked != 0 && actionMasked != 1) {
            if (actionMasked == 2 || actionMasked == 3) {
                int[] iArr2 = new int[pointerCount];
                fArr = new float[pointerCount];
                fArr2 = new float[pointerCount];
                for (int i = 0; i < pointerCount; i++) {
                    iArr2[i] = motionEvent.getPointerId(i);
                    fArr[i] = motionEvent.getX(i);
                    fArr2[i] = motionEvent.getY(i);
                }
                iArr = iArr2;
                this.h.a(actionMasked % 5, iArr, fArr, fArr2, motionEvent.getEventTime() / 1000.0d);
            }
            if (actionMasked != 5 && actionMasked != 6) {
                return;
            }
        }
        int actionIndex = motionEvent.getActionIndex();
        int[] iArr3 = {motionEvent.getPointerId(actionIndex)};
        fArr = new float[]{motionEvent.getX(actionIndex)};
        fArr2 = new float[]{motionEvent.getY(actionIndex)};
        iArr = iArr3;
        this.h.a(actionMasked % 5, iArr, fArr, fArr2, motionEvent.getEventTime() / 1000.0d);
    }

    public void a(MotionEvent motionEvent) {
        b(motionEvent);
        tech.sud.runtime.component.e.d dVar = this.l;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void a(int i) {
        if (i < 1) {
            i = 1;
        } else if (i > 60) {
            i = 60;
        }
        this.j = (long) ((1.0d / i) * 1.0E9d);
    }

    private void a(int i, int i2) {
        if (this.e) {
            return;
        }
        this.h.a(i, i2, tech.sud.runtime.component.c.h.a(this.n.getContext()), this.g);
    }
}
