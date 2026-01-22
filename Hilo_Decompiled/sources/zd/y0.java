package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class y0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٧٥٧b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f٢٠٧٥٨c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٧٥٩a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f٢٠٧٦٠b;

        /* renamed from: f, reason: collision with root package name */
        final pd.o f٢٠٧٦٤f;

        /* renamed from: h, reason: collision with root package name */
        nd.c f٢٠٧٦٦h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f٢٠٧٦٧i;

        /* renamed from: c, reason: collision with root package name */
        final nd.a f٢٠٧٦١c = new nd.a();

        /* renamed from: e, reason: collision with root package name */
        final fe.c f٢٠٧٦٣e = new fe.c();

        /* renamed from: d, reason: collision with root package name */
        final AtomicInteger f٢٠٧٦٢d = new AtomicInteger(1);

        /* renamed from: g, reason: collision with root package name */
        final AtomicReference f٢٠٧٦٥g = new AtomicReference();

        /* renamed from: zd.y0$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class C٠٢٧٤a extends AtomicReference implements io.reactivex.rxjava3.core.l, nd.c {
            private static final long serialVersionUID = -502562646270949838L;

            C٠٢٧٤a() {
            }

            @Override // nd.c
            public void dispose() {
                qd.c.a(this);
            }

            @Override // nd.c
            public boolean isDisposed() {
                return qd.c.c((nd.c) get());
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                a.this.e(this);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                a.this.f(this, th);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSuccess(Object obj) {
                a.this.g(this, obj);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, boolean z10) {
            this.f٢٠٧٥٩a = g0Var;
            this.f٢٠٧٦٤f = oVar;
            this.f٢٠٧٦٠b = z10;
        }

        void a() {
            be.c cVar = (be.c) this.f٢٠٧٦٥g.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        void c() {
            boolean z10;
            Object obj;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٧٥٩a;
            AtomicInteger atomicInteger = this.f٢٠٧٦٢d;
            AtomicReference atomicReference = this.f٢٠٧٦٥g;
            int i10 = 1;
            while (!this.f٢٠٧٦٧i) {
                if (!this.f٢٠٧٦٠b && ((Throwable) this.f٢٠٧٦٣e.get()) != null) {
                    a();
                    this.f٢٠٧٦٣e.f(g0Var);
                    return;
                }
                boolean z11 = false;
                if (atomicInteger.get() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                be.c cVar = (be.c) atomicReference.get();
                if (cVar != null) {
                    obj = cVar.poll();
                } else {
                    obj = null;
                }
                if (obj == null) {
                    z11 = true;
                }
                if (z10 && z11) {
                    this.f٢٠٧٦٣e.f(g0Var);
                    return;
                } else if (z11) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    g0Var.onNext(obj);
                }
            }
            a();
        }

        be.c d() {
            be.c cVar = (be.c) this.f٢٠٧٦٥g.get();
            if (cVar != null) {
                return cVar;
            }
            be.c cVar2 = new be.c(io.reactivex.rxjava3.core.z.bufferSize());
            if (androidx.lifecycle.a.a(this.f٢٠٧٦٥g, null, cVar2)) {
                return cVar2;
            }
            return (be.c) this.f٢٠٧٦٥g.get();
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٧٦٧i = true;
            this.f٢٠٧٦٦h.dispose();
            this.f٢٠٧٦١c.dispose();
            this.f٢٠٧٦٣e.d();
        }

        void e(C٠٢٧٤a r32) {
            this.f٢٠٧٦١c.c(r32);
            if (get() == 0) {
                boolean z10 = false;
                if (compareAndSet(0, 1)) {
                    if (this.f٢٠٧٦٢d.decrementAndGet() == 0) {
                        z10 = true;
                    }
                    be.c cVar = (be.c) this.f٢٠٧٦٥g.get();
                    if (z10 && (cVar == null || cVar.isEmpty())) {
                        this.f٢٠٧٦٣e.f(this.f٢٠٧٥٩a);
                        return;
                    } else {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        c();
                        return;
                    }
                }
            }
            this.f٢٠٧٦٢d.decrementAndGet();
            b();
        }

        void f(C٠٢٧٤a r22, Throwable th) {
            this.f٢٠٧٦١c.c(r22);
            if (this.f٢٠٧٦٣e.c(th)) {
                if (!this.f٢٠٧٦٠b) {
                    this.f٢٠٧٦٦h.dispose();
                    this.f٢٠٧٦١c.dispose();
                }
                this.f٢٠٧٦٢d.decrementAndGet();
                b();
            }
        }

        void g(C٠٢٧٤a r32, Object obj) {
            this.f٢٠٧٦١c.c(r32);
            if (get() == 0) {
                boolean z10 = false;
                if (compareAndSet(0, 1)) {
                    this.f٢٠٧٥٩a.onNext(obj);
                    if (this.f٢٠٧٦٢d.decrementAndGet() == 0) {
                        z10 = true;
                    }
                    be.c cVar = (be.c) this.f٢٠٧٦٥g.get();
                    if (z10 && (cVar == null || cVar.isEmpty())) {
                        this.f٢٠٧٦٣e.f(this.f٢٠٧٥٩a);
                        return;
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    c();
                }
            }
            be.c d10 = d();
            synchronized (d10) {
                d10.offer(obj);
            }
            this.f٢٠٧٦٢d.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٧٦٧i;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٧٦٢d.decrementAndGet();
            b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٧٦٢d.decrementAndGet();
            if (this.f٢٠٧٦٣e.c(th)) {
                if (!this.f٢٠٧٦٠b) {
                    this.f٢٠٧٦١c.dispose();
                }
                b();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            try {
                Object apply = this.f٢٠٧٦٤f.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                io.reactivex.rxjava3.core.n nVar = (io.reactivex.rxjava3.core.n) apply;
                this.f٢٠٧٦٢d.getAndIncrement();
                C٠٢٧٤a r02 = new C٠٢٧٤a();
                if (!this.f٢٠٧٦٧i && this.f٢٠٧٦١c.a(r02)) {
                    nVar.a(r02);
                }
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠٧٦٦h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٧٦٦h, cVar)) {
                this.f٢٠٧٦٦h = cVar;
                this.f٢٠٧٥٩a.onSubscribe(this);
            }
        }
    }

    public y0(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, boolean z10) {
        super(e0Var);
        this.f٢٠٧٥٧b = oVar;
        this.f٢٠٧٥٨c = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٧٥٧b, this.f٢٠٧٥٨c));
    }
}
