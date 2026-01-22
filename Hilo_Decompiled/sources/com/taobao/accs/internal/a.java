package com.taobao.accs.internal;

import android.content.Context;
import com.taobao.accs.ACCSClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ ACCSManagerImpl c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ACCSManagerImpl aCCSManagerImpl, String str, Context context) {
        this.c = aCCSManagerImpl;
        this.a = str;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ACCSClient.getAccsClient(this.a).addConnectionListener(new b(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
