package com.taobao.accs.utl;

import anet.channel.util.ALog;
import com.alibaba.sdk.android.logger.ILog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class l implements ALog.ILog {
    private ILog a = AccsLogger.getLogger("NetworkSdk");

    private String a(String str, String str2) {
        return "[" + str + "]" + str2;
    }

    public void d(String str, String str2) {
        this.a.d(a(str, str2));
    }

    public void e(String str, String str2) {
        this.a.e(a(str, str2));
    }

    public void i(String str, String str2) {
        this.a.i(a(str, str2));
    }

    public boolean isPrintLog(int i) {
        return true;
    }

    public boolean isValid() {
        return true;
    }

    public void setLogLevel(int i) {
    }

    public void w(String str, String str2) {
        this.a.w(a(str, str2));
    }

    public void e(String str, String str2, Throwable th) {
        this.a.e(a(str, str2), th);
    }

    public void w(String str, String str2, Throwable th) {
        this.a.w(a(str, str2), th);
    }
}
