package d2;

import c2.d;
import c2.e;
import d2.b;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class i {
    public static o a(c2.e eVar, int i10, ArrayList arrayList, o oVar) {
        int i11;
        int w12;
        if (i10 == 0) {
            i11 = eVar.S0;
        } else {
            i11 = eVar.T0;
        }
        int i12 = 0;
        if (i11 != -1 && (oVar == null || i11 != oVar.f١٣٦٠٨b)) {
            int i13 = 0;
            while (true) {
                if (i13 >= arrayList.size()) {
                    break;
                }
                o oVar2 = (o) arrayList.get(i13);
                if (oVar2.c() == i11) {
                    if (oVar != null) {
                        oVar.g(i10, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                } else {
                    i13++;
                }
            }
        } else if (i11 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((eVar instanceof c2.j) && (w12 = ((c2.j) eVar).w1(i10)) != -1) {
                int i14 = 0;
                while (true) {
                    if (i14 >= arrayList.size()) {
                        break;
                    }
                    o oVar3 = (o) arrayList.get(i14);
                    if (oVar3.c() == w12) {
                        oVar = oVar3;
                        break;
                    }
                    i14++;
                }
            }
            if (oVar == null) {
                oVar = new o(i10);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(eVar)) {
            if (eVar instanceof c2.h) {
                c2.h hVar = (c2.h) eVar;
                c2.d v12 = hVar.v1();
                if (hVar.w1() == 0) {
                    i12 = 1;
                }
                v12.c(i12, arrayList, oVar);
            }
            if (i10 == 0) {
                eVar.S0 = oVar.c();
                eVar.Q.c(i10, arrayList, oVar);
                eVar.S.c(i10, arrayList, oVar);
            } else {
                eVar.T0 = oVar.c();
                eVar.R.c(i10, arrayList, oVar);
                eVar.U.c(i10, arrayList, oVar);
                eVar.T.c(i10, arrayList, oVar);
            }
            eVar.X.c(i10, arrayList, oVar);
        }
        return oVar;
    }

    private static o b(ArrayList arrayList, int i10) {
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            o oVar = (o) arrayList.get(i11);
            if (i10 == oVar.f١٣٦٠٨b) {
                return oVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:211:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0392 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x038d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(c2.f fVar, b.InterfaceC٠١٥٠b r17) {
        o oVar;
        o oVar2;
        ArrayList v12 = fVar.v1();
        int size = v12.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            c2.e eVar = (c2.e) v12.get(i11);
            if (!d(fVar.C(), fVar.V(), eVar.C(), eVar.V()) || (eVar instanceof c2.g)) {
                return false;
            }
        }
        int i12 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList arrayList4 = null;
        ArrayList arrayList5 = null;
        ArrayList arrayList6 = null;
        while (i12 < size) {
            c2.e eVar2 = (c2.e) v12.get(i12);
            if (!d(fVar.C(), fVar.V(), eVar2.C(), eVar2.V())) {
                c2.f.X1(i10, eVar2, r17, fVar.f٥٧٨٥z1, b.a.f١٣٥٤٤k);
            }
            boolean z10 = eVar2 instanceof c2.h;
            if (z10) {
                c2.h hVar = (c2.h) eVar2;
                if (hVar.w1() == 0) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(hVar);
                }
                if (hVar.w1() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(hVar);
                }
            }
            if (eVar2 instanceof c2.j) {
                if (eVar2 instanceof c2.a) {
                    c2.a aVar = (c2.a) eVar2;
                    if (aVar.B1() == 0) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(aVar);
                    }
                    if (aVar.B1() == 1) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(aVar);
                    }
                } else {
                    c2.j jVar = (c2.j) eVar2;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(jVar);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(jVar);
                }
            }
            if (eVar2.Q.f٥٦٨٥f == null && eVar2.S.f٥٦٨٥f == null && !z10 && !(eVar2 instanceof c2.a)) {
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                }
                arrayList5.add(eVar2);
            }
            if (eVar2.R.f٥٦٨٥f == null && eVar2.T.f٥٦٨٥f == null && eVar2.U.f٥٦٨٥f == null && !z10 && !(eVar2 instanceof c2.a)) {
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                }
                arrayList6.add(eVar2);
            }
            i12++;
            i10 = 0;
        }
        ArrayList arrayList7 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a((c2.h) it.next(), 0, arrayList7, null);
            }
        }
        int i13 = 0;
        o oVar3 = null;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c2.j jVar2 = (c2.j) it2.next();
                o a10 = a(jVar2, i13, arrayList7, oVar3);
                jVar2.v1(arrayList7, i13, a10);
                a10.b(arrayList7);
                i13 = 0;
                oVar3 = null;
            }
        }
        c2.d q10 = fVar.q(d.b.LEFT);
        if (q10.d() != null) {
            Iterator it3 = q10.d().iterator();
            while (it3.hasNext()) {
                a(((c2.d) it3.next()).f٥٦٨٣d, 0, arrayList7, null);
            }
        }
        c2.d q11 = fVar.q(d.b.RIGHT);
        if (q11.d() != null) {
            Iterator it4 = q11.d().iterator();
            while (it4.hasNext()) {
                a(((c2.d) it4.next()).f٥٦٨٣d, 0, arrayList7, null);
            }
        }
        c2.d q12 = fVar.q(d.b.CENTER);
        if (q12.d() != null) {
            Iterator it5 = q12.d().iterator();
            while (it5.hasNext()) {
                a(((c2.d) it5.next()).f٥٦٨٣d, 0, arrayList7, null);
            }
        }
        o oVar4 = null;
        if (arrayList5 != null) {
            Iterator it6 = arrayList5.iterator();
            while (it6.hasNext()) {
                a((c2.e) it6.next(), 0, arrayList7, null);
            }
        }
        if (arrayList3 != null) {
            Iterator it7 = arrayList3.iterator();
            while (it7.hasNext()) {
                a((c2.h) it7.next(), 1, arrayList7, null);
            }
        }
        int i14 = 1;
        if (arrayList4 != null) {
            Iterator it8 = arrayList4.iterator();
            while (it8.hasNext()) {
                c2.j jVar3 = (c2.j) it8.next();
                o a11 = a(jVar3, i14, arrayList7, oVar4);
                jVar3.v1(arrayList7, i14, a11);
                a11.b(arrayList7);
                i14 = 1;
                oVar4 = null;
            }
        }
        c2.d q13 = fVar.q(d.b.TOP);
        if (q13.d() != null) {
            Iterator it9 = q13.d().iterator();
            while (it9.hasNext()) {
                a(((c2.d) it9.next()).f٥٦٨٣d, 1, arrayList7, null);
            }
        }
        c2.d q14 = fVar.q(d.b.BASELINE);
        if (q14.d() != null) {
            Iterator it10 = q14.d().iterator();
            while (it10.hasNext()) {
                a(((c2.d) it10.next()).f٥٦٨٣d, 1, arrayList7, null);
            }
        }
        c2.d q15 = fVar.q(d.b.BOTTOM);
        if (q15.d() != null) {
            Iterator it11 = q15.d().iterator();
            while (it11.hasNext()) {
                a(((c2.d) it11.next()).f٥٦٨٣d, 1, arrayList7, null);
            }
        }
        c2.d q16 = fVar.q(d.b.CENTER);
        if (q16.d() != null) {
            Iterator it12 = q16.d().iterator();
            while (it12.hasNext()) {
                a(((c2.d) it12.next()).f٥٦٨٣d, 1, arrayList7, null);
            }
        }
        if (arrayList6 != null) {
            Iterator it13 = arrayList6.iterator();
            while (it13.hasNext()) {
                a((c2.e) it13.next(), 1, arrayList7, null);
            }
        }
        for (int i15 = 0; i15 < size; i15++) {
            c2.e eVar3 = (c2.e) v12.get(i15);
            if (eVar3.u0()) {
                o b10 = b(arrayList7, eVar3.S0);
                o b11 = b(arrayList7, eVar3.T0);
                if (b10 != null && b11 != null) {
                    b10.g(0, b11);
                    b11.i(2);
                    arrayList7.remove(b10);
                }
            }
        }
        if (arrayList7.size() <= 1) {
            return false;
        }
        if (fVar.C() == e.b.WRAP_CONTENT) {
            Iterator it14 = arrayList7.iterator();
            oVar = null;
            int i16 = 0;
            while (it14.hasNext()) {
                o oVar5 = (o) it14.next();
                if (oVar5.d() != 1) {
                    oVar5.h(false);
                    int f10 = oVar5.f(fVar.P1(), 0);
                    if (f10 > i16) {
                        oVar = oVar5;
                        i16 = f10;
                    }
                }
            }
            if (oVar != null) {
                fVar.T0(e.b.FIXED);
                fVar.o1(i16);
                oVar.h(true);
                if (fVar.V() != e.b.WRAP_CONTENT) {
                    Iterator it15 = arrayList7.iterator();
                    o oVar6 = null;
                    int i17 = 0;
                    while (it15.hasNext()) {
                        o oVar7 = (o) it15.next();
                        if (oVar7.d() != 0) {
                            oVar7.h(false);
                            int f11 = oVar7.f(fVar.P1(), 1);
                            if (f11 > i17) {
                                oVar6 = oVar7;
                                i17 = f11;
                            }
                        }
                    }
                    if (oVar6 != null) {
                        fVar.k1(e.b.FIXED);
                        fVar.P0(i17);
                        oVar6.h(true);
                        oVar2 = oVar6;
                        if (oVar != null && oVar2 == null) {
                            return false;
                        }
                        return true;
                    }
                }
                oVar2 = null;
                if (oVar != null) {
                }
                return true;
            }
        }
        oVar = null;
        if (fVar.V() != e.b.WRAP_CONTENT) {
        }
        oVar2 = null;
        if (oVar != null) {
        }
        return true;
    }

    public static boolean d(e.b bVar, e.b bVar2, e.b bVar3, e.b bVar4) {
        boolean z10;
        boolean z11;
        e.b bVar5;
        e.b bVar6;
        e.b bVar7 = e.b.FIXED;
        if (bVar3 != bVar7 && bVar3 != (bVar6 = e.b.WRAP_CONTENT) && (bVar3 != e.b.MATCH_PARENT || bVar == bVar6)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (bVar4 != bVar7 && bVar4 != (bVar5 = e.b.WRAP_CONTENT) && (bVar4 != e.b.MATCH_PARENT || bVar2 == bVar5)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z10 || z11) {
            return true;
        }
        return false;
    }
}
