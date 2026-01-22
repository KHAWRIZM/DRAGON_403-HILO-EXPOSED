package pf;

import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class l implements d1.c {
    public final /* synthetic */ u a;

    public l(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        if (this.a.m != null) {
            LogUtils.file("ProxySudFSTAPPImpl", "onGameLoadStarted");
            SudLogger.d(q0.c.F, "onGameLoadStarted");
        }
        aVar.success("{\"ret_code\":0, \"ret_msg\":\"success\"}");
    }
}
