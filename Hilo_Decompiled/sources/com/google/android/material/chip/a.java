package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.x;
import c8.c;
import c8.e;
import com.google.android.material.internal.e0;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.i;
import h2.b;
import h2.g;
import io.agora.rtc.Constants;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.KotlinVersion;
import p7.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a extends i implements g, Drawable.Callback, e0.b {
    private static final int[] T0 = {R.attr.state_enabled};
    private static final ShapeDrawable U0 = new ShapeDrawable(new OvalShape());
    private int A0;
    private int B0;
    private int C0;
    private int D0;
    private boolean E0;
    private int F0;
    private int G0;
    private ColorFilter H0;
    private PorterDuffColorFilter I0;
    private ColorStateList J;
    private ColorStateList J0;
    private ColorStateList K;
    private PorterDuff.Mode K0;
    private float L;
    private int[] L0;
    private float M;
    private boolean M0;
    private ColorStateList N;
    private ColorStateList N0;
    private float O;
    private WeakReference O0;
    private ColorStateList P;
    private TextUtils.TruncateAt P0;
    private CharSequence Q;
    private boolean Q0;
    private boolean R;
    private int R0;
    private Drawable S;
    private boolean S0;
    private ColorStateList T;
    private float U;
    private boolean V;
    private boolean W;
    private Drawable X;
    private Drawable Y;
    private ColorStateList Z;

    /* renamed from: a0, reason: collision with root package name */
    private float f٨٧٥٧a0;

    /* renamed from: b0, reason: collision with root package name */
    private CharSequence f٨٧٥٨b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f٨٧٥٩c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f٨٧٦٠d0;

    /* renamed from: e0, reason: collision with root package name */
    private Drawable f٨٧٦١e0;

    /* renamed from: f0, reason: collision with root package name */
    private ColorStateList f٨٧٦٢f0;

    /* renamed from: g0, reason: collision with root package name */
    private h f٨٧٦٣g0;

    /* renamed from: h0, reason: collision with root package name */
    private h f٨٧٦٤h0;

    /* renamed from: i0, reason: collision with root package name */
    private float f٨٧٦٥i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f٨٧٦٦j0;

    /* renamed from: k0, reason: collision with root package name */
    private float f٨٧٦٧k0;

    /* renamed from: l0, reason: collision with root package name */
    private float f٨٧٦٨l0;

    /* renamed from: m0, reason: collision with root package name */
    private float f٨٧٦٩m0;

    /* renamed from: n0, reason: collision with root package name */
    private float f٨٧٧٠n0;

    /* renamed from: o0, reason: collision with root package name */
    private float f٨٧٧١o0;

    /* renamed from: p0, reason: collision with root package name */
    private float f٨٧٧٢p0;

    /* renamed from: q0, reason: collision with root package name */
    private final Context f٨٧٧٣q0;

    /* renamed from: r0, reason: collision with root package name */
    private final Paint f٨٧٧٤r0;

    /* renamed from: s0, reason: collision with root package name */
    private final Paint f٨٧٧٥s0;

    /* renamed from: t0, reason: collision with root package name */
    private final Paint.FontMetrics f٨٧٧٦t0;

    /* renamed from: u0, reason: collision with root package name */
    private final RectF f٨٧٧٧u0;

    /* renamed from: v0, reason: collision with root package name */
    private final PointF f٨٧٧٨v0;

    /* renamed from: w0, reason: collision with root package name */
    private final Path f٨٧٧٩w0;

    /* renamed from: x0, reason: collision with root package name */
    private final e0 f٨٧٨٠x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f٨٧٨١y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f٨٧٨٢z0;

    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface InterfaceC٠١٠٩a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.M = -1.0f;
        this.f٨٧٧٤r0 = new Paint(1);
        this.f٨٧٧٦t0 = new Paint.FontMetrics();
        this.f٨٧٧٧u0 = new RectF();
        this.f٨٧٧٨v0 = new PointF();
        this.f٨٧٧٩w0 = new Path();
        this.G0 = KotlinVersion.MAX_COMPONENT_VALUE;
        this.K0 = PorterDuff.Mode.SRC_IN;
        this.O0 = new WeakReference(null);
        V(context);
        this.f٨٧٧٣q0 = context;
        e0 e0Var = new e0(this);
        this.f٨٧٨٠x0 = e0Var;
        this.Q = "";
        e0Var.g().density = context.getResources().getDisplayMetrics().density;
        this.f٨٧٧٥s0 = null;
        int[] iArr = T0;
        setState(iArr);
        D2(iArr);
        this.Q0 = true;
        U0.setTint(-1);
    }

    private void B0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        b.m(drawable, b.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.X) {
            if (drawable.isStateful()) {
                drawable.setState(n1());
            }
            drawable.setTintList(this.Z);
            return;
        }
        Drawable drawable2 = this.S;
        if (drawable == drawable2 && this.V) {
            drawable2.setTintList(this.T);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void C0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (g3() || f3()) {
            float f10 = this.f٨٧٦٥i0 + this.f٨٧٦٦j0;
            float r12 = r1();
            if (b.f(this) == 0) {
                float f11 = rect.left + f10;
                rectF.left = f11;
                rectF.right = f11 + r12;
            } else {
                float f12 = rect.right - f10;
                rectF.right = f12;
                rectF.left = f12 - r12;
            }
            float q12 = q1();
            float exactCenterY = rect.exactCenterY() - (q12 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + q12;
        }
    }

    private ColorFilter C1() {
        ColorFilter colorFilter = this.H0;
        if (colorFilter == null) {
            return this.I0;
        }
        return colorFilter;
    }

    private void E0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (h3()) {
            float f10 = this.f٨٧٧٢p0 + this.f٨٧٧١o0 + this.f٨٧٥٧a0 + this.f٨٧٧٠n0 + this.f٨٧٦٩m0;
            if (b.f(this) == 0) {
                rectF.right = rect.right - f10;
            } else {
                rectF.left = rect.left + f10;
            }
        }
    }

    private static boolean E1(int[] iArr, int i10) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    private void F0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (h3()) {
            float f10 = this.f٨٧٧٢p0 + this.f٨٧٧١o0;
            if (b.f(this) == 0) {
                float f11 = rect.right - f10;
                rectF.right = f11;
                rectF.left = f11 - this.f٨٧٥٧a0;
            } else {
                float f12 = rect.left + f10;
                rectF.left = f12;
                rectF.right = f12 + this.f٨٧٥٧a0;
            }
            float exactCenterY = rect.exactCenterY();
            float f13 = this.f٨٧٥٧a0;
            float f14 = exactCenterY - (f13 / 2.0f);
            rectF.top = f14;
            rectF.bottom = f14 + f13;
        }
    }

    private void G0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (h3()) {
            float f10 = this.f٨٧٧٢p0 + this.f٨٧٧١o0 + this.f٨٧٥٧a0 + this.f٨٧٧٠n0 + this.f٨٧٦٩m0;
            if (b.f(this) == 0) {
                float f11 = rect.right;
                rectF.right = f11;
                rectF.left = f11 - f10;
            } else {
                int i10 = rect.left;
                rectF.left = i10;
                rectF.right = i10 + f10;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void I0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.Q != null) {
            float D0 = this.f٨٧٦٥i0 + D0() + this.f٨٧٦٨l0;
            float H0 = this.f٨٧٧٢p0 + H0() + this.f٨٧٦٩m0;
            if (b.f(this) == 0) {
                rectF.left = rect.left + D0;
                rectF.right = rect.right - H0;
            } else {
                rectF.left = rect.left + H0;
                rectF.right = rect.right - D0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean I1(ColorStateList colorStateList) {
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    private float J0() {
        this.f٨٧٨٠x0.g().getFontMetrics(this.f٨٧٧٦t0);
        Paint.FontMetrics fontMetrics = this.f٨٧٧٦t0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean J1(Drawable drawable) {
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        return false;
    }

    private static boolean K1(e eVar) {
        if (eVar != null && eVar.j() != null && eVar.j().isStateful()) {
            return true;
        }
        return false;
    }

    private boolean L0() {
        if (this.f٨٧٦٠d0 && this.f٨٧٦١e0 != null && this.f٨٧٥٩c0) {
            return true;
        }
        return false;
    }

    private void L1(AttributeSet attributeSet, int i10, int i11) {
        TypedArray i12 = h0.i(this.f٨٧٧٣q0, attributeSet, com.google.android.material.R.styleable.Chip, i10, i11, new int[0]);
        this.S0 = i12.hasValue(com.google.android.material.R.styleable.Chip_shapeAppearance);
        t2(c.a(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_chipSurfaceColor));
        X1(c.a(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_chipBackgroundColor));
        l2(i12.getDimension(com.google.android.material.R.styleable.Chip_chipMinHeight, DownloadProgress.UNKNOWN_PROGRESS));
        int i13 = com.google.android.material.R.styleable.Chip_chipCornerRadius;
        if (i12.hasValue(i13)) {
            Z1(i12.getDimension(i13, DownloadProgress.UNKNOWN_PROGRESS));
        }
        p2(c.a(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_chipStrokeColor));
        r2(i12.getDimension(com.google.android.material.R.styleable.Chip_chipStrokeWidth, DownloadProgress.UNKNOWN_PROGRESS));
        Q2(c.a(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_rippleColor));
        V2(i12.getText(com.google.android.material.R.styleable.Chip_android_text));
        e h10 = c.h(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_android_textAppearance);
        h10.o(i12.getDimension(com.google.android.material.R.styleable.Chip_android_textSize, h10.k()));
        if (Build.VERSION.SDK_INT < 23) {
            h10.n(c.a(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_android_textColor));
        }
        W2(h10);
        int i14 = i12.getInt(com.google.android.material.R.styleable.Chip_android_ellipsize, 0);
        if (i14 != 1) {
            if (i14 != 2) {
                if (i14 == 3) {
                    I2(TextUtils.TruncateAt.END);
                }
            } else {
                I2(TextUtils.TruncateAt.MIDDLE);
            }
        } else {
            I2(TextUtils.TruncateAt.START);
        }
        k2(i12.getBoolean(com.google.android.material.R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            k2(i12.getBoolean(com.google.android.material.R.styleable.Chip_chipIconEnabled, false));
        }
        d2(c.e(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_chipIcon));
        int i15 = com.google.android.material.R.styleable.Chip_chipIconTint;
        if (i12.hasValue(i15)) {
            h2(c.a(this.f٨٧٧٣q0, i12, i15));
        }
        f2(i12.getDimension(com.google.android.material.R.styleable.Chip_chipIconSize, -1.0f));
        G2(i12.getBoolean(com.google.android.material.R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            G2(i12.getBoolean(com.google.android.material.R.styleable.Chip_closeIconEnabled, false));
        }
        u2(c.e(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_closeIcon));
        E2(c.a(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_closeIconTint));
        z2(i12.getDimension(com.google.android.material.R.styleable.Chip_closeIconSize, DownloadProgress.UNKNOWN_PROGRESS));
        P1(i12.getBoolean(com.google.android.material.R.styleable.Chip_android_checkable, false));
        W1(i12.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            W1(i12.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconEnabled, false));
        }
        R1(c.e(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_checkedIcon));
        int i16 = com.google.android.material.R.styleable.Chip_checkedIconTint;
        if (i12.hasValue(i16)) {
            T1(c.a(this.f٨٧٧٣q0, i12, i16));
        }
        T2(h.c(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_showMotionSpec));
        J2(h.c(this.f٨٧٧٣q0, i12, com.google.android.material.R.styleable.Chip_hideMotionSpec));
        n2(i12.getDimension(com.google.android.material.R.styleable.Chip_chipStartPadding, DownloadProgress.UNKNOWN_PROGRESS));
        N2(i12.getDimension(com.google.android.material.R.styleable.Chip_iconStartPadding, DownloadProgress.UNKNOWN_PROGRESS));
        L2(i12.getDimension(com.google.android.material.R.styleable.Chip_iconEndPadding, DownloadProgress.UNKNOWN_PROGRESS));
        b3(i12.getDimension(com.google.android.material.R.styleable.Chip_textStartPadding, DownloadProgress.UNKNOWN_PROGRESS));
        Y2(i12.getDimension(com.google.android.material.R.styleable.Chip_textEndPadding, DownloadProgress.UNKNOWN_PROGRESS));
        B2(i12.getDimension(com.google.android.material.R.styleable.Chip_closeIconStartPadding, DownloadProgress.UNKNOWN_PROGRESS));
        w2(i12.getDimension(com.google.android.material.R.styleable.Chip_closeIconEndPadding, DownloadProgress.UNKNOWN_PROGRESS));
        b2(i12.getDimension(com.google.android.material.R.styleable.Chip_chipEndPadding, DownloadProgress.UNKNOWN_PROGRESS));
        P2(i12.getDimensionPixelSize(com.google.android.material.R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        i12.recycle();
    }

    public static a M0(Context context, AttributeSet attributeSet, int i10, int i11) {
        a aVar = new a(context, attributeSet, i10, i11);
        aVar.L1(attributeSet, i10, i11);
        return aVar;
    }

    private void N0(Canvas canvas, Rect rect) {
        if (f3()) {
            C0(rect, this.f٨٧٧٧u0);
            RectF rectF = this.f٨٧٧٧u0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.f٨٧٦١e0.setBounds(0, 0, (int) this.f٨٧٧٧u0.width(), (int) this.f٨٧٧٧u0.height());
            this.f٨٧٦١e0.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean N1(int[] iArr, int[] iArr2) {
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        int i12;
        int i13;
        int i14;
        boolean z12;
        boolean z13;
        ColorStateList colorStateList;
        int i15;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.J;
        if (colorStateList2 != null) {
            i10 = colorStateList2.getColorForState(iArr, this.f٨٧٨١y0);
        } else {
            i10 = 0;
        }
        int q10 = q(i10);
        boolean z14 = true;
        if (this.f٨٧٨١y0 != q10) {
            this.f٨٧٨١y0 = q10;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.K;
        if (colorStateList3 != null) {
            i11 = colorStateList3.getColorForState(iArr, this.f٨٧٨٢z0);
        } else {
            i11 = 0;
        }
        int q11 = q(i11);
        if (this.f٨٧٨٢z0 != q11) {
            this.f٨٧٨٢z0 = q11;
            onStateChange = true;
        }
        int j10 = v7.a.j(q10, q11);
        if (this.A0 != j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (D() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 | z11) {
            this.A0 = j10;
            h0(ColorStateList.valueOf(j10));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.N;
        if (colorStateList4 != null) {
            i12 = colorStateList4.getColorForState(iArr, this.B0);
        } else {
            i12 = 0;
        }
        if (this.B0 != i12) {
            this.B0 = i12;
            onStateChange = true;
        }
        if (this.N0 != null && d8.a.f(iArr)) {
            i13 = this.N0.getColorForState(iArr, this.C0);
        } else {
            i13 = 0;
        }
        if (this.C0 != i13) {
            this.C0 = i13;
            if (this.M0) {
                onStateChange = true;
            }
        }
        if (this.f٨٧٨٠x0.e() != null && this.f٨٧٨٠x0.e().j() != null) {
            i14 = this.f٨٧٨٠x0.e().j().getColorForState(iArr, this.D0);
        } else {
            i14 = 0;
        }
        if (this.D0 != i14) {
            this.D0 = i14;
            onStateChange = true;
        }
        if (E1(getState(), R.attr.state_checked) && this.f٨٧٥٩c0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (this.E0 != z12 && this.f٨٧٦١e0 != null) {
            float D0 = D0();
            this.E0 = z12;
            if (D0 != D0()) {
                onStateChange = true;
                z13 = true;
                colorStateList = this.J0;
                if (colorStateList == null) {
                    i15 = colorStateList.getColorForState(iArr, this.F0);
                } else {
                    i15 = 0;
                }
                if (this.F0 == i15) {
                    this.F0 = i15;
                    this.I0 = com.google.android.material.drawable.g.o(this, this.J0, this.K0);
                } else {
                    z14 = onStateChange;
                }
                if (J1(this.S)) {
                    z14 |= this.S.setState(iArr);
                }
                if (J1(this.f٨٧٦١e0)) {
                    z14 |= this.f٨٧٦١e0.setState(iArr);
                }
                if (J1(this.X)) {
                    int[] iArr3 = new int[iArr.length + iArr2.length];
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                    z14 |= this.X.setState(iArr3);
                }
                if (J1(this.Y)) {
                    z14 |= this.Y.setState(iArr2);
                }
                if (z14) {
                    invalidateSelf();
                }
                if (z13) {
                    M1();
                }
                return z14;
            }
            onStateChange = true;
        }
        z13 = false;
        colorStateList = this.J0;
        if (colorStateList == null) {
        }
        if (this.F0 == i15) {
        }
        if (J1(this.S)) {
        }
        if (J1(this.f٨٧٦١e0)) {
        }
        if (J1(this.X)) {
        }
        if (J1(this.Y)) {
        }
        if (z14) {
        }
        if (z13) {
        }
        return z14;
    }

    private void O0(Canvas canvas, Rect rect) {
        if (!this.S0) {
            this.f٨٧٧٤r0.setColor(this.f٨٧٨٢z0);
            this.f٨٧٧٤r0.setStyle(Paint.Style.FILL);
            this.f٨٧٧٤r0.setColorFilter(C1());
            this.f٨٧٧٧u0.set(rect);
            canvas.drawRoundRect(this.f٨٧٧٧u0, Z0(), Z0(), this.f٨٧٧٤r0);
        }
    }

    private void P0(Canvas canvas, Rect rect) {
        if (g3()) {
            C0(rect, this.f٨٧٧٧u0);
            RectF rectF = this.f٨٧٧٧u0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.S.setBounds(0, 0, (int) this.f٨٧٧٧u0.width(), (int) this.f٨٧٧٧u0.height());
            this.S.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    private void Q0(Canvas canvas, Rect rect) {
        if (this.O > DownloadProgress.UNKNOWN_PROGRESS && !this.S0) {
            this.f٨٧٧٤r0.setColor(this.B0);
            this.f٨٧٧٤r0.setStyle(Paint.Style.STROKE);
            if (!this.S0) {
                this.f٨٧٧٤r0.setColorFilter(C1());
            }
            RectF rectF = this.f٨٧٧٧u0;
            float f10 = rect.left;
            float f11 = this.O;
            rectF.set(f10 + (f11 / 2.0f), rect.top + (f11 / 2.0f), rect.right - (f11 / 2.0f), rect.bottom - (f11 / 2.0f));
            float f12 = this.M - (this.O / 2.0f);
            canvas.drawRoundRect(this.f٨٧٧٧u0, f12, f12, this.f٨٧٧٤r0);
        }
    }

    private void R0(Canvas canvas, Rect rect) {
        if (!this.S0) {
            this.f٨٧٧٤r0.setColor(this.f٨٧٨١y0);
            this.f٨٧٧٤r0.setStyle(Paint.Style.FILL);
            this.f٨٧٧٧u0.set(rect);
            canvas.drawRoundRect(this.f٨٧٧٧u0, Z0(), Z0(), this.f٨٧٧٤r0);
        }
    }

    private void S0(Canvas canvas, Rect rect) {
        if (h3()) {
            F0(rect, this.f٨٧٧٧u0);
            RectF rectF = this.f٨٧٧٧u0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.X.setBounds(0, 0, (int) this.f٨٧٧٧u0.width(), (int) this.f٨٧٧٧u0.height());
            this.Y.setBounds(this.X.getBounds());
            this.Y.jumpToCurrentState();
            this.Y.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    private void T0(Canvas canvas, Rect rect) {
        this.f٨٧٧٤r0.setColor(this.C0);
        this.f٨٧٧٤r0.setStyle(Paint.Style.FILL);
        this.f٨٧٧٧u0.set(rect);
        if (!this.S0) {
            canvas.drawRoundRect(this.f٨٧٧٧u0, Z0(), Z0(), this.f٨٧٧٤r0);
        } else {
            l(new RectF(rect), this.f٨٧٧٩w0);
            super.u(canvas, this.f٨٧٧٤r0, this.f٨٧٧٩w0, z());
        }
    }

    private void U0(Canvas canvas, Rect rect) {
        Paint paint = this.f٨٧٧٥s0;
        if (paint != null) {
            paint.setColor(x.l(-16777216, Constants.ERR_WATERMARKR_INFO));
            canvas.drawRect(rect, this.f٨٧٧٥s0);
            if (g3() || f3()) {
                C0(rect, this.f٨٧٧٧u0);
                canvas.drawRect(this.f٨٧٧٧u0, this.f٨٧٧٥s0);
            }
            if (this.Q != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f٨٧٧٥s0);
            }
            if (h3()) {
                F0(rect, this.f٨٧٧٧u0);
                canvas.drawRect(this.f٨٧٧٧u0, this.f٨٧٧٥s0);
            }
            this.f٨٧٧٥s0.setColor(x.l(-65536, Constants.ERR_WATERMARKR_INFO));
            E0(rect, this.f٨٧٧٧u0);
            canvas.drawRect(this.f٨٧٧٧u0, this.f٨٧٧٥s0);
            this.f٨٧٧٥s0.setColor(x.l(-16711936, Constants.ERR_WATERMARKR_INFO));
            G0(rect, this.f٨٧٧٧u0);
            canvas.drawRect(this.f٨٧٧٧u0, this.f٨٧٧٥s0);
        }
    }

    private void V0(Canvas canvas, Rect rect) {
        boolean z10;
        if (this.Q != null) {
            Paint.Align K0 = K0(rect, this.f٨٧٧٨v0);
            I0(rect, this.f٨٧٧٧u0);
            if (this.f٨٧٨٠x0.e() != null) {
                this.f٨٧٨٠x0.g().drawableState = getState();
                this.f٨٧٨٠x0.n(this.f٨٧٧٣q0);
            }
            this.f٨٧٨٠x0.g().setTextAlign(K0);
            int i10 = 0;
            if (Math.round(this.f٨٧٨٠x0.h(y1().toString())) > Math.round(this.f٨٧٧٧u0.width())) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                i10 = canvas.save();
                canvas.clipRect(this.f٨٧٧٧u0);
            }
            CharSequence charSequence = this.Q;
            if (z10 && this.P0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f٨٧٨٠x0.g(), this.f٨٧٧٧u0.width(), this.P0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.f٨٧٧٨v0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.f٨٧٨٠x0.g());
            if (z10) {
                canvas.restoreToCount(i10);
            }
        }
    }

    private boolean f3() {
        if (this.f٨٧٦٠d0 && this.f٨٧٦١e0 != null && this.E0) {
            return true;
        }
        return false;
    }

    private boolean g3() {
        if (this.R && this.S != null) {
            return true;
        }
        return false;
    }

    private boolean h3() {
        if (this.W && this.X != null) {
            return true;
        }
        return false;
    }

    private void i3(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void j3() {
        ColorStateList colorStateList;
        if (this.M0) {
            colorStateList = d8.a.e(this.P);
        } else {
            colorStateList = null;
        }
        this.N0 = colorStateList;
    }

    private void k3() {
        this.Y = new RippleDrawable(d8.a.e(w1()), this.X, U0);
    }

    private float q1() {
        Drawable drawable;
        if (this.E0) {
            drawable = this.f٨٧٦١e0;
        } else {
            drawable = this.S;
        }
        float f10 = this.U;
        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS && drawable != null) {
            f10 = (float) Math.ceil(k0.g(this.f٨٧٧٣q0, 24));
            if (drawable.getIntrinsicHeight() <= f10) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f10;
    }

    private float r1() {
        Drawable drawable;
        if (this.E0) {
            drawable = this.f٨٧٦١e0;
        } else {
            drawable = this.S;
        }
        float f10 = this.U;
        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS && drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return f10;
    }

    private void t2(ColorStateList colorStateList) {
        if (this.J != colorStateList) {
            this.J = colorStateList;
            onStateChange(getState());
        }
    }

    public float A1() {
        return this.f٨٧٦٩m0;
    }

    public void A2(int i10) {
        z2(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    public float B1() {
        return this.f٨٧٦٨l0;
    }

    public void B2(float f10) {
        if (this.f٨٧٧٠n0 != f10) {
            this.f٨٧٧٠n0 = f10;
            invalidateSelf();
            if (h3()) {
                M1();
            }
        }
    }

    public void C2(int i10) {
        B2(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float D0() {
        if (!g3() && !f3()) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return this.f٨٧٦٦j0 + r1() + this.f٨٧٦٧k0;
    }

    public boolean D1() {
        return this.M0;
    }

    public boolean D2(int[] iArr) {
        if (!Arrays.equals(this.L0, iArr)) {
            this.L0 = iArr;
            if (h3()) {
                return N1(getState(), iArr);
            }
            return false;
        }
        return false;
    }

    public void E2(ColorStateList colorStateList) {
        if (this.Z != colorStateList) {
            this.Z = colorStateList;
            if (h3()) {
                this.X.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public boolean F1() {
        return this.f٨٧٥٩c0;
    }

    public void F2(int i10) {
        E2(r1.a.a(this.f٨٧٧٣q0, i10));
    }

    public boolean G1() {
        return J1(this.X);
    }

    public void G2(boolean z10) {
        if (this.W != z10) {
            boolean h32 = h3();
            this.W = z10;
            boolean h33 = h3();
            if (h32 != h33) {
                if (h33) {
                    B0(this.X);
                } else {
                    i3(this.X);
                }
                invalidateSelf();
                M1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float H0() {
        if (h3()) {
            return this.f٨٧٧٠n0 + this.f٨٧٥٧a0 + this.f٨٧٧١o0;
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public boolean H1() {
        return this.W;
    }

    public void H2(InterfaceC٠١٠٩a r22) {
        this.O0 = new WeakReference(r22);
    }

    public void I2(TextUtils.TruncateAt truncateAt) {
        this.P0 = truncateAt;
    }

    public void J2(h hVar) {
        this.f٨٧٦٤h0 = hVar;
    }

    Paint.Align K0(Rect rect, PointF pointF) {
        pointF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        Paint.Align align = Paint.Align.LEFT;
        if (this.Q != null) {
            float D0 = this.f٨٧٦٥i0 + D0() + this.f٨٧٦٨l0;
            if (b.f(this) == 0) {
                pointF.x = rect.left + D0;
            } else {
                pointF.x = rect.right - D0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - J0();
        }
        return align;
    }

    public void K2(int i10) {
        J2(h.d(this.f٨٧٧٣q0, i10));
    }

    public void L2(float f10) {
        if (this.f٨٧٦٧k0 != f10) {
            float D0 = D0();
            this.f٨٧٦٧k0 = f10;
            float D02 = D0();
            invalidateSelf();
            if (D0 != D02) {
                M1();
            }
        }
    }

    protected void M1() {
        InterfaceC٠١٠٩a r02 = (InterfaceC٠١٠٩a) this.O0.get();
        if (r02 != null) {
            r02.a();
        }
    }

    public void M2(int i10) {
        L2(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    public void N2(float f10) {
        if (this.f٨٧٦٦j0 != f10) {
            float D0 = D0();
            this.f٨٧٦٦j0 = f10;
            float D02 = D0();
            invalidateSelf();
            if (D0 != D02) {
                M1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O1(boolean z10) {
        int[] iArr;
        if (this.X == null) {
            return false;
        }
        if (z10) {
            iArr = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        } else {
            iArr = T0;
        }
        return D2(iArr);
    }

    public void O2(int i10) {
        N2(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    public void P1(boolean z10) {
        if (this.f٨٧٥٩c0 != z10) {
            this.f٨٧٥٩c0 = z10;
            float D0 = D0();
            if (!z10 && this.E0) {
                this.E0 = false;
            }
            float D02 = D0();
            invalidateSelf();
            if (D0 != D02) {
                M1();
            }
        }
    }

    public void P2(int i10) {
        this.R0 = i10;
    }

    public void Q1(int i10) {
        P1(this.f٨٧٧٣q0.getResources().getBoolean(i10));
    }

    public void Q2(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            j3();
            onStateChange(getState());
        }
    }

    public void R1(Drawable drawable) {
        if (this.f٨٧٦١e0 != drawable) {
            float D0 = D0();
            this.f٨٧٦١e0 = drawable;
            float D02 = D0();
            i3(this.f٨٧٦١e0);
            B0(this.f٨٧٦١e0);
            invalidateSelf();
            if (D0 != D02) {
                M1();
            }
        }
    }

    public void R2(int i10) {
        Q2(r1.a.a(this.f٨٧٧٣q0, i10));
    }

    public void S1(int i10) {
        R1(r1.a.b(this.f٨٧٧٣q0, i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S2(boolean z10) {
        this.Q0 = z10;
    }

    public void T1(ColorStateList colorStateList) {
        if (this.f٨٧٦٢f0 != colorStateList) {
            this.f٨٧٦٢f0 = colorStateList;
            if (L0()) {
                this.f٨٧٦١e0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void T2(h hVar) {
        this.f٨٧٦٣g0 = hVar;
    }

    public void U1(int i10) {
        T1(r1.a.a(this.f٨٧٧٣q0, i10));
    }

    public void U2(int i10) {
        T2(h.d(this.f٨٧٧٣q0, i10));
    }

    public void V1(int i10) {
        W1(this.f٨٧٧٣q0.getResources().getBoolean(i10));
    }

    public void V2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.Q, charSequence)) {
            this.Q = charSequence;
            this.f٨٧٨٠x0.m(true);
            invalidateSelf();
            M1();
        }
    }

    public Drawable W0() {
        return this.f٨٧٦١e0;
    }

    public void W1(boolean z10) {
        if (this.f٨٧٦٠d0 != z10) {
            boolean f32 = f3();
            this.f٨٧٦٠d0 = z10;
            boolean f33 = f3();
            if (f32 != f33) {
                if (f33) {
                    B0(this.f٨٧٦١e0);
                } else {
                    i3(this.f٨٧٦١e0);
                }
                invalidateSelf();
                M1();
            }
        }
    }

    public void W2(e eVar) {
        this.f٨٧٨٠x0.k(eVar, this.f٨٧٧٣q0);
    }

    public ColorStateList X0() {
        return this.f٨٧٦٢f0;
    }

    public void X1(ColorStateList colorStateList) {
        if (this.K != colorStateList) {
            this.K = colorStateList;
            onStateChange(getState());
        }
    }

    public void X2(int i10) {
        W2(new e(this.f٨٧٧٣q0, i10));
    }

    public ColorStateList Y0() {
        return this.K;
    }

    public void Y1(int i10) {
        X1(r1.a.a(this.f٨٧٧٣q0, i10));
    }

    public void Y2(float f10) {
        if (this.f٨٧٦٩m0 != f10) {
            this.f٨٧٦٩m0 = f10;
            invalidateSelf();
            M1();
        }
    }

    public float Z0() {
        if (this.S0) {
            return O();
        }
        return this.M;
    }

    public void Z1(float f10) {
        if (this.M != f10) {
            this.M = f10;
            setShapeAppearanceModel(getShapeAppearanceModel().x(f10));
        }
    }

    public void Z2(int i10) {
        Y2(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    @Override // com.google.android.material.internal.e0.b
    public void a() {
        M1();
        invalidateSelf();
    }

    public float a1() {
        return this.f٨٧٧٢p0;
    }

    public void a2(int i10) {
        Z1(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    public void a3(float f10) {
        e z12 = z1();
        if (z12 != null) {
            z12.o(f10);
            this.f٨٧٨٠x0.g().setTextSize(f10);
            a();
        }
    }

    public Drawable b1() {
        Drawable drawable = this.S;
        if (drawable != null) {
            return b.q(drawable);
        }
        return null;
    }

    public void b2(float f10) {
        if (this.f٨٧٧٢p0 != f10) {
            this.f٨٧٧٢p0 = f10;
            invalidateSelf();
            M1();
        }
    }

    public void b3(float f10) {
        if (this.f٨٧٦٨l0 != f10) {
            this.f٨٧٦٨l0 = f10;
            invalidateSelf();
            M1();
        }
    }

    public float c1() {
        return this.U;
    }

    public void c2(int i10) {
        b2(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    public void c3(int i10) {
        b3(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    public ColorStateList d1() {
        return this.T;
    }

    public void d2(Drawable drawable) {
        Drawable drawable2;
        Drawable b12 = b1();
        if (b12 != drawable) {
            float D0 = D0();
            if (drawable != null) {
                drawable2 = b.r(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.S = drawable2;
            float D02 = D0();
            i3(b12);
            if (g3()) {
                B0(this.S);
            }
            invalidateSelf();
            if (D0 != D02) {
                M1();
            }
        }
    }

    public void d3(boolean z10) {
        if (this.M0 != z10) {
            this.M0 = z10;
            j3();
            onStateChange(getState());
        }
    }

    @Override // f8.i, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i10;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i11 = this.G0;
            if (i11 < 255) {
                i10 = s7.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i11);
            } else {
                i10 = 0;
            }
            R0(canvas, bounds);
            O0(canvas, bounds);
            if (this.S0) {
                super.draw(canvas);
            }
            Q0(canvas, bounds);
            T0(canvas, bounds);
            P0(canvas, bounds);
            N0(canvas, bounds);
            if (this.Q0) {
                V0(canvas, bounds);
            }
            S0(canvas, bounds);
            U0(canvas, bounds);
            if (this.G0 < 255) {
                canvas.restoreToCount(i10);
            }
        }
    }

    public float e1() {
        return this.L;
    }

    public void e2(int i10) {
        d2(r1.a.b(this.f٨٧٧٣q0, i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e3() {
        return this.Q0;
    }

    public float f1() {
        return this.f٨٧٦٥i0;
    }

    public void f2(float f10) {
        if (this.U != f10) {
            float D0 = D0();
            this.U = f10;
            float D02 = D0();
            invalidateSelf();
            if (D0 != D02) {
                M1();
            }
        }
    }

    public ColorStateList g1() {
        return this.N;
    }

    public void g2(int i10) {
        f2(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    @Override // f8.i, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.G0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.H0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.L;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f٨٧٦٥i0 + D0() + this.f٨٧٦٨l0 + this.f٨٧٨٠x0.h(y1().toString()) + this.f٨٧٦٩m0 + H0() + this.f٨٧٧٢p0), this.R0);
    }

    @Override // f8.i, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // f8.i, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.S0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.M);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.M);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public float h1() {
        return this.O;
    }

    public void h2(ColorStateList colorStateList) {
        this.V = true;
        if (this.T != colorStateList) {
            this.T = colorStateList;
            if (g3()) {
                this.S.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public Drawable i1() {
        Drawable drawable = this.X;
        if (drawable != null) {
            return b.q(drawable);
        }
        return null;
    }

    public void i2(int i10) {
        h2(r1.a.a(this.f٨٧٧٣q0, i10));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // f8.i, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!I1(this.J) && !I1(this.K) && !I1(this.N) && ((!this.M0 || !I1(this.N0)) && !K1(this.f٨٧٨٠x0.e()) && !L0() && !J1(this.S) && !J1(this.f٨٧٦١e0) && !I1(this.J0))) {
            return false;
        }
        return true;
    }

    public CharSequence j1() {
        return this.f٨٧٥٨b0;
    }

    public void j2(int i10) {
        k2(this.f٨٧٧٣q0.getResources().getBoolean(i10));
    }

    public float k1() {
        return this.f٨٧٧١o0;
    }

    public void k2(boolean z10) {
        if (this.R != z10) {
            boolean g32 = g3();
            this.R = z10;
            boolean g33 = g3();
            if (g32 != g33) {
                if (g33) {
                    B0(this.S);
                } else {
                    i3(this.S);
                }
                invalidateSelf();
                M1();
            }
        }
    }

    public float l1() {
        return this.f٨٧٥٧a0;
    }

    public void l2(float f10) {
        if (this.L != f10) {
            this.L = f10;
            invalidateSelf();
            M1();
        }
    }

    public float m1() {
        return this.f٨٧٧٠n0;
    }

    public void m2(int i10) {
        l2(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    public int[] n1() {
        return this.L0;
    }

    public void n2(float f10) {
        if (this.f٨٧٦٥i0 != f10) {
            this.f٨٧٦٥i0 = f10;
            invalidateSelf();
            M1();
        }
    }

    public ColorStateList o1() {
        return this.Z;
    }

    public void o2(int i10) {
        n2(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (g3()) {
            onLayoutDirectionChanged |= b.m(this.S, i10);
        }
        if (f3()) {
            onLayoutDirectionChanged |= b.m(this.f٨٧٦١e0, i10);
        }
        if (h3()) {
            onLayoutDirectionChanged |= b.m(this.X, i10);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        boolean onLevelChange = super.onLevelChange(i10);
        if (g3()) {
            onLevelChange |= this.S.setLevel(i10);
        }
        if (f3()) {
            onLevelChange |= this.f٨٧٦١e0.setLevel(i10);
        }
        if (h3()) {
            onLevelChange |= this.X.setLevel(i10);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // f8.i, android.graphics.drawable.Drawable, com.google.android.material.internal.e0.b
    public boolean onStateChange(int[] iArr) {
        if (this.S0) {
            super.onStateChange(iArr);
        }
        return N1(iArr, n1());
    }

    public void p1(RectF rectF) {
        G0(getBounds(), rectF);
    }

    public void p2(ColorStateList colorStateList) {
        if (this.N != colorStateList) {
            this.N = colorStateList;
            if (this.S0) {
                t0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void q2(int i10) {
        p2(r1.a.a(this.f٨٧٧٣q0, i10));
    }

    public void r2(float f10) {
        if (this.O != f10) {
            this.O = f10;
            this.f٨٧٧٤r0.setStrokeWidth(f10);
            if (this.S0) {
                super.u0(f10);
            }
            invalidateSelf();
        }
    }

    public TextUtils.TruncateAt s1() {
        return this.P0;
    }

    public void s2(int i10) {
        r2(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // f8.i, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.G0 != i10) {
            this.G0 = i10;
            invalidateSelf();
        }
    }

    @Override // f8.i, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.H0 != colorFilter) {
            this.H0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // f8.i, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.J0 != colorStateList) {
            this.J0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // f8.i, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.K0 != mode) {
            this.K0 = mode;
            this.I0 = com.google.android.material.drawable.g.o(this, this.J0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (g3()) {
            visible |= this.S.setVisible(z10, z11);
        }
        if (f3()) {
            visible |= this.f٨٧٦١e0.setVisible(z10, z11);
        }
        if (h3()) {
            visible |= this.X.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public h t1() {
        return this.f٨٧٦٤h0;
    }

    public float u1() {
        return this.f٨٧٦٧k0;
    }

    public void u2(Drawable drawable) {
        Drawable drawable2;
        Drawable i12 = i1();
        if (i12 != drawable) {
            float H0 = H0();
            if (drawable != null) {
                drawable2 = b.r(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.X = drawable2;
            k3();
            float H02 = H0();
            i3(i12);
            if (h3()) {
                B0(this.X);
            }
            invalidateSelf();
            if (H0 != H02) {
                M1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public float v1() {
        return this.f٨٧٦٦j0;
    }

    public void v2(CharSequence charSequence) {
        if (this.f٨٧٥٨b0 != charSequence) {
            this.f٨٧٥٨b0 = l2.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public ColorStateList w1() {
        return this.P;
    }

    public void w2(float f10) {
        if (this.f٨٧٧١o0 != f10) {
            this.f٨٧٧١o0 = f10;
            invalidateSelf();
            if (h3()) {
                M1();
            }
        }
    }

    public h x1() {
        return this.f٨٧٦٣g0;
    }

    public void x2(int i10) {
        w2(this.f٨٧٧٣q0.getResources().getDimension(i10));
    }

    public CharSequence y1() {
        return this.Q;
    }

    public void y2(int i10) {
        u2(r1.a.b(this.f٨٧٧٣q0, i10));
    }

    public e z1() {
        return this.f٨٧٨٠x0.e();
    }

    public void z2(float f10) {
        if (this.f٨٧٥٧a0 != f10) {
            this.f٨٧٥٧a0 = f10;
            invalidateSelf();
            if (h3()) {
                M1();
            }
        }
    }
}
