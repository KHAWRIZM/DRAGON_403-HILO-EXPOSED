package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class l1 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final pd.r f٢٠٠٠٣a;

    /* renamed from: b, reason: collision with root package name */
    final pd.c f٢٠٠٠٤b;

    /* renamed from: c, reason: collision with root package name */
    final pd.g f٢٠٠٠٥c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٠٠٦a;

        /* renamed from: b, reason: collision with root package name */
        final pd.c f٢٠٠٠٧b;

        /* renamed from: c, reason: collision with root package name */
        final pd.g f٢٠٠٠٨c;

        /* renamed from: d, reason: collision with root package name */
        Object f٢٠٠٠٩d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f٢٠٠١٠e;

        /* renamed from: f, reason: collision with root package name */
        boolean f٢٠٠١١f;

        /* renamed from: g, reason: collision with root package name */
        boolean f٢٠٠١٢g;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.c cVar, pd.g gVar, Object obj) {
            this.f٢٠٠٠٦a = g0Var;
            this.f٢٠٠٠٧b = cVar;
            this.f٢٠٠٠٨c = gVar;
            this.f٢٠٠٠٩d = obj;
        }

        private void c(Object obj) {
            try {
                this.f٢٠٠٠٨c.accept(obj);
            } catch (Throwable th) {
                od.b.b(th);
                ie.a.s(th);
            }
        }

        public void d() {
            Object obj = this.f٢٠٠٠٩d;
            if (this.f٢٠٠١٠e) {
                this.f٢٠٠٠٩d = null;
                c(obj);
                return;
            }
            pd.c cVar = this.f٢٠٠٠٧b;
            while (!this.f٢٠٠١٠e) {
                this.f٢٠٠١٢g = false;
                try {
                    obj = cVar.apply(obj, this);
                    if (this.f٢٠٠١١f) {
                        this.f٢٠٠١٠e = true;
                        this.f٢٠٠٠٩d = null;
                        c(obj);
                        return;
                    }
                } catch (Throwable th) {
                    od.b.b(th);
                    this.f٢٠٠٠٩d = null;
                    this.f٢٠٠١٠e = true;
                    onError(th);
                    c(obj);
                    return;
                }
            }
            this.f٢٠٠٠٩d = null;
            c(obj);
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٠١٠e = true;
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٠١٠e;
        }

        @Override // io.reactivex.rxjava3.core.g
        public void onError(Throwable th) {
            if (this.f٢٠٠١١f) {
                ie.a.s(th);
                return;
            }
            if (th == null) {
                th = fe.j.b("onError called with a null Throwable.");
            }
            this.f٢٠٠١١f = true;
            this.f٢٠٠٠٦a.onError(th);
        }
    }

    public l1(pd.r rVar, pd.c cVar, pd.g gVar) {
        this.f٢٠٠٠٣a = rVar;
        this.f٢٠٠٠٤b = cVar;
        this.f٢٠٠٠٥c = gVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        try {
            a aVar = new a(g0Var, this.f٢٠٠٠٤b, this.f٢٠٠٠٥c, this.f٢٠٠٠٣a.get());
            g0Var.onSubscribe(aVar);
            aVar.d();
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.f(th, g0Var);
        }
    }
}
