package org.android.agoo.control;

import android.content.Intent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
class i implements Runnable {
    final /* synthetic */ Intent a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, Intent intent) {
        this.b = hVar;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a.onHandleIntent(this.a);
    }
}
