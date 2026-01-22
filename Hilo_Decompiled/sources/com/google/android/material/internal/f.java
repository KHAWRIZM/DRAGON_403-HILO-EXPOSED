package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final Drawable f٩٢٩٩a;

    /* renamed from: b, reason: collision with root package name */
    private final Drawable f٩٣٠٠b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f٩٣٠١c;

    /* renamed from: d, reason: collision with root package name */
    private float f٩٣٠٢d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class b extends Drawable {
        private b() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public f(Drawable drawable, Drawable drawable2) {
        Drawable bVar;
        Drawable bVar2;
        int i10;
        if (drawable != null) {
            bVar = drawable.getConstantState().newDrawable().mutate();
        } else {
            bVar = new b();
        }
        this.f٩٢٩٩a = bVar;
        if (drawable2 != null) {
            bVar2 = drawable2.getConstantState().newDrawable().mutate();
        } else {
            bVar2 = new b();
        }
        this.f٩٣٠٠b = bVar2;
        if (drawable != null) {
            i10 = h2.b.f(drawable);
        } else {
            i10 = 3;
        }
        int f10 = drawable2 != null ? h2.b.f(drawable2) : 3;
        h2.b.m(bVar, i10);
        h2.b.m(bVar2, f10);
        bVar2.setAlpha(0);
        this.f٩٣٠١c = new float[2];
    }

    public void a(float f10) {
        if (this.f٩٣٠٢d != f10) {
            this.f٩٣٠٢d = f10;
            h.a(f10, this.f٩٣٠١c);
            this.f٩٢٩٩a.setAlpha((int) (this.f٩٣٠١c[0] * 255.0f));
            this.f٩٣٠٠b.setAlpha((int) (this.f٩٣٠١c[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f٩٢٩٩a.draw(canvas);
        this.f٩٣٠٠b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f٩٢٩٩a.getIntrinsicHeight(), this.f٩٣٠٠b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f٩٢٩٩a.getIntrinsicWidth(), this.f٩٣٠٠b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.f٩٢٩٩a.getMinimumHeight(), this.f٩٣٠٠b.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.f٩٢٩٩a.getMinimumWidth(), this.f٩٣٠٠b.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.f٩٢٩٩a.isStateful() && !this.f٩٣٠٠b.isStateful()) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f٩٣٠٢d <= 0.5f) {
            this.f٩٢٩٩a.setAlpha(i10);
            this.f٩٣٠٠b.setAlpha(0);
        } else {
            this.f٩٢٩٩a.setAlpha(0);
            this.f٩٣٠٠b.setAlpha(i10);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.f٩٢٩٩a.setBounds(i10, i11, i12, i13);
        this.f٩٣٠٠b.setBounds(i10, i11, i12, i13);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f٩٢٩٩a.setColorFilter(colorFilter);
        this.f٩٣٠٠b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        boolean state = this.f٩٢٩٩a.setState(iArr);
        boolean state2 = this.f٩٣٠٠b.setState(iArr);
        if (!state && !state2) {
            return false;
        }
        return true;
    }
}
