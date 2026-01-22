package com.taobao.accs.ut.a;

import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    public String a;
    public String b;
    public boolean c;
    public String d;
    private final String e = "BindApp";
    private boolean f = false;

    private void b(String str) {
        String str2;
        String str3;
        String str4;
        if (this.f) {
            return;
        }
        this.f = true;
        HashMap hashMap = new HashMap();
        String str5 = null;
        try {
            str3 = this.a;
            try {
                str2 = String.valueOf(Constants.SDK_VERSION_CODE);
            } catch (Throwable th) {
                th = th;
                str2 = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
        }
        try {
            hashMap.put("device_id", this.a);
            hashMap.put("bind_date", this.b);
            if (this.c) {
                str4 = "y";
            } else {
                str4 = "n";
            }
            hashMap.put("ret", str4);
            hashMap.put("fail_reasons", this.d);
            hashMap.put("push_token", "");
            UTMini.getInstance().commitEvent(66001, str, str3, (Object) null, str2, hashMap);
        } catch (Throwable th3) {
            th = th3;
            str5 = str3;
            ALog.d("BindAppStatistic", UTMini.getCommitInfo(66001, str5, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
        }
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(ErrorCode errorCode) {
        if (errorCode.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) {
            a(errorCode.getMsg());
        }
    }

    public void a() {
        b("BindApp");
    }
}
