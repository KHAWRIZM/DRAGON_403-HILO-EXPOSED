package zd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٥٤٩b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f١٩٥٥٠c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends c {
        private static final long serialVersionUID = -3029755663834015785L;

        /* renamed from: e, reason: collision with root package name */
        final AtomicInteger f١٩٥٥١e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f١٩٥٥٢f;

        a(io.reactivex.rxjava3.core.g0 g0Var, io.reactivex.rxjava3.core.e0 e0Var) {
            super(g0Var, e0Var);
            this.f١٩٥٥١e = new AtomicInteger();
        }

        @Override // zd.a3.c
        void b() {
            this.f١٩٥٥٢f = true;
            if (this.f١٩٥٥١e.getAndIncrement() == 0) {
                c();
                this.f١٩٥٥٣a.onComplete();
            }
        }

        @Override // zd.a3.c
        void e() {
            if (this.f١٩٥٥١e.getAndIncrement() != 0) {
                return;
            }
            do {
                boolean z10 = this.f١٩٥٥٢f;
                c();
                if (z10) {
                    this.f١٩٥٥٣a.onComplete();
                    return;
                }
            } while (this.f١٩٥٥١e.decrementAndGet() != 0);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends c {
        private static final long serialVersionUID = -3029755663834015785L;

        b(io.reactivex.rxjava3.core.g0 g0Var, io.reactivex.rxjava3.core.e0 e0Var) {
            super(g0Var, e0Var);
        }

        @Override // zd.a3.c
        void b() {
            this.f١٩٥٥٣a.onComplete();
        }

        @Override // zd.a3.c
        void e() {
            c();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static abstract class c extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٥٥٣a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f١٩٥٥٤b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference f١٩٥٥٥c = new AtomicReference();

        /* renamed from: d, reason: collision with root package name */
        nd.c f١٩٥٥٦d;

        c(io.reactivex.rxjava3.core.g0 g0Var, io.reactivex.rxjava3.core.e0 e0Var) {
            this.f١٩٥٥٣a = g0Var;
            this.f١٩٥٥٤b = e0Var;
        }

        public void a() {
            this.f١٩٥٥٦d.dispose();
            b();
        }

        abstract void b();

        void c() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.f١٩٥٥٣a.onNext(andSet);
            }
        }

        public void d(Throwable th) {
            this.f١٩٥٥٦d.dispose();
            this.f١٩٥٥٣a.onError(th);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f١٩٥٥٥c);
            this.f١٩٥٥٦d.dispose();
        }

        abstract void e();

        boolean f(nd.c cVar) {
            return qd.c.g(this.f١٩٥٥٥c, cVar);
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (this.f١٩٥٥٥c.get() == qd.c.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            qd.c.a(this.f١٩٥٥٥c);
            b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            qd.c.a(this.f١٩٥٥٥c);
            this.f١٩٥٥٣a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            lazySet(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٥٥٦d, cVar)) {
                this.f١٩٥٥٦d = cVar;
                this.f١٩٥٥٣a.onSubscribe(this);
                if (this.f١٩٥٥٥c.get() == null) {
                    this.f١٩٥٥٤b.subscribe(new d(this));
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class d implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        final c f١٩٥٥٧a;

        d(c cVar) {
            this.f١٩٥٥٧a = cVar;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٥٥٧a.a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٥٥٧a.d(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٥٥٧a.e();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f١٩٥٥٧a.f(cVar);
        }
    }

    public a3(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, boolean z10) {
        super(e0Var);
        this.f١٩٥٤٩b = e0Var2;
        this.f١٩٥٥٠c = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        he.e eVar = new he.e(g0Var);
        if (this.f١٩٥٥٠c) {
            this.f١٩٥٣٢a.subscribe(new a(eVar, this.f١٩٥٤٩b));
        } else {
            this.f١٩٥٣٢a.subscribe(new b(eVar, this.f١٩٥٤٩b));
        }
    }
}
