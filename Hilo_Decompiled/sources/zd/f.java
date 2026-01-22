package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class f extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.q f١٩٧٤٤b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٧٤٥a;

        /* renamed from: b, reason: collision with root package name */
        final pd.q f١٩٧٤٦b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٧٤٧c;

        /* renamed from: d, reason: collision with root package name */
        boolean f١٩٧٤٨d;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.q qVar) {
            this.f١٩٧٤٥a = g0Var;
            this.f١٩٧٤٦b = qVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٧٤٧c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٧٤٧c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٧٤٨d) {
                return;
            }
            this.f١٩٧٤٨d = true;
            this.f١٩٧٤٥a.onNext(Boolean.TRUE);
            this.f١٩٧٤٥a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٧٤٨d) {
                ie.a.s(th);
            } else {
                this.f١٩٧٤٨d = true;
                this.f١٩٧٤٥a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٧٤٨d) {
                return;
            }
            try {
                if (!this.f١٩٧٤٦b.test(obj)) {
                    this.f١٩٧٤٨d = true;
                    this.f١٩٧٤٧c.dispose();
                    this.f١٩٧٤٥a.onNext(Boolean.FALSE);
                    this.f١٩٧٤٥a.onComplete();
                }
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٧٤٧c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٧٤٧c, cVar)) {
                this.f١٩٧٤٧c = cVar;
                this.f١٩٧٤٥a.onSubscribe(this);
            }
        }
    }

    public f(io.reactivex.rxjava3.core.e0 e0Var, pd.q qVar) {
        super(e0Var);
        this.f١٩٧٤٤b = qVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٧٤٤b));
    }
}
