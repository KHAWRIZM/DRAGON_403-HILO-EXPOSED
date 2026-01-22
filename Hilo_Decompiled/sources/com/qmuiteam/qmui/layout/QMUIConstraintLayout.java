package com.qmuiteam.qmui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import bc.a;
import bc.d;
import com.qmuiteam.qmui.alpha.QMUIAlphaConstraintLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class QMUIConstraintLayout extends QMUIAlphaConstraintLayout implements a {

    /* renamed from: b, reason: collision with root package name */
    private d f١٢٧١٥b;

    public QMUIConstraintLayout(Context context) {
        super(context);
        n(context, null, 0);
    }

    private void n(Context context, AttributeSet attributeSet, int i10) {
        this.f١٢٧١٥b = new d(context, attributeSet, i10, this);
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
    }

    @Override // bc.a
    public void d(int i10) {
        this.f١٢٧١٥b.d(i10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
            this.f١٢٧١٥b.p(canvas, getWidth(), getHeight());
            this.f١٢٧١٥b.o(canvas);
        } catch (Throwable unused) {
        }
    }

    @Override // bc.a
    public void f(int i10) {
        this.f١٢٧١٥b.f(i10);
    }

    public int getHideRadiusSide() {
        return this.f١٢٧١٥b.r();
    }

    public int getRadius() {
        return this.f١٢٧١٥b.u();
    }

    public float getShadowAlpha() {
        return this.f١٢٧١٥b.w();
    }

    public int getShadowColor() {
        return this.f١٢٧١٥b.x();
    }

    public int getShadowElevation() {
        return this.f١٢٧١٥b.y();
    }

    @Override // bc.a
    public void i(int i10) {
        this.f١٢٧١٥b.i(i10);
    }

    @Override // bc.a
    public void j(int i10) {
        this.f١٢٧١٥b.j(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int t10 = this.f١٢٧١٥b.t(i10);
        int s10 = this.f١٢٧١٥b.s(i11);
        super.onMeasure(t10, s10);
        int A = this.f١٢٧١٥b.A(t10, getMeasuredWidth());
        int z10 = this.f١٢٧١٥b.z(s10, getMeasuredHeight());
        if (t10 != A || s10 != z10) {
            super.onMeasure(A, z10);
        }
    }

    @Override // bc.a
    public void setBorderColor(int i10) {
        this.f١٢٧١٥b.setBorderColor(i10);
        invalidate();
    }

    public void setBorderWidth(int i10) {
        this.f١٢٧١٥b.E(i10);
        invalidate();
    }

    public void setBottomDividerAlpha(int i10) {
        this.f١٢٧١٥b.F(i10);
        invalidate();
    }

    public void setHideRadiusSide(int i10) {
        this.f١٢٧١٥b.G(i10);
    }

    public void setLeftDividerAlpha(int i10) {
        this.f١٢٧١٥b.H(i10);
        invalidate();
    }

    public void setOuterNormalColor(int i10) {
        this.f١٢٧١٥b.I(i10);
    }

    public void setOutlineExcludePadding(boolean z10) {
        this.f١٢٧١٥b.J(z10);
    }

    public void setRadius(int i10) {
        this.f١٢٧١٥b.K(i10);
    }

    public void setRightDividerAlpha(int i10) {
        this.f١٢٧١٥b.P(i10);
        invalidate();
    }

    public void setShadowAlpha(float f10) {
        this.f١٢٧١٥b.Q(f10);
    }

    public void setShadowColor(int i10) {
        this.f١٢٧١٥b.R(i10);
    }

    public void setShadowElevation(int i10) {
        this.f١٢٧١٥b.T(i10);
    }

    public void setShowBorderOnlyBeforeL(boolean z10) {
        this.f١٢٧١٥b.U(z10);
        invalidate();
    }

    public void setTopDividerAlpha(int i10) {
        this.f١٢٧١٥b.V(i10);
        invalidate();
    }

    public QMUIConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context, attributeSet, 0);
    }

    public QMUIConstraintLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        n(context, attributeSet, i10);
    }
}
