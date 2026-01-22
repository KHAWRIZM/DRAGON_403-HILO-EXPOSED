package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class c implements Runnable {
    private final NativeCameraCaptureListener a;
    private final SurfaceTexture b;

    private c(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        this.a = nativeCameraCaptureListener;
        this.b = surfaceTexture;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        return new c(nativeCameraCaptureListener, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.runInNative(d.a(this.a, this.b));
    }
}
