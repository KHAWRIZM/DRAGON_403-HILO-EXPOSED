package nf;

import com.taobao.accs.common.Constants;
import mf.c;
import org.json.JSONException;
import org.json.JSONObject;
import re.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public abstract class a {
    public static d a(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                d dVar = new d();
                dVar.a = jSONObject.getLong("mgId");
                dVar.b = jSONObject.getString(Constants.SP_KEY_VERSION);
                dVar.c = jSONObject.getString("url");
                dVar.d = jSONObject.getString("fNameMd5");
                dVar.e = jSONObject.getInt("fTotalSize");
                dVar.f = jSONObject.getLong("lastUseTimestamp");
                return dVar;
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static c b(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                c cVar = new c();
                cVar.a = jSONObject.getLong("mgId");
                cVar.b = jSONObject.getString("fGamePackageMd5");
                return cVar;
            } catch (JSONException unused) {
            }
        }
        return null;
    }
}
