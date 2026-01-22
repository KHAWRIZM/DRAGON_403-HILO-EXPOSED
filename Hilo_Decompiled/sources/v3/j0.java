package v3;

import java.util.ArrayList;
import w3.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٢٧a = c.a.a("nm", "hd", "it");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.q a(w3.c cVar, com.airbnb.lottie.j jVar) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z10 = false;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤٢٧a);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        cVar.A();
                    } else {
                        cVar.b();
                        while (cVar.j()) {
                            s3.c a10 = h.a(cVar, jVar);
                            if (a10 != null) {
                                arrayList.add(a10);
                            }
                        }
                        cVar.g();
                    }
                } else {
                    z10 = cVar.k();
                }
            } else {
                str = cVar.s();
            }
        }
        return new s3.q(str, arrayList, z10);
    }
}
