package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f١٩٥٤١b;

    /* renamed from: c, reason: collision with root package name */
    final pd.o f١٩٥٤٢c;

    /* renamed from: d, reason: collision with root package name */
    final pd.r f١٩٥٤٣d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٥٤٤a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f١٩٥٤٥b;

        /* renamed from: c, reason: collision with root package name */
        final pd.o f١٩٥٤٦c;

        /* renamed from: d, reason: collision with root package name */
        final pd.r f١٩٥٤٧d;

        /* renamed from: e, reason: collision with root package name */
        nd.c f١٩٥٤٨e;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, pd.o oVar2, pd.r rVar) {
            this.f١٩٥٤٤a = g0Var;
            this.f١٩٥٤٥b = oVar;
            this.f١٩٥٤٦c = oVar2;
            this.f١٩٥٤٧d = rVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٥٤٨e.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٥٤٨e.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            try {
                Object obj = this.f١٩٥٤٧d.get();
                Objects.requireNonNull(obj, "The onComplete ObservableSource returned is null");
                this.f١٩٥٤٤a.onNext((io.reactivex.rxjava3.core.e0) obj);
                this.f١٩٥٤٤a.onComplete();
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٥٤٤a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            try {
                Object apply = this.f١٩٥٤٦c.apply(th);
                Objects.requireNonNull(apply, "The onError ObservableSource returned is null");
                this.f١٩٥٤٤a.onNext((io.reactivex.rxjava3.core.e0) apply);
                this.f١٩٥٤٤a.onComplete();
            } catch (Throwable th2) {
                od.b.b(th2);
                this.f١٩٥٤٤a.onError(new od.a(th, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            try {
                Object apply = this.f١٩٥٤٥b.apply(obj);
                Objects.requireNonNull(apply, "The onNext ObservableSource returned is null");
                this.f١٩٥٤٤a.onNext((io.reactivex.rxjava3.core.e0) apply);
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٥٤٤a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٥٤٨e, cVar)) {
                this.f١٩٥٤٨e = cVar;
                this.f١٩٥٤٤a.onSubscribe(this);
            }
        }
    }

    public a2(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, pd.o oVar2, pd.r rVar) {
        super(e0Var);
        this.f١٩٥٤١b = oVar;
        this.f١٩٥٤٢c = oVar2;
        this.f١٩٥٤٣d = rVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٥٤١b, this.f١٩٥٤٢c, this.f١٩٥٤٣d));
    }
}
