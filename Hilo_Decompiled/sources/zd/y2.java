package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class y2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٧٦٩b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 802743776666017014L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٧٧٠a;

        /* renamed from: d, reason: collision with root package name */
        final le.c f٢٠٧٧٣d;

        /* renamed from: g, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f٢٠٧٧٦g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f٢٠٧٧٧h;

        /* renamed from: b, reason: collision with root package name */
        final AtomicInteger f٢٠٧٧١b = new AtomicInteger();

        /* renamed from: c, reason: collision with root package name */
        final fe.c f٢٠٧٧٢c = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        final C٠٢٧٥a f٢٠٧٧٤e = new C٠٢٧٥a();

        /* renamed from: f, reason: collision with root package name */
        final AtomicReference f٢٠٧٧٥f = new AtomicReference();

        /* renamed from: zd.y2$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class C٠٢٧٥a extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
            private static final long serialVersionUID = 3254781284376480842L;

            C٠٢٧٥a() {
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
            this.f٢٠٧٧٠a = g0Var;
            this.f٢٠٧٧٣d = cVar;
            this.f٢٠٧٧٦g = e0Var;
        }

        void a() {
            qd.c.a(this.f٢٠٧٧٥f);
            fe.k.a(this.f٢٠٧٧٠a, this, this.f٢٠٧٧٢c);
        }

        void b(Throwable th) {
            qd.c.a(this.f٢٠٧٧٥f);
            fe.k.c(this.f٢٠٧٧٠a, th, this, this.f٢٠٧٧٢c);
        }

        void c() {
            d();
        }

        void d() {
            if (this.f٢٠٧٧١b.getAndIncrement() != 0) {
                return;
            }
            while (!isDisposed()) {
                if (!this.f٢٠٧٧٧h) {
                    this.f٢٠٧٧٧h = true;
                    this.f٢٠٧٧٦g.subscribe(this);
                }
                if (this.f٢٠٧٧١b.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f٢٠٧٧٥f);
            qd.c.a(this.f٢٠٧٧٤e);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) this.f٢٠٧٧٥f.get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            qd.c.a(this.f٢٠٧٧٤e);
            fe.k.a(this.f٢٠٧٧٠a, this, this.f٢٠٧٧٢c);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            qd.c.d(this.f٢٠٧٧٥f, null);
            this.f٢٠٧٧٧h = false;
            this.f٢٠٧٧٣d.onNext(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            fe.k.e(this.f٢٠٧٧٠a, obj, this, this.f٢٠٧٧٢c);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.d(this.f٢٠٧٧٥f, cVar);
        }
    }

    public y2(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar) {
        super(e0Var);
        this.f٢٠٧٦٩b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        le.c d10 = le.a.f().d();
        try {
            Object apply = this.f٢٠٧٦٩b.apply(d10);
            Objects.requireNonNull(apply, "The handler returned a null ObservableSource");
            io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
            a aVar = new a(g0Var, d10, this.f١٩٥٣٢a);
            g0Var.onSubscribe(aVar);
            e0Var.subscribe(aVar.f٢٠٧٧٤e);
            aVar.d();
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.f(th, g0Var);
        }
    }
}
