package anetwork.channel.unified;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionGetCallback;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h implements SessionGetCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f٥٢٧١a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f٥٢٧٢b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Request f٥٢٧٣c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ SessionCenter f٥٢٧٤d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ HttpUrl f٥٢٧٥e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f٥٢٧٦f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ e f٥٢٧٧g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, RequestStatistic requestStatistic, long j10, Request request, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z10) {
        this.f٥٢٧٧g = eVar;
        this.f٥٢٧١a = requestStatistic;
        this.f٥٢٧٢b = j10;
        this.f٥٢٧٣c = request;
        this.f٥٢٧٤d = sessionCenter;
        this.f٥٢٧٥e = httpUrl;
        this.f٥٢٧٦f = z10;
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetFail() {
        Session a10;
        ALog.e(e.TAG, "onSessionGetFail", this.f٥٢٧٧g.f٥٢٤٨a.f٥٢٨٣c, "url", this.f٥٢٧١a.url);
        this.f٥٢٧١a.connWaitTime = System.currentTimeMillis() - this.f٥٢٧٢b;
        e eVar = this.f٥٢٧٧g;
        a10 = eVar.a(null, this.f٥٢٧٤d, this.f٥٢٧٥e, this.f٥٢٧٦f);
        eVar.a(a10, this.f٥٢٧٣c);
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetSuccess(Session session) {
        ALog.i(e.TAG, "onSessionGetSuccess", this.f٥٢٧٧g.f٥٢٤٨a.f٥٢٨٣c, "Session", session);
        this.f٥٢٧١a.connWaitTime = System.currentTimeMillis() - this.f٥٢٧٢b;
        this.f٥٢٧١a.spdyRequestSend = true;
        this.f٥٢٧٧g.a(session, this.f٥٢٧٣c);
    }
}
