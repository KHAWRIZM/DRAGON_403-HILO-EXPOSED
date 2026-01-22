package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.k;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d extends t0 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a extends AnimatorListenerAdapter implements k.i {

        /* renamed from: a, reason: collision with root package name */
        private final View f٤٢٦١a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f٤٢٦٢b = false;

        a(View view) {
            this.f٤٢٦١a = view;
        }

        @Override // androidx.transition.k.i
        public void b(k kVar) {
            this.f٤٢٦١a.setTag(R.id.transition_pause_alpha, null);
        }

        @Override // androidx.transition.k.i
        public void d(k kVar) {
        }

        @Override // androidx.transition.k.i
        public void e(k kVar) {
            float f10;
            if (this.f٤٢٦١a.getVisibility() == 0) {
                f10 = g0.b(this.f٤٢٦١a);
            } else {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            this.f٤٢٦١a.setTag(R.id.transition_pause_alpha, Float.valueOf(f10));
        }

        @Override // androidx.transition.k.i
        public /* synthetic */ void g(k kVar, boolean z10) {
            o.a(this, kVar, z10);
        }

        @Override // androidx.transition.k.i
        public void i(k kVar) {
        }

        @Override // androidx.transition.k.i
        public void k(k kVar) {
        }

        @Override // androidx.transition.k.i
        public void l(k kVar, boolean z10) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            g0.e(this.f٤٢٦١a, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f٤٢٦١a.hasOverlappingRendering() && this.f٤٢٦١a.getLayerType() == 0) {
                this.f٤٢٦٢b = true;
                this.f٤٢٦١a.setLayerType(2, null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (this.f٤٢٦٢b) {
                this.f٤٢٦١a.setLayerType(0, null);
            }
            if (z10) {
                return;
            }
            g0.e(this.f٤٢٦١a, 1.0f);
            g0.a(this.f٤٢٦١a);
        }
    }

    public d(int i10) {
        w0(i10);
    }

    private Animator x0(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        g0.e(view, f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) g0.f٤٢٩١b, f11);
        a aVar = new a(view);
        ofFloat.addListener(aVar);
        D().c(aVar);
        return ofFloat;
    }

    private static float y0(c0 c0Var, float f10) {
        Float f11;
        if (c0Var != null && (f11 = (Float) c0Var.f٤٢٥٨a.get("android:fade:transitionAlpha")) != null) {
            return f11.floatValue();
        }
        return f10;
    }

    @Override // androidx.transition.k
    public boolean O() {
        return true;
    }

    @Override // androidx.transition.t0, androidx.transition.k
    public void k(c0 c0Var) {
        super.k(c0Var);
        Float f10 = (Float) c0Var.f٤٢٥٩b.getTag(R.id.transition_pause_alpha);
        if (f10 == null) {
            if (c0Var.f٤٢٥٩b.getVisibility() == 0) {
                f10 = Float.valueOf(g0.b(c0Var.f٤٢٥٩b));
            } else {
                f10 = Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS);
            }
        }
        c0Var.f٤٢٥٨a.put("android:fade:transitionAlpha", f10);
    }

    @Override // androidx.transition.t0
    public Animator s0(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2) {
        g0.c(view);
        return x0(view, y0(c0Var, DownloadProgress.UNKNOWN_PROGRESS), 1.0f);
    }

    @Override // androidx.transition.t0
    public Animator u0(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2) {
        g0.c(view);
        Animator x02 = x0(view, y0(c0Var, 1.0f), DownloadProgress.UNKNOWN_PROGRESS);
        if (x02 == null) {
            g0.e(view, y0(c0Var2, 1.0f));
        }
        return x02;
    }

    public d() {
    }
}
