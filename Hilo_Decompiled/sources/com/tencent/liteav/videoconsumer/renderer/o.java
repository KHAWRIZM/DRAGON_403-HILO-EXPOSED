package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class o implements Runnable {
    private final j a;

    private o(j jVar) {
        this.a = jVar;
    }

    public static Runnable a(j jVar) {
        return new o(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.b(this.a);
    }
}
