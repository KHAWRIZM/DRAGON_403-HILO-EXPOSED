package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.u0;
import androidx.core.widget.l;
import com.google.android.material.internal.BaselineLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import m2.g0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class NavigationBarItemView extends FrameLayout implements h {

    /* renamed from: j0, reason: collision with root package name */
    private static final int[] f٩٤١٨j0 = {R.attr.state_checked};

    /* renamed from: k0, reason: collision with root package name */
    private static final c f٩٤١٩k0;

    /* renamed from: l0, reason: collision with root package name */
    private static final c f٩٤٢٠l0;
    private BaselineLayout A;

    /* renamed from: B, reason: collision with root package name */
    private int f٩٤٢١B;
    private int C;
    private int D;
    private int E;
    private int F;
    private ColorStateList G;
    private boolean H;
    private androidx.appcompat.view.menu.i I;
    private ColorStateList J;
    private Drawable K;
    private Drawable L;
    private ValueAnimator M;
    private c N;
    private float O;
    private boolean P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private int V;
    private int W;

    /* renamed from: a, reason: collision with root package name */
    private boolean f٩٤٢٢a;

    /* renamed from: a0, reason: collision with root package name */
    private com.google.android.material.badge.a f٩٤٢٣a0;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f٩٤٢٤b;

    /* renamed from: b0, reason: collision with root package name */
    private int f٩٤٢٥b0;

    /* renamed from: c, reason: collision with root package name */
    Drawable f٩٤٢٦c;

    /* renamed from: c0, reason: collision with root package name */
    private int f٩٤٢٧c0;

    /* renamed from: d, reason: collision with root package name */
    private int f٩٤٢٨d;

    /* renamed from: d0, reason: collision with root package name */
    private int f٩٤٢٩d0;

    /* renamed from: e, reason: collision with root package name */
    private int f٩٤٣٠e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f٩٤٣١e0;

    /* renamed from: f, reason: collision with root package name */
    private int f٩٤٣٢f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f٩٤٣٣f0;

    /* renamed from: g, reason: collision with root package name */
    private int f٩٤٣٤g;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f٩٤٣٥g0;

    /* renamed from: h, reason: collision with root package name */
    private float f٩٤٣٦h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f٩٤٣٧h0;

    /* renamed from: i, reason: collision with root package name */
    private float f٩٤٣٨i;

    /* renamed from: i0, reason: collision with root package name */
    private Rect f٩٤٣٩i0;

    /* renamed from: j, reason: collision with root package name */
    private float f٩٤٤٠j;

    /* renamed from: k, reason: collision with root package name */
    private float f٩٤٤١k;

    /* renamed from: l, reason: collision with root package name */
    private float f٩٤٤٢l;

    /* renamed from: m, reason: collision with root package name */
    private float f٩٤٤٣m;

    /* renamed from: n, reason: collision with root package name */
    private int f٩٤٤٤n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٩٤٤٥o;

    /* renamed from: p, reason: collision with root package name */
    private final LinearLayout f٩٤٤٦p;

    /* renamed from: q, reason: collision with root package name */
    private final LinearLayout f٩٤٤٧q;

    /* renamed from: r, reason: collision with root package name */
    private final View f٩٤٤٨r;

    /* renamed from: s, reason: collision with root package name */
    private final FrameLayout f٩٤٤٩s;

    /* renamed from: t, reason: collision with root package name */
    private final ImageView f٩٤٥٠t;

    /* renamed from: u, reason: collision with root package name */
    private final BaselineLayout f٩٤٥١u;

    /* renamed from: v, reason: collision with root package name */
    private final TextView f٩٤٥٢v;

    /* renamed from: w, reason: collision with root package name */
    private final TextView f٩٤٥٣w;

    /* renamed from: x, reason: collision with root package name */
    private BaselineLayout f٩٤٥٤x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f٩٤٥٥y;

    /* renamed from: z, reason: collision with root package name */
    private TextView f٩٤٥٦z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f٩٤٥٧a;

        a(int i10) {
            this.f٩٤٥٧a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            NavigationBarItemView.this.B(this.f٩٤٥٧a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f٩٤٥٩a;

        b(float f10) {
            this.f٩٤٥٩a = f10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NavigationBarItemView.this.q(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f٩٤٥٩a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c {
        private c() {
        }

        protected float a(float f10, float f11) {
            float f12;
            float f13;
            if (f11 == DownloadProgress.UNKNOWN_PROGRESS) {
                f12 = 0.8f;
            } else {
                f12 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            if (f11 == DownloadProgress.UNKNOWN_PROGRESS) {
                f13 = 1.0f;
            } else {
                f13 = 0.2f;
            }
            return p7.a.b(DownloadProgress.UNKNOWN_PROGRESS, 1.0f, f12, f13, f10);
        }

        protected float b(float f10) {
            return p7.a.a(0.4f, 1.0f, f10);
        }

        protected float c(float f10) {
            return 1.0f;
        }

        public void d(float f10, float f11, View view) {
            view.setScaleX(b(f10));
            view.setScaleY(c(f10));
            view.setAlpha(a(f10, f11));
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class d extends c {
        private d() {
            super(null);
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.c
        protected float c(float f10) {
            return b(f10);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f٩٤١٩k0 = new c(aVar);
        f٩٤٢٠l0 = new d(aVar);
    }

    public NavigationBarItemView(Context context) {
        super(context);
        this.f٩٤٢٢a = false;
        this.f٩٤٢١B = -1;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.H = false;
        this.N = f٩٤١٩k0;
        this.O = DownloadProgress.UNKNOWN_PROGRESS;
        this.P = false;
        this.Q = 0;
        this.R = 0;
        this.S = -2;
        this.T = 0;
        this.U = false;
        this.V = 0;
        this.W = 0;
        this.f٩٤٢٧c0 = 0;
        this.f٩٤٢٩d0 = 49;
        this.f٩٤٣١e0 = false;
        this.f٩٤٣٣f0 = false;
        this.f٩٤٣٥g0 = false;
        this.f٩٤٣٧h0 = false;
        this.f٩٤٣٩i0 = new Rect();
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f٩٤٤٦p = (LinearLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_content_container);
        LinearLayout linearLayout = (LinearLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_inner_content_container);
        this.f٩٤٤٧q = linearLayout;
        this.f٩٤٤٨r = findViewById(com.google.android.material.R.id.navigation_bar_item_active_indicator_view);
        this.f٩٤٤٩s = (FrameLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_container);
        this.f٩٤٥٠t = (ImageView) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view);
        BaselineLayout baselineLayout = (BaselineLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_labels_group);
        this.f٩٤٥١u = baselineLayout;
        TextView textView = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_small_label_view);
        this.f٩٤٥٢v = textView;
        TextView textView2 = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_large_label_view);
        this.f٩٤٥٣w = textView2;
        j();
        this.A = baselineLayout;
        setBackgroundResource(getItemBackgroundResId());
        this.f٩٤٢٨d = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f٩٤٣٠e = baselineLayout.getPaddingBottom();
        this.f٩٤٣٢f = 0;
        this.f٩٤٣٤g = 0;
        textView.setImportantForAccessibility(2);
        textView2.setImportantForAccessibility(2);
        this.f٩٤٥٥y.setImportantForAccessibility(2);
        this.f٩٤٥٦z.setImportantForAccessibility(2);
        setFocusable(true);
        d();
        this.T = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.m3_navigation_item_expanded_active_indicator_height_default);
        linearLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.navigation.e
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                NavigationBarItemView.this.l(view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
    }

    private void A(View view) {
        if (!i()) {
            return;
        }
        com.google.android.material.badge.b.f(this.f٩٤٢٣a0, view, null);
    }

    private void C() {
        if (k()) {
            this.N = f٩٤٢٠l0;
        } else {
            this.N = f٩٤١٩k0;
        }
    }

    private void D() {
        TextView textView = this.f٩٤٥٣w;
        textView.setTypeface(textView.getTypeface(), this.H ? 1 : 0);
        TextView textView2 = this.f٩٤٥٦z;
        textView2.setTypeface(textView2.getTypeface(), this.H ? 1 : 0);
    }

    private void E(TextView textView, int i10) {
        if (textView == null) {
            return;
        }
        u(textView, i10);
        d();
        textView.setMinimumHeight(c8.c.i(textView.getContext(), i10, 0));
        ColorStateList colorStateList = this.G;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
        D();
    }

    private void F(TextView textView, int i10) {
        if (textView == null) {
            return;
        }
        u(textView, i10);
        d();
        textView.setMinimumHeight(c8.c.i(textView.getContext(), i10, 0));
        ColorStateList colorStateList = this.G;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private void G() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        this.f٩٤٢٧c0 = 0;
        this.A = this.f٩٤٥١u;
        int i16 = 8;
        if (this.f٩٤٢٥b0 == 1) {
            if (this.f٩٤٥٤x.getParent() == null) {
                c();
            }
            Rect rect = this.f٩٤٣٩i0;
            int i17 = rect.left;
            int i18 = rect.right;
            int i19 = rect.top;
            i10 = rect.bottom;
            this.f٩٤٢٧c0 = 1;
            int i20 = this.W;
            this.A = this.f٩٤٥٤x;
            i15 = i19;
            i14 = i18;
            i13 = i17;
            i12 = i20;
            i11 = 0;
        } else {
            i10 = 0;
            i16 = 0;
            i11 = 8;
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i15 = 0;
        }
        this.f٩٤٥١u.setVisibility(i16);
        this.f٩٤٥٤x.setVisibility(i11);
        ((FrameLayout.LayoutParams) this.f٩٤٤٦p.getLayoutParams()).gravity = this.f٩٤٢٩d0;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f٩٤٤٧q.getLayoutParams();
        layoutParams.leftMargin = i13;
        layoutParams.rightMargin = i14;
        layoutParams.topMargin = i15;
        layoutParams.bottomMargin = i10;
        setPadding(i12, 0, i12, 0);
        B(getWidth());
    }

    private static void H(View view, int i10) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10);
    }

    private void I() {
        int i10;
        androidx.appcompat.view.menu.i iVar = this.I;
        if (iVar != null) {
            if (iVar.isVisible() && (this.f٩٤٣١e0 || !this.f٩٤٣٣f0)) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            setVisibility(i10);
        }
    }

    private void c() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f٩٤٤٧q.addView(this.f٩٤٥٤x, layoutParams);
        r();
    }

    private void d() {
        float textSize = this.f٩٤٥٢v.getTextSize();
        float textSize2 = this.f٩٤٥٣w.getTextSize();
        this.f٩٤٣٦h = textSize - textSize2;
        this.f٩٤٣٨i = (textSize2 * 1.0f) / textSize;
        this.f٩٤٤٠j = (textSize * 1.0f) / textSize2;
        float textSize3 = this.f٩٤٥٥y.getTextSize();
        float textSize4 = this.f٩٤٥٦z.getTextSize();
        this.f٩٤٤١k = textSize3 - textSize4;
        this.f٩٤٤٢l = (textSize4 * 1.0f) / textSize3;
        this.f٩٤٤٣m = (textSize3 * 1.0f) / textSize4;
    }

    private static Drawable f(ColorStateList colorStateList) {
        return new RippleDrawable(d8.a.a(colorStateList), null, null);
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i10 = 0;
        for (int i11 = 0; i11 < indexOfChild; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i10++;
            }
        }
        return i10;
    }

    private int getSuggestedIconWidth() {
        int minimumWidth;
        com.google.android.material.badge.a aVar = this.f٩٤٢٣a0;
        if (aVar == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = aVar.getMinimumWidth() - this.f٩٤٢٣a0.m();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f٩٤٤٩s.getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f٩٤٥٠t.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private boolean i() {
        if (this.f٩٤٢٣a0 != null) {
            return true;
        }
        return false;
    }

    private void j() {
        float dimension = getResources().getDimension(com.google.android.material.R.dimen.default_navigation_text_size);
        float dimension2 = getResources().getDimension(com.google.android.material.R.dimen.default_navigation_active_text_size);
        BaselineLayout baselineLayout = new BaselineLayout(getContext());
        this.f٩٤٥٤x = baselineLayout;
        baselineLayout.setVisibility(8);
        this.f٩٤٥٤x.setDuplicateParentStateEnabled(true);
        this.f٩٤٥٤x.setMeasurePaddingFromBaseline(this.f٩٤٣٥g0);
        TextView textView = new TextView(getContext());
        this.f٩٤٥٥y = textView;
        textView.setMaxLines(1);
        TextView textView2 = this.f٩٤٥٥y;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView2.setEllipsize(truncateAt);
        this.f٩٤٥٥y.setDuplicateParentStateEnabled(true);
        this.f٩٤٥٥y.setIncludeFontPadding(false);
        this.f٩٤٥٥y.setGravity(16);
        this.f٩٤٥٥y.setTextSize(dimension);
        TextView textView3 = new TextView(getContext());
        this.f٩٤٥٦z = textView3;
        textView3.setMaxLines(1);
        this.f٩٤٥٦z.setEllipsize(truncateAt);
        this.f٩٤٥٦z.setDuplicateParentStateEnabled(true);
        this.f٩٤٥٦z.setVisibility(4);
        this.f٩٤٥٦z.setIncludeFontPadding(false);
        this.f٩٤٥٦z.setGravity(16);
        this.f٩٤٥٦z.setTextSize(dimension2);
        this.f٩٤٥٤x.addView(this.f٩٤٥٥y);
        this.f٩٤٥٤x.addView(this.f٩٤٥٦z);
    }

    private boolean k() {
        if (this.U && this.f٩٤٤٤n == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        boolean z10;
        if (this.f٩٤٥٠t.getVisibility() == 0) {
            A(this.f٩٤٥٠t);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f٩٤٤٧q.getLayoutParams();
        int i18 = (i12 - i10) + layoutParams.rightMargin + layoutParams.leftMargin;
        int i19 = (i13 - i11) + layoutParams.topMargin + layoutParams.bottomMargin;
        boolean z11 = true;
        if (this.f٩٤٢٥b0 == 1 && this.S == -2) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f٩٤٤٨r.getLayoutParams();
            if (this.S == -2 && this.f٩٤٤٨r.getMeasuredWidth() != i18) {
                layoutParams2.width = Math.max(i18, Math.min(this.Q, getMeasuredWidth() - (this.V * 2)));
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.f٩٤٤٨r.getMeasuredHeight() < i19) {
                layoutParams2.height = i19;
            } else {
                z11 = z10;
            }
            if (z11) {
                this.f٩٤٤٨r.setLayoutParams(layoutParams2);
            }
        }
    }

    private void m(float f10) {
        if (this.P && this.f٩٤٢٢a && isAttachedToWindow()) {
            ValueAnimator valueAnimator = this.M;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.M = null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.O, f10);
            this.M = ofFloat;
            ofFloat.addUpdateListener(new b(f10));
            this.M.setInterpolator(a8.k.g(getContext(), com.google.android.material.R.attr.motionEasingEmphasizedInterpolator, p7.a.f١٦٩٤٨b));
            this.M.setDuration(a8.k.f(getContext(), com.google.android.material.R.attr.motionDurationLong2, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
            this.M.start();
            return;
        }
        q(f10, f10);
    }

    private void n() {
        androidx.appcompat.view.menu.i iVar = this.I;
        if (iVar != null) {
            setChecked(iVar.isChecked());
        }
    }

    private void o() {
        Drawable drawable = this.f٩٤٢٦c;
        RippleDrawable rippleDrawable = null;
        boolean z10 = true;
        if (this.f٩٤٢٤b != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.P && getActiveIndicatorDrawable() != null && activeIndicatorDrawable != null) {
                rippleDrawable = new RippleDrawable(d8.a.e(this.f٩٤٢٤b), null, activeIndicatorDrawable);
                z10 = false;
            } else if (drawable == null) {
                drawable = f(this.f٩٤٢٤b);
            }
        }
        this.f٩٤٤٩s.setPadding(0, 0, 0, 0);
        this.f٩٤٤٩s.setForeground(rippleDrawable);
        setBackground(drawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(float f10, float f11) {
        this.N.d(f10, f11, this.f٩٤٤٨r);
        this.O = f10;
    }

    private void r() {
        int i10;
        int i11;
        int i12 = 0;
        if (this.f٩٤٥٠t.getLayoutParams().width > 0) {
            i10 = this.f٩٤٣٤g;
        } else {
            i10 = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f٩٤٥٤x.getLayoutParams();
        if (layoutParams != null) {
            if (getLayoutDirection() == 1) {
                i11 = i10;
            } else {
                i11 = 0;
            }
            layoutParams.rightMargin = i11;
            if (getLayoutDirection() != 1) {
                i12 = i10;
            }
            layoutParams.leftMargin = i12;
        }
    }

    private void s(View view, View view2, float f10, float f11) {
        int i10;
        int i11;
        int i12;
        int i13;
        LinearLayout linearLayout = this.f٩٤٤٦p;
        if (this.f٩٤٢٥b0 == 0) {
            i10 = (int) (this.f٩٤٢٨d + f11);
        } else {
            i10 = 0;
        }
        w(linearLayout, i10, 0, this.f٩٤٢٩d0);
        LinearLayout linearLayout2 = this.f٩٤٤٧q;
        int i14 = this.f٩٤٢٥b0;
        if (i14 == 0) {
            i11 = 0;
        } else {
            i11 = this.f٩٤٣٩i0.top;
        }
        if (i14 == 0) {
            i12 = 0;
        } else {
            i12 = this.f٩٤٣٩i0.bottom;
        }
        if (i14 == 0) {
            i13 = 17;
        } else {
            i13 = 8388627;
        }
        w(linearLayout2, i11, i12, i13);
        H(this.f٩٤٥١u, this.f٩٤٣٠e);
        this.A.setVisibility(0);
        x(view, 1.0f, 1.0f, 0);
        x(view2, f10, f10, 4);
    }

    private void setLabelPivots(TextView textView) {
        textView.setPivotX(textView.getWidth() / 2);
        textView.setPivotY(textView.getBaseline());
    }

    private void t() {
        int i10;
        LinearLayout linearLayout = this.f٩٤٤٦p;
        int i11 = this.f٩٤٢٨d;
        if (this.f٩٤٢٥b0 == 0) {
            i10 = 17;
        } else {
            i10 = this.f٩٤٢٩d0;
        }
        w(linearLayout, i11, i11, i10);
        w(this.f٩٤٤٧q, 0, 0, 17);
        H(this.f٩٤٥١u, 0);
        this.A.setVisibility(8);
    }

    private void u(TextView textView, int i10) {
        if (this.f٩٤٣٧h0) {
            l.m(textView, i10);
        } else {
            v(textView, i10);
        }
    }

    private static void v(TextView textView, int i10) {
        l.m(textView, i10);
        int j10 = c8.c.j(textView.getContext(), i10, 0);
        if (j10 != 0) {
            textView.setTextSize(0, j10);
        }
    }

    private static void w(View view, int i10, int i11, int i12) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i10;
        layoutParams.bottomMargin = i11;
        layoutParams.gravity = i12;
        view.setLayoutParams(layoutParams);
    }

    private static void x(View view, float f10, float f11, int i10) {
        view.setScaleX(f10);
        view.setScaleY(f11);
        view.setVisibility(i10);
    }

    private void y(View view) {
        if (i() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.b.a(this.f٩٤٢٣a0, view);
        }
    }

    private void z(View view) {
        if (!i()) {
            return;
        }
        if (view != null) {
            setClipChildren(true);
            setClipToPadding(true);
            com.google.android.material.badge.b.e(this.f٩٤٢٣a0, view);
        }
        this.f٩٤٢٣a0 = null;
    }

    public void B(int i10) {
        if (i10 <= 0 && getVisibility() == 0) {
            return;
        }
        int min = Math.min(this.Q, i10 - (this.V * 2));
        int i11 = this.R;
        if (this.f٩٤٢٥b0 == 1) {
            int i12 = i10 - (this.W * 2);
            int i13 = this.S;
            if (i13 != -1) {
                if (i13 == -2) {
                    i12 = this.f٩٤٤٦p.getMeasuredWidth();
                } else {
                    i12 = Math.min(i13, i12);
                }
            }
            min = i12;
            i11 = Math.max(this.T, this.f٩٤٤٧q.getMeasuredHeight());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f٩٤٤٨r.getLayoutParams();
        if (k()) {
            i11 = min;
        }
        layoutParams.height = i11;
        layoutParams.width = Math.max(0, min);
        this.f٩٤٤٨r.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.P) {
            this.f٩٤٤٩s.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        p();
        this.I = null;
        this.O = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٩٤٢٢a = false;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void g(androidx.appcompat.view.menu.i iVar, int i10) {
        CharSequence title;
        this.I = iVar;
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitle());
        setId(iVar.getItemId());
        if (!TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(iVar.getContentDescription());
        }
        if (!TextUtils.isEmpty(iVar.getTooltipText())) {
            title = iVar.getTooltipText();
        } else {
            title = iVar.getTitle();
        }
        if (Build.VERSION.SDK_INT > 23) {
            u0.a(this, title);
        }
        I();
        this.f٩٤٢٢a = true;
    }

    public Drawable getActiveIndicatorDrawable() {
        return this.f٩٤٤٨r.getBackground();
    }

    public com.google.android.material.badge.a getBadge() {
        return this.f٩٤٢٣a0;
    }

    public BaselineLayout getExpandedLabelGroup() {
        return this.f٩٤٥٤x;
    }

    protected int getItemBackgroundResId() {
        return com.google.android.material.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public androidx.appcompat.view.menu.i getItemData() {
        return this.I;
    }

    protected int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f٩٤٢١B;
    }

    public BaselineLayout getLabelGroup() {
        return this.f٩٤٥١u;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f٩٤٤٦p.getLayoutParams();
        return this.f٩٤٤٦p.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        if (this.f٩٤٢٥b0 == 1) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f٩٤٤٧q.getLayoutParams();
            return this.f٩٤٤٧q.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f٩٤٥١u.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams2.leftMargin + this.f٩٤٥١u.getMeasuredWidth() + layoutParams2.rightMargin);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean h() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        androidx.appcompat.view.menu.i iVar = this.I;
        if (iVar != null && iVar.isCheckable() && this.I.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f٩٤١٨j0);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        com.google.android.material.badge.a aVar = this.f٩٤٢٣a0;
        if (aVar != null && aVar.isVisible()) {
            CharSequence title = this.I.getTitle();
            if (!TextUtils.isEmpty(this.I.getContentDescription())) {
                title = this.I.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.f٩٤٢٣a0.j()));
        }
        g0 V0 = g0.V0(accessibilityNodeInfo);
        V0.r0(g0.f.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            V0.p0(false);
            V0.f0(g0.a.f١٥٩٣٠i);
        }
        V0.J0(getResources().getString(com.google.android.material.R.string.item_view_role_description));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        post(new a(i10));
    }

    void p() {
        z(this.f٩٤٥٠t);
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        this.f٩٤٤٨r.setBackground(drawable);
        o();
    }

    public void setActiveIndicatorEnabled(boolean z10) {
        int i10;
        this.P = z10;
        o();
        View view = this.f٩٤٤٨r;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        view.setVisibility(i10);
        requestLayout();
    }

    public void setActiveIndicatorExpandedHeight(int i10) {
        this.T = i10;
        B(getWidth());
    }

    public void setActiveIndicatorExpandedMarginHorizontal(int i10) {
        this.W = i10;
        if (this.f٩٤٢٥b0 == 1) {
            setPadding(i10, 0, i10, 0);
        }
        B(getWidth());
    }

    public void setActiveIndicatorExpandedPadding(Rect rect) {
        this.f٩٤٣٩i0 = rect;
    }

    public void setActiveIndicatorExpandedWidth(int i10) {
        this.S = i10;
        B(getWidth());
    }

    public void setActiveIndicatorHeight(int i10) {
        this.R = i10;
        B(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i10) {
        int i11;
        if (this.f٩٤٣٢f != i10) {
            this.f٩٤٣٢f = i10;
            ((LinearLayout.LayoutParams) this.f٩٤٥١u.getLayoutParams()).topMargin = i10;
            if (this.f٩٤٥٤x.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f٩٤٥٤x.getLayoutParams();
                if (getLayoutDirection() == 1) {
                    i11 = i10;
                } else {
                    i11 = 0;
                }
                layoutParams.rightMargin = i11;
                if (getLayoutDirection() == 1) {
                    i10 = 0;
                }
                layoutParams.leftMargin = i10;
                requestLayout();
            }
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i10) {
        this.V = i10;
        B(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z10) {
        this.U = z10;
    }

    public void setActiveIndicatorWidth(int i10) {
        this.Q = i10;
        B(getWidth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadge(com.google.android.material.badge.a aVar) {
        if (this.f٩٤٢٣a0 == aVar) {
            return;
        }
        if (i() && this.f٩٤٥٠t != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            z(this.f٩٤٥٠t);
        }
        this.f٩٤٢٣a0 = aVar;
        aVar.O(this.f٩٤٢٧c0);
        ImageView imageView = this.f٩٤٥٠t;
        if (imageView != null) {
            y(imageView);
        }
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
    }

    public void setChecked(boolean z10) {
        float f10;
        setLabelPivots(this.f٩٤٥٣w);
        setLabelPivots(this.f٩٤٥٢v);
        setLabelPivots(this.f٩٤٥٦z);
        setLabelPivots(this.f٩٤٥٥y);
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        m(f10);
        TextView textView = this.f٩٤٥٣w;
        TextView textView2 = this.f٩٤٥٢v;
        float f11 = this.f٩٤٣٦h;
        float f12 = this.f٩٤٣٨i;
        float f13 = this.f٩٤٤٠j;
        if (this.f٩٤٢٥b0 == 1) {
            textView = this.f٩٤٥٦z;
            textView2 = this.f٩٤٥٥y;
            f11 = this.f٩٤٤١k;
            f12 = this.f٩٤٤٢l;
            f13 = this.f٩٤٤٣m;
        }
        int i10 = this.f٩٤٤٤n;
        if (i10 != -1) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        t();
                    }
                } else if (z10) {
                    s(textView, textView2, f12, f11);
                } else {
                    s(textView2, textView, f13, DownloadProgress.UNKNOWN_PROGRESS);
                }
            } else if (z10) {
                s(textView, textView2, f12, DownloadProgress.UNKNOWN_PROGRESS);
            } else {
                t();
            }
        } else if (this.f٩٤٤٥o) {
            if (z10) {
                s(textView, textView2, f12, DownloadProgress.UNKNOWN_PROGRESS);
            } else {
                t();
            }
        } else if (z10) {
            s(textView, textView2, f12, f11);
        } else {
            s(textView2, textView, f13, DownloadProgress.UNKNOWN_PROGRESS);
        }
        refreshDrawableState();
        setSelected(z10);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f٩٤٥٢v.setEnabled(z10);
        this.f٩٤٥٣w.setEnabled(z10);
        this.f٩٤٥٥y.setEnabled(z10);
        this.f٩٤٥٦z.setEnabled(z10);
        this.f٩٤٥٠t.setEnabled(z10);
    }

    @Override // com.google.android.material.navigation.h
    public void setExpanded(boolean z10) {
        this.f٩٤٣١e0 = z10;
        I();
    }

    public void setHorizontalTextAppearanceActive(int i10) {
        this.E = i10;
        TextView textView = this.f٩٤٥٦z;
        if (i10 == 0) {
            i10 = this.C;
        }
        E(textView, i10);
    }

    public void setHorizontalTextAppearanceInactive(int i10) {
        this.F = i10;
        TextView textView = this.f٩٤٥٥y;
        if (i10 == 0) {
            i10 = this.D;
        }
        F(textView, i10);
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.K) {
            return;
        }
        this.K = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = h2.b.r(drawable).mutate();
            this.L = drawable;
            ColorStateList colorStateList = this.J;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }
        this.f٩٤٥٠t.setImageDrawable(drawable);
    }

    public void setIconLabelHorizontalSpacing(int i10) {
        if (this.f٩٤٣٤g != i10) {
            this.f٩٤٣٤g = i10;
            r();
            requestLayout();
        }
    }

    public void setIconSize(int i10) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f٩٤٥٠t.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i10;
        this.f٩٤٥٠t.setLayoutParams(layoutParams);
        r();
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.J = colorStateList;
        if (this.I != null && (drawable = this.L) != null) {
            drawable.setTintList(colorStateList);
            this.L.invalidateSelf();
        }
    }

    public void setItemBackground(int i10) {
        setItemBackground(i10 == 0 ? null : getContext().getDrawable(i10));
    }

    public void setItemGravity(int i10) {
        this.f٩٤٢٩d0 = i10;
        requestLayout();
    }

    public void setItemIconGravity(int i10) {
        if (this.f٩٤٢٥b0 != i10) {
            this.f٩٤٢٥b0 = i10;
            G();
            o();
        }
    }

    public void setItemPaddingBottom(int i10) {
        if (this.f٩٤٣٠e != i10) {
            this.f٩٤٣٠e = i10;
            n();
        }
    }

    public void setItemPaddingTop(int i10) {
        if (this.f٩٤٢٨d != i10) {
            this.f٩٤٢٨d = i10;
            n();
        }
    }

    public void setItemPosition(int i10) {
        this.f٩٤٢١B = i10;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f٩٤٢٤b = colorStateList;
        o();
    }

    public void setLabelFontScalingEnabled(boolean z10) {
        this.f٩٤٣٧h0 = z10;
        setTextAppearanceActive(this.C);
        setTextAppearanceInactive(this.D);
        setHorizontalTextAppearanceActive(this.E);
        setHorizontalTextAppearanceInactive(this.F);
    }

    public void setLabelMaxLines(int i10) {
        this.f٩٤٥٢v.setMaxLines(i10);
        this.f٩٤٥٣w.setMaxLines(i10);
        this.f٩٤٥٥y.setMaxLines(i10);
        this.f٩٤٥٦z.setMaxLines(i10);
        if (Build.VERSION.SDK_INT > 34) {
            this.f٩٤٥٢v.setGravity(17);
            this.f٩٤٥٣w.setGravity(17);
        } else if (i10 > 1) {
            this.f٩٤٥٢v.setEllipsize(null);
            this.f٩٤٥٣w.setEllipsize(null);
            this.f٩٤٥٢v.setGravity(17);
            this.f٩٤٥٣w.setGravity(17);
        } else {
            this.f٩٤٥٢v.setGravity(16);
            this.f٩٤٥٣w.setGravity(16);
        }
        requestLayout();
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.f٩٤٤٤n != i10) {
            this.f٩٤٤٤n = i10;
            C();
            B(getWidth());
            n();
        }
    }

    public void setMeasureBottomPaddingFromLabelBaseline(boolean z10) {
        this.f٩٤٣٥g0 = z10;
        this.f٩٤٥١u.setMeasurePaddingFromBaseline(z10);
        this.f٩٤٥٢v.setIncludeFontPadding(z10);
        this.f٩٤٥٣w.setIncludeFontPadding(z10);
        this.f٩٤٥٤x.setMeasurePaddingFromBaseline(z10);
        this.f٩٤٥٥y.setIncludeFontPadding(z10);
        this.f٩٤٥٦z.setIncludeFontPadding(z10);
        requestLayout();
    }

    @Override // com.google.android.material.navigation.h
    public void setOnlyShowWhenExpanded(boolean z10) {
        this.f٩٤٣٣f0 = z10;
        I();
    }

    public void setShifting(boolean z10) {
        if (this.f٩٤٤٥o != z10) {
            this.f٩٤٤٥o = z10;
            n();
        }
    }

    public void setTextAppearanceActive(int i10) {
        this.C = i10;
        E(this.f٩٤٥٣w, i10);
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z10) {
        this.H = z10;
        setTextAppearanceActive(this.C);
        setHorizontalTextAppearanceActive(this.E);
        D();
    }

    public void setTextAppearanceInactive(int i10) {
        this.D = i10;
        F(this.f٩٤٥٢v, i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.G = colorStateList;
        if (colorStateList != null) {
            this.f٩٤٥٢v.setTextColor(colorStateList);
            this.f٩٤٥٣w.setTextColor(colorStateList);
            this.f٩٤٥٥y.setTextColor(colorStateList);
            this.f٩٤٥٦z.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f٩٤٥٢v.setText(charSequence);
        this.f٩٤٥٣w.setText(charSequence);
        this.f٩٤٥٥y.setText(charSequence);
        this.f٩٤٥٦z.setText(charSequence);
        androidx.appcompat.view.menu.i iVar = this.I;
        if (iVar == null || TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        androidx.appcompat.view.menu.i iVar2 = this.I;
        if (iVar2 != null && !TextUtils.isEmpty(iVar2.getTooltipText())) {
            charSequence = this.I.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            u0.a(this, charSequence);
        }
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f٩٤٢٦c = drawable;
        o();
    }
}
