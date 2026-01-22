package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class q0 extends io.reactivex.rxjava3.core.j implements sd.d {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٣٣٦a;

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٣٣٧b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.l f٢٠٣٣٨a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٣٣٩b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f٢٠٣٤٠c;

        /* renamed from: d, reason: collision with root package name */
        long f٢٠٣٤١d;

        /* renamed from: e, reason: collision with root package name */
        boolean f٢٠٣٤٢e;

        a(io.reactivex.rxjava3.core.l lVar, long j10) {
            this.f٢٠٣٣٨a = lVar;
            this.f٢٠٣٣٩b = j10;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٣٤٠c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٣٤٠c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f٢٠٣٤٢e) {
                this.f٢٠٣٤٢e = true;
                this.f٢٠٣٣٨a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٣٤٢e) {
                ie.a.s(th);
            } else {
                this.f٢٠٣٤٢e = true;
                this.f٢٠٣٣٨a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٣٤٢e) {
                return;
            }
            long j10 = this.f٢٠٣٤١d;
            if (j10 == this.f٢٠٣٣٩b) {
                this.f٢٠٣٤٢e = true;
                this.f٢٠٣٤٠c.dispose();
                this.f٢٠٣٣٨a.onSuccess(obj);
                return;
            }
            this.f٢٠٣٤١d = j10 + 1;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٣٤٠c, cVar)) {
                this.f٢٠٣٤٠c = cVar;
                this.f٢٠٣٣٨a.onSubscribe(this);
            }
        }
    }

    public q0(io.reactivex.rxjava3.core.e0 e0Var, long j10) {
        this.f٢٠٣٣٦a = e0Var;
        this.f٢٠٣٣٧b = j10;
    }

    @Override // sd.d
    public io.reactivex.rxjava3.core.z b() {
        return ie.a.o(new p0(this.f٢٠٣٣٦a, this.f٢٠٣٣٧b, null, false));
    }

    @Override // io.reactivex.rxjava3.core.j
    public void e(io.reactivex.rxjava3.core.l lVar) {
        this.f٢٠٣٣٦a.subscribe(new a(lVar, this.f٢٠٣٣٧b));
    }
}
