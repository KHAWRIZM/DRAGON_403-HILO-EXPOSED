package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.activity.BackEventCompat;
import androidx.annotation.Dimension;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.p0;
import androidx.core.view.d2;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.l0;
import com.google.android.material.internal.p;
import com.google.android.material.internal.q;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import f8.s;
import java.util.Objects;
import s7.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements a8.b {

    /* renamed from: h, reason: collision with root package name */
    private final p f٩٥٠٨h;

    /* renamed from: i, reason: collision with root package name */
    private final q f٩٥٠٩i;

    /* renamed from: j, reason: collision with root package name */
    private final int f٩٥١٠j;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f٩٥١١k;

    /* renamed from: l, reason: collision with root package name */
    private MenuInflater f٩٥١٢l;

    /* renamed from: m, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f٩٥١٣m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f٩٥١٤n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٩٥١٥o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f٩٥١٦p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f٩٥١٧q;

    /* renamed from: r, reason: collision with root package name */
    private int f٩٥١٨r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f٩٥١٩s;

    /* renamed from: t, reason: collision with root package name */
    private final int f٩٥٢٠t;

    /* renamed from: u, reason: collision with root package name */
    private final s f٩٥٢١u;

    /* renamed from: v, reason: collision with root package name */
    private final a8.j f٩٥٢٢v;

    /* renamed from: w, reason: collision with root package name */
    private final a8.c f٩٥٢٣w;

    /* renamed from: x, reason: collision with root package name */
    private final DrawerLayout.e f٩٥٢٤x;

    /* renamed from: y, reason: collision with root package name */
    private static final int[] f٩٥٠٦y = {R.attr.state_checked};

    /* renamed from: z, reason: collision with root package name */
    private static final int[] f٩٥٠٧z = {-16842910};
    private static final int A = com.google.android.material.R.style.Widget_Design_NavigationView;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends DrawerLayout.g {
        a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void a(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                final a8.c cVar = navigationView.f٩٥٢٣w;
                Objects.requireNonNull(cVar);
                view.post(new Runnable() { // from class: com.google.android.material.navigation.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        a8.c.this.e();
                    }
                });
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void b(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                navigationView.f٩٥٢٣w.f();
                NavigationView.this.x();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements g.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            NavigationView.this.getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            boolean z16;
            boolean z17;
            boolean z18;
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.f٩٥١١k);
            boolean z19 = true;
            if (NavigationView.this.f٩٥١١k[1] == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            NavigationView.this.f٩٥٠٩i.D(z10);
            NavigationView navigationView2 = NavigationView.this;
            if (z10 && navigationView2.v()) {
                z11 = true;
            } else {
                z11 = false;
            }
            navigationView2.setDrawTopInsetForeground(z11);
            if (NavigationView.this.getLayoutDirection() == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (NavigationView.this.f٩٥١١k[0] != 0 && NavigationView.this.f٩٥١١k[0] + NavigationView.this.getWidth() != 0) {
                z13 = false;
            } else {
                z13 = true;
            }
            NavigationView navigationView3 = NavigationView.this;
            if (z13 && (!z12 ? navigationView3.u() : navigationView3.t())) {
                z14 = true;
            } else {
                z14 = false;
            }
            navigationView3.setDrawLeftInsetForeground(z14);
            Activity a10 = com.google.android.material.internal.c.a(NavigationView.this.getContext());
            if (a10 != null) {
                Rect a11 = l0.a(a10);
                if (a11.height() - NavigationView.this.getHeight() == NavigationView.this.f٩٥١١k[1]) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if (Color.alpha(a10.getWindow().getNavigationBarColor()) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                NavigationView navigationView4 = NavigationView.this;
                if (z15 && z16 && navigationView4.s()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                navigationView4.setDrawBottomInsetForeground(z17);
                if (a11.width() != NavigationView.this.f٩٥١١k[0] && a11.width() - NavigationView.this.getWidth() != NavigationView.this.f٩٥١١k[0]) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                NavigationView navigationView5 = NavigationView.this;
                if (!z18 || (!z12 ? !navigationView5.t() : !navigationView5.u())) {
                    z19 = false;
                }
                navigationView5.setDrawRightInsetForeground(z19);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface d {
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    private void A() {
        this.f٩٥١٣m = new c();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f٩٥١٣m);
    }

    private MenuInflater getMenuInflater() {
        if (this.f٩٥١٢l == null) {
            this.f٩٥١٢l = new androidx.appcompat.view.g(getContext());
        }
        return this.f٩٥١٢l;
    }

    private ColorStateList m(int i10) {
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
        int[] iArr = f٩٥٠٧z;
        return new ColorStateList(new int[][]{iArr, f٩٥٠٦y, FrameLayout.EMPTY_STATE_SET}, new int[]{a10.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    private Drawable n(p0 p0Var) {
        return o(p0Var, c8.c.b(getContext(), p0Var, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
    }

    private Drawable o(p0 p0Var, ColorStateList colorStateList) {
        f8.i iVar = new f8.i(o.b(getContext(), p0Var.n(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0), p0Var.n(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).m());
        iVar.h0(colorStateList);
        return new InsetDrawable((Drawable) iVar, p0Var.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), p0Var.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), p0Var.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), p0Var.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private boolean p(p0 p0Var) {
        if (!p0Var.s(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) && !p0Var.s(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.f٩٥١٩s && this.f٩٥١٨r != 0) {
            this.f٩٥١٨r = 0;
            y(getWidth(), getHeight());
        }
    }

    private void y(int i10, int i11) {
        boolean z10;
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.f)) {
            if ((this.f٩٥١٨r > 0 || this.f٩٥١٩s) && (getBackground() instanceof f8.i)) {
                if (Gravity.getAbsoluteGravity(((DrawerLayout.f) getLayoutParams()).f٣٥٧٧a, getLayoutDirection()) == 3) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                f8.i iVar = (f8.i) getBackground();
                o.b o10 = iVar.getShapeAppearanceModel().w().o(this.f٩٥١٨r);
                if (z10) {
                    o10.E(DownloadProgress.UNKNOWN_PROGRESS);
                    o10.v(DownloadProgress.UNKNOWN_PROGRESS);
                } else {
                    o10.I(DownloadProgress.UNKNOWN_PROGRESS);
                    o10.z(DownloadProgress.UNKNOWN_PROGRESS);
                }
                o m10 = o10.m();
                iVar.setShapeAppearanceModel(m10);
                this.f٩٥٢١u.g(this, m10);
                this.f٩٥٢١u.f(this, new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, i10, i11));
                this.f٩٥٢١u.i(this, true);
            }
        }
    }

    private Pair z() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.f)) {
            return new Pair((DrawerLayout) parent, (DrawerLayout.f) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    @Override // a8.b
    public void a() {
        z();
        this.f٩٥٢٢v.f();
        x();
    }

    @Override // a8.b
    public void d(BackEventCompat backEventCompat) {
        z();
        this.f٩٥٢٢v.j(backEventCompat);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f٩٥٢١u.e(canvas, new a.InterfaceC٠٢٢٨a() { // from class: com.google.android.material.navigation.j
            @Override // s7.a.InterfaceC٠٢٢٨a
            public final void a(Canvas canvas2) {
                NavigationView.this.w(canvas2);
            }
        });
    }

    @Override // a8.b
    public void e(BackEventCompat backEventCompat) {
        this.f٩٥٢٢v.l(backEventCompat, ((DrawerLayout.f) z().second).f٣٥٧٧a);
        if (this.f٩٥١٩s) {
            this.f٩٥١٨r = p7.a.c(0, this.f٩٥٢٠t, this.f٩٥٢٢v.a(backEventCompat.getProgress()));
            y(getWidth(), getHeight());
        }
    }

    @Override // a8.b
    public void f() {
        Pair z10 = z();
        DrawerLayout drawerLayout = (DrawerLayout) z10.first;
        BackEventCompat c10 = this.f٩٥٢٢v.c();
        if (c10 != null && Build.VERSION.SDK_INT >= 34) {
            this.f٩٥٢٢v.h(c10, ((DrawerLayout.f) z10.second).f٣٥٧٧a, com.google.android.material.navigation.c.b(drawerLayout, this), com.google.android.material.navigation.c.c(drawerLayout));
            return;
        }
        drawerLayout.d(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    protected void g(d2 d2Var) {
        this.f٩٥٠٩i.m(d2Var);
    }

    @VisibleForTesting
    a8.j getBackHelper() {
        return this.f٩٥٢٢v;
    }

    public MenuItem getCheckedItem() {
        return this.f٩٥٠٩i.n();
    }

    public int getDividerInsetEnd() {
        return this.f٩٥٠٩i.o();
    }

    public int getDividerInsetStart() {
        return this.f٩٥٠٩i.p();
    }

    public int getHeaderCount() {
        return this.f٩٥٠٩i.q();
    }

    public Drawable getItemBackground() {
        return this.f٩٥٠٩i.r();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.f٩٥٠٩i.s();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.f٩٥٠٩i.t();
    }

    public ColorStateList getItemIconTintList() {
        return this.f٩٥٠٩i.w();
    }

    public int getItemMaxLines() {
        return this.f٩٥٠٩i.u();
    }

    public ColorStateList getItemTextColor() {
        return this.f٩٥٠٩i.v();
    }

    public int getItemVerticalPadding() {
        return this.f٩٥٠٩i.x();
    }

    public Menu getMenu() {
        return this.f٩٥٠٨h;
    }

    public int getSubheaderInsetEnd() {
        return this.f٩٥٠٩i.z();
    }

    public int getSubheaderInsetStart() {
        return this.f٩٥٠٩i.A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f8.j.e(this);
        ViewParent parent = getParent();
        if ((parent instanceof DrawerLayout) && this.f٩٥٢٣w.b()) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            drawerLayout.I(this.f٩٥٢٤x);
            drawerLayout.a(this.f٩٥٢٤x);
            if (drawerLayout.A(this)) {
                this.f٩٥٢٣w.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f٩٥١٣m);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            ((DrawerLayout) parent).I(this.f٩٥٢٤x);
        }
        this.f٩٥٢٣w.f();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i10 = View.MeasureSpec.makeMeasureSpec(this.f٩٥١٠j, 1073741824);
            }
        } else {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), this.f٩٥١٠j), 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f٩٥٠٨h.T(savedState.f٩٥٢٥a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f٩٥٢٥a = bundle;
        this.f٩٥٠٨h.V(bundle);
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        y(i10, i11);
    }

    public View q(int i10) {
        return this.f٩٥٠٩i.C(i10);
    }

    public void r(int i10) {
        this.f٩٥٠٩i.Y(true);
        getMenuInflater().inflate(i10, this.f٩٥٠٨h);
        this.f٩٥٠٩i.Y(false);
        this.f٩٥٠٩i.h(false);
    }

    public boolean s() {
        return this.f٩٥١٥o;
    }

    public void setBottomInsetScrimEnabled(boolean z10) {
        this.f٩٥١٥o = z10;
    }

    public void setCheckedItem(int i10) {
        MenuItem findItem = this.f٩٥٠٨h.findItem(i10);
        if (findItem != null) {
            this.f٩٥٠٩i.E((androidx.appcompat.view.menu.i) findItem);
        }
    }

    public void setDividerInsetEnd(int i10) {
        this.f٩٥٠٩i.F(i10);
    }

    public void setDividerInsetStart(int i10) {
        this.f٩٥٠٩i.G(i10);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        f8.j.d(this, f10);
    }

    public void setEndInsetScrimEnabled(boolean z10) {
        this.f٩٥١٧q = z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setForceCompatClippingEnabled(boolean z10) {
        this.f٩٥٢١u.h(this, z10);
    }

    public void setItemBackground(Drawable drawable) {
        this.f٩٥٠٩i.I(drawable);
    }

    public void setItemBackgroundResource(int i10) {
        setItemBackground(getContext().getDrawable(i10));
    }

    public void setItemHorizontalPadding(@Dimension int i10) {
        this.f٩٥٠٩i.K(i10);
    }

    public void setItemHorizontalPaddingResource(int i10) {
        this.f٩٥٠٩i.K(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconPadding(@Dimension int i10) {
        this.f٩٥٠٩i.L(i10);
    }

    public void setItemIconPaddingResource(int i10) {
        this.f٩٥٠٩i.L(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconSize(@Dimension int i10) {
        this.f٩٥٠٩i.M(i10);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f٩٥٠٩i.N(colorStateList);
    }

    public void setItemMaxLines(int i10) {
        this.f٩٥٠٩i.O(i10);
    }

    public void setItemTextAppearance(int i10) {
        this.f٩٥٠٩i.P(i10);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.f٩٥٠٩i.Q(z10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f٩٥٠٩i.R(colorStateList);
    }

    public void setItemVerticalPadding(int i10) {
        this.f٩٥٠٩i.S(i10);
    }

    public void setItemVerticalPaddingResource(int i10) {
        this.f٩٥٠٩i.S(getResources().getDimensionPixelSize(i10));
    }

    public void setNavigationItemSelectedListener(d dVar) {
    }

    @Override // android.view.View
    public void setOverScrollMode(int i10) {
        super.setOverScrollMode(i10);
        q qVar = this.f٩٥٠٩i;
        if (qVar != null) {
            qVar.T(i10);
        }
    }

    public void setStartInsetScrimEnabled(boolean z10) {
        this.f٩٥١٦p = z10;
    }

    public void setSubheaderInsetEnd(int i10) {
        this.f٩٥٠٩i.V(i10);
    }

    public void setSubheaderInsetStart(int i10) {
        this.f٩٥٠٩i.W(i10);
    }

    public void setTopInsetScrimEnabled(boolean z10) {
        this.f٩٥١٤n = z10;
    }

    public boolean t() {
        return this.f٩٥١٧q;
    }

    public boolean u() {
        return this.f٩٥١٦p;
    }

    public boolean v() {
        return this.f٩٥١٤n;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public Bundle f٩٥٢٥a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f٩٥٢٥a = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.f٩٥٢٥a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NavigationView(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r9), attributeSet, i10);
        ColorStateList m10;
        int i11;
        int i12;
        int i13 = A;
        q qVar = new q();
        this.f٩٥٠٩i = qVar;
        this.f٩٥١١k = new int[2];
        this.f٩٥١٤n = true;
        this.f٩٥١٥o = true;
        this.f٩٥١٦p = true;
        this.f٩٥١٧q = true;
        this.f٩٥١٨r = 0;
        this.f٩٥٢١u = s.a(this);
        this.f٩٥٢٢v = new a8.j(this);
        this.f٩٥٢٣w = new a8.c(this);
        this.f٩٥٢٤x = new a();
        Context context2 = getContext();
        p pVar = new p(context2);
        this.f٩٥٠٨h = pVar;
        p0 j10 = h0.j(context2, attributeSet, com.google.android.material.R.styleable.NavigationView, i10, i13, new int[0]);
        int i14 = com.google.android.material.R.styleable.NavigationView_android_background;
        if (j10.s(i14)) {
            setBackground(j10.g(i14));
        }
        int f10 = j10.f(com.google.android.material.R.styleable.NavigationView_drawerLayoutCornerSize, 0);
        this.f٩٥١٨r = f10;
        this.f٩٥١٩s = f10 == 0;
        this.f٩٥٢٠t = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.m3_navigation_drawer_layout_corner_size);
        Drawable background = getBackground();
        ColorStateList g10 = com.google.android.material.drawable.g.g(background);
        if (background == null || g10 != null) {
            f8.i iVar = new f8.i(o.e(context2, attributeSet, i10, i13).m());
            if (g10 != null) {
                iVar.h0(g10);
            }
            iVar.V(context2);
            setBackground(iVar);
        }
        if (j10.s(com.google.android.material.R.styleable.NavigationView_elevation)) {
            setElevation(j10.f(r2, 0));
        }
        setFitsSystemWindows(j10.a(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.f٩٥١٠j = j10.f(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        int i15 = com.google.android.material.R.styleable.NavigationView_subheaderColor;
        ColorStateList c10 = j10.s(i15) ? j10.c(i15) : null;
        int i16 = com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance;
        int n10 = j10.s(i16) ? j10.n(i16, 0) : 0;
        if (n10 == 0 && c10 == null) {
            c10 = m(R.attr.textColorSecondary);
        }
        int i17 = com.google.android.material.R.styleable.NavigationView_itemIconTint;
        if (j10.s(i17)) {
            m10 = j10.c(i17);
        } else {
            m10 = m(R.attr.textColorSecondary);
        }
        int i18 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance;
        int n11 = j10.s(i18) ? j10.n(i18, 0) : 0;
        boolean a10 = j10.a(com.google.android.material.R.styleable.NavigationView_itemTextAppearanceActiveBoldEnabled, true);
        int i19 = com.google.android.material.R.styleable.NavigationView_itemIconSize;
        if (j10.s(i19)) {
            setItemIconSize(j10.f(i19, 0));
        }
        int i20 = com.google.android.material.R.styleable.NavigationView_itemTextColor;
        ColorStateList c11 = j10.s(i20) ? j10.c(i20) : null;
        if (n11 == 0 && c11 == null) {
            c11 = m(R.attr.textColorPrimary);
        }
        Drawable g11 = j10.g(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (g11 == null && p(j10)) {
            g11 = n(j10);
            ColorStateList b10 = c8.c.b(context2, j10, com.google.android.material.R.styleable.NavigationView_itemRippleColor);
            if (b10 != null) {
                qVar.J(new RippleDrawable(d8.a.e(b10), null, o(j10, null)));
            }
        }
        int i21 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding;
        if (j10.s(i21)) {
            i11 = 0;
            setItemHorizontalPadding(j10.f(i21, 0));
        } else {
            i11 = 0;
        }
        int i22 = com.google.android.material.R.styleable.NavigationView_itemVerticalPadding;
        if (j10.s(i22)) {
            setItemVerticalPadding(j10.f(i22, i11));
        }
        setDividerInsetStart(j10.f(com.google.android.material.R.styleable.NavigationView_dividerInsetStart, i11));
        setDividerInsetEnd(j10.f(com.google.android.material.R.styleable.NavigationView_dividerInsetEnd, i11));
        setSubheaderInsetStart(j10.f(com.google.android.material.R.styleable.NavigationView_subheaderInsetStart, i11));
        setSubheaderInsetEnd(j10.f(com.google.android.material.R.styleable.NavigationView_subheaderInsetEnd, i11));
        setTopInsetScrimEnabled(j10.a(com.google.android.material.R.styleable.NavigationView_topInsetScrimEnabled, this.f٩٥١٤n));
        setBottomInsetScrimEnabled(j10.a(com.google.android.material.R.styleable.NavigationView_bottomInsetScrimEnabled, this.f٩٥١٥o));
        setStartInsetScrimEnabled(j10.a(com.google.android.material.R.styleable.NavigationView_startInsetScrimEnabled, this.f٩٥١٦p));
        setEndInsetScrimEnabled(j10.a(com.google.android.material.R.styleable.NavigationView_endInsetScrimEnabled, this.f٩٥١٧q));
        int f11 = j10.f(com.google.android.material.R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(j10.k(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        pVar.W(new b());
        qVar.H(1);
        qVar.k(context2, pVar);
        if (n10 != 0) {
            qVar.X(n10);
        }
        qVar.U(c10);
        qVar.N(m10);
        qVar.T(getOverScrollMode());
        if (n11 != 0) {
            qVar.P(n11);
        }
        qVar.Q(a10);
        qVar.R(c11);
        qVar.I(g11);
        qVar.L(f11);
        pVar.b(qVar);
        addView((View) qVar.y(this));
        int i23 = com.google.android.material.R.styleable.NavigationView_menu;
        if (j10.s(i23)) {
            i12 = 0;
            r(j10.n(i23, 0));
        } else {
            i12 = 0;
        }
        int i24 = com.google.android.material.R.styleable.NavigationView_headerLayout;
        if (j10.s(i24)) {
            q(j10.n(i24, i12));
        }
        j10.x();
        A();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f٩٥٠٨h.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f٩٥٠٩i.E((androidx.appcompat.view.menu.i) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
