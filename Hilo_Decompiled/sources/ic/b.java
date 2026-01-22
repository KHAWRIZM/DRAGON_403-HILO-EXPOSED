package ic;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.d1;
import androidx.core.view.t;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import io.agora.rtc.Constants;
import l2.o;
import l2.p;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b {
    private static final boolean Z = false;

    /* renamed from: a0, reason: collision with root package name */
    private static final Paint f١٤٨٢٥a0 = null;
    private Typeface A;

    /* renamed from: B, reason: collision with root package name */
    private float f١٤٨٢٦B;
    private CharSequence C;
    private CharSequence D;
    private boolean E;
    private boolean F;
    private Bitmap G;
    private Paint H;
    private float I;
    private float J;
    private float K;
    private float L;
    private int[] M;
    private boolean N;
    private final TextPaint O;
    private Interpolator P;
    private Interpolator Q;
    private float R;
    private float S;
    private float T;
    private int U;
    private float V;
    private float W;
    private float X;
    private int Y;

    /* renamed from: a, reason: collision with root package name */
    private final View f١٤٨٢٧a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٤٨٢٨b;

    /* renamed from: c, reason: collision with root package name */
    private float f١٤٨٢٩c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f١٤٨٣٠d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f١٤٨٣١e;

    /* renamed from: f, reason: collision with root package name */
    private final RectF f١٤٨٣٢f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٤٨٣٣g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٤٨٣٤h;

    /* renamed from: i, reason: collision with root package name */
    private float f١٤٨٣٥i;

    /* renamed from: j, reason: collision with root package name */
    private float f١٤٨٣٦j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f١٤٨٣٧k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f١٤٨٣٨l;

    /* renamed from: m, reason: collision with root package name */
    private float f١٤٨٣٩m;

    /* renamed from: n, reason: collision with root package name */
    private float f١٤٨٤٠n;

    /* renamed from: o, reason: collision with root package name */
    private float f١٤٨٤١o;

    /* renamed from: p, reason: collision with root package name */
    private float f١٤٨٤٢p;

    /* renamed from: q, reason: collision with root package name */
    private float f١٤٨٤٣q;

    /* renamed from: r, reason: collision with root package name */
    private float f١٤٨٤٤r;

    /* renamed from: s, reason: collision with root package name */
    private float f١٤٨٤٥s;

    /* renamed from: t, reason: collision with root package name */
    private float f١٤٨٤٦t;

    /* renamed from: u, reason: collision with root package name */
    private float f١٤٨٤٧u;

    /* renamed from: v, reason: collision with root package name */
    private float f١٤٨٤٨v;

    /* renamed from: w, reason: collision with root package name */
    private float f١٤٨٤٩w;

    /* renamed from: x, reason: collision with root package name */
    private float f١٤٨٥٠x;

    /* renamed from: y, reason: collision with root package name */
    private Typeface f١٤٨٥١y;

    /* renamed from: z, reason: collision with root package name */
    private Typeface f١٤٨٥٢z;

    public b(View view) {
        this(view, DownloadProgress.UNKNOWN_PROGRESS);
    }

    private static boolean B(Rect rect, int i10, int i11, int i12, int i13) {
        if (rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13) {
            return true;
        }
        return false;
    }

    private void O(float f10) {
        boolean z10;
        e(f10);
        if (Z && this.K != 1.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.F = z10;
        if (z10) {
            h();
        }
        d1.h0(this.f١٤٨٢٧a);
    }

    private boolean c(CharSequence charSequence) {
        o oVar;
        if (d1.D(this.f١٤٨٢٧a) == 1) {
            oVar = p.f١٥٧٢١d;
        } else {
            oVar = p.f١٥٧٢٠c;
        }
        return oVar.a(charSequence, 0, charSequence.length());
    }

    private void d(float f10) {
        u(f10);
        this.f١٤٨٤٣q = x(this.f١٤٨٤١o, this.f١٤٨٤٢p, f10, this.P);
        this.f١٤٨٤٤r = x(this.f١٤٨٣٩m, this.f١٤٨٤٠n, f10, this.P);
        this.f١٤٨٥٠x = x(this.f١٤٨٤٩w, this.f١٤٨٤٨v, f10, this.P);
        this.f١٤٨٤٧u = x(this.f١٤٨٤٦t, this.f١٤٨٤٥s, f10, this.P);
        O(x(this.f١٤٨٣٥i, this.f١٤٨٣٦j, f10, this.Q));
        if (this.f١٤٨٣٨l != this.f١٤٨٣٧k) {
            this.O.setColor(c.a(n(), m(), f10));
        } else {
            this.O.setColor(m());
        }
        this.O.setShadowLayer(x(this.V, this.R, f10, null), x(this.W, this.S, f10, null), x(this.X, this.T, f10, null), c.a(this.Y, this.U, f10));
        d1.h0(this.f١٤٨٢٧a);
    }

    private void e(float f10) {
        boolean z10;
        float f11;
        if (this.C == null) {
            return;
        }
        float width = this.f١٤٨٣١e.width();
        float width2 = this.f١٤٨٣٠d.width();
        float f12 = this.f١٤٨٢٩c;
        float f13 = this.f١٤٨٢٦B;
        boolean z11 = true;
        if (f12 >= 1.0f - f13) {
            Typeface typeface = this.A;
            Typeface typeface2 = this.f١٤٨٥١y;
            if (typeface != typeface2) {
                this.A = typeface2;
                z10 = true;
            }
            z10 = false;
        } else {
            if (f12 <= f13) {
                Typeface typeface3 = this.A;
                Typeface typeface4 = this.f١٤٨٥٢z;
                if (typeface3 != typeface4) {
                    this.A = typeface4;
                    z10 = true;
                }
            }
            z10 = false;
        }
        if (v(f10, this.f١٤٨٣٦j)) {
            f11 = this.f١٤٨٣٦j;
            this.K = 1.0f;
        } else {
            float f14 = this.f١٤٨٣٥i;
            if (v(f10, f14)) {
                this.K = 1.0f;
            } else {
                this.K = f10 / this.f١٤٨٣٥i;
            }
            float f15 = this.f١٤٨٣٦j / this.f١٤٨٣٥i;
            if (width2 * f15 > width) {
                width = Math.min(width / f15, width2);
            } else {
                width = width2;
            }
            f11 = f14;
        }
        if (width > DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.L == f11 && !this.N && !z10) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.L = f11;
            this.N = false;
        }
        if (this.D == null || z10) {
            this.O.setTextSize(this.L);
            this.O.setTypeface(this.A);
            TextPaint textPaint = this.O;
            if (this.K == 1.0f) {
                z11 = false;
            }
            textPaint.setLinearText(z11);
            CharSequence ellipsize = TextUtils.ellipsize(this.C, this.O, width, TextUtils.TruncateAt.END);
            if (!TextUtils.equals(ellipsize, this.D)) {
                this.D = ellipsize;
                this.E = c(ellipsize);
            }
        }
    }

    private void f() {
        Bitmap bitmap = this.G;
        if (bitmap != null) {
            bitmap.recycle();
            this.G = null;
        }
    }

    private void h() {
        if (this.G == null && !this.f١٤٨٣٠d.isEmpty() && !TextUtils.isEmpty(this.D)) {
            d(DownloadProgress.UNKNOWN_PROGRESS);
            this.I = this.O.ascent();
            this.J = this.O.descent();
            TextPaint textPaint = this.O;
            CharSequence charSequence = this.D;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.J - this.I);
            if (round > 0 && round2 > 0) {
                this.G = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.G);
                CharSequence charSequence2 = this.D;
                canvas.drawText(charSequence2, 0, charSequence2.length(), DownloadProgress.UNKNOWN_PROGRESS, round2 - this.O.descent(), this.O);
                if (this.H == null) {
                    this.H = new Paint(3);
                }
            }
        }
    }

    private int m() {
        ColorStateList colorStateList = this.f١٤٨٣٨l;
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.M;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private int n() {
        ColorStateList colorStateList = this.f١٤٨٣٧k;
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.M;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private void u(float f10) {
        this.f١٤٨٣٢f.left = x(this.f١٤٨٣٠d.left, this.f١٤٨٣١e.left, f10, this.P);
        this.f١٤٨٣٢f.top = x(this.f١٤٨٣٩m, this.f١٤٨٤٠n, f10, this.P);
        this.f١٤٨٣٢f.right = x(this.f١٤٨٣٠d.right, this.f١٤٨٣١e.right, f10, this.P);
        this.f١٤٨٣٢f.bottom = x(this.f١٤٨٣٠d.bottom, this.f١٤٨٣١e.bottom, f10, this.P);
    }

    private static boolean v(float f10, float f11) {
        if (Math.abs(f10 - f11) < 0.001f) {
            return true;
        }
        return false;
    }

    public static float x(float f10, float f11, float f12, Interpolator interpolator) {
        if (interpolator != null) {
            f12 = interpolator.getInterpolation(f12);
        }
        return f10 + Math.round(f12 * (f11 - f10));
    }

    private Typeface z(int i10) {
        TypedArray obtainStyledAttributes = this.f١٤٨٢٧a.getContext().obtainStyledAttributes(i10, new int[]{R.attr.fontFamily});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void A() {
        if (this.f١٤٨٢٧a.getHeight() > 0 && this.f١٤٨٢٧a.getWidth() > 0) {
            a();
            b();
        }
    }

    public void C(int i10, int i11, int i12, int i13) {
        if (!B(this.f١٤٨٣١e, i10, i11, i12, i13)) {
            this.f١٤٨٣١e.set(i10, i11, i12, i13);
            this.N = true;
            y();
        }
    }

    public void D(int i10) {
        TypedArray obtainStyledAttributes = this.f١٤٨٢٧a.getContext().obtainStyledAttributes(i10, com.qmuiteam.qmui.R.styleable.QMUITextAppearance);
        int i11 = com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_textColor;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f١٤٨٣٨l = obtainStyledAttributes.getColorStateList(i11);
        }
        if (obtainStyledAttributes.hasValue(com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_textSize)) {
            this.f١٤٨٣٦j = obtainStyledAttributes.getDimensionPixelSize(r1, (int) this.f١٤٨٣٦j);
        }
        this.U = obtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_shadowColor, 0);
        this.S = obtainStyledAttributes.getFloat(com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_shadowDx, DownloadProgress.UNKNOWN_PROGRESS);
        this.T = obtainStyledAttributes.getFloat(com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_shadowDy, DownloadProgress.UNKNOWN_PROGRESS);
        this.R = obtainStyledAttributes.getFloat(com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_shadowRadius, DownloadProgress.UNKNOWN_PROGRESS);
        obtainStyledAttributes.recycle();
        this.f١٤٨٥١y = z(i10);
        A();
    }

    public void E(ColorStateList colorStateList) {
        if (this.f١٤٨٣٨l != colorStateList) {
            this.f١٤٨٣٨l = colorStateList;
            A();
        }
    }

    public void F(int i10) {
        if (this.f١٤٨٣٤h != i10) {
            this.f١٤٨٣٤h = i10;
            A();
        }
    }

    public void G(Typeface typeface) {
        if (this.f١٤٨٥١y != typeface) {
            this.f١٤٨٥١y = typeface;
            A();
        }
    }

    public void H(int i10, int i11, int i12, int i13) {
        if (!B(this.f١٤٨٣٠d, i10, i11, i12, i13)) {
            this.f١٤٨٣٠d.set(i10, i11, i12, i13);
            this.N = true;
            y();
        }
    }

    public void I(int i10) {
        TypedArray obtainStyledAttributes = this.f١٤٨٢٧a.getContext().obtainStyledAttributes(i10, com.qmuiteam.qmui.R.styleable.QMUITextAppearance);
        int i11 = com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_textColor;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f١٤٨٣٧k = obtainStyledAttributes.getColorStateList(i11);
        }
        if (obtainStyledAttributes.hasValue(com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_textSize)) {
            this.f١٤٨٣٥i = obtainStyledAttributes.getDimensionPixelSize(r1, (int) this.f١٤٨٣٥i);
        }
        this.Y = obtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_shadowColor, 0);
        this.W = obtainStyledAttributes.getFloat(com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_shadowDx, DownloadProgress.UNKNOWN_PROGRESS);
        this.X = obtainStyledAttributes.getFloat(com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_shadowDy, DownloadProgress.UNKNOWN_PROGRESS);
        this.V = obtainStyledAttributes.getFloat(com.qmuiteam.qmui.R.styleable.QMUITextAppearance_android_shadowRadius, DownloadProgress.UNKNOWN_PROGRESS);
        obtainStyledAttributes.recycle();
        this.f١٤٨٥٢z = z(i10);
        A();
    }

    public void J(ColorStateList colorStateList) {
        if (this.f١٤٨٣٧k != colorStateList) {
            this.f١٤٨٣٧k = colorStateList;
            A();
        }
    }

    public void K(int i10) {
        if (this.f١٤٨٣٣g != i10) {
            this.f١٤٨٣٣g = i10;
            A();
        }
    }

    public void L(Typeface typeface) {
        if (this.f١٤٨٥٢z != typeface) {
            this.f١٤٨٥٢z = typeface;
            A();
        }
    }

    public void M(float f10) {
        float b10 = g.b(f10, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        if (b10 != this.f١٤٨٢٩c) {
            this.f١٤٨٢٩c = b10;
            b();
        }
    }

    public void N(int i10, int i11, boolean z10) {
        if (this.f١٤٨٣٤h != i10 || this.f١٤٨٣٣g != i11) {
            this.f١٤٨٣٤h = i10;
            this.f١٤٨٣٣g = i11;
            if (z10) {
                A();
            }
        }
    }

    public void P(Interpolator interpolator) {
        this.P = interpolator;
        A();
    }

    public final boolean Q(int[] iArr) {
        this.M = iArr;
        if (w()) {
            A();
            return true;
        }
        return false;
    }

    public void R(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.C)) {
            this.C = charSequence;
            this.D = null;
            f();
            A();
        }
    }

    public void S(ColorStateList colorStateList, ColorStateList colorStateList2, boolean z10) {
        if (this.f١٤٨٣٨l != colorStateList || this.f١٤٨٣٧k != colorStateList2) {
            this.f١٤٨٣٨l = colorStateList;
            this.f١٤٨٣٧k = colorStateList2;
            if (z10) {
                A();
            }
        }
    }

    public void T(float f10, float f11, boolean z10) {
        if (this.f١٤٨٣٥i != f11 || this.f١٤٨٣٦j != f10) {
            this.f١٤٨٣٥i = f11;
            this.f١٤٨٣٦j = f10;
            if (z10) {
                A();
            }
        }
    }

    public void U(Interpolator interpolator) {
        this.Q = interpolator;
        A();
    }

    public void V(Typeface typeface, Typeface typeface2, boolean z10) {
        if (this.f١٤٨٥١y != typeface || this.f١٤٨٥٢z != typeface2) {
            this.f١٤٨٥١y = typeface;
            this.f١٤٨٥٢z = typeface2;
            if (z10) {
                A();
            }
        }
    }

    public void W(float f10) {
        this.f١٤٨٢٦B = f10;
    }

    public void a() {
        float f10;
        float f11 = this.L;
        e(this.f١٤٨٣٦j);
        CharSequence charSequence = this.D;
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        if (charSequence != null) {
            f10 = this.O.measureText(charSequence, 0, charSequence.length());
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        this.f١٤٨٤٥s = f10;
        this.f١٤٨٤٨v = this.O.descent() - this.O.ascent();
        int b10 = t.b(this.f١٤٨٣٤h, this.E ? 1 : 0);
        int i10 = b10 & 112;
        if (i10 != 48) {
            if (i10 != 80) {
                this.f١٤٨٤٠n = this.f١٤٨٣١e.centerY() + ((this.f١٤٨٤٨v / 2.0f) - this.O.descent());
            } else {
                this.f١٤٨٤٠n = this.f١٤٨٣١e.bottom - this.O.descent();
            }
        } else {
            this.f١٤٨٤٠n = this.f١٤٨٣١e.top - this.O.ascent();
        }
        int i11 = b10 & 8388615;
        if (i11 != 1) {
            if (i11 != 5) {
                this.f١٤٨٤٢p = this.f١٤٨٣١e.left;
            } else {
                this.f١٤٨٤٢p = this.f١٤٨٣١e.right - this.f١٤٨٤٥s;
            }
        } else {
            this.f١٤٨٤٢p = this.f١٤٨٣١e.centerX() - (this.f١٤٨٤٥s / 2.0f);
        }
        e(this.f١٤٨٣٥i);
        CharSequence charSequence2 = this.D;
        if (charSequence2 != null) {
            f12 = this.O.measureText(charSequence2, 0, charSequence2.length());
        }
        this.f١٤٨٤٦t = f12;
        this.f١٤٨٤٩w = this.O.descent() - this.O.ascent();
        int b11 = t.b(this.f١٤٨٣٣g, this.E ? 1 : 0);
        int i12 = b11 & 112;
        if (i12 != 48) {
            if (i12 != 80) {
                this.f١٤٨٣٩m = this.f١٤٨٣٠d.centerY() + ((this.f١٤٨٤٩w / 2.0f) - this.O.descent());
            } else {
                this.f١٤٨٣٩m = this.f١٤٨٣٠d.bottom - this.O.descent();
            }
        } else {
            this.f١٤٨٣٩m = this.f١٤٨٣٠d.top - this.O.ascent();
        }
        int i13 = b11 & 8388615;
        if (i13 != 1) {
            if (i13 != 5) {
                this.f١٤٨٤١o = this.f١٤٨٣٠d.left;
            } else {
                this.f١٤٨٤١o = this.f١٤٨٣٠d.right - this.f١٤٨٤٦t;
            }
        } else {
            this.f١٤٨٤١o = this.f١٤٨٣٠d.centerX() - (this.f١٤٨٤٦t / 2.0f);
        }
        f();
        O(f11);
    }

    public void b() {
        d(this.f١٤٨٢٩c);
    }

    public void g(Canvas canvas) {
        boolean z10;
        float ascent;
        int save = canvas.save();
        if (this.D != null && this.f١٤٨٢٨b) {
            float f10 = this.f١٤٨٤٣q;
            float f11 = this.f١٤٨٤٤r;
            if (this.F && this.G != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                ascent = this.I * this.K;
            } else {
                ascent = this.O.ascent() * this.K;
                this.O.descent();
            }
            if (z10) {
                f11 += ascent;
            }
            float f12 = f11;
            float f13 = this.K;
            if (f13 != 1.0f) {
                canvas.scale(f13, f13, f10, f12);
            }
            if (z10) {
                canvas.drawBitmap(this.G, f10, f12, this.H);
            } else {
                CharSequence charSequence = this.D;
                canvas.drawText(charSequence, 0, charSequence.length(), f10, f12, this.O);
            }
        }
        canvas.restoreToCount(save);
    }

    public int i() {
        return this.f١٤٨٣٤h;
    }

    public float j() {
        return this.f١٤٨٤٨v;
    }

    public float k() {
        return this.f١٤٨٤٥s;
    }

    public Typeface l() {
        Typeface typeface = this.f١٤٨٥١y;
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
    }

    public int o() {
        return this.f١٤٨٣٣g;
    }

    public float p() {
        return this.f١٤٨٤٩w;
    }

    public float q() {
        return this.f١٤٨٤٦t;
    }

    public Typeface r() {
        Typeface typeface = this.f١٤٨٥٢z;
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
    }

    public float s() {
        return this.f١٤٨٢٩c;
    }

    public CharSequence t() {
        return this.C;
    }

    public final boolean w() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f١٤٨٣٨l;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f١٤٨٣٧k) != null && colorStateList.isStateful())) {
            return true;
        }
        return false;
    }

    void y() {
        boolean z10;
        if (this.f١٤٨٣١e.width() > 0 && this.f١٤٨٣١e.height() > 0 && this.f١٤٨٣٠d.width() > 0 && this.f١٤٨٣٠d.height() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f١٤٨٢٨b = z10;
    }

    public b(View view, float f10) {
        this.f١٤٨٣٣g = 16;
        this.f١٤٨٣٤h = 16;
        this.f١٤٨٣٥i = 15.0f;
        this.f١٤٨٣٦j = 15.0f;
        this.f١٤٨٢٧a = view;
        this.O = new TextPaint(Constants.ERR_WATERMARK_READ);
        this.f١٤٨٢٩c = f10;
        this.f١٤٨٣١e = new Rect();
        this.f١٤٨٣٠d = new Rect();
        this.f١٤٨٣٢f = new RectF();
    }
}
