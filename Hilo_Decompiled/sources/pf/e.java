package pf;

import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class e implements d1.c {
    public final /* synthetic */ u a;

    public e(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        q0.a aVar2 = this.a.m;
        if (aVar2 != null) {
            q0.i iVar = new q0.i(aVar2);
            q0.c cVar = aVar2.b;
            if (cVar.z == null) {
                cVar.z = new ArrayList();
            }
            cVar.z.add(iVar);
            c0.c.c(str4, iVar);
        }
        aVar.success("{\"ret_code\":0, \"ret_msg\":\"success\"}");
    }
}
