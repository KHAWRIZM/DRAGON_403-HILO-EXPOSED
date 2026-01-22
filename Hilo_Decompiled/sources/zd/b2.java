package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b2 extends zd.a {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٥٧٥a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f١٩٥٧٦b;

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f١٩٥٧٥a = g0Var;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٥٧٦b.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٥٧٦b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٥٧٥a.onNext(io.reactivex.rxjava3.core.o.a());
            this.f١٩٥٧٥a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٥٧٥a.onNext(io.reactivex.rxjava3.core.o.b(th));
            this.f١٩٥٧٥a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٥٧٥a.onNext(io.reactivex.rxjava3.core.o.c(obj));
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٥٧٦b, cVar)) {
                this.f١٩٥٧٦b = cVar;
                this.f١٩٥٧٥a.onSubscribe(this);
            }
        }
    }

    public b2(io.reactivex.rxjava3.core.e0 e0Var) {
        super(e0Var);
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var));
    }
}
