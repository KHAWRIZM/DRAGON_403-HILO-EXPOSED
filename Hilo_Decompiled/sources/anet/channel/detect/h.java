package anet.channel.detect;

import anet.channel.Session;
import anet.channel.entity.EventCb;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HorseRaceStat f٤٧٢٤a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f٤٧٢٥b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f٤٧٢٦c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ l.e f٤٧٢٧d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f٤٧٢٨e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ d f٤٧٢٩f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar, HorseRaceStat horseRaceStat, long j10, String str, l.e eVar, TnetSpdySession tnetSpdySession) {
        this.f٤٧٢٩f = dVar;
        this.f٤٧٢٤a = horseRaceStat;
        this.f٤٧٢٥b = j10;
        this.f٤٧٢٦c = str;
        this.f٤٧٢٧d = eVar;
        this.f٤٧٢٨e = tnetSpdySession;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i10, anet.channel.entity.b bVar) {
        if (this.f٤٧٢٤a.connTime != 0) {
            return;
        }
        this.f٤٧٢٤a.connTime = System.currentTimeMillis() - this.f٤٧٢٥b;
        if (i10 == 1) {
            ALog.i("anet.HorseRaceDetector", "tnetSpdySession connect success", this.f٤٧٢٦c, new Object[0]);
            this.f٤٧٢٤a.connRet = 1;
            HttpUrl parse = HttpUrl.parse(session.getHost() + this.f٤٧٢٧d.f٥٠٤٨c);
            if (parse == null) {
                return;
            }
            this.f٤٧٢٨e.request(new Request.Builder().setUrl(parse).setReadTimeout(this.f٤٧٢٧d.f٥٠٤٧b.f٥٠١٩d).setRedirectEnable(false).setSeq(this.f٤٧٢٦c).build(), new i(this));
            return;
        }
        this.f٤٧٢٤a.connErrorCode = bVar.f٤٧٦٩b;
        synchronized (this.f٤٧٢٤a) {
            this.f٤٧٢٤a.notify();
        }
    }
}
