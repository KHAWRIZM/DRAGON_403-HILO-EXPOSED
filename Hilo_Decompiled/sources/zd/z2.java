package zd;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class z2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٨٠٥b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f٢٠٨٠٦c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠٨٠٧d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f٢٠٨٠٨e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends c {
        private static final long serialVersionUID = -7139995637533111443L;

        /* renamed from: g, reason: collision with root package name */
        final AtomicInteger f٢٠٨٠٩g;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
            super(g0Var, j10, timeUnit, h0Var);
            this.f٢٠٨٠٩g = new AtomicInteger(1);
        }

        @Override // zd.z2.c
        void b() {
            c();
            if (this.f٢٠٨٠٩g.decrementAndGet() == 0) {
                this.f٢٠٨١٠a.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f٢٠٨٠٩g.incrementAndGet() == 2) {
                c();
                if (this.f٢٠٨٠٩g.decrementAndGet() == 0) {
                    this.f٢٠٨١٠a.onComplete();
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends c {
        private static final long serialVersionUID = -7139995637533111443L;

        b(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
            super(g0Var, j10, timeUnit, h0Var);
        }

        @Override // zd.z2.c
        void b() {
            this.f٢٠٨١٠a.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static abstract class c extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٨١٠a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٨١١b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f٢٠٨١٢c;

        /* renamed from: d, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f٢٠٨١٣d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference f٢٠٨١٤e = new AtomicReference();

        /* renamed from: f, reason: collision with root package name */
        nd.c f٢٠٨١٥f;

        c(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
            this.f٢٠٨١٠a = g0Var;
            this.f٢٠٨١١b = j10;
            this.f٢٠٨١٢c = timeUnit;
            this.f٢٠٨١٣d = h0Var;
        }

        void a() {
            qd.c.a(this.f٢٠٨١٤e);
        }

        abstract void b();

        void c() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.f٢٠٨١٠a.onNext(andSet);
            }
        }

        @Override // nd.c
        public void dispose() {
            a();
            this.f٢٠٨١٥f.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٨١٥f.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            a();
            b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            a();
            this.f٢٠٨١٠a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            lazySet(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٨١٥f, cVar)) {
                this.f٢٠٨١٥f = cVar;
                this.f٢٠٨١٠a.onSubscribe(this);
                io.reactivex.rxjava3.core.h0 h0Var = this.f٢٠٨١٣d;
                long j10 = this.f٢٠٨١١b;
                qd.c.d(this.f٢٠٨١٤e, h0Var.schedulePeriodicallyDirect(this, j10, j10, this.f٢٠٨١٢c));
            }
        }
    }

    public z2(io.reactivex.rxjava3.core.e0 e0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, boolean z10) {
        super(e0Var);
        this.f٢٠٨٠٥b = j10;
        this.f٢٠٨٠٦c = timeUnit;
        this.f٢٠٨٠٧d = h0Var;
        this.f٢٠٨٠٨e = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        he.e eVar = new he.e(g0Var);
        if (this.f٢٠٨٠٨e) {
            this.f١٩٥٣٢a.subscribe(new a(eVar, this.f٢٠٨٠٥b, this.f٢٠٨٠٦c, this.f٢٠٨٠٧d));
        } else {
            this.f١٩٥٣٢a.subscribe(new b(eVar, this.f٢٠٨٠٥b, this.f٢٠٨٠٦c, this.f٢٠٨٠٧d));
        }
    }
}
