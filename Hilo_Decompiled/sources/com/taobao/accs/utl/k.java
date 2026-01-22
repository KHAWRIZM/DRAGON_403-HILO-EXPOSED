package com.taobao.accs.utl;

import anet.channel.util.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class k implements ALog.ILog {
    private ALog.ILog a;
    private a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface a {
        void a(String str);
    }

    public k(ALog.ILog iLog, a aVar) {
        this.a = iLog;
        this.b = aVar;
    }

    public void d(String str, String str2) {
        this.a.d(str, str2);
        this.b.a(str2);
    }

    public void e(String str, String str2) {
        this.a.e(str, str2);
        this.b.a(str2);
    }

    public void i(String str, String str2) {
        this.a.i(str, str2);
        this.b.a(str2);
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
        this.a.w(str, str2);
        this.b.a(str2);
    }

    public void e(String str, String str2, Throwable th) {
        this.a.e(str, str2, th);
        this.b.a(str2 + " " + th.getMessage());
    }

    public void w(String str, String str2, Throwable th) {
        this.a.w(str, str2, th);
        this.b.a(str2 + " " + th.getMessage());
    }
}
