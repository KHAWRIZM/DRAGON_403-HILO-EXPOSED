package com.luck.picture.lib.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class AnimUtils {
    public static final int DURATION = 250;

    public static void rotateArrow(ImageView imageView, boolean z10) {
        float f10 = 180.0f;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        if (z10) {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
            f11 = 180.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", f10, f11);
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }

    public static void selectZoom(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.05f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.05f, 1.0f));
        animatorSet.setDuration(250L);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.start();
    }
}
