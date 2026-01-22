package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class t3 extends zd.a {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٥١٨a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f٢٠٥١٩b;

        /* renamed from: c, reason: collision with root package name */
        Object f٢٠٥٢٠c;

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٥١٨a = g0Var;
        }

        void a() {
            Object obj = this.f٢٠٥٢٠c;
            if (obj != null) {
                this.f٢٠٥٢٠c = null;
                this.f٢٠٥١٨a.onNext(obj);
            }
            this.f٢٠٥١٨a.onComplete();
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٥٢٠c = null;
            this.f٢٠٥١٩b.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٥١٩b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٥٢٠c = null;
            this.f٢٠٥١٨a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٥٢٠c = obj;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٥١٩b, cVar)) {
                this.f٢٠٥١٩b = cVar;
                this.f٢٠٥١٨a.onSubscribe(this);
            }
        }
    }

    public t3(io.reactivex.rxjava3.core.e0 e0Var) {
        super(e0Var);
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var));
    }
}
