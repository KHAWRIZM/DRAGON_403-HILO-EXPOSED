package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.j0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.i0;
import com.google.android.material.internal.k0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.b, a8.b {
    private static final int E = R.style.Widget_Material3_SearchView;
    private boolean A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f٩٧٧٥B;
    private b C;
    private Map D;

    /* renamed from: a, reason: collision with root package name */
    final View f٩٧٧٦a;

    /* renamed from: b, reason: collision with root package name */
    final ClippableRoundedCornerLayout f٩٧٧٧b;

    /* renamed from: c, reason: collision with root package name */
    final View f٩٧٧٨c;

    /* renamed from: d, reason: collision with root package name */
    final View f٩٧٧٩d;

    /* renamed from: e, reason: collision with root package name */
    final FrameLayout f٩٧٨٠e;

    /* renamed from: f, reason: collision with root package name */
    final FrameLayout f٩٧٨١f;

    /* renamed from: g, reason: collision with root package name */
    final MaterialToolbar f٩٧٨٢g;

    /* renamed from: h, reason: collision with root package name */
    final Toolbar f٩٧٨٣h;

    /* renamed from: i, reason: collision with root package name */
    final TextView f٩٧٨٤i;

    /* renamed from: j, reason: collision with root package name */
    final LinearLayout f٩٧٨٥j;

    /* renamed from: k, reason: collision with root package name */
    final EditText f٩٧٨٦k;

    /* renamed from: l, reason: collision with root package name */
    final ImageButton f٩٧٨٧l;

    /* renamed from: m, reason: collision with root package name */
    final View f٩٧٨٨m;

    /* renamed from: n, reason: collision with root package name */
    final TouchObserverFrameLayout f٩٧٨٩n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f٩٧٩٠o;

    /* renamed from: p, reason: collision with root package name */
    private final b0 f٩٧٩١p;

    /* renamed from: q, reason: collision with root package name */
    private final a8.c f٩٧٩٢q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f٩٧٩٣r;

    /* renamed from: s, reason: collision with root package name */
    private final x7.a f٩٧٩٤s;

    /* renamed from: t, reason: collision with root package name */
    private final Set f٩٧٩٥t;

    /* renamed from: u, reason: collision with root package name */
    private SearchBar f٩٧٩٦u;

    /* renamed from: v, reason: collision with root package name */
    private int f٩٧٩٧v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f٩٧٩٨w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f٩٧٩٩x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f٩٨٠٠y;

    /* renamed from: z, reason: collision with root package name */
    private final int f٩٨٠١z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Behavior extends CoordinatorLayout.c {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public boolean n(CoordinatorLayout coordinatorLayout, SearchView searchView, View view) {
            if (!searchView.z() && (view instanceof SearchBar)) {
                searchView.setupWithSearchBar((SearchBar) view);
                return false;
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f٩٨٠٢a;

        /* renamed from: b, reason: collision with root package name */
        int f٩٨٠٣b;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f٩٨٠٢a);
            parcel.writeInt(this.f٩٨٠٣b);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f٩٨٠٢a = parcel.readString();
            this.f٩٨٠٣b = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            int i13;
            ImageButton imageButton = SearchView.this.f٩٧٨٧l;
            if (charSequence.length() > 0) {
                i13 = 0;
            } else {
                i13 = 8;
            }
            imageButton.setVisibility(i13);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum b {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    public SearchView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        this.f٩٧٨٦k.clearFocus();
        k0.l(this.f٩٧٨٦k, this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        if (this.f٩٧٨٦k.requestFocus()) {
            this.f٩٧٨٦k.sendAccessibilityEvent(8);
        }
        k0.r(this.f٩٧٨٦k, this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(View view) {
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(View view) {
        s();
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean E(View view, MotionEvent motionEvent) {
        if (u()) {
            r();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ d2 F(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11, View view, d2 d2Var) {
        androidx.core.graphics.b0 f10 = d2Var.f(d2.m.g() | d2.m.a());
        marginLayoutParams.leftMargin = i10 + f10.f٢٧٩٣a;
        marginLayoutParams.rightMargin = i11 + f10.f٢٧٩٥c;
        return d2Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean G(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ d2 H(View view, d2 d2Var) {
        boolean z10;
        int i10 = d2Var.f(d2.m.g() | d2.m.a()).f٢٧٩٤b;
        setUpStatusBarSpacer(i10);
        if (!this.f٩٧٧٥B) {
            if (i10 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            setStatusBarSpacerEnabledInternal(z10);
        }
        return d2Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ d2 I(View view, d2 d2Var, k0.e eVar) {
        int i10;
        int i11;
        boolean m10 = k0.m(this.f٩٧٨٢g);
        if (m10) {
            i10 = eVar.f٩٣٢١c;
        } else {
            i10 = eVar.f٩٣١٩a;
        }
        if (m10) {
            i11 = eVar.f٩٣١٩a;
        } else {
            i11 = eVar.f٩٣٢١c;
        }
        androidx.core.graphics.b0 f10 = d2Var.f(d2.m.g() | d2.m.a());
        this.f٩٧٨٢g.setPadding(i10 + f10.f٢٧٩٣a, eVar.f٩٣٢٠b, i11 + f10.f٢٧٩٥c, eVar.f٩٣٢٢d);
        return d2Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        X();
    }

    private void M(b bVar, boolean z10) {
        if (this.C.equals(bVar)) {
            return;
        }
        if (z10) {
            a0(bVar);
        }
        this.C = bVar;
        Iterator it = new LinkedHashSet(this.f٩٧٩٥t).iterator();
        if (!it.hasNext()) {
            Z(bVar);
            SearchBar searchBar = this.f٩٧٩٦u;
            if (searchBar != null && bVar == b.HIDDEN) {
                searchBar.sendAccessibilityEvent(8);
                return;
            }
            return;
        }
        androidx.appcompat.app.a0.a(it.next());
        throw null;
    }

    private void N(boolean z10, boolean z11) {
        if (z11) {
            this.f٩٧٨٢g.setNavigationIcon((Drawable) null);
            return;
        }
        this.f٩٧٨٢g.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchView.this.C(view);
            }
        });
        if (z10) {
            s1.d dVar = new s1.d(getContext());
            dVar.c(v7.a.d(this, R.attr.colorOnSurface));
            this.f٩٧٨٢g.setNavigationIcon(dVar);
        }
    }

    private void O() {
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
    }

    private void P() {
        this.f٩٧٨٧l.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchView.this.D(view);
            }
        });
        this.f٩٧٨٦k.addTextChangedListener(new a());
    }

    private void Q() {
        this.f٩٧٨٩n.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.search.o
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean E2;
                E2 = SearchView.this.E(view, motionEvent);
                return E2;
            }
        });
    }

    private void R() {
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f٩٧٨٨m.getLayoutParams();
        final int i10 = marginLayoutParams.leftMargin;
        final int i11 = marginLayoutParams.rightMargin;
        d1.E0(this.f٩٧٨٨m, new j0() { // from class: com.google.android.material.search.i
            @Override // androidx.core.view.j0
            public final d2 onApplyWindowInsets(View view, d2 d2Var) {
                d2 F;
                F = SearchView.F(marginLayoutParams, i10, i11, view, d2Var);
                return F;
            }
        });
    }

    private void S(int i10, String str, String str2) {
        if (i10 != -1) {
            androidx.core.widget.l.m(this.f٩٧٨٦k, i10);
        }
        this.f٩٧٨٦k.setText(str);
        this.f٩٧٨٦k.setHint(str2);
    }

    private void T() {
        W();
        R();
        V();
    }

    private void U() {
        this.f٩٧٧٧b.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.search.n
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean G;
                G = SearchView.G(view, motionEvent);
                return G;
            }
        });
    }

    private void V() {
        setUpStatusBarSpacer(getStatusBarHeight());
        d1.E0(this.f٩٧٧٩d, new j0() { // from class: com.google.android.material.search.k
            @Override // androidx.core.view.j0
            public final d2 onApplyWindowInsets(View view, d2 d2Var) {
                d2 H;
                H = SearchView.this.H(view, d2Var);
                return H;
            }
        });
    }

    private void W() {
        k0.f(this.f٩٧٨٢g, new k0.d() { // from class: com.google.android.material.search.j
            @Override // com.google.android.material.internal.k0.d
            public final d2 a(View view, d2 d2Var, k0.e eVar) {
                d2 I;
                I = SearchView.this.I(view, d2Var, eVar);
                return I;
            }
        });
    }

    private void Y(ViewGroup viewGroup, boolean z10) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != this) {
                if (childAt.findViewById(this.f٩٧٧٧b.getId()) != null) {
                    Y((ViewGroup) childAt, z10);
                } else if (!z10) {
                    Map map = this.D;
                    if (map != null && map.containsKey(childAt)) {
                        childAt.setImportantForAccessibility(((Integer) this.D.get(childAt)).intValue());
                    }
                } else {
                    this.D.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    childAt.setImportantForAccessibility(4);
                }
            }
        }
    }

    private void Z(b bVar) {
        if (this.f٩٧٩٦u != null && this.f٩٧٩٣r) {
            if (bVar.equals(b.SHOWN)) {
                this.f٩٧٩٢q.c();
            } else if (bVar.equals(b.HIDDEN)) {
                this.f٩٧٩٢q.f();
            }
        }
    }

    private void a0(b bVar) {
        if (bVar == b.SHOWN) {
            setModalForAccessibility(true);
        } else if (bVar == b.HIDDEN) {
            setModalForAccessibility(false);
        }
    }

    private void b0() {
        MaterialToolbar materialToolbar = this.f٩٧٨٢g;
        if (materialToolbar == null || y(materialToolbar)) {
            return;
        }
        int defaultNavigationIconResource = getDefaultNavigationIconResource();
        if (this.f٩٧٩٦u == null) {
            this.f٩٧٨٢g.setNavigationIcon(defaultNavigationIconResource);
            return;
        }
        Drawable r10 = h2.b.r(r1.a.b(getContext(), defaultNavigationIconResource).mutate());
        if (this.f٩٧٨٢g.getNavigationIconTint() != null) {
            r10.setTint(this.f٩٧٨٢g.getNavigationIconTint().intValue());
        }
        h2.b.m(r10, getLayoutDirection());
        this.f٩٧٨٢g.setNavigationIcon(new com.google.android.material.internal.f(this.f٩٧٩٦u.getNavigationIcon(), r10));
        c0();
    }

    private void c0() {
        int i10;
        ImageButton d10 = i0.d(this.f٩٧٨٢g);
        if (d10 == null) {
            return;
        }
        if (this.f٩٧٧٧b.getVisibility() == 0) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        Drawable q10 = h2.b.q(d10.getDrawable());
        if (q10 instanceof s1.d) {
            ((s1.d) q10).e(i10);
        }
        if (q10 instanceof com.google.android.material.internal.f) {
            ((com.google.android.material.internal.f) q10).a(i10);
        }
    }

    private Window getActivityWindow() {
        Activity a10 = com.google.android.material.internal.c.a(getContext());
        if (a10 == null) {
            return null;
        }
        return a10.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f٩٧٩٦u;
        if (searchBar != null) {
            return searchBar.getCompatElevation();
        }
        return getResources().getDimension(R.dimen.m3_searchview_elevation);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z10) {
        int i10;
        View view = this.f٩٧٧٩d;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        view.setVisibility(i10);
    }

    private void setUpBackgroundViewElevationOverlay(float f10) {
        x7.a aVar = this.f٩٧٩٤s;
        if (aVar != null && this.f٩٧٧٨c != null) {
            this.f٩٧٧٨c.setBackgroundColor(aVar.c(this.f٩٨٠١z, f10));
        }
    }

    private void setUpHeaderLayout(int i10) {
        if (i10 != -1) {
            q(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this.f٩٧٨٠e, false));
        }
    }

    private void setUpStatusBarSpacer(int i10) {
        if (this.f٩٧٧٩d.getLayoutParams().height != i10) {
            this.f٩٧٧٩d.getLayoutParams().height = i10;
            this.f٩٧٧٩d.requestLayout();
        }
    }

    private boolean w() {
        if (!this.C.equals(b.HIDDEN) && !this.C.equals(b.HIDING)) {
            return false;
        }
        return true;
    }

    private boolean y(Toolbar toolbar) {
        return h2.b.q(toolbar.getNavigationIcon()) instanceof s1.d;
    }

    public void K() {
        this.f٩٧٨٦k.postDelayed(new Runnable() { // from class: com.google.android.material.search.f
            @Override // java.lang.Runnable
            public final void run() {
                SearchView.this.B();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L() {
        if (this.f٩٨٠٠y) {
            K();
        }
    }

    public void X() {
        if (!this.C.equals(b.SHOWN) && !this.C.equals(b.SHOWING)) {
            this.f٩٧٩١p.q0();
        }
    }

    @Override // a8.b
    public void a() {
        if (!w() && this.f٩٧٩٦u != null && Build.VERSION.SDK_INT >= 34) {
            this.f٩٧٩١p.w();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f٩٧٩٠o) {
            this.f٩٧٨٩n.addView(view, i10, layoutParams);
        } else {
            super.addView(view, i10, layoutParams);
        }
    }

    @Override // a8.b
    public void d(BackEventCompat backEventCompat) {
        SearchBar searchBar;
        if (!w() && (searchBar = this.f٩٧٩٦u) != null) {
            if (searchBar != null) {
                searchBar.setPlaceholderText(this.f٩٧٨٦k.getText().toString());
            }
            this.f٩٧٩١p.r0(backEventCompat);
        }
    }

    public void d0() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f٩٧٩٧v = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // a8.b
    public void e(BackEventCompat backEventCompat) {
        if (!w() && this.f٩٧٩٦u != null && Build.VERSION.SDK_INT >= 34) {
            this.f٩٧٩١p.w0(backEventCompat);
        }
    }

    @Override // a8.b
    public void f() {
        if (w()) {
            return;
        }
        BackEventCompat j02 = this.f٩٧٩١p.j0();
        if (Build.VERSION.SDK_INT >= 34 && this.f٩٧٩٦u != null && j02 != null) {
            this.f٩٧٩١p.x();
        } else {
            t();
        }
    }

    @VisibleForTesting
    a8.i getBackHelper() {
        return this.f٩٧٩١p.z();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c getBehavior() {
        return new Behavior();
    }

    public b getCurrentTransitionState() {
        return this.C;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int getDefaultNavigationIconResource() {
        return R.drawable.ic_arrow_back_black_24;
    }

    public EditText getEditText() {
        return this.f٩٧٨٦k;
    }

    public CharSequence getHint() {
        return this.f٩٧٨٦k.getHint();
    }

    public TextView getSearchPrefix() {
        return this.f٩٧٨٤i;
    }

    public CharSequence getSearchPrefixText() {
        return this.f٩٧٨٤i.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f٩٧٩٧v;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.f٩٧٨٦k.getText();
    }

    public Toolbar getToolbar() {
        return this.f٩٧٨٢g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f8.j.e(this);
        b currentTransitionState = getCurrentTransitionState();
        a0(currentTransitionState);
        Z(currentTransitionState);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setModalForAccessibility(false);
        this.f٩٧٩٢q.f();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        d0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        boolean z10;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.f٩٨٠٢a);
        if (savedState.f٩٨٠٣b == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        setVisible(z10);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        String charSequence;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        if (text == null) {
            charSequence = null;
        } else {
            charSequence = text.toString();
        }
        savedState.f٩٨٠٢a = charSequence;
        savedState.f٩٨٠٣b = this.f٩٧٧٧b.getVisibility();
        return savedState;
    }

    public void q(View view) {
        this.f٩٧٨٠e.addView(view);
        this.f٩٧٨٠e.setVisibility(0);
    }

    public void r() {
        this.f٩٧٨٦k.post(new Runnable() { // from class: com.google.android.material.search.g
            @Override // java.lang.Runnable
            public final void run() {
                SearchView.this.A();
            }
        });
    }

    public void s() {
        this.f٩٧٨٦k.setText("");
    }

    public void setAnimatedNavigationIcon(boolean z10) {
        this.f٩٧٩٨w = z10;
    }

    public void setAutoShowKeyboard(boolean z10) {
        this.f٩٨٠٠y = z10;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        setUpBackgroundViewElevationOverlay(f10);
    }

    public void setHint(CharSequence charSequence) {
        this.f٩٧٨٦k.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z10) {
        this.f٩٧٩٩x = z10;
    }

    public void setModalForAccessibility(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z10) {
            this.D = new HashMap(viewGroup.getChildCount());
        }
        Y(viewGroup, z10);
        if (!z10) {
            this.D = null;
        }
    }

    public void setOnMenuItemClickListener(Toolbar.h hVar) {
        this.f٩٧٨٢g.setOnMenuItemClickListener(hVar);
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        int i10;
        this.f٩٧٨٤i.setText(charSequence);
        TextView textView = this.f٩٧٨٤i;
        if (TextUtils.isEmpty(charSequence)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        textView.setVisibility(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStatusBarSpacerEnabled(boolean z10) {
        this.f٩٧٧٥B = true;
        setStatusBarSpacerEnabledInternal(z10);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(CharSequence charSequence) {
        this.f٩٧٨٦k.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z10) {
        this.f٩٧٨٢g.setTouchscreenBlocksFocus(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTransitionState(b bVar) {
        M(bVar, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setUseWindowInsetsController(boolean z10) {
        this.A = z10;
    }

    public void setVisible(boolean z10) {
        boolean z11;
        int i10;
        b bVar;
        boolean z12 = true;
        if (this.f٩٧٧٧b.getVisibility() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f٩٧٧٧b;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        clippableRoundedCornerLayout.setVisibility(i10);
        c0();
        if (z10) {
            bVar = b.SHOWN;
        } else {
            bVar = b.HIDDEN;
        }
        if (z11 == z10) {
            z12 = false;
        }
        M(bVar, z12);
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.f٩٧٩٦u = searchBar;
        this.f٩٧٩١p.o0(searchBar);
        if (searchBar != null) {
            searchBar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.search.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchView.this.J(view);
                }
            });
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    searchBar.setHandwritingDelegatorCallback(new Runnable() { // from class: com.google.android.material.search.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            SearchView.this.X();
                        }
                    });
                    this.f٩٧٨٦k.setIsHandwritingDelegate(true);
                } catch (LinkageError unused) {
                }
            }
        }
        b0();
        O();
        Z(getCurrentTransitionState());
    }

    public void t() {
        if (!this.C.equals(b.HIDDEN) && !this.C.equals(b.HIDING)) {
            SearchBar searchBar = this.f٩٧٩٦u;
            if (searchBar != null && searchBar.isAttachedToWindow()) {
                this.f٩٧٩٦u.setPlaceholderText(this.f٩٧٨٦k.getText().toString());
                SearchBar searchBar2 = this.f٩٧٩٦u;
                final b0 b0Var = this.f٩٧٩١p;
                Objects.requireNonNull(b0Var);
                searchBar2.post(new Runnable() { // from class: com.google.android.material.search.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.this.Y();
                    }
                });
                return;
            }
            this.f٩٧٩١p.Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        if (this.f٩٧٩٧v == 48) {
            return true;
        }
        return false;
    }

    public boolean v() {
        return this.f٩٧٩٨w;
    }

    public boolean x() {
        return this.f٩٧٩٩x;
    }

    public boolean z() {
        if (this.f٩٧٩٦u != null) {
            return true;
        }
        return false;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSearchViewStyle);
    }

    public void setHint(int i10) {
        this.f٩٧٨٦k.setHint(i10);
    }

    public void setText(int i10) {
        this.f٩٧٨٦k.setText(i10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchView(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = E;
        this.f٩٧٩٢q = new a8.c(this);
        this.f٩٧٩٥t = new LinkedHashSet();
        this.f٩٧٩٧v = 16;
        this.C = b.HIDDEN;
        Context context2 = getContext();
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.SearchView, i10, i11, new int[0]);
        this.f٩٨٠١z = i12.getColor(R.styleable.SearchView_backgroundTint, 0);
        int resourceId = i12.getResourceId(R.styleable.SearchView_headerLayout, -1);
        int resourceId2 = i12.getResourceId(R.styleable.SearchView_android_textAppearance, -1);
        String string = i12.getString(R.styleable.SearchView_android_text);
        String string2 = i12.getString(R.styleable.SearchView_android_hint);
        String string3 = i12.getString(R.styleable.SearchView_searchPrefixText);
        boolean z10 = i12.getBoolean(R.styleable.SearchView_useDrawerArrowDrawable, false);
        this.f٩٧٩٨w = i12.getBoolean(R.styleable.SearchView_animateNavigationIcon, true);
        this.f٩٧٩٩x = i12.getBoolean(R.styleable.SearchView_animateMenuItems, true);
        boolean z11 = i12.getBoolean(R.styleable.SearchView_hideNavigationIcon, false);
        this.f٩٨٠٠y = i12.getBoolean(R.styleable.SearchView_autoShowKeyboard, true);
        this.f٩٧٩٣r = i12.getBoolean(R.styleable.SearchView_backHandlingEnabled, true);
        i12.recycle();
        LayoutInflater.from(context2).inflate(R.layout.mtrl_search_view, this);
        this.f٩٧٩٠o = true;
        this.f٩٧٧٦a = findViewById(R.id.open_search_view_scrim);
        this.f٩٧٧٧b = (ClippableRoundedCornerLayout) findViewById(R.id.open_search_view_root);
        this.f٩٧٧٨c = findViewById(R.id.open_search_view_background);
        this.f٩٧٧٩d = findViewById(R.id.open_search_view_status_bar_spacer);
        this.f٩٧٨٠e = (FrameLayout) findViewById(R.id.open_search_view_header_container);
        this.f٩٧٨١f = (FrameLayout) findViewById(R.id.open_search_view_toolbar_container);
        this.f٩٧٨٢g = (MaterialToolbar) findViewById(R.id.open_search_view_toolbar);
        this.f٩٧٨٣h = (Toolbar) findViewById(R.id.open_search_view_dummy_toolbar);
        this.f٩٧٨٤i = (TextView) findViewById(R.id.open_search_view_search_prefix);
        this.f٩٧٨٥j = (LinearLayout) findViewById(R.id.open_search_view_text_container);
        this.f٩٧٨٦k = (EditText) findViewById(R.id.open_search_view_edit_text);
        this.f٩٧٨٧l = (ImageButton) findViewById(R.id.open_search_view_clear_button);
        this.f٩٧٨٨m = findViewById(R.id.open_search_view_divider);
        this.f٩٧٨٩n = (TouchObserverFrameLayout) findViewById(R.id.open_search_view_content_container);
        this.f٩٧٩١p = new b0(this);
        this.f٩٧٩٤s = new x7.a(context2);
        U();
        O();
        setUpHeaderLayout(resourceId);
        setSearchPrefixText(string3);
        S(resourceId2, string, string2);
        N(z10, z11);
        P();
        Q();
        T();
    }
}
