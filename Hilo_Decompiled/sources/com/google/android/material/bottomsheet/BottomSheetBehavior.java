package com.google.android.material.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.b0;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.customview.view.AbsSavedState;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.material.R;
import com.google.android.material.internal.k0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.i;
import f8.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import m2.g0;
import m2.j0;
import s2.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c implements a8.b {

    /* renamed from: l0, reason: collision with root package name */
    private static final int f٨٤١٣l0 = R.style.Widget_Design_BottomSheet_Modal;
    private boolean A;

    /* renamed from: B, reason: collision with root package name */
    private final h f٨٤١٤B;
    private ValueAnimator C;
    int D;
    int E;
    int F;
    float G;
    int H;
    float I;
    boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    int O;
    int P;
    s2.c Q;
    private boolean R;
    private int S;
    private boolean T;
    private float U;
    private int V;
    int W;
    int X;
    WeakReference Y;
    WeakReference Z;

    /* renamed from: a, reason: collision with root package name */
    private int f٨٤١٥a;

    /* renamed from: a0, reason: collision with root package name */
    WeakReference f٨٤١٦a0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٨٤١٧b;

    /* renamed from: b0, reason: collision with root package name */
    WeakReference f٨٤١٨b0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٨٤١٩c;

    /* renamed from: c0, reason: collision with root package name */
    private final ArrayList f٨٤٢٠c0;

    /* renamed from: d, reason: collision with root package name */
    private float f٨٤٢١d;

    /* renamed from: d0, reason: collision with root package name */
    private VelocityTracker f٨٤٢٢d0;

    /* renamed from: e, reason: collision with root package name */
    private int f٨٤٢٣e;

    /* renamed from: e0, reason: collision with root package name */
    a8.f f٨٤٢٤e0;

    /* renamed from: f, reason: collision with root package name */
    private int f٨٤٢٥f;

    /* renamed from: f0, reason: collision with root package name */
    int f٨٤٢٦f0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٨٤٢٧g;

    /* renamed from: g0, reason: collision with root package name */
    private int f٨٤٢٨g0;

    /* renamed from: h, reason: collision with root package name */
    private int f٨٤٢٩h;

    /* renamed from: h0, reason: collision with root package name */
    boolean f٨٤٣٠h0;

    /* renamed from: i, reason: collision with root package name */
    private int f٨٤٣١i;

    /* renamed from: i0, reason: collision with root package name */
    private Map f٨٤٣٢i0;

    /* renamed from: j, reason: collision with root package name */
    private i f٨٤٣٣j;

    /* renamed from: j0, reason: collision with root package name */
    final SparseIntArray f٨٤٣٤j0;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f٨٤٣٥k;

    /* renamed from: k0, reason: collision with root package name */
    private final c.AbstractC٠٢٢٦c f٨٤٣٦k0;

    /* renamed from: l, reason: collision with root package name */
    private int f٨٤٣٧l;

    /* renamed from: m, reason: collision with root package name */
    private int f٨٤٣٨m;

    /* renamed from: n, reason: collision with root package name */
    private int f٨٤٣٩n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٨٤٤٠o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f٨٤٤١p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f٨٤٤٢q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٨٤٤٣r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f٨٤٤٤s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f٨٤٤٥t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f٨٤٤٦u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f٨٤٤٧v;

    /* renamed from: w, reason: collision with root package name */
    private int f٨٤٤٨w;

    /* renamed from: x, reason: collision with root package name */
    private int f٨٤٤٩x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f٨٤٥٠y;

    /* renamed from: z, reason: collision with root package name */
    private o f٨٤٥١z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f٨٤٥٧a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f٨٤٥٨b;

        a(View view, int i10) {
            this.f٨٤٥٧a = view;
            this.f٨٤٥٨b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.k1(this.f٨٤٥٧a, this.f٨٤٥٨b, false);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomSheetBehavior.this.d1(5);
            WeakReference weakReference = BottomSheetBehavior.this.Y;
            if (weakReference != null && weakReference.get() != null) {
                ((View) BottomSheetBehavior.this.Y.get()).requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f٨٤٣٣j != null) {
                BottomSheetBehavior.this.f٨٤٣٣j.i0(floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d implements k0.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f٨٤٦٢a;

        d(boolean z10) {
            this.f٨٤٦٢a = z10;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
        @Override // com.google.android.material.internal.k0.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d2 a(View view, d2 d2Var, k0.e eVar) {
            boolean z10;
            int i10;
            int i11;
            b0 f10 = d2Var.f(d2.m.g());
            b0 f11 = d2Var.f(d2.m.d());
            BottomSheetBehavior.this.f٨٤٤٩x = f10.f٢٧٩٤b;
            boolean m10 = k0.m(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.f٨٤٤١p) {
                BottomSheetBehavior.this.f٨٤٤٨w = d2Var.j();
                paddingBottom = eVar.f٩٣٢٢d + BottomSheetBehavior.this.f٨٤٤٨w;
            }
            if (BottomSheetBehavior.this.f٨٤٤٢q) {
                if (m10) {
                    i11 = eVar.f٩٣٢١c;
                } else {
                    i11 = eVar.f٩٣١٩a;
                }
                paddingLeft = i11 + f10.f٢٧٩٣a;
            }
            if (BottomSheetBehavior.this.f٨٤٤٣r) {
                if (m10) {
                    i10 = eVar.f٩٣١٩a;
                } else {
                    i10 = eVar.f٩٣٢١c;
                }
                paddingRight = i10 + f10.f٢٧٩٥c;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z11 = true;
            if (BottomSheetBehavior.this.f٨٤٤٥t) {
                int i12 = marginLayoutParams.leftMargin;
                int i13 = f10.f٢٧٩٣a;
                if (i12 != i13) {
                    marginLayoutParams.leftMargin = i13;
                    z10 = true;
                    if (BottomSheetBehavior.this.f٨٤٤٦u) {
                        int i14 = marginLayoutParams.rightMargin;
                        int i15 = f10.f٢٧٩٥c;
                        if (i14 != i15) {
                            marginLayoutParams.rightMargin = i15;
                            z10 = true;
                        }
                    }
                    if (BottomSheetBehavior.this.f٨٤٤٧v) {
                        int i16 = marginLayoutParams.topMargin;
                        int i17 = f10.f٢٧٩٤b;
                        if (i16 != i17) {
                            marginLayoutParams.topMargin = i17;
                            if (z11) {
                                view.setLayoutParams(marginLayoutParams);
                            }
                            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
                            if (this.f٨٤٦٢a) {
                                BottomSheetBehavior.this.f٨٤٣٩n = f11.f٢٧٩٦d;
                            }
                            if (!BottomSheetBehavior.this.f٨٤٤١p || this.f٨٤٦٢a) {
                                BottomSheetBehavior.this.p1(false);
                            }
                            return d2Var;
                        }
                    }
                    z11 = z10;
                    if (z11) {
                    }
                    view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
                    if (this.f٨٤٦٢a) {
                    }
                    if (!BottomSheetBehavior.this.f٨٤٤١p) {
                    }
                    BottomSheetBehavior.this.p1(false);
                    return d2Var;
                }
            }
            z10 = false;
            if (BottomSheetBehavior.this.f٨٤٤٦u) {
            }
            if (BottomSheetBehavior.this.f٨٤٤٧v) {
            }
            z11 = z10;
            if (z11) {
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.f٨٤٦٢a) {
            }
            if (!BottomSheetBehavior.this.f٨٤٤١p) {
            }
            BottomSheetBehavior.this.p1(false);
            return d2Var;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class e extends c.AbstractC٠٢٢٦c {

        /* renamed from: a, reason: collision with root package name */
        private long f٨٤٦٤a;

        e() {
        }

        private boolean a(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (top > (bottomSheetBehavior.X + bottomSheetBehavior.u0()) / 2) {
                return true;
            }
            return false;
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            return view.getLeft();
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return j2.a.b(i10, BottomSheetBehavior.this.u0(), getViewVerticalDragRange(view));
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public int getViewVerticalDragRange(View view) {
            if (BottomSheetBehavior.this.l0()) {
                return BottomSheetBehavior.this.X;
            }
            return BottomSheetBehavior.this.H;
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewDragStateChanged(int i10) {
            if (i10 == 1 && BottomSheetBehavior.this.L) {
                BottomSheetBehavior.this.d1(1);
            }
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.q0(i11);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        
            if (r7.f٨٤٦٥b.f1(r3, (r9 * 100.0f) / r10.X) != false) goto L٦;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        
            if (r9 > r7.f٨٤٦٥b.F) goto L٦٣;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
        
            if (java.lang.Math.abs(r8.getTop() - r7.f٨٤٦٥b.u0()) < java.lang.Math.abs(r8.getTop() - r7.f٨٤٦٥b.F)) goto L٦;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00d0, code lost:
        
            if (r7.f٨٤٦٥b.i1() == false) goto L٦٣;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00f2, code lost:
        
            if (java.lang.Math.abs(r9 - r7.f٨٤٦٥b.E) < java.lang.Math.abs(r9 - r7.f٨٤٦٥b.H)) goto L٦;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x010e, code lost:
        
            if (r7.f٨٤٦٥b.i1() != false) goto L٣٩;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0128, code lost:
        
            if (r7.f٨٤٦٥b.i1() == false) goto L٦٣;
         */
        @Override // s2.c.AbstractC٠٢٢٦c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onViewReleased(View view, float f10, float f11) {
            int i10 = 6;
            if (f11 < DownloadProgress.UNKNOWN_PROGRESS) {
                if (!BottomSheetBehavior.this.f٨٤١٧b) {
                    int top = view.getTop();
                    long uptimeMillis = SystemClock.uptimeMillis() - this.f٨٤٦٤a;
                    if (BottomSheetBehavior.this.i1()) {
                    }
                }
                i10 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.J && bottomSheetBehavior.h1(view, f11)) {
                    if ((Math.abs(f10) < Math.abs(f11) && f11 > BottomSheetBehavior.this.f٨٤٢٣e) || a(view)) {
                        i10 = 5;
                    } else {
                        if (!BottomSheetBehavior.this.f٨٤١٧b) {
                        }
                        i10 = 3;
                    }
                } else if (f11 != DownloadProgress.UNKNOWN_PROGRESS && Math.abs(f10) <= Math.abs(f11)) {
                    if (!BottomSheetBehavior.this.f٨٤١٧b) {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - BottomSheetBehavior.this.F) < Math.abs(top2 - BottomSheetBehavior.this.H)) {
                        }
                    }
                    i10 = 4;
                } else {
                    int top3 = view.getTop();
                    if (!BottomSheetBehavior.this.f٨٤١٧b) {
                        BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                        int i11 = bottomSheetBehavior2.F;
                        if (top3 < i11) {
                            if (top3 >= Math.abs(top3 - bottomSheetBehavior2.H)) {
                            }
                            i10 = 3;
                        } else {
                            if (Math.abs(top3 - i11) < Math.abs(top3 - BottomSheetBehavior.this.H)) {
                            }
                            i10 = 4;
                        }
                    }
                }
            }
            BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
            bottomSheetBehavior3.k1(view, i10, bottomSheetBehavior3.j1());
        }

        @Override // s2.c.AbstractC٠٢٢٦c
        public boolean tryCaptureView(View view, int i10) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.O;
            if (i11 == 1 || bottomSheetBehavior.f٨٤٣٠h0) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.f٨٤٢٦f0 == i10) {
                WeakReference weakReference = bottomSheetBehavior.f٨٤١٨b0;
                if (weakReference != null) {
                    view2 = (View) weakReference.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f٨٤٦٤a = SystemClock.uptimeMillis();
            WeakReference weakReference2 = BottomSheetBehavior.this.Y;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class f implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f٨٤٦٦a;

        f(int i10) {
            this.f٨٤٦٦a = i10;
        }

        @Override // m2.j0
        public boolean perform(View view, j0.a aVar) {
            BottomSheetBehavior.this.c(this.f٨٤٦٦a);
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class g {
        void onLayout(View view) {
        }

        public abstract void onSlide(View view, float f10);

        public abstract void onStateChanged(View view, int i10);
    }

    public BottomSheetBehavior() {
        this.f٨٤١٥a = 0;
        this.f٨٤١٧b = true;
        this.f٨٤١٩c = false;
        this.f٨٤٣٧l = -1;
        this.f٨٤٣٨m = -1;
        this.f٨٤١٤B = new h(this, null);
        this.G = 0.5f;
        this.I = -1.0f;
        this.L = true;
        this.M = true;
        this.O = 4;
        this.P = 4;
        this.U = 0.1f;
        this.f٨٤٢٠c0 = new ArrayList();
        this.f٨٤٢٨g0 = -1;
        this.f٨٤٣٤j0 = new SparseIntArray();
        this.f٨٤٣٦k0 = new e();
    }

    private boolean E0(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            return true;
        }
        return false;
    }

    private boolean G0(CoordinatorLayout coordinatorLayout, int i10, int i11) {
        View view;
        WeakReference weakReference = this.f٨٤١٦a0;
        if (weakReference != null) {
            view = (View) weakReference.get();
        } else {
            view = null;
        }
        if (view != null && coordinatorLayout.H(view, i10, i11)) {
            return true;
        }
        return false;
    }

    private boolean H0(CoordinatorLayout coordinatorLayout, int i10, int i11) {
        View view;
        WeakReference weakReference = this.f٨٤١٨b0;
        if (weakReference != null) {
            view = (View) weakReference.get();
        } else {
            view = null;
        }
        if (view != null && coordinatorLayout.H(view, i10, i11)) {
            return true;
        }
        return false;
    }

    private void J0(View view, g0.a aVar, int i10) {
        d1.m0(view, aVar, null, n0(i10));
    }

    private void K0() {
        this.f٨٤٢٦f0 = -1;
        this.f٨٤٢٨g0 = -1;
        VelocityTracker velocityTracker = this.f٨٤٢٢d0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f٨٤٢٢d0 = null;
        }
    }

    private void L0(SavedState savedState) {
        int i10 = this.f٨٤١٥a;
        if (i10 == 0) {
            return;
        }
        if (i10 == -1 || (i10 & 1) == 1) {
            this.f٨٤٢٥f = savedState.f٨٤٥٣b;
        }
        if (i10 == -1 || (i10 & 2) == 2) {
            this.f٨٤١٧b = savedState.f٨٤٥٤c;
        }
        if (i10 == -1 || (i10 & 4) == 4) {
            this.J = savedState.f٨٤٥٥d;
        }
        if (i10 == -1 || (i10 & 8) == 8) {
            this.K = savedState.f٨٤٥٦e;
        }
    }

    private void M0(View view, Runnable runnable) {
        if (E0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    private int d0(View view, int i10, int i11) {
        return d1.c(view, view.getResources().getString(i10), n0(i11));
    }

    private void e1(View view) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 29 && !B0() && !this.f٨٤٢٧g) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!this.f٨٤٤١p && !this.f٨٤٤٢q && !this.f٨٤٤٣r && !this.f٨٤٤٥t && !this.f٨٤٤٦u && !this.f٨٤٤٧v && !z10) {
            return;
        }
        k0.f(view, new d(z10));
    }

    private void f0() {
        int j02 = j0();
        if (this.f٨٤١٧b) {
            this.H = Math.max(this.X - j02, this.E);
        } else {
            this.H = this.X - j02;
        }
    }

    private float g0(float f10, RoundedCorner roundedCorner) {
        int radius;
        if (roundedCorner != null) {
            radius = roundedCorner.getRadius();
            float f11 = radius;
            if (f11 > DownloadProgress.UNKNOWN_PROGRESS && f10 > DownloadProgress.UNKNOWN_PROGRESS) {
                return f11 / f10;
            }
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    private boolean g1() {
        if (this.Q != null && (this.L || this.O == 1)) {
            return true;
        }
        return false;
    }

    private void h0() {
        this.F = (int) (this.X * (1.0f - this.G));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        r0 = r0.getRootWindowInsets();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float i0() {
        WeakReference weakReference;
        WindowInsets rootWindowInsets;
        RoundedCorner roundedCorner;
        RoundedCorner roundedCorner2;
        if (this.f٨٤٣٣j != null && (weakReference = this.Y) != null && weakReference.get() != null && Build.VERSION.SDK_INT >= 31) {
            View view = (View) this.Y.get();
            if (y0() && rootWindowInsets != null) {
                float O = this.f٨٤٣٣j.O();
                roundedCorner = rootWindowInsets.getRoundedCorner(0);
                float g02 = g0(O, roundedCorner);
                float P = this.f٨٤٣٣j.P();
                roundedCorner2 = rootWindowInsets.getRoundedCorner(1);
                return Math.max(g02, g0(P, roundedCorner2));
            }
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    private int j0() {
        int i10;
        if (this.f٨٤٢٧g) {
            return Math.min(Math.max(this.f٨٤٢٩h, this.X - ((this.W * 9) / 16)), this.V) + this.f٨٤٤٨w;
        }
        if (!this.f٨٤٤٠o && !this.f٨٤٤١p && (i10 = this.f٨٤٣٩n) > 0) {
            return Math.max(this.f٨٤٢٥f, i10 + this.f٨٤٣١i);
        }
        return this.f٨٤٢٥f + this.f٨٤٤٨w;
    }

    private float k0(int i10) {
        float f10;
        float f11;
        int i11 = this.H;
        if (i10 <= i11 && i11 != u0()) {
            int i12 = this.H;
            f10 = i12 - i10;
            f11 = i12 - u0();
        } else {
            int i13 = this.H;
            f10 = i13 - i10;
            f11 = this.X - i13;
        }
        return f10 / f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(View view, int i10, boolean z10) {
        int w02 = w0(i10);
        s2.c cVar = this.Q;
        if (cVar != null && (!z10 ? cVar.R(view, view.getLeft(), w02) : cVar.P(view.getLeft(), w02))) {
            d1(2);
            n1(i10, true);
            this.f٨٤١٤B.c(i10);
            return;
        }
        d1(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l0() {
        if (C0() && D0()) {
            return true;
        }
        return false;
    }

    private void l1() {
        WeakReference weakReference = this.Y;
        if (weakReference != null) {
            m1((View) weakReference.get(), 0);
        }
        WeakReference weakReference2 = this.Z;
        if (weakReference2 != null) {
            m1((View) weakReference2.get(), 1);
        }
    }

    private void m0(View view, int i10) {
        if (view == null) {
            return;
        }
        d1.k0(view, anet.channel.bytes.a.MAX_POOL_SIZE);
        d1.k0(view, 262144);
        d1.k0(view, Constants.MB);
        int i11 = this.f٨٤٣٤j0.get(i10, -1);
        if (i11 != -1) {
            d1.k0(view, i11);
            this.f٨٤٣٤j0.delete(i10);
        }
    }

    private void m1(View view, int i10) {
        if (view == null) {
            return;
        }
        m0(view, i10);
        int i11 = 6;
        if (!this.f٨٤١٧b && this.O != 6) {
            this.f٨٤٣٤j0.put(i10, d0(view, R.string.bottomsheet_action_expand_halfway, 6));
        }
        if (this.J && D0() && this.O != 5) {
            J0(view, g0.a.f١٥٩٤٦y, 5);
        }
        int i12 = this.O;
        if (i12 != 3) {
            if (i12 != 4) {
                if (i12 == 6) {
                    J0(view, g0.a.f١٥٩٤٥x, 4);
                    J0(view, g0.a.f١٥٩٤٤w, 3);
                    return;
                }
                return;
            }
            if (this.f٨٤١٧b) {
                i11 = 3;
            }
            J0(view, g0.a.f١٥٩٤٤w, i11);
            return;
        }
        if (this.f٨٤١٧b) {
            i11 = 4;
        }
        J0(view, g0.a.f١٥٩٤٥x, i11);
    }

    private j0 n0(int i10) {
        return new f(i10);
    }

    private void n1(int i10, boolean z10) {
        boolean z02;
        ValueAnimator valueAnimator;
        if (i10 != 2 && this.A != (z02 = z0()) && this.f٨٤٣٣j != null) {
            this.A = z02;
            float f10 = 1.0f;
            if (z10 && (valueAnimator = this.C) != null) {
                if (valueAnimator.isRunning()) {
                    this.C.reverse();
                    return;
                }
                float E = this.f٨٤٣٣j.E();
                if (z02) {
                    f10 = i0();
                }
                this.C.setFloatValues(E, f10);
                this.C.start();
                return;
            }
            ValueAnimator valueAnimator2 = this.C;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.C.cancel();
            }
            i iVar = this.f٨٤٣٣j;
            if (this.A) {
                f10 = i0();
            }
            iVar.i0(f10);
        }
    }

    private void o0(Context context) {
        if (this.f٨٤٥١z == null) {
            return;
        }
        i iVar = new i(this.f٨٤٥١z);
        this.f٨٤٣٣j = iVar;
        iVar.V(context);
        ColorStateList colorStateList = this.f٨٤٣٥k;
        if (colorStateList != null) {
            this.f٨٤٣٣j.h0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
        this.f٨٤٣٣j.setTint(typedValue.data);
    }

    private void o1(boolean z10) {
        Map map;
        WeakReference weakReference = this.Y;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z10) {
            if (this.f٨٤٣٢i0 == null) {
                this.f٨٤٣٢i0 = new HashMap(childCount);
            } else {
                return;
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = coordinatorLayout.getChildAt(i10);
            if (childAt != this.Y.get()) {
                if (z10) {
                    this.f٨٤٣٢i0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    if (this.f٨٤١٩c) {
                        childAt.setImportantForAccessibility(4);
                    }
                } else if (this.f٨٤١٩c && (map = this.f٨٤٣٢i0) != null && map.containsKey(childAt)) {
                    childAt.setImportantForAccessibility(((Integer) this.f٨٤٣٢i0.get(childAt)).intValue());
                }
            }
        }
        if (!z10) {
            this.f٨٤٣٢i0 = null;
        } else if (this.f٨٤١٩c) {
            ((View) this.Y.get()).sendAccessibilityEvent(8);
        }
    }

    private void p0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i0(), 1.0f);
        this.C = ofFloat;
        ofFloat.setDuration(500L);
        this.C.addUpdateListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(boolean z10) {
        View view;
        if (this.Y != null) {
            f0();
            if (this.O == 4 && (view = (View) this.Y.get()) != null) {
                if (z10) {
                    c(4);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    public static BottomSheetBehavior s0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) layoutParams).f();
            if (f10 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) f10;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int t0(int i10, int i11, int i12, int i13) {
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

    private int w0(int i10) {
        if (i10 != 3) {
            if (i10 != 4) {
                if (i10 != 5) {
                    if (i10 == 6) {
                        return this.F;
                    }
                    throw new IllegalArgumentException("Invalid state to get top offset: " + i10);
                }
                return this.X;
            }
            return this.H;
        }
        return u0();
    }

    private float x0() {
        VelocityTracker velocityTracker = this.f٨٤٢٢d0;
        if (velocityTracker == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f٨٤٢١d);
        return this.f٨٤٢٢d0.getYVelocity(this.f٨٤٢٦f0);
    }

    private boolean y0() {
        WeakReference weakReference = this.Y;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        ((View) this.Y.get()).getLocationOnScreen(iArr);
        if (iArr[1] != 0) {
            return false;
        }
        return true;
    }

    private boolean z0() {
        if (this.O == 3 && (this.f٨٤٥٠y || y0())) {
            return true;
        }
        return false;
    }

    public boolean A0() {
        return this.f٨٤١٧b;
    }

    public boolean B0() {
        return this.f٨٤٤٠o;
    }

    public boolean C0() {
        return this.J;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void D(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.D(coordinatorLayout, view, savedState.getSuperState());
        L0(savedState);
        int i10 = savedState.f٨٤٥٢a;
        if (i10 != 1 && i10 != 2) {
            this.O = i10;
            this.P = i10;
        } else {
            this.O = 4;
            this.P = 4;
        }
    }

    public boolean D0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable E(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.E(coordinatorLayout, view), this);
    }

    public boolean F0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean G(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i10, int i11) {
        this.S = 0;
        this.T = false;
        if ((i10 & 2) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if (r4.getTop() <= r2.F) goto L٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
    
        r0 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
    
        if (java.lang.Math.abs(r3 - r2.E) < java.lang.Math.abs(r3 - r2.H)) goto L٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (i1() != false) goto L٤٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.H)) goto L٥١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a7, code lost:
    
        if (java.lang.Math.abs(r3 - r2.F) < java.lang.Math.abs(r3 - r2.H)) goto L٥١;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I(CoordinatorLayout coordinatorLayout, View view, View view2, int i10) {
        WeakReference weakReference;
        int i11 = 3;
        if (view.getTop() == u0()) {
            d1(3);
            return;
        }
        if (F0() && ((weakReference = this.f٨٤١٨b0) == null || view2 != weakReference.get() || !this.T)) {
            return;
        }
        if (this.S > 0) {
            if (!this.f٨٤١٧b) {
            }
            k1(view, i11, false);
            this.T = false;
        }
        if (this.J && h1(view, x0())) {
            i11 = 5;
        } else if (this.S == 0) {
            int top = view.getTop();
            if (!this.f٨٤١٧b) {
                int i12 = this.F;
                if (top < i12) {
                    if (top >= Math.abs(top - this.H)) {
                    }
                }
            }
        } else {
            if (!this.f٨٤١٧b) {
                int top2 = view.getTop();
            }
            i11 = 4;
        }
        k1(view, i11, false);
        this.T = false;
    }

    public void I0(g gVar) {
        this.f٨٤٢٠c0.remove(gVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.O == 1 && actionMasked == 0) {
            return true;
        }
        if (g1()) {
            this.Q.G(motionEvent);
        }
        if (actionMasked == 0) {
            K0();
        }
        if (this.f٨٤٢٢d0 == null) {
            this.f٨٤٢٢d0 = VelocityTracker.obtain();
        }
        this.f٨٤٢٢d0.addMovement(motionEvent);
        if (g1() && actionMasked == 2 && !this.R && Math.abs(this.f٨٤٢٨g0 - motionEvent.getY()) > this.Q.A()) {
            this.Q.c(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.R;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N0(View view) {
        WeakReference weakReference;
        if (view == null && (weakReference = this.Z) != null) {
            m0((View) weakReference.get(), 1);
            this.Z = null;
        } else {
            this.Z = new WeakReference(view);
            m1(view, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(BottomSheetDragHandleView bottomSheetDragHandleView) {
        WeakReference weakReference;
        if (bottomSheetDragHandleView != null) {
            weakReference = new WeakReference(bottomSheetDragHandleView);
        } else {
            weakReference = null;
        }
        this.f٨٤١٦a0 = weakReference;
    }

    public void P0(boolean z10) {
        this.L = z10;
    }

    public void Q0(boolean z10) {
        this.M = z10;
    }

    public void R0(int i10) {
        if (i10 >= 0) {
            this.D = i10;
            n1(this.O, true);
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void S0(boolean z10) {
        int i10;
        if (this.f٨٤١٧b == z10) {
            return;
        }
        this.f٨٤١٧b = z10;
        if (this.Y != null) {
            f0();
        }
        if (this.f٨٤١٧b && this.O == 6) {
            i10 = 3;
        } else {
            i10 = this.O;
        }
        d1(i10);
        n1(this.O, true);
        l1();
    }

    public void T0(boolean z10) {
        this.f٨٤٤٠o = z10;
    }

    public void U0(float f10) {
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS && f10 < 1.0f) {
            this.G = f10;
            if (this.Y != null) {
                h0();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void V0(boolean z10) {
        if (this.J != z10) {
            this.J = z10;
            if (!z10 && this.O == 5) {
                c(4);
            }
            l1();
        }
    }

    public void W0(int i10) {
        this.f٨٤٣٨m = i10;
    }

    public void X0(int i10) {
        this.f٨٤٣٧l = i10;
    }

    public void Y0(int i10) {
        Z0(i10, false);
    }

    public final void Z0(int i10, boolean z10) {
        if (i10 == -1) {
            if (!this.f٨٤٢٧g) {
                this.f٨٤٢٧g = true;
            } else {
                return;
            }
        } else if (this.f٨٤٢٧g || this.f٨٤٢٥f != i10) {
            this.f٨٤٢٧g = false;
            this.f٨٤٢٥f = Math.max(0, i10);
        } else {
            return;
        }
        p1(z10);
    }

    @Override // a8.b
    public void a() {
        a8.f fVar = this.f٨٤٢٤e0;
        if (fVar == null) {
            return;
        }
        fVar.f();
    }

    public void a1(int i10) {
        this.f٨٤١٥a = i10;
    }

    public void b1(int i10) {
        this.f٨٤٢٣e = i10;
    }

    public void c(int i10) {
        String str;
        int i11;
        if (i10 != 1 && i10 != 2) {
            if (!this.J && i10 == 5) {
                Log.w("BottomSheetBehavior", "Cannot set state: " + i10);
                return;
            }
            if (i10 == 6 && this.f٨٤١٧b && w0(i10) <= this.E) {
                i11 = 3;
            } else {
                i11 = i10;
            }
            WeakReference weakReference = this.Y;
            if (weakReference != null && weakReference.get() != null) {
                View view = (View) this.Y.get();
                M0(view, new a(view, i11));
                return;
            } else {
                d1(i10);
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

    public void c1(boolean z10) {
        this.K = z10;
    }

    @Override // a8.b
    public void d(BackEventCompat backEventCompat) {
        a8.f fVar = this.f٨٤٢٤e0;
        if (fVar == null) {
            return;
        }
        fVar.j(backEventCompat);
    }

    void d1(int i10) {
        View view;
        if (this.O == i10) {
            return;
        }
        this.O = i10;
        if (i10 == 4 || i10 == 3 || i10 == 6 || (this.J && i10 == 5)) {
            this.P = i10;
        }
        WeakReference weakReference = this.Y;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        if (i10 == 3) {
            o1(true);
        } else if (i10 == 6 || i10 == 5 || i10 == 4) {
            o1(false);
        }
        n1(i10, true);
        for (int i11 = 0; i11 < this.f٨٤٢٠c0.size(); i11++) {
            ((g) this.f٨٤٢٠c0.get(i11)).onStateChanged(view, i10);
        }
        l1();
    }

    @Override // a8.b
    public void e(BackEventCompat backEventCompat) {
        a8.f fVar = this.f٨٤٢٤e0;
        if (fVar == null) {
            return;
        }
        fVar.l(backEventCompat);
    }

    public void e0(g gVar) {
        if (!this.f٨٤٢٠c0.contains(gVar)) {
            this.f٨٤٢٠c0.add(gVar);
        }
    }

    @Override // a8.b
    public void f() {
        a8.f fVar = this.f٨٤٢٤e0;
        if (fVar == null) {
            return;
        }
        BackEventCompat c10 = fVar.c();
        int i10 = 4;
        if (c10 != null && Build.VERSION.SDK_INT >= 34) {
            if (this.J) {
                this.f٨٤٢٤e0.h(c10, new b());
                return;
            } else {
                this.f٨٤٢٤e0.i(c10, null);
                c(4);
                return;
            }
        }
        if (this.J) {
            i10 = 5;
        }
        c(i10);
    }

    public boolean f1(long j10, float f10) {
        return false;
    }

    public int getState() {
        return this.O;
    }

    boolean h1(View view, float f10) {
        if (this.K) {
            return true;
        }
        if (!D0() || view.getTop() < this.H) {
            return false;
        }
        if (Math.abs((view.getTop() + (f10 * this.U)) - this.H) / j0() > 0.5f) {
            return true;
        }
        return false;
    }

    public boolean i1() {
        return false;
    }

    public boolean j1() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void m(CoordinatorLayout.f fVar) {
        super.m(fVar);
        this.Y = null;
        this.Q = null;
        this.f٨٤٢٤e0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p() {
        super.p();
        this.Y = null;
        this.Q = null;
        this.f٨٤٢٤e0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z10;
        View view2;
        int i10;
        s2.c cVar;
        if (view.isShown() && this.L) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                K0();
            }
            if (this.f٨٤٢٢d0 == null) {
                this.f٨٤٢٢d0 = VelocityTracker.obtain();
            }
            this.f٨٤٢٢d0.addMovement(motionEvent);
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.f٨٤٣٠h0 = false;
                    this.f٨٤٢٦f0 = -1;
                    if (this.R) {
                        this.R = false;
                        return false;
                    }
                }
            } else {
                int x10 = (int) motionEvent.getX();
                int y10 = (int) motionEvent.getY();
                this.f٨٤٢٨g0 = y10;
                if (this.O != 2 && H0(coordinatorLayout, x10, y10)) {
                    this.f٨٤٢٦f0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    if (!G0(coordinatorLayout, x10, this.f٨٤٢٨g0)) {
                        this.f٨٤٣٠h0 = true;
                    }
                }
                if (this.f٨٤٢٦f0 == -1 && !coordinatorLayout.H(view, x10, this.f٨٤٢٨g0)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.R = z10;
            }
            if (!this.R && (cVar = this.Q) != null && cVar.Q(motionEvent)) {
                return true;
            }
            WeakReference weakReference = this.f٨٤١٨b0;
            if (weakReference != null) {
                view2 = (View) weakReference.get();
            } else {
                view2 = null;
            }
            if (actionMasked != 2 || view2 == null || this.R || this.O == 1 || coordinatorLayout.H(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.Q == null || (i10 = this.f٨٤٢٨g0) == -1 || Math.abs(i10 - motionEvent.getY()) <= this.Q.A()) {
                return false;
            }
            return true;
        }
        this.R = true;
        return false;
    }

    void q0(int i10) {
        View view = (View) this.Y.get();
        if (view != null && !this.f٨٤٢٠c0.isEmpty()) {
            float k02 = k0(i10);
            for (int i11 = 0; i11 < this.f٨٤٢٠c0.size(); i11++) {
                ((g) this.f٨٤٢٠c0.get(i11)).onSlide(view, k02);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i10) {
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.Y == null) {
            this.f٨٤٢٩h = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            e1(view);
            d1.L0(view, new com.google.android.material.bottomsheet.f(view));
            this.Y = new WeakReference(view);
            this.f٨٤٢٤e0 = new a8.f(view);
            i iVar = this.f٨٤٣٣j;
            if (iVar != null) {
                view.setBackground(iVar);
                i iVar2 = this.f٨٤٣٣j;
                float f10 = this.I;
                if (f10 == -1.0f) {
                    f10 = view.getElevation();
                }
                iVar2.g0(f10);
            } else {
                ColorStateList colorStateList = this.f٨٤٣٥k;
                if (colorStateList != null) {
                    d1.u0(view, colorStateList);
                }
            }
            l1();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.Q == null) {
            this.Q = s2.c.p(coordinatorLayout, this.f٨٤٣٦k0);
        }
        int top = view.getTop();
        coordinatorLayout.O(view, i10);
        this.W = coordinatorLayout.getWidth();
        this.X = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.V = height;
        int i11 = this.X;
        int i12 = i11 - height;
        int i13 = this.f٨٤٤٩x;
        if (i12 < i13) {
            if (this.f٨٤٤٤s) {
                int i14 = this.f٨٤٣٨m;
                if (i14 != -1) {
                    i11 = Math.min(i11, i14);
                }
                this.V = i11;
            } else {
                int i15 = i11 - i13;
                int i16 = this.f٨٤٣٨m;
                if (i16 != -1) {
                    i15 = Math.min(i15, i16);
                }
                this.V = i15;
            }
        }
        this.E = Math.max(0, this.X - this.V);
        h0();
        f0();
        int i17 = this.O;
        if (i17 == 3) {
            d1.b0(view, u0());
        } else if (i17 == 6) {
            d1.b0(view, this.F);
        } else if (this.J && i17 == 5) {
            d1.b0(view, this.X);
        } else if (i17 == 4) {
            d1.b0(view, this.H);
        } else if (i17 == 1 || i17 == 2) {
            d1.b0(view, top - view.getTop());
        }
        n1(this.O, false);
        this.f٨٤١٨b0 = new WeakReference(r0(view));
        for (int i18 = 0; i18 < this.f٨٤٢٠c0.size(); i18++) {
            ((g) this.f٨٤٢٠c0.get(i18)).onLayout(view);
        }
        return true;
    }

    View r0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View r02 = r0(viewGroup.getChildAt(i10));
                if (r02 != null) {
                    return r02;
                }
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean s(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(t0(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.f٨٤٣٧l, marginLayoutParams.width), t0(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, this.f٨٤٣٨m, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean u(CoordinatorLayout coordinatorLayout, View view, View view2, float f10, float f11) {
        WeakReference weakReference;
        if (!F0() || (weakReference = this.f٨٤١٨b0) == null || view2 != weakReference.get()) {
            return false;
        }
        if ((this.O == 3 || this.N) && !super.u(coordinatorLayout, view, view2, f10, f11)) {
            return false;
        }
        return true;
    }

    public int u0() {
        int i10;
        if (this.f٨٤١٧b) {
            return this.E;
        }
        int i11 = this.D;
        if (this.f٨٤٤٤s) {
            i10 = 0;
        } else {
            i10 = this.f٨٤٤٩x;
        }
        return Math.max(i11, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i v0() {
        return this.f٨٤٣٣j;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void w(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int[] iArr, int i12) {
        View view3;
        if (i12 == 1) {
            return;
        }
        WeakReference weakReference = this.f٨٤١٨b0;
        if (weakReference != null) {
            view3 = (View) weakReference.get();
        } else {
            view3 = null;
        }
        if (F0() && view2 != view3) {
            return;
        }
        int top = view.getTop();
        int i13 = top - i11;
        if (i11 > 0) {
            if (!this.T && !this.M && view2 == view3 && view2.canScrollVertically(1)) {
                this.N = true;
                return;
            }
            if (i13 < u0()) {
                int u02 = top - u0();
                iArr[1] = u02;
                d1.b0(view, -u02);
                d1(3);
            } else {
                if (!this.L) {
                    return;
                }
                iArr[1] = i11;
                d1.b0(view, -i11);
                d1(1);
            }
        } else if (i11 < 0) {
            boolean canScrollVertically = view2.canScrollVertically(-1);
            if (!this.T && !this.M && view2 == view3 && canScrollVertically) {
                this.N = true;
                return;
            }
            if (!canScrollVertically) {
                if (i13 > this.H && !l0()) {
                    int i14 = top - this.H;
                    iArr[1] = i14;
                    d1.b0(view, -i14);
                    d1(4);
                } else {
                    if (!this.L) {
                        return;
                    }
                    iArr[1] = i11;
                    d1.b0(view, -i11);
                    d1(1);
                }
            }
        }
        q0(view.getTop());
        this.S = i11;
        this.T = true;
        this.N = false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class h {

        /* renamed from: a, reason: collision with root package name */
        private int f٨٤٦٨a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f٨٤٦٩b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f٨٤٧٠c;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.f٨٤٦٩b = false;
                s2.c cVar = BottomSheetBehavior.this.Q;
                if (cVar != null && cVar.n(true)) {
                    h hVar = h.this;
                    hVar.c(hVar.f٨٤٦٨a);
                    return;
                }
                h hVar2 = h.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.O == 2) {
                    bottomSheetBehavior.d1(hVar2.f٨٤٦٨a);
                }
            }
        }

        private h() {
            this.f٨٤٧٠c = new a();
        }

        void c(int i10) {
            WeakReference weakReference = BottomSheetBehavior.this.Y;
            if (weakReference != null && weakReference.get() != null) {
                this.f٨٤٦٨a = i10;
                if (!this.f٨٤٦٩b) {
                    ((View) BottomSheetBehavior.this.Y.get()).postOnAnimation(this.f٨٤٧٠c);
                    this.f٨٤٦٩b = true;
                }
            }
        }

        /* synthetic */ h(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        final int f٨٤٥٢a;

        /* renamed from: b, reason: collision with root package name */
        int f٨٤٥٣b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٨٤٥٤c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٨٤٥٥d;

        /* renamed from: e, reason: collision with root package name */
        boolean f٨٤٥٦e;

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
            this.f٨٤٥٢a = parcel.readInt();
            this.f٨٤٥٣b = parcel.readInt();
            this.f٨٤٥٤c = parcel.readInt() == 1;
            this.f٨٤٥٥d = parcel.readInt() == 1;
            this.f٨٤٥٦e = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f٨٤٥٢a);
            parcel.writeInt(this.f٨٤٥٣b);
            parcel.writeInt(this.f٨٤٥٤c ? 1 : 0);
            parcel.writeInt(this.f٨٤٥٥d ? 1 : 0);
            parcel.writeInt(this.f٨٤٥٦e ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.f٨٤٥٢a = bottomSheetBehavior.O;
            this.f٨٤٥٣b = bottomSheetBehavior.f٨٤٢٥f;
            this.f٨٤٥٤c = bottomSheetBehavior.f٨٤١٧b;
            this.f٨٤٥٥d = bottomSheetBehavior.J;
            this.f٨٤٥٦e = bottomSheetBehavior.K;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i10;
        this.f٨٤١٥a = 0;
        this.f٨٤١٧b = true;
        this.f٨٤١٩c = false;
        this.f٨٤٣٧l = -1;
        this.f٨٤٣٨m = -1;
        this.f٨٤١٤B = new h(this, null);
        this.G = 0.5f;
        this.I = -1.0f;
        this.L = true;
        this.M = true;
        this.O = 4;
        this.P = 4;
        this.U = 0.1f;
        this.f٨٤٢٠c0 = new ArrayList();
        this.f٨٤٢٨g0 = -1;
        this.f٨٤٣٤j0 = new SparseIntArray();
        this.f٨٤٣٦k0 = new e();
        this.f٨٤٣١i = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        int i11 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f٨٤٣٥k = c8.c.a(context, obtainStyledAttributes, i11);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.f٨٤٥١z = o.e(context, attributeSet, R.attr.bottomSheetStyle, f٨٤١٣l0).m();
        }
        o0(context);
        p0();
        this.I = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i12 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i12)) {
            X0(obtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        int i13 = R.styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (obtainStyledAttributes.hasValue(i13)) {
            W0(obtainStyledAttributes.getDimensionPixelSize(i13, -1));
        }
        int i14 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i14);
        if (peekValue != null && (i10 = peekValue.data) == -1) {
            Y0(i10);
        } else {
            Y0(obtainStyledAttributes.getDimensionPixelSize(i14, -1));
        }
        V0(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        T0(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        S0(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c1(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        P0(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        Q0(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggableOnNestedScroll, true));
        a1(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        U0(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i15 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i15);
        if (peekValue2 != null && peekValue2.type == 16) {
            R0(peekValue2.data);
        } else {
            R0(obtainStyledAttributes.getDimensionPixelOffset(i15, 0));
        }
        b1(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.f٨٤٤١p = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.f٨٤٤٢q = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.f٨٤٤٣r = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.f٨٤٤٤s = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.f٨٤٤٥t = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.f٨٤٤٦u = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.f٨٤٤٧v = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.f٨٤٥٠y = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        obtainStyledAttributes.recycle();
        this.f٨٤٢١d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
