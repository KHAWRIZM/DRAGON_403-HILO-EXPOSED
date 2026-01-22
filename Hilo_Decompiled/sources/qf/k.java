package qf;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
import tech.sud.gip.logger.SudLogger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class k implements Runnable {
    public final /* synthetic */ x a;

    public k(x xVar) {
        this.a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.a;
        d0.a a = d0.a.a("reportEvent.sp");
        Map<String, ?> all = a.a.getAll();
        if (all != null && all.size() != 0) {
            for (String str : all.keySet()) {
                String string = a.a.getString(str, "");
                if (TextUtils.isEmpty(string)) {
                    a.d(str);
                } else {
                    try {
                        int i = new JSONObject(x.b(xVar.h, string, new JSONObject(string).getString("request_id"), new wf.e(), null, null)).getInt("ret_code");
                        if (i != 0) {
                            SudLogger.e(x.p, "reportStats server errcode=" + i);
                        }
                        a.d(str);
                        if (fd.e.a) {
                            fd.d.a.execute(new fd.b());
                        } else {
                            ExecutorService executorService = fd.d.a;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
