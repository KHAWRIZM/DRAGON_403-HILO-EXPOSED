package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class h2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.q f١٩٨٤٧b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٤٨a;

        /* renamed from: b, reason: collision with root package name */
        final pd.q f١٩٨٤٩b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٨٥٠c;

        public a(io.reactivex.rxjava3.core.g0 g0Var, pd.q qVar) {
            this.f١٩٨٤٨a = g0Var;
            this.f١٩٨٤٩b = qVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٨٥٠c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٨٥٠c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٨٤٨a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            try {
                if (this.f١٩٨٤٩b.test(th)) {
                    this.f١٩٨٤٨a.onComplete();
                } else {
                    this.f١٩٨٤٨a.onError(th);
                }
            } catch (Throwable th2) {
                od.b.b(th2);
                this.f١٩٨٤٨a.onError(new od.a(th, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٨٤٨a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٨٥٠c, cVar)) {
                this.f١٩٨٥٠c = cVar;
                this.f١٩٨٤٨a.onSubscribe(this);
            }
        }
    }

    public h2(io.reactivex.rxjava3.core.e0 e0Var, pd.q qVar) {
        super(e0Var);
        this.f١٩٨٤٧b = qVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٨٤٧b));
    }
}
