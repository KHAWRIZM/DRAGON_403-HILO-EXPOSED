package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f٩١٨٤a;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f٩١٨٥b;

    /* renamed from: c, reason: collision with root package name */
    private final Rect f٩١٨٦c;

    /* renamed from: d, reason: collision with root package name */
    private int f٩١٨٧d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f٩١٨٨e;

    /* renamed from: f, reason: collision with root package name */
    boolean f٩١٨٩f;

    public ForegroundLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f٩١٨٤a;
        if (drawable != null) {
            if (this.f٩١٨٩f) {
                this.f٩١٨٩f = false;
                Rect rect = this.f٩١٨٥b;
                Rect rect2 = this.f٩١٨٦c;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f٩١٨٨e) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f٩١٨٧d, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f٩١٨٤a;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f٩١٨٤a;
        if (drawable != null && drawable.isStateful()) {
            this.f٩١٨٤a.setState(getDrawableState());
        }
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f٩١٨٤a;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f٩١٨٧d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f٩١٨٤a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f٩١٨٩f = z10 | this.f٩١٨٩f;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f٩١٨٩f = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f٩١٨٤a;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f٩١٨٤a);
            }
            this.f٩١٨٤a = drawable;
            this.f٩١٨٩f = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f٩١٨٧d == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i10) {
        if (this.f٩١٨٧d != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f٩١٨٧d = i10;
            if (i10 == 119 && this.f٩١٨٤a != null) {
                this.f٩١٨٤a.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f٩١٨٤a) {
            return false;
        }
        return true;
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٩١٨٥b = new Rect();
        this.f٩١٨٦c = new Rect();
        this.f٩١٨٧d = 119;
        this.f٩١٨٨e = true;
        this.f٩١٨٩f = false;
        TypedArray i11 = h0.i(context, attributeSet, R.styleable.ForegroundLinearLayout, i10, 0, new int[0]);
        this.f٩١٨٧d = i11.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.f٩١٨٧d);
        Drawable drawable = i11.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f٩١٨٨e = i11.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        i11.recycle();
    }
}
