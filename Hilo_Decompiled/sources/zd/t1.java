package zd;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class t1 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠٥٠٦a;

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٥٠٧b;

    /* renamed from: c, reason: collision with root package name */
    final long f٢٠٥٠٨c;

    /* renamed from: d, reason: collision with root package name */
    final long f٢٠٥٠٩d;

    /* renamed from: e, reason: collision with root package name */
    final long f٢٠٥١٠e;

    /* renamed from: f, reason: collision with root package name */
    final TimeUnit f٢٠٥١١f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements nd.c, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٥١٢a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٥١٣b;

        /* renamed from: c, reason: collision with root package name */
        long f٢٠٥١٤c;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, long j11) {
            this.f٢٠٥١٢a = g0Var;
            this.f٢٠٥١٤c = j10;
            this.f٢٠٥١٣b = j11;
        }

        public void a(nd.c cVar) {
            qd.c.g(this, cVar);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (get() == qd.c.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!isDisposed()) {
                long j10 = this.f٢٠٥١٤c;
                this.f٢٠٥١٢a.onNext(Long.valueOf(j10));
                if (j10 == this.f٢٠٥١٣b) {
                    if (!isDisposed()) {
                        this.f٢٠٥١٢a.onComplete();
                    }
                    qd.c.a(this);
                    return;
                }
                this.f٢٠٥١٤c = j10 + 1;
            }
        }
    }

    public t1(long j10, long j11, long j12, long j13, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
        this.f٢٠٥٠٩d = j12;
        this.f٢٠٥١٠e = j13;
        this.f٢٠٥١١f = timeUnit;
        this.f٢٠٥٠٦a = h0Var;
        this.f٢٠٥٠٧b = j10;
        this.f٢٠٥٠٨c = j11;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var, this.f٢٠٥٠٧b, this.f٢٠٥٠٨c);
        g0Var.onSubscribe(aVar);
        io.reactivex.rxjava3.core.h0 h0Var = this.f٢٠٥٠٦a;
        if (h0Var instanceof ce.o) {
            h0.c createWorker = h0Var.createWorker();
            aVar.a(createWorker);
            createWorker.schedulePeriodically(aVar, this.f٢٠٥٠٩d, this.f٢٠٥١٠e, this.f٢٠٥١١f);
            return;
        }
        aVar.a(h0Var.schedulePeriodicallyDirect(aVar, this.f٢٠٥٠٩d, this.f٢٠٥١٠e, this.f٢٠٥١١f));
    }
}
