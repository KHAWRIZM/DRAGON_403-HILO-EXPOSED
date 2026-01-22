package com.tencent.liteav.videoproducer2.capture;

import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.video.ScreenCaptureService;
import com.tencent.rtmp.video.VirtualDisplayManagerProxy;
import com.tencent.rtmp.video.VirtualDisplayWrapper;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class NativeScreenCapture {
    private static final String TAG = "NativeScreenCapture";
    static boolean sIsCaptureClassExist;
    static boolean sIsCheck;
    private NativeScreenCaptureListener mListener;
    private MediaProjection mMediaProjection;
    private j mScreenCaptureBridge;
    private Surface mSurface;

    public NativeScreenCapture(Surface surface, MediaProjection mediaProjection, NativeScreenCaptureListener nativeScreenCaptureListener) {
        this.mSurface = surface;
        this.mMediaProjection = mediaProjection;
        this.mListener = nativeScreenCaptureListener;
    }

    private static boolean checkIfScreenCaptureClassExist() {
        boolean z;
        if (sIsCheck) {
            return sIsCaptureClassExist;
        }
        try {
            int i = ScreenCaptureService.a;
            try {
                LiteavLog.i(TAG, "Detect screen capture class!");
                z = true;
            } catch (ClassNotFoundException unused) {
                z = true;
                LiteavLog.e(TAG, "Detect screen capture class failed!");
                sIsCaptureClassExist = z;
                sIsCheck = true;
                return z;
            }
        } catch (ClassNotFoundException unused2) {
            z = false;
        }
        sIsCaptureClassExist = z;
        sIsCheck = true;
        return z;
    }

    public void startVirtualDisplaySync(int i, int i2) {
        if (!checkIfScreenCaptureClassExist()) {
            this.mListener.onClassNotFound();
            return;
        }
        if (this.mScreenCaptureBridge == null) {
            this.mScreenCaptureBridge = new j(this.mSurface, i, i2, this.mMediaProjection, this.mListener);
        }
        j jVar = this.mScreenCaptureBridge;
        VirtualDisplayManagerProxy.getInstance().startVirtualDisplaySync(jVar.a, jVar.c, jVar.d, jVar.b, jVar.f);
    }

    public void stopVirtualDisplaySync() {
        if (!checkIfScreenCaptureClassExist()) {
            this.mListener.onClassNotFound();
            return;
        }
        j jVar = this.mScreenCaptureBridge;
        if (jVar != null) {
            VirtualDisplayWrapper virtualDisplayWrapper = jVar.e;
            if (virtualDisplayWrapper != null) {
                virtualDisplayWrapper.release();
                jVar.e = null;
            }
            VirtualDisplayManagerProxy.getInstance().stopVirtualDisplaySync(jVar.a);
            this.mScreenCaptureBridge = null;
        }
    }

    public void updateVirtualDisplaySync(int i, int i2, boolean z) {
        if (!checkIfScreenCaptureClassExist()) {
            this.mListener.onClassNotFound();
            return;
        }
        j jVar = this.mScreenCaptureBridge;
        if (jVar == null) {
            LiteavLog.e(TAG, "Must start first!");
            return;
        }
        jVar.c = i;
        jVar.d = i2;
        LiteavLog.i("ScreenCaptureBridge", "updateVirtualDisplaySync:[wxh:" + i + "x" + i2 + "|restart:" + z + "]");
        VirtualDisplayWrapper virtualDisplayWrapper = jVar.e;
        if (virtualDisplayWrapper != null && !z) {
            virtualDisplayWrapper.resize(i, i2);
            return;
        }
        if (virtualDisplayWrapper != null) {
            virtualDisplayWrapper.release();
            jVar.e = null;
        }
        VirtualDisplayManagerProxy.getInstance().updateVirtualDisplaySizeSync(jVar.a, jVar.c, jVar.d, jVar.f);
    }
}
