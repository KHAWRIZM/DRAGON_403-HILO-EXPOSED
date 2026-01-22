package zd;

import io.reactivex.rxjava3.core.h0;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class v extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٥٨٨b;

    /* renamed from: c, reason: collision with root package name */
    final int f٢٠٥٨٩c;

    /* renamed from: d, reason: collision with root package name */
    final fe.i f٢٠٥٩٠d;

    /* renamed from: e, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠٥٩١e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c, Runnable {
        private static final long serialVersionUID = -6951100001833242599L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٥٩٢a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f٢٠٥٩٣b;

        /* renamed from: c, reason: collision with root package name */
        final int f٢٠٥٩٤c;

        /* renamed from: d, reason: collision with root package name */
        final fe.c f٢٠٥٩٥d = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        final C٠٢٧٠a f٢٠٥٩٦e;

        /* renamed from: f, reason: collision with root package name */
        final boolean f٢٠٥٩٧f;

        /* renamed from: g, reason: collision with root package name */
        final h0.c f٢٠٥٩٨g;

        /* renamed from: h, reason: collision with root package name */
        sd.j f٢٠٥٩٩h;

        /* renamed from: i, reason: collision with root package name */
        nd.c f٢٠٦٠٠i;

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f٢٠٦٠١j;

        /* renamed from: k, reason: collision with root package name */
        volatile boolean f٢٠٦٠٢k;

        /* renamed from: l, reason: collision with root package name */
        volatile boolean f٢٠٦٠٣l;

        /* renamed from: m, reason: collision with root package name */
        int f٢٠٦٠٤m;

        /* renamed from: zd.v$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        static final class C٠٢٧٠a extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
            private static final long serialVersionUID = 2620149119579502636L;

            /* renamed from: a, reason: collision with root package name */
            final io.reactivex.rxjava3.core.g0 f٢٠٦٠٥a;

            /* renamed from: b, reason: collision with root package name */
            final a f٢٠٦٠٦b;

            C٠٢٧٠a(io.reactivex.rxjava3.core.g0 g0Var, a aVar) {
                this.f٢٠٦٠٥a = g0Var;
                this.f٢٠٦٠٦b = aVar;
            }

            void a() {
                qd.c.a(this);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                a aVar = this.f٢٠٦٠٦b;
                aVar.f٢٠٦٠١j = false;
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                a aVar = this.f٢٠٦٠٦b;
                if (aVar.f٢٠٥٩٥d.c(th)) {
                    if (!aVar.f٢٠٥٩٧f) {
                        aVar.f٢٠٦٠٠i.dispose();
                    }
                    aVar.f٢٠٦٠١j = false;
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.g0
            public void onNext(Object obj) {
                this.f٢٠٦٠٥a.onNext(obj);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.d(this, cVar);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, int i10, boolean z10, h0.c cVar) {
            this.f٢٠٥٩٢a = g0Var;
            this.f٢٠٥٩٣b = oVar;
            this.f٢٠٥٩٤c = i10;
            this.f٢٠٥٩٧f = z10;
            this.f٢٠٥٩٦e = new C٠٢٧٠a(g0Var, this);
            this.f٢٠٥٩٨g = cVar;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.f٢٠٥٩٨g.schedule(this);
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٦٠٣l = true;
            this.f٢٠٦٠٠i.dispose();
            this.f٢٠٥٩٦e.a();
            this.f٢٠٥٩٨g.dispose();
            this.f٢٠٥٩٥d.d();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٦٠٣l;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٦٠٢k = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٥٩٥d.c(th)) {
                this.f٢٠٦٠٢k = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٦٠٤m == 0) {
                this.f٢٠٥٩٩h.offer(obj);
            }
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٦٠٠i, cVar)) {
                this.f٢٠٦٠٠i = cVar;
                if (cVar instanceof sd.e) {
                    sd.e eVar = (sd.e) cVar;
                    int a10 = eVar.a(3);
                    if (a10 == 1) {
                        this.f٢٠٦٠٤m = a10;
                        this.f٢٠٥٩٩h = eVar;
                        this.f٢٠٦٠٢k = true;
                        this.f٢٠٥٩٢a.onSubscribe(this);
                        a();
                        return;
                    }
                    if (a10 == 2) {
                        this.f٢٠٦٠٤m = a10;
                        this.f٢٠٥٩٩h = eVar;
                        this.f٢٠٥٩٢a.onSubscribe(this);
                        return;
                    }
                }
                this.f٢٠٥٩٩h = new be.c(this.f٢٠٥٩٤c);
                this.f٢٠٥٩٢a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٥٩٢a;
            sd.j jVar = this.f٢٠٥٩٩h;
            fe.c cVar = this.f٢٠٥٩٥d;
            while (true) {
                if (!this.f٢٠٦٠١j) {
                    if (this.f٢٠٦٠٣l) {
                        jVar.clear();
                        return;
                    }
                    if (!this.f٢٠٥٩٧f && ((Throwable) cVar.get()) != null) {
                        jVar.clear();
                        this.f٢٠٦٠٣l = true;
                        cVar.f(g0Var);
                        this.f٢٠٥٩٨g.dispose();
                        return;
                    }
                    boolean z11 = this.f٢٠٦٠٢k;
                    try {
                        Object poll = jVar.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z11 && z10) {
                            this.f٢٠٦٠٣l = true;
                            cVar.f(g0Var);
                            this.f٢٠٥٩٨g.dispose();
                            return;
                        }
                        if (!z10) {
                            try {
                                Object apply = this.f٢٠٥٩٣b.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                                if (e0Var instanceof pd.r) {
                                    try {
                                        Object obj = ((pd.r) e0Var).get();
                                        if (obj != null && !this.f٢٠٦٠٣l) {
                                            g0Var.onNext(obj);
                                        }
                                    } catch (Throwable th) {
                                        od.b.b(th);
                                        cVar.c(th);
                                    }
                                } else {
                                    this.f٢٠٦٠١j = true;
                                    e0Var.subscribe(this.f٢٠٥٩٦e);
                                }
                            } catch (Throwable th2) {
                                od.b.b(th2);
                                this.f٢٠٦٠٣l = true;
                                this.f٢٠٦٠٠i.dispose();
                                jVar.clear();
                                cVar.c(th2);
                                cVar.f(g0Var);
                                this.f٢٠٥٩٨g.dispose();
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        od.b.b(th3);
                        this.f٢٠٦٠٣l = true;
                        this.f٢٠٦٠٠i.dispose();
                        cVar.c(th3);
                        cVar.f(g0Var);
                        this.f٢٠٥٩٨g.dispose();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c, Runnable {
        private static final long serialVersionUID = 8828587559905699186L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٦٠٧a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f٢٠٦٠٨b;

        /* renamed from: c, reason: collision with root package name */
        final a f٢٠٦٠٩c;

        /* renamed from: d, reason: collision with root package name */
        final int f٢٠٦١٠d;

        /* renamed from: e, reason: collision with root package name */
        final h0.c f٢٠٦١١e;

        /* renamed from: f, reason: collision with root package name */
        sd.j f٢٠٦١٢f;

        /* renamed from: g, reason: collision with root package name */
        nd.c f٢٠٦١٣g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f٢٠٦١٤h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f٢٠٦١٥i;

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f٢٠٦١٦j;

        /* renamed from: k, reason: collision with root package name */
        int f٢٠٦١٧k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
            private static final long serialVersionUID = -7449079488798789337L;

            /* renamed from: a, reason: collision with root package name */
            final io.reactivex.rxjava3.core.g0 f٢٠٦١٨a;

            /* renamed from: b, reason: collision with root package name */
            final b f٢٠٦١٩b;

            a(io.reactivex.rxjava3.core.g0 g0Var, b bVar) {
                this.f٢٠٦١٨a = g0Var;
                this.f٢٠٦١٩b = bVar;
            }

            void a() {
                qd.c.a(this);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                this.f٢٠٦١٩b.b();
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                this.f٢٠٦١٩b.dispose();
                this.f٢٠٦١٨a.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.g0
            public void onNext(Object obj) {
                this.f٢٠٦١٨a.onNext(obj);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.d(this, cVar);
            }
        }

        b(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, int i10, h0.c cVar) {
            this.f٢٠٦٠٧a = g0Var;
            this.f٢٠٦٠٨b = oVar;
            this.f٢٠٦١٠d = i10;
            this.f٢٠٦٠٩c = new a(g0Var, this);
            this.f٢٠٦١١e = cVar;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.f٢٠٦١١e.schedule(this);
        }

        void b() {
            this.f٢٠٦١٤h = false;
            a();
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٦١٥i = true;
            this.f٢٠٦٠٩c.a();
            this.f٢٠٦١٣g.dispose();
            this.f٢٠٦١١e.dispose();
            if (getAndIncrement() == 0) {
                this.f٢٠٦١٢f.clear();
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٦١٥i;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f٢٠٦١٦j) {
                return;
            }
            this.f٢٠٦١٦j = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٦١٦j) {
                ie.a.s(th);
                return;
            }
            this.f٢٠٦١٦j = true;
            dispose();
            this.f٢٠٦٠٧a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٦١٦j) {
                return;
            }
            if (this.f٢٠٦١٧k == 0) {
                this.f٢٠٦١٢f.offer(obj);
            }
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٦١٣g, cVar)) {
                this.f٢٠٦١٣g = cVar;
                if (cVar instanceof sd.e) {
                    sd.e eVar = (sd.e) cVar;
                    int a10 = eVar.a(3);
                    if (a10 == 1) {
                        this.f٢٠٦١٧k = a10;
                        this.f٢٠٦١٢f = eVar;
                        this.f٢٠٦١٦j = true;
                        this.f٢٠٦٠٧a.onSubscribe(this);
                        a();
                        return;
                    }
                    if (a10 == 2) {
                        this.f٢٠٦١٧k = a10;
                        this.f٢٠٦١٢f = eVar;
                        this.f٢٠٦٠٧a.onSubscribe(this);
                        return;
                    }
                }
                this.f٢٠٦١٢f = new be.c(this.f٢٠٦١٠d);
                this.f٢٠٦٠٧a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            while (!this.f٢٠٦١٥i) {
                if (!this.f٢٠٦١٤h) {
                    boolean z11 = this.f٢٠٦١٦j;
                    try {
                        Object poll = this.f٢٠٦١٢f.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z11 && z10) {
                            this.f٢٠٦١٥i = true;
                            this.f٢٠٦٠٧a.onComplete();
                            this.f٢٠٦١١e.dispose();
                            return;
                        } else if (!z10) {
                            try {
                                Object apply = this.f٢٠٦٠٨b.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                                this.f٢٠٦١٤h = true;
                                e0Var.subscribe(this.f٢٠٦٠٩c);
                            } catch (Throwable th) {
                                od.b.b(th);
                                dispose();
                                this.f٢٠٦١٢f.clear();
                                this.f٢٠٦٠٧a.onError(th);
                                this.f٢٠٦١١e.dispose();
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        od.b.b(th2);
                        dispose();
                        this.f٢٠٦١٢f.clear();
                        this.f٢٠٦٠٧a.onError(th2);
                        this.f٢٠٦١١e.dispose();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f٢٠٦١٢f.clear();
        }
    }

    public v(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, int i10, fe.i iVar, io.reactivex.rxjava3.core.h0 h0Var) {
        super(e0Var);
        this.f٢٠٥٨٨b = oVar;
        this.f٢٠٥٩٠d = iVar;
        this.f٢٠٥٨٩c = Math.max(8, i10);
        this.f٢٠٥٩١e = h0Var;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        boolean z10;
        if (this.f٢٠٥٩٠d == fe.i.IMMEDIATE) {
            this.f١٩٥٣٢a.subscribe(new b(new he.e(g0Var), this.f٢٠٥٨٨b, this.f٢٠٥٨٩c, this.f٢٠٥٩١e.createWorker()));
            return;
        }
        io.reactivex.rxjava3.core.e0 e0Var = this.f١٩٥٣٢a;
        pd.o oVar = this.f٢٠٥٨٨b;
        int i10 = this.f٢٠٥٨٩c;
        if (this.f٢٠٥٩٠d == fe.i.END) {
            z10 = true;
        } else {
            z10 = false;
        }
        e0Var.subscribe(new a(g0Var, oVar, i10, z10, this.f٢٠٥٩١e.createWorker()));
    }
}
