package com.qiahao.nextvideo.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
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
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class HiloTabLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener {
    private float A;
    private int B;
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
    private Context a;
    private String[] b;
    private LinearLayout c;
    private int d;
    private int e;
    private int f;
    private Rect g;
    private GradientDrawable h;
    private GradientDrawable i;
    private Paint j;
    private float k;
    private boolean l;
    private float m;
    private int n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private long u;
    private boolean v;
    private boolean w;
    private int x;
    private float y;
    private float z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (HiloTabLayout.this.d != intValue) {
                HiloTabLayout.this.setCurrentTab(intValue);
                if (HiloTabLayout.this.P != null) {
                    HiloTabLayout.this.P.onTabSelect(intValue);
                    return;
                }
                return;
            }
            if (HiloTabLayout.this.P != null) {
                HiloTabLayout.this.P.onTabReselect(intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class b {
        public float a;
        public float b;

        b() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    class c implements TypeEvaluator {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b evaluate(float f, b bVar, b bVar2) {
            float f2 = bVar.a;
            float f3 = f2 + ((bVar2.a - f2) * f);
            float f4 = bVar.b;
            float f5 = f4 + (f * (bVar2.b - f4));
            b bVar3 = new b();
            bVar3.a = f3;
            bVar3.b = f5;
            return bVar3;
        }
    }

    public HiloTabLayout(Context context) {
        this(context, null, 0);
    }

    private void c(int i, View view) {
        LinearLayout.LayoutParams layoutParams;
        ((TextView) view.findViewById(R.id.tv_tab_title)).setText(this.b[i]);
        view.setOnClickListener(new a());
        if (this.l) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        if (this.m > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.m, -1);
        }
        this.c.addView(view, i, layoutParams);
    }

    private void d() {
        View childAt = this.c.getChildAt(this.d);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        Rect rect = this.g;
        rect.left = (int) left;
        rect.right = (int) right;
        if (!this.v) {
            int i = this.d;
            if (i == 0) {
                float[] fArr = this.L;
                float f = this.p;
                fArr[0] = f;
                fArr[1] = f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = f;
                fArr[7] = f;
                return;
            }
            if (i == this.f - 1) {
                float[] fArr2 = this.L;
                fArr2[0] = 0.0f;
                fArr2[1] = 0.0f;
                float f2 = this.p;
                fArr2[2] = f2;
                fArr2[3] = f2;
                fArr2[4] = f2;
                fArr2[5] = f2;
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
        float f3 = this.p;
        fArr4[0] = f3;
        fArr4[1] = f3;
        fArr4[2] = f3;
        fArr4[3] = f3;
        fArr4[4] = f3;
        fArr4[5] = f3;
        fArr4[6] = f3;
        fArr4[7] = f3;
    }

    private void e() {
        long j;
        View childAt = this.c.getChildAt(this.d);
        this.Q.a = childAt.getLeft();
        this.Q.b = childAt.getRight();
        View childAt2 = this.c.getChildAt(this.e);
        this.R.a = childAt2.getLeft();
        this.R.b = childAt2.getRight();
        b bVar = this.R;
        float f = bVar.a;
        b bVar2 = this.Q;
        if (f == bVar2.a && bVar.b == bVar2.b) {
            invalidate();
            return;
        }
        this.J.setObjectValues(bVar, bVar2);
        if (this.w) {
            this.J.setInterpolator(this.K);
        }
        if (this.u < 0) {
            if (this.w) {
                j = 500;
            } else {
                j = 250;
            }
            this.u = j;
        }
        this.J.setDuration(this.u);
        this.J.start();
    }

    private void h(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SegmentTabLayout);
        this.n = obtainStyledAttributes.getColor(9, Color.parseColor("#222831"));
        this.o = obtainStyledAttributes.getDimension(11, -1.0f);
        this.p = obtainStyledAttributes.getDimension(10, -1.0f);
        float f = 0.0f;
        this.q = obtainStyledAttributes.getDimension(13, f(0.0f));
        this.r = obtainStyledAttributes.getDimension(15, 0.0f);
        this.s = obtainStyledAttributes.getDimension(14, f(0.0f));
        this.t = obtainStyledAttributes.getDimension(12, 0.0f);
        this.v = obtainStyledAttributes.getBoolean(7, false);
        this.w = obtainStyledAttributes.getBoolean(8, true);
        this.u = obtainStyledAttributes.getInt(6, -1);
        this.x = obtainStyledAttributes.getColor(3, this.n);
        this.y = obtainStyledAttributes.getDimension(5, f(1.0f));
        this.z = obtainStyledAttributes.getDimension(4, 0.0f);
        this.A = obtainStyledAttributes.getDimension(23, j(13.0f));
        this.B = obtainStyledAttributes.getColor(21, Color.parseColor("#ffffff"));
        this.C = obtainStyledAttributes.getColor(22, this.n);
        this.D = obtainStyledAttributes.getInt(20, 0);
        this.E = obtainStyledAttributes.getBoolean(19, false);
        this.l = obtainStyledAttributes.getBoolean(17, true);
        float dimension = obtainStyledAttributes.getDimension(18, f(-1.0f));
        this.m = dimension;
        if (!this.l && dimension <= 0.0f) {
            f = 10.0f;
        }
        this.k = obtainStyledAttributes.getDimension(16, f(f));
        this.F = obtainStyledAttributes.getColor(0, 0);
        this.G = obtainStyledAttributes.getColor(1, this.n);
        this.H = obtainStyledAttributes.getDimension(2, f(1.0f));
        obtainStyledAttributes.recycle();
    }

    private void k(int i) {
        boolean z;
        int i2;
        for (int i3 = 0; i3 < this.f; i3++) {
            View childAt = this.c.getChildAt(i3);
            if (i3 == i) {
                z = true;
            } else {
                z = false;
            }
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (z) {
                i2 = this.B;
            } else {
                i2 = this.C;
            }
            textView.setTextColor(i2);
            if (this.D == 1) {
                if (z) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                } else {
                    textView.setTypeface(Typeface.defaultFromStyle(0));
                }
            }
            textView.invalidate();
        }
    }

    private void l() {
        int i;
        for (int i2 = 0; i2 < this.f; i2++) {
            View childAt = this.c.getChildAt(i2);
            float f = this.k;
            childAt.setPadding((int) f, 0, (int) f, 0);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (i2 == this.d) {
                i = this.B;
            } else {
                i = this.C;
            }
            textView.setTextColor(i);
            textView.setTextSize(0, this.A);
            if (this.E) {
                textView.setText(textView.getText().toString().toUpperCase());
            }
            int i3 = this.D;
            if (i3 == 2) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
            } else if (i3 == 0) {
                textView.setTypeface(Typeface.defaultFromStyle(0));
            }
            textView.invalidate();
        }
    }

    protected int f(float f) {
        return (int) ((f * this.a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void g() {
        this.c.removeAllViews();
        this.f = this.b.length;
        for (int i = 0; i < this.f; i++) {
            View inflate = View.inflate(this.a, R.layout.layout_tab_segment, null);
            inflate.setTag(Integer.valueOf(i));
            c(i, inflate);
        }
        l();
    }

    public int getCurrentTab() {
        return this.d;
    }

    public int getDividerColor() {
        return this.x;
    }

    public float getDividerPadding() {
        return this.z;
    }

    public float getDividerWidth() {
        return this.y;
    }

    public long getIndicatorAnimDuration() {
        return this.u;
    }

    public int getIndicatorColor() {
        return this.n;
    }

    public float getIndicatorCornerRadius() {
        return this.p;
    }

    public float getIndicatorHeight() {
        return this.o;
    }

    public float getIndicatorMarginBottom() {
        return this.t;
    }

    public float getIndicatorMarginLeft() {
        return this.q;
    }

    public float getIndicatorMarginRight() {
        return this.s;
    }

    public float getIndicatorMarginTop() {
        return this.r;
    }

    public int getTabCount() {
        return this.f;
    }

    public float getTabPadding() {
        return this.k;
    }

    public float getTabWidth() {
        return this.m;
    }

    public int getTextBold() {
        return this.D;
    }

    public int getTextSelectColor() {
        return this.B;
    }

    public int getTextUnselectColor() {
        return this.C;
    }

    public float getTextsize() {
        return this.A;
    }

    public void i(float f, float f2, float f3, float f4) {
        this.q = f(f);
        this.r = f(f2);
        this.s = f(f3);
        this.t = f(f4);
        invalidate();
    }

    protected int j(float f) {
        return (int) ((f * this.a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        b bVar = (b) valueAnimator.getAnimatedValue();
        Rect rect = this.g;
        rect.left = (int) bVar.a;
        rect.right = (int) bVar.b;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            if (this.o < 0.0f) {
                this.o = (height - this.r) - this.t;
            }
            float f = this.p;
            if (f < 0.0f || f > this.o / 2.0f) {
                this.p = this.o / 2.0f;
            }
            this.i.setColor(this.F);
            this.i.setStroke((int) this.H, this.G);
            this.i.setCornerRadius(this.p);
            this.i.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.i.draw(canvas);
            if (!this.v) {
                float f2 = this.y;
                if (f2 > 0.0f) {
                    this.j.setStrokeWidth(f2);
                    this.j.setColor(this.x);
                    for (int i = 0; i < this.f - 1; i++) {
                        View childAt = this.c.getChildAt(i);
                        canvas.drawLine(childAt.getRight() + paddingLeft, this.z, childAt.getRight() + paddingLeft, height - this.z, this.j);
                    }
                }
            }
            if (this.v) {
                if (this.M) {
                    this.M = false;
                    d();
                }
            } else {
                d();
            }
            this.h.setColor(this.n);
            GradientDrawable gradientDrawable = this.h;
            int i2 = ((int) this.q) + paddingLeft + this.g.left;
            float f3 = this.r;
            gradientDrawable.setBounds(i2, (int) f3, (int) ((paddingLeft + r3.right) - this.s), (int) (f3 + this.o));
            this.h.setCornerRadii(this.L);
            this.h.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.d = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.d != 0 && this.c.getChildCount() > 0) {
                k(this.d);
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.d);
        return bundle;
    }

    public void setCurrentTab(int i) {
        this.e = this.d;
        this.d = i;
        k(i);
        if (this.v) {
            e();
        } else {
            invalidate();
        }
    }

    public void setDividerColor(int i) {
        this.x = i;
        invalidate();
    }

    public void setDividerPadding(float f) {
        this.z = f(f);
        invalidate();
    }

    public void setDividerWidth(float f) {
        this.y = f(f);
        invalidate();
    }

    public void setIndicatorAnimDuration(long j) {
        this.u = j;
    }

    public void setIndicatorAnimEnable(boolean z) {
        this.v = z;
    }

    public void setIndicatorBounceEnable(boolean z) {
        this.w = z;
    }

    public void setIndicatorColor(int i) {
        this.n = i;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f) {
        this.p = f(f);
        invalidate();
    }

    public void setIndicatorHeight(float f) {
        this.o = f(f);
        invalidate();
    }

    public void setOnTabSelectListener(o6.b bVar) {
        this.P = bVar;
    }

    public void setTabData(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            this.b = strArr;
            g();
            return;
        }
        throw new IllegalStateException("Titles can not be NULL or EMPTY !");
    }

    public void setTabPadding(float f) {
        this.k = f(f);
        l();
    }

    public void setTabSpaceEqual(boolean z) {
        this.l = z;
        l();
    }

    public void setTabWidth(float f) {
        this.m = f(f);
        l();
    }

    public void setTextAllCaps(boolean z) {
        this.E = z;
        l();
    }

    public void setTextBold(int i) {
        this.D = i;
        l();
    }

    public void setTextSelectColor(int i) {
        this.B = i;
        l();
    }

    public void setTextUnselectColor(int i) {
        this.C = i;
        l();
    }

    public void setTextsize(float f) {
        this.A = j(f);
        l();
    }

    public HiloTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HiloTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new Rect();
        this.h = new GradientDrawable();
        this.i = new GradientDrawable();
        this.j = new Paint(1);
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
        this.a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.c = linearLayout;
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
