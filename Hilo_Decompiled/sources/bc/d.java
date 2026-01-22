package bc;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;
import ic.i;
import java.lang.ref.WeakReference;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d implements bc.a {
    private Paint A;

    /* renamed from: B, reason: collision with root package name */
    private PorterDuffXfermode f٥٥٧٩B;
    private int C;
    private int D;
    private float[] E;
    private boolean F;
    private RectF G;
    private int H;
    private int I;
    private int J;
    private WeakReference K;
    private boolean L;
    private Path M;
    private boolean N;
    private int O;
    private float P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;

    /* renamed from: a, reason: collision with root package name */
    private Context f٥٥٨٠a;

    /* renamed from: b, reason: collision with root package name */
    private int f٥٥٨١b;

    /* renamed from: c, reason: collision with root package name */
    private int f٥٥٨٢c;

    /* renamed from: d, reason: collision with root package name */
    private int f٥٥٨٣d;

    /* renamed from: e, reason: collision with root package name */
    private int f٥٥٨٤e;

    /* renamed from: f, reason: collision with root package name */
    private int f٥٥٨٥f;

    /* renamed from: g, reason: collision with root package name */
    private int f٥٥٨٦g;

    /* renamed from: h, reason: collision with root package name */
    private int f٥٥٨٧h;

    /* renamed from: i, reason: collision with root package name */
    private int f٥٥٨٨i;

    /* renamed from: j, reason: collision with root package name */
    private int f٥٥٨٩j;

    /* renamed from: k, reason: collision with root package name */
    private int f٥٥٩٠k;

    /* renamed from: l, reason: collision with root package name */
    private int f٥٥٩١l;

    /* renamed from: m, reason: collision with root package name */
    private int f٥٥٩٢m;

    /* renamed from: n, reason: collision with root package name */
    private int f٥٥٩٣n;

    /* renamed from: o, reason: collision with root package name */
    private int f٥٥٩٤o;

    /* renamed from: p, reason: collision with root package name */
    private int f٥٥٩٥p;

    /* renamed from: q, reason: collision with root package name */
    private int f٥٥٩٦q;

    /* renamed from: r, reason: collision with root package name */
    private int f٥٥٩٧r;

    /* renamed from: s, reason: collision with root package name */
    private int f٥٥٩٨s;

    /* renamed from: t, reason: collision with root package name */
    private int f٥٥٩٩t;

    /* renamed from: u, reason: collision with root package name */
    private int f٥٦٠٠u;

    /* renamed from: v, reason: collision with root package name */
    private int f٥٦٠١v;

    /* renamed from: w, reason: collision with root package name */
    private int f٥٦٠٢w;

    /* renamed from: x, reason: collision with root package name */
    private int f٥٦٠٣x;

    /* renamed from: y, reason: collision with root package name */
    private int f٥٦٠٤y;

    /* renamed from: z, reason: collision with root package name */
    private Paint f٥٦٠٥z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                float v10 = d.this.v();
                float f10 = v10 * 2.0f;
                float min = Math.min(width, height);
                if (f10 > min) {
                    v10 = min / 2.0f;
                }
                float f11 = v10;
                if (!d.this.F) {
                    int i16 = d.this.T;
                    int max = Math.max(i16 + 1, height - d.this.U);
                    int i17 = d.this.R;
                    int i18 = width - d.this.S;
                    if (d.this.L) {
                        i17 += view.getPaddingLeft();
                        i16 += view.getPaddingTop();
                        int max2 = Math.max(i17 + 1, i18 - view.getPaddingRight());
                        i11 = Math.max(i16 + 1, max - view.getPaddingBottom());
                        i10 = max2;
                    } else {
                        i10 = i18;
                        i11 = max;
                    }
                    int i19 = i16;
                    int i20 = i17;
                    float f12 = d.this.P;
                    if (d.this.O == 0) {
                        f12 = 1.0f;
                    }
                    outline.setAlpha(f12);
                    if (f11 <= DownloadProgress.UNKNOWN_PROGRESS) {
                        outline.setRect(i20, i19, i10, i11);
                        return;
                    } else {
                        outline.setRoundRect(i20, i19, i10, i11, f11);
                        return;
                    }
                }
                if (d.this.D == 4) {
                    i14 = (int) (0 - f11);
                    i12 = width;
                    i13 = height;
                } else {
                    if (d.this.D == 1) {
                        i15 = (int) (0 - f11);
                        i12 = width;
                        i13 = height;
                        i14 = 0;
                        outline.setRoundRect(i14, i15, i12, i13, f11);
                    }
                    if (d.this.D == 2) {
                        width = (int) (width + f11);
                    } else if (d.this.D == 3) {
                        height = (int) (height + f11);
                    }
                    i12 = width;
                    i13 = height;
                    i14 = 0;
                }
                i15 = 0;
                outline.setRoundRect(i14, i15, i12, i13, f11);
            }
        }
    }

    public d(Context context, AttributeSet attributeSet, int i10, View view) {
        this(context, attributeSet, i10, 0, view);
    }

    private void B() {
        View view = (View) this.K.get();
        if (view == null) {
            return;
        }
        view.invalidate();
    }

    private void C() {
        View view;
        if (!X() || (view = (View) this.K.get()) == null) {
            return;
        }
        int i10 = this.O;
        if (i10 == 0) {
            view.setElevation(DownloadProgress.UNKNOWN_PROGRESS);
        } else {
            view.setElevation(i10);
        }
        view.invalidateOutline();
    }

    private void S(int i10) {
        View view;
        if (Build.VERSION.SDK_INT >= 28 && (view = (View) this.K.get()) != null) {
            view.setOutlineAmbientShadowColor(i10);
            view.setOutlineSpotShadowColor(i10);
        }
    }

    public static boolean X() {
        return true;
    }

    private void q(Canvas canvas, RectF rectF, float[] fArr, Paint paint) {
        this.M.reset();
        this.M.addRoundRect(rectF, fArr, Path.Direction.CW);
        canvas.drawPath(this.M, paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v() {
        View view = (View) this.K.get();
        if (view == null) {
            return this.C;
        }
        int i10 = this.C;
        if (i10 == -1) {
            return view.getHeight() / 2;
        }
        if (i10 == -2) {
            return view.getWidth() / 2;
        }
        return i10;
    }

    public int A(int i10, int i11) {
        int i12;
        if (View.MeasureSpec.getMode(i10) != 1073741824 && i11 < (i12 = this.f٥٥٨٣d)) {
            return View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        return i10;
    }

    public boolean D() {
        int i10 = this.C;
        if ((i10 == -1 || i10 == -2 || i10 > 0) && this.D != 0) {
            return true;
        }
        return false;
    }

    public void E(int i10) {
        this.I = i10;
    }

    public void F(int i10) {
        this.f٥٥٩٤o = i10;
    }

    public void G(int i10) {
        if (this.D == i10) {
            return;
        }
        N(this.C, i10, this.O, this.P);
    }

    public void H(int i10) {
        this.f٥٥٩٩t = i10;
    }

    public void I(int i10) {
        this.J = i10;
        View view = (View) this.K.get();
        if (view != null) {
            view.invalidate();
        }
    }

    public void J(boolean z10) {
        View view;
        if (!X() || (view = (View) this.K.get()) == null) {
            return;
        }
        this.L = z10;
        view.invalidateOutline();
    }

    public void K(int i10) {
        if (this.C != i10) {
            M(i10, this.O, this.P);
        }
    }

    public void L(int i10, int i11) {
        if (this.C == i10 && i11 == this.D) {
            return;
        }
        N(i10, i11, this.O, this.P);
    }

    public void M(int i10, int i11, float f10) {
        N(i10, this.D, i11, f10);
    }

    public void N(int i10, int i11, int i12, float f10) {
        O(i10, i11, i12, this.Q, f10);
    }

    public void O(int i10, int i11, int i12, int i13, float f10) {
        boolean z10;
        View view = (View) this.K.get();
        if (view == null) {
            return;
        }
        this.C = i10;
        this.D = i11;
        this.F = D();
        this.O = i12;
        this.P = f10;
        this.Q = i13;
        if (X()) {
            int i14 = this.O;
            if (i14 != 0 && !this.F) {
                view.setElevation(i14);
            } else {
                view.setElevation(DownloadProgress.UNKNOWN_PROGRESS);
            }
            S(this.Q);
            view.setOutlineProvider(new a());
            int i15 = this.C;
            if (i15 != -2 && i15 != -1 && i15 <= 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            view.setClipToOutline(z10);
        }
        view.invalidate();
    }

    public void P(int i10) {
        this.f٥٦٠٤y = i10;
    }

    public void Q(float f10) {
        if (this.P == f10) {
            return;
        }
        this.P = f10;
        C();
    }

    public void R(int i10) {
        if (this.Q == i10) {
            return;
        }
        this.Q = i10;
        S(i10);
    }

    public void T(int i10) {
        if (this.O == i10) {
            return;
        }
        this.O = i10;
        C();
    }

    public void U(boolean z10) {
        this.N = z10;
        B();
    }

    public void V(int i10) {
        this.f٥٥٨٩j = i10;
    }

    public void W(int i10, int i11, int i12, int i13) {
        this.f٥٥٩١l = i10;
        this.f٥٥٩٢m = i11;
        this.f٥٥٩٣n = i13;
        this.f٥٥٩٠k = i12;
    }

    @Override // bc.a
    public void d(int i10) {
        if (this.f٥٥٩٣n != i10) {
            this.f٥٥٩٣n = i10;
            B();
        }
    }

    @Override // bc.a
    public void f(int i10) {
        if (this.f٥٥٩٨s != i10) {
            this.f٥٥٩٨s = i10;
            B();
        }
    }

    @Override // bc.a
    public void i(int i10) {
        if (this.f٥٥٨٨i != i10) {
            this.f٥٥٨٨i = i10;
            B();
        }
    }

    @Override // bc.a
    public void j(int i10) {
        if (this.f٥٦٠٣x != i10) {
            this.f٥٦٠٣x = i10;
            B();
        }
    }

    public void o(Canvas canvas) {
        boolean z10;
        boolean z11;
        View view = (View) this.K.get();
        if (view == null) {
            return;
        }
        int v10 = v();
        if (v10 > 0 && !X() && this.J != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.I > 0 && this.H != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z10 && !z11) {
            return;
        }
        if (this.N && X() && this.O != 0) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        canvas.save();
        canvas.translate(view.getScrollX(), view.getScrollY());
        float f10 = this.I / 2.0f;
        if (this.L) {
            this.G.set(view.getPaddingLeft() + f10, view.getPaddingTop() + f10, (width - view.getPaddingRight()) - f10, (height - view.getPaddingBottom()) - f10);
        } else {
            this.G.set(f10, f10, width - f10, height - f10);
        }
        if (this.F) {
            if (this.E == null) {
                this.E = new float[8];
            }
            int i10 = this.D;
            if (i10 == 1) {
                float[] fArr = this.E;
                float f11 = v10;
                fArr[4] = f11;
                fArr[5] = f11;
                fArr[6] = f11;
                fArr[7] = f11;
            } else if (i10 == 2) {
                float[] fArr2 = this.E;
                float f12 = v10;
                fArr2[0] = f12;
                fArr2[1] = f12;
                fArr2[6] = f12;
                fArr2[7] = f12;
            } else if (i10 == 3) {
                float[] fArr3 = this.E;
                float f13 = v10;
                fArr3[0] = f13;
                fArr3[1] = f13;
                fArr3[2] = f13;
                fArr3[3] = f13;
            } else if (i10 == 4) {
                float[] fArr4 = this.E;
                float f14 = v10;
                fArr4[2] = f14;
                fArr4[3] = f14;
                fArr4[4] = f14;
                fArr4[5] = f14;
            }
        }
        if (z10) {
            int saveLayer = canvas.saveLayer(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, width, height, null, 31);
            canvas.drawColor(this.J);
            this.A.setColor(this.J);
            this.A.setStyle(Paint.Style.FILL);
            this.A.setXfermode(this.f٥٥٧٩B);
            if (!this.F) {
                float f15 = v10;
                canvas.drawRoundRect(this.G, f15, f15, this.A);
            } else {
                q(canvas, this.G, this.E, this.A);
            }
            this.A.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
        if (z11) {
            this.A.setColor(this.H);
            this.A.setStrokeWidth(this.I);
            this.A.setStyle(Paint.Style.STROKE);
            if (this.F) {
                q(canvas, this.G, this.E, this.A);
            } else if (v10 <= 0) {
                canvas.drawRect(this.G, this.A);
            } else {
                float f16 = v10;
                canvas.drawRoundRect(this.G, f16, f16, this.A);
            }
        }
        canvas.restore();
    }

    public void p(Canvas canvas, int i10, int i11) {
        if (((View) this.K.get()) == null) {
            return;
        }
        if (this.f٥٦٠٥z == null && (this.f٥٥٨٥f > 0 || this.f٥٥٩٠k > 0 || this.f٥٥٩٥p > 0 || this.f٥٦٠٠u > 0)) {
            this.f٥٦٠٥z = new Paint();
        }
        canvas.save();
        canvas.translate(r0.getScrollX(), r0.getScrollY());
        int i12 = this.f٥٥٨٥f;
        if (i12 > 0) {
            this.f٥٦٠٥z.setStrokeWidth(i12);
            this.f٥٦٠٥z.setColor(this.f٥٥٨٨i);
            int i13 = this.f٥٥٨٩j;
            if (i13 < 255) {
                this.f٥٦٠٥z.setAlpha(i13);
            }
            float f10 = this.f٥٥٨٥f / 2.0f;
            canvas.drawLine(this.f٥٥٨٦g, f10, i10 - this.f٥٥٨٧h, f10, this.f٥٦٠٥z);
        }
        int i14 = this.f٥٥٩٠k;
        if (i14 > 0) {
            this.f٥٦٠٥z.setStrokeWidth(i14);
            this.f٥٦٠٥z.setColor(this.f٥٥٩٣n);
            int i15 = this.f٥٥٩٤o;
            if (i15 < 255) {
                this.f٥٦٠٥z.setAlpha(i15);
            }
            float floor = (float) Math.floor(i11 - (this.f٥٥٩٠k / 2.0f));
            canvas.drawLine(this.f٥٥٩١l, floor, i10 - this.f٥٥٩٢m, floor, this.f٥٦٠٥z);
        }
        int i16 = this.f٥٥٩٥p;
        if (i16 > 0) {
            this.f٥٦٠٥z.setStrokeWidth(i16);
            this.f٥٦٠٥z.setColor(this.f٥٥٩٨s);
            int i17 = this.f٥٥٩٩t;
            if (i17 < 255) {
                this.f٥٦٠٥z.setAlpha(i17);
            }
            float f11 = this.f٥٥٩٥p / 2.0f;
            canvas.drawLine(f11, this.f٥٥٩٦q, f11, i11 - this.f٥٥٩٧r, this.f٥٦٠٥z);
        }
        int i18 = this.f٥٦٠٠u;
        if (i18 > 0) {
            this.f٥٦٠٥z.setStrokeWidth(i18);
            this.f٥٦٠٥z.setColor(this.f٥٦٠٣x);
            int i19 = this.f٥٦٠٤y;
            if (i19 < 255) {
                this.f٥٦٠٥z.setAlpha(i19);
            }
            float floor2 = (float) Math.floor(i10 - (this.f٥٦٠٠u / 2.0f));
            canvas.drawLine(floor2, this.f٥٦٠١v, floor2, i11 - this.f٥٦٠٢w, this.f٥٦٠٥z);
        }
        canvas.restore();
    }

    public int r() {
        return this.D;
    }

    public int s(int i10) {
        if (this.f٥٥٨٢c > 0 && View.MeasureSpec.getSize(i10) > this.f٥٥٨٢c) {
            if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
                return View.MeasureSpec.makeMeasureSpec(this.f٥٥٨١b, Integer.MIN_VALUE);
            }
            return View.MeasureSpec.makeMeasureSpec(this.f٥٥٨١b, 1073741824);
        }
        return i10;
    }

    @Override // bc.a
    public void setBorderColor(int i10) {
        this.H = i10;
    }

    public int t(int i10) {
        if (this.f٥٥٨١b > 0 && View.MeasureSpec.getSize(i10) > this.f٥٥٨١b) {
            if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
                return View.MeasureSpec.makeMeasureSpec(this.f٥٥٨١b, Integer.MIN_VALUE);
            }
            return View.MeasureSpec.makeMeasureSpec(this.f٥٥٨١b, 1073741824);
        }
        return i10;
    }

    public int u() {
        return this.C;
    }

    public float w() {
        return this.P;
    }

    public int x() {
        return this.Q;
    }

    public int y() {
        return this.O;
    }

    public int z(int i10, int i11) {
        int i12;
        if (View.MeasureSpec.getMode(i10) != 1073741824 && i11 < (i12 = this.f٥٥٨٤e)) {
            return View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        return i10;
    }

    public d(Context context, AttributeSet attributeSet, int i10, int i11, View view) {
        boolean z10;
        int i12;
        int i13 = 0;
        this.f٥٥٨١b = 0;
        this.f٥٥٨٢c = 0;
        this.f٥٥٨٣d = 0;
        this.f٥٥٨٤e = 0;
        this.f٥٥٨٥f = 0;
        this.f٥٥٨٦g = 0;
        this.f٥٥٨٧h = 0;
        this.f٥٥٨٩j = KotlinVersion.MAX_COMPONENT_VALUE;
        this.f٥٥٩٠k = 0;
        this.f٥٥٩١l = 0;
        this.f٥٥٩٢m = 0;
        this.f٥٥٩٤o = KotlinVersion.MAX_COMPONENT_VALUE;
        this.f٥٥٩٥p = 0;
        this.f٥٥٩٦q = 0;
        this.f٥٥٩٧r = 0;
        this.f٥٥٩٩t = KotlinVersion.MAX_COMPONENT_VALUE;
        this.f٥٦٠٠u = 0;
        this.f٥٦٠١v = 0;
        this.f٥٦٠٢w = 0;
        this.f٥٦٠٤y = KotlinVersion.MAX_COMPONENT_VALUE;
        this.D = 0;
        this.H = 0;
        this.I = 1;
        this.J = 0;
        this.L = false;
        this.M = new Path();
        this.N = true;
        this.O = 0;
        this.Q = -16777216;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.f٥٥٨٠a = context;
        this.K = new WeakReference(view);
        int color = androidx.core.content.a.getColor(context, R.color.qmui_config_color_separator);
        this.f٥٥٨٨i = color;
        this.f٥٥٩٣n = color;
        this.f٥٥٧٩B = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint paint = new Paint();
        this.A = paint;
        paint.setAntiAlias(true);
        this.P = i.i(context, R.attr.qmui_general_shadow_alpha);
        this.G = new RectF();
        if (attributeSet == null && i10 == 0 && i11 == 0) {
            z10 = false;
            i12 = 0;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUILayout, i10, i11);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i14 = 0;
            z10 = false;
            i12 = 0;
            for (int i15 = 0; i15 < indexCount; i15++) {
                int index = obtainStyledAttributes.getIndex(i15);
                if (index == R.styleable.QMUILayout_android_maxWidth) {
                    this.f٥٥٨١b = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٨١b);
                } else if (index == R.styleable.QMUILayout_android_maxHeight) {
                    this.f٥٥٨٢c = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٨٢c);
                } else if (index == R.styleable.QMUILayout_android_minWidth) {
                    this.f٥٥٨٣d = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٨٣d);
                } else if (index == R.styleable.QMUILayout_android_minHeight) {
                    this.f٥٥٨٤e = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٨٤e);
                } else if (index == R.styleable.QMUILayout_qmui_topDividerColor) {
                    this.f٥٥٨٨i = obtainStyledAttributes.getColor(index, this.f٥٥٨٨i);
                } else if (index == R.styleable.QMUILayout_qmui_topDividerHeight) {
                    this.f٥٥٨٥f = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٨٥f);
                } else if (index == R.styleable.QMUILayout_qmui_topDividerInsetLeft) {
                    this.f٥٥٨٦g = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٨٦g);
                } else if (index == R.styleable.QMUILayout_qmui_topDividerInsetRight) {
                    this.f٥٥٨٧h = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٨٧h);
                } else if (index == R.styleable.QMUILayout_qmui_bottomDividerColor) {
                    this.f٥٥٩٣n = obtainStyledAttributes.getColor(index, this.f٥٥٩٣n);
                } else if (index == R.styleable.QMUILayout_qmui_bottomDividerHeight) {
                    this.f٥٥٩٠k = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٩٠k);
                } else if (index == R.styleable.QMUILayout_qmui_bottomDividerInsetLeft) {
                    this.f٥٥٩١l = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٩١l);
                } else if (index == R.styleable.QMUILayout_qmui_bottomDividerInsetRight) {
                    this.f٥٥٩٢m = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٩٢m);
                } else if (index == R.styleable.QMUILayout_qmui_leftDividerColor) {
                    this.f٥٥٩٨s = obtainStyledAttributes.getColor(index, this.f٥٥٩٨s);
                } else if (index == R.styleable.QMUILayout_qmui_leftDividerWidth) {
                    this.f٥٥٩٥p = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٩٥p);
                } else if (index == R.styleable.QMUILayout_qmui_leftDividerInsetTop) {
                    this.f٥٥٩٦q = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٩٦q);
                } else if (index == R.styleable.QMUILayout_qmui_leftDividerInsetBottom) {
                    this.f٥٥٩٧r = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٥٩٧r);
                } else if (index == R.styleable.QMUILayout_qmui_rightDividerColor) {
                    this.f٥٦٠٣x = obtainStyledAttributes.getColor(index, this.f٥٦٠٣x);
                } else if (index == R.styleable.QMUILayout_qmui_rightDividerWidth) {
                    this.f٥٦٠٠u = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٦٠٠u);
                } else if (index == R.styleable.QMUILayout_qmui_rightDividerInsetTop) {
                    this.f٥٦٠١v = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٦٠١v);
                } else if (index == R.styleable.QMUILayout_qmui_rightDividerInsetBottom) {
                    this.f٥٦٠٢w = obtainStyledAttributes.getDimensionPixelSize(index, this.f٥٦٠٢w);
                } else if (index == R.styleable.QMUILayout_qmui_borderColor) {
                    this.H = obtainStyledAttributes.getColor(index, this.H);
                } else if (index == R.styleable.QMUILayout_qmui_borderWidth) {
                    this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                } else if (index == R.styleable.QMUILayout_qmui_radius) {
                    i12 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.QMUILayout_qmui_outerNormalColor) {
                    this.J = obtainStyledAttributes.getColor(index, this.J);
                } else if (index == R.styleable.QMUILayout_qmui_hideRadiusSide) {
                    this.D = obtainStyledAttributes.getInt(index, this.D);
                } else if (index == R.styleable.QMUILayout_qmui_showBorderOnlyBeforeL) {
                    this.N = obtainStyledAttributes.getBoolean(index, this.N);
                } else if (index == R.styleable.QMUILayout_qmui_shadowElevation) {
                    i14 = obtainStyledAttributes.getDimensionPixelSize(index, i14);
                } else if (index == R.styleable.QMUILayout_qmui_shadowAlpha) {
                    this.P = obtainStyledAttributes.getFloat(index, this.P);
                } else if (index == R.styleable.QMUILayout_qmui_useThemeGeneralShadowElevation) {
                    z10 = obtainStyledAttributes.getBoolean(index, false);
                } else if (index == R.styleable.QMUILayout_qmui_outlineInsetLeft) {
                    this.R = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.QMUILayout_qmui_outlineInsetRight) {
                    this.S = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.QMUILayout_qmui_outlineInsetTop) {
                    this.T = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.QMUILayout_qmui_outlineInsetBottom) {
                    this.U = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.QMUILayout_qmui_outlineExcludePadding) {
                    this.L = obtainStyledAttributes.getBoolean(index, false);
                }
            }
            obtainStyledAttributes.recycle();
            i13 = i14;
        }
        if (i13 == 0 && z10) {
            i13 = i.e(context, R.attr.qmui_general_shadow_elevation);
        }
        N(i12, this.D, i13, this.P);
    }
}
