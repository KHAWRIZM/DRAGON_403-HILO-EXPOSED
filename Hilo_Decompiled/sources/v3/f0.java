package v3;

import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤١٣a = c.a.a("nm", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.n a(w3.c cVar, com.airbnb.lottie.j jVar) {
        boolean z10 = false;
        String str = null;
        r3.b bVar = null;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤١٣a);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        cVar.A();
                    } else {
                        z10 = cVar.k();
                    }
                } else {
                    bVar = d.f(cVar, jVar, true);
                }
            } else {
                str = cVar.s();
            }
        }
        if (z10) {
            return null;
        }
        return new s3.n(str, bVar);
    }
}
