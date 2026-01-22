package com.qiahao.nextvideo.ui.reusable;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
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
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiahao.base_common.utils.image.ImageKtx;
import com.qiahao.nextvideo.R;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class CustomizeCommonTabLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener {
    private boolean A;
    private int B;
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
    private boolean N;
    private int O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private final ValueAnimator T;
    private final OvershootInterpolator U;
    private boolean V;
    private final Paint W;
    private final Context a;
    private final SparseArray a0;
    private final ArrayList b;
    private o6.b b0;
    private final FrameLayout c;
    private final b c0;
    private int d;
    private final b d0;
    private int e;
    private int f;
    private final Rect g;
    private final GradientDrawable h;
    private final Paint i;
    private final Paint j;
    private final Paint k;
    private final Path l;
    private int m;
    private float n;
    private boolean o;
    private float p;
    private int q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private long y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (CustomizeCommonTabLayout.this.d != intValue) {
                CustomizeCommonTabLayout.this.setCurrentTab(intValue);
                if (CustomizeCommonTabLayout.this.b0 != null) {
                    CustomizeCommonTabLayout.this.b0.onTabSelect(intValue);
                    return;
                }
                return;
            }
            if (CustomizeCommonTabLayout.this.b0 != null) {
                CustomizeCommonTabLayout.this.b0.onTabReselect(intValue);
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

    public CustomizeCommonTabLayout(Context context) {
        this(context, null, 0);
    }

    private void c(int i, View view) {
        ((TextView) view.findViewById(R.id.tv_tab_title)).setText(((o6.a) this.b.get(i)).getTabTitle());
        ImageKtx.INSTANCE.loadImage((ImageView) view.findViewById(R.id.iv_tab_icon), Integer.valueOf(((o6.a) this.b.get(i)).getTabUnselectedIcon()));
        view.setOnClickListener(new a());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        if (this.p > 0.0f) {
            layoutParams = new FrameLayout.LayoutParams((int) this.p, -1);
        }
        if (i == 0) {
            this.c.addView(view, i, layoutParams);
        } else if (i == 1) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
            layoutParams2.gravity = 8388613;
            this.c.addView(view, i, layoutParams2);
        }
    }

    private void d() {
        View childAt = this.c.getChildAt(this.d);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        Rect rect = this.g;
        rect.left = (int) left;
        rect.right = (int) right;
        if (this.s >= 0.0f) {
            float left2 = childAt.getLeft();
            float width = childAt.getWidth();
            float f = this.s;
            float f2 = left2 + ((width - f) / 2.0f);
            Rect rect2 = this.g;
            int i = (int) f2;
            rect2.left = i;
            rect2.right = (int) (i + f);
        }
    }

    private void e() {
        long j;
        View childAt = this.c.getChildAt(this.d);
        this.c0.a = childAt.getLeft();
        this.c0.b = childAt.getRight();
        View childAt2 = this.c.getChildAt(this.e);
        this.d0.a = childAt2.getLeft();
        this.d0.b = childAt2.getRight();
        b bVar = this.d0;
        float f = bVar.a;
        b bVar2 = this.c0;
        if (f == bVar2.a && bVar.b == bVar2.b) {
            invalidate();
            return;
        }
        this.T.setObjectValues(bVar, bVar2);
        if (this.A) {
            this.T.setInterpolator(this.U);
        }
        if (this.y < 0) {
            if (this.A) {
                j = 500;
            } else {
                j = 250;
            }
            this.y = j;
        }
        this.T.setDuration(this.y);
        this.T.start();
    }

    private void h(Context context, AttributeSet attributeSet) {
        String str;
        int i;
        float f;
        float f2;
        float f3;
        float f4;
        int f5;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonTabLayout);
        int i2 = obtainStyledAttributes.getInt(19, 0);
        this.m = i2;
        if (i2 != 2) {
            str = "#ffffff";
        } else {
            str = "#4B6A87";
        }
        this.q = obtainStyledAttributes.getColor(11, Color.parseColor(str));
        int i3 = this.m;
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
        this.r = obtainStyledAttributes.getDimension(14, f(f));
        if (this.m == 1) {
            f2 = 10.0f;
        } else {
            f2 = -1.0f;
        }
        this.s = obtainStyledAttributes.getDimension(20, f(f2));
        if (this.m == 2) {
            f3 = -1.0f;
        } else {
            f3 = 0.0f;
        }
        this.t = obtainStyledAttributes.getDimension(12, f(f3));
        this.u = obtainStyledAttributes.getDimension(16, f(0.0f));
        float f6 = 7.0f;
        if (this.m == 2) {
            f4 = 7.0f;
        } else {
            f4 = 0.0f;
        }
        this.v = obtainStyledAttributes.getDimension(18, f(f4));
        this.w = obtainStyledAttributes.getDimension(17, f(0.0f));
        if (this.m != 2) {
            f6 = 0.0f;
        }
        this.x = obtainStyledAttributes.getDimension(15, f(f6));
        this.z = obtainStyledAttributes.getBoolean(9, true);
        this.A = obtainStyledAttributes.getBoolean(10, true);
        this.y = obtainStyledAttributes.getInt(8, -1);
        this.B = obtainStyledAttributes.getInt(13, 80);
        this.C = obtainStyledAttributes.getColor(29, Color.parseColor("#ffffff"));
        this.D = obtainStyledAttributes.getDimension(31, f(0.0f));
        this.E = obtainStyledAttributes.getInt(30, 80);
        this.F = obtainStyledAttributes.getColor(0, Color.parseColor("#ffffff"));
        this.G = obtainStyledAttributes.getDimension(2, f(0.0f));
        this.H = obtainStyledAttributes.getDimension(1, f(12.0f));
        this.I = obtainStyledAttributes.getDimension(28, i(13.0f));
        this.J = obtainStyledAttributes.getColor(26, Color.parseColor("#ffffff"));
        this.K = obtainStyledAttributes.getColor(27, Color.parseColor("#AAffffff"));
        this.L = obtainStyledAttributes.getInt(25, 0);
        this.M = obtainStyledAttributes.getBoolean(24, false);
        this.N = obtainStyledAttributes.getBoolean(6, true);
        this.O = obtainStyledAttributes.getInt(3, 48);
        this.P = obtainStyledAttributes.getDimension(7, f(0.0f));
        this.Q = obtainStyledAttributes.getDimension(4, f(0.0f));
        this.R = obtainStyledAttributes.getDimension(5, f(2.5f));
        this.o = obtainStyledAttributes.getBoolean(22, true);
        float dimension = obtainStyledAttributes.getDimension(23, f(-1.0f));
        this.p = dimension;
        if (!this.o && dimension <= 0.0f) {
            f5 = f(10.0f);
        } else {
            f5 = f(0.0f);
        }
        this.n = obtainStyledAttributes.getDimension(21, f5);
        obtainStyledAttributes.recycle();
    }

    private void j(int i) {
        boolean z;
        int i2;
        int tabUnselectedIcon;
        for (int i3 = 0; i3 < this.f; i3++) {
            View childAt = this.c.getChildAt(i3);
            if (i3 == i) {
                z = true;
            } else {
                z = false;
            }
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (z) {
                i2 = this.J;
            } else {
                i2 = this.K;
            }
            textView.setTextColor(i2);
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_tab_icon);
            o6.a aVar = (o6.a) this.b.get(i3);
            ImageKtx imageKtx = ImageKtx.INSTANCE;
            if (z) {
                tabUnselectedIcon = aVar.getTabSelectedIcon();
            } else {
                tabUnselectedIcon = aVar.getTabUnselectedIcon();
            }
            imageKtx.loadImage(imageView, Integer.valueOf(tabUnselectedIcon));
            if (this.L == 1) {
                textView.getPaint().setFakeBoldText(z);
            }
        }
    }

    private void k() {
        int i;
        int tabUnselectedIcon;
        int i2;
        for (int i3 = 0; i3 < this.f; i3++) {
            View childAt = this.c.getChildAt(i3);
            float f = this.n;
            childAt.setPadding((int) f, 0, (int) f, 0);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (i3 == this.d) {
                i = this.J;
            } else {
                i = this.K;
            }
            textView.setTextColor(i);
            textView.setTextSize(0, this.I);
            if (this.M) {
                textView.setText(textView.getText().toString().toUpperCase());
            }
            int i4 = this.L;
            if (i4 == 2) {
                textView.getPaint().setFakeBoldText(true);
            } else if (i4 == 0) {
                textView.getPaint().setFakeBoldText(false);
            }
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_tab_icon);
            if (this.N) {
                imageView.setVisibility(0);
                o6.a aVar = (o6.a) this.b.get(i3);
                ImageKtx imageKtx = ImageKtx.INSTANCE;
                if (i3 == this.d) {
                    tabUnselectedIcon = aVar.getTabSelectedIcon();
                } else {
                    tabUnselectedIcon = aVar.getTabUnselectedIcon();
                }
                imageKtx.loadImage(imageView, Integer.valueOf(tabUnselectedIcon));
                float f2 = this.P;
                int i5 = -2;
                if (f2 <= 0.0f) {
                    i2 = -2;
                } else {
                    i2 = (int) f2;
                }
                float f3 = this.Q;
                if (f3 > 0.0f) {
                    i5 = (int) f3;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i5);
                int i6 = this.O;
                if (i6 == 3) {
                    layoutParams.rightMargin = (int) this.R;
                } else if (i6 == 5) {
                    layoutParams.leftMargin = (int) this.R;
                } else if (i6 == 80) {
                    layoutParams.topMargin = (int) this.R;
                } else {
                    layoutParams.bottomMargin = (int) this.R;
                }
                imageView.setLayoutParams(layoutParams);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    protected int f(float f) {
        return (int) ((f * this.a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void g() {
        View inflate;
        this.c.removeAllViews();
        this.f = this.b.size();
        for (int i = 0; i < this.f; i++) {
            int i2 = this.O;
            if (i2 == 3) {
                inflate = View.inflate(this.a, R.layout.layout_tab_left, null);
            } else if (i2 == 5) {
                inflate = View.inflate(this.a, R.layout.layout_tab_right, null);
            } else if (i2 == 80) {
                inflate = View.inflate(this.a, R.layout.layout_tab_bottom, null);
            } else {
                inflate = View.inflate(this.a, R.layout.layout_tab_top, null);
            }
            inflate.setTag(Integer.valueOf(i));
            c(i, inflate);
        }
        k();
    }

    public int getCurrentTab() {
        return this.d;
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

    public int getIconGravity() {
        return this.O;
    }

    public float getIconHeight() {
        return this.Q;
    }

    public float getIconMargin() {
        return this.R;
    }

    public float getIconWidth() {
        return this.P;
    }

    public long getIndicatorAnimDuration() {
        return this.y;
    }

    public int getIndicatorColor() {
        return this.q;
    }

    public float getIndicatorCornerRadius() {
        return this.t;
    }

    public float getIndicatorHeight() {
        return this.r;
    }

    public float getIndicatorMarginBottom() {
        return this.x;
    }

    public float getIndicatorMarginLeft() {
        return this.u;
    }

    public float getIndicatorMarginRight() {
        return this.w;
    }

    public float getIndicatorMarginTop() {
        return this.v;
    }

    public int getIndicatorStyle() {
        return this.m;
    }

    public float getIndicatorWidth() {
        return this.s;
    }

    public int getTabCount() {
        return this.f;
    }

    public float getTabPadding() {
        return this.n;
    }

    public float getTabWidth() {
        return this.p;
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

    protected int i(float f) {
        return (int) ((f * this.a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View childAt = this.c.getChildAt(this.d);
        b bVar = (b) valueAnimator.getAnimatedValue();
        Rect rect = this.g;
        float f = bVar.a;
        rect.left = (int) f;
        rect.right = (int) bVar.b;
        if (this.s >= 0.0f) {
            float width = childAt.getWidth();
            float f2 = this.s;
            float f3 = f + ((width - f2) / 2.0f);
            Rect rect2 = this.g;
            int i = (int) f3;
            rect2.left = i;
            rect2.right = (int) (i + f2);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            float f = this.G;
            if (f > 0.0f) {
                this.j.setStrokeWidth(f);
                this.j.setColor(this.F);
                for (int i = 0; i < this.f - 1; i++) {
                    View childAt = this.c.getChildAt(i);
                    canvas.drawLine(childAt.getRight() + paddingLeft, this.H, childAt.getRight() + paddingLeft, height - this.H, this.j);
                }
            }
            if (this.D > 0.0f) {
                this.i.setColor(this.C);
                if (this.E == 80) {
                    float f2 = height;
                    canvas.drawRect(paddingLeft, f2 - this.D, this.c.getWidth() + paddingLeft, f2, this.i);
                } else {
                    canvas.drawRect(paddingLeft, 0.0f, this.c.getWidth() + paddingLeft, this.D, this.i);
                }
            }
            if (this.z) {
                if (this.V) {
                    this.V = false;
                    d();
                }
            } else {
                d();
            }
            int i2 = this.m;
            if (i2 == 1) {
                if (this.r > 0.0f) {
                    this.k.setColor(this.q);
                    this.l.reset();
                    float f3 = height;
                    this.l.moveTo(this.g.left + paddingLeft, f3);
                    Path path = this.l;
                    Rect rect = this.g;
                    path.lineTo((rect.left / 2) + paddingLeft + (rect.right / 2), f3 - this.r);
                    this.l.lineTo(paddingLeft + this.g.right, f3);
                    this.l.close();
                    canvas.drawPath(this.l, this.k);
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (this.r < 0.0f) {
                    this.r = (height - this.v) - this.x;
                }
                float f4 = this.r;
                if (f4 > 0.0f) {
                    float f5 = this.t;
                    if (f5 < 0.0f || f5 > f4 / 2.0f) {
                        this.t = f4 / 2.0f;
                    }
                    this.h.setColor(this.q);
                    GradientDrawable gradientDrawable = this.h;
                    int i3 = ((int) this.u) + paddingLeft + this.g.left;
                    float f6 = this.v;
                    gradientDrawable.setBounds(i3, (int) f6, (int) ((paddingLeft + r2.right) - this.w), (int) (f6 + this.r));
                    this.h.setCornerRadius(this.t);
                    this.h.draw(canvas);
                    return;
                }
                return;
            }
            if (this.r > 0.0f) {
                this.h.setColor(this.q);
                if (this.B == 80) {
                    GradientDrawable gradientDrawable2 = this.h;
                    int i4 = ((int) this.u) + paddingLeft;
                    Rect rect2 = this.g;
                    int i5 = i4 + rect2.left;
                    int i6 = height - ((int) this.r);
                    float f7 = this.x;
                    gradientDrawable2.setBounds(i5, i6 - ((int) f7), (paddingLeft + rect2.right) - ((int) this.w), height - ((int) f7));
                } else {
                    GradientDrawable gradientDrawable3 = this.h;
                    int i7 = ((int) this.u) + paddingLeft;
                    Rect rect3 = this.g;
                    int i8 = i7 + rect3.left;
                    float f8 = this.v;
                    gradientDrawable3.setBounds(i8, (int) f8, (paddingLeft + rect3.right) - ((int) this.w), ((int) this.r) + ((int) f8));
                }
                this.h.setCornerRadius(this.t);
                this.h.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.d = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.d != 0 && this.c.getChildCount() > 0) {
                j(this.d);
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
        j(i);
        if (this.z) {
            e();
        } else {
            invalidate();
        }
    }

    public void setDividerColor(int i) {
        this.F = i;
        invalidate();
    }

    public void setDividerPadding(float f) {
        this.H = f(f);
        invalidate();
    }

    public void setDividerWidth(float f) {
        this.G = f(f);
        invalidate();
    }

    public void setIconGravity(int i) {
        this.O = i;
        g();
    }

    public void setIconHeight(float f) {
        this.Q = f(f);
        k();
    }

    public void setIconMargin(float f) {
        this.R = f(f);
        k();
    }

    public void setIconVisible(boolean z) {
        this.N = z;
        k();
    }

    public void setIconWidth(float f) {
        this.P = f(f);
        k();
    }

    public void setIndicatorAnimDuration(long j) {
        this.y = j;
    }

    public void setIndicatorAnimEnable(boolean z) {
        this.z = z;
    }

    public void setIndicatorBounceEnable(boolean z) {
        this.A = z;
    }

    public void setIndicatorColor(int i) {
        this.q = i;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f) {
        this.t = f(f);
        invalidate();
    }

    public void setIndicatorGravity(int i) {
        this.B = i;
        invalidate();
    }

    public void setIndicatorHeight(float f) {
        this.r = f(f);
        invalidate();
    }

    public void setIndicatorStyle(int i) {
        this.m = i;
        invalidate();
    }

    public void setIndicatorWidth(float f) {
        this.s = f(f);
        invalidate();
    }

    public void setOnTabSelectListener(o6.b bVar) {
        this.b0 = bVar;
    }

    public void setTabData(ArrayList<o6.a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.b.clear();
            this.b.addAll(arrayList);
            g();
            return;
        }
        throw new IllegalStateException("TabEntitys can not be NULL or EMPTY !");
    }

    public void setTabPadding(float f) {
        this.n = f(f);
        k();
    }

    public void setTabSpaceEqual(boolean z) {
        this.o = z;
        k();
    }

    public void setTabWidth(float f) {
        this.p = f(f);
        k();
    }

    public void setTextAllCaps(boolean z) {
        this.M = z;
        k();
    }

    public void setTextBold(int i) {
        this.L = i;
        k();
    }

    public void setTextSelectColor(int i) {
        this.J = i;
        k();
    }

    public void setTextUnselectColor(int i) {
        this.K = i;
        k();
    }

    public void setTextsize(float f) {
        this.I = i(f);
        k();
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
        this.D = f(f);
        invalidate();
    }

    public CustomizeCommonTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomizeCommonTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new ArrayList();
        this.g = new Rect();
        this.h = new GradientDrawable();
        this.i = new Paint(1);
        this.j = new Paint(1);
        this.k = new Paint(1);
        this.l = new Path();
        this.m = 0;
        this.U = new OvershootInterpolator(1.5f);
        this.V = true;
        this.W = new Paint(1);
        this.a0 = new SparseArray();
        b bVar = new b();
        this.c0 = bVar;
        b bVar2 = new b();
        this.d0 = bVar2;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.a = context;
        FrameLayout frameLayout = new FrameLayout(context);
        this.c = frameLayout;
        addView(frameLayout);
        h(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.layout_height});
            this.S = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new c(), bVar2, bVar);
        this.T = ofObject;
        ofObject.addUpdateListener(this);
    }
}
