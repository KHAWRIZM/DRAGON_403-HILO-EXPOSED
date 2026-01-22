package zd;

import java.util.Collection;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class f4 extends io.reactivex.rxjava3.core.i0 implements sd.d {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٧٨٦a;

    /* renamed from: b, reason: collision with root package name */
    final pd.r f١٩٧٨٧b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.k0 f١٩٧٨٨a;

        /* renamed from: b, reason: collision with root package name */
        Collection f١٩٧٨٩b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٧٩٠c;

        a(io.reactivex.rxjava3.core.k0 k0Var, Collection collection) {
            this.f١٩٧٨٨a = k0Var;
            this.f١٩٧٨٩b = collection;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٧٩٠c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٧٩٠c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            Collection collection = this.f١٩٧٨٩b;
            this.f١٩٧٨٩b = null;
            this.f١٩٧٨٨a.onSuccess(collection);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٧٨٩b = null;
            this.f١٩٧٨٨a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٧٨٩b.add(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٧٩٠c, cVar)) {
                this.f١٩٧٩٠c = cVar;
                this.f١٩٧٨٨a.onSubscribe(this);
            }
        }
    }

    public f4(io.reactivex.rxjava3.core.e0 e0Var, int i10) {
        this.f١٩٧٨٦a = e0Var;
        this.f١٩٧٨٧b = rd.a.e(i10);
    }

    @Override // sd.d
    public io.reactivex.rxjava3.core.z b() {
        return ie.a.o(new e4(this.f١٩٧٨٦a, this.f١٩٧٨٧b));
    }

    @Override // io.reactivex.rxjava3.core.i0
    public void o(io.reactivex.rxjava3.core.k0 k0Var) {
        try {
            this.f١٩٧٨٦a.subscribe(new a(k0Var, (Collection) fe.j.c(this.f١٩٧٨٧b.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.g(th, k0Var);
        }
    }

    public f4(io.reactivex.rxjava3.core.e0 e0Var, pd.r rVar) {
        this.f١٩٧٨٦a = e0Var;
        this.f١٩٧٨٧b = rVar;
    }
}
