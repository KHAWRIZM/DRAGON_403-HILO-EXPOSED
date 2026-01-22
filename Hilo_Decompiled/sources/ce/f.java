package ce;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class f extends h0.c implements nd.c {

    /* renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f٦٠٦٦a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f٦٠٦٧b;

    public f(ThreadFactory threadFactory) {
        this.f٦٠٦٦a = l.a(threadFactory);
    }

    public k a(Runnable runnable, long j10, TimeUnit timeUnit, nd.d dVar) {
        Future schedule;
        k kVar = new k(ie.a.u(runnable), dVar);
        if (dVar != null && !dVar.a(kVar)) {
            return kVar;
        }
        try {
            if (j10 <= 0) {
                schedule = this.f٦٠٦٦a.submit((Callable) kVar);
            } else {
                schedule = this.f٦٠٦٦a.schedule((Callable) kVar, j10, timeUnit);
            }
            kVar.a(schedule);
        } catch (RejectedExecutionException e10) {
            if (dVar != null) {
                dVar.b(kVar);
            }
            ie.a.s(e10);
        }
        return kVar;
    }

    public nd.c b(Runnable runnable, long j10, TimeUnit timeUnit) {
        Future schedule;
        j jVar = new j(ie.a.u(runnable));
        try {
            if (j10 <= 0) {
                schedule = this.f٦٠٦٦a.submit(jVar);
            } else {
                schedule = this.f٦٠٦٦a.schedule(jVar, j10, timeUnit);
            }
            jVar.a(schedule);
            return jVar;
        } catch (RejectedExecutionException e10) {
            ie.a.s(e10);
            return qd.d.INSTANCE;
        }
    }

    public nd.c c(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Future schedule;
        Runnable u10 = ie.a.u(runnable);
        if (j11 <= 0) {
            c cVar = new c(u10, this.f٦٠٦٦a);
            try {
                if (j10 <= 0) {
                    schedule = this.f٦٠٦٦a.submit(cVar);
                } else {
                    schedule = this.f٦٠٦٦a.schedule(cVar, j10, timeUnit);
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
            iVar.a(this.f٦٠٦٦a.scheduleAtFixedRate(iVar, j10, j11, timeUnit));
            return iVar;
        } catch (RejectedExecutionException e11) {
            ie.a.s(e11);
            return qd.d.INSTANCE;
        }
    }

    public void d() {
        if (!this.f٦٠٦٧b) {
            this.f٦٠٦٧b = true;
            this.f٦٠٦٦a.shutdown();
        }
    }

    @Override // nd.c
    public void dispose() {
        if (!this.f٦٠٦٧b) {
            this.f٦٠٦٧b = true;
            this.f٦٠٦٦a.shutdownNow();
        }
    }

    @Override // nd.c
    public boolean isDisposed() {
        return this.f٦٠٦٧b;
    }

    @Override // io.reactivex.rxjava3.core.h0.c
    public nd.c schedule(Runnable runnable) {
        return schedule(runnable, 0L, null);
    }

    @Override // io.reactivex.rxjava3.core.h0.c
    public nd.c schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (this.f٦٠٦٧b) {
            return qd.d.INSTANCE;
        }
        return a(runnable, j10, timeUnit, null);
    }
}
