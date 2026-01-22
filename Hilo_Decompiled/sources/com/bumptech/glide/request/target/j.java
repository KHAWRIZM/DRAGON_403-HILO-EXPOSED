package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import z4.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface j extends l {
    c5.d getRequest();

    void getSize(i iVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(Object obj, d5.b bVar);

    void removeCallback(i iVar);

    void setRequest(c5.d dVar);
}
