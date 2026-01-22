package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class q1 extends io.reactivex.rxjava3.core.b implements sd.d {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٣٤٣a;

    public q1(io.reactivex.rxjava3.core.e0 e0Var) {
        this.f٢٠٣٤٣a = e0Var;
    }

    @Override // sd.d
    public io.reactivex.rxjava3.core.z b() {
        return ie.a.o(new p1(this.f٢٠٣٤٣a));
    }

    @Override // io.reactivex.rxjava3.core.b
    public void e(io.reactivex.rxjava3.core.d dVar) {
        this.f٢٠٣٤٣a.subscribe(new a(dVar));
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.d f٢٠٣٤٤a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f٢٠٣٤٥b;

        a(io.reactivex.rxjava3.core.d dVar) {
            this.f٢٠٣٤٤a = dVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٣٤٥b.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٣٤٥b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٣٤٤a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٣٤٤a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f٢٠٣٤٥b = cVar;
            this.f٢٠٣٤٤a.onSubscribe(this);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
        }
    }
}
