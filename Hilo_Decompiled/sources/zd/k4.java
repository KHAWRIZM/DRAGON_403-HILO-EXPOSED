package zd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class k4 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٩٦٠b;

    /* renamed from: c, reason: collision with root package name */
    final pd.o f١٩٩٦١c;

    /* renamed from: d, reason: collision with root package name */
    final int f١٩٩٦٢d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c, Runnable {
        private static final long serialVersionUID = 8646217640096099753L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٩٦٣a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f١٩٩٦٤b;

        /* renamed from: c, reason: collision with root package name */
        final pd.o f١٩٩٦٥c;

        /* renamed from: d, reason: collision with root package name */
        final int f١٩٩٦٦d;

        /* renamed from: l, reason: collision with root package name */
        volatile boolean f١٩٩٧٤l;

        /* renamed from: m, reason: collision with root package name */
        volatile boolean f١٩٩٧٥m;

        /* renamed from: n, reason: collision with root package name */
        volatile boolean f١٩٩٧٦n;

        /* renamed from: p, reason: collision with root package name */
        nd.c f١٩٩٧٨p;

        /* renamed from: h, reason: collision with root package name */
        final sd.i f١٩٩٧٠h = new be.a();

        /* renamed from: e, reason: collision with root package name */
        final nd.a f١٩٩٦٧e = new nd.a();

        /* renamed from: g, reason: collision with root package name */
        final List f١٩٩٦٩g = new ArrayList();

        /* renamed from: i, reason: collision with root package name */
        final AtomicLong f١٩٩٧١i = new AtomicLong(1);

        /* renamed from: j, reason: collision with root package name */
        final AtomicBoolean f١٩٩٧٢j = new AtomicBoolean();

        /* renamed from: o, reason: collision with root package name */
        final fe.c f١٩٩٧٧o = new fe.c();

        /* renamed from: f, reason: collision with root package name */
        final c f١٩٩٦٨f = new c(this);

        /* renamed from: k, reason: collision with root package name */
        final AtomicLong f١٩٩٧٣k = new AtomicLong();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: zd.k4$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class C٠٢٦٦a extends io.reactivex.rxjava3.core.z implements io.reactivex.rxjava3.core.g0, nd.c {

            /* renamed from: a, reason: collision with root package name */
            final a f١٩٩٧٩a;

            /* renamed from: b, reason: collision with root package name */
            final le.d f١٩٩٨٠b;

            /* renamed from: c, reason: collision with root package name */
            final AtomicReference f١٩٩٨١c = new AtomicReference();

            /* renamed from: d, reason: collision with root package name */
            final AtomicBoolean f١٩٩٨٢d = new AtomicBoolean();

            C٠٢٦٦a(a aVar, le.d dVar) {
                this.f١٩٩٧٩a = aVar;
                this.f١٩٩٨٠b = dVar;
            }

            boolean d() {
                if (this.f١٩٩٨٢d.get() || !this.f١٩٩٨٢d.compareAndSet(false, true)) {
                    return false;
                }
                return true;
            }

            @Override // nd.c
            public void dispose() {
                qd.c.a(this.f١٩٩٨١c);
            }

            @Override // nd.c
            public boolean isDisposed() {
                if (this.f١٩٩٨١c.get() == qd.c.DISPOSED) {
                    return true;
                }
                return false;
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                this.f١٩٩٧٩a.a(this);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                if (isDisposed()) {
                    ie.a.s(th);
                } else {
                    this.f١٩٩٧٩a.b(th);
                }
            }

            @Override // io.reactivex.rxjava3.core.g0
            public void onNext(Object obj) {
                if (qd.c.a(this.f١٩٩٨١c)) {
                    this.f١٩٩٧٩a.a(this);
                }
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this.f١٩٩٨١c, cVar);
            }

            @Override // io.reactivex.rxjava3.core.z
            protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
                this.f١٩٩٨٠b.subscribe(g0Var);
                this.f١٩٩٨٢d.set(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            final Object f١٩٩٨٣a;

            b(Object obj) {
                this.f١٩٩٨٣a = obj;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class c extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
            private static final long serialVersionUID = -3326496781427702834L;

            /* renamed from: a, reason: collision with root package name */
            final a f١٩٩٨٤a;

            c(a aVar) {
                this.f١٩٩٨٤a = aVar;
            }

            void a() {
                qd.c.a(this);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                this.f١٩٩٨٤a.e();
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                this.f١٩٩٨٤a.f(th);
            }

            @Override // io.reactivex.rxjava3.core.g0
            public void onNext(Object obj) {
                this.f١٩٩٨٤a.d(obj);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var, io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, int i10) {
            this.f١٩٩٦٣a = g0Var;
            this.f١٩٩٦٤b = e0Var;
            this.f١٩٩٦٥c = oVar;
            this.f١٩٩٦٦d = i10;
        }

        void a(C٠٢٦٦a r22) {
            this.f١٩٩٧٠h.offer(r22);
            c();
        }

        void b(Throwable th) {
            this.f١٩٩٧٨p.dispose();
            this.f١٩٩٦٨f.a();
            this.f١٩٩٦٧e.dispose();
            if (this.f١٩٩٧٧o.c(th)) {
                this.f١٩٩٧٥m = true;
                c();
            }
        }

        void c() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.rxjava3.core.g0 g0Var = this.f١٩٩٦٣a;
            sd.i iVar = this.f١٩٩٧٠h;
            List list = this.f١٩٩٦٩g;
            int i10 = 1;
            while (true) {
                if (this.f١٩٩٧٤l) {
                    iVar.clear();
                    list.clear();
                } else {
                    boolean z11 = this.f١٩٩٧٥m;
                    Object poll = iVar.poll();
                    if (poll == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z11 && (z10 || this.f١٩٩٧٧o.get() != null)) {
                        g(g0Var);
                        this.f١٩٩٧٤l = true;
                    } else if (!z10) {
                        if (poll instanceof b) {
                            if (!this.f١٩٩٧٢j.get()) {
                                try {
                                    Object apply = this.f١٩٩٦٥c.apply(((b) poll).f١٩٩٨٣a);
                                    Objects.requireNonNull(apply, "The closingIndicator returned a null ObservableSource");
                                    io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                                    this.f١٩٩٧١i.getAndIncrement();
                                    le.d f10 = le.d.f(this.f١٩٩٦٦d, this);
                                    C٠٢٦٦a r72 = new C٠٢٦٦a(this, f10);
                                    g0Var.onNext(r72);
                                    if (r72.d()) {
                                        f10.onComplete();
                                    } else {
                                        list.add(f10);
                                        this.f١٩٩٦٧e.a(r72);
                                        e0Var.subscribe(r72);
                                    }
                                } catch (Throwable th) {
                                    od.b.b(th);
                                    this.f١٩٩٧٨p.dispose();
                                    this.f١٩٩٦٨f.a();
                                    this.f١٩٩٦٧e.dispose();
                                    od.b.b(th);
                                    this.f١٩٩٧٧o.c(th);
                                    this.f١٩٩٧٥m = true;
                                }
                            }
                        } else if (poll instanceof C٠٢٦٦a) {
                            le.d dVar = ((C٠٢٦٦a) poll).f١٩٩٨٠b;
                            list.remove(dVar);
                            this.f١٩٩٦٧e.c((nd.c) poll);
                            dVar.onComplete();
                        } else {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                ((le.d) it.next()).onNext(poll);
                            }
                        }
                    } else if (this.f١٩٩٧٦n && list.size() == 0) {
                        this.f١٩٩٧٨p.dispose();
                        this.f١٩٩٦٨f.a();
                        this.f١٩٩٦٧e.dispose();
                        g(g0Var);
                        this.f١٩٩٧٤l = true;
                    }
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }

        void d(Object obj) {
            this.f١٩٩٧٠h.offer(new b(obj));
            c();
        }

        @Override // nd.c
        public void dispose() {
            if (this.f١٩٩٧٢j.compareAndSet(false, true)) {
                if (this.f١٩٩٧١i.decrementAndGet() == 0) {
                    this.f١٩٩٧٨p.dispose();
                    this.f١٩٩٦٨f.a();
                    this.f١٩٩٦٧e.dispose();
                    this.f١٩٩٧٧o.d();
                    this.f١٩٩٧٤l = true;
                    c();
                    return;
                }
                this.f١٩٩٦٨f.a();
            }
        }

        void e() {
            this.f١٩٩٧٦n = true;
            c();
        }

        void f(Throwable th) {
            this.f١٩٩٧٨p.dispose();
            this.f١٩٩٦٧e.dispose();
            if (this.f١٩٩٧٧o.c(th)) {
                this.f١٩٩٧٥m = true;
                c();
            }
        }

        void g(io.reactivex.rxjava3.core.g0 g0Var) {
            Throwable a10 = this.f١٩٩٧٧o.a();
            if (a10 == null) {
                Iterator it = this.f١٩٩٦٩g.iterator();
                while (it.hasNext()) {
                    ((le.d) it.next()).onComplete();
                }
                g0Var.onComplete();
                return;
            }
            if (a10 != fe.j.f١٤٣٠٦a) {
                Iterator it2 = this.f١٩٩٦٩g.iterator();
                while (it2.hasNext()) {
                    ((le.d) it2.next()).onError(a10);
                }
                g0Var.onError(a10);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٩٧٢j.get();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٩٦٨f.a();
            this.f١٩٩٦٧e.dispose();
            this.f١٩٩٧٥m = true;
            c();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٩٦٨f.a();
            this.f١٩٩٦٧e.dispose();
            if (this.f١٩٩٧٧o.c(th)) {
                this.f١٩٩٧٥m = true;
                c();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٩٧٠h.offer(obj);
            c();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٩٧٨p, cVar)) {
                this.f١٩٩٧٨p = cVar;
                this.f١٩٩٦٣a.onSubscribe(this);
                this.f١٩٩٦٤b.subscribe(this.f١٩٩٦٨f);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f١٩٩٧١i.decrementAndGet() == 0) {
                this.f١٩٩٧٨p.dispose();
                this.f١٩٩٦٨f.a();
                this.f١٩٩٦٧e.dispose();
                this.f١٩٩٧٧o.d();
                this.f١٩٩٧٤l = true;
                c();
            }
        }
    }

    public k4(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, pd.o oVar, int i10) {
        super(e0Var);
        this.f١٩٩٦٠b = e0Var2;
        this.f١٩٩٦١c = oVar;
        this.f١٩٩٦٢d = i10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٩٦٠b, this.f١٩٩٦١c, this.f١٩٩٦٢d));
    }
}
