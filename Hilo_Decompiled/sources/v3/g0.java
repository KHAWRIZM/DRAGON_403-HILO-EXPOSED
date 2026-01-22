package v3;

import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g0 implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f١٨٤١٥a = new g0();

    private g0() {
    }

    @Override // v3.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public y3.d a(w3.c cVar, float f10) {
        boolean z10;
        if (cVar.u() == c.b.BEGIN_ARRAY) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            cVar.b();
        }
        float m10 = (float) cVar.m();
        float m11 = (float) cVar.m();
        while (cVar.j()) {
            cVar.A();
        }
        if (z10) {
            cVar.g();
        }
        return new y3.d((m10 / 100.0f) * f10, (m11 / 100.0f) * f10);
    }
}
