package ce;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f٦٠٧٦a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f٦٠٧٧b;

    /* renamed from: c, reason: collision with root package name */
    static final AtomicReference f٦٠٧٨c = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    static final Map f٦٠٧٩d = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(l.f٦٠٧٩d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    l.f٦٠٧٩d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b implements pd.o {
        b() {
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return System.getProperty(str);
        }
    }

    static {
        b bVar = new b();
        boolean b10 = b(true, "rx3.purge-enabled", true, true, bVar);
        f٦٠٧٦a = b10;
        f٦٠٧٧b = c(b10, "rx3.purge-period-seconds", 1, 1, bVar);
        d();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        e(f٦٠٧٦a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static boolean b(boolean z10, String str, boolean z11, boolean z12, pd.o oVar) {
        if (z10) {
            try {
                String str2 = (String) oVar.apply(str);
                if (str2 == null) {
                    return z11;
                }
                return "true".equals(str2);
            } catch (Throwable th) {
                od.b.b(th);
                return z11;
            }
        }
        return z12;
    }

    static int c(boolean z10, String str, int i10, int i11, pd.o oVar) {
        if (z10) {
            try {
                String str2 = (String) oVar.apply(str);
                if (str2 == null) {
                    return i10;
                }
                return Integer.parseInt(str2);
            } catch (Throwable th) {
                od.b.b(th);
                return i10;
            }
        }
        return i11;
    }

    public static void d() {
        f(f٦٠٧٦a);
    }

    static void e(boolean z10, ScheduledExecutorService scheduledExecutorService) {
        if (z10 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f٦٠٧٩d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void f(boolean z10) {
        if (!z10) {
            return;
        }
        while (true) {
            AtomicReference atomicReference = f٦٠٧٨c;
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new h("RxSchedulerPurge"));
            if (androidx.lifecycle.a.a(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                a aVar = new a();
                int i10 = f٦٠٧٧b;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, i10, i10, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }
}
