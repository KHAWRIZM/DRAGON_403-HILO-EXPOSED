package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class r3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٤٣٤b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٤٣٥a;

        /* renamed from: b, reason: collision with root package name */
        boolean f٢٠٤٣٦b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f٢٠٤٣٧c;

        /* renamed from: d, reason: collision with root package name */
        long f٢٠٤٣٨d;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10) {
            this.f٢٠٤٣٥a = g0Var;
            this.f٢٠٤٣٨d = j10;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٤٣٧c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٤٣٧c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f٢٠٤٣٦b) {
                this.f٢٠٤٣٦b = true;
                this.f٢٠٤٣٧c.dispose();
                this.f٢٠٤٣٥a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٤٣٦b) {
                ie.a.s(th);
                return;
            }
            this.f٢٠٤٣٦b = true;
            this.f٢٠٤٣٧c.dispose();
            this.f٢٠٤٣٥a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            boolean z10;
            if (!this.f٢٠٤٣٦b) {
                long j10 = this.f٢٠٤٣٨d;
                long j11 = j10 - 1;
                this.f٢٠٤٣٨d = j11;
                if (j10 > 0) {
                    if (j11 == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f٢٠٤٣٥a.onNext(obj);
                    if (z10) {
                        onComplete();
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٤٣٧c, cVar)) {
                this.f٢٠٤٣٧c = cVar;
                if (this.f٢٠٤٣٨d == 0) {
                    this.f٢٠٤٣٦b = true;
                    cVar.dispose();
                    qd.d.d(this.f٢٠٤٣٥a);
                    return;
                }
                this.f٢٠٤٣٥a.onSubscribe(this);
            }
        }
    }

    public r3(io.reactivex.rxjava3.core.e0 e0Var, long j10) {
        super(e0Var);
        this.f٢٠٤٣٤b = j10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٤٣٤b));
    }
}
