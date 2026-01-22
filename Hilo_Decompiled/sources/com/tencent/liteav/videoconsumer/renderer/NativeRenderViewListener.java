package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class NativeRenderViewListener implements RenderViewHelperInterface.RenderViewListener {
    private long mNativeHandler;

    public NativeRenderViewListener(long j) {
        this.mNativeHandler = j;
    }

    private static native void nativeOnRequestRedraw(long j, Bitmap bitmap);

    private static native void nativeOnSurfaceChanged(long j, Surface surface, boolean z);

    private static native void nativeOnSurfaceDestroy(long j);

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public synchronized void onRequestRedraw(Bitmap bitmap) {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnRequestRedraw(j, bitmap);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public synchronized void onSurfaceChanged(Surface surface, boolean z) {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnSurfaceChanged(j, surface, z);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface.RenderViewListener
    public synchronized void onSurfaceDestroy() {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnSurfaceDestroy(j);
        }
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0L;
    }
}
