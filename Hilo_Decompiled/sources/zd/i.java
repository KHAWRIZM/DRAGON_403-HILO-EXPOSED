package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class i extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.q f١٩٨٦٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٦٦a;

        /* renamed from: b, reason: collision with root package name */
        final pd.q f١٩٨٦٧b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٨٦٨c;

        /* renamed from: d, reason: collision with root package name */
        boolean f١٩٨٦٩d;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.q qVar) {
            this.f١٩٨٦٦a = g0Var;
            this.f١٩٨٦٧b = qVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٨٦٨c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٨٦٨c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f١٩٨٦٩d) {
                this.f١٩٨٦٩d = true;
                this.f١٩٨٦٦a.onNext(Boolean.FALSE);
                this.f١٩٨٦٦a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٨٦٩d) {
                ie.a.s(th);
            } else {
                this.f١٩٨٦٩d = true;
                this.f١٩٨٦٦a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٨٦٩d) {
                return;
            }
            try {
                if (this.f١٩٨٦٧b.test(obj)) {
                    this.f١٩٨٦٩d = true;
                    this.f١٩٨٦٨c.dispose();
                    this.f١٩٨٦٦a.onNext(Boolean.TRUE);
                    this.f١٩٨٦٦a.onComplete();
                }
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٨٦٨c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٨٦٨c, cVar)) {
                this.f١٩٨٦٨c = cVar;
                this.f١٩٨٦٦a.onSubscribe(this);
            }
        }
    }

    public i(io.reactivex.rxjava3.core.e0 e0Var, pd.q qVar) {
        super(e0Var);
        this.f١٩٨٦٥b = qVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٨٦٥b));
    }
}
