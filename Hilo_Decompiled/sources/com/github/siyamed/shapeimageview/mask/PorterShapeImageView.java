package com.github.siyamed.shapeimageview.mask;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.github.siyamed.shapeimageview.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PorterShapeImageView extends PorterImageView {

    /* renamed from: k, reason: collision with root package name */
    private Drawable f٨٠٩٦k;

    /* renamed from: l, reason: collision with root package name */
    private Matrix f٨٠٩٧l;

    /* renamed from: m, reason: collision with root package name */
    private Matrix f٨٠٩٨m;

    public PorterShapeImageView(Context context) {
        super(context);
        c(context, null, 0);
    }

    private void c(Context context, AttributeSet attributeSet, int i10) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShaderImageView, i10, 0);
            this.f٨٠٩٦k = obtainStyledAttributes.getDrawable(R.styleable.ShaderImageView_siShape);
            obtainStyledAttributes.recycle();
        }
        this.f٨٠٩٧l = new Matrix();
    }

    private void d(int i10, int i11) {
        boolean z10;
        this.f٨٠٩٨m = null;
        int intrinsicWidth = this.f٨٠٩٦k.getIntrinsicWidth();
        int intrinsicHeight = this.f٨٠٩٦k.getIntrinsicHeight();
        if (i10 == intrinsicWidth && i11 == intrinsicHeight) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (intrinsicWidth > 0 && intrinsicHeight > 0 && !z10) {
            this.f٨٠٩٦k.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            float min = Math.min(i10 / intrinsicWidth, i11 / intrinsicHeight);
            this.f٨٠٩٧l.setScale(min, min);
            this.f٨٠٩٧l.postTranslate((int) (((r5 - (r0 * min)) * 0.5f) + 0.5f), (int) (((r6 - (r1 * min)) * 0.5f) + 0.5f));
        }
    }

    @Override // com.github.siyamed.shapeimageview.mask.PorterImageView
    protected void b(Canvas canvas, Paint paint, int i10, int i11) {
        Drawable drawable = this.f٨٠٩٦k;
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                d(i10, i11);
                if (this.f٨٠٩٨m != null) {
                    int saveCount = canvas.getSaveCount();
                    canvas.save();
                    canvas.concat(this.f٨٠٩٧l);
                    this.f٨٠٩٦k.draw(canvas);
                    canvas.restoreToCount(saveCount);
                    return;
                }
            }
            this.f٨٠٩٦k.setBounds(0, 0, i10, i11);
            this.f٨٠٩٦k.draw(canvas);
        }
    }

    public PorterShapeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet, 0);
    }

    public PorterShapeImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c(context, attributeSet, i10);
    }
}
