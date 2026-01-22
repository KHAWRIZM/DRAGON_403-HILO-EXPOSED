package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class o1 extends zd.a {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٢٤٢a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f٢٠٢٤٣b;

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٢٤٢a = g0Var;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٢٤٣b.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٢٤٣b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٢٤٢a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٢٤٢a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٢٤٢a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٢٤٣b, cVar)) {
                this.f٢٠٢٤٣b = cVar;
                this.f٢٠٢٤٢a.onSubscribe(this);
            }
        }
    }

    public o1(io.reactivex.rxjava3.core.e0 e0Var) {
        super(e0Var);
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var));
    }
}
