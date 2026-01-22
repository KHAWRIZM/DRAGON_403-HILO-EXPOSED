package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class i2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f١٩٨٧٣b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٧٤a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f١٩٨٧٥b;

        /* renamed from: c, reason: collision with root package name */
        final qd.f f١٩٨٧٦c = new qd.f();

        /* renamed from: d, reason: collision with root package name */
        boolean f١٩٨٧٧d;

        /* renamed from: e, reason: collision with root package name */
        boolean f١٩٨٧٨e;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar) {
            this.f١٩٨٧٤a = g0Var;
            this.f١٩٨٧٥b = oVar;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٨٧٨e) {
                return;
            }
            this.f١٩٨٧٨e = true;
            this.f١٩٨٧٧d = true;
            this.f١٩٨٧٤a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٨٧٧d) {
                if (this.f١٩٨٧٨e) {
                    ie.a.s(th);
                    return;
                } else {
                    this.f١٩٨٧٤a.onError(th);
                    return;
                }
            }
            this.f١٩٨٧٧d = true;
            try {
                io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) this.f١٩٨٧٥b.apply(th);
                if (e0Var == null) {
                    NullPointerException nullPointerException = new NullPointerException("Observable is null");
                    nullPointerException.initCause(th);
                    this.f١٩٨٧٤a.onError(nullPointerException);
                    return;
                }
                e0Var.subscribe(this);
            } catch (Throwable th2) {
                od.b.b(th2);
                this.f١٩٨٧٤a.onError(new od.a(th, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٨٧٨e) {
                return;
            }
            this.f١٩٨٧٤a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f١٩٨٧٦c.a(cVar);
        }
    }

    public i2(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar) {
        super(e0Var);
        this.f١٩٨٧٣b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var, this.f١٩٨٧٣b);
        g0Var.onSubscribe(aVar.f١٩٨٧٦c);
        this.f١٩٥٣٢a.subscribe(aVar);
    }
}
