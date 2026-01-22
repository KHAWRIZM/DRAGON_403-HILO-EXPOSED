package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class u2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٥٦٢b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 802743776666017014L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٥٦٣a;

        /* renamed from: d, reason: collision with root package name */
        final le.c f٢٠٥٦٦d;

        /* renamed from: g, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f٢٠٥٦٩g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f٢٠٥٧٠h;

        /* renamed from: b, reason: collision with root package name */
        final AtomicInteger f٢٠٥٦٤b = new AtomicInteger();

        /* renamed from: c, reason: collision with root package name */
        final fe.c f٢٠٥٦٥c = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        final C٠٢٦٩a f٢٠٥٦٧e = new C٠٢٦٩a();

        /* renamed from: f, reason: collision with root package name */
        final AtomicReference f٢٠٥٦٨f = new AtomicReference();

        /* renamed from: zd.u2$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class C٠٢٦٩a extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
            private static final long serialVersionUID = 3254781284376480842L;

            C٠٢٦٩a() {
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                a.this.a();
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                a.this.b(th);
            }

            @Override // io.reactivex.rxjava3.core.g0
            public void onNext(Object obj) {
                a.this.c();
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var, le.c cVar, io.reactivex.rxjava3.core.e0 e0Var) {
            this.f٢٠٥٦٣a = g0Var;
            this.f٢٠٥٦٦d = cVar;
            this.f٢٠٥٦٩g = e0Var;
        }

        void a() {
            qd.c.a(this.f٢٠٥٦٨f);
            fe.k.a(this.f٢٠٥٦٣a, this, this.f٢٠٥٦٥c);
        }

        void b(Throwable th) {
            qd.c.a(this.f٢٠٥٦٨f);
            fe.k.c(this.f٢٠٥٦٣a, th, this, this.f٢٠٥٦٥c);
        }

        void c() {
            d();
        }

        void d() {
            if (this.f٢٠٥٦٤b.getAndIncrement() != 0) {
                return;
            }
            while (!isDisposed()) {
                if (!this.f٢٠٥٧٠h) {
                    this.f٢٠٥٧٠h = true;
                    this.f٢٠٥٦٩g.subscribe(this);
                }
                if (this.f٢٠٥٦٤b.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f٢٠٥٦٨f);
            qd.c.a(this.f٢٠٥٦٧e);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) this.f٢٠٥٦٨f.get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            qd.c.d(this.f٢٠٥٦٨f, null);
            this.f٢٠٥٧٠h = false;
            this.f٢٠٥٦٦d.onNext(0);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            qd.c.a(this.f٢٠٥٦٧e);
            fe.k.c(this.f٢٠٥٦٣a, th, this, this.f٢٠٥٦٥c);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            fe.k.e(this.f٢٠٥٦٣a, obj, this, this.f٢٠٥٦٥c);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f٢٠٥٦٨f, cVar);
        }
    }

    public u2(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar) {
        super(e0Var);
        this.f٢٠٥٦٢b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        le.c d10 = le.a.f().d();
        try {
            Object apply = this.f٢٠٥٦٢b.apply(d10);
            Objects.requireNonNull(apply, "The handler returned a null ObservableSource");
            io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
            a aVar = new a(g0Var, d10, this.f١٩٥٣٢a);
            g0Var.onSubscribe(aVar);
            e0Var.subscribe(aVar.f٢٠٥٦٧e);
            aVar.d();
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.f(th, g0Var);
        }
    }
}
