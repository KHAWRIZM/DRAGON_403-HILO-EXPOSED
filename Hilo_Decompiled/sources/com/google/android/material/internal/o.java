package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class o implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    private final a f٩٣٢٣a;

    /* renamed from: b, reason: collision with root package name */
    private final View[] f٩٣٢٤b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    interface a {
        void a(ValueAnimator valueAnimator, View view);
    }

    public o(a aVar, View... viewArr) {
        this.f٩٣٢٣a = aVar;
        this.f٩٣٢٤b = viewArr;
    }

    public static o e(View... viewArr) {
        return new o(new a() { // from class: com.google.android.material.internal.n
            @Override // com.google.android.material.internal.o.a
            public final void a(ValueAnimator valueAnimator, View view) {
                o.g(valueAnimator, view);
            }
        }, viewArr);
    }

    public static o f(View... viewArr) {
        return new o(new a() { // from class: com.google.android.material.internal.m
            @Override // com.google.android.material.internal.o.a
            public final void a(ValueAnimator valueAnimator, View view) {
                o.h(valueAnimator, view);
            }
        }, viewArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(ValueAnimator valueAnimator, View view) {
        view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(ValueAnimator valueAnimator, View view) {
        Float f10 = (Float) valueAnimator.getAnimatedValue();
        view.setScaleX(f10.floatValue());
        view.setScaleY(f10.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(ValueAnimator valueAnimator, View view) {
        view.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(ValueAnimator valueAnimator, View view) {
        view.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static o k(View... viewArr) {
        return new o(new a() { // from class: com.google.android.material.internal.k
            @Override // com.google.android.material.internal.o.a
            public final void a(ValueAnimator valueAnimator, View view) {
                o.i(valueAnimator, view);
            }
        }, viewArr);
    }

    public static o l(View... viewArr) {
        return new o(new a() { // from class: com.google.android.material.internal.l
            @Override // com.google.android.material.internal.o.a
            public final void a(ValueAnimator valueAnimator, View view) {
                o.j(valueAnimator, view);
            }
        }, viewArr);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        for (View view : this.f٩٣٢٤b) {
            this.f٩٣٢٣a.a(valueAnimator, view);
        }
    }
}
