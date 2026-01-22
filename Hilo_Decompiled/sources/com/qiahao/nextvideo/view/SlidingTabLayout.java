package com.qiahao.nextvideo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.qiahao.nextvideo.R;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class SlidingTabLayout extends HorizontalScrollView implements ViewPager.j {
    private int A;
    private boolean B;
    private int C;
    private float D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private int N;
    private int O;
    private boolean P;
    private float Q;
    private Paint R;
    private SparseArray S;
    private o6.b T;
    private Context a;
    private ViewPager b;
    private ArrayList c;
    private LinearLayout d;
    private int e;
    private float f;
    private int g;
    private Rect h;
    private Rect i;
    private GradientDrawable j;
    private Paint k;
    private Paint l;
    private Paint m;
    private Path n;
    private int o;
    private float p;
    private boolean q;
    private float r;
    private int s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int indexOfChild = SlidingTabLayout.this.d.indexOfChild(view);
            if (indexOfChild != -1) {
                if (SlidingTabLayout.this.b.getCurrentItem() != indexOfChild) {
                    if (SlidingTabLayout.this.P) {
                        SlidingTabLayout.this.b.setCurrentItem(indexOfChild, false);
                    } else {
                        SlidingTabLayout.this.b.setCurrentItem(indexOfChild);
                    }
                    if (SlidingTabLayout.this.T != null) {
                        SlidingTabLayout.this.T.onTabSelect(indexOfChild);
                        return;
                    }
                    return;
                }
                if (SlidingTabLayout.this.T != null) {
                    SlidingTabLayout.this.T.onTabReselect(indexOfChild);
                }
            }
        }
    }

    public SlidingTabLayout(Context context) {
        this(context, null, 0);
    }

    private void e(int i, String str, View view) {
        LinearLayout.LayoutParams layoutParams;
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        if (textView != null && str != null) {
            textView.setText(str);
        }
        view.setOnClickListener(new a());
        if (this.q) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        if (this.r > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.r, -1);
        }
        this.d.addView(view, i, layoutParams);
    }

    private void f() {
        View childAt = this.d.getChildAt(this.e);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.o == 0 && this.B) {
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            this.R.setTextSize(this.I);
            this.Q = ((right - left) - this.R.measureText(textView.getText().toString())) / 2.0f;
        }
        int i = this.e;
        if (i < this.g - 1) {
            View childAt2 = this.d.getChildAt(i + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f = this.f;
            left += (left2 - left) * f;
            right += f * (right2 - right);
            if (this.o == 0 && this.B) {
                TextView textView2 = (TextView) childAt2.findViewById(R.id.tv_tab_title);
                this.R.setTextSize(this.I);
                float measureText = ((right2 - left2) - this.R.measureText(textView2.getText().toString())) / 2.0f;
                float f2 = this.Q;
                this.Q = f2 + (this.f * (measureText - f2));
            }
        }
        Rect rect = this.h;
        int i2 = (int) left;
        rect.left = i2;
        int i3 = (int) right;
        rect.right = i3;
        if (this.o == 0 && this.B) {
            float f3 = this.Q;
            rect.left = (int) ((left + f3) - 1.0f);
            rect.right = (int) ((right - f3) - 1.0f);
        }
        Rect rect2 = this.i;
        rect2.left = i2;
        rect2.right = i3;
        if (this.u >= 0.0f) {
            float left3 = childAt.getLeft() + ((childAt.getWidth() - this.u) / 2.0f);
            if (this.e < this.g - 1) {
                left3 += this.f * ((childAt.getWidth() / 2) + (this.d.getChildAt(r2 + 1).getWidth() / 2));
            }
            Rect rect3 = this.h;
            int i4 = (int) left3;
            rect3.left = i4;
            rect3.right = (int) (i4 + this.u);
        }
    }

    private void i(Context context, AttributeSet attributeSet) {
        String str;
        int i;
        float f;
        float f2;
        float f3;
        float f4;
        int g;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.flyco.tablayout.R.styleable.SlidingTabLayout);
        int i2 = obtainStyledAttributes.getInt(11, 0);
        this.o = i2;
        if (i2 != 2) {
            str = "#ffffff";
        } else {
            str = "#4B6A87";
        }
        this.s = obtainStyledAttributes.getColor(3, Color.parseColor(str));
        int i3 = this.o;
        if (i3 == 1) {
            f = 4.0f;
        } else {
            if (i3 == 2) {
                i = -1;
            } else {
                i = 2;
            }
            f = i;
        }
        this.t = obtainStyledAttributes.getDimension(6, g(f));
        if (this.o == 1) {
            f2 = 10.0f;
        } else {
            f2 = -1.0f;
        }
        this.u = obtainStyledAttributes.getDimension(12, g(f2));
        if (this.o == 2) {
            f3 = -1.0f;
        } else {
            f3 = 0.0f;
        }
        this.v = obtainStyledAttributes.getDimension(4, g(f3));
        this.w = obtainStyledAttributes.getDimension(8, g(0.0f));
        float f5 = 7.0f;
        if (this.o == 2) {
            f4 = 7.0f;
        } else {
            f4 = 0.0f;
        }
        this.x = obtainStyledAttributes.getDimension(10, g(f4));
        this.y = obtainStyledAttributes.getDimension(9, g(0.0f));
        if (this.o != 2) {
            f5 = 0.0f;
        }
        this.z = obtainStyledAttributes.getDimension(7, g(f5));
        this.A = obtainStyledAttributes.getInt(5, 80);
        this.B = obtainStyledAttributes.getBoolean(13, false);
        this.C = obtainStyledAttributes.getColor(22, Color.parseColor("#ffffff"));
        this.D = obtainStyledAttributes.getDimension(24, g(0.0f));
        this.E = obtainStyledAttributes.getInt(23, 80);
        this.F = obtainStyledAttributes.getColor(0, Color.parseColor("#ffffff"));
        this.G = obtainStyledAttributes.getDimension(2, g(0.0f));
        this.H = obtainStyledAttributes.getDimension(1, g(12.0f));
        this.I = obtainStyledAttributes.getDimension(21, l(14.0f));
        this.J = obtainStyledAttributes.getColor(19, Color.parseColor("#ffffff"));
        this.K = obtainStyledAttributes.getColor(20, Color.parseColor("#AAffffff"));
        this.L = obtainStyledAttributes.getInt(18, 0);
        this.M = obtainStyledAttributes.getBoolean(17, false);
        this.q = obtainStyledAttributes.getBoolean(15, false);
        float dimension = obtainStyledAttributes.getDimension(16, g(-1.0f));
        this.r = dimension;
        if (!this.q && dimension <= 0.0f) {
            g = g(20.0f);
        } else {
            g = g(0.0f);
        }
        this.p = obtainStyledAttributes.getDimension(14, g);
        obtainStyledAttributes.recycle();
    }

    private void j() {
        if (this.g <= 0) {
            return;
        }
        int width = (int) (this.f * this.d.getChildAt(this.e).getWidth());
        int left = this.d.getChildAt(this.e).getLeft() + width;
        if (this.e > 0 || width > 0) {
            int width2 = left - ((getWidth() / 2) - getPaddingLeft());
            f();
            Rect rect = this.i;
            left = width2 + ((rect.right - rect.left) / 2);
        }
        if (left != this.N) {
            this.N = left;
            scrollTo(left, 0);
        }
    }

    private void m(int i) {
        boolean z;
        int i2;
        for (int i3 = 0; i3 < this.g; i3++) {
            View childAt = this.d.getChildAt(i3);
            if (i3 == i) {
                z = true;
            } else {
                z = false;
            }
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (textView != null) {
                if (z) {
                    i2 = this.J;
                } else {
                    i2 = this.K;
                }
                textView.setTextColor(i2);
                if (this.L == 1) {
                    textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                    if (z) {
                        textView.getPaint().setStrokeWidth(3.0f);
                    } else {
                        textView.getPaint().setStrokeWidth(0.0f);
                    }
                }
            }
        }
    }

    private void n() {
        int i;
        for (int i2 = 0; i2 < this.g; i2++) {
            TextView textView = (TextView) this.d.getChildAt(i2).findViewById(R.id.tv_tab_title);
            if (textView != null) {
                if (i2 == this.e) {
                    i = this.J;
                } else {
                    i = this.K;
                }
                textView.setTextColor(i);
                textView.setTextSize(0, this.I);
                float f = this.p;
                textView.setPadding((int) f, 0, (int) f, 0);
                if (this.M) {
                    textView.setText(textView.getText().toString().toUpperCase());
                }
                int i3 = this.L;
                if (i3 == 2) {
                    textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                    textView.getPaint().setStrokeWidth(3.0f);
                } else if (i3 == 0) {
                    textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                    textView.getPaint().setStrokeWidth(0.0f);
                } else if (i3 == 1) {
                    if (i2 == this.e) {
                        textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                        textView.getPaint().setStrokeWidth(3.0f);
                    } else {
                        textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                        textView.getPaint().setStrokeWidth(0.0f);
                    }
                }
            }
        }
    }

    protected int g(float f) {
        return (int) ((f * this.a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getCurrentTab() {
        return this.e;
    }

    public int getDividerColor() {
        return this.F;
    }

    public float getDividerPadding() {
        return this.H;
    }

    public float getDividerWidth() {
        return this.G;
    }

    public int getIndicatorColor() {
        return this.s;
    }

    public float getIndicatorCornerRadius() {
        return this.v;
    }

    public float getIndicatorHeight() {
        return this.t;
    }

    public float getIndicatorMarginBottom() {
        return this.z;
    }

    public float getIndicatorMarginLeft() {
        return this.w;
    }

    public float getIndicatorMarginRight() {
        return this.y;
    }

    public float getIndicatorMarginTop() {
        return this.x;
    }

    public int getIndicatorStyle() {
        return this.o;
    }

    public float getIndicatorWidth() {
        return this.u;
    }

    public int getTabCount() {
        return this.g;
    }

    public float getTabPadding() {
        return this.p;
    }

    public float getTabWidth() {
        return this.r;
    }

    public int getTextBold() {
        return this.L;
    }

    public int getTextSelectColor() {
        return this.J;
    }

    public int getTextUnselectColor() {
        return this.K;
    }

    public float getTextsize() {
        return this.I;
    }

    public int getUnderlineColor() {
        return this.C;
    }

    public float getUnderlineHeight() {
        return this.D;
    }

    public void h() {
        int size;
        CharSequence charSequence;
        this.d.removeAllViews();
        ArrayList arrayList = this.c;
        if (arrayList == null) {
            size = this.b.getAdapter().getCount();
        } else {
            size = arrayList.size();
        }
        this.g = size;
        for (int i = 0; i < this.g; i++) {
            View inflate = View.inflate(this.a, R.layout.layout_tab, null);
            ArrayList arrayList2 = this.c;
            if (arrayList2 == null) {
                charSequence = this.b.getAdapter().getPageTitle(i);
            } else {
                charSequence = (CharSequence) arrayList2.get(i);
            }
            e(i, charSequence.toString(), inflate);
        }
        n();
    }

    public void k(ViewPager viewPager, String[] strArr) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            if (strArr != null && strArr.length != 0) {
                if (strArr.length == viewPager.getAdapter().getCount()) {
                    this.b = viewPager;
                    ArrayList arrayList = new ArrayList();
                    this.c = arrayList;
                    Collections.addAll(arrayList, strArr);
                    this.b.removeOnPageChangeListener(this);
                    this.b.addOnPageChangeListener(this);
                    h();
                    return;
                }
                throw new IllegalStateException("Titles length must be the same as the page count !");
            }
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
    }

    protected int l(float f) {
        return (int) ((f * this.a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.g > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            float f = this.G;
            if (f > 0.0f) {
                this.l.setStrokeWidth(f);
                this.l.setColor(this.F);
                for (int i = 0; i < this.g - 1; i++) {
                    View childAt = this.d.getChildAt(i);
                    canvas.drawLine(childAt.getRight() + paddingLeft, this.H, childAt.getRight() + paddingLeft, height - this.H, this.l);
                }
            }
            if (this.D > 0.0f) {
                this.k.setColor(this.C);
                if (this.E == 80) {
                    float f2 = height;
                    canvas.drawRect(paddingLeft, f2 - this.D, this.d.getWidth() + paddingLeft, f2, this.k);
                } else {
                    canvas.drawRect(paddingLeft, 0.0f, this.d.getWidth() + paddingLeft, this.D, this.k);
                }
            }
            f();
            int i2 = this.o;
            if (i2 == 1) {
                if (this.t > 0.0f) {
                    this.m.setColor(this.s);
                    this.n.reset();
                    float f3 = height;
                    this.n.moveTo(this.h.left + paddingLeft, f3);
                    Path path = this.n;
                    Rect rect = this.h;
                    path.lineTo((rect.left / 2) + paddingLeft + (rect.right / 2), f3 - this.t);
                    this.n.lineTo(paddingLeft + this.h.right, f3);
                    this.n.close();
                    canvas.drawPath(this.n, this.m);
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (this.t < 0.0f) {
                    this.t = (height - this.x) - this.z;
                }
                float f4 = this.t;
                if (f4 > 0.0f) {
                    float f5 = this.v;
                    if (f5 < 0.0f || f5 > f4 / 2.0f) {
                        this.v = f4 / 2.0f;
                    }
                    this.j.setColor(this.s);
                    GradientDrawable gradientDrawable = this.j;
                    int i3 = ((int) this.w) + paddingLeft + this.h.left;
                    float f6 = this.x;
                    gradientDrawable.setBounds(i3, (int) f6, (int) ((paddingLeft + r2.right) - this.y), (int) (f6 + this.t));
                    this.j.setCornerRadius(this.v);
                    this.j.draw(canvas);
                    return;
                }
                return;
            }
            if (this.t > 0.0f) {
                this.j.setColor(this.s);
                if (this.A == 80) {
                    GradientDrawable gradientDrawable2 = this.j;
                    int i4 = ((int) this.w) + paddingLeft;
                    Rect rect2 = this.h;
                    int i5 = i4 + rect2.left;
                    int i6 = height - ((int) this.t);
                    float f7 = this.z;
                    gradientDrawable2.setBounds(i5, i6 - ((int) f7), (paddingLeft + rect2.right) - ((int) this.y), height - ((int) f7));
                } else {
                    GradientDrawable gradientDrawable3 = this.j;
                    int i7 = ((int) this.w) + paddingLeft;
                    Rect rect3 = this.h;
                    int i8 = i7 + rect3.left;
                    float f8 = this.x;
                    gradientDrawable3.setBounds(i8, (int) f8, (paddingLeft + rect3.right) - ((int) this.y), ((int) this.t) + ((int) f8));
                }
                this.j.setCornerRadius(this.v);
                this.j.draw(canvas);
            }
        }
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.e = i;
        this.f = f;
        j();
        invalidate();
    }

    public void onPageSelected(int i) {
        m(i);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.e = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.e != 0 && this.d.getChildCount() > 0) {
                m(this.e);
                j();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.e);
        return bundle;
    }

    public void setCurrentTab(int i) {
        this.e = i;
        this.b.setCurrentItem(i);
    }

    public void setDividerColor(int i) {
        this.F = i;
        invalidate();
    }

    public void setDividerPadding(float f) {
        this.H = g(f);
        invalidate();
    }

    public void setDividerWidth(float f) {
        this.G = g(f);
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.s = i;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f) {
        this.v = g(f);
        invalidate();
    }

    public void setIndicatorGravity(int i) {
        this.A = i;
        invalidate();
    }

    public void setIndicatorHeight(float f) {
        this.t = g(f);
        invalidate();
    }

    public void setIndicatorStyle(int i) {
        this.o = i;
        invalidate();
    }

    public void setIndicatorWidth(float f) {
        this.u = g(f);
        invalidate();
    }

    public void setIndicatorWidthEqualTitle(boolean z) {
        this.B = z;
        invalidate();
    }

    public void setOnTabSelectListener(o6.b bVar) {
        this.T = bVar;
    }

    public void setSnapOnTabClick(boolean z) {
        this.P = z;
    }

    public void setTabPadding(float f) {
        this.p = g(f);
        n();
    }

    public void setTabSpaceEqual(boolean z) {
        this.q = z;
        n();
    }

    public void setTabWidth(float f) {
        this.r = g(f);
        n();
    }

    public void setTextAllCaps(boolean z) {
        this.M = z;
        n();
    }

    public void setTextBold(int i) {
        this.L = i;
        n();
    }

    public void setTextSelectColor(int i) {
        this.J = i;
        n();
    }

    public void setTextUnselectColor(int i) {
        this.K = i;
        n();
    }

    public void setTextsize(float f) {
        this.I = l(f);
        n();
    }

    public void setUnderlineColor(int i) {
        this.C = i;
        invalidate();
    }

    public void setUnderlineGravity(int i) {
        this.E = i;
        invalidate();
    }

    public void setUnderlineHeight(float f) {
        this.D = g(f);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.b = viewPager;
            viewPager.removeOnPageChangeListener(this);
            this.b.addOnPageChangeListener(this);
            h();
            return;
        }
        throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new Rect();
        this.i = new Rect();
        this.j = new GradientDrawable();
        this.k = new Paint(1);
        this.l = new Paint(1);
        this.m = new Paint(1);
        this.n = new Path();
        this.o = 0;
        this.R = new Paint(1);
        this.S = new SparseArray();
        setFillViewport(true);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.d = linearLayout;
        addView(linearLayout);
        i(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (attributeValue.equals("-1") || attributeValue.equals("-2")) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.layout_height});
        this.O = obtainStyledAttributes.getDimensionPixelSize(0, -2);
        obtainStyledAttributes.recycle();
    }
}
