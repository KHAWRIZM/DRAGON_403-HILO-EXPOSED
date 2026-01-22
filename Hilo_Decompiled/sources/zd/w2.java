package zd;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class w2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.d f٢٠٧٠٩b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٧١٠a;

        /* renamed from: b, reason: collision with root package name */
        final qd.f f٢٠٧١١b;

        /* renamed from: c, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f٢٠٧١٢c;

        /* renamed from: d, reason: collision with root package name */
        final pd.d f٢٠٧١٣d;

        /* renamed from: e, reason: collision with root package name */
        int f٢٠٧١٤e;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.d dVar, qd.f fVar, io.reactivex.rxjava3.core.e0 e0Var) {
            this.f٢٠٧١٠a = g0Var;
            this.f٢٠٧١١b = fVar;
            this.f٢٠٧١٢c = e0Var;
            this.f٢٠٧١٣d = dVar;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i10 = 1;
                while (!this.f٢٠٧١١b.isDisposed()) {
                    this.f٢٠٧١٢c.subscribe(this);
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٧١٠a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            try {
                pd.d dVar = this.f٢٠٧١٣d;
                int i10 = this.f٢٠٧١٤e + 1;
                this.f٢٠٧١٤e = i10;
                if (!dVar.a(Integer.valueOf(i10), th)) {
                    this.f٢٠٧١٠a.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                od.b.b(th2);
                this.f٢٠٧١٠a.onError(new od.a(th, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٧١٠a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f٢٠٧١١b.a(cVar);
        }
    }

    public w2(io.reactivex.rxjava3.core.z zVar, pd.d dVar) {
        super(zVar);
        this.f٢٠٧٠٩b = dVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        qd.f fVar = new qd.f();
        g0Var.onSubscribe(fVar);
        new a(g0Var, this.f٢٠٧٠٩b, fVar, this.f١٩٥٣٢a).a();
    }
}
