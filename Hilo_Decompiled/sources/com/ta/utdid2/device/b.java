package com.ta.utdid2.device;

import com.ta.a.c.f;
import com.taobao.accs.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class b {
    int d = -1;

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(int i) {
        return i >= 0 && i != 10012;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(String str) {
        JSONObject jSONObject;
        b bVar = new b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has(Constants.KEY_HTTP_CODE)) {
                bVar.d = jSONObject2.getInt(Constants.KEY_HTTP_CODE);
            }
            if (jSONObject2.has("data") && (jSONObject = jSONObject2.getJSONObject("data")) != null && jSONObject.has("utdid")) {
                String string = jSONObject.getString("utdid");
                if (d.m١٣٠c(string)) {
                    com.ta.a.b.e.a(string);
                }
            }
            f.m١٢٧a("BizResponse", "content", str);
        } catch (JSONException e) {
            f.m١٢٧a("", e.toString());
        }
        return bVar;
    }
}
