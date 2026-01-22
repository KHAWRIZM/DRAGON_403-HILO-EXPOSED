package d2;

import c2.e;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import d2.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private c2.f f١٣٥٥٩a;

    /* renamed from: d, reason: collision with root package name */
    private c2.f f١٣٥٦٢d;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٣٥٦٠b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٣٥٦١c = true;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList f١٣٥٦٣e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList f١٣٥٦٤f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private b.InterfaceC٠١٥٠b f١٣٥٦٥g = null;

    /* renamed from: h, reason: collision with root package name */
    private b.a f١٣٥٦٦h = new b.a();

    /* renamed from: i, reason: collision with root package name */
    ArrayList f١٣٥٦٧i = new ArrayList();

    public e(c2.f fVar) {
        this.f١٣٥٥٩a = fVar;
        this.f١٣٥٦٢d = fVar;
    }

    private void a(f fVar, int i10, int i11, f fVar2, ArrayList arrayList, m mVar) {
        p pVar = fVar.f١٣٥٧١d;
        if (pVar.f١٣٦٢٣c == null) {
            c2.f fVar3 = this.f١٣٥٥٩a;
            if (pVar != fVar3.f٥٧٠٩e && pVar != fVar3.f٥٧١١f) {
                if (mVar == null) {
                    mVar = new m(pVar, i11);
                    arrayList.add(mVar);
                }
                pVar.f١٣٦٢٣c = mVar;
                mVar.a(pVar);
                for (d dVar : pVar.f١٣٦٢٨h.f١٣٥٧٨k) {
                    if (dVar instanceof f) {
                        a((f) dVar, i10, 0, fVar2, arrayList, mVar);
                    }
                }
                for (d dVar2 : pVar.f١٣٦٢٩i.f١٣٥٧٨k) {
                    if (dVar2 instanceof f) {
                        a((f) dVar2, i10, 1, fVar2, arrayList, mVar);
                    }
                }
                if (i10 == 1 && (pVar instanceof n)) {
                    for (d dVar3 : ((n) pVar).f١٣٦٠٣k.f١٣٥٧٨k) {
                        if (dVar3 instanceof f) {
                            a((f) dVar3, i10, 2, fVar2, arrayList, mVar);
                        }
                    }
                }
                for (f fVar4 : pVar.f١٣٦٢٨h.f١٣٥٧٩l) {
                    if (fVar4 == fVar2) {
                        mVar.f١٣٥٩٧b = true;
                    }
                    a(fVar4, i10, 0, fVar2, arrayList, mVar);
                }
                for (f fVar5 : pVar.f١٣٦٢٩i.f١٣٥٧٩l) {
                    if (fVar5 == fVar2) {
                        mVar.f١٣٥٩٧b = true;
                    }
                    a(fVar5, i10, 1, fVar2, arrayList, mVar);
                }
                if (i10 == 1 && (pVar instanceof n)) {
                    Iterator it = ((n) pVar).f١٣٦٠٣k.f١٣٥٧٩l.iterator();
                    while (it.hasNext()) {
                        a((f) it.next(), i10, 2, fVar2, arrayList, mVar);
                    }
                }
            }
        }
    }

    private boolean b(c2.f fVar) {
        int i10;
        e.b bVar;
        int i11;
        e.b bVar2;
        e.b bVar3;
        e.b bVar4;
        Iterator it = fVar.V0.iterator();
        while (it.hasNext()) {
            c2.e eVar = (c2.e) it.next();
            e.b[] bVarArr = eVar.f٥٧٠٤b0;
            e.b bVar5 = bVarArr[0];
            e.b bVar6 = bVarArr[1];
            if (eVar.X() == 8) {
                eVar.f٥٧٠١a = true;
            } else {
                if (eVar.f٥٧٠٠B < 1.0f && bVar5 == e.b.MATCH_CONSTRAINT) {
                    eVar.f٥٧٤٥w = 2;
                }
                if (eVar.E < 1.0f && bVar6 == e.b.MATCH_CONSTRAINT) {
                    eVar.f٥٧٤٧x = 2;
                }
                if (eVar.x() > DownloadProgress.UNKNOWN_PROGRESS) {
                    e.b bVar7 = e.b.MATCH_CONSTRAINT;
                    if (bVar5 == bVar7 && (bVar6 == e.b.WRAP_CONTENT || bVar6 == e.b.FIXED)) {
                        eVar.f٥٧٤٥w = 3;
                    } else if (bVar6 == bVar7 && (bVar5 == e.b.WRAP_CONTENT || bVar5 == e.b.FIXED)) {
                        eVar.f٥٧٤٧x = 3;
                    } else if (bVar5 == bVar7 && bVar6 == bVar7) {
                        if (eVar.f٥٧٤٥w == 0) {
                            eVar.f٥٧٤٥w = 3;
                        }
                        if (eVar.f٥٧٤٧x == 0) {
                            eVar.f٥٧٤٧x = 3;
                        }
                    }
                }
                e.b bVar8 = e.b.MATCH_CONSTRAINT;
                if (bVar5 == bVar8 && eVar.f٥٧٤٥w == 1 && (eVar.Q.f٥٦٨٥f == null || eVar.S.f٥٦٨٥f == null)) {
                    bVar5 = e.b.WRAP_CONTENT;
                }
                e.b bVar9 = bVar5;
                if (bVar6 == bVar8 && eVar.f٥٧٤٧x == 1 && (eVar.R.f٥٦٨٥f == null || eVar.T.f٥٦٨٥f == null)) {
                    bVar6 = e.b.WRAP_CONTENT;
                }
                e.b bVar10 = bVar6;
                l lVar = eVar.f٥٧٠٩e;
                lVar.f١٣٦٢٤d = bVar9;
                int i12 = eVar.f٥٧٤٥w;
                lVar.f١٣٦٢١a = i12;
                n nVar = eVar.f٥٧١١f;
                nVar.f١٣٦٢٤d = bVar10;
                int i13 = eVar.f٥٧٤٧x;
                nVar.f١٣٦٢١a = i13;
                e.b bVar11 = e.b.MATCH_PARENT;
                if ((bVar9 == bVar11 || bVar9 == e.b.FIXED || bVar9 == e.b.WRAP_CONTENT) && (bVar10 == bVar11 || bVar10 == e.b.FIXED || bVar10 == e.b.WRAP_CONTENT)) {
                    int Y = eVar.Y();
                    if (bVar9 == bVar11) {
                        i10 = (fVar.Y() - eVar.Q.f٥٦٨٦g) - eVar.S.f٥٦٨٦g;
                        bVar = e.b.FIXED;
                    } else {
                        i10 = Y;
                        bVar = bVar9;
                    }
                    int z10 = eVar.z();
                    if (bVar10 == bVar11) {
                        i11 = (fVar.z() - eVar.R.f٥٦٨٦g) - eVar.T.f٥٦٨٦g;
                        bVar2 = e.b.FIXED;
                    } else {
                        i11 = z10;
                        bVar2 = bVar10;
                    }
                    l(eVar, bVar, i10, bVar2, i11);
                    eVar.f٥٧٠٩e.f١٣٦٢٥e.d(eVar.Y());
                    eVar.f٥٧١١f.f١٣٦٢٥e.d(eVar.z());
                    eVar.f٥٧٠١a = true;
                } else {
                    if (bVar9 == bVar8 && (bVar10 == (bVar4 = e.b.WRAP_CONTENT) || bVar10 == e.b.FIXED)) {
                        if (i12 == 3) {
                            if (bVar10 == bVar4) {
                                l(eVar, bVar4, 0, bVar4, 0);
                            }
                            int z11 = eVar.z();
                            int i14 = (int) ((z11 * eVar.f٥٧١٢f0) + 0.5f);
                            e.b bVar12 = e.b.FIXED;
                            l(eVar, bVar12, i14, bVar12, z11);
                            eVar.f٥٧٠٩e.f١٣٦٢٥e.d(eVar.Y());
                            eVar.f٥٧١١f.f١٣٦٢٥e.d(eVar.z());
                            eVar.f٥٧٠١a = true;
                        } else if (i12 == 1) {
                            l(eVar, bVar4, 0, bVar10, 0);
                            eVar.f٥٧٠٩e.f١٣٦٢٥e.f١٣٥٨٩m = eVar.Y();
                        } else if (i12 == 2) {
                            e.b bVar13 = fVar.f٥٧٠٤b0[0];
                            e.b bVar14 = e.b.FIXED;
                            if (bVar13 == bVar14 || bVar13 == bVar11) {
                                l(eVar, bVar14, (int) ((eVar.f٥٧٠٠B * fVar.Y()) + 0.5f), bVar10, eVar.z());
                                eVar.f٥٧٠٩e.f١٣٦٢٥e.d(eVar.Y());
                                eVar.f٥٧١١f.f١٣٦٢٥e.d(eVar.z());
                                eVar.f٥٧٠١a = true;
                            }
                        } else {
                            c2.d[] dVarArr = eVar.Y;
                            if (dVarArr[0].f٥٦٨٥f == null || dVarArr[1].f٥٦٨٥f == null) {
                                l(eVar, bVar4, 0, bVar10, 0);
                                eVar.f٥٧٠٩e.f١٣٦٢٥e.d(eVar.Y());
                                eVar.f٥٧١١f.f١٣٦٢٥e.d(eVar.z());
                                eVar.f٥٧٠١a = true;
                            }
                        }
                    }
                    if (bVar10 == bVar8 && (bVar9 == (bVar3 = e.b.WRAP_CONTENT) || bVar9 == e.b.FIXED)) {
                        if (i13 == 3) {
                            if (bVar9 == bVar3) {
                                l(eVar, bVar3, 0, bVar3, 0);
                            }
                            int Y2 = eVar.Y();
                            float f10 = eVar.f٥٧١٢f0;
                            if (eVar.y() == -1) {
                                f10 = 1.0f / f10;
                            }
                            e.b bVar15 = e.b.FIXED;
                            l(eVar, bVar15, Y2, bVar15, (int) ((Y2 * f10) + 0.5f));
                            eVar.f٥٧٠٩e.f١٣٦٢٥e.d(eVar.Y());
                            eVar.f٥٧١١f.f١٣٦٢٥e.d(eVar.z());
                            eVar.f٥٧٠١a = true;
                        } else if (i13 == 1) {
                            l(eVar, bVar9, 0, bVar3, 0);
                            eVar.f٥٧١١f.f١٣٦٢٥e.f١٣٥٨٩m = eVar.z();
                        } else if (i13 == 2) {
                            e.b bVar16 = fVar.f٥٧٠٤b0[1];
                            e.b bVar17 = e.b.FIXED;
                            if (bVar16 == bVar17 || bVar16 == bVar11) {
                                l(eVar, bVar9, eVar.Y(), bVar17, (int) ((eVar.E * fVar.z()) + 0.5f));
                                eVar.f٥٧٠٩e.f١٣٦٢٥e.d(eVar.Y());
                                eVar.f٥٧١١f.f١٣٦٢٥e.d(eVar.z());
                                eVar.f٥٧٠١a = true;
                            }
                        } else {
                            c2.d[] dVarArr2 = eVar.Y;
                            if (dVarArr2[2].f٥٦٨٥f == null || dVarArr2[3].f٥٦٨٥f == null) {
                                l(eVar, bVar3, 0, bVar10, 0);
                                eVar.f٥٧٠٩e.f١٣٦٢٥e.d(eVar.Y());
                                eVar.f٥٧١١f.f١٣٦٢٥e.d(eVar.z());
                                eVar.f٥٧٠١a = true;
                            }
                        }
                    }
                    if (bVar9 == bVar8 && bVar10 == bVar8) {
                        if (i12 == 1 || i13 == 1) {
                            e.b bVar18 = e.b.WRAP_CONTENT;
                            l(eVar, bVar18, 0, bVar18, 0);
                            eVar.f٥٧٠٩e.f١٣٦٢٥e.f١٣٥٨٩m = eVar.Y();
                            eVar.f٥٧١١f.f١٣٦٢٥e.f١٣٥٨٩m = eVar.z();
                        } else if (i13 == 2 && i12 == 2) {
                            e.b[] bVarArr2 = fVar.f٥٧٠٤b0;
                            e.b bVar19 = bVarArr2[0];
                            e.b bVar20 = e.b.FIXED;
                            if (bVar19 == bVar20 && bVarArr2[1] == bVar20) {
                                l(eVar, bVar20, (int) ((eVar.f٥٧٠٠B * fVar.Y()) + 0.5f), bVar20, (int) ((eVar.E * fVar.z()) + 0.5f));
                                eVar.f٥٧٠٩e.f١٣٦٢٥e.d(eVar.Y());
                                eVar.f٥٧١١f.f١٣٦٢٥e.d(eVar.z());
                                eVar.f٥٧٠١a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int e(c2.f fVar, int i10) {
        int size = this.f١٣٥٦٧i.size();
        long j10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            j10 = Math.max(j10, ((m) this.f١٣٥٦٧i.get(i11)).b(fVar, i10));
        }
        return (int) j10;
    }

    private void i(p pVar, int i10, ArrayList arrayList) {
        for (d dVar : pVar.f١٣٦٢٨h.f١٣٥٧٨k) {
            if (dVar instanceof f) {
                a((f) dVar, i10, 0, pVar.f١٣٦٢٩i, arrayList, null);
            } else if (dVar instanceof p) {
                a(((p) dVar).f١٣٦٢٨h, i10, 0, pVar.f١٣٦٢٩i, arrayList, null);
            }
        }
        for (d dVar2 : pVar.f١٣٦٢٩i.f١٣٥٧٨k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i10, 1, pVar.f١٣٦٢٨h, arrayList, null);
            } else if (dVar2 instanceof p) {
                a(((p) dVar2).f١٣٦٢٩i, i10, 1, pVar.f١٣٦٢٨h, arrayList, null);
            }
        }
        if (i10 == 1) {
            for (d dVar3 : ((n) pVar).f١٣٦٠٣k.f١٣٥٧٨k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i10, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(c2.e eVar, e.b bVar, int i10, e.b bVar2, int i11) {
        b.a aVar = this.f١٣٥٦٦h;
        aVar.f١٣٥٤٧a = bVar;
        aVar.f١٣٥٤٨b = bVar2;
        aVar.f١٣٥٤٩c = i10;
        aVar.f١٣٥٥٠d = i11;
        this.f١٣٥٦٥g.b(eVar, aVar);
        eVar.o1(this.f١٣٥٦٦h.f١٣٥٥١e);
        eVar.P0(this.f١٣٥٦٦h.f١٣٥٥٢f);
        eVar.O0(this.f١٣٥٦٦h.f١٣٥٥٤h);
        eVar.E0(this.f١٣٥٦٦h.f١٣٥٥٣g);
    }

    public void c() {
        d(this.f١٣٥٦٣e);
        this.f١٣٥٦٧i.clear();
        m.f١٣٥٩٥h = 0;
        i(this.f١٣٥٥٩a.f٥٧٠٩e, 0, this.f١٣٥٦٧i);
        i(this.f١٣٥٥٩a.f٥٧١١f, 1, this.f١٣٥٦٧i);
        this.f١٣٥٦٠b = false;
    }

    public void d(ArrayList arrayList) {
        arrayList.clear();
        this.f١٣٥٦٢d.f٥٧٠٩e.f();
        this.f١٣٥٦٢d.f٥٧١١f.f();
        arrayList.add(this.f١٣٥٦٢d.f٥٧٠٩e);
        arrayList.add(this.f١٣٥٦٢d.f٥٧١١f);
        Iterator it = this.f١٣٥٦٢d.V0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            c2.e eVar = (c2.e) it.next();
            if (eVar instanceof c2.h) {
                arrayList.add(new j(eVar));
            } else {
                if (eVar.k0()) {
                    if (eVar.f٥٧٠٥c == null) {
                        eVar.f٥٧٠٥c = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f٥٧٠٥c);
                } else {
                    arrayList.add(eVar.f٥٧٠٩e);
                }
                if (eVar.m0()) {
                    if (eVar.f٥٧٠٧d == null) {
                        eVar.f٥٧٠٧d = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f٥٧٠٧d);
                } else {
                    arrayList.add(eVar.f٥٧١١f);
                }
                if (eVar instanceof c2.j) {
                    arrayList.add(new k(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((p) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            p pVar = (p) it3.next();
            if (pVar.f١٣٦٢٢b != this.f١٣٥٦٢d) {
                pVar.d();
            }
        }
    }

    public boolean f(boolean z10) {
        boolean z11;
        boolean z12 = false;
        if (this.f١٣٥٦٠b || this.f١٣٥٦١c) {
            Iterator it = this.f١٣٥٥٩a.V0.iterator();
            while (it.hasNext()) {
                c2.e eVar = (c2.e) it.next();
                eVar.p();
                eVar.f٥٧٠١a = false;
                eVar.f٥٧٠٩e.r();
                eVar.f٥٧١١f.q();
            }
            this.f١٣٥٥٩a.p();
            c2.f fVar = this.f١٣٥٥٩a;
            fVar.f٥٧٠١a = false;
            fVar.f٥٧٠٩e.r();
            this.f١٣٥٥٩a.f٥٧١١f.q();
            this.f١٣٥٦١c = false;
        }
        if (b(this.f١٣٥٦٢d)) {
            return false;
        }
        this.f١٣٥٥٩a.q1(0);
        this.f١٣٥٥٩a.r1(0);
        e.b w10 = this.f١٣٥٥٩a.w(0);
        e.b w11 = this.f١٣٥٥٩a.w(1);
        if (this.f١٣٥٦٠b) {
            c();
        }
        int Z = this.f١٣٥٥٩a.Z();
        int a02 = this.f١٣٥٥٩a.a0();
        this.f١٣٥٥٩a.f٥٧٠٩e.f١٣٦٢٨h.d(Z);
        this.f١٣٥٥٩a.f٥٧١١f.f١٣٦٢٨h.d(a02);
        m();
        e.b bVar = e.b.WRAP_CONTENT;
        if (w10 == bVar || w11 == bVar) {
            if (z10) {
                Iterator it2 = this.f١٣٥٦٣e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!((p) it2.next()).m()) {
                        z10 = false;
                        break;
                    }
                }
            }
            if (z10 && w10 == e.b.WRAP_CONTENT) {
                this.f١٣٥٥٩a.T0(e.b.FIXED);
                c2.f fVar2 = this.f١٣٥٥٩a;
                fVar2.o1(e(fVar2, 0));
                c2.f fVar3 = this.f١٣٥٥٩a;
                fVar3.f٥٧٠٩e.f١٣٦٢٥e.d(fVar3.Y());
            }
            if (z10 && w11 == e.b.WRAP_CONTENT) {
                this.f١٣٥٥٩a.k1(e.b.FIXED);
                c2.f fVar4 = this.f١٣٥٥٩a;
                fVar4.P0(e(fVar4, 1));
                c2.f fVar5 = this.f١٣٥٥٩a;
                fVar5.f٥٧١١f.f١٣٦٢٥e.d(fVar5.z());
            }
        }
        c2.f fVar6 = this.f١٣٥٥٩a;
        e.b bVar2 = fVar6.f٥٧٠٤b0[0];
        e.b bVar3 = e.b.FIXED;
        if (bVar2 != bVar3 && bVar2 != e.b.MATCH_PARENT) {
            z11 = false;
        } else {
            int Y = fVar6.Y() + Z;
            this.f١٣٥٥٩a.f٥٧٠٩e.f١٣٦٢٩i.d(Y);
            this.f١٣٥٥٩a.f٥٧٠٩e.f١٣٦٢٥e.d(Y - Z);
            m();
            c2.f fVar7 = this.f١٣٥٥٩a;
            e.b bVar4 = fVar7.f٥٧٠٤b0[1];
            if (bVar4 == bVar3 || bVar4 == e.b.MATCH_PARENT) {
                int z13 = fVar7.z() + a02;
                this.f١٣٥٥٩a.f٥٧١١f.f١٣٦٢٩i.d(z13);
                this.f١٣٥٥٩a.f٥٧١١f.f١٣٦٢٥e.d(z13 - a02);
            }
            m();
            z11 = true;
        }
        Iterator it3 = this.f١٣٥٦٣e.iterator();
        while (it3.hasNext()) {
            p pVar = (p) it3.next();
            if (pVar.f١٣٦٢٢b != this.f١٣٥٥٩a || pVar.f١٣٦٢٧g) {
                pVar.e();
            }
        }
        Iterator it4 = this.f١٣٥٦٣e.iterator();
        while (true) {
            if (it4.hasNext()) {
                p pVar2 = (p) it4.next();
                if (z11 || pVar2.f١٣٦٢٢b != this.f١٣٥٥٩a) {
                    if (!pVar2.f١٣٦٢٨h.f١٣٥٧٧j) {
                        break;
                    }
                    if (!pVar2.f١٣٦٢٩i.f١٣٥٧٧j) {
                        if (!(pVar2 instanceof j)) {
                            break;
                        }
                    }
                    if (!pVar2.f١٣٦٢٥e.f١٣٥٧٧j && !(pVar2 instanceof c) && !(pVar2 instanceof j)) {
                        break;
                    }
                }
            } else {
                z12 = true;
                break;
            }
        }
        this.f١٣٥٥٩a.T0(w10);
        this.f١٣٥٥٩a.k1(w11);
        return z12;
    }

    public boolean g(boolean z10) {
        if (this.f١٣٥٦٠b) {
            Iterator it = this.f١٣٥٥٩a.V0.iterator();
            while (it.hasNext()) {
                c2.e eVar = (c2.e) it.next();
                eVar.p();
                eVar.f٥٧٠١a = false;
                l lVar = eVar.f٥٧٠٩e;
                lVar.f١٣٦٢٥e.f١٣٥٧٧j = false;
                lVar.f١٣٦٢٧g = false;
                lVar.r();
                n nVar = eVar.f٥٧١١f;
                nVar.f١٣٦٢٥e.f١٣٥٧٧j = false;
                nVar.f١٣٦٢٧g = false;
                nVar.q();
            }
            this.f١٣٥٥٩a.p();
            c2.f fVar = this.f١٣٥٥٩a;
            fVar.f٥٧٠١a = false;
            l lVar2 = fVar.f٥٧٠٩e;
            lVar2.f١٣٦٢٥e.f١٣٥٧٧j = false;
            lVar2.f١٣٦٢٧g = false;
            lVar2.r();
            n nVar2 = this.f١٣٥٥٩a.f٥٧١١f;
            nVar2.f١٣٦٢٥e.f١٣٥٧٧j = false;
            nVar2.f١٣٦٢٧g = false;
            nVar2.q();
            c();
        }
        if (b(this.f١٣٥٦٢d)) {
            return false;
        }
        this.f١٣٥٥٩a.q1(0);
        this.f١٣٥٥٩a.r1(0);
        this.f١٣٥٥٩a.f٥٧٠٩e.f١٣٦٢٨h.d(0);
        this.f١٣٥٥٩a.f٥٧١١f.f١٣٦٢٨h.d(0);
        return true;
    }

    public boolean h(boolean z10, int i10) {
        boolean z11;
        e.b bVar;
        boolean z12 = false;
        e.b w10 = this.f١٣٥٥٩a.w(0);
        e.b w11 = this.f١٣٥٥٩a.w(1);
        int Z = this.f١٣٥٥٩a.Z();
        int a02 = this.f١٣٥٥٩a.a0();
        if (z10 && (w10 == (bVar = e.b.WRAP_CONTENT) || w11 == bVar)) {
            Iterator it = this.f١٣٥٦٣e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p pVar = (p) it.next();
                if (pVar.f١٣٦٢٦f == i10 && !pVar.m()) {
                    z10 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z10 && w10 == e.b.WRAP_CONTENT) {
                    this.f١٣٥٥٩a.T0(e.b.FIXED);
                    c2.f fVar = this.f١٣٥٥٩a;
                    fVar.o1(e(fVar, 0));
                    c2.f fVar2 = this.f١٣٥٥٩a;
                    fVar2.f٥٧٠٩e.f١٣٦٢٥e.d(fVar2.Y());
                }
            } else if (z10 && w11 == e.b.WRAP_CONTENT) {
                this.f١٣٥٥٩a.k1(e.b.FIXED);
                c2.f fVar3 = this.f١٣٥٥٩a;
                fVar3.P0(e(fVar3, 1));
                c2.f fVar4 = this.f١٣٥٥٩a;
                fVar4.f٥٧١١f.f١٣٦٢٥e.d(fVar4.z());
            }
        }
        if (i10 == 0) {
            c2.f fVar5 = this.f١٣٥٥٩a;
            e.b bVar2 = fVar5.f٥٧٠٤b0[0];
            if (bVar2 == e.b.FIXED || bVar2 == e.b.MATCH_PARENT) {
                int Y = fVar5.Y() + Z;
                this.f١٣٥٥٩a.f٥٧٠٩e.f١٣٦٢٩i.d(Y);
                this.f١٣٥٥٩a.f٥٧٠٩e.f١٣٦٢٥e.d(Y - Z);
                z11 = true;
            }
            z11 = false;
        } else {
            c2.f fVar6 = this.f١٣٥٥٩a;
            e.b bVar3 = fVar6.f٥٧٠٤b0[1];
            if (bVar3 == e.b.FIXED || bVar3 == e.b.MATCH_PARENT) {
                int z13 = fVar6.z() + a02;
                this.f١٣٥٥٩a.f٥٧١١f.f١٣٦٢٩i.d(z13);
                this.f١٣٥٥٩a.f٥٧١١f.f١٣٦٢٥e.d(z13 - a02);
                z11 = true;
            }
            z11 = false;
        }
        m();
        Iterator it2 = this.f١٣٥٦٣e.iterator();
        while (it2.hasNext()) {
            p pVar2 = (p) it2.next();
            if (pVar2.f١٣٦٢٦f == i10 && (pVar2.f١٣٦٢٢b != this.f١٣٥٥٩a || pVar2.f١٣٦٢٧g)) {
                pVar2.e();
            }
        }
        Iterator it3 = this.f١٣٥٦٣e.iterator();
        while (true) {
            if (it3.hasNext()) {
                p pVar3 = (p) it3.next();
                if (pVar3.f١٣٦٢٦f == i10 && (z11 || pVar3.f١٣٦٢٢b != this.f١٣٥٥٩a)) {
                    if (!pVar3.f١٣٦٢٨h.f١٣٥٧٧j) {
                        break;
                    }
                    if (!pVar3.f١٣٦٢٩i.f١٣٥٧٧j) {
                        break;
                    }
                    if (!(pVar3 instanceof c) && !pVar3.f١٣٦٢٥e.f١٣٥٧٧j) {
                        break;
                    }
                }
            } else {
                z12 = true;
                break;
            }
        }
        this.f١٣٥٥٩a.T0(w10);
        this.f١٣٥٥٩a.k1(w11);
        return z12;
    }

    public void j() {
        this.f١٣٥٦٠b = true;
    }

    public void k() {
        this.f١٣٥٦١c = true;
    }

    public void m() {
        boolean z10;
        g gVar;
        Iterator it = this.f١٣٥٥٩a.V0.iterator();
        while (it.hasNext()) {
            c2.e eVar = (c2.e) it.next();
            if (!eVar.f٥٧٠١a) {
                e.b[] bVarArr = eVar.f٥٧٠٤b0;
                boolean z11 = false;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                int i10 = eVar.f٥٧٤٥w;
                int i11 = eVar.f٥٧٤٧x;
                e.b bVar3 = e.b.WRAP_CONTENT;
                if (bVar != bVar3 && (bVar != e.b.MATCH_CONSTRAINT || i10 != 1)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (bVar2 == bVar3 || (bVar2 == e.b.MATCH_CONSTRAINT && i11 == 1)) {
                    z11 = true;
                }
                g gVar2 = eVar.f٥٧٠٩e.f١٣٦٢٥e;
                boolean z12 = gVar2.f١٣٥٧٧j;
                g gVar3 = eVar.f٥٧١١f.f١٣٦٢٥e;
                boolean z13 = gVar3.f١٣٥٧٧j;
                if (z12 && z13) {
                    e.b bVar4 = e.b.FIXED;
                    l(eVar, bVar4, gVar2.f١٣٥٧٤g, bVar4, gVar3.f١٣٥٧٤g);
                    eVar.f٥٧٠١a = true;
                } else if (z12 && z11) {
                    l(eVar, e.b.FIXED, gVar2.f١٣٥٧٤g, bVar3, gVar3.f١٣٥٧٤g);
                    if (bVar2 == e.b.MATCH_CONSTRAINT) {
                        eVar.f٥٧١١f.f١٣٦٢٥e.f١٣٥٨٩m = eVar.z();
                    } else {
                        eVar.f٥٧١١f.f١٣٦٢٥e.d(eVar.z());
                        eVar.f٥٧٠١a = true;
                    }
                } else if (z13 && z10) {
                    l(eVar, bVar3, gVar2.f١٣٥٧٤g, e.b.FIXED, gVar3.f١٣٥٧٤g);
                    if (bVar == e.b.MATCH_CONSTRAINT) {
                        eVar.f٥٧٠٩e.f١٣٦٢٥e.f١٣٥٨٩m = eVar.Y();
                    } else {
                        eVar.f٥٧٠٩e.f١٣٦٢٥e.d(eVar.Y());
                        eVar.f٥٧٠١a = true;
                    }
                }
                if (eVar.f٥٧٠١a && (gVar = eVar.f٥٧١١f.f١٣٦٠٤l) != null) {
                    gVar.d(eVar.r());
                }
            }
        }
    }

    public void n(b.InterfaceC٠١٥٠b r12) {
        this.f١٣٥٦٥g = r12;
    }
}
