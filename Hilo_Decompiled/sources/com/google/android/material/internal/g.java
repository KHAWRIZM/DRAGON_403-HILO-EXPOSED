package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    private final View f٩٣٠٥a;

    /* renamed from: b, reason: collision with root package name */
    private final View f٩٣٠٦b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f٩٣٠٧c = new float[2];

    public g(View view, View view2) {
        this.f٩٣٠٥a = view;
        this.f٩٣٠٦b = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        h.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f٩٣٠٧c);
        View view = this.f٩٣٠٥a;
        if (view != null) {
            view.setAlpha(this.f٩٣٠٧c[0]);
        }
        View view2 = this.f٩٣٠٦b;
        if (view2 != null) {
            view2.setAlpha(this.f٩٣٠٧c[1]);
        }
    }
}
