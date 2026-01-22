package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.d1;
import c8.e;
import c8.g;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.a;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.j;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import f8.r;
import java.util.List;
import m2.g0;
import p7.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC٠١٠٩a, r, j {

    /* renamed from: e, reason: collision with root package name */
    private com.google.android.material.chip.a f٨٧٢٤e;

    /* renamed from: f, reason: collision with root package name */
    private InsetDrawable f٨٧٢٥f;

    /* renamed from: g, reason: collision with root package name */
    private RippleDrawable f٨٧٢٦g;

    /* renamed from: h, reason: collision with root package name */
    private View.OnClickListener f٨٧٢٧h;

    /* renamed from: i, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f٨٧٢٨i;

    /* renamed from: j, reason: collision with root package name */
    private j.a f٨٧٢٩j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f٨٧٣٠k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٨٧٣١l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٨٧٣٢m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f٨٧٣٣n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٨٧٣٤o;

    /* renamed from: p, reason: collision with root package name */
    private int f٨٧٣٥p;

    /* renamed from: q, reason: collision with root package name */
    private int f٨٧٣٦q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f٨٧٣٧r;

    /* renamed from: s, reason: collision with root package name */
    private final c f٨٧٣٨s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f٨٧٣٩t;

    /* renamed from: u, reason: collision with root package name */
    private final Rect f٨٧٤٠u;

    /* renamed from: v, reason: collision with root package name */
    private final RectF f٨٧٤١v;

    /* renamed from: w, reason: collision with root package name */
    private final g f٨٧٤٢w;

    /* renamed from: x, reason: collision with root package name */
    private static final int f٨٧٢١x = R.style.Widget_MaterialComponents_Chip_Action;

    /* renamed from: y, reason: collision with root package name */
    private static final Rect f٨٧٢٢y = new Rect();

    /* renamed from: z, reason: collision with root package name */
    private static final int[] f٨٧٢٣z = {android.R.attr.state_selected};
    private static final int[] A = {android.R.attr.state_checkable};

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends g {
        a() {
        }

        @Override // c8.g
        public void a(int i10) {
        }

        @Override // c8.g
        public void b(Typeface typeface, boolean z10) {
            CharSequence text;
            Chip chip = Chip.this;
            if (chip.f٨٧٢٤e.e3()) {
                text = Chip.this.f٨٧٢٤e.y1();
            } else {
                text = Chip.this.getText();
            }
            chip.setText(text);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f٨٧٢٤e != null) {
                Chip.this.f٨٧٢٤e.getOutline(outline);
            } else {
                outline.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c extends s2.a {
        c(Chip chip) {
            super(chip);
        }

        @Override // s2.a
        protected boolean A(int i10, int i11, Bundle bundle) {
            if (i11 == 16) {
                if (i10 == 0) {
                    return Chip.this.performClick();
                }
                if (i10 == 1) {
                    return Chip.this.u();
                }
                return false;
            }
            return false;
        }

        @Override // s2.a
        protected void D(g0 g0Var) {
            g0Var.m0(Chip.this.r());
            g0Var.p0(Chip.this.isClickable());
            g0Var.o0(Chip.this.getAccessibilityClassName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                g0Var.R0(text);
            } else {
                g0Var.s0(text);
            }
        }

        @Override // s2.a
        protected void E(int i10, g0 g0Var) {
            CharSequence charSequence = "";
            if (i10 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    g0Var.s0(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i11 = R.string.mtrl_chip_close_icon_content_description;
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    g0Var.s0(context.getString(i11, charSequence).trim());
                }
                g0Var.j0(Chip.this.getCloseIconTouchBoundsInt());
                g0Var.b(g0.a.f١٥٩٣٠i);
                g0Var.u0(Chip.this.isEnabled());
                g0Var.o0(Button.class.getName());
                return;
            }
            g0Var.s0("");
            g0Var.j0(Chip.f٨٧٢٢y);
        }

        @Override // s2.a
        protected void F(int i10, boolean z10) {
            if (i10 == 1) {
                Chip.this.f٨٧٣٣n = z10;
            }
            if (Chip.this.f٨٧٢٤e.O1(Chip.this.f٨٧٣٣n)) {
                Chip.this.refreshDrawableState();
            }
        }

        @Override // s2.a
        protected int q(float f10, float f11) {
            if (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f10, f11)) {
                return 1;
            }
            return 0;
        }

        @Override // s2.a
        protected void r(List list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f٨٧٢٧h != null) {
                list.add(1);
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    private void A() {
        this.f٨٧٢٦g = new RippleDrawable(d8.a.e(this.f٨٧٢٤e.w1()), getBackgroundDrawable(), null);
        this.f٨٧٢٤e.d3(false);
        setBackground(this.f٨٧٢٦g);
        B();
    }

    private void B() {
        com.google.android.material.chip.a aVar;
        if (!TextUtils.isEmpty(getText()) && (aVar = this.f٨٧٢٤e) != null) {
            int a12 = (int) (aVar.a1() + this.f٨٧٢٤e.A1() + this.f٨٧٢٤e.H0());
            int f12 = (int) (this.f٨٧٢٤e.f1() + this.f٨٧٢٤e.B1() + this.f٨٧٢٤e.D0());
            if (this.f٨٧٢٥f != null) {
                Rect rect = new Rect();
                this.f٨٧٢٥f.getPadding(rect);
                f12 += rect.left;
                a12 += rect.right;
            }
            setPaddingRelative(f12, getPaddingTop(), a12, getPaddingBottom());
        }
    }

    private void C() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        e textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.p(getContext(), paint, this.f٨٧٤٢w);
        }
    }

    private void D(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                        if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                                Log.w("Chip", "Chip text must be vertically center and start aligned");
                                return;
                            }
                            return;
                        }
                        throw new UnsupportedOperationException("Chip does not support multi-line text");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f٨٧٤١v.setEmpty();
        if (n() && this.f٨٧٢٧h != null) {
            this.f٨٧٢٤e.p1(this.f٨٧٤١v);
        }
        return this.f٨٧٤١v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f٨٧٤٠u.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f٨٧٤٠u;
    }

    private e getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.z1();
        }
        return null;
    }

    private void k(com.google.android.material.chip.a aVar) {
        aVar.H2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    private int[] l() {
        ?? isEnabled = isEnabled();
        int i10 = isEnabled;
        if (this.f٨٧٣٣n) {
            i10 = isEnabled + 1;
        }
        int i11 = i10;
        if (this.f٨٧٣٢m) {
            i11 = i10 + 1;
        }
        int i12 = i11;
        if (this.f٨٧٣١l) {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (isChecked()) {
            i13 = i12 + 1;
        }
        int[] iArr = new int[i13];
        int i14 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i14 = 1;
        }
        if (this.f٨٧٣٣n) {
            iArr[i14] = 16842908;
            i14++;
        }
        if (this.f٨٧٣٢m) {
            iArr[i14] = 16843623;
            i14++;
        }
        if (this.f٨٧٣١l) {
            iArr[i14] = 16842919;
            i14++;
        }
        if (isChecked()) {
            iArr[i14] = 16842913;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null && aVar.i1() != null) {
            return true;
        }
        return false;
    }

    private void o(Context context, AttributeSet attributeSet, int i10) {
        TypedArray i11 = h0.i(context, attributeSet, R.styleable.Chip, i10, f٨٧٢١x, new int[0]);
        this.f٨٧٣٤o = i11.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.f٨٧٣٦q = (int) Math.ceil(i11.getDimension(R.styleable.Chip_chipMinTouchTargetSize, c8.b.e(context)));
        i11.recycle();
    }

    private void p() {
        setOutlineProvider(new b());
    }

    private void q(int i10, int i11, int i12, int i13) {
        this.f٨٧٢٥f = new InsetDrawable((Drawable) this.f٨٧٢٤e, i10, i11, i12, i13);
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.f٨٧٣٢m != z10) {
            this.f٨٧٣٢m = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.f٨٧٣١l != z10) {
            this.f٨٧٣١l = z10;
            refreshDrawableState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(CompoundButton compoundButton, boolean z10) {
        j.a aVar = this.f٨٧٢٩j;
        if (aVar != null) {
            aVar.a(this, z10);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f٨٧٢٨i;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z10);
        }
    }

    private void v() {
        if (this.f٨٧٢٥f != null) {
            this.f٨٧٢٥f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            z();
        }
    }

    private void x(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.H2(null);
        }
    }

    private void y() {
        if (n() && s() && this.f٨٧٢٧h != null) {
            d1.q0(this, this.f٨٧٣٨s);
            this.f٨٧٣٩t = true;
        } else {
            d1.q0(this, null);
            this.f٨٧٣٩t = false;
        }
    }

    private void z() {
        A();
    }

    @Override // com.google.android.material.chip.a.InterfaceC٠١٠٩a
    public void a() {
        m(this.f٨٧٣٦q);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.f٨٧٣٩t) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (!this.f٨٧٣٨s.k(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f٨٧٣٩t) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.f٨٧٣٨s.l(keyEvent) && this.f٨٧٣٨s.p() != Integer.MIN_VALUE) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        boolean z10;
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null && aVar.G1()) {
            z10 = this.f٨٧٢٤e.D2(l());
        } else {
            z10 = false;
        }
        if (z10) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f٨٧٣٧r)) {
            return this.f٨٧٣٧r;
        }
        if (r()) {
            ViewParent parent = getParent();
            if (!(parent instanceof ChipGroup) || !((ChipGroup) parent).i()) {
                return "android.widget.Button";
            }
            return "android.widget.RadioButton";
        }
        if (isClickable()) {
            return "android.widget.Button";
        }
        return "android.view.View";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f٨٧٢٥f;
        if (insetDrawable == null) {
            return this.f٨٧٢٤e;
        }
        return insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.W0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.X0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.Y0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return Math.max(DownloadProgress.UNKNOWN_PROGRESS, aVar.Z0());
    }

    public Drawable getChipDrawable() {
        return this.f٨٧٢٤e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.a1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.c1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.d1();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.e1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.f1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.g1();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.h1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.i1();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.j1();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.k1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.l1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.m1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.o1();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.s1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f٨٧٣٩t && (this.f٨٧٣٨s.p() == 1 || this.f٨٧٣٨s.m() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.t1();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.u1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.v1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.w1();
        }
        return null;
    }

    @Override // f8.r
    public o getShapeAppearanceModel() {
        return this.f٨٧٢٤e.getShapeAppearanceModel();
    }

    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.x1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.A1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            return aVar.B1();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public boolean m(int i10) {
        int i11;
        this.f٨٧٣٦q = i10;
        int i12 = 0;
        if (!w()) {
            if (this.f٨٧٢٥f != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int max = Math.max(0, i10 - this.f٨٧٢٤e.getIntrinsicHeight());
        int max2 = Math.max(0, i10 - this.f٨٧٢٤e.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.f٨٧٢٥f != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        if (max2 > 0) {
            i11 = max2 / 2;
        } else {
            i11 = 0;
        }
        if (max > 0) {
            i12 = max / 2;
        }
        if (this.f٨٧٢٥f != null) {
            Rect rect = new Rect();
            this.f٨٧٢٥f.getPadding(rect);
            if (rect.top == i12 && rect.bottom == i12 && rect.left == i11 && rect.right == i11) {
                z();
                return true;
            }
        }
        if (getMinHeight() != i10) {
            setMinHeight(i10);
        }
        if (getMinWidth() != i10) {
            setMinWidth(i10);
        }
        q(i11, i12, i11, i12);
        z();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f8.j.f(this, this.f٨٧٢٤e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f٨٧٢٣z);
        }
        if (r()) {
            View.mergeDrawableStates(onCreateDrawableState, A);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.f٨٧٣٩t) {
            this.f٨٧٣٨s.z(z10, i10, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                setCloseIconHovered(false);
            }
        } else {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            g0 V0 = g0.V0(accessibilityNodeInfo);
            if (chipGroup.c()) {
                i10 = chipGroup.g(this);
            } else {
                i10 = -1;
            }
            V0.r0(g0.f.a(chipGroup.b(this), 1, i10, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i10) {
        PointerIcon systemIcon;
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            systemIcon = PointerIcon.getSystemIcon(getContext(), 1002);
            return systemIcon;
        }
        return super.onResolvePointerIcon(motionEvent, i10);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.f٨٧٣٥p != i10) {
            this.f٨٧٣٥p = i10;
            B();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r0 != 3) goto L٢٢;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f٨٧٣١l) {
                        if (!contains) {
                            setCloseIconPressed(false);
                        }
                        z10 = true;
                    }
                }
                z10 = false;
            } else if (this.f٨٧٣١l) {
                u();
                z10 = true;
                setCloseIconPressed(false);
            }
            z10 = false;
            setCloseIconPressed(false);
        } else {
            if (contains) {
                setCloseIconPressed(true);
                z10 = true;
            }
            z10 = false;
        }
        if (z10 || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public boolean r() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null && aVar.F1()) {
            return true;
        }
        return false;
    }

    public boolean s() {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null && aVar.H1()) {
            return true;
        }
        return false;
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f٨٧٣٧r = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.f٨٧٢٦g) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        } else {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.f٨٧٢٦g) {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i10) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.P1(z10);
        }
    }

    public void setCheckableResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.Q1(i10);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar == null) {
            this.f٨٧٣٠k = z10;
        } else if (aVar.F1()) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.R1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.S1(i10);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.T1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.U1(i10);
        }
    }

    public void setCheckedIconVisible(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.V1(i10);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.X1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.Y1(i10);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.Z1(f10);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.a2(i10);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f٨٧٢٤e;
        if (aVar2 != aVar) {
            x(aVar2);
            this.f٨٧٢٤e = aVar;
            aVar.S2(false);
            k(this.f٨٧٢٤e);
            m(this.f٨٧٣٦q);
        }
    }

    public void setChipEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.b2(f10);
        }
    }

    public void setChipEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.c2(i10);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.d2(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.e2(i10);
        }
    }

    public void setChipIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.f2(f10);
        }
    }

    public void setChipIconSizeResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.g2(i10);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.h2(colorStateList);
        }
    }

    public void setChipIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.i2(i10);
        }
    }

    public void setChipIconVisible(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.j2(i10);
        }
    }

    public void setChipMinHeight(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.l2(f10);
        }
    }

    public void setChipMinHeightResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.m2(i10);
        }
    }

    public void setChipStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.n2(f10);
        }
    }

    public void setChipStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.o2(i10);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.p2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.q2(i10);
        }
    }

    public void setChipStrokeWidth(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.r2(f10);
        }
    }

    public void setChipStrokeWidthResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.s2(i10);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.u2(drawable);
        }
        y();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.v2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.w2(f10);
        }
    }

    public void setCloseIconEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.x2(i10);
        }
    }

    public void setCloseIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.y2(i10);
        }
        y();
    }

    public void setCloseIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.z2(f10);
        }
    }

    public void setCloseIconSizeResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.A2(i10);
        }
    }

    public void setCloseIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.B2(f10);
        }
    }

    public void setCloseIconStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.C2(i10);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.E2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.F2(i10);
        }
    }

    public void setCloseIconVisible(int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.g0(f10);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f٨٧٢٤e == null) {
            return;
        }
        if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
            super.setEllipsize(truncateAt);
            com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
            if (aVar != null) {
                aVar.I2(truncateAt);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.f٨٧٣٤o = z10;
        m(this.f٨٧٣٦q);
    }

    @Override // android.widget.TextView
    public void setGravity(int i10) {
        if (i10 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i10);
        }
    }

    public void setHideMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.J2(hVar);
        }
    }

    public void setHideMotionSpecResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.K2(i10);
        }
    }

    public void setIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.L2(f10);
        }
    }

    public void setIconEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.M2(i10);
        }
    }

    public void setIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.N2(f10);
        }
    }

    public void setIconStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.O2(i10);
        }
    }

    @Override // com.google.android.material.internal.j
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInternalOnCheckedChangeListener(j.a aVar) {
        this.f٨٧٢٩j = aVar;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        if (this.f٨٧٢٤e == null) {
            return;
        }
        super.setLayoutDirection(i10);
    }

    @Override // android.widget.TextView
    public void setLines(int i10) {
        if (i10 <= 1) {
            super.setLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i10) {
        if (i10 <= 1) {
            super.setMaxLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i10) {
        super.setMaxWidth(i10);
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.P2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i10) {
        if (i10 <= 1) {
            super.setMinLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f٨٧٢٨i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f٨٧٢٧h = onClickListener;
        y();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.Q2(colorStateList);
        }
        if (!this.f٨٧٢٤e.D1()) {
            A();
        }
    }

    public void setRippleColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.R2(i10);
            if (!this.f٨٧٢٤e.D1()) {
                A();
            }
        }
    }

    @Override // f8.r
    public void setShapeAppearanceModel(o oVar) {
        this.f٨٧٢٤e.setShapeAppearanceModel(oVar);
    }

    public void setShowMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.T2(hVar);
        }
    }

    public void setShowMotionSpecResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.U2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z10) {
        if (z10) {
            super.setSingleLine(z10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (aVar.e3()) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        super.setText(charSequence2, bufferType);
        com.google.android.material.chip.a aVar2 = this.f٨٧٢٤e;
        if (aVar2 != null) {
            aVar2.V2(charSequence);
        }
    }

    public void setTextAppearance(e eVar) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.W2(eVar);
        }
        C();
    }

    public void setTextAppearanceResource(int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.Y2(f10);
        }
    }

    public void setTextEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.Z2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.a3(TypedValue.applyDimension(i10, f10, getResources().getDisplayMetrics()));
        }
        C();
    }

    public void setTextStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.b3(f10);
        }
    }

    public void setTextStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.c3(i10);
        }
    }

    public boolean u() {
        boolean z10 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f٨٧٢٧h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z10 = true;
        }
        if (this.f٨٧٣٩t) {
            this.f٨٧٣٨s.L(1, 1);
        }
        return z10;
    }

    public boolean w() {
        return this.f٨٧٣٤o;
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.G2(z10);
        }
        y();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Chip(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f٨٧٢١x;
        this.f٨٧٤٠u = new Rect();
        this.f٨٧٤١v = new RectF();
        this.f٨٧٤٢w = new a();
        Context context2 = getContext();
        D(attributeSet);
        com.google.android.material.chip.a M0 = com.google.android.material.chip.a.M0(context2, attributeSet, i10, i11);
        o(context2, attributeSet, i10);
        setChipDrawable(M0);
        M0.g0(getElevation());
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.Chip, i10, i11, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(c8.c.a(context2, i12, R.styleable.Chip_android_textColor));
        }
        boolean hasValue = i12.hasValue(R.styleable.Chip_shapeAppearance);
        i12.recycle();
        this.f٨٧٣٨s = new c(this);
        y();
        if (!hasValue) {
            p();
        }
        setChecked(this.f٨٧٣٠k);
        setText(M0.y1());
        setEllipsize(M0.s1());
        C();
        if (!this.f٨٧٢٤e.e3()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        B();
        if (w()) {
            setMinHeight(this.f٨٧٣٦q);
        }
        this.f٨٧٣٥p = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: u7.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                Chip.this.t(compoundButton, z10);
            }
        });
    }

    public void setCheckedIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.W1(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.k2(z10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.X2(i10);
        }
        C();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        com.google.android.material.chip.a aVar = this.f٨٧٢٤e;
        if (aVar != null) {
            aVar.X2(i10);
        }
        C();
    }
}
