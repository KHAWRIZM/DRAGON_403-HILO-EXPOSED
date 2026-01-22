package zd;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import zd.n1;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class u1 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٥٤١b;

    /* renamed from: c, reason: collision with root package name */
    final pd.o f٢٠٥٤٢c;

    /* renamed from: d, reason: collision with root package name */
    final pd.o f٢٠٥٤٣d;

    /* renamed from: e, reason: collision with root package name */
    final pd.c f٢٠٥٤٤e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements nd.c, n1.b {

        /* renamed from: n, reason: collision with root package name */
        static final Integer f٢٠٥٤٥n = 1;

        /* renamed from: o, reason: collision with root package name */
        static final Integer f٢٠٥٤٦o = 2;

        /* renamed from: p, reason: collision with root package name */
        static final Integer f٢٠٥٤٧p = 3;

        /* renamed from: q, reason: collision with root package name */
        static final Integer f٢٠٥٤٨q = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٥٤٩a;

        /* renamed from: g, reason: collision with root package name */
        final pd.o f٢٠٥٥٥g;

        /* renamed from: h, reason: collision with root package name */
        final pd.o f٢٠٥٥٦h;

        /* renamed from: i, reason: collision with root package name */
        final pd.c f٢٠٥٥٧i;

        /* renamed from: k, reason: collision with root package name */
        int f٢٠٥٥٩k;

        /* renamed from: l, reason: collision with root package name */
        int f٢٠٥٦٠l;

        /* renamed from: m, reason: collision with root package name */
        volatile boolean f٢٠٥٦١m;

        /* renamed from: c, reason: collision with root package name */
        final nd.a f٢٠٥٥١c = new nd.a();

        /* renamed from: b, reason: collision with root package name */
        final be.c f٢٠٥٥٠b = new be.c(io.reactivex.rxjava3.core.z.bufferSize());

        /* renamed from: d, reason: collision with root package name */
        final Map f٢٠٥٥٢d = new LinkedHashMap();

        /* renamed from: e, reason: collision with root package name */
        final Map f٢٠٥٥٣e = new LinkedHashMap();

        /* renamed from: f, reason: collision with root package name */
        final AtomicReference f٢٠٥٥٤f = new AtomicReference();

        /* renamed from: j, reason: collision with root package name */
        final AtomicInteger f٢٠٥٥٨j = new AtomicInteger(2);

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, pd.o oVar2, pd.c cVar) {
            this.f٢٠٥٤٩a = g0Var;
            this.f٢٠٥٥٥g = oVar;
            this.f٢٠٥٥٦h = oVar2;
            this.f٢٠٥٥٧i = cVar;
        }

        @Override // zd.n1.b
        public void a(boolean z10, Object obj) {
            Integer num;
            synchronized (this) {
                try {
                    be.c cVar = this.f٢٠٥٥٠b;
                    if (z10) {
                        num = f٢٠٥٤٥n;
                    } else {
                        num = f٢٠٥٤٦o;
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
            if (fe.j.a(this.f٢٠٥٥٤f, th)) {
                this.f٢٠٥٥٨j.decrementAndGet();
                g();
            } else {
                ie.a.s(th);
            }
        }

        @Override // zd.n1.b
        public void c(Throwable th) {
            if (fe.j.a(this.f٢٠٥٥٤f, th)) {
                g();
            } else {
                ie.a.s(th);
            }
        }

        @Override // zd.n1.b
        public void d(boolean z10, n1.c cVar) {
            Integer num;
            synchronized (this) {
                try {
                    be.c cVar2 = this.f٢٠٥٥٠b;
                    if (z10) {
                        num = f٢٠٥٤٧p;
                    } else {
                        num = f٢٠٥٤٨q;
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
            if (!this.f٢٠٥٦١m) {
                this.f٢٠٥٦١m = true;
                f();
                if (getAndIncrement() == 0) {
                    this.f٢٠٥٥٠b.clear();
                }
            }
        }

        @Override // zd.n1.b
        public void e(n1.d dVar) {
            this.f٢٠٥٥١c.c(dVar);
            this.f٢٠٥٥٨j.decrementAndGet();
            g();
        }

        void f() {
            this.f٢٠٥٥١c.dispose();
        }

        void g() {
            boolean z10;
            boolean z11;
            if (getAndIncrement() != 0) {
                return;
            }
            be.c cVar = this.f٢٠٥٥٠b;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٥٤٩a;
            int i10 = 1;
            while (!this.f٢٠٥٦١m) {
                if (((Throwable) this.f٢٠٥٥٤f.get()) != null) {
                    cVar.clear();
                    f();
                    h(g0Var);
                    return;
                }
                if (this.f٢٠٥٥٨j.get() == 0) {
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
                    this.f٢٠٥٥٢d.clear();
                    this.f٢٠٥٥٣e.clear();
                    this.f٢٠٥٥١c.dispose();
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
                    if (num == f٢٠٥٤٥n) {
                        int i11 = this.f٢٠٥٥٩k;
                        this.f٢٠٥٥٩k = i11 + 1;
                        this.f٢٠٥٥٢d.put(Integer.valueOf(i11), poll);
                        try {
                            Object apply = this.f٢٠٥٥٥g.apply(poll);
                            Objects.requireNonNull(apply, "The leftEnd returned a null ObservableSource");
                            io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                            n1.c cVar2 = new n1.c(this, true, i11);
                            this.f٢٠٥٥١c.a(cVar2);
                            e0Var.subscribe(cVar2);
                            if (((Throwable) this.f٢٠٥٥٤f.get()) != null) {
                                cVar.clear();
                                f();
                                h(g0Var);
                                return;
                            }
                            Iterator it = this.f٢٠٥٥٣e.values().iterator();
                            while (it.hasNext()) {
                                try {
                                    Object apply2 = this.f٢٠٥٥٧i.apply(poll, it.next());
                                    Objects.requireNonNull(apply2, "The resultSelector returned a null value");
                                    g0Var.onNext(apply2);
                                } catch (Throwable th) {
                                    i(th, g0Var, cVar);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            i(th2, g0Var, cVar);
                            return;
                        }
                    } else if (num == f٢٠٥٤٦o) {
                        int i12 = this.f٢٠٥٦٠l;
                        this.f٢٠٥٦٠l = i12 + 1;
                        this.f٢٠٥٥٣e.put(Integer.valueOf(i12), poll);
                        try {
                            Object apply3 = this.f٢٠٥٥٦h.apply(poll);
                            Objects.requireNonNull(apply3, "The rightEnd returned a null ObservableSource");
                            io.reactivex.rxjava3.core.e0 e0Var2 = (io.reactivex.rxjava3.core.e0) apply3;
                            n1.c cVar3 = new n1.c(this, false, i12);
                            this.f٢٠٥٥١c.a(cVar3);
                            e0Var2.subscribe(cVar3);
                            if (((Throwable) this.f٢٠٥٥٤f.get()) != null) {
                                cVar.clear();
                                f();
                                h(g0Var);
                                return;
                            }
                            Iterator it2 = this.f٢٠٥٥٢d.values().iterator();
                            while (it2.hasNext()) {
                                try {
                                    Object apply4 = this.f٢٠٥٥٧i.apply(it2.next(), poll);
                                    Objects.requireNonNull(apply4, "The resultSelector returned a null value");
                                    g0Var.onNext(apply4);
                                } catch (Throwable th3) {
                                    i(th3, g0Var, cVar);
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            i(th4, g0Var, cVar);
                            return;
                        }
                    } else if (num == f٢٠٥٤٧p) {
                        n1.c cVar4 = (n1.c) poll;
                        this.f٢٠٥٥٢d.remove(Integer.valueOf(cVar4.f٢٠١٨٢c));
                        this.f٢٠٥٥١c.b(cVar4);
                    } else {
                        n1.c cVar5 = (n1.c) poll;
                        this.f٢٠٥٥٣e.remove(Integer.valueOf(cVar5.f٢٠١٨٢c));
                        this.f٢٠٥٥١c.b(cVar5);
                    }
                }
            }
            cVar.clear();
        }

        void h(io.reactivex.rxjava3.core.g0 g0Var) {
            Throwable e10 = fe.j.e(this.f٢٠٥٥٤f);
            this.f٢٠٥٥٢d.clear();
            this.f٢٠٥٥٣e.clear();
            g0Var.onError(e10);
        }

        void i(Throwable th, io.reactivex.rxjava3.core.g0 g0Var, be.c cVar) {
            od.b.b(th);
            fe.j.a(this.f٢٠٥٥٤f, th);
            cVar.clear();
            f();
            h(g0Var);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٥٦١m;
        }
    }

    public u1(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, pd.o oVar, pd.o oVar2, pd.c cVar) {
        super(e0Var);
        this.f٢٠٥٤١b = e0Var2;
        this.f٢٠٥٤٢c = oVar;
        this.f٢٠٥٤٣d = oVar2;
        this.f٢٠٥٤٤e = cVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var, this.f٢٠٥٤٢c, this.f٢٠٥٤٣d, this.f٢٠٥٤٤e);
        g0Var.onSubscribe(aVar);
        n1.d dVar = new n1.d(aVar, true);
        aVar.f٢٠٥٥١c.a(dVar);
        n1.d dVar2 = new n1.d(aVar, false);
        aVar.f٢٠٥٥١c.a(dVar2);
        this.f١٩٥٣٢a.subscribe(dVar);
        this.f٢٠٥٤١b.subscribe(dVar2);
    }
}
