package v3;

import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٠٢a = c.a.a("a");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f١٨٤٠٣b = c.a.a("fc", "sc", "sw", "t");

    public static r3.k a(w3.c cVar, com.airbnb.lottie.j jVar) {
        cVar.c();
        r3.k kVar = null;
        while (cVar.j()) {
            if (cVar.x(f١٨٤٠٢a) != 0) {
                cVar.z();
                cVar.A();
            } else {
                kVar = b(cVar, jVar);
            }
        }
        cVar.h();
        if (kVar == null) {
            return new r3.k(null, null, null, null);
        }
        return kVar;
    }

    private static r3.k b(w3.c cVar, com.airbnb.lottie.j jVar) {
        cVar.c();
        r3.a aVar = null;
        r3.a aVar2 = null;
        r3.b bVar = null;
        r3.b bVar2 = null;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤٠٣b);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        if (x10 != 3) {
                            cVar.z();
                            cVar.A();
                        } else {
                            bVar2 = d.e(cVar, jVar);
                        }
                    } else {
                        bVar = d.e(cVar, jVar);
                    }
                } else {
                    aVar2 = d.c(cVar, jVar);
                }
            } else {
                aVar = d.c(cVar, jVar);
            }
        }
        cVar.h();
        return new r3.k(aVar, aVar2, bVar, bVar2);
    }
}
