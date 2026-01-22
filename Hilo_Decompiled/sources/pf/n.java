package pf;

import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class n implements d1.c {
    public final /* synthetic */ u a;

    public n(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        try {
            String str5 = (String) this.a.l.get(new JSONObject(str4).getString("state"));
            if (str5 == null) {
                str5 = "{}";
            }
            aVar.success(str5);
        } catch (Exception unused) {
            aVar.failure("{\"ret_code\":-1, \"ret_msg\":\"json serialize fail\"}");
        }
    }
}
