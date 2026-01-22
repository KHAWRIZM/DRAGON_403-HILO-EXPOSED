package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class w1 extends io.reactivex.rxjava3.core.j {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٧٠٥a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.l f٢٠٧٠٦a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f٢٠٧٠٧b;

        /* renamed from: c, reason: collision with root package name */
        Object f٢٠٧٠٨c;

        a(io.reactivex.rxjava3.core.l lVar) {
            this.f٢٠٧٠٦a = lVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٧٠٧b.dispose();
            this.f٢٠٧٠٧b = qd.c.DISPOSED;
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (this.f٢٠٧٠٧b == qd.c.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٧٠٧b = qd.c.DISPOSED;
            Object obj = this.f٢٠٧٠٨c;
            if (obj != null) {
                this.f٢٠٧٠٨c = null;
                this.f٢٠٧٠٦a.onSuccess(obj);
            } else {
                this.f٢٠٧٠٦a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٧٠٧b = qd.c.DISPOSED;
            this.f٢٠٧٠٨c = null;
            this.f٢٠٧٠٦a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٧٠٨c = obj;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٧٠٧b, cVar)) {
                this.f٢٠٧٠٧b = cVar;
                this.f٢٠٧٠٦a.onSubscribe(this);
            }
        }
    }

    public w1(io.reactivex.rxjava3.core.e0 e0Var) {
        this.f٢٠٧٠٥a = e0Var;
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void e(io.reactivex.rxjava3.core.l lVar) {
        this.f٢٠٧٠٥a.subscribe(new a(lVar));
    }
}
