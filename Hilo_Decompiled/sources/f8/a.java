package f8;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private final float f١٤٠٨٦a;

    public a(float f10) {
        this.f١٤٠٨٦a = f10;
    }

    @Override // f8.d
    public float a(RectF rectF) {
        return this.f١٤٠٨٦a;
    }

    public float b() {
        return this.f١٤٠٨٦a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof a) && this.f١٤٠٨٦a == ((a) obj).f١٤٠٨٦a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f١٤٠٨٦a)});
    }

    public String toString() {
        return b() + "px";
    }
}
