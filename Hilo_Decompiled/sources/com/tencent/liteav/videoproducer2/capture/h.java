package com.tencent.liteav.videoproducer2.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class h implements Runnable {
    private final NativeScreenCaptureListener a;

    private h(NativeScreenCaptureListener nativeScreenCaptureListener) {
        this.a = nativeScreenCaptureListener;
    }

    public static Runnable a(NativeScreenCaptureListener nativeScreenCaptureListener) {
        return new h(nativeScreenCaptureListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.notifyCaptureError();
    }
}
