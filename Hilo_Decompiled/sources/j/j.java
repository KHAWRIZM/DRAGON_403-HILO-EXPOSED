package j;

import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j extends r {

    /* renamed from: a, reason: collision with root package name */
    public final Class f١٥٠١٦a;

    public j(Class cls) {
        this.f١٥٠١٦a = cls;
    }

    @Override // j.r
    public t a(JSONObject jSONObject) {
        try {
            return (t) this.f١٥٠١٦a.newInstance();
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return null;
        } catch (InstantiationException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
