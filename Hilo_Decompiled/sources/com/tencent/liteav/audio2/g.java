package com.tencent.liteav.audio2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class g implements Runnable {
    private final e a;

    private g(e eVar) {
        this.a = eVar;
    }

    public static Runnable a(e eVar) {
        return new g(eVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d();
    }
}
