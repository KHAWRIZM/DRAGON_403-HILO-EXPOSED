package d2;

import c2.d;
import c2.e;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import d2.b;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static b.a f١٣٥٩٠a = new b.a();

    /* renamed from: b, reason: collision with root package name */
    private static int f١٣٥٩١b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f١٣٥٩٢c = 0;

    private static boolean a(int i10, c2.e eVar) {
        c2.f fVar;
        boolean z10;
        boolean z11;
        e.b bVar;
        e.b bVar2;
        e.b C = eVar.C();
        e.b V = eVar.V();
        if (eVar.M() != null) {
            fVar = (c2.f) eVar.M();
        } else {
            fVar = null;
        }
        if (fVar != null) {
            fVar.C();
            e.b bVar3 = e.b.FIXED;
        }
        if (fVar != null) {
            fVar.V();
            e.b bVar4 = e.b.FIXED;
        }
        e.b bVar5 = e.b.FIXED;
        if (C != bVar5 && !eVar.p0() && C != e.b.WRAP_CONTENT && ((C != (bVar2 = e.b.MATCH_CONSTRAINT) || eVar.f٥٧٤٥w != 0 || eVar.f٥٧١٢f0 != DownloadProgress.UNKNOWN_PROGRESS || !eVar.c0(0)) && (C != bVar2 || eVar.f٥٧٤٥w != 1 || !eVar.f0(0, eVar.Y())))) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (V != bVar5 && !eVar.q0() && V != e.b.WRAP_CONTENT && ((V != (bVar = e.b.MATCH_CONSTRAINT) || eVar.f٥٧٤٧x != 0 || eVar.f٥٧١٢f0 != DownloadProgress.UNKNOWN_PROGRESS || !eVar.c0(1)) && (V != bVar || eVar.f٥٧٤٧x != 1 || !eVar.f0(1, eVar.z())))) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (eVar.f٥٧١٢f0 > DownloadProgress.UNKNOWN_PROGRESS && (z10 || z11)) {
            return true;
        }
        if (!z10 || !z11) {
            return false;
        }
        return true;
    }

    private static void b(int i10, c2.e eVar, b.InterfaceC٠١٥٠b r18, boolean z10) {
        boolean z11;
        c2.d dVar;
        c2.d dVar2;
        boolean z12;
        c2.d dVar3;
        c2.d dVar4;
        if (eVar.i0()) {
            return;
        }
        f١٣٥٩١b++;
        if (!(eVar instanceof c2.f) && eVar.o0()) {
            int i11 = i10 + 1;
            if (a(i11, eVar)) {
                c2.f.X1(i11, eVar, r18, new b.a(), b.a.f١٣٥٤٤k);
            }
        }
        c2.d q10 = eVar.q(d.b.LEFT);
        c2.d q11 = eVar.q(d.b.RIGHT);
        int e10 = q10.e();
        int e11 = q11.e();
        if (q10.d() != null && q10.n()) {
            Iterator it = q10.d().iterator();
            while (it.hasNext()) {
                c2.d dVar5 = (c2.d) it.next();
                c2.e eVar2 = dVar5.f٥٦٨٣d;
                int i12 = i10 + 1;
                boolean a10 = a(i12, eVar2);
                if (eVar2.o0() && a10) {
                    c2.f.X1(i12, eVar2, r18, new b.a(), b.a.f١٣٥٤٤k);
                }
                if ((dVar5 == eVar2.Q && (dVar4 = eVar2.S.f٥٦٨٥f) != null && dVar4.n()) || (dVar5 == eVar2.S && (dVar3 = eVar2.Q.f٥٦٨٥f) != null && dVar3.n())) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                e.b C = eVar2.C();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (C == bVar && !a10) {
                    if (eVar2.C() == bVar && eVar2.A >= 0 && eVar2.f٥٧٥١z >= 0 && ((eVar2.X() == 8 || (eVar2.f٥٧٤٥w == 0 && eVar2.x() == DownloadProgress.UNKNOWN_PROGRESS)) && !eVar2.k0() && !eVar2.n0() && z12 && !eVar2.k0())) {
                        e(i12, eVar, r18, eVar2, z10);
                    }
                } else if (!eVar2.o0()) {
                    c2.d dVar6 = eVar2.Q;
                    if (dVar5 == dVar6 && eVar2.S.f٥٦٨٥f == null) {
                        int f10 = dVar6.f() + e10;
                        eVar2.J0(f10, eVar2.Y() + f10);
                        b(i12, eVar2, r18, z10);
                    } else {
                        c2.d dVar7 = eVar2.S;
                        if (dVar5 == dVar7 && dVar6.f٥٦٨٥f == null) {
                            int f11 = e10 - dVar7.f();
                            eVar2.J0(f11 - eVar2.Y(), f11);
                            b(i12, eVar2, r18, z10);
                        } else if (z12 && !eVar2.k0()) {
                            d(i12, r18, eVar2, z10);
                        }
                    }
                }
            }
        }
        if (eVar instanceof c2.h) {
            return;
        }
        if (q11.d() != null && q11.n()) {
            Iterator it2 = q11.d().iterator();
            while (it2.hasNext()) {
                c2.d dVar8 = (c2.d) it2.next();
                c2.e eVar3 = dVar8.f٥٦٨٣d;
                int i13 = i10 + 1;
                boolean a11 = a(i13, eVar3);
                if (eVar3.o0() && a11) {
                    c2.f.X1(i13, eVar3, r18, new b.a(), b.a.f١٣٥٤٤k);
                }
                if ((dVar8 == eVar3.Q && (dVar2 = eVar3.S.f٥٦٨٥f) != null && dVar2.n()) || (dVar8 == eVar3.S && (dVar = eVar3.Q.f٥٦٨٥f) != null && dVar.n())) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                e.b C2 = eVar3.C();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (C2 == bVar2 && !a11) {
                    if (eVar3.C() == bVar2 && eVar3.A >= 0 && eVar3.f٥٧٥١z >= 0 && (eVar3.X() == 8 || (eVar3.f٥٧٤٥w == 0 && eVar3.x() == DownloadProgress.UNKNOWN_PROGRESS))) {
                        if (!eVar3.k0() && !eVar3.n0() && z11 && !eVar3.k0()) {
                            e(i13, eVar, r18, eVar3, z10);
                        }
                    }
                } else if (!eVar3.o0()) {
                    c2.d dVar9 = eVar3.Q;
                    if (dVar8 == dVar9 && eVar3.S.f٥٦٨٥f == null) {
                        int f12 = dVar9.f() + e11;
                        eVar3.J0(f12, eVar3.Y() + f12);
                        b(i13, eVar3, r18, z10);
                    } else {
                        c2.d dVar10 = eVar3.S;
                        if (dVar8 == dVar10 && dVar9.f٥٦٨٥f == null) {
                            int f13 = e11 - dVar10.f();
                            eVar3.J0(f13 - eVar3.Y(), f13);
                            b(i13, eVar3, r18, z10);
                        } else if (z11 && !eVar3.k0()) {
                            d(i13, r18, eVar3, z10);
                        }
                    }
                }
            }
        }
        eVar.s0();
    }

    private static void c(int i10, c2.a aVar, b.InterfaceC٠١٥٠b r32, int i11, boolean z10) {
        if (aVar.x1()) {
            if (i11 == 0) {
                b(i10 + 1, aVar, r32, z10);
            } else {
                i(i10 + 1, aVar, r32);
            }
        }
    }

    private static void d(int i10, b.InterfaceC٠١٥٠b r72, c2.e eVar, boolean z10) {
        float f10;
        float A = eVar.A();
        int e10 = eVar.Q.f٥٦٨٥f.e();
        int e11 = eVar.S.f٥٦٨٥f.e();
        int f11 = eVar.Q.f() + e10;
        int f12 = e11 - eVar.S.f();
        if (e10 == e11) {
            A = 0.5f;
        } else {
            e10 = f11;
            e11 = f12;
        }
        int Y = eVar.Y();
        int i11 = (e11 - e10) - Y;
        if (e10 > e11) {
            i11 = (e10 - e11) - Y;
        }
        if (i11 > 0) {
            f10 = (A * i11) + 0.5f;
        } else {
            f10 = A * i11;
        }
        int i12 = ((int) f10) + e10;
        int i13 = i12 + Y;
        if (e10 > e11) {
            i13 = i12 - Y;
        }
        eVar.J0(i12, i13);
        b(i10 + 1, eVar, r72, z10);
    }

    private static void e(int i10, c2.e eVar, b.InterfaceC٠١٥٠b r92, c2.e eVar2, boolean z10) {
        int Y;
        float A = eVar2.A();
        int e10 = eVar2.Q.f٥٦٨٥f.e() + eVar2.Q.f();
        int e11 = eVar2.S.f٥٦٨٥f.e() - eVar2.S.f();
        if (e11 >= e10) {
            int Y2 = eVar2.Y();
            if (eVar2.X() != 8) {
                int i11 = eVar2.f٥٧٤٥w;
                if (i11 == 2) {
                    if (eVar instanceof c2.f) {
                        Y = eVar.Y();
                    } else {
                        Y = eVar.M().Y();
                    }
                    Y2 = (int) (eVar2.A() * 0.5f * Y);
                } else if (i11 == 0) {
                    Y2 = e11 - e10;
                }
                Y2 = Math.max(eVar2.f٥٧٥١z, Y2);
                int i12 = eVar2.A;
                if (i12 > 0) {
                    Y2 = Math.min(i12, Y2);
                }
            }
            int i13 = e10 + ((int) ((A * ((e11 - e10) - Y2)) + 0.5f));
            eVar2.J0(i13, Y2 + i13);
            b(i10 + 1, eVar2, r92, z10);
        }
    }

    private static void f(int i10, b.InterfaceC٠١٥٠b r72, c2.e eVar) {
        float f10;
        float T = eVar.T();
        int e10 = eVar.R.f٥٦٨٥f.e();
        int e11 = eVar.T.f٥٦٨٥f.e();
        int f11 = eVar.R.f() + e10;
        int f12 = e11 - eVar.T.f();
        if (e10 == e11) {
            T = 0.5f;
        } else {
            e10 = f11;
            e11 = f12;
        }
        int z10 = eVar.z();
        int i11 = (e11 - e10) - z10;
        if (e10 > e11) {
            i11 = (e10 - e11) - z10;
        }
        if (i11 > 0) {
            f10 = (T * i11) + 0.5f;
        } else {
            f10 = T * i11;
        }
        int i12 = (int) f10;
        int i13 = e10 + i12;
        int i14 = i13 + z10;
        if (e10 > e11) {
            i13 = e10 - i12;
            i14 = i13 - z10;
        }
        eVar.M0(i13, i14);
        i(i10 + 1, eVar, r72);
    }

    private static void g(int i10, c2.e eVar, b.InterfaceC٠١٥٠b r92, c2.e eVar2) {
        int z10;
        float T = eVar2.T();
        int e10 = eVar2.R.f٥٦٨٥f.e() + eVar2.R.f();
        int e11 = eVar2.T.f٥٦٨٥f.e() - eVar2.T.f();
        if (e11 >= e10) {
            int z11 = eVar2.z();
            if (eVar2.X() != 8) {
                int i11 = eVar2.f٥٧٤٧x;
                if (i11 == 2) {
                    if (eVar instanceof c2.f) {
                        z10 = eVar.z();
                    } else {
                        z10 = eVar.M().z();
                    }
                    z11 = (int) (T * 0.5f * z10);
                } else if (i11 == 0) {
                    z11 = e11 - e10;
                }
                z11 = Math.max(eVar2.C, z11);
                int i12 = eVar2.D;
                if (i12 > 0) {
                    z11 = Math.min(i12, z11);
                }
            }
            int i13 = e10 + ((int) ((T * ((e11 - e10) - z11)) + 0.5f));
            eVar2.M0(i13, z11 + i13);
            i(i10 + 1, eVar2, r92);
        }
    }

    public static void h(c2.f fVar, b.InterfaceC٠١٥٠b r14) {
        e.b C = fVar.C();
        e.b V = fVar.V();
        f١٣٥٩١b = 0;
        f١٣٥٩٢c = 0;
        fVar.y0();
        ArrayList v12 = fVar.v1();
        int size = v12.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((c2.e) v12.get(i10)).y0();
        }
        boolean U1 = fVar.U1();
        if (C == e.b.FIXED) {
            fVar.J0(0, fVar.Y());
        } else {
            fVar.K0(0);
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            c2.e eVar = (c2.e) v12.get(i11);
            if (eVar instanceof c2.h) {
                c2.h hVar = (c2.h) eVar;
                if (hVar.w1() == 1) {
                    if (hVar.x1() != -1) {
                        hVar.A1(hVar.x1());
                    } else if (hVar.y1() != -1 && fVar.p0()) {
                        hVar.A1(fVar.Y() - hVar.y1());
                    } else if (fVar.p0()) {
                        hVar.A1((int) ((hVar.z1() * fVar.Y()) + 0.5f));
                    }
                    z10 = true;
                }
            } else if ((eVar instanceof c2.a) && ((c2.a) eVar).B1() == 0) {
                z11 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                c2.e eVar2 = (c2.e) v12.get(i12);
                if (eVar2 instanceof c2.h) {
                    c2.h hVar2 = (c2.h) eVar2;
                    if (hVar2.w1() == 1) {
                        b(0, hVar2, r14, U1);
                    }
                }
            }
        }
        b(0, fVar, r14, U1);
        if (z11) {
            for (int i13 = 0; i13 < size; i13++) {
                c2.e eVar3 = (c2.e) v12.get(i13);
                if (eVar3 instanceof c2.a) {
                    c2.a aVar = (c2.a) eVar3;
                    if (aVar.B1() == 0) {
                        c(0, aVar, r14, 0, U1);
                    }
                }
            }
        }
        if (V == e.b.FIXED) {
            fVar.M0(0, fVar.z());
        } else {
            fVar.L0(0);
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i14 = 0; i14 < size; i14++) {
            c2.e eVar4 = (c2.e) v12.get(i14);
            if (eVar4 instanceof c2.h) {
                c2.h hVar3 = (c2.h) eVar4;
                if (hVar3.w1() == 0) {
                    if (hVar3.x1() != -1) {
                        hVar3.A1(hVar3.x1());
                    } else if (hVar3.y1() != -1 && fVar.q0()) {
                        hVar3.A1(fVar.z() - hVar3.y1());
                    } else if (fVar.q0()) {
                        hVar3.A1((int) ((hVar3.z1() * fVar.z()) + 0.5f));
                    }
                    z12 = true;
                }
            } else if ((eVar4 instanceof c2.a) && ((c2.a) eVar4).B1() == 1) {
                z13 = true;
            }
        }
        if (z12) {
            for (int i15 = 0; i15 < size; i15++) {
                c2.e eVar5 = (c2.e) v12.get(i15);
                if (eVar5 instanceof c2.h) {
                    c2.h hVar4 = (c2.h) eVar5;
                    if (hVar4.w1() == 0) {
                        i(1, hVar4, r14);
                    }
                }
            }
        }
        i(0, fVar, r14);
        if (z13) {
            for (int i16 = 0; i16 < size; i16++) {
                c2.e eVar6 = (c2.e) v12.get(i16);
                if (eVar6 instanceof c2.a) {
                    c2.a aVar2 = (c2.a) eVar6;
                    if (aVar2.B1() == 1) {
                        c(0, aVar2, r14, 1, U1);
                    }
                }
            }
        }
        for (int i17 = 0; i17 < size; i17++) {
            c2.e eVar7 = (c2.e) v12.get(i17);
            if (eVar7.o0() && a(0, eVar7)) {
                c2.f.X1(0, eVar7, r14, f١٣٥٩٠a, b.a.f١٣٥٤٤k);
                if (eVar7 instanceof c2.h) {
                    if (((c2.h) eVar7).w1() == 0) {
                        i(0, eVar7, r14);
                    } else {
                        b(0, eVar7, r14, U1);
                    }
                } else {
                    b(0, eVar7, r14, U1);
                    i(0, eVar7, r14);
                }
            }
        }
    }

    private static void i(int i10, c2.e eVar, b.InterfaceC٠١٥٠b r18) {
        boolean z10;
        c2.d dVar;
        c2.d dVar2;
        boolean z11;
        c2.d dVar3;
        c2.d dVar4;
        if (eVar.r0()) {
            return;
        }
        f١٣٥٩٢c++;
        if (!(eVar instanceof c2.f) && eVar.o0()) {
            int i11 = i10 + 1;
            if (a(i11, eVar)) {
                c2.f.X1(i11, eVar, r18, new b.a(), b.a.f١٣٥٤٤k);
            }
        }
        c2.d q10 = eVar.q(d.b.TOP);
        c2.d q11 = eVar.q(d.b.BOTTOM);
        int e10 = q10.e();
        int e11 = q11.e();
        if (q10.d() != null && q10.n()) {
            Iterator it = q10.d().iterator();
            while (it.hasNext()) {
                c2.d dVar5 = (c2.d) it.next();
                c2.e eVar2 = dVar5.f٥٦٨٣d;
                int i12 = i10 + 1;
                boolean a10 = a(i12, eVar2);
                if (eVar2.o0() && a10) {
                    c2.f.X1(i12, eVar2, r18, new b.a(), b.a.f١٣٥٤٤k);
                }
                if ((dVar5 == eVar2.R && (dVar4 = eVar2.T.f٥٦٨٥f) != null && dVar4.n()) || (dVar5 == eVar2.T && (dVar3 = eVar2.R.f٥٦٨٥f) != null && dVar3.n())) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                e.b V = eVar2.V();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (V == bVar && !a10) {
                    if (eVar2.V() == bVar && eVar2.D >= 0 && eVar2.C >= 0 && (eVar2.X() == 8 || (eVar2.f٥٧٤٧x == 0 && eVar2.x() == DownloadProgress.UNKNOWN_PROGRESS))) {
                        if (!eVar2.m0() && !eVar2.n0() && z11 && !eVar2.m0()) {
                            g(i12, eVar, r18, eVar2);
                        }
                    }
                } else if (!eVar2.o0()) {
                    c2.d dVar6 = eVar2.R;
                    if (dVar5 == dVar6 && eVar2.T.f٥٦٨٥f == null) {
                        int f10 = dVar6.f() + e10;
                        eVar2.M0(f10, eVar2.z() + f10);
                        i(i12, eVar2, r18);
                    } else {
                        c2.d dVar7 = eVar2.T;
                        if (dVar5 == dVar7 && dVar6.f٥٦٨٥f == null) {
                            int f11 = e10 - dVar7.f();
                            eVar2.M0(f11 - eVar2.z(), f11);
                            i(i12, eVar2, r18);
                        } else if (z11 && !eVar2.m0()) {
                            f(i12, r18, eVar2);
                        }
                    }
                }
            }
        }
        if (eVar instanceof c2.h) {
            return;
        }
        if (q11.d() != null && q11.n()) {
            Iterator it2 = q11.d().iterator();
            while (it2.hasNext()) {
                c2.d dVar8 = (c2.d) it2.next();
                c2.e eVar3 = dVar8.f٥٦٨٣d;
                int i13 = i10 + 1;
                boolean a11 = a(i13, eVar3);
                if (eVar3.o0() && a11) {
                    c2.f.X1(i13, eVar3, r18, new b.a(), b.a.f١٣٥٤٤k);
                }
                if ((dVar8 == eVar3.R && (dVar2 = eVar3.T.f٥٦٨٥f) != null && dVar2.n()) || (dVar8 == eVar3.T && (dVar = eVar3.R.f٥٦٨٥f) != null && dVar.n())) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                e.b V2 = eVar3.V();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (V2 == bVar2 && !a11) {
                    if (eVar3.V() == bVar2 && eVar3.D >= 0 && eVar3.C >= 0 && (eVar3.X() == 8 || (eVar3.f٥٧٤٧x == 0 && eVar3.x() == DownloadProgress.UNKNOWN_PROGRESS))) {
                        if (!eVar3.m0() && !eVar3.n0() && z10 && !eVar3.m0()) {
                            g(i13, eVar, r18, eVar3);
                        }
                    }
                } else if (!eVar3.o0()) {
                    c2.d dVar9 = eVar3.R;
                    if (dVar8 == dVar9 && eVar3.T.f٥٦٨٥f == null) {
                        int f12 = dVar9.f() + e11;
                        eVar3.M0(f12, eVar3.z() + f12);
                        i(i13, eVar3, r18);
                    } else {
                        c2.d dVar10 = eVar3.T;
                        if (dVar8 == dVar10 && dVar9.f٥٦٨٥f == null) {
                            int f13 = e11 - dVar10.f();
                            eVar3.M0(f13 - eVar3.z(), f13);
                            i(i13, eVar3, r18);
                        } else if (z10 && !eVar3.m0()) {
                            f(i13, r18, eVar3);
                        }
                    }
                }
            }
        }
        c2.d q12 = eVar.q(d.b.BASELINE);
        if (q12.d() != null && q12.n()) {
            int e12 = q12.e();
            Iterator it3 = q12.d().iterator();
            while (it3.hasNext()) {
                c2.d dVar11 = (c2.d) it3.next();
                c2.e eVar4 = dVar11.f٥٦٨٣d;
                int i14 = i10 + 1;
                boolean a12 = a(i14, eVar4);
                if (eVar4.o0() && a12) {
                    c2.f.X1(i14, eVar4, r18, new b.a(), b.a.f١٣٥٤٤k);
                }
                if (eVar4.V() != e.b.MATCH_CONSTRAINT || a12) {
                    if (!eVar4.o0() && dVar11 == eVar4.U) {
                        eVar4.I0(dVar11.f() + e12);
                        i(i14, eVar4, r18);
                    }
                }
            }
        }
        eVar.t0();
    }
}
