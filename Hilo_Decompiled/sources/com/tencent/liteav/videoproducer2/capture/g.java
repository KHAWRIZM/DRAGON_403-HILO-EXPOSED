package com.tencent.liteav.videoproducer2.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class g implements Runnable {
    private final NativeScreenCaptureListener a;
    private final boolean b;
    private final boolean c;

    private g(NativeScreenCaptureListener nativeScreenCaptureListener, boolean z, boolean z2) {
        this.a = nativeScreenCaptureListener;
        this.b = z;
        this.c = z2;
    }

    public static Runnable a(NativeScreenCaptureListener nativeScreenCaptureListener, boolean z, boolean z2) {
        return new g(nativeScreenCaptureListener, z, z2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.notifyStartFinish(this.b, this.c);
    }
}
