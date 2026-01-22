package zd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class v3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٦٨٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 1418547743690811973L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٦٨٦a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference f٢٠٦٨٧b = new AtomicReference();

        /* renamed from: c, reason: collision with root package name */
        final C٠٢٧١a f٢٠٦٨٨c = new C٠٢٧١a();

        /* renamed from: d, reason: collision with root package name */
        final fe.c f٢٠٦٨٩d = new fe.c();

        /* renamed from: zd.v3$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class C٠٢٧١a extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
            private static final long serialVersionUID = -8693423678067375039L;

            C٠٢٧١a() {
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
                qd.c.a(this);
                a.this.a();
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٦٨٦a = g0Var;
        }

        void a() {
            qd.c.a(this.f٢٠٦٨٧b);
            fe.k.a(this.f٢٠٦٨٦a, this, this.f٢٠٦٨٩d);
        }

        void b(Throwable th) {
            qd.c.a(this.f٢٠٦٨٧b);
            fe.k.c(this.f٢٠٦٨٦a, th, this, this.f٢٠٦٨٩d);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f٢٠٦٨٧b);
            qd.c.a(this.f٢٠٦٨٨c);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) this.f٢٠٦٨٧b.get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            qd.c.a(this.f٢٠٦٨٨c);
            fe.k.a(this.f٢٠٦٨٦a, this, this.f٢٠٦٨٩d);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            qd.c.a(this.f٢٠٦٨٨c);
            fe.k.c(this.f٢٠٦٨٦a, th, this, this.f٢٠٦٨٩d);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            fe.k.e(this.f٢٠٦٨٦a, obj, this, this.f٢٠٦٨٩d);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f٢٠٦٨٧b, cVar);
        }
    }

    public v3(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2) {
        super(e0Var);
        this.f٢٠٦٨٥b = e0Var2;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var);
        g0Var.onSubscribe(aVar);
        this.f٢٠٦٨٥b.subscribe(aVar.f٢٠٦٨٨c);
        this.f١٩٥٣٢a.subscribe(aVar);
    }
}
