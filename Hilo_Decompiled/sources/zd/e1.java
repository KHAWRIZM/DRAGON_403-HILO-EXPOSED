package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e1 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.f f١٩٧٠٨a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends sd.a implements io.reactivex.rxjava3.core.d {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٧٠٩a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f١٩٧١٠b;

        public a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f١٩٧٠٩a = g0Var;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٧١٠b.dispose();
            this.f١٩٧١٠b = qd.c.DISPOSED;
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٧١٠b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٧١٠b = qd.c.DISPOSED;
            this.f١٩٧٠٩a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.d
        public void onError(Throwable th) {
            this.f١٩٧١٠b = qd.c.DISPOSED;
            this.f١٩٧٠٩a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.d
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٧١٠b, cVar)) {
                this.f١٩٧١٠b = cVar;
                this.f١٩٧٠٩a.onSubscribe(this);
            }
        }
    }

    public e1(io.reactivex.rxjava3.core.f fVar) {
        this.f١٩٧٠٨a = fVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٧٠٨a.a(new a(g0Var));
    }
}
