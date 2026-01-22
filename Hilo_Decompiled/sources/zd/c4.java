package zd;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c4 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f١٩٦٣٢b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f١٩٦٣٣c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f١٩٦٣٤d;

    /* renamed from: e, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٦٣٥e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٦٣٦a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference f١٩٦٣٧b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(io.reactivex.rxjava3.core.g0 g0Var, AtomicReference atomicReference) {
            this.f١٩٦٣٦a = g0Var;
            this.f١٩٦٣٧b = atomicReference;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٦٣٦a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٦٣٦a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٦٣٦a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.d(this.f١٩٦٣٧b, cVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c, d {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٦٣٨a;

        /* renamed from: b, reason: collision with root package name */
        final long f١٩٦٣٩b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f١٩٦٤٠c;

        /* renamed from: d, reason: collision with root package name */
        final h0.c f١٩٦٤١d;

        /* renamed from: e, reason: collision with root package name */
        final qd.f f١٩٦٤٢e = new qd.f();

        /* renamed from: f, reason: collision with root package name */
        final AtomicLong f١٩٦٤٣f = new AtomicLong();

        /* renamed from: g, reason: collision with root package name */
        final AtomicReference f١٩٦٤٤g = new AtomicReference();

        /* renamed from: h, reason: collision with root package name */
        io.reactivex.rxjava3.core.e0 f١٩٦٤٥h;

        b(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, h0.c cVar, io.reactivex.rxjava3.core.e0 e0Var) {
            this.f١٩٦٣٨a = g0Var;
            this.f١٩٦٣٩b = j10;
            this.f١٩٦٤٠c = timeUnit;
            this.f١٩٦٤١d = cVar;
            this.f١٩٦٤٥h = e0Var;
        }

        @Override // zd.c4.d
        public void b(long j10) {
            if (this.f١٩٦٤٣f.compareAndSet(j10, LongCompanionObject.MAX_VALUE)) {
                qd.c.a(this.f١٩٦٤٤g);
                io.reactivex.rxjava3.core.e0 e0Var = this.f١٩٦٤٥h;
                this.f١٩٦٤٥h = null;
                e0Var.subscribe(new a(this.f١٩٦٣٨a, this));
                this.f١٩٦٤١d.dispose();
            }
        }

        void c(long j10) {
            this.f١٩٦٤٢e.a(this.f١٩٦٤١d.schedule(new e(j10, this), this.f١٩٦٣٩b, this.f١٩٦٤٠c));
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f١٩٦٤٤g);
            qd.c.a(this);
            this.f١٩٦٤١d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٦٤٣f.getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.f١٩٦٤٢e.dispose();
                this.f١٩٦٣٨a.onComplete();
                this.f١٩٦٤١d.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٦٤٣f.getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.f١٩٦٤٢e.dispose();
                this.f١٩٦٣٨a.onError(th);
                this.f١٩٦٤١d.dispose();
                return;
            }
            ie.a.s(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            long j10 = this.f١٩٦٤٣f.get();
            if (j10 != LongCompanionObject.MAX_VALUE) {
                long j11 = 1 + j10;
                if (this.f١٩٦٤٣f.compareAndSet(j10, j11)) {
                    ((nd.c) this.f١٩٦٤٢e.get()).dispose();
                    this.f١٩٦٣٨a.onNext(obj);
                    c(j11);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f١٩٦٤٤g, cVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class c extends AtomicLong implements io.reactivex.rxjava3.core.g0, nd.c, d {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٦٤٦a;

        /* renamed from: b, reason: collision with root package name */
        final long f١٩٦٤٧b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f١٩٦٤٨c;

        /* renamed from: d, reason: collision with root package name */
        final h0.c f١٩٦٤٩d;

        /* renamed from: e, reason: collision with root package name */
        final qd.f f١٩٦٥٠e = new qd.f();

        /* renamed from: f, reason: collision with root package name */
        final AtomicReference f١٩٦٥١f = new AtomicReference();

        c(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, h0.c cVar) {
            this.f١٩٦٤٦a = g0Var;
            this.f١٩٦٤٧b = j10;
            this.f١٩٦٤٨c = timeUnit;
            this.f١٩٦٤٩d = cVar;
        }

        @Override // zd.c4.d
        public void b(long j10) {
            if (compareAndSet(j10, LongCompanionObject.MAX_VALUE)) {
                qd.c.a(this.f١٩٦٥١f);
                this.f١٩٦٤٦a.onError(new TimeoutException(fe.j.f(this.f١٩٦٤٧b, this.f١٩٦٤٨c)));
                this.f١٩٦٤٩d.dispose();
            }
        }

        void c(long j10) {
            this.f١٩٦٥٠e.a(this.f١٩٦٤٩d.schedule(new e(j10, this), this.f١٩٦٤٧b, this.f١٩٦٤٨c));
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f١٩٦٥١f);
            this.f١٩٦٤٩d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) this.f١٩٦٥١f.get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.f١٩٦٥٠e.dispose();
                this.f١٩٦٤٦a.onComplete();
                this.f١٩٦٤٩d.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.f١٩٦٥٠e.dispose();
                this.f١٩٦٤٦a.onError(th);
                this.f١٩٦٤٩d.dispose();
                return;
            }
            ie.a.s(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            long j10 = get();
            if (j10 != LongCompanionObject.MAX_VALUE) {
                long j11 = 1 + j10;
                if (compareAndSet(j10, j11)) {
                    ((nd.c) this.f١٩٦٥٠e.get()).dispose();
                    this.f١٩٦٤٦a.onNext(obj);
                    c(j11);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f١٩٦٥١f, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface d {
        void b(long j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final d f١٩٦٥٢a;

        /* renamed from: b, reason: collision with root package name */
        final long f١٩٦٥٣b;

        e(long j10, d dVar) {
            this.f١٩٦٥٣b = j10;
            this.f١٩٦٥٢a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f١٩٦٥٢a.b(this.f١٩٦٥٣b);
        }
    }

    public c4(io.reactivex.rxjava3.core.z zVar, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, io.reactivex.rxjava3.core.e0 e0Var) {
        super(zVar);
        this.f١٩٦٣٢b = j10;
        this.f١٩٦٣٣c = timeUnit;
        this.f١٩٦٣٤d = h0Var;
        this.f١٩٦٣٥e = e0Var;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        if (this.f١٩٦٣٥e == null) {
            c cVar = new c(g0Var, this.f١٩٦٣٢b, this.f١٩٦٣٣c, this.f١٩٦٣٤d.createWorker());
            g0Var.onSubscribe(cVar);
            cVar.c(0L);
            this.f١٩٥٣٢a.subscribe(cVar);
            return;
        }
        b bVar = new b(g0Var, this.f١٩٦٣٢b, this.f١٩٦٣٣c, this.f١٩٦٣٤d.createWorker(), this.f١٩٦٣٥e);
        g0Var.onSubscribe(bVar);
        bVar.c(0L);
        this.f١٩٥٣٢a.subscribe(bVar);
    }
}
