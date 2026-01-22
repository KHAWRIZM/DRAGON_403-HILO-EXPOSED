package com.tencent.rtmp.video.a;

import android.view.Surface;
import com.tencent.rtmp.video.BaseBridge;
import com.tencent.rtmp.video.VirtualDisplayWrapper;
import com.tencent.rtmp.video.a.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class j implements Runnable {
    private final f a;
    private final Surface b;

    private j(f fVar, Surface surface) {
        this.a = fVar;
        this.b = surface;
    }

    public static Runnable a(f fVar, Surface surface) {
        return new j(fVar, surface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VirtualDisplayWrapper virtualDisplayWrapper;
        f fVar = this.a;
        Surface surface = this.b;
        if (surface != null) {
            f.a remove = fVar.d.remove(surface);
            if (remove != null && (virtualDisplayWrapper = remove.e) != null) {
                virtualDisplayWrapper.release();
                BaseBridge.printLog("VirtualDisplayManager", "VirtualDisplay released, " + remove.e);
            }
            fVar.c();
        }
    }
}
