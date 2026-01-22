package com.tencent.liteav.videoproducer2.capture;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class e implements Runnable {
    private final NativeCameraCaptureListener a;
    private final int b;

    private e(NativeCameraCaptureListener nativeCameraCaptureListener, int i) {
        this.a = nativeCameraCaptureListener;
        this.b = i;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, int i) {
        return new e(nativeCameraCaptureListener, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        NativeCameraCaptureListener.nativeOnCameraError(this.a.mNativeHandle, this.b);
    }
}
