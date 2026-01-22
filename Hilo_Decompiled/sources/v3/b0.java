package v3;

import android.graphics.PointF;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b0 implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f١٨٤٠٤a = new b0();

    private b0() {
    }

    @Override // v3.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(w3.c cVar, float f10) {
        c.b u10 = cVar.u();
        if (u10 == c.b.BEGIN_ARRAY) {
            return s.e(cVar, f10);
        }
        if (u10 == c.b.BEGIN_OBJECT) {
            return s.e(cVar, f10);
        }
        if (u10 == c.b.NUMBER) {
            PointF pointF = new PointF(((float) cVar.m()) * f10, ((float) cVar.m()) * f10);
            while (cVar.j()) {
                cVar.A();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + u10);
    }
}
