package com.tencent.rtmp.video;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface VirtualDisplayListener {
    void onCaptureError();

    void onStartFinish(boolean z, boolean z2);

    void onVirtualDisplayCreate(VirtualDisplayWrapper virtualDisplayWrapper);
}
