package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class n4 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.c f٢٠١٩٦b;

    /* renamed from: c, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠١٩٧c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -312246233408980075L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠١٩٨a;

        /* renamed from: b, reason: collision with root package name */
        final pd.c f٢٠١٩٩b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference f٢٠٢٠٠c = new AtomicReference();

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference f٢٠٢٠١d = new AtomicReference();

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.c cVar) {
            this.f٢٠١٩٨a = g0Var;
            this.f٢٠١٩٩b = cVar;
        }

        public void a(Throwable th) {
            qd.c.a(this.f٢٠٢٠٠c);
            this.f٢٠١٩٨a.onError(th);
        }

        public boolean b(nd.c cVar) {
            return qd.c.g(this.f٢٠٢٠١d, cVar);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f٢٠٢٠٠c);
            qd.c.a(this.f٢٠٢٠١d);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) this.f٢٠٢٠٠c.get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            qd.c.a(this.f٢٠٢٠١d);
            this.f٢٠١٩٨a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            qd.c.a(this.f٢٠٢٠١d);
            this.f٢٠١٩٨a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            Object obj2 = get();
            if (obj2 != null) {
                try {
                    Object apply = this.f٢٠١٩٩b.apply(obj, obj2);
                    Objects.requireNonNull(apply, "The combiner returned a null value");
                    this.f٢٠١٩٨a.onNext(apply);
                } catch (Throwable th) {
                    od.b.b(th);
                    dispose();
                    this.f٢٠١٩٨a.onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f٢٠٢٠٠c, cVar);
        }
    }

    public n4(io.reactivex.rxjava3.core.e0 e0Var, pd.c cVar, io.reactivex.rxjava3.core.e0 e0Var2) {
        super(e0Var);
        this.f٢٠١٩٦b = cVar;
        this.f٢٠١٩٧c = e0Var2;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        he.e eVar = new he.e(g0Var);
        a aVar = new a(eVar, this.f٢٠١٩٦b);
        eVar.onSubscribe(aVar);
        this.f٢٠١٩٧c.subscribe(new b(aVar));
        this.f١٩٥٣٢a.subscribe(aVar);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    final class b implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        private final a f٢٠٢٠٢a;

        b(a aVar) {
            this.f٢٠٢٠٢a = aVar;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٢٠٢a.a(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٢٠٢a.lazySet(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f٢٠٢٠٢a.b(cVar);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
        }
    }
}
