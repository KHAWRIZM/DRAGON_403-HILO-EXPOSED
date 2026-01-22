package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c implements IHeartbeat, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Session f٤٧٩٨a = null;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f٤٧٩٩b = false;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f٤٨٠٠c = System.currentTimeMillis();

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.f٤٨٠٠c = System.currentTimeMillis() + 45000;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f٤٧٩٩b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f٤٨٠٠c - 1000) {
            ThreadPoolExecutorFactory.submitScheduledTask(this, this.f٤٨٠٠c - currentTimeMillis, TimeUnit.MILLISECONDS);
        } else {
            this.f٤٧٩٨a.close(false);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        if (session != null) {
            this.f٤٧٩٨a = session;
            this.f٤٨٠٠c = System.currentTimeMillis() + 45000;
            ThreadPoolExecutorFactory.submitScheduledTask(this, 45000L, TimeUnit.MILLISECONDS);
            return;
        }
        throw new NullPointerException("session is null");
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        this.f٤٧٩٩b = true;
    }
}
