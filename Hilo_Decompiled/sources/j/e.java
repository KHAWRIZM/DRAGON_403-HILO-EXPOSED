package j;

import org.json.JSONException;
import org.json.JSONObject;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e implements a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٥٠١٢a;

    public e(d dVar) {
        this.f١٥٠١٢a = dVar;
    }

    public final void a(String str) {
        try {
            int i10 = new JSONObject(str).getInt("obj");
            d dVar = this.f١٥٠١٢a;
            t tVar = (t) dVar.f١٤٩٨٩d.get(i10);
            if (tVar == null) {
                o.b.c("WXGame", String.format("objectDestroy: obj %d not found", Integer.valueOf(i10)));
            } else {
                dVar.f١٤٩٨٩d.remove(i10);
                tVar.d();
            }
        } catch (JSONException e10) {
            o.b.c("WXGame", "ObjDestroy:" + e10.getMessage());
        }
    }
}
