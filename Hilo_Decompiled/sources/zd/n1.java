package zd;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class n1 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠١٥٩b;

    /* renamed from: c, reason: collision with root package name */
    final pd.o f٢٠١٦٠c;

    /* renamed from: d, reason: collision with root package name */
    final pd.o f٢٠١٦١d;

    /* renamed from: e, reason: collision with root package name */
    final pd.c f٢٠١٦٢e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements nd.c, b {

        /* renamed from: n, reason: collision with root package name */
        static final Integer f٢٠١٦٣n = 1;

        /* renamed from: o, reason: collision with root package name */
        static final Integer f٢٠١٦٤o = 2;

        /* renamed from: p, reason: collision with root package name */
        static final Integer f٢٠١٦٥p = 3;

        /* renamed from: q, reason: collision with root package name */
        static final Integer f٢٠١٦٦q = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠١٦٧a;

        /* renamed from: g, reason: collision with root package name */
        final pd.o f٢٠١٧٣g;

        /* renamed from: h, reason: collision with root package name */
        final pd.o f٢٠١٧٤h;

        /* renamed from: i, reason: collision with root package name */
        final pd.c f٢٠١٧٥i;

        /* renamed from: k, reason: collision with root package name */
        int f٢٠١٧٧k;

        /* renamed from: l, reason: collision with root package name */
        int f٢٠١٧٨l;

        /* renamed from: m, reason: collision with root package name */
        volatile boolean f٢٠١٧٩m;

        /* renamed from: c, reason: collision with root package name */
        final nd.a f٢٠١٦٩c = new nd.a();

        /* renamed from: b, reason: collision with root package name */
        final be.c f٢٠١٦٨b = new be.c(io.reactivex.rxjava3.core.z.bufferSize());

        /* renamed from: d, reason: collision with root package name */
        final Map f٢٠١٧٠d = new LinkedHashMap();

        /* renamed from: e, reason: collision with root package name */
        final Map f٢٠١٧١e = new LinkedHashMap();

        /* renamed from: f, reason: collision with root package name */
        final AtomicReference f٢٠١٧٢f = new AtomicReference();

        /* renamed from: j, reason: collision with root package name */
        final AtomicInteger f٢٠١٧٦j = new AtomicInteger(2);

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, pd.o oVar2, pd.c cVar) {
            this.f٢٠١٦٧a = g0Var;
            this.f٢٠١٧٣g = oVar;
            this.f٢٠١٧٤h = oVar2;
            this.f٢٠١٧٥i = cVar;
        }

        @Override // zd.n1.b
        public void a(boolean z10, Object obj) {
            Integer num;
            synchronized (this) {
                try {
                    be.c cVar = this.f٢٠١٦٨b;
                    if (z10) {
                        num = f٢٠١٦٣n;
                    } else {
                        num = f٢٠١٦٤o;
                    }
                    cVar.m(num, obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
            g();
        }

        @Override // zd.n1.b
        public void b(Throwable th) {
            if (fe.j.a(this.f٢٠١٧٢f, th)) {
                this.f٢٠١٧٦j.decrementAndGet();
                g();
            } else {
                ie.a.s(th);
            }
        }

        @Override // zd.n1.b
        public void c(Throwable th) {
            if (fe.j.a(this.f٢٠١٧٢f, th)) {
                g();
            } else {
                ie.a.s(th);
            }
        }

        @Override // zd.n1.b
        public void d(boolean z10, c cVar) {
            Integer num;
            synchronized (this) {
                try {
                    be.c cVar2 = this.f٢٠١٦٨b;
                    if (z10) {
                        num = f٢٠١٦٥p;
                    } else {
                        num = f٢٠١٦٦q;
                    }
                    cVar2.m(num, cVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
            g();
        }

        @Override // nd.c
        public void dispose() {
            if (this.f٢٠١٧٩m) {
                return;
            }
            this.f٢٠١٧٩m = true;
            f();
            if (getAndIncrement() == 0) {
                this.f٢٠١٦٨b.clear();
            }
        }

        @Override // zd.n1.b
        public void e(d dVar) {
            this.f٢٠١٦٩c.c(dVar);
            this.f٢٠١٧٦j.decrementAndGet();
            g();
        }

        void f() {
            this.f٢٠١٦٩c.dispose();
        }

        void g() {
            boolean z10;
            boolean z11;
            if (getAndIncrement() != 0) {
                return;
            }
            be.c cVar = this.f٢٠١٦٨b;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠١٦٧a;
            int i10 = 1;
            while (!this.f٢٠١٧٩m) {
                if (((Throwable) this.f٢٠١٧٢f.get()) != null) {
                    cVar.clear();
                    f();
                    h(g0Var);
                    return;
                }
                if (this.f٢٠١٧٦j.get() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Integer num = (Integer) cVar.poll();
                if (num == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z10 && z11) {
                    Iterator it = this.f٢٠١٧٠d.values().iterator();
                    while (it.hasNext()) {
                        ((le.d) it.next()).onComplete();
                    }
                    this.f٢٠١٧٠d.clear();
                    this.f٢٠١٧١e.clear();
                    this.f٢٠١٦٩c.dispose();
                    g0Var.onComplete();
                    return;
                }
                if (z11) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    Object poll = cVar.poll();
                    if (num == f٢٠١٦٣n) {
                        le.d e10 = le.d.e();
                        int i11 = this.f٢٠١٧٧k;
                        this.f٢٠١٧٧k = i11 + 1;
                        this.f٢٠١٧٠d.put(Integer.valueOf(i11), e10);
                        try {
                            Object apply = this.f٢٠١٧٣g.apply(poll);
                            Objects.requireNonNull(apply, "The leftEnd returned a null ObservableSource");
                            io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                            c cVar2 = new c(this, true, i11);
                            this.f٢٠١٦٩c.a(cVar2);
                            e0Var.subscribe(cVar2);
                            if (((Throwable) this.f٢٠١٧٢f.get()) != null) {
                                cVar.clear();
                                f();
                                h(g0Var);
                                return;
                            }
                            try {
                                Object apply2 = this.f٢٠١٧٥i.apply(poll, e10);
                                Objects.requireNonNull(apply2, "The resultSelector returned a null value");
                                g0Var.onNext(apply2);
                                Iterator it2 = this.f٢٠١٧١e.values().iterator();
                                while (it2.hasNext()) {
                                    e10.onNext(it2.next());
                                }
                            } catch (Throwable th) {
                                i(th, g0Var, cVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            i(th2, g0Var, cVar);
                            return;
                        }
                    } else if (num == f٢٠١٦٤o) {
                        int i12 = this.f٢٠١٧٨l;
                        this.f٢٠١٧٨l = i12 + 1;
                        this.f٢٠١٧١e.put(Integer.valueOf(i12), poll);
                        try {
                            Object apply3 = this.f٢٠١٧٤h.apply(poll);
                            Objects.requireNonNull(apply3, "The rightEnd returned a null ObservableSource");
                            io.reactivex.rxjava3.core.e0 e0Var2 = (io.reactivex.rxjava3.core.e0) apply3;
                            c cVar3 = new c(this, false, i12);
                            this.f٢٠١٦٩c.a(cVar3);
                            e0Var2.subscribe(cVar3);
                            if (((Throwable) this.f٢٠١٧٢f.get()) != null) {
                                cVar.clear();
                                f();
                                h(g0Var);
                                return;
                            } else {
                                Iterator it3 = this.f٢٠١٧٠d.values().iterator();
                                while (it3.hasNext()) {
                                    ((le.d) it3.next()).onNext(poll);
                                }
                            }
                        } catch (Throwable th3) {
                            i(th3, g0Var, cVar);
                            return;
                        }
                    } else if (num == f٢٠١٦٥p) {
                        c cVar4 = (c) poll;
                        le.d dVar = (le.d) this.f٢٠١٧٠d.remove(Integer.valueOf(cVar4.f٢٠١٨٢c));
                        this.f٢٠١٦٩c.b(cVar4);
                        if (dVar != null) {
                            dVar.onComplete();
                        }
                    } else {
                        c cVar5 = (c) poll;
                        this.f٢٠١٧١e.remove(Integer.valueOf(cVar5.f٢٠١٨٢c));
                        this.f٢٠١٦٩c.b(cVar5);
                    }
                }
            }
            cVar.clear();
        }

        void h(io.reactivex.rxjava3.core.g0 g0Var) {
            Throwable e10 = fe.j.e(this.f٢٠١٧٢f);
            Iterator it = this.f٢٠١٧٠d.values().iterator();
            while (it.hasNext()) {
                ((le.d) it.next()).onError(e10);
            }
            this.f٢٠١٧٠d.clear();
            this.f٢٠١٧١e.clear();
            g0Var.onError(e10);
        }

        void i(Throwable th, io.reactivex.rxjava3.core.g0 g0Var, be.c cVar) {
            od.b.b(th);
            fe.j.a(this.f٢٠١٧٢f, th);
            cVar.clear();
            f();
            h(g0Var);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠١٧٩m;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
        void a(boolean z10, Object obj);

        void b(Throwable th);

        void c(Throwable th);

        void d(boolean z10, c cVar);

        void e(d dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class c extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 1883890389173668373L;

        /* renamed from: a, reason: collision with root package name */
        final b f٢٠١٨٠a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f٢٠١٨١b;

        /* renamed from: c, reason: collision with root package name */
        final int f٢٠١٨٢c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(b bVar, boolean z10, int i10) {
            this.f٢٠١٨٠a = bVar;
            this.f٢٠١٨١b = z10;
            this.f٢٠١٨٢c = i10;
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠١٨٠a.d(this.f٢٠١٨١b, this);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠١٨٠a.c(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (qd.c.a(this)) {
                this.f٢٠١٨٠a.d(this.f٢٠١٨١b, this);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this, cVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class d extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 1883890389173668373L;

        /* renamed from: a, reason: collision with root package name */
        final b f٢٠١٨٣a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f٢٠١٨٤b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(b bVar, boolean z10) {
            this.f٢٠١٨٣a = bVar;
            this.f٢٠١٨٤b = z10;
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠١٨٣a.e(this);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠١٨٣a.b(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠١٨٣a.a(this.f٢٠١٨٤b, obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this, cVar);
        }
    }

    public n1(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, pd.o oVar, pd.o oVar2, pd.c cVar) {
        super(e0Var);
        this.f٢٠١٥٩b = e0Var2;
        this.f٢٠١٦٠c = oVar;
        this.f٢٠١٦١d = oVar2;
        this.f٢٠١٦٢e = cVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var, this.f٢٠١٦٠c, this.f٢٠١٦١d, this.f٢٠١٦٢e);
        g0Var.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.f٢٠١٦٩c.a(dVar);
        d dVar2 = new d(aVar, false);
        aVar.f٢٠١٦٩c.a(dVar2);
        this.f١٩٥٣٢a.subscribe(dVar);
        this.f٢٠١٥٩b.subscribe(dVar2);
    }
}
