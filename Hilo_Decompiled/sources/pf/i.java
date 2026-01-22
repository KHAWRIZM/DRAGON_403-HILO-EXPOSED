package pf;

import org.json.JSONObject;
import tech.sud.gip.core.ISudFSMMG;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class i implements d1.c {
    public final /* synthetic */ u a;

    public i(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        n1.b bVar;
        q0.a aVar2 = this.a.m;
        if (aVar2 != null && (bVar = aVar2.b.B) != null) {
            try {
                JSONObject jSONObject = new JSONObject(str4);
                String optString = jSONObject.optString("uid");
                String optString2 = jSONObject.optString("name");
                jSONObject.optString("avatar");
                bVar.d = optString;
                bVar.e = optString2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ISudFSMMG iSudFSMMG = (ISudFSMMG) this.a.c.get();
        if (iSudFSMMG != null) {
            iSudFSMMG.onGameStateChange(aVar, "mg_common_game_player_self_info", str4);
        }
    }
}
