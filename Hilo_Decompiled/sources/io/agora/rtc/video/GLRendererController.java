package io.agora.rtc.video;

import android.graphics.SurfaceTexture;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface GLRendererController extends SurfaceTexture.OnFrameAvailableListener {
    int GetAPILevel();

    void ReDraw();
}
