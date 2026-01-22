package zd;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class z3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٨١٦b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f٢٠٨١٧c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠٨١٨d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f٢٠٨١٩e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٨٢٠a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٨٢١b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f٢٠٨٢٢c;

        /* renamed from: d, reason: collision with root package name */
        final h0.c f٢٠٨٢٣d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f٢٠٨٢٤e;

        /* renamed from: f, reason: collision with root package name */
        final AtomicReference f٢٠٨٢٥f = new AtomicReference();

        /* renamed from: g, reason: collision with root package name */
        nd.c f٢٠٨٢٦g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f٢٠٨٢٧h;

        /* renamed from: i, reason: collision with root package name */
        Throwable f٢٠٨٢٨i;

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f٢٠٨٢٩j;

        /* renamed from: k, reason: collision with root package name */
        volatile boolean f٢٠٨٣٠k;

        /* renamed from: l, reason: collision with root package name */
        boolean f٢٠٨٣١l;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, h0.c cVar, boolean z10) {
            this.f٢٠٨٢٠a = g0Var;
            this.f٢٠٨٢١b = j10;
            this.f٢٠٨٢٢c = timeUnit;
            this.f٢٠٨٢٣d = cVar;
            this.f٢٠٨٢٤e = z10;
        }

        void a() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference atomicReference = this.f٢٠٨٢٥f;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٨٢٠a;
            int i10 = 1;
            while (!this.f٢٠٨٢٩j) {
                boolean z11 = this.f٢٠٨٢٧h;
                if (z11 && this.f٢٠٨٢٨i != null) {
                    atomicReference.lazySet(null);
                    g0Var.onError(this.f٢٠٨٢٨i);
                    this.f٢٠٨٢٣d.dispose();
                    return;
                }
                if (atomicReference.get() == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z11) {
                    Object andSet = atomicReference.getAndSet(null);
                    if (!z10 && this.f٢٠٨٢٤e) {
                        g0Var.onNext(andSet);
                    }
                    g0Var.onComplete();
                    this.f٢٠٨٢٣d.dispose();
                    return;
                }
                if (z10) {
                    if (this.f٢٠٨٣٠k) {
                        this.f٢٠٨٣١l = false;
                        this.f٢٠٨٣٠k = false;
                    }
                } else if (!this.f٢٠٨٣١l || this.f٢٠٨٣٠k) {
                    g0Var.onNext(atomicReference.getAndSet(null));
                    this.f٢٠٨٣٠k = false;
                    this.f٢٠٨٣١l = true;
                    this.f٢٠٨٢٣d.schedule(this, this.f٢٠٨٢١b, this.f٢٠٨٢٢c);
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٨٢٩j = true;
            this.f٢٠٨٢٦g.dispose();
            this.f٢٠٨٢٣d.dispose();
            if (getAndIncrement() == 0) {
                this.f٢٠٨٢٥f.lazySet(null);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٨٢٩j;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٨٢٧h = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٨٢٨i = th;
            this.f٢٠٨٢٧h = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٨٢٥f.set(obj);
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٨٢٦g, cVar)) {
                this.f٢٠٨٢٦g = cVar;
                this.f٢٠٨٢٠a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f٢٠٨٣٠k = true;
            a();
        }
    }

    public z3(io.reactivex.rxjava3.core.z zVar, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, boolean z10) {
        super(zVar);
        this.f٢٠٨١٦b = j10;
        this.f٢٠٨١٧c = timeUnit;
        this.f٢٠٨١٨d = h0Var;
        this.f٢٠٨١٩e = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٨١٦b, this.f٢٠٨١٧c, this.f٢٠٨١٨d.createWorker(), this.f٢٠٨١٩e));
    }
}
