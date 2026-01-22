package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view;

import android.graphics.Bitmap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface CameraView {
    void confirmState(int i);

    boolean handlerFoucs(float f, float f2);

    void playVideo(Bitmap bitmap, String str);

    void resetState(int i);

    void setTip(String str);

    void showPicture(Bitmap bitmap, boolean z);

    void startPreviewCallback();

    void stopVideo();
}
