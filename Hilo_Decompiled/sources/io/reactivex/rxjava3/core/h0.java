package io.reactivex.rxjava3.core;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class h0 {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = computeClockDrift(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a implements nd.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f١٤٩٦٤a;

        /* renamed from: b, reason: collision with root package name */
        final c f١٤٩٦٥b;

        /* renamed from: c, reason: collision with root package name */
        Thread f١٤٩٦٦c;

        a(Runnable runnable, c cVar) {
            this.f١٤٩٦٤a = runnable;
            this.f١٤٩٦٥b = cVar;
        }

        @Override // nd.c
        public void dispose() {
            if (this.f١٤٩٦٦c == Thread.currentThread()) {
                c cVar = this.f١٤٩٦٥b;
                if (cVar instanceof ce.f) {
                    ((ce.f) cVar).d();
                    return;
                }
            }
            this.f١٤٩٦٥b.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٤٩٦٥b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f١٤٩٦٦c = Thread.currentThread();
            try {
                this.f١٤٩٦٤a.run();
            } finally {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b implements nd.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f١٤٩٦٧a;

        /* renamed from: b, reason: collision with root package name */
        final c f١٤٩٦٨b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f١٤٩٦٩c;

        b(Runnable runnable, c cVar) {
            this.f١٤٩٦٧a = runnable;
            this.f١٤٩٦٨b = cVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٤٩٦٩c = true;
            this.f١٤٩٦٨b.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٤٩٦٩c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f١٤٩٦٩c) {
                try {
                    this.f١٤٩٦٧a.run();
                } catch (Throwable th) {
                    dispose();
                    ie.a.s(th);
                    throw th;
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static abstract class c implements nd.c {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final Runnable f١٤٩٧٠a;

            /* renamed from: b, reason: collision with root package name */
            final qd.f f١٤٩٧١b;

            /* renamed from: c, reason: collision with root package name */
            final long f١٤٩٧٢c;

            /* renamed from: d, reason: collision with root package name */
            long f١٤٩٧٣d;

            /* renamed from: e, reason: collision with root package name */
            long f١٤٩٧٤e;

            /* renamed from: f, reason: collision with root package name */
            long f١٤٩٧٥f;

            a(long j10, Runnable runnable, long j11, qd.f fVar, long j12) {
                this.f١٤٩٧٠a = runnable;
                this.f١٤٩٧١b = fVar;
                this.f١٤٩٧٢c = j12;
                this.f١٤٩٧٤e = j11;
                this.f١٤٩٧٥f = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j10;
                this.f١٤٩٧٠a.run();
                if (!this.f١٤٩٧١b.isDisposed()) {
                    c cVar = c.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long now = cVar.now(timeUnit);
                    long j11 = h0.CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
                    long j12 = now + j11;
                    long j13 = this.f١٤٩٧٤e;
                    if (j12 >= j13) {
                        long j14 = this.f١٤٩٧٢c;
                        if (now < j13 + j14 + j11) {
                            long j15 = this.f١٤٩٧٥f;
                            long j16 = this.f١٤٩٧٣d + 1;
                            this.f١٤٩٧٣d = j16;
                            j10 = j15 + (j16 * j14);
                            this.f١٤٩٧٤e = now;
                            this.f١٤٩٧١b.a(c.this.schedule(this, j10 - now, timeUnit));
                        }
                    }
                    long j17 = this.f١٤٩٧٢c;
                    long j18 = now + j17;
                    long j19 = this.f١٤٩٧٣d + 1;
                    this.f١٤٩٧٣d = j19;
                    this.f١٤٩٧٥f = j18 - (j17 * j19);
                    j10 = j18;
                    this.f١٤٩٧٤e = now;
                    this.f١٤٩٧١b.a(c.this.schedule(this, j10 - now, timeUnit));
                }
            }
        }

        public long now(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public nd.c schedule(Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract nd.c schedule(Runnable runnable, long j10, TimeUnit timeUnit);

        public nd.c schedulePeriodically(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            qd.f fVar = new qd.f();
            qd.f fVar2 = new qd.f(fVar);
            Runnable u10 = ie.a.u(runnable);
            long nanos = timeUnit.toNanos(j11);
            long now = now(TimeUnit.NANOSECONDS);
            nd.c schedule = schedule(new a(now + timeUnit.toNanos(j10), u10, now, fVar2, nanos), j10, timeUnit);
            if (schedule == qd.d.INSTANCE) {
                return schedule;
            }
            fVar.a(schedule);
            return fVar2;
        }
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    static long computeClockDrift(long j10, String str) {
        if ("seconds".equalsIgnoreCase(str)) {
            return TimeUnit.SECONDS.toNanos(j10);
        }
        if ("milliseconds".equalsIgnoreCase(str)) {
            return TimeUnit.MILLISECONDS.toNanos(j10);
        }
        return TimeUnit.MINUTES.toNanos(j10);
    }

    public abstract c createWorker();

    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public nd.c scheduleDirect(Runnable runnable) {
        return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public nd.c schedulePeriodicallyDirect(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        c createWorker = createWorker();
        b bVar = new b(ie.a.u(runnable), createWorker);
        nd.c schedulePeriodically = createWorker.schedulePeriodically(bVar, j10, j11, timeUnit);
        if (schedulePeriodically == qd.d.INSTANCE) {
            return schedulePeriodically;
        }
        return bVar;
    }

    public void start() {
    }

    public <S extends h0 & nd.c> S when(pd.o oVar) {
        Objects.requireNonNull(oVar, "combine is null");
        return new ce.m(oVar, this);
    }

    public nd.c scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) {
        c createWorker = createWorker();
        a aVar = new a(ie.a.u(runnable), createWorker);
        createWorker.schedule(aVar, j10, timeUnit);
        return aVar;
    }
}
