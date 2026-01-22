package anet.channel.e;

import anet.channel.Session;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.e.a;
import anet.channel.entity.EventCb;
import anet.channel.statist.Http3DetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class f implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IConnStrategy f٤٧٦٠a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f٤٧٦١b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, IConnStrategy iConnStrategy) {
        this.f٤٧٦١b = eVar;
        this.f٤٧٦٠a = iConnStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i10, anet.channel.entity.b bVar) {
        a.b bVar2;
        String str;
        ?? r02 = 1;
        if (i10 != 1) {
            r02 = 0;
        }
        bVar2 = a.f٤٧٤٥a;
        bVar2.a(NetworkStatusHelper.getUniqueId(this.f٤٧٦١b.f٤٧٥٩b), r02);
        session.close(false);
        str = a.f٤٧٤٦b;
        Http3DetectStat http3DetectStat = new Http3DetectStat(str, this.f٤٧٦٠a);
        http3DetectStat.ret = r02;
        AppMonitor.getInstance().commitStat(http3DetectStat);
    }
}
