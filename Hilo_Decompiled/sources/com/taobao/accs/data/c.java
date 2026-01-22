package com.taobao.accs.data;

import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class c implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        String str;
        Map map;
        String str2;
        int i2;
        synchronized (this.a) {
            try {
                i = this.a.f;
                if (i == 0) {
                    str = this.a.b;
                    ALog.e("AssembleMessage", "timeout", Constants.KEY_DATA_ID, str);
                    this.a.f = 1;
                    map = this.a.h;
                    map.clear();
                    str2 = this.a.b;
                    i2 = this.a.f;
                    AppMonitor.getInstance().commitStat(new AssembleMonitor(str2, String.valueOf(i2)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
