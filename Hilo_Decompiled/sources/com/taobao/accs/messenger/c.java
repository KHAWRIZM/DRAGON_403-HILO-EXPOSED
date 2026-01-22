package com.taobao.accs.messenger;

import android.content.Intent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class c implements Runnable {
    final /* synthetic */ Intent a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Intent intent) {
        this.b = bVar;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessengerService.a();
    }
}
