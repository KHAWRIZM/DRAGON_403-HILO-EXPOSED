package com.taobao.accs.net;

import anet.channel.session.TnetSpdySession;
import com.alibaba.sdk.android.logger.ILog;
import com.taobao.accs.AccsState;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class o implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ TnetSpdySession d;
    final /* synthetic */ j e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar, int i, int i2, byte[] bArr, TnetSpdySession tnetSpdySession) {
        this.e = jVar;
        this.a = i;
        this.b = i2;
        this.c = bArr;
        this.d = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        ILog iLog;
        ILog iLog2;
        String str;
        ILog iLog3;
        iLog = this.e.t;
        iLog.i(new Object[]{"onDataReceive", "type", Integer.valueOf(this.a), Constants.KEY_DATA_ID, Integer.valueOf(this.b)});
        AccsState.getInstance().a(this.e.m, AccsState.LAST_MSG_RECEIVE_TIME, Integer.valueOf(this.b));
        if (this.a != 200) {
            iLog3 = this.e.t;
            iLog3.e("drop frame len:" + this.c.length + " frameType" + this.a);
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.e.e.a(this.c, this.d.getHost());
            com.taobao.accs.ut.a.d g = this.e.e.g();
            if (g != null) {
                g.c = String.valueOf(currentTimeMillis);
                if (this.e.c == 0) {
                    str = "service";
                } else {
                    str = "inapp";
                }
                g.g = str;
                g.a();
            }
        } catch (Throwable th) {
            iLog2 = this.e.t;
            iLog2.e("onDataReceive", th);
            UTMini.getInstance().commitEvent(66001, "DATA_RECEIVE", UtilityImpl.a(th));
        }
    }
}
