package com.google.android.material.materialswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.p0;
import androidx.core.graphics.x;
import com.google.android.material.R;
import com.google.android.material.drawable.g;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import r1.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialSwitch extends SwitchCompat {

    /* renamed from: k0, reason: collision with root package name */
    private static final int f٩٤٠٣k0 = R.style.Widget_Material3_CompoundButton_MaterialSwitch;

    /* renamed from: l0, reason: collision with root package name */
    private static final int[] f٩٤٠٤l0 = {R.attr.state_with_icon};
    private Drawable U;
    private Drawable V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private Drawable f٩٤٠٥a0;

    /* renamed from: b0, reason: collision with root package name */
    private Drawable f٩٤٠٦b0;

    /* renamed from: c0, reason: collision with root package name */
    private ColorStateList f٩٤٠٧c0;

    /* renamed from: d0, reason: collision with root package name */
    private ColorStateList f٩٤٠٨d0;

    /* renamed from: e0, reason: collision with root package name */
    private PorterDuff.Mode f٩٤٠٩e0;

    /* renamed from: f0, reason: collision with root package name */
    private ColorStateList f٩٤١٠f0;

    /* renamed from: g0, reason: collision with root package name */
    private ColorStateList f٩٤١١g0;

    /* renamed from: h0, reason: collision with root package name */
    private PorterDuff.Mode f٩٤١٢h0;

    /* renamed from: i0, reason: collision with root package name */
    private int[] f٩٤١٣i0;

    /* renamed from: j0, reason: collision with root package name */
    private int[] f٩٤١٤j0;

    public MaterialSwitch(Context context) {
        this(context, null);
    }

    private void r() {
        this.U = g.c(this.U, this.f٩٤٠٧c0, getThumbTintMode());
        this.V = g.c(this.V, this.f٩٤٠٨d0, this.f٩٤٠٩e0);
        u();
        Drawable drawable = this.U;
        Drawable drawable2 = this.V;
        int i10 = this.W;
        super.setThumbDrawable(g.b(drawable, drawable2, i10, i10));
        refreshDrawableState();
    }

    private void s() {
        this.f٩٤٠٥a0 = g.c(this.f٩٤٠٥a0, this.f٩٤١٠f0, getTrackTintMode());
        this.f٩٤٠٦b0 = g.c(this.f٩٤٠٦b0, this.f٩٤١١g0, this.f٩٤١٢h0);
        u();
        Drawable drawable = this.f٩٤٠٥a0;
        if (drawable != null && this.f٩٤٠٦b0 != null) {
            drawable = new LayerDrawable(new Drawable[]{this.f٩٤٠٥a0, this.f٩٤٠٦b0});
        } else if (drawable == null) {
            drawable = this.f٩٤٠٦b0;
        }
        if (drawable != null) {
            setSwitchMinWidth(drawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(drawable);
    }

    private static void t(Drawable drawable, ColorStateList colorStateList, int[] iArr, int[] iArr2, float f10) {
        if (drawable != null && colorStateList != null) {
            drawable.setTint(x.c(colorStateList.getColorForState(iArr, 0), colorStateList.getColorForState(iArr2, 0), f10));
        }
    }

    private void u() {
        if (this.f٩٤٠٧c0 == null && this.f٩٤٠٨d0 == null && this.f٩٤١٠f0 == null && this.f٩٤١١g0 == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.f٩٤٠٧c0;
        if (colorStateList != null) {
            t(this.U, colorStateList, this.f٩٤١٣i0, this.f٩٤١٤j0, thumbPosition);
        }
        ColorStateList colorStateList2 = this.f٩٤٠٨d0;
        if (colorStateList2 != null) {
            t(this.V, colorStateList2, this.f٩٤١٣i0, this.f٩٤١٤j0, thumbPosition);
        }
        ColorStateList colorStateList3 = this.f٩٤١٠f0;
        if (colorStateList3 != null) {
            t(this.f٩٤٠٥a0, colorStateList3, this.f٩٤١٣i0, this.f٩٤١٤j0, thumbPosition);
        }
        ColorStateList colorStateList4 = this.f٩٤١١g0;
        if (colorStateList4 != null) {
            t(this.f٩٤٠٦b0, colorStateList4, this.f٩٤١٣i0, this.f٩٤١٤j0, thumbPosition);
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getThumbDrawable() {
        return this.U;
    }

    public Drawable getThumbIconDrawable() {
        return this.V;
    }

    public int getThumbIconSize() {
        return this.W;
    }

    public ColorStateList getThumbIconTintList() {
        return this.f٩٤٠٨d0;
    }

    public PorterDuff.Mode getThumbIconTintMode() {
        return this.f٩٤٠٩e0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getThumbTintList() {
        return this.f٩٤٠٧c0;
    }

    public Drawable getTrackDecorationDrawable() {
        return this.f٩٤٠٦b0;
    }

    public ColorStateList getTrackDecorationTintList() {
        return this.f٩٤١١g0;
    }

    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.f٩٤١٢h0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getTrackDrawable() {
        return this.f٩٤٠٥a0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getTrackTintList() {
        return this.f٩٤١٠f0;
    }

    @Override // android.view.View
    public void invalidate() {
        u();
        super.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (this.V != null) {
            View.mergeDrawableStates(onCreateDrawableState, f٩٤٠٤l0);
        }
        this.f٩٤١٣i0 = g.j(onCreateDrawableState);
        this.f٩٤١٤j0 = g.f(onCreateDrawableState);
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(Drawable drawable) {
        this.U = drawable;
        r();
    }

    public void setThumbIconDrawable(Drawable drawable) {
        this.V = drawable;
        r();
    }

    public void setThumbIconResource(int i10) {
        setThumbIconDrawable(a.b(getContext(), i10));
    }

    public void setThumbIconSize(int i10) {
        if (this.W != i10) {
            this.W = i10;
            r();
        }
    }

    public void setThumbIconTintList(ColorStateList colorStateList) {
        this.f٩٤٠٨d0 = colorStateList;
        r();
    }

    public void setThumbIconTintMode(PorterDuff.Mode mode) {
        this.f٩٤٠٩e0 = mode;
        r();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(ColorStateList colorStateList) {
        this.f٩٤٠٧c0 = colorStateList;
        r();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        r();
    }

    public void setTrackDecorationDrawable(Drawable drawable) {
        this.f٩٤٠٦b0 = drawable;
        s();
    }

    public void setTrackDecorationResource(int i10) {
        setTrackDecorationDrawable(a.b(getContext(), i10));
    }

    public void setTrackDecorationTintList(ColorStateList colorStateList) {
        this.f٩٤١١g0 = colorStateList;
        s();
    }

    public void setTrackDecorationTintMode(PorterDuff.Mode mode) {
        this.f٩٤١٢h0 = mode;
        s();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(Drawable drawable) {
        this.f٩٤٠٥a0 = drawable;
        s();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(ColorStateList colorStateList) {
        this.f٩٤١٠f0 = colorStateList;
        s();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        s();
    }

    public MaterialSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSwitchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialSwitch(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f٩٤٠٣k0;
        this.W = -1;
        Context context2 = getContext();
        this.U = super.getThumbDrawable();
        this.f٩٤٠٧c0 = super.getThumbTintList();
        super.setThumbTintList(null);
        this.f٩٤٠٥a0 = super.getTrackDrawable();
        this.f٩٤١٠f0 = super.getTrackTintList();
        super.setTrackTintList(null);
        p0 j10 = h0.j(context2, attributeSet, R.styleable.MaterialSwitch, i10, i11, new int[0]);
        this.V = j10.g(R.styleable.MaterialSwitch_thumbIcon);
        this.W = j10.f(R.styleable.MaterialSwitch_thumbIconSize, -1);
        this.f٩٤٠٨d0 = j10.c(R.styleable.MaterialSwitch_thumbIconTint);
        int k10 = j10.k(R.styleable.MaterialSwitch_thumbIconTintMode, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f٩٤٠٩e0 = k0.o(k10, mode);
        this.f٩٤٠٦b0 = j10.g(R.styleable.MaterialSwitch_trackDecoration);
        this.f٩٤١١g0 = j10.c(R.styleable.MaterialSwitch_trackDecorationTint);
        this.f٩٤١٢h0 = k0.o(j10.k(R.styleable.MaterialSwitch_trackDecorationTintMode, -1), mode);
        j10.x();
        setEnforceSwitchWidth(false);
        r();
        s();
    }
}
