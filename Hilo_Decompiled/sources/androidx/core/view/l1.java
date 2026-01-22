package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class l1 {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f٢٩٩٠a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m1 f٢٩٩١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f٢٩٩٢b;

        a(m1 m1Var, View view) {
            this.f٢٩٩١a = m1Var;
            this.f٢٩٩٢b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f٢٩٩١a.onAnimationCancel(this.f٢٩٩٢b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f٢٩٩١a.onAnimationEnd(this.f٢٩٩٢b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f٢٩٩١a.onAnimationStart(this.f٢٩٩٢b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l1(View view) {
        this.f٢٩٩٠a = new WeakReference(view);
    }

    private void i(View view, m1 m1Var) {
        if (m1Var != null) {
            view.animate().setListener(new a(m1Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public l1 b(float f10) {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    public void c() {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public l1 f(long j10) {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    public l1 g(Interpolator interpolator) {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public l1 h(m1 m1Var) {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            i(view, m1Var);
        }
        return this;
    }

    public l1 j(long j10) {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    public l1 k(final o1 o1Var) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        final View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            if (o1Var != null) {
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.k1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        o1.this.a(view);
                    }
                };
            } else {
                animatorUpdateListener = null;
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }

    public void l() {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public l1 m(float f10) {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            view.animate().translationX(f10);
        }
        return this;
    }

    public l1 n(float f10) {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }

    public l1 o(Runnable runnable) {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            view.animate().withEndAction(runnable);
        }
        return this;
    }

    public l1 p() {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            view.animate().withLayer();
        }
        return this;
    }

    public l1 q(Runnable runnable) {
        View view = (View) this.f٢٩٩٠a.get();
        if (view != null) {
            view.animate().withStartAction(runnable);
        }
        return this;
    }
}
