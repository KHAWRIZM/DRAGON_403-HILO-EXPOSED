package zd;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class s1 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠٤٦٠a;

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٤٦١b;

    /* renamed from: c, reason: collision with root package name */
    final long f٢٠٤٦٢c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f٢٠٤٦٣d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements nd.c, Runnable {
        private static final long serialVersionUID = 346773832286157679L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٤٦٤a;

        /* renamed from: b, reason: collision with root package name */
        long f٢٠٤٦٥b;

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٤٦٤a = g0Var;
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
            if (get() != qd.c.DISPOSED) {
                io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٤٦٤a;
                long j10 = this.f٢٠٤٦٥b;
                this.f٢٠٤٦٥b = 1 + j10;
                g0Var.onNext(Long.valueOf(j10));
            }
        }
    }

    public s1(long j10, long j11, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
        this.f٢٠٤٦١b = j10;
        this.f٢٠٤٦٢c = j11;
        this.f٢٠٤٦٣d = timeUnit;
        this.f٢٠٤٦٠a = h0Var;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var);
        g0Var.onSubscribe(aVar);
        io.reactivex.rxjava3.core.h0 h0Var = this.f٢٠٤٦٠a;
        if (h0Var instanceof ce.o) {
            h0.c createWorker = h0Var.createWorker();
            aVar.a(createWorker);
            createWorker.schedulePeriodically(aVar, this.f٢٠٤٦١b, this.f٢٠٤٦٢c, this.f٢٠٤٦٣d);
            return;
        }
        aVar.a(h0Var.schedulePeriodicallyDirect(aVar, this.f٢٠٤٦١b, this.f٢٠٤٦٢c, this.f٢٠٤٦٣d));
    }
}
