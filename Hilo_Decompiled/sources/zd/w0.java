package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class w0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٦٩٥b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f٢٠٦٩٦c;

    public w0(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, boolean z10) {
        super(e0Var);
        this.f٢٠٦٩٥b = oVar;
        this.f٢٠٦٩٦c = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٦٩٥b, this.f٢٠٦٩٦c));
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.b implements io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٦٩٧a;

        /* renamed from: c, reason: collision with root package name */
        final pd.o f٢٠٦٩٩c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f٢٠٧٠٠d;

        /* renamed from: f, reason: collision with root package name */
        nd.c f٢٠٧٠٢f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f٢٠٧٠٣g;

        /* renamed from: b, reason: collision with root package name */
        final fe.c f٢٠٦٩٨b = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        final nd.a f٢٠٧٠١e = new nd.a();

        /* renamed from: zd.w0$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class C٠٢٧٢a extends AtomicReference implements io.reactivex.rxjava3.core.d, nd.c {
            private static final long serialVersionUID = 8606673141535671828L;

            C٠٢٧٢a() {
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
                a.this.b(this);
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onError(Throwable th) {
                a.this.c(this, th);
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, boolean z10) {
            this.f٢٠٦٩٧a = g0Var;
            this.f٢٠٦٩٩c = oVar;
            this.f٢٠٧٠٠d = z10;
            lazySet(1);
        }

        @Override // sd.f
        public int a(int i10) {
            return i10 & 2;
        }

        void b(C٠٢٧٢a r22) {
            this.f٢٠٧٠١e.c(r22);
            onComplete();
        }

        void c(C٠٢٧٢a r22, Throwable th) {
            this.f٢٠٧٠١e.c(r22);
            onError(th);
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٧٠٣g = true;
            this.f٢٠٧٠٢f.dispose();
            this.f٢٠٧٠١e.dispose();
            this.f٢٠٦٩٨b.d();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٧٠٢f.isDisposed();
        }

        @Override // sd.j
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.f٢٠٦٩٨b.f(this.f٢٠٦٩٧a);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٦٩٨b.c(th)) {
                if (this.f٢٠٧٠٠d) {
                    if (decrementAndGet() == 0) {
                        this.f٢٠٦٩٨b.f(this.f٢٠٦٩٧a);
                    }
                } else {
                    this.f٢٠٧٠٣g = true;
                    this.f٢٠٧٠٢f.dispose();
                    this.f٢٠٧٠١e.dispose();
                    this.f٢٠٦٩٨b.f(this.f٢٠٦٩٧a);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            try {
                Object apply = this.f٢٠٦٩٩c.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                io.reactivex.rxjava3.core.f fVar = (io.reactivex.rxjava3.core.f) apply;
                getAndIncrement();
                C٠٢٧٢a r02 = new C٠٢٧٢a();
                if (!this.f٢٠٧٠٣g && this.f٢٠٧٠١e.a(r02)) {
                    fVar.a(r02);
                }
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠٧٠٢f.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٧٠٢f, cVar)) {
                this.f٢٠٧٠٢f = cVar;
                this.f٢٠٦٩٧a.onSubscribe(this);
            }
        }

        @Override // sd.j
        public Object poll() {
            return null;
        }

        @Override // sd.j
        public void clear() {
        }
    }
}
