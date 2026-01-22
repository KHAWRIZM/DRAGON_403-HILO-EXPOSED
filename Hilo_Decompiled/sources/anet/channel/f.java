package anet.channel;

import anet.channel.SessionRequest;
import anet.channel.entity.EventCb;
import anet.channel.util.ALog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SessionRequest.IConnCb f٤٧٧٤a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f٤٧٧٥b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionRequest f٤٧٧٦c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SessionRequest sessionRequest, SessionRequest.IConnCb iConnCb, long j10) {
        this.f٤٧٧٦c = sessionRequest;
        this.f٤٧٧٤a = iConnCb;
        this.f٤٧٧٥b = j10;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i10, anet.channel.entity.b bVar) {
        int i11;
        String str;
        if (session == null) {
            return;
        }
        if (bVar == null) {
            i11 = 0;
        } else {
            i11 = bVar.f٤٧٦٩b;
        }
        if (bVar == null) {
            str = "";
        } else {
            str = bVar.f٤٧٧٠c;
        }
        if (i10 != 2) {
            if (i10 != 256) {
                if (i10 == 512) {
                    ALog.d("awcn.SessionRequest", null, session.f٤٦٢٦p, "Session", session, "EventType", Integer.valueOf(i10), "Event", bVar);
                    this.f٤٧٧٦c.a(session, 0, (String) null);
                    this.f٤٧٧٤a.onSuccess(session, this.f٤٧٧٥b);
                    return;
                }
                return;
            }
            ALog.d("awcn.SessionRequest", null, session.f٤٦٢٦p, "Session", session, "EventType", Integer.valueOf(i10), "Event", bVar);
            this.f٤٧٧٤a.onFailed(session, this.f٤٧٧٥b, i10, i11);
            return;
        }
        ALog.d("awcn.SessionRequest", null, session.f٤٦٢٦p, "Session", session, "EventType", Integer.valueOf(i10), "Event", bVar);
        this.f٤٧٧٦c.a(session, i11, str);
        SessionRequest sessionRequest = this.f٤٧٧٦c;
        if (sessionRequest.f٤٦٥٠b.c(sessionRequest, session)) {
            this.f٤٧٧٤a.onDisConnect(session, this.f٤٧٧٥b, i10);
        } else {
            this.f٤٧٧٤a.onFailed(session, this.f٤٧٧٥b, i10, i11);
        }
    }
}
