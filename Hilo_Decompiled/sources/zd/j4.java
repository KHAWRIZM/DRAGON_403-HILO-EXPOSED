package zd;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class j4 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٩٢٥b;

    /* renamed from: c, reason: collision with root package name */
    final int f١٩٩٢٦c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends he.c {

        /* renamed from: b, reason: collision with root package name */
        final b f١٩٩٢٧b;

        /* renamed from: c, reason: collision with root package name */
        boolean f١٩٩٢٨c;

        a(b bVar) {
            this.f١٩٩٢٧b = bVar;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٩٢٨c) {
                return;
            }
            this.f١٩٩٢٨c = true;
            this.f١٩٩٢٧b.b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٩٢٨c) {
                ie.a.s(th);
            } else {
                this.f١٩٩٢٨c = true;
                this.f١٩٩٢٧b.c(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٩٢٨c) {
                return;
            }
            this.f١٩٩٢٧b.d();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c, Runnable {

        /* renamed from: k, reason: collision with root package name */
        static final Object f١٩٩٢٩k = new Object();
        private static final long serialVersionUID = 2233020065421370272L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٩٣٠a;

        /* renamed from: b, reason: collision with root package name */
        final int f١٩٩٣١b;

        /* renamed from: c, reason: collision with root package name */
        final a f١٩٩٣٢c = new a(this);

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference f١٩٩٣٣d = new AtomicReference();

        /* renamed from: e, reason: collision with root package name */
        final AtomicInteger f١٩٩٣٤e = new AtomicInteger(1);

        /* renamed from: f, reason: collision with root package name */
        final be.a f١٩٩٣٥f = new be.a();

        /* renamed from: g, reason: collision with root package name */
        final fe.c f١٩٩٣٦g = new fe.c();

        /* renamed from: h, reason: collision with root package name */
        final AtomicBoolean f١٩٩٣٧h = new AtomicBoolean();

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f١٩٩٣٨i;

        /* renamed from: j, reason: collision with root package name */
        le.d f١٩٩٣٩j;

        b(io.reactivex.rxjava3.core.g0 g0Var, int i10) {
            this.f١٩٩٣٠a = g0Var;
            this.f١٩٩٣١b = i10;
        }

        void a() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.rxjava3.core.g0 g0Var = this.f١٩٩٣٠a;
            be.a aVar = this.f١٩٩٣٥f;
            fe.c cVar = this.f١٩٩٣٦g;
            int i10 = 1;
            while (this.f١٩٩٣٤e.get() != 0) {
                le.d dVar = this.f١٩٩٣٩j;
                boolean z11 = this.f١٩٩٣٨i;
                if (z11 && cVar.get() != null) {
                    aVar.clear();
                    Throwable a10 = cVar.a();
                    if (dVar != null) {
                        this.f١٩٩٣٩j = null;
                        dVar.onError(a10);
                    }
                    g0Var.onError(a10);
                    return;
                }
                Object poll = aVar.poll();
                if (poll == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z11 && z10) {
                    Throwable a11 = cVar.a();
                    if (a11 == null) {
                        if (dVar != null) {
                            this.f١٩٩٣٩j = null;
                            dVar.onComplete();
                        }
                        g0Var.onComplete();
                        return;
                    }
                    if (dVar != null) {
                        this.f١٩٩٣٩j = null;
                        dVar.onError(a11);
                    }
                    g0Var.onError(a11);
                    return;
                }
                if (z10) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else if (poll != f١٩٩٢٩k) {
                    dVar.onNext(poll);
                } else {
                    if (dVar != null) {
                        this.f١٩٩٣٩j = null;
                        dVar.onComplete();
                    }
                    if (!this.f١٩٩٣٧h.get()) {
                        le.d f10 = le.d.f(this.f١٩٩٣١b, this);
                        this.f١٩٩٣٩j = f10;
                        this.f١٩٩٣٤e.getAndIncrement();
                        l4 l4Var = new l4(f10);
                        g0Var.onNext(l4Var);
                        if (l4Var.d()) {
                            f10.onComplete();
                        }
                    }
                }
            }
            aVar.clear();
            this.f١٩٩٣٩j = null;
        }

        void b() {
            qd.c.a(this.f١٩٩٣٣d);
            this.f١٩٩٣٨i = true;
            a();
        }

        void c(Throwable th) {
            qd.c.a(this.f١٩٩٣٣d);
            if (this.f١٩٩٣٦g.c(th)) {
                this.f١٩٩٣٨i = true;
                a();
            }
        }

        void d() {
            this.f١٩٩٣٥f.offer(f١٩٩٢٩k);
            a();
        }

        @Override // nd.c
        public void dispose() {
            if (this.f١٩٩٣٧h.compareAndSet(false, true)) {
                this.f١٩٩٣٢c.dispose();
                if (this.f١٩٩٣٤e.decrementAndGet() == 0) {
                    qd.c.a(this.f١٩٩٣٣d);
                }
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٩٣٧h.get();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٩٣٢c.dispose();
            this.f١٩٩٣٨i = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٩٣٢c.dispose();
            if (this.f١٩٩٣٦g.c(th)) {
                this.f١٩٩٣٨i = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٩٣٥f.offer(obj);
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.g(this.f١٩٩٣٣d, cVar)) {
                d();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f١٩٩٣٤e.decrementAndGet() == 0) {
                qd.c.a(this.f١٩٩٣٣d);
            }
        }
    }

    public j4(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, int i10) {
        super(e0Var);
        this.f١٩٩٢٥b = e0Var2;
        this.f١٩٩٢٦c = i10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        b bVar = new b(g0Var, this.f١٩٩٢٦c);
        g0Var.onSubscribe(bVar);
        this.f١٩٩٢٥b.subscribe(bVar.f١٩٩٣٢c);
        this.f١٩٥٣٢a.subscribe(bVar);
    }
}
