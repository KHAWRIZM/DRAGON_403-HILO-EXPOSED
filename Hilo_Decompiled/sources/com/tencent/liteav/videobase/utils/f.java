package com.tencent.liteav.videobase.utils;

import android.graphics.SurfaceTexture;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class f implements Runnable {
    private final SurfaceTextureHolder a;
    private final SurfaceTexture b;

    private f(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        this.a = surfaceTextureHolder;
        this.b = surfaceTexture;
    }

    public static Runnable a(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        return new f(surfaceTextureHolder, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTextureHolder.lambda$onFrameAvailable$0(this.a, this.b);
    }
}
