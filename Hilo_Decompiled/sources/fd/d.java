package fd;

import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class d {
    public static final ExecutorService a = Executors.newSingleThreadExecutor();

    public static void a() {
        String string = d0.a.a("TechSudMGPGlobal.sp").a.getString("key_upload_anr_log_info", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            b(jSONObject.getLong("mgId"), 1, jSONObject.getString("logId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(long j, int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        k1.e eVar = new k1.e();
        eVar.a = e.d.g;
        eVar.b = j;
        eVar.c = str;
        eVar.d = e.d.f();
        eVar.e = i;
        a.execute(new f(eVar));
    }
}
