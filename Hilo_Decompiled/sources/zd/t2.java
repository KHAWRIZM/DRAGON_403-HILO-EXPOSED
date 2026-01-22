package zd;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class t2 extends zd.a {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٥١٥a;

        /* renamed from: b, reason: collision with root package name */
        final qd.f f٢٠٥١٦b;

        /* renamed from: c, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f٢٠٥١٧c;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.e eVar, qd.f fVar, io.reactivex.rxjava3.core.e0 e0Var) {
            this.f٢٠٥١٥a = g0Var;
            this.f٢٠٥١٦b = fVar;
            this.f٢٠٥١٧c = e0Var;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i10 = 1;
                do {
                    this.f٢٠٥١٧c.subscribe(this);
                    i10 = addAndGet(-i10);
                } while (i10 != 0);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            try {
                throw null;
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠٥١٥a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٥١٥a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٥١٥a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f٢٠٥١٦b.a(cVar);
        }
    }

    public t2(io.reactivex.rxjava3.core.z zVar, pd.e eVar) {
        super(zVar);
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        qd.f fVar = new qd.f();
        g0Var.onSubscribe(fVar);
        new a(g0Var, null, fVar, this.f١٩٥٣٢a).a();
    }
}
