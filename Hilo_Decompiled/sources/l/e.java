package l;

import j.r;
import j.t;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e extends r {
    @Override // j.r
    public final t a(JSONObject jSONObject) {
        try {
            jSONObject.getString("adUnitId");
            return new f();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
