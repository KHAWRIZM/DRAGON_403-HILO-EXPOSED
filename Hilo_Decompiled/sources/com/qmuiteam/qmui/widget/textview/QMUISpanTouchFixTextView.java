package com.qmuiteam.qmui.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import bc.d;
import com.qmuiteam.qmui.link.c;
import kc.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUISpanTouchFixTextView extends AppCompatTextView implements a, bc.a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f١٣٤٤٥a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٣٤٤٦b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٣٤٤٧c;

    /* renamed from: d, reason: collision with root package name */
    private d f١٣٤٤٨d;

    public QMUISpanTouchFixTextView(Context context) {
        this(context, null);
    }

    @Override // bc.a
    public void d(int i10) {
        this.f١٣٤٤٨d.d(i10);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f١٣٤٤٨d.p(canvas, getWidth(), getHeight());
        this.f١٣٤٤٨d.o(canvas);
    }

    @Override // bc.a
    public void f(int i10) {
        this.f١٣٤٤٨d.f(i10);
    }

    public int getHideRadiusSide() {
        return this.f١٣٤٤٨d.r();
    }

    public int getRadius() {
        return this.f١٣٤٤٨d.u();
    }

    public float getShadowAlpha() {
        return this.f١٣٤٤٨d.w();
    }

    @Override // android.widget.TextView
    public int getShadowColor() {
        return this.f١٣٤٤٨d.x();
    }

    public int getShadowElevation() {
        return this.f١٣٤٤٨d.y();
    }

    @Override // bc.a
    public void i(int i10) {
        this.f١٣٤٤٨d.i(i10);
    }

    @Override // bc.a
    public void j(int i10) {
        this.f١٣٤٤٨d.j(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(boolean z10) {
        super.setPressed(z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int t10 = this.f١٣٤٤٨d.t(i10);
        int s10 = this.f١٣٤٤٨d.s(i11);
        super.onMeasure(t10, s10);
        int A = this.f١٣٤٤٨d.A(t10, getMeasuredWidth());
        int z10 = this.f١٣٤٤٨d.z(s10, getMeasuredHeight());
        if (t10 != A || s10 != z10) {
            super.onMeasure(A, z10);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((getText() instanceof Spannable) && (getMovementMethod() instanceof c)) {
            this.f١٣٤٤٥a = true;
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (this.f١٣٤٤٧c) {
                return this.f١٣٤٤٥a;
            }
            return onTouchEvent;
        }
        this.f١٣٤٤٥a = false;
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (!this.f١٣٤٤٥a && !this.f١٣٤٤٧c) {
            return super.performClick();
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        if (!this.f١٣٤٤٥a && !this.f١٣٤٤٧c) {
            return super.performLongClick();
        }
        return false;
    }

    @Override // bc.a
    public void setBorderColor(int i10) {
        this.f١٣٤٤٨d.setBorderColor(i10);
        invalidate();
    }

    public void setBorderWidth(int i10) {
        this.f١٣٤٤٨d.E(i10);
        invalidate();
    }

    public void setBottomDividerAlpha(int i10) {
        this.f١٣٤٤٨d.F(i10);
        invalidate();
    }

    public void setHideRadiusSide(int i10) {
        this.f١٣٤٤٨d.G(i10);
        invalidate();
    }

    public void setLeftDividerAlpha(int i10) {
        this.f١٣٤٤٨d.H(i10);
        invalidate();
    }

    public void setMovementMethodCompat(MovementMethod movementMethod) {
        setMovementMethod(movementMethod);
        if (this.f١٣٤٤٧c) {
            setNeedForceEventToParent(true);
        }
    }

    public void setNeedForceEventToParent(boolean z10) {
        this.f١٣٤٤٧c = z10;
        setFocusable(!z10);
        setClickable(!z10);
        setLongClickable(!z10);
    }

    public void setOuterNormalColor(int i10) {
        this.f١٣٤٤٨d.I(i10);
    }

    public void setOutlineExcludePadding(boolean z10) {
        this.f١٣٤٤٨d.J(z10);
    }

    @Override // android.view.View
    public final void setPressed(boolean z10) {
        this.f١٣٤٤٦b = z10;
        if (!this.f١٣٤٤٥a) {
            k(z10);
        }
    }

    public void setRadius(int i10) {
        this.f١٣٤٤٨d.K(i10);
    }

    public void setRightDividerAlpha(int i10) {
        this.f١٣٤٤٨d.P(i10);
        invalidate();
    }

    public void setShadowAlpha(float f10) {
        this.f١٣٤٤٨d.Q(f10);
    }

    public void setShadowColor(int i10) {
        this.f١٣٤٤٨d.R(i10);
    }

    public void setShadowElevation(int i10) {
        this.f١٣٤٤٨d.T(i10);
    }

    public void setShowBorderOnlyBeforeL(boolean z10) {
        this.f١٣٤٤٨d.U(z10);
        invalidate();
    }

    public void setTopDividerAlpha(int i10) {
        this.f١٣٤٤٨d.V(i10);
        invalidate();
    }

    @Override // kc.a
    public void setTouchSpanHit(boolean z10) {
        if (this.f١٣٤٤٥a != z10) {
            this.f١٣٤٤٥a = z10;
            setPressed(this.f١٣٤٤٦b);
        }
    }

    public QMUISpanTouchFixTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUISpanTouchFixTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٤٤٦b = false;
        this.f١٣٤٤٧c = false;
        setHighlightColor(0);
        this.f١٣٤٤٨d = new d(context, attributeSet, i10, this);
    }
}
