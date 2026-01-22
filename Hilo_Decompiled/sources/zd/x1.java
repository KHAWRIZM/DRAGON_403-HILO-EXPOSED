package zd;

import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class x1 extends io.reactivex.rxjava3.core.i0 {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٧٣٥a;

    /* renamed from: b, reason: collision with root package name */
    final Object f٢٠٧٣٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.k0 f٢٠٧٣٧a;

        /* renamed from: b, reason: collision with root package name */
        final Object f٢٠٧٣٨b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f٢٠٧٣٩c;

        /* renamed from: d, reason: collision with root package name */
        Object f٢٠٧٤٠d;

        a(io.reactivex.rxjava3.core.k0 k0Var, Object obj) {
            this.f٢٠٧٣٧a = k0Var;
            this.f٢٠٧٣٨b = obj;
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٧٣٩c.dispose();
            this.f٢٠٧٣٩c = qd.c.DISPOSED;
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (this.f٢٠٧٣٩c == qd.c.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٧٣٩c = qd.c.DISPOSED;
            Object obj = this.f٢٠٧٤٠d;
            if (obj != null) {
                this.f٢٠٧٤٠d = null;
                this.f٢٠٧٣٧a.onSuccess(obj);
                return;
            }
            Object obj2 = this.f٢٠٧٣٨b;
            if (obj2 != null) {
                this.f٢٠٧٣٧a.onSuccess(obj2);
            } else {
                this.f٢٠٧٣٧a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٧٣٩c = qd.c.DISPOSED;
            this.f٢٠٧٤٠d = null;
            this.f٢٠٧٣٧a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٧٤٠d = obj;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٧٣٩c, cVar)) {
                this.f٢٠٧٣٩c = cVar;
                this.f٢٠٧٣٧a.onSubscribe(this);
            }
        }
    }

    public x1(io.reactivex.rxjava3.core.e0 e0Var, Object obj) {
        this.f٢٠٧٣٥a = e0Var;
        this.f٢٠٧٣٦b = obj;
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(io.reactivex.rxjava3.core.k0 k0Var) {
        this.f٢٠٧٣٥a.subscribe(new a(k0Var, this.f٢٠٧٣٦b));
    }
}
