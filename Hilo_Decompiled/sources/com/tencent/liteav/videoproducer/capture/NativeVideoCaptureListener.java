package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class NativeVideoCaptureListener implements com.tencent.liteav.videobase.videobase.c, CaptureSourceInterface.CaptureSourceListener {
    private static final String TAG = "NativeVideoCaptureListener";
    private long mNativeHandler;

    public NativeVideoCaptureListener(long j) {
        this.mNativeHandler = j;
    }

    private static native void nativeOnAutoFocusEnabled(long j, boolean z);

    private static native void nativeOnCaptureError(long j, int i, String str);

    private static native void nativeOnCaptureFirstFrame(long j);

    private static native void nativeOnCapturePaused(long j);

    private static native void nativeOnCaptureResumed(long j);

    private static native void nativeOnCaptureStopped(long j);

    private static native void nativeOnFrameAvailable(long j, PixelFrame pixelFrame);

    private static native void nativeOnScreenDisplayOrientationChanged(long j, int i);

    private static native void nativeOnStartFinish(long j, boolean z);

    private static native void nativeOnZoomEnabled(long j, boolean z);

    public synchronized void notifyError(e.a aVar, String str) {
        if (this.mNativeHandler == 0) {
            return;
        }
        int a = com.tencent.liteav.videobase.videobase.e.a(aVar);
        if (a != 0) {
            nativeOnCaptureError(this.mNativeHandler, a, str);
            return;
        }
        LiteavLog.i(TAG, "notifyError error code:" + aVar + ", do not need transfer to LiteAvCode:" + a);
    }

    public void notifyEvent(e.b bVar, int i, String str) {
    }

    @Override // com.tencent.liteav.videobase.videobase.c
    public synchronized void notifyWarning(e.c cVar, String str) {
    }

    public synchronized void onCameraTouchEnable(boolean z) {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnAutoFocusEnabled(j, !z);
        }
    }

    public synchronized void onCameraZoomEnable(boolean z) {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnZoomEnabled(j, z);
        }
    }

    public synchronized void onCaptureError() {
    }

    public synchronized void onCaptureFirstFrame() {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnCaptureFirstFrame(j);
        }
    }

    public synchronized void onFrameAvailable(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame) {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnFrameAvailable(j, pixelFrame);
        }
    }

    public synchronized void onScreenDisplayOrientationChanged(k kVar) {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnScreenDisplayOrientationChanged(j, k.a(kVar));
        }
    }

    public synchronized void onStartFinish(boolean z) {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnStartFinish(j, z);
        }
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0L;
    }

    public synchronized void updateStatus(com.tencent.liteav.videobase.videobase.f fVar, Object obj) {
    }

    public synchronized void notifyEvent(e.b bVar, Object obj, String str) {
        long j = this.mNativeHandler;
        if (j == 0) {
            return;
        }
        if (bVar == e.b.EVT_VIDEO_CAPTURE_FIRST_FRAME) {
            nativeOnCaptureFirstFrame(j);
            return;
        }
        if (bVar == e.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED) {
            nativeOnCapturePaused(j);
        } else if (bVar == e.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_RESUME) {
            nativeOnCaptureResumed(j);
        } else {
            if (bVar == e.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_STOP_SUCCESS) {
                nativeOnCaptureStopped(j);
            }
        }
    }

    @Override // com.tencent.liteav.videobase.videobase.c
    public synchronized void updateStatus(com.tencent.liteav.videobase.videobase.f fVar, int i, Object obj) {
    }
}
