package zd;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e3 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٧٢٢a;

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٧٢٣b;

    /* renamed from: c, reason: collision with root package name */
    final pd.d f١٩٧٢٤c;

    /* renamed from: d, reason: collision with root package name */
    final int f١٩٧٢٥d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements nd.c {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٧٢٦a;

        /* renamed from: b, reason: collision with root package name */
        final pd.d f١٩٧٢٧b;

        /* renamed from: c, reason: collision with root package name */
        final qd.a f١٩٧٢٨c;

        /* renamed from: d, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f١٩٧٢٩d;

        /* renamed from: e, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f١٩٧٣٠e;

        /* renamed from: f, reason: collision with root package name */
        final b[] f١٩٧٣١f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f١٩٧٣٢g;

        /* renamed from: h, reason: collision with root package name */
        Object f١٩٧٣٣h;

        /* renamed from: i, reason: collision with root package name */
        Object f١٩٧٣٤i;

        a(io.reactivex.rxjava3.core.g0 g0Var, int i10, io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, pd.d dVar) {
            this.f١٩٧٢٦a = g0Var;
            this.f١٩٧٢٩d = e0Var;
            this.f١٩٧٣٠e = e0Var2;
            this.f١٩٧٢٧b = dVar;
            this.f١٩٧٣١f = r3;
            b[] bVarArr = {new b(this, 0, i10), new b(this, 1, i10)};
            this.f١٩٧٢٨c = new qd.a(2);
        }

        void a(be.c cVar, be.c cVar2) {
            this.f١٩٧٣٢g = true;
            cVar.clear();
            cVar2.clear();
        }

        void b() {
            boolean z10;
            boolean z11;
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            b[] bVarArr = this.f١٩٧٣١f;
            b bVar = bVarArr[0];
            be.c cVar = bVar.f١٩٧٣٦b;
            b bVar2 = bVarArr[1];
            be.c cVar2 = bVar2.f١٩٧٣٦b;
            int i10 = 1;
            while (!this.f١٩٧٣٢g) {
                boolean z12 = bVar.f١٩٧٣٨d;
                if (z12 && (th2 = bVar.f١٩٧٣٩e) != null) {
                    a(cVar, cVar2);
                    this.f١٩٧٢٦a.onError(th2);
                    return;
                }
                boolean z13 = bVar2.f١٩٧٣٨d;
                if (z13 && (th = bVar2.f١٩٧٣٩e) != null) {
                    a(cVar, cVar2);
                    this.f١٩٧٢٦a.onError(th);
                    return;
                }
                if (this.f١٩٧٣٣h == null) {
                    this.f١٩٧٣٣h = cVar.poll();
                }
                if (this.f١٩٧٣٣h == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (this.f١٩٧٣٤i == null) {
                    this.f١٩٧٣٤i = cVar2.poll();
                }
                Object obj = this.f١٩٧٣٤i;
                if (obj == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z12 && z13 && z10 && z11) {
                    this.f١٩٧٢٦a.onNext(Boolean.TRUE);
                    this.f١٩٧٢٦a.onComplete();
                    return;
                }
                if (z12 && z13 && z10 != z11) {
                    a(cVar, cVar2);
                    this.f١٩٧٢٦a.onNext(Boolean.FALSE);
                    this.f١٩٧٢٦a.onComplete();
                    return;
                }
                if (!z10 && !z11) {
                    try {
                        if (!this.f١٩٧٢٧b.a(this.f١٩٧٣٣h, obj)) {
                            a(cVar, cVar2);
                            this.f١٩٧٢٦a.onNext(Boolean.FALSE);
                            this.f١٩٧٢٦a.onComplete();
                            return;
                        }
                        this.f١٩٧٣٣h = null;
                        this.f١٩٧٣٤i = null;
                    } catch (Throwable th3) {
                        od.b.b(th3);
                        a(cVar, cVar2);
                        this.f١٩٧٢٦a.onError(th3);
                        return;
                    }
                }
                if (z10 || z11) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            }
            cVar.clear();
            cVar2.clear();
        }

        boolean c(nd.c cVar, int i10) {
            return this.f١٩٧٢٨c.a(i10, cVar);
        }

        void d() {
            b[] bVarArr = this.f١٩٧٣١f;
            this.f١٩٧٢٩d.subscribe(bVarArr[0]);
            this.f١٩٧٣٠e.subscribe(bVarArr[1]);
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f١٩٧٣٢g) {
                this.f١٩٧٣٢g = true;
                this.f١٩٧٢٨c.dispose();
                if (getAndIncrement() == 0) {
                    b[] bVarArr = this.f١٩٧٣١f;
                    bVarArr[0].f١٩٧٣٦b.clear();
                    bVarArr[1].f١٩٧٣٦b.clear();
                }
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٧٣٢g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        final a f١٩٧٣٥a;

        /* renamed from: b, reason: collision with root package name */
        final be.c f١٩٧٣٦b;

        /* renamed from: c, reason: collision with root package name */
        final int f١٩٧٣٧c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f١٩٧٣٨d;

        /* renamed from: e, reason: collision with root package name */
        Throwable f١٩٧٣٩e;

        b(a aVar, int i10, int i11) {
            this.f١٩٧٣٥a = aVar;
            this.f١٩٧٣٧c = i10;
            this.f١٩٧٣٦b = new be.c(i11);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٧٣٨d = true;
            this.f١٩٧٣٥a.b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٧٣٩e = th;
            this.f١٩٧٣٨d = true;
            this.f١٩٧٣٥a.b();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٧٣٦b.offer(obj);
            this.f١٩٧٣٥a.b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f١٩٧٣٥a.c(cVar, this.f١٩٧٣٧c);
        }
    }

    public e3(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, pd.d dVar, int i10) {
        this.f١٩٧٢٢a = e0Var;
        this.f١٩٧٢٣b = e0Var2;
        this.f١٩٧٢٤c = dVar;
        this.f١٩٧٢٥d = i10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var, this.f١٩٧٢٥d, this.f١٩٧٢٢a, this.f١٩٧٢٣b, this.f١٩٧٢٤c);
        g0Var.onSubscribe(aVar);
        aVar.d();
    }
}
