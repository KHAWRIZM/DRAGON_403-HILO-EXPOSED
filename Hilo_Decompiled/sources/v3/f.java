package v3;

import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤١٢a = c.a.a("nm", "p", "s", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.b a(w3.c cVar, com.airbnb.lottie.j jVar, int i10) {
        boolean z10;
        if (i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = z10;
        String str = null;
        r3.m mVar = null;
        r3.f fVar = null;
        boolean z12 = false;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤١٢a);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        if (x10 != 3) {
                            if (x10 != 4) {
                                cVar.z();
                                cVar.A();
                            } else if (cVar.o() == 3) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                        } else {
                            z12 = cVar.k();
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
        return new s3.b(str, mVar, fVar, z11, z12);
    }
}
