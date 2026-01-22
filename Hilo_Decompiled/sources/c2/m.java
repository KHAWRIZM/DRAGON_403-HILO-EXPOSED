package c2;

import c2.e;
import d2.b;
import java.util.HashSet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class m extends j {
    private int X0 = 0;
    private int Y0 = 0;
    private int Z0 = 0;

    /* renamed from: a1, reason: collision with root package name */
    private int f٥٨٢٥a1 = 0;

    /* renamed from: b1, reason: collision with root package name */
    private int f٥٨٢٦b1 = 0;

    /* renamed from: c1, reason: collision with root package name */
    private int f٥٨٢٧c1 = 0;

    /* renamed from: d1, reason: collision with root package name */
    private int f٥٨٢٨d1 = 0;

    /* renamed from: e1, reason: collision with root package name */
    private int f٥٨٢٩e1 = 0;

    /* renamed from: f1, reason: collision with root package name */
    private boolean f٥٨٣٠f1 = false;

    /* renamed from: g1, reason: collision with root package name */
    private int f٥٨٣١g1 = 0;

    /* renamed from: h1, reason: collision with root package name */
    private int f٥٨٣٢h1 = 0;

    /* renamed from: i1, reason: collision with root package name */
    protected b.a f٥٨٣٣i1 = new b.a();

    /* renamed from: j1, reason: collision with root package name */
    b.InterfaceC٠١٥٠b f٥٨٣٤j1 = null;

    public int A1() {
        return this.f٥٨٣٢h1;
    }

    public int B1() {
        return this.f٥٨٣١g1;
    }

    public int C1() {
        return this.Y0;
    }

    public int D1() {
        return this.f٥٨٢٨d1;
    }

    public int E1() {
        return this.f٥٨٢٩e1;
    }

    public int F1() {
        return this.X0;
    }

    public abstract void G1(int i10, int i11, int i12, int i13);

    /* JADX INFO: Access modifiers changed from: protected */
    public void H1(e eVar, e.b bVar, int i10, e.b bVar2, int i11) {
        while (this.f٥٨٣٤j1 == null && M() != null) {
            this.f٥٨٣٤j1 = ((f) M()).N1();
        }
        b.a aVar = this.f٥٨٣٣i1;
        aVar.f١٣٥٤٧a = bVar;
        aVar.f١٣٥٤٨b = bVar2;
        aVar.f١٣٥٤٩c = i10;
        aVar.f١٣٥٥٠d = i11;
        this.f٥٨٣٤j1.b(eVar, aVar);
        eVar.o1(this.f٥٨٣٣i1.f١٣٥٥١e);
        eVar.P0(this.f٥٨٣٣i1.f١٣٥٥٢f);
        eVar.O0(this.f٥٨٣٣i1.f١٣٥٥٤h);
        eVar.E0(this.f٥٨٣٣i1.f١٣٥٥٣g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I1() {
        b.InterfaceC٠١٥٠b r02;
        e eVar = this.f٥٧٠٦c0;
        if (eVar != null) {
            r02 = ((f) eVar).N1();
        } else {
            r02 = null;
        }
        if (r02 == null) {
            return false;
        }
        for (int i10 = 0; i10 < this.W0; i10++) {
            e eVar2 = this.V0[i10];
            if (eVar2 != null && !(eVar2 instanceof h)) {
                e.b w10 = eVar2.w(0);
                e.b w11 = eVar2.w(1);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (w10 != bVar || eVar2.f٥٧٤٥w == 1 || w11 != bVar || eVar2.f٥٧٤٧x == 1) {
                    if (w10 == bVar) {
                        w10 = e.b.WRAP_CONTENT;
                    }
                    if (w11 == bVar) {
                        w11 = e.b.WRAP_CONTENT;
                    }
                    b.a aVar = this.f٥٨٣٣i1;
                    aVar.f١٣٥٤٧a = w10;
                    aVar.f١٣٥٤٨b = w11;
                    aVar.f١٣٥٤٩c = eVar2.Y();
                    this.f٥٨٣٣i1.f١٣٥٥٠d = eVar2.z();
                    r02.b(eVar2, this.f٥٨٣٣i1);
                    eVar2.o1(this.f٥٨٣٣i1.f١٣٥٥١e);
                    eVar2.P0(this.f٥٨٣٣i1.f١٣٥٥٢f);
                    eVar2.E0(this.f٥٨٣٣i1.f١٣٥٥٣g);
                }
            }
        }
        return true;
    }

    public boolean J1() {
        return this.f٥٨٣٠f1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K1(boolean z10) {
        this.f٥٨٣٠f1 = z10;
    }

    public void L1(int i10, int i11) {
        this.f٥٨٣١g1 = i10;
        this.f٥٨٣٢h1 = i11;
    }

    public void M1(int i10) {
        this.Z0 = i10;
        this.X0 = i10;
        this.f٥٨٢٥a1 = i10;
        this.Y0 = i10;
        this.f٥٨٢٦b1 = i10;
        this.f٥٨٢٧c1 = i10;
    }

    public void N1(int i10) {
        this.Y0 = i10;
    }

    public void O1(int i10) {
        this.f٥٨٢٧c1 = i10;
    }

    public void P1(int i10) {
        this.Z0 = i10;
        this.f٥٨٢٨d1 = i10;
    }

    public void Q1(int i10) {
        this.f٥٨٢٥a1 = i10;
        this.f٥٨٢٩e1 = i10;
    }

    public void R1(int i10) {
        this.f٥٨٢٦b1 = i10;
        this.f٥٨٢٨d1 = i10;
        this.f٥٨٢٩e1 = i10;
    }

    public void S1(int i10) {
        this.X0 = i10;
    }

    @Override // c2.j, c2.i
    public void b(f fVar) {
        y1();
    }

    public void x1(boolean z10) {
        int i10 = this.f٥٨٢٦b1;
        if (i10 > 0 || this.f٥٨٢٧c1 > 0) {
            if (z10) {
                this.f٥٨٢٨d1 = this.f٥٨٢٧c1;
                this.f٥٨٢٩e1 = i10;
            } else {
                this.f٥٨٢٨d1 = i10;
                this.f٥٨٢٩e1 = this.f٥٨٢٧c1;
            }
        }
    }

    public void y1() {
        for (int i10 = 0; i10 < this.W0; i10++) {
            e eVar = this.V0[i10];
            if (eVar != null) {
                eVar.Y0(true);
            }
        }
    }

    public boolean z1(HashSet hashSet) {
        for (int i10 = 0; i10 < this.W0; i10++) {
            if (hashSet.contains(this.V0[i10])) {
                return true;
            }
        }
        return false;
    }
}
