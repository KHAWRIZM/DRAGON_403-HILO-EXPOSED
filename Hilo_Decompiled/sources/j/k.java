package j;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class k extends t {
    @Override // j.t
    public final void e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", "fail: invalid param");
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        f("fail", jSONObject);
    }

    @Override // j.t
    public final void d() {
    }
}
