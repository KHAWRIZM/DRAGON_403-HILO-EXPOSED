package pf;

import android.text.TextUtils;
import org.json.JSONObject;
import tech.sud.gip.core.ISudFSMMG;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class t implements d1.c {
    public final /* synthetic */ u a;

    public t(u uVar) {
        this.a = uVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        a1.d dVar;
        q0.a aVar2 = this.a.m;
        if (aVar2 != null) {
            if (!TextUtils.isEmpty(str4)) {
                dVar = new a1.d();
                try {
                    dVar.a = new JSONObject(str4).getBoolean("isOpen");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (dVar != null) {
                    if (dVar.a) {
                        q0.c cVar = aVar2.b;
                        y0.b bVar = new y0.b(cVar);
                        cVar.E = bVar;
                        n1.b bVar2 = cVar.B;
                        if (bVar2 != null) {
                            bVar2.o = bVar;
                        }
                    } else {
                        q0.c cVar2 = aVar2.b;
                        cVar2.E = null;
                        n1.b bVar3 = cVar2.B;
                        if (bVar3 != null) {
                            bVar3.o = null;
                        }
                    }
                }
            }
            dVar = null;
            if (dVar != null) {
            }
        }
        ISudFSMMG iSudFSMMG = (ISudFSMMG) this.a.c.get();
        if (iSudFSMMG != null) {
            iSudFSMMG.onGameStateChange(aVar, "mg_common_game_llm_asr", str4);
        }
    }
}
