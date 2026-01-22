package com.luck.picture.lib.interfaces;

import android.content.Context;
import com.luck.picture.lib.entity.LocalMedia;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface OnExternalPreviewEventListener {
    boolean onLongPressDownload(Context context, LocalMedia localMedia);

    void onPreviewDelete(int i10);
}
