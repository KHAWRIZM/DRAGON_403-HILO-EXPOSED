package qf;

import org.json.JSONObject;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.ISudListenerGetMGList;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ ISudListenerGetMGList b;
    public final /* synthetic */ x c;

    public b(x xVar, String str, ISudListenerGetMGList iSudListenerGetMGList) {
        this.c = xVar;
        this.a = str;
        this.b = iSudListenerGetMGList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        String str;
        int i;
        JSONObject jSONObject;
        f.a aVar = new f.a("getMGList");
        wf.e eVar = new wf.e();
        aVar.n = eVar;
        String str2 = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdk_token", this.a);
            String str3 = e.d.a;
            jSONObject2.put("platform", 2);
            str = x.b(this.c.d, jSONObject2.toString(), aVar.c, eVar, null, null);
        } catch (Exception e) {
            e = e;
            str = null;
        }
        try {
            jSONObject = new JSONObject(str);
            i = jSONObject.getInt("ret_code");
        } catch (Exception e2) {
            e = e2;
            i = 0;
            String str4 = "mgList error :" + LogUtils.getErrorInfo(e);
            SudLogger.e(x.p, str4);
            LogUtils.file("HttpService", str4);
            if (i == 0) {
                i = d.a.a(e);
                str2 = e.toString();
            }
            aVar.e = i;
            if (str2 != null) {
            }
            ThreadUtils.postUITask(new f.b(aVar.toString(), false, aVar.a, i));
            x xVar = this.c;
            y yVar = new y(this, i, str, str2);
            xVar.getClass();
            ThreadUtils.postUITask(yVar);
        }
        try {
            str2 = jSONObject.getString("ret_msg");
        } catch (Exception e3) {
            e = e3;
            String str42 = "mgList error :" + LogUtils.getErrorInfo(e);
            SudLogger.e(x.p, str42);
            LogUtils.file("HttpService", str42);
            if (i == 0) {
            }
            aVar.e = i;
            if (str2 != null) {
            }
            ThreadUtils.postUITask(new f.b(aVar.toString(), false, aVar.a, i));
            x xVar2 = this.c;
            y yVar2 = new y(this, i, str, str2);
            xVar2.getClass();
            ThreadUtils.postUITask(yVar2);
        }
        aVar.e = i;
        if (str2 != null) {
            aVar.f = str2;
        }
        ThreadUtils.postUITask(new f.b(aVar.toString(), false, aVar.a, i));
        x xVar22 = this.c;
        y yVar22 = new y(this, i, str, str2);
        xVar22.getClass();
        ThreadUtils.postUITask(yVar22);
    }
}
