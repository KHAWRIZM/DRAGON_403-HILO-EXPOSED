package qf;

import com.qiahao.nextvideo.sheep.GameMatchActivity;
import org.json.JSONObject;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.ISudListenerGetMGInfo;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class d implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;
    public final /* synthetic */ ISudListenerGetMGInfo e;
    public final /* synthetic */ x f;

    public d(x xVar, long j, String str, long j2, String str2, ISudListenerGetMGInfo iSudListenerGetMGInfo) {
        this.f = xVar;
        this.a = j;
        this.b = str;
        this.c = j2;
        this.d = str2;
        this.e = iSudListenerGetMGInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00a7  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int i;
        JSONObject jSONObject;
        GameInfo gameInfo = new GameInfo();
        f.a aVar = new f.a("getMGInfo");
        aVar.g = String.valueOf(this.a);
        wf.e eVar = new wf.e();
        aVar.n = eVar;
        String str = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdk_token", this.b);
            jSONObject2.put("mg_id", this.a);
            jSONObject2.put("client_version", this.c);
            String str2 = e.d.a;
            jSONObject2.put("platform", 2);
            jSONObject2.put("uengine_version", "2022.3.62f2c1");
            jSONObject2.put("user_id", f.d.a);
            jSONObject2.put(GameMatchActivity.ROOM_ID, this.d);
            jSONObject = new JSONObject(x.b(this.f.e, jSONObject2.toString(), aVar.c, eVar, null, null));
            i = jSONObject.getInt("ret_code");
        } catch (Exception e) {
            e = e;
            i = 0;
        }
        try {
            str = jSONObject.getString("ret_msg");
            x.s(jSONObject, gameInfo);
        } catch (Exception e2) {
            e = e2;
            String str3 = "mgInfo error :" + LogUtils.getErrorInfo(e);
            SudLogger.e(x.p, str3);
            LogUtils.file("HttpService", str3);
            if (i == 0) {
                i = d.a.a(e);
                str = e.toString();
            }
            aVar.e = i;
            if (str != null) {
            }
            ThreadUtils.postUITask(new f.b(aVar.toString(), false, aVar.a, i));
            ThreadUtils.postUITask(new c(this, i, gameInfo, str));
        }
        aVar.e = i;
        if (str != null) {
            aVar.f = str;
        }
        ThreadUtils.postUITask(new f.b(aVar.toString(), false, aVar.a, i));
        ThreadUtils.postUITask(new c(this, i, gameInfo, str));
    }
}
