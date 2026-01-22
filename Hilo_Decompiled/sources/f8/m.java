package f8;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class m implements d {

    /* renamed from: a, reason: collision with root package name */
    private final float f١٤١٧٦a;

    public m(float f10) {
        this.f١٤١٧٦a = f10;
    }

    public static m b(RectF rectF, d dVar) {
        if (dVar instanceof m) {
            return (m) dVar;
        }
        return new m(dVar.a(rectF) / c(rectF));
    }

    private static float c(RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    @Override // f8.d
    public float a(RectF rectF) {
        return this.f١٤١٧٦a * c(rectF);
    }

    public float d() {
        return this.f١٤١٧٦a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof m) && this.f١٤١٧٦a == ((m) obj).f١٤١٧٦a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f١٤١٧٦a)});
    }

    public String toString() {
        return ((int) (d() * 100.0f)) + "%";
    }
}
