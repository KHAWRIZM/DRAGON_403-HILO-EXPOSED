package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class x3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.q f٢٠٧٤٨b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٧٤٩a;

        /* renamed from: b, reason: collision with root package name */
        final pd.q f٢٠٧٥٠b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f٢٠٧٥١c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٢٠٧٥٢d;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.q qVar) {
            this.f٢٠٧٤٩a = g0Var;
            this.f٢٠٧٥٠b = qVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٧٥١c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٧٥١c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f٢٠٧٥٢d) {
                return;
            }
            this.f٢٠٧٥٢d = true;
            this.f٢٠٧٤٩a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٧٥٢d) {
                ie.a.s(th);
            } else {
                this.f٢٠٧٥٢d = true;
                this.f٢٠٧٤٩a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٧٥٢d) {
                return;
            }
            try {
                if (!this.f٢٠٧٥٠b.test(obj)) {
                    this.f٢٠٧٥٢d = true;
                    this.f٢٠٧٥١c.dispose();
                    this.f٢٠٧٤٩a.onComplete();
                    return;
                }
                this.f٢٠٧٤٩a.onNext(obj);
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠٧٥١c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٧٥١c, cVar)) {
                this.f٢٠٧٥١c = cVar;
                this.f٢٠٧٤٩a.onSubscribe(this);
            }
        }
    }

    public x3(io.reactivex.rxjava3.core.e0 e0Var, pd.q qVar) {
        super(e0Var);
        this.f٢٠٧٤٨b = qVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٧٤٨b));
    }
}
