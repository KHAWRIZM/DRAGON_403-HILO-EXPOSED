package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class l2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٠١٣b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        final le.a f٢٠٠١٤a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference f٢٠٠١٥b;

        a(le.a aVar, AtomicReference atomicReference) {
            this.f٢٠٠١٤a = aVar;
            this.f٢٠٠١٥b = atomicReference;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٠١٤a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٠١٤a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٠١٤a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f٢٠٠١٥b, cVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 854110278590336484L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٠١٦a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f٢٠٠١٧b;

        b(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٠١٦a = g0Var;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٠١٧b.dispose();
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٠١٧b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            qd.c.a(this);
            this.f٢٠٠١٦a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            qd.c.a(this);
            this.f٢٠٠١٦a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٠١٦a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٠١٧b, cVar)) {
                this.f٢٠٠١٧b = cVar;
                this.f٢٠٠١٦a.onSubscribe(this);
            }
        }
    }

    public l2(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar) {
        super(e0Var);
        this.f٢٠٠١٣b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        le.a f10 = le.a.f();
        try {
            Object apply = this.f٢٠٠١٣b.apply(f10);
            Objects.requireNonNull(apply, "The selector returned a null ObservableSource");
            io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
            b bVar = new b(g0Var);
            e0Var.subscribe(bVar);
            this.f١٩٥٣٢a.subscribe(new a(f10, bVar));
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.f(th, g0Var);
        }
    }
}
