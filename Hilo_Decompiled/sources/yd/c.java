package yd;

import fe.i;
import io.reactivex.rxjava3.core.e0;
import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.m0;
import io.reactivex.rxjava3.core.z;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import pd.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c extends z {

    /* renamed from: a, reason: collision with root package name */
    final e0 f١٩٢٧١a;

    /* renamed from: b, reason: collision with root package name */
    final o f١٩٢٧٢b;

    /* renamed from: c, reason: collision with root package name */
    final i f١٩٢٧٣c;

    /* renamed from: d, reason: collision with root package name */
    final int f١٩٢٧٤d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements g0, nd.c {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: a, reason: collision with root package name */
        final g0 f١٩٢٧٥a;

        /* renamed from: b, reason: collision with root package name */
        final o f١٩٢٧٦b;

        /* renamed from: c, reason: collision with root package name */
        final fe.c f١٩٢٧٧c = new fe.c();

        /* renamed from: d, reason: collision with root package name */
        final C٠٢٥١a f١٩٢٧٨d = new C٠٢٥١a(this);

        /* renamed from: e, reason: collision with root package name */
        final sd.i f١٩٢٧٩e;

        /* renamed from: f, reason: collision with root package name */
        final i f١٩٢٨٠f;

        /* renamed from: g, reason: collision with root package name */
        nd.c f١٩٢٨١g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f١٩٢٨٢h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f١٩٢٨٣i;

        /* renamed from: j, reason: collision with root package name */
        Object f١٩٢٨٤j;

        /* renamed from: k, reason: collision with root package name */
        volatile int f١٩٢٨٥k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: yd.c$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class C٠٢٥١a extends AtomicReference implements k0 {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: a, reason: collision with root package name */
            final a f١٩٢٨٦a;

            C٠٢٥١a(a aVar) {
                this.f١٩٢٨٦a = aVar;
            }

            void a() {
                qd.c.a(this);
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                this.f١٩٢٨٦a.b(th);
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.d(this, cVar);
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onSuccess(Object obj) {
                this.f١٩٢٨٦a.c(obj);
            }
        }

        a(g0 g0Var, o oVar, int i10, i iVar) {
            this.f١٩٢٧٥a = g0Var;
            this.f١٩٢٧٦b = oVar;
            this.f١٩٢٨٠f = iVar;
            this.f١٩٢٧٩e = new be.c(i10);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            g0 g0Var = this.f١٩٢٧٥a;
            i iVar = this.f١٩٢٨٠f;
            sd.i iVar2 = this.f١٩٢٧٩e;
            fe.c cVar = this.f١٩٢٧٧c;
            int i10 = 1;
            while (true) {
                if (this.f١٩٢٨٣i) {
                    iVar2.clear();
                    this.f١٩٢٨٤j = null;
                } else {
                    int i11 = this.f١٩٢٨٥k;
                    if (cVar.get() == null || (iVar != i.IMMEDIATE && (iVar != i.BOUNDARY || i11 != 0))) {
                        boolean z10 = false;
                        if (i11 == 0) {
                            boolean z11 = this.f١٩٢٨٢h;
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
                                    Object apply = this.f١٩٢٧٦b.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                                    m0 m0Var = (m0) apply;
                                    this.f١٩٢٨٥k = 1;
                                    m0Var.a(this.f١٩٢٧٨d);
                                } catch (Throwable th) {
                                    od.b.b(th);
                                    this.f١٩٢٨١g.dispose();
                                    iVar2.clear();
                                    cVar.c(th);
                                    cVar.f(g0Var);
                                    return;
                                }
                            }
                        } else if (i11 == 2) {
                            Object obj = this.f١٩٢٨٤j;
                            this.f١٩٢٨٤j = null;
                            g0Var.onNext(obj);
                            this.f١٩٢٨٥k = 0;
                        }
                    }
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
            iVar2.clear();
            this.f١٩٢٨٤j = null;
            cVar.f(g0Var);
        }

        void b(Throwable th) {
            if (this.f١٩٢٧٧c.c(th)) {
                if (this.f١٩٢٨٠f != i.END) {
                    this.f١٩٢٨١g.dispose();
                }
                this.f١٩٢٨٥k = 0;
                a();
            }
        }

        void c(Object obj) {
            this.f١٩٢٨٤j = obj;
            this.f١٩٢٨٥k = 2;
            a();
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٢٨٣i = true;
            this.f١٩٢٨١g.dispose();
            this.f١٩٢٧٨d.a();
            this.f١٩٢٧٧c.d();
            if (getAndIncrement() == 0) {
                this.f١٩٢٧٩e.clear();
                this.f١٩٢٨٤j = null;
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٢٨٣i;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٢٨٢h = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٢٧٧c.c(th)) {
                if (this.f١٩٢٨٠f == i.IMMEDIATE) {
                    this.f١٩٢٧٨d.a();
                }
                this.f١٩٢٨٢h = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٢٧٩e.offer(obj);
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٢٨١g, cVar)) {
                this.f١٩٢٨١g = cVar;
                this.f١٩٢٧٥a.onSubscribe(this);
            }
        }
    }

    public c(e0 e0Var, o oVar, i iVar, int i10) {
        this.f١٩٢٧١a = e0Var;
        this.f١٩٢٧٢b = oVar;
        this.f١٩٢٧٣c = iVar;
        this.f١٩٢٧٤d = i10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        if (!g.c(this.f١٩٢٧١a, this.f١٩٢٧٢b, g0Var)) {
            this.f١٩٢٧١a.subscribe(new a(g0Var, this.f١٩٢٧٢b, this.f١٩٢٧٤d, this.f١٩٢٧٣c));
        }
    }
}
