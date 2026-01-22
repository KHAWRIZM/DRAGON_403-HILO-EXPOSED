package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class o2 extends io.reactivex.rxjava3.core.j {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٢٤٤a;

    /* renamed from: b, reason: collision with root package name */
    final pd.c f٢٠٢٤٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.l f٢٠٢٤٦a;

        /* renamed from: b, reason: collision with root package name */
        final pd.c f٢٠٢٤٧b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٢٠٢٤٨c;

        /* renamed from: d, reason: collision with root package name */
        Object f٢٠٢٤٩d;

        /* renamed from: e, reason: collision with root package name */
        nd.c f٢٠٢٥٠e;

        a(io.reactivex.rxjava3.core.l lVar, pd.c cVar) {
            this.f٢٠٢٤٦a = lVar;
            this.f٢٠٢٤٧b = cVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٢٥٠e.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٢٥٠e.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f٢٠٢٤٨c) {
                return;
            }
            this.f٢٠٢٤٨c = true;
            Object obj = this.f٢٠٢٤٩d;
            this.f٢٠٢٤٩d = null;
            if (obj != null) {
                this.f٢٠٢٤٦a.onSuccess(obj);
            } else {
                this.f٢٠٢٤٦a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٢٤٨c) {
                ie.a.s(th);
                return;
            }
            this.f٢٠٢٤٨c = true;
            this.f٢٠٢٤٩d = null;
            this.f٢٠٢٤٦a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (!this.f٢٠٢٤٨c) {
                Object obj2 = this.f٢٠٢٤٩d;
                if (obj2 == null) {
                    this.f٢٠٢٤٩d = obj;
                    return;
                }
                try {
                    Object apply = this.f٢٠٢٤٧b.apply(obj2, obj);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.f٢٠٢٤٩d = apply;
                } catch (Throwable th) {
                    od.b.b(th);
                    this.f٢٠٢٥٠e.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٢٥٠e, cVar)) {
                this.f٢٠٢٥٠e = cVar;
                this.f٢٠٢٤٦a.onSubscribe(this);
            }
        }
    }

    public o2(io.reactivex.rxjava3.core.e0 e0Var, pd.c cVar) {
        this.f٢٠٢٤٤a = e0Var;
        this.f٢٠٢٤٥b = cVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void e(io.reactivex.rxjava3.core.l lVar) {
        this.f٢٠٢٤٤a.subscribe(new a(lVar, this.f٢٠٢٤٥b));
    }
}
