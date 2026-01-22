package com.luck.picture.lib.engine;

import android.content.Context;
import android.widget.ImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface ImageEngine {
    void loadAlbumCover(Context context, String str, ImageView imageView);

    void loadGridImage(Context context, String str, ImageView imageView);

    void loadImage(Context context, ImageView imageView, String str, int i10, int i11);

    void loadImage(Context context, String str, ImageView imageView);

    void pauseRequests(Context context);

    void resumeRequests(Context context);
}
