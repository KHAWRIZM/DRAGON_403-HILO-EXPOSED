package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicInteger f٥٠٥٣a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f٥٠٥٤b = null;

    static ScheduledThreadPoolExecutor a() {
        if (f٥٠٥٤b == null) {
            synchronized (a.class) {
                try {
                    if (f٥٠٥٤b == null) {
                        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new b());
                        f٥٠٥٤b = scheduledThreadPoolExecutor;
                        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
                        f٥٠٥٤b.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return f٥٠٥٤b;
    }

    public static void a(Runnable runnable) {
        try {
            a().submit(runnable);
        } catch (Exception e10) {
            ALog.e(anet.channel.strategy.dispatch.a.TAG, "submit task failed", null, e10, new Object[0]);
        }
    }

    public static void a(Runnable runnable, long j10) {
        try {
            a().schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            ALog.e(anet.channel.strategy.dispatch.a.TAG, "schedule task failed", null, e10, new Object[0]);
        }
    }
}
