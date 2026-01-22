package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.m;
import androidx.core.util.Pools;
import androidx.transition.a0;
import androidx.transition.x;
import com.google.android.material.internal.f0;
import f8.o;
import java.util.HashSet;
import m2.g0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements m {
    private static final int[] W = {R.attr.state_checked};

    /* renamed from: a0, reason: collision with root package name */
    private static final int[] f٩٤٦١a0 = {-16842910};
    private boolean A;

    /* renamed from: B, reason: collision with root package name */
    private int f٩٤٦٢B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private o I;
    private boolean J;
    private ColorStateList K;
    private NavigationBarPresenter L;
    private g M;
    private boolean N;
    private boolean O;
    private int P;
    private int Q;
    private boolean R;
    private MenuItem S;
    private int T;
    private boolean U;
    private final Rect V;

    /* renamed from: a, reason: collision with root package name */
    private final a0 f٩٤٦٣a;

    /* renamed from: b, reason: collision with root package name */
    private final View.OnClickListener f٩٤٦٤b;

    /* renamed from: c, reason: collision with root package name */
    private Pools.Pool f٩٤٦٥c;

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray f٩٤٦٦d;

    /* renamed from: e, reason: collision with root package name */
    private int f٩٤٦٧e;

    /* renamed from: f, reason: collision with root package name */
    private int f٩٤٦٨f;

    /* renamed from: g, reason: collision with root package name */
    private h[] f٩٤٦٩g;

    /* renamed from: h, reason: collision with root package name */
    private int f٩٤٧٠h;

    /* renamed from: i, reason: collision with root package name */
    private int f٩٤٧١i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f٩٤٧٢j;

    /* renamed from: k, reason: collision with root package name */
    private int f٩٤٧٣k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f٩٤٧٤l;

    /* renamed from: m, reason: collision with root package name */
    private final ColorStateList f٩٤٧٥m;

    /* renamed from: n, reason: collision with root package name */
    private int f٩٤٧٦n;

    /* renamed from: o, reason: collision with root package name */
    private int f٩٤٧٧o;

    /* renamed from: p, reason: collision with root package name */
    private int f٩٤٧٨p;

    /* renamed from: q, reason: collision with root package name */
    private int f٩٤٧٩q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٩٤٨٠r;

    /* renamed from: s, reason: collision with root package name */
    private Drawable f٩٤٨١s;

    /* renamed from: t, reason: collision with root package name */
    private ColorStateList f٩٤٨٢t;

    /* renamed from: u, reason: collision with root package name */
    private int f٩٤٨٣u;

    /* renamed from: v, reason: collision with root package name */
    private final SparseArray f٩٤٨٤v;

    /* renamed from: w, reason: collision with root package name */
    private int f٩٤٨٥w;

    /* renamed from: x, reason: collision with root package name */
    private int f٩٤٨٦x;

    /* renamed from: y, reason: collision with root package name */
    private int f٩٤٨٧y;

    /* renamed from: z, reason: collision with root package name */
    private int f٩٤٨٨z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.view.menu.i itemData = ((NavigationBarItemView) view).getItemData();
            boolean e10 = NavigationBarMenuView.this.M.e(itemData, NavigationBarMenuView.this.L, 0);
            if (itemData != null && itemData.isCheckable()) {
                if (!e10 || itemData.isChecked()) {
                    NavigationBarMenuView.this.setCheckedItem(itemData);
                }
            }
        }
    }

    public NavigationBarMenuView(Context context) {
        super(context);
        this.f٩٤٦٦d = new SparseArray();
        this.f٩٤٧٠h = -1;
        this.f٩٤٧١i = -1;
        this.f٩٤٨٤v = new SparseArray();
        this.f٩٤٨٥w = -1;
        this.f٩٤٨٦x = -1;
        this.f٩٤٨٧y = -1;
        this.f٩٤٨٨z = -1;
        this.H = 49;
        this.J = false;
        this.P = 1;
        this.Q = 0;
        this.S = null;
        this.T = 7;
        this.U = false;
        this.V = new Rect();
        this.f٩٤٧٥m = e(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.f٩٤٦٣a = null;
        } else {
            androidx.transition.a aVar = new androidx.transition.a();
            this.f٩٤٦٣a = aVar;
            aVar.B0(0);
            aVar.t(TextView.class, true);
            aVar.i0(a8.k.f(getContext(), com.google.android.material.R.attr.motionDurationMedium4, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
            aVar.k0(a8.k.g(getContext(), com.google.android.material.R.attr.motionEasingStandard, p7.a.f١٦٩٤٨b));
            aVar.s0(new f0());
        }
        this.f٩٤٦٤b = new a();
        setImportantForAccessibility(1);
    }

    private Drawable f() {
        if (this.I != null && this.K != null) {
            f8.i iVar = new f8.i(this.I);
            iVar.h0(this.K);
            return iVar;
        }
        return null;
    }

    private NavigationBarItemView g(int i10, androidx.appcompat.view.menu.i iVar, boolean z10, boolean z11) {
        this.L.m(true);
        iVar.setCheckable(true);
        this.L.m(false);
        NavigationBarItemView newItem = getNewItem();
        newItem.setShifting(z10);
        newItem.setLabelMaxLines(this.P);
        newItem.setIconTintList(this.f٩٤٧٢j);
        newItem.setIconSize(this.f٩٤٧٣k);
        newItem.setTextColor(this.f٩٤٧٥m);
        newItem.setTextAppearanceInactive(this.f٩٤٧٦n);
        newItem.setTextAppearanceActive(this.f٩٤٧٧o);
        newItem.setHorizontalTextAppearanceInactive(this.f٩٤٧٨p);
        newItem.setHorizontalTextAppearanceActive(this.f٩٤٧٩q);
        newItem.setTextAppearanceActiveBoldEnabled(this.f٩٤٨٠r);
        newItem.setTextColor(this.f٩٤٧٤l);
        int i11 = this.f٩٤٨٥w;
        if (i11 != -1) {
            newItem.setItemPaddingTop(i11);
        }
        int i12 = this.f٩٤٨٦x;
        if (i12 != -1) {
            newItem.setItemPaddingBottom(i12);
        }
        newItem.setMeasureBottomPaddingFromLabelBaseline(this.N);
        newItem.setLabelFontScalingEnabled(this.O);
        int i13 = this.f٩٤٨٧y;
        if (i13 != -1) {
            newItem.setActiveIndicatorLabelPadding(i13);
        }
        int i14 = this.f٩٤٨٨z;
        if (i14 != -1) {
            newItem.setIconLabelHorizontalSpacing(i14);
        }
        newItem.setActiveIndicatorWidth(this.f٩٤٦٢B);
        newItem.setActiveIndicatorHeight(this.C);
        newItem.setActiveIndicatorExpandedWidth(this.D);
        newItem.setActiveIndicatorExpandedHeight(this.E);
        newItem.setActiveIndicatorMarginHorizontal(this.F);
        newItem.setItemGravity(this.H);
        newItem.setActiveIndicatorExpandedPadding(this.V);
        newItem.setActiveIndicatorExpandedMarginHorizontal(this.G);
        newItem.setActiveIndicatorDrawable(f());
        newItem.setActiveIndicatorResizeable(this.J);
        newItem.setActiveIndicatorEnabled(this.A);
        Drawable drawable = this.f٩٤٨١s;
        if (drawable != null) {
            newItem.setItemBackground(drawable);
        } else {
            newItem.setItemBackground(this.f٩٤٨٣u);
        }
        newItem.setItemRippleColor(this.f٩٤٨٢t);
        newItem.setLabelVisibilityMode(this.f٩٤٦٧e);
        newItem.setItemIconGravity(this.f٩٤٦٨f);
        newItem.setOnlyShowWhenExpanded(z11);
        newItem.setExpanded(this.R);
        newItem.g(iVar, 0);
        newItem.setItemPosition(i10);
        int itemId = iVar.getItemId();
        newItem.setOnTouchListener((View.OnTouchListener) this.f٩٤٦٦d.get(itemId));
        newItem.setOnClickListener(this.f٩٤٦٤b);
        int i15 = this.f٩٤٧٠h;
        if (i15 != 0 && itemId == i15) {
            this.f٩٤٧١i = i10;
        }
        setBadgeIfNeeded(newItem);
        return newItem;
    }

    private int getCollapsedVisibleItemCount() {
        return Math.min(this.T, this.M.d());
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemView;
        Pools.Pool pool = this.f٩٤٦٥c;
        if (pool != null) {
            navigationBarItemView = (NavigationBarItemView) pool.acquire();
        } else {
            navigationBarItemView = null;
        }
        if (navigationBarItemView == null) {
            return h(getContext());
        }
        return navigationBarItemView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean i() {
        g gVar;
        boolean z10;
        if (this.f٩٤٦٩g == null || (gVar = this.M) == null || gVar.g() != this.f٩٤٦٩g.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            boolean z11 = true;
            if (i10 >= this.f٩٤٦٩g.length) {
                return true;
            }
            if ((this.M.b(i10) instanceof com.google.android.material.navigation.a) && !(this.f٩٤٦٩g[i10] instanceof NavigationBarDividerView)) {
                return false;
            }
            if (this.M.b(i10).hasSubMenu() && !(this.f٩٤٦٩g[i10] instanceof NavigationBarSubheaderView)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.M.b(i10).hasSubMenu() || (this.f٩٤٦٩g[i10] instanceof NavigationBarItemView)) {
                z11 = false;
            }
            if ((this.M.b(i10) instanceof com.google.android.material.navigation.a) || (!z10 && !z11)) {
                i10++;
            }
        }
    }

    private boolean k(int i10) {
        return i10 != -1;
    }

    private void l() {
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null && this.f٩٤٦٥c != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    NavigationBarItemView navigationBarItemView = (NavigationBarItemView) hVar;
                    this.f٩٤٦٥c.release(navigationBarItemView);
                    navigationBarItemView.e();
                }
            }
        }
    }

    private void m() {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < this.M.g(); i10++) {
            hashSet.add(Integer.valueOf(this.M.b(i10).getItemId()));
        }
        for (int i11 = 0; i11 < this.f٩٤٨٤v.size(); i11++) {
            int keyAt = this.f٩٤٨٤v.keyAt(i11);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.f٩٤٨٤v.delete(keyAt);
            }
        }
    }

    private void setBadgeIfNeeded(NavigationBarItemView navigationBarItemView) {
        com.google.android.material.badge.a aVar;
        int id = navigationBarItemView.getId();
        if (k(id) && (aVar = (com.google.android.material.badge.a) this.f٩٤٨٤v.get(id)) != null) {
            navigationBarItemView.setBadge(aVar);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(androidx.appcompat.view.menu.g gVar) {
        this.M = new g(gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d() {
        boolean z10;
        NavigationBarItemView navigationBarItemView;
        removeAllViews();
        l();
        this.L.m(true);
        this.M.f();
        this.L.m(false);
        int a10 = this.M.a();
        if (a10 == 0) {
            this.f٩٤٧٠h = 0;
            this.f٩٤٧١i = 0;
            this.f٩٤٦٩g = null;
            this.f٩٤٦٥c = null;
            return;
        }
        if (this.f٩٤٦٥c == null || this.Q != a10) {
            this.Q = a10;
            this.f٩٤٦٥c = new Pools.SynchronizedPool(a10);
        }
        m();
        int g10 = this.M.g();
        this.f٩٤٦٩g = new h[g10];
        boolean j10 = j(this.f٩٤٦٧e, getCurrentVisibleContentItemCount());
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < g10; i12++) {
            MenuItem b10 = this.M.b(i12);
            boolean z11 = b10 instanceof com.google.android.material.navigation.a;
            if (z11) {
                NavigationBarDividerView navigationBarDividerView = new NavigationBarDividerView(getContext());
                navigationBarDividerView.setOnlyShowWhenExpanded(true);
                navigationBarDividerView.setDividersEnabled(this.U);
                navigationBarItemView = navigationBarDividerView;
            } else if (b10.hasSubMenu()) {
                if (i10 <= 0) {
                    NavigationBarSubheaderView navigationBarSubheaderView = new NavigationBarSubheaderView(getContext());
                    int i13 = this.f٩٤٧٩q;
                    if (i13 == 0) {
                        i13 = this.f٩٤٧٧o;
                    }
                    navigationBarSubheaderView.setTextAppearance(i13);
                    navigationBarSubheaderView.setTextColor(this.f٩٤٧٤l);
                    navigationBarSubheaderView.setOnlyShowWhenExpanded(true);
                    navigationBarSubheaderView.g((androidx.appcompat.view.menu.i) b10, 0);
                    i10 = b10.getSubMenu().size();
                    navigationBarItemView = navigationBarSubheaderView;
                } else {
                    throw new IllegalArgumentException("Only one layer of submenu is supported; a submenu inside a submenu is not supported by the Navigation Bar.");
                }
            } else if (i10 > 0) {
                i10--;
                navigationBarItemView = g(i12, (androidx.appcompat.view.menu.i) b10, j10, true);
            } else {
                androidx.appcompat.view.menu.i iVar = (androidx.appcompat.view.menu.i) b10;
                if (i11 >= this.T) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                i11++;
                navigationBarItemView = g(i12, iVar, j10, z10);
            }
            if (!z11 && b10.isCheckable() && this.f٩٤٧١i == -1) {
                this.f٩٤٧١i = i12;
            }
            this.f٩٤٦٩g[i12] = navigationBarItemView;
            addView(navigationBarItemView);
        }
        int min = Math.min(g10 - 1, this.f٩٤٧١i);
        this.f٩٤٧١i = min;
        setCheckedItem(this.f٩٤٦٩g[min].getItemData());
    }

    public ColorStateList e(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList a10 = r1.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = a10.getDefaultColor();
        int[] iArr = f٩٤٦١a0;
        return new ColorStateList(new int[][]{iArr, W, ViewGroup.EMPTY_STATE_SET}, new int[]{a10.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    public int getActiveIndicatorLabelPadding() {
        return this.f٩٤٨٧y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<com.google.android.material.badge.a> getBadgeDrawables() {
        return this.f٩٤٨٤v;
    }

    public int getCurrentVisibleContentItemCount() {
        if (this.R) {
            return this.M.c();
        }
        return getCollapsedVisibleItemCount();
    }

    public int getHorizontalItemTextAppearanceActive() {
        return this.f٩٤٧٩q;
    }

    public int getHorizontalItemTextAppearanceInactive() {
        return this.f٩٤٧٨p;
    }

    public int getIconLabelHorizontalSpacing() {
        return this.f٩٤٨٨z;
    }

    public ColorStateList getIconTintList() {
        return this.f٩٤٧٢j;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.K;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.A;
    }

    public int getItemActiveIndicatorExpandedHeight() {
        return this.E;
    }

    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.G;
    }

    public int getItemActiveIndicatorExpandedWidth() {
        return this.D;
    }

    public int getItemActiveIndicatorHeight() {
        return this.C;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.F;
    }

    public o getItemActiveIndicatorShapeAppearance() {
        return this.I;
    }

    public int getItemActiveIndicatorWidth() {
        return this.f٩٤٦٢B;
    }

    public Drawable getItemBackground() {
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null && hVarArr.length > 0) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    return ((NavigationBarItemView) hVar).getBackground();
                }
            }
        }
        return this.f٩٤٨١s;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f٩٤٨٣u;
    }

    public int getItemGravity() {
        return this.H;
    }

    public int getItemIconGravity() {
        return this.f٩٤٦٨f;
    }

    @Dimension
    public int getItemIconSize() {
        return this.f٩٤٧٣k;
    }

    public int getItemPaddingBottom() {
        return this.f٩٤٨٦x;
    }

    public int getItemPaddingTop() {
        return this.f٩٤٨٥w;
    }

    public ColorStateList getItemRippleColor() {
        return this.f٩٤٨٢t;
    }

    public int getItemTextAppearanceActive() {
        return this.f٩٤٧٧o;
    }

    public int getItemTextAppearanceInactive() {
        return this.f٩٤٧٦n;
    }

    public ColorStateList getItemTextColor() {
        return this.f٩٤٧٤l;
    }

    public int getLabelMaxLines() {
        return this.P;
    }

    public int getLabelVisibilityMode() {
        return this.f٩٤٦٧e;
    }

    protected g getMenu() {
        return this.M;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.O;
    }

    public int getSelectedItemId() {
        return this.f٩٤٧٠h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSelectedItemPosition() {
        return this.f٩٤٧١i;
    }

    public int getWindowAnimations() {
        return 0;
    }

    protected abstract NavigationBarItemView h(Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(int i10, int i11) {
        if (i10 == -1) {
            if (i11 <= 3) {
                return false;
            }
        } else if (i10 != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(SparseArray sparseArray) {
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            int keyAt = sparseArray.keyAt(i10);
            if (this.f٩٤٨٤v.indexOfKey(keyAt) < 0) {
                this.f٩٤٨٤v.append(keyAt, (com.google.android.material.badge.a) sparseArray.get(keyAt));
            }
        }
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    NavigationBarItemView navigationBarItemView = (NavigationBarItemView) hVar;
                    com.google.android.material.badge.a aVar = (com.google.android.material.badge.a) this.f٩٤٨٤v.get(navigationBarItemView.getId());
                    if (aVar != null) {
                        navigationBarItemView.setBadge(aVar);
                    }
                }
            }
        }
    }

    public void o(int i10, int i11, int i12, int i13) {
        Rect rect = this.V;
        rect.left = i10;
        rect.top = i11;
        rect.right = i12;
        rect.bottom = i13;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorExpandedPadding(this.V);
                }
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        g0.V0(accessibilityNodeInfo).q0(g0.e.b(1, getCurrentVisibleContentItemCount(), false, 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i10) {
        int g10 = this.M.g();
        for (int i11 = 0; i11 < g10; i11++) {
            MenuItem b10 = this.M.b(i11);
            if (i10 == b10.getItemId()) {
                this.f٩٤٧٠h = i10;
                this.f٩٤٧١i = i11;
                setCheckedItem(b10);
                return;
            }
        }
    }

    public void q(int i10) {
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).B(i10);
                }
            }
        }
    }

    public void r() {
        a0 a0Var;
        if (this.M != null && this.f٩٤٦٩g != null) {
            this.L.m(true);
            this.M.f();
            this.L.m(false);
            if (!i()) {
                d();
                return;
            }
            int i10 = this.f٩٤٧٠h;
            int g10 = this.M.g();
            for (int i11 = 0; i11 < g10; i11++) {
                MenuItem b10 = this.M.b(i11);
                if (b10.isChecked()) {
                    setCheckedItem(b10);
                    this.f٩٤٧٠h = b10.getItemId();
                    this.f٩٤٧١i = i11;
                }
            }
            if (i10 != this.f٩٤٧٠h && (a0Var = this.f٩٤٦٣a) != null) {
                x.b(this, a0Var);
            }
            boolean j10 = j(this.f٩٤٦٧e, getCurrentVisibleContentItemCount());
            for (int i12 = 0; i12 < g10; i12++) {
                this.L.m(true);
                this.f٩٤٦٩g[i12].setExpanded(this.R);
                h hVar = this.f٩٤٦٩g[i12];
                if (hVar instanceof NavigationBarItemView) {
                    NavigationBarItemView navigationBarItemView = (NavigationBarItemView) hVar;
                    navigationBarItemView.setLabelVisibilityMode(this.f٩٤٦٧e);
                    navigationBarItemView.setItemIconGravity(this.f٩٤٦٨f);
                    navigationBarItemView.setItemGravity(this.H);
                    navigationBarItemView.setShifting(j10);
                }
                if (this.M.b(i12) instanceof androidx.appcompat.view.menu.i) {
                    this.f٩٤٦٩g[i12].g((androidx.appcompat.view.menu.i) this.M.b(i12), 0);
                }
                this.L.m(false);
            }
        }
    }

    public void setActiveIndicatorLabelPadding(int i10) {
        this.f٩٤٨٧y = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorLabelPadding(i10);
                }
            }
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        if (this.S != menuItem && menuItem.isCheckable()) {
            MenuItem menuItem2 = this.S;
            if (menuItem2 != null && menuItem2.isChecked()) {
                this.S.setChecked(false);
            }
            menuItem.setChecked(true);
            this.S = menuItem;
        }
    }

    public void setCollapsedMaxItemCount(int i10) {
        this.T = i10;
    }

    public void setExpanded(boolean z10) {
        this.R = z10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                hVar.setExpanded(z10);
            }
        }
    }

    public void setHorizontalItemTextAppearanceActive(int i10) {
        this.f٩٤٧٩q = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setHorizontalTextAppearanceActive(i10);
                }
            }
        }
    }

    public void setHorizontalItemTextAppearanceInactive(int i10) {
        this.f٩٤٧٨p = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setHorizontalTextAppearanceInactive(i10);
                }
            }
        }
    }

    public void setIconLabelHorizontalSpacing(int i10) {
        this.f٩٤٨٨z = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setIconLabelHorizontalSpacing(i10);
                }
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f٩٤٧٢j = colorStateList;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setIconTintList(colorStateList);
                }
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.K = colorStateList;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorDrawable(f());
                }
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.A = z10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorEnabled(z10);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedHeight(int i10) {
        this.E = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorExpandedHeight(i10);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(int i10) {
        this.G = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorExpandedMarginHorizontal(i10);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedWidth(int i10) {
        this.D = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorExpandedWidth(i10);
                }
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i10) {
        this.C = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorHeight(i10);
                }
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i10) {
        this.F = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorMarginHorizontal(i10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemActiveIndicatorResizeable(boolean z10) {
        this.J = z10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorResizeable(z10);
                }
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(o oVar) {
        this.I = oVar;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorDrawable(f());
                }
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i10) {
        this.f٩٤٦٢B = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setActiveIndicatorWidth(i10);
                }
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f٩٤٨١s = drawable;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setItemBackground(drawable);
                }
            }
        }
    }

    public void setItemBackgroundRes(int i10) {
        this.f٩٤٨٣u = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setItemBackground(i10);
                }
            }
        }
    }

    public void setItemGravity(int i10) {
        this.H = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setItemGravity(i10);
                }
            }
        }
    }

    public void setItemIconGravity(int i10) {
        this.f٩٤٦٨f = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setItemIconGravity(i10);
                }
            }
        }
    }

    public void setItemIconSize(@Dimension int i10) {
        this.f٩٤٧٣k = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setIconSize(i10);
                }
            }
        }
    }

    public void setItemPaddingBottom(int i10) {
        this.f٩٤٨٦x = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setItemPaddingBottom(this.f٩٤٨٦x);
                }
            }
        }
    }

    public void setItemPaddingTop(int i10) {
        this.f٩٤٨٥w = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setItemPaddingTop(i10);
                }
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f٩٤٨٢t = colorStateList;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setItemRippleColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(int i10) {
        this.f٩٤٧٧o = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setTextAppearanceActive(i10);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.f٩٤٨٠r = z10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setTextAppearanceActiveBoldEnabled(z10);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i10) {
        this.f٩٤٧٦n = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setTextAppearanceInactive(i10);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f٩٤٧٤l = colorStateList;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setTextColor(colorStateList);
                }
            }
        }
    }

    public void setLabelFontScalingEnabled(boolean z10) {
        this.O = z10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setLabelFontScalingEnabled(z10);
                }
            }
        }
    }

    public void setLabelMaxLines(int i10) {
        this.P = i10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setLabelMaxLines(i10);
                }
            }
        }
    }

    public void setLabelVisibilityMode(int i10) {
        this.f٩٤٦٧e = i10;
    }

    public void setMeasurePaddingFromLabelBaseline(boolean z10) {
        this.N = z10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) hVar).setMeasureBottomPaddingFromLabelBaseline(z10);
                }
            }
        }
    }

    public void setPresenter(NavigationBarPresenter navigationBarPresenter) {
        this.L = navigationBarPresenter;
    }

    public void setSubmenuDividersEnabled(boolean z10) {
        if (this.U == z10) {
            return;
        }
        this.U = z10;
        h[] hVarArr = this.f٩٤٦٩g;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                if (hVar instanceof NavigationBarDividerView) {
                    ((NavigationBarDividerView) hVar).setDividersEnabled(z10);
                }
            }
        }
    }
}
