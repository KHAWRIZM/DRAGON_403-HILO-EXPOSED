package com.tencent.liteav.videoconsumer.renderer;

import android.view.SurfaceView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class f implements Runnable {
    private final e a;
    private final SurfaceView b;

    private f(e eVar, SurfaceView surfaceView) {
        this.a = eVar;
        this.b = surfaceView;
    }

    public static Runnable a(e eVar, SurfaceView surfaceView) {
        return new f(eVar, surfaceView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a(this.a, this.b);
    }
}
