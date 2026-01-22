package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class d {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String i;
    private final String j = "receiveMessage";
    public boolean h = false;
    private boolean k = false;

    public void a() {
        String str;
        String str2;
        Throwable th;
        String str3;
        if (this.k) {
            return;
        }
        this.k = true;
        HashMap hashMap = new HashMap();
        try {
            str = this.a;
            try {
                str2 = String.valueOf(Constants.SDK_VERSION_CODE);
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
                th = th;
                ALog.d("ReceiveMessage", UTMini.getCommitInfo(66001, str, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
            }
            try {
                hashMap.put("device_id", this.a);
                hashMap.put("data_id", this.b);
                hashMap.put("receive_date", this.c);
                hashMap.put("to_bz_date", this.d);
                hashMap.put("service_id", this.e);
                hashMap.put("data_length", this.f);
                hashMap.put("msg_type", this.g);
                if (this.h) {
                    str3 = "y";
                } else {
                    str3 = "n";
                }
                hashMap.put("repeat", str3);
                hashMap.put("user_id", this.i);
                UTMini.getInstance().commitEvent(66001, "receiveMessage", str, (Object) null, str2, hashMap);
            } catch (Throwable th3) {
                th = th3;
                ALog.d("ReceiveMessage", UTMini.getCommitInfo(66001, str, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
            }
        } catch (Throwable th4) {
            th = th4;
            str = null;
            str2 = null;
        }
    }
}
