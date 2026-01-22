package zd;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class u extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٥٢١b;

    /* renamed from: c, reason: collision with root package name */
    final fe.i f٢٠٥٢٢c;

    /* renamed from: d, reason: collision with root package name */
    final int f٢٠٥٢٣d;

    /* renamed from: e, reason: collision with root package name */
    final int f٢٠٥٢٤e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c, ud.p {
        private static final long serialVersionUID = 8080567949447303262L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٥٢٥a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f٢٠٥٢٦b;

        /* renamed from: c, reason: collision with root package name */
        final int f٢٠٥٢٧c;

        /* renamed from: d, reason: collision with root package name */
        final int f٢٠٥٢٨d;

        /* renamed from: e, reason: collision with root package name */
        final fe.i f٢٠٥٢٩e;

        /* renamed from: f, reason: collision with root package name */
        final fe.c f٢٠٥٣٠f = new fe.c();

        /* renamed from: g, reason: collision with root package name */
        final ArrayDeque f٢٠٥٣١g = new ArrayDeque();

        /* renamed from: h, reason: collision with root package name */
        sd.j f٢٠٥٣٢h;

        /* renamed from: i, reason: collision with root package name */
        nd.c f٢٠٥٣٣i;

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f٢٠٥٣٤j;

        /* renamed from: k, reason: collision with root package name */
        int f٢٠٥٣٥k;

        /* renamed from: l, reason: collision with root package name */
        volatile boolean f٢٠٥٣٦l;

        /* renamed from: m, reason: collision with root package name */
        ud.o f٢٠٥٣٧m;

        /* renamed from: n, reason: collision with root package name */
        int f٢٠٥٣٨n;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, int i10, int i11, fe.i iVar) {
            this.f٢٠٥٢٥a = g0Var;
            this.f٢٠٥٢٦b = oVar;
            this.f٢٠٥٢٧c = i10;
            this.f٢٠٥٢٨d = i11;
            this.f٢٠٥٢٩e = iVar;
        }

        @Override // ud.p
        public void a(ud.o oVar, Object obj) {
            oVar.b().offer(obj);
            b();
        }

        @Override // ud.p
        public void b() {
            Object poll;
            boolean z10;
            boolean z11;
            if (getAndIncrement() != 0) {
                return;
            }
            sd.j jVar = this.f٢٠٥٣٢h;
            ArrayDeque arrayDeque = this.f٢٠٥٣١g;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٥٢٥a;
            fe.i iVar = this.f٢٠٥٢٩e;
            int i10 = 1;
            while (true) {
                int i11 = this.f٢٠٥٣٨n;
                while (i11 != this.f٢٠٥٢٧c) {
                    if (this.f٢٠٥٣٦l) {
                        jVar.clear();
                        e();
                        return;
                    }
                    if (iVar == fe.i.IMMEDIATE && ((Throwable) this.f٢٠٥٣٠f.get()) != null) {
                        jVar.clear();
                        e();
                        this.f٢٠٥٣٠f.f(this.f٢٠٥٢٥a);
                        return;
                    }
                    try {
                        Object poll2 = jVar.poll();
                        if (poll2 == null) {
                            break;
                        }
                        Object apply = this.f٢٠٥٢٦b.apply(poll2);
                        Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                        io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                        ud.o oVar = new ud.o(this, this.f٢٠٥٢٨d);
                        arrayDeque.offer(oVar);
                        e0Var.subscribe(oVar);
                        i11++;
                    } catch (Throwable th) {
                        od.b.b(th);
                        this.f٢٠٥٣٣i.dispose();
                        jVar.clear();
                        e();
                        this.f٢٠٥٣٠f.c(th);
                        this.f٢٠٥٣٠f.f(this.f٢٠٥٢٥a);
                        return;
                    }
                }
                this.f٢٠٥٣٨n = i11;
                if (this.f٢٠٥٣٦l) {
                    jVar.clear();
                    e();
                    return;
                }
                if (iVar == fe.i.IMMEDIATE && ((Throwable) this.f٢٠٥٣٠f.get()) != null) {
                    jVar.clear();
                    e();
                    this.f٢٠٥٣٠f.f(this.f٢٠٥٢٥a);
                    return;
                }
                ud.o oVar2 = this.f٢٠٥٣٧m;
                if (oVar2 == null) {
                    if (iVar == fe.i.BOUNDARY && ((Throwable) this.f٢٠٥٣٠f.get()) != null) {
                        jVar.clear();
                        e();
                        this.f٢٠٥٣٠f.f(g0Var);
                        return;
                    }
                    boolean z12 = this.f٢٠٥٣٤j;
                    ud.o oVar3 = (ud.o) arrayDeque.poll();
                    if (oVar3 == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z12 && z11) {
                        if (((Throwable) this.f٢٠٥٣٠f.get()) != null) {
                            jVar.clear();
                            e();
                            this.f٢٠٥٣٠f.f(g0Var);
                            return;
                        }
                        g0Var.onComplete();
                        return;
                    }
                    if (!z11) {
                        this.f٢٠٥٣٧m = oVar3;
                    }
                    oVar2 = oVar3;
                }
                if (oVar2 != null) {
                    sd.j b10 = oVar2.b();
                    while (!this.f٢٠٥٣٦l) {
                        boolean a10 = oVar2.a();
                        if (iVar == fe.i.IMMEDIATE && ((Throwable) this.f٢٠٥٣٠f.get()) != null) {
                            jVar.clear();
                            e();
                            this.f٢٠٥٣٠f.f(g0Var);
                            return;
                        }
                        try {
                            poll = b10.poll();
                            if (poll == null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                        } catch (Throwable th2) {
                            od.b.b(th2);
                            this.f٢٠٥٣٠f.c(th2);
                            this.f٢٠٥٣٧m = null;
                            this.f٢٠٥٣٨n--;
                        }
                        if (a10 && z10) {
                            this.f٢٠٥٣٧m = null;
                            this.f٢٠٥٣٨n--;
                        } else if (!z10) {
                            g0Var.onNext(poll);
                        }
                    }
                    jVar.clear();
                    e();
                    return;
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }

        @Override // ud.p
        public void c(ud.o oVar) {
            oVar.c();
            b();
        }

        @Override // ud.p
        public void d(ud.o oVar, Throwable th) {
            if (this.f٢٠٥٣٠f.c(th)) {
                if (this.f٢٠٥٢٩e == fe.i.IMMEDIATE) {
                    this.f٢٠٥٣٣i.dispose();
                }
                oVar.c();
                b();
            }
        }

        @Override // nd.c
        public void dispose() {
            if (this.f٢٠٥٣٦l) {
                return;
            }
            this.f٢٠٥٣٦l = true;
            this.f٢٠٥٣٣i.dispose();
            this.f٢٠٥٣٠f.d();
            f();
        }

        void e() {
            ud.o oVar = this.f٢٠٥٣٧m;
            if (oVar != null) {
                oVar.dispose();
            }
            while (true) {
                ud.o oVar2 = (ud.o) this.f٢٠٥٣١g.poll();
                if (oVar2 == null) {
                    return;
                } else {
                    oVar2.dispose();
                }
            }
        }

        void f() {
            if (getAndIncrement() != 0) {
                return;
            }
            do {
                this.f٢٠٥٣٢h.clear();
                e();
            } while (decrementAndGet() != 0);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٥٣٦l;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٥٣٤j = true;
            b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٥٣٠f.c(th)) {
                this.f٢٠٥٣٤j = true;
                b();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٥٣٥k == 0) {
                this.f٢٠٥٣٢h.offer(obj);
            }
            b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٥٣٣i, cVar)) {
                this.f٢٠٥٣٣i = cVar;
                if (cVar instanceof sd.e) {
                    sd.e eVar = (sd.e) cVar;
                    int a10 = eVar.a(3);
                    if (a10 == 1) {
                        this.f٢٠٥٣٥k = a10;
                        this.f٢٠٥٣٢h = eVar;
                        this.f٢٠٥٣٤j = true;
                        this.f٢٠٥٢٥a.onSubscribe(this);
                        b();
                        return;
                    }
                    if (a10 == 2) {
                        this.f٢٠٥٣٥k = a10;
                        this.f٢٠٥٣٢h = eVar;
                        this.f٢٠٥٢٥a.onSubscribe(this);
                        return;
                    }
                }
                this.f٢٠٥٣٢h = new be.c(this.f٢٠٥٢٨d);
                this.f٢٠٥٢٥a.onSubscribe(this);
            }
        }
    }

    public u(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, fe.i iVar, int i10, int i11) {
        super(e0Var);
        this.f٢٠٥٢١b = oVar;
        this.f٢٠٥٢٢c = iVar;
        this.f٢٠٥٢٣d = i10;
        this.f٢٠٥٢٤e = i11;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٥٢١b, this.f٢٠٥٢٣d, this.f٢٠٥٢٤e, this.f٢٠٥٢٢c));
    }
}
