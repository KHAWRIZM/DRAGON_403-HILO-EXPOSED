package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.c f١٩٦٨٦b;

    /* renamed from: c, reason: collision with root package name */
    final pd.r f١٩٦٨٧c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٦٨٨a;

        /* renamed from: b, reason: collision with root package name */
        final pd.c f١٩٦٨٩b;

        /* renamed from: c, reason: collision with root package name */
        Object f١٩٦٩٠c;

        /* renamed from: d, reason: collision with root package name */
        nd.c f١٩٦٩١d;

        /* renamed from: e, reason: collision with root package name */
        boolean f١٩٦٩٢e;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.c cVar, Object obj) {
            this.f١٩٦٨٨a = g0Var;
            this.f١٩٦٨٩b = cVar;
            this.f١٩٦٩٠c = obj;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٦٩١d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٦٩١d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٦٩٢e) {
                return;
            }
            this.f١٩٦٩٢e = true;
            this.f١٩٦٨٨a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٦٩٢e) {
                ie.a.s(th);
            } else {
                this.f١٩٦٩٢e = true;
                this.f١٩٦٨٨a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٦٩٢e) {
                return;
            }
            try {
                Object apply = this.f١٩٦٨٩b.apply(this.f١٩٦٩٠c, obj);
                Objects.requireNonNull(apply, "The accumulator returned a null value");
                this.f١٩٦٩٠c = apply;
                this.f١٩٦٨٨a.onNext(apply);
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٦٩١d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٦٩١d, cVar)) {
                this.f١٩٦٩١d = cVar;
                this.f١٩٦٨٨a.onSubscribe(this);
                this.f١٩٦٨٨a.onNext(this.f١٩٦٩٠c);
            }
        }
    }

    public d3(io.reactivex.rxjava3.core.e0 e0Var, pd.r rVar, pd.c cVar) {
        super(e0Var);
        this.f١٩٦٨٦b = cVar;
        this.f١٩٦٨٧c = rVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        try {
            Object obj = this.f١٩٦٨٧c.get();
            Objects.requireNonNull(obj, "The seed supplied is null");
            this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٦٨٦b, obj));
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.f(th, g0Var);
        }
    }
}
