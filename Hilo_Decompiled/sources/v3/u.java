package v3;

import java.util.ArrayList;
import java.util.List;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class u {

    /* renamed from: a, reason: collision with root package name */
    static c.a f١٨٤٥٦a = c.a.a("k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List a(w3.c cVar, com.airbnb.lottie.j jVar, float f10, n0 n0Var, boolean z10) {
        ArrayList arrayList = new ArrayList();
        if (cVar.u() == c.b.STRING) {
            jVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.c();
        while (cVar.j()) {
            if (cVar.x(f١٨٤٥٦a) != 0) {
                cVar.A();
            } else if (cVar.u() == c.b.BEGIN_ARRAY) {
                cVar.b();
                if (cVar.u() == c.b.NUMBER) {
                    arrayList.add(t.c(cVar, jVar, f10, n0Var, false, z10));
                } else {
                    while (cVar.j()) {
                        arrayList.add(t.c(cVar, jVar, f10, n0Var, true, z10));
                    }
                }
                cVar.g();
            } else {
                arrayList.add(t.c(cVar, jVar, f10, n0Var, false, z10));
            }
        }
        cVar.h();
        b(arrayList);
        return arrayList;
    }

    public static void b(List list) {
        int i10;
        Object obj;
        int size = list.size();
        int i11 = 0;
        while (true) {
            i10 = size - 1;
            if (i11 >= i10) {
                break;
            }
            y3.a aVar = (y3.a) list.get(i11);
            i11++;
            y3.a aVar2 = (y3.a) list.get(i11);
            aVar.f١٩١٢٣h = Float.valueOf(aVar2.f١٩١٢٢g);
            if (aVar.f١٩١١٨c == null && (obj = aVar2.f١٩١١٧b) != null) {
                aVar.f١٩١١٨c = obj;
                if (aVar instanceof o3.i) {
                    ((o3.i) aVar).j();
                }
            }
        }
        y3.a aVar3 = (y3.a) list.get(i10);
        if ((aVar3.f١٩١١٧b == null || aVar3.f١٩١١٨c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
