package zd;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class r2 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final ge.a f٢٠٤١٩a;

    /* renamed from: b, reason: collision with root package name */
    final int f٢٠٤٢٠b;

    /* renamed from: c, reason: collision with root package name */
    final long f٢٠٤٢١c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f٢٠٤٢٢d;

    /* renamed from: e, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠٤٢٣e;

    /* renamed from: f, reason: collision with root package name */
    a f٢٠٤٢٤f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends AtomicReference implements Runnable, pd.g {
        private static final long serialVersionUID = -4552101107598366241L;

        /* renamed from: a, reason: collision with root package name */
        final r2 f٢٠٤٢٥a;

        /* renamed from: b, reason: collision with root package name */
        nd.c f٢٠٤٢٦b;

        /* renamed from: c, reason: collision with root package name */
        long f٢٠٤٢٧c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٢٠٤٢٨d;

        /* renamed from: e, reason: collision with root package name */
        boolean f٢٠٤٢٩e;

        a(r2 r2Var) {
            this.f٢٠٤٢٥a = r2Var;
        }

        @Override // pd.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(nd.c cVar) {
            qd.c.d(this, cVar);
            synchronized (this.f٢٠٤٢٥a) {
                try {
                    if (this.f٢٠٤٢٩e) {
                        this.f٢٠٤٢٥a.f٢٠٤١٩a.f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f٢٠٤٢٥a.f(this);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicBoolean implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -7419642935409022375L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٤٣٠a;

        /* renamed from: b, reason: collision with root package name */
        final r2 f٢٠٤٣١b;

        /* renamed from: c, reason: collision with root package name */
        final a f٢٠٤٣٢c;

        /* renamed from: d, reason: collision with root package name */
        nd.c f٢٠٤٣٣d;

        b(io.reactivex.rxjava3.core.g0 g0Var, r2 r2Var, a aVar) {
            this.f٢٠٤٣٠a = g0Var;
            this.f٢٠٤٣١b = r2Var;
            this.f٢٠٤٣٢c = aVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٤٣٣d.dispose();
            if (compareAndSet(false, true)) {
                this.f٢٠٤٣١b.d(this.f٢٠٤٣٢c);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٤٣٣d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f٢٠٤٣١b.e(this.f٢٠٤٣٢c);
                this.f٢٠٤٣٠a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f٢٠٤٣١b.e(this.f٢٠٤٣٢c);
                this.f٢٠٤٣٠a.onError(th);
            } else {
                ie.a.s(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٤٣٠a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٤٣٣d, cVar)) {
                this.f٢٠٤٣٣d = cVar;
                this.f٢٠٤٣٠a.onSubscribe(this);
            }
        }
    }

    public r2(ge.a aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    void d(a aVar) {
        synchronized (this) {
            try {
                a aVar2 = this.f٢٠٤٢٤f;
                if (aVar2 != null && aVar2 == aVar) {
                    long j10 = aVar.f٢٠٤٢٧c - 1;
                    aVar.f٢٠٤٢٧c = j10;
                    if (j10 == 0 && aVar.f٢٠٤٢٨d) {
                        if (this.f٢٠٤٢١c == 0) {
                            f(aVar);
                            return;
                        }
                        qd.f fVar = new qd.f();
                        aVar.f٢٠٤٢٦b = fVar;
                        fVar.a(this.f٢٠٤٢٣e.scheduleDirect(aVar, this.f٢٠٤٢١c, this.f٢٠٤٢٢d));
                    }
                }
            } finally {
            }
        }
    }

    void e(a aVar) {
        synchronized (this) {
            try {
                if (this.f٢٠٤٢٤f == aVar) {
                    nd.c cVar = aVar.f٢٠٤٢٦b;
                    if (cVar != null) {
                        cVar.dispose();
                        aVar.f٢٠٤٢٦b = null;
                    }
                    long j10 = aVar.f٢٠٤٢٧c - 1;
                    aVar.f٢٠٤٢٧c = j10;
                    if (j10 == 0) {
                        this.f٢٠٤٢٤f = null;
                        this.f٢٠٤١٩a.f();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void f(a aVar) {
        synchronized (this) {
            try {
                if (aVar.f٢٠٤٢٧c == 0 && aVar == this.f٢٠٤٢٤f) {
                    this.f٢٠٤٢٤f = null;
                    nd.c cVar = (nd.c) aVar.get();
                    qd.c.a(aVar);
                    if (cVar == null) {
                        aVar.f٢٠٤٢٩e = true;
                    } else {
                        this.f٢٠٤١٩a.f();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar;
        boolean z10;
        nd.c cVar;
        synchronized (this) {
            try {
                aVar = this.f٢٠٤٢٤f;
                if (aVar == null) {
                    aVar = new a(this);
                    this.f٢٠٤٢٤f = aVar;
                }
                long j10 = aVar.f٢٠٤٢٧c;
                if (j10 == 0 && (cVar = aVar.f٢٠٤٢٦b) != null) {
                    cVar.dispose();
                }
                long j11 = j10 + 1;
                aVar.f٢٠٤٢٧c = j11;
                if (!aVar.f٢٠٤٢٨d && j11 == this.f٢٠٤٢٠b) {
                    z10 = true;
                    aVar.f٢٠٤٢٨d = true;
                } else {
                    z10 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f٢٠٤١٩a.subscribe(new b(g0Var, this, aVar));
        if (z10) {
            this.f٢٠٤١٩a.d(aVar);
        }
    }

    public r2(ge.a aVar, int i10, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
        this.f٢٠٤١٩a = aVar;
        this.f٢٠٤٢٠b = i10;
        this.f٢٠٤٢١c = j10;
        this.f٢٠٤٢٢d = timeUnit;
        this.f٢٠٤٢٣e = h0Var;
    }
}
