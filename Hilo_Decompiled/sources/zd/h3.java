package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class h3 extends io.reactivex.rxjava3.core.j {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٨٥١a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.l f١٩٨٥٢a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f١٩٨٥٣b;

        /* renamed from: c, reason: collision with root package name */
        Object f١٩٨٥٤c;

        /* renamed from: d, reason: collision with root package name */
        boolean f١٩٨٥٥d;

        a(io.reactivex.rxjava3.core.l lVar) {
            this.f١٩٨٥٢a = lVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٨٥٣b.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٨٥٣b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٨٥٥d) {
                return;
            }
            this.f١٩٨٥٥d = true;
            Object obj = this.f١٩٨٥٤c;
            this.f١٩٨٥٤c = null;
            if (obj == null) {
                this.f١٩٨٥٢a.onComplete();
            } else {
                this.f١٩٨٥٢a.onSuccess(obj);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٨٥٥d) {
                ie.a.s(th);
            } else {
                this.f١٩٨٥٥d = true;
                this.f١٩٨٥٢a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٨٥٥d) {
                return;
            }
            if (this.f١٩٨٥٤c != null) {
                this.f١٩٨٥٥d = true;
                this.f١٩٨٥٣b.dispose();
                this.f١٩٨٥٢a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f١٩٨٥٤c = obj;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٨٥٣b, cVar)) {
                this.f١٩٨٥٣b = cVar;
                this.f١٩٨٥٢a.onSubscribe(this);
            }
        }
    }

    public h3(io.reactivex.rxjava3.core.e0 e0Var) {
        this.f١٩٨٥١a = e0Var;
    }

    @Override // io.reactivex.rxjava3.core.j
    public void e(io.reactivex.rxjava3.core.l lVar) {
        this.f١٩٨٥١a.subscribe(new a(lVar));
    }
}
