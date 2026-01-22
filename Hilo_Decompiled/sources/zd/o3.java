package zd;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class o3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠٢٥١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 8094547886072529208L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٢٥٢a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference f٢٠٢٥٣b = new AtomicReference();

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٢٥٢a = g0Var;
        }

        void a(nd.c cVar) {
            qd.c.g(this, cVar);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f٢٠٢٥٣b);
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٢٥٢a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٢٥٢a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٢٥٢a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f٢٠٢٥٣b, cVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final a f٢٠٢٥٤a;

        b(a aVar) {
            this.f٢٠٢٥٤a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o3.this.f١٩٥٣٢a.subscribe(this.f٢٠٢٥٤a);
        }
    }

    public o3(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.h0 h0Var) {
        super(e0Var);
        this.f٢٠٢٥١b = h0Var;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var);
        g0Var.onSubscribe(aVar);
        aVar.a(this.f٢٠٢٥١b.scheduleDirect(new b(aVar)));
    }
}
