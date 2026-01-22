package zd;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class w extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.f f٢٠٦٩١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.d, nd.c {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٦٩٢a;

        /* renamed from: b, reason: collision with root package name */
        io.reactivex.rxjava3.core.f f٢٠٦٩٣b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٢٠٦٩٤c;

        a(io.reactivex.rxjava3.core.g0 g0Var, io.reactivex.rxjava3.core.f fVar) {
            this.f٢٠٦٩٢a = g0Var;
            this.f٢٠٦٩٣b = fVar;
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
            if (this.f٢٠٦٩٤c) {
                this.f٢٠٦٩٢a.onComplete();
                return;
            }
            this.f٢٠٦٩٤c = true;
            qd.c.d(this, null);
            io.reactivex.rxjava3.core.f fVar = this.f٢٠٦٩٣b;
            this.f٢٠٦٩٣b = null;
            fVar.a(this);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٦٩٢a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٦٩٢a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.g(this, cVar) && !this.f٢٠٦٩٤c) {
                this.f٢٠٦٩٢a.onSubscribe(this);
            }
        }
    }

    public w(io.reactivex.rxjava3.core.z zVar, io.reactivex.rxjava3.core.f fVar) {
        super(zVar);
        this.f٢٠٦٩١b = fVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٦٩١b));
    }
}
