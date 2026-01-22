package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class x0 extends io.reactivex.rxjava3.core.b implements sd.d {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٧٢٤a;

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٧٢٥b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f٢٠٧٢٦c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements nd.c, io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.d f٢٠٧٢٧a;

        /* renamed from: c, reason: collision with root package name */
        final pd.o f٢٠٧٢٩c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f٢٠٧٣٠d;

        /* renamed from: f, reason: collision with root package name */
        nd.c f٢٠٧٣٢f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f٢٠٧٣٣g;

        /* renamed from: b, reason: collision with root package name */
        final fe.c f٢٠٧٢٨b = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        final nd.a f٢٠٧٣١e = new nd.a();

        /* renamed from: zd.x0$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class C٠٢٧٣a extends AtomicReference implements io.reactivex.rxjava3.core.d, nd.c {
            private static final long serialVersionUID = 8606673141535671828L;

            C٠٢٧٣a() {
            }

            @Override // nd.c
            public void dispose() {
                qd.c.a(this);
            }

            @Override // nd.c
            public boolean isDisposed() {
                return qd.c.c((nd.c) get());
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onComplete() {
                a.this.a(this);
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onError(Throwable th) {
                a.this.b(this, th);
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }
        }

        a(io.reactivex.rxjava3.core.d dVar, pd.o oVar, boolean z10) {
            this.f٢٠٧٢٧a = dVar;
            this.f٢٠٧٢٩c = oVar;
            this.f٢٠٧٣٠d = z10;
            lazySet(1);
        }

        void a(C٠٢٧٣a r22) {
            this.f٢٠٧٣١e.c(r22);
            onComplete();
        }

        void b(C٠٢٧٣a r22, Throwable th) {
            this.f٢٠٧٣١e.c(r22);
            onError(th);
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٧٣٣g = true;
            this.f٢٠٧٣٢f.dispose();
            this.f٢٠٧٣١e.dispose();
            this.f٢٠٧٢٨b.d();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٧٣٢f.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.f٢٠٧٢٨b.e(this.f٢٠٧٢٧a);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٧٢٨b.c(th)) {
                if (this.f٢٠٧٣٠d) {
                    if (decrementAndGet() == 0) {
                        this.f٢٠٧٢٨b.e(this.f٢٠٧٢٧a);
                    }
                } else {
                    this.f٢٠٧٣٣g = true;
                    this.f٢٠٧٣٢f.dispose();
                    this.f٢٠٧٣١e.dispose();
                    this.f٢٠٧٢٨b.e(this.f٢٠٧٢٧a);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            try {
                Object apply = this.f٢٠٧٢٩c.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                io.reactivex.rxjava3.core.f fVar = (io.reactivex.rxjava3.core.f) apply;
                getAndIncrement();
                C٠٢٧٣a r02 = new C٠٢٧٣a();
                if (!this.f٢٠٧٣٣g && this.f٢٠٧٣١e.a(r02)) {
                    fVar.a(r02);
                }
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠٧٣٢f.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٧٣٢f, cVar)) {
                this.f٢٠٧٣٢f = cVar;
                this.f٢٠٧٢٧a.onSubscribe(this);
            }
        }
    }

    public x0(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, boolean z10) {
        this.f٢٠٧٢٤a = e0Var;
        this.f٢٠٧٢٥b = oVar;
        this.f٢٠٧٢٦c = z10;
    }

    @Override // sd.d
    public io.reactivex.rxjava3.core.z b() {
        return ie.a.o(new w0(this.f٢٠٧٢٤a, this.f٢٠٧٢٥b, this.f٢٠٧٢٦c));
    }

    @Override // io.reactivex.rxjava3.core.b
    protected void e(io.reactivex.rxjava3.core.d dVar) {
        this.f٢٠٧٢٤a.subscribe(new a(dVar, this.f٢٠٧٢٥b, this.f٢٠٧٢٦c));
    }
}
