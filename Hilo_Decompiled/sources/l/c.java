package l;

import j.t;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c extends t {
    public final void g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", "没有广告模块");
            jSONObject.put("errCode", 1008);
        } catch (JSONException unused) {
        }
        f("_error", jSONObject);
    }
}
