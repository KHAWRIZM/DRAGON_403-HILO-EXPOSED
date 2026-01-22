package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.d1;
import com.qmuiteam.qmui.R;
import ic.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIProgressBar extends View {

    /* renamed from: z, reason: collision with root package name */
    public static int f١٢٩٨٦z = e.b(40);

    /* renamed from: a, reason: collision with root package name */
    RectF f١٢٩٨٧a;

    /* renamed from: b, reason: collision with root package name */
    RectF f١٢٩٨٨b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٢٩٨٩c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٢٩٩٠d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٢٩٩١e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٢٩٩٢f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٢٩٩٣g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٢٩٩٤h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٢٩٩٥i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٢٩٩٦j;

    /* renamed from: k, reason: collision with root package name */
    private long f١٢٩٩٧k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٢٩٩٨l;

    /* renamed from: m, reason: collision with root package name */
    private int f١٢٩٩٩m;

    /* renamed from: n, reason: collision with root package name */
    private int f١٣٠٠٠n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٣٠٠١o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f١٣٠٠٢p;

    /* renamed from: q, reason: collision with root package name */
    private Paint f١٣٠٠٣q;

    /* renamed from: r, reason: collision with root package name */
    private Paint f١٣٠٠٤r;

    /* renamed from: s, reason: collision with root package name */
    private Paint f١٣٠٠٥s;

    /* renamed from: t, reason: collision with root package name */
    private RectF f١٣٠٠٦t;

    /* renamed from: u, reason: collision with root package name */
    private String f١٣٠٠٧u;

    /* renamed from: v, reason: collision with root package name */
    private int f١٣٠٠٨v;

    /* renamed from: w, reason: collision with root package name */
    private float f١٣٠٠٩w;

    /* renamed from: x, reason: collision with root package name */
    private Point f١٣٠١٠x;

    /* renamed from: y, reason: collision with root package name */
    private Runnable f١٣٠١١y;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QMUIProgressBar.a(QMUIProgressBar.this);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface c {
    }

    public QMUIProgressBar(Context context) {
        super(context);
        this.f١٣٠٠٣q = new Paint();
        this.f١٣٠٠٤r = new Paint();
        this.f١٣٠٠٥s = new Paint(1);
        this.f١٣٠٠٦t = new RectF();
        this.f١٣٠٠٧u = "";
        this.f١٣٠١١y = new a();
        i(context, null);
    }

    static /* bridge */ /* synthetic */ b a(QMUIProgressBar qMUIProgressBar) {
        qMUIProgressBar.getClass();
        return null;
    }

    private void b(int i10, int i11, boolean z10, int i12) {
        this.f١٣٠٠٤r.setColor(this.f١٢٩٩٢f);
        this.f١٣٠٠٣q.setColor(this.f١٢٩٩٣g);
        int i13 = this.f١٢٩٩١e;
        if (i13 != 0 && i13 != 1) {
            if (i13 == 3) {
                this.f١٣٠٠٤r.setStyle(Paint.Style.FILL);
                this.f١٣٠٠٤r.setAntiAlias(true);
                this.f١٣٠٠٤r.setStrokeCap(Paint.Cap.BUTT);
                this.f١٣٠٠٣q.setStyle(Paint.Style.STROKE);
                this.f١٣٠٠٣q.setStrokeWidth(i12);
                this.f١٣٠٠٣q.setAntiAlias(true);
            } else {
                Paint paint = this.f١٣٠٠٤r;
                Paint.Style style = Paint.Style.STROKE;
                paint.setStyle(style);
                float f10 = i12;
                this.f١٣٠٠٤r.setStrokeWidth(f10);
                this.f١٣٠٠٤r.setAntiAlias(true);
                if (z10) {
                    this.f١٣٠٠٤r.setStrokeCap(Paint.Cap.ROUND);
                } else {
                    this.f١٣٠٠٤r.setStrokeCap(Paint.Cap.BUTT);
                }
                this.f١٣٠٠٣q.setStyle(style);
                this.f١٣٠٠٣q.setStrokeWidth(f10);
                this.f١٣٠٠٣q.setAntiAlias(true);
            }
        } else {
            Paint paint2 = this.f١٣٠٠٤r;
            Paint.Style style2 = Paint.Style.FILL;
            paint2.setStyle(style2);
            this.f١٣٠٠٤r.setStrokeCap(Paint.Cap.BUTT);
            this.f١٣٠٠٣q.setStyle(style2);
        }
        this.f١٣٠٠٥s.setColor(i10);
        this.f١٣٠٠٥s.setTextSize(i11);
        this.f١٣٠٠٥s.setTextAlign(Paint.Align.CENTER);
    }

    private void c() {
        int i10 = this.f١٢٩٩١e;
        if (i10 != 0 && i10 != 1) {
            this.f١٣٠٠٩w = ((Math.min(this.f١٢٩٨٩c, this.f١٢٩٩٠d) - this.f١٣٠٠٨v) / 2.0f) - 0.5f;
            this.f١٣٠١٠x = new Point(this.f١٢٩٨٩c / 2, this.f١٢٩٩٠d / 2);
        } else {
            this.f١٢٩٨٧a = new RectF(getPaddingLeft(), getPaddingTop(), this.f١٢٩٨٩c + getPaddingLeft(), this.f١٢٩٩٠d + getPaddingTop());
            this.f١٢٩٨٨b = new RectF();
        }
    }

    private void d(Canvas canvas, boolean z10) {
        Point point = this.f١٣٠١٠x;
        canvas.drawCircle(point.x, point.y, this.f١٣٠٠٩w, this.f١٣٠٠٣q);
        RectF rectF = this.f١٣٠٠٦t;
        Point point2 = this.f١٣٠١٠x;
        int i10 = point2.x;
        float f10 = this.f١٣٠٠٩w;
        rectF.left = i10 - f10;
        rectF.right = i10 + f10;
        int i11 = point2.y;
        rectF.top = i11 - f10;
        rectF.bottom = i11 + f10;
        int i12 = this.f١٢٩٩٥i;
        if (i12 > 0) {
            canvas.drawArc(rectF, 270.0f, (i12 * 360.0f) / this.f١٢٩٩٤h, z10, this.f١٣٠٠٤r);
        }
        String str = this.f١٣٠٠٧u;
        if (str != null && str.length() > 0) {
            Paint.FontMetricsInt fontMetricsInt = this.f١٣٠٠٥s.getFontMetricsInt();
            RectF rectF2 = this.f١٣٠٠٦t;
            float f11 = rectF2.top;
            float height = rectF2.height() - fontMetricsInt.bottom;
            int i13 = fontMetricsInt.top;
            canvas.drawText(this.f١٣٠٠٧u, this.f١٣٠١٠x.x, (f11 + ((height + i13) / 2.0f)) - i13, this.f١٣٠٠٥s);
        }
    }

    private void e(Canvas canvas) {
        canvas.drawRect(this.f١٢٩٨٧a, this.f١٣٠٠٣q);
        this.f١٢٩٨٨b.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + g(), getPaddingTop() + this.f١٢٩٩٠d);
        canvas.drawRect(this.f١٢٩٨٨b, this.f١٣٠٠٤r);
        String str = this.f١٣٠٠٧u;
        if (str != null && str.length() > 0) {
            Paint.FontMetricsInt fontMetricsInt = this.f١٣٠٠٥s.getFontMetricsInt();
            RectF rectF = this.f١٢٩٨٧a;
            float f10 = rectF.top;
            float height = rectF.height() - fontMetricsInt.bottom;
            int i10 = fontMetricsInt.top;
            canvas.drawText(this.f١٣٠٠٧u, this.f١٢٩٨٧a.centerX(), (f10 + ((height + i10) / 2.0f)) - i10, this.f١٣٠٠٥s);
        }
    }

    private void f(Canvas canvas) {
        float f10 = this.f١٢٩٩٠d / 2.0f;
        canvas.drawRoundRect(this.f١٢٩٨٧a, f10, f10, this.f١٣٠٠٣q);
        this.f١٢٩٨٨b.set(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + g(), getPaddingTop() + this.f١٢٩٩٠d);
        canvas.drawRoundRect(this.f١٢٩٨٨b, f10, f10, this.f١٣٠٠٤r);
        String str = this.f١٣٠٠٧u;
        if (str != null && str.length() > 0) {
            Paint.FontMetricsInt fontMetricsInt = this.f١٣٠٠٥s.getFontMetricsInt();
            RectF rectF = this.f١٢٩٨٧a;
            float f11 = rectF.top;
            float height = rectF.height() - fontMetricsInt.bottom;
            int i10 = fontMetricsInt.top;
            canvas.drawText(this.f١٣٠٠٧u, this.f١٢٩٨٧a.centerX(), (f11 + ((height + i10) / 2.0f)) - i10, this.f١٣٠٠٥s);
        }
    }

    private int g() {
        return (this.f١٢٩٨٩c * this.f١٢٩٩٥i) / this.f١٢٩٩٤h;
    }

    public int getMaxValue() {
        return this.f١٢٩٩٤h;
    }

    public int getProgress() {
        return this.f١٢٩٩٥i;
    }

    public c getQMUIProgressBarTextGenerator() {
        return null;
    }

    public void h(int i10, boolean z10) {
        int i11 = this.f١٢٩٩٤h;
        if (i10 <= i11 && i10 >= 0) {
            int i12 = this.f١٢٩٩٦j;
            if (i12 != -1 || this.f١٢٩٩٥i != i10) {
                if (i12 != -1 && i12 == i10) {
                    return;
                }
                if (!z10) {
                    this.f١٢٩٩٦j = -1;
                    this.f١٢٩٩٥i = i10;
                    this.f١٣٠١١y.run();
                    invalidate();
                    return;
                }
                this.f١٢٩٩٩m = Math.abs((int) (((this.f١٢٩٩٥i - i10) * 1000) / i11));
                this.f١٢٩٩٧k = System.currentTimeMillis();
                this.f١٢٩٩٨l = i10 - this.f١٢٩٩٥i;
                this.f١٢٩٩٦j = i10;
                invalidate();
            }
        }
    }

    public void i(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIProgressBar);
        this.f١٢٩٩١e = obtainStyledAttributes.getInt(R.styleable.QMUIProgressBar_qmui_type, 0);
        this.f١٢٩٩٢f = obtainStyledAttributes.getColor(R.styleable.QMUIProgressBar_qmui_progress_color, -16776961);
        this.f١٢٩٩٣g = obtainStyledAttributes.getColor(R.styleable.QMUIProgressBar_qmui_background_color, -7829368);
        this.f١٢٩٩٤h = obtainStyledAttributes.getInt(R.styleable.QMUIProgressBar_qmui_max_value, 100);
        this.f١٢٩٩٥i = obtainStyledAttributes.getInt(R.styleable.QMUIProgressBar_qmui_value, 0);
        this.f١٣٠٠٢p = obtainStyledAttributes.getBoolean(R.styleable.QMUIProgressBar_qmui_stroke_round_cap, false);
        this.f١٣٠٠٠n = 20;
        int i10 = R.styleable.QMUIProgressBar_android_textSize;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.f١٣٠٠٠n = obtainStyledAttributes.getDimensionPixelSize(i10, 20);
        }
        this.f١٣٠٠١o = -16777216;
        int i11 = R.styleable.QMUIProgressBar_android_textColor;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f١٣٠٠١o = obtainStyledAttributes.getColor(i11, -16777216);
        }
        int i12 = this.f١٢٩٩١e;
        if (i12 == 2 || i12 == 3) {
            this.f١٣٠٠٨v = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIProgressBar_qmui_stroke_width, f١٢٩٨٦z);
        }
        obtainStyledAttributes.recycle();
        b(this.f١٣٠٠١o, this.f١٣٠٠٠n, this.f١٣٠٠٢p, this.f١٣٠٠٨v);
        setProgress(this.f١٢٩٩٥i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f١٢٩٩٦j != -1) {
            long currentTimeMillis = System.currentTimeMillis() - this.f١٢٩٩٧k;
            int i10 = this.f١٢٩٩٩m;
            if (currentTimeMillis >= i10) {
                this.f١٢٩٩٥i = this.f١٢٩٩٦j;
                post(this.f١٣٠١١y);
                this.f١٢٩٩٦j = -1;
            } else {
                this.f١٢٩٩٥i = (int) (this.f١٢٩٩٦j - ((1.0f - (((float) currentTimeMillis) / i10)) * this.f١٢٩٩٨l));
                post(this.f١٣٠١١y);
                d1.h0(this);
            }
        }
        int i11 = this.f١٢٩٩١e;
        boolean z10 = true;
        if (((i11 == 0 || i11 == 1) && this.f١٢٩٨٧a == null) || ((i11 == 2 || i11 == 3) && this.f١٣٠١٠x == null)) {
            c();
        }
        int i12 = this.f١٢٩٩١e;
        if (i12 == 0) {
            e(canvas);
        } else {
            if (i12 == 1) {
                f(canvas);
                return;
            }
            if (i12 != 3) {
                z10 = false;
            }
            d(canvas, z10);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f١٢٩٨٩c = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.f١٢٩٩٠d = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        c();
        setMeasuredDimension(this.f١٢٩٨٩c, this.f١٢٩٩٠d);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f١٢٩٩٣g = i10;
        this.f١٣٠٠٣q.setColor(i10);
        invalidate();
    }

    public void setMaxValue(int i10) {
        this.f١٢٩٩٤h = i10;
    }

    public void setOnProgressChangeListener(b bVar) {
    }

    public void setProgress(int i10) {
        h(i10, true);
    }

    public void setProgressColor(int i10) {
        this.f١٢٩٩٢f = i10;
        this.f١٣٠٠٤r.setColor(i10);
        invalidate();
    }

    public void setQMUIProgressBarTextGenerator(c cVar) {
    }

    public void setStrokeRoundCap(boolean z10) {
        Paint.Cap cap;
        Paint paint = this.f١٣٠٠٤r;
        if (z10) {
            cap = Paint.Cap.ROUND;
        } else {
            cap = Paint.Cap.BUTT;
        }
        paint.setStrokeCap(cap);
        invalidate();
    }

    public void setStrokeWidth(int i10) {
        if (this.f١٣٠٠٨v != i10) {
            this.f١٣٠٠٨v = i10;
            if (this.f١٢٩٨٩c > 0) {
                c();
            }
            b(this.f١٣٠٠١o, this.f١٣٠٠٠n, this.f١٣٠٠٢p, this.f١٣٠٠٨v);
            invalidate();
        }
    }

    public void setTextColor(int i10) {
        this.f١٣٠٠٥s.setColor(i10);
        invalidate();
    }

    public void setTextSize(int i10) {
        this.f١٣٠٠٥s.setTextSize(i10);
        invalidate();
    }

    public void setType(int i10) {
        this.f١٢٩٩١e = i10;
        b(this.f١٣٠٠١o, this.f١٣٠٠٠n, this.f١٣٠٠٢p, this.f١٣٠٠٨v);
        invalidate();
    }

    public QMUIProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣٠٠٣q = new Paint();
        this.f١٣٠٠٤r = new Paint();
        this.f١٣٠٠٥s = new Paint(1);
        this.f١٣٠٠٦t = new RectF();
        this.f١٣٠٠٧u = "";
        this.f١٣٠١١y = new a();
        i(context, attributeSet);
    }

    public QMUIProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٠٠٣q = new Paint();
        this.f١٣٠٠٤r = new Paint();
        this.f١٣٠٠٥s = new Paint(1);
        this.f١٣٠٠٦t = new RectF();
        this.f١٣٠٠٧u = "";
        this.f١٣٠١١y = new a();
        i(context, attributeSet);
    }
}
