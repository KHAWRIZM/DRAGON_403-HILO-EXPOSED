package com.qmuiteam.qmui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import bc.a;
import bc.d;
import com.qmuiteam.qmui.alpha.QMUIAlphaFrameLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class QMUIFrameLayout extends QMUIAlphaFrameLayout implements a {

    /* renamed from: b, reason: collision with root package name */
    private d f١٢٧١٦b;

    public QMUIFrameLayout(Context context) {
        super(context);
        b(context, null, 0);
    }

    private void b(Context context, AttributeSet attributeSet, int i10) {
        this.f١٢٧١٦b = new d(context, attributeSet, i10, this);
        setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenPress(false);
    }

    @Override // bc.a
    public void d(int i10) {
        this.f١٢٧١٦b.d(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f١٢٧١٦b.p(canvas, getWidth(), getHeight());
        this.f١٢٧١٦b.o(canvas);
    }

    @Override // bc.a
    public void f(int i10) {
        this.f١٢٧١٦b.f(i10);
    }

    public int getHideRadiusSide() {
        return this.f١٢٧١٦b.r();
    }

    public int getRadius() {
        return this.f١٢٧١٦b.u();
    }

    public float getShadowAlpha() {
        return this.f١٢٧١٦b.w();
    }

    public int getShadowColor() {
        return this.f١٢٧١٦b.x();
    }

    public int getShadowElevation() {
        return this.f١٢٧١٦b.y();
    }

    @Override // bc.a
    public void i(int i10) {
        this.f١٢٧١٦b.i(i10);
    }

    @Override // bc.a
    public void j(int i10) {
        this.f١٢٧١٦b.j(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int t10 = this.f١٢٧١٦b.t(i10);
        int s10 = this.f١٢٧١٦b.s(i11);
        super.onMeasure(t10, s10);
        int A = this.f١٢٧١٦b.A(t10, getMeasuredWidth());
        int z10 = this.f١٢٧١٦b.z(s10, getMeasuredHeight());
        if (t10 != A || s10 != z10) {
            super.onMeasure(A, z10);
        }
    }

    @Override // bc.a
    public void setBorderColor(int i10) {
        this.f١٢٧١٦b.setBorderColor(i10);
        invalidate();
    }

    public void setBorderWidth(int i10) {
        this.f١٢٧١٦b.E(i10);
        invalidate();
    }

    public void setBottomDividerAlpha(int i10) {
        this.f١٢٧١٦b.F(i10);
        invalidate();
    }

    public void setHideRadiusSide(int i10) {
        this.f١٢٧١٦b.G(i10);
    }

    public void setLeftDividerAlpha(int i10) {
        this.f١٢٧١٦b.H(i10);
        invalidate();
    }

    public void setOuterNormalColor(int i10) {
        this.f١٢٧١٦b.I(i10);
    }

    public void setOutlineExcludePadding(boolean z10) {
        this.f١٢٧١٦b.J(z10);
    }

    public void setRadius(int i10) {
        this.f١٢٧١٦b.K(i10);
    }

    public void setRightDividerAlpha(int i10) {
        this.f١٢٧١٦b.P(i10);
        invalidate();
    }

    public void setShadowAlpha(float f10) {
        this.f١٢٧١٦b.Q(f10);
    }

    public void setShadowColor(int i10) {
        this.f١٢٧١٦b.R(i10);
    }

    public void setShadowElevation(int i10) {
        this.f١٢٧١٦b.T(i10);
    }

    public void setShowBorderOnlyBeforeL(boolean z10) {
        this.f١٢٧١٦b.U(z10);
        invalidate();
    }

    public void setTopDividerAlpha(int i10) {
        this.f١٢٧١٦b.V(i10);
        invalidate();
    }

    public QMUIFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet, 0);
    }

    public QMUIFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b(context, attributeSet, i10);
    }
}
