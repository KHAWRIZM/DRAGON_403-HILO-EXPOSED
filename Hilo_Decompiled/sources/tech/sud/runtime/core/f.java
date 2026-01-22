package tech.sud.runtime.core;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class f extends tech.sud.runtime.component.c.d implements c {
    private final d a;

    public f(g gVar, Context context) {
        super(context);
        setPreserveEGLContextOnPause(true);
        this.a = new d(gVar, this);
    }

    @Override // tech.sud.runtime.core.c
    public d a() {
        return this.a;
    }

    @Override // tech.sud.runtime.component.c.d
    public void b(SurfaceTexture surfaceTexture) {
        this.a.a(true);
        this.a.b(true);
        super.b(surfaceTexture);
        this.a.b(false);
    }

    @Override // tech.sud.runtime.component.c.d, android.view.View
    public void onDetachedFromWindow() {
        this.a.b(true);
        super.onDetachedFromWindow();
        this.a.b(false);
    }

    @Override // tech.sud.runtime.component.c.d, tech.sud.runtime.core.c
    public void onPause() {
        if (this.a.d()) {
            return;
        }
        super.onPause();
        this.a.c();
    }

    @Override // tech.sud.runtime.component.c.d, tech.sud.runtime.core.c
    public void onResume() {
        if (this.a.d()) {
            return;
        }
        super.onResume();
        this.a.b();
    }

    @Override // android.view.TextureView, android.view.View
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

    @Override // tech.sud.runtime.component.c.d
    public void a(SurfaceTexture surfaceTexture) {
        this.a.a(false);
        super.a(surfaceTexture);
    }

    @Override // tech.sud.runtime.component.c.d
    public void b() {
        this.a.e();
    }
}
