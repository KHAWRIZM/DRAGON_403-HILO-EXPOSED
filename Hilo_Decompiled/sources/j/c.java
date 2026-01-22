package j;

import org.json.JSONException;
import org.json.JSONObject;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c implements a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٤٩٨٤a;

    public c(d dVar) {
        this.f١٤٩٨٤a = dVar;
    }

    public final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            d.b(this.f١٤٩٨٤a, jSONObject.getInt("obj"), jSONObject.getString("cmd"), jSONObject.optJSONObject("data"));
        } catch (JSONException e10) {
            o.b.c("WXGame", "ObjMsg:" + e10.getMessage());
        }
    }
}
