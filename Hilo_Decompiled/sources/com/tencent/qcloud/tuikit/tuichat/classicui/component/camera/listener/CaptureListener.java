package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface CaptureListener {
    void recordEnd(long j);

    void recordError();

    void recordShort(long j);

    void recordStart();

    void recordZoom(float f);

    void takePictures();
}
