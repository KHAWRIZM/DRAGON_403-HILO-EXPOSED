package anet.channel.session;

import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyInstance;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f٤٩١٥a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TnetSpdySession tnetSpdySession) {
        this.f٤٩١٥a = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        IConnStrategy iConnStrategy;
        if (this.f٤٩١٥a.f٤٨٩٤y) {
            TnetSpdySession tnetSpdySession = this.f٤٩١٥a;
            ALog.e("awcn.TnetSpdySession", "send msg time out!", tnetSpdySession.f٤٦٢٦p, "pingUnRcv:", Boolean.valueOf(tnetSpdySession.f٤٨٩٤y));
            try {
                this.f٤٩١٥a.handleCallbacks(2048, null);
                SessionStatistic sessionStatistic = this.f٤٩١٥a.f٤٦٢٧q;
                if (sessionStatistic != null) {
                    sessionStatistic.closeReason = "ping time out";
                }
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = false;
                connEvent.isAccs = this.f٤٩١٥a.I;
                IStrategyInstance strategyCenter = StrategyCenter.getInstance();
                str = this.f٤٩١٥a.f٤٦١٤d;
                iConnStrategy = this.f٤٩١٥a.f٤٦٢١k;
                strategyCenter.notifyConnEvent(str, iConnStrategy, connEvent);
                this.f٤٩١٥a.close(true);
            } catch (Exception unused) {
            }
        }
    }
}
