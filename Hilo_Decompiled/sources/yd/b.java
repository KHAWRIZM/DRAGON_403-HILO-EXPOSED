package yd;

import fe.i;
import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.l;
import io.reactivex.rxjava3.core.n;
import io.reactivex.rxjava3.core.z;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import pd.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b extends z {

    /* renamed from: a, reason: collision with root package name */
    final z f١٩٢٥٥a;

    /* renamed from: b, reason: collision with root package name */
    final o f١٩٢٥٦b;

    /* renamed from: c, reason: collision with root package name */
    final i f١٩٢٥٧c;

    /* renamed from: d, reason: collision with root package name */
    final int f١٩٢٥٨d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements g0, nd.c {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: a, reason: collision with root package name */
        final g0 f١٩٢٥٩a;

        /* renamed from: b, reason: collision with root package name */
        final o f١٩٢٦٠b;

        /* renamed from: c, reason: collision with root package name */
        final fe.c f١٩٢٦١c = new fe.c();

        /* renamed from: d, reason: collision with root package name */
        final C٠٢٥٠a f١٩٢٦٢d = new C٠٢٥٠a(this);

        /* renamed from: e, reason: collision with root package name */
        final sd.i f١٩٢٦٣e;

        /* renamed from: f, reason: collision with root package name */
        final i f١٩٢٦٤f;

        /* renamed from: g, reason: collision with root package name */
        nd.c f١٩٢٦٥g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f١٩٢٦٦h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f١٩٢٦٧i;

        /* renamed from: j, reason: collision with root package name */
        Object f١٩٢٦٨j;

        /* renamed from: k, reason: collision with root package name */
        volatile int f١٩٢٦٩k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: yd.b$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class C٠٢٥٠a extends AtomicReference implements l {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: a, reason: collision with root package name */
            final a f١٩٢٧٠a;

            C٠٢٥٠a(a aVar) {
                this.f١٩٢٧٠a = aVar;
            }

            void a() {
                qd.c.a(this);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                this.f١٩٢٧٠a.b();
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                this.f١٩٢٧٠a.c(th);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.d(this, cVar);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSuccess(Object obj) {
                this.f١٩٢٧٠a.d(obj);
            }
        }

        a(g0 g0Var, o oVar, int i10, i iVar) {
            this.f١٩٢٥٩a = g0Var;
            this.f١٩٢٦٠b = oVar;
            this.f١٩٢٦٤f = iVar;
            this.f١٩٢٦٣e = new be.c(i10);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            g0 g0Var = this.f١٩٢٥٩a;
            i iVar = this.f١٩٢٦٤f;
            sd.i iVar2 = this.f١٩٢٦٣e;
            fe.c cVar = this.f١٩٢٦١c;
            int i10 = 1;
            while (true) {
                if (this.f١٩٢٦٧i) {
                    iVar2.clear();
                    this.f١٩٢٦٨j = null;
                } else {
                    int i11 = this.f١٩٢٦٩k;
                    if (cVar.get() == null || (iVar != i.IMMEDIATE && (iVar != i.BOUNDARY || i11 != 0))) {
                        boolean z10 = false;
                        if (i11 == 0) {
                            boolean z11 = this.f١٩٢٦٦h;
                            Object poll = iVar2.poll();
                            if (poll == null) {
                                z10 = true;
                            }
                            if (z11 && z10) {
                                cVar.f(g0Var);
                                return;
                            }
                            if (!z10) {
                                try {
                                    Object apply = this.f١٩٢٦٠b.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                                    n nVar = (n) apply;
                                    this.f١٩٢٦٩k = 1;
                                    nVar.a(this.f١٩٢٦٢d);
                                } catch (Throwable th) {
                                    od.b.b(th);
                                    this.f١٩٢٦٥g.dispose();
                                    iVar2.clear();
                                    cVar.c(th);
                                    cVar.f(g0Var);
                                    return;
                                }
                            }
                        } else if (i11 == 2) {
                            Object obj = this.f١٩٢٦٨j;
                            this.f١٩٢٦٨j = null;
                            g0Var.onNext(obj);
                            this.f١٩٢٦٩k = 0;
                        }
                    }
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
            iVar2.clear();
            this.f١٩٢٦٨j = null;
            cVar.f(g0Var);
        }

        void b() {
            this.f١٩٢٦٩k = 0;
            a();
        }

        void c(Throwable th) {
            if (this.f١٩٢٦١c.c(th)) {
                if (this.f١٩٢٦٤f != i.END) {
                    this.f١٩٢٦٥g.dispose();
                }
                this.f١٩٢٦٩k = 0;
                a();
            }
        }

        void d(Object obj) {
            this.f١٩٢٦٨j = obj;
            this.f١٩٢٦٩k = 2;
            a();
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٢٦٧i = true;
            this.f١٩٢٦٥g.dispose();
            this.f١٩٢٦٢d.a();
            this.f١٩٢٦١c.d();
            if (getAndIncrement() == 0) {
                this.f١٩٢٦٣e.clear();
                this.f١٩٢٦٨j = null;
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٢٦٧i;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٢٦٦h = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٢٦١c.c(th)) {
                if (this.f١٩٢٦٤f == i.IMMEDIATE) {
                    this.f١٩٢٦٢d.a();
                }
                this.f١٩٢٦٦h = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٢٦٣e.offer(obj);
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٢٦٥g, cVar)) {
                this.f١٩٢٦٥g = cVar;
                this.f١٩٢٥٩a.onSubscribe(this);
            }
        }
    }

    public b(z zVar, o oVar, i iVar, int i10) {
        this.f١٩٢٥٥a = zVar;
        this.f١٩٢٥٦b = oVar;
        this.f١٩٢٥٧c = iVar;
        this.f١٩٢٥٨d = i10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        if (!g.b(this.f١٩٢٥٥a, this.f١٩٢٥٦b, g0Var)) {
            this.f١٩٢٥٥a.subscribe(new a(g0Var, this.f١٩٢٥٦b, this.f١٩٢٥٨d, this.f١٩٢٥٧c));
        }
    }
}
