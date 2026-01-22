package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class j extends i {
    private j(Drawable drawable) {
        super(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static v a(Drawable drawable) {
        if (drawable != null) {
            return new j(drawable);
        }
        return null;
    }

    @Override // o4.v
    public Class getResourceClass() {
        return this.drawable.getClass();
    }

    @Override // o4.v
    public int getSize() {
        return Math.max(1, this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight() * 4);
    }

    @Override // o4.v
    public void recycle() {
    }
}
