package zd;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class f0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f١٩٧٤٩b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f١٩٧٥٠c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f١٩٧٥١d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f١٩٧٥٢e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٧٥٣a;

        /* renamed from: b, reason: collision with root package name */
        final long f١٩٧٥٤b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f١٩٧٥٥c;

        /* renamed from: d, reason: collision with root package name */
        final h0.c f١٩٧٥٦d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f١٩٧٥٧e;

        /* renamed from: f, reason: collision with root package name */
        nd.c f١٩٧٥٨f;

        /* renamed from: zd.f0$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class RunnableC٠٢٦٣a implements Runnable {
            RunnableC٠٢٦٣a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f١٩٧٥٣a.onComplete();
                } finally {
                    a.this.f١٩٧٥٦d.dispose();
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final Throwable f١٩٧٦٠a;

            b(Throwable th) {
                this.f١٩٧٦٠a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f١٩٧٥٣a.onError(this.f١٩٧٦٠a);
                } finally {
                    a.this.f١٩٧٥٦d.dispose();
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final Object f١٩٧٦٢a;

            c(Object obj) {
                this.f١٩٧٦٢a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f١٩٧٥٣a.onNext(this.f١٩٧٦٢a);
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, h0.c cVar, boolean z10) {
            this.f١٩٧٥٣a = g0Var;
            this.f١٩٧٥٤b = j10;
            this.f١٩٧٥٥c = timeUnit;
            this.f١٩٧٥٦d = cVar;
            this.f١٩٧٥٧e = z10;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٧٥٨f.dispose();
            this.f١٩٧٥٦d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٧٥٦d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٧٥٦d.schedule(new RunnableC٠٢٦٣a(), this.f١٩٧٥٤b, this.f١٩٧٥٥c);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            long j10;
            h0.c cVar = this.f١٩٧٥٦d;
            b bVar = new b(th);
            if (this.f١٩٧٥٧e) {
                j10 = this.f١٩٧٥٤b;
            } else {
                j10 = 0;
            }
            cVar.schedule(bVar, j10, this.f١٩٧٥٥c);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٩٧٥٦d.schedule(new c(obj), this.f١٩٧٥٤b, this.f١٩٧٥٥c);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٧٥٨f, cVar)) {
                this.f١٩٧٥٨f = cVar;
                this.f١٩٧٥٣a.onSubscribe(this);
            }
        }
    }

    public f0(io.reactivex.rxjava3.core.e0 e0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, boolean z10) {
        super(e0Var);
        this.f١٩٧٤٩b = j10;
        this.f١٩٧٥٠c = timeUnit;
        this.f١٩٧٥١d = h0Var;
        this.f١٩٧٥٢e = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        io.reactivex.rxjava3.core.g0 eVar;
        if (this.f١٩٧٥٢e) {
            eVar = g0Var;
        } else {
            eVar = new he.e(g0Var);
        }
        this.f١٩٥٣٢a.subscribe(new a(eVar, this.f١٩٧٤٩b, this.f١٩٧٥٠c, this.f١٩٧٥١d.createWorker(), this.f١٩٧٥٢e));
    }
}
