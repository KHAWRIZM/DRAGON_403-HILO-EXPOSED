package com.qiahao.base_common.ui.wheel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import com.qiahao.base_common.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.model.WheelItem;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class WheelView extends View implements bb.b {
    private boolean A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f١٢٥٤٠B;
    private final RectF C;
    private long D;
    private int E;
    private int F;
    private int G;
    private VelocityTracker H;
    private OverScroller I;
    private int J;

    /* renamed from: a, reason: collision with root package name */
    private final String f١٢٥٤١a;

    /* renamed from: b, reason: collision with root package name */
    private final TextPaint f١٢٥٤٢b;

    /* renamed from: c, reason: collision with root package name */
    private final Camera f١٢٥٤٣c;

    /* renamed from: d, reason: collision with root package name */
    private final Matrix f١٢٥٤٤d;

    /* renamed from: e, reason: collision with root package name */
    private float f١٢٥٤٥e;

    /* renamed from: f, reason: collision with root package name */
    private bb.a[] f١٢٥٤٦f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٢٥٤٧g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٢٥٤٨h;

    /* renamed from: i, reason: collision with root package name */
    private float f١٢٥٤٩i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٢٥٥٠j;

    /* renamed from: k, reason: collision with root package name */
    private float f١٢٥٥١k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٢٥٥٢l;

    /* renamed from: m, reason: collision with root package name */
    private int f١٢٥٥٣m;

    /* renamed from: n, reason: collision with root package name */
    private Rect[] f١٢٥٥٤n;

    /* renamed from: o, reason: collision with root package name */
    private Rect[] f١٢٥٥٥o;

    /* renamed from: p, reason: collision with root package name */
    private int f١٢٥٥٦p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٢٥٥٧q;

    /* renamed from: r, reason: collision with root package name */
    private float f١٢٥٥٨r;

    /* renamed from: s, reason: collision with root package name */
    private int f١٢٥٥٩s;

    /* renamed from: t, reason: collision with root package name */
    private int f١٢٥٦٠t;

    /* renamed from: u, reason: collision with root package name */
    private int f١٢٥٦١u;

    /* renamed from: v, reason: collision with root package name */
    private float f١٢٥٦٢v;

    /* renamed from: w, reason: collision with root package name */
    private float f١٢٥٦٣w;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f١٢٥٦٤x;

    /* renamed from: y, reason: collision with root package name */
    private int f١٢٥٦٥y;

    /* renamed from: z, reason: collision with root package name */
    private ValueAnimator f١٢٥٦٦z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WheelView.this.y(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WheelView wheelView = WheelView.this;
            wheelView.A = false;
            if (wheelView.f١٢٥٤٠B) {
                wheelView.f١٢٥٤٠B = false;
            } else {
                WheelView.b(wheelView);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            WheelView.this.A = true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface c {
    }

    public WheelView(Context context) {
        super(context);
        this.f١٢٥٤١a = "WheelView2";
        this.f١٢٥٤٢b = new TextPaint(1);
        this.f١٢٥٤٣c = new Camera();
        this.f١٢٥٤٤d = new Matrix();
        this.f١٢٥٤٥e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٤٦f = null;
        this.f١٢٥٤٧g = -16777216;
        this.f١٢٥٤٨h = -16777216;
        this.f١٢٥٤٩i = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٥٠j = 0;
        this.f١٢٥٥١k = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٥٢l = 5;
        this.f١٢٥٥٣m = 7;
        this.f١٢٥٥٤n = null;
        this.f١٢٥٥٥o = null;
        this.f١٢٥٥٦p = 0;
        this.f١٢٥٥٧q = 0;
        this.f١٢٥٥٨r = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٥٩s = 0;
        this.f١٢٥٦٠t = 0;
        this.f١٢٥٦١u = 0;
        this.f١٢٥٦٢v = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٦٣w = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٦٤x = new int[2];
        this.f١٢٥٦٥y = 0;
        this.f١٢٥٦٦z = null;
        this.A = false;
        this.f١٢٥٤٠B = false;
        this.C = new RectF();
        this.D = 0L;
        this.H = null;
        this.J = 0;
        r(context, null, 0);
    }

    static /* bridge */ /* synthetic */ c b(WheelView wheelView) {
        wheelView.getClass();
        return null;
    }

    private int f(Rect rect) {
        return (int) ((1.0f - ((Math.abs((getHeight() / 2) - rect.centerY()) * 0.6f) / (this.f١٢٥٦١u * (this.f١٢٥٥٢l / 2)))) * 255.0f);
    }

    private float g() {
        bb.a[] aVarArr = this.f١٢٥٤٦f;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        for (bb.a aVar : aVarArr) {
            String showText = aVar.getShowText();
            if (showText != null && showText.length() != 0) {
                f10 += this.f١٢٥٤٢b.measureText(showText);
            }
        }
        return f10 / getItemCount();
    }

    private int getItemCount() {
        bb.a[] aVarArr = this.f١٢٥٤٦f;
        if (aVarArr == null) {
            return 0;
        }
        return aVarArr.length;
    }

    private int h(int i10, Rect rect) {
        return (i10 * Math.abs((getHeight() / 2) - rect.centerY())) / (this.f١٢٥٦١u * (this.f١٢٥٥٢l / 2));
    }

    private float i(Rect rect, float f10) {
        return ((f10 * ((getHeight() / 2) - rect.centerY())) * 1.0f) / (this.f١٢٥٦١u * (this.f١٢٥٥٢l / 2));
    }

    private float j(Rect rect) {
        return (((getHeight() / 2) - rect.centerY()) * 0.3f) / (this.f١٢٥٦١u * (this.f١٢٥٥٢l / 2));
    }

    private int k(int i10) {
        while (i10 > 1200) {
            i10 /= 2;
        }
        return i10;
    }

    private void l(int i10, int i11) {
        int i12 = this.f١٢٥٦١u;
        int i13 = 0 - i12;
        int i14 = i10 / i13;
        int i15 = i10 % i13;
        if (i11 > 0 && i15 != 0) {
            i14++;
            i15 = i12 - Math.abs(i15);
        }
        if (i11 < 0 && Math.abs(i15) >= this.f١٢٥٦١u / 4) {
            i14++;
        }
        if (i11 > 0 && Math.abs(i15) >= this.f١٢٥٦١u / 4) {
            i14--;
        }
        int min = Math.min(Math.max(i14, 0), getItemCount() - 1);
        int i16 = (0 - (this.f١٢٥٦١u * min)) - i10;
        int[] iArr = this.f١٢٥٦٤x;
        iArr[0] = min;
        iArr[1] = i16;
    }

    private void m() {
        if (this.f١٢٥٦٦z == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f١٢٥٦٦z = valueAnimator;
            valueAnimator.addUpdateListener(new a());
            this.f١٢٥٦٦z.setInterpolator(new LinearInterpolator());
            this.f١٢٥٦٦z.addListener(new b());
        }
    }

    private void n(Canvas canvas, Rect rect, bb.a aVar, int i10, TextPaint textPaint) {
        String showText;
        float width;
        float f10;
        if (aVar == null) {
            showText = "";
        } else {
            showText = aVar.getShowText();
        }
        if (showText != null && showText.trim().length() != 0) {
            int i11 = 0;
            rect.offset(0, i10);
            if (f(rect) == 255) {
                textPaint.setColor(this.f١٢٥٤٨h);
            } else {
                textPaint.setColor(this.f١٢٥٤٧g);
            }
            textPaint.setAlpha(f(rect));
            int i12 = this.f١٢٥٥٠j;
            if (i12 != 0) {
                i11 = h(i12, rect);
            }
            float measureText = textPaint.measureText(showText);
            int i13 = this.f١٢٥٥٠j;
            if (i13 > 0) {
                f10 = ((getWidth() + this.f١٢٥٥١k) / 2.0f) - measureText;
            } else {
                if (i13 < 0) {
                    width = getWidth() - this.f١٢٥٥١k;
                } else {
                    width = getWidth() - measureText;
                }
                f10 = width / 2.0f;
            }
            float f11 = f10 + i11;
            float width2 = getWidth() / 2.0f;
            float exactCenterY = rect.exactCenterY();
            float f12 = this.f١٢٥٤٥e + exactCenterY;
            this.f١٢٥٤٤d.reset();
            this.f١٢٥٤٣c.save();
            this.f١٢٥٤٣c.rotateX(i(rect, this.f١٢٥٥٨r));
            this.f١٢٥٤٣c.getMatrix(this.f١٢٥٤٤d);
            this.f١٢٥٤٣c.restore();
            this.f١٢٥٤٤d.preTranslate(-width2, -exactCenterY);
            this.f١٢٥٤٤d.postTranslate(width2, exactCenterY);
            int i14 = this.f١٢٥٥٠j;
            if (i14 > 0) {
                this.f١٢٥٤٤d.setSkew(DownloadProgress.UNKNOWN_PROGRESS - j(rect), DownloadProgress.UNKNOWN_PROGRESS, (measureText + f11) / 2.0f, exactCenterY);
            } else if (i14 < 0) {
                this.f١٢٥٤٤d.setSkew(j(rect), DownloadProgress.UNKNOWN_PROGRESS, (measureText + f11) / 2.0f, exactCenterY);
            }
            canvas.save();
            canvas.concat(this.f١٢٥٤٤d);
            canvas.drawText(showText, f11, f12, textPaint);
            canvas.restore();
        }
    }

    private void o(int... iArr) {
        if (u(iArr)) {
            return;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (i11 > 0) {
                i10 += Math.abs(iArr[i11] - iArr[i11 - 1]);
            }
        }
        if (i10 == 0) {
            return;
        }
        m();
        if (this.f١٢٥٦٦z.isRunning()) {
            this.f١٢٥٤٠B = true;
            this.f١٢٥٦٦z.cancel();
        }
        this.f١٢٥٦٦z.setIntValues(iArr);
        this.f١٢٥٦٦z.setDuration(k(i10));
        this.f١٢٥٦٦z.start();
    }

    private void p(float f10, float f11) {
        int i10 = this.f١٢٥٦٥y - (this.f١٢٥٥٣m / 2);
        for (int i11 = 0; i11 < this.f١٢٥٥٣m; i11++) {
            this.C.set(this.f١٢٥٥٥o[i11]);
            if (this.C.contains(f10, f11)) {
                if (i10 >= 0 && i10 < getItemCount()) {
                    setSelectedIndex(i10);
                    return;
                }
                return;
            }
            i10++;
        }
    }

    private bb.a q(int i10) {
        if (!v() && i10 >= 0 && i10 < getItemCount()) {
            return this.f١٢٥٤٦f[i10];
        }
        return null;
    }

    private void s() {
        this.f١٢٥٤٢b.setColor(this.f١٢٥٤٧g);
        this.f١٢٥٤٢b.setTextSize(this.f١٢٥٤٩i);
        Paint.FontMetrics fontMetrics = this.f١٢٥٤٢b.getFontMetrics();
        Rect rect = new Rect();
        this.f١٢٥٤٢b.getTextBounds("菜单选项", 0, 4, rect);
        int height = rect.height() + this.f١٢٥٦٠t;
        this.f١٢٥٦١u = height;
        float f10 = (-height) / 2.0f;
        float f11 = height - fontMetrics.bottom;
        float f12 = fontMetrics.top;
        this.f١٢٥٤٥e = (f10 + ((f11 + f12) / 2.0f)) - f12;
        if (this.f١٢٥٥٢l < 5) {
            this.f١٢٥٥٢l = 5;
        }
        int i10 = this.f١٢٥٥٢l;
        if (i10 % 2 == 0) {
            this.f١٢٥٥٢l = i10 + 1;
        }
        int i11 = this.f١٢٥٥٢l + 2;
        this.f١٢٥٥٣m = i11;
        this.f١٢٥٥٤n = new Rect[i11];
        this.f١٢٥٥٥o = new Rect[i11];
        for (int i12 = 0; i12 < this.f١٢٥٥٣m; i12++) {
            this.f١٢٥٥٤n[i12] = new Rect();
            this.f١٢٥٥٥o[i12] = new Rect();
        }
    }

    private void t() {
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
    }

    private boolean u(int... iArr) {
        if (iArr != null && iArr.length >= 2) {
            int i10 = iArr[0];
            for (int i11 : iArr) {
                if (i10 != i11) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean v() {
        if (getItemCount() == 0) {
            return true;
        }
        return false;
    }

    private void w() {
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.H = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i10, int i11) {
        l(i10, i11);
        this.f١٢٥٥٧q = i10;
        int[] iArr = this.f١٢٥٦٤x;
        this.f١٢٥٦٥y = iArr[0];
        this.f١٢٥٥٦p = iArr[1];
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.I.computeScrollOffset()) {
            int currY = this.I.getCurrY();
            this.f١٢٥٥٧q = currY;
            y(currY, 0);
            invalidate();
            return;
        }
        int i10 = this.J;
        if (i10 != 0) {
            this.J = 0;
            l(this.f١٢٥٥٧q, i10);
            int[] iArr = this.f١٢٥٦٤x;
            int i11 = iArr[0];
            this.f١٢٥٦٥y = i11;
            this.f١٢٥٥٦p = iArr[1];
            o(this.f١٢٥٥٧q, 0 - (i11 * this.f١٢٥٦١u));
        }
    }

    public int getItemHeight() {
        return this.f١٢٥٦١u;
    }

    public int getSelectedIndex() {
        return this.f١٢٥٦٥y;
    }

    public int getShowCount() {
        return this.f١٢٥٥٢l;
    }

    public int getTotalMoveY() {
        return this.f١٢٥٥٧q;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (v()) {
            return;
        }
        int i10 = this.f١٢٥٦٥y - (this.f١٢٥٥٣m / 2);
        for (int i11 = 0; i11 < this.f١٢٥٥٣m; i11++) {
            Rect rect = this.f١٢٥٥٥o[i11];
            rect.set(this.f١٢٥٥٤n[i11]);
            rect.left = 0;
            rect.right = getWidth();
            if (i10 >= 0 && i10 < getItemCount()) {
                n(canvas, rect, q(i10), -this.f١٢٥٥٦p, this.f١٢٥٤٢b);
            }
            i10++;
        }
        computeScroll();
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12 = 0 - this.f١٢٥٦١u;
        for (int i13 = 0; i13 < this.f١٢٥٥٣m; i13++) {
            this.f١٢٥٥٤n[i13].set(0, i12, 0, this.f١٢٥٦١u + i12);
            i12 += this.f١٢٥٦١u;
        }
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(this.f١٢٥٦١u * this.f١٢٥٥٢l, 1073741824));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if (r1 != 3) goto L٤١;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i10;
        if (v()) {
            return super.onTouchEvent(motionEvent);
        }
        t();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.H.addMovement(motionEvent);
                    float x10 = motionEvent.getX();
                    float y10 = motionEvent.getY();
                    int i11 = (int) (y10 - this.f١٢٥٦٣w);
                    if (i11 != 0) {
                        this.D = 0L;
                        int abs = i11 / Math.abs(i11);
                        this.C.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, getWidth(), getHeight());
                        if (this.C.contains(x10, y10)) {
                            this.f١٢٥٦٢v = x10;
                            this.f١٢٥٦٣w = y10;
                            y(this.f١٢٥٥٧q + i11, abs);
                        }
                    }
                }
            }
            if (System.currentTimeMillis() - this.D <= 1000) {
                p(motionEvent.getX(), motionEvent.getY());
            } else {
                VelocityTracker velocityTracker = this.H;
                velocityTracker.computeCurrentVelocity(this.f١٢٥٥٩s, this.F);
                float yVelocity = velocityTracker.getYVelocity();
                w();
                if (yVelocity == DownloadProgress.UNKNOWN_PROGRESS) {
                    i10 = 0;
                } else if (yVelocity < DownloadProgress.UNKNOWN_PROGRESS) {
                    i10 = -1;
                } else {
                    i10 = 1;
                }
                if (Math.abs(yVelocity) >= this.E) {
                    this.J = i10;
                    OverScroller overScroller = this.I;
                    int i12 = this.f١٢٥٥٧q;
                    int i13 = (int) yVelocity;
                    int itemCount = getItemCount();
                    int i14 = this.f١٢٥٥٢l / 2;
                    int i15 = this.f١٢٥٦١u;
                    overScroller.fling(0, i12, 0, i13, 0, 0, (-(itemCount + i14)) * i15, i14 * i15, 0, 0);
                    invalidate();
                } else {
                    l(this.f١٢٥٥٧q, i10);
                    int[] iArr = this.f١٢٥٦٤x;
                    int i16 = iArr[0];
                    this.f١٢٥٦٥y = i16;
                    this.f١٢٥٥٦p = iArr[1];
                    o(this.f١٢٥٥٧q, 0 - (i16 * this.f١٢٥٦١u));
                }
            }
        } else {
            this.H.clear();
            this.J = 0;
            this.I.forceFinished(true);
            ValueAnimator valueAnimator = this.f١٢٥٦٦z;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f١٢٥٤٠B = true;
                this.f١٢٥٦٦z.cancel();
            }
            this.f١٢٥٦٢v = motionEvent.getX();
            this.f١٢٥٦٣w = motionEvent.getY();
            this.D = System.currentTimeMillis();
        }
        return true;
    }

    public void r(Context context, AttributeSet attributeSet, int i10) {
        String valueOf;
        this.I = new OverScroller(context);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.E = viewConfiguration.getScaledMinimumFlingVelocity();
        this.F = viewConfiguration.getScaledMaximumFlingVelocity();
        this.G = viewConfiguration.getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WheelView, i10, 0);
        float applyDimension = TypedValue.applyDimension(1, 14.0f, getResources().getDisplayMetrics());
        this.f١٢٥٤٧g = obtainStyledAttributes.getColor(R.styleable.WheelView_wheelTextColor, -13421773);
        this.f١٢٥٤٨h = obtainStyledAttributes.getColor(R.styleable.WheelView_wheelTextSelectColor, -13421773);
        this.f١٢٥٤٩i = obtainStyledAttributes.getDimension(R.styleable.WheelView_wheelTextSize, applyDimension);
        this.f١٢٥٥٢l = obtainStyledAttributes.getInt(R.styleable.WheelView_wheelShowCount, 5);
        this.f١٢٥٥٠j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WheelView_wheelTotalOffsetX, 0);
        this.f١٢٥٦٠t = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WheelView_wheelItemVerticalSpace, 32);
        int i11 = R.styleable.WheelView_wheelRotationX;
        this.f١٢٥٥٨r = obtainStyledAttributes.getFloat(i11, 45.0f);
        int integer = obtainStyledAttributes.getInteger(i11, 600);
        this.f١٢٥٥٩s = integer;
        if (integer < 0) {
            this.f١٢٥٥٩s = Math.abs(integer);
        }
        obtainStyledAttributes.recycle();
        s();
        if (isInEditMode()) {
            bb.a[] aVarArr = new bb.a[50];
            for (int i12 = 0; i12 < 50; i12++) {
                StringBuilder sb = new StringBuilder();
                sb.append("菜单选项");
                if (i12 < 10) {
                    valueOf = "0" + i12;
                } else {
                    valueOf = String.valueOf(i12);
                }
                sb.append(valueOf);
                aVarArr[i12] = new WheelItem(sb.toString());
            }
            setItems(aVarArr);
        }
    }

    public void setItemVerticalSpace(int i10) {
        this.f١٢٥٦٠t = i10;
        s();
        requestLayout();
    }

    public void setItems(bb.a[] aVarArr) {
        this.f١٢٥٤٦f = aVarArr;
        if (!v()) {
            this.f١٢٥٥١k = g();
            invalidate();
        }
    }

    @Override // bb.b
    public void setOnSelectedListener(c cVar) {
    }

    public void setSelectedIndex(int i10) {
        x(i10, true);
    }

    public void setShowCount(int i10) {
        this.f١٢٥٥٢l = i10;
        s();
        requestLayout();
    }

    public void setTextColor(int i10) {
        this.f١٢٥٤٧g = i10;
        this.f١٢٥٤٢b.setColor(i10);
        invalidate();
    }

    public void setTextSize(float f10) {
        this.f١٢٥٤٩i = f10;
        s();
        requestLayout();
    }

    public void setTotalOffsetX(int i10) {
        this.f١٢٥٥٠j = i10;
        invalidate();
    }

    public void setVelocityUnits(int i10) {
        this.f١٢٥٥٩s = Math.abs(i10);
    }

    public void setWheelRotationX(float f10) {
        if (this.f١٢٥٥٨r != f10) {
            this.f١٢٥٥٨r = f10;
            invalidate();
        }
    }

    public void x(int i10, boolean z10) {
        if (i10 >= 0 && i10 < getItemCount()) {
            if (z10) {
                o(this.f١٢٥٥٧q, 0 - (this.f١٢٥٦١u * i10));
                return;
            }
            this.f١٢٥٥٧q = 0 - (this.f١٢٥٦١u * i10);
            this.f١٢٥٦٥y = i10;
            this.f١٢٥٥٦p = 0;
            invalidate();
            return;
        }
        throw new IndexOutOfBoundsException("Out of array bounds.");
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٥٤١a = "WheelView2";
        this.f١٢٥٤٢b = new TextPaint(1);
        this.f١٢٥٤٣c = new Camera();
        this.f١٢٥٤٤d = new Matrix();
        this.f١٢٥٤٥e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٤٦f = null;
        this.f١٢٥٤٧g = -16777216;
        this.f١٢٥٤٨h = -16777216;
        this.f١٢٥٤٩i = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٥٠j = 0;
        this.f١٢٥٥١k = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٥٢l = 5;
        this.f١٢٥٥٣m = 7;
        this.f١٢٥٥٤n = null;
        this.f١٢٥٥٥o = null;
        this.f١٢٥٥٦p = 0;
        this.f١٢٥٥٧q = 0;
        this.f١٢٥٥٨r = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٥٩s = 0;
        this.f١٢٥٦٠t = 0;
        this.f١٢٥٦١u = 0;
        this.f١٢٥٦٢v = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٦٣w = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٦٤x = new int[2];
        this.f١٢٥٦٥y = 0;
        this.f١٢٥٦٦z = null;
        this.A = false;
        this.f١٢٥٤٠B = false;
        this.C = new RectF();
        this.D = 0L;
        this.H = null;
        this.J = 0;
        r(context, attributeSet, 0);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٥٤١a = "WheelView2";
        this.f١٢٥٤٢b = new TextPaint(1);
        this.f١٢٥٤٣c = new Camera();
        this.f١٢٥٤٤d = new Matrix();
        this.f١٢٥٤٥e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٤٦f = null;
        this.f١٢٥٤٧g = -16777216;
        this.f١٢٥٤٨h = -16777216;
        this.f١٢٥٤٩i = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٥٠j = 0;
        this.f١٢٥٥١k = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٥٢l = 5;
        this.f١٢٥٥٣m = 7;
        this.f١٢٥٥٤n = null;
        this.f١٢٥٥٥o = null;
        this.f١٢٥٥٦p = 0;
        this.f١٢٥٥٧q = 0;
        this.f١٢٥٥٨r = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٥٩s = 0;
        this.f١٢٥٦٠t = 0;
        this.f١٢٥٦١u = 0;
        this.f١٢٥٦٢v = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٦٣w = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٥٦٤x = new int[2];
        this.f١٢٥٦٥y = 0;
        this.f١٢٥٦٦z = null;
        this.A = false;
        this.f١٢٥٤٠B = false;
        this.C = new RectF();
        this.D = 0L;
        this.H = null;
        this.J = 0;
        r(context, attributeSet, i10);
    }
}
