package s0;

import android.animation.ValueAnimator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f١٧٥٤٣a;

    public b(e eVar) {
        this.f١٧٥٤٣a = eVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f١٧٥٤٣a.c(0, true, ((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
    }
}
