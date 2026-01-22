package pf;

import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class r implements d1.c {
    public final /* synthetic */ u a;

    public r(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        String str5;
        d.o oVar;
        d.k kVar;
        d.k kVar2;
        k1.c cVar = new k1.c();
        cVar.a = "getSdkInfo";
        cVar.b = System.currentTimeMillis();
        this.a.b(cVar);
        u uVar = this.a;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret_code", 0);
            jSONObject.put("ret_msg", com.taobao.agoo.a.a.b.JSON_SUCCESS);
            jSONObject.put("env_type", e.d.f);
            jSONObject.put("language", e.d.d);
            jSONObject.put("wordLanguage", "");
            jSONObject.put("asr_text_language_list", c1.a.c());
            jSONObject.put("asr_number_language_list", c1.a.a());
            jSONObject.put("sdk_version", "1.6.6.1277");
            jSONObject.put("app_id", e.d.g);
            jSONObject.put("platform", 2);
            jSONObject.put("bundle_id", e.d.d());
            jSONObject.put("sud_sdk_trace_id", e.d.j);
            jSONObject.put("mg_id", uVar.g);
            jSONObject.put("mg_id_str", String.valueOf(uVar.g));
            d.p pVar = e.d.e;
            if (pVar == null || (kVar2 = pVar.c) == null || (str5 = kVar2.h) == null) {
                str5 = "";
            }
            jSONObject.put("mg_api_cfg", new JSONObject(str5));
            jSONObject.put("dynamic_config", new JSONObject(uVar.h));
            jSONObject.put("app_auth", new JSONObject(uVar.i));
            d.p pVar2 = e.d.e;
            if (pVar2 != null && (kVar = pVar2.c) != null) {
                oVar = kVar.f;
            } else {
                oVar = null;
            }
            if (oVar != null) {
                jSONObject.put("app_server_info_url", oVar.b);
                jSONObject.put("game_login_url", oVar.a);
            } else {
                jSONObject.put("app_server_info_url", "");
                jSONObject.put("game_login_url", "");
            }
            aVar.success(jSONObject.toString());
            long currentTimeMillis = System.currentTimeMillis();
            cVar.c = currentTimeMillis;
            cVar.d = currentTimeMillis - cVar.b;
            uVar.b(cVar);
        } catch (Exception unused) {
            aVar.failure("{\"ret_code\":-1, \"ret_msg\":\"json serialize fail\"}");
            long currentTimeMillis2 = System.currentTimeMillis();
            cVar.c = currentTimeMillis2;
            cVar.d = currentTimeMillis2 - cVar.b;
            uVar.b(cVar);
        }
    }
}
