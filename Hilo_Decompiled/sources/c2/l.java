package c2;

import c2.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class l extends m {
    @Override // c2.m
    public void G1(int i10, int i11, int i12, int i13) {
        int D1 = D1() + E1();
        int F1 = F1() + C1();
        boolean z10 = false;
        if (this.W0 > 0) {
            D1 += this.V0[0].Y();
            F1 += this.V0[0].z();
        }
        int max = Math.max(K(), D1);
        int max2 = Math.max(J(), F1);
        if (i10 != 1073741824) {
            if (i10 == Integer.MIN_VALUE) {
                i11 = Math.min(max, i11);
            } else if (i10 == 0) {
                i11 = max;
            } else {
                i11 = 0;
            }
        }
        if (i12 != 1073741824) {
            if (i12 == Integer.MIN_VALUE) {
                i13 = Math.min(max2, i13);
            } else if (i12 == 0) {
                i13 = max2;
            } else {
                i13 = 0;
            }
        }
        L1(i11, i13);
        o1(i11);
        P0(i13);
        if (this.W0 > 0) {
            z10 = true;
        }
        K1(z10);
    }

    @Override // c2.e
    public void g(z1.d dVar, boolean z10) {
        super.g(dVar, z10);
        if (this.W0 > 0) {
            e eVar = this.V0[0];
            eVar.w0();
            d.b bVar = d.b.LEFT;
            eVar.j(bVar, this, bVar);
            d.b bVar2 = d.b.RIGHT;
            eVar.j(bVar2, this, bVar2);
            d.b bVar3 = d.b.TOP;
            eVar.j(bVar3, this, bVar3);
            d.b bVar4 = d.b.BOTTOM;
            eVar.j(bVar4, this, bVar4);
        }
    }
}
