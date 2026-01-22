package pf;

import tech.sud.gip.core.ISudFSMMG;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class w implements d1.c {
    public final /* synthetic */ u a;

    public w(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        try {
            ISudFSMMG iSudFSMMG = (ISudFSMMG) this.a.c.get();
            if (iSudFSMMG != null) {
                iSudFSMMG.onGameLog(str4);
            }
            aVar.success("{\"ret_code\":0, \"ret_msg\":\"success\"}");
        } catch (Exception unused) {
            aVar.failure("{\"ret_code\":-1, \"ret_msg\":\"json serialize fail\"}");
        }
    }
}
