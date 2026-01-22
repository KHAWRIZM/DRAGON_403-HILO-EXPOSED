package zd;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class y extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.m0 f٢٠٧٥٣b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.k0, nd.c {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٧٥٤a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.rxjava3.core.m0 f٢٠٧٥٥b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٢٠٧٥٦c;

        a(io.reactivex.rxjava3.core.g0 g0Var, io.reactivex.rxjava3.core.m0 m0Var) {
            this.f٢٠٧٥٤a = g0Var;
            this.f٢٠٧٥٥b = m0Var;
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
            this.f٢٠٧٥٦c = true;
            qd.c.d(this, null);
            io.reactivex.rxjava3.core.m0 m0Var = this.f٢٠٧٥٥b;
            this.f٢٠٧٥٥b = null;
            m0Var.a(this);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٧٥٤a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٧٥٤a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.g(this, cVar) && !this.f٢٠٧٥٦c) {
                this.f٢٠٧٥٤a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSuccess(Object obj) {
            this.f٢٠٧٥٤a.onNext(obj);
            this.f٢٠٧٥٤a.onComplete();
        }
    }

    public y(io.reactivex.rxjava3.core.z zVar, io.reactivex.rxjava3.core.m0 m0Var) {
        super(zVar);
        this.f٢٠٧٥٣b = m0Var;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٧٥٣b));
    }
}
