package com.tencent.liteav.videoconsumer.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class l implements Runnable {
    private final j a;

    private l(j jVar) {
        this.a = jVar;
    }

    public static Runnable a(j jVar) {
        return new l(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();
    }
}
