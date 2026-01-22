package zd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.m0 f١٩٧١١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٧١٢a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference f١٩٧١٣b = new AtomicReference();

        /* renamed from: c, reason: collision with root package name */
        final C٠٢٦٢a f١٩٧١٤c = new C٠٢٦٢a(this);

        /* renamed from: d, reason: collision with root package name */
        final fe.c f١٩٧١٥d = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        volatile sd.i f١٩٧١٦e;

        /* renamed from: f, reason: collision with root package name */
        Object f١٩٧١٧f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f١٩٧١٨g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f١٩٧١٩h;

        /* renamed from: i, reason: collision with root package name */
        volatile int f١٩٧٢٠i;

        /* renamed from: zd.e2$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        static final class C٠٢٦٢a extends AtomicReference implements io.reactivex.rxjava3.core.k0 {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: a, reason: collision with root package name */
            final a f١٩٧٢١a;

            C٠٢٦٢a(a aVar) {
                this.f١٩٧٢١a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                this.f١٩٧٢١a.d(th);
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onSuccess(Object obj) {
                this.f١٩٧٢١a.e(obj);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f١٩٧١٢a = g0Var;
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        void b() {
            Object obj;
            boolean z10;
            io.reactivex.rxjava3.core.g0 g0Var = this.f١٩٧١٢a;
            int i10 = 1;
            while (!this.f١٩٧١٨g) {
                if (this.f١٩٧١٥d.get() != null) {
                    this.f١٩٧١٧f = null;
                    this.f١٩٧١٦e = null;
                    this.f١٩٧١٥d.f(g0Var);
                    return;
                }
                int i11 = this.f١٩٧٢٠i;
                if (i11 == 1) {
                    Object obj2 = this.f١٩٧١٧f;
                    this.f١٩٧١٧f = null;
                    this.f١٩٧٢٠i = 2;
                    g0Var.onNext(obj2);
                    i11 = 2;
                }
                boolean z11 = this.f١٩٧١٩h;
                sd.i iVar = this.f١٩٧١٦e;
                if (iVar != null) {
                    obj = iVar.poll();
                } else {
                    obj = null;
                }
                if (obj == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z11 && z10 && i11 == 2) {
                    this.f١٩٧١٦e = null;
                    g0Var.onComplete();
                    return;
                } else if (z10) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    g0Var.onNext(obj);
                }
            }
            this.f١٩٧١٧f = null;
            this.f١٩٧١٦e = null;
        }

        sd.i c() {
            sd.i iVar = this.f١٩٧١٦e;
            if (iVar == null) {
                be.c cVar = new be.c(io.reactivex.rxjava3.core.z.bufferSize());
                this.f١٩٧١٦e = cVar;
                return cVar;
            }
            return iVar;
        }

        void d(Throwable th) {
            if (this.f١٩٧١٥d.c(th)) {
                qd.c.a(this.f١٩٧١٣b);
                a();
            }
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٧١٨g = true;
            qd.c.a(this.f١٩٧١٣b);
            qd.c.a(this.f١٩٧١٤c);
            this.f١٩٧١٥d.d();
            if (getAndIncrement() == 0) {
                this.f١٩٧١٦e = null;
                this.f١٩٧١٧f = null;
            }
        }

        void e(Object obj) {
            if (compareAndSet(0, 1)) {
                this.f١٩٧١٢a.onNext(obj);
                this.f١٩٧٢٠i = 2;
            } else {
                this.f١٩٧١٧f = obj;
                this.f١٩٧٢٠i = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) this.f١٩٧١٣b.get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٧١٩h = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٧١٥d.c(th)) {
                qd.c.a(this.f١٩٧١٤c);
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (compareAndSet(0, 1)) {
                this.f١٩٧١٢a.onNext(obj);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(obj);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f١٩٧١٣b, cVar);
        }
    }

    public e2(io.reactivex.rxjava3.core.z zVar, io.reactivex.rxjava3.core.m0 m0Var) {
        super(zVar);
        this.f١٩٧١١b = m0Var;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var);
        g0Var.onSubscribe(aVar);
        this.f١٩٥٣٢a.subscribe(aVar);
        this.f١٩٧١١b.a(aVar.f١٩٧١٤c);
    }
}
