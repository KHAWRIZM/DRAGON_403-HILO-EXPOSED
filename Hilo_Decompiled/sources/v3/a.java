package v3;

import java.util.ArrayList;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٠٠a = c.a.a("k", "x", "y");

    public static r3.e a(w3.c cVar, com.airbnb.lottie.j jVar) {
        ArrayList arrayList = new ArrayList();
        if (cVar.u() == c.b.BEGIN_ARRAY) {
            cVar.b();
            while (cVar.j()) {
                arrayList.add(z.a(cVar, jVar));
            }
            cVar.g();
            u.b(arrayList);
        } else {
            arrayList.add(new y3.a(s.e(cVar, x3.l.e())));
        }
        return new r3.e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r3.m b(w3.c cVar, com.airbnb.lottie.j jVar) {
        cVar.c();
        r3.e eVar = null;
        r3.b bVar = null;
        r3.b bVar2 = null;
        boolean z10 = false;
        while (cVar.u() != c.b.END_OBJECT) {
            int x10 = cVar.x(f١٨٤٠٠a);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        cVar.z();
                        cVar.A();
                    } else if (cVar.u() == c.b.STRING) {
                        cVar.A();
                        z10 = true;
                    } else {
                        bVar2 = d.e(cVar, jVar);
                    }
                } else if (cVar.u() == c.b.STRING) {
                    cVar.A();
                    z10 = true;
                } else {
                    bVar = d.e(cVar, jVar);
                }
            } else {
                eVar = a(cVar, jVar);
            }
        }
        cVar.h();
        if (z10) {
            jVar.a("Lottie doesn't support expressions.");
        }
        if (eVar != null) {
            return eVar;
        }
        return new r3.i(bVar, bVar2);
    }
}
