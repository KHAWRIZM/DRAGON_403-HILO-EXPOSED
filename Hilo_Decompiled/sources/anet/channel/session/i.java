package anet.channel.session;

import anet.channel.IAuth;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.statist.SessionStatistic;
import anet.channel.util.ALog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i implements IAuth.AuthCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f٤٩١٦a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TnetSpdySession tnetSpdySession) {
        this.f٤٩١٦a = tnetSpdySession;
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthFail(int i10, String str) {
        this.f٤٩١٦a.notifyStatus(5, null);
        SessionStatistic sessionStatistic = this.f٤٩١٦a.f٤٦٢٧q;
        if (sessionStatistic != null) {
            sessionStatistic.closeReason = "Accs_Auth_Fail:" + i10;
            this.f٤٩١٦a.f٤٦٢٧q.errorCode = (long) i10;
        }
        this.f٤٩١٦a.close();
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthSuccess() {
        this.f٤٩١٦a.notifyStatus(4, null);
        this.f٤٩١٦a.f٤٨٩٥z = System.currentTimeMillis();
        TnetSpdySession tnetSpdySession = this.f٤٩١٦a;
        IHeartbeat iHeartbeat = tnetSpdySession.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(tnetSpdySession);
        }
        TnetSpdySession tnetSpdySession2 = this.f٤٩١٦a;
        SessionStatistic sessionStatistic = tnetSpdySession2.f٤٦٢٧q;
        sessionStatistic.ret = 1;
        ALog.d("awcn.TnetSpdySession", "spdyOnStreamResponse", tnetSpdySession2.f٤٦٢٦p, "authTime", Long.valueOf(sessionStatistic.authTime));
        TnetSpdySession tnetSpdySession3 = this.f٤٩١٦a;
        if (tnetSpdySession3.A > 0) {
            tnetSpdySession3.f٤٦٢٧q.authTime = System.currentTimeMillis() - this.f٤٩١٦a.A;
        }
    }
}
