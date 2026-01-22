package l;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import j.r;
import j.t;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b extends r {
    @Override // j.r
    public final t a(JSONObject jSONObject) {
        try {
            jSONObject.getString("adUnitId");
            JSONObject jSONObject2 = jSONObject.getJSONObject("style");
            jSONObject2.optInt(ViewHierarchyConstants.DIMENSION_LEFT_KEY);
            jSONObject2.optInt(ViewHierarchyConstants.DIMENSION_TOP_KEY);
            jSONObject2.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            jSONObject2.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            return new d();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
