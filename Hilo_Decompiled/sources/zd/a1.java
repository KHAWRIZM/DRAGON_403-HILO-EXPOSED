package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a1 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f١٩٥٣٧b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٥٣٨a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f١٩٥٣٩b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٥٤٠c;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar) {
            this.f١٩٥٣٨a = g0Var;
            this.f١٩٥٣٩b = oVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٥٤٠c.dispose();
            this.f١٩٥٤٠c = qd.c.DISPOSED;
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٥٤٠c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            nd.c cVar = this.f١٩٥٤٠c;
            qd.c cVar2 = qd.c.DISPOSED;
            if (cVar == cVar2) {
                return;
            }
            this.f١٩٥٤٠c = cVar2;
            this.f١٩٥٣٨a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            nd.c cVar = this.f١٩٥٤٠c;
            qd.c cVar2 = qd.c.DISPOSED;
            if (cVar == cVar2) {
                ie.a.s(th);
            } else {
                this.f١٩٥٤٠c = cVar2;
                this.f١٩٥٣٨a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٥٤٠c == qd.c.DISPOSED) {
                return;
            }
            try {
                io.reactivex.rxjava3.core.g0 g0Var = this.f١٩٥٣٨a;
                for (Object obj2 : (Iterable) this.f١٩٥٣٩b.apply(obj)) {
                    try {
                        try {
                            Objects.requireNonNull(obj2, "The iterator returned a null value");
                            g0Var.onNext(obj2);
                        } catch (Throwable th) {
                            od.b.b(th);
                            this.f١٩٥٤٠c.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        od.b.b(th2);
                        this.f١٩٥٤٠c.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                od.b.b(th3);
                this.f١٩٥٤٠c.dispose();
                onError(th3);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٥٤٠c, cVar)) {
                this.f١٩٥٤٠c = cVar;
                this.f١٩٥٣٨a.onSubscribe(this);
            }
        }
    }

    public a1(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar) {
        super(e0Var);
        this.f١٩٥٣٧b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٥٣٧b));
    }
}
