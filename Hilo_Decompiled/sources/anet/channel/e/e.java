package anet.channel.e;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.session.TnetSpdySession;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f٤٧٥٨a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f٤٧٥٩b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List list, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f٤٧٥٨a = list;
        this.f٤٧٥٩b = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        AtomicInteger atomicInteger;
        IConnStrategy b10;
        IConnStrategy iConnStrategy = (IConnStrategy) this.f٤٧٥٨a.get(0);
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        str = a.f٤٧٤٦b;
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Http3Detect");
        atomicInteger = a.f٤٧٥٢h;
        sb3.append(atomicInteger.getAndIncrement());
        String sb4 = sb3.toString();
        b10 = a.b(iConnStrategy);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(GlobalAppRuntimeInfo.getContext(), new anet.channel.entity.a(sb2, sb4, b10));
        tnetSpdySession.registerEventcb(257, new f(this, iConnStrategy));
        tnetSpdySession.f٤٦٢٧q.isCommitted = true;
        tnetSpdySession.connect();
    }
}
