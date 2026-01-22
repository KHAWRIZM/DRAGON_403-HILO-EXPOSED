package com.google.android.material.card;

import a8.k;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.cardview.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.e;
import f8.f;
import f8.i;
import f8.n;
import f8.o;
import kotlin.KotlinVersion;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c {

    /* renamed from: y, reason: collision with root package name */
    private static final double f٨٥٨٧y = Math.cos(Math.toRadians(45.0d));

    /* renamed from: z, reason: collision with root package name */
    private static final Drawable f٨٥٨٨z;

    /* renamed from: a, reason: collision with root package name */
    private final MaterialCardView f٨٥٨٩a;

    /* renamed from: c, reason: collision with root package name */
    private final i f٨٥٩١c;

    /* renamed from: d, reason: collision with root package name */
    private final i f٨٥٩٢d;

    /* renamed from: e, reason: collision with root package name */
    private int f٨٥٩٣e;

    /* renamed from: f, reason: collision with root package name */
    private int f٨٥٩٤f;

    /* renamed from: g, reason: collision with root package name */
    private int f٨٥٩٥g;

    /* renamed from: h, reason: collision with root package name */
    private int f٨٥٩٦h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f٨٥٩٧i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f٨٥٩٨j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f٨٥٩٩k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f٨٦٠٠l;

    /* renamed from: m, reason: collision with root package name */
    private o f٨٦٠١m;

    /* renamed from: n, reason: collision with root package name */
    private ColorStateList f٨٦٠٢n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f٨٦٠٣o;

    /* renamed from: p, reason: collision with root package name */
    private LayerDrawable f٨٦٠٤p;

    /* renamed from: q, reason: collision with root package name */
    private i f٨٦٠٥q;

    /* renamed from: s, reason: collision with root package name */
    private boolean f٨٦٠٧s;

    /* renamed from: t, reason: collision with root package name */
    private ValueAnimator f٨٦٠٨t;

    /* renamed from: u, reason: collision with root package name */
    private final TimeInterpolator f٨٦٠٩u;

    /* renamed from: v, reason: collision with root package name */
    private final int f٨٦١٠v;

    /* renamed from: w, reason: collision with root package name */
    private final int f٨٦١١w;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f٨٥٩٠b = new Rect();

    /* renamed from: r, reason: collision with root package name */
    private boolean f٨٦٠٦r = false;

    /* renamed from: x, reason: collision with root package name */
    private float f٨٦١٢x = DownloadProgress.UNKNOWN_PROGRESS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends InsetDrawable {
        a(Drawable drawable, int i10, int i11, int i12, int i13) {
            super(drawable, i10, i11, i12, i13);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        ColorDrawable colorDrawable;
        if (Build.VERSION.SDK_INT <= 28) {
            colorDrawable = new ColorDrawable();
        } else {
            colorDrawable = null;
        }
        f٨٥٨٨z = colorDrawable;
    }

    public c(MaterialCardView materialCardView, AttributeSet attributeSet, int i10, int i11) {
        this.f٨٥٨٩a = materialCardView;
        i iVar = new i(materialCardView.getContext(), attributeSet, i10, i11);
        this.f٨٥٩١c = iVar;
        iVar.V(materialCardView.getContext());
        iVar.n0(-12303292);
        o.b w10 = iVar.getShapeAppearanceModel().w();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i10, R.style.CardView);
        int i12 = R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i12)) {
            w10.o(obtainStyledAttributes.getDimension(i12, DownloadProgress.UNKNOWN_PROGRESS));
        }
        this.f٨٥٩٢d = new i();
        X(w10.m());
        this.f٨٦٠٩u = k.g(materialCardView.getContext(), com.google.android.material.R.attr.motionEasingLinearInterpolator, p7.a.f١٦٩٤٧a);
        this.f٨٦١٠v = k.f(materialCardView.getContext(), com.google.android.material.R.attr.motionDurationShort2, 300);
        this.f٨٦١١w = k.f(materialCardView.getContext(), com.google.android.material.R.attr.motionDurationShort1, 300);
        obtainStyledAttributes.recycle();
    }

    private Drawable B(Drawable drawable) {
        int i10;
        int i11;
        if (this.f٨٥٨٩a.getUseCompatPadding()) {
            i11 = (int) Math.ceil(f());
            i10 = (int) Math.ceil(e());
        } else {
            i10 = 0;
            i11 = 0;
        }
        return new a(drawable, i10, i11, i10, i11);
    }

    private boolean E() {
        if ((this.f٨٥٩٥g & 80) == 80) {
            return true;
        }
        return false;
    }

    private boolean F() {
        if ((this.f٨٥٩٥g & 8388613) == 8388613) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f٨٥٩٨j.setAlpha((int) (255.0f * floatValue));
        this.f٨٦١٢x = floatValue;
    }

    private boolean b0() {
        if (this.f٨٥٨٩a.getPreventCornerOverlap() && !g()) {
            return true;
        }
        return false;
    }

    private float c() {
        return Math.max(Math.max(d(this.f٨٦٠١m.q(), this.f٨٥٩١c.O()), d(this.f٨٦٠١m.s(), this.f٨٥٩١c.P())), Math.max(d(this.f٨٦٠١m.k(), this.f٨٥٩١c.y()), d(this.f٨٦٠١m.i(), this.f٨٥٩١c.x())));
    }

    private boolean c0() {
        if (this.f٨٥٨٩a.getPreventCornerOverlap() && g() && this.f٨٥٨٩a.getUseCompatPadding()) {
            return true;
        }
        return false;
    }

    private float d(e eVar, float f10) {
        if (eVar instanceof n) {
            return (float) ((1.0d - f٨٥٨٧y) * f10);
        }
        if (eVar instanceof f) {
            return f10 / 2.0f;
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    private boolean d0() {
        if (this.f٨٥٨٩a.isClickable()) {
            return true;
        }
        View view = this.f٨٥٨٩a;
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    private float e() {
        float f10;
        float maxCardElevation = this.f٨٥٨٩a.getMaxCardElevation();
        if (c0()) {
            f10 = c();
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        return maxCardElevation + f10;
    }

    private float f() {
        float f10;
        float maxCardElevation = this.f٨٥٨٩a.getMaxCardElevation() * 1.5f;
        if (c0()) {
            f10 = c();
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        return maxCardElevation + f10;
    }

    private boolean g() {
        return this.f٨٥٩١c.Y();
    }

    private Drawable h() {
        this.f٨٦٠٥q = new i(this.f٨٦٠١m);
        return new RippleDrawable(this.f٨٥٩٩k, null, this.f٨٦٠٥q);
    }

    private void h0(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 && (this.f٨٥٨٩a.getForeground() instanceof InsetDrawable)) {
            ((InsetDrawable) this.f٨٥٨٩a.getForeground()).setDrawable(drawable);
        } else {
            this.f٨٥٨٩a.setForeground(B(drawable));
        }
    }

    private void j0() {
        Drawable drawable = this.f٨٦٠٣o;
        if (drawable != null) {
            ((RippleDrawable) drawable).setColor(this.f٨٥٩٩k);
        }
    }

    private Drawable r() {
        if (this.f٨٦٠٣o == null) {
            this.f٨٦٠٣o = h();
        }
        if (this.f٨٦٠٤p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f٨٦٠٣o, this.f٨٥٩٢d, this.f٨٥٩٨j});
            this.f٨٦٠٤p = layerDrawable;
            layerDrawable.setId(2, com.google.android.material.R.id.mtrl_card_checked_layer_id);
        }
        return this.f٨٦٠٤p;
    }

    private float t() {
        if (this.f٨٥٨٩a.getPreventCornerOverlap() && this.f٨٥٨٩a.getUseCompatPadding()) {
            return (float) ((1.0d - f٨٥٨٧y) * this.f٨٥٨٩a.getCardViewRadius());
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rect A() {
        return this.f٨٥٩٠b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        return this.f٨٦٠٦r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D() {
        return this.f٨٦٠٧s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(TypedArray typedArray) {
        Drawable drawable;
        ColorStateList a10 = c8.c.a(this.f٨٥٨٩a.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        this.f٨٦٠٢n = a10;
        if (a10 == null) {
            this.f٨٦٠٢n = ColorStateList.valueOf(-1);
        }
        this.f٨٥٩٦h = typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z10 = typedArray.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        this.f٨٦٠٧s = z10;
        this.f٨٥٨٩a.setLongClickable(z10);
        this.f٨٦٠٠l = c8.c.a(this.f٨٥٨٩a.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        P(c8.c.e(this.f٨٥٨٩a.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        S(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconSize, 0));
        R(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconMargin, 0));
        this.f٨٥٩٥g = typedArray.getInteger(com.google.android.material.R.styleable.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList a11 = c8.c.a(this.f٨٥٨٩a.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        this.f٨٥٩٩k = a11;
        if (a11 == null) {
            this.f٨٥٩٩k = ColorStateList.valueOf(v7.a.d(this.f٨٥٨٩a, androidx.appcompat.R.attr.colorControlHighlight));
        }
        L(c8.c.a(this.f٨٥٨٩a.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor));
        j0();
        g0();
        k0();
        this.f٨٥٨٩a.setBackgroundInternal(B(this.f٨٥٩١c));
        if (d0()) {
            drawable = r();
        } else {
            drawable = this.f٨٥٩٢d;
        }
        this.f٨٥٩٧i = drawable;
        this.f٨٥٨٩a.setForeground(B(drawable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        if (this.f٨٦٠٤p != null) {
            if (this.f٨٥٨٩a.getUseCompatPadding()) {
                i12 = (int) Math.ceil(f() * 2.0f);
                i13 = (int) Math.ceil(e() * 2.0f);
            } else {
                i12 = 0;
                i13 = 0;
            }
            if (F()) {
                i14 = ((i10 - this.f٨٥٩٣e) - this.f٨٥٩٤f) - i13;
            } else {
                i14 = this.f٨٥٩٣e;
            }
            if (E()) {
                i15 = this.f٨٥٩٣e;
            } else {
                i15 = ((i11 - this.f٨٥٩٣e) - this.f٨٥٩٤f) - i12;
            }
            int i20 = i15;
            if (F()) {
                i16 = this.f٨٥٩٣e;
            } else {
                i16 = ((i10 - this.f٨٥٩٣e) - this.f٨٥٩٤f) - i13;
            }
            if (E()) {
                i17 = ((i11 - this.f٨٥٩٣e) - this.f٨٥٩٤f) - i12;
            } else {
                i17 = this.f٨٥٩٣e;
            }
            int i21 = i17;
            if (this.f٨٥٨٩a.getLayoutDirection() == 1) {
                i19 = i16;
                i18 = i14;
            } else {
                i18 = i16;
                i19 = i14;
            }
            this.f٨٦٠٤p.setLayerInset(2, i19, i21, i18, i20);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(boolean z10) {
        this.f٨٦٠٦r = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(ColorStateList colorStateList) {
        this.f٨٥٩١c.h0(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(ColorStateList colorStateList) {
        i iVar = this.f٨٥٩٢d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        iVar.h0(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(boolean z10) {
        this.f٨٦٠٧s = z10;
    }

    public void N(boolean z10) {
        O(z10, false);
    }

    public void O(boolean z10, boolean z11) {
        int i10;
        float f10;
        Drawable drawable = this.f٨٥٩٨j;
        if (drawable != null) {
            if (z11) {
                b(z10);
                return;
            }
            if (z10) {
                i10 = KotlinVersion.MAX_COMPONENT_VALUE;
            } else {
                i10 = 0;
            }
            drawable.setAlpha(i10);
            if (z10) {
                f10 = 1.0f;
            } else {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            this.f٨٦١٢x = f10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = h2.b.r(drawable).mutate();
            this.f٨٥٩٨j = mutate;
            mutate.setTintList(this.f٨٦٠٠l);
            N(this.f٨٥٨٩a.isChecked());
        } else {
            this.f٨٥٩٨j = f٨٥٨٨z;
        }
        LayerDrawable layerDrawable = this.f٨٦٠٤p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(com.google.android.material.R.id.mtrl_card_checked_layer_id, this.f٨٥٩٨j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(int i10) {
        this.f٨٥٩٥g = i10;
        I(this.f٨٥٨٩a.getMeasuredWidth(), this.f٨٥٨٩a.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(int i10) {
        this.f٨٥٩٣e = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(int i10) {
        this.f٨٥٩٤f = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(ColorStateList colorStateList) {
        this.f٨٦٠٠l = colorStateList;
        Drawable drawable = this.f٨٥٩٨j;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(float f10) {
        X(this.f٨٦٠١m.x(f10));
        this.f٨٥٩٧i.invalidateSelf();
        if (c0() || b0()) {
            f0();
        }
        if (c0()) {
            i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(float f10) {
        this.f٨٥٩١c.i0(f10);
        i iVar = this.f٨٥٩٢d;
        if (iVar != null) {
            iVar.i0(f10);
        }
        i iVar2 = this.f٨٦٠٥q;
        if (iVar2 != null) {
            iVar2.i0(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(ColorStateList colorStateList) {
        this.f٨٥٩٩k = colorStateList;
        j0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(o oVar) {
        this.f٨٦٠١m = oVar;
        this.f٨٥٩١c.setShapeAppearanceModel(oVar);
        this.f٨٥٩١c.m0(!r0.Y());
        i iVar = this.f٨٥٩٢d;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(oVar);
        }
        i iVar2 = this.f٨٦٠٥q;
        if (iVar2 != null) {
            iVar2.setShapeAppearanceModel(oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(ColorStateList colorStateList) {
        if (this.f٨٦٠٢n == colorStateList) {
            return;
        }
        this.f٨٦٠٢n = colorStateList;
        k0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(int i10) {
        if (i10 == this.f٨٥٩٦h) {
            return;
        }
        this.f٨٥٩٦h = i10;
        k0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(int i10, int i11, int i12, int i13) {
        this.f٨٥٩٠b.set(i10, i11, i12, i13);
        f0();
    }

    public void b(boolean z10) {
        float f10;
        float f11;
        int i10;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (z10) {
            f11 = 1.0f - this.f٨٦١٢x;
        } else {
            f11 = this.f٨٦١٢x;
        }
        ValueAnimator valueAnimator = this.f٨٦٠٨t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f٨٦٠٨t = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f٨٦١٢x, f10);
        this.f٨٦٠٨t = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.card.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                c.this.G(valueAnimator2);
            }
        });
        this.f٨٦٠٨t.setInterpolator(this.f٨٦٠٩u);
        ValueAnimator valueAnimator2 = this.f٨٦٠٨t;
        if (z10) {
            i10 = this.f٨٦١٠v;
        } else {
            i10 = this.f٨٦١١w;
        }
        valueAnimator2.setDuration(i10 * f11);
        this.f٨٦٠٨t.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0() {
        Drawable drawable;
        Drawable drawable2 = this.f٨٥٩٧i;
        if (d0()) {
            drawable = r();
        } else {
            drawable = this.f٨٥٩٢d;
        }
        this.f٨٥٩٧i = drawable;
        if (drawable2 != drawable) {
            h0(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0() {
        float c10;
        if (!b0() && !c0()) {
            c10 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            c10 = c();
        }
        int t10 = (int) (c10 - t());
        MaterialCardView materialCardView = this.f٨٥٨٩a;
        Rect rect = this.f٨٥٩٠b;
        materialCardView.h(rect.left + t10, rect.top + t10, rect.right + t10, rect.bottom + t10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g0() {
        this.f٨٥٩١c.g0(this.f٨٥٨٩a.getCardElevation());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f٨٦٠٣o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i10 = bounds.bottom;
            this.f٨٦٠٣o.setBounds(bounds.left, bounds.top, bounds.right, i10 - 1);
            this.f٨٦٠٣o.setBounds(bounds.left, bounds.top, bounds.right, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i0() {
        if (!C()) {
            this.f٨٥٨٩a.setBackgroundInternal(B(this.f٨٥٩١c));
        }
        this.f٨٥٨٩a.setForeground(B(this.f٨٥٩٧i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i j() {
        return this.f٨٥٩١c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList k() {
        return this.f٨٥٩١c.D();
    }

    void k0() {
        this.f٨٥٩٢d.s0(this.f٨٥٩٦h, this.f٨٦٠٢n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f٨٥٩٢d.D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable m() {
        return this.f٨٥٩٨j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f٨٥٩٥g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.f٨٥٩٣e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f٨٥٩٤f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList q() {
        return this.f٨٦٠٠l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float s() {
        return this.f٨٥٩١c.O();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float u() {
        return this.f٨٥٩١c.E();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList v() {
        return this.f٨٥٩٩k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o w() {
        return this.f٨٦٠١m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x() {
        ColorStateList colorStateList = this.f٨٦٠٢n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList y() {
        return this.f٨٦٠٢n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z() {
        return this.f٨٥٩٦h;
    }
}
