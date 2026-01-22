package zd;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class g4 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f١٩٨٢٥b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicBoolean implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 1015244841293359600L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٢٦a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f١٩٨٢٧b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٨٢٨c;

        /* renamed from: zd.g4$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class RunnableC٠٢٦٥a implements Runnable {
            RunnableC٠٢٦٥a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f١٩٨٢٨c.dispose();
            }
        }

        a(io.reactivex.rxjava3.core.g0 g0Var, io.reactivex.rxjava3.core.h0 h0Var) {
            this.f١٩٨٢٦a = g0Var;
            this.f١٩٨٢٧b = h0Var;
        }

        @Override // nd.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f١٩٨٢٧b.scheduleDirect(new RunnableC٠٢٦٥a());
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!get()) {
                this.f١٩٨٢٦a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (get()) {
                ie.a.s(th);
            } else {
                this.f١٩٨٢٦a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (!get()) {
                this.f١٩٨٢٦a.onNext(obj);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٨٢٨c, cVar)) {
                this.f١٩٨٢٨c = cVar;
                this.f١٩٨٢٦a.onSubscribe(this);
            }
        }
    }

    public g4(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.h0 h0Var) {
        super(e0Var);
        this.f١٩٨٢٥b = h0Var;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٨٢٥b));
    }
}
