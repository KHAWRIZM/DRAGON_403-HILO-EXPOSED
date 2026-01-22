package zd;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class f3 extends io.reactivex.rxjava3.core.i0 implements sd.d {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٧٦٨a;

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٧٦٩b;

    /* renamed from: c, reason: collision with root package name */
    final pd.d f١٩٧٧٠c;

    /* renamed from: d, reason: collision with root package name */
    final int f١٩٧٧١d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements nd.c {
        private static final long serialVersionUID = -6178010334400373240L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.k0 f١٩٧٧٢a;

        /* renamed from: b, reason: collision with root package name */
        final pd.d f١٩٧٧٣b;

        /* renamed from: c, reason: collision with root package name */
        final qd.a f١٩٧٧٤c;

        /* renamed from: d, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f١٩٧٧٥d;

        /* renamed from: e, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f١٩٧٧٦e;

        /* renamed from: f, reason: collision with root package name */
        final b[] f١٩٧٧٧f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f١٩٧٧٨g;

        /* renamed from: h, reason: collision with root package name */
        Object f١٩٧٧٩h;

        /* renamed from: i, reason: collision with root package name */
        Object f١٩٧٨٠i;

        a(io.reactivex.rxjava3.core.k0 k0Var, int i10, io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, pd.d dVar) {
            this.f١٩٧٧٢a = k0Var;
            this.f١٩٧٧٥d = e0Var;
            this.f١٩٧٧٦e = e0Var2;
            this.f١٩٧٧٣b = dVar;
            this.f١٩٧٧٧f = r3;
            b[] bVarArr = {new b(this, 0, i10), new b(this, 1, i10)};
            this.f١٩٧٧٤c = new qd.a(2);
        }

        void a(be.c cVar, be.c cVar2) {
            this.f١٩٧٧٨g = true;
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
            b[] bVarArr = this.f١٩٧٧٧f;
            b bVar = bVarArr[0];
            be.c cVar = bVar.f١٩٧٨٢b;
            b bVar2 = bVarArr[1];
            be.c cVar2 = bVar2.f١٩٧٨٢b;
            int i10 = 1;
            while (!this.f١٩٧٧٨g) {
                boolean z12 = bVar.f١٩٧٨٤d;
                if (z12 && (th2 = bVar.f١٩٧٨٥e) != null) {
                    a(cVar, cVar2);
                    this.f١٩٧٧٢a.onError(th2);
                    return;
                }
                boolean z13 = bVar2.f١٩٧٨٤d;
                if (z13 && (th = bVar2.f١٩٧٨٥e) != null) {
                    a(cVar, cVar2);
                    this.f١٩٧٧٢a.onError(th);
                    return;
                }
                if (this.f١٩٧٧٩h == null) {
                    this.f١٩٧٧٩h = cVar.poll();
                }
                if (this.f١٩٧٧٩h == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (this.f١٩٧٨٠i == null) {
                    this.f١٩٧٨٠i = cVar2.poll();
                }
                Object obj = this.f١٩٧٨٠i;
                if (obj == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z12 && z13 && z10 && z11) {
                    this.f١٩٧٧٢a.onSuccess(Boolean.TRUE);
                    return;
                }
                if (z12 && z13 && z10 != z11) {
                    a(cVar, cVar2);
                    this.f١٩٧٧٢a.onSuccess(Boolean.FALSE);
                    return;
                }
                if (!z10 && !z11) {
                    try {
                        if (!this.f١٩٧٧٣b.a(this.f١٩٧٧٩h, obj)) {
                            a(cVar, cVar2);
                            this.f١٩٧٧٢a.onSuccess(Boolean.FALSE);
                            return;
                        } else {
                            this.f١٩٧٧٩h = null;
                            this.f١٩٧٨٠i = null;
                        }
                    } catch (Throwable th3) {
                        od.b.b(th3);
                        a(cVar, cVar2);
                        this.f١٩٧٧٢a.onError(th3);
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
            return this.f١٩٧٧٤c.a(i10, cVar);
        }

        void d() {
            b[] bVarArr = this.f١٩٧٧٧f;
            this.f١٩٧٧٥d.subscribe(bVarArr[0]);
            this.f١٩٧٧٦e.subscribe(bVarArr[1]);
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f١٩٧٧٨g) {
                this.f١٩٧٧٨g = true;
                this.f١٩٧٧٤c.dispose();
                if (getAndIncrement() == 0) {
                    b[] bVarArr = this.f١٩٧٧٧f;
                    bVarArr[0].f١٩٧٨٢b.clear();
                    bVarArr[1].f١٩٧٨٢b.clear();
                }
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٧٧٨g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        final a f١٩٧٨١a;

        /* renamed from: b, reason: collision with root package name */
        final be.c f١٩٧٨٢b;

        /* renamed from: c, reason: collision with root package name */
        final int f١٩٧٨٣c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f١٩٧٨٤d;

        /* renamed from: e, reason: collision with root package name */
        Throwable f١٩٧٨٥e;

        b(a aVar, int i10, int i11) {
            this.f١٩٧٨١a = aVar;
            this.f١٩٧٨٣c = i10;
            this.f١٩٧٨٢b = new be.c(i11);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٧٨٤d = true;
            this.f١٩٧٨١a.b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٧٨٥e = th;
            this.f١٩٧٨٤d = true;
            this.f١٩٧٨١a.b();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٧٨٢b.offer(obj);
            this.f١٩٧٨١a.b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f١٩٧٨١a.c(cVar, this.f١٩٧٨٣c);
        }
    }

    public f3(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, pd.d dVar, int i10) {
        this.f١٩٧٦٨a = e0Var;
        this.f١٩٧٦٩b = e0Var2;
        this.f١٩٧٧٠c = dVar;
        this.f١٩٧٧١d = i10;
    }

    @Override // sd.d
    public io.reactivex.rxjava3.core.z b() {
        return ie.a.o(new e3(this.f١٩٧٦٨a, this.f١٩٧٦٩b, this.f١٩٧٧٠c, this.f١٩٧٧١d));
    }

    @Override // io.reactivex.rxjava3.core.i0
    public void o(io.reactivex.rxjava3.core.k0 k0Var) {
        a aVar = new a(k0Var, this.f١٩٧٧١d, this.f١٩٧٦٨a, this.f١٩٧٦٩b, this.f١٩٧٧٠c);
        k0Var.onSubscribe(aVar);
        aVar.d();
    }
}
