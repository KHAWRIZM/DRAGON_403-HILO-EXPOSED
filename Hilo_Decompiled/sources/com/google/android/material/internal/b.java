package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import c8.a;
import com.google.android.material.internal.c0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import io.agora.rtc.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b {
    private Typeface A;

    /* renamed from: B, reason: collision with root package name */
    private Typeface f٩٢١٩B;
    private Typeface C;
    private Typeface D;
    private c8.a E;
    private c8.a F;
    private CharSequence H;
    private CharSequence I;
    private boolean J;
    private float L;
    private float M;
    private float N;
    private float O;
    private float P;
    private int Q;
    private int R;
    private int[] S;
    private boolean T;
    private final TextPaint U;
    private final TextPaint V;
    private TimeInterpolator W;
    private TimeInterpolator X;
    private float Y;
    private float Z;

    /* renamed from: a, reason: collision with root package name */
    private final View f٩٢٢٠a;

    /* renamed from: a0, reason: collision with root package name */
    private float f٩٢٢١a0;

    /* renamed from: b, reason: collision with root package name */
    private float f٩٢٢٢b;

    /* renamed from: b0, reason: collision with root package name */
    private ColorStateList f٩٢٢٣b0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٩٢٢٤c;

    /* renamed from: c0, reason: collision with root package name */
    private float f٩٢٢٥c0;

    /* renamed from: d, reason: collision with root package name */
    private float f٩٢٢٦d;

    /* renamed from: d0, reason: collision with root package name */
    private float f٩٢٢٧d0;

    /* renamed from: e, reason: collision with root package name */
    private float f٩٢٢٨e;

    /* renamed from: e0, reason: collision with root package name */
    private float f٩٢٢٩e0;

    /* renamed from: f, reason: collision with root package name */
    private int f٩٢٣٠f;

    /* renamed from: f0, reason: collision with root package name */
    private ColorStateList f٩٢٣١f0;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f٩٢٣٢g;

    /* renamed from: g0, reason: collision with root package name */
    private float f٩٢٣٣g0;

    /* renamed from: h, reason: collision with root package name */
    private final Rect f٩٢٣٤h;

    /* renamed from: h0, reason: collision with root package name */
    private float f٩٢٣٥h0;

    /* renamed from: i, reason: collision with root package name */
    private Rect f٩٢٣٦i;

    /* renamed from: i0, reason: collision with root package name */
    private float f٩٢٣٧i0;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f٩٢٣٨j;

    /* renamed from: j0, reason: collision with root package name */
    private StaticLayout f٩٢٣٩j0;

    /* renamed from: k0, reason: collision with root package name */
    private float f٩٢٤١k0;

    /* renamed from: l0, reason: collision with root package name */
    private float f٩٢٤٣l0;

    /* renamed from: m0, reason: collision with root package name */
    private float f٩٢٤٥m0;

    /* renamed from: n0, reason: collision with root package name */
    private CharSequence f٩٢٤٧n0;

    /* renamed from: o, reason: collision with root package name */
    private ColorStateList f٩٢٤٨o;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f٩٢٥٠p;

    /* renamed from: q, reason: collision with root package name */
    private int f٩٢٥٢q;

    /* renamed from: r, reason: collision with root package name */
    private float f٩٢٥٤r;

    /* renamed from: s, reason: collision with root package name */
    private float f٩٢٥٦s;

    /* renamed from: t, reason: collision with root package name */
    private float f٩٢٥٨t;

    /* renamed from: t0, reason: collision with root package name */
    private d0 f٩٢٥٩t0;

    /* renamed from: u, reason: collision with root package name */
    private float f٩٢٦٠u;

    /* renamed from: v, reason: collision with root package name */
    private float f٩٢٦٢v;

    /* renamed from: w, reason: collision with root package name */
    private float f٩٢٦٤w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f٩٢٦٥w0;

    /* renamed from: x, reason: collision with root package name */
    private Typeface f٩٢٦٦x;

    /* renamed from: y, reason: collision with root package name */
    private Typeface f٩٢٦٧y;

    /* renamed from: z, reason: collision with root package name */
    private Typeface f٩٢٦٨z;

    /* renamed from: k, reason: collision with root package name */
    private int f٩٢٤٠k = 16;

    /* renamed from: l, reason: collision with root package name */
    private int f٩٢٤٢l = 16;

    /* renamed from: m, reason: collision with root package name */
    private float f٩٢٤٤m = 15.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f٩٢٤٦n = 15.0f;
    private TextUtils.TruncateAt G = TextUtils.TruncateAt.END;
    private boolean K = true;

    /* renamed from: o0, reason: collision with root package name */
    private int f٩٢٤٩o0 = 1;

    /* renamed from: p0, reason: collision with root package name */
    private int f٩٢٥١p0 = 1;

    /* renamed from: q0, reason: collision with root package name */
    private float f٩٢٥٣q0 = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: r0, reason: collision with root package name */
    private float f٩٢٥٥r0 = 1.0f;

    /* renamed from: s0, reason: collision with root package name */
    private int f٩٢٥٧s0 = c0.f٩٢٧١o;

    /* renamed from: u0, reason: collision with root package name */
    private int f٩٢٦١u0 = -1;

    /* renamed from: v0, reason: collision with root package name */
    private int f٩٢٦٣v0 = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements a.InterfaceC٠٠٧٢a {
        a() {
        }

        @Override // c8.a.InterfaceC٠٠٧٢a
        public void a(Typeface typeface) {
            b.this.o0(typeface);
        }
    }

    /* renamed from: com.google.android.material.internal.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class C٠١١٥b implements a.InterfaceC٠٠٧٢a {
        C٠١١٥b() {
        }

        @Override // c8.a.InterfaceC٠٠٧٢a
        public void a(Typeface typeface) {
            b.this.B0(typeface);
        }
    }

    public b(View view) {
        this.f٩٢٢٠a = view;
        TextPaint textPaint = new TextPaint(Constants.ERR_WATERMARK_READ);
        this.U = textPaint;
        this.V = new TextPaint(textPaint);
        this.f٩٢٣٤h = new Rect();
        this.f٩٢٣٢g = new Rect();
        this.f٩٢٣٨j = new RectF();
        this.f٩٢٢٨e = e();
        Z(view.getContext().getResources().getConfiguration());
    }

    private boolean C0(Typeface typeface) {
        c8.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.C != typeface) {
            this.C = typeface;
            Typeface b10 = c8.k.b(this.f٩٢٢٠a.getContext().getResources().getConfiguration(), typeface);
            this.f٩٢١٩B = b10;
            if (b10 == null) {
                b10 = this.C;
            }
            this.A = b10;
            return true;
        }
        return false;
    }

    private void H0(float f10) {
        h(f10);
        this.f٩٢٢٠a.postInvalidateOnAnimation();
    }

    private Layout.Alignment N() {
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f٩٢٤٠k, this.J ? 1 : 0) & 7;
        if (absoluteGravity != 1) {
            if (absoluteGravity != 5) {
                if (this.J) {
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                return Layout.Alignment.ALIGN_NORMAL;
            }
            if (this.J) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private void Q(TextPaint textPaint) {
        textPaint.setTextSize(this.f٩٢٤٦n);
        textPaint.setTypeface(this.f٩٢٦٦x);
        textPaint.setLetterSpacing(this.f٩٢٣٣g0);
    }

    private void R(TextPaint textPaint) {
        textPaint.setTextSize(this.f٩٢٤٤m);
        textPaint.setTypeface(this.A);
        textPaint.setLetterSpacing(this.f٩٢٣٥h0);
    }

    private boolean S0() {
        if ((this.f٩٢٤٩o0 > 1 || this.f٩٢٥١p0 > 1) && (!this.J || this.f٩٢٢٤c)) {
            return true;
        }
        return false;
    }

    private void T(float f10) {
        Rect rect;
        if (this.f٩٢٢٤c) {
            RectF rectF = this.f٩٢٣٨j;
            if (f10 < this.f٩٢٢٨e) {
                rect = this.f٩٢٣٢g;
            } else {
                rect = this.f٩٢٣٤h;
            }
            rectF.set(rect);
            return;
        }
        this.f٩٢٣٨j.left = Y(this.f٩٢٣٢g.left, this.f٩٢٣٤h.left, f10, this.W);
        this.f٩٢٣٨j.top = Y(this.f٩٢٥٤r, this.f٩٢٥٦s, f10, this.W);
        this.f٩٢٣٨j.right = Y(this.f٩٢٣٢g.right, this.f٩٢٣٤h.right, f10, this.W);
        this.f٩٢٣٨j.bottom = Y(this.f٩٢٣٢g.bottom, this.f٩٢٣٤h.bottom, f10, this.W);
    }

    private boolean T0() {
        if (this.f٩٢٥١p0 == 1) {
            return true;
        }
        return false;
    }

    private static boolean U(float f10, float f11) {
        if (Math.abs(f10 - f11) < 1.0E-5f) {
            return true;
        }
        return false;
    }

    private boolean V() {
        if (this.f٩٢٢٠a.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private boolean X(CharSequence charSequence, boolean z10) {
        l2.o oVar;
        if (z10) {
            oVar = l2.p.f١٥٧٢١d;
        } else {
            oVar = l2.p.f١٥٧٢٠c;
        }
        return oVar.a(charSequence, 0, charSequence.length());
    }

    private static float Y(float f10, float f11, float f12, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return p7.a.a(f10, f11, f12);
    }

    private static int a(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb(Math.round((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), Math.round((Color.red(i10) * f11) + (Color.red(i11) * f10)), Math.round((Color.green(i10) * f11) + (Color.green(i11) * f10)), Math.round((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
    }

    private float a0(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private void b(boolean z10) {
        float f10;
        float f11;
        int i10;
        CharSequence charSequence;
        i(1.0f, z10);
        if (this.I != null && this.f٩٢٣٩j0 != null) {
            if (T0()) {
                charSequence = TextUtils.ellipsize(this.I, this.U, this.f٩٢٣٩j0.getWidth(), this.G);
            } else {
                charSequence = this.I;
            }
            this.f٩٢٤٧n0 = charSequence;
        }
        CharSequence charSequence2 = this.f٩٢٤٧n0;
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        if (charSequence2 != null) {
            this.f٩٢٤١k0 = a0(this.U, charSequence2);
        } else {
            this.f٩٢٤١k0 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f٩٢٤٢l, this.J ? 1 : 0);
        Rect rect = this.f٩٢٣٦i;
        if (rect == null) {
            rect = this.f٩٢٣٤h;
        }
        int i11 = absoluteGravity & 112;
        if (i11 != 48) {
            if (i11 != 80) {
                this.f٩٢٥٦s = rect.centerY() - ((this.U.descent() - this.U.ascent()) / 2.0f);
            } else {
                this.f٩٢٥٦s = rect.bottom + this.U.ascent();
            }
        } else {
            this.f٩٢٥٦s = rect.top;
        }
        int i12 = absoluteGravity & 8388615;
        if (i12 != 1) {
            if (i12 != 5) {
                this.f٩٢٦٠u = rect.left;
            } else {
                this.f٩٢٦٠u = rect.right - this.f٩٢٤١k0;
            }
        } else {
            this.f٩٢٦٠u = rect.centerX() - (this.f٩٢٤١k0 / 2.0f);
        }
        if (this.f٩٢٤١k0 <= this.f٩٢٣٤h.width()) {
            float f13 = this.f٩٢٦٠u;
            float max = f13 + Math.max(DownloadProgress.UNKNOWN_PROGRESS, this.f٩٢٣٤h.left - f13);
            this.f٩٢٦٠u = max;
            this.f٩٢٦٠u = max + Math.min(DownloadProgress.UNKNOWN_PROGRESS, this.f٩٢٣٤h.right - (this.f٩٢٤١k0 + max));
        }
        if (m() <= this.f٩٢٣٤h.height()) {
            float f14 = this.f٩٢٥٦s;
            float max2 = f14 + Math.max(DownloadProgress.UNKNOWN_PROGRESS, this.f٩٢٣٤h.top - f14);
            this.f٩٢٥٦s = max2;
            this.f٩٢٥٦s = max2 + Math.min(DownloadProgress.UNKNOWN_PROGRESS, this.f٩٢٣٤h.bottom - (r() + max2));
        }
        i(DownloadProgress.UNKNOWN_PROGRESS, z10);
        StaticLayout staticLayout = this.f٩٢٣٩j0;
        if (staticLayout != null) {
            f10 = staticLayout.getHeight();
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        StaticLayout staticLayout2 = this.f٩٢٣٩j0;
        if (staticLayout2 != null && this.f٩٢٤٩o0 > 1) {
            f11 = staticLayout2.getWidth();
        } else {
            CharSequence charSequence3 = this.I;
            if (charSequence3 != null) {
                f11 = a0(this.U, charSequence3);
            } else {
                f11 = DownloadProgress.UNKNOWN_PROGRESS;
            }
        }
        StaticLayout staticLayout3 = this.f٩٢٣٩j0;
        if (staticLayout3 != null) {
            i10 = staticLayout3.getLineCount();
        } else {
            i10 = 0;
        }
        this.f٩٢٥٢q = i10;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f٩٢٤٠k, this.J ? 1 : 0);
        int i13 = absoluteGravity2 & 112;
        if (i13 != 48) {
            if (i13 != 80) {
                this.f٩٢٥٤r = this.f٩٢٣٢g.centerY() - (f10 / 2.0f);
            } else {
                float f15 = this.f٩٢٣٢g.bottom - f10;
                if (this.f٩٢٦٥w0) {
                    f12 = this.U.descent();
                }
                this.f٩٢٥٤r = f15 + f12;
            }
        } else {
            this.f٩٢٥٤r = this.f٩٢٣٢g.top;
        }
        int i14 = absoluteGravity2 & 8388615;
        if (i14 != 1) {
            if (i14 != 5) {
                this.f٩٢٥٨t = this.f٩٢٣٢g.left;
            } else {
                this.f٩٢٥٨t = this.f٩٢٣٢g.right - f11;
            }
        } else {
            this.f٩٢٥٨t = this.f٩٢٣٢g.centerX() - (f11 / 2.0f);
        }
        H0(this.f٩٢٢٢b);
    }

    private void c() {
        g(this.f٩٢٢٢b);
    }

    private float d(float f10) {
        float f11 = this.f٩٢٢٨e;
        if (f10 <= f11) {
            return p7.a.b(1.0f, DownloadProgress.UNKNOWN_PROGRESS, this.f٩٢٢٦d, f11, f10);
        }
        return p7.a.b(DownloadProgress.UNKNOWN_PROGRESS, 1.0f, f11, 1.0f, f10);
    }

    private static boolean d0(Rect rect, int i10, int i11, int i12, int i13) {
        if (rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13) {
            return true;
        }
        return false;
    }

    private float e() {
        float f10 = this.f٩٢٢٦d;
        return f10 + ((1.0f - f10) * 0.5f);
    }

    private boolean f(CharSequence charSequence) {
        boolean V = V();
        if (this.K) {
            return X(charSequence, V);
        }
        return V;
    }

    private void g(float f10) {
        float f11;
        T(f10);
        if (this.f٩٢٢٤c) {
            if (f10 < this.f٩٢٢٨e) {
                this.f٩٢٦٢v = this.f٩٢٥٨t;
                this.f٩٢٦٤w = this.f٩٢٥٤r;
                H0(DownloadProgress.UNKNOWN_PROGRESS);
                f11 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                this.f٩٢٦٢v = this.f٩٢٦٠u;
                this.f٩٢٦٤w = this.f٩٢٥٦s - Math.max(0, this.f٩٢٣٠f);
                H0(1.0f);
                f11 = 1.0f;
            }
        } else {
            this.f٩٢٦٢v = Y(this.f٩٢٥٨t, this.f٩٢٦٠u, f10, this.W);
            this.f٩٢٦٤w = Y(this.f٩٢٥٤r, this.f٩٢٥٦s, f10, this.W);
            H0(f10);
            f11 = f10;
        }
        TimeInterpolator timeInterpolator = p7.a.f١٦٩٤٨b;
        k0(1.0f - Y(DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 1.0f - f10, timeInterpolator));
        x0(Y(1.0f, DownloadProgress.UNKNOWN_PROGRESS, f10, timeInterpolator));
        if (this.f٩٢٥٠p != this.f٩٢٤٨o) {
            this.U.setColor(a(y(), w(), f11));
        } else {
            this.U.setColor(w());
        }
        float f12 = this.f٩٢٣٣g0;
        float f13 = this.f٩٢٣٥h0;
        if (f12 != f13) {
            this.U.setLetterSpacing(Y(f13, f12, f10, timeInterpolator));
        } else {
            this.U.setLetterSpacing(f12);
        }
        this.N = Y(this.f٩٢٢٥c0, this.Y, f10, null);
        this.O = Y(this.f٩٢٢٧d0, this.Z, f10, null);
        this.P = Y(this.f٩٢٢٩e0, this.f٩٢٢١a0, f10, null);
        int a10 = a(x(this.f٩٢٣١f0), x(this.f٩٢٢٣b0), f10);
        this.Q = a10;
        this.U.setShadowLayer(this.N, this.O, this.P, a10);
        if (this.f٩٢٢٤c) {
            this.U.setAlpha((int) (d(f10) * this.U.getAlpha()));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.U;
                textPaint.setShadowLayer(this.N, this.O, this.P, v7.a.a(this.Q, textPaint.getAlpha()));
            }
        }
        this.f٩٢٢٠a.postInvalidateOnAnimation();
    }

    private void h(float f10) {
        i(f10, false);
    }

    private void i(float f10, boolean z10) {
        Typeface typeface;
        float f11;
        float f12;
        int i10;
        int i11;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        float Y;
        if (this.H == null) {
            return;
        }
        float width = this.f٩٢٣٤h.width();
        float width2 = this.f٩٢٣٢g.width();
        float f13 = 1.0f;
        if (U(f10, 1.0f)) {
            if (T0()) {
                f11 = this.f٩٢٤٦n;
            } else {
                f11 = this.f٩٢٤٤m;
            }
            if (T0()) {
                f12 = this.f٩٢٣٣g0;
            } else {
                f12 = this.f٩٢٣٥h0;
            }
            if (T0()) {
                Y = 1.0f;
            } else {
                Y = Y(this.f٩٢٤٤m, this.f٩٢٤٦n, f10, this.X) / this.f٩٢٤٤m;
            }
            this.L = Y;
            if (!T0()) {
                width = width2;
            }
            typeface = this.f٩٢٦٦x;
            width2 = width;
        } else {
            float f14 = this.f٩٢٤٤m;
            float f15 = this.f٩٢٣٥h0;
            typeface = this.A;
            if (U(f10, DownloadProgress.UNKNOWN_PROGRESS)) {
                this.L = 1.0f;
            } else {
                this.L = Y(this.f٩٢٤٤m, this.f٩٢٤٦n, f10, this.X) / this.f٩٢٤٤m;
            }
            float f16 = this.f٩٢٤٦n / this.f٩٢٤٤m;
            float f17 = width2 * f16;
            if (!z10 && !this.f٩٢٢٤c && f17 > width && T0()) {
                width2 = Math.min(width / f16, width2);
            }
            f11 = f14;
            f12 = f15;
        }
        if (f10 < 0.5f) {
            i10 = this.f٩٢٤٩o0;
        } else {
            i10 = this.f٩٢٥١p0;
        }
        boolean z17 = false;
        if (width2 > DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.M != f11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (this.f٩٢٣٧i0 != f12) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (this.D != typeface) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (this.f٩٢٣٩j0 != null && width2 != r9.getWidth()) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (this.R != i10) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (!z11 && !z12 && !z14 && !z13 && !z15 && !this.T) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.M = f11;
            this.f٩٢٣٧i0 = f12;
            this.D = typeface;
            this.T = false;
            this.R = i10;
            TextPaint textPaint = this.U;
            if (this.L != 1.0f) {
                z17 = true;
            }
            textPaint.setLinearText(z17);
            z17 = z16;
        }
        if (this.I == null || z17) {
            this.U.setTextSize(this.M);
            this.U.setTypeface(this.D);
            this.U.setLetterSpacing(this.f٩٢٣٧i0);
            this.J = f(this.H);
            if (S0()) {
                i11 = i10;
            } else {
                i11 = 1;
            }
            TextPaint textPaint2 = this.U;
            CharSequence charSequence = this.H;
            if (!T0()) {
                f13 = this.L;
            }
            StaticLayout j10 = j(i11, textPaint2, charSequence, width2 * f13, this.J);
            this.f٩٢٣٩j0 = j10;
            this.I = j10.getText();
        }
    }

    private StaticLayout j(int i10, TextPaint textPaint, CharSequence charSequence, float f10, boolean z10) {
        StaticLayout staticLayout;
        Layout.Alignment N;
        try {
            if (i10 == 1) {
                N = Layout.Alignment.ALIGN_NORMAL;
            } else {
                N = N();
            }
            staticLayout = c0.c(charSequence, textPaint, (int) f10).e(this.G).h(z10).d(N).g(false).j(i10).i(this.f٩٢٥٣q0, this.f٩٢٥٥r0).f(this.f٩٢٥٧s0).k(this.f٩٢٥٩t0).a();
        } catch (c0.a e10) {
            Log.e("CollapsingTextHelper", e10.getCause().getMessage(), e10);
            staticLayout = null;
        }
        return (StaticLayout) androidx.core.util.h.g(staticLayout);
    }

    private void k0(float f10) {
        this.f٩٢٤٣l0 = f10;
        this.f٩٢٢٠a.postInvalidateOnAnimation();
    }

    private void l(Canvas canvas, float f10, float f11) {
        int alpha = this.U.getAlpha();
        canvas.translate(f10, f11);
        if (!this.f٩٢٢٤c) {
            this.U.setAlpha((int) (this.f٩٢٤٥m0 * alpha));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.U;
                textPaint.setShadowLayer(this.N, this.O, this.P, v7.a.a(this.Q, textPaint.getAlpha()));
            }
            this.f٩٢٣٩j0.draw(canvas);
        }
        if (!this.f٩٢٢٤c) {
            this.U.setAlpha((int) (this.f٩٢٤٣l0 * alpha));
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            TextPaint textPaint2 = this.U;
            textPaint2.setShadowLayer(this.N, this.O, this.P, v7.a.a(this.Q, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f٩٢٣٩j0.getLineBaseline(0);
        CharSequence charSequence = this.f٩٢٤٧n0;
        float f12 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), DownloadProgress.UNKNOWN_PROGRESS, f12, this.U);
        if (i10 >= 31) {
            this.U.setShadowLayer(this.N, this.O, this.P, this.Q);
        }
        if (!this.f٩٢٢٤c) {
            String trim = this.f٩٢٤٧n0.toString().trim();
            if (trim.endsWith("…")) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.U.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.f٩٢٣٩j0.getLineEnd(0), str.length()), DownloadProgress.UNKNOWN_PROGRESS, f12, (Paint) this.U);
        }
    }

    private boolean p0(Typeface typeface) {
        c8.a aVar = this.F;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f٩٢٦٨z != typeface) {
            this.f٩٢٦٨z = typeface;
            Typeface b10 = c8.k.b(this.f٩٢٢٠a.getContext().getResources().getConfiguration(), typeface);
            this.f٩٢٦٧y = b10;
            if (b10 == null) {
                b10 = this.f٩٢٦٨z;
            }
            this.f٩٢٦٦x = b10;
            return true;
        }
        return false;
    }

    private float s(int i10, int i11) {
        if (i11 != 17 && (i11 & 7) != 1) {
            if ((i11 & 8388613) != 8388613 && (i11 & 5) != 5) {
                if (this.J) {
                    return this.f٩٢٣٤h.right - this.f٩٢٤١k0;
                }
                return this.f٩٢٣٤h.left;
            }
            if (this.J) {
                return this.f٩٢٣٤h.left;
            }
            return this.f٩٢٣٤h.right - this.f٩٢٤١k0;
        }
        return (i10 / 2.0f) - (this.f٩٢٤١k0 / 2.0f);
    }

    private float t(RectF rectF, int i10, int i11) {
        if (i11 != 17 && (i11 & 7) != 1) {
            if ((i11 & 8388613) != 8388613 && (i11 & 5) != 5) {
                if (this.J) {
                    return this.f٩٢٣٤h.right;
                }
                return rectF.left + this.f٩٢٤١k0;
            }
            if (this.J) {
                return rectF.left + this.f٩٢٤١k0;
            }
            return this.f٩٢٣٤h.right;
        }
        return (i10 / 2.0f) + (this.f٩٢٤١k0 / 2.0f);
    }

    private int x(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.S;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private void x0(float f10) {
        this.f٩٢٤٥m0 = f10;
        this.f٩٢٢٠a.postInvalidateOnAnimation();
    }

    private int y() {
        return x(this.f٩٢٤٨o);
    }

    public int A() {
        return this.f٩٢٤٩o0;
    }

    public void A0(float f10) {
        if (this.f٩٢٤٤m != f10) {
            this.f٩٢٤٤m = f10;
            b0();
        }
    }

    public float B() {
        R(this.V);
        return (-this.V.ascent()) + this.V.descent();
    }

    public void B0(Typeface typeface) {
        if (C0(typeface)) {
            b0();
        }
    }

    public int C() {
        return this.f٩٢٤٠k;
    }

    public float D() {
        int i10 = this.f٩٢٦٣v0;
        if (i10 != -1) {
            return i10;
        }
        return E();
    }

    public void D0(float f10) {
        float a10 = j2.a.a(f10, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        if (a10 != this.f٩٢٢٢b) {
            this.f٩٢٢٢b = a10;
            c();
        }
    }

    public float E() {
        R(this.V);
        return -this.V.ascent();
    }

    public void E0(boolean z10) {
        this.f٩٢٢٤c = z10;
    }

    public float F() {
        return this.f٩٢٤٤m;
    }

    public void F0(float f10) {
        this.f٩٢٢٦d = f10;
        this.f٩٢٢٨e = e();
    }

    public Typeface G() {
        Typeface typeface = this.A;
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
    }

    public void G0(int i10) {
        this.f٩٢٥٧s0 = i10;
    }

    public float H() {
        return this.f٩٢٢٢b;
    }

    public float I() {
        return this.f٩٢٢٨e;
    }

    public void I0(float f10) {
        this.f٩٢٥٣q0 = f10;
    }

    public int J() {
        return this.f٩٢٥٧s0;
    }

    public void J0(float f10) {
        this.f٩٢٥٥r0 = f10;
    }

    public int K() {
        StaticLayout staticLayout = this.f٩٢٣٩j0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public void K0(TimeInterpolator timeInterpolator) {
        this.W = timeInterpolator;
        b0();
    }

    public float L() {
        return this.f٩٢٣٩j0.getSpacingAdd();
    }

    public void L0(boolean z10) {
        this.K = z10;
    }

    public float M() {
        return this.f٩٢٣٩j0.getSpacingMultiplier();
    }

    public final boolean M0(int[] iArr) {
        this.S = iArr;
        if (W()) {
            b0();
            return true;
        }
        return false;
    }

    public void N0(d0 d0Var) {
        if (this.f٩٢٥٩t0 != d0Var) {
            this.f٩٢٥٩t0 = d0Var;
            c0(true);
        }
    }

    public TimeInterpolator O() {
        return this.W;
    }

    public void O0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.H, charSequence)) {
            this.H = charSequence;
            this.I = null;
            b0();
        }
    }

    public CharSequence P() {
        return this.H;
    }

    public void P0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        b0();
    }

    public void Q0(TextUtils.TruncateAt truncateAt) {
        this.G = truncateAt;
        b0();
    }

    public void R0(Typeface typeface) {
        boolean p02 = p0(typeface);
        boolean C0 = C0(typeface);
        if (p02 || C0) {
            b0();
        }
    }

    public TextUtils.TruncateAt S() {
        return this.G;
    }

    public void U0(int i10) {
        Q(this.V);
        float f10 = i10;
        this.f٩٢٦١u0 = j(this.f٩٢٥١p0, this.V, this.H, f10 * (this.f٩٢٤٦n / this.f٩٢٤٤m), this.J).getHeight();
        R(this.V);
        this.f٩٢٦٣v0 = j(this.f٩٢٤٩o0, this.V, this.H, f10, this.J).getHeight();
    }

    public final boolean W() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f٩٢٥٠p;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f٩٢٤٨o) != null && colorStateList.isStateful())) {
            return true;
        }
        return false;
    }

    public void Z(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f٩٢٦٨z;
            if (typeface != null) {
                this.f٩٢٦٧y = c8.k.b(configuration, typeface);
            }
            Typeface typeface2 = this.C;
            if (typeface2 != null) {
                this.f٩٢١٩B = c8.k.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f٩٢٦٧y;
            if (typeface3 == null) {
                typeface3 = this.f٩٢٦٨z;
            }
            this.f٩٢٦٦x = typeface3;
            Typeface typeface4 = this.f٩٢١٩B;
            if (typeface4 == null) {
                typeface4 = this.C;
            }
            this.A = typeface4;
            c0(true);
        }
    }

    public void b0() {
        c0(false);
    }

    public void c0(boolean z10) {
        if ((this.f٩٢٢٠a.getHeight() > 0 && this.f٩٢٢٠a.getWidth() > 0) || z10) {
            b(z10);
            c();
        }
    }

    public void e0(ColorStateList colorStateList) {
        if (this.f٩٢٥٠p != colorStateList || this.f٩٢٤٨o != colorStateList) {
            this.f٩٢٥٠p = colorStateList;
            this.f٩٢٤٨o = colorStateList;
            b0();
        }
    }

    public void f0(int i10, int i11, int i12, int i13) {
        if (!d0(this.f٩٢٣٤h, i10, i11, i12, i13)) {
            this.f٩٢٣٤h.set(i10, i11, i12, i13);
            this.T = true;
        }
    }

    public void g0(Rect rect) {
        f0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void h0(int i10, int i11, int i12, int i13) {
        if (this.f٩٢٣٦i == null) {
            this.f٩٢٣٦i = new Rect(i10, i11, i12, i13);
            this.T = true;
        }
        if (!d0(this.f٩٢٣٦i, i10, i11, i12, i13)) {
            this.f٩٢٣٦i.set(i10, i11, i12, i13);
            this.T = true;
        }
    }

    public void i0(int i10) {
        if (i10 != this.f٩٢٥١p0) {
            this.f٩٢٥١p0 = i10;
            b0();
        }
    }

    public void j0(int i10) {
        c8.e eVar = new c8.e(this.f٩٢٢٠a.getContext(), i10);
        if (eVar.j() != null) {
            this.f٩٢٥٠p = eVar.j();
        }
        if (eVar.k() != DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٩٢٤٦n = eVar.k();
        }
        ColorStateList colorStateList = eVar.f٥٩٦٣c;
        if (colorStateList != null) {
            this.f٩٢٢٣b0 = colorStateList;
        }
        this.Z = eVar.f٥٩٦٩i;
        this.f٩٢٢١a0 = eVar.f٥٩٧٠j;
        this.Y = eVar.f٥٩٧١k;
        this.f٩٢٣٣g0 = eVar.f٥٩٧٣m;
        c8.a aVar = this.F;
        if (aVar != null) {
            aVar.c();
        }
        this.F = new c8.a(new a(), eVar.e());
        eVar.h(this.f٩٢٢٠a.getContext(), this.F);
        b0();
    }

    public void k(Canvas canvas) {
        int save = canvas.save();
        if (this.I != null && this.f٩٢٣٨j.width() > DownloadProgress.UNKNOWN_PROGRESS && this.f٩٢٣٨j.height() > DownloadProgress.UNKNOWN_PROGRESS) {
            this.U.setTextSize(this.M);
            float f10 = this.f٩٢٦٢v;
            float f11 = this.f٩٢٦٤w;
            float f12 = this.L;
            if (f12 != 1.0f && !this.f٩٢٢٤c) {
                canvas.scale(f12, f12, f10, f11);
            }
            if (S0() && T0() && (!this.f٩٢٢٤c || this.f٩٢٢٢b > this.f٩٢٢٨e)) {
                l(canvas, this.f٩٢٦٢v - this.f٩٢٣٩j0.getLineStart(0), f11);
            } else {
                canvas.translate(f10, f11);
                this.f٩٢٣٩j0.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public void l0(ColorStateList colorStateList) {
        if (this.f٩٢٥٠p != colorStateList) {
            this.f٩٢٥٠p = colorStateList;
            b0();
        }
    }

    public float m() {
        Q(this.V);
        return (-this.V.ascent()) + this.V.descent();
    }

    public void m0(int i10) {
        if (this.f٩٢٤٢l != i10) {
            this.f٩٢٤٢l = i10;
            b0();
        }
    }

    public float n() {
        Q(this.V);
        return -this.V.ascent();
    }

    public void n0(float f10) {
        if (this.f٩٢٤٦n != f10) {
            this.f٩٢٤٦n = f10;
            b0();
        }
    }

    public void o(RectF rectF, int i10, int i11) {
        this.J = f(this.H);
        rectF.left = Math.max(s(i10, i11), this.f٩٢٣٤h.left);
        rectF.top = this.f٩٢٣٤h.top;
        rectF.right = Math.min(t(rectF, i10, i11), this.f٩٢٣٤h.right);
        rectF.bottom = this.f٩٢٣٤h.top + r();
        if (this.f٩٢٣٩j0 != null && !T0()) {
            float lineWidth = this.f٩٢٣٩j0.getLineWidth(r4.getLineCount() - 1) * (this.f٩٢٤٦n / this.f٩٢٤٤m);
            if (this.J) {
                rectF.left = rectF.right - lineWidth;
            } else {
                rectF.right = rectF.left + lineWidth;
            }
        }
    }

    public void o0(Typeface typeface) {
        if (p0(typeface)) {
            b0();
        }
    }

    public ColorStateList p() {
        return this.f٩٢٥٠p;
    }

    public int q() {
        return this.f٩٢٤٢l;
    }

    public void q0(int i10) {
        this.f٩٢٣٠f = i10;
    }

    public float r() {
        int i10 = this.f٩٢٦١u0;
        if (i10 != -1) {
            return i10;
        }
        return n();
    }

    public void r0(int i10, int i11, int i12, int i13) {
        s0(i10, i11, i12, i13, true);
    }

    public void s0(int i10, int i11, int i12, int i13, boolean z10) {
        if (!d0(this.f٩٢٣٢g, i10, i11, i12, i13) || z10 != this.f٩٢٦٥w0) {
            this.f٩٢٣٢g.set(i10, i11, i12, i13);
            this.T = true;
            this.f٩٢٦٥w0 = z10;
        }
    }

    public void t0(Rect rect) {
        r0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public float u() {
        return this.f٩٢٤٦n;
    }

    public void u0(float f10) {
        if (this.f٩٢٣٥h0 != f10) {
            this.f٩٢٣٥h0 = f10;
            b0();
        }
    }

    public Typeface v() {
        Typeface typeface = this.f٩٢٦٦x;
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
    }

    public void v0(int i10) {
        if (i10 != this.f٩٢٤٩o0) {
            this.f٩٢٤٩o0 = i10;
            b0();
        }
    }

    public int w() {
        return x(this.f٩٢٥٠p);
    }

    public void w0(int i10) {
        c8.e eVar = new c8.e(this.f٩٢٢٠a.getContext(), i10);
        if (eVar.j() != null) {
            this.f٩٢٤٨o = eVar.j();
        }
        if (eVar.k() != DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٩٢٤٤m = eVar.k();
        }
        ColorStateList colorStateList = eVar.f٥٩٦٣c;
        if (colorStateList != null) {
            this.f٩٢٣١f0 = colorStateList;
        }
        this.f٩٢٢٧d0 = eVar.f٥٩٦٩i;
        this.f٩٢٢٩e0 = eVar.f٥٩٧٠j;
        this.f٩٢٢٥c0 = eVar.f٥٩٧١k;
        this.f٩٢٣٥h0 = eVar.f٥٩٧٣m;
        c8.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        this.E = new c8.a(new C٠١١٥b(), eVar.e());
        eVar.h(this.f٩٢٢٠a.getContext(), this.E);
        b0();
    }

    public void y0(ColorStateList colorStateList) {
        if (this.f٩٢٤٨o != colorStateList) {
            this.f٩٢٤٨o = colorStateList;
            b0();
        }
    }

    public int z() {
        return this.f٩٢٥٢q;
    }

    public void z0(int i10) {
        if (this.f٩٢٤٠k != i10) {
            this.f٩٢٤٠k = i10;
            b0();
        }
    }
}
