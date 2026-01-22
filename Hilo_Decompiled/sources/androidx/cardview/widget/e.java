package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private static final double f١٧٣٩a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(float f10, float f11, boolean z10) {
        if (z10) {
            return (float) (f10 + ((1.0d - f١٧٣٩a) * f11));
        }
        return f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f10, float f11, boolean z10) {
        if (z10) {
            return (float) ((f10 * 1.5f) + ((1.0d - f١٧٣٩a) * f11));
        }
        return f10 * 1.5f;
    }
}
