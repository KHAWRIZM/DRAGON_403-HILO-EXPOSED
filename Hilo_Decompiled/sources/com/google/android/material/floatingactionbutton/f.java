package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;
import p7.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface f {
    void a(h hVar);

    void b();

    h c();

    boolean d();

    void e();

    int f();

    void g();

    List getListeners();

    AnimatorSet h();

    void i(ExtendedFloatingActionButton.l lVar);

    void onAnimationStart(Animator animator);
}
