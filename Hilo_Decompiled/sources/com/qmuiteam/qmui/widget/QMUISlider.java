package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.collection.SimpleArrayMap;
import bc.d;
import com.qmuiteam.qmui.R;
import dc.f;
import ic.e;
import ic.g;
import ic.k;
import ic.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUISlider extends FrameLayout implements fc.a {

    /* renamed from: v, reason: collision with root package name */
    private static SimpleArrayMap f١٣٠٥٣v;

    /* renamed from: a, reason: collision with root package name */
    private Paint f١٣٠٥٤a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٣٠٥٥b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٣٠٥٦c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٣٠٥٧d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٣٠٥٨e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٣٠٥٩f;

    /* renamed from: g, reason: collision with root package name */
    private b f١٣٠٦٠g;

    /* renamed from: h, reason: collision with root package name */
    private l f١٣٠٦١h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٣٠٦٢i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٣٠٦٣j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f١٣٠٦٤k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f١٣٠٦٥l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٣٠٦٦m;

    /* renamed from: n, reason: collision with root package name */
    private int f١٣٠٦٧n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٣٠٦٨o;

    /* renamed from: p, reason: collision with root package name */
    private int f١٣٠٦٩p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٣٠٧٠q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f١٣٠٧١r;

    /* renamed from: s, reason: collision with root package name */
    private int f١٣٠٧٢s;

    /* renamed from: t, reason: collision with root package name */
    private RectF f١٣٠٧٣t;

    /* renamed from: u, reason: collision with root package name */
    private c f١٣٠٧٤u;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class DefaultThumbView extends View implements b, fc.a {

        /* renamed from: c, reason: collision with root package name */
        private static SimpleArrayMap f١٣٠٧٥c;

        /* renamed from: a, reason: collision with root package name */
        private final d f١٣٠٧٦a;

        /* renamed from: b, reason: collision with root package name */
        private final int f١٣٠٧٧b;

        static {
            SimpleArrayMap simpleArrayMap = new SimpleArrayMap(2);
            f١٣٠٧٥c = simpleArrayMap;
            simpleArrayMap.put("background", Integer.valueOf(R.attr.qmui_skin_support_slider_thumb_bg_color));
            f١٣٠٧٥c.put("border", Integer.valueOf(R.attr.qmui_skin_support_slider_thumb_border_color));
        }

        public DefaultThumbView(Context context, int i10, int i11) {
            super(context, null, i11);
            this.f١٣٠٧٧b = i10;
            d dVar = new d(context, null, i11, this);
            this.f١٣٠٧٦a = dVar;
            dVar.K(i10 / 2);
            setPress(false);
        }

        @Override // com.qmuiteam.qmui.widget.QMUISlider.b
        public void a(int i10, int i11) {
        }

        @Override // android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            this.f١٣٠٧٦a.p(canvas, getWidth(), getHeight());
            this.f١٣٠٧٦a.o(canvas);
        }

        @Override // fc.a
        public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
            return f١٣٠٧٥c;
        }

        @Override // com.qmuiteam.qmui.widget.QMUISlider.b
        public int getLeftRightMargin() {
            return 0;
        }

        @Override // android.view.View
        protected void onMeasure(int i10, int i11) {
            int i12 = this.f١٣٠٧٧b;
            setMeasuredDimension(i12, i12);
        }

        public void setBorderColor(int i10) {
            this.f١٣٠٧٦a.setBorderColor(i10);
            invalidate();
        }

        @Override // com.qmuiteam.qmui.widget.QMUISlider.b
        public void setPress(boolean z10) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface a {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
        void a(int i10, int i11);

        int getLeftRightMargin();

        void setPress(boolean z10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QMUISlider.this.f١٣٠٧١r = true;
            int unused = QMUISlider.this.f١٣٠٦٣j;
            QMUISlider qMUISlider = QMUISlider.this;
            qMUISlider.j(qMUISlider.f١٣٠٦٩p, QMUISlider.this.getMaxThumbOffset());
            QMUISlider.this.f١٣٠٧٠q = true;
            QMUISlider.this.f١٣٠٦٠g.setPress(true);
            QMUISlider.a(QMUISlider.this);
        }
    }

    static {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(2);
        f١٣٠٥٣v = simpleArrayMap;
        simpleArrayMap.put("background", Integer.valueOf(R.attr.qmui_skin_support_slider_bar_bg_color));
        f١٣٠٥٣v.put("progressColor", Integer.valueOf(R.attr.qmui_skin_support_slider_bar_progress_color));
        f١٣٠٥٣v.put("hintColor", Integer.valueOf(R.attr.qmui_skin_support_slider_record_progress_color));
    }

    public QMUISlider(Context context) {
        this(context, null);
    }

    static /* bridge */ /* synthetic */ a a(QMUISlider qMUISlider) {
        qMUISlider.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMaxThumbOffset() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.f١٣٠٦٠g.getLeftRightMargin() * 2)) - k().getWidth();
    }

    private void i(int i10) {
        k();
        float c10 = (this.f١٣٠٦١h.c() * 1.0f) / i10;
        int i11 = this.f١٣٠٦٢i;
        u(g.c((int) ((i11 * c10) + 0.5f), 0, i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i10, int i11) {
        if (this.f١٣٠٦٠g == null) {
            return;
        }
        float f10 = i11 / this.f١٣٠٦٢i;
        float paddingLeft = (i10 - getPaddingLeft()) - this.f١٣٠٦٠g.getLeftRightMargin();
        float f11 = f10 / 2.0f;
        if (paddingLeft <= f11) {
            this.f١٣٠٦١h.g(0);
            u(0);
        } else if (i10 >= ((getWidth() - getPaddingRight()) - this.f١٣٠٦٠g.getLeftRightMargin()) - f11) {
            this.f١٣٠٦١h.g(i11);
            u(this.f١٣٠٦٢i);
        } else {
            int width = (int) ((this.f١٣٠٦٢i * (paddingLeft / (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.f١٣٠٦٠g.getLeftRightMargin() * 2)))) + 0.5f);
            this.f١٣٠٦١h.g((int) (width * f10));
            u(width);
        }
    }

    private View k() {
        return (View) this.f١٣٠٦٠g;
    }

    private boolean p(float f10, float f11) {
        return q(k(), f10, f11);
    }

    private void u(int i10) {
        this.f١٣٠٦٣j = i10;
        this.f١٣٠٦٠g.a(i10, this.f١٣٠٦٢i);
    }

    public int getBarHeight() {
        return this.f١٣٠٥٥b;
    }

    public int getBarNormalColor() {
        return this.f١٣٠٥٦c;
    }

    public int getBarProgressColor() {
        return this.f١٣٠٥٧d;
    }

    public int getCurrentProgress() {
        return this.f١٣٠٦٣j;
    }

    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return f١٣٠٥٣v;
    }

    public int getRecordProgress() {
        return this.f١٣٠٦٧n;
    }

    public int getRecordProgressColor() {
        return this.f١٣٠٥٨e;
    }

    public int getTickCount() {
        return this.f١٣٠٦٢i;
    }

    protected void l(Canvas canvas, RectF rectF, Paint paint) {
        float height = rectF.height() / 2.0f;
        canvas.drawRoundRect(rectF, height, height, paint);
    }

    protected void m(Canvas canvas, RectF rectF, int i10, Paint paint, boolean z10) {
        float f10 = i10 / 2;
        canvas.drawRoundRect(rectF, f10, f10, paint);
    }

    protected void n(Canvas canvas, int i10, int i11, int i12, int i13, float f10, Paint paint, int i14, int i15) {
    }

    protected boolean o(int i10) {
        if (this.f١٣٠٦٧n == -1) {
            return false;
        }
        View k10 = k();
        float width = (((getWidth() - getPaddingLeft()) - getPaddingRight()) * ((this.f١٣٠٦٧n * 1.0f) / this.f١٣٠٦٢i)) - (k10.getWidth() / 2.0f);
        float width2 = k10.getWidth() + width;
        float f10 = i10;
        if (f10 < width || f10 > width2) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int i10 = this.f١٣٠٥٥b;
        int i11 = paddingTop + ((height - i10) / 2);
        this.f١٣٠٥٤a.setColor(this.f١٣٠٥٦c);
        float f10 = paddingLeft;
        float f11 = i11;
        float f12 = i10 + i11;
        this.f١٣٠٧٣t.set(f10, f11, width, f12);
        m(canvas, this.f١٣٠٧٣t, this.f١٣٠٥٥b, this.f١٣٠٥٤a, false);
        float maxThumbOffset = getMaxThumbOffset() / this.f١٣٠٦٢i;
        int i12 = (int) (this.f١٣٠٦٣j * maxThumbOffset);
        this.f١٣٠٥٤a.setColor(this.f١٣٠٥٧d);
        View k10 = k();
        if (k10 != null && k10.getVisibility() == 0) {
            if (!this.f١٣٠٧١r) {
                this.f١٣٠٦١h.g(i12);
            }
            this.f١٣٠٧٣t.set(f10, f11, (k10.getRight() + k10.getLeft()) / 2.0f, f12);
            m(canvas, this.f١٣٠٧٣t, this.f١٣٠٥٥b, this.f١٣٠٥٤a, true);
        } else {
            this.f١٣٠٧٣t.set(f10, f11, i12 + paddingLeft, f12);
            m(canvas, this.f١٣٠٧٣t, this.f١٣٠٥٥b, this.f١٣٠٥٤a, true);
        }
        n(canvas, this.f١٣٠٦٣j, this.f١٣٠٦٢i, paddingLeft, width, this.f١٣٠٧٣t.centerY(), this.f١٣٠٥٤a, this.f١٣٠٥٦c, this.f١٣٠٥٧d);
        if (this.f١٣٠٦٧n != -1 && k10 != null) {
            this.f١٣٠٥٤a.setColor(this.f١٣٠٥٨e);
            float paddingLeft2 = getPaddingLeft() + this.f١٣٠٦٠g.getLeftRightMargin() + ((int) (maxThumbOffset * this.f١٣٠٦٧n));
            this.f١٣٠٧٣t.set(paddingLeft2, k10.getTop(), k10.getWidth() + paddingLeft2, k10.getBottom());
            l(canvas, this.f١٣٠٧٣t, this.f١٣٠٥٤a);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        t(z10, i10, i11, i12, i13);
        View k10 = k();
        int paddingTop = getPaddingTop();
        int measuredHeight = k10.getMeasuredHeight();
        int measuredWidth = k10.getMeasuredWidth();
        int paddingLeft = getPaddingLeft() + this.f١٣٠٦٠g.getLeftRightMargin();
        int paddingBottom = paddingTop + (((((i13 - i11) - paddingTop) - getPaddingBottom()) - k10.getMeasuredHeight()) / 2);
        k10.layout(paddingLeft, paddingBottom, measuredWidth + paddingLeft, measuredHeight + paddingBottom);
        this.f١٣٠٦١h.e();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredHeight = getMeasuredHeight();
        int i12 = this.f١٣٠٥٥b;
        if (measuredHeight < i12) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(i12 + getPaddingTop() + getPaddingBottom(), 1073741824));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int x10 = (int) motionEvent.getX();
            this.f١٣٠٦٨o = x10;
            this.f١٣٠٦٩p = x10;
            boolean p10 = p(motionEvent.getX(), motionEvent.getY());
            this.f١٣٠٧٠q = p10;
            if (p10) {
                this.f١٣٠٦٠g.setPress(true);
            } else if (this.f١٣٠٦٦m) {
                removeCallbacks(this.f١٣٠٧٤u);
                postOnAnimationDelayed(this.f١٣٠٧٤u, 300L);
            }
        } else if (action == 2) {
            int x11 = (int) motionEvent.getX();
            int i10 = x11 - this.f١٣٠٦٩p;
            this.f١٣٠٦٩p = x11;
            if (!this.f١٣٠٧١r && this.f١٣٠٧٠q && Math.abs(x11 - this.f١٣٠٦٨o) > this.f١٣٠٧٢s) {
                removeCallbacks(this.f١٣٠٧٤u);
                this.f١٣٠٧١r = true;
                i10 = i10 > 0 ? i10 - this.f١٣٠٧٢s : i10 + this.f١٣٠٧٢s;
            }
            if (this.f١٣٠٧١r) {
                k.e(this, true);
                int maxThumbOffset = getMaxThumbOffset();
                if (this.f١٣٠٥٩f) {
                    j(x11, maxThumbOffset);
                } else {
                    l lVar = this.f١٣٠٦١h;
                    lVar.g(g.c(lVar.c() + i10, 0, maxThumbOffset));
                    i(maxThumbOffset);
                }
                invalidate();
            }
        } else if (action != 1 && action != 3) {
            removeCallbacks(this.f١٣٠٧٤u);
        } else {
            removeCallbacks(this.f١٣٠٧٤u);
            this.f١٣٠٦٩p = -1;
            k.e(this, false);
            if (this.f١٣٠٧١r) {
                this.f١٣٠٧١r = false;
            }
            if (this.f١٣٠٧٠q) {
                this.f١٣٠٧٠q = false;
                this.f١٣٠٦٠g.setPress(false);
            } else if (action == 1) {
                int x12 = (int) motionEvent.getX();
                boolean o10 = o(x12);
                if (Math.abs(x12 - this.f١٣٠٦٨o) < this.f١٣٠٧٢s && (this.f١٣٠٦٥l || o10)) {
                    if (o10) {
                        u(this.f١٣٠٦٧n);
                    } else {
                        j(x12, getMaxThumbOffset());
                    }
                    invalidate();
                }
            }
        }
        return true;
    }

    protected boolean q(View view, float f10, float f11) {
        if (view.getVisibility() == 0 && view.getLeft() <= f10 && view.getRight() >= f10 && view.getTop() <= f11 && view.getBottom() >= f11) {
            return true;
        }
        return false;
    }

    protected FrameLayout.LayoutParams r() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    protected b s(Context context, int i10, int i11) {
        return new DefaultThumbView(context, i10, i11);
    }

    public void setBarHeight(int i10) {
        if (this.f١٣٠٥٥b != i10) {
            this.f١٣٠٥٥b = i10;
            requestLayout();
        }
    }

    public void setBarNormalColor(int i10) {
        if (this.f١٣٠٥٦c != i10) {
            this.f١٣٠٥٦c = i10;
            invalidate();
        }
    }

    public void setBarProgressColor(int i10) {
        if (this.f١٣٠٥٧d != i10) {
            this.f١٣٠٥٧d = i10;
            invalidate();
        }
    }

    public void setCallback(a aVar) {
    }

    public void setClickToChangeProgress(boolean z10) {
        this.f١٣٠٦٥l = z10;
    }

    public void setConstraintThumbInMoving(boolean z10) {
        this.f١٣٠٥٩f = z10;
    }

    public void setCurrentProgress(int i10) {
        if (!this.f١٣٠٧١r) {
            int c10 = g.c(i10, 0, this.f١٣٠٦٢i);
            if (this.f١٣٠٦٣j != c10 || !this.f١٣٠٦٤k) {
                this.f١٣٠٦٤k = true;
                u(c10);
                invalidate();
            }
        }
    }

    public void setLongTouchToChangeProgress(boolean z10) {
        this.f١٣٠٦٦m = z10;
    }

    public void setRecordProgress(int i10) {
        if (i10 != this.f١٣٠٦٧n) {
            if (i10 != -1) {
                i10 = g.c(i10, 0, this.f١٣٠٦٢i);
            }
            this.f١٣٠٦٧n = i10;
            invalidate();
        }
    }

    public void setRecordProgressColor(int i10) {
        if (this.f١٣٠٥٨e != i10) {
            this.f١٣٠٥٨e = i10;
            invalidate();
        }
    }

    public void setThumbSkin(f fVar) {
        dc.d.g(k(), fVar);
    }

    public void setTickCount(int i10) {
        if (this.f١٣٠٦٢i != i10) {
            this.f١٣٠٦٢i = i10;
            setCurrentProgress(g.c(this.f١٣٠٦٣j, 0, i10));
            this.f١٣٠٦٠g.a(this.f١٣٠٦٣j, this.f١٣٠٦٢i);
            invalidate();
        }
    }

    protected void t(boolean z10, int i10, int i11, int i12, int i13) {
    }

    public QMUISlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUISliderStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QMUISlider(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٠٥٩f = true;
        this.f١٣٠٦٣j = 0;
        this.f١٣٠٦٤k = false;
        this.f١٣٠٦٥l = false;
        this.f١٣٠٦٦m = false;
        this.f١٣٠٦٧n = -1;
        this.f١٣٠٦٨o = 0;
        this.f١٣٠٦٩p = 0;
        this.f١٣٠٧٠q = false;
        this.f١٣٠٧١r = false;
        this.f١٣٠٧٣t = new RectF();
        this.f١٣٠٧٤u = new c();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUISlider, i10, 0);
        this.f١٣٠٥٥b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUISlider_qmui_slider_bar_height, e.a(context, 2));
        this.f١٣٠٥٦c = obtainStyledAttributes.getColor(R.styleable.QMUISlider_qmui_slider_bar_normal_color, -1);
        this.f١٣٠٥٧d = obtainStyledAttributes.getColor(R.styleable.QMUISlider_qmui_slider_bar_progress_color, -16776961);
        this.f١٣٠٥٨e = obtainStyledAttributes.getColor(R.styleable.QMUISlider_qmui_slider_bar_record_progress_color, -7829368);
        this.f١٣٠٦٢i = obtainStyledAttributes.getInt(R.styleable.QMUISlider_qmui_slider_bar_tick_count, 100);
        this.f١٣٠٥٩f = obtainStyledAttributes.getBoolean(R.styleable.QMUISlider_qmui_slider_bar_constraint_thumb_in_moving, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUISlider_qmui_slider_bar_thumb_size, e.a(getContext(), 24));
        String string = obtainStyledAttributes.getString(R.styleable.QMUISlider_qmui_slider_bar_thumb_style_attr);
        int identifier = string != null ? getResources().getIdentifier(string, "attr", context.getPackageName()) : 0;
        if (!obtainStyledAttributes.getBoolean(R.styleable.QMUISlider_qmui_slider_bar_use_clip_children_by_developer, false)) {
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.QMUISlider_qmui_slider_bar_padding_hor_for_thumb_shadow, 0);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.QMUISlider_qmui_slider_bar_padding_ver_for_thumb_shadow, 0);
            setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
        }
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f١٣٠٥٤a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f١٣٠٥٤a.setAntiAlias(true);
        this.f١٣٠٧٢s = e.a(context, 2);
        setWillNotDraw(false);
        setClipToPadding(false);
        setClipChildren(false);
        b s10 = s(context, dimensionPixelSize, identifier);
        if (s10 instanceof View) {
            this.f١٣٠٦٠g = s10;
            View view = (View) s10;
            this.f١٣٠٦١h = new l(view);
            addView(view, r());
            s10.a(this.f١٣٠٦٣j, this.f١٣٠٦٢i);
            return;
        }
        throw new IllegalArgumentException("thumbView must be a instance of View");
    }
}
