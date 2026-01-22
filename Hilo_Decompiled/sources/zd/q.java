package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class q extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.r f٢٠٣٢٩b;

    /* renamed from: c, reason: collision with root package name */
    final pd.b f٢٠٣٣٠c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٣٣١a;

        /* renamed from: b, reason: collision with root package name */
        final pd.b f٢٠٣٣٢b;

        /* renamed from: c, reason: collision with root package name */
        final Object f٢٠٣٣٣c;

        /* renamed from: d, reason: collision with root package name */
        nd.c f٢٠٣٣٤d;

        /* renamed from: e, reason: collision with root package name */
        boolean f٢٠٣٣٥e;

        a(io.reactivex.rxjava3.core.g0 g0Var, Object obj, pd.b bVar) {
            this.f٢٠٣٣١a = g0Var;
            this.f٢٠٣٣٢b = bVar;
            this.f٢٠٣٣٣c = obj;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٣٣٤d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٣٣٤d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f٢٠٣٣٥e) {
                return;
            }
            this.f٢٠٣٣٥e = true;
            this.f٢٠٣٣١a.onNext(this.f٢٠٣٣٣c);
            this.f٢٠٣٣١a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٣٣٥e) {
                ie.a.s(th);
            } else {
                this.f٢٠٣٣٥e = true;
                this.f٢٠٣٣١a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٣٣٥e) {
                return;
            }
            try {
                this.f٢٠٣٣٢b.accept(this.f٢٠٣٣٣c, obj);
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠٣٣٤d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٣٣٤d, cVar)) {
                this.f٢٠٣٣٤d = cVar;
                this.f٢٠٣٣١a.onSubscribe(this);
            }
        }
    }

    public q(io.reactivex.rxjava3.core.e0 e0Var, pd.r rVar, pd.b bVar) {
        super(e0Var);
        this.f٢٠٣٢٩b = rVar;
        this.f٢٠٣٣٠c = bVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        try {
            Object obj = this.f٢٠٣٢٩b.get();
            Objects.requireNonNull(obj, "The initialSupplier returned a null value");
            this.f١٩٥٣٢a.subscribe(new a(g0Var, obj, this.f٢٠٣٣٠c));
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.f(th, g0Var);
        }
    }
}
