package com.github.gzuliyujiang.wheelview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.annotation.IntRange;
import com.github.gzuliyujiang.wheelview.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import u6.a;
import u6.b;
import u6.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class WheelView extends View implements Runnable {
    protected int A;

    /* renamed from: B, reason: collision with root package name */
    private final Handler f٨٠٤١B;
    private final Paint C;
    private final Scroller D;
    private VelocityTracker E;
    private a F;
    private final Rect G;
    private final Rect H;
    private final Rect I;
    private final Rect J;
    private final Camera K;
    private final Matrix L;
    private final Matrix M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a, reason: collision with root package name */
    protected List f٨٠٤٢a;

    /* renamed from: a0, reason: collision with root package name */
    private int f٨٠٤٣a0;

    /* renamed from: b, reason: collision with root package name */
    protected c f٨٠٤٤b;

    /* renamed from: b0, reason: collision with root package name */
    private int f٨٠٤٥b0;

    /* renamed from: c, reason: collision with root package name */
    protected Object f٨٠٤٦c;

    /* renamed from: c0, reason: collision with root package name */
    private int f٨٠٤٧c0;

    /* renamed from: d, reason: collision with root package name */
    protected int f٨٠٤٨d;

    /* renamed from: d0, reason: collision with root package name */
    private int f٨٠٤٩d0;

    /* renamed from: e, reason: collision with root package name */
    protected int f٨٠٥٠e;

    /* renamed from: e0, reason: collision with root package name */
    private int f٨٠٥١e0;

    /* renamed from: f, reason: collision with root package name */
    protected int f٨٠٥٢f;

    /* renamed from: f0, reason: collision with root package name */
    private int f٨٠٥٣f0;

    /* renamed from: g, reason: collision with root package name */
    protected String f٨٠٥٤g;

    /* renamed from: g0, reason: collision with root package name */
    private int f٨٠٥٥g0;

    /* renamed from: h, reason: collision with root package name */
    protected int f٨٠٥٦h;

    /* renamed from: h0, reason: collision with root package name */
    private final int f٨٠٥٧h0;

    /* renamed from: i, reason: collision with root package name */
    protected int f٨٠٥٨i;

    /* renamed from: i0, reason: collision with root package name */
    private final int f٨٠٥٩i0;

    /* renamed from: j, reason: collision with root package name */
    protected float f٨٠٦٠j;

    /* renamed from: j0, reason: collision with root package name */
    private final int f٨٠٦١j0;

    /* renamed from: k, reason: collision with root package name */
    protected float f٨٠٦٢k;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f٨٠٦٣k0;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f٨٠٦٤l;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f٨٠٦٥l0;

    /* renamed from: m, reason: collision with root package name */
    protected float f٨٠٦٦m;

    /* renamed from: n, reason: collision with root package name */
    protected int f٨٠٦٧n;

    /* renamed from: o, reason: collision with root package name */
    protected int f٨٠٦٨o;

    /* renamed from: p, reason: collision with root package name */
    protected int f٨٠٦٩p;

    /* renamed from: q, reason: collision with root package name */
    protected float f٨٠٧٠q;

    /* renamed from: r, reason: collision with root package name */
    protected int f٨٠٧١r;

    /* renamed from: s, reason: collision with root package name */
    protected int f٨٠٧٢s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f٨٠٧٣t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f٨٠٧٤u;

    /* renamed from: v, reason: collision with root package name */
    protected boolean f٨٠٧٥v;

    /* renamed from: w, reason: collision with root package name */
    protected boolean f٨٠٧٦w;

    /* renamed from: x, reason: collision with root package name */
    protected boolean f٨٠٧٧x;

    /* renamed from: y, reason: collision with root package name */
    protected boolean f٨٠٧٨y;

    /* renamed from: z, reason: collision with root package name */
    protected int f٨٠٧٩z;

    public WheelView(Context context) {
        this(context, null);
    }

    private void A(MotionEvent motionEvent) {
        int i10;
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (this.f٨٠٦٣k0) {
            return;
        }
        VelocityTracker velocityTracker = this.E;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
            this.E.computeCurrentVelocity(1000, this.f٨٠٥٩i0);
            i10 = (int) this.E.getYVelocity();
        } else {
            i10 = 0;
        }
        this.f٨٠٦٥l0 = false;
        if (Math.abs(i10) > this.f٨٠٥٧h0) {
            this.D.fling(0, this.f٨٠٥١e0, 0, i10, 0, 0, this.V, this.W);
            int g10 = g(this.D.getFinalY() % this.S);
            Scroller scroller = this.D;
            scroller.setFinalY(scroller.getFinalY() + g10);
        } else {
            this.D.startScroll(0, this.f٨٠٥١e0, 0, g(this.f٨٠٥١e0 % this.S));
        }
        if (!this.f٨٠٧٧x) {
            int finalY = this.D.getFinalY();
            int i11 = this.W;
            if (finalY > i11) {
                this.D.setFinalY(i11);
            } else {
                int finalY2 = this.D.getFinalY();
                int i12 = this.V;
                if (finalY2 < i12) {
                    this.D.setFinalY(i12);
                }
            }
        }
        this.f٨٠٤١B.post(this);
        a();
    }

    private void B(Context context, AttributeSet attributeSet, int i10, int i11) {
        float f10 = context.getResources().getDisplayMetrics().density;
        float f11 = context.getResources().getDisplayMetrics().scaledDensity;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WheelView, i10, i11);
        this.f٨٠٤٨d = obtainStyledAttributes.getInt(R.styleable.WheelView_wheel_visibleItemCount, 5);
        this.f٨٠٧٣t = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_sameWidthEnabled, false);
        this.f٨٠٥٤g = obtainStyledAttributes.getString(R.styleable.WheelView_wheel_maxWidthText);
        this.f٨٠٥٦h = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_itemTextColor, -7829368);
        this.f٨٠٥٨i = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_itemTextColorSelected, -16777216);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_itemTextSize, f11 * 15.0f);
        this.f٨٠٦٠j = dimension;
        this.f٨٠٦٢k = obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_itemTextSizeSelected, dimension);
        this.f٨٠٦٤l = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_itemTextBoldSelected, false);
        this.f٨٠٧٢s = obtainStyledAttributes.getInt(R.styleable.WheelView_wheel_itemTextAlign, 0);
        this.f٨٠٧١r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WheelView_wheel_itemSpace, (int) (20.0f * f10));
        this.f٨٠٧٧x = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_cyclicEnabled, false);
        this.f٨٠٧٤u = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_indicatorEnabled, true);
        this.f٨٠٦٧n = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_indicatorColor, -3552823);
        float f12 = f10 * 1.0f;
        this.f٨٠٦٦m = obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_indicatorSize, f12);
        this.A = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WheelView_wheel_curvedIndicatorSpace, (int) f12);
        this.f٨٠٧٥v = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_curtainEnabled, false);
        this.f٨٠٦٨o = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_curtainColor, -1);
        this.f٨٠٦٩p = obtainStyledAttributes.getInt(R.styleable.WheelView_wheel_curtainCorner, 0);
        this.f٨٠٧٠q = obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_curtainRadius, DownloadProgress.UNKNOWN_PROGRESS);
        this.f٨٠٧٦w = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_atmosphericEnabled, false);
        this.f٨٠٧٨y = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_curvedEnabled, false);
        this.f٨٠٧٩z = obtainStyledAttributes.getInteger(R.styleable.WheelView_wheel_curvedMaxAngle, 90);
        obtainStyledAttributes.recycle();
    }

    private void C() {
        this.C.setColor(this.f٨٠٥٦h);
        this.C.setTextSize(this.f٨٠٦٠j);
        this.C.setFakeBoldText(false);
        this.C.setStyle(Paint.Style.FILL);
    }

    private boolean D(int i10, int i11) {
        return i10 >= 0 && i10 < i11;
    }

    private int E(int i10, int i11, int i12) {
        if (i10 != 1073741824) {
            if (i10 == Integer.MIN_VALUE) {
                return Math.min(i12, i11);
            }
            return i12;
        }
        return i11;
    }

    private void F(int i10) {
        int max = Math.max(Math.min(i10, getItemCount() - 1), 0);
        this.f٨٠٥١e0 = 0;
        this.f٨٠٤٦c = w(max);
        this.f٨٠٥٠e = max;
        this.f٨٠٥٢f = max;
        K();
        i();
        j();
        d();
        requestLayout();
        invalidate();
    }

    private String G(int i10) {
        int itemCount = getItemCount();
        if (this.f٨٠٧٧x) {
            if (itemCount != 0) {
                int i11 = i10 % itemCount;
                if (i11 < 0) {
                    i11 += itemCount;
                }
                return t(i11);
            }
        } else if (D(i10, itemCount)) {
            return t(i10);
        }
        return "";
    }

    private void H() {
        VelocityTracker velocityTracker = this.E;
        if (velocityTracker == null) {
            this.E = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private float J(float f10) {
        return (float) Math.sin(Math.toRadians(f10));
    }

    private void K() {
        int i10 = this.f٨٠٧٢s;
        if (i10 != 1) {
            if (i10 != 2) {
                this.C.setTextAlign(Paint.Align.CENTER);
                return;
            } else {
                this.C.setTextAlign(Paint.Align.RIGHT);
                return;
            }
        }
        this.C.setTextAlign(Paint.Align.LEFT);
    }

    private void L() {
        int i10 = this.f٨٠٤٨d;
        if (i10 >= 2) {
            if (i10 % 2 == 0) {
                this.f٨٠٤٨d = i10 + 1;
            }
            int i11 = this.f٨٠٤٨d + 2;
            this.O = i11;
            this.P = i11 / 2;
            return;
        }
        throw new ArithmeticException("Visible item count can not be less than 2");
    }

    private void a() {
        VelocityTracker velocityTracker = this.E;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.E = null;
        }
    }

    private float b(float f10, float f11, float f12) {
        if (f10 < f11) {
            return f11;
        }
        return Math.min(f10, f12);
    }

    private void c(int i10) {
        if (this.f٨٠٧٦w) {
            this.C.setAlpha(Math.max((int) ((((r0 - i10) * 1.0f) / this.f٨٠٤٩d0) * 255.0f), 0));
        }
    }

    private void d() {
        if (!this.f٨٠٧٥v && this.f٨٠٥٨i == 0) {
            return;
        }
        Rect rect = this.J;
        Rect rect2 = this.G;
        int i10 = rect2.left;
        int i11 = this.f٨٠٤٥b0;
        int i12 = this.T;
        rect.set(i10, i11 - i12, rect2.right, i11 + i12);
    }

    private float e(int i10, float f10) {
        int i11;
        int i12 = this.f٨٠٤٩d0;
        if (i10 > i12) {
            i11 = 1;
        } else if (i10 < i12) {
            i11 = -1;
        } else {
            i11 = 0;
        }
        float f11 = -(1.0f - f10);
        int i13 = this.f٨٠٧٩z;
        return b(f11 * i13 * i11, -i13, i13);
    }

    private int f(float f10) {
        return (int) (this.U - (Math.cos(Math.toRadians(f10)) * this.U));
    }

    private int g(int i10) {
        int i11;
        if (Math.abs(i10) > this.T) {
            if (this.f٨٠٥١e0 < 0) {
                i11 = -this.S;
            } else {
                i11 = this.S;
            }
            return i11 - i10;
        }
        return i10 * (-1);
    }

    private void h() {
        int i10 = this.f٨٠٧٢s;
        if (i10 != 1) {
            if (i10 != 2) {
                this.f٨٠٤٧c0 = this.f٨٠٤٣a0;
            } else {
                this.f٨٠٤٧c0 = this.G.right;
            }
        } else {
            this.f٨٠٤٧c0 = this.G.left;
        }
        this.f٨٠٤٩d0 = (int) (this.f٨٠٤٥b0 - ((this.C.ascent() + this.C.descent()) / 2.0f));
    }

    private void i() {
        int itemCount;
        int i10 = this.f٨٠٥٠e;
        int i11 = this.S;
        int i12 = i10 * i11;
        if (this.f٨٠٧٧x) {
            itemCount = Integer.MIN_VALUE;
        } else {
            itemCount = ((-i11) * (getItemCount() - 1)) + i12;
        }
        this.V = itemCount;
        if (this.f٨٠٧٧x) {
            i12 = Integer.MAX_VALUE;
        }
        this.W = i12;
    }

    private void j() {
        int i10;
        if (!this.f٨٠٧٤u) {
            return;
        }
        if (this.f٨٠٧٨y) {
            i10 = this.A;
        } else {
            i10 = 0;
        }
        int i11 = (int) (this.f٨٠٦٦m / 2.0f);
        int i12 = this.f٨٠٤٥b0;
        int i13 = this.T;
        int i14 = i12 + i13 + i10;
        int i15 = (i12 - i13) - i10;
        Rect rect = this.H;
        Rect rect2 = this.G;
        rect.set(rect2.left, i14 - i11, rect2.right, i14 + i11);
        Rect rect3 = this.I;
        Rect rect4 = this.G;
        rect3.set(rect4.left, i15 - i11, rect4.right, i15 + i11);
    }

    private int k(int i10) {
        return (((this.f٨٠٥١e0 * (-1)) / this.S) + this.f٨٠٥٠e) % i10;
    }

    private void l() {
        this.R = 0;
        this.Q = 0;
        if (this.f٨٠٧٣t) {
            this.Q = (int) this.C.measureText(t(0));
        } else if (!TextUtils.isEmpty(this.f٨٠٥٤g)) {
            this.Q = (int) this.C.measureText(this.f٨٠٥٤g);
        } else {
            int itemCount = getItemCount();
            for (int i10 = 0; i10 < itemCount; i10++) {
                this.Q = Math.max(this.Q, (int) this.C.measureText(t(i10)));
            }
        }
        Paint.FontMetrics fontMetrics = this.C.getFontMetrics();
        this.R = (int) (fontMetrics.bottom - fontMetrics.top);
    }

    private float m(float f10) {
        return (J(f10) / J(this.f٨٠٧٩z)) * this.U;
    }

    private void n(Canvas canvas) {
        boolean z10;
        float f10;
        int i10 = (this.f٨٠٥١e0 * (-1)) / this.S;
        int i11 = this.P;
        int i12 = i10 - i11;
        int i13 = this.f٨٠٥٠e + i12;
        int i14 = i11 * (-1);
        while (i13 < this.f٨٠٥٠e + i12 + this.O) {
            C();
            if (i13 == this.f٨٠٥٠e + i12 + (this.O / 2)) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i15 = this.f٨٠٤٩d0;
            int i16 = this.S;
            int i17 = (i14 * i16) + i15 + (this.f٨٠٥١e0 % i16);
            int abs = Math.abs(i15 - i17);
            int i18 = this.f٨٠٤٩d0;
            int i19 = this.G.top;
            float e10 = e(i17, (((i18 - abs) - i19) * 1.0f) / (i18 - i19));
            float m10 = m(e10);
            if (this.f٨٠٧٨y) {
                int i20 = this.f٨٠٤٣a0;
                int i21 = this.f٨٠٧٢s;
                if (i21 != 1) {
                    if (i21 == 2) {
                        i20 = this.G.right;
                    }
                } else {
                    i20 = this.G.left;
                }
                float f11 = this.f٨٠٤٥b0 - m10;
                this.K.save();
                this.K.rotateX(e10);
                this.K.getMatrix(this.L);
                this.K.restore();
                float f12 = -i20;
                float f13 = -f11;
                this.L.preTranslate(f12, f13);
                float f14 = i20;
                this.L.postTranslate(f14, f11);
                this.K.save();
                this.K.translate(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f(e10));
                this.K.getMatrix(this.M);
                this.K.restore();
                this.M.preTranslate(f12, f13);
                this.M.postTranslate(f14, f11);
                this.L.postConcat(this.M);
            }
            c(abs);
            if (this.f٨٠٧٨y) {
                f10 = this.f٨٠٤٩d0 - m10;
            } else {
                f10 = i17;
            }
            q(canvas, i13, z10, f10);
            i13++;
            i14++;
        }
    }

    private void o(Canvas canvas) {
        float[] fArr;
        if (!this.f٨٠٧٥v) {
            return;
        }
        this.C.setColor(this.f٨٠٦٨o);
        this.C.setStyle(Paint.Style.FILL);
        if (this.f٨٠٧٠q > DownloadProgress.UNKNOWN_PROGRESS) {
            Path path = new Path();
            int i10 = this.f٨٠٦٩p;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 5) {
                                fArr = new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
                            } else {
                                float f10 = this.f٨٠٧٠q;
                                fArr = new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f10, f10, f10, f10, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
                            }
                        } else {
                            float f11 = this.f٨٠٧٠q;
                            fArr = new float[]{f11, f11, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f11, f11};
                        }
                    } else {
                        float f12 = this.f٨٠٧٠q;
                        fArr = new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f12, f12, f12, f12};
                    }
                } else {
                    float f13 = this.f٨٠٧٠q;
                    fArr = new float[]{f13, f13, f13, f13, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
                }
            } else {
                float f14 = this.f٨٠٧٠q;
                fArr = new float[]{f14, f14, f14, f14, f14, f14, f14, f14};
            }
            path.addRoundRect(new RectF(this.J), fArr, Path.Direction.CCW);
            canvas.drawPath(path, this.C);
            return;
        }
        canvas.drawRect(this.J, this.C);
    }

    private void p(Canvas canvas) {
        if (!this.f٨٠٧٤u) {
            return;
        }
        this.C.setColor(this.f٨٠٦٧n);
        this.C.setStyle(Paint.Style.FILL);
        canvas.drawRect(this.H, this.C);
        canvas.drawRect(this.I, this.C);
    }

    private void q(Canvas canvas, int i10, boolean z10, float f10) {
        int i11 = this.f٨٠٥٨i;
        if (i11 == 0) {
            canvas.save();
            canvas.clipRect(this.G);
            if (this.f٨٠٧٨y) {
                canvas.concat(this.L);
            }
            r(canvas, i10, f10);
            canvas.restore();
            return;
        }
        if (this.f٨٠٦٠j == this.f٨٠٦٢k && !this.f٨٠٦٤l) {
            canvas.save();
            if (this.f٨٠٧٨y) {
                canvas.concat(this.L);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(this.J);
            } else {
                canvas.clipRect(this.J, Region.Op.DIFFERENCE);
            }
            r(canvas, i10, f10);
            canvas.restore();
            this.C.setColor(this.f٨٠٥٨i);
            canvas.save();
            if (this.f٨٠٧٨y) {
                canvas.concat(this.L);
            }
            canvas.clipRect(this.J);
            r(canvas, i10, f10);
            canvas.restore();
            return;
        }
        if (!z10) {
            canvas.save();
            if (this.f٨٠٧٨y) {
                canvas.concat(this.L);
            }
            r(canvas, i10, f10);
            canvas.restore();
            return;
        }
        this.C.setColor(i11);
        this.C.setTextSize(this.f٨٠٦٢k);
        this.C.setFakeBoldText(this.f٨٠٦٤l);
        canvas.save();
        if (this.f٨٠٧٨y) {
            canvas.concat(this.L);
        }
        r(canvas, i10, f10);
        canvas.restore();
    }

    private void r(Canvas canvas, int i10, float f10) {
        int length;
        int measuredWidth = getMeasuredWidth();
        float measureText = this.C.measureText("...");
        String G = G(i10);
        boolean z10 = false;
        while ((this.C.measureText(G) + measureText) - measuredWidth > DownloadProgress.UNKNOWN_PROGRESS && (length = G.length()) > 1) {
            G = G.substring(0, length - 1);
            z10 = true;
        }
        if (z10) {
            G = G + "...";
        }
        canvas.drawText(G, this.f٨٠٤٧c0, f10, this.C);
    }

    private int s(Object obj) {
        c cVar;
        if (obj == null) {
            return 0;
        }
        int i10 = 0;
        for (Object obj2 : this.f٨٠٤٢a) {
            if (obj2 != null) {
                if (obj2.equals(obj) || (((cVar = this.f٨٠٤٤b) != null && cVar.a(obj2).equals(this.f٨٠٤٤b.a(obj))) || (((obj2 instanceof b) && ((b) obj2).a().equals(obj.toString())) || obj2.toString().equals(obj.toString())))) {
                    return i10;
                }
                i10++;
            }
        }
        return 0;
    }

    private void x(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        a();
    }

    private void y(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        H();
        this.E.addMovement(motionEvent);
        if (!this.D.isFinished()) {
            this.D.abortAnimation();
            this.f٨٠٦٥l0 = true;
        }
        int y10 = (int) motionEvent.getY();
        this.f٨٠٥٣f0 = y10;
        this.f٨٠٥٥g0 = y10;
    }

    private void z(MotionEvent motionEvent) {
        int g10 = g(this.D.getFinalY() % this.S);
        if (Math.abs(this.f٨٠٥٥g0 - motionEvent.getY()) < this.f٨٠٦١j0 && g10 > 0) {
            this.f٨٠٦٣k0 = true;
            return;
        }
        this.f٨٠٦٣k0 = false;
        VelocityTracker velocityTracker = this.E;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        a aVar = this.F;
        if (aVar != null) {
            aVar.b(this, 1);
        }
        float y10 = motionEvent.getY() - this.f٨٠٥٣f0;
        if (Math.abs(y10) < 1.0f) {
            return;
        }
        this.f٨٠٥١e0 = (int) (this.f٨٠٥١e0 + y10);
        this.f٨٠٥٣f0 = (int) motionEvent.getY();
        invalidate();
    }

    public void I(List list, int i10) {
        if (list == null) {
            list = new ArrayList();
        }
        this.f٨٠٤٢a = list;
        F(i10);
    }

    public <T> T getCurrentItem() {
        return (T) w(this.f٨٠٥٢f);
    }

    public int getCurrentPosition() {
        return this.f٨٠٥٢f;
    }

    public int getCurtainColor() {
        return this.f٨٠٦٨o;
    }

    public int getCurtainCorner() {
        return this.f٨٠٦٩p;
    }

    public float getCurtainRadius() {
        return this.f٨٠٧٠q;
    }

    public int getCurvedIndicatorSpace() {
        return this.A;
    }

    public int getCurvedMaxAngle() {
        return this.f٨٠٧٩z;
    }

    public List<?> getData() {
        return this.f٨٠٤٢a;
    }

    public int getIndicatorColor() {
        return this.f٨٠٦٧n;
    }

    public float getIndicatorSize() {
        return this.f٨٠٦٦m;
    }

    public int getItemCount() {
        return this.f٨٠٤٢a.size();
    }

    public int getItemSpace() {
        return this.f٨٠٧١r;
    }

    public String getMaxWidthText() {
        return this.f٨٠٥٤g;
    }

    public boolean getSelectedTextBold() {
        return this.f٨٠٦٤l;
    }

    public int getSelectedTextColor() {
        return this.f٨٠٥٨i;
    }

    public float getSelectedTextSize() {
        return this.f٨٠٦٢k;
    }

    public int getTextAlign() {
        return this.f٨٠٧٢s;
    }

    public int getTextColor() {
        return this.f٨٠٥٦h;
    }

    public float getTextSize() {
        return this.f٨٠٦٠j;
    }

    public Typeface getTypeface() {
        return this.C.getTypeface();
    }

    public int getVisibleItemCount() {
        return this.f٨٠٤٨d;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        a aVar = this.F;
        if (aVar != null) {
            aVar.c(this, this.f٨٠٥١e0);
        }
        if (this.S - this.P <= 0) {
            return;
        }
        o(canvas);
        p(canvas);
        n(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int i12 = this.Q;
        int i13 = this.R;
        int i14 = this.f٨٠٤٨d;
        int i15 = (i13 * i14) + (this.f٨٠٧١r * (i14 - 1));
        if (this.f٨٠٧٨y) {
            i15 = (int) ((i15 * 2) / 3.141592653589793d);
        }
        setMeasuredDimension(E(mode, size, i12 + getPaddingLeft() + getPaddingRight()), E(mode2, size2, i15 + getPaddingTop() + getPaddingBottom()));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.G.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.f٨٠٤٣a0 = this.G.centerX();
        this.f٨٠٤٥b0 = this.G.centerY();
        h();
        this.U = this.G.height() / 2;
        int height = this.G.height() / this.f٨٠٤٨d;
        this.S = height;
        this.T = height / 2;
        i();
        j();
        d();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 3) {
                            x(motionEvent);
                        }
                    } else {
                        z(motionEvent);
                    }
                } else {
                    A(motionEvent);
                }
            } else {
                y(motionEvent);
            }
        }
        if (this.f٨٠٦٣k0) {
            performClick();
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        if (this.S == 0) {
            return;
        }
        int itemCount = getItemCount();
        if (itemCount == 0) {
            a aVar2 = this.F;
            if (aVar2 != null) {
                aVar2.b(this, 0);
                return;
            }
            return;
        }
        if (this.D.isFinished() && !this.f٨٠٦٥l0) {
            int k10 = k(itemCount);
            if (k10 < 0) {
                k10 += itemCount;
            }
            this.f٨٠٥٢f = k10;
            a aVar3 = this.F;
            if (aVar3 != null) {
                aVar3.d(this, k10);
                this.F.b(this, 0);
            }
            postInvalidate();
            return;
        }
        if (this.D.computeScrollOffset()) {
            a aVar4 = this.F;
            if (aVar4 != null) {
                aVar4.b(this, 2);
            }
            this.f٨٠٥١e0 = this.D.getCurrY();
            int k11 = k(itemCount);
            int i10 = this.N;
            if (i10 != k11) {
                if (k11 == 0 && i10 == itemCount - 1 && (aVar = this.F) != null) {
                    aVar.a(this);
                }
                this.N = k11;
            }
            postInvalidate();
            this.f٨٠٤١B.postDelayed(this, 20L);
        }
    }

    public void setAtmosphericEnabled(boolean z10) {
        this.f٨٠٧٦w = z10;
        invalidate();
    }

    public void setCurtainColor(int i10) {
        this.f٨٠٦٨o = i10;
        invalidate();
    }

    public void setCurtainCorner(int i10) {
        this.f٨٠٦٩p = i10;
        invalidate();
    }

    public void setCurtainEnabled(boolean z10) {
        this.f٨٠٧٥v = z10;
        if (z10) {
            this.f٨٠٧٤u = false;
        }
        d();
        invalidate();
    }

    public void setCurtainRadius(float f10) {
        this.f٨٠٧٠q = f10;
        invalidate();
    }

    public void setCurvedEnabled(boolean z10) {
        this.f٨٠٧٨y = z10;
        requestLayout();
        invalidate();
    }

    public void setCurvedIndicatorSpace(int i10) {
        this.A = i10;
        j();
        invalidate();
    }

    public void setCurvedMaxAngle(int i10) {
        this.f٨٠٧٩z = i10;
        requestLayout();
        invalidate();
    }

    public void setCyclicEnabled(boolean z10) {
        this.f٨٠٧٧x = z10;
        i();
        invalidate();
    }

    public void setData(List<?> list) {
        I(list, 0);
    }

    public void setDefaultPosition(int i10) {
        F(i10);
    }

    public void setDefaultValue(Object obj) {
        setDefaultPosition(s(obj));
    }

    public void setFormatter(c cVar) {
        this.f٨٠٤٤b = cVar;
    }

    public void setIndicatorColor(int i10) {
        this.f٨٠٦٧n = i10;
        invalidate();
    }

    public void setIndicatorEnabled(boolean z10) {
        this.f٨٠٧٤u = z10;
        j();
        invalidate();
    }

    public void setIndicatorSize(float f10) {
        this.f٨٠٦٦m = f10;
        j();
        invalidate();
    }

    public void setItemSpace(int i10) {
        this.f٨٠٧١r = i10;
        requestLayout();
        invalidate();
    }

    public void setMaxWidthText(String str) {
        if (str != null) {
            this.f٨٠٥٤g = str;
            l();
            requestLayout();
            invalidate();
            return;
        }
        throw new NullPointerException("Maximum width text can not be null!");
    }

    public void setOnWheelChangedListener(a aVar) {
        this.F = aVar;
    }

    public void setSameWidthEnabled(boolean z10) {
        this.f٨٠٧٣t = z10;
        l();
        requestLayout();
        invalidate();
    }

    public void setSelectedTextBold(boolean z10) {
        this.f٨٠٦٤l = z10;
        l();
        requestLayout();
        invalidate();
    }

    public void setSelectedTextColor(int i10) {
        this.f٨٠٥٨i = i10;
        d();
        invalidate();
    }

    public void setSelectedTextSize(float f10) {
        this.f٨٠٦٢k = f10;
        l();
        requestLayout();
        invalidate();
    }

    public void setStyle(int i10) {
        B(getContext(), null, R.attr.WheelStyle, i10);
        C();
        K();
        l();
        i();
        j();
        d();
        requestLayout();
        invalidate();
    }

    public void setTextAlign(int i10) {
        this.f٨٠٧٢s = i10;
        K();
        h();
        invalidate();
    }

    public void setTextColor(int i10) {
        this.f٨٠٥٦h = i10;
        invalidate();
    }

    public void setTextSize(float f10) {
        this.f٨٠٦٠j = f10;
        l();
        requestLayout();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (typeface == null) {
            return;
        }
        this.C.setTypeface(typeface);
        l();
        requestLayout();
        invalidate();
    }

    public void setVisibleItemCount(@IntRange(from = 2) int i10) {
        this.f٨٠٤٨d = i10;
        L();
        requestLayout();
    }

    public String t(int i10) {
        return u(w(i10));
    }

    public String u(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof b) {
            return ((b) obj).a();
        }
        c cVar = this.f٨٠٤٤b;
        if (cVar != null) {
            return cVar.a(obj);
        }
        return obj.toString();
    }

    protected List v() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("贵州穿青人");
        arrayList.add("大定府羡民");
        arrayList.add("不在五十六个民族之内");
        arrayList.add("已识别待定民族");
        arrayList.add("穿青山魈人马");
        arrayList.add("李裕江");
        return arrayList;
    }

    public Object w(int i10) {
        int i11;
        int size = this.f٨٠٤٢a.size();
        if (size == 0 || (i11 = (i10 + size) % size) < 0 || i11 > size - 1) {
            return null;
        }
        return this.f٨٠٤٢a.get(i11);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.WheelStyle);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٨٠٤٢a = new ArrayList();
        this.f٨٠٧٩z = 90;
        this.f٨٠٤١B = new Handler();
        this.C = new Paint(69);
        this.G = new Rect();
        this.H = new Rect();
        this.I = new Rect();
        this.J = new Rect();
        this.K = new Camera();
        this.L = new Matrix();
        this.M = new Matrix();
        B(context, attributeSet, i10, R.style.WheelDefault);
        C();
        L();
        this.D = new Scroller(context);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f٨٠٥٧h0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f٨٠٥٩i0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f٨٠٦١j0 = viewConfiguration.getScaledTouchSlop();
        if (isInEditMode()) {
            setData(v());
        }
    }
}
