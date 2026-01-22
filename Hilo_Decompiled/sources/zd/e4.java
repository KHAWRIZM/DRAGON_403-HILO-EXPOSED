package zd;

import java.util.Collection;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e4 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.r f١٩٧٤٠b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٧٤١a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f١٩٧٤٢b;

        /* renamed from: c, reason: collision with root package name */
        Collection f١٩٧٤٣c;

        a(io.reactivex.rxjava3.core.g0 g0Var, Collection collection) {
            this.f١٩٧٤١a = g0Var;
            this.f١٩٧٤٣c = collection;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٧٤٢b.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٧٤٢b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            Collection collection = this.f١٩٧٤٣c;
            this.f١٩٧٤٣c = null;
            this.f١٩٧٤١a.onNext(collection);
            this.f١٩٧٤١a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٧٤٣c = null;
            this.f١٩٧٤١a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٧٤٣c.add(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٧٤٢b, cVar)) {
                this.f١٩٧٤٢b = cVar;
                this.f١٩٧٤١a.onSubscribe(this);
            }
        }
    }

    public e4(io.reactivex.rxjava3.core.e0 e0Var, pd.r rVar) {
        super(e0Var);
        this.f١٩٧٤٠b = rVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        try {
            this.f١٩٥٣٢a.subscribe(new a(g0Var, (Collection) fe.j.c(this.f١٩٧٤٠b.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.f(th, g0Var);
        }
    }
}
