package x3;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g implements ThreadFactory {

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f١٨٩٠١d = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f١٨٩٠٢a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f١٨٩٠٣b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    private final String f١٨٩٠٤c;

    public g() {
        ThreadGroup threadGroup;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            threadGroup = Thread.currentThread().getThreadGroup();
        } else {
            threadGroup = securityManager.getThreadGroup();
        }
        this.f١٨٩٠٢a = threadGroup;
        this.f١٨٩٠٤c = "lottie-" + f١٨٩٠١d.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f١٨٩٠٢a, runnable, this.f١٨٩٠٤c + this.f١٨٩٠٣b.getAndIncrement(), 0L);
        thread.setDaemon(false);
        thread.setPriority(10);
        return thread;
    }
}
