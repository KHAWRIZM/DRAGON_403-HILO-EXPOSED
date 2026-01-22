package ce;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class o extends h0 {

    /* renamed from: a, reason: collision with root package name */
    private static final o f٦١٠٤a = new o();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f٦١٠٥a;

        /* renamed from: b, reason: collision with root package name */
        private final c f٦١٠٦b;

        /* renamed from: c, reason: collision with root package name */
        private final long f٦١٠٧c;

        a(Runnable runnable, c cVar, long j10) {
            this.f٦١٠٥a = runnable;
            this.f٦١٠٦b = cVar;
            this.f٦١٠٧c = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f٦١٠٦b.f٦١١٥d) {
                long now = this.f٦١٠٦b.now(TimeUnit.MILLISECONDS);
                long j10 = this.f٦١٠٧c;
                if (j10 > now) {
                    try {
                        Thread.sleep(j10 - now);
                    } catch (InterruptedException e10) {
                        Thread.currentThread().interrupt();
                        ie.a.s(e10);
                        return;
                    }
                }
                if (!this.f٦١٠٦b.f٦١١٥d) {
                    this.f٦١٠٥a.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        final Runnable f٦١٠٨a;

        /* renamed from: b, reason: collision with root package name */
        final long f٦١٠٩b;

        /* renamed from: c, reason: collision with root package name */
        final int f٦١١٠c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f٦١١١d;

        b(Runnable runnable, Long l10, int i10) {
            this.f٦١٠٨a = runnable;
            this.f٦١٠٩b = l10.longValue();
            this.f٦١١٠c = i10;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int compare = Long.compare(this.f٦١٠٩b, bVar.f٦١٠٩b);
            if (compare == 0) {
                return Integer.compare(this.f٦١١٠c, bVar.f٦١١٠c);
            }
            return compare;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class c extends h0.c implements nd.c {

        /* renamed from: a, reason: collision with root package name */
        final PriorityBlockingQueue f٦١١٢a = new PriorityBlockingQueue();

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f٦١١٣b = new AtomicInteger();

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f٦١١٤c = new AtomicInteger();

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f٦١١٥d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final b f٦١١٦a;

            a(b bVar) {
                this.f٦١١٦a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f٦١١٦a.f٦١١١d = true;
                c.this.f٦١١٢a.remove(this.f٦١١٦a);
            }
        }

        c() {
        }

        nd.c a(Runnable runnable, long j10) {
            if (this.f٦١١٥d) {
                return qd.d.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j10), this.f٦١١٤c.incrementAndGet());
            this.f٦١١٢a.add(bVar);
            if (this.f٦١١٣b.getAndIncrement() == 0) {
                int i10 = 1;
                while (!this.f٦١١٥d) {
                    b bVar2 = (b) this.f٦١١٢a.poll();
                    if (bVar2 == null) {
                        i10 = this.f٦١١٣b.addAndGet(-i10);
                        if (i10 == 0) {
                            return qd.d.INSTANCE;
                        }
                    } else if (!bVar2.f٦١١١d) {
                        bVar2.f٦١٠٨a.run();
                    }
                }
                this.f٦١١٢a.clear();
                return qd.d.INSTANCE;
            }
            return nd.b.b(new a(bVar));
        }

        @Override // nd.c
        public void dispose() {
            this.f٦١١٥d = true;
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٦١١٥d;
        }

        @Override // io.reactivex.rxjava3.core.h0.c
        public nd.c schedule(Runnable runnable) {
            return a(runnable, now(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.rxjava3.core.h0.c
        public nd.c schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            long now = now(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j10);
            return a(new a(runnable, this, now), now);
        }
    }

    o() {
    }

    public static o a() {
        return f٦١٠٤a;
    }

    @Override // io.reactivex.rxjava3.core.h0
    public h0.c createWorker() {
        return new c();
    }

    @Override // io.reactivex.rxjava3.core.h0
    public nd.c scheduleDirect(Runnable runnable) {
        ie.a.u(runnable).run();
        return qd.d.INSTANCE;
    }

    @Override // io.reactivex.rxjava3.core.h0
    public nd.c scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j10);
            ie.a.u(runnable).run();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            ie.a.s(e10);
        }
        return qd.d.INSTANCE;
    }
}
