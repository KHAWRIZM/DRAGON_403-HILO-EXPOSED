package qf;

import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.ISudCfg;
import tech.sud.gip.core.TccRtssCfg;
import tech.sud.gip.core.model.VolcCfg;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class j implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ String e;
    public final /* synthetic */ x f;

    public j(x xVar, String str, String str2, String str3, boolean z, String str4) {
        this.f = xVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a aVar;
        f.a aVar2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        d.n nVar;
        HashMap hashMap;
        Iterator<String> keys;
        d.p pVar = new d.p();
        f.a aVar3 = new f.a("getSDKToken");
        wf.e eVar = new wf.e();
        aVar3.n = eVar;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("app_id", this.a);
            jSONObject3.put("app_key", this.b);
            jSONObject3.put("bundle_id", this.c);
            String str = e.d.a;
            jSONObject3.put("platform", 2);
            jSONObject3.put("is_test_env", this.d);
            jSONObject3.put("sdk_version", "1.6.6.1277");
            jSONObject3.put("unity_dynamic_lib_type", "ilruntime-2022.3.62f2c1-1.0.7");
            JSONObject jSONObject4 = new JSONObject(x.b(this.e, jSONObject3.toString(), aVar3.c, eVar, this.f.m, null));
            pVar.a = jSONObject4.getInt("ret_code");
            pVar.b = jSONObject4.getString("ret_msg");
            jSONObject = jSONObject4.getJSONObject("data");
            d.k kVar = new d.k();
            pVar.c = kVar;
            kVar.a = jSONObject.getString("sdk_token");
            JSONObject jSONObject5 = jSONObject.getJSONObject("sdk_rt_cfg");
            jSONObject5.getString(Constants.SP_KEY_VERSION);
            jSONObject5.getString(Constants.KEY_SECURITY_SIGN);
            jSONObject5.getString("sdk_min");
            jSONObject5.getString("key");
            jSONObject5.getString("url");
            jSONObject5.getString("desc");
            pVar.c.getClass();
            jSONObject2 = jSONObject.getJSONObject("sdk_sud_cfg");
            nVar = new d.n();
            nVar.a = jSONObject2.getString(Constants.SP_KEY_VERSION);
            jSONObject2.getString(Constants.KEY_SECURITY_SIGN);
            jSONObject2.getString("sdk_min");
            nVar.b = jSONObject2.getString("key");
            nVar.c = jSONObject2.getString("url_arm64_v8a");
            jSONObject2.getString("url_armeabi_v7a");
            jSONObject2.getString("url_x86");
            aVar = aVar3;
        } catch (Exception e) {
            e = e;
            aVar = aVar3;
        }
        try {
            jSONObject2.getString("url_x86_64");
            jSONObject2.getString("desc");
            pVar.c.b = nVar;
            JSONObject jSONObject6 = jSONObject.getJSONObject("sdk_et_cfg");
            jSONObject6.getString(Constants.SP_KEY_VERSION);
            jSONObject6.getString(Constants.KEY_SECURITY_SIGN);
            jSONObject6.getString("sdk_min");
            jSONObject6.getString("key");
            jSONObject6.getString("url_arm64_v8a");
            jSONObject6.getString("url_armeabi_v7a");
            jSONObject6.getString("url_x86");
            jSONObject6.getString("url_x86_64");
            jSONObject6.getString("desc");
            pVar.c.getClass();
            JSONObject jSONObject7 = jSONObject.getJSONObject("sdk_unity_cfg");
            d.n nVar2 = new d.n();
            nVar2.a = jSONObject7.getString(Constants.SP_KEY_VERSION);
            jSONObject7.getString(Constants.KEY_SECURITY_SIGN);
            jSONObject7.getString("sdk_min");
            nVar2.b = jSONObject7.getString("key");
            nVar2.c = jSONObject7.getString("url_arm64_v8a");
            jSONObject7.getString("url_armeabi_v7a");
            jSONObject7.getString("url_x86");
            jSONObject7.getString("url_x86_64");
            jSONObject7.getString("desc");
            pVar.c.c = nVar2;
            JSONObject jSONObject8 = jSONObject.getJSONObject("mg_api_cfg");
            d.o oVar = new d.o();
            oVar.b = jSONObject8.getString("app_server_info_url");
            oVar.a = jSONObject8.getString("game_login_url");
            d.k kVar2 = pVar.c;
            kVar2.f = oVar;
            kVar2.h = jSONObject8.toString();
            d.j jVar = new d.j();
            if (jSONObject.has("app_online_route_cfg")) {
                JSONObject jSONObject9 = jSONObject.getJSONObject("app_online_route_cfg");
                if (jSONObject9.has("online_route")) {
                    jVar.a = jSONObject9.getBoolean("online_route");
                }
            }
            pVar.c.g = jVar;
            JSONObject jSONObject10 = jSONObject.getJSONObject("sdk_api_cfg");
            d.e eVar2 = new d.e();
            eVar2.a = jSONObject10.getString("mg_list_url");
            eVar2.b = jSONObject10.getString("mg_info_url");
            if (jSONObject10.has("report_url")) {
                eVar2.c = jSONObject10.getString("report_url");
            }
            if (jSONObject10.has("auth_mg_info_url")) {
                eVar2.d = jSONObject10.getString("auth_mg_info_url");
            }
            eVar2.e = jSONObject10.optString("upload_url");
            pVar.c.d = eVar2;
            this.f.f = jSONObject10.optString("gate_token_url");
            eVar2.f = jSONObject10.optString("gate_ws_url");
            d.l lVar = new d.l();
            if (!jSONObject.isNull("sdk_rtss_cfg")) {
                JSONObject jSONObject11 = jSONObject.getJSONObject("sdk_rtss_cfg");
                JSONObject optJSONObject = jSONObject11.optJSONObject("microsoft_rtss_cfg");
                if (optJSONObject != null) {
                    d.i iVar = new d.i();
                    iVar.a = optJSONObject.optString("speech_subscription_key");
                    iVar.b = optJSONObject.optString("speech_region");
                    iVar.c = optJSONObject.optJSONArray("asr_text_language_list");
                    iVar.d = optJSONObject.optJSONArray("asr_number_language_list");
                    lVar.a = iVar;
                }
                JSONArray optJSONArray = jSONObject11.optJSONArray(ISudCfg.ASR_LOAD_LIST);
                if (optJSONArray != null) {
                    lVar.b = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        lVar.b.add(Integer.valueOf(optJSONArray.getInt(i)));
                    }
                }
                JSONObject optJSONObject2 = jSONObject11.optJSONObject("tcc_rtss_cfg");
                if (optJSONObject2 != null) {
                    TccRtssCfg tccRtssCfg = new TccRtssCfg();
                    tccRtssCfg.app_id = optJSONObject2.optInt("app_id");
                    tccRtssCfg.secret_id = optJSONObject2.optString("secret_id");
                    tccRtssCfg.secret_key = optJSONObject2.optString("secret_key");
                    tccRtssCfg.hotword_list = optJSONObject2.optString("hotword_list");
                    tccRtssCfg.hotword_id = optJSONObject2.optString("hotword_id");
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("engine_model_type");
                    if (optJSONObject3 != null && (keys = optJSONObject3.keys()) != null) {
                        hashMap = new HashMap();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, optJSONObject3.optString(next));
                        }
                        tccRtssCfg.engine_model_type = hashMap;
                        tccRtssCfg.asr_text_language_list = optJSONObject2.optJSONArray("asr_text_language_list");
                        tccRtssCfg.asr_number_language_list = optJSONObject2.optJSONArray("asr_number_language_list");
                        lVar.c = tccRtssCfg;
                    }
                    hashMap = null;
                    tccRtssCfg.engine_model_type = hashMap;
                    tccRtssCfg.asr_text_language_list = optJSONObject2.optJSONArray("asr_text_language_list");
                    tccRtssCfg.asr_number_language_list = optJSONObject2.optJSONArray("asr_number_language_list");
                    lVar.c = tccRtssCfg;
                }
            }
            pVar.c.e = lVar;
            JSONObject jSONObject12 = jSONObject.getJSONObject("sdk_localization_cfg");
            d.k kVar3 = pVar.c;
            d.g gVar = new d.g();
            kVar3.i = gVar;
            gVar.a = x.a(jSONObject12.getJSONObject("load_tip_loading"));
            pVar.c.i.b = x.a(jSONObject12.getJSONObject("load_tip_fail"));
            if (jSONObject12.has("load_tip_fail_upgrade")) {
                pVar.c.i.c = x.a(jSONObject12.getJSONObject("load_tip_fail_upgrade"));
            }
            pVar.c.i.d = x.a(jSONObject12.getJSONObject("load_reload"));
            pVar.c.i.e = x.a(jSONObject12.getJSONObject("load_tip_timeout"));
            pVar.c.i.f = x.a(jSONObject12.getJSONObject("load_tip_continue_wait"));
            pVar.c.j = jSONObject.getInt("load_mg_pkg_time_out");
            pVar.c.k = jSONObject.optBoolean("unity_multi_process");
            JSONObject optJSONObject4 = jSONObject.optJSONObject("console_log_cfg");
            if (optJSONObject4 != null) {
                d.k kVar4 = pVar.c;
                d.h hVar = new d.h();
                kVar4.l = hVar;
                hVar.a = optJSONObject4.optBoolean("is_open");
                pVar.c.l.b = optJSONObject4.optLong("max_size");
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("model_api_cfg");
            if (optJSONObject5 != null) {
                d.k kVar5 = pVar.c;
                d.b bVar = new d.b();
                kVar5.m = bVar;
                bVar.a = optJSONObject5.optString("ip_interaction_url");
                pVar.c.m.b = optJSONObject5.optString("ip_interaction_sse_url");
                pVar.c.m.c = optJSONObject5.optString("model_config_url");
                pVar.c.m.d = optJSONObject5.optString("room_message_url");
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("large_model_cfg");
            if (optJSONObject6 != null) {
                pVar.c.n = new d.m();
                optJSONObject6.optBoolean("enable");
                JSONObject optJSONObject7 = optJSONObject6.optJSONObject("volc");
                if (optJSONObject7 != null) {
                    pVar.c.n.a = new VolcCfg();
                    pVar.c.n.a.url = optJSONObject7.optString("url");
                    pVar.c.n.a.async_url = optJSONObject7.optString("async_url");
                    pVar.c.n.a.app_key = optJSONObject7.optString("app_key");
                    pVar.c.n.a.access_key = e.e.a(optJSONObject7.optString("access_key"));
                    pVar.c.n.a.resource_id = optJSONObject7.optString("resource_id");
                    pVar.c.n.a.model_name = optJSONObject7.optString("model_name");
                    pVar.c.n.a.languages = optJSONObject7.optJSONArray("languages");
                    pVar.c.n.a.request_config = optJSONObject7.optJSONObject("request_config");
                }
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("report_api_cfg");
            if (optJSONObject8 != null) {
                d.k kVar6 = pVar.c;
                d.c cVar = new d.c();
                kVar6.p = cVar;
                cVar.a = optJSONObject8.optString("report_llm_asr_url");
            }
            pVar.c.o = jSONObject.optString("log_id");
            fd.d.b(0L, 0, pVar.c.o);
            fd.d.a();
            aVar2 = aVar;
        } catch (Exception e2) {
            e = e2;
            if (pVar.a == 0) {
                pVar.a = d.a.a(e);
                pVar.b = e.toString();
            } else {
                SudLogger.e(x.p, "sdkToken error :" + pVar.b + "(" + pVar.a + ")");
            }
            aVar2 = aVar;
            aVar2.e = pVar.a;
            String str2 = pVar.b;
            if (str2 != null) {
                aVar2.f = str2;
            }
            String str3 = "sdkToken error :" + LogUtils.getErrorInfo(e);
            SudLogger.e(x.p, str3);
            LogUtils.file("HttpService", str3);
            ThreadUtils.postUITask(new g(this, pVar, aVar2));
        }
        ThreadUtils.postUITask(new g(this, pVar, aVar2));
    }
}
