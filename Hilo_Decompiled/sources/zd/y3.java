package zd;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class y3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٧٧٩b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f٢٠٧٨٠c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠٧٨١d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c, Runnable {
        private static final long serialVersionUID = 786994795061867455L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٧٨٢a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٧٨٣b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f٢٠٧٨٤c;

        /* renamed from: d, reason: collision with root package name */
        final h0.c f٢٠٧٨٥d;

        /* renamed from: e, reason: collision with root package name */
        nd.c f٢٠٧٨٦e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f٢٠٧٨٧f;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, h0.c cVar) {
            this.f٢٠٧٨٢a = g0Var;
            this.f٢٠٧٨٣b = j10;
            this.f٢٠٧٨٤c = timeUnit;
            this.f٢٠٧٨٥d = cVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٧٨٦e.dispose();
            this.f٢٠٧٨٥d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٧٨٥d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٧٨٢a.onComplete();
            this.f٢٠٧٨٥d.dispose();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٧٨٢a.onError(th);
            this.f٢٠٧٨٥d.dispose();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (!this.f٢٠٧٨٧f) {
                this.f٢٠٧٨٧f = true;
                this.f٢٠٧٨٢a.onNext(obj);
                nd.c cVar = (nd.c) get();
                if (cVar != null) {
                    cVar.dispose();
                }
                qd.c.d(this, this.f٢٠٧٨٥d.schedule(this, this.f٢٠٧٨٣b, this.f٢٠٧٨٤c));
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٧٨٦e, cVar)) {
                this.f٢٠٧٨٦e = cVar;
                this.f٢٠٧٨٢a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f٢٠٧٨٧f = false;
        }
    }

    public y3(io.reactivex.rxjava3.core.e0 e0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
        super(e0Var);
        this.f٢٠٧٧٩b = j10;
        this.f٢٠٧٨٠c = timeUnit;
        this.f٢٠٧٨١d = h0Var;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(new he.e(g0Var), this.f٢٠٧٧٩b, this.f٢٠٧٨٠c, this.f٢٠٧٨١d.createWorker()));
    }
}
