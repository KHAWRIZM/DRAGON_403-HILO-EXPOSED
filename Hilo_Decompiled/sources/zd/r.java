package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class r extends io.reactivex.rxjava3.core.i0 implements sd.d {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٣٧٦a;

    /* renamed from: b, reason: collision with root package name */
    final pd.r f٢٠٣٧٧b;

    /* renamed from: c, reason: collision with root package name */
    final pd.b f٢٠٣٧٨c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.k0 f٢٠٣٧٩a;

        /* renamed from: b, reason: collision with root package name */
        final pd.b f٢٠٣٨٠b;

        /* renamed from: c, reason: collision with root package name */
        final Object f٢٠٣٨١c;

        /* renamed from: d, reason: collision with root package name */
        nd.c f٢٠٣٨٢d;

        /* renamed from: e, reason: collision with root package name */
        boolean f٢٠٣٨٣e;

        a(io.reactivex.rxjava3.core.k0 k0Var, Object obj, pd.b bVar) {
            this.f٢٠٣٧٩a = k0Var;
            this.f٢٠٣٨٠b = bVar;
            this.f٢٠٣٨١c = obj;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٣٨٢d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٣٨٢d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f٢٠٣٨٣e) {
                return;
            }
            this.f٢٠٣٨٣e = true;
            this.f٢٠٣٧٩a.onSuccess(this.f٢٠٣٨١c);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٣٨٣e) {
                ie.a.s(th);
            } else {
                this.f٢٠٣٨٣e = true;
                this.f٢٠٣٧٩a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٣٨٣e) {
                return;
            }
            try {
                this.f٢٠٣٨٠b.accept(this.f٢٠٣٨١c, obj);
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠٣٨٢d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٣٨٢d, cVar)) {
                this.f٢٠٣٨٢d = cVar;
                this.f٢٠٣٧٩a.onSubscribe(this);
            }
        }
    }

    public r(io.reactivex.rxjava3.core.e0 e0Var, pd.r rVar, pd.b bVar) {
        this.f٢٠٣٧٦a = e0Var;
        this.f٢٠٣٧٧b = rVar;
        this.f٢٠٣٧٨c = bVar;
    }

    @Override // sd.d
    public io.reactivex.rxjava3.core.z b() {
        return ie.a.o(new q(this.f٢٠٣٧٦a, this.f٢٠٣٧٧b, this.f٢٠٣٧٨c));
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(io.reactivex.rxjava3.core.k0 k0Var) {
        try {
            Object obj = this.f٢٠٣٧٧b.get();
            Objects.requireNonNull(obj, "The initialSupplier returned a null value");
            this.f٢٠٣٧٦a.subscribe(new a(k0Var, obj, this.f٢٠٣٧٨c));
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.g(th, k0Var);
        }
    }
}
