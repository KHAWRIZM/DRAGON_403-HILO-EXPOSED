package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import bc.d;
import com.qmuiteam.qmui.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIRadiusImageView2 extends AppCompatImageView implements bc.a {

    /* renamed from: a, reason: collision with root package name */
    private d f١٣٠٣٧a;

    /* renamed from: b, reason: collision with root package name */
    private zb.a f١٣٠٣٨b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٣٠٣٩c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٣٠٤٠d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٣٠٤١e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٣٠٤٢f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٣٠٤٣g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٣٠٤٤h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٣٠٤٥i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٣٠٤٦j;

    /* renamed from: k, reason: collision with root package name */
    private ColorFilter f١٣٠٤٧k;

    /* renamed from: l, reason: collision with root package name */
    private ColorFilter f١٣٠٤٨l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٣٠٤٩m;

    public QMUIRadiusImageView2(Context context) {
        super(context);
        this.f١٣٠٣٩c = false;
        this.f١٣٠٤٠d = false;
        this.f١٣٠٤٦j = true;
        this.f١٣٠٤٩m = false;
        k(context, null, 0);
    }

    private zb.a getAlphaViewHelper() {
        if (this.f١٣٠٣٨b == null) {
            this.f١٣٠٣٨b = new zb.a(this);
        }
        return this.f١٣٠٣٨b;
    }

    private void k(Context context, AttributeSet attributeSet, int i10) {
        this.f١٣٠٣٧a = new d(context, attributeSet, i10, this);
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIRadiusImageView2, i10, 0);
        this.f١٣٠٤١e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRadiusImageView2_qmui_border_width, 0);
        this.f١٣٠٤٢f = obtainStyledAttributes.getColor(R.styleable.QMUIRadiusImageView2_qmui_border_color, -7829368);
        this.f١٣٠٤٣g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRadiusImageView2_qmui_selected_border_width, this.f١٣٠٤١e);
        this.f١٣٠٤٤h = obtainStyledAttributes.getColor(R.styleable.QMUIRadiusImageView2_qmui_selected_border_color, this.f١٣٠٤٢f);
        int color = obtainStyledAttributes.getColor(R.styleable.QMUIRadiusImageView2_qmui_selected_mask_color, 0);
        this.f١٣٠٤٥i = color;
        if (color != 0) {
            this.f١٣٠٤٨l = new PorterDuffColorFilter(this.f١٣٠٤٥i, PorterDuff.Mode.DARKEN);
        }
        this.f١٣٠٤٦j = obtainStyledAttributes.getBoolean(R.styleable.QMUIRadiusImageView2_qmui_is_touch_select_mode_enabled, true);
        boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.QMUIRadiusImageView2_qmui_is_circle, false);
        this.f١٣٠٣٩c = z10;
        if (!z10) {
            setRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRadiusImageView2_qmui_corner_radius, 0));
        }
        obtainStyledAttributes.recycle();
        this.f١٣٠٣٧a.E(this.f١٣٠٤١e);
        this.f١٣٠٣٧a.setBorderColor(this.f١٣٠٤٢f);
    }

    @Override // bc.a
    public void d(int i10) {
        this.f١٣٠٣٧a.d(i10);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f١٣٠٣٧a.p(canvas, getWidth(), getHeight());
        this.f١٣٠٣٧a.o(canvas);
    }

    @Override // bc.a
    public void f(int i10) {
        this.f١٣٠٣٧a.f(i10);
    }

    public int getBorderColor() {
        return this.f١٣٠٤٢f;
    }

    public int getBorderWidth() {
        return this.f١٣٠٤١e;
    }

    public int getCornerRadius() {
        return getRadius();
    }

    public int getHideRadiusSide() {
        return this.f١٣٠٣٧a.r();
    }

    public int getRadius() {
        return this.f١٣٠٣٧a.u();
    }

    public int getSelectedBorderColor() {
        return this.f١٣٠٤٤h;
    }

    public int getSelectedBorderWidth() {
        return this.f١٣٠٤٣g;
    }

    public int getSelectedMaskColor() {
        return this.f١٣٠٤٥i;
    }

    public float getShadowAlpha() {
        return this.f١٣٠٣٧a.w();
    }

    public int getShadowColor() {
        return this.f١٣٠٣٧a.x();
    }

    public int getShadowElevation() {
        return this.f١٣٠٣٧a.y();
    }

    @Override // bc.a
    public void i(int i10) {
        this.f١٣٠٣٧a.i(i10);
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.f١٣٠٤٠d;
    }

    @Override // bc.a
    public void j(int i10) {
        this.f١٣٠٣٧a.j(i10);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        int t10 = this.f١٣٠٣٧a.t(i10);
        int s10 = this.f١٣٠٣٧a.s(i11);
        super.onMeasure(t10, s10);
        int A = this.f١٣٠٣٧a.A(t10, getMeasuredWidth());
        int z10 = this.f١٣٠٣٧a.z(s10, getMeasuredHeight());
        if (t10 != A || s10 != z10) {
            super.onMeasure(A, z10);
        }
        if (this.f١٣٠٣٩c) {
            int measuredHeight = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            int i12 = measuredWidth / 2;
            if (measuredHeight != measuredWidth) {
                int min = Math.min(measuredHeight, measuredWidth);
                i12 = min / 2;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
                super.onMeasure(makeMeasureSpec, makeMeasureSpec);
            }
            setRadius(i12);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isClickable()) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.f١٣٠٤٦j) {
            this.f١٣٠٤٩m = true;
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3 || action == 4 || action == 8) {
                    setSelected(false);
                }
            } else {
                setSelected(true);
            }
            this.f١٣٠٤٩m = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // bc.a
    public void setBorderColor(int i10) {
        if (this.f١٣٠٤٢f != i10) {
            this.f١٣٠٤٢f = i10;
            if (!this.f١٣٠٤٠d) {
                this.f١٣٠٣٧a.setBorderColor(i10);
                invalidate();
            }
        }
    }

    public void setBorderWidth(int i10) {
        if (this.f١٣٠٤١e != i10) {
            this.f١٣٠٤١e = i10;
            if (!this.f١٣٠٤٠d) {
                this.f١٣٠٣٧a.E(i10);
                invalidate();
            }
        }
    }

    public void setBottomDividerAlpha(int i10) {
        this.f١٣٠٣٧a.F(i10);
        invalidate();
    }

    public void setChangeAlphaWhenDisable(boolean z10) {
        getAlphaViewHelper().c(z10);
    }

    public void setChangeAlphaWhenPress(boolean z10) {
        getAlphaViewHelper().d(z10);
    }

    public void setCircle(boolean z10) {
        if (this.f١٣٠٣٩c != z10) {
            this.f١٣٠٣٩c = z10;
            requestLayout();
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f١٣٠٤٧k == colorFilter) {
            return;
        }
        this.f١٣٠٤٧k = colorFilter;
        if (!this.f١٣٠٤٠d) {
            super.setColorFilter(colorFilter);
        }
    }

    public void setCornerRadius(int i10) {
        setRadius(i10);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        getAlphaViewHelper().a(this, z10);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i10, int i11, int i12, int i13) {
        return super.setFrame(i10, i11, i12, i13);
    }

    public void setHideRadiusSide(int i10) {
        this.f١٣٠٣٧a.G(i10);
    }

    public void setLeftDividerAlpha(int i10) {
        this.f١٣٠٣٧a.H(i10);
        invalidate();
    }

    public void setOuterNormalColor(int i10) {
        this.f١٣٠٣٧a.I(i10);
    }

    public void setOutlineExcludePadding(boolean z10) {
        this.f١٣٠٣٧a.J(z10);
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        super.setPressed(z10);
        getAlphaViewHelper().b(this, z10);
    }

    public void setRadius(int i10) {
        this.f١٣٠٣٧a.K(i10);
    }

    public void setRightDividerAlpha(int i10) {
        this.f١٣٠٣٧a.P(i10);
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z10) {
        int i10;
        int i11;
        if (!this.f١٣٠٤٩m) {
            super.setSelected(z10);
        }
        if (this.f١٣٠٤٠d != z10) {
            this.f١٣٠٤٠d = z10;
            if (z10) {
                super.setColorFilter(this.f١٣٠٤٨l);
            } else {
                super.setColorFilter(this.f١٣٠٤٧k);
            }
            boolean z11 = this.f١٣٠٤٠d;
            if (z11) {
                i10 = this.f١٣٠٤٣g;
            } else {
                i10 = this.f١٣٠٤١e;
            }
            if (z11) {
                i11 = this.f١٣٠٤٤h;
            } else {
                i11 = this.f١٣٠٤٢f;
            }
            this.f١٣٠٣٧a.E(i10);
            this.f١٣٠٣٧a.setBorderColor(i11);
            invalidate();
        }
    }

    public void setSelectedBorderColor(int i10) {
        if (this.f١٣٠٤٤h != i10) {
            this.f١٣٠٤٤h = i10;
            if (this.f١٣٠٤٠d) {
                this.f١٣٠٣٧a.setBorderColor(i10);
                invalidate();
            }
        }
    }

    public void setSelectedBorderWidth(int i10) {
        if (this.f١٣٠٤٣g != i10) {
            this.f١٣٠٤٣g = i10;
            if (this.f١٣٠٤٠d) {
                this.f١٣٠٣٧a.E(i10);
                invalidate();
            }
        }
    }

    public void setSelectedColorFilter(ColorFilter colorFilter) {
        if (this.f١٣٠٤٨l == colorFilter) {
            return;
        }
        this.f١٣٠٤٨l = colorFilter;
        if (this.f١٣٠٤٠d) {
            super.setColorFilter(colorFilter);
        }
    }

    public void setSelectedMaskColor(int i10) {
        if (this.f١٣٠٤٥i != i10) {
            this.f١٣٠٤٥i = i10;
            if (i10 != 0) {
                this.f١٣٠٤٨l = new PorterDuffColorFilter(this.f١٣٠٤٥i, PorterDuff.Mode.DARKEN);
            } else {
                this.f١٣٠٤٨l = null;
            }
            if (this.f١٣٠٤٠d) {
                invalidate();
            }
        }
        this.f١٣٠٤٥i = i10;
    }

    public void setShadowAlpha(float f10) {
        this.f١٣٠٣٧a.Q(f10);
    }

    public void setShadowColor(int i10) {
        this.f١٣٠٣٧a.R(i10);
    }

    public void setShadowElevation(int i10) {
        this.f١٣٠٣٧a.T(i10);
    }

    public void setShowBorderOnlyBeforeL(boolean z10) {
        this.f١٣٠٣٧a.U(z10);
        invalidate();
    }

    public void setTopDividerAlpha(int i10) {
        this.f١٣٠٣٧a.V(i10);
        invalidate();
    }

    public void setTouchSelectModeEnabled(boolean z10) {
        this.f١٣٠٤٦j = z10;
    }

    public QMUIRadiusImageView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣٠٣٩c = false;
        this.f١٣٠٤٠d = false;
        this.f١٣٠٤٦j = true;
        this.f١٣٠٤٩m = false;
        k(context, attributeSet, 0);
    }

    public QMUIRadiusImageView2(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٠٣٩c = false;
        this.f١٣٠٤٠d = false;
        this.f١٣٠٤٦j = true;
        this.f١٣٠٤٩m = false;
        k(context, attributeSet, i10);
    }
}
