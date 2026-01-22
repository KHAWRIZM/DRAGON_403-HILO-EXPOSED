package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class j3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f١٩٩٢١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٩٢٢a;

        /* renamed from: b, reason: collision with root package name */
        long f١٩٩٢٣b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٩٢٤c;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10) {
            this.f١٩٩٢٢a = g0Var;
            this.f١٩٩٢٣b = j10;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٩٢٤c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٩٢٤c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٩٢٢a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٩٢٢a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            long j10 = this.f١٩٩٢٣b;
            if (j10 != 0) {
                this.f١٩٩٢٣b = j10 - 1;
            } else {
                this.f١٩٩٢٢a.onNext(obj);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٩٢٤c, cVar)) {
                this.f١٩٩٢٤c = cVar;
                this.f١٩٩٢٢a.onSubscribe(this);
            }
        }
    }

    public j3(io.reactivex.rxjava3.core.e0 e0Var, long j10) {
        super(e0Var);
        this.f١٩٩٢١b = j10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٩٢١b));
    }
}
