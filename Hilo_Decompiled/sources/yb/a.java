package yb;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import z2.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Interpolator f١٩٢٣١a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final Interpolator f١٩٢٣٢b = new z2.b();

    /* renamed from: c, reason: collision with root package name */
    public static final Interpolator f١٩٢٣٣c = new z2.a();

    /* renamed from: d, reason: collision with root package name */
    public static final Interpolator f١٩٢٣٤d = new c();

    /* renamed from: e, reason: collision with root package name */
    public static final Interpolator f١٩٢٣٥e = new DecelerateInterpolator();

    /* renamed from: f, reason: collision with root package name */
    public static final Interpolator f١٩٢٣٦f = new AccelerateInterpolator();

    /* renamed from: g, reason: collision with root package name */
    public static final Interpolator f١٩٢٣٧g = new AccelerateDecelerateInterpolator();

    /* renamed from: h, reason: collision with root package name */
    public static final Interpolator f١٩٢٣٨h = new InterpolatorC٠٢٤٧a();

    /* renamed from: yb.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class InterpolatorC٠٢٤٧a implements Interpolator {
        InterpolatorC٠٢٤٧a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }
}
