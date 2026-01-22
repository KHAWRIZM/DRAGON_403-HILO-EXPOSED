package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f0 extends androidx.transition.k {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f٩٣٠٣a;

        a(TextView textView) {
            this.f٩٣٠٣a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f٩٣٠٣a.setScaleX(floatValue);
            this.f٩٣٠٣a.setScaleY(floatValue);
        }
    }

    private void q0(androidx.transition.c0 c0Var) {
        View view = c0Var.f٤٢٥٩b;
        if (view instanceof TextView) {
            c0Var.f٤٢٥٨a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.k
    public void h(androidx.transition.c0 c0Var) {
        q0(c0Var);
    }

    @Override // androidx.transition.k
    public void k(androidx.transition.c0 c0Var) {
        q0(c0Var);
    }

    @Override // androidx.transition.k
    public Animator o(ViewGroup viewGroup, androidx.transition.c0 c0Var, androidx.transition.c0 c0Var2) {
        float f10;
        if (c0Var == null || c0Var2 == null || !(c0Var.f٤٢٥٩b instanceof TextView)) {
            return null;
        }
        View view = c0Var2.f٤٢٥٩b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map map = c0Var.f٤٢٥٨a;
        Map map2 = c0Var2.f٤٢٥٨a;
        float f11 = 1.0f;
        if (map.get("android:textscale:scale") != null) {
            f10 = ((Float) map.get("android:textscale:scale")).floatValue();
        } else {
            f10 = 1.0f;
        }
        if (map2.get("android:textscale:scale") != null) {
            f11 = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (f10 == f11) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, f11);
        ofFloat.addUpdateListener(new a(textView));
        return ofFloat;
    }
}
