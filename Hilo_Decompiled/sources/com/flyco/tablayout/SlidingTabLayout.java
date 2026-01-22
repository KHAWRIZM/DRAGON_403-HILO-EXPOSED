package com.flyco.tablayout;

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
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Collections;
import o6.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SlidingTabLayout extends HorizontalScrollView implements ViewPager.j {
    private int A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f٧٩٠٣B;
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
    private b T;

    /* renamed from: a, reason: collision with root package name */
    private Context f٧٩٠٤a;

    /* renamed from: b, reason: collision with root package name */
    private ViewPager f٧٩٠٥b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList f٧٩٠٦c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f٧٩٠٧d;

    /* renamed from: e, reason: collision with root package name */
    private int f٧٩٠٨e;

    /* renamed from: f, reason: collision with root package name */
    private float f٧٩٠٩f;

    /* renamed from: g, reason: collision with root package name */
    private int f٧٩١٠g;

    /* renamed from: h, reason: collision with root package name */
    private Rect f٧٩١١h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f٧٩١٢i;

    /* renamed from: j, reason: collision with root package name */
    private GradientDrawable f٧٩١٣j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f٧٩١٤k;

    /* renamed from: l, reason: collision with root package name */
    private Paint f٧٩١٥l;

    /* renamed from: m, reason: collision with root package name */
    private Paint f٧٩١٦m;

    /* renamed from: n, reason: collision with root package name */
    private Path f٧٩١٧n;

    /* renamed from: o, reason: collision with root package name */
    private int f٧٩١٨o;

    /* renamed from: p, reason: collision with root package name */
    private float f٧٩١٩p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f٧٩٢٠q;

    /* renamed from: r, reason: collision with root package name */
    private float f٧٩٢١r;

    /* renamed from: s, reason: collision with root package name */
    private int f٧٩٢٢s;

    /* renamed from: t, reason: collision with root package name */
    private float f٧٩٢٣t;

    /* renamed from: u, reason: collision with root package name */
    private float f٧٩٢٤u;

    /* renamed from: v, reason: collision with root package name */
    private float f٧٩٢٥v;

    /* renamed from: w, reason: collision with root package name */
    private float f٧٩٢٦w;

    /* renamed from: x, reason: collision with root package name */
    private float f٧٩٢٧x;

    /* renamed from: y, reason: collision with root package name */
    private float f٧٩٢٨y;

    /* renamed from: z, reason: collision with root package name */
    private float f٧٩٢٩z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int indexOfChild = SlidingTabLayout.this.f٧٩٠٧d.indexOfChild(view);
            if (indexOfChild != -1) {
                if (SlidingTabLayout.this.f٧٩٠٥b.getCurrentItem() != indexOfChild) {
                    if (SlidingTabLayout.this.P) {
                        SlidingTabLayout.this.f٧٩٠٥b.setCurrentItem(indexOfChild, false);
                    } else {
                        SlidingTabLayout.this.f٧٩٠٥b.setCurrentItem(indexOfChild);
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

    private void e(int i10, String str, View view) {
        LinearLayout.LayoutParams layoutParams;
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        if (textView != null && str != null) {
            textView.setText(str);
        }
        view.setOnClickListener(new a());
        if (this.f٧٩٢٠q) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        if (this.f٧٩٢١r > DownloadProgress.UNKNOWN_PROGRESS) {
            layoutParams = new LinearLayout.LayoutParams((int) this.f٧٩٢١r, -1);
        }
        this.f٧٩٠٧d.addView(view, i10, layoutParams);
    }

    private void f() {
        View childAt = this.f٧٩٠٧d.getChildAt(this.f٧٩٠٨e);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.f٧٩١٨o == 0 && this.f٧٩٠٣B) {
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            this.R.setTextSize(this.I);
            this.Q = ((right - left) - this.R.measureText(textView.getText().toString())) / 2.0f;
        }
        int i10 = this.f٧٩٠٨e;
        if (i10 < this.f٧٩١٠g - 1) {
            View childAt2 = this.f٧٩٠٧d.getChildAt(i10 + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f10 = this.f٧٩٠٩f;
            left += (left2 - left) * f10;
            right += f10 * (right2 - right);
            if (this.f٧٩١٨o == 0 && this.f٧٩٠٣B) {
                TextView textView2 = (TextView) childAt2.findViewById(R.id.tv_tab_title);
                this.R.setTextSize(this.I);
                float measureText = ((right2 - left2) - this.R.measureText(textView2.getText().toString())) / 2.0f;
                float f11 = this.Q;
                this.Q = f11 + (this.f٧٩٠٩f * (measureText - f11));
            }
        }
        Rect rect = this.f٧٩١١h;
        int i11 = (int) left;
        rect.left = i11;
        int i12 = (int) right;
        rect.right = i12;
        if (this.f٧٩١٨o == 0 && this.f٧٩٠٣B) {
            float f12 = this.Q;
            rect.left = (int) ((left + f12) - 1.0f);
            rect.right = (int) ((right - f12) - 1.0f);
        }
        Rect rect2 = this.f٧٩١٢i;
        rect2.left = i11;
        rect2.right = i12;
        if (this.f٧٩٢٤u >= DownloadProgress.UNKNOWN_PROGRESS) {
            float left3 = childAt.getLeft() + ((childAt.getWidth() - this.f٧٩٢٤u) / 2.0f);
            if (this.f٧٩٠٨e < this.f٧٩١٠g - 1) {
                left3 += this.f٧٩٠٩f * ((childAt.getWidth() / 2) + (this.f٧٩٠٧d.getChildAt(r2 + 1).getWidth() / 2));
            }
            Rect rect3 = this.f٧٩١١h;
            int i13 = (int) left3;
            rect3.left = i13;
            rect3.right = (int) (i13 + this.f٧٩٢٤u);
        }
    }

    private void j(Context context, AttributeSet attributeSet) {
        String str;
        int i10;
        float f10;
        float f11;
        float f12;
        float f13;
        int g10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingTabLayout);
        int i11 = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_indicator_style, 0);
        this.f٧٩١٨o = i11;
        int i12 = R.styleable.SlidingTabLayout_tl_indicator_color;
        if (i11 != 2) {
            str = "#ffffff";
        } else {
            str = "#4B6A87";
        }
        this.f٧٩٢٢s = obtainStyledAttributes.getColor(i12, Color.parseColor(str));
        int i13 = R.styleable.SlidingTabLayout_tl_indicator_height;
        int i14 = this.f٧٩١٨o;
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
        this.f٧٩٢٣t = obtainStyledAttributes.getDimension(i13, g(f10));
        int i15 = R.styleable.SlidingTabLayout_tl_indicator_width;
        if (this.f٧٩١٨o == 1) {
            f11 = 10.0f;
        } else {
            f11 = -1.0f;
        }
        this.f٧٩٢٤u = obtainStyledAttributes.getDimension(i15, g(f11));
        int i16 = R.styleable.SlidingTabLayout_tl_indicator_corner_radius;
        if (this.f٧٩١٨o == 2) {
            f12 = -1.0f;
        } else {
            f12 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        this.f٧٩٢٥v = obtainStyledAttributes.getDimension(i16, g(f12));
        this.f٧٩٢٦w = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_left, g(DownloadProgress.UNKNOWN_PROGRESS));
        int i17 = R.styleable.SlidingTabLayout_tl_indicator_margin_top;
        float f14 = 7.0f;
        if (this.f٧٩١٨o == 2) {
            f13 = 7.0f;
        } else {
            f13 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        this.f٧٩٢٧x = obtainStyledAttributes.getDimension(i17, g(f13));
        this.f٧٩٢٨y = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_right, g(DownloadProgress.UNKNOWN_PROGRESS));
        int i18 = R.styleable.SlidingTabLayout_tl_indicator_margin_bottom;
        if (this.f٧٩١٨o != 2) {
            f14 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        this.f٧٩٢٩z = obtainStyledAttributes.getDimension(i18, g(f14));
        this.A = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_indicator_gravity, 80);
        this.f٧٩٠٣B = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_indicator_width_equal_title, false);
        this.C = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_underline_color, Color.parseColor("#ffffff"));
        this.D = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_underline_height, g(DownloadProgress.UNKNOWN_PROGRESS));
        this.E = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_underline_gravity, 80);
        this.F = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_divider_color, Color.parseColor("#ffffff"));
        this.G = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_divider_width, g(DownloadProgress.UNKNOWN_PROGRESS));
        this.H = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_divider_padding, g(12.0f));
        this.I = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_textsize, m(14.0f));
        this.J = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        this.K = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_textUnselectColor, Color.parseColor("#AAffffff"));
        this.L = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_textBold, 0);
        this.M = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_textAllCaps, false);
        this.f٧٩٢٠q = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_tab_space_equal, false);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_tab_width, g(-1.0f));
        this.f٧٩٢١r = dimension;
        int i19 = R.styleable.SlidingTabLayout_tl_tab_padding;
        if (!this.f٧٩٢٠q && dimension <= DownloadProgress.UNKNOWN_PROGRESS) {
            g10 = g(20.0f);
        } else {
            g10 = g(DownloadProgress.UNKNOWN_PROGRESS);
        }
        this.f٧٩١٩p = obtainStyledAttributes.getDimension(i19, g10);
        obtainStyledAttributes.recycle();
    }

    private void k() {
        if (this.f٧٩١٠g <= 0) {
            return;
        }
        int width = (int) (this.f٧٩٠٩f * this.f٧٩٠٧d.getChildAt(this.f٧٩٠٨e).getWidth());
        int left = this.f٧٩٠٧d.getChildAt(this.f٧٩٠٨e).getLeft() + width;
        if (this.f٧٩٠٨e > 0 || width > 0) {
            int width2 = left - ((getWidth() / 2) - getPaddingLeft());
            f();
            Rect rect = this.f٧٩١٢i;
            left = width2 + ((rect.right - rect.left) / 2);
        }
        if (left != this.N) {
            this.N = left;
            scrollTo(left, 0);
        }
    }

    private void n(int i10) {
        boolean z10;
        int i11;
        for (int i12 = 0; i12 < this.f٧٩١٠g; i12++) {
            View childAt = this.f٧٩٠٧d.getChildAt(i12);
            if (i12 == i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (textView != null) {
                if (z10) {
                    i11 = this.J;
                } else {
                    i11 = this.K;
                }
                textView.setTextColor(i11);
                if (this.L == 1) {
                    textView.getPaint().setFakeBoldText(z10);
                }
            }
        }
    }

    private void o() {
        int i10;
        for (int i11 = 0; i11 < this.f٧٩١٠g; i11++) {
            TextView textView = (TextView) this.f٧٩٠٧d.getChildAt(i11).findViewById(R.id.tv_tab_title);
            if (textView != null) {
                if (i11 == this.f٧٩٠٨e) {
                    i10 = this.J;
                } else {
                    i10 = this.K;
                }
                textView.setTextColor(i10);
                textView.setTextSize(0, this.I);
                float f10 = this.f٧٩١٩p;
                textView.setPadding((int) f10, 0, (int) f10, 0);
                if (this.M) {
                    textView.setText(textView.getText().toString().toUpperCase());
                }
                int i12 = this.L;
                if (i12 == 2) {
                    textView.getPaint().setFakeBoldText(true);
                } else if (i12 == 0) {
                    textView.getPaint().setFakeBoldText(false);
                }
            }
        }
    }

    protected int g(float f10) {
        return (int) ((f10 * this.f٧٩٠٤a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getCurrentTab() {
        return this.f٧٩٠٨e;
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
        return this.f٧٩٢٢s;
    }

    public float getIndicatorCornerRadius() {
        return this.f٧٩٢٥v;
    }

    public float getIndicatorHeight() {
        return this.f٧٩٢٣t;
    }

    public float getIndicatorMarginBottom() {
        return this.f٧٩٢٩z;
    }

    public float getIndicatorMarginLeft() {
        return this.f٧٩٢٦w;
    }

    public float getIndicatorMarginRight() {
        return this.f٧٩٢٨y;
    }

    public float getIndicatorMarginTop() {
        return this.f٧٩٢٧x;
    }

    public int getIndicatorStyle() {
        return this.f٧٩١٨o;
    }

    public float getIndicatorWidth() {
        return this.f٧٩٢٤u;
    }

    public int getTabCount() {
        return this.f٧٩١٠g;
    }

    public float getTabPadding() {
        return this.f٧٩١٩p;
    }

    public float getTabWidth() {
        return this.f٧٩٢١r;
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

    public TextView h(int i10) {
        return (TextView) this.f٧٩٠٧d.getChildAt(i10).findViewById(R.id.tv_tab_title);
    }

    public void i() {
        int size;
        CharSequence charSequence;
        this.f٧٩٠٧d.removeAllViews();
        ArrayList arrayList = this.f٧٩٠٦c;
        if (arrayList == null) {
            size = this.f٧٩٠٥b.getAdapter().getCount();
        } else {
            size = arrayList.size();
        }
        this.f٧٩١٠g = size;
        for (int i10 = 0; i10 < this.f٧٩١٠g; i10++) {
            View inflate = View.inflate(this.f٧٩٠٤a, R.layout.layout_tab, null);
            ArrayList arrayList2 = this.f٧٩٠٦c;
            if (arrayList2 == null) {
                charSequence = this.f٧٩٠٥b.getAdapter().getPageTitle(i10);
            } else {
                charSequence = (CharSequence) arrayList2.get(i10);
            }
            e(i10, charSequence.toString(), inflate);
        }
        o();
    }

    public void l(ViewPager viewPager, String[] strArr) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            if (strArr != null && strArr.length != 0) {
                if (strArr.length == viewPager.getAdapter().getCount()) {
                    this.f٧٩٠٥b = viewPager;
                    ArrayList arrayList = new ArrayList();
                    this.f٧٩٠٦c = arrayList;
                    Collections.addAll(arrayList, strArr);
                    this.f٧٩٠٥b.removeOnPageChangeListener(this);
                    this.f٧٩٠٥b.addOnPageChangeListener(this);
                    i();
                    return;
                }
                throw new IllegalStateException("Titles length must be the same as the page count !");
            }
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
    }

    protected int m(float f10) {
        return (int) ((f10 * this.f٧٩٠٤a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f٧٩١٠g > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            float f10 = this.G;
            if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
                this.f٧٩١٥l.setStrokeWidth(f10);
                this.f٧٩١٥l.setColor(this.F);
                for (int i10 = 0; i10 < this.f٧٩١٠g - 1; i10++) {
                    View childAt = this.f٧٩٠٧d.getChildAt(i10);
                    canvas.drawLine(childAt.getRight() + paddingLeft, this.H, childAt.getRight() + paddingLeft, height - this.H, this.f٧٩١٥l);
                }
            }
            if (this.D > DownloadProgress.UNKNOWN_PROGRESS) {
                this.f٧٩١٤k.setColor(this.C);
                if (this.E == 80) {
                    float f11 = height;
                    canvas.drawRect(paddingLeft, f11 - this.D, this.f٧٩٠٧d.getWidth() + paddingLeft, f11, this.f٧٩١٤k);
                } else {
                    canvas.drawRect(paddingLeft, DownloadProgress.UNKNOWN_PROGRESS, this.f٧٩٠٧d.getWidth() + paddingLeft, this.D, this.f٧٩١٤k);
                }
            }
            f();
            int i11 = this.f٧٩١٨o;
            if (i11 == 1) {
                if (this.f٧٩٢٣t > DownloadProgress.UNKNOWN_PROGRESS) {
                    this.f٧٩١٦m.setColor(this.f٧٩٢٢s);
                    this.f٧٩١٧n.reset();
                    float f12 = height;
                    this.f٧٩١٧n.moveTo(this.f٧٩١١h.left + paddingLeft, f12);
                    Path path = this.f٧٩١٧n;
                    Rect rect = this.f٧٩١١h;
                    path.lineTo((rect.left / 2) + paddingLeft + (rect.right / 2), f12 - this.f٧٩٢٣t);
                    this.f٧٩١٧n.lineTo(paddingLeft + this.f٧٩١١h.right, f12);
                    this.f٧٩١٧n.close();
                    canvas.drawPath(this.f٧٩١٧n, this.f٧٩١٦m);
                    return;
                }
                return;
            }
            if (i11 == 2) {
                if (this.f٧٩٢٣t < DownloadProgress.UNKNOWN_PROGRESS) {
                    this.f٧٩٢٣t = (height - this.f٧٩٢٧x) - this.f٧٩٢٩z;
                }
                float f13 = this.f٧٩٢٣t;
                if (f13 > DownloadProgress.UNKNOWN_PROGRESS) {
                    float f14 = this.f٧٩٢٥v;
                    if (f14 < DownloadProgress.UNKNOWN_PROGRESS || f14 > f13 / 2.0f) {
                        this.f٧٩٢٥v = f13 / 2.0f;
                    }
                    this.f٧٩١٣j.setColor(this.f٧٩٢٢s);
                    GradientDrawable gradientDrawable = this.f٧٩١٣j;
                    int i12 = ((int) this.f٧٩٢٦w) + paddingLeft + this.f٧٩١١h.left;
                    float f15 = this.f٧٩٢٧x;
                    gradientDrawable.setBounds(i12, (int) f15, (int) ((paddingLeft + r2.right) - this.f٧٩٢٨y), (int) (f15 + this.f٧٩٢٣t));
                    this.f٧٩١٣j.setCornerRadius(this.f٧٩٢٥v);
                    this.f٧٩١٣j.draw(canvas);
                    return;
                }
                return;
            }
            if (this.f٧٩٢٣t > DownloadProgress.UNKNOWN_PROGRESS) {
                this.f٧٩١٣j.setColor(this.f٧٩٢٢s);
                if (this.A == 80) {
                    GradientDrawable gradientDrawable2 = this.f٧٩١٣j;
                    int i13 = ((int) this.f٧٩٢٦w) + paddingLeft;
                    Rect rect2 = this.f٧٩١١h;
                    int i14 = i13 + rect2.left;
                    int i15 = height - ((int) this.f٧٩٢٣t);
                    float f16 = this.f٧٩٢٩z;
                    gradientDrawable2.setBounds(i14, i15 - ((int) f16), (paddingLeft + rect2.right) - ((int) this.f٧٩٢٨y), height - ((int) f16));
                } else {
                    GradientDrawable gradientDrawable3 = this.f٧٩١٣j;
                    int i16 = ((int) this.f٧٩٢٦w) + paddingLeft;
                    Rect rect3 = this.f٧٩١١h;
                    int i17 = i16 + rect3.left;
                    float f17 = this.f٧٩٢٧x;
                    gradientDrawable3.setBounds(i17, (int) f17, (paddingLeft + rect3.right) - ((int) this.f٧٩٢٨y), ((int) this.f٧٩٢٣t) + ((int) f17));
                }
                this.f٧٩١٣j.setCornerRadius(this.f٧٩٢٥v);
                this.f٧٩١٣j.draw(canvas);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrolled(int i10, float f10, int i11) {
        this.f٧٩٠٨e = i10;
        this.f٧٩٠٩f = f10;
        k();
        invalidate();
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageSelected(int i10) {
        n(i10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f٧٩٠٨e = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.f٧٩٠٨e != 0 && this.f٧٩٠٧d.getChildCount() > 0) {
                n(this.f٧٩٠٨e);
                k();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.f٧٩٠٨e);
        return bundle;
    }

    public void setCurrentTab(int i10) {
        this.f٧٩٠٨e = i10;
        this.f٧٩٠٥b.setCurrentItem(i10);
    }

    public void setDividerColor(int i10) {
        this.F = i10;
        invalidate();
    }

    public void setDividerPadding(float f10) {
        this.H = g(f10);
        invalidate();
    }

    public void setDividerWidth(float f10) {
        this.G = g(f10);
        invalidate();
    }

    public void setIndicatorColor(int i10) {
        this.f٧٩٢٢s = i10;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f10) {
        this.f٧٩٢٥v = g(f10);
        invalidate();
    }

    public void setIndicatorGravity(int i10) {
        this.A = i10;
        invalidate();
    }

    public void setIndicatorHeight(float f10) {
        this.f٧٩٢٣t = g(f10);
        invalidate();
    }

    public void setIndicatorStyle(int i10) {
        this.f٧٩١٨o = i10;
        invalidate();
    }

    public void setIndicatorWidth(float f10) {
        this.f٧٩٢٤u = g(f10);
        invalidate();
    }

    public void setIndicatorWidthEqualTitle(boolean z10) {
        this.f٧٩٠٣B = z10;
        invalidate();
    }

    public void setOnTabSelectListener(b bVar) {
        this.T = bVar;
    }

    public void setSnapOnTabClick(boolean z10) {
        this.P = z10;
    }

    public void setTabPadding(float f10) {
        this.f٧٩١٩p = g(f10);
        o();
    }

    public void setTabSpaceEqual(boolean z10) {
        this.f٧٩٢٠q = z10;
        o();
    }

    public void setTabWidth(float f10) {
        this.f٧٩٢١r = g(f10);
        o();
    }

    public void setTextAllCaps(boolean z10) {
        this.M = z10;
        o();
    }

    public void setTextBold(int i10) {
        this.L = i10;
        o();
    }

    public void setTextSelectColor(int i10) {
        this.J = i10;
        o();
    }

    public void setTextUnselectColor(int i10) {
        this.K = i10;
        o();
    }

    public void setTextsize(float f10) {
        this.I = m(f10);
        o();
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
        this.D = g(f10);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.f٧٩٠٥b = viewPager;
            viewPager.removeOnPageChangeListener(this);
            this.f٧٩٠٥b.addOnPageChangeListener(this);
            i();
            return;
        }
        throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٧٩١١h = new Rect();
        this.f٧٩١٢i = new Rect();
        this.f٧٩١٣j = new GradientDrawable();
        this.f٧٩١٤k = new Paint(1);
        this.f٧٩١٥l = new Paint(1);
        this.f٧٩١٦m = new Paint(1);
        this.f٧٩١٧n = new Path();
        this.f٧٩١٨o = 0;
        this.R = new Paint(1);
        this.S = new SparseArray();
        setFillViewport(true);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f٧٩٠٤a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f٧٩٠٧d = linearLayout;
        addView(linearLayout);
        j(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (attributeValue.equals("-1") || attributeValue.equals("-2")) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.layout_height});
        this.O = obtainStyledAttributes.getDimensionPixelSize(0, -2);
        obtainStyledAttributes.recycle();
    }
}
