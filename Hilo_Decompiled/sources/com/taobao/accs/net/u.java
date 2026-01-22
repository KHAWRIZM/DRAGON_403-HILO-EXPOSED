package com.taobao.accs.net;

import android.content.Context;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class u extends f {
    private ScheduledFuture c;

    /* JADX INFO: Access modifiers changed from: protected */
    public u(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.f
    protected void a(int i) {
        ScheduledFuture scheduledFuture = this.c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.c = null;
        }
        long j = i;
        this.c = ThreadPoolExecutorFactory.getScheduledExecutor().scheduleAtFixedRate(new v(this), j, j, TimeUnit.SECONDS);
    }
}
