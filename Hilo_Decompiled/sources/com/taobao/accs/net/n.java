package com.taobao.accs.net;

import com.alibaba.sdk.android.logger.ILog;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.data.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class n implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ boolean c;
    final /* synthetic */ j d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar, String str, long j, boolean z) {
        this.d = jVar;
        this.a = str;
        this.b = j;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        ILog iLog;
        Message a = this.d.e.a(this.a);
        if (a != null) {
            this.d.e.a(a, AccsErrorCode.REQ_TIME_OUT.copy().msg("发送超过" + this.b + "未收到回执").detail(AccsErrorCode.getAllDetails(null)).build());
            this.d.a(this.a, this.c, "receive data time out");
            iLog = this.d.t;
            iLog.e(this.a + "-> receive data time out!");
        }
    }
}
