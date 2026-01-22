package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class h implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ com.taobao.accs.net.b b;
    final /* synthetic */ Intent c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, com.taobao.accs.net.b bVar, Intent intent) {
        this.a = context;
        this.b = bVar;
        this.c = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        g.a().b(this.a, this.b, this.c);
    }
}
