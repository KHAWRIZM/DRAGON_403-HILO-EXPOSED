package com.tencent.rtmp.video;

import android.app.Activity;
import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.rtmp.video.a.f;
import com.tencent.rtmp.video.a.i;
import com.tencent.rtmp.video.a.j;
import com.tencent.rtmp.video.a.k;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class VirtualDisplayManagerProxy {
    private static volatile VirtualDisplayManagerProxy sInstance;
    private f mVirtualDisplayManager = new f();

    private VirtualDisplayManagerProxy() {
    }

    public static VirtualDisplayManagerProxy getInstance() {
        if (sInstance == null) {
            synchronized (VirtualDisplayManagerProxy.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new VirtualDisplayManagerProxy();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public void registerRequestPermissionActivity(Activity activity) {
        this.mVirtualDisplayManager.a(activity);
    }

    public void signalSessionRequestFinish(MediaProjection mediaProjection) {
        this.mVirtualDisplayManager.a(mediaProjection);
    }

    public void startVirtualDisplaySync(Surface surface, int i, int i2, MediaProjection mediaProjection, VirtualDisplayListener virtualDisplayListener) {
        f fVar = this.mVirtualDisplayManager;
        BaseBridge.printLog("VirtualDisplayManager", "startVirtualDisplaySync, surface:" + surface + ", width:" + i + ", height:" + i2 + ", mediaProjection: " + mediaProjection + ", listener:" + virtualDisplayListener + ". version:12.9.0.19492");
        fVar.c.b(i.a(fVar, surface, i, i2, mediaProjection, virtualDisplayListener));
    }

    public void stopVirtualDisplaySync(Surface surface) {
        f fVar = this.mVirtualDisplayManager;
        BaseBridge.printLog("VirtualDisplayManager", "stopVirtualDisplaySync, surface:".concat(String.valueOf(surface)));
        fVar.c.b(j.a(fVar, surface));
    }

    public void unRegisterRequestPermissionActivity(Activity activity) {
        f fVar = this.mVirtualDisplayManager;
        BaseBridge.printLog("VirtualDisplayManager", "UnRegister request permission activity:".concat(String.valueOf(activity)));
        WeakReference<Activity> weakReference = fVar.a;
        if (weakReference != null && weakReference.get() == activity) {
            fVar.a = null;
        }
    }

    public void updateVirtualDisplaySizeSync(Surface surface, int i, int i2, VirtualDisplayListener virtualDisplayListener) {
        f fVar = this.mVirtualDisplayManager;
        BaseBridge.printLog("VirtualDisplayManager", "updateVirtualDisplaySizeSync, surface:" + surface + ", width:" + i + ", height:" + i2 + ", listener:" + virtualDisplayListener);
        fVar.c.b(k.a(fVar, surface, i, i2, virtualDisplayListener));
    }
}
