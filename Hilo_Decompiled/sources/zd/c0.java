package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f١٩٦٠٠b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٦٠١a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f١٩٦٠٢b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٦٠٣c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference f١٩٦٠٤d = new AtomicReference();

        /* renamed from: e, reason: collision with root package name */
        volatile long f١٩٦٠٥e;

        /* renamed from: f, reason: collision with root package name */
        boolean f١٩٦٠٦f;

        /* renamed from: zd.c0$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        static final class C٠٢٥٨a extends he.c {

            /* renamed from: b, reason: collision with root package name */
            final a f١٩٦٠٧b;

            /* renamed from: c, reason: collision with root package name */
            final long f١٩٦٠٨c;

            /* renamed from: d, reason: collision with root package name */
            final Object f١٩٦٠٩d;

            /* renamed from: e, reason: collision with root package name */
            boolean f١٩٦١٠e;

            /* renamed from: f, reason: collision with root package name */
            final AtomicBoolean f١٩٦١١f = new AtomicBoolean();

            C٠٢٥٨a(a aVar, long j10, Object obj) {
                this.f١٩٦٠٧b = aVar;
                this.f١٩٦٠٨c = j10;
                this.f١٩٦٠٩d = obj;
            }

            void b() {
                if (this.f١٩٦١١f.compareAndSet(false, true)) {
                    this.f١٩٦٠٧b.a(this.f١٩٦٠٨c, this.f١٩٦٠٩d);
                }
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                if (this.f١٩٦١٠e) {
                    return;
                }
                this.f١٩٦١٠e = true;
                b();
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                if (this.f١٩٦١٠e) {
                    ie.a.s(th);
                } else {
                    this.f١٩٦١٠e = true;
                    this.f١٩٦٠٧b.onError(th);
                }
            }

            @Override // io.reactivex.rxjava3.core.g0
            public void onNext(Object obj) {
                if (this.f١٩٦١٠e) {
                    return;
                }
                this.f١٩٦١٠e = true;
                dispose();
                b();
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar) {
            this.f١٩٦٠١a = g0Var;
            this.f١٩٦٠٢b = oVar;
        }

        void a(long j10, Object obj) {
            if (j10 == this.f١٩٦٠٥e) {
                this.f١٩٦٠١a.onNext(obj);
            }
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٦٠٣c.dispose();
            qd.c.a(this.f١٩٦٠٤d);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٦٠٣c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٦٠٦f) {
                return;
            }
            this.f١٩٦٠٦f = true;
            nd.c cVar = (nd.c) this.f١٩٦٠٤d.get();
            if (cVar != qd.c.DISPOSED) {
                C٠٢٥٨a r02 = (C٠٢٥٨a) cVar;
                if (r02 != null) {
                    r02.b();
                }
                qd.c.a(this.f١٩٦٠٤d);
                this.f١٩٦٠١a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            qd.c.a(this.f١٩٦٠٤d);
            this.f١٩٦٠١a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٦٠٦f) {
                return;
            }
            long j10 = this.f١٩٦٠٥e + 1;
            this.f١٩٦٠٥e = j10;
            nd.c cVar = (nd.c) this.f١٩٦٠٤d.get();
            if (cVar != null) {
                cVar.dispose();
            }
            try {
                Object apply = this.f١٩٦٠٢b.apply(obj);
                Objects.requireNonNull(apply, "The ObservableSource supplied is null");
                io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                C٠٢٥٨a r42 = new C٠٢٥٨a(this, j10, obj);
                if (androidx.lifecycle.a.a(this.f١٩٦٠٤d, cVar, r42)) {
                    e0Var.subscribe(r42);
                }
            } catch (Throwable th) {
                od.b.b(th);
                dispose();
                this.f١٩٦٠١a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٦٠٣c, cVar)) {
                this.f١٩٦٠٣c = cVar;
                this.f١٩٦٠١a.onSubscribe(this);
            }
        }
    }

    public c0(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar) {
        super(e0Var);
        this.f١٩٦٠٠b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(new he.e(g0Var), this.f١٩٦٠٠b));
    }
}
