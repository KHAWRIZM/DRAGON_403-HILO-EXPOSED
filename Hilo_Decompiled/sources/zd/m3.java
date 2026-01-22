package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class m3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٠٨٨b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    final class a implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        final qd.a f٢٠٠٨٩a;

        /* renamed from: b, reason: collision with root package name */
        final b f٢٠٠٩٠b;

        /* renamed from: c, reason: collision with root package name */
        final he.e f٢٠٠٩١c;

        /* renamed from: d, reason: collision with root package name */
        nd.c f٢٠٠٩٢d;

        a(qd.a aVar, b bVar, he.e eVar) {
            this.f٢٠٠٨٩a = aVar;
            this.f٢٠٠٩٠b = bVar;
            this.f٢٠٠٩١c = eVar;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٠٩٠b.f٢٠٠٩٧d = true;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٠٨٩a.dispose();
            this.f٢٠٠٩١c.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٠٩٢d.dispose();
            this.f٢٠٠٩٠b.f٢٠٠٩٧d = true;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٠٩٢d, cVar)) {
                this.f٢٠٠٩٢d = cVar;
                this.f٢٠٠٨٩a.a(1, cVar);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٠٩٤a;

        /* renamed from: b, reason: collision with root package name */
        final qd.a f٢٠٠٩٥b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f٢٠٠٩٦c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f٢٠٠٩٧d;

        /* renamed from: e, reason: collision with root package name */
        boolean f٢٠٠٩٨e;

        b(io.reactivex.rxjava3.core.g0 g0Var, qd.a aVar) {
            this.f٢٠٠٩٤a = g0Var;
            this.f٢٠٠٩٥b = aVar;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٠٩٥b.dispose();
            this.f٢٠٠٩٤a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٠٩٥b.dispose();
            this.f٢٠٠٩٤a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٠٩٨e) {
                this.f٢٠٠٩٤a.onNext(obj);
            } else if (this.f٢٠٠٩٧d) {
                this.f٢٠٠٩٨e = true;
                this.f٢٠٠٩٤a.onNext(obj);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٠٩٦c, cVar)) {
                this.f٢٠٠٩٦c = cVar;
                this.f٢٠٠٩٥b.a(0, cVar);
            }
        }
    }

    public m3(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2) {
        super(e0Var);
        this.f٢٠٠٨٨b = e0Var2;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        he.e eVar = new he.e(g0Var);
        qd.a aVar = new qd.a(2);
        eVar.onSubscribe(aVar);
        b bVar = new b(eVar, aVar);
        this.f٢٠٠٨٨b.subscribe(new a(aVar, bVar, eVar));
        this.f١٩٥٣٢a.subscribe(bVar);
    }
}
