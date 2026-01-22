package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class p3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٣٠٨b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٣٠٩a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f٢٠٣١٠b;

        /* renamed from: d, reason: collision with root package name */
        boolean f٢٠٣١٢d = true;

        /* renamed from: c, reason: collision with root package name */
        final qd.f f٢٠٣١١c = new qd.f();

        a(io.reactivex.rxjava3.core.g0 g0Var, io.reactivex.rxjava3.core.e0 e0Var) {
            this.f٢٠٣٠٩a = g0Var;
            this.f٢٠٣١٠b = e0Var;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f٢٠٣١٢d) {
                this.f٢٠٣١٢d = false;
                this.f٢٠٣١٠b.subscribe(this);
            } else {
                this.f٢٠٣٠٩a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٣٠٩a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٣١٢d) {
                this.f٢٠٣١٢d = false;
            }
            this.f٢٠٣٠٩a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f٢٠٣١١c.b(cVar);
        }
    }

    public p3(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2) {
        super(e0Var);
        this.f٢٠٣٠٨b = e0Var2;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var, this.f٢٠٣٠٨b);
        g0Var.onSubscribe(aVar.f٢٠٣١١c);
        this.f١٩٥٣٢a.subscribe(aVar);
    }
}
