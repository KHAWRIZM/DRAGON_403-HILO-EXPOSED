package com.flyco.tablayout;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SegmentTabLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener {
    private float A;

    /* renamed from: B, reason: collision with root package name */
    private int f٧٨٧١B;
    private int C;
    private int D;
    private boolean E;
    private int F;
    private int G;
    private float H;
    private int I;
    private ValueAnimator J;
    private OvershootInterpolator K;
    private float[] L;
    private boolean M;
    private Paint N;
    private SparseArray O;
    private o6.b P;
    private b Q;
    private b R;

    /* renamed from: a, reason: collision with root package name */
    private Context f٧٨٧٢a;

    /* renamed from: b, reason: collision with root package name */
    private String[] f٧٨٧٣b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f٧٨٧٤c;

    /* renamed from: d, reason: collision with root package name */
    private int f٧٨٧٥d;

    /* renamed from: e, reason: collision with root package name */
    private int f٧٨٧٦e;

    /* renamed from: f, reason: collision with root package name */
    private int f٧٨٧٧f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f٧٨٧٨g;

    /* renamed from: h, reason: collision with root package name */
    private GradientDrawable f٧٨٧٩h;

    /* renamed from: i, reason: collision with root package name */
    private GradientDrawable f٧٨٨٠i;

    /* renamed from: j, reason: collision with root package name */
    private Paint f٧٨٨١j;

    /* renamed from: k, reason: collision with root package name */
    private float f٧٨٨٢k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٧٨٨٣l;

    /* renamed from: m, reason: collision with root package name */
    private float f٧٨٨٤m;

    /* renamed from: n, reason: collision with root package name */
    private int f٧٨٨٥n;

    /* renamed from: o, reason: collision with root package name */
    private float f٧٨٨٦o;

    /* renamed from: p, reason: collision with root package name */
    private float f٧٨٨٧p;

    /* renamed from: q, reason: collision with root package name */
    private float f٧٨٨٨q;

    /* renamed from: r, reason: collision with root package name */
    private float f٧٨٨٩r;

    /* renamed from: s, reason: collision with root package name */
    private float f٧٨٩٠s;

    /* renamed from: t, reason: collision with root package name */
    private float f٧٨٩١t;

    /* renamed from: u, reason: collision with root package name */
    private long f٧٨٩٢u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f٧٨٩٣v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f٧٨٩٤w;

    /* renamed from: x, reason: collision with root package name */
    private int f٧٨٩٥x;

    /* renamed from: y, reason: collision with root package name */
    private float f٧٨٩٦y;

    /* renamed from: z, reason: collision with root package name */
    private float f٧٨٩٧z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (SegmentTabLayout.this.f٧٨٧٥d != intValue) {
                SegmentTabLayout.this.setCurrentTab(intValue);
                if (SegmentTabLayout.this.P != null) {
                    SegmentTabLayout.this.P.onTabSelect(intValue);
                    return;
                }
                return;
            }
            if (SegmentTabLayout.this.P != null) {
                SegmentTabLayout.this.P.onTabReselect(intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public float f٧٨٩٩a;

        /* renamed from: b, reason: collision with root package name */
        public float f٧٩٠٠b;

        b() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c implements TypeEvaluator {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b evaluate(float f10, b bVar, b bVar2) {
            float f11 = bVar.f٧٨٩٩a;
            float f12 = f11 + ((bVar2.f٧٨٩٩a - f11) * f10);
            float f13 = bVar.f٧٩٠٠b;
            float f14 = f13 + (f10 * (bVar2.f٧٩٠٠b - f13));
            b bVar3 = new b();
            bVar3.f٧٨٩٩a = f12;
            bVar3.f٧٩٠٠b = f14;
            return bVar3;
        }
    }

    public SegmentTabLayout(Context context) {
        this(context, null, 0);
    }

    private void c(int i10, View view) {
        LinearLayout.LayoutParams layoutParams;
        ((TextView) view.findViewById(R.id.tv_tab_title)).setText(this.f٧٨٧٣b[i10]);
        view.setOnClickListener(new a());
        if (this.f٧٨٨٣l) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        if (this.f٧٨٨٤m > DownloadProgress.UNKNOWN_PROGRESS) {
            layoutParams = new LinearLayout.LayoutParams((int) this.f٧٨٨٤m, -1);
        }
        this.f٧٨٧٤c.addView(view, i10, layoutParams);
    }

    private void d() {
        View childAt = this.f٧٨٧٤c.getChildAt(this.f٧٨٧٥d);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        Rect rect = this.f٧٨٧٨g;
        rect.left = (int) left;
        rect.right = (int) right;
        if (!this.f٧٨٩٣v) {
            int i10 = this.f٧٨٧٥d;
            if (i10 == 0) {
                float[] fArr = this.L;
                float f10 = this.f٧٨٨٧p;
                fArr[0] = f10;
                fArr[1] = f10;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = f10;
                fArr[7] = f10;
                return;
            }
            if (i10 == this.f٧٨٧٧f - 1) {
                float[] fArr2 = this.L;
                fArr2[0] = 0.0f;
                fArr2[1] = 0.0f;
                float f11 = this.f٧٨٨٧p;
                fArr2[2] = f11;
                fArr2[3] = f11;
                fArr2[4] = f11;
                fArr2[5] = f11;
                fArr2[6] = 0.0f;
                fArr2[7] = 0.0f;
                return;
            }
            float[] fArr3 = this.L;
            fArr3[0] = 0.0f;
            fArr3[1] = 0.0f;
            fArr3[2] = 0.0f;
            fArr3[3] = 0.0f;
            fArr3[4] = 0.0f;
            fArr3[5] = 0.0f;
            fArr3[6] = 0.0f;
            fArr3[7] = 0.0f;
            return;
        }
        float[] fArr4 = this.L;
        float f12 = this.f٧٨٨٧p;
        fArr4[0] = f12;
        fArr4[1] = f12;
        fArr4[2] = f12;
        fArr4[3] = f12;
        fArr4[4] = f12;
        fArr4[5] = f12;
        fArr4[6] = f12;
        fArr4[7] = f12;
    }

    private void e() {
        long j10;
        View childAt = this.f٧٨٧٤c.getChildAt(this.f٧٨٧٥d);
        this.Q.f٧٨٩٩a = childAt.getLeft();
        this.Q.f٧٩٠٠b = childAt.getRight();
        View childAt2 = this.f٧٨٧٤c.getChildAt(this.f٧٨٧٦e);
        this.R.f٧٨٩٩a = childAt2.getLeft();
        this.R.f٧٩٠٠b = childAt2.getRight();
        b bVar = this.R;
        float f10 = bVar.f٧٨٩٩a;
        b bVar2 = this.Q;
        if (f10 == bVar2.f٧٨٩٩a && bVar.f٧٩٠٠b == bVar2.f٧٩٠٠b) {
            invalidate();
            return;
        }
        this.J.setObjectValues(bVar, bVar2);
        if (this.f٧٨٩٤w) {
            this.J.setInterpolator(this.K);
        }
        if (this.f٧٨٩٢u < 0) {
            if (this.f٧٨٩٤w) {
                j10 = 500;
            } else {
                j10 = 250;
            }
            this.f٧٨٩٢u = j10;
        }
        this.J.setDuration(this.f٧٨٩٢u);
        this.J.start();
    }

    private void h(Context context, AttributeSet attributeSet) {
        int f10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SegmentTabLayout);
        this.f٧٨٨٥n = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_indicator_color, Color.parseColor("#222831"));
        this.f٧٨٨٦o = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_height, -1.0f);
        this.f٧٨٨٧p = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_corner_radius, -1.0f);
        this.f٧٨٨٨q = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_left, f(DownloadProgress.UNKNOWN_PROGRESS));
        this.f٧٨٨٩r = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_top, DownloadProgress.UNKNOWN_PROGRESS);
        this.f٧٨٩٠s = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_right, f(DownloadProgress.UNKNOWN_PROGRESS));
        this.f٧٨٩١t = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_bottom, DownloadProgress.UNKNOWN_PROGRESS);
        this.f٧٨٩٣v = obtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_indicator_anim_enable, false);
        this.f٧٨٩٤w = obtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_indicator_bounce_enable, true);
        this.f٧٨٩٢u = obtainStyledAttributes.getInt(R.styleable.SegmentTabLayout_tl_indicator_anim_duration, -1);
        this.f٧٨٩٥x = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_divider_color, this.f٧٨٨٥n);
        this.f٧٨٩٦y = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_divider_width, f(1.0f));
        this.f٧٨٩٧z = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_divider_padding, DownloadProgress.UNKNOWN_PROGRESS);
        this.A = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_textsize, i(13.0f));
        this.f٧٨٧١B = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        this.C = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_textUnselectColor, this.f٧٨٨٥n);
        this.D = obtainStyledAttributes.getInt(R.styleable.SegmentTabLayout_tl_textBold, 0);
        this.E = obtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_textAllCaps, false);
        this.f٧٨٨٣l = obtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_tab_space_equal, true);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_tab_width, f(-1.0f));
        this.f٧٨٨٤m = dimension;
        int i10 = R.styleable.SegmentTabLayout_tl_tab_padding;
        if (!this.f٧٨٨٣l && dimension <= DownloadProgress.UNKNOWN_PROGRESS) {
            f10 = f(10.0f);
        } else {
            f10 = f(DownloadProgress.UNKNOWN_PROGRESS);
        }
        this.f٧٨٨٢k = obtainStyledAttributes.getDimension(i10, f10);
        this.F = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_bar_color, 0);
        this.G = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_bar_stroke_color, this.f٧٨٨٥n);
        this.H = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_bar_stroke_width, f(1.0f));
        obtainStyledAttributes.recycle();
    }

    private void j(int i10) {
        boolean z10;
        int i11;
        for (int i12 = 0; i12 < this.f٧٨٧٧f; i12++) {
            View childAt = this.f٧٨٧٤c.getChildAt(i12);
            if (i12 == i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (z10) {
                i11 = this.f٧٨٧١B;
            } else {
                i11 = this.C;
            }
            textView.setTextColor(i11);
            if (this.D == 1) {
                textView.getPaint().setFakeBoldText(z10);
            }
        }
    }

    private void k() {
        int i10;
        for (int i11 = 0; i11 < this.f٧٨٧٧f; i11++) {
            View childAt = this.f٧٨٧٤c.getChildAt(i11);
            float f10 = this.f٧٨٨٢k;
            childAt.setPadding((int) f10, 0, (int) f10, 0);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (i11 == this.f٧٨٧٥d) {
                i10 = this.f٧٨٧١B;
            } else {
                i10 = this.C;
            }
            textView.setTextColor(i10);
            textView.setTextSize(0, this.A);
            if (this.E) {
                textView.setText(textView.getText().toString().toUpperCase());
            }
            int i12 = this.D;
            if (i12 == 2) {
                textView.getPaint().setFakeBoldText(true);
            } else if (i12 == 0) {
                textView.getPaint().setFakeBoldText(false);
            }
        }
    }

    protected int f(float f10) {
        return (int) ((f10 * this.f٧٨٧٢a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void g() {
        this.f٧٨٧٤c.removeAllViews();
        this.f٧٨٧٧f = this.f٧٨٧٣b.length;
        for (int i10 = 0; i10 < this.f٧٨٧٧f; i10++) {
            View inflate = View.inflate(this.f٧٨٧٢a, R.layout.layout_tab_segment, null);
            inflate.setTag(Integer.valueOf(i10));
            c(i10, inflate);
        }
        k();
    }

    public int getCurrentTab() {
        return this.f٧٨٧٥d;
    }

    public int getDividerColor() {
        return this.f٧٨٩٥x;
    }

    public float getDividerPadding() {
        return this.f٧٨٩٧z;
    }

    public float getDividerWidth() {
        return this.f٧٨٩٦y;
    }

    public long getIndicatorAnimDuration() {
        return this.f٧٨٩٢u;
    }

    public int getIndicatorColor() {
        return this.f٧٨٨٥n;
    }

    public float getIndicatorCornerRadius() {
        return this.f٧٨٨٧p;
    }

    public float getIndicatorHeight() {
        return this.f٧٨٨٦o;
    }

    public float getIndicatorMarginBottom() {
        return this.f٧٨٩١t;
    }

    public float getIndicatorMarginLeft() {
        return this.f٧٨٨٨q;
    }

    public float getIndicatorMarginRight() {
        return this.f٧٨٩٠s;
    }

    public float getIndicatorMarginTop() {
        return this.f٧٨٨٩r;
    }

    public int getTabCount() {
        return this.f٧٨٧٧f;
    }

    public float getTabPadding() {
        return this.f٧٨٨٢k;
    }

    public float getTabWidth() {
        return this.f٧٨٨٤m;
    }

    public int getTextBold() {
        return this.D;
    }

    public int getTextSelectColor() {
        return this.f٧٨٧١B;
    }

    public int getTextUnselectColor() {
        return this.C;
    }

    public float getTextsize() {
        return this.A;
    }

    protected int i(float f10) {
        return (int) ((f10 * this.f٧٨٧٢a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        b bVar = (b) valueAnimator.getAnimatedValue();
        Rect rect = this.f٧٨٧٨g;
        rect.left = (int) bVar.f٧٨٩٩a;
        rect.right = (int) bVar.f٧٩٠٠b;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f٧٨٧٧f > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            if (this.f٧٨٨٦o < DownloadProgress.UNKNOWN_PROGRESS) {
                this.f٧٨٨٦o = (height - this.f٧٨٨٩r) - this.f٧٨٩١t;
            }
            float f10 = this.f٧٨٨٧p;
            if (f10 < DownloadProgress.UNKNOWN_PROGRESS || f10 > this.f٧٨٨٦o / 2.0f) {
                this.f٧٨٨٧p = this.f٧٨٨٦o / 2.0f;
            }
            this.f٧٨٨٠i.setColor(this.F);
            this.f٧٨٨٠i.setStroke((int) this.H, this.G);
            this.f٧٨٨٠i.setCornerRadius(this.f٧٨٨٧p);
            this.f٧٨٨٠i.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.f٧٨٨٠i.draw(canvas);
            if (!this.f٧٨٩٣v) {
                float f11 = this.f٧٨٩٦y;
                if (f11 > DownloadProgress.UNKNOWN_PROGRESS) {
                    this.f٧٨٨١j.setStrokeWidth(f11);
                    this.f٧٨٨١j.setColor(this.f٧٨٩٥x);
                    for (int i10 = 0; i10 < this.f٧٨٧٧f - 1; i10++) {
                        View childAt = this.f٧٨٧٤c.getChildAt(i10);
                        canvas.drawLine(childAt.getRight() + paddingLeft, this.f٧٨٩٧z, childAt.getRight() + paddingLeft, height - this.f٧٨٩٧z, this.f٧٨٨١j);
                    }
                }
            }
            if (this.f٧٨٩٣v) {
                if (this.M) {
                    this.M = false;
                    d();
                }
            } else {
                d();
            }
            this.f٧٨٧٩h.setColor(this.f٧٨٨٥n);
            GradientDrawable gradientDrawable = this.f٧٨٧٩h;
            int i11 = ((int) this.f٧٨٨٨q) + paddingLeft + this.f٧٨٧٨g.left;
            float f12 = this.f٧٨٨٩r;
            gradientDrawable.setBounds(i11, (int) f12, (int) ((paddingLeft + r3.right) - this.f٧٨٩٠s), (int) (f12 + this.f٧٨٨٦o));
            this.f٧٨٧٩h.setCornerRadii(this.L);
            this.f٧٨٧٩h.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f٧٨٧٥d = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.f٧٨٧٥d != 0 && this.f٧٨٧٤c.getChildCount() > 0) {
                j(this.f٧٨٧٥d);
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.f٧٨٧٥d);
        return bundle;
    }

    public void setCurrentTab(int i10) {
        this.f٧٨٧٦e = this.f٧٨٧٥d;
        this.f٧٨٧٥d = i10;
        j(i10);
        if (this.f٧٨٩٣v) {
            e();
        } else {
            invalidate();
        }
    }

    public void setDividerColor(int i10) {
        this.f٧٨٩٥x = i10;
        invalidate();
    }

    public void setDividerPadding(float f10) {
        this.f٧٨٩٧z = f(f10);
        invalidate();
    }

    public void setDividerWidth(float f10) {
        this.f٧٨٩٦y = f(f10);
        invalidate();
    }

    public void setIndicatorAnimDuration(long j10) {
        this.f٧٨٩٢u = j10;
    }

    public void setIndicatorAnimEnable(boolean z10) {
        this.f٧٨٩٣v = z10;
    }

    public void setIndicatorBounceEnable(boolean z10) {
        this.f٧٨٩٤w = z10;
    }

    public void setIndicatorColor(int i10) {
        this.f٧٨٨٥n = i10;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f10) {
        this.f٧٨٨٧p = f(f10);
        invalidate();
    }

    public void setIndicatorHeight(float f10) {
        this.f٧٨٨٦o = f(f10);
        invalidate();
    }

    public void setOnTabSelectListener(o6.b bVar) {
        this.P = bVar;
    }

    public void setTabData(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            this.f٧٨٧٣b = strArr;
            g();
            return;
        }
        throw new IllegalStateException("Titles can not be NULL or EMPTY !");
    }

    public void setTabPadding(float f10) {
        this.f٧٨٨٢k = f(f10);
        k();
    }

    public void setTabSpaceEqual(boolean z10) {
        this.f٧٨٨٣l = z10;
        k();
    }

    public void setTabWidth(float f10) {
        this.f٧٨٨٤m = f(f10);
        k();
    }

    public void setTextAllCaps(boolean z10) {
        this.E = z10;
        k();
    }

    public void setTextBold(int i10) {
        this.D = i10;
        k();
    }

    public void setTextSelectColor(int i10) {
        this.f٧٨٧١B = i10;
        k();
    }

    public void setTextUnselectColor(int i10) {
        this.C = i10;
        k();
    }

    public void setTextsize(float f10) {
        this.A = i(f10);
        k();
    }

    public SegmentTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SegmentTabLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٧٨٧٨g = new Rect();
        this.f٧٨٧٩h = new GradientDrawable();
        this.f٧٨٨٠i = new GradientDrawable();
        this.f٧٨٨١j = new Paint(1);
        this.K = new OvershootInterpolator(0.8f);
        this.L = new float[8];
        this.M = true;
        this.N = new Paint(1);
        this.O = new SparseArray();
        this.Q = new b();
        this.R = new b();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f٧٨٧٢a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f٧٨٧٤c = linearLayout;
        addView(linearLayout);
        h(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.layout_height});
            this.I = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new c(), this.R, this.Q);
        this.J = ofObject;
        ofObject.addUpdateListener(this);
    }
}
