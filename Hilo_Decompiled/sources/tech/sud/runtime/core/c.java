package tech.sud.runtime.core;

import android.opengl.GLSurfaceView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public interface c {
    d a();

    void onPause();

    void onResume();

    void queueEvent(Runnable runnable);

    void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6);

    void setEGLContextClientVersion(int i);

    void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory);

    void setRenderMode(int i);

    void setRenderer(GLSurfaceView.Renderer renderer);
}
