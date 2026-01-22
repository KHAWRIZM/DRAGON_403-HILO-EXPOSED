package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class t extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٤٧٦b;

    /* renamed from: c, reason: collision with root package name */
    final int f٢٠٤٧٧c;

    /* renamed from: d, reason: collision with root package name */
    final fe.i f٢٠٤٧٨d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -6951100001833242599L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٤٧٩a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f٢٠٤٨٠b;

        /* renamed from: c, reason: collision with root package name */
        final int f٢٠٤٨١c;

        /* renamed from: d, reason: collision with root package name */
        final fe.c f٢٠٤٨٢d = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        final C٠٢٦٨a f٢٠٤٨٣e;

        /* renamed from: f, reason: collision with root package name */
        final boolean f٢٠٤٨٤f;

        /* renamed from: g, reason: collision with root package name */
        sd.j f٢٠٤٨٥g;

        /* renamed from: h, reason: collision with root package name */
        nd.c f٢٠٤٨٦h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f٢٠٤٨٧i;

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f٢٠٤٨٨j;

        /* renamed from: k, reason: collision with root package name */
        volatile boolean f٢٠٤٨٩k;

        /* renamed from: l, reason: collision with root package name */
        int f٢٠٤٩٠l;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: zd.t$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class C٠٢٦٨a extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
            private static final long serialVersionUID = 2620149119579502636L;

            /* renamed from: a, reason: collision with root package name */
            final io.reactivex.rxjava3.core.g0 f٢٠٤٩١a;

            /* renamed from: b, reason: collision with root package name */
            final a f٢٠٤٩٢b;

            C٠٢٦٨a(io.reactivex.rxjava3.core.g0 g0Var, a aVar) {
                this.f٢٠٤٩١a = g0Var;
                this.f٢٠٤٩٢b = aVar;
            }

            void a() {
                qd.c.a(this);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                a aVar = this.f٢٠٤٩٢b;
                aVar.f٢٠٤٨٧i = false;
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                a aVar = this.f٢٠٤٩٢b;
                if (aVar.f٢٠٤٨٢d.c(th)) {
                    if (!aVar.f٢٠٤٨٤f) {
                        aVar.f٢٠٤٨٦h.dispose();
                    }
                    aVar.f٢٠٤٨٧i = false;
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.g0
            public void onNext(Object obj) {
                this.f٢٠٤٩١a.onNext(obj);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.d(this, cVar);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, int i10, boolean z10) {
            this.f٢٠٤٧٩a = g0Var;
            this.f٢٠٤٨٠b = oVar;
            this.f٢٠٤٨١c = i10;
            this.f٢٠٤٨٤f = z10;
            this.f٢٠٤٨٣e = new C٠٢٦٨a(g0Var, this);
        }

        void a() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٤٧٩a;
            sd.j jVar = this.f٢٠٤٨٥g;
            fe.c cVar = this.f٢٠٤٨٢d;
            while (true) {
                if (!this.f٢٠٤٨٧i) {
                    if (this.f٢٠٤٨٩k) {
                        jVar.clear();
                        return;
                    }
                    if (!this.f٢٠٤٨٤f && ((Throwable) cVar.get()) != null) {
                        jVar.clear();
                        this.f٢٠٤٨٩k = true;
                        cVar.f(g0Var);
                        return;
                    }
                    boolean z11 = this.f٢٠٤٨٨j;
                    try {
                        Object poll = jVar.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z11 && z10) {
                            this.f٢٠٤٨٩k = true;
                            cVar.f(g0Var);
                            return;
                        }
                        if (!z10) {
                            try {
                                Object apply = this.f٢٠٤٨٠b.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                                if (e0Var instanceof pd.r) {
                                    try {
                                        Object obj = ((pd.r) e0Var).get();
                                        if (obj != null && !this.f٢٠٤٨٩k) {
                                            g0Var.onNext(obj);
                                        }
                                    } catch (Throwable th) {
                                        od.b.b(th);
                                        cVar.c(th);
                                    }
                                } else {
                                    this.f٢٠٤٨٧i = true;
                                    e0Var.subscribe(this.f٢٠٤٨٣e);
                                }
                            } catch (Throwable th2) {
                                od.b.b(th2);
                                this.f٢٠٤٨٩k = true;
                                this.f٢٠٤٨٦h.dispose();
                                jVar.clear();
                                cVar.c(th2);
                                cVar.f(g0Var);
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        od.b.b(th3);
                        this.f٢٠٤٨٩k = true;
                        this.f٢٠٤٨٦h.dispose();
                        cVar.c(th3);
                        cVar.f(g0Var);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٤٨٩k = true;
            this.f٢٠٤٨٦h.dispose();
            this.f٢٠٤٨٣e.a();
            this.f٢٠٤٨٢d.d();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٤٨٩k;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٤٨٨j = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٤٨٢d.c(th)) {
                this.f٢٠٤٨٨j = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٤٩٠l == 0) {
                this.f٢٠٤٨٥g.offer(obj);
            }
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٤٨٦h, cVar)) {
                this.f٢٠٤٨٦h = cVar;
                if (cVar instanceof sd.e) {
                    sd.e eVar = (sd.e) cVar;
                    int a10 = eVar.a(3);
                    if (a10 == 1) {
                        this.f٢٠٤٩٠l = a10;
                        this.f٢٠٤٨٥g = eVar;
                        this.f٢٠٤٨٨j = true;
                        this.f٢٠٤٧٩a.onSubscribe(this);
                        a();
                        return;
                    }
                    if (a10 == 2) {
                        this.f٢٠٤٩٠l = a10;
                        this.f٢٠٤٨٥g = eVar;
                        this.f٢٠٤٧٩a.onSubscribe(this);
                        return;
                    }
                }
                this.f٢٠٤٨٥g = new be.c(this.f٢٠٤٨١c);
                this.f٢٠٤٧٩a.onSubscribe(this);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 8828587559905699186L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٤٩٣a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f٢٠٤٩٤b;

        /* renamed from: c, reason: collision with root package name */
        final a f٢٠٤٩٥c;

        /* renamed from: d, reason: collision with root package name */
        final int f٢٠٤٩٦d;

        /* renamed from: e, reason: collision with root package name */
        sd.j f٢٠٤٩٧e;

        /* renamed from: f, reason: collision with root package name */
        nd.c f٢٠٤٩٨f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f٢٠٤٩٩g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f٢٠٥٠٠h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f٢٠٥٠١i;

        /* renamed from: j, reason: collision with root package name */
        int f٢٠٥٠٢j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
            private static final long serialVersionUID = -7449079488798789337L;

            /* renamed from: a, reason: collision with root package name */
            final io.reactivex.rxjava3.core.g0 f٢٠٥٠٣a;

            /* renamed from: b, reason: collision with root package name */
            final b f٢٠٥٠٤b;

            a(io.reactivex.rxjava3.core.g0 g0Var, b bVar) {
                this.f٢٠٥٠٣a = g0Var;
                this.f٢٠٥٠٤b = bVar;
            }

            void a() {
                qd.c.a(this);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                this.f٢٠٥٠٤b.b();
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                this.f٢٠٥٠٤b.dispose();
                this.f٢٠٥٠٣a.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.g0
            public void onNext(Object obj) {
                this.f٢٠٥٠٣a.onNext(obj);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.d(this, cVar);
            }
        }

        b(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, int i10) {
            this.f٢٠٤٩٣a = g0Var;
            this.f٢٠٤٩٤b = oVar;
            this.f٢٠٤٩٦d = i10;
            this.f٢٠٤٩٥c = new a(g0Var, this);
        }

        void a() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.f٢٠٥٠٠h) {
                if (!this.f٢٠٤٩٩g) {
                    boolean z11 = this.f٢٠٥٠١i;
                    try {
                        Object poll = this.f٢٠٤٩٧e.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z11 && z10) {
                            this.f٢٠٥٠٠h = true;
                            this.f٢٠٤٩٣a.onComplete();
                            return;
                        }
                        if (!z10) {
                            try {
                                Object apply = this.f٢٠٤٩٤b.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                                this.f٢٠٤٩٩g = true;
                                e0Var.subscribe(this.f٢٠٤٩٥c);
                            } catch (Throwable th) {
                                od.b.b(th);
                                dispose();
                                this.f٢٠٤٩٧e.clear();
                                this.f٢٠٤٩٣a.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        od.b.b(th2);
                        dispose();
                        this.f٢٠٤٩٧e.clear();
                        this.f٢٠٤٩٣a.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f٢٠٤٩٧e.clear();
        }

        void b() {
            this.f٢٠٤٩٩g = false;
            a();
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٥٠٠h = true;
            this.f٢٠٤٩٥c.a();
            this.f٢٠٤٩٨f.dispose();
            if (getAndIncrement() == 0) {
                this.f٢٠٤٩٧e.clear();
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٥٠٠h;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f٢٠٥٠١i) {
                return;
            }
            this.f٢٠٥٠١i = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٥٠١i) {
                ie.a.s(th);
                return;
            }
            this.f٢٠٥٠١i = true;
            dispose();
            this.f٢٠٤٩٣a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٥٠١i) {
                return;
            }
            if (this.f٢٠٥٠٢j == 0) {
                this.f٢٠٤٩٧e.offer(obj);
            }
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٤٩٨f, cVar)) {
                this.f٢٠٤٩٨f = cVar;
                if (cVar instanceof sd.e) {
                    sd.e eVar = (sd.e) cVar;
                    int a10 = eVar.a(3);
                    if (a10 == 1) {
                        this.f٢٠٥٠٢j = a10;
                        this.f٢٠٤٩٧e = eVar;
                        this.f٢٠٥٠١i = true;
                        this.f٢٠٤٩٣a.onSubscribe(this);
                        a();
                        return;
                    }
                    if (a10 == 2) {
                        this.f٢٠٥٠٢j = a10;
                        this.f٢٠٤٩٧e = eVar;
                        this.f٢٠٤٩٣a.onSubscribe(this);
                        return;
                    }
                }
                this.f٢٠٤٩٧e = new be.c(this.f٢٠٤٩٦d);
                this.f٢٠٤٩٣a.onSubscribe(this);
            }
        }
    }

    public t(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, int i10, fe.i iVar) {
        super(e0Var);
        this.f٢٠٤٧٦b = oVar;
        this.f٢٠٤٧٨d = iVar;
        this.f٢٠٤٧٧c = Math.max(8, i10);
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        boolean z10;
        if (b3.b(this.f١٩٥٣٢a, g0Var, this.f٢٠٤٧٦b)) {
            return;
        }
        if (this.f٢٠٤٧٨d == fe.i.IMMEDIATE) {
            this.f١٩٥٣٢a.subscribe(new b(new he.e(g0Var), this.f٢٠٤٧٦b, this.f٢٠٤٧٧c));
            return;
        }
        io.reactivex.rxjava3.core.e0 e0Var = this.f١٩٥٣٢a;
        pd.o oVar = this.f٢٠٤٧٦b;
        int i10 = this.f٢٠٤٧٧c;
        if (this.f٢٠٤٧٨d == fe.i.END) {
            z10 = true;
        } else {
            z10 = false;
        }
        e0Var.subscribe(new a(g0Var, oVar, i10, z10));
    }
}
