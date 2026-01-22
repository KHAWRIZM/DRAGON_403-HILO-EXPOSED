package qf;

import com.qiahao.nextvideo.sheep.GameMatchActivity;
import org.json.JSONObject;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class h implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ s0.h e;
    public final /* synthetic */ x f;

    public h(x xVar, long j, String str, String str2, String str3, s0.h hVar) {
        this.f = xVar;
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00b1  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int i;
        JSONObject jSONObject;
        GameInfo gameInfo = new GameInfo();
        f.a aVar = new f.a("getAuthMGInfo");
        aVar.g = String.valueOf(this.a);
        wf.e eVar = new wf.e();
        aVar.n = eVar;
        String str = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdk_token", this.b);
            jSONObject2.put("authorization_secret", this.c);
            jSONObject2.put("mg_id", this.a);
            jSONObject2.put("client_version", 0);
            String str2 = e.d.a;
            jSONObject2.put("platform", 2);
            jSONObject2.put("uengine_version", "2022.3.62f2c1");
            jSONObject2.put("user_id", f.d.a);
            jSONObject2.put(GameMatchActivity.ROOM_ID, this.d);
            jSONObject = new JSONObject(x.b(this.f.g, jSONObject2.toString(), aVar.c, eVar, null, null));
            i = jSONObject.getInt("ret_code");
        } catch (Exception e) {
            e = e;
            i = 0;
        }
        try {
            str = jSONObject.getString("ret_msg");
            this.f.getClass();
            x.s(jSONObject, gameInfo);
        } catch (Exception e2) {
            e = e2;
            String str3 = "authMgInfo error :" + LogUtils.getErrorInfo(e);
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
            x xVar = this.f;
            f fVar = new f(this, i, gameInfo, str);
            xVar.getClass();
            ThreadUtils.postUITask(fVar);
        }
        aVar.e = i;
        if (str != null) {
            aVar.f = str;
        }
        ThreadUtils.postUITask(new f.b(aVar.toString(), false, aVar.a, i));
        x xVar2 = this.f;
        f fVar2 = new f(this, i, gameInfo, str);
        xVar2.getClass();
        ThreadUtils.postUITask(fVar2);
    }
}
