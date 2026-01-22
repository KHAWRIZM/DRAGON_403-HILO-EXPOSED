package pf;

import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class p implements d1.c {
    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        try {
            d1.a.a = new JSONObject(str4).getBoolean("debug");
            aVar.success("{\"ret_code\":0, \"ret_msg\":\"success\"}");
        } catch (Exception unused) {
            aVar.failure("{\"ret_code\":-1, \"ret_msg\":\"json serialize fail\"}");
        }
    }
}
