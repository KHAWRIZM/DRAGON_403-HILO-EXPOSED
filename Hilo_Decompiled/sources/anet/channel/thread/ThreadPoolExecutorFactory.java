package anet.channel.thread;

import anet.channel.util.ALog;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ThreadPoolExecutorFactory {

    /* renamed from: a, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f٥٠٥٥a = new ScheduledThreadPoolExecutor(1, new b("AWCN Scheduler"));

    /* renamed from: b, reason: collision with root package name */
    private static ThreadPoolExecutor f٥٠٥٦b;

    /* renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f٥٠٥٧c;

    /* renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f٥٠٥٨d;

    /* renamed from: e, reason: collision with root package name */
    private static ThreadPoolExecutor f٥٠٥٩e;

    /* renamed from: f, reason: collision with root package name */
    private static ThreadPoolExecutor f٥٠٦٠f;

    /* renamed from: g, reason: collision with root package name */
    private static ThreadPoolExecutor f٥٠٦١g;

    /* renamed from: h, reason: collision with root package name */
    private static ThreadPoolExecutor f٥٠٦٢h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class Priority {
        public static int HIGH = 0;
        public static int LOW = 9;
        public static int NORMAL = 1;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a implements Comparable<a>, Runnable {

        /* renamed from: a, reason: collision with root package name */
        Runnable f٥٠٦٣a;

        /* renamed from: b, reason: collision with root package name */
        int f٥٠٦٤b;

        /* renamed from: c, reason: collision with root package name */
        long f٥٠٦٥c;

        public a(Runnable runnable, int i10) {
            this.f٥٠٦٣a = null;
            this.f٥٠٦٤b = 0;
            this.f٥٠٦٥c = System.currentTimeMillis();
            this.f٥٠٦٣a = runnable;
            this.f٥٠٦٤b = i10;
            this.f٥٠٦٥c = System.currentTimeMillis();
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int i10 = this.f٥٠٦٤b;
            int i11 = aVar.f٥٠٦٤b;
            if (i10 != i11) {
                return i10 - i11;
            }
            return (int) (aVar.f٥٠٦٥c - this.f٥٠٦٥c);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f٥٠٦٣a.run();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        AtomicInteger f٥٠٦٦a = new AtomicInteger(0);

        /* renamed from: b, reason: collision with root package name */
        String f٥٠٦٧b;

        b(String str) {
            this.f٥٠٦٧b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f٥٠٦٧b + this.f٥٠٦٦a.incrementAndGet());
            ALog.i("awcn.ThreadPoolExecutorFactory", "thread created!", null, "name", thread.getName());
            thread.setPriority(5);
            return thread;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f٥٠٥٦b = new ThreadPoolExecutor(2, 2, 60L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Worker(H)"));
        f٥٠٥٧c = new anet.channel.thread.a(16, 16, 60L, timeUnit, new PriorityBlockingQueue(), new b("AWCN Worker(M)"));
        f٥٠٥٨d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Worker(L)"));
        f٥٠٥٩e = new ThreadPoolExecutor(32, 32, 60L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Worker(Backup)"));
        f٥٠٦٠f = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Detector"));
        f٥٠٦١g = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new b("AWCN HR"));
        f٥٠٦٢h = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Cookie"));
        f٥٠٥٦b.allowCoreThreadTimeOut(true);
        f٥٠٥٧c.allowCoreThreadTimeOut(true);
        f٥٠٥٨d.allowCoreThreadTimeOut(true);
        f٥٠٥٩e.allowCoreThreadTimeOut(true);
        f٥٠٦٠f.allowCoreThreadTimeOut(true);
        f٥٠٦١g.allowCoreThreadTimeOut(true);
        f٥٠٦٢h.allowCoreThreadTimeOut(true);
    }

    public static void removeScheduleTask(Runnable runnable) {
        f٥٠٥٥a.remove(runnable);
    }

    public static synchronized void setNormalExecutorPoolSize(int i10) {
        synchronized (ThreadPoolExecutorFactory.class) {
            if (i10 < 6) {
                i10 = 6;
            }
            f٥٠٥٧c.setCorePoolSize(i10);
            f٥٠٥٧c.setMaximumPoolSize(i10);
        }
    }

    public static Future<?> submitBackupTask(Runnable runnable) {
        return f٥٠٥٩e.submit(runnable);
    }

    public static Future<?> submitCookieMonitor(Runnable runnable) {
        return f٥٠٦٢h.submit(runnable);
    }

    public static Future<?> submitDetectTask(Runnable runnable) {
        return f٥٠٦٠f.submit(runnable);
    }

    public static Future<?> submitHRTask(Runnable runnable) {
        return f٥٠٦١g.submit(runnable);
    }

    public static Future<?> submitPriorityTask(Runnable runnable, int i10) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.ThreadPoolExecutorFactory", "submit priority task", null, "priority", Integer.valueOf(i10));
        }
        if (i10 < Priority.HIGH || i10 > Priority.LOW) {
            i10 = Priority.LOW;
        }
        if (i10 == Priority.HIGH) {
            return f٥٠٥٦b.submit(runnable);
        }
        if (i10 == Priority.LOW) {
            return f٥٠٥٨d.submit(runnable);
        }
        return f٥٠٥٧c.submit(new a(runnable, i10));
    }

    public static Future<?> submitScheduledTask(Runnable runnable) {
        return f٥٠٥٥a.submit(runnable);
    }

    public static Future<?> submitScheduledTask(Runnable runnable, long j10, TimeUnit timeUnit) {
        return f٥٠٥٥a.schedule(runnable, j10, timeUnit);
    }
}
