package com.aliyun.ams.emas.push;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AgooMessageIntentService f٦٨٧٦a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AgooMessageIntentService agooMessageIntentService) {
        this.f٦٨٧٦a = agooMessageIntentService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Intent intent;
        if (message != null && (intent = (Intent) message.getData().getParcelable("intent")) != null) {
            this.f٦٨٧٦a.onStartCommand(intent, 0, 0);
        }
    }
}
