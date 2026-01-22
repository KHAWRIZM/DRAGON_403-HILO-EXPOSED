package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.c f١٩٦٢٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٦٢٧a;

        /* renamed from: b, reason: collision with root package name */
        final pd.c f١٩٦٢٨b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٦٢٩c;

        /* renamed from: d, reason: collision with root package name */
        Object f١٩٦٣٠d;

        /* renamed from: e, reason: collision with root package name */
        boolean f١٩٦٣١e;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.c cVar) {
            this.f١٩٦٢٧a = g0Var;
            this.f١٩٦٢٨b = cVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٦٢٩c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٦٢٩c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٦٣١e) {
                return;
            }
            this.f١٩٦٣١e = true;
            this.f١٩٦٢٧a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٦٣١e) {
                ie.a.s(th);
            } else {
                this.f١٩٦٣١e = true;
                this.f١٩٦٢٧a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٦٣١e) {
                return;
            }
            io.reactivex.rxjava3.core.g0 g0Var = this.f١٩٦٢٧a;
            Object obj2 = this.f١٩٦٣٠d;
            if (obj2 == null) {
                this.f١٩٦٣٠d = obj;
                g0Var.onNext(obj);
                return;
            }
            try {
                Object apply = this.f١٩٦٢٨b.apply(obj2, obj);
                Objects.requireNonNull(apply, "The value returned by the accumulator is null");
                this.f١٩٦٣٠d = apply;
                g0Var.onNext(apply);
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٦٢٩c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٦٢٩c, cVar)) {
                this.f١٩٦٢٩c = cVar;
                this.f١٩٦٢٧a.onSubscribe(this);
            }
        }
    }

    public c3(io.reactivex.rxjava3.core.e0 e0Var, pd.c cVar) {
        super(e0Var);
        this.f١٩٦٢٦b = cVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٦٢٦b));
    }
}
