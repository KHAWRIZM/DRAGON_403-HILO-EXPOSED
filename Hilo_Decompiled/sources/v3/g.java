package v3;

import android.graphics.Color;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final g f١٨٤١٤a = new g();

    private g() {
    }

    @Override // v3.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(w3.c cVar, float f10) {
        boolean z10;
        double d10;
        if (cVar.u() == c.b.BEGIN_ARRAY) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            cVar.b();
        }
        double m10 = cVar.m();
        double m11 = cVar.m();
        double m12 = cVar.m();
        if (cVar.u() == c.b.NUMBER) {
            d10 = cVar.m();
        } else {
            d10 = 1.0d;
        }
        if (z10) {
            cVar.g();
        }
        if (m10 <= 1.0d && m11 <= 1.0d && m12 <= 1.0d) {
            m10 *= 255.0d;
            m11 *= 255.0d;
            m12 *= 255.0d;
            if (d10 <= 1.0d) {
                d10 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) d10, (int) m10, (int) m11, (int) m12));
    }
}
