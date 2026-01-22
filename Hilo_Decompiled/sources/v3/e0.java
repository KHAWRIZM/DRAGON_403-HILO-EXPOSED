package v3;

import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤١١a = c.a.a("nm", "c", "o", "tr", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.m a(w3.c cVar, com.airbnb.lottie.j jVar) {
        String str = null;
        r3.b bVar = null;
        r3.b bVar2 = null;
        r3.l lVar = null;
        boolean z10 = false;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤١١a);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        if (x10 != 3) {
                            if (x10 != 4) {
                                cVar.A();
                            } else {
                                z10 = cVar.k();
                            }
                        } else {
                            lVar = c.g(cVar, jVar);
                        }
                    } else {
                        bVar2 = d.f(cVar, jVar, false);
                    }
                } else {
                    bVar = d.f(cVar, jVar, false);
                }
            } else {
                str = cVar.s();
            }
        }
        return new s3.m(str, bVar, bVar2, lVar, z10);
    }
}
