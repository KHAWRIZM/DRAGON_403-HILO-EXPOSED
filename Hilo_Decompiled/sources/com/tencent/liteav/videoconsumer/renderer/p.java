package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class p implements Runnable {
    private final j a;

    private p(j jVar) {
        this.a = jVar;
    }

    public static Runnable a(j jVar) {
        return new p(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.a(this.a);
    }
}
