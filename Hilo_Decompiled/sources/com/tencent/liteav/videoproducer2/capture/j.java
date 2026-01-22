package com.tencent.liteav.videoproducer2.capture;

import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.rtmp.video.BaseBridge;
import com.tencent.rtmp.video.VirtualDisplayListener;
import com.tencent.rtmp.video.VirtualDisplayWrapper;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class j {
    private static BaseBridge.BaseBridgeCallback g;
    Surface a;
    MediaProjection b;
    int c;
    int d;
    VirtualDisplayWrapper e;
    VirtualDisplayListener f = new VirtualDisplayListener() { // from class: com.tencent.liteav.videoproducer2.capture.j.1
        @Override // com.tencent.rtmp.video.VirtualDisplayListener
        public final void onCaptureError() {
            if (j.this.h != null) {
                j.this.h.onCaptureError();
            }
        }

        @Override // com.tencent.rtmp.video.VirtualDisplayListener
        public final void onStartFinish(boolean z, boolean z2) {
            if (j.this.h != null) {
                j.this.h.onStartFinish(z, z2);
            }
        }

        @Override // com.tencent.rtmp.video.VirtualDisplayListener
        public final void onVirtualDisplayCreate(VirtualDisplayWrapper virtualDisplayWrapper) {
            j.this.e = virtualDisplayWrapper;
        }
    };
    private NativeScreenCaptureListener h;

    static {
        a aVar = new a();
        g = aVar;
        BaseBridge.setBaseBridgeCallback(aVar);
    }

    public j(Surface surface, int i, int i2, MediaProjection mediaProjection, NativeScreenCaptureListener nativeScreenCaptureListener) {
        this.a = surface;
        this.b = mediaProjection;
        this.h = nativeScreenCaptureListener;
        this.c = i;
        this.d = i2;
    }
}
