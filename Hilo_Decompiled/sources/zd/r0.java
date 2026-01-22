package zd;

import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class r0 extends io.reactivex.rxjava3.core.i0 implements sd.d {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٣٨٤a;

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٣٨٥b;

    /* renamed from: c, reason: collision with root package name */
    final Object f٢٠٣٨٦c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.k0 f٢٠٣٨٧a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٣٨٨b;

        /* renamed from: c, reason: collision with root package name */
        final Object f٢٠٣٨٩c;

        /* renamed from: d, reason: collision with root package name */
        nd.c f٢٠٣٩٠d;

        /* renamed from: e, reason: collision with root package name */
        long f٢٠٣٩١e;

        /* renamed from: f, reason: collision with root package name */
        boolean f٢٠٣٩٢f;

        a(io.reactivex.rxjava3.core.k0 k0Var, long j10, Object obj) {
            this.f٢٠٣٨٧a = k0Var;
            this.f٢٠٣٨٨b = j10;
            this.f٢٠٣٨٩c = obj;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٣٩٠d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٣٩٠d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f٢٠٣٩٢f) {
                this.f٢٠٣٩٢f = true;
                Object obj = this.f٢٠٣٨٩c;
                if (obj != null) {
                    this.f٢٠٣٨٧a.onSuccess(obj);
                } else {
                    this.f٢٠٣٨٧a.onError(new NoSuchElementException());
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٣٩٢f) {
                ie.a.s(th);
            } else {
                this.f٢٠٣٩٢f = true;
                this.f٢٠٣٨٧a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٣٩٢f) {
                return;
            }
            long j10 = this.f٢٠٣٩١e;
            if (j10 == this.f٢٠٣٨٨b) {
                this.f٢٠٣٩٢f = true;
                this.f٢٠٣٩٠d.dispose();
                this.f٢٠٣٨٧a.onSuccess(obj);
                return;
            }
            this.f٢٠٣٩١e = j10 + 1;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٣٩٠d, cVar)) {
                this.f٢٠٣٩٠d = cVar;
                this.f٢٠٣٨٧a.onSubscribe(this);
            }
        }
    }

    public r0(io.reactivex.rxjava3.core.e0 e0Var, long j10, Object obj) {
        this.f٢٠٣٨٤a = e0Var;
        this.f٢٠٣٨٥b = j10;
        this.f٢٠٣٨٦c = obj;
    }

    @Override // sd.d
    public io.reactivex.rxjava3.core.z b() {
        return ie.a.o(new p0(this.f٢٠٣٨٤a, this.f٢٠٣٨٥b, this.f٢٠٣٨٦c, true));
    }

    @Override // io.reactivex.rxjava3.core.i0
    public void o(io.reactivex.rxjava3.core.k0 k0Var) {
        this.f٢٠٣٨٤a.subscribe(new a(k0Var, this.f٢٠٣٨٥b, this.f٢٠٣٨٦c));
    }
}
