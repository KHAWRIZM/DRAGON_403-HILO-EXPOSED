package com.tencent.liteav.videoproducer2.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class i implements Runnable {
    private final NativeScreenCaptureListener a;

    private i(NativeScreenCaptureListener nativeScreenCaptureListener) {
        this.a = nativeScreenCaptureListener;
    }

    public static Runnable a(NativeScreenCaptureListener nativeScreenCaptureListener) {
        return new i(nativeScreenCaptureListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.notifyClassNotFound();
    }
}
