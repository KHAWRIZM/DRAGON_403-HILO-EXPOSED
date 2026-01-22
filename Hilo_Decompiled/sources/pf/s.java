package pf;

import tech.sud.gip.core.ISudFSMStateHandle;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class s implements ISudFSMStateHandle {
    public final g1.a a;
    public final k1.c b;
    public final /* synthetic */ u c;

    public s(u uVar, g1.a aVar, k1.c cVar) {
        this.c = uVar;
        this.a = aVar;
        this.b = cVar;
    }

    @Override // tech.sud.gip.core.ISudFSMStateHandle
    public final void failure(String str) {
        this.a.failure(str);
        k1.c cVar = this.b;
        long currentTimeMillis = System.currentTimeMillis();
        cVar.c = currentTimeMillis;
        cVar.d = currentTimeMillis - cVar.b;
        this.c.b(this.b);
    }

    @Override // tech.sud.gip.core.ISudFSMStateHandle
    public final void success(String str) {
        this.a.success(str);
        k1.c cVar = this.b;
        long currentTimeMillis = System.currentTimeMillis();
        cVar.c = currentTimeMillis;
        cVar.d = currentTimeMillis - cVar.b;
        this.c.b(this.b);
    }
}
