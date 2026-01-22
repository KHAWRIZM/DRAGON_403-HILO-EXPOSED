package com.taobao.accs.ut.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class c {
    public int a;
    public int b;
    public String f;
    public String g;
    public long h;
    public boolean i;
    public boolean j;
    private long k = 0;
    public boolean c = false;
    public int d = 0;
    public int e = 0;

    public void a() {
        String str;
        String str2;
        String valueOf;
        long currentTimeMillis = System.currentTimeMillis();
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level)) {
            ALog.d("MonitorStatistic", "commitUT interval:" + (currentTimeMillis - this.k) + " interval1:" + (currentTimeMillis - this.h), new Object[0]);
        }
        if (currentTimeMillis - this.k > 1200000 && currentTimeMillis - this.h > 60000) {
            HashMap hashMap = new HashMap();
            String str3 = null;
            try {
                valueOf = String.valueOf(this.d);
                try {
                    str2 = String.valueOf(this.e);
                    try {
                        str = String.valueOf(Constants.SDK_VERSION_CODE);
                        try {
                            hashMap.put("connStatus", String.valueOf(this.a));
                            hashMap.put("connType", String.valueOf(this.b));
                            hashMap.put("tcpConnected", String.valueOf(this.c));
                            hashMap.put("proxy", String.valueOf(this.f));
                            hashMap.put("startServiceTime", String.valueOf(this.h));
                            hashMap.put("commitTime", String.valueOf(currentTimeMillis));
                            hashMap.put("networkAvailable", String.valueOf(this.i));
                            hashMap.put("threadIsalive", String.valueOf(this.j));
                            hashMap.put("url", this.g);
                            if (ALog.isPrintLog(level)) {
                                try {
                                    ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, valueOf, str2, str, hashMap), new Object[0]);
                                } catch (Throwable th) {
                                    th = th;
                                    str3 = valueOf;
                                    ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str3, str2, str, hashMap) + " " + th.toString(), new Object[0]);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = null;
                    str2 = null;
                }
            } catch (Throwable th5) {
                th = th5;
                str = null;
                str2 = null;
            }
            try {
                UTMini.getInstance().commitEvent(66001, "MONITOR", valueOf, str2, str, hashMap);
                this.k = currentTimeMillis;
            } catch (Throwable th6) {
                th = th6;
                str3 = valueOf;
                str = str;
                str2 = str2;
                ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, str3, str2, str, hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }
}
