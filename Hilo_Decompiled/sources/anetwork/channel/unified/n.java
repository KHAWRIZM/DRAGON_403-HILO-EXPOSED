package anetwork.channel.unified;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f٥٢٩٤a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.f٥٢٩٤a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f٥٢٩٤a.f٥٢٨٧a.f٥٢٨٤d.compareAndSet(false, true)) {
            RequestStatistic requestStatistic = this.f٥٢٩٤a.f٥٢٨٧a.f٥٢٨١a.f٥٢٢٥b;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_TIME_OUT;
                requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_TIME_OUT);
                requestStatistic.rspEnd = System.currentTimeMillis();
                ALog.e("anet.UnifiedRequestTask", "task time out", this.f٥٢٩٤a.f٥٢٨٧a.f٥٢٨٣c, "rs", requestStatistic);
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_TIME_OUT, null, requestStatistic, null));
            }
            this.f٥٢٩٤a.f٥٢٨٧a.b();
            this.f٥٢٩٤a.f٥٢٨٧a.f٥٢٨٢b.onFinish(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_TIME_OUT, (String) null, this.f٥٢٩٤a.f٥٢٨٧a.f٥٢٨١a.a()));
        }
    }
}
