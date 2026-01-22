package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class h4 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final pd.r f١٩٨٥٦a;

    /* renamed from: b, reason: collision with root package name */
    final pd.o f١٩٨٥٧b;

    /* renamed from: c, reason: collision with root package name */
    final pd.g f١٩٨٥٨c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f١٩٨٥٩d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicBoolean implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 5904473792286235046L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٦٠a;

        /* renamed from: b, reason: collision with root package name */
        final Object f١٩٨٦١b;

        /* renamed from: c, reason: collision with root package name */
        final pd.g f١٩٨٦٢c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f١٩٨٦٣d;

        /* renamed from: e, reason: collision with root package name */
        nd.c f١٩٨٦٤e;

        a(io.reactivex.rxjava3.core.g0 g0Var, Object obj, pd.g gVar, boolean z10) {
            this.f١٩٨٦٠a = g0Var;
            this.f١٩٨٦١b = obj;
            this.f١٩٨٦٢c = gVar;
            this.f١٩٨٦٣d = z10;
        }

        void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f١٩٨٦٢c.accept(this.f١٩٨٦١b);
                } catch (Throwable th) {
                    od.b.b(th);
                    ie.a.s(th);
                }
            }
        }

        @Override // nd.c
        public void dispose() {
            if (this.f١٩٨٦٣d) {
                a();
                this.f١٩٨٦٤e.dispose();
                this.f١٩٨٦٤e = qd.c.DISPOSED;
            } else {
                this.f١٩٨٦٤e.dispose();
                this.f١٩٨٦٤e = qd.c.DISPOSED;
                a();
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٨٦٣d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f١٩٨٦٢c.accept(this.f١٩٨٦١b);
                    } catch (Throwable th) {
                        od.b.b(th);
                        this.f١٩٨٦٠a.onError(th);
                        return;
                    }
                }
                this.f١٩٨٦٤e.dispose();
                this.f١٩٨٦٠a.onComplete();
                return;
            }
            this.f١٩٨٦٠a.onComplete();
            this.f١٩٨٦٤e.dispose();
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٨٦٣d) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f١٩٨٦٢c.accept(this.f١٩٨٦١b);
                    } catch (Throwable th2) {
                        od.b.b(th2);
                        th = new od.a(th, th2);
                    }
                }
                this.f١٩٨٦٤e.dispose();
                this.f١٩٨٦٠a.onError(th);
                return;
            }
            this.f١٩٨٦٠a.onError(th);
            this.f١٩٨٦٤e.dispose();
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٨٦٠a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٨٦٤e, cVar)) {
                this.f١٩٨٦٤e = cVar;
                this.f١٩٨٦٠a.onSubscribe(this);
            }
        }
    }

    public h4(pd.r rVar, pd.o oVar, pd.g gVar, boolean z10) {
        this.f١٩٨٥٦a = rVar;
        this.f١٩٨٥٧b = oVar;
        this.f١٩٨٥٨c = gVar;
        this.f١٩٨٥٩d = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        try {
            Object obj = this.f١٩٨٥٦a.get();
            try {
                Object apply = this.f١٩٨٥٧b.apply(obj);
                Objects.requireNonNull(apply, "The sourceSupplier returned a null ObservableSource");
                ((io.reactivex.rxjava3.core.e0) apply).subscribe(new a(g0Var, obj, this.f١٩٨٥٨c, this.f١٩٨٥٩d));
            } catch (Throwable th) {
                od.b.b(th);
                try {
                    this.f١٩٨٥٨c.accept(obj);
                    qd.d.f(th, g0Var);
                } catch (Throwable th2) {
                    od.b.b(th2);
                    qd.d.f(new od.a(th, th2), g0Var);
                }
            }
        } catch (Throwable th3) {
            od.b.b(th3);
            qd.d.f(th3, g0Var);
        }
    }
}
