package com.taobao.accs.data;

import android.content.Intent;
import android.os.Handler;
import com.taobao.accs.messenger.MessengerService;
import com.taobao.accs.utl.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class i extends Handler {
    final /* synthetic */ MsgDistributeService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MsgDistributeService msgDistributeService) {
        this.a = msgDistributeService;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        if (message != null) {
            ALog.i("MsgDistributeService", "handleMessage on receive msg", "msg", message.toString());
            Intent intent = (Intent) message.getData().getParcelable(MessengerService.INTENT);
            if (intent != null) {
                ALog.i("MsgDistributeService", "handleMessage get intent success", MessengerService.INTENT, intent.toString());
                this.a.onStartCommand(intent, 0, 0);
            }
        }
    }
}
