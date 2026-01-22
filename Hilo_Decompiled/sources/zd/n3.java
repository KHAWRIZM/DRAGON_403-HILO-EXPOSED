package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class n3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.q f٢٠١٩١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠١٩٢a;

        /* renamed from: b, reason: collision with root package name */
        final pd.q f٢٠١٩٣b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f٢٠١٩٤c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٢٠١٩٥d;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.q qVar) {
            this.f٢٠١٩٢a = g0Var;
            this.f٢٠١٩٣b = qVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠١٩٤c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠١٩٤c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠١٩٢a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠١٩٢a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠١٩٥d) {
                this.f٢٠١٩٢a.onNext(obj);
                return;
            }
            try {
                if (!this.f٢٠١٩٣b.test(obj)) {
                    this.f٢٠١٩٥d = true;
                    this.f٢٠١٩٢a.onNext(obj);
                }
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠١٩٤c.dispose();
                this.f٢٠١٩٢a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠١٩٤c, cVar)) {
                this.f٢٠١٩٤c = cVar;
                this.f٢٠١٩٢a.onSubscribe(this);
            }
        }
    }

    public n3(io.reactivex.rxjava3.core.e0 e0Var, pd.q qVar) {
        super(e0Var);
        this.f٢٠١٩١b = qVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠١٩١b));
    }
}
