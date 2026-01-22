package com.taobao.accs.messenger;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import java.util.concurrent.ExecutorService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class b extends Handler {
    final /* synthetic */ MessengerService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MessengerService messengerService) {
        this.a = messengerService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Intent intent;
        ExecutorService executorService;
        if (message != null && (intent = (Intent) message.getData().getParcelable(MessengerService.INTENT)) != null) {
            executorService = this.a.a;
            executorService.execute(new c(this, intent));
        }
    }
}
