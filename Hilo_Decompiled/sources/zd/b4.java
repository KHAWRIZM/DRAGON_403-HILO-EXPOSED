package zd;

import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import zd.c4;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b4 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٥٨١b;

    /* renamed from: c, reason: collision with root package name */
    final pd.o f١٩٥٨٢c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٥٨٣d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 8708641127342403073L;

        /* renamed from: a, reason: collision with root package name */
        final d f١٩٥٨٤a;

        /* renamed from: b, reason: collision with root package name */
        final long f١٩٥٨٥b;

        a(long j10, d dVar) {
            this.f١٩٥٨٥b = j10;
            this.f١٩٥٨٤a = dVar;
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            Object obj = get();
            qd.c cVar = qd.c.DISPOSED;
            if (obj != cVar) {
                lazySet(cVar);
                this.f١٩٥٨٤a.b(this.f١٩٥٨٥b);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            Object obj = get();
            qd.c cVar = qd.c.DISPOSED;
            if (obj != cVar) {
                lazySet(cVar);
                this.f١٩٥٨٤a.a(this.f١٩٥٨٥b, th);
            } else {
                ie.a.s(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            nd.c cVar = (nd.c) get();
            qd.c cVar2 = qd.c.DISPOSED;
            if (cVar != cVar2) {
                cVar.dispose();
                lazySet(cVar2);
                this.f١٩٥٨٤a.b(this.f١٩٥٨٥b);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this, cVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c, d {
        private static final long serialVersionUID = -7508389464265974549L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٥٨٦a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f١٩٥٨٧b;

        /* renamed from: c, reason: collision with root package name */
        final qd.f f١٩٥٨٨c = new qd.f();

        /* renamed from: d, reason: collision with root package name */
        final AtomicLong f١٩٥٨٩d = new AtomicLong();

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference f١٩٥٩٠e = new AtomicReference();

        /* renamed from: f, reason: collision with root package name */
        io.reactivex.rxjava3.core.e0 f١٩٥٩١f;

        b(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, io.reactivex.rxjava3.core.e0 e0Var) {
            this.f١٩٥٨٦a = g0Var;
            this.f١٩٥٨٧b = oVar;
            this.f١٩٥٩١f = e0Var;
        }

        @Override // zd.b4.d
        public void a(long j10, Throwable th) {
            if (this.f١٩٥٨٩d.compareAndSet(j10, LongCompanionObject.MAX_VALUE)) {
                qd.c.a(this);
                this.f١٩٥٨٦a.onError(th);
            } else {
                ie.a.s(th);
            }
        }

        @Override // zd.c4.d
        public void b(long j10) {
            if (this.f١٩٥٨٩d.compareAndSet(j10, LongCompanionObject.MAX_VALUE)) {
                qd.c.a(this.f١٩٥٩٠e);
                io.reactivex.rxjava3.core.e0 e0Var = this.f١٩٥٩١f;
                this.f١٩٥٩١f = null;
                e0Var.subscribe(new c4.a(this.f١٩٥٨٦a, this));
            }
        }

        void c(io.reactivex.rxjava3.core.e0 e0Var) {
            if (e0Var != null) {
                a aVar = new a(0L, this);
                if (this.f١٩٥٨٨c.a(aVar)) {
                    e0Var.subscribe(aVar);
                }
            }
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f١٩٥٩٠e);
            qd.c.a(this);
            this.f١٩٥٨٨c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٥٨٩d.getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.f١٩٥٨٨c.dispose();
                this.f١٩٥٨٦a.onComplete();
                this.f١٩٥٨٨c.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٥٨٩d.getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.f١٩٥٨٨c.dispose();
                this.f١٩٥٨٦a.onError(th);
                this.f١٩٥٨٨c.dispose();
                return;
            }
            ie.a.s(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            long j10 = this.f١٩٥٨٩d.get();
            if (j10 != LongCompanionObject.MAX_VALUE) {
                long j11 = 1 + j10;
                if (this.f١٩٥٨٩d.compareAndSet(j10, j11)) {
                    nd.c cVar = (nd.c) this.f١٩٥٨٨c.get();
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    this.f١٩٥٨٦a.onNext(obj);
                    try {
                        Object apply = this.f١٩٥٨٧b.apply(obj);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                        a aVar = new a(j11, this);
                        if (this.f١٩٥٨٨c.a(aVar)) {
                            e0Var.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        od.b.b(th);
                        ((nd.c) this.f١٩٥٩٠e.get()).dispose();
                        this.f١٩٥٨٩d.getAndSet(LongCompanionObject.MAX_VALUE);
                        this.f١٩٥٨٦a.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f١٩٥٩٠e, cVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class c extends AtomicLong implements io.reactivex.rxjava3.core.g0, nd.c, d {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٥٩٢a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f١٩٥٩٣b;

        /* renamed from: c, reason: collision with root package name */
        final qd.f f١٩٥٩٤c = new qd.f();

        /* renamed from: d, reason: collision with root package name */
        final AtomicReference f١٩٥٩٥d = new AtomicReference();

        c(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar) {
            this.f١٩٥٩٢a = g0Var;
            this.f١٩٥٩٣b = oVar;
        }

        @Override // zd.b4.d
        public void a(long j10, Throwable th) {
            if (compareAndSet(j10, LongCompanionObject.MAX_VALUE)) {
                qd.c.a(this.f١٩٥٩٥d);
                this.f١٩٥٩٢a.onError(th);
            } else {
                ie.a.s(th);
            }
        }

        @Override // zd.c4.d
        public void b(long j10) {
            if (compareAndSet(j10, LongCompanionObject.MAX_VALUE)) {
                qd.c.a(this.f١٩٥٩٥d);
                this.f١٩٥٩٢a.onError(new TimeoutException());
            }
        }

        void c(io.reactivex.rxjava3.core.e0 e0Var) {
            if (e0Var != null) {
                a aVar = new a(0L, this);
                if (this.f١٩٥٩٤c.a(aVar)) {
                    e0Var.subscribe(aVar);
                }
            }
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f١٩٥٩٥d);
            this.f١٩٥٩٤c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) this.f١٩٥٩٥d.get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.f١٩٥٩٤c.dispose();
                this.f١٩٥٩٢a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.f١٩٥٩٤c.dispose();
                this.f١٩٥٩٢a.onError(th);
            } else {
                ie.a.s(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            long j10 = get();
            if (j10 != LongCompanionObject.MAX_VALUE) {
                long j11 = 1 + j10;
                if (compareAndSet(j10, j11)) {
                    nd.c cVar = (nd.c) this.f١٩٥٩٤c.get();
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    this.f١٩٥٩٢a.onNext(obj);
                    try {
                        Object apply = this.f١٩٥٩٣b.apply(obj);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null ObservableSource.");
                        io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                        a aVar = new a(j11, this);
                        if (this.f١٩٥٩٤c.a(aVar)) {
                            e0Var.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        od.b.b(th);
                        ((nd.c) this.f١٩٥٩٥d.get()).dispose();
                        getAndSet(LongCompanionObject.MAX_VALUE);
                        this.f١٩٥٩٢a.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f١٩٥٩٥d, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface d extends c4.d {
        void a(long j10, Throwable th);
    }

    public b4(io.reactivex.rxjava3.core.z zVar, io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, io.reactivex.rxjava3.core.e0 e0Var2) {
        super(zVar);
        this.f١٩٥٨١b = e0Var;
        this.f١٩٥٨٢c = oVar;
        this.f١٩٥٨٣d = e0Var2;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        if (this.f١٩٥٨٣d == null) {
            c cVar = new c(g0Var, this.f١٩٥٨٢c);
            g0Var.onSubscribe(cVar);
            cVar.c(this.f١٩٥٨١b);
            this.f١٩٥٣٢a.subscribe(cVar);
            return;
        }
        b bVar = new b(g0Var, this.f١٩٥٨٢c, this.f١٩٥٨٣d);
        g0Var.onSubscribe(bVar);
        bVar.c(this.f١٩٥٨١b);
        this.f١٩٥٣٢a.subscribe(bVar);
    }
}
