package io.agora.rtc.gdp;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class OffscreenSurface extends EglSurfaceBase {
    public OffscreenSurface(EglCore eglCore, int i10, int i11) {
        super(eglCore);
        createOffscreenSurface(i10, i11);
    }

    public void release() {
        releaseEglSurface();
    }
}
