package com.taobao.accs.client;

import com.taobao.accs.utl.UtilityImpl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class d implements Runnable {
    final /* synthetic */ GlobalClientInfo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GlobalClientInfo globalClientInfo) {
        this.a = globalClientInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        GlobalClientInfo.b = UtilityImpl.j(GlobalClientInfo.a);
    }
}
