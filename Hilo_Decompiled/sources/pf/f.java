package pf;

import tech.sud.gip.core.ISudFSMMG;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class f implements d1.c {
    public final /* synthetic */ u a;

    public f(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        k1.c cVar = new k1.c();
        cVar.a = "getGameCfg";
        cVar.b = System.currentTimeMillis();
        this.a.b(cVar);
        ISudFSMMG iSudFSMMG = (ISudFSMMG) this.a.c.get();
        if (iSudFSMMG != null) {
            SudLogger.i(u.n, "onGetGameCfg");
            LogUtils.file("SudFSMMGStateHandlerImpl", "onGetGameCfg");
            iSudFSMMG.onGetGameCfg(new s(this.a, aVar, cVar), str4);
        }
    }
}
