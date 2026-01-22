package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.collection.SimpleArrayMap;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;
import dc.c;
import dc.e;
import ic.i;
import ic.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUITopBar extends QMUIRelativeLayout implements c, fc.a {
    private static SimpleArrayMap H;
    private ColorStateList A;

    /* renamed from: B, reason: collision with root package name */
    private int f١٣٠٧٩B;
    private Typeface C;
    private int D;
    private Rect E;
    private boolean F;
    private TextUtils.TruncateAt G;

    /* renamed from: c, reason: collision with root package name */
    private int f١٣٠٨٠c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٣٠٨١d;

    /* renamed from: e, reason: collision with root package name */
    private View f١٣٠٨٢e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f١٣٠٨٣f;

    /* renamed from: g, reason: collision with root package name */
    private QMUIQQFaceView f١٣٠٨٤g;

    /* renamed from: h, reason: collision with root package name */
    private QMUISpanTouchFixTextView f١٣٠٨٥h;

    /* renamed from: i, reason: collision with root package name */
    private List f١٣٠٨٦i;

    /* renamed from: j, reason: collision with root package name */
    private List f١٣٠٨٧j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٣٠٨٨k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٣٠٨٩l;

    /* renamed from: m, reason: collision with root package name */
    private int f١٣٠٩٠m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٣٠٩١n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٣٠٩٢o;

    /* renamed from: p, reason: collision with root package name */
    private Typeface f١٣٠٩٣p;

    /* renamed from: q, reason: collision with root package name */
    private Typeface f١٣٠٩٤q;

    /* renamed from: r, reason: collision with root package name */
    private int f١٣٠٩٥r;

    /* renamed from: s, reason: collision with root package name */
    private int f١٣٠٩٦s;

    /* renamed from: t, reason: collision with root package name */
    private int f١٣٠٩٧t;

    /* renamed from: u, reason: collision with root package name */
    private int f١٣٠٩٨u;

    /* renamed from: v, reason: collision with root package name */
    private int f١٣٠٩٩v;

    /* renamed from: w, reason: collision with root package name */
    private int f١٣١٠٠w;

    /* renamed from: x, reason: collision with root package name */
    private int f١٣١٠١x;

    /* renamed from: y, reason: collision with root package name */
    private int f١٣١٠٢y;

    /* renamed from: z, reason: collision with root package name */
    private int f١٣١٠٣z;

    static {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(4);
        H = simpleArrayMap;
        simpleArrayMap.put("bottomSeparator", Integer.valueOf(R.attr.qmui_skin_support_topbar_separator_color));
        H.put("background", Integer.valueOf(R.attr.qmui_skin_support_topbar_bg));
    }

    public QMUITopBar(Context context) {
        this(context, null);
    }

    private RelativeLayout.LayoutParams g() {
        return new RelativeLayout.LayoutParams(-1, i.e(getContext(), R.attr.qmui_topbar_height));
    }

    private void h() {
        this.f١٣٠٨٠c = -1;
        this.f١٣٠٨١d = -1;
        this.f١٣٠٨٦i = new ArrayList();
        this.f١٣٠٨٧j = new ArrayList();
    }

    private LinearLayout k() {
        if (this.f١٣٠٨٣f == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f١٣٠٨٣f = linearLayout;
            linearLayout.setOrientation(1);
            this.f١٣٠٨٣f.setGravity(17);
            LinearLayout linearLayout2 = this.f١٣٠٨٣f;
            int i10 = this.f١٣١٠٠w;
            linearLayout2.setPadding(i10, 0, i10, 0);
            addView(this.f١٣٠٨٣f, g());
        }
        return this.f١٣٠٨٣f;
    }

    @Override // dc.c
    public void a(e eVar, int i10, Resources.Theme theme, SimpleArrayMap simpleArrayMap) {
        if (simpleArrayMap != null) {
            for (int i11 = 0; i11 < simpleArrayMap.getSize(); i11++) {
                String str = (String) simpleArrayMap.keyAt(i11);
                Integer num = (Integer) simpleArrayMap.valueAt(i11);
                if (num != null && (!(getParent() instanceof QMUITopBarLayout) || (!"background".equals(str) && !"bottomSeparator".equals(str)))) {
                    eVar.c(this, theme, str, num.intValue());
                }
            }
        }
    }

    void b(Context context, AttributeSet attributeSet, int i10) {
        Typeface typeface;
        Typeface typeface2;
        Typeface typeface3;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUITopBar, i10, 0);
        this.f١٣٠٨٩l = obtainStyledAttributes.getResourceId(R.styleable.QMUITopBar_qmui_topbar_left_back_drawable_id, R.drawable.qmui_icon_topbar_back);
        this.f١٣٠٩٠m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_left_back_width, -1);
        this.f١٣٠٩١n = obtainStyledAttributes.getBoolean(R.styleable.QMUITopBar_qmui_topbar_clear_left_padding_when_add_left_back_view, false);
        this.f١٣٠٨٨k = obtainStyledAttributes.getInt(R.styleable.QMUITopBar_qmui_topbar_title_gravity, 17);
        this.f١٣٠٩٢o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_text_size, ic.e.k(context, 17));
        this.f١٣٠٩٥r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_text_size_with_subtitle, ic.e.k(context, 16));
        this.f١٣٠٩٦s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_subtitle_text_size, ic.e.k(context, 11));
        this.f١٣٠٩٧t = obtainStyledAttributes.getColor(R.styleable.QMUITopBar_qmui_topbar_title_color, i.b(context, R.attr.qmui_config_color_gray_1));
        this.f١٣٠٩٨u = obtainStyledAttributes.getColor(R.styleable.QMUITopBar_qmui_topbar_subtitle_color, i.b(context, R.attr.qmui_config_color_gray_4));
        this.f١٣٠٩٩v = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_margin_horizontal_when_no_btn_aside, 0);
        this.f١٣١٠٠w = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_container_padding_horizontal, 0);
        this.f١٣١٠١x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_image_btn_width, ic.e.a(context, 48));
        this.f١٣١٠٢y = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_image_btn_height, ic.e.a(context, 48));
        this.f١٣١٠٣z = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_text_btn_padding_horizontal, ic.e.a(context, 12));
        this.A = obtainStyledAttributes.getColorStateList(R.styleable.QMUITopBar_qmui_topbar_text_btn_color_state_list);
        this.f١٣٠٧٩B = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_text_btn_text_size, ic.e.k(context, 16));
        if (obtainStyledAttributes.getBoolean(R.styleable.QMUITopBar_qmui_topbar_title_bold, false)) {
            typeface = Typeface.DEFAULT_BOLD;
        } else {
            typeface = null;
        }
        this.f١٣٠٩٣p = typeface;
        if (obtainStyledAttributes.getBoolean(R.styleable.QMUITopBar_qmui_topbar_subtitle_bold, false)) {
            typeface2 = Typeface.DEFAULT_BOLD;
        } else {
            typeface2 = null;
        }
        this.f١٣٠٩٤q = typeface2;
        if (obtainStyledAttributes.getBoolean(R.styleable.QMUITopBar_qmui_topbar_text_btn_bold, false)) {
            typeface3 = Typeface.DEFAULT_BOLD;
        } else {
            typeface3 = null;
        }
        this.C = typeface3;
        int i11 = obtainStyledAttributes.getInt(R.styleable.QMUITopBar_android_ellipsize, -1);
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    this.G = null;
                } else {
                    this.G = TextUtils.TruncateAt.END;
                }
            } else {
                this.G = TextUtils.TruncateAt.MIDDLE;
            }
        } else {
            this.G = TextUtils.TruncateAt.START;
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.F = true;
        super.setBackgroundDrawable(null);
    }

    @Override // fc.a
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return H;
    }

    public QMUISpanTouchFixTextView getSubTitleView() {
        return this.f١٣٠٨٥h;
    }

    public CharSequence getTitle() {
        QMUIQQFaceView qMUIQQFaceView = this.f١٣٠٨٤g;
        if (qMUIQQFaceView == null) {
            return null;
        }
        return qMUIQQFaceView.getText();
    }

    public Rect getTitleContainerRect() {
        if (this.E == null) {
            this.E = new Rect();
        }
        LinearLayout linearLayout = this.f١٣٠٨٣f;
        if (linearLayout == null) {
            this.E.set(0, 0, 0, 0);
        } else {
            k.c(this, linearLayout, this.E);
        }
        return this.E;
    }

    public LinearLayout getTitleContainerView() {
        return this.f١٣٠٨٣f;
    }

    public QMUIQQFaceView getTitleView() {
        return this.f١٣٠٨٤g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTopBarHeight() {
        if (this.D == -1) {
            this.D = i.e(getContext(), R.attr.qmui_topbar_height);
        }
        return this.D;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof QMUICollapsingTopBarLayout) {
                k();
                return;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int max;
        super.onLayout(z10, i10, i11, i12, i13);
        LinearLayout linearLayout = this.f١٣٠٨٣f;
        if (linearLayout != null) {
            int measuredWidth = linearLayout.getMeasuredWidth();
            int measuredHeight = this.f١٣٠٨٣f.getMeasuredHeight();
            int measuredHeight2 = ((i13 - i11) - this.f١٣٠٨٣f.getMeasuredHeight()) / 2;
            int paddingLeft = getPaddingLeft();
            if ((this.f١٣٠٨٨k & 7) == 1) {
                max = ((i12 - i10) - this.f١٣٠٨٣f.getMeasuredWidth()) / 2;
            } else {
                for (int i14 = 0; i14 < this.f١٣٠٨٦i.size(); i14++) {
                    View view = (View) this.f١٣٠٨٦i.get(i14);
                    if (view.getVisibility() != 8) {
                        paddingLeft += view.getMeasuredWidth();
                    }
                }
                max = Math.max(paddingLeft, this.f١٣٠٩٩v);
            }
            this.f١٣٠٨٣f.layout(max, measuredHeight2, measuredWidth + max, measuredHeight + measuredHeight2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.layout.QMUIRelativeLayout, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int size;
        super.onMeasure(i10, i11);
        if (this.f١٣٠٨٣f != null) {
            int paddingLeft = getPaddingLeft();
            for (int i12 = 0; i12 < this.f١٣٠٨٦i.size(); i12++) {
                View view = (View) this.f١٣٠٨٦i.get(i12);
                if (view.getVisibility() != 8) {
                    paddingLeft += view.getMeasuredWidth();
                }
            }
            int paddingRight = getPaddingRight();
            for (int i13 = 0; i13 < this.f١٣٠٨٧j.size(); i13++) {
                View view2 = (View) this.f١٣٠٨٧j.get(i13);
                if (view2.getVisibility() != 8) {
                    paddingRight += view2.getMeasuredWidth();
                }
            }
            int max = Math.max(this.f١٣٠٩٩v, paddingLeft);
            int max2 = Math.max(this.f١٣٠٩٩v, paddingRight);
            if ((this.f١٣٠٨٨k & 7) == 1) {
                size = View.MeasureSpec.getSize(i10) - (Math.max(max, max2) * 2);
            } else {
                size = (View.MeasureSpec.getSize(i10) - max) - max2;
            }
            this.f١٣٠٨٣f.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i11);
        }
    }

    public void setBackgroundAlpha(int i10) {
        getBackground().mutate().setAlpha(i10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!this.F) {
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setCenterView(View view) {
        View view2 = this.f١٣٠٨٢e;
        if (view2 == view) {
            return;
        }
        if (view2 != null) {
            removeView(view2);
        }
        this.f١٣٠٨٢e = view;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(13);
        addView(view, layoutParams);
    }

    public void setTitleGravity(int i10) {
        this.f١٣٠٨٨k = i10;
        QMUIQQFaceView qMUIQQFaceView = this.f١٣٠٨٤g;
        if (qMUIQQFaceView != null) {
            ((LinearLayout.LayoutParams) qMUIQQFaceView.getLayoutParams()).gravity = i10;
            if (i10 == 17 || i10 == 1) {
                this.f١٣٠٨٤g.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingBottom());
            }
        }
        QMUISpanTouchFixTextView qMUISpanTouchFixTextView = this.f١٣٠٨٥h;
        if (qMUISpanTouchFixTextView != null) {
            ((LinearLayout.LayoutParams) qMUISpanTouchFixTextView.getLayoutParams()).gravity = i10;
        }
        requestLayout();
    }

    public QMUITopBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUITopBarStyle);
    }

    public QMUITopBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.D = -1;
        this.F = false;
        h();
        b(context, attributeSet, i10);
    }
}
