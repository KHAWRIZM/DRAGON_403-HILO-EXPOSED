package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class q implements Runnable {
    private final j a;

    private q(j jVar) {
        this.a = jVar;
    }

    public static Runnable a(j jVar) {
        return new q(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.f(this.a);
    }
}
