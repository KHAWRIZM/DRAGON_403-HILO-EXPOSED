package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class n0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.g f٢٠١٤٨b;

    /* renamed from: c, reason: collision with root package name */
    final pd.g f٢٠١٤٩c;

    /* renamed from: d, reason: collision with root package name */
    final pd.a f٢٠١٥٠d;

    /* renamed from: e, reason: collision with root package name */
    final pd.a f٢٠١٥١e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠١٥٢a;

        /* renamed from: b, reason: collision with root package name */
        final pd.g f٢٠١٥٣b;

        /* renamed from: c, reason: collision with root package name */
        final pd.g f٢٠١٥٤c;

        /* renamed from: d, reason: collision with root package name */
        final pd.a f٢٠١٥٥d;

        /* renamed from: e, reason: collision with root package name */
        final pd.a f٢٠١٥٦e;

        /* renamed from: f, reason: collision with root package name */
        nd.c f٢٠١٥٧f;

        /* renamed from: g, reason: collision with root package name */
        boolean f٢٠١٥٨g;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.g gVar, pd.g gVar2, pd.a aVar, pd.a aVar2) {
            this.f٢٠١٥٢a = g0Var;
            this.f٢٠١٥٣b = gVar;
            this.f٢٠١٥٤c = gVar2;
            this.f٢٠١٥٥d = aVar;
            this.f٢٠١٥٦e = aVar2;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠١٥٧f.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠١٥٧f.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f٢٠١٥٨g) {
                return;
            }
            try {
                this.f٢٠١٥٥d.run();
                this.f٢٠١٥٨g = true;
                this.f٢٠١٥٢a.onComplete();
                try {
                    this.f٢٠١٥٦e.run();
                } catch (Throwable th) {
                    od.b.b(th);
                    ie.a.s(th);
                }
            } catch (Throwable th2) {
                od.b.b(th2);
                onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠١٥٨g) {
                ie.a.s(th);
                return;
            }
            this.f٢٠١٥٨g = true;
            try {
                this.f٢٠١٥٤c.accept(th);
            } catch (Throwable th2) {
                od.b.b(th2);
                th = new od.a(th, th2);
            }
            this.f٢٠١٥٢a.onError(th);
            try {
                this.f٢٠١٥٦e.run();
            } catch (Throwable th3) {
                od.b.b(th3);
                ie.a.s(th3);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠١٥٨g) {
                return;
            }
            try {
                this.f٢٠١٥٣b.accept(obj);
                this.f٢٠١٥٢a.onNext(obj);
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠١٥٧f.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠١٥٧f, cVar)) {
                this.f٢٠١٥٧f = cVar;
                this.f٢٠١٥٢a.onSubscribe(this);
            }
        }
    }

    public n0(io.reactivex.rxjava3.core.e0 e0Var, pd.g gVar, pd.g gVar2, pd.a aVar, pd.a aVar2) {
        super(e0Var);
        this.f٢٠١٤٨b = gVar;
        this.f٢٠١٤٩c = gVar2;
        this.f٢٠١٥٠d = aVar;
        this.f٢٠١٥١e = aVar2;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠١٤٨b, this.f٢٠١٤٩c, this.f٢٠١٥٠d, this.f٢٠١٥١e));
    }
}
