package v3;

import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class d0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٠٨a = c.a.a("nm", "p", "s", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.l a(w3.c cVar, com.airbnb.lottie.j jVar) {
        String str = null;
        r3.m mVar = null;
        r3.f fVar = null;
        r3.b bVar = null;
        boolean z10 = false;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤٠٨a);
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
                            bVar = d.e(cVar, jVar);
                        }
                    } else {
                        fVar = d.i(cVar, jVar);
                    }
                } else {
                    mVar = a.b(cVar, jVar);
                }
            } else {
                str = cVar.s();
            }
        }
        return new s3.l(str, mVar, fVar, bVar, z10);
    }
}
