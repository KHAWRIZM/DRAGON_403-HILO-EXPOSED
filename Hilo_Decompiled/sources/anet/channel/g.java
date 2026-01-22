package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Session f٤٧٨٧a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SessionRequest f٤٧٨٨b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SessionRequest sessionRequest, Session session) {
        this.f٤٧٨٨b = sessionRequest;
        this.f٤٧٨٧a = session;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i10, anet.channel.entity.b bVar) {
        ALog.d("awcn.SessionRequest", "Receive session event", null, "eventType", Integer.valueOf(i10));
        ConnEvent connEvent = new ConnEvent();
        if (i10 == 512) {
            connEvent.isSuccess = true;
        }
        SessionInfo sessionInfo = this.f٤٧٨٨b.f٤٦٥١c;
        if (sessionInfo != null) {
            connEvent.isAccs = sessionInfo.isAccs;
        }
        StrategyCenter.getInstance().notifyConnEvent(this.f٤٧٨٧a.getRealHost(), this.f٤٧٨٧a.getConnStrategy(), connEvent);
    }
}
