package com.tencent.liteav.videoproducer2.capture;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class b implements Runnable {
    private final NativeCameraCaptureListener a;
    private final int b;

    private b(NativeCameraCaptureListener nativeCameraCaptureListener, int i) {
        this.a = nativeCameraCaptureListener;
        this.b = i;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, int i) {
        return new b(nativeCameraCaptureListener, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.runInNative(e.a(this.a, this.b));
    }
}
