package org.android.agoo.control;

import android.content.Intent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
class l implements Runnable {
    final /* synthetic */ Intent a;
    final /* synthetic */ BaseIntentService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BaseIntentService baseIntentService, Intent intent) {
        this.b = baseIntentService;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.onHandleIntent(this.a);
    }
}
