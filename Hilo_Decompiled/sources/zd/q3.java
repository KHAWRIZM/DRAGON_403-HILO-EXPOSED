package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class q3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٣٤٩b;

    /* renamed from: c, reason: collision with root package name */
    final int f٢٠٣٥٠c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f٢٠٣٥١d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = 3837284832786408377L;

        /* renamed from: a, reason: collision with root package name */
        final b f٢٠٣٥٢a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٣٥٣b;

        /* renamed from: c, reason: collision with root package name */
        final int f٢٠٣٥٤c;

        /* renamed from: d, reason: collision with root package name */
        volatile sd.j f٢٠٣٥٥d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f٢٠٣٥٦e;

        a(b bVar, long j10, int i10) {
            this.f٢٠٣٥٢a = bVar;
            this.f٢٠٣٥٣b = j10;
            this.f٢٠٣٥٤c = i10;
        }

        public void a() {
            qd.c.a(this);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f٢٠٣٥٣b == this.f٢٠٣٥٢a.f٢٠٣٦٧j) {
                this.f٢٠٣٥٦e = true;
                this.f٢٠٣٥٢a.b();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٣٥٢a.c(this, th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٣٥٣b == this.f٢٠٣٥٢a.f٢٠٣٦٧j) {
                if (obj != null) {
                    this.f٢٠٣٥٥d.offer(obj);
                }
                this.f٢٠٣٥٢a.b();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.g(this, cVar)) {
                if (cVar instanceof sd.e) {
                    sd.e eVar = (sd.e) cVar;
                    int a10 = eVar.a(7);
                    if (a10 == 1) {
                        this.f٢٠٣٥٥d = eVar;
                        this.f٢٠٣٥٦e = true;
                        this.f٢٠٣٥٢a.b();
                        return;
                    } else if (a10 == 2) {
                        this.f٢٠٣٥٥d = eVar;
                        return;
                    }
                }
                this.f٢٠٣٥٥d = new be.c(this.f٢٠٣٥٤c);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: k, reason: collision with root package name */
        static final a f٢٠٣٥٧k;
        private static final long serialVersionUID = -3491074160481096299L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٣٥٨a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f٢٠٣٥٩b;

        /* renamed from: c, reason: collision with root package name */
        final int f٢٠٣٦٠c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f٢٠٣٦١d;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f٢٠٣٦٣f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f٢٠٣٦٤g;

        /* renamed from: h, reason: collision with root package name */
        nd.c f٢٠٣٦٥h;

        /* renamed from: j, reason: collision with root package name */
        volatile long f٢٠٣٦٧j;

        /* renamed from: i, reason: collision with root package name */
        final AtomicReference f٢٠٣٦٦i = new AtomicReference();

        /* renamed from: e, reason: collision with root package name */
        final fe.c f٢٠٣٦٢e = new fe.c();

        static {
            a aVar = new a(null, -1L, 1);
            f٢٠٣٥٧k = aVar;
            aVar.a();
        }

        b(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, int i10, boolean z10) {
            this.f٢٠٣٥٨a = g0Var;
            this.f٢٠٣٥٩b = oVar;
            this.f٢٠٣٦٠c = i10;
            this.f٢٠٣٦١d = z10;
        }

        void a() {
            a aVar = (a) this.f٢٠٣٦٦i.getAndSet(f٢٠٣٥٧k);
            if (aVar != null) {
                aVar.a();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x00b7 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x000f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void b() {
            sd.j jVar;
            Object obj;
            boolean z10;
            boolean z11;
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٣٥٨a;
            AtomicReference atomicReference = this.f٢٠٣٦٦i;
            boolean z12 = this.f٢٠٣٦١d;
            int i10 = 1;
            while (!this.f٢٠٣٦٤g) {
                if (this.f٢٠٣٦٣f) {
                    if (atomicReference.get() == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z12) {
                        if (z11) {
                            Throwable th = (Throwable) this.f٢٠٣٦٢e.get();
                            if (th != null) {
                                g0Var.onError(th);
                                return;
                            } else {
                                g0Var.onComplete();
                                return;
                            }
                        }
                    } else if (((Throwable) this.f٢٠٣٦٢e.get()) != null) {
                        this.f٢٠٣٦٢e.f(g0Var);
                        return;
                    } else if (z11) {
                        g0Var.onComplete();
                        return;
                    }
                }
                a aVar = (a) atomicReference.get();
                if (aVar != null && (jVar = aVar.f٢٠٣٥٥d) != null) {
                    boolean z13 = false;
                    while (!this.f٢٠٣٦٤g) {
                        if (aVar == atomicReference.get()) {
                            if (!z12 && ((Throwable) this.f٢٠٣٦٢e.get()) != null) {
                                this.f٢٠٣٦٢e.f(g0Var);
                                return;
                            }
                            boolean z14 = aVar.f٢٠٣٥٦e;
                            try {
                                obj = jVar.poll();
                            } catch (Throwable th2) {
                                od.b.b(th2);
                                this.f٢٠٣٦٢e.c(th2);
                                androidx.lifecycle.a.a(atomicReference, aVar, null);
                                if (!z12) {
                                    a();
                                    this.f٢٠٣٦٥h.dispose();
                                    this.f٢٠٣٦٣f = true;
                                } else {
                                    aVar.a();
                                }
                                obj = null;
                                z13 = true;
                            }
                            if (obj == null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z14 && z10) {
                                androidx.lifecycle.a.a(atomicReference, aVar, null);
                            } else if (z10) {
                                if (!z13) {
                                    continue;
                                }
                            } else {
                                g0Var.onNext(obj);
                            }
                        }
                        z13 = true;
                        if (!z13) {
                        }
                    }
                    return;
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }

        void c(a aVar, Throwable th) {
            if (aVar.f٢٠٣٥٣b == this.f٢٠٣٦٧j && this.f٢٠٣٦٢e.b(th)) {
                if (!this.f٢٠٣٦١d) {
                    this.f٢٠٣٦٥h.dispose();
                    this.f٢٠٣٦٣f = true;
                }
                aVar.f٢٠٣٥٦e = true;
                b();
                return;
            }
            ie.a.s(th);
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f٢٠٣٦٤g) {
                this.f٢٠٣٦٤g = true;
                this.f٢٠٣٦٥h.dispose();
                a();
                this.f٢٠٣٦٢e.d();
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٣٦٤g;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f٢٠٣٦٣f) {
                this.f٢٠٣٦٣f = true;
                b();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (!this.f٢٠٣٦٣f && this.f٢٠٣٦٢e.b(th)) {
                if (!this.f٢٠٣٦١d) {
                    a();
                }
                this.f٢٠٣٦٣f = true;
                b();
                return;
            }
            ie.a.s(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            a aVar;
            long j10 = this.f٢٠٣٦٧j + 1;
            this.f٢٠٣٦٧j = j10;
            a aVar2 = (a) this.f٢٠٣٦٦i.get();
            if (aVar2 != null) {
                aVar2.a();
            }
            try {
                Object apply = this.f٢٠٣٥٩b.apply(obj);
                Objects.requireNonNull(apply, "The ObservableSource returned is null");
                io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                a aVar3 = new a(this, j10, this.f٢٠٣٦٠c);
                do {
                    aVar = (a) this.f٢٠٣٦٦i.get();
                    if (aVar == f٢٠٣٥٧k) {
                        return;
                    }
                } while (!androidx.lifecycle.a.a(this.f٢٠٣٦٦i, aVar, aVar3));
                e0Var.subscribe(aVar3);
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠٣٦٥h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٣٦٥h, cVar)) {
                this.f٢٠٣٦٥h = cVar;
                this.f٢٠٣٥٨a.onSubscribe(this);
            }
        }
    }

    public q3(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, int i10, boolean z10) {
        super(e0Var);
        this.f٢٠٣٤٩b = oVar;
        this.f٢٠٣٥٠c = i10;
        this.f٢٠٣٥١d = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        if (b3.b(this.f١٩٥٣٢a, g0Var, this.f٢٠٣٤٩b)) {
            return;
        }
        this.f١٩٥٣٢a.subscribe(new b(g0Var, this.f٢٠٣٤٩b, this.f٢٠٣٥٠c, this.f٢٠٣٥١d));
    }
}
