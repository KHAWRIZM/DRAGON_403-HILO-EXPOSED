package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class j2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f١٩٩١٧b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٩١٨a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f١٩٩١٩b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٩٢٠c;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar) {
            this.f١٩٩١٨a = g0Var;
            this.f١٩٩١٩b = oVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٩٢٠c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٩٢٠c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٩١٨a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            try {
                Object apply = this.f١٩٩١٩b.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f١٩٩١٨a.onError(nullPointerException);
                } else {
                    this.f١٩٩١٨a.onNext(apply);
                    this.f١٩٩١٨a.onComplete();
                }
            } catch (Throwable th2) {
                od.b.b(th2);
                this.f١٩٩١٨a.onError(new od.a(th, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٩١٨a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٩٢٠c, cVar)) {
                this.f١٩٩٢٠c = cVar;
                this.f١٩٩١٨a.onSubscribe(this);
            }
        }
    }

    public j2(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar) {
        super(e0Var);
        this.f١٩٩١٧b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٩١٧b));
    }
}
