package com.flyco.tablayout;

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
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CommonTabLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener {
    private boolean A;

    /* renamed from: B, reason: collision with root package name */
    private int f٧٨٣٥B;
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
    private ValueAnimator T;
    private OvershootInterpolator U;
    private boolean V;
    private Paint W;

    /* renamed from: a, reason: collision with root package name */
    private Context f٧٨٣٦a;

    /* renamed from: a0, reason: collision with root package name */
    private SparseArray f٧٨٣٧a0;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList f٧٨٣٨b;

    /* renamed from: b0, reason: collision with root package name */
    private o6.b f٧٨٣٩b0;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f٧٨٤٠c;

    /* renamed from: c0, reason: collision with root package name */
    private b f٧٨٤١c0;

    /* renamed from: d, reason: collision with root package name */
    private int f٧٨٤٢d;

    /* renamed from: d0, reason: collision with root package name */
    private b f٧٨٤٣d0;

    /* renamed from: e, reason: collision with root package name */
    private int f٧٨٤٤e;

    /* renamed from: f, reason: collision with root package name */
    private int f٧٨٤٥f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f٧٨٤٦g;

    /* renamed from: h, reason: collision with root package name */
    private GradientDrawable f٧٨٤٧h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f٧٨٤٨i;

    /* renamed from: j, reason: collision with root package name */
    private Paint f٧٨٤٩j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f٧٨٥٠k;

    /* renamed from: l, reason: collision with root package name */
    private Path f٧٨٥١l;

    /* renamed from: m, reason: collision with root package name */
    private int f٧٨٥٢m;

    /* renamed from: n, reason: collision with root package name */
    private float f٧٨٥٣n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٧٨٥٤o;

    /* renamed from: p, reason: collision with root package name */
    private float f٧٨٥٥p;

    /* renamed from: q, reason: collision with root package name */
    private int f٧٨٥٦q;

    /* renamed from: r, reason: collision with root package name */
    private float f٧٨٥٧r;

    /* renamed from: s, reason: collision with root package name */
    private float f٧٨٥٨s;

    /* renamed from: t, reason: collision with root package name */
    private float f٧٨٥٩t;

    /* renamed from: u, reason: collision with root package name */
    private float f٧٨٦٠u;

    /* renamed from: v, reason: collision with root package name */
    private float f٧٨٦١v;

    /* renamed from: w, reason: collision with root package name */
    private float f٧٨٦٢w;

    /* renamed from: x, reason: collision with root package name */
    private float f٧٨٦٣x;

    /* renamed from: y, reason: collision with root package name */
    private long f٧٨٦٤y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f٧٨٦٥z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (CommonTabLayout.this.f٧٨٤٢d != intValue) {
                CommonTabLayout.this.setCurrentTab(intValue);
                if (CommonTabLayout.this.f٧٨٣٩b0 != null) {
                    CommonTabLayout.this.f٧٨٣٩b0.onTabSelect(intValue);
                    return;
                }
                return;
            }
            if (CommonTabLayout.this.f٧٨٣٩b0 != null) {
                CommonTabLayout.this.f٧٨٣٩b0.onTabReselect(intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public float f٧٨٦٧a;

        /* renamed from: b, reason: collision with root package name */
        public float f٧٨٦٨b;

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
            float f11 = bVar.f٧٨٦٧a;
            float f12 = f11 + ((bVar2.f٧٨٦٧a - f11) * f10);
            float f13 = bVar.f٧٨٦٨b;
            float f14 = f13 + (f10 * (bVar2.f٧٨٦٨b - f13));
            b bVar3 = new b();
            bVar3.f٧٨٦٧a = f12;
            bVar3.f٧٨٦٨b = f14;
            return bVar3;
        }
    }

    public CommonTabLayout(Context context) {
        this(context, null, 0);
    }

    private void c(int i10, View view) {
        LinearLayout.LayoutParams layoutParams;
        ((TextView) view.findViewById(R.id.tv_tab_title)).setText(((o6.a) this.f٧٨٣٨b.get(i10)).getTabTitle());
        ((ImageView) view.findViewById(R.id.iv_tab_icon)).setImageResource(((o6.a) this.f٧٨٣٨b.get(i10)).getTabUnselectedIcon());
        view.setOnClickListener(new a());
        if (this.f٧٨٥٤o) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        if (this.f٧٨٥٥p > DownloadProgress.UNKNOWN_PROGRESS) {
            layoutParams = new LinearLayout.LayoutParams((int) this.f٧٨٥٥p, -1);
        }
        this.f٧٨٤٠c.addView(view, i10, layoutParams);
    }

    private void d() {
        View childAt = this.f٧٨٤٠c.getChildAt(this.f٧٨٤٢d);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        Rect rect = this.f٧٨٤٦g;
        rect.left = (int) left;
        rect.right = (int) right;
        if (this.f٧٨٥٨s >= DownloadProgress.UNKNOWN_PROGRESS) {
            float left2 = childAt.getLeft();
            float width = childAt.getWidth();
            float f10 = this.f٧٨٥٨s;
            float f11 = left2 + ((width - f10) / 2.0f);
            Rect rect2 = this.f٧٨٤٦g;
            int i10 = (int) f11;
            rect2.left = i10;
            rect2.right = (int) (i10 + f10);
        }
    }

    private void e() {
        long j10;
        View childAt = this.f٧٨٤٠c.getChildAt(this.f٧٨٤٢d);
        this.f٧٨٤١c0.f٧٨٦٧a = childAt.getLeft();
        this.f٧٨٤١c0.f٧٨٦٨b = childAt.getRight();
        View childAt2 = this.f٧٨٤٠c.getChildAt(this.f٧٨٤٤e);
        this.f٧٨٤٣d0.f٧٨٦٧a = childAt2.getLeft();
        this.f٧٨٤٣d0.f٧٨٦٨b = childAt2.getRight();
        b bVar = this.f٧٨٤٣d0;
        float f10 = bVar.f٧٨٦٧a;
        b bVar2 = this.f٧٨٤١c0;
        if (f10 == bVar2.f٧٨٦٧a && bVar.f٧٨٦٨b == bVar2.f٧٨٦٨b) {
            invalidate();
            return;
        }
        this.T.setObjectValues(bVar, bVar2);
        if (this.A) {
            this.T.setInterpolator(this.U);
        }
        if (this.f٧٨٦٤y < 0) {
            if (this.A) {
                j10 = 500;
            } else {
                j10 = 250;
            }
            this.f٧٨٦٤y = j10;
        }
        this.T.setDuration(this.f٧٨٦٤y);
        this.T.start();
    }

    private void i(Context context, AttributeSet attributeSet) {
        String str;
        int i10;
        float f10;
        float f11;
        float f12;
        float f13;
        int f14;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonTabLayout);
        int i11 = obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_indicator_style, 0);
        this.f٧٨٥٢m = i11;
        int i12 = R.styleable.CommonTabLayout_tl_indicator_color;
        if (i11 != 2) {
            str = "#ffffff";
        } else {
            str = "#4B6A87";
        }
        this.f٧٨٥٦q = obtainStyledAttributes.getColor(i12, Color.parseColor(str));
        int i13 = R.styleable.CommonTabLayout_tl_indicator_height;
        int i14 = this.f٧٨٥٢m;
        if (i14 == 1) {
            f10 = 4.0f;
        } else {
            if (i14 == 2) {
                i10 = -1;
            } else {
                i10 = 2;
            }
            f10 = i10;
        }
        this.f٧٨٥٧r = obtainStyledAttributes.getDimension(i13, f(f10));
        int i15 = R.styleable.CommonTabLayout_tl_indicator_width;
        if (this.f٧٨٥٢m == 1) {
            f11 = 10.0f;
        } else {
            f11 = -1.0f;
        }
        this.f٧٨٥٨s = obtainStyledAttributes.getDimension(i15, f(f11));
        int i16 = R.styleable.CommonTabLayout_tl_indicator_corner_radius;
        if (this.f٧٨٥٢m == 2) {
            f12 = -1.0f;
        } else {
            f12 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        this.f٧٨٥٩t = obtainStyledAttributes.getDimension(i16, f(f12));
        this.f٧٨٦٠u = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_margin_left, f(DownloadProgress.UNKNOWN_PROGRESS));
        int i17 = R.styleable.CommonTabLayout_tl_indicator_margin_top;
        float f15 = 7.0f;
        if (this.f٧٨٥٢m == 2) {
            f13 = 7.0f;
        } else {
            f13 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        this.f٧٨٦١v = obtainStyledAttributes.getDimension(i17, f(f13));
        this.f٧٨٦٢w = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_margin_right, f(DownloadProgress.UNKNOWN_PROGRESS));
        int i18 = R.styleable.CommonTabLayout_tl_indicator_margin_bottom;
        if (this.f٧٨٥٢m != 2) {
            f15 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        this.f٧٨٦٣x = obtainStyledAttributes.getDimension(i18, f(f15));
        this.f٧٨٦٥z = obtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_indicator_anim_enable, true);
        this.A = obtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_indicator_bounce_enable, true);
        this.f٧٨٦٤y = obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_indicator_anim_duration, -1);
        this.f٧٨٣٥B = obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_indicator_gravity, 80);
        this.C = obtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_underline_color, Color.parseColor("#ffffff"));
        this.D = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_underline_height, f(DownloadProgress.UNKNOWN_PROGRESS));
        this.E = obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_underline_gravity, 80);
        this.F = obtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_divider_color, Color.parseColor("#ffffff"));
        this.G = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_divider_width, f(DownloadProgress.UNKNOWN_PROGRESS));
        this.H = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_divider_padding, f(12.0f));
        this.I = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_textsize, j(13.0f));
        this.J = obtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        this.K = obtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_textUnselectColor, Color.parseColor("#AAffffff"));
        this.L = obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_textBold, 0);
        this.M = obtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_textAllCaps, false);
        this.N = obtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_iconVisible, true);
        this.O = obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_iconGravity, 48);
        this.P = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_iconWidth, f(DownloadProgress.UNKNOWN_PROGRESS));
        this.Q = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_iconHeight, f(DownloadProgress.UNKNOWN_PROGRESS));
        this.R = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_iconMargin, f(2.5f));
        this.f٧٨٥٤o = obtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_tab_space_equal, true);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_tab_width, f(-1.0f));
        this.f٧٨٥٥p = dimension;
        int i19 = R.styleable.CommonTabLayout_tl_tab_padding;
        if (!this.f٧٨٥٤o && dimension <= DownloadProgress.UNKNOWN_PROGRESS) {
            f14 = f(10.0f);
        } else {
            f14 = f(DownloadProgress.UNKNOWN_PROGRESS);
        }
        this.f٧٨٥٣n = obtainStyledAttributes.getDimension(i19, f14);
        obtainStyledAttributes.recycle();
    }

    private void k(int i10) {
        boolean z10;
        int i11;
        int tabUnselectedIcon;
        for (int i12 = 0; i12 < this.f٧٨٤٥f; i12++) {
            View childAt = this.f٧٨٤٠c.getChildAt(i12);
            if (i12 == i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (z10) {
                i11 = this.J;
            } else {
                i11 = this.K;
            }
            textView.setTextColor(i11);
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_tab_icon);
            o6.a aVar = (o6.a) this.f٧٨٣٨b.get(i12);
            if (z10) {
                tabUnselectedIcon = aVar.getTabSelectedIcon();
            } else {
                tabUnselectedIcon = aVar.getTabUnselectedIcon();
            }
            imageView.setImageResource(tabUnselectedIcon);
            if (this.L == 1) {
                textView.getPaint().setFakeBoldText(z10);
            }
        }
    }

    private void l() {
        int i10;
        int tabUnselectedIcon;
        int i11;
        for (int i12 = 0; i12 < this.f٧٨٤٥f; i12++) {
            View childAt = this.f٧٨٤٠c.getChildAt(i12);
            float f10 = this.f٧٨٥٣n;
            childAt.setPadding((int) f10, 0, (int) f10, 0);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (i12 == this.f٧٨٤٢d) {
                i10 = this.J;
            } else {
                i10 = this.K;
            }
            textView.setTextColor(i10);
            textView.setTextSize(0, this.I);
            if (this.M) {
                textView.setText(textView.getText().toString().toUpperCase());
            }
            int i13 = this.L;
            if (i13 == 2) {
                textView.getPaint().setFakeBoldText(true);
            } else if (i13 == 0) {
                textView.getPaint().setFakeBoldText(false);
            }
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_tab_icon);
            if (this.N) {
                imageView.setVisibility(0);
                o6.a aVar = (o6.a) this.f٧٨٣٨b.get(i12);
                if (i12 == this.f٧٨٤٢d) {
                    tabUnselectedIcon = aVar.getTabSelectedIcon();
                } else {
                    tabUnselectedIcon = aVar.getTabUnselectedIcon();
                }
                imageView.setImageResource(tabUnselectedIcon);
                float f11 = this.P;
                int i14 = -2;
                if (f11 <= DownloadProgress.UNKNOWN_PROGRESS) {
                    i11 = -2;
                } else {
                    i11 = (int) f11;
                }
                float f12 = this.Q;
                if (f12 > DownloadProgress.UNKNOWN_PROGRESS) {
                    i14 = (int) f12;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, i14);
                int i15 = this.O;
                if (i15 == 3) {
                    layoutParams.rightMargin = (int) this.R;
                } else if (i15 == 5) {
                    layoutParams.leftMargin = (int) this.R;
                } else if (i15 == 80) {
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

    protected int f(float f10) {
        return (int) ((f10 * this.f٧٨٣٦a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public TextView g(int i10) {
        return (TextView) this.f٧٨٤٠c.getChildAt(i10).findViewById(R.id.tv_tab_title);
    }

    public int getCurrentTab() {
        return this.f٧٨٤٢d;
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
        return this.f٧٨٦٤y;
    }

    public int getIndicatorColor() {
        return this.f٧٨٥٦q;
    }

    public float getIndicatorCornerRadius() {
        return this.f٧٨٥٩t;
    }

    public float getIndicatorHeight() {
        return this.f٧٨٥٧r;
    }

    public float getIndicatorMarginBottom() {
        return this.f٧٨٦٣x;
    }

    public float getIndicatorMarginLeft() {
        return this.f٧٨٦٠u;
    }

    public float getIndicatorMarginRight() {
        return this.f٧٨٦٢w;
    }

    public float getIndicatorMarginTop() {
        return this.f٧٨٦١v;
    }

    public int getIndicatorStyle() {
        return this.f٧٨٥٢m;
    }

    public float getIndicatorWidth() {
        return this.f٧٨٥٨s;
    }

    public int getTabCount() {
        return this.f٧٨٤٥f;
    }

    public float getTabPadding() {
        return this.f٧٨٥٣n;
    }

    public float getTabWidth() {
        return this.f٧٨٥٥p;
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
        View inflate;
        this.f٧٨٤٠c.removeAllViews();
        this.f٧٨٤٥f = this.f٧٨٣٨b.size();
        for (int i10 = 0; i10 < this.f٧٨٤٥f; i10++) {
            int i11 = this.O;
            if (i11 == 3) {
                inflate = View.inflate(this.f٧٨٣٦a, R.layout.layout_tab_left, null);
            } else if (i11 == 5) {
                inflate = View.inflate(this.f٧٨٣٦a, R.layout.layout_tab_right, null);
            } else if (i11 == 80) {
                inflate = View.inflate(this.f٧٨٣٦a, R.layout.layout_tab_bottom, null);
            } else {
                inflate = View.inflate(this.f٧٨٣٦a, R.layout.layout_tab_top, null);
            }
            inflate.setTag(Integer.valueOf(i10));
            c(i10, inflate);
        }
        l();
    }

    protected int j(float f10) {
        return (int) ((f10 * this.f٧٨٣٦a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View childAt = this.f٧٨٤٠c.getChildAt(this.f٧٨٤٢d);
        b bVar = (b) valueAnimator.getAnimatedValue();
        Rect rect = this.f٧٨٤٦g;
        float f10 = bVar.f٧٨٦٧a;
        rect.left = (int) f10;
        rect.right = (int) bVar.f٧٨٦٨b;
        if (this.f٧٨٥٨s >= DownloadProgress.UNKNOWN_PROGRESS) {
            float width = childAt.getWidth();
            float f11 = this.f٧٨٥٨s;
            float f12 = f10 + ((width - f11) / 2.0f);
            Rect rect2 = this.f٧٨٤٦g;
            int i10 = (int) f12;
            rect2.left = i10;
            rect2.right = (int) (i10 + f11);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f٧٨٤٥f > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            float f10 = this.G;
            if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
                this.f٧٨٤٩j.setStrokeWidth(f10);
                this.f٧٨٤٩j.setColor(this.F);
                for (int i10 = 0; i10 < this.f٧٨٤٥f - 1; i10++) {
                    View childAt = this.f٧٨٤٠c.getChildAt(i10);
                    canvas.drawLine(childAt.getRight() + paddingLeft, this.H, childAt.getRight() + paddingLeft, height - this.H, this.f٧٨٤٩j);
                }
            }
            if (this.D > DownloadProgress.UNKNOWN_PROGRESS) {
                this.f٧٨٤٨i.setColor(this.C);
                if (this.E == 80) {
                    float f11 = height;
                    canvas.drawRect(paddingLeft, f11 - this.D, this.f٧٨٤٠c.getWidth() + paddingLeft, f11, this.f٧٨٤٨i);
                } else {
                    canvas.drawRect(paddingLeft, DownloadProgress.UNKNOWN_PROGRESS, this.f٧٨٤٠c.getWidth() + paddingLeft, this.D, this.f٧٨٤٨i);
                }
            }
            if (this.f٧٨٦٥z) {
                if (this.V) {
                    this.V = false;
                    d();
                }
            } else {
                d();
            }
            int i11 = this.f٧٨٥٢m;
            if (i11 == 1) {
                if (this.f٧٨٥٧r > DownloadProgress.UNKNOWN_PROGRESS) {
                    this.f٧٨٥٠k.setColor(this.f٧٨٥٦q);
                    this.f٧٨٥١l.reset();
                    float f12 = height;
                    this.f٧٨٥١l.moveTo(this.f٧٨٤٦g.left + paddingLeft, f12);
                    Path path = this.f٧٨٥١l;
                    Rect rect = this.f٧٨٤٦g;
                    path.lineTo((rect.left / 2) + paddingLeft + (rect.right / 2), f12 - this.f٧٨٥٧r);
                    this.f٧٨٥١l.lineTo(paddingLeft + this.f٧٨٤٦g.right, f12);
                    this.f٧٨٥١l.close();
                    canvas.drawPath(this.f٧٨٥١l, this.f٧٨٥٠k);
                    return;
                }
                return;
            }
            if (i11 == 2) {
                if (this.f٧٨٥٧r < DownloadProgress.UNKNOWN_PROGRESS) {
                    this.f٧٨٥٧r = (height - this.f٧٨٦١v) - this.f٧٨٦٣x;
                }
                float f13 = this.f٧٨٥٧r;
                if (f13 > DownloadProgress.UNKNOWN_PROGRESS) {
                    float f14 = this.f٧٨٥٩t;
                    if (f14 < DownloadProgress.UNKNOWN_PROGRESS || f14 > f13 / 2.0f) {
                        this.f٧٨٥٩t = f13 / 2.0f;
                    }
                    this.f٧٨٤٧h.setColor(this.f٧٨٥٦q);
                    GradientDrawable gradientDrawable = this.f٧٨٤٧h;
                    int i12 = ((int) this.f٧٨٦٠u) + paddingLeft + this.f٧٨٤٦g.left;
                    float f15 = this.f٧٨٦١v;
                    gradientDrawable.setBounds(i12, (int) f15, (int) ((paddingLeft + r2.right) - this.f٧٨٦٢w), (int) (f15 + this.f٧٨٥٧r));
                    this.f٧٨٤٧h.setCornerRadius(this.f٧٨٥٩t);
                    this.f٧٨٤٧h.draw(canvas);
                    return;
                }
                return;
            }
            if (this.f٧٨٥٧r > DownloadProgress.UNKNOWN_PROGRESS) {
                this.f٧٨٤٧h.setColor(this.f٧٨٥٦q);
                if (this.f٧٨٣٥B == 80) {
                    GradientDrawable gradientDrawable2 = this.f٧٨٤٧h;
                    int i13 = ((int) this.f٧٨٦٠u) + paddingLeft;
                    Rect rect2 = this.f٧٨٤٦g;
                    int i14 = i13 + rect2.left;
                    int i15 = height - ((int) this.f٧٨٥٧r);
                    float f16 = this.f٧٨٦٣x;
                    gradientDrawable2.setBounds(i14, i15 - ((int) f16), (paddingLeft + rect2.right) - ((int) this.f٧٨٦٢w), height - ((int) f16));
                } else {
                    GradientDrawable gradientDrawable3 = this.f٧٨٤٧h;
                    int i16 = ((int) this.f٧٨٦٠u) + paddingLeft;
                    Rect rect3 = this.f٧٨٤٦g;
                    int i17 = i16 + rect3.left;
                    float f17 = this.f٧٨٦١v;
                    gradientDrawable3.setBounds(i17, (int) f17, (paddingLeft + rect3.right) - ((int) this.f٧٨٦٢w), ((int) this.f٧٨٥٧r) + ((int) f17));
                }
                this.f٧٨٤٧h.setCornerRadius(this.f٧٨٥٩t);
                this.f٧٨٤٧h.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f٧٨٤٢d = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.f٧٨٤٢d != 0 && this.f٧٨٤٠c.getChildCount() > 0) {
                k(this.f٧٨٤٢d);
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.f٧٨٤٢d);
        return bundle;
    }

    public void setCurrentTab(int i10) {
        this.f٧٨٤٤e = this.f٧٨٤٢d;
        this.f٧٨٤٢d = i10;
        k(i10);
        if (this.f٧٨٦٥z) {
            e();
        } else {
            invalidate();
        }
    }

    public void setDividerColor(int i10) {
        this.F = i10;
        invalidate();
    }

    public void setDividerPadding(float f10) {
        this.H = f(f10);
        invalidate();
    }

    public void setDividerWidth(float f10) {
        this.G = f(f10);
        invalidate();
    }

    public void setIconGravity(int i10) {
        this.O = i10;
        h();
    }

    public void setIconHeight(float f10) {
        this.Q = f(f10);
        l();
    }

    public void setIconMargin(float f10) {
        this.R = f(f10);
        l();
    }

    public void setIconVisible(boolean z10) {
        this.N = z10;
        l();
    }

    public void setIconWidth(float f10) {
        this.P = f(f10);
        l();
    }

    public void setIndicatorAnimDuration(long j10) {
        this.f٧٨٦٤y = j10;
    }

    public void setIndicatorAnimEnable(boolean z10) {
        this.f٧٨٦٥z = z10;
    }

    public void setIndicatorBounceEnable(boolean z10) {
        this.A = z10;
    }

    public void setIndicatorColor(int i10) {
        this.f٧٨٥٦q = i10;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f10) {
        this.f٧٨٥٩t = f(f10);
        invalidate();
    }

    public void setIndicatorGravity(int i10) {
        this.f٧٨٣٥B = i10;
        invalidate();
    }

    public void setIndicatorHeight(float f10) {
        this.f٧٨٥٧r = f(f10);
        invalidate();
    }

    public void setIndicatorStyle(int i10) {
        this.f٧٨٥٢m = i10;
        invalidate();
    }

    public void setIndicatorWidth(float f10) {
        this.f٧٨٥٨s = f(f10);
        invalidate();
    }

    public void setOnTabSelectListener(o6.b bVar) {
        this.f٧٨٣٩b0 = bVar;
    }

    public void setTabData(ArrayList<o6.a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.f٧٨٣٨b.clear();
            this.f٧٨٣٨b.addAll(arrayList);
            h();
            return;
        }
        throw new IllegalStateException("TabEntitys can not be NULL or EMPTY !");
    }

    public void setTabPadding(float f10) {
        this.f٧٨٥٣n = f(f10);
        l();
    }

    public void setTabSpaceEqual(boolean z10) {
        this.f٧٨٥٤o = z10;
        l();
    }

    public void setTabWidth(float f10) {
        this.f٧٨٥٥p = f(f10);
        l();
    }

    public void setTextAllCaps(boolean z10) {
        this.M = z10;
        l();
    }

    public void setTextBold(int i10) {
        this.L = i10;
        l();
    }

    public void setTextSelectColor(int i10) {
        this.J = i10;
        l();
    }

    public void setTextUnselectColor(int i10) {
        this.K = i10;
        l();
    }

    public void setTextsize(float f10) {
        this.I = j(f10);
        l();
    }

    public void setUnderlineColor(int i10) {
        this.C = i10;
        invalidate();
    }

    public void setUnderlineGravity(int i10) {
        this.E = i10;
        invalidate();
    }

    public void setUnderlineHeight(float f10) {
        this.D = f(f10);
        invalidate();
    }

    public CommonTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTabLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٧٨٣٨b = new ArrayList();
        this.f٧٨٤٦g = new Rect();
        this.f٧٨٤٧h = new GradientDrawable();
        this.f٧٨٤٨i = new Paint(1);
        this.f٧٨٤٩j = new Paint(1);
        this.f٧٨٥٠k = new Paint(1);
        this.f٧٨٥١l = new Path();
        this.f٧٨٥٢m = 0;
        this.U = new OvershootInterpolator(1.5f);
        this.V = true;
        this.W = new Paint(1);
        this.f٧٨٣٧a0 = new SparseArray();
        this.f٧٨٤١c0 = new b();
        this.f٧٨٤٣d0 = new b();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f٧٨٣٦a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f٧٨٤٠c = linearLayout;
        addView(linearLayout);
        i(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.layout_height});
            this.S = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new c(), this.f٧٨٤٣d0, this.f٧٨٤١c0);
        this.T = ofObject;
        ofObject.addUpdateListener(this);
    }
}
