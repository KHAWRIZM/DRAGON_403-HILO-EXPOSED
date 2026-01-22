package c2;

import c2.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    static boolean[] f٥٨٢٤a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(f fVar, z1.d dVar, e eVar) {
        eVar.f٥٧٣٩t = -1;
        eVar.f٥٧٤١u = -1;
        e.b bVar = fVar.f٥٧٠٤b0[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.f٥٧٠٤b0[0] == e.b.MATCH_PARENT) {
            int i10 = eVar.Q.f٥٦٨٦g;
            int Y = fVar.Y() - eVar.S.f٥٦٨٦g;
            d dVar2 = eVar.Q;
            dVar2.f٥٦٨٨i = dVar.q(dVar2);
            d dVar3 = eVar.S;
            dVar3.f٥٦٨٨i = dVar.q(dVar3);
            dVar.f(eVar.Q.f٥٦٨٨i, i10);
            dVar.f(eVar.S.f٥٦٨٨i, Y);
            eVar.f٥٧٣٩t = 2;
            eVar.S0(i10, Y);
        }
        if (fVar.f٥٧٠٤b0[1] != bVar2 && eVar.f٥٧٠٤b0[1] == e.b.MATCH_PARENT) {
            int i11 = eVar.R.f٥٦٨٦g;
            int z10 = fVar.z() - eVar.T.f٥٦٨٦g;
            d dVar4 = eVar.R;
            dVar4.f٥٦٨٨i = dVar.q(dVar4);
            d dVar5 = eVar.T;
            dVar5.f٥٦٨٨i = dVar.q(dVar5);
            dVar.f(eVar.R.f٥٦٨٨i, i11);
            dVar.f(eVar.T.f٥٦٨٨i, z10);
            if (eVar.f٥٧٢٨n0 > 0 || eVar.X() == 8) {
                d dVar6 = eVar.U;
                dVar6.f٥٦٨٨i = dVar.q(dVar6);
                dVar.f(eVar.U.f٥٦٨٨i, eVar.f٥٧٢٨n0 + i11);
            }
            eVar.f٥٧٤١u = 2;
            eVar.j1(i11, z10);
        }
    }

    public static final boolean b(int i10, int i11) {
        if ((i10 & i11) == i11) {
            return true;
        }
        return false;
    }
}
