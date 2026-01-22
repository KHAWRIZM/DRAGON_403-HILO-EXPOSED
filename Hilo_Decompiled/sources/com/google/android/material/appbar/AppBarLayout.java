package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.a0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.j0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import m2.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: B, reason: collision with root package name */
    private static final int f٨١٢١B = R.style.Widget_Design_AppBarLayout;
    private Behavior A;

    /* renamed from: a, reason: collision with root package name */
    private int f٨١٢٢a;

    /* renamed from: b, reason: collision with root package name */
    private int f٨١٢٣b;

    /* renamed from: c, reason: collision with root package name */
    private int f٨١٢٤c;

    /* renamed from: d, reason: collision with root package name */
    private int f٨١٢٥d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٨١٢٦e;

    /* renamed from: f, reason: collision with root package name */
    private int f٨١٢٧f;

    /* renamed from: g, reason: collision with root package name */
    private d2 f٨١٢٨g;

    /* renamed from: h, reason: collision with root package name */
    private List f٨١٢٩h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٨١٣٠i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f٨١٣١j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f٨١٣٢k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٨١٣٣l;

    /* renamed from: m, reason: collision with root package name */
    private ColorStateList f٨١٣٤m;

    /* renamed from: n, reason: collision with root package name */
    private int f٨١٣٥n;

    /* renamed from: o, reason: collision with root package name */
    private WeakReference f٨١٣٦o;

    /* renamed from: p, reason: collision with root package name */
    private ValueAnimator f٨١٣٧p;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f٨١٣٨q;

    /* renamed from: r, reason: collision with root package name */
    private final List f٨١٣٩r;

    /* renamed from: s, reason: collision with root package name */
    private final LinkedHashSet f٨١٤٠s;

    /* renamed from: t, reason: collision with root package name */
    private final long f٨١٤١t;

    /* renamed from: u, reason: collision with root package name */
    private final TimeInterpolator f٨١٤٢u;

    /* renamed from: v, reason: collision with root package name */
    private int[] f٨١٤٣v;

    /* renamed from: w, reason: collision with root package name */
    private int f٨١٤٤w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f٨١٤٥x;

    /* renamed from: y, reason: collision with root package name */
    private Integer f٨١٤٦y;

    /* renamed from: z, reason: collision with root package name */
    private final float f٨١٤٧z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends i {

        /* renamed from: k, reason: collision with root package name */
        private int f٨١٤٨k;

        /* renamed from: l, reason: collision with root package name */
        private int f٨١٤٩l;

        /* renamed from: m, reason: collision with root package name */
        private ValueAnimator f٨١٥٠m;

        /* renamed from: n, reason: collision with root package name */
        private SavedState f٨١٥١n;

        /* renamed from: o, reason: collision with root package name */
        private WeakReference f٨١٥٢o;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f٨١٥٨a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f٨١٥٩b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f٨١٥٨a = coordinatorLayout;
                this.f٨١٥٩b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.V(this.f٨١٥٨a, this.f٨١٥٩b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public class b extends androidx.core.view.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f٨١٦١a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f٨١٦٢b;

            b(AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout) {
                this.f٨١٦١a = appBarLayout;
                this.f٨١٦٢b = coordinatorLayout;
            }

            @Override // androidx.core.view.a
            public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
                View l02;
                super.onInitializeAccessibilityNodeInfo(view, g0Var);
                g0Var.o0(ScrollView.class.getName());
                if (this.f٨١٦١a.getTotalScrollRange() == 0 || (l02 = BaseBehavior.this.l0(this.f٨١٦٢b)) == null || !BaseBehavior.this.h0(this.f٨١٦١a)) {
                    return;
                }
                if (BaseBehavior.this.S() != (-this.f٨١٦١a.getTotalScrollRange())) {
                    g0Var.b(g0.a.f١٥٩٣٨q);
                    g0Var.L0(true);
                }
                if (BaseBehavior.this.S() != 0) {
                    if (l02.canScrollVertically(-1)) {
                        if ((-this.f٨١٦١a.getDownNestedPreScrollRange()) != 0) {
                            g0Var.b(g0.a.f١٥٩٣٩r);
                            g0Var.L0(true);
                            return;
                        }
                        return;
                    }
                    g0Var.b(g0.a.f١٥٩٣٩r);
                    g0Var.L0(true);
                }
            }

            @Override // androidx.core.view.a
            public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
                if (i10 == 4096) {
                    this.f٨١٦١a.setExpanded(false);
                    return true;
                }
                if (i10 == 8192) {
                    if (BaseBehavior.this.S() != 0) {
                        View l02 = BaseBehavior.this.l0(this.f٨١٦٢b);
                        if (l02.canScrollVertically(-1)) {
                            int i11 = -this.f٨١٦١a.getDownNestedPreScrollRange();
                            if (i11 != 0) {
                                BaseBehavior.this.w(this.f٨١٦٢b, this.f٨١٦١a, l02, 0, i11, new int[]{0, 0}, 1);
                                return true;
                            }
                        } else {
                            this.f٨١٦١a.setExpanded(true);
                            return true;
                        }
                    }
                    return false;
                }
                return super.performAccessibilityAction(view, i10, bundle);
            }
        }

        public BaseBehavior() {
        }

        private boolean B0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List y10 = coordinatorLayout.y(appBarLayout);
            int size = y10.size();
            for (int i10 = 0; i10 < size; i10++) {
                CoordinatorLayout.c f10 = ((CoordinatorLayout.f) ((View) y10.get(i10)).getLayoutParams()).f();
                if (f10 instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) f10).Q() == 0) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        private void C0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int topInset = appBarLayout.getTopInset() + appBarLayout.getPaddingTop();
            int S = S() - topInset;
            int k02 = k0(appBarLayout, S);
            if (k02 >= 0) {
                View childAt = appBarLayout.getChildAt(k02);
                e eVar = (e) childAt.getLayoutParams();
                int c10 = eVar.c();
                if ((c10 & 17) == 17) {
                    int i10 = -childAt.getTop();
                    int i11 = -childAt.getBottom();
                    if (k02 == 0 && appBarLayout.getFitsSystemWindows() && childAt.getFitsSystemWindows()) {
                        i10 -= appBarLayout.getTopInset();
                    }
                    if (g0(c10, 2)) {
                        i11 += childAt.getMinimumHeight();
                    } else if (g0(c10, 5)) {
                        int minimumHeight = childAt.getMinimumHeight() + i11;
                        if (S < minimumHeight) {
                            i10 = minimumHeight;
                        } else {
                            i11 = minimumHeight;
                        }
                    }
                    if (g0(c10, 32)) {
                        i10 += ((LinearLayout.LayoutParams) eVar).topMargin;
                        i11 -= ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    }
                    b0(coordinatorLayout, appBarLayout, j2.a.b(d0(S, i11, i10) + topInset, -appBarLayout.getTotalScrollRange(), 0), DownloadProgress.UNKNOWN_PROGRESS);
                }
            }
        }

        private void D0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10, int i11, boolean z10) {
            Drawable foreground;
            Drawable foreground2;
            View j02 = j0(appBarLayout, i10);
            boolean z11 = false;
            if (j02 != null) {
                int c10 = ((e) j02.getLayoutParams()).c();
                if ((c10 & 1) != 0) {
                    int minimumHeight = j02.getMinimumHeight();
                    if (i11 <= 0 || (c10 & 12) == 0 ? !((c10 & 2) == 0 || (-i10) < (j02.getBottom() - minimumHeight) - appBarLayout.getTopInset()) : (-i10) >= (j02.getBottom() - minimumHeight) - appBarLayout.getTopInset()) {
                        z11 = true;
                    }
                }
            }
            if (appBarLayout.o()) {
                z11 = appBarLayout.F(i0(coordinatorLayout));
            }
            boolean C = appBarLayout.C(z11);
            if (z10 || (C && B0(coordinatorLayout, appBarLayout))) {
                if (appBarLayout.getBackground() != null) {
                    appBarLayout.getBackground().jumpToCurrentState();
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    foreground = appBarLayout.getForeground();
                    if (foreground != null) {
                        foreground2 = appBarLayout.getForeground();
                        foreground2.jumpToCurrentState();
                    }
                }
                if (appBarLayout.getStateListAnimator() != null) {
                    appBarLayout.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        private void a0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            if (!d1.R(coordinatorLayout)) {
                d1.q0(coordinatorLayout, new b(appBarLayout, coordinatorLayout));
            }
        }

        private void b0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10, float f10) {
            int height;
            int abs = Math.abs(S() - i10);
            float abs2 = Math.abs(f10);
            if (abs2 > DownloadProgress.UNKNOWN_PROGRESS) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            }
            c0(coordinatorLayout, appBarLayout, i10, height);
        }

        private void c0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10, int i11) {
            int S = S();
            if (S == i10) {
                ValueAnimator valueAnimator = this.f٨١٥٠m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f٨١٥٠m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f٨١٥٠m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f٨١٥٠m = valueAnimator3;
                valueAnimator3.setInterpolator(p7.a.f١٦٩٥١e);
                this.f٨١٥٠m.addUpdateListener(new a(coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f٨١٥٠m.setDuration(Math.min(i11, 600));
            this.f٨١٥٠m.setIntValues(S, i10);
            this.f٨١٥٠m.start();
        }

        private int d0(int i10, int i11, int i12) {
            if (i10 >= (i11 + i12) / 2) {
                return i12;
            }
            return i11;
        }

        private boolean f0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (appBarLayout.k() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight()) {
                return true;
            }
            return false;
        }

        private static boolean g0(int i10, int i11) {
            return (i10 & i11) == i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (((e) appBarLayout.getChildAt(i10).getLayoutParams()).f٨١٦٧a != 0) {
                    return true;
                }
            }
            return false;
        }

        private View i0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if ((childAt instanceof d0) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View j0(AppBarLayout appBarLayout, int i10) {
            int abs = Math.abs(i10);
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = appBarLayout.getChildAt(i11);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int k0(AppBarLayout appBarLayout, int i10) {
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = appBarLayout.getChildAt(i11);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                e eVar = (e) childAt.getLayoutParams();
                if (g0(eVar.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) eVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) eVar).bottomMargin;
                }
                int i12 = -i10;
                if (top <= i12 && bottom >= i12) {
                    return i11;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public View l0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int o0(AppBarLayout appBarLayout, int i10) {
            int abs = Math.abs(i10);
            int childCount = appBarLayout.getChildCount();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i12 >= childCount) {
                    break;
                }
                View childAt = appBarLayout.getChildAt(i12);
                e eVar = (e) childAt.getLayoutParams();
                Interpolator d10 = eVar.d();
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    if (d10 != null) {
                        int c10 = eVar.c();
                        if ((c10 & 1) != 0) {
                            i11 = childAt.getHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                            if ((c10 & 2) != 0) {
                                i11 -= childAt.getMinimumHeight();
                            }
                        }
                        if (childAt.getFitsSystemWindows()) {
                            i11 -= appBarLayout.getTopInset();
                        }
                        if (i11 > 0) {
                            float f10 = i11;
                            return Integer.signum(i10) * (childAt.getTop() + Math.round(f10 * d10.getInterpolation((abs - childAt.getTop()) / f10)));
                        }
                    }
                } else {
                    i12++;
                }
            }
            return i10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.i
        /* renamed from: A0, reason: merged with bridge method [inline-methods] */
        public int W(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10, int i11, int i12) {
            int i13;
            int i14;
            int S = S();
            int i15 = 0;
            if (i11 != 0 && S >= i11 && S <= i12) {
                int b10 = j2.a.b(i10, i11, i12);
                if (S != b10) {
                    if (appBarLayout.i()) {
                        i13 = o0(appBarLayout, b10);
                    } else {
                        i13 = b10;
                    }
                    boolean M = M(i13);
                    int i16 = S - b10;
                    this.f٨١٤٨k = b10 - i13;
                    if (M) {
                        while (i15 < appBarLayout.getChildCount()) {
                            e eVar = (e) appBarLayout.getChildAt(i15).getLayoutParams();
                            c b11 = eVar.b();
                            if (b11 != null && (eVar.c() & 1) != 0) {
                                b11.a(appBarLayout, appBarLayout.getChildAt(i15), K());
                            }
                            i15++;
                        }
                    }
                    if (!M && appBarLayout.i()) {
                        coordinatorLayout.r(appBarLayout);
                    }
                    appBarLayout.v(K());
                    if (b10 < S) {
                        i14 = -1;
                    } else {
                        i14 = 1;
                    }
                    D0(coordinatorLayout, appBarLayout, b10, i14, false);
                    i15 = i16;
                }
            } else {
                this.f٨١٤٨k = 0;
            }
            a0(coordinatorLayout, appBarLayout);
            return i15;
        }

        @Override // com.google.android.material.appbar.i
        int S() {
            return K() + this.f٨١٤٨k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.i
        /* renamed from: e0, reason: merged with bridge method [inline-methods] */
        public boolean N(AppBarLayout appBarLayout) {
            WeakReference weakReference = this.f٨١٥٢o;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isShown() && !view.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.i
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public int Q(AppBarLayout appBarLayout) {
            return (-appBarLayout.getDownNestedScrollRange()) + appBarLayout.getTopInset();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.i
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public int R(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.i
        /* renamed from: p0, reason: merged with bridge method [inline-methods] */
        public void T(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            C0(coordinatorLayout, appBarLayout);
            if (appBarLayout.o()) {
                appBarLayout.C(appBarLayout.F(i0(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.k, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public boolean r(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10) {
            boolean z10;
            int round;
            boolean r10 = super.r(coordinatorLayout, appBarLayout, i10);
            int pendingAction = appBarLayout.getPendingAction();
            SavedState savedState = this.f٨١٥١n;
            if (savedState != null && (pendingAction & 8) == 0) {
                if (savedState.f٨١٥٣a) {
                    V(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
                } else if (savedState.f٨١٥٤b) {
                    V(coordinatorLayout, appBarLayout, 0);
                } else {
                    View childAt = appBarLayout.getChildAt(savedState.f٨١٥٥c);
                    int i11 = -childAt.getBottom();
                    if (this.f٨١٥١n.f٨١٥٧e) {
                        round = childAt.getMinimumHeight() + appBarLayout.getTopInset();
                    } else {
                        round = Math.round(childAt.getHeight() * this.f٨١٥١n.f٨١٥٦d);
                    }
                    V(coordinatorLayout, appBarLayout, i11 + round);
                }
            } else if (pendingAction != 0) {
                if ((pendingAction & 4) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((pendingAction & 2) != 0) {
                    int i12 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z10) {
                        b0(coordinatorLayout, appBarLayout, i12, DownloadProgress.UNKNOWN_PROGRESS);
                    } else {
                        V(coordinatorLayout, appBarLayout, i12);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z10) {
                        b0(coordinatorLayout, appBarLayout, 0, DownloadProgress.UNKNOWN_PROGRESS);
                    } else {
                        V(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.y();
            this.f٨١٥١n = null;
            M(j2.a.b(K(), -appBarLayout.getTotalScrollRange(), 0));
            D0(coordinatorLayout, appBarLayout, K(), 0, true);
            appBarLayout.v(K());
            a0(coordinatorLayout, appBarLayout);
            return r10;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: r0, reason: merged with bridge method [inline-methods] */
        public boolean s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10, int i11, int i12, int i13) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) appBarLayout.getLayoutParams())).height == -2) {
                coordinatorLayout.P(appBarLayout, i10, i11, View.MeasureSpec.makeMeasureSpec(0, 0), i13);
                return true;
            }
            return super.s(coordinatorLayout, appBarLayout, i10, i11, i12, i13);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: s0, reason: merged with bridge method [inline-methods] */
        public void w(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int[] iArr, int i12) {
            int i13;
            int i14;
            if (i11 != 0) {
                if (i11 < 0) {
                    int i15 = -appBarLayout.getTotalScrollRange();
                    i13 = i15;
                    i14 = appBarLayout.getDownNestedPreScrollRange() + i15;
                } else {
                    i13 = -appBarLayout.getUpNestedPreScrollRange();
                    i14 = 0;
                }
                if (i13 != i14) {
                    iArr[1] = U(coordinatorLayout, appBarLayout, i11, i13, i14);
                }
            }
            if (appBarLayout.o()) {
                appBarLayout.C(appBarLayout.F(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: t0, reason: merged with bridge method [inline-methods] */
        public void z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            if (i13 < 0) {
                iArr[1] = U(coordinatorLayout, appBarLayout, i13, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i13 == 0) {
                a0(coordinatorLayout, appBarLayout);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: u0, reason: merged with bridge method [inline-methods] */
        public void D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                y0((SavedState) parcelable, true);
                super.D(coordinatorLayout, appBarLayout, this.f٨١٥١n.getSuperState());
            } else {
                super.D(coordinatorLayout, appBarLayout, parcelable);
                this.f٨١٥١n = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: v0, reason: merged with bridge method [inline-methods] */
        public Parcelable E(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable E = super.E(coordinatorLayout, appBarLayout);
            SavedState z02 = z0(E, appBarLayout);
            if (z02 != null) {
                return z02;
            }
            return E;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: w0, reason: merged with bridge method [inline-methods] */
        public boolean G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
            boolean z10;
            ValueAnimator valueAnimator;
            if ((i10 & 2) != 0 && (appBarLayout.o() || appBarLayout.q() || f0(coordinatorLayout, appBarLayout, view))) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && (valueAnimator = this.f٨١٥٠m) != null) {
                valueAnimator.cancel();
            }
            this.f٨١٥٢o = null;
            this.f٨١٤٩l = i11;
            return z10;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: x0, reason: merged with bridge method [inline-methods] */
        public void I(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10) {
            if (this.f٨١٤٩l == 0 || i10 == 1) {
                C0(coordinatorLayout, appBarLayout);
                if (appBarLayout.o()) {
                    appBarLayout.C(appBarLayout.F(view));
                }
            }
            this.f٨١٥٢o = new WeakReference(view);
        }

        void y0(SavedState savedState, boolean z10) {
            if (this.f٨١٥١n == null || z10) {
                this.f٨١٥١n = savedState;
            }
        }

        SavedState z0(Parcelable parcelable, AppBarLayout appBarLayout) {
            boolean z10;
            boolean z11;
            int K = K();
            int childCount = appBarLayout.getChildCount();
            boolean z12 = false;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = appBarLayout.getChildAt(i10);
                int bottom = childAt.getBottom() + K;
                if (childAt.getTop() + K <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    if (K == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    savedState.f٨١٥٤b = z10;
                    if (!z10 && (-K) >= appBarLayout.getTotalScrollRange()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    savedState.f٨١٥٣a = z11;
                    savedState.f٨١٥٥c = i10;
                    if (bottom == childAt.getMinimumHeight() + appBarLayout.getTopInset()) {
                        z12 = true;
                    }
                    savedState.f٨١٥٧e = z12;
                    savedState.f٨١٥٦d = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: a, reason: collision with root package name */
            boolean f٨١٥٣a;

            /* renamed from: b, reason: collision with root package name */
            boolean f٨١٥٤b;

            /* renamed from: c, reason: collision with root package name */
            int f٨١٥٥c;

            /* renamed from: d, reason: collision with root package name */
            float f٨١٥٦d;

            /* renamed from: e, reason: collision with root package name */
            boolean f٨١٥٧e;

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
                this.f٨١٥٣a = parcel.readByte() != 0;
                this.f٨١٥٤b = parcel.readByte() != 0;
                this.f٨١٥٥c = parcel.readInt();
                this.f٨١٥٦d = parcel.readFloat();
                this.f٨١٥٧e = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                super.writeToParcel(parcel, i10);
                parcel.writeByte(this.f٨١٥٣a ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f٨١٥٤b ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f٨١٥٥c);
                parcel.writeFloat(this.f٨١٥٦d);
                parcel.writeByte(this.f٨١٥٧e ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.i, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.J(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.k
        public /* bridge */ /* synthetic */ int K() {
            return super.K();
        }

        @Override // com.google.android.material.appbar.k
        public /* bridge */ /* synthetic */ boolean M(int i10) {
            return super.M(i10);
        }

        @Override // com.google.android.material.appbar.i, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.q(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: q0 */
        public /* bridge */ /* synthetic */ boolean r(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10) {
            return super.r(coordinatorLayout, appBarLayout, i10);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: r0 */
        public /* bridge */ /* synthetic */ boolean s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10, int i11, int i12, int i13) {
            return super.s(coordinatorLayout, appBarLayout, i10, i11, i12, i13);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: s0 */
        public /* bridge */ /* synthetic */ void w(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int[] iArr, int i12) {
            super.w(coordinatorLayout, appBarLayout, view, i10, i11, iArr, i12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: t0 */
        public /* bridge */ /* synthetic */ void z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            super.z(coordinatorLayout, appBarLayout, view, i10, i11, i12, i13, i14, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: u0 */
        public /* bridge */ /* synthetic */ void D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.D(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: v0 */
        public /* bridge */ /* synthetic */ Parcelable E(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.E(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: w0 */
        public /* bridge */ /* synthetic */ boolean G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
            return super.G(coordinatorLayout, appBarLayout, view, view2, i10, i11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: x0 */
        public /* bridge */ /* synthetic */ void I(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10) {
            super.I(coordinatorLayout, appBarLayout, view, i10);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class ScrollingViewBehavior extends j {
        public ScrollingViewBehavior() {
        }

        private static int X(AppBarLayout appBarLayout) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (f10 instanceof BaseBehavior) {
                return ((BaseBehavior) f10).S();
            }
            return 0;
        }

        private void Y(View view, View view2) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (f10 instanceof BaseBehavior) {
                d1.b0(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) f10).f٨١٤٨k) + S()) - O(view2));
            }
        }

        private void Z(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.o()) {
                    appBarLayout.C(appBarLayout.F(view));
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean C(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
            AppBarLayout N = N(coordinatorLayout.x(view));
            if (N != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.f٨٢٢٥d;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    N.z(false, !z10);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.j
        float P(View view) {
            int i10;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int X = X(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + X > downNestedPreScrollRange) && (i10 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (X / i10) + 1.0f;
                }
            }
            return DownloadProgress.UNKNOWN_PROGRESS;
        }

        @Override // com.google.android.material.appbar.j
        int R(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.R(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.j
        /* renamed from: W, reason: merged with bridge method [inline-methods] */
        public AppBarLayout N(List list) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = (View) list.get(i10);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Y(view, view2);
            Z(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void o(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                d1.q0(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.k, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean r(CoordinatorLayout coordinatorLayout, View view, int i10) {
            return super.r(coordinatorLayout, view, i10);
        }

        @Override // com.google.android.material.appbar.j, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean s(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
            return super.s(coordinatorLayout, view, i10, i11, i12, i13);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            U(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements j0 {
        a() {
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            return AppBarLayout.this.w(d2Var);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void onOffsetChanged(AppBarLayout appBarLayout, int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class c {
        public abstract void a(AppBarLayout appBarLayout, View view, float f10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d extends c {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f٨١٦٥a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        private final Rect f٨١٦٦b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, View view, float f10) {
            b(this.f٨١٦٥a, appBarLayout, view);
            float abs = this.f٨١٦٥a.top - Math.abs(f10);
            if (abs <= DownloadProgress.UNKNOWN_PROGRESS) {
                float a10 = 1.0f - j2.a.a(Math.abs(abs / this.f٨١٦٥a.height()), DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
                float height = (-abs) - ((this.f٨١٦٥a.height() * 0.3f) * (1.0f - (a10 * a10)));
                view.setTranslationY(height);
                view.getDrawingRect(this.f٨١٦٦b);
                this.f٨١٦٦b.offset(0, (int) (-height));
                if (height >= this.f٨١٦٦b.height()) {
                    view.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
                } else {
                    view.setAlpha(1.0f);
                }
                view.setClipBounds(this.f٨١٦٦b);
                return;
            }
            view.setClipBounds(null);
            view.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
            view.setAlpha(1.0f);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface f {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class g {
        public abstract void a(float f10, int i10, float f11);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface h extends b {
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    private void A(boolean z10, boolean z11, boolean z12) {
        int i10;
        int i11;
        if (z10) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        int i12 = 0;
        if (z11) {
            i11 = 4;
        } else {
            i11 = 0;
        }
        int i13 = i10 | i11;
        if (z12) {
            i12 = 8;
        }
        this.f٨١٢٧f = i13 | i12;
        requestLayout();
    }

    private boolean B(boolean z10) {
        if (this.f٨١٣١j != z10) {
            this.f٨١٣١j = z10;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    private boolean E() {
        if (this.f٨١٤٥x != null && getTopInset() > 0) {
            return true;
        }
        return false;
    }

    private boolean G() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8 || childAt.getFitsSystemWindows()) {
            return false;
        }
        return true;
    }

    private void H(float f10, float f11) {
        ValueAnimator valueAnimator = this.f٨١٣٧p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, f11);
        this.f٨١٣٧p = ofFloat;
        ofFloat.setDuration(this.f٨١٤١t);
        this.f٨١٣٧p.setInterpolator(this.f٨١٤٢u);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f٨١٣٨q;
        if (animatorUpdateListener != null) {
            this.f٨١٣٧p.addUpdateListener(animatorUpdateListener);
        }
        this.f٨١٣٧p.start();
    }

    private void I() {
        setWillNotDraw(!E());
    }

    private void c() {
        WeakReference weakReference = this.f٨١٣٦o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f٨١٣٦o = null;
    }

    private Integer d() {
        Drawable drawable = this.f٨١٤٥x;
        if (drawable instanceof f8.i) {
            return Integer.valueOf(((f8.i) drawable).G());
        }
        ColorStateList g10 = com.google.android.material.drawable.g.g(drawable);
        if (g10 != null) {
            return Integer.valueOf(g10.getDefaultColor());
        }
        return null;
    }

    private View e(View view) {
        int i10;
        View view2;
        if (this.f٨١٣٦o == null && (i10 = this.f٨١٣٥n) != -1) {
            if (view != null) {
                view2 = view.findViewById(i10);
            } else {
                view2 = null;
            }
            if (view2 == null && (getParent() instanceof ViewGroup)) {
                view2 = ((ViewGroup) getParent()).findViewById(this.f٨١٣٥n);
            }
            if (view2 != null) {
                this.f٨١٣٦o = new WeakReference(view2);
            }
        }
        WeakReference weakReference = this.f٨١٣٦o;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    private boolean j() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((e) getChildAt(i10).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void l(final f8.i iVar, final ColorStateList colorStateList) {
        final Integer f10 = v7.a.f(getContext(), R.attr.colorSurface);
        this.f٨١٣٨q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.this.r(colorStateList, iVar, f10, valueAnimator);
            }
        };
    }

    private void m(Context context, final f8.i iVar) {
        iVar.V(context);
        this.f٨١٣٨q = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.this.s(iVar, valueAnimator);
            }
        };
    }

    private void n() {
        BaseBehavior.SavedState savedState;
        Behavior behavior = this.A;
        if (behavior != null && this.f٨١٢٣b != -1 && this.f٨١٢٧f == 0) {
            savedState = behavior.z0(AbsSavedState.EMPTY_STATE, this);
        } else {
            savedState = null;
        }
        this.f٨١٢٣b = -1;
        this.f٨١٢٤c = -1;
        this.f٨١٢٥d = -1;
        if (savedState != null) {
            this.A.y0(savedState, false);
        }
    }

    private boolean p() {
        return getBackground() instanceof f8.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(ColorStateList colorStateList, f8.i iVar, Integer num, ValueAnimator valueAnimator) {
        Integer num2;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int k10 = v7.a.k(this.f٨١٤٤w, colorStateList.getDefaultColor(), floatValue);
        iVar.h0(ColorStateList.valueOf(k10));
        if (this.f٨١٤٥x != null && (num2 = this.f٨١٤٦y) != null && num2.equals(num)) {
            this.f٨١٤٥x.setTint(k10);
        }
        if (!this.f٨١٣٩r.isEmpty()) {
            Iterator it = this.f٨١٣٩r.iterator();
            while (it.hasNext()) {
                a0.a(it.next());
                if (iVar.D() != null) {
                    throw null;
                }
            }
        }
        if (!this.f٨١٤٠s.isEmpty()) {
            Iterator it2 = this.f٨١٤٠s.iterator();
            while (it2.hasNext()) {
                ((g) it2.next()).a(DownloadProgress.UNKNOWN_PROGRESS, k10, floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(f8.i iVar, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        iVar.g0(floatValue);
        Drawable drawable = this.f٨١٤٥x;
        if (drawable instanceof f8.i) {
            ((f8.i) drawable).g0(floatValue);
        }
        Iterator it = this.f٨١٣٩r.iterator();
        if (!it.hasNext()) {
            Iterator it2 = this.f٨١٤٠s.iterator();
            while (it2.hasNext()) {
                ((g) it2.next()).a(floatValue, iVar.G(), floatValue / this.f٨١٤٧z);
            }
        } else {
            a0.a(it.next());
            iVar.G();
            throw null;
        }
    }

    private f8.i t(Drawable drawable) {
        if (drawable instanceof f8.i) {
            return (f8.i) drawable;
        }
        ColorStateList g10 = com.google.android.material.drawable.g.g(drawable);
        if (g10 == null) {
            return null;
        }
        f8.i iVar = new f8.i();
        iVar.h0(g10);
        return iVar;
    }

    private Drawable u(Context context, Drawable drawable) {
        f8.i t10 = t(drawable);
        if (t10 != null && t10.D() != null) {
            this.f٨١٤٤w = t10.D().getDefaultColor();
            ColorStateList colorStateList = this.f٨١٣٤m;
            if (colorStateList != null) {
                l(t10, colorStateList);
            } else {
                m(context, t10);
            }
            return t10;
        }
        return drawable;
    }

    boolean C(boolean z10) {
        return D(z10, !this.f٨١٣٠i);
    }

    boolean D(boolean z10, boolean z11) {
        float f10;
        float f11;
        if (z11 && this.f٨١٣٢k != z10) {
            this.f٨١٣٢k = z10;
            refreshDrawableState();
            if (p()) {
                ColorStateList colorStateList = this.f٨١٣٤m;
                float f12 = DownloadProgress.UNKNOWN_PROGRESS;
                if (colorStateList != null) {
                    if (z10) {
                        f11 = DownloadProgress.UNKNOWN_PROGRESS;
                    } else {
                        f11 = 1.0f;
                    }
                    if (z10) {
                        f12 = 1.0f;
                    }
                    H(f11, f12);
                    return true;
                }
                if (this.f٨١٣٣l) {
                    if (z10) {
                        f10 = DownloadProgress.UNKNOWN_PROGRESS;
                    } else {
                        f10 = this.f٨١٤٧z;
                    }
                    if (z10) {
                        f12 = this.f٨١٤٧z;
                    }
                    H(f10, f12);
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    boolean F(View view) {
        View e10 = e(view);
        if (e10 != null) {
            view = e10;
        }
        if (view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0)) {
            return true;
        }
        return false;
    }

    @Deprecated
    public void addLiftOnScrollListener(f fVar) {
        this.f٨١٣٩r.add(fVar);
    }

    public void addLiftOnScrollProgressListener(g gVar) {
        this.f٨١٤٠s.add(gVar);
    }

    public void addOnOffsetChangedListener(b bVar) {
        if (this.f٨١٢٩h == null) {
            this.f٨١٢٩h = new ArrayList();
        }
        if (bVar == null || this.f٨١٢٩h.contains(bVar)) {
            return;
        }
        this.f٨١٢٩h.add(bVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (E()) {
            int save = canvas.save();
            canvas.translate(DownloadProgress.UNKNOWN_PROGRESS, -this.f٨١٢٢a);
            this.f٨١٤٥x.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f٨١٤٥x;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c getBehavior() {
        Behavior behavior = new Behavior();
        this.A = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int i10;
        int minimumHeight;
        int i11 = this.f٨١٢٤c;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = eVar.f٨١٦٧a;
                if ((i13 & 5) == 5) {
                    int i14 = ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    if ((i13 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i13 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        i10 = i14 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            i10 = Math.min(i10, measuredHeight - getTopInset());
                        }
                        i12 += i10;
                    }
                    i10 = i14 + minimumHeight;
                    if (childCount == 0) {
                        i10 = Math.min(i10, measuredHeight - getTopInset());
                    }
                    i12 += i10;
                } else if (i12 > 0) {
                    break;
                }
            }
        }
        int max = Math.max(0, i12);
        this.f٨١٢٤c = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i10 = this.f٨١٢٥d;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                int i13 = eVar.f٨١٦٧a;
                if ((i13 & 1) == 0) {
                    break;
                }
                i12 += measuredHeight;
                if ((i13 & 2) != 0) {
                    i12 -= childAt.getMinimumHeight();
                    break;
                }
            }
            i11++;
        }
        int max = Math.max(0, i12);
        this.f٨١٢٥d = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f٨١٣٥n;
    }

    public f8.i getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof f8.i) {
            return (f8.i) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int i10;
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i11 = (minimumHeight * 2) + topInset;
            if (i11 >= getHeight()) {
                return minimumHeight + topInset;
            }
            return i11;
        }
        int childCount = getChildCount();
        if (childCount >= 1) {
            i10 = getChildAt(childCount - 1).getMinimumHeight();
        } else {
            i10 = 0;
        }
        if (i10 != 0) {
            int i12 = (i10 * 2) + topInset;
            if (i12 >= getHeight()) {
                return i10 + topInset;
            }
            return i12;
        }
        return getHeight() / 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.f٨١٢٧f;
    }

    public Drawable getStatusBarForeground() {
        return this.f٨١٤٥x;
    }

    @Deprecated
    public float getTargetElevation() {
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    @VisibleForTesting
    final int getTopInset() {
        d2 d2Var = this.f٨١٢٨g;
        if (d2Var != null) {
            return d2Var.m();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i10 = this.f٨١٢٣b;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = eVar.f٨١٦٧a;
                if ((i13 & 1) == 0) {
                    break;
                }
                i12 += measuredHeight + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                if (i11 == 0 && childAt.getFitsSystemWindows()) {
                    i12 -= getTopInset();
                }
                if ((i13 & 2) != 0) {
                    i12 -= childAt.getMinimumHeight();
                    break;
                }
            }
            i11++;
        }
        int max = Math.max(0, i12);
        this.f٨١٢٣b = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new e((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    boolean i() {
        return this.f٨١٢٦e;
    }

    boolean k() {
        if (getTotalScrollRange() != 0) {
            return true;
        }
        return false;
    }

    public boolean o() {
        return this.f٨١٣٣l;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f8.j.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int i11;
        int i12;
        if (this.f٨١٤٣v == null) {
            this.f٨١٤٣v = new int[4];
        }
        int[] iArr = this.f٨١٤٣v;
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + iArr.length);
        boolean z10 = this.f٨١٣١j;
        int i13 = R.attr.state_liftable;
        if (!z10) {
            i13 = -i13;
        }
        iArr[0] = i13;
        if (z10 && this.f٨١٣٢k) {
            i11 = R.attr.state_lifted;
        } else {
            i11 = -R.attr.state_lifted;
        }
        iArr[1] = i11;
        int i14 = R.attr.state_collapsible;
        if (!z10) {
            i14 = -i14;
        }
        iArr[2] = i14;
        if (z10 && this.f٨١٣٢k) {
            i12 = R.attr.state_collapsed;
        } else {
            i12 = -R.attr.state_collapsed;
        }
        iArr[3] = i12;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        boolean z11 = true;
        if (getFitsSystemWindows() && G()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                d1.b0(getChildAt(childCount), topInset);
            }
        }
        n();
        this.f٨١٢٦e = false;
        int childCount2 = getChildCount();
        int i14 = 0;
        while (true) {
            if (i14 >= childCount2) {
                break;
            }
            if (((e) getChildAt(i14).getLayoutParams()).d() != null) {
                this.f٨١٢٦e = true;
                break;
            }
            i14++;
        }
        Drawable drawable = this.f٨١٤٥x;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f٨١٣٠i) {
            if (!this.f٨١٣٣l && !j()) {
                z11 = false;
            }
            B(z11);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != 1073741824 && getFitsSystemWindows() && G()) {
            int measuredHeight = getMeasuredHeight();
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    measuredHeight += getTopInset();
                }
            } else {
                measuredHeight = j2.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i11));
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        n();
    }

    public boolean q() {
        return this.f٨١٣٢k;
    }

    public void removeOnOffsetChangedListener(b bVar) {
        List list = this.f٨١٢٩h;
        if (list == null || bVar == null) {
            return;
        }
        list.remove(bVar);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(u(getContext(), drawable));
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        f8.j.d(this, f10);
    }

    public void setExpanded(boolean z10) {
        z(z10, isLaidOut());
    }

    public void setLiftOnScroll(boolean z10) {
        this.f٨١٣٣l = z10;
    }

    public void setLiftOnScrollColor(ColorStateList colorStateList) {
        if (this.f٨١٣٤m != colorStateList) {
            this.f٨١٣٤m = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f٨١٣٥n = -1;
        if (view == null) {
            c();
        } else {
            this.f٨١٣٦o = new WeakReference(view);
        }
    }

    public void setLiftOnScrollTargetViewId(int i10) {
        this.f٨١٣٥n = i10;
        c();
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.f٨١٣٠i = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (i10 == 1) {
            super.setOrientation(i10);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPendingAction(int i10) {
        this.f٨١٢٧f = i10;
    }

    public void setStatusBarForeground(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.f٨١٤٥x;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f٨١٤٥x = drawable3;
            this.f٨١٤٦y = d();
            Drawable drawable4 = this.f٨١٤٥x;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.f٨١٤٥x.setState(getDrawableState());
                }
                h2.b.m(this.f٨١٤٥x, getLayoutDirection());
                Drawable drawable5 = this.f٨١٤٥x;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable5.setVisible(z10, false);
                this.f٨١٤٥x.setCallback(this);
            }
            I();
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i10) {
        setStatusBarForeground(new ColorDrawable(i10));
    }

    public void setStatusBarForegroundResource(int i10) {
        setStatusBarForeground(r1.a.b(getContext(), i10));
    }

    @Deprecated
    public void setTargetElevation(float f10) {
        m.b(this, f10);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        boolean z10;
        super.setVisibility(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable = this.f٨١٤٥x;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    void v(int i10) {
        this.f٨١٢٢a = i10;
        if (!willNotDraw()) {
            postInvalidateOnAnimation();
        }
        List list = this.f٨١٢٩h;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                b bVar = (b) this.f٨١٢٩h.get(i11);
                if (bVar != null) {
                    bVar.onOffsetChanged(this, i10);
                }
            }
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f٨١٤٥x) {
            return false;
        }
        return true;
    }

    d2 w(d2 d2Var) {
        d2 d2Var2;
        if (getFitsSystemWindows()) {
            d2Var2 = d2Var;
        } else {
            d2Var2 = null;
        }
        if (!androidx.core.util.f.a(this.f٨١٢٨g, d2Var2)) {
            this.f٨١٢٨g = d2Var2;
            I();
            requestLayout();
        }
        return d2Var;
    }

    public boolean x(g gVar) {
        return this.f٨١٤٠s.remove(gVar);
    }

    void y() {
        this.f٨١٢٧f = 0;
    }

    public void z(boolean z10, boolean z11) {
        A(z10, z11, true);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f٨١٢١B;
        this.f٨١٢٣b = -1;
        this.f٨١٢٤c = -1;
        this.f٨١٢٥d = -1;
        this.f٨١٢٧f = 0;
        this.f٨١٣٩r = new ArrayList();
        this.f٨١٤٠s = new LinkedHashSet();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            m.a(this);
        }
        m.c(this, attributeSet, i10, i11);
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.AppBarLayout, i10, i11, new int[0]);
        this.f٨١٣٤m = c8.c.a(context2, i12, R.styleable.AppBarLayout_liftOnScrollColor);
        this.f٨١٤١t = a8.k.f(context2, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.f٨١٤٢u = a8.k.g(context2, R.attr.motionEasingStandardInterpolator, p7.a.f١٦٩٤٧a);
        int i13 = R.styleable.AppBarLayout_expanded;
        if (i12.hasValue(i13)) {
            A(i12.getBoolean(i13, false), false, false);
        }
        if (i12.hasValue(R.styleable.AppBarLayout_elevation)) {
            m.b(this, i12.getDimensionPixelSize(r11, 0));
        }
        setBackground(i12.getDrawable(R.styleable.AppBarLayout_android_background));
        if (Build.VERSION.SDK_INT >= 26) {
            int i14 = R.styleable.AppBarLayout_android_keyboardNavigationCluster;
            if (i12.hasValue(i14)) {
                setKeyboardNavigationCluster(i12.getBoolean(i14, false));
            }
            int i15 = R.styleable.AppBarLayout_android_touchscreenBlocksFocus;
            if (i12.hasValue(i15)) {
                setTouchscreenBlocksFocus(i12.getBoolean(i15, false));
            }
        }
        this.f٨١٤٧z = getResources().getDimension(R.dimen.design_appbar_elevation);
        this.f٨١٣٣l = i12.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        this.f٨١٣٥n = i12.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(i12.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
        i12.recycle();
        d1.E0(this, new a());
    }

    public void removeOnOffsetChangedListener(h hVar) {
        removeOnOffsetChangedListener((b) hVar);
    }

    public void addOnOffsetChangedListener(h hVar) {
        addOnOffsetChangedListener((b) hVar);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class e extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f٨١٦٧a;

        /* renamed from: b, reason: collision with root package name */
        private c f٨١٦٨b;

        /* renamed from: c, reason: collision with root package name */
        Interpolator f٨١٦٩c;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f٨١٦٧a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f٨١٦٧a = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            f(obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            int i10 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (obtainStyledAttributes.hasValue(i10)) {
                this.f٨١٦٩c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i10, 0));
            }
            obtainStyledAttributes.recycle();
        }

        private c a(int i10) {
            if (i10 != 1) {
                return null;
            }
            return new d();
        }

        public c b() {
            return this.f٨١٦٨b;
        }

        public int c() {
            return this.f٨١٦٧a;
        }

        public Interpolator d() {
            return this.f٨١٦٩c;
        }

        boolean e() {
            int i10 = this.f٨١٦٧a;
            if ((i10 & 1) == 1 && (i10 & 10) != 0) {
                return true;
            }
            return false;
        }

        public void f(int i10) {
            this.f٨١٦٨b = a(i10);
        }

        public void g(int i10) {
            this.f٨١٦٧a = i10;
        }

        public e(int i10, int i11) {
            super(i10, i11);
            this.f٨١٦٧a = 1;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f٨١٦٧a = 1;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f٨١٦٧a = 1;
        }

        public e(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f٨١٦٧a = 1;
        }
    }
}
