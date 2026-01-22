package c2;

import d2.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j extends e implements i {
    public e[] V0 = new e[4];
    public int W0 = 0;

    @Override // c2.i
    public void a(e eVar) {
        if (eVar != this && eVar != null) {
            int i10 = this.W0 + 1;
            e[] eVarArr = this.V0;
            if (i10 > eVarArr.length) {
                this.V0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
            }
            e[] eVarArr2 = this.V0;
            int i11 = this.W0;
            eVarArr2[i11] = eVar;
            this.W0 = i11 + 1;
        }
    }

    @Override // c2.i
    public void c() {
        this.W0 = 0;
        Arrays.fill(this.V0, (Object) null);
    }

    @Override // c2.e
    public void n(e eVar, HashMap hashMap) {
        super.n(eVar, hashMap);
        j jVar = (j) eVar;
        this.W0 = 0;
        int i10 = jVar.W0;
        for (int i11 = 0; i11 < i10; i11++) {
            a((e) hashMap.get(jVar.V0[i11]));
        }
    }

    public void v1(ArrayList arrayList, int i10, o oVar) {
        for (int i11 = 0; i11 < this.W0; i11++) {
            oVar.a(this.V0[i11]);
        }
        for (int i12 = 0; i12 < this.W0; i12++) {
            d2.i.a(this.V0[i12], i10, arrayList, oVar);
        }
    }

    public int w1(int i10) {
        int i11;
        int i12;
        for (int i13 = 0; i13 < this.W0; i13++) {
            e eVar = this.V0[i13];
            if (i10 == 0 && (i12 = eVar.S0) != -1) {
                return i12;
            }
            if (i10 == 1 && (i11 = eVar.T0) != -1) {
                return i11;
            }
        }
        return -1;
    }

    @Override // c2.i
    public void b(f fVar) {
    }
}
