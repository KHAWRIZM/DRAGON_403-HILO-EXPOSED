package com.qmuiteam.qmui.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import bc.a;
import bc.d;
import com.qmuiteam.qmui.alpha.QMUIAlphaButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class QMUIButton extends QMUIAlphaButton implements a {

    /* renamed from: b, reason: collision with root package name */
    private d f١٢٧١٤b;

    public QMUIButton(Context context) {
        super(context);
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i10) {
        this.f١٢٧١٤b = new d(context, attributeSet, i10, this);
        setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenPress(false);
    }

    @Override // bc.a
    public void d(int i10) {
        this.f١٢٧١٤b.d(i10);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f١٢٧١٤b.p(canvas, getWidth(), getHeight());
        this.f١٢٧١٤b.o(canvas);
    }

    @Override // bc.a
    public void f(int i10) {
        this.f١٢٧١٤b.f(i10);
    }

    public int getHideRadiusSide() {
        return this.f١٢٧١٤b.r();
    }

    public int getRadius() {
        return this.f١٢٧١٤b.u();
    }

    public float getShadowAlpha() {
        return this.f١٢٧١٤b.w();
    }

    @Override // android.widget.TextView
    public int getShadowColor() {
        return this.f١٢٧١٤b.x();
    }

    public int getShadowElevation() {
        return this.f١٢٧١٤b.y();
    }

    @Override // bc.a
    public void i(int i10) {
        this.f١٢٧١٤b.i(i10);
    }

    @Override // bc.a
    public void j(int i10) {
        this.f١٢٧١٤b.j(i10);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i10, int i11) {
        int t10 = this.f١٢٧١٤b.t(i10);
        int s10 = this.f١٢٧١٤b.s(i11);
        super.onMeasure(t10, s10);
        int A = this.f١٢٧١٤b.A(t10, getMeasuredWidth());
        int z10 = this.f١٢٧١٤b.z(s10, getMeasuredHeight());
        if (t10 != A || s10 != z10) {
            super.onMeasure(A, z10);
        }
    }

    @Override // bc.a
    public void setBorderColor(int i10) {
        this.f١٢٧١٤b.setBorderColor(i10);
        invalidate();
    }

    public void setBorderWidth(int i10) {
        this.f١٢٧١٤b.E(i10);
        invalidate();
    }

    public void setBottomDividerAlpha(int i10) {
        this.f١٢٧١٤b.F(i10);
        invalidate();
    }

    public void setHideRadiusSide(int i10) {
        this.f١٢٧١٤b.G(i10);
        invalidate();
    }

    public void setLeftDividerAlpha(int i10) {
        this.f١٢٧١٤b.H(i10);
        invalidate();
    }

    public void setOuterNormalColor(int i10) {
        this.f١٢٧١٤b.I(i10);
    }

    public void setOutlineExcludePadding(boolean z10) {
        this.f١٢٧١٤b.J(z10);
    }

    public void setRadius(int i10) {
        this.f١٢٧١٤b.K(i10);
    }

    public void setRightDividerAlpha(int i10) {
        this.f١٢٧١٤b.P(i10);
        invalidate();
    }

    public void setShadowAlpha(float f10) {
        this.f١٢٧١٤b.Q(f10);
    }

    public void setShadowColor(int i10) {
        this.f١٢٧١٤b.R(i10);
    }

    public void setShadowElevation(int i10) {
        this.f١٢٧١٤b.T(i10);
    }

    public void setShowBorderOnlyBeforeL(boolean z10) {
        this.f١٢٧١٤b.U(z10);
        invalidate();
    }

    public void setTopDividerAlpha(int i10) {
        this.f١٢٧١٤b.V(i10);
        invalidate();
    }

    public QMUIButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public QMUIButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet, i10);
    }
}
