package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.google.android.material.R;
import com.google.android.material.internal.k0;
import f8.i;
import f8.o;
import f8.r;
import f8.w;
import v2.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final MaterialButton f٨٥٥٤a;

    /* renamed from: b, reason: collision with root package name */
    private o f٨٥٥٥b;

    /* renamed from: c, reason: collision with root package name */
    private w f٨٥٥٦c;

    /* renamed from: d, reason: collision with root package name */
    private m f٨٥٥٧d;

    /* renamed from: e, reason: collision with root package name */
    private i.d f٨٥٥٨e;

    /* renamed from: f, reason: collision with root package name */
    private int f٨٥٥٩f;

    /* renamed from: g, reason: collision with root package name */
    private int f٨٥٦٠g;

    /* renamed from: h, reason: collision with root package name */
    private int f٨٥٦١h;

    /* renamed from: i, reason: collision with root package name */
    private int f٨٥٦٢i;

    /* renamed from: j, reason: collision with root package name */
    private int f٨٥٦٣j;

    /* renamed from: k, reason: collision with root package name */
    private int f٨٥٦٤k;

    /* renamed from: l, reason: collision with root package name */
    private PorterDuff.Mode f٨٥٦٥l;

    /* renamed from: m, reason: collision with root package name */
    private ColorStateList f٨٥٦٦m;

    /* renamed from: n, reason: collision with root package name */
    private ColorStateList f٨٥٦٧n;

    /* renamed from: o, reason: collision with root package name */
    private ColorStateList f٨٥٦٨o;

    /* renamed from: p, reason: collision with root package name */
    private Drawable f٨٥٦٩p;

    /* renamed from: t, reason: collision with root package name */
    private boolean f٨٥٧٣t;

    /* renamed from: v, reason: collision with root package name */
    private LayerDrawable f٨٥٧٥v;

    /* renamed from: w, reason: collision with root package name */
    private int f٨٥٧٦w;

    /* renamed from: q, reason: collision with root package name */
    private boolean f٨٥٧٠q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٨٥٧١r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f٨٥٧٢s = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f٨٥٧٤u = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MaterialButton materialButton, o oVar) {
        this.f٨٥٥٤a = materialButton;
        this.f٨٥٥٥b = oVar;
    }

    private void K(int i10, int i11) {
        int paddingStart = this.f٨٥٥٤a.getPaddingStart();
        int paddingTop = this.f٨٥٥٤a.getPaddingTop();
        int paddingEnd = this.f٨٥٥٤a.getPaddingEnd();
        int paddingBottom = this.f٨٥٥٤a.getPaddingBottom();
        int i12 = this.f٨٥٦١h;
        int i13 = this.f٨٥٦٢i;
        this.f٨٥٦٢i = i11;
        this.f٨٥٦١h = i10;
        if (!this.f٨٥٧١r) {
            L();
        }
        this.f٨٥٥٤a.setPaddingRelative(paddingStart, (paddingTop + i10) - i12, paddingEnd, (paddingBottom + i11) - i13);
    }

    private void L() {
        this.f٨٥٥٤a.setInternalBackground(a());
        i g10 = g();
        if (g10 != null) {
            g10.g0(this.f٨٥٧٦w);
            g10.setState(this.f٨٥٥٤a.getDrawableState());
        }
    }

    private void M() {
        if (Build.VERSION.SDK_INT < 23 && !this.f٨٥٧١r) {
            int paddingStart = this.f٨٥٥٤a.getPaddingStart();
            int paddingTop = this.f٨٥٥٤a.getPaddingTop();
            int paddingEnd = this.f٨٥٥٤a.getPaddingEnd();
            int paddingBottom = this.f٨٥٥٤a.getPaddingBottom();
            L();
            this.f٨٥٥٤a.setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom);
            return;
        }
        i g10 = g();
        if (g10 != null) {
            w wVar = this.f٨٥٥٦c;
            if (wVar != null) {
                g10.q0(wVar);
            } else {
                g10.setShapeAppearanceModel(this.f٨٥٥٥b);
            }
            m mVar = this.f٨٥٥٧d;
            if (mVar != null) {
                g10.f0(mVar);
            }
        }
        i p10 = p();
        if (p10 != null) {
            w wVar2 = this.f٨٥٥٦c;
            if (wVar2 != null) {
                p10.q0(wVar2);
            } else {
                p10.setShapeAppearanceModel(this.f٨٥٥٥b);
            }
            m mVar2 = this.f٨٥٥٧d;
            if (mVar2 != null) {
                p10.f0(mVar2);
            }
        }
        r f10 = f();
        if (f10 != null) {
            f10.setShapeAppearanceModel(this.f٨٥٥٥b);
            if (f10 instanceof i) {
                i iVar = (i) f10;
                w wVar3 = this.f٨٥٥٦c;
                if (wVar3 != null) {
                    iVar.q0(wVar3);
                }
                m mVar3 = this.f٨٥٥٧d;
                if (mVar3 != null) {
                    iVar.f0(mVar3);
                }
            }
        }
    }

    private void N() {
        int i10;
        i g10 = g();
        i p10 = p();
        if (g10 != null) {
            g10.s0(this.f٨٥٦٤k, this.f٨٥٦٧n);
            if (p10 != null) {
                float f10 = this.f٨٥٦٤k;
                if (this.f٨٥٧٠q) {
                    i10 = v7.a.d(this.f٨٥٥٤a, R.attr.colorSurface);
                } else {
                    i10 = 0;
                }
                p10.r0(f10, i10);
            }
        }
    }

    private InsetDrawable O(Drawable drawable) {
        return new InsetDrawable(drawable, this.f٨٥٥٩f, this.f٨٥٦١h, this.f٨٥٦٠g, this.f٨٥٦٢i);
    }

    private Drawable a() {
        int i10;
        i iVar = new i(this.f٨٥٥٥b);
        w wVar = this.f٨٥٥٦c;
        if (wVar != null) {
            iVar.q0(wVar);
        }
        m mVar = this.f٨٥٥٧d;
        if (mVar != null) {
            iVar.f0(mVar);
        }
        i.d dVar = this.f٨٥٥٨e;
        if (dVar != null) {
            iVar.setOnCornerSizeChangeListener(dVar);
        }
        iVar.V(this.f٨٥٥٤a.getContext());
        iVar.setTintList(this.f٨٥٦٦m);
        PorterDuff.Mode mode = this.f٨٥٦٥l;
        if (mode != null) {
            iVar.setTintMode(mode);
        }
        iVar.s0(this.f٨٥٦٤k, this.f٨٥٦٧n);
        i iVar2 = new i(this.f٨٥٥٥b);
        w wVar2 = this.f٨٥٥٦c;
        if (wVar2 != null) {
            iVar2.q0(wVar2);
        }
        m mVar2 = this.f٨٥٥٧d;
        if (mVar2 != null) {
            iVar2.f0(mVar2);
        }
        iVar2.setTint(0);
        float f10 = this.f٨٥٦٤k;
        if (this.f٨٥٧٠q) {
            i10 = v7.a.d(this.f٨٥٥٤a, R.attr.colorSurface);
        } else {
            i10 = 0;
        }
        iVar2.r0(f10, i10);
        i iVar3 = new i(this.f٨٥٥٥b);
        this.f٨٥٦٩p = iVar3;
        w wVar3 = this.f٨٥٥٦c;
        if (wVar3 != null) {
            iVar3.q0(wVar3);
        }
        m mVar3 = this.f٨٥٥٧d;
        if (mVar3 != null) {
            ((i) this.f٨٥٦٩p).f0(mVar3);
        }
        this.f٨٥٦٩p.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(d8.a.e(this.f٨٥٦٨o), O(new LayerDrawable(new Drawable[]{iVar2, iVar})), this.f٨٥٦٩p);
        this.f٨٥٧٥v = rippleDrawable;
        return rippleDrawable;
    }

    private i h(boolean z10) {
        LayerDrawable layerDrawable = this.f٨٥٧٥v;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 0) {
            return (i) ((LayerDrawable) ((InsetDrawable) this.f٨٥٧٥v.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0);
        }
        return null;
    }

    private i p() {
        return h(true);
    }

    public void A(int i10) {
        K(i10, this.f٨٥٦٢i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(ColorStateList colorStateList) {
        if (this.f٨٥٦٨o != colorStateList) {
            this.f٨٥٦٨o = colorStateList;
            if (this.f٨٥٥٤a.getBackground() instanceof RippleDrawable) {
                ((RippleDrawable) this.f٨٥٥٤a.getBackground()).setColor(d8.a.e(colorStateList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(o oVar) {
        this.f٨٥٥٥b = oVar;
        this.f٨٥٥٦c = null;
        M();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(boolean z10) {
        this.f٨٥٧٠q = z10;
        N();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(w wVar) {
        this.f٨٥٥٦c = wVar;
        M();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(ColorStateList colorStateList) {
        if (this.f٨٥٦٧n != colorStateList) {
            this.f٨٥٦٧n = colorStateList;
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(int i10) {
        if (this.f٨٥٦٤k != i10) {
            this.f٨٥٦٤k = i10;
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(ColorStateList colorStateList) {
        if (this.f٨٥٦٦m != colorStateList) {
            this.f٨٥٦٦m = colorStateList;
            if (g() != null) {
                g().setTintList(this.f٨٥٦٦m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(PorterDuff.Mode mode) {
        if (this.f٨٥٦٥l != mode) {
            this.f٨٥٦٥l = mode;
            if (g() != null && this.f٨٥٦٥l != null) {
                g().setTintMode(this.f٨٥٦٥l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(boolean z10) {
        this.f٨٥٧٤u = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f٨٥٦٣j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m c() {
        return this.f٨٥٥٧d;
    }

    public int d() {
        return this.f٨٥٦٢i;
    }

    public int e() {
        return this.f٨٥٦١h;
    }

    public r f() {
        LayerDrawable layerDrawable = this.f٨٥٧٥v;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 1) {
            if (this.f٨٥٧٥v.getNumberOfLayers() > 2) {
                return (r) this.f٨٥٧٥v.getDrawable(2);
            }
            return (r) this.f٨٥٧٥v.getDrawable(1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i g() {
        return h(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList i() {
        return this.f٨٥٦٨o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o j() {
        return this.f٨٥٥٥b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w k() {
        return this.f٨٥٥٦c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f٨٥٦٧n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f٨٥٦٤k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList n() {
        return this.f٨٥٦٦m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode o() {
        return this.f٨٥٦٥l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.f٨٥٧١r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.f٨٥٧٣t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return this.f٨٥٧٤u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCornerSizeChangeListener(i.d dVar) {
        this.f٨٥٥٨e = dVar;
        i g10 = g();
        if (g10 != null) {
            g10.setOnCornerSizeChangeListener(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(TypedArray typedArray) {
        this.f٨٥٥٩f = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.f٨٥٦٠g = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.f٨٥٦١h = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.f٨٥٦٢i = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        int i10 = R.styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i10)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i10, -1);
            this.f٨٥٦٣j = dimensionPixelSize;
            C(this.f٨٥٥٥b.x(dimensionPixelSize));
            this.f٨٥٧٢s = true;
        }
        this.f٨٥٦٤k = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.f٨٥٦٥l = k0.o(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f٨٥٦٦m = c8.c.a(this.f٨٥٥٤a.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.f٨٥٦٧n = c8.c.a(this.f٨٥٥٤a.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.f٨٥٦٨o = c8.c.a(this.f٨٥٥٤a.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.f٨٥٧٣t = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.f٨٥٧٦w = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        this.f٨٥٧٤u = typedArray.getBoolean(R.styleable.MaterialButton_toggleCheckedStateOnClick, true);
        int paddingStart = this.f٨٥٥٤a.getPaddingStart();
        int paddingTop = this.f٨٥٥٤a.getPaddingTop();
        int paddingEnd = this.f٨٥٥٤a.getPaddingEnd();
        int paddingBottom = this.f٨٥٥٤a.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            v();
        } else {
            L();
        }
        this.f٨٥٥٤a.setPaddingRelative(paddingStart + this.f٨٥٥٩f, paddingTop + this.f٨٥٦١h, paddingEnd + this.f٨٥٦٠g, paddingBottom + this.f٨٥٦٢i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i10) {
        if (g() != null) {
            g().setTint(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.f٨٥٧١r = true;
        this.f٨٥٥٤a.setSupportBackgroundTintList(this.f٨٥٦٦m);
        this.f٨٥٥٤a.setSupportBackgroundTintMode(this.f٨٥٦٥l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(boolean z10) {
        this.f٨٥٧٣t = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(int i10) {
        if (!this.f٨٥٧٢s || this.f٨٥٦٣j != i10) {
            this.f٨٥٦٣j = i10;
            this.f٨٥٧٢s = true;
            C(this.f٨٥٥٥b.x(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(m mVar) {
        this.f٨٥٥٧d = mVar;
        if (this.f٨٥٥٦c != null) {
            M();
        }
    }

    public void z(int i10) {
        K(this.f٨٥٦١h, i10);
    }
}
