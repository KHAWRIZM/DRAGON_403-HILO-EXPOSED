package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class p1 extends zd.a {
    public p1(io.reactivex.rxjava3.core.e0 e0Var) {
        super(e0Var);
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var));
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٢٩٩a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f٢٠٣٠٠b;

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٢٩٩a = g0Var;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٣٠٠b.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٣٠٠b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٢٩٩a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٢٩٩a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f٢٠٣٠٠b = cVar;
            this.f٢٠٢٩٩a.onSubscribe(this);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
        }
    }
}
