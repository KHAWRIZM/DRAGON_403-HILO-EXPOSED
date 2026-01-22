package zd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.n f١٩٦٧٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٦٧٦a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference f١٩٦٧٧b = new AtomicReference();

        /* renamed from: c, reason: collision with root package name */
        final C٠٢٦١a f١٩٦٧٨c = new C٠٢٦١a(this);

        /* renamed from: d, reason: collision with root package name */
        final fe.c f١٩٦٧٩d = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        volatile sd.i f١٩٦٨٠e;

        /* renamed from: f, reason: collision with root package name */
        Object f١٩٦٨١f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f١٩٦٨٢g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f١٩٦٨٣h;

        /* renamed from: i, reason: collision with root package name */
        volatile int f١٩٦٨٤i;

        /* renamed from: zd.d2$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        static final class C٠٢٦١a extends AtomicReference implements io.reactivex.rxjava3.core.l {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: a, reason: collision with root package name */
            final a f١٩٦٨٥a;

            C٠٢٦١a(a aVar) {
                this.f١٩٦٨٥a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                this.f١٩٦٨٥a.d();
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                this.f١٩٦٨٥a.e(th);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSuccess(Object obj) {
                this.f١٩٦٨٥a.f(obj);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f١٩٦٧٦a = g0Var;
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        void b() {
            Object obj;
            boolean z10;
            io.reactivex.rxjava3.core.g0 g0Var = this.f١٩٦٧٦a;
            int i10 = 1;
            while (!this.f١٩٦٨٢g) {
                if (this.f١٩٦٧٩d.get() != null) {
                    this.f١٩٦٨١f = null;
                    this.f١٩٦٨٠e = null;
                    this.f١٩٦٧٩d.f(g0Var);
                    return;
                }
                int i11 = this.f١٩٦٨٤i;
                if (i11 == 1) {
                    Object obj2 = this.f١٩٦٨١f;
                    this.f١٩٦٨١f = null;
                    this.f١٩٦٨٤i = 2;
                    g0Var.onNext(obj2);
                    i11 = 2;
                }
                boolean z11 = this.f١٩٦٨٣h;
                sd.i iVar = this.f١٩٦٨٠e;
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
                    this.f١٩٦٨٠e = null;
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
            this.f١٩٦٨١f = null;
            this.f١٩٦٨٠e = null;
        }

        sd.i c() {
            sd.i iVar = this.f١٩٦٨٠e;
            if (iVar == null) {
                be.c cVar = new be.c(io.reactivex.rxjava3.core.z.bufferSize());
                this.f١٩٦٨٠e = cVar;
                return cVar;
            }
            return iVar;
        }

        void d() {
            this.f١٩٦٨٤i = 2;
            a();
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٦٨٢g = true;
            qd.c.a(this.f١٩٦٧٧b);
            qd.c.a(this.f١٩٦٧٨c);
            this.f١٩٦٧٩d.d();
            if (getAndIncrement() == 0) {
                this.f١٩٦٨٠e = null;
                this.f١٩٦٨١f = null;
            }
        }

        void e(Throwable th) {
            if (this.f١٩٦٧٩d.c(th)) {
                qd.c.a(this.f١٩٦٧٧b);
                a();
            }
        }

        void f(Object obj) {
            if (compareAndSet(0, 1)) {
                this.f١٩٦٧٦a.onNext(obj);
                this.f١٩٦٨٤i = 2;
            } else {
                this.f١٩٦٨١f = obj;
                this.f١٩٦٨٤i = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) this.f١٩٦٧٧b.get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٦٨٣h = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٦٧٩d.c(th)) {
                qd.c.a(this.f١٩٦٧٨c);
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (compareAndSet(0, 1)) {
                this.f١٩٦٧٦a.onNext(obj);
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
            qd.c.g(this.f١٩٦٧٧b, cVar);
        }
    }

    public d2(io.reactivex.rxjava3.core.z zVar, io.reactivex.rxjava3.core.n nVar) {
        super(zVar);
        this.f١٩٦٧٥b = nVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var);
        g0Var.onSubscribe(aVar);
        this.f١٩٥٣٢a.subscribe(aVar);
        this.f١٩٦٧٥b.a(aVar.f١٩٦٧٨c);
    }
}
