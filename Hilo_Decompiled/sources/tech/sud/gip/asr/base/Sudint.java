package tech.sud.gip.asr.base;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import d.c;
import d.k;
import d.p;
import e.d;
import org.json.JSONObject;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class Sudint {
    public final Sudnew Sudbyte;
    public boolean Sudcase;
    public long Sudchar;
    public int Suddo;
    public final long Sudfor;
    public String Sudif;
    public long Sudlong;
    public final String Sudnew;
    public final String Sudtry;
    public final Sudfor Sudelse = new Sudfor(this);
    public final Handler Sudgoto = new Handler(Looper.getMainLooper());
    public final String Sudint = "volc";

    public Sudint(long j, String str, String str2, Sudnew sudnew) {
        this.Sudfor = j;
        this.Sudnew = str;
        this.Sudtry = str2;
        this.Sudbyte = sudnew;
    }

    public final void Suddo() {
        String str;
        k kVar;
        c cVar;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.Sudchar;
        this.Sudchar = SystemClock.elapsedRealtime();
        if (elapsedRealtime > 60000) {
            return;
        }
        long j = this.Sudlong + elapsedRealtime;
        this.Sudlong = j;
        int i = this.Suddo + 1;
        this.Suddo = i;
        String str2 = this.Sudif;
        long j2 = this.Sudfor;
        String str3 = this.Sudint;
        String str4 = this.Sudnew;
        String str5 = this.Sudtry;
        long j3 = (j + 999) / 1000;
        Sudif sudif = (Sudif) this.Sudbyte;
        String str6 = sudif.Sudif;
        p pVar = d.e;
        if (pVar == null || (kVar = pVar.c) == null || (cVar = kVar.p) == null || (str = cVar.a) == null) {
            str = null;
        }
        String str7 = str;
        if (TextUtils.isEmpty(str7)) {
            SudLogger.w(sudif.Suddo, "error onReportDuration error because url is null");
            LogUtils.file("CommonAsrBillingListener", "error onReportDuration error because url is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("seq_no", i);
            jSONObject.put("session_id", str2);
            jSONObject.put("app_id", str6);
            jSONObject.put("mg_id", j2);
            jSONObject.put("platform", 2);
            jSONObject.put("csp", str3);
            jSONObject.put("user_id", str4);
            jSONObject.put(GameMatchActivity.ROOM_ID, str5);
            jSONObject.put("duration", j3);
        } catch (Exception e) {
            LogUtils.file("error:" + LogUtils.getErrorInfo(e));
            e.printStackTrace();
        }
        d.b.o(str7, jSONObject.toString(), null, new Suddo(), null);
    }
}
