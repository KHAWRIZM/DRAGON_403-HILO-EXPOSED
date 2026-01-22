package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class i implements Runnable {
    private final e a;

    private i(e eVar) {
        this.a = eVar;
    }

    public static Runnable a(e eVar) {
        return new i(eVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
