package ce;

import io.reactivex.rxjava3.core.h0;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d extends h0 {

    /* renamed from: c, reason: collision with root package name */
    static final h f٦٠٤٥c;

    /* renamed from: d, reason: collision with root package name */
    static final h f٦٠٤٦d;

    /* renamed from: g, reason: collision with root package name */
    static final c f٦٠٤٩g;

    /* renamed from: h, reason: collision with root package name */
    static final a f٦٠٥٠h;

    /* renamed from: a, reason: collision with root package name */
    final ThreadFactory f٦٠٥١a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f٦٠٥٢b;

    /* renamed from: f, reason: collision with root package name */
    private static final TimeUnit f٦٠٤٨f = TimeUnit.SECONDS;

    /* renamed from: e, reason: collision with root package name */
    private static final long f٦٠٤٧e = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final long f٦٠٥٣a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue f٦٠٥٤b;

        /* renamed from: c, reason: collision with root package name */
        final nd.a f٦٠٥٥c;

        /* renamed from: d, reason: collision with root package name */
        private final ScheduledExecutorService f٦٠٥٦d;

        /* renamed from: e, reason: collision with root package name */
        private final Future f٦٠٥٧e;

        /* renamed from: f, reason: collision with root package name */
        private final ThreadFactory f٦٠٥٨f;

        a(long j10, TimeUnit timeUnit, ThreadFactory threadFactory) {
            long j11;
            ScheduledExecutorService scheduledExecutorService;
            ScheduledFuture<?> scheduledFuture;
            if (timeUnit != null) {
                j11 = timeUnit.toNanos(j10);
            } else {
                j11 = 0;
            }
            long j12 = j11;
            this.f٦٠٥٣a = j12;
            this.f٦٠٥٤b = new ConcurrentLinkedQueue();
            this.f٦٠٥٥c = new nd.a();
            this.f٦٠٥٨f = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.f٦٠٤٦d);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j12, j12, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.f٦٠٥٦d = scheduledExecutorService;
            this.f٦٠٥٧e = scheduledFuture;
        }

        static void a(ConcurrentLinkedQueue concurrentLinkedQueue, nd.a aVar) {
            if (!concurrentLinkedQueue.isEmpty()) {
                long c10 = c();
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.e() <= c10) {
                        if (concurrentLinkedQueue.remove(cVar)) {
                            aVar.b(cVar);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        static long c() {
            return System.nanoTime();
        }

        c b() {
            if (this.f٦٠٥٥c.isDisposed()) {
                return d.f٦٠٤٩g;
            }
            while (!this.f٦٠٥٤b.isEmpty()) {
                c cVar = (c) this.f٦٠٥٤b.poll();
                if (cVar != null) {
                    return cVar;
                }
            }
            c cVar2 = new c(this.f٦٠٥٨f);
            this.f٦٠٥٥c.a(cVar2);
            return cVar2;
        }

        void d(c cVar) {
            cVar.f(c() + this.f٦٠٥٣a);
            this.f٦٠٥٤b.offer(cVar);
        }

        void e() {
            this.f٦٠٥٥c.dispose();
            Future future = this.f٦٠٥٧e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f٦٠٥٦d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this.f٦٠٥٤b, this.f٦٠٥٥c);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends h0.c {

        /* renamed from: b, reason: collision with root package name */
        private final a f٦٠٦٠b;

        /* renamed from: c, reason: collision with root package name */
        private final c f٦٠٦١c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicBoolean f٦٠٦٢d = new AtomicBoolean();

        /* renamed from: a, reason: collision with root package name */
        private final nd.a f٦٠٥٩a = new nd.a();

        b(a aVar) {
            this.f٦٠٦٠b = aVar;
            this.f٦٠٦١c = aVar.b();
        }

        @Override // nd.c
        public void dispose() {
            if (this.f٦٠٦٢d.compareAndSet(false, true)) {
                this.f٦٠٥٩a.dispose();
                this.f٦٠٦٠b.d(this.f٦٠٦١c);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٦٠٦٢d.get();
        }

        @Override // io.reactivex.rxjava3.core.h0.c
        public nd.c schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f٦٠٥٩a.isDisposed()) {
                return qd.d.INSTANCE;
            }
            return this.f٦٠٦١c.a(runnable, j10, timeUnit, this.f٦٠٥٩a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class c extends f {

        /* renamed from: c, reason: collision with root package name */
        long f٦٠٦٣c;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f٦٠٦٣c = 0L;
        }

        public long e() {
            return this.f٦٠٦٣c;
        }

        public void f(long j10) {
            this.f٦٠٦٣c = j10;
        }
    }

    static {
        c cVar = new c(new h("RxCachedThreadSchedulerShutdown"));
        f٦٠٤٩g = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        h hVar = new h("RxCachedThreadScheduler", max);
        f٦٠٤٥c = hVar;
        f٦٠٤٦d = new h("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0L, null, hVar);
        f٦٠٥٠h = aVar;
        aVar.e();
    }

    public d() {
        this(f٦٠٤٥c);
    }

    @Override // io.reactivex.rxjava3.core.h0
    public h0.c createWorker() {
        return new b((a) this.f٦٠٥٢b.get());
    }

    @Override // io.reactivex.rxjava3.core.h0
    public void start() {
        a aVar = new a(f٦٠٤٧e, f٦٠٤٨f, this.f٦٠٥١a);
        if (!androidx.lifecycle.a.a(this.f٦٠٥٢b, f٦٠٥٠h, aVar)) {
            aVar.e();
        }
    }

    public d(ThreadFactory threadFactory) {
        this.f٦٠٥١a = threadFactory;
        this.f٦٠٥٢b = new AtomicReference(f٦٠٥٠h);
        start();
    }
}
