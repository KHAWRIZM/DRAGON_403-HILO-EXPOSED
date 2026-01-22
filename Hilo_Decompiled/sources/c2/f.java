package c2;

import c2.e;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import d2.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f extends n {
    private int Y0;

    /* renamed from: c1, reason: collision with root package name */
    int f٥٧٦٢c1;

    /* renamed from: d1, reason: collision with root package name */
    int f٥٧٦٣d1;

    /* renamed from: e1, reason: collision with root package name */
    int f٥٧٦٤e1;

    /* renamed from: f1, reason: collision with root package name */
    int f٥٧٦٥f1;
    d2.b W0 = new d2.b(this);
    public d2.e X0 = new d2.e(this);
    protected b.InterfaceC٠١٥٠b Z0 = null;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f٥٧٦٠a1 = false;

    /* renamed from: b1, reason: collision with root package name */
    protected z1.d f٥٧٦١b1 = new z1.d();

    /* renamed from: g1, reason: collision with root package name */
    public int f٥٧٦٦g1 = 0;

    /* renamed from: h1, reason: collision with root package name */
    public int f٥٧٦٧h1 = 0;

    /* renamed from: i1, reason: collision with root package name */
    c[] f٥٧٦٨i1 = new c[4];

    /* renamed from: j1, reason: collision with root package name */
    c[] f٥٧٦٩j1 = new c[4];

    /* renamed from: k1, reason: collision with root package name */
    public boolean f٥٧٧٠k1 = false;

    /* renamed from: l1, reason: collision with root package name */
    public boolean f٥٧٧١l1 = false;

    /* renamed from: m1, reason: collision with root package name */
    public boolean f٥٧٧٢m1 = false;

    /* renamed from: n1, reason: collision with root package name */
    public int f٥٧٧٣n1 = 0;

    /* renamed from: o1, reason: collision with root package name */
    public int f٥٧٧٤o1 = 0;

    /* renamed from: p1, reason: collision with root package name */
    private int f٥٧٧٥p1 = 257;

    /* renamed from: q1, reason: collision with root package name */
    public boolean f٥٧٧٦q1 = false;

    /* renamed from: r1, reason: collision with root package name */
    private boolean f٥٧٧٧r1 = false;

    /* renamed from: s1, reason: collision with root package name */
    private boolean f٥٧٧٨s1 = false;

    /* renamed from: t1, reason: collision with root package name */
    int f٥٧٧٩t1 = 0;

    /* renamed from: u1, reason: collision with root package name */
    private WeakReference f٥٧٨٠u1 = null;

    /* renamed from: v1, reason: collision with root package name */
    private WeakReference f٥٧٨١v1 = null;

    /* renamed from: w1, reason: collision with root package name */
    private WeakReference f٥٧٨٢w1 = null;

    /* renamed from: x1, reason: collision with root package name */
    private WeakReference f٥٧٨٣x1 = null;

    /* renamed from: y1, reason: collision with root package name */
    HashSet f٥٧٨٤y1 = new HashSet();

    /* renamed from: z1, reason: collision with root package name */
    public b.a f٥٧٨٥z1 = new b.a();

    private void B1(e eVar) {
        int i10 = this.f٥٧٦٦g1 + 1;
        c[] cVarArr = this.f٥٧٦٩j1;
        if (i10 >= cVarArr.length) {
            this.f٥٧٦٩j1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f٥٧٦٩j1[this.f٥٧٦٦g1] = new c(eVar, 0, U1());
        this.f٥٧٦٦g1++;
    }

    private void E1(d dVar, z1.i iVar) {
        this.f٥٧٦١b1.h(iVar, this.f٥٧٦١b1.q(dVar), 0, 5);
    }

    private void F1(d dVar, z1.i iVar) {
        this.f٥٧٦١b1.h(this.f٥٧٦١b1.q(dVar), iVar, 0, 5);
    }

    private void G1(e eVar) {
        int i10 = this.f٥٧٦٧h1 + 1;
        c[] cVarArr = this.f٥٧٦٨i1;
        if (i10 >= cVarArr.length) {
            this.f٥٧٦٨i1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f٥٧٦٨i1[this.f٥٧٦٧h1] = new c(eVar, 1, U1());
        this.f٥٧٦٧h1++;
    }

    public static boolean X1(int i10, e eVar, b.InterfaceC٠١٥٠b r72, b.a aVar, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i12;
        int i13;
        if (r72 == null) {
            return false;
        }
        if (eVar.X() != 8 && !(eVar instanceof h) && !(eVar instanceof a)) {
            aVar.f١٣٥٤٧a = eVar.C();
            aVar.f١٣٥٤٨b = eVar.V();
            aVar.f١٣٥٤٩c = eVar.Y();
            aVar.f١٣٥٥٠d = eVar.z();
            aVar.f١٣٥٥٥i = false;
            aVar.f١٣٥٥٦j = i11;
            e.b bVar = aVar.f١٣٥٤٧a;
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            if (bVar == bVar2) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (aVar.f١٣٥٤٨b == bVar2) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 && eVar.f٥٧١٢f0 > DownloadProgress.UNKNOWN_PROGRESS) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z11 && eVar.f٥٧١٢f0 > DownloadProgress.UNKNOWN_PROGRESS) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z10 && eVar.c0(0) && eVar.f٥٧٤٥w == 0 && !z12) {
                aVar.f١٣٥٤٧a = e.b.WRAP_CONTENT;
                if (z11 && eVar.f٥٧٤٧x == 0) {
                    aVar.f١٣٥٤٧a = e.b.FIXED;
                }
                z10 = false;
            }
            if (z11 && eVar.c0(1) && eVar.f٥٧٤٧x == 0 && !z13) {
                aVar.f١٣٥٤٨b = e.b.WRAP_CONTENT;
                if (z10 && eVar.f٥٧٤٥w == 0) {
                    aVar.f١٣٥٤٨b = e.b.FIXED;
                }
                z11 = false;
            }
            if (eVar.p0()) {
                aVar.f١٣٥٤٧a = e.b.FIXED;
                z10 = false;
            }
            if (eVar.q0()) {
                aVar.f١٣٥٤٨b = e.b.FIXED;
                z11 = false;
            }
            if (z12) {
                if (eVar.f٥٧٤٩y[0] == 4) {
                    aVar.f١٣٥٤٧a = e.b.FIXED;
                } else if (!z11) {
                    e.b bVar3 = aVar.f١٣٥٤٨b;
                    e.b bVar4 = e.b.FIXED;
                    if (bVar3 == bVar4) {
                        i13 = aVar.f١٣٥٥٠d;
                    } else {
                        aVar.f١٣٥٤٧a = e.b.WRAP_CONTENT;
                        r72.b(eVar, aVar);
                        i13 = aVar.f١٣٥٥٢f;
                    }
                    aVar.f١٣٥٤٧a = bVar4;
                    aVar.f١٣٥٤٩c = (int) (eVar.x() * i13);
                }
            }
            if (z13) {
                if (eVar.f٥٧٤٩y[1] == 4) {
                    aVar.f١٣٥٤٨b = e.b.FIXED;
                } else if (!z10) {
                    e.b bVar5 = aVar.f١٣٥٤٧a;
                    e.b bVar6 = e.b.FIXED;
                    if (bVar5 == bVar6) {
                        i12 = aVar.f١٣٥٤٩c;
                    } else {
                        aVar.f١٣٥٤٨b = e.b.WRAP_CONTENT;
                        r72.b(eVar, aVar);
                        i12 = aVar.f١٣٥٥١e;
                    }
                    aVar.f١٣٥٤٨b = bVar6;
                    if (eVar.y() == -1) {
                        aVar.f١٣٥٥٠d = (int) (i12 / eVar.x());
                    } else {
                        aVar.f١٣٥٥٠d = (int) (eVar.x() * i12);
                    }
                }
            }
            r72.b(eVar, aVar);
            eVar.o1(aVar.f١٣٥٥١e);
            eVar.P0(aVar.f١٣٥٥٢f);
            eVar.O0(aVar.f١٣٥٥٤h);
            eVar.E0(aVar.f١٣٥٥٣g);
            aVar.f١٣٥٥٦j = b.a.f١٣٥٤٤k;
            return aVar.f١٣٥٥٥i;
        }
        aVar.f١٣٥٥١e = 0;
        aVar.f١٣٥٥٢f = 0;
        return false;
    }

    private void Z1() {
        this.f٥٧٦٦g1 = 0;
        this.f٥٧٦٧h1 = 0;
    }

    public boolean A1(z1.d dVar) {
        int i10;
        boolean Y1 = Y1(64);
        g(dVar, Y1);
        int size = this.V0.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = (e) this.V0.get(i11);
            eVar.W0(0, false);
            eVar.W0(1, false);
            if (eVar instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                e eVar2 = (e) this.V0.get(i12);
                if (eVar2 instanceof a) {
                    ((a) eVar2).C1();
                }
            }
        }
        this.f٥٧٨٤y1.clear();
        for (int i13 = 0; i13 < size; i13++) {
            e eVar3 = (e) this.V0.get(i13);
            if (eVar3.f()) {
                if (eVar3 instanceof m) {
                    this.f٥٧٨٤y1.add(eVar3);
                } else {
                    eVar3.g(dVar, Y1);
                }
            }
        }
        while (this.f٥٧٨٤y1.size() > 0) {
            int size2 = this.f٥٧٨٤y1.size();
            Iterator it = this.f٥٧٨٤y1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m mVar = (m) ((e) it.next());
                if (mVar.z1(this.f٥٧٨٤y1)) {
                    mVar.g(dVar, Y1);
                    this.f٥٧٨٤y1.remove(mVar);
                    break;
                }
            }
            if (size2 == this.f٥٧٨٤y1.size()) {
                Iterator it2 = this.f٥٧٨٤y1.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).g(dVar, Y1);
                }
                this.f٥٧٨٤y1.clear();
            }
        }
        if (z1.d.f١٩٣٥٧r) {
            HashSet hashSet = new HashSet();
            for (int i14 = 0; i14 < size; i14++) {
                e eVar4 = (e) this.V0.get(i14);
                if (!eVar4.f()) {
                    hashSet.add(eVar4);
                }
            }
            if (C() == e.b.WRAP_CONTENT) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            e(this, dVar, hashSet, i10, false);
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                e eVar5 = (e) it3.next();
                k.a(this, dVar, eVar5);
                eVar5.g(dVar, Y1);
            }
        } else {
            for (int i15 = 0; i15 < size; i15++) {
                e eVar6 = (e) this.V0.get(i15);
                if (eVar6 instanceof f) {
                    e.b[] bVarArr = eVar6.f٥٧٠٤b0;
                    e.b bVar = bVarArr[0];
                    e.b bVar2 = bVarArr[1];
                    e.b bVar3 = e.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        eVar6.T0(e.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.k1(e.b.FIXED);
                    }
                    eVar6.g(dVar, Y1);
                    if (bVar == bVar3) {
                        eVar6.T0(bVar);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.k1(bVar2);
                    }
                } else {
                    k.a(this, dVar, eVar6);
                    if (!eVar6.f()) {
                        eVar6.g(dVar, Y1);
                    }
                }
            }
        }
        if (this.f٥٧٦٦g1 > 0) {
            b.b(this, dVar, null, 0);
        }
        if (this.f٥٧٦٧h1 > 0) {
            b.b(this, dVar, null, 1);
        }
        return true;
    }

    public void C1(d dVar) {
        WeakReference weakReference = this.f٥٧٨٣x1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > ((d) this.f٥٧٨٣x1.get()).e()) {
            this.f٥٧٨٣x1 = new WeakReference(dVar);
        }
    }

    public void D1(d dVar) {
        WeakReference weakReference = this.f٥٧٨١v1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > ((d) this.f٥٧٨١v1.get()).e()) {
            this.f٥٧٨١v1 = new WeakReference(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H1(d dVar) {
        WeakReference weakReference = this.f٥٧٨٢w1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > ((d) this.f٥٧٨٢w1.get()).e()) {
            this.f٥٧٨٢w1 = new WeakReference(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I1(d dVar) {
        WeakReference weakReference = this.f٥٧٨٠u1;
        if (weakReference == null || weakReference.get() == null || dVar.e() > ((d) this.f٥٧٨٠u1.get()).e()) {
            this.f٥٧٨٠u1 = new WeakReference(dVar);
        }
    }

    public boolean J1(boolean z10) {
        return this.X0.f(z10);
    }

    public boolean K1(boolean z10) {
        return this.X0.g(z10);
    }

    public boolean L1(boolean z10, int i10) {
        return this.X0.h(z10, i10);
    }

    public void M1(z1.e eVar) {
        this.f٥٧٦١b1.v(eVar);
    }

    public b.InterfaceC٠١٥٠b N1() {
        return this.Z0;
    }

    public int O1() {
        return this.f٥٧٧٥p1;
    }

    public z1.d P1() {
        return this.f٥٧٦١b1;
    }

    @Override // c2.e
    public void Q(StringBuilder sb) {
        sb.append(this.f٥٧٢٩o + ":{\n");
        sb.append("  actualWidth:" + this.f٥٧٠٨d0);
        sb.append("\n");
        sb.append("  actualHeight:" + this.f٥٧١٠e0);
        sb.append("\n");
        Iterator it = v1().iterator();
        while (it.hasNext()) {
            ((e) it.next()).Q(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public boolean Q1() {
        return false;
    }

    public void R1() {
        this.X0.j();
    }

    public void S1() {
        this.X0.k();
    }

    public boolean T1() {
        return this.f٥٧٧٨s1;
    }

    public boolean U1() {
        return this.f٥٧٦٠a1;
    }

    public boolean V1() {
        return this.f٥٧٧٧r1;
    }

    public long W1(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.f٥٧٦٢c1 = i17;
        this.f٥٧٦٣d1 = i18;
        return this.W0.d(this, i10, i17, i18, i11, i12, i13, i14, i15, i16);
    }

    public boolean Y1(int i10) {
        if ((this.f٥٧٧٥p1 & i10) == i10) {
            return true;
        }
        return false;
    }

    public void a2(b.InterfaceC٠١٥٠b r22) {
        this.Z0 = r22;
        this.X0.n(r22);
    }

    public void b2(int i10) {
        this.f٥٧٧٥p1 = i10;
        z1.d.f١٩٣٥٧r = Y1(512);
    }

    public void c2(int i10) {
        this.Y0 = i10;
    }

    public void d2(boolean z10) {
        this.f٥٧٦٠a1 = z10;
    }

    public boolean e2(z1.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean Y1 = Y1(64);
        u1(dVar, Y1);
        int size = this.V0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = (e) this.V0.get(i10);
            eVar.u1(dVar, Y1);
            if (eVar.e0()) {
                z10 = true;
            }
        }
        return z10;
    }

    public void f2() {
        this.W0.e(this);
    }

    @Override // c2.e
    public void t1(boolean z10, boolean z11) {
        super.t1(z10, z11);
        int size = this.V0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((e) this.V0.get(i10)).t1(z10, z11);
        }
    }

    @Override // c2.n, c2.e
    public void v0() {
        this.f٥٧٦١b1.E();
        this.f٥٧٦٢c1 = 0;
        this.f٥٧٦٤e1 = 0;
        this.f٥٧٦٣d1 = 0;
        this.f٥٧٦٥f1 = 0;
        this.f٥٧٧٦q1 = false;
        super.v0();
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0310  */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // c2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w1() {
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        ?? r62;
        boolean z15;
        boolean z16;
        int i12;
        e.b bVar;
        this.f٥٧١٦h0 = 0;
        this.f٥٧١٨i0 = 0;
        this.f٥٧٧٧r1 = false;
        this.f٥٧٧٨s1 = false;
        int size = this.V0.size();
        int max = Math.max(0, Y());
        int max2 = Math.max(0, z());
        e.b[] bVarArr = this.f٥٧٠٤b0;
        e.b bVar2 = bVarArr[1];
        e.b bVar3 = bVarArr[0];
        if (this.Y0 == 0 && k.b(this.f٥٧٧٥p1, 1)) {
            d2.h.h(this, N1());
            for (int i13 = 0; i13 < size; i13++) {
                e eVar = (e) this.V0.get(i13);
                if (eVar.o0() && !(eVar instanceof h) && !(eVar instanceof a) && !(eVar instanceof m) && !eVar.n0()) {
                    e.b w10 = eVar.w(0);
                    e.b w11 = eVar.w(1);
                    e.b bVar4 = e.b.MATCH_CONSTRAINT;
                    if (w10 != bVar4 || eVar.f٥٧٤٥w == 1 || w11 != bVar4 || eVar.f٥٧٤٧x == 1) {
                        X1(0, eVar, this.Z0, new b.a(), b.a.f١٣٥٤٤k);
                    }
                }
            }
        }
        if (size > 2 && ((bVar3 == (bVar = e.b.WRAP_CONTENT) || bVar2 == bVar) && k.b(this.f٥٧٧٥p1, 1024) && d2.i.c(this, N1()))) {
            if (bVar3 == bVar) {
                if (max < Y() && max > 0) {
                    o1(max);
                    this.f٥٧٧٧r1 = true;
                } else {
                    max = Y();
                }
            }
            if (bVar2 == bVar) {
                if (max2 < z() && max2 > 0) {
                    P0(max2);
                    this.f٥٧٧٨s1 = true;
                } else {
                    max2 = z();
                }
            }
            i10 = max2;
            i11 = max;
            z10 = true;
        } else {
            i10 = max2;
            i11 = max;
            z10 = false;
        }
        if (!Y1(64) && !Y1(128)) {
            z11 = false;
        } else {
            z11 = true;
        }
        z1.d dVar = this.f٥٧٦١b1;
        dVar.f١٩٣٧٢h = false;
        dVar.f١٩٣٧٣i = false;
        if (this.f٥٧٧٥p1 != 0 && z11) {
            dVar.f١٩٣٧٣i = true;
        }
        ArrayList arrayList = this.V0;
        e.b C = C();
        e.b bVar5 = e.b.WRAP_CONTENT;
        if (C != bVar5 && V() != bVar5) {
            z12 = false;
        } else {
            z12 = true;
        }
        Z1();
        for (int i14 = 0; i14 < size; i14++) {
            e eVar2 = (e) this.V0.get(i14);
            if (eVar2 instanceof n) {
                ((n) eVar2).w1();
            }
        }
        boolean Y1 = Y1(64);
        boolean z17 = z10;
        int i15 = 0;
        boolean z18 = true;
        while (z18) {
            int i16 = i15 + 1;
            try {
                this.f٥٧٦١b1.E();
                Z1();
                o(this.f٥٧٦١b1);
                for (int i17 = 0; i17 < size; i17++) {
                    ((e) this.V0.get(i17)).o(this.f٥٧٦١b1);
                }
                z18 = A1(this.f٥٧٦١b1);
                WeakReference weakReference = this.f٥٧٨٠u1;
                if (weakReference != null && weakReference.get() != null) {
                    F1((d) this.f٥٧٨٠u1.get(), this.f٥٧٦١b1.q(this.R));
                    this.f٥٧٨٠u1 = null;
                }
                WeakReference weakReference2 = this.f٥٧٨٢w1;
                if (weakReference2 != null && weakReference2.get() != null) {
                    E1((d) this.f٥٧٨٢w1.get(), this.f٥٧٦١b1.q(this.T));
                    this.f٥٧٨٢w1 = null;
                }
                WeakReference weakReference3 = this.f٥٧٨١v1;
                if (weakReference3 != null && weakReference3.get() != null) {
                    F1((d) this.f٥٧٨١v1.get(), this.f٥٧٦١b1.q(this.Q));
                    this.f٥٧٨١v1 = null;
                }
                WeakReference weakReference4 = this.f٥٧٨٣x1;
                if (weakReference4 != null && weakReference4.get() != null) {
                    E1((d) this.f٥٧٨٣x1.get(), this.f٥٧٦١b1.q(this.S));
                    this.f٥٧٨٣x1 = null;
                }
                if (z18) {
                    this.f٥٧٦١b1.A();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                System.out.println("EXCEPTION : " + e10);
            }
            if (z18) {
                z13 = e2(this.f٥٧٦١b1, k.f٥٨٢٤a);
            } else {
                u1(this.f٥٧٦١b1, Y1);
                for (int i18 = 0; i18 < size; i18++) {
                    ((e) this.V0.get(i18)).u1(this.f٥٧٦١b1, Y1);
                }
                z13 = false;
            }
            if (z12 && i16 < 8 && k.f٥٨٢٤a[2]) {
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                while (i19 < size) {
                    e eVar3 = (e) this.V0.get(i19);
                    i21 = Math.max(i21, eVar3.f٥٧١٦h0 + eVar3.Y());
                    i20 = Math.max(i20, eVar3.f٥٧١٨i0 + eVar3.z());
                    i19++;
                    z13 = z13;
                }
                z14 = z13;
                int max3 = Math.max(this.f٥٧٣٠o0, i21);
                int max4 = Math.max(this.f٥٧٣٢p0, i20);
                e.b bVar6 = e.b.WRAP_CONTENT;
                if (bVar3 == bVar6 && Y() < max3) {
                    o1(max3);
                    this.f٥٧٠٤b0[0] = bVar6;
                    z17 = true;
                    z14 = true;
                }
                if (bVar2 == bVar6 && z() < max4) {
                    P0(max4);
                    this.f٥٧٠٤b0[1] = bVar6;
                    z17 = true;
                    z14 = true;
                }
            } else {
                z14 = z13;
            }
            int max5 = Math.max(this.f٥٧٣٠o0, Y());
            if (max5 > Y()) {
                o1(max5);
                this.f٥٧٠٤b0[0] = e.b.FIXED;
                z17 = true;
                z14 = true;
            }
            int max6 = Math.max(this.f٥٧٣٢p0, z());
            if (max6 > z()) {
                P0(max6);
                r62 = 1;
                this.f٥٧٠٤b0[1] = e.b.FIXED;
                z15 = true;
                z14 = true;
            } else {
                r62 = 1;
                z15 = z17;
            }
            if (!z15) {
                e.b bVar7 = this.f٥٧٠٤b0[0];
                e.b bVar8 = e.b.WRAP_CONTENT;
                if (bVar7 == bVar8 && i11 > 0 && Y() > i11) {
                    this.f٥٧٧٧r1 = r62;
                    this.f٥٧٠٤b0[0] = e.b.FIXED;
                    o1(i11);
                    z15 = true;
                    z14 = true;
                }
                if (this.f٥٧٠٤b0[r62] == bVar8 && i10 > 0 && z() > i10) {
                    this.f٥٧٧٨s1 = r62;
                    this.f٥٧٠٤b0[r62] = e.b.FIXED;
                    P0(i10);
                    i12 = 8;
                    z16 = true;
                    z17 = true;
                    if (i16 <= i12) {
                        z18 = false;
                    } else {
                        z18 = z16;
                    }
                    i15 = i16;
                }
            }
            z17 = z15;
            z16 = z14;
            i12 = 8;
            if (i16 <= i12) {
            }
            i15 = i16;
        }
        this.V0 = arrayList;
        if (z17) {
            e.b[] bVarArr2 = this.f٥٧٠٤b0;
            bVarArr2[0] = bVar3;
            bVarArr2[1] = bVar2;
        }
        z0(this.f٥٧٦١b1.w());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z1(e eVar, int i10) {
        if (i10 == 0) {
            B1(eVar);
        } else if (i10 == 1) {
            G1(eVar);
        }
    }
}
