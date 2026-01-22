package com.google.android.material.behavior;

import a8.k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.app.a0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.material.R;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class HideViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c {

    /* renamed from: o, reason: collision with root package name */
    private static final int f٨٣١١o = R.attr.motionDurationLong2;

    /* renamed from: p, reason: collision with root package name */
    private static final int f٨٣١٢p = R.attr.motionDurationMedium4;

    /* renamed from: q, reason: collision with root package name */
    private static final int f٨٣١٣q = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: a, reason: collision with root package name */
    private d f٨٣١٤a;

    /* renamed from: b, reason: collision with root package name */
    private AccessibilityManager f٨٣١٥b;

    /* renamed from: c, reason: collision with root package name */
    private AccessibilityManager.TouchExplorationStateChangeListener f٨٣١٦c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٨٣١٧d;

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashSet f٨٣١٨e;

    /* renamed from: f, reason: collision with root package name */
    private int f٨٣١٩f;

    /* renamed from: g, reason: collision with root package name */
    private int f٨٣٢٠g;

    /* renamed from: h, reason: collision with root package name */
    private TimeInterpolator f٨٣٢١h;

    /* renamed from: i, reason: collision with root package name */
    private TimeInterpolator f٨٣٢٢i;

    /* renamed from: j, reason: collision with root package name */
    private int f٨٣٢٣j;

    /* renamed from: k, reason: collision with root package name */
    private int f٨٣٢٤k;

    /* renamed from: l, reason: collision with root package name */
    private int f٨٣٢٥l;

    /* renamed from: m, reason: collision with root package name */
    private ViewPropertyAnimator f٨٣٢٦m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f٨٣٢٧n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (HideViewOnScrollBehavior.this.f٨٣١٦c != null && HideViewOnScrollBehavior.this.f٨٣١٥b != null) {
                HideViewOnScrollBehavior.this.f٨٣١٥b.removeTouchExplorationStateChangeListener(HideViewOnScrollBehavior.this.f٨٣١٦c);
                HideViewOnScrollBehavior.this.f٨٣١٦c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideViewOnScrollBehavior.this.f٨٣٢٦m = null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
    }

    public HideViewOnScrollBehavior() {
        this.f٨٣١٧d = true;
        this.f٨٣١٨e = new LinkedHashSet();
        this.f٨٣٢٣j = 0;
        this.f٨٣٢٤k = 2;
        this.f٨٣٢٥l = 0;
        this.f٨٣٢٧n = false;
    }

    private void P(View view, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f٨٣٢٦m = this.f٨٣١٤a.d(view, i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new b());
    }

    private void Q(final View view) {
        if (this.f٨٣١٥b == null) {
            this.f٨٣١٥b = (AccessibilityManager) androidx.core.content.a.getSystemService(view.getContext(), AccessibilityManager.class);
        }
        if (this.f٨٣١٥b != null && this.f٨٣١٦c == null) {
            AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: r7.b
                @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
                public final void onTouchExplorationStateChanged(boolean z10) {
                    HideViewOnScrollBehavior.this.V(view, z10);
                }
            };
            this.f٨٣١٦c = touchExplorationStateChangeListener;
            this.f٨٣١٥b.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
            view.addOnAttachStateChangeListener(new a());
        }
    }

    private boolean R(int i10) {
        return i10 == 80 || i10 == 81;
    }

    private boolean S(int i10) {
        return i10 == 3 || i10 == 19;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view, boolean z10) {
        if (this.f٨٣١٧d && z10 && U()) {
            Y(view);
        }
    }

    private void W(View view, int i10) {
        int i11;
        if (this.f٨٣٢٧n) {
            return;
        }
        int i12 = ((CoordinatorLayout.f) view.getLayoutParams()).f٢٥٦٢c;
        if (R(i12)) {
            X(1);
            return;
        }
        if (S(Gravity.getAbsoluteGravity(i12, i10))) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        X(i11);
    }

    private void X(int i10) {
        d dVar = this.f٨٣١٤a;
        if (dVar == null || dVar.c() != i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        this.f٨٣١٤a = new com.google.android.material.behavior.b();
                        return;
                    }
                    throw new IllegalArgumentException("Invalid view edge position value: " + i10 + ". Must be 0, 1 or 2" + InstructionFileId.DOT);
                }
                this.f٨٣١٤a = new com.google.android.material.behavior.a();
                return;
            }
            this.f٨٣١٤a = new com.google.android.material.behavior.c();
        }
    }

    private void c0(View view, int i10) {
        this.f٨٣٢٤k = i10;
        Iterator it = this.f٨٣١٨e.iterator();
        if (!it.hasNext()) {
            return;
        }
        a0.a(it.next());
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean G(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i10, int i11) {
        return i10 == 2;
    }

    public boolean T() {
        if (this.f٨٣٢٤k == 2) {
            return true;
        }
        return false;
    }

    public boolean U() {
        if (this.f٨٣٢٤k == 1) {
            return true;
        }
        return false;
    }

    public void Y(View view) {
        Z(view, true);
    }

    public void Z(View view, boolean z10) {
        if (T()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f٨٣٢٦m;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        c0(view, 2);
        int b10 = this.f٨٣١٤a.b();
        if (z10) {
            P(view, b10, this.f٨٣١٩f, this.f٨٣٢١h);
        } else {
            this.f٨٣١٤a.e(view, b10);
        }
    }

    public void a0(View view) {
        b0(view, true);
    }

    public void addOnScrollStateChangedListener(c cVar) {
        this.f٨٣١٨e.add(cVar);
    }

    public void b0(View view, boolean z10) {
        AccessibilityManager accessibilityManager;
        if (U()) {
            return;
        }
        if (this.f٨٣١٧d && (accessibilityManager = this.f٨٣١٥b) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f٨٣٢٦m;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        c0(view, 1);
        int i10 = this.f٨٣٢٣j + this.f٨٣٢٥l;
        if (z10) {
            P(view, i10, this.f٨٣٢٠g, this.f٨٣٢٢i);
        } else {
            this.f٨٣١٤a.e(view, i10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i10) {
        Q(view);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        W(view, i10);
        this.f٨٣٢٣j = this.f٨٣١٤a.a(view, marginLayoutParams);
        this.f٨٣١٩f = k.f(view.getContext(), f٨٣١١o, 225);
        this.f٨٣٢٠g = k.f(view.getContext(), f٨٣١٢p, 175);
        Context context = view.getContext();
        int i11 = f٨٣١٣q;
        this.f٨٣٢١h = k.g(context, i11, p7.a.f١٦٩٥٠d);
        this.f٨٣٢٢i = k.g(view.getContext(), i11, p7.a.f١٦٩٤٩c);
        return super.r(coordinatorLayout, view, i10);
    }

    public void removeOnScrollStateChangedListener(c cVar) {
        this.f٨٣١٨e.remove(cVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i11 > 0) {
            a0(view);
        } else if (i11 < 0) {
            Y(view);
        }
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٨٣١٧d = true;
        this.f٨٣١٨e = new LinkedHashSet();
        this.f٨٣٢٣j = 0;
        this.f٨٣٢٤k = 2;
        this.f٨٣٢٥l = 0;
        this.f٨٣٢٧n = false;
    }
}
