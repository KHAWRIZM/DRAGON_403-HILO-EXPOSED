package pf;

import tech.sud.gip.core.ISudFSMMG;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class q implements d1.c {
    public final /* synthetic */ u a;

    public q(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        ISudFSMMG iSudFSMMG = (ISudFSMMG) this.a.c.get();
        if (iSudFSMMG != null) {
            LogUtils.file("SudFSMMGStateHandlerImpl", "onGameStarted");
            SudLogger.i(u.n, "onGameStarted");
            iSudFSMMG.onGameStarted();
        }
        aVar.success("{\"ret_code\":0, \"ret_msg\":\"success\"}");
    }
}
