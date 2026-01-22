package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a0 extends io.reactivex.rxjava3.core.i0 implements sd.d {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٥٣٣a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.k0 f١٩٥٣٤a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f١٩٥٣٥b;

        /* renamed from: c, reason: collision with root package name */
        long f١٩٥٣٦c;

        a(io.reactivex.rxjava3.core.k0 k0Var) {
            this.f١٩٥٣٤a = k0Var;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٥٣٥b.dispose();
            this.f١٩٥٣٥b = qd.c.DISPOSED;
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٥٣٥b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٥٣٥b = qd.c.DISPOSED;
            this.f١٩٥٣٤a.onSuccess(Long.valueOf(this.f١٩٥٣٦c));
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٥٣٥b = qd.c.DISPOSED;
            this.f١٩٥٣٤a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٥٣٦c++;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٥٣٥b, cVar)) {
                this.f١٩٥٣٥b = cVar;
                this.f١٩٥٣٤a.onSubscribe(this);
            }
        }
    }

    public a0(io.reactivex.rxjava3.core.e0 e0Var) {
        this.f١٩٥٣٣a = e0Var;
    }

    @Override // sd.d
    public io.reactivex.rxjava3.core.z b() {
        return ie.a.o(new z(this.f١٩٥٣٣a));
    }

    @Override // io.reactivex.rxjava3.core.i0
    public void o(io.reactivex.rxjava3.core.k0 k0Var) {
        this.f١٩٥٣٣a.subscribe(new a(k0Var));
    }
}
