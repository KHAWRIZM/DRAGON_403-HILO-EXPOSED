package pf;

import android.view.View;
import org.json.JSONObject;
import tech.sud.gip.core.ISudCfg;
import tech.sud.gip.core.SudGIP;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class b implements d1.c {
    public final /* synthetic */ u a;

    public b(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        g1.h hVar;
        q0.a aVar2 = this.a.m;
        if (aVar2 != null && !"true".equals(SudGIP.getCfg().getAdvancedConfigMap().get(ISudCfg.BLOCK_COMMON_GAME_RELOAD))) {
            q0.c cVar = aVar2.b;
            g1.h hVar2 = cVar.m;
            if (hVar2 instanceof g1.h) {
                hVar = hVar2;
            } else {
                hVar = null;
            }
            if (hVar == null) {
                return;
            }
            cVar.a();
            cVar.j = false;
            cVar.i = false;
            s0.e eVar = new s0.e(cVar.b);
            cVar.p = eVar;
            View view = eVar.f;
            cVar.q = view;
            ((s0.l) eVar).a = cVar.s;
            cVar.n.addView(view);
            cVar.p.f(cVar.g.bigLoadingPic);
            cVar.p.b(3, (JSONObject) null);
            hVar.c(cVar.x, cVar.y);
            return;
        }
        this.a.a(str, str2, str3, str4, aVar);
    }
}
