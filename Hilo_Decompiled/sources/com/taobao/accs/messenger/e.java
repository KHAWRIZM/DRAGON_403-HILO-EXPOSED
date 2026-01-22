package com.taobao.accs.messenger;

import android.content.Intent;
import android.os.RemoteException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class e {
    private static final String a = e.class.getName() + ".TRY_COUNT";
    private ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();
    private a c;

    public e(a aVar) {
        this.c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, Intent intent) {
        d a2 = this.c.a(str);
        if (a2 == null) {
            this.c.a(str, intent);
            c(str, intent);
            return;
        }
        try {
            a2.a(intent);
        } catch (RemoteException unused) {
            this.c.b(str, a2);
            this.c.a(str, intent);
            c(str, intent);
        }
    }

    private void c(String str, Intent intent) {
        String str2 = a;
        int intExtra = intent.getIntExtra(str2, 0);
        if (intExtra > 10) {
            return;
        }
        intent.putExtra(str2, intExtra + 1);
        this.b.schedule(new f(this, str, intent), 1000L, TimeUnit.MILLISECONDS);
    }

    public void a(String str, Intent intent) {
        b(str, intent);
    }
}
