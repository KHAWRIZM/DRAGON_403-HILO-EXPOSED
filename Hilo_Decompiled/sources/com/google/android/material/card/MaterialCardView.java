package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.h0;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import f8.j;
import f8.o;
import f8.r;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialCardView extends CardView implements Checkable, r {

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f٨٥٧٨e = {R.attr.state_checkable};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f٨٥٧٩f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f٨٥٨٠g = {com.google.android.material.R.attr.state_dragged};

    /* renamed from: h, reason: collision with root package name */
    private static final int f٨٥٨١h = com.google.android.material.R.style.Widget_MaterialComponents_CardView;

    /* renamed from: a, reason: collision with root package name */
    private final c f٨٥٨٢a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٨٥٨٣b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٨٥٨٤c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٨٥٨٥d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface a {
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private void d() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f٨٥٨٢a.i();
        }
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f٨٥٨٢a.j().getBounds());
        return rectF;
    }

    public boolean f() {
        c cVar = this.f٨٥٨٢a;
        if (cVar != null && cVar.D()) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return this.f٨٥٨٥d;
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.f٨٥٨٢a.k();
    }

    public ColorStateList getCardForegroundColor() {
        return this.f٨٥٨٢a.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f٨٥٨٢a.m();
    }

    public int getCheckedIconGravity() {
        return this.f٨٥٨٢a.n();
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.f٨٥٨٢a.o();
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.f٨٥٨٢a.p();
    }

    public ColorStateList getCheckedIconTint() {
        return this.f٨٥٨٢a.q();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f٨٥٨٢a.A().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f٨٥٨٢a.A().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f٨٥٨٢a.A().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f٨٥٨٢a.A().top;
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float getProgress() {
        return this.f٨٥٨٢a.u();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f٨٥٨٢a.s();
    }

    public ColorStateList getRippleColor() {
        return this.f٨٥٨٢a.v();
    }

    @Override // f8.r
    public o getShapeAppearanceModel() {
        return this.f٨٥٨٢a.w();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f٨٥٨٢a.x();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f٨٥٨٢a.y();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.f٨٥٨٢a.z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i10, int i11, int i12, int i13) {
        super.setContentPadding(i10, i11, i12, i13);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f٨٥٨٤c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f٨٥٨٢a.e0();
        j.f(this, this.f٨٥٨٢a.j());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 3);
        if (f()) {
            View.mergeDrawableStates(onCreateDrawableState, f٨٥٧٨e);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f٨٥٧٩f);
        }
        if (g()) {
            View.mergeDrawableStates(onCreateDrawableState, f٨٥٨٠g);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(f());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f٨٥٨٢a.I(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f٨٥٨٣b) {
            if (!this.f٨٥٨٢a.C()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f٨٥٨٢a.J(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i10) {
        this.f٨٥٨٢a.K(ColorStateList.valueOf(i10));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f10) {
        super.setCardElevation(f10);
        this.f٨٥٨٢a.g0();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.f٨٥٨٢a.L(colorStateList);
    }

    public void setCheckable(boolean z10) {
        this.f٨٥٨٢a.M(z10);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.f٨٥٨٤c != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f٨٥٨٢a.P(drawable);
    }

    public void setCheckedIconGravity(int i10) {
        if (this.f٨٥٨٢a.n() != i10) {
            this.f٨٥٨٢a.Q(i10);
        }
    }

    public void setCheckedIconMargin(@Dimension int i10) {
        this.f٨٥٨٢a.R(i10);
    }

    public void setCheckedIconMarginResource(int i10) {
        if (i10 != -1) {
            this.f٨٥٨٢a.R(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconResource(int i10) {
        this.f٨٥٨٢a.P(r1.a.b(getContext(), i10));
    }

    public void setCheckedIconSize(@Dimension int i10) {
        this.f٨٥٨٢a.S(i10);
    }

    public void setCheckedIconSizeResource(int i10) {
        if (i10 != 0) {
            this.f٨٥٨٢a.S(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.f٨٥٨٢a.T(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        super.setClickable(z10);
        c cVar = this.f٨٥٨٢a;
        if (cVar != null) {
            cVar.e0();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i10, int i11, int i12, int i13) {
        this.f٨٥٨٢a.a0(i10, i11, i12, i13);
    }

    public void setDragged(boolean z10) {
        if (this.f٨٥٨٥d != z10) {
            this.f٨٥٨٥d = z10;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f10) {
        super.setMaxCardElevation(f10);
        this.f٨٥٨٢a.i0();
    }

    public void setOnCheckedChangeListener(a aVar) {
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        this.f٨٥٨٢a.i0();
        this.f٨٥٨٢a.f0();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f٨٥٨٢a.V(f10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f10) {
        super.setRadius(f10);
        this.f٨٥٨٢a.U(f10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f٨٥٨٢a.W(colorStateList);
    }

    public void setRippleColorResource(int i10) {
        this.f٨٥٨٢a.W(r1.a.a(getContext(), i10));
    }

    @Override // f8.r
    public void setShapeAppearanceModel(o oVar) {
        setClipToOutline(oVar.v(getBoundsAsRectF()));
        this.f٨٥٨٢a.X(oVar);
    }

    public void setStrokeColor(int i10) {
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeWidth(@Dimension int i10) {
        this.f٨٥٨٢a.Z(i10);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        this.f٨٥٨٢a.i0();
        this.f٨٥٨٢a.f0();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (f() && isEnabled()) {
            this.f٨٥٨٤c = !this.f٨٥٨٤c;
            refreshDrawableState();
            d();
            this.f٨٥٨٢a.O(this.f٨٥٨٤c, true);
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f٨٥٨٢a.K(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f٨٥٨٢a.Y(colorStateList);
        invalidate();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r6), attributeSet, i10);
        int i11 = f٨٥٨١h;
        this.f٨٥٨٤c = false;
        this.f٨٥٨٥d = false;
        this.f٨٥٨٣b = true;
        TypedArray i12 = h0.i(getContext(), attributeSet, com.google.android.material.R.styleable.MaterialCardView, i10, i11, new int[0]);
        c cVar = new c(this, attributeSet, i10, i11);
        this.f٨٥٨٢a = cVar;
        cVar.K(super.getCardBackgroundColor());
        cVar.a0(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        cVar.H(i12);
        i12.recycle();
    }
}
