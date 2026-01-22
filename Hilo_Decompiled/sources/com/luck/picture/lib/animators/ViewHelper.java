package com.luck.picture.lib.animators;

import android.view.View;
import androidx.core.view.d1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ViewHelper {
    public static void clear(View view) {
        view.setAlpha(1.0f);
        view.setScaleY(1.0f);
        view.setScaleX(1.0f);
        view.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
        view.setTranslationX(DownloadProgress.UNKNOWN_PROGRESS);
        view.setRotation(DownloadProgress.UNKNOWN_PROGRESS);
        view.setRotationY(DownloadProgress.UNKNOWN_PROGRESS);
        view.setRotationX(DownloadProgress.UNKNOWN_PROGRESS);
        view.setPivotY(view.getMeasuredHeight() / 2);
        view.setPivotX(view.getMeasuredWidth() / 2);
        d1.e(view).g(null).j(0L);
    }
}
