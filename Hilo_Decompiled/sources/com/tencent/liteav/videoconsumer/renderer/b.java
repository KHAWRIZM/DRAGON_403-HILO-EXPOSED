package com.tencent.liteav.videoconsumer.renderer;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class b implements Runnable {
    private final a a;
    private final Surface b;

    private b(a aVar, Surface surface) {
        this.a = aVar;
        this.b = surface;
    }

    public static Runnable a(a aVar, Surface surface) {
        return new b(aVar, surface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.a, this.b);
    }
}
