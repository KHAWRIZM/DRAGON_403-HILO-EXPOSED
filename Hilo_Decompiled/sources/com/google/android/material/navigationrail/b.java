package com.google.android.material.navigationrail;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.c0;
import androidx.transition.k;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class b extends k {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(View view, ValueAnimator valueAnimator) {
        view.setTranslationX((1.0f - valueAnimator.getAnimatedFraction()) * (-30.0f));
    }

    @Override // androidx.transition.k
    public void h(c0 c0Var) {
        c0Var.f٤٢٥٨a.put("NavigationRailLabelVisibility", Integer.valueOf(c0Var.f٤٢٥٩b.getVisibility()));
    }

    @Override // androidx.transition.k
    public void k(c0 c0Var) {
        c0Var.f٤٢٥٨a.put("NavigationRailLabelVisibility", Integer.valueOf(c0Var.f٤٢٥٩b.getVisibility()));
    }

    @Override // androidx.transition.k
    public Animator o(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        if (c0Var != null && c0Var2 != null && c0Var.f٤٢٥٨a.get("NavigationRailLabelVisibility") != null && c0Var2.f٤٢٥٨a.get("NavigationRailLabelVisibility") != null) {
            if (((Integer) c0Var.f٤٢٥٨a.get("NavigationRailLabelVisibility")).intValue() == 8 && ((Integer) c0Var2.f٤٢٥٨a.get("NavigationRailLabelVisibility")).intValue() == 0) {
                final View view = c0Var2.f٤٢٥٩b;
                ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.navigationrail.a
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        b.r0(view, valueAnimator);
                    }
                });
                return ofFloat;
            }
            return super.o(viewGroup, c0Var, c0Var2);
        }
        return super.o(viewGroup, c0Var, c0Var2);
    }
}
