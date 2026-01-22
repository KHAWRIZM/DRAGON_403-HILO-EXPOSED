package c2;

import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class n extends e {
    public ArrayList V0 = new ArrayList();

    public void a(e eVar) {
        this.V0.add(eVar);
        if (eVar.M() != null) {
            ((n) eVar.M()).x1(eVar);
        }
        eVar.g1(this);
    }

    @Override // c2.e
    public void v0() {
        this.V0.clear();
        super.v0();
    }

    public ArrayList v1() {
        return this.V0;
    }

    public abstract void w1();

    public void x1(e eVar) {
        this.V0.remove(eVar);
        eVar.v0();
    }

    public void y1() {
        this.V0.clear();
    }

    @Override // c2.e
    public void z0(z1.c cVar) {
        super.z0(cVar);
        int size = this.V0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((e) this.V0.get(i10)).z0(cVar);
        }
    }
}
