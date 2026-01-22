package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.appcompat.app.a0;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d2;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.j;
import f8.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p7.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    private static final int A = R.style.Widget_MaterialComponents_BottomAppBar;

    /* renamed from: B, reason: collision with root package name */
    private static final int f٨٣٤٧B = R.attr.motionDurationLong2;
    private static final int C = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: a, reason: collision with root package name */
    private Integer f٨٣٤٨a;

    /* renamed from: b, reason: collision with root package name */
    private final f8.i f٨٣٤٩b;

    /* renamed from: c, reason: collision with root package name */
    private Animator f٨٣٥٠c;

    /* renamed from: d, reason: collision with root package name */
    private Animator f٨٣٥١d;

    /* renamed from: e, reason: collision with root package name */
    private int f٨٣٥٢e;

    /* renamed from: f, reason: collision with root package name */
    private int f٨٣٥٣f;

    /* renamed from: g, reason: collision with root package name */
    private int f٨٣٥٤g;

    /* renamed from: h, reason: collision with root package name */
    private final int f٨٣٥٥h;

    /* renamed from: i, reason: collision with root package name */
    private int f٨٣٥٦i;

    /* renamed from: j, reason: collision with root package name */
    private int f٨٣٥٧j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f٨٣٥٨k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٨٣٥٩l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f٨٣٦٠m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f٨٣٦١n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f٨٣٦٢o;

    /* renamed from: p, reason: collision with root package name */
    private int f٨٣٦٣p;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList f٨٣٦٤q;

    /* renamed from: r, reason: collision with root package name */
    private int f٨٣٦٥r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f٨٣٦٦s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f٨٣٦٧t;

    /* renamed from: u, reason: collision with root package name */
    private Behavior f٨٣٦٨u;

    /* renamed from: v, reason: collision with root package name */
    private int f٨٣٦٩v;

    /* renamed from: w, reason: collision with root package name */
    private int f٨٣٧٠w;

    /* renamed from: x, reason: collision with root package name */
    private int f٨٣٧١x;

    /* renamed from: y, reason: collision with root package name */
    AnimatorListenerAdapter f٨٣٧٢y;

    /* renamed from: z, reason: collision with root package name */
    k f٨٣٧٣z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f٨٣٧٩a;

        /* renamed from: b, reason: collision with root package name */
        boolean f٨٣٨٠b;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f٨٣٧٩a);
            parcel.writeInt(this.f٨٣٨٠b ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f٨٣٧٩a = parcel.readInt();
            this.f٨٣٨٠b = parcel.readInt() != 0;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!BottomAppBar.this.f٨٣٦٦s) {
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.u0(bottomAppBar.f٨٣٥٢e, BottomAppBar.this.f٨٣٦٧t);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements k {
        b() {
        }

        @Override // p7.k
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(FloatingActionButton floatingActionButton) {
            float f10;
            f8.i iVar = BottomAppBar.this.f٨٣٤٩b;
            if (floatingActionButton.getVisibility() == 0 && BottomAppBar.this.f٨٣٥٤g == 1) {
                f10 = floatingActionButton.getScaleY();
            } else {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            iVar.i0(f10);
        }

        @Override // p7.k
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(FloatingActionButton floatingActionButton) {
            if (BottomAppBar.this.f٨٣٥٤g != 1) {
                return;
            }
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().h() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().n(translationX);
                BottomAppBar.this.f٨٣٤٩b.invalidateSelf();
            }
            float f10 = -floatingActionButton.getTranslationY();
            float f11 = DownloadProgress.UNKNOWN_PROGRESS;
            float max = Math.max(DownloadProgress.UNKNOWN_PROGRESS, f10);
            if (BottomAppBar.this.getTopEdgeTreatment().c() != max) {
                BottomAppBar.this.getTopEdgeTreatment().i(max);
                BottomAppBar.this.f٨٣٤٩b.invalidateSelf();
            }
            f8.i iVar = BottomAppBar.this.f٨٣٤٩b;
            if (floatingActionButton.getVisibility() == 0) {
                f11 = floatingActionButton.getScaleY();
            }
            iVar.i0(f11);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c implements k0.d {
        c() {
        }

        @Override // com.google.android.material.internal.k0.d
        public d2 a(View view, d2 d2Var, k0.e eVar) {
            boolean z10;
            if (BottomAppBar.this.f٨٣٦٠m) {
                BottomAppBar.this.f٨٣٦٩v = d2Var.j();
            }
            boolean z11 = true;
            boolean z12 = false;
            if (BottomAppBar.this.f٨٣٦١n) {
                if (BottomAppBar.this.f٨٣٧١x != d2Var.k()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                BottomAppBar.this.f٨٣٧١x = d2Var.k();
            } else {
                z10 = false;
            }
            if (BottomAppBar.this.f٨٣٦٢o) {
                if (BottomAppBar.this.f٨٣٧٠w == d2Var.l()) {
                    z11 = false;
                }
                BottomAppBar.this.f٨٣٧٠w = d2Var.l();
                z12 = z11;
            }
            if (z10 || z12) {
                BottomAppBar.this.i0();
                BottomAppBar.this.z0();
                BottomAppBar.this.y0();
            }
            return d2Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.m0();
            BottomAppBar.this.f٨٣٥٠c = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class e extends FloatingActionButton.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f٨٣٨٥a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.m0();
            }
        }

        e(int i10) {
            this.f٨٣٨٥a = i10;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.r0(this.f٨٣٨٥a));
            floatingActionButton.show(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.m0();
            BottomAppBar.this.f٨٣٦٦s = false;
            BottomAppBar.this.f٨٣٥١d = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f٨٣٨٩a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f٨٣٩٠b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f٨٣٩١c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f٨٣٩٢d;

        g(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f٨٣٩٠b = actionMenuView;
            this.f٨٣٩١c = i10;
            this.f٨٣٩٢d = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f٨٣٨٩a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z10;
            if (!this.f٨٣٨٩a) {
                if (BottomAppBar.this.f٨٣٦٥r != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.x0(bottomAppBar.f٨٣٦٥r);
                BottomAppBar.this.D0(this.f٨٣٩٠b, this.f٨٣٩١c, this.f٨٣٩٢d, z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f٨٣٩٤a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f٨٣٩٥b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f٨٣٩٦c;

        h(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f٨٣٩٤a = actionMenuView;
            this.f٨٣٩٥b = i10;
            this.f٨٣٩٦c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f٨٣٩٤a.setTranslationX(BottomAppBar.this.q0(r0, this.f٨٣٩٥b, this.f٨٣٩٦c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f٨٣٧٢y.onAnimationStart(animator);
            FloatingActionButton o02 = BottomAppBar.this.o0();
            if (o02 != null) {
                o02.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    public BottomAppBar(Context context) {
        this(context, null);
    }

    private void C0(ActionMenuView actionMenuView, int i10, boolean z10) {
        D0(actionMenuView, i10, z10, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(ActionMenuView actionMenuView, int i10, boolean z10, boolean z11) {
        h hVar = new h(actionMenuView, i10, z10);
        if (z11) {
            actionMenuView.post(hVar);
        } else {
            hVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E0(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        fVar.f٢٥٦٣d = 17;
        int i10 = bottomAppBar.f٨٣٥٤g;
        if (i10 == 1) {
            fVar.f٢٥٦٣d = 17 | 48;
        }
        if (i10 == 0) {
            fVar.f٢٥٦٣d |= 80;
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f٨٣٦٩v;
    }

    private int getFabAlignmentAnimationDuration() {
        return a8.k.f(getContext(), f٨٣٤٧B, 300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return r0(this.f٨٣٥٢e);
    }

    private float getFabTranslationY() {
        int i10;
        if (this.f٨٣٥٤g == 1) {
            return -getTopEdgeTreatment().c();
        }
        View p02 = p0();
        if (p02 != null) {
            i10 = (-((getMeasuredHeight() + getBottomInset()) - p02.getMeasuredHeight())) / 2;
        } else {
            i10 = 0;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f٨٣٧١x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f٨٣٧٠w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.material.bottomappbar.d getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.d) this.f٨٣٤٩b.getShapeAppearanceModel().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.f٨٣٧٢y);
        floatingActionButton.f(new i());
        floatingActionButton.g(this.f٨٣٧٣z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        Animator animator = this.f٨٣٥١d;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f٨٣٥٠c;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void k0(int i10, List list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(o0(), "translationX", r0(i10));
        ofFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(ofFloat);
    }

    private void l0(int i10, boolean z10, List list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        ofFloat.setDuration(0.8f * fabAlignmentAnimationDuration);
        if (Math.abs(actionMenuView.getTranslationX() - q0(actionMenuView, i10, z10)) > 1.0f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", DownloadProgress.UNKNOWN_PROGRESS);
            ofFloat2.setDuration(fabAlignmentAnimationDuration * 0.2f);
            ofFloat2.addListener(new g(actionMenuView, i10, z10));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
            return;
        }
        if (actionMenuView.getAlpha() < 1.0f) {
            list.add(ofFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        ArrayList arrayList;
        int i10 = this.f٨٣٦٣p - 1;
        this.f٨٣٦٣p = i10;
        if (i10 == 0 && (arrayList = this.f٨٣٦٤q) != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                a0.a(it.next());
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        ArrayList arrayList;
        int i10 = this.f٨٣٦٣p;
        this.f٨٣٦٣p = i10 + 1;
        if (i10 == 0 && (arrayList = this.f٨٣٦٤q) != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                a0.a(it.next());
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton o0() {
        View p02 = p0();
        if (p02 instanceof FloatingActionButton) {
            return (FloatingActionButton) p02;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View p0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).y(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float r0(int i10) {
        int i11;
        int i12;
        boolean m10 = k0.m(this);
        int i13 = 1;
        if (i10 == 1) {
            View p02 = p0();
            if (m10) {
                i11 = this.f٨٣٧١x;
            } else {
                i11 = this.f٨٣٧٠w;
            }
            if (this.f٨٣٥٦i != -1 && p02 != null) {
                i12 = (p02.getMeasuredWidth() / 2) + this.f٨٣٥٦i;
            } else {
                i12 = this.f٨٣٥٥h;
            }
            int measuredWidth = (getMeasuredWidth() / 2) - (i11 + i12);
            if (m10) {
                i13 = -1;
            }
            return measuredWidth * i13;
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    private boolean s0() {
        FloatingActionButton o02 = o0();
        if (o02 != null && o02.m()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i10, boolean z10) {
        if (!isLaidOut()) {
            this.f٨٣٦٦s = false;
            x0(this.f٨٣٦٥r);
            return;
        }
        Animator animator = this.f٨٣٥١d;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!s0()) {
            i10 = 0;
            z10 = false;
        }
        l0(i10, z10, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f٨٣٥١d = animatorSet;
        animatorSet.addListener(new f());
        this.f٨٣٥١d.start();
    }

    private void v0(int i10) {
        if (this.f٨٣٥٢e != i10 && isLaidOut()) {
            Animator animator = this.f٨٣٥٠c;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.f٨٣٥٣f == 1) {
                k0(i10, arrayList);
            } else {
                j0(i10, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setInterpolator(a8.k.g(getContext(), C, p7.a.f١٦٩٤٧a));
            this.f٨٣٥٠c = animatorSet;
            animatorSet.addListener(new d());
            this.f٨٣٥٠c.start();
        }
    }

    private Drawable w0(Drawable drawable) {
        if (drawable != null && this.f٨٣٤٨a != null) {
            Drawable r10 = h2.b.r(drawable.mutate());
            r10.setTint(this.f٨٣٤٨a.intValue());
            return r10;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.f٨٣٥١d == null) {
            actionMenuView.setAlpha(1.0f);
            if (!s0()) {
                C0(actionMenuView, 0, false);
            } else {
                C0(actionMenuView, this.f٨٣٥٢e, this.f٨٣٦٧t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        float f10;
        getTopEdgeTreatment().n(getFabTranslationX());
        f8.i iVar = this.f٨٣٤٩b;
        if (this.f٨٣٦٧t && s0() && this.f٨٣٥٤g == 1) {
            f10 = 1.0f;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        iVar.i0(f10);
        View p02 = p0();
        if (p02 != null) {
            p02.setTranslationY(getFabTranslationY());
            p02.setTranslationX(getFabTranslationX());
        }
    }

    public void A0(int i10, int i11) {
        this.f٨٣٦٥r = i11;
        this.f٨٣٦٦s = true;
        u0(i10, this.f٨٣٦٧t);
        v0(i10);
        this.f٨٣٥٢e = i10;
    }

    boolean B0(int i10) {
        float f10 = i10;
        if (f10 != getTopEdgeTreatment().g()) {
            getTopEdgeTreatment().m(f10);
            this.f٨٣٤٩b.invalidateSelf();
            return true;
        }
        return false;
    }

    public void addOnScrollStateChangedListener(HideBottomViewOnScrollBehavior.c cVar) {
        getBehavior().addOnScrollStateChangedListener(cVar);
    }

    public ColorStateList getBackgroundTint() {
        return this.f٨٣٤٩b.N();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.f٨٣٥٢e;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f٨٣٥٦i;
    }

    public int getFabAnchorMode() {
        return this.f٨٣٥٤g;
    }

    public int getFabAnimationMode() {
        return this.f٨٣٥٣f;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().e();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f();
    }

    public boolean getHideOnScroll() {
        return this.f٨٣٥٩l;
    }

    public int getMenuAlignmentMode() {
        return this.f٨٣٥٧j;
    }

    protected void j0(int i10, List list) {
        FloatingActionButton o02 = o0();
        if (o02 != null && !o02.l()) {
            n0();
            o02.hide(new e(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.f(this, this.f٨٣٤٩b);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            i0();
            z0();
            final View p02 = p0();
            if (p02 != null && p02.isLaidOut()) {
                p02.post(new Runnable() { // from class: com.google.android.material.bottomappbar.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        p02.requestLayout();
                    }
                });
            }
        }
        y0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f٨٣٥٢e = savedState.f٨٣٧٩a;
        this.f٨٣٦٧t = savedState.f٨٣٨٠b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f٨٣٧٩a = this.f٨٣٥٢e;
        savedState.f٨٣٨٠b = this.f٨٣٦٧t;
        return savedState;
    }

    protected int q0(ActionMenuView actionMenuView, int i10, boolean z10) {
        int i11;
        int left;
        int i12;
        int i13 = 0;
        if (this.f٨٣٥٧j != 1 && (i10 != 1 || !z10)) {
            return 0;
        }
        boolean m10 = k0.m(this);
        if (m10) {
            i11 = getMeasuredWidth();
        } else {
            i11 = 0;
        }
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            View childAt = getChildAt(i14);
            if ((childAt.getLayoutParams() instanceof Toolbar.g) && (((Toolbar.g) childAt.getLayoutParams()).f٧١٩a & 8388615) == 8388611) {
                if (m10) {
                    i11 = Math.min(i11, childAt.getLeft());
                } else {
                    i11 = Math.max(i11, childAt.getRight());
                }
            }
        }
        if (m10) {
            left = actionMenuView.getRight();
        } else {
            left = actionMenuView.getLeft();
        }
        if (m10) {
            i12 = this.f٨٣٧٠w;
        } else {
            i12 = -this.f٨٣٧١x;
        }
        if (getNavigationIcon() == null) {
            i13 = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
            if (!m10) {
                i13 = -i13;
            }
        }
        return i11 - ((left + i12) + i13);
    }

    public void removeOnScrollStateChangedListener(HideBottomViewOnScrollBehavior.c cVar) {
        getBehavior().removeOnScrollStateChangedListener(cVar);
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        this.f٨٣٤٩b.setTintList(colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f10) {
        if (f10 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().i(f10);
            this.f٨٣٤٩b.invalidateSelf();
            z0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        this.f٨٣٤٩b.g0(f10);
        getBehavior().U(this, this.f٨٣٤٩b.J() - this.f٨٣٤٩b.I());
    }

    public void setFabAlignmentMode(int i10) {
        A0(i10, 0);
    }

    public void setFabAlignmentModeEndMargin(int i10) {
        if (this.f٨٣٥٦i != i10) {
            this.f٨٣٥٦i = i10;
            z0();
        }
    }

    public void setFabAnchorMode(int i10) {
        this.f٨٣٥٤g = i10;
        z0();
        View p02 = p0();
        if (p02 != null) {
            E0(this, p02);
            p02.requestLayout();
            this.f٨٣٤٩b.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i10) {
        this.f٨٣٥٣f = i10;
    }

    void setFabCornerSize(@Dimension float f10) {
        if (f10 != getTopEdgeTreatment().d()) {
            getTopEdgeTreatment().j(f10);
            this.f٨٣٤٩b.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@Dimension float f10) {
        if (f10 != getFabCradleMargin()) {
            getTopEdgeTreatment().k(f10);
            this.f٨٣٤٩b.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f10) {
        if (f10 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().l(f10);
            this.f٨٣٤٩b.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z10) {
        this.f٨٣٥٩l = z10;
    }

    public void setMenuAlignmentMode(int i10) {
        if (this.f٨٣٥٧j != i10) {
            this.f٨٣٥٧j = i10;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                C0(actionMenuView, this.f٨٣٥٢e, s0());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(w0(drawable));
    }

    public void setNavigationIconTint(int i10) {
        this.f٨٣٤٨a = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public void x0(int i10) {
        if (i10 != 0) {
            this.f٨٣٦٥r = 0;
            getMenu().clear();
            inflateMenu(i10);
        }
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f٨٣٦٨u == null) {
            this.f٨٣٦٨u = new Behavior();
        }
        return this.f٨٣٦٨u;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: p, reason: collision with root package name */
        private final Rect f٨٣٧٤p;

        /* renamed from: q, reason: collision with root package name */
        private WeakReference f٨٣٧٥q;

        /* renamed from: r, reason: collision with root package name */
        private int f٨٣٧٦r;

        /* renamed from: s, reason: collision with root package name */
        private final View.OnLayoutChangeListener f٨٣٧٧s;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f٨٣٧٥q.get();
                if (bottomAppBar != null && ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    int height = view.getHeight();
                    if (view instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                        floatingActionButton.h(Behavior.this.f٨٣٧٤p);
                        int height2 = Behavior.this.f٨٣٧٤p.height();
                        bottomAppBar.B0(height2);
                        bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f٨٣٧٤p)));
                        height = height2;
                    }
                    CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                    if (Behavior.this.f٨٣٧٦r == 0) {
                        if (bottomAppBar.f٨٣٥٤g == 1) {
                            ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                        }
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                        if (k0.m(view)) {
                            ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.f٨٣٥٥h;
                        } else {
                            ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.f٨٣٥٥h;
                        }
                    }
                    bottomAppBar.z0();
                    return;
                }
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.f٨٣٧٧s = new a();
            this.f٨٣٧٤p = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: d0, reason: merged with bridge method [inline-methods] */
        public boolean r(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i10) {
            this.f٨٣٧٥q = new WeakReference(bottomAppBar);
            View p02 = bottomAppBar.p0();
            if (p02 != null && !p02.isLaidOut()) {
                BottomAppBar.E0(bottomAppBar, p02);
                this.f٨٣٧٦r = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) p02.getLayoutParams())).bottomMargin;
                if (p02 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) p02;
                    if (bottomAppBar.f٨٣٥٤g == 0 && bottomAppBar.f٨٣٥٨k) {
                        floatingActionButton.setElevation(DownloadProgress.UNKNOWN_PROGRESS);
                        floatingActionButton.setCompatElevation(DownloadProgress.UNKNOWN_PROGRESS);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                    }
                    bottomAppBar.h0(floatingActionButton);
                }
                p02.addOnLayoutChangeListener(this.f٨٣٧٧s);
                bottomAppBar.z0();
            }
            coordinatorLayout.O(bottomAppBar, i10);
            return super.r(coordinatorLayout, bottomAppBar, i10);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: e0, reason: merged with bridge method [inline-methods] */
        public boolean G(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i10, int i11) {
            if (bottomAppBar.getHideOnScroll() && super.G(coordinatorLayout, bottomAppBar, view, view2, i10, i11)) {
                return true;
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f٨٣٧٧s = new a();
            this.f٨٣٧٤p = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BottomAppBar(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r6), attributeSet, i10);
        int i11 = A;
        f8.i iVar = new f8.i();
        this.f٨٣٤٩b = iVar;
        this.f٨٣٦٣p = 0;
        this.f٨٣٦٥r = 0;
        this.f٨٣٦٦s = false;
        this.f٨٣٦٧t = true;
        this.f٨٣٧٢y = new a();
        this.f٨٣٧٣z = new b();
        Context context2 = getContext();
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.BottomAppBar, i10, i11, new int[0]);
        ColorStateList a10 = c8.c.a(context2, i12, R.styleable.BottomAppBar_backgroundTint);
        int i13 = R.styleable.BottomAppBar_navigationIconTint;
        if (i12.hasValue(i13)) {
            setNavigationIconTint(i12.getColor(i13, -1));
        }
        int dimensionPixelSize = i12.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = i12.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = i12.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = i12.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.f٨٣٥٢e = i12.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.f٨٣٥٣f = i12.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.f٨٣٥٤g = i12.getInt(R.styleable.BottomAppBar_fabAnchorMode, 1);
        this.f٨٣٥٨k = i12.getBoolean(R.styleable.BottomAppBar_removeEmbeddedFabElevation, true);
        this.f٨٣٥٧j = i12.getInt(R.styleable.BottomAppBar_menuAlignmentMode, 0);
        this.f٨٣٥٩l = i12.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.f٨٣٦٠m = i12.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.f٨٣٦١n = i12.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.f٨٣٦٢o = i12.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        this.f٨٣٥٦i = i12.getDimensionPixelOffset(R.styleable.BottomAppBar_fabAlignmentModeEndMargin, -1);
        boolean z10 = i12.getBoolean(R.styleable.BottomAppBar_addElevationShadow, true);
        i12.recycle();
        this.f٨٣٥٥h = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        iVar.setShapeAppearanceModel(o.a().B(new com.google.android.material.bottomappbar.d(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).m());
        if (z10) {
            iVar.o0(2);
        } else {
            iVar.o0(1);
            if (Build.VERSION.SDK_INT >= 28) {
                setOutlineAmbientShadowColor(0);
                setOutlineSpotShadowColor(0);
            }
        }
        iVar.k0(Paint.Style.FILL);
        iVar.V(context2);
        iVar.setTintList(a10);
        setElevation(dimensionPixelSize);
        setBackground(iVar);
        k0.e(this, attributeSet, i10, i11, new c());
    }
}
