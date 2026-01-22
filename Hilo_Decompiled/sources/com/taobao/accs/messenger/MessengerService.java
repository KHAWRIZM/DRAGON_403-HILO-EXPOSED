package com.taobao.accs.messenger;

import android.app.Service;
import android.os.Messenger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class MessengerService extends Service {
    public static final String INTENT = "intent";
    private ExecutorService a = Executors.newSingleThreadExecutor();
    private Messenger b = new Messenger(new b(this));

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a() {
    }
}
