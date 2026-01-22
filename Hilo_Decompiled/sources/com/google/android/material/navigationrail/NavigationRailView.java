package com.google.android.material.navigationrail;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.p0;
import androidx.core.graphics.b0;
import androidx.core.view.d2;
import androidx.transition.a0;
import androidx.transition.c;
import androidx.transition.d;
import androidx.transition.k;
import androidx.transition.x;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import com.google.android.material.navigation.NavigationBarDividerView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NavigationRailView extends NavigationBarView {

    /* renamed from: y, reason: collision with root package name */
    private static final TimeInterpolator f٩٥٤٧y = new PathInterpolator(0.38f, 1.21f, 0.22f, 1.0f);

    /* renamed from: e, reason: collision with root package name */
    private final int f٩٥٤٨e;

    /* renamed from: f, reason: collision with root package name */
    private final int f٩٥٤٩f;

    /* renamed from: g, reason: collision with root package name */
    private final int f٩٥٥٠g;

    /* renamed from: h, reason: collision with root package name */
    private final int f٩٥٥١h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f٩٥٥٢i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f٩٥٥٣j;

    /* renamed from: k, reason: collision with root package name */
    private View f٩٥٥٤k;

    /* renamed from: l, reason: collision with root package name */
    private Boolean f٩٥٥٥l;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f٩٥٥٦m;

    /* renamed from: n, reason: collision with root package name */
    private Boolean f٩٥٥٧n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٩٥٥٨o;

    /* renamed from: p, reason: collision with root package name */
    private int f٩٥٥٩p;

    /* renamed from: q, reason: collision with root package name */
    private int f٩٥٦٠q;

    /* renamed from: r, reason: collision with root package name */
    private int f٩٥٦١r;

    /* renamed from: s, reason: collision with root package name */
    private int f٩٥٦٢s;

    /* renamed from: t, reason: collision with root package name */
    private int f٩٥٦٣t;

    /* renamed from: u, reason: collision with root package name */
    private int f٩٥٦٤u;

    /* renamed from: v, reason: collision with root package name */
    private int f٩٥٦٥v;

    /* renamed from: w, reason: collision with root package name */
    private int f٩٥٦٦w;

    /* renamed from: x, reason: collision with root package name */
    private NavigationRailFrameLayout f٩٥٦٧x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements k0.d {
        a() {
        }

        @Override // com.google.android.material.internal.k0.d
        public d2 a(View view, d2 d2Var, k0.e eVar) {
            b0 f10 = d2Var.f(d2.m.g());
            b0 f11 = d2Var.f(d2.m.a());
            NavigationRailView navigationRailView = NavigationRailView.this;
            if (navigationRailView.t(navigationRailView.f٩٥٥٥l)) {
                eVar.f٩٣٢٠b += f10.f٢٧٩٤b;
            }
            NavigationRailView navigationRailView2 = NavigationRailView.this;
            if (navigationRailView2.t(navigationRailView2.f٩٥٥٦m)) {
                eVar.f٩٣٢٢d += f10.f٢٧٩٦d;
            }
            NavigationRailView navigationRailView3 = NavigationRailView.this;
            if (navigationRailView3.t(navigationRailView3.f٩٥٥٧n)) {
                if (k0.m(view)) {
                    eVar.f٩٣١٩a += Math.max(f10.f٢٧٩٥c, f11.f٢٧٩٥c);
                } else {
                    eVar.f٩٣١٩a += Math.max(f10.f٢٧٩٣a, f11.f٢٧٩٣a);
                }
            }
            eVar.a(view);
            return d2Var;
        }
    }

    public NavigationRailView(Context context) {
        this(context, null);
    }

    private int getMaxChildWidth() {
        int childCount = getNavigationRailMenuView().getChildCount();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getNavigationRailMenuView().getChildAt(i11);
            if (childAt.getVisibility() != 8 && !(childAt instanceof NavigationBarDividerView)) {
                i10 = Math.max(i10, childAt.getMeasuredWidth());
            }
        }
        return i10;
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private void l() {
        View view = (View) getMenuView();
        NavigationRailFrameLayout navigationRailFrameLayout = new NavigationRailFrameLayout(getContext());
        this.f٩٥٦٧x = navigationRailFrameLayout;
        navigationRailFrameLayout.setPaddingTop(this.f٩٥٤٨e);
        this.f٩٥٦٧x.setScrollingEnabled(this.f٩٥٥٢i);
        this.f٩٥٦٧x.setClipChildren(false);
        this.f٩٥٦٧x.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f٩٥٦٧x.addView(view);
        if (!this.f٩٥٥٢i) {
            addView(this.f٩٥٦٧x);
            return;
        }
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.addView(this.f٩٥٦٧x);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(scrollView);
    }

    private void o() {
        k0.f(this, new a());
    }

    private int q(int i10, int i11) {
        int min = Math.min(this.f٩٥٥٠g, View.MeasureSpec.getSize(i10));
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            int max = Math.max(i11, min);
            View view = this.f٩٥٥٤k;
            if (view != null) {
                max = Math.max(max, view.getMeasuredWidth());
            }
            return View.MeasureSpec.makeMeasureSpec(Math.max(getSuggestedMinimumWidth(), Math.min(max, this.f٩٥٥١h)), 1073741824);
        }
        return i10;
    }

    private int r(int i10) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i10) != 1073741824 && suggestedMinimumWidth > 0) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
        }
        return i10;
    }

    private void setExpanded(boolean z10) {
        if (this.f٩٥٥٨o == z10) {
            return;
        }
        u();
        this.f٩٥٥٨o = z10;
        int i10 = this.f٩٥٦١r;
        int i11 = this.f٩٥٥٩p;
        int i12 = this.f٩٥٦٠q;
        int i13 = this.f٩٥٦٢s;
        if (z10) {
            i10 = this.f٩٥٦٤u;
            i11 = this.f٩٥٦٦w;
            i12 = this.f٩٥٦٣t;
            i13 = this.f٩٥٦٥v;
        }
        getNavigationRailMenuView().setItemGravity(i13);
        super.setItemIconGravity(i10);
        getNavigationRailMenuView().setItemSpacing(i11);
        getNavigationRailMenuView().setItemMinimumHeight(i12);
        getNavigationRailMenuView().setExpanded(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return getFitsSystemWindows();
    }

    private void u() {
        if (!isLaidOut()) {
            return;
        }
        k k02 = new c().i0(500L).k0(f٩٥٤٧y);
        k i02 = new d().i0(100L);
        k i03 = new d().i0(100L);
        b bVar = new b();
        k i04 = new d().i0(100L);
        int childCount = getNavigationRailMenuView().getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getNavigationRailMenuView().getChildAt(i10);
            if (childAt instanceof NavigationBarItemView) {
                NavigationBarItemView navigationBarItemView = (NavigationBarItemView) childAt;
                k02.s(navigationBarItemView.getLabelGroup(), true);
                k02.s(navigationBarItemView.getExpandedLabelGroup(), true);
                if (this.f٩٥٥٨o) {
                    i03.d(navigationBarItemView.getExpandedLabelGroup());
                    i02.d(navigationBarItemView.getLabelGroup());
                } else {
                    i03.d(navigationBarItemView.getLabelGroup());
                    i02.d(navigationBarItemView.getExpandedLabelGroup());
                }
                bVar.d(navigationBarItemView.getExpandedLabelGroup());
            }
            i04.d(childAt);
        }
        a0 a0Var = new a0();
        a0Var.B0(0);
        a0Var.s0(k02).s0(i02).s0(bVar);
        if (!this.f٩٥٥٨o) {
            a0Var.s0(i04);
        }
        a0 a0Var2 = new a0();
        a0Var2.B0(0);
        a0Var2.s0(i03);
        if (this.f٩٥٥٨o) {
            a0Var2.s0(i04);
        }
        a0 a0Var3 = new a0();
        a0Var3.B0(1);
        a0Var3.s0(a0Var2).s0(a0Var);
        x.b((ViewGroup) getParent(), a0Var3);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    protected boolean e() {
        return true;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public boolean g() {
        return true;
    }

    public int getCollapsedItemMinimumHeight() {
        return this.f٩٥٦٠q;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getCollapsedMaxItemCount() {
        return 7;
    }

    public int getExpandedItemMinimumHeight() {
        return this.f٩٥٦٣t;
    }

    public View getHeaderView() {
        return this.f٩٥٥٤k;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getItemGravity() {
        return getNavigationRailMenuView().getItemGravity();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getItemIconGravity() {
        return getNavigationRailMenuView().getItemIconGravity();
    }

    public int getItemMinimumHeight() {
        return getNavigationRailMenuView().getItemMinimumHeight();
    }

    public int getItemSpacing() {
        return getNavigationRailMenuView().getItemSpacing();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return Integer.MAX_VALUE;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public boolean getSubmenuDividersEnabled() {
        return this.f٩٥٥٣j;
    }

    public void m(int i10) {
        n(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this, false));
    }

    public void n(View view) {
        s();
        this.f٩٥٥٤k = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.bottomMargin = this.f٩٥٤٩f;
        this.f٩٥٦٧x.addView(view, 0, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        int r10 = r(i10);
        if (this.f٩٥٥٨o) {
            measureChild(getNavigationRailMenuView(), i10, i11);
            View view = this.f٩٥٥٤k;
            if (view != null) {
                measureChild(view, i10, i11);
            }
            r10 = q(i10, getMaxChildWidth());
            if (getItemActiveIndicatorExpandedWidth() == -1) {
                getNavigationRailMenuView().q(View.MeasureSpec.getSize(r10));
            }
        }
        super.onMeasure(r10, i11);
        if (this.f٩٥٦٧x.getMeasuredHeight() < getMeasuredHeight()) {
            measureChild(this.f٩٥٦٧x, r10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.navigation.NavigationBarView
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public NavigationRailMenuView c(Context context) {
        return new NavigationRailMenuView(context);
    }

    public void s() {
        View view = this.f٩٥٥٤k;
        if (view != null) {
            this.f٩٥٦٧x.removeView(view);
            this.f٩٥٥٤k = null;
        }
    }

    public void setCollapsedItemMinimumHeight(int i10) {
        this.f٩٥٦٠q = i10;
        if (!this.f٩٥٥٨o) {
            ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i10);
        }
    }

    public void setCollapsedItemSpacing(int i10) {
        this.f٩٥٥٩p = i10;
        if (!this.f٩٥٥٨o) {
            getNavigationRailMenuView().setItemSpacing(i10);
        }
    }

    public void setExpandedItemMinimumHeight(int i10) {
        this.f٩٥٦٣t = i10;
        if (this.f٩٥٥٨o) {
            ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i10);
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void setItemGravity(int i10) {
        this.f٩٥٦٢s = i10;
        this.f٩٥٦٥v = i10;
        super.setItemGravity(i10);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void setItemIconGravity(int i10) {
        this.f٩٥٦١r = i10;
        this.f٩٥٦٤u = i10;
        super.setItemIconGravity(i10);
    }

    public void setItemMinimumHeight(int i10) {
        this.f٩٥٦٠q = i10;
        this.f٩٥٦٣t = i10;
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i10);
    }

    public void setItemSpacing(int i10) {
        this.f٩٥٥٩p = i10;
        this.f٩٥٦٦w = i10;
        getNavigationRailMenuView().setItemSpacing(i10);
    }

    public void setMenuGravity(int i10) {
        getNavigationRailMenuView().setMenuGravity(i10);
    }

    public void setSubmenuDividersEnabled(boolean z10) {
        if (this.f٩٥٥٣j == z10) {
            return;
        }
        this.f٩٥٥٣j = z10;
        getNavigationRailMenuView().setSubmenuDividersEnabled(z10);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f٩٥٥٥l = null;
        this.f٩٥٥٦m = null;
        this.f٩٥٥٧n = null;
        this.f٩٥٥٨o = false;
        this.f٩٥٦٠q = -1;
        this.f٩٥٦١r = 0;
        this.f٩٥٦٢s = 49;
        Context context2 = getContext();
        this.f٩٥٦٦w = getContext().getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_expanded_item_spacing);
        this.f٩٥٦٥v = 8388627;
        this.f٩٥٦٤u = 1;
        p0 j10 = h0.j(context2, attributeSet, R.styleable.NavigationRailView, i10, i11, new int[0]);
        int i12 = R.styleable.NavigationRailView_contentMarginTop;
        Resources resources = getResources();
        int i13 = R.dimen.mtrl_navigation_rail_margin;
        this.f٩٥٤٨e = j10.f(i12, resources.getDimensionPixelSize(i13));
        this.f٩٥٤٩f = j10.f(R.styleable.NavigationRailView_headerMarginBottom, getResources().getDimensionPixelSize(i13));
        this.f٩٥٥٢i = j10.a(R.styleable.NavigationRailView_scrollingEnabled, false);
        setSubmenuDividersEnabled(j10.a(R.styleable.NavigationRailView_submenuDividersEnabled, false));
        l();
        int n10 = j10.n(R.styleable.NavigationRailView_headerLayout, 0);
        if (n10 != 0) {
            m(n10);
        }
        setMenuGravity(j10.k(R.styleable.NavigationRailView_menuGravity, 49));
        int i14 = R.styleable.NavigationRailView_itemMinHeight;
        int f10 = j10.f(i14, -1);
        int f11 = j10.f(i14, -1);
        int i15 = R.styleable.NavigationRailView_collapsedItemMinHeight;
        f10 = j10.s(i15) ? j10.f(i15, -1) : f10;
        int i16 = R.styleable.NavigationRailView_expandedItemMinHeight;
        f11 = j10.s(i16) ? j10.f(i16, -1) : f11;
        setCollapsedItemMinimumHeight(f10);
        setExpandedItemMinimumHeight(f11);
        this.f٩٥٥٠g = j10.f(R.styleable.NavigationRailView_expandedMinWidth, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_min_expanded_width));
        this.f٩٥٥١h = j10.f(R.styleable.NavigationRailView_expandedMaxWidth, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_max_expanded_width));
        int i17 = R.styleable.NavigationRailView_paddingTopSystemWindowInsets;
        if (j10.s(i17)) {
            this.f٩٥٥٥l = Boolean.valueOf(j10.a(i17, false));
        }
        int i18 = R.styleable.NavigationRailView_paddingBottomSystemWindowInsets;
        if (j10.s(i18)) {
            this.f٩٥٥٦m = Boolean.valueOf(j10.a(i18, false));
        }
        int i19 = R.styleable.NavigationRailView_paddingStartSystemWindowInsets;
        if (j10.s(i19)) {
            this.f٩٥٥٧n = Boolean.valueOf(j10.a(i19, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float b10 = p7.a.b(DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 0.3f, 1.0f, c8.c.f(context2) - 1.0f);
        float c10 = p7.a.c(getItemPaddingTop(), dimensionPixelOffset, b10);
        float c11 = p7.a.c(getItemPaddingBottom(), dimensionPixelOffset2, b10);
        setItemPaddingTop(Math.round(c10));
        setItemPaddingBottom(Math.round(c11));
        setCollapsedItemSpacing(j10.f(R.styleable.NavigationRailView_itemSpacing, 0));
        setExpanded(j10.a(R.styleable.NavigationRailView_expanded, false));
        j10.x();
        o();
    }
}
