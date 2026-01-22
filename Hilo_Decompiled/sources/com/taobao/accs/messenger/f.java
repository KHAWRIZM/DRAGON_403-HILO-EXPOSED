package com.taobao.accs.messenger;

import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Intent b;
    final /* synthetic */ e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, String str, Intent intent) {
        this.c = eVar;
        this.a = str;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.b(this.a, this.b);
    }
}
