package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class i0 extends zd.a {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        io.reactivex.rxjava3.core.g0 f١٩٨٧٠a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f١٩٨٧١b;

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f١٩٨٧٠a = g0Var;
        }

        @Override // nd.c
        public void dispose() {
            nd.c cVar = this.f١٩٨٧١b;
            this.f١٩٨٧١b = fe.g.INSTANCE;
            this.f١٩٨٧٠a = fe.g.a();
            cVar.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٨٧١b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            io.reactivex.rxjava3.core.g0 g0Var = this.f١٩٨٧٠a;
            this.f١٩٨٧١b = fe.g.INSTANCE;
            this.f١٩٨٧٠a = fe.g.a();
            g0Var.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            io.reactivex.rxjava3.core.g0 g0Var = this.f١٩٨٧٠a;
            this.f١٩٨٧١b = fe.g.INSTANCE;
            this.f١٩٨٧٠a = fe.g.a();
            g0Var.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٨٧٠a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٨٧١b, cVar)) {
                this.f١٩٨٧١b = cVar;
                this.f١٩٨٧٠a.onSubscribe(this);
            }
        }
    }

    public i0(io.reactivex.rxjava3.core.e0 e0Var) {
        super(e0Var);
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var));
    }
}
