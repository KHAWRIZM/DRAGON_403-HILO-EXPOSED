package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class z0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٧٩١b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f٢٠٧٩٢c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 8600231336733376951L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٧٩٣a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f٢٠٧٩٤b;

        /* renamed from: f, reason: collision with root package name */
        final pd.o f٢٠٧٩٨f;

        /* renamed from: h, reason: collision with root package name */
        nd.c f٢٠٨٠٠h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f٢٠٨٠١i;

        /* renamed from: c, reason: collision with root package name */
        final nd.a f٢٠٧٩٥c = new nd.a();

        /* renamed from: e, reason: collision with root package name */
        final fe.c f٢٠٧٩٧e = new fe.c();

        /* renamed from: d, reason: collision with root package name */
        final AtomicInteger f٢٠٧٩٦d = new AtomicInteger(1);

        /* renamed from: g, reason: collision with root package name */
        final AtomicReference f٢٠٧٩٩g = new AtomicReference();

        /* renamed from: zd.z0$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class C٠٢٧٦a extends AtomicReference implements io.reactivex.rxjava3.core.k0, nd.c {
            private static final long serialVersionUID = -502562646270949838L;

            C٠٢٧٦a() {
            }

            @Override // nd.c
            public void dispose() {
                qd.c.a(this);
            }

            @Override // nd.c
            public boolean isDisposed() {
                return qd.c.c((nd.c) get());
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                a.this.e(this, th);
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onSuccess(Object obj) {
                a.this.f(this, obj);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, boolean z10) {
            this.f٢٠٧٩٣a = g0Var;
            this.f٢٠٧٩٨f = oVar;
            this.f٢٠٧٩٤b = z10;
        }

        void a() {
            be.c cVar = (be.c) this.f٢٠٧٩٩g.get();
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
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٧٩٣a;
            AtomicInteger atomicInteger = this.f٢٠٧٩٦d;
            AtomicReference atomicReference = this.f٢٠٧٩٩g;
            int i10 = 1;
            while (!this.f٢٠٨٠١i) {
                if (!this.f٢٠٧٩٤b && ((Throwable) this.f٢٠٧٩٧e.get()) != null) {
                    a();
                    this.f٢٠٧٩٧e.f(g0Var);
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
                    this.f٢٠٧٩٧e.f(this.f٢٠٧٩٣a);
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
            be.c cVar = (be.c) this.f٢٠٧٩٩g.get();
            if (cVar != null) {
                return cVar;
            }
            be.c cVar2 = new be.c(io.reactivex.rxjava3.core.z.bufferSize());
            if (androidx.lifecycle.a.a(this.f٢٠٧٩٩g, null, cVar2)) {
                return cVar2;
            }
            return (be.c) this.f٢٠٧٩٩g.get();
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٨٠١i = true;
            this.f٢٠٨٠٠h.dispose();
            this.f٢٠٧٩٥c.dispose();
            this.f٢٠٧٩٧e.d();
        }

        void e(C٠٢٧٦a r22, Throwable th) {
            this.f٢٠٧٩٥c.c(r22);
            if (this.f٢٠٧٩٧e.c(th)) {
                if (!this.f٢٠٧٩٤b) {
                    this.f٢٠٨٠٠h.dispose();
                    this.f٢٠٧٩٥c.dispose();
                }
                this.f٢٠٧٩٦d.decrementAndGet();
                b();
            }
        }

        void f(C٠٢٧٦a r32, Object obj) {
            this.f٢٠٧٩٥c.c(r32);
            if (get() == 0) {
                boolean z10 = false;
                if (compareAndSet(0, 1)) {
                    this.f٢٠٧٩٣a.onNext(obj);
                    if (this.f٢٠٧٩٦d.decrementAndGet() == 0) {
                        z10 = true;
                    }
                    be.c cVar = (be.c) this.f٢٠٧٩٩g.get();
                    if (z10 && (cVar == null || cVar.isEmpty())) {
                        this.f٢٠٧٩٧e.f(this.f٢٠٧٩٣a);
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
            this.f٢٠٧٩٦d.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٨٠١i;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٧٩٦d.decrementAndGet();
            b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٧٩٦d.decrementAndGet();
            if (this.f٢٠٧٩٧e.c(th)) {
                if (!this.f٢٠٧٩٤b) {
                    this.f٢٠٧٩٥c.dispose();
                }
                b();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            try {
                Object apply = this.f٢٠٧٩٨f.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                io.reactivex.rxjava3.core.m0 m0Var = (io.reactivex.rxjava3.core.m0) apply;
                this.f٢٠٧٩٦d.getAndIncrement();
                C٠٢٧٦a r02 = new C٠٢٧٦a();
                if (!this.f٢٠٨٠١i && this.f٢٠٧٩٥c.a(r02)) {
                    m0Var.a(r02);
                }
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠٨٠٠h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٨٠٠h, cVar)) {
                this.f٢٠٨٠٠h = cVar;
                this.f٢٠٧٩٣a.onSubscribe(this);
            }
        }
    }

    public z0(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, boolean z10) {
        super(e0Var);
        this.f٢٠٧٩١b = oVar;
        this.f٢٠٧٩٢c = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٧٩١b, this.f٢٠٧٩٢c));
    }
}
