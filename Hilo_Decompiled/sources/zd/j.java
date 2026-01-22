package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class j extends io.reactivex.rxjava3.core.i0 implements sd.d {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٩٠٦a;

    /* renamed from: b, reason: collision with root package name */
    final pd.q f١٩٩٠٧b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.k0 f١٩٩٠٨a;

        /* renamed from: b, reason: collision with root package name */
        final pd.q f١٩٩٠٩b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٩١٠c;

        /* renamed from: d, reason: collision with root package name */
        boolean f١٩٩١١d;

        a(io.reactivex.rxjava3.core.k0 k0Var, pd.q qVar) {
            this.f١٩٩٠٨a = k0Var;
            this.f١٩٩٠٩b = qVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٩١٠c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٩١٠c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f١٩٩١١d) {
                this.f١٩٩١١d = true;
                this.f١٩٩٠٨a.onSuccess(Boolean.FALSE);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٩١١d) {
                ie.a.s(th);
            } else {
                this.f١٩٩١١d = true;
                this.f١٩٩٠٨a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٩١١d) {
                return;
            }
            try {
                if (this.f١٩٩٠٩b.test(obj)) {
                    this.f١٩٩١١d = true;
                    this.f١٩٩١٠c.dispose();
                    this.f١٩٩٠٨a.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٩١٠c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٩١٠c, cVar)) {
                this.f١٩٩١٠c = cVar;
                this.f١٩٩٠٨a.onSubscribe(this);
            }
        }
    }

    public j(io.reactivex.rxjava3.core.e0 e0Var, pd.q qVar) {
        this.f١٩٩٠٦a = e0Var;
        this.f١٩٩٠٧b = qVar;
    }

    @Override // sd.d
    public io.reactivex.rxjava3.core.z b() {
        return ie.a.o(new i(this.f١٩٩٠٦a, this.f١٩٩٠٧b));
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(io.reactivex.rxjava3.core.k0 k0Var) {
        this.f١٩٩٠٦a.subscribe(new a(k0Var, this.f١٩٩٠٧b));
    }
}
