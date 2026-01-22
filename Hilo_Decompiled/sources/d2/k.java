package d2;

import d2.f;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class k extends p {
    public k(c2.e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.f١٣٦٢٨h.f١٣٥٧٨k.add(fVar);
        fVar.f١٣٥٧٩l.add(this.f١٣٦٢٨h);
    }

    @Override // d2.p, d2.d
    public void a(d dVar) {
        c2.a aVar = (c2.a) this.f١٣٦٢٢b;
        int z12 = aVar.z1();
        Iterator it = this.f١٣٦٢٨h.f١٣٥٧٩l.iterator();
        int i10 = 0;
        int i11 = -1;
        while (it.hasNext()) {
            int i12 = ((f) it.next()).f١٣٥٧٤g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (z12 != 0 && z12 != 2) {
            this.f١٣٦٢٨h.d(i10 + aVar.A1());
        } else {
            this.f١٣٦٢٨h.d(i11 + aVar.A1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public void d() {
        c2.e eVar = this.f١٣٦٢٢b;
        if (eVar instanceof c2.a) {
            this.f١٣٦٢٨h.f١٣٥٦٩b = true;
            c2.a aVar = (c2.a) eVar;
            int z12 = aVar.z1();
            boolean y12 = aVar.y1();
            int i10 = 0;
            if (z12 != 0) {
                if (z12 != 1) {
                    if (z12 != 2) {
                        if (z12 == 3) {
                            this.f١٣٦٢٨h.f١٣٥٧٢e = f.a.BOTTOM;
                            while (i10 < aVar.W0) {
                                c2.e eVar2 = aVar.V0[i10];
                                if (y12 || eVar2.X() != 8) {
                                    f fVar = eVar2.f٥٧١١f.f١٣٦٢٩i;
                                    fVar.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
                                    this.f١٣٦٢٨h.f١٣٥٧٩l.add(fVar);
                                }
                                i10++;
                            }
                            q(this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٨h);
                            q(this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٩i);
                            return;
                        }
                        return;
                    }
                    this.f١٣٦٢٨h.f١٣٥٧٢e = f.a.TOP;
                    while (i10 < aVar.W0) {
                        c2.e eVar3 = aVar.V0[i10];
                        if (y12 || eVar3.X() != 8) {
                            f fVar2 = eVar3.f٥٧١١f.f١٣٦٢٨h;
                            fVar2.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
                            this.f١٣٦٢٨h.f١٣٥٧٩l.add(fVar2);
                        }
                        i10++;
                    }
                    q(this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٨h);
                    q(this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٩i);
                    return;
                }
                this.f١٣٦٢٨h.f١٣٥٧٢e = f.a.RIGHT;
                while (i10 < aVar.W0) {
                    c2.e eVar4 = aVar.V0[i10];
                    if (y12 || eVar4.X() != 8) {
                        f fVar3 = eVar4.f٥٧٠٩e.f١٣٦٢٩i;
                        fVar3.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
                        this.f١٣٦٢٨h.f١٣٥٧٩l.add(fVar3);
                    }
                    i10++;
                }
                q(this.f١٣٦٢٢b.f٥٧٠٩e.f١٣٦٢٨h);
                q(this.f١٣٦٢٢b.f٥٧٠٩e.f١٣٦٢٩i);
                return;
            }
            this.f١٣٦٢٨h.f١٣٥٧٢e = f.a.LEFT;
            while (i10 < aVar.W0) {
                c2.e eVar5 = aVar.V0[i10];
                if (y12 || eVar5.X() != 8) {
                    f fVar4 = eVar5.f٥٧٠٩e.f١٣٦٢٨h;
                    fVar4.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
                    this.f١٣٦٢٨h.f١٣٥٧٩l.add(fVar4);
                }
                i10++;
            }
            q(this.f١٣٦٢٢b.f٥٧٠٩e.f١٣٦٢٨h);
            q(this.f١٣٦٢٢b.f٥٧٠٩e.f١٣٦٢٩i);
        }
    }

    @Override // d2.p
    public void e() {
        c2.e eVar = this.f١٣٦٢٢b;
        if (eVar instanceof c2.a) {
            int z12 = ((c2.a) eVar).z1();
            if (z12 != 0 && z12 != 1) {
                this.f١٣٦٢٢b.r1(this.f١٣٦٢٨h.f١٣٥٧٤g);
            } else {
                this.f١٣٦٢٢b.q1(this.f١٣٦٢٨h.f١٣٥٧٤g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public void f() {
        this.f١٣٦٢٣c = null;
        this.f١٣٦٢٨h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public boolean m() {
        return false;
    }
}
