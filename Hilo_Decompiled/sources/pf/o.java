package pf;

import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class o implements d1.c {
    public final /* synthetic */ u a;

    public o(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        q0.a aVar2 = this.a.m;
        if (aVar2 != null) {
            LogUtils.file("ProxySudFSTAPPImpl", "onGameLoadCompleted");
            SudLogger.d(q0.c.F, "onGameLoadCompleted");
            y0.e eVar = aVar2.b.w;
            eVar.h = true;
            eVar.j.stop();
            eVar.k.stop();
            eVar.l.stop();
            eVar.a();
            f.a aVar3 = eVar.a;
            if (aVar3 != null) {
                aVar3.e = 0;
            }
            if (aVar3 != null) {
                aVar3.f = com.taobao.agoo.a.a.b.JSON_SUCCESS;
            }
            eVar.h();
            aVar2.b.a();
            q0.c cVar = aVar2.b;
            if (!cVar.j) {
                cVar.j = true;
                cVar.b(3, 0, 100, false);
            }
        }
        aVar.success("{\"ret_code\":0, \"ret_msg\":\"success\"}");
    }
}
