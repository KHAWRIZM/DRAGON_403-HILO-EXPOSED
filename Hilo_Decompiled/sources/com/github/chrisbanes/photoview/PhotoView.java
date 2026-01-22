package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import p6.d;
import p6.e;
import p6.f;
import p6.g;
import p6.h;
import p6.i;
import p6.j;
import p6.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PhotoView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    private k f٧٩٣٩a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView.ScaleType f٧٩٤٠b;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void init() {
        this.f٧٩٣٩a = new k(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f٧٩٤٠b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f٧٩٤٠b = null;
        }
    }

    public k getAttacher() {
        return this.f٧٩٣٩a;
    }

    public RectF getDisplayRect() {
        return this.f٧٩٣٩a.B();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f٧٩٣٩a.E();
    }

    public float getMaximumScale() {
        return this.f٧٩٣٩a.H();
    }

    public float getMediumScale() {
        return this.f٧٩٣٩a.I();
    }

    public float getMinimumScale() {
        return this.f٧٩٣٩a.J();
    }

    public float getScale() {
        return this.f٧٩٣٩a.K();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f٧٩٣٩a.L();
    }

    public void setAllowParentInterceptOnEdge(boolean z10) {
        this.f٧٩٣٩a.O(z10);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i10, int i11, int i12, int i13) {
        boolean frame = super.setFrame(i10, i11, i12, i13);
        if (frame) {
            this.f٧٩٣٩a.b0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.f٧٩٣٩a;
        if (kVar != null) {
            kVar.b0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        super.setImageResource(i10);
        k kVar = this.f٧٩٣٩a;
        if (kVar != null) {
            kVar.b0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.f٧٩٣٩a;
        if (kVar != null) {
            kVar.b0();
        }
    }

    public void setMaximumScale(float f10) {
        this.f٧٩٣٩a.Q(f10);
    }

    public void setMediumScale(float f10) {
        this.f٧٩٣٩a.R(f10);
    }

    public void setMinimumScale(float f10) {
        this.f٧٩٣٩a.S(f10);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f٧٩٣٩a.setOnClickListener(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f٧٩٣٩a.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f٧٩٣٩a.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.f٧٩٣٩a.setOnMatrixChangeListener(dVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f٧٩٣٩a.setOnOutsidePhotoTapListener(eVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f٧٩٣٩a.setOnPhotoTapListener(fVar);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f٧٩٣٩a.setOnScaleChangeListener(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f٧٩٣٩a.setOnSingleFlingListener(hVar);
    }

    public void setOnViewDragListener(i iVar) {
        this.f٧٩٣٩a.setOnViewDragListener(iVar);
    }

    public void setOnViewTapListener(j jVar) {
        this.f٧٩٣٩a.setOnViewTapListener(jVar);
    }

    public void setRotationBy(float f10) {
        this.f٧٩٣٩a.T(f10);
    }

    public void setRotationTo(float f10) {
        this.f٧٩٣٩a.U(f10);
    }

    public void setScale(float f10) {
        this.f٧٩٣٩a.V(f10);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        k kVar = this.f٧٩٣٩a;
        if (kVar == null) {
            this.f٧٩٤٠b = scaleType;
        } else {
            kVar.Y(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i10) {
        this.f٧٩٣٩a.Z(i10);
    }

    public void setZoomable(boolean z10) {
        this.f٧٩٣٩a.a0(z10);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f10, boolean z10) {
        this.f٧٩٣٩a.X(f10, z10);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init();
    }
}
