package com.tencent.rtmp.video.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class h implements Runnable {
    private final f a;

    private h(f fVar) {
        this.a = fVar;
    }

    public static Runnable a(f fVar) {
        return new h(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c();
    }
}
