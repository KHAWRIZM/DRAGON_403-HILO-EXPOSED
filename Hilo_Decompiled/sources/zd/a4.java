package zd;

import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a4 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f١٩٥٥٨b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f١٩٥٥٩c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٥٦٠a;

        /* renamed from: b, reason: collision with root package name */
        final TimeUnit f١٩٥٦١b;

        /* renamed from: c, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f١٩٥٦٢c;

        /* renamed from: d, reason: collision with root package name */
        long f١٩٥٦٣d;

        /* renamed from: e, reason: collision with root package name */
        nd.c f١٩٥٦٤e;

        a(io.reactivex.rxjava3.core.g0 g0Var, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
            this.f١٩٥٦٠a = g0Var;
            this.f١٩٥٦٢c = h0Var;
            this.f١٩٥٦١b = timeUnit;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٥٦٤e.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٥٦٤e.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٥٦٠a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٥٦٠a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            long now = this.f١٩٥٦٢c.now(this.f١٩٥٦١b);
            long j10 = this.f١٩٥٦٣d;
            this.f١٩٥٦٣d = now;
            this.f١٩٥٦٠a.onNext(new ke.b(obj, now - j10, this.f١٩٥٦١b));
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٥٦٤e, cVar)) {
                this.f١٩٥٦٤e = cVar;
                this.f١٩٥٦٣d = this.f١٩٥٦٢c.now(this.f١٩٥٦١b);
                this.f١٩٥٦٠a.onSubscribe(this);
            }
        }
    }

    public a4(io.reactivex.rxjava3.core.e0 e0Var, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
        super(e0Var);
        this.f١٩٥٥٨b = h0Var;
        this.f١٩٥٥٩c = timeUnit;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٥٥٩c, this.f١٩٥٥٨b));
    }
}
