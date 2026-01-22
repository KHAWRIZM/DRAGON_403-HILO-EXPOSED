package com.google.android.material.navigation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import androidx.core.graphics.x;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f٩٥٣٠a = Color.alpha(-1728053248);

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DrawerLayout f٩٥٣١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f٩٥٣٢b;

        a(DrawerLayout drawerLayout, View view) {
            this.f٩٥٣١a = drawerLayout;
            this.f٩٥٣٢b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f٩٥٣١a.e(this.f٩٥٣٢b, false);
            this.f٩٥٣١a.setScrimColor(-1728053248);
        }
    }

    public static Animator.AnimatorListener b(DrawerLayout drawerLayout, View view) {
        return new a(drawerLayout, view);
    }

    public static ValueAnimator.AnimatorUpdateListener c(final DrawerLayout drawerLayout) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.navigation.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.d(DrawerLayout.this, valueAnimator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(DrawerLayout drawerLayout, ValueAnimator valueAnimator) {
        drawerLayout.setScrimColor(x.l(-1728053248, p7.a.c(f٩٥٣٠a, 0, valueAnimator.getAnimatedFraction())));
    }
}
