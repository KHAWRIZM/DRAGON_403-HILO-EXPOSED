package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private Animator f٩٠٦٦a;

    public void a() {
        Animator animator = this.f٩٠٦٦a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f٩٠٦٦a = null;
    }

    public void c(Animator animator) {
        a();
        this.f٩٠٦٦a = animator;
    }
}
