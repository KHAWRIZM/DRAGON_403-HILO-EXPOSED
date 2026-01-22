package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import d5.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class f extends k implements b.a {
    private Animatable animatable;

    public f(ImageView imageView) {
        super(imageView);
    }

    private void e(Object obj) {
        if (obj instanceof Animatable) {
            Animatable animatable = (Animatable) obj;
            this.animatable = animatable;
            animatable.start();
            return;
        }
        this.animatable = null;
    }

    private void f(Object obj) {
        setResource(obj);
        e(obj);
    }

    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    @Override // com.bumptech.glide.request.target.k, com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.j
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.animatable;
        if (animatable != null) {
            animatable.stop();
        }
        f(null);
        setDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.j
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        f(null);
        setDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.k, com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.j
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        f(null);
        setDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.j
    public void onResourceReady(Object obj, d5.b bVar) {
        if (bVar != null && bVar.a(obj, this)) {
            e(obj);
        } else {
            f(obj);
        }
    }

    @Override // z4.l
    public void onStart() {
        Animatable animatable = this.animatable;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // z4.l
    public void onStop() {
        Animatable animatable = this.animatable;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    protected abstract void setResource(Object obj);
}
