package s0;

import android.view.View;
import org.json.JSONObject;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class t implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f١٧٥٩٩a;

    public t(e eVar) {
        this.f١٧٥٩٩a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        q0.e eVar = this.f١٧٥٩٩a.f١٧٥٨٥a;
        eVar.getClass();
        LogUtils.file("ProxySudFSTAPPImpl", "onClickTimeoutReload");
        q0.c cVar = eVar.f١٧٠٧٨a;
        e eVar2 = cVar.f١٧٠٦٦p;
        if (eVar2 != null) {
            int i10 = eVar2.f١٧٥٤٧d;
            if (i10 == 80) {
                eVar2.a();
                eVar.f١٧٠٧٨a.f١٧٠٦٦p.h();
            } else if (i10 > 80 && cVar.f١٧٠٦٣m != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("onClickTimeoutReload", 1);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                eVar.f١٧٠٧٨a.f١٧٠٦٦p.b(3, jSONObject);
                q0.c cVar2 = eVar.f١٧٠٧٨a;
                cVar2.f١٧٠٦٣m.c(cVar2.f١٧٠٧٤x, cVar2.f١٧٠٧٥y);
            }
        }
        y0.e eVar3 = eVar.f١٧٠٧٨a.f١٧٠٧٣w;
        eVar3.getClass();
        LogUtils.file("LoadGameStatsManager", "onClickTimeoutReload");
        eVar3.e(true);
    }
}
