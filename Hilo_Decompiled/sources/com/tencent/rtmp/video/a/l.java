package com.tencent.rtmp.video.a;

import android.media.projection.MediaProjection;
import com.tencent.rtmp.video.BaseBridge;
import com.tencent.rtmp.video.VirtualDisplayListener;
import com.tencent.rtmp.video.a.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class l implements Runnable {
    private final f a;
    private final MediaProjection b;

    private l(f fVar, MediaProjection mediaProjection) {
        this.a = fVar;
        this.b = mediaProjection;
    }

    public static Runnable a(f fVar, MediaProjection mediaProjection) {
        return new l(fVar, mediaProjection);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.a;
        MediaProjection mediaProjection = this.b;
        fVar.f = false;
        if (mediaProjection == null) {
            HashMap hashMap = new HashMap(fVar.d);
            fVar.d.clear();
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                VirtualDisplayListener virtualDisplayListener = ((f.a) it.next()).d;
                if (virtualDisplayListener != null) {
                    virtualDisplayListener.onStartFinish(false, true);
                }
            }
            f.d();
            return;
        }
        BaseBridge.printLog("VirtualDisplayManager", "Got session ".concat(String.valueOf(mediaProjection)));
        fVar.e = mediaProjection;
        mediaProjection.registerCallback(fVar.i, fVar.b);
        fVar.b();
        f.b(fVar.e);
        fVar.c.a(fVar.h, TimeUnit.SECONDS.toMillis(1L));
    }
}
