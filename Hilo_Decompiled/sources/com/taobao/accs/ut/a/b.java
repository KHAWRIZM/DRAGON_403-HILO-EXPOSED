package com.taobao.accs.ut.a;

import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class b {
    public String a;
    public String b;
    public boolean c;
    public String d;
    public String e;
    private final String f = "BindUser";
    private boolean g = false;

    private void b(String str) {
        String str2;
        String str3;
        if (this.g) {
            return;
        }
        this.g = true;
        HashMap hashMap = new HashMap();
        String str4 = null;
        try {
            String str5 = this.a;
            try {
                str2 = String.valueOf(Constants.SDK_VERSION_CODE);
                try {
                    hashMap.put("device_id", this.a);
                    hashMap.put("bind_date", this.b);
                    if (this.c) {
                        str3 = "y";
                    } else {
                        str3 = "n";
                    }
                    hashMap.put("ret", str3);
                    hashMap.put("fail_reasons", this.d);
                    hashMap.put("user_id", this.e);
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        ALog.d("accs.BindUserStatistic", UTMini.getCommitInfo(66001, str5, (String) null, str2, hashMap), new Object[0]);
                    }
                    UTMini.getInstance().commitEvent(66001, str, str5, (Object) null, str2, hashMap);
                } catch (Throwable th) {
                    th = th;
                    str4 = str5;
                    ALog.d("accs.BindUserStatistic", UTMini.getCommitInfo(66001, str4, (String) null, str2, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            str2 = null;
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
        b("BindUser");
    }
}
