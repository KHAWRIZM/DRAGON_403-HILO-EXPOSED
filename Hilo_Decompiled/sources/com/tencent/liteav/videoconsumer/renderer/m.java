package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class m implements Runnable {
    private final j a;
    private final boolean b;

    private m(j jVar, boolean z) {
        this.a = jVar;
        this.b = z;
    }

    public static Runnable a(j jVar, boolean z) {
        return new m(jVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.a(this.a, this.b);
    }
}
