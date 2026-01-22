package zd;

import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class p0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٢٨٩b;

    /* renamed from: c, reason: collision with root package name */
    final Object f٢٠٢٩٠c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f٢٠٢٩١d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٢٩٢a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٢٩٣b;

        /* renamed from: c, reason: collision with root package name */
        final Object f٢٠٢٩٤c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f٢٠٢٩٥d;

        /* renamed from: e, reason: collision with root package name */
        nd.c f٢٠٢٩٦e;

        /* renamed from: f, reason: collision with root package name */
        long f٢٠٢٩٧f;

        /* renamed from: g, reason: collision with root package name */
        boolean f٢٠٢٩٨g;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, Object obj, boolean z10) {
            this.f٢٠٢٩٢a = g0Var;
            this.f٢٠٢٩٣b = j10;
            this.f٢٠٢٩٤c = obj;
            this.f٢٠٢٩٥d = z10;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٢٩٦e.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٢٩٦e.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f٢٠٢٩٨g) {
                this.f٢٠٢٩٨g = true;
                Object obj = this.f٢٠٢٩٤c;
                if (obj == null && this.f٢٠٢٩٥d) {
                    this.f٢٠٢٩٢a.onError(new NoSuchElementException());
                    return;
                }
                if (obj != null) {
                    this.f٢٠٢٩٢a.onNext(obj);
                }
                this.f٢٠٢٩٢a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٢٩٨g) {
                ie.a.s(th);
            } else {
                this.f٢٠٢٩٨g = true;
                this.f٢٠٢٩٢a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٢٩٨g) {
                return;
            }
            long j10 = this.f٢٠٢٩٧f;
            if (j10 == this.f٢٠٢٩٣b) {
                this.f٢٠٢٩٨g = true;
                this.f٢٠٢٩٦e.dispose();
                this.f٢٠٢٩٢a.onNext(obj);
                this.f٢٠٢٩٢a.onComplete();
                return;
            }
            this.f٢٠٢٩٧f = j10 + 1;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٢٩٦e, cVar)) {
                this.f٢٠٢٩٦e = cVar;
                this.f٢٠٢٩٢a.onSubscribe(this);
            }
        }
    }

    public p0(io.reactivex.rxjava3.core.e0 e0Var, long j10, Object obj, boolean z10) {
        super(e0Var);
        this.f٢٠٢٨٩b = j10;
        this.f٢٠٢٩٠c = obj;
        this.f٢٠٢٩١d = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٢٨٩b, this.f٢٠٢٩٠c, this.f٢٠٢٩١d));
    }
}
