package v3;

import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    static c.a f١٨٤٣٥a = c.a.a("nm", "ind", "ks", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.r a(w3.c cVar, com.airbnb.lottie.j jVar) {
        String str = null;
        r3.h hVar = null;
        int i10 = 0;
        boolean z10 = false;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤٣٥a);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        if (x10 != 3) {
                            cVar.A();
                        } else {
                            z10 = cVar.k();
                        }
                    } else {
                        hVar = d.k(cVar, jVar);
                    }
                } else {
                    i10 = cVar.o();
                }
            } else {
                str = cVar.s();
            }
        }
        return new s3.r(str, i10, hVar, z10);
    }
}
