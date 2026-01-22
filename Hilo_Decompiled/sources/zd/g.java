package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class g extends io.reactivex.rxjava3.core.i0 implements sd.d {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٧٩١a;

    /* renamed from: b, reason: collision with root package name */
    final pd.q f١٩٧٩٢b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.k0 f١٩٧٩٣a;

        /* renamed from: b, reason: collision with root package name */
        final pd.q f١٩٧٩٤b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٧٩٥c;

        /* renamed from: d, reason: collision with root package name */
        boolean f١٩٧٩٦d;

        a(io.reactivex.rxjava3.core.k0 k0Var, pd.q qVar) {
            this.f١٩٧٩٣a = k0Var;
            this.f١٩٧٩٤b = qVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٧٩٥c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٧٩٥c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٧٩٦d) {
                return;
            }
            this.f١٩٧٩٦d = true;
            this.f١٩٧٩٣a.onSuccess(Boolean.TRUE);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٧٩٦d) {
                ie.a.s(th);
            } else {
                this.f١٩٧٩٦d = true;
                this.f١٩٧٩٣a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٧٩٦d) {
                return;
            }
            try {
                if (!this.f١٩٧٩٤b.test(obj)) {
                    this.f١٩٧٩٦d = true;
                    this.f١٩٧٩٥c.dispose();
                    this.f١٩٧٩٣a.onSuccess(Boolean.FALSE);
                }
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٧٩٥c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٧٩٥c, cVar)) {
                this.f١٩٧٩٥c = cVar;
                this.f١٩٧٩٣a.onSubscribe(this);
            }
        }
    }

    public g(io.reactivex.rxjava3.core.e0 e0Var, pd.q qVar) {
        this.f١٩٧٩١a = e0Var;
        this.f١٩٧٩٢b = qVar;
    }

    @Override // sd.d
    public io.reactivex.rxjava3.core.z b() {
        return ie.a.o(new f(this.f١٩٧٩١a, this.f١٩٧٩٢b));
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(io.reactivex.rxjava3.core.k0 k0Var) {
        this.f١٩٧٩١a.subscribe(new a(k0Var, this.f١٩٧٩٢b));
    }
}
