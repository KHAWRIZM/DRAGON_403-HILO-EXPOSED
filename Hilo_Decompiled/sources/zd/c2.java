package zd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.f f١٩٦١٨b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -4592979584110982903L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٦١٩a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference f١٩٦٢٠b = new AtomicReference();

        /* renamed from: c, reason: collision with root package name */
        final C٠٢٥٩a f١٩٦٢١c = new C٠٢٥٩a(this);

        /* renamed from: d, reason: collision with root package name */
        final fe.c f١٩٦٢٢d = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f١٩٦٢٣e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f١٩٦٢٤f;

        /* renamed from: zd.c2$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        static final class C٠٢٥٩a extends AtomicReference implements io.reactivex.rxjava3.core.d {
            private static final long serialVersionUID = -2935427570954647017L;

            /* renamed from: a, reason: collision with root package name */
            final a f١٩٦٢٥a;

            C٠٢٥٩a(a aVar) {
                this.f١٩٦٢٥a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onComplete() {
                this.f١٩٦٢٥a.a();
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onError(Throwable th) {
                this.f١٩٦٢٥a.b(th);
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f١٩٦١٩a = g0Var;
        }

        void a() {
            this.f١٩٦٢٤f = true;
            if (this.f١٩٦٢٣e) {
                fe.k.a(this.f١٩٦١٩a, this, this.f١٩٦٢٢d);
            }
        }

        void b(Throwable th) {
            qd.c.a(this.f١٩٦٢٠b);
            fe.k.c(this.f١٩٦١٩a, th, this, this.f١٩٦٢٢d);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f١٩٦٢٠b);
            qd.c.a(this.f١٩٦٢١c);
            this.f١٩٦٢٢d.d();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) this.f١٩٦٢٠b.get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٦٢٣e = true;
            if (this.f١٩٦٢٤f) {
                fe.k.a(this.f١٩٦١٩a, this, this.f١٩٦٢٢d);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            qd.c.a(this.f١٩٦٢١c);
            fe.k.c(this.f١٩٦١٩a, th, this, this.f١٩٦٢٢d);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            fe.k.e(this.f١٩٦١٩a, obj, this, this.f١٩٦٢٢d);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f١٩٦٢٠b, cVar);
        }
    }

    public c2(io.reactivex.rxjava3.core.z zVar, io.reactivex.rxjava3.core.f fVar) {
        super(zVar);
        this.f١٩٦١٨b = fVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var);
        g0Var.onSubscribe(aVar);
        this.f١٩٥٣٢a.subscribe(aVar);
        this.f١٩٦١٨b.a(aVar.f١٩٦٢١c);
    }
}
