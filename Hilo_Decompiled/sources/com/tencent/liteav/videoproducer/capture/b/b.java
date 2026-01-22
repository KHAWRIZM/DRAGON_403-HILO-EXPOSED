package com.tencent.liteav.videoproducer.capture.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class b implements Runnable {
    private final a a;
    private final int b;

    private b(a aVar, int i) {
        this.a = aVar;
        this.b = i;
    }

    public static Runnable a(a aVar, int i) {
        return new b(aVar, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.a, this.b);
    }
}
