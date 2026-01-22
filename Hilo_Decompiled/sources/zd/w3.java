package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class w3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.q f٢٠٧١٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٧١٦a;

        /* renamed from: b, reason: collision with root package name */
        final pd.q f٢٠٧١٧b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f٢٠٧١٨c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٢٠٧١٩d;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.q qVar) {
            this.f٢٠٧١٦a = g0Var;
            this.f٢٠٧١٧b = qVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٧١٨c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٧١٨c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f٢٠٧١٩d) {
                this.f٢٠٧١٩d = true;
                this.f٢٠٧١٦a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (!this.f٢٠٧١٩d) {
                this.f٢٠٧١٩d = true;
                this.f٢٠٧١٦a.onError(th);
            } else {
                ie.a.s(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (!this.f٢٠٧١٩d) {
                this.f٢٠٧١٦a.onNext(obj);
                try {
                    if (this.f٢٠٧١٧b.test(obj)) {
                        this.f٢٠٧١٩d = true;
                        this.f٢٠٧١٨c.dispose();
                        this.f٢٠٧١٦a.onComplete();
                    }
                } catch (Throwable th) {
                    od.b.b(th);
                    this.f٢٠٧١٨c.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٧١٨c, cVar)) {
                this.f٢٠٧١٨c = cVar;
                this.f٢٠٧١٦a.onSubscribe(this);
            }
        }
    }

    public w3(io.reactivex.rxjava3.core.e0 e0Var, pd.q qVar) {
        super(e0Var);
        this.f٢٠٧١٥b = qVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٧١٥b));
    }
}
