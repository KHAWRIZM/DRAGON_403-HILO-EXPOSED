package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import f5.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c implements j {
    private final int height;
    private c5.d request;
    private final int width;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.j
    public final c5.d getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.request.target.j
    public final void getSize(i iVar) {
        iVar.d(this.width, this.height);
    }

    @Override // z4.l
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.j
    public void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.j
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // z4.l
    public void onStart() {
    }

    @Override // z4.l
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.j
    public final void removeCallback(i iVar) {
    }

    @Override // com.bumptech.glide.request.target.j
    public final void setRequest(c5.d dVar) {
        this.request = dVar;
    }

    public c(int i10, int i11) {
        if (l.v(i10, i11)) {
            this.width = i10;
            this.height = i11;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i10 + " and height: " + i11);
    }
}
