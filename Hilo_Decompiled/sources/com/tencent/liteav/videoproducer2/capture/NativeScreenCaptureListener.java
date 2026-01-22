package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CustomHandler;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class NativeScreenCaptureListener implements SurfaceTexture.OnFrameAvailableListener {
    private final CustomHandler mCallbackHandler = new CustomHandler(Looper.myLooper());
    private long mNativeHandle;

    public NativeScreenCaptureListener(long j) {
        this.mNativeHandle = j;
    }

    private static native void nativeOnCaptureError(long j);

    private static native void nativeOnClassNotFound(long j);

    private static native void nativeOnFrameAvailable(long j, SurfaceTexture surfaceTexture);

    private static native void nativeOnStartFinish(long j, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyCaptureError() {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeOnCaptureError(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyClassNotFound() {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeOnClassNotFound(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyFrameAvailable(SurfaceTexture surfaceTexture) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeOnFrameAvailable(j, surfaceTexture);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyStartFinish(boolean z, boolean z2) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeOnStartFinish(j, z, z2);
        }
    }

    public Handler getCallbackHandler() {
        return this.mCallbackHandler;
    }

    public void onCaptureError() {
        this.mCallbackHandler.runOrPost(h.a(this));
    }

    public void onClassNotFound() {
        this.mCallbackHandler.runOrPost(i.a(this));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mCallbackHandler.runOrPost(f.a(this, surfaceTexture));
    }

    public void onStartFinish(boolean z, boolean z2) {
        this.mCallbackHandler.runOrPost(g.a(this, z, z2));
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandle = 0L;
    }
}
