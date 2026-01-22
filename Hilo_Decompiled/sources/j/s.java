package j;

import org.json.JSONException;
import org.json.JSONObject;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class s implements a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٥٠٣٧a;

    public s(d dVar) {
        this.f١٥٠٣٧a = dVar;
    }

    public final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            d.c(this.f١٥٠٣٧a, jSONObject.getString("type"), jSONObject.getInt("obj"), jSONObject.optJSONObject("data"));
        } catch (JSONException e10) {
            o.b.c("WXGame", "ObjCreate:" + e10.getMessage());
        }
    }
}
