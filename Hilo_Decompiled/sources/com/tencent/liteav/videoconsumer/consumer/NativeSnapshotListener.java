package com.tencent.liteav.videoconsumer.consumer;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class NativeSnapshotListener {
    private long mNativeVideoSnapListener;

    private NativeSnapshotListener(long j) {
        this.mNativeVideoSnapListener = j;
    }

    private native void nativeDestroy(long j);

    private native void nativeOnComplete(long j, Bitmap bitmap);

    protected void finalize() throws Throwable {
        long j = this.mNativeVideoSnapListener;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeVideoSnapListener = 0L;
        }
        super.finalize();
    }

    public void onComplete(Bitmap bitmap) {
        long j = this.mNativeVideoSnapListener;
        if (j != 0) {
            nativeOnComplete(j, bitmap);
            this.mNativeVideoSnapListener = 0L;
        }
    }
}
