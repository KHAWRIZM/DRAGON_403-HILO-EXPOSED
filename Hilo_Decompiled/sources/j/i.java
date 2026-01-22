package j;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i implements a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٥٠١٥a;

    public i(d dVar) {
        this.f١٥٠١٥a = dVar;
    }

    public final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getString("cmd");
            int i10 = jSONObject.getInt("id");
            JSONArray jSONArray = jSONObject.getJSONArray("ret");
            d dVar = this.f١٥٠١٥a;
            z zVar = (z) dVar.f١٤٩٩١f.get(i10);
            if (zVar != null) {
                dVar.f١٤٩٩١f.remove(i10);
                zVar.a(jSONArray);
            }
        } catch (JSONException e10) {
            o.b.c("WXGame", "Callback:" + e10.getMessage());
        }
    }
}
