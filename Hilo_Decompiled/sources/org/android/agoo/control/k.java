package org.android.agoo.control;

import com.taobao.accs.client.AdapterGlobalClientInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
class k implements Runnable {
    final /* synthetic */ BaseIntentService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BaseIntentService baseIntentService) {
        this.a = baseIntentService;
    }

    @Override // java.lang.Runnable
    public void run() {
        AgooFactory agooFactory;
        AgooFactory agooFactory2;
        AdapterGlobalClientInfo.mStartServiceTimes.incrementAndGet();
        BaseIntentService baseIntentService = this.a;
        baseIntentService.agooFactory = AgooFactory.getInstance(baseIntentService.getApplicationContext());
        BaseIntentService baseIntentService2 = this.a;
        agooFactory = baseIntentService2.agooFactory;
        baseIntentService2.notifyManager = agooFactory.getNotifyManager();
        BaseIntentService baseIntentService3 = this.a;
        agooFactory2 = baseIntentService3.agooFactory;
        baseIntentService3.messageService = agooFactory2.getMessageService();
    }
}
