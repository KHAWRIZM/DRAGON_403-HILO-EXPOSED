package v3;

import w3.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٠٩a = c.a.a("ef");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f١٨٤١٠b = c.a.a("ty", "v");

    private static s3.a a(w3.c cVar, com.airbnb.lottie.j jVar) {
        cVar.c();
        s3.a aVar = null;
        while (true) {
            boolean z10 = false;
            while (cVar.j()) {
                int x10 = cVar.x(f١٨٤١٠b);
                if (x10 != 0) {
                    if (x10 != 1) {
                        cVar.z();
                        cVar.A();
                    } else if (z10) {
                        aVar = new s3.a(d.e(cVar, jVar));
                    } else {
                        cVar.A();
                    }
                } else if (cVar.o() == 0) {
                    z10 = true;
                }
            }
            cVar.h();
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.a b(w3.c cVar, com.airbnb.lottie.j jVar) {
        s3.a aVar = null;
        while (cVar.j()) {
            if (cVar.x(f١٨٤٠٩a) != 0) {
                cVar.z();
                cVar.A();
            } else {
                cVar.b();
                while (cVar.j()) {
                    s3.a a10 = a(cVar, jVar);
                    if (a10 != null) {
                        aVar = a10;
                    }
                }
                cVar.g();
            }
        }
        return aVar;
    }
}
