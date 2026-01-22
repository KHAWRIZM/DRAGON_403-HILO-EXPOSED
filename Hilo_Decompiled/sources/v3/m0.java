package v3;

import s3.t;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٤١a = c.a.a("s", "e", "o", "nm", "m", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.t a(w3.c cVar, com.airbnb.lottie.j jVar) {
        String str = null;
        t.a aVar = null;
        r3.b bVar = null;
        r3.b bVar2 = null;
        r3.b bVar3 = null;
        boolean z10 = false;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤٤١a);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        if (x10 != 3) {
                            if (x10 != 4) {
                                if (x10 != 5) {
                                    cVar.A();
                                } else {
                                    z10 = cVar.k();
                                }
                            } else {
                                aVar = t.a.c(cVar.o());
                            }
                        } else {
                            str = cVar.s();
                        }
                    } else {
                        bVar3 = d.f(cVar, jVar, false);
                    }
                } else {
                    bVar2 = d.f(cVar, jVar, false);
                }
            } else {
                bVar = d.f(cVar, jVar, false);
            }
        }
        return new s3.t(str, aVar, bVar, bVar2, bVar3, z10);
    }
}
