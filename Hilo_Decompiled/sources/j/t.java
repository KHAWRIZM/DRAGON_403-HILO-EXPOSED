package j;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public int f١٥٠٣٨a;

    /* renamed from: b, reason: collision with root package name */
    public d f١٥٠٣٩b;

    public abstract void a();

    public boolean c(String str, JSONObject jSONObject) {
        return false;
    }

    public abstract void d();

    public final void f(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("obj", this.f١٥٠٣٨a);
            jSONObject2.put("cmd", str);
            if (jSONObject != null) {
                jSONObject2.put("data", jSONObject);
            }
            v vVar = this.f١٥٠٣٩b.f١٤٩٨٦a;
            if (vVar != null) {
                String jSONObject3 = jSONObject2.toString();
                tech.sud.runtime.a.c cVar = vVar.f١٥٠٤٩c;
                if (cVar != null) {
                    cVar.a("RTObjMsg", jSONObject3);
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void e() {
    }

    public void b(JSONObject jSONObject) {
    }
}
