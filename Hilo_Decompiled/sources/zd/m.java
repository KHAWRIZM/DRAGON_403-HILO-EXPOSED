package zd;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class m extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.r f٢٠٠٣٥b;

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٠٣٦c;

    /* renamed from: d, reason: collision with root package name */
    final pd.o f٢٠٠٣٧d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -8466418554264089604L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٠٣٨a;

        /* renamed from: b, reason: collision with root package name */
        final pd.r f٢٠٠٣٩b;

        /* renamed from: c, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f٢٠٠٤٠c;

        /* renamed from: d, reason: collision with root package name */
        final pd.o f٢٠٠٤١d;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f٢٠٠٤٥h;

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f٢٠٠٤٧j;

        /* renamed from: k, reason: collision with root package name */
        long f٢٠٠٤٨k;

        /* renamed from: i, reason: collision with root package name */
        final be.c f٢٠٠٤٦i = new be.c(io.reactivex.rxjava3.core.z.bufferSize());

        /* renamed from: e, reason: collision with root package name */
        final nd.a f٢٠٠٤٢e = new nd.a();

        /* renamed from: f, reason: collision with root package name */
        final AtomicReference f٢٠٠٤٣f = new AtomicReference();

        /* renamed from: l, reason: collision with root package name */
        Map f٢٠٠٤٩l = new LinkedHashMap();

        /* renamed from: g, reason: collision with root package name */
        final fe.c f٢٠٠٤٤g = new fe.c();

        /* renamed from: zd.m$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        static final class C٠٢٦٧a extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {
            private static final long serialVersionUID = -8498650778633225126L;

            /* renamed from: a, reason: collision with root package name */
            final a f٢٠٠٥٠a;

            C٠٢٦٧a(a aVar) {
                this.f٢٠٠٥٠a = aVar;
            }

            @Override // nd.c
            public void dispose() {
                qd.c.a(this);
            }

            @Override // nd.c
            public boolean isDisposed() {
                if (get() == qd.c.DISPOSED) {
                    return true;
                }
                return false;
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                lazySet(qd.c.DISPOSED);
                this.f٢٠٠٥٠a.e(this);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                lazySet(qd.c.DISPOSED);
                this.f٢٠٠٥٠a.a(this, th);
            }

            @Override // io.reactivex.rxjava3.core.g0
            public void onNext(Object obj) {
                this.f٢٠٠٥٠a.d(obj);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var, io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, pd.r rVar) {
            this.f٢٠٠٣٨a = g0Var;
            this.f٢٠٠٣٩b = rVar;
            this.f٢٠٠٤٠c = e0Var;
            this.f٢٠٠٤١d = oVar;
        }

        void a(nd.c cVar, Throwable th) {
            qd.c.a(this.f٢٠٠٤٣f);
            this.f٢٠٠٤٢e.c(cVar);
            onError(th);
        }

        void b(b bVar, long j10) {
            boolean z10;
            this.f٢٠٠٤٢e.c(bVar);
            if (this.f٢٠٠٤٢e.f() == 0) {
                qd.c.a(this.f٢٠٠٤٣f);
                z10 = true;
            } else {
                z10 = false;
            }
            synchronized (this) {
                try {
                    Map map = this.f٢٠٠٤٩l;
                    if (map == null) {
                        return;
                    }
                    this.f٢٠٠٤٦i.offer(map.remove(Long.valueOf(j10)));
                    if (z10) {
                        this.f٢٠٠٤٥h = true;
                    }
                    c();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void c() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٠٣٨a;
            be.c cVar = this.f٢٠٠٤٦i;
            int i10 = 1;
            while (!this.f٢٠٠٤٧j) {
                boolean z11 = this.f٢٠٠٤٥h;
                if (z11 && this.f٢٠٠٤٤g.get() != null) {
                    cVar.clear();
                    this.f٢٠٠٤٤g.f(g0Var);
                    return;
                }
                Collection collection = (Collection) cVar.poll();
                if (collection == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z11 && z10) {
                    g0Var.onComplete();
                    return;
                } else if (z10) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    g0Var.onNext(collection);
                }
            }
            cVar.clear();
        }

        void d(Object obj) {
            try {
                Object obj2 = this.f٢٠٠٣٩b.get();
                Objects.requireNonNull(obj2, "The bufferSupplier returned a null Collection");
                Collection collection = (Collection) obj2;
                Object apply = this.f٢٠٠٤١d.apply(obj);
                Objects.requireNonNull(apply, "The bufferClose returned a null ObservableSource");
                io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                long j10 = this.f٢٠٠٤٨k;
                this.f٢٠٠٤٨k = 1 + j10;
                synchronized (this) {
                    try {
                        Map map = this.f٢٠٠٤٩l;
                        if (map == null) {
                            return;
                        }
                        map.put(Long.valueOf(j10), collection);
                        b bVar = new b(this, j10);
                        this.f٢٠٠٤٢e.a(bVar);
                        e0Var.subscribe(bVar);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                od.b.b(th2);
                qd.c.a(this.f٢٠٠٤٣f);
                onError(th2);
            }
        }

        @Override // nd.c
        public void dispose() {
            if (qd.c.a(this.f٢٠٠٤٣f)) {
                this.f٢٠٠٤٧j = true;
                this.f٢٠٠٤٢e.dispose();
                synchronized (this) {
                    this.f٢٠٠٤٩l = null;
                }
                if (getAndIncrement() != 0) {
                    this.f٢٠٠٤٦i.clear();
                }
            }
        }

        void e(C٠٢٦٧a r22) {
            this.f٢٠٠٤٢e.c(r22);
            if (this.f٢٠٠٤٢e.f() == 0) {
                qd.c.a(this.f٢٠٠٤٣f);
                this.f٢٠٠٤٥h = true;
                c();
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) this.f٢٠٠٤٣f.get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٠٤٢e.dispose();
            synchronized (this) {
                try {
                    Map map = this.f٢٠٠٤٩l;
                    if (map == null) {
                        return;
                    }
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        this.f٢٠٠٤٦i.offer((Collection) it.next());
                    }
                    this.f٢٠٠٤٩l = null;
                    this.f٢٠٠٤٥h = true;
                    c();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٠٤٤g.c(th)) {
                this.f٢٠٠٤٢e.dispose();
                synchronized (this) {
                    this.f٢٠٠٤٩l = null;
                }
                this.f٢٠٠٤٥h = true;
                c();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            synchronized (this) {
                try {
                    Map map = this.f٢٠٠٤٩l;
                    if (map == null) {
                        return;
                    }
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        ((Collection) it.next()).add(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.g(this.f٢٠٠٤٣f, cVar)) {
                C٠٢٦٧a r22 = new C٠٢٦٧a(this);
                this.f٢٠٠٤٢e.a(r22);
                this.f٢٠٠٤٠c.subscribe(r22);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -8498650778633225126L;

        /* renamed from: a, reason: collision with root package name */
        final a f٢٠٠٥١a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٠٥٢b;

        b(a aVar, long j10) {
            this.f٢٠٠٥١a = aVar;
            this.f٢٠٠٥٢b = j10;
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (get() == qd.c.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            Object obj = get();
            qd.c cVar = qd.c.DISPOSED;
            if (obj != cVar) {
                lazySet(cVar);
                this.f٢٠٠٥١a.b(this, this.f٢٠٠٥٢b);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            Object obj = get();
            qd.c cVar = qd.c.DISPOSED;
            if (obj != cVar) {
                lazySet(cVar);
                this.f٢٠٠٥١a.a(this, th);
            } else {
                ie.a.s(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            nd.c cVar = (nd.c) get();
            qd.c cVar2 = qd.c.DISPOSED;
            if (cVar != cVar2) {
                lazySet(cVar2);
                cVar.dispose();
                this.f٢٠٠٥١a.b(this, this.f٢٠٠٥٢b);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this, cVar);
        }
    }

    public m(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, pd.o oVar, pd.r rVar) {
        super(e0Var);
        this.f٢٠٠٣٦c = e0Var2;
        this.f٢٠٠٣٧d = oVar;
        this.f٢٠٠٣٥b = rVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var, this.f٢٠٠٣٦c, this.f٢٠٠٣٧d, this.f٢٠٠٣٥b);
        g0Var.onSubscribe(aVar);
        this.f١٩٥٣٢a.subscribe(aVar);
    }
}
