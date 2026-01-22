package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class p2 extends io.reactivex.rxjava3.core.i0 {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٣٠١a;

    /* renamed from: b, reason: collision with root package name */
    final Object f٢٠٣٠٢b;

    /* renamed from: c, reason: collision with root package name */
    final pd.c f٢٠٣٠٣c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.k0 f٢٠٣٠٤a;

        /* renamed from: b, reason: collision with root package name */
        final pd.c f٢٠٣٠٥b;

        /* renamed from: c, reason: collision with root package name */
        Object f٢٠٣٠٦c;

        /* renamed from: d, reason: collision with root package name */
        nd.c f٢٠٣٠٧d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(io.reactivex.rxjava3.core.k0 k0Var, pd.c cVar, Object obj) {
            this.f٢٠٣٠٤a = k0Var;
            this.f٢٠٣٠٦c = obj;
            this.f٢٠٣٠٥b = cVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٣٠٧d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٣٠٧d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            Object obj = this.f٢٠٣٠٦c;
            if (obj != null) {
                this.f٢٠٣٠٦c = null;
                this.f٢٠٣٠٤a.onSuccess(obj);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٣٠٦c != null) {
                this.f٢٠٣٠٦c = null;
                this.f٢٠٣٠٤a.onError(th);
            } else {
                ie.a.s(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            Object obj2 = this.f٢٠٣٠٦c;
            if (obj2 != null) {
                try {
                    Object apply = this.f٢٠٣٠٥b.apply(obj2, obj);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.f٢٠٣٠٦c = apply;
                } catch (Throwable th) {
                    od.b.b(th);
                    this.f٢٠٣٠٧d.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٣٠٧d, cVar)) {
                this.f٢٠٣٠٧d = cVar;
                this.f٢٠٣٠٤a.onSubscribe(this);
            }
        }
    }

    public p2(io.reactivex.rxjava3.core.e0 e0Var, Object obj, pd.c cVar) {
        this.f٢٠٣٠١a = e0Var;
        this.f٢٠٣٠٢b = obj;
        this.f٢٠٣٠٣c = cVar;
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(io.reactivex.rxjava3.core.k0 k0Var) {
        this.f٢٠٣٠١a.subscribe(new a(k0Var, this.f٢٠٣٠٣c, this.f٢٠٣٠٢b));
    }
}
