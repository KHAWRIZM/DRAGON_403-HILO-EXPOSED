package p7;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f١٦٩٤٧a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f١٦٩٤٨b = new z2.b();

    /* renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f١٦٩٤٩c = new z2.a();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f١٦٩٥٠d = new z2.c();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f١٦٩٥١e = new DecelerateInterpolator();

    public static float a(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    public static float b(float f10, float f11, float f12, float f13, float f14) {
        if (f14 <= f12) {
            return f10;
        }
        if (f14 >= f13) {
            return f11;
        }
        return a(f10, f11, (f14 - f12) / (f13 - f12));
    }

    public static int c(int i10, int i11, float f10) {
        return i10 + Math.round(f10 * (i11 - i10));
    }
}
