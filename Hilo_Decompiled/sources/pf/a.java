package pf;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class a implements d1.c {
    public final /* synthetic */ u a;

    public a(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        c.d dVar = c.d.f;
        Context context = this.a.b;
        dVar.getClass();
        int a = c.d.a(context);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret_code", 0);
            jSONObject.put("ret_msg", com.taobao.agoo.a.a.b.JSON_SUCCESS);
            jSONObject.put("net_type", a);
            aVar.success(jSONObject.toString());
        } catch (Exception e) {
            aVar.failure(d.a.b(e.toString()));
        }
    }
}
