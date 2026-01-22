package tech.sud.runtime.core;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class e extends GLSurfaceView implements c {
    private final d a;

    public e(g gVar, Context context, boolean z) {
        super(context);
        if (z) {
            getHolder().setFormat(-3);
            setZOrderOnTop(true);
        }
        setPreserveEGLContextOnPause(true);
        this.a = new d(gVar, this);
    }

    @Override // tech.sud.runtime.core.c
    public d a() {
        return this.a;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        this.a.b(true);
        super.onDetachedFromWindow();
        this.a.b(false);
    }

    @Override // android.opengl.GLSurfaceView, tech.sud.runtime.core.c
    public void onPause() {
        if (this.a.d()) {
            return;
        }
        super.onPause();
        this.a.c();
    }

    @Override // android.opengl.GLSurfaceView, tech.sud.runtime.core.c
    public void onResume() {
        if (this.a.d()) {
            return;
        }
        super.onResume();
        this.a.b();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.a.b(true);
        super.onSizeChanged(i, i2, i3, i4);
        this.a.b(false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.a.a(motionEvent);
        return true;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.a.a(false);
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.a.a(true);
        this.a.b(true);
        super.surfaceDestroyed(surfaceHolder);
        this.a.b(false);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        this.a.b(true);
        super.surfaceRedrawNeeded(surfaceHolder);
        this.a.b(false);
    }
}
