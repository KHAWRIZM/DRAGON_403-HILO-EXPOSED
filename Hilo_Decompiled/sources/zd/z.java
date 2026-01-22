package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class z extends zd.a {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٧٨٨a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f٢٠٧٨٩b;

        /* renamed from: c, reason: collision with root package name */
        long f٢٠٧٩٠c;

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٧٨٨a = g0Var;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٧٨٩b.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٧٨٩b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٧٨٨a.onNext(Long.valueOf(this.f٢٠٧٩٠c));
            this.f٢٠٧٨٨a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٧٨٨a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٧٩٠c++;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٧٨٩b, cVar)) {
                this.f٢٠٧٨٩b = cVar;
                this.f٢٠٧٨٨a.onSubscribe(this);
            }
        }
    }

    public z(io.reactivex.rxjava3.core.e0 e0Var) {
        super(e0Var);
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var));
    }
}
