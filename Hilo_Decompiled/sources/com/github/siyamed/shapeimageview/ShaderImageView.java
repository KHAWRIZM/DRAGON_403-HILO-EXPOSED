package com.github.siyamed.shapeimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import y6.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class ShaderImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private d f٨٠٨٣a;

    public ShaderImageView(Context context) {
        super(context);
        b(context, null, 0);
    }

    private void b(Context context, AttributeSet attributeSet, int i10) {
        getPathHelper().i(context, attributeSet, i10);
    }

    protected abstract d a();

    public float getBorderAlpha() {
        return getPathHelper().g();
    }

    public int getBorderWidth() {
        return getPathHelper().h();
    }

    protected d getPathHelper() {
        if (this.f٨٠٨٣a == null) {
            this.f٨٠٨٣a = a();
        }
        return this.f٨٠٨٣a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!getPathHelper().k(canvas)) {
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        if (getPathHelper().j()) {
            super.onMeasure(i10, i10);
        } else {
            super.onMeasure(i10, i11);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        getPathHelper().m(i10, i11);
    }

    public void setBorderAlpha(float f10) {
        getPathHelper().o(f10);
        invalidate();
    }

    public void setBorderColor(int i10) {
        getPathHelper().p(i10);
        invalidate();
    }

    public void setBorderWidth(int i10) {
        getPathHelper().q(i10);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        getPathHelper().l(getDrawable());
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getPathHelper().l(getDrawable());
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        super.setImageResource(i10);
        getPathHelper().l(getDrawable());
    }

    public void setSquare(boolean z10) {
        getPathHelper().r(z10);
        invalidate();
    }

    public ShaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet, 0);
    }

    public ShaderImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b(context, attributeSet, i10);
    }
}
