package pf;

import android.os.Vibrator;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class k implements d1.c {
    public final /* synthetic */ u a;

    public k(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        try {
            ((Vibrator) this.a.b.getSystemService("vibrator")).vibrate(new JSONObject(str4).getLong("milliseconds"));
            aVar.success("{\"ret_code\":0, \"ret_msg\":\"success\"}");
        } catch (Exception unused) {
            aVar.failure("{\"ret_code\":-1, \"ret_msg\":\"json serialize fail\"}");
        }
    }
}
