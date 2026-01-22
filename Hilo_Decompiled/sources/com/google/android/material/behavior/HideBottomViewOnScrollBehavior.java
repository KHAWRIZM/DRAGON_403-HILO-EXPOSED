package com.google.android.material.behavior;

import a8.k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.app.a0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.util.Iterator;
import java.util.LinkedHashSet;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c {

    /* renamed from: m, reason: collision with root package name */
    private static final int f٨٢٩٤m = R.attr.motionDurationLong2;

    /* renamed from: n, reason: collision with root package name */
    private static final int f٨٢٩٥n = R.attr.motionDurationMedium4;

    /* renamed from: o, reason: collision with root package name */
    private static final int f٨٢٩٦o = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f٨٢٩٧a;

    /* renamed from: b, reason: collision with root package name */
    private int f٨٢٩٨b;

    /* renamed from: c, reason: collision with root package name */
    private int f٨٢٩٩c;

    /* renamed from: d, reason: collision with root package name */
    private TimeInterpolator f٨٣٠٠d;

    /* renamed from: e, reason: collision with root package name */
    private TimeInterpolator f٨٣٠١e;

    /* renamed from: f, reason: collision with root package name */
    private int f٨٣٠٢f;

    /* renamed from: g, reason: collision with root package name */
    private AccessibilityManager f٨٣٠٣g;

    /* renamed from: h, reason: collision with root package name */
    private AccessibilityManager.TouchExplorationStateChangeListener f٨٣٠٤h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٨٣٠٥i;

    /* renamed from: j, reason: collision with root package name */
    private int f٨٣٠٦j;

    /* renamed from: k, reason: collision with root package name */
    private int f٨٣٠٧k;

    /* renamed from: l, reason: collision with root package name */
    private ViewPropertyAnimator f٨٣٠٨l;

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
            if (HideBottomViewOnScrollBehavior.this.f٨٣٠٤h != null && HideBottomViewOnScrollBehavior.this.f٨٣٠٣g != null) {
                HideBottomViewOnScrollBehavior.this.f٨٣٠٣g.removeTouchExplorationStateChangeListener(HideBottomViewOnScrollBehavior.this.f٨٣٠٤h);
                HideBottomViewOnScrollBehavior.this.f٨٣٠٤h = null;
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
            HideBottomViewOnScrollBehavior.this.f٨٣٠٨l = null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
    }

    public HideBottomViewOnScrollBehavior() {
        this.f٨٢٩٧a = new LinkedHashSet();
        this.f٨٣٠٢f = 0;
        this.f٨٣٠٥i = true;
        this.f٨٣٠٦j = 2;
        this.f٨٣٠٧k = 0;
    }

    private void P(View view, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f٨٣٠٨l = view.animate().translationY(i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new b());
    }

    private void Q(final View view) {
        if (this.f٨٣٠٣g == null) {
            this.f٨٣٠٣g = (AccessibilityManager) androidx.core.content.a.getSystemService(view.getContext(), AccessibilityManager.class);
        }
        if (this.f٨٣٠٣g != null && this.f٨٣٠٤h == null) {
            AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: r7.a
                @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
                public final void onTouchExplorationStateChanged(boolean z10) {
                    HideBottomViewOnScrollBehavior.this.T(view, z10);
                }
            };
            this.f٨٣٠٤h = touchExplorationStateChangeListener;
            this.f٨٣٠٣g.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
            view.addOnAttachStateChangeListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(View view, boolean z10) {
        if (z10 && R()) {
            X(view);
        }
    }

    private void Z(View view, int i10) {
        this.f٨٣٠٦j = i10;
        Iterator it = this.f٨٢٩٧a.iterator();
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

    public boolean R() {
        if (this.f٨٣٠٦j == 1) {
            return true;
        }
        return false;
    }

    public boolean S() {
        if (this.f٨٣٠٦j == 2) {
            return true;
        }
        return false;
    }

    public void U(View view, int i10) {
        this.f٨٣٠٧k = i10;
        if (this.f٨٣٠٦j == 1) {
            view.setTranslationY(this.f٨٣٠٢f + i10);
        }
    }

    public void V(View view) {
        W(view, true);
    }

    public void W(View view, boolean z10) {
        AccessibilityManager accessibilityManager;
        if (R()) {
            return;
        }
        if (this.f٨٣٠٥i && (accessibilityManager = this.f٨٣٠٣g) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f٨٣٠٨l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        Z(view, 1);
        int i10 = this.f٨٣٠٢f + this.f٨٣٠٧k;
        if (z10) {
            P(view, i10, this.f٨٢٩٩c, this.f٨٣٠١e);
        } else {
            view.setTranslationY(i10);
        }
    }

    public void X(View view) {
        Y(view, true);
    }

    public void Y(View view, boolean z10) {
        if (S()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f٨٣٠٨l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        Z(view, 2);
        if (z10) {
            P(view, 0, this.f٨٢٩٨b, this.f٨٣٠٠d);
        } else {
            view.setTranslationY(0);
        }
    }

    public void addOnScrollStateChangedListener(c cVar) {
        this.f٨٢٩٧a.add(cVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i10) {
        this.f٨٣٠٢f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f٨٢٩٨b = k.f(view.getContext(), f٨٢٩٤m, 225);
        this.f٨٢٩٩c = k.f(view.getContext(), f٨٢٩٥n, 175);
        Context context = view.getContext();
        int i11 = f٨٢٩٦o;
        this.f٨٣٠٠d = k.g(context, i11, p7.a.f١٦٩٥٠d);
        this.f٨٣٠١e = k.g(view.getContext(), i11, p7.a.f١٦٩٤٩c);
        Q(view);
        return super.r(coordinatorLayout, view, i10);
    }

    public void removeOnScrollStateChangedListener(c cVar) {
        this.f٨٢٩٧a.remove(cVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i11 > 0) {
            V(view);
        } else if (i11 < 0) {
            X(view);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٨٢٩٧a = new LinkedHashSet();
        this.f٨٣٠٢f = 0;
        this.f٨٣٠٥i = true;
        this.f٨٣٠٦j = 2;
        this.f٨٣٠٧k = 0;
    }
}
