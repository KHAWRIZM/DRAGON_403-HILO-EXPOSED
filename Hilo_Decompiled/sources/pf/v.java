package pf;

import android.widget.TextView;
import java.util.Locale;
import org.json.JSONObject;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class v implements d1.c {
    public final /* synthetic */ u a;

    public v(u uVar) {
        this.a = uVar;
    }

    public final void a(String str, String str2, String str3, String str4, g1.a aVar) {
        q0.a aVar2 = this.a.m;
        if (aVar2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str4);
                int i = jSONObject.getInt("percent");
                s0.e eVar = aVar2.b.p;
                int i2 = 0;
                if (eVar != null) {
                    TextView textView = eVar.k;
                    Locale locale = Locale.US;
                    textView.setText(i + "/100");
                    eVar.c = 85;
                    eVar.d((long) i, 100L, 15, 100);
                    q0.c cVar = aVar2.b;
                    cVar.l = true;
                    y0.e eVar2 = cVar.w;
                    eVar2.getClass();
                    LogUtils.file("LoadGameStatsManager", "onGameLoadPercent");
                    eVar2.q = true;
                    eVar2.r = true;
                    eVar2.g = false;
                    eVar2.e(true);
                }
                int i3 = (int) ((i * 15) / 100);
                if (i3 >= 0) {
                    i2 = i3;
                }
                int i4 = i2 + 85;
                if (i == 0) {
                    aVar2.b.w.d("loadGameRuntime", i4, jSONObject);
                } else {
                    aVar2.b.w.d("loadGamePercent", i4, jSONObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        aVar.success("{\"ret_code\":0, \"ret_msg\":\"success\"}");
    }
}
