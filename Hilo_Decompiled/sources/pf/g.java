package pf;

import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class g implements d1.c {
    public final /* synthetic */ u a;

    public g(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret_code", 0);
            jSONObject.put("ret_msg", com.taobao.agoo.a.a.b.JSON_SUCCESS);
            jSONObject.put("user_id", this.a.d);
            jSONObject.put(GameMatchActivity.ROOM_ID, this.a.e);
            jSONObject.put("mg_id", this.a.g);
            jSONObject.put("mg_id_str", String.valueOf(this.a.g));
            jSONObject.put(Constants.KEY_HTTP_CODE, this.a.f);
            jSONObject.put("app_id", e.d.g);
            jSONObject.put("platform", 2);
            jSONObject.put("bundle_id", e.d.d());
            jSONObject.put("sud_sdk_trace_id", e.d.j);
            aVar.success(jSONObject.toString());
        } catch (Exception unused) {
            aVar.failure("{\"ret_code\":-1, \"ret_msg\":\"json serialize fail\"}");
        }
    }
}
