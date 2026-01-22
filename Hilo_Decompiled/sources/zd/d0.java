package zd;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f١٩٦٥٩b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f١٩٦٦٠c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f١٩٦٦١d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends AtomicReference implements Runnable, nd.c {
        private static final long serialVersionUID = 6812032969491025141L;

        /* renamed from: a, reason: collision with root package name */
        final Object f١٩٦٦٢a;

        /* renamed from: b, reason: collision with root package name */
        final long f١٩٦٦٣b;

        /* renamed from: c, reason: collision with root package name */
        final b f١٩٦٦٤c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicBoolean f١٩٦٦٥d = new AtomicBoolean();

        a(Object obj, long j10, b bVar) {
            this.f١٩٦٦٢a = obj;
            this.f١٩٦٦٣b = j10;
            this.f١٩٦٦٤c = bVar;
        }

        public void a(nd.c cVar) {
            qd.c.d(this, cVar);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (get() == qd.c.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f١٩٦٦٥d.compareAndSet(false, true)) {
                this.f١٩٦٦٤c.a(this.f١٩٦٦٣b, this.f١٩٦٦٢a, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٦٦٦a;

        /* renamed from: b, reason: collision with root package name */
        final long f١٩٦٦٧b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f١٩٦٦٨c;

        /* renamed from: d, reason: collision with root package name */
        final h0.c f١٩٦٦٩d;

        /* renamed from: e, reason: collision with root package name */
        nd.c f١٩٦٧٠e;

        /* renamed from: f, reason: collision with root package name */
        nd.c f١٩٦٧١f;

        /* renamed from: g, reason: collision with root package name */
        volatile long f١٩٦٧٢g;

        /* renamed from: h, reason: collision with root package name */
        boolean f١٩٦٧٣h;

        b(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, h0.c cVar) {
            this.f١٩٦٦٦a = g0Var;
            this.f١٩٦٦٧b = j10;
            this.f١٩٦٦٨c = timeUnit;
            this.f١٩٦٦٩d = cVar;
        }

        void a(long j10, Object obj, a aVar) {
            if (j10 == this.f١٩٦٧٢g) {
                this.f١٩٦٦٦a.onNext(obj);
                aVar.dispose();
            }
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٦٧٠e.dispose();
            this.f١٩٦٦٩d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٦٦٩d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٦٧٣h) {
                return;
            }
            this.f١٩٦٧٣h = true;
            nd.c cVar = this.f١٩٦٧١f;
            if (cVar != null) {
                cVar.dispose();
            }
            a aVar = (a) cVar;
            if (aVar != null) {
                aVar.run();
            }
            this.f١٩٦٦٦a.onComplete();
            this.f١٩٦٦٩d.dispose();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٦٧٣h) {
                ie.a.s(th);
                return;
            }
            nd.c cVar = this.f١٩٦٧١f;
            if (cVar != null) {
                cVar.dispose();
            }
            this.f١٩٦٧٣h = true;
            this.f١٩٦٦٦a.onError(th);
            this.f١٩٦٦٩d.dispose();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٦٧٣h) {
                return;
            }
            long j10 = this.f١٩٦٧٢g + 1;
            this.f١٩٦٧٢g = j10;
            nd.c cVar = this.f١٩٦٧١f;
            if (cVar != null) {
                cVar.dispose();
            }
            a aVar = new a(obj, j10, this);
            this.f١٩٦٧١f = aVar;
            aVar.a(this.f١٩٦٦٩d.schedule(aVar, this.f١٩٦٦٧b, this.f١٩٦٦٨c));
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٦٧٠e, cVar)) {
                this.f١٩٦٧٠e = cVar;
                this.f١٩٦٦٦a.onSubscribe(this);
            }
        }
    }

    public d0(io.reactivex.rxjava3.core.e0 e0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
        super(e0Var);
        this.f١٩٦٥٩b = j10;
        this.f١٩٦٦٠c = timeUnit;
        this.f١٩٦٦١d = h0Var;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new b(new he.e(g0Var), this.f١٩٦٥٩b, this.f١٩٦٦٠c, this.f١٩٦٦١d.createWorker()));
    }
}
