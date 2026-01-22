package com.taobao.accs.net;

import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsState;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class p implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ boolean d;
    final /* synthetic */ j e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(j jVar, int i, String str, int i2, boolean z) {
        this.e = jVar;
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message.a aVar;
        Message b;
        AccsState.getInstance().b(this.e.m, AccsState.RECENT_ERRORS, "oe " + this.a + " " + this.b);
        int i = this.c;
        if (i > 0) {
            Message.a aVar2 = new Message.a(i, "");
            Iterator<Message.a> it = this.e.e.f().iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = it.next();
                    if (aVar.equals(aVar2)) {
                        break;
                    }
                } else {
                    aVar = null;
                    break;
                }
            }
            if (aVar != null && (b = this.e.e.b(aVar.b())) != null) {
                if (this.d) {
                    if (!this.e.a(b, HonorResultCode.ADVANCED_RECORD_SUCCESS)) {
                        this.e.e.a(b, AccsErrorCode.convertNetworkSdkError(this.a, this.b).detail(AccsErrorCode.getAllDetails(null)).build());
                    }
                    if (b.e() != null) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "total_tnet", 0.0d);
                    }
                } else {
                    this.e.e.a(b, AccsErrorCode.convertNetworkSdkError(this.a, this.b).detail(AccsErrorCode.getAllDetails(null)).build());
                }
            }
        }
        int i2 = this.c;
        if (i2 < 0 && this.d) {
            this.e.b(i2);
        }
    }
}
