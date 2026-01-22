package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Request f٤٩١٠a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RequestCb f٤٩١١b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f٤٩١٢c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f٤٩١٣d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, Request request, RequestCb requestCb, RequestStatistic requestStatistic) {
        this.f٤٩١٣d = dVar;
        this.f٤٩١٠a = request;
        this.f٤٩١١b = requestCb;
        this.f٤٩١٢c = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f٤٩١٠a.f٤٨٤٤a.sendBeforeTime = System.currentTimeMillis() - this.f٤٩١٠a.f٤٨٤٤a.reqStart;
        b.a(this.f٤٩١٠a, new g(this));
    }
}
