package zd;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class x extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.n f٢٠٧٢٠b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, nd.c {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٧٢١a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.rxjava3.core.n f٢٠٧٢٢b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٢٠٧٢٣c;

        a(io.reactivex.rxjava3.core.g0 g0Var, io.reactivex.rxjava3.core.n nVar) {
            this.f٢٠٧٢١a = g0Var;
            this.f٢٠٧٢٢b = nVar;
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
            if (this.f٢٠٧٢٣c) {
                this.f٢٠٧٢١a.onComplete();
                return;
            }
            this.f٢٠٧٢٣c = true;
            qd.c.d(this, null);
            io.reactivex.rxjava3.core.n nVar = this.f٢٠٧٢٢b;
            this.f٢٠٧٢٢b = null;
            nVar.a(this);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٧٢١a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٧٢١a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.g(this, cVar) && !this.f٢٠٧٢٣c) {
                this.f٢٠٧٢١a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSuccess(Object obj) {
            this.f٢٠٧٢١a.onNext(obj);
            this.f٢٠٧٢١a.onComplete();
        }
    }

    public x(io.reactivex.rxjava3.core.z zVar, io.reactivex.rxjava3.core.n nVar) {
        super(zVar);
        this.f٢٠٧٢٠b = nVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٧٢٠b));
    }
}
