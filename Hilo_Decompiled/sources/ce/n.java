package ce;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class n extends h0 {

    /* renamed from: c, reason: collision with root package name */
    static final h f٦٠٩٧c;

    /* renamed from: d, reason: collision with root package name */
    static final ScheduledExecutorService f٦٠٩٨d;

    /* renamed from: a, reason: collision with root package name */
    final ThreadFactory f٦٠٩٩a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f٦١٠٠b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends h0.c {

        /* renamed from: a, reason: collision with root package name */
        final ScheduledExecutorService f٦١٠١a;

        /* renamed from: b, reason: collision with root package name */
        final nd.a f٦١٠٢b = new nd.a();

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f٦١٠٣c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f٦١٠١a = scheduledExecutorService;
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f٦١٠٣c) {
                this.f٦١٠٣c = true;
                this.f٦١٠٢b.dispose();
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٦١٠٣c;
        }

        @Override // io.reactivex.rxjava3.core.h0.c
        public nd.c schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            Future schedule;
            if (this.f٦١٠٣c) {
                return qd.d.INSTANCE;
            }
            k kVar = new k(ie.a.u(runnable), this.f٦١٠٢b);
            this.f٦١٠٢b.a(kVar);
            try {
                if (j10 <= 0) {
                    schedule = this.f٦١٠١a.submit((Callable) kVar);
                } else {
                    schedule = this.f٦١٠١a.schedule((Callable) kVar, j10, timeUnit);
                }
                kVar.a(schedule);
                return kVar;
            } catch (RejectedExecutionException e10) {
                dispose();
                ie.a.s(e10);
                return qd.d.INSTANCE;
            }
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f٦٠٩٨d = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f٦٠٩٧c = new h("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())), true);
    }

    public n() {
        this(f٦٠٩٧c);
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return l.a(threadFactory);
    }

    @Override // io.reactivex.rxjava3.core.h0
    public h0.c createWorker() {
        return new a((ScheduledExecutorService) this.f٦١٠٠b.get());
    }

    @Override // io.reactivex.rxjava3.core.h0
    public nd.c scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) {
        Future schedule;
        j jVar = new j(ie.a.u(runnable));
        try {
            if (j10 <= 0) {
                schedule = ((ScheduledExecutorService) this.f٦١٠٠b.get()).submit(jVar);
            } else {
                schedule = ((ScheduledExecutorService) this.f٦١٠٠b.get()).schedule(jVar, j10, timeUnit);
            }
            jVar.a(schedule);
            return jVar;
        } catch (RejectedExecutionException e10) {
            ie.a.s(e10);
            return qd.d.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.h0
    public nd.c schedulePeriodicallyDirect(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Future schedule;
        Runnable u10 = ie.a.u(runnable);
        if (j11 <= 0) {
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f٦١٠٠b.get();
            c cVar = new c(u10, scheduledExecutorService);
            try {
                if (j10 <= 0) {
                    schedule = scheduledExecutorService.submit(cVar);
                } else {
                    schedule = scheduledExecutorService.schedule(cVar, j10, timeUnit);
                }
                cVar.b(schedule);
                return cVar;
            } catch (RejectedExecutionException e10) {
                ie.a.s(e10);
                return qd.d.INSTANCE;
            }
        }
        i iVar = new i(u10);
        try {
            iVar.a(((ScheduledExecutorService) this.f٦١٠٠b.get()).scheduleAtFixedRate(iVar, j10, j11, timeUnit));
            return iVar;
        } catch (RejectedExecutionException e11) {
            ie.a.s(e11);
            return qd.d.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.h0
    public void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = (ScheduledExecutorService) this.f٦١٠٠b.get();
            if (scheduledExecutorService != f٦٠٩٨d) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = a(this.f٦٠٩٩a);
            }
        } while (!androidx.lifecycle.a.a(this.f٦١٠٠b, scheduledExecutorService, scheduledExecutorService2));
    }

    public n(ThreadFactory threadFactory) {
        AtomicReference atomicReference = new AtomicReference();
        this.f٦١٠٠b = atomicReference;
        this.f٦٠٩٩a = threadFactory;
        atomicReference.lazySet(a(threadFactory));
    }
}
