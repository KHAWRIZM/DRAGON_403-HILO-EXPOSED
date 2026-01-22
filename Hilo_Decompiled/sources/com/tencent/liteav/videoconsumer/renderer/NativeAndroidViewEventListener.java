package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.rtmp.ui.AndroidViewEventListener;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class NativeAndroidViewEventListener implements AndroidViewEventListener {
    private long mNativeHandler;

    public NativeAndroidViewEventListener(long j) {
        this.mNativeHandler = j;
    }

    private static native void nativeOnTap(long j, int i, int i2, int i3, int i4);

    private static native void nativeOnZoom(long j, float f);

    private static native void nativeonSizeChanged(long j, int i, int i2, int i3, int i4);

    @Override // com.tencent.rtmp.ui.AndroidViewEventListener
    public synchronized void onSizeChanged(int i, int i2, int i3, int i4) {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeonSizeChanged(j, i, i2, i3, i4);
        }
    }

    @Override // com.tencent.rtmp.ui.AndroidViewEventListener
    public synchronized void onTap(int i, int i2, int i3, int i4) {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnTap(j, i, i2, i3, i4);
        }
    }

    @Override // com.tencent.rtmp.ui.AndroidViewEventListener
    public synchronized void onZoom(float f) {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnZoom(j, f);
        }
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0L;
    }
}
