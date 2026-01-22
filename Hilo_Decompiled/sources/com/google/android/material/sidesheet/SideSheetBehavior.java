package com.google.android.material.sidesheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d1;
import androidx.customview.view.AbsSavedState;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.material.R;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import m2.g0;
import m2.j0;
import s2.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c implements com.google.android.material.sidesheet.c {

    /* renamed from: a, reason: collision with root package name */
    private e f٩٨٦٧a;

    /* renamed from: b, reason: collision with root package name */
    private float f٩٨٦٨b;

    /* renamed from: c, reason: collision with root package name */
    private f8.i f٩٨٦٩c;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f٩٨٧٠d;

    /* renamed from: e, reason: collision with root package name */
    private o f٩٨٧١e;

    /* renamed from: f, reason: collision with root package name */
    private final c f٩٨٧٢f;

    /* renamed from: g, reason: collision with root package name */
    private float f٩٨٧٣g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٩٨٧٤h;

    /* renamed from: i, reason: collision with root package name */
    private int f٩٨٧٥i;

    /* renamed from: j, reason: collision with root package name */
    private int f٩٨٧٦j;

    /* renamed from: k, reason: collision with root package name */
    private s2.c f٩٨٧٧k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٩٨٧٨l;

    /* renamed from: m, reason: collision with root package name */
    private float f٩٨٧٩m;

    /* renamed from: n, reason: collision with root package name */
    private int f٩٨٨٠n;

    /* renamed from: o, reason: collision with root package name */
    private int f٩٨٨١o;

    /* renamed from: p, reason: collision with root package name */
    private int f٩٨٨٢p;

    /* renamed from: q, reason: collision with root package name */
    private int f٩٨٨٣q;

    /* renamed from: r, reason: collision with root package name */
    private WeakReference f٩٨٨٤r;

    /* renamed from: s, reason: collision with root package name */
    private WeakReference f٩٨٨٥s;

    /* renamed from: t, reason: collision with root package name */
    private int f٩٨٨٦t;

    /* renamed from: u, reason: collision with root package name */
    private VelocityTracker f٩٨٨٧u;

    /* renamed from: v, reason: collision with root package name */
    private a8.j f٩٨٨٨v;

    /* renamed from: w, reason: collision with root package name */
    private int f٩٨٨٩w;

    /* renamed from: x, reason: collision with root package name */
    private final Set f٩٨٩٠x;

    /* renamed from: y, reason: collision with root package name */
    private final c.AbstractC٠٢٢٦c f٩٨٩١y;

    /* renamed from: z, reason: collision with root package name */
    private static final int f٩٨٦٦z = R.string.side_sheet_accessibility_pane_title;
    private static final int A = R.style.Widget_Material3_SideSheet;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends c.AbstractC٠٢٢٦c {
        a() {
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            return j2.a.b(i10, SideSheetBehavior.this.f٩٨٦٧a.g(), SideSheetBehavior.this.f٩٨٦٧a.f());
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int getViewHorizontalDragRange(View view) {
            return SideSheetBehavior.this.f٩٨٨٠n + SideSheetBehavior.this.o0();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewDragStateChanged(int i10) {
            if (i10 == 1 && SideSheetBehavior.this.f٩٨٧٤h) {
                SideSheetBehavior.this.M0(1);
            }
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View j02 = SideSheetBehavior.this.j0();
            if (j02 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) j02.getLayoutParams()) != null) {
                SideSheetBehavior.this.f٩٨٦٧a.p(marginLayoutParams, view.getLeft(), view.getRight());
                j02.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.d0(view, i10);
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewReleased(View view, float f10, float f11) {
            int Z = SideSheetBehavior.this.Z(view, f10, f11);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.R0(view, Z, sideSheetBehavior.Q0());
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public boolean tryCaptureView(View view, int i10) {
            if (SideSheetBehavior.this.f٩٨٧٥i == 1 || SideSheetBehavior.this.f٩٨٨٤r == null || SideSheetBehavior.this.f٩٨٨٤r.get() != view) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SideSheetBehavior.this.M0(5);
            if (SideSheetBehavior.this.f٩٨٨٤r != null && SideSheetBehavior.this.f٩٨٨٤r.get() != null) {
                ((View) SideSheetBehavior.this.f٩٨٨٤r.get()).requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private int f٩٨٩٥a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f٩٨٩٦b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f٩٨٩٧c = new Runnable() { // from class: com.google.android.material.sidesheet.k
            @Override // java.lang.Runnable
            public final void run() {
                SideSheetBehavior.c.this.c();
            }
        };

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f٩٨٩٦b = false;
            if (SideSheetBehavior.this.f٩٨٧٧k != null && SideSheetBehavior.this.f٩٨٧٧k.n(true)) {
                b(this.f٩٨٩٥a);
            } else if (SideSheetBehavior.this.f٩٨٧٥i == 2) {
                SideSheetBehavior.this.M0(this.f٩٨٩٥a);
            }
        }

        void b(int i10) {
            if (SideSheetBehavior.this.f٩٨٨٤r != null && SideSheetBehavior.this.f٩٨٨٤r.get() != null) {
                this.f٩٨٩٥a = i10;
                if (!this.f٩٨٩٦b) {
                    ((View) SideSheetBehavior.this.f٩٨٨٤r.get()).postOnAnimation(this.f٩٨٩٧c);
                    this.f٩٨٩٦b = true;
                }
            }
        }
    }

    public SideSheetBehavior() {
        this.f٩٨٧٢f = new c();
        this.f٩٨٧٤h = true;
        this.f٩٨٧٥i = 5;
        this.f٩٨٧٦j = 5;
        this.f٩٨٧٩m = 0.1f;
        this.f٩٨٨٦t = -1;
        this.f٩٨٩٠x = new LinkedHashSet();
        this.f٩٨٩١y = new a();
    }

    private boolean A0(View view, int i10, boolean z10) {
        int p02 = p0(i10);
        s2.c t02 = t0();
        if (t02 != null && (!z10 ? t02.R(view, p02, view.getTop()) : t02.P(p02, view.getTop()))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean B0(int i10, View view, j0.a aVar) {
        c(i10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, View view, ValueAnimator valueAnimator) {
        this.f٩٨٦٧a.o(marginLayoutParams, p7.a.c(i10, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(int i10) {
        View view = (View) this.f٩٨٨٤r.get();
        if (view != null) {
            R0(view, i10, false);
        }
    }

    private void E0(CoordinatorLayout coordinatorLayout) {
        int i10;
        View findViewById;
        if (this.f٩٨٨٥s == null && (i10 = this.f٩٨٨٦t) != -1 && (findViewById = coordinatorLayout.findViewById(i10)) != null) {
            this.f٩٨٨٥s = new WeakReference(findViewById);
        }
    }

    private void F0(View view, g0.a aVar, int i10) {
        d1.m0(view, aVar, null, b0(i10));
    }

    private void G0() {
        VelocityTracker velocityTracker = this.f٩٨٨٧u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f٩٨٨٧u = null;
        }
    }

    private void H0(View view, Runnable runnable) {
        if (z0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void K0(int i10) {
        e eVar = this.f٩٨٦٧a;
        if (eVar != null && eVar.j() == i10) {
            return;
        }
        if (i10 == 0) {
            this.f٩٨٦٧a = new com.google.android.material.sidesheet.b(this);
            if (this.f٩٨٧١e != null && !w0()) {
                o.b w10 = this.f٩٨٧١e.w();
                w10.I(DownloadProgress.UNKNOWN_PROGRESS).z(DownloadProgress.UNKNOWN_PROGRESS);
                U0(w10.m());
                return;
            }
            return;
        }
        if (i10 == 1) {
            this.f٩٨٦٧a = new com.google.android.material.sidesheet.a(this);
            if (this.f٩٨٧١e != null && !v0()) {
                o.b w11 = this.f٩٨٧١e.w();
                w11.E(DownloadProgress.UNKNOWN_PROGRESS).v(DownloadProgress.UNKNOWN_PROGRESS);
                U0(w11.m());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid sheet edge position value: " + i10 + ". Must be 0 or 1" + InstructionFileId.DOT);
    }

    private void L0(View view, int i10) {
        int i11;
        if (Gravity.getAbsoluteGravity(((CoordinatorLayout.f) view.getLayoutParams()).f٢٥٦٢c, i10) == 3) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        K0(i11);
    }

    private boolean N0() {
        if (this.f٩٨٧٧k != null && (this.f٩٨٧٤h || this.f٩٨٧٥i == 1)) {
            return true;
        }
        return false;
    }

    private boolean P0(View view) {
        if ((view.isShown() || d1.r(view) != null) && this.f٩٨٧٤h) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(View view, int i10, boolean z10) {
        if (A0(view, i10, z10)) {
            M0(2);
            this.f٩٨٧٢f.b(i10);
        } else {
            M0(i10);
        }
    }

    private void S0() {
        View view;
        WeakReference weakReference = this.f٩٨٨٤r;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        d1.k0(view, 262144);
        d1.k0(view, Constants.MB);
        if (this.f٩٨٧٥i != 5) {
            F0(view, g0.a.f١٥٩٤٦y, 5);
        }
        if (this.f٩٨٧٥i != 3) {
            F0(view, g0.a.f١٥٩٤٤w, 3);
        }
    }

    private void T0() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference weakReference = this.f٩٨٨٤r;
        if (weakReference != null && weakReference.get() != null) {
            View view = (View) this.f٩٨٨٤r.get();
            View j02 = j0();
            if (j02 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) j02.getLayoutParams()) == null) {
                return;
            }
            this.f٩٨٦٧a.o(marginLayoutParams, (int) ((this.f٩٨٨٠n * view.getScaleX()) + this.f٩٨٨٣q));
            j02.requestLayout();
        }
    }

    private void U0(o oVar) {
        f8.i iVar = this.f٩٨٦٩c;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(oVar);
        }
    }

    private void V0(View view) {
        int i10;
        if (this.f٩٨٧٥i == 5) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        if (view.getVisibility() != i10) {
            view.setVisibility(i10);
        }
    }

    private int X(int i10, View view) {
        int i11 = this.f٩٨٧٥i;
        if (i11 != 1 && i11 != 2) {
            if (i11 != 3) {
                if (i11 == 5) {
                    return this.f٩٨٦٧a.e();
                }
                throw new IllegalStateException("Unexpected value: " + this.f٩٨٧٥i);
            }
            return 0;
        }
        return i10 - this.f٩٨٦٧a.h(view);
    }

    private float Y(float f10, float f11) {
        return Math.abs(f10 - f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Z(View view, float f10, float f11) {
        if (y0(f10)) {
            return 3;
        }
        if (O0(view, f10)) {
            if (!this.f٩٨٦٧a.m(f10, f11) && !this.f٩٨٦٧a.l(view)) {
                return 3;
            }
        } else if (f10 == DownloadProgress.UNKNOWN_PROGRESS || !g.a(f10, f11)) {
            int left = view.getLeft();
            if (Math.abs(left - k0()) < Math.abs(left - this.f٩٨٦٧a.e())) {
                return 3;
            }
        }
        return 5;
    }

    private void a0() {
        WeakReference weakReference = this.f٩٨٨٥s;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f٩٨٨٥s = null;
    }

    private j0 b0(final int i10) {
        return new j0() { // from class: com.google.android.material.sidesheet.i
            @Override // m2.j0
            public final boolean perform(View view, j0.a aVar) {
                boolean B0;
                B0 = SideSheetBehavior.this.B0(i10, view, aVar);
                return B0;
            }
        };
    }

    private void c0(Context context) {
        if (this.f٩٨٧١e == null) {
            return;
        }
        f8.i iVar = new f8.i(this.f٩٨٧١e);
        this.f٩٨٦٩c = iVar;
        iVar.V(context);
        ColorStateList colorStateList = this.f٩٨٧٠d;
        if (colorStateList != null) {
            this.f٩٨٦٩c.h0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
        this.f٩٨٦٩c.setTint(typedValue.data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(View view, int i10) {
        if (!this.f٩٨٩٠x.isEmpty()) {
            float b10 = this.f٩٨٦٧a.b(i10);
            Iterator it = this.f٩٨٩٠x.iterator();
            while (it.hasNext()) {
                ((d) it.next()).b(view, b10);
            }
        }
    }

    private void e0(View view) {
        if (d1.r(view) == null) {
            d1.s0(view, view.getResources().getString(f٩٨٦٦z));
        }
    }

    public static SideSheetBehavior f0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) layoutParams).f();
            if (f10 instanceof SideSheetBehavior) {
                return (SideSheetBehavior) f10;
            }
            throw new IllegalArgumentException("The view is not associated with SideSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int g0(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                i12 = Math.min(size, i12);
            }
            return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
    }

    private ValueAnimator.AnimatorUpdateListener i0() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final View j02 = j0();
        if (j02 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) j02.getLayoutParams()) == null) {
            return null;
        }
        final int c10 = this.f٩٨٦٧a.c(marginLayoutParams);
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.sidesheet.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SideSheetBehavior.this.C0(marginLayoutParams, c10, j02, valueAnimator);
            }
        };
    }

    private int l0() {
        e eVar = this.f٩٨٦٧a;
        if (eVar == null || eVar.j() == 0) {
            return 5;
        }
        return 3;
    }

    private CoordinatorLayout.f u0() {
        View view;
        WeakReference weakReference = this.f٩٨٨٤r;
        if (weakReference != null && (view = (View) weakReference.get()) != null && (view.getLayoutParams() instanceof CoordinatorLayout.f)) {
            return (CoordinatorLayout.f) view.getLayoutParams();
        }
        return null;
    }

    private boolean v0() {
        CoordinatorLayout.f u02 = u0();
        if (u02 != null && ((ViewGroup.MarginLayoutParams) u02).leftMargin > 0) {
            return true;
        }
        return false;
    }

    private boolean w0() {
        CoordinatorLayout.f u02 = u0();
        if (u02 != null && ((ViewGroup.MarginLayoutParams) u02).rightMargin > 0) {
            return true;
        }
        return false;
    }

    private boolean x0(MotionEvent motionEvent) {
        if (!N0() || Y(this.f٩٨٨٩w, motionEvent.getX()) <= this.f٩٨٧٧k.A()) {
            return false;
        }
        return true;
    }

    private boolean y0(float f10) {
        return this.f٩٨٦٧a.k(f10);
    }

    private boolean z0(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void D(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.D(coordinatorLayout, view, savedState.getSuperState());
        }
        int i10 = savedState.f٩٨٩٢a;
        if (i10 == 1 || i10 == 2) {
            i10 = 5;
        }
        this.f٩٨٧٥i = i10;
        this.f٩٨٧٦j = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable E(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.E(coordinatorLayout, view), this);
    }

    public void I0(int i10) {
        this.f٩٨٨٦t = i10;
        a0();
        WeakReference weakReference = this.f٩٨٨٤r;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (i10 != -1 && view.isLaidOut()) {
                view.requestLayout();
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f٩٨٧٥i == 1 && actionMasked == 0) {
            return true;
        }
        if (N0()) {
            this.f٩٨٧٧k.G(motionEvent);
        }
        if (actionMasked == 0) {
            G0();
        }
        if (this.f٩٨٨٧u == null) {
            this.f٩٨٨٧u = VelocityTracker.obtain();
        }
        this.f٩٨٨٧u.addMovement(motionEvent);
        if (N0() && actionMasked == 2 && !this.f٩٨٧٨l && x0(motionEvent)) {
            this.f٩٨٧٧k.c(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f٩٨٧٨l;
    }

    public void J0(boolean z10) {
        this.f٩٨٧٤h = z10;
    }

    void M0(int i10) {
        View view;
        if (this.f٩٨٧٥i == i10) {
            return;
        }
        this.f٩٨٧٥i = i10;
        if (i10 == 3 || i10 == 5) {
            this.f٩٨٧٦j = i10;
        }
        WeakReference weakReference = this.f٩٨٨٤r;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        V0(view);
        Iterator it = this.f٩٨٩٠x.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(view, i10);
        }
        S0();
    }

    boolean O0(View view, float f10) {
        return this.f٩٨٦٧a.n(view, f10);
    }

    public boolean Q0() {
        return true;
    }

    @Override // com.google.android.material.sidesheet.c
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public void b(l lVar) {
        this.f٩٨٩٠x.add(lVar);
    }

    @Override // a8.b
    public void a() {
        a8.j jVar = this.f٩٨٨٨v;
        if (jVar == null) {
            return;
        }
        jVar.f();
    }

    @Override // com.google.android.material.sidesheet.c
    public void c(final int i10) {
        String str;
        if (i10 != 1 && i10 != 2) {
            WeakReference weakReference = this.f٩٨٨٤r;
            if (weakReference != null && weakReference.get() != null) {
                H0((View) this.f٩٨٨٤r.get(), new Runnable() { // from class: com.google.android.material.sidesheet.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        SideSheetBehavior.this.D0(i10);
                    }
                });
                return;
            } else {
                M0(i10);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("STATE_");
        if (i10 == 1) {
            str = "DRAGGING";
        } else {
            str = "SETTLING";
        }
        sb.append(str);
        sb.append(" should not be set externally.");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // a8.b
    public void d(BackEventCompat backEventCompat) {
        a8.j jVar = this.f٩٨٨٨v;
        if (jVar == null) {
            return;
        }
        jVar.j(backEventCompat);
    }

    @Override // a8.b
    public void e(BackEventCompat backEventCompat) {
        a8.j jVar = this.f٩٨٨٨v;
        if (jVar == null) {
            return;
        }
        jVar.l(backEventCompat, l0());
        T0();
    }

    @Override // a8.b
    public void f() {
        a8.j jVar = this.f٩٨٨٨v;
        if (jVar == null) {
            return;
        }
        BackEventCompat c10 = jVar.c();
        if (c10 != null && Build.VERSION.SDK_INT >= 34) {
            this.f٩٨٨٨v.h(c10, l0(), new b(), i0());
        } else {
            c(5);
        }
    }

    @Override // com.google.android.material.sidesheet.c
    public int getState() {
        return this.f٩٨٧٥i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h0() {
        return this.f٩٨٨٠n;
    }

    public View j0() {
        WeakReference weakReference = this.f٩٨٨٥s;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public int k0() {
        return this.f٩٨٦٧a.d();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void m(CoordinatorLayout.f fVar) {
        super.m(fVar);
        this.f٩٨٨٤r = null;
        this.f٩٨٧٧k = null;
        this.f٩٨٨٨v = null;
    }

    public float m0() {
        return this.f٩٨٧٩m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n0() {
        return 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o0() {
        return this.f٩٨٨٣q;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p() {
        super.p();
        this.f٩٨٨٤r = null;
        this.f٩٨٧٧k = null;
        this.f٩٨٨٨v = null;
    }

    int p0(int i10) {
        if (i10 != 3) {
            if (i10 == 5) {
                return this.f٩٨٦٧a.e();
            }
            throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i10);
        }
        return k0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        s2.c cVar;
        if (!P0(view)) {
            this.f٩٨٧٨l = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            G0();
        }
        if (this.f٩٨٨٧u == null) {
            this.f٩٨٨٧u = VelocityTracker.obtain();
        }
        this.f٩٨٨٧u.addMovement(motionEvent);
        if (actionMasked != 0) {
            if ((actionMasked == 1 || actionMasked == 3) && this.f٩٨٧٨l) {
                this.f٩٨٧٨l = false;
                return false;
            }
        } else {
            this.f٩٨٨٩w = (int) motionEvent.getX();
        }
        if (!this.f٩٨٧٨l && (cVar = this.f٩٨٧٧k) != null && cVar.Q(motionEvent)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q0() {
        return this.f٩٨٨٢p;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i10) {
        int i11;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.f٩٨٨٤r == null) {
            this.f٩٨٨٤r = new WeakReference(view);
            this.f٩٨٨٨v = new a8.j(view);
            f8.i iVar = this.f٩٨٦٩c;
            if (iVar != null) {
                view.setBackground(iVar);
                f8.i iVar2 = this.f٩٨٦٩c;
                float f10 = this.f٩٨٧٣g;
                if (f10 == -1.0f) {
                    f10 = view.getElevation();
                }
                iVar2.g0(f10);
            } else {
                ColorStateList colorStateList = this.f٩٨٧٠d;
                if (colorStateList != null) {
                    d1.u0(view, colorStateList);
                }
            }
            V0(view);
            S0();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            e0(view);
        }
        L0(view, i10);
        if (this.f٩٨٧٧k == null) {
            this.f٩٨٧٧k = s2.c.p(coordinatorLayout, this.f٩٨٩١y);
        }
        int h10 = this.f٩٨٦٧a.h(view);
        coordinatorLayout.O(view, i10);
        this.f٩٨٨١o = coordinatorLayout.getWidth();
        this.f٩٨٨٢p = this.f٩٨٦٧a.i(coordinatorLayout);
        this.f٩٨٨٠n = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams != null) {
            i11 = this.f٩٨٦٧a.a(marginLayoutParams);
        } else {
            i11 = 0;
        }
        this.f٩٨٨٣q = i11;
        d1.a0(view, X(h10, view));
        E0(coordinatorLayout);
        for (d dVar : this.f٩٨٩٠x) {
            if (dVar instanceof l) {
                ((l) dVar).c(view);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r0() {
        return this.f٩٨٨١o;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean s(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(g0(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, -1, marginLayoutParams.width), g0(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, -1, marginLayoutParams.height));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s0() {
        return 500;
    }

    s2.c t0() {
        return this.f٩٨٧٧k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        final int f٩٨٩٢a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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
            this.f٩٨٩٢a = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f٩٨٩٢a);
        }

        public SavedState(Parcelable parcelable, SideSheetBehavior sideSheetBehavior) {
            super(parcelable);
            this.f٩٨٩٢a = sideSheetBehavior.f٩٨٧٥i;
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٩٨٧٢f = new c();
        this.f٩٨٧٤h = true;
        this.f٩٨٧٥i = 5;
        this.f٩٨٧٦j = 5;
        this.f٩٨٧٩m = 0.1f;
        this.f٩٨٨٦t = -1;
        this.f٩٨٩٠x = new LinkedHashSet();
        this.f٩٨٩١y = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SideSheetBehavior_Layout);
        int i10 = R.styleable.SideSheetBehavior_Layout_backgroundTint;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.f٩٨٧٠d = c8.c.a(context, obtainStyledAttributes, i10);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SideSheetBehavior_Layout_shapeAppearance)) {
            this.f٩٨٧١e = o.e(context, attributeSet, 0, A).m();
        }
        int i11 = R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId;
        if (obtainStyledAttributes.hasValue(i11)) {
            I0(obtainStyledAttributes.getResourceId(i11, -1));
        }
        c0(context);
        this.f٩٨٧٣g = obtainStyledAttributes.getDimension(R.styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        J0(obtainStyledAttributes.getBoolean(R.styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        obtainStyledAttributes.recycle();
        this.f٩٨٦٨b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
