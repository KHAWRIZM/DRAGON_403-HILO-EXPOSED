package com.taobao.accs.net;

import android.text.TextUtils;
import com.alibaba.sdk.android.logger.ILog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class q implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ILog iLog;
        try {
            j jVar = this.a;
            if (jVar.d != null && !TextUtils.isEmpty(jVar.i())) {
                iLog = this.a.t;
                iLog.i("mTryStartServiceRunnable bindApp");
                j jVar2 = this.a;
                jVar2.b(jVar2.d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
