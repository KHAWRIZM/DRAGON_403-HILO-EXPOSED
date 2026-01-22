package anet.channel.heartbeat;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class b implements IHeartbeat, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Session f٤٧٩٤a;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f٤٧٩٥b = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f٤٧٩٦c = false;

    /* renamed from: d, reason: collision with root package name */
    private long f٤٧٩٧d = 0;

    private void a(long j10) {
        try {
            this.f٤٧٩٥b = System.currentTimeMillis() + j10;
            ThreadPoolExecutorFactory.submitScheduledTask(this, j10 + 50, TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            ALog.e("awcn.DefaultHeartbeatImpl", "Submit heartbeat task failed.", this.f٤٧٩٤a.f٤٦٢٦p, e10, new Object[0]);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.f٤٧٩٥b = System.currentTimeMillis() + this.f٤٧٩٧d;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f٤٧٩٦c) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f٤٧٩٥b - 1000) {
            a(this.f٤٧٩٥b - currentTimeMillis);
            return;
        }
        if (!GlobalAppRuntimeInfo.isAppBackground()) {
            if (ALog.isPrintLog(1)) {
                Session session = this.f٤٧٩٤a;
                ALog.d("awcn.DefaultHeartbeatImpl", "heartbeat", session.f٤٦٢٦p, "session", session);
            }
            this.f٤٧٩٤a.ping(true);
            a(this.f٤٧٩٧d);
            return;
        }
        Session session2 = this.f٤٧٩٤a;
        ALog.e("awcn.DefaultHeartbeatImpl", "close session in background", session2.f٤٦٢٦p, "session", session2);
        this.f٤٧٩٤a.close(false);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        if (session != null) {
            this.f٤٧٩٤a = session;
            long heartbeat = session.getConnStrategy().getHeartbeat();
            this.f٤٧٩٧d = heartbeat;
            if (heartbeat <= 0) {
                this.f٤٧٩٧d = 45000L;
            }
            ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat start", session.f٤٦٢٦p, "session", session, "interval", Long.valueOf(this.f٤٧٩٧d));
            a(this.f٤٧٩٧d);
            return;
        }
        throw new NullPointerException("session is null");
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        Session session = this.f٤٧٩٤a;
        if (session == null) {
            return;
        }
        ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat stop", session.f٤٦٢٦p, "session", session);
        this.f٤٧٩٦c = true;
    }
}
