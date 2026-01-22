package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class e {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    private final String g = "sendAck";
    private boolean h = false;

    public void a() {
        String str;
        String str2;
        Throwable th;
        if (this.h) {
            return;
        }
        this.h = true;
        HashMap hashMap = new HashMap();
        try {
            str = this.a;
            try {
                str2 = String.valueOf(Constants.SDK_VERSION_CODE);
                try {
                    hashMap.put("device_id", this.a);
                    hashMap.put("session_id", this.b);
                    hashMap.put("data_id", this.c);
                    hashMap.put("ack_date", this.d);
                    hashMap.put("service_id", this.e);
                    hashMap.put("fail_reasons", this.f);
                    UTMini.getInstance().commitEvent(66001, "sendAck", str, (Object) null, str2, hashMap);
                } catch (Throwable th2) {
                    th = th2;
                    ALog.d("accs.SendAckStatistic", UTMini.getCommitInfo(66001, str, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = null;
                th = th;
                ALog.d("accs.SendAckStatistic", UTMini.getCommitInfo(66001, str, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
            }
        } catch (Throwable th4) {
            th = th4;
            str = null;
            str2 = null;
        }
    }
}
