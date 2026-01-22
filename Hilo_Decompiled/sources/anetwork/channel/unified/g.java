package anetwork.channel.unified;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SessionCenter f٥٢٦٥a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ HttpUrl f٥٢٦٦b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f٥٢٦٧c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ HttpUrl f٥٢٦٨d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f٥٢٦٩e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ e f٥٢٧٠f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, SessionCenter sessionCenter, HttpUrl httpUrl, RequestStatistic requestStatistic, HttpUrl httpUrl2, boolean z10) {
        this.f٥٢٧٠f = eVar;
        this.f٥٢٦٥a = sessionCenter;
        this.f٥٢٦٦b = httpUrl;
        this.f٥٢٦٧c = requestStatistic;
        this.f٥٢٦٨d = httpUrl2;
        this.f٥٢٦٩e = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z10;
        Session a10;
        long currentTimeMillis = System.currentTimeMillis();
        Session session = this.f٥٢٦٥a.get(this.f٥٢٦٦b, anet.channel.entity.c.f٤٧٧١a, 3000L);
        this.f٥٢٦٧c.connWaitTime = System.currentTimeMillis() - currentTimeMillis;
        RequestStatistic requestStatistic = this.f٥٢٦٧c;
        if (session != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        requestStatistic.spdyRequestSend = z10;
        a10 = this.f٥٢٧٠f.a(session, this.f٥٢٦٥a, this.f٥٢٦٨d, this.f٥٢٦٩e);
        e eVar = this.f٥٢٧٠f;
        eVar.a(a10, eVar.f٥٢٤٨a.f٥٢٨١a.a());
    }
}
