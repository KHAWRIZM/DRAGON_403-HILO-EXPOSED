package zd;

import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class i3 extends io.reactivex.rxjava3.core.i0 {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٨٧٩a;

    /* renamed from: b, reason: collision with root package name */
    final Object f١٩٨٨٠b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.k0 f١٩٨٨١a;

        /* renamed from: b, reason: collision with root package name */
        final Object f١٩٨٨٢b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٨٨٣c;

        /* renamed from: d, reason: collision with root package name */
        Object f١٩٨٨٤d;

        /* renamed from: e, reason: collision with root package name */
        boolean f١٩٨٨٥e;

        a(io.reactivex.rxjava3.core.k0 k0Var, Object obj) {
            this.f١٩٨٨١a = k0Var;
            this.f١٩٨٨٢b = obj;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٨٨٣c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٨٨٣c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٨٨٥e) {
                return;
            }
            this.f١٩٨٨٥e = true;
            Object obj = this.f١٩٨٨٤d;
            this.f١٩٨٨٤d = null;
            if (obj == null) {
                obj = this.f١٩٨٨٢b;
            }
            if (obj != null) {
                this.f١٩٨٨١a.onSuccess(obj);
            } else {
                this.f١٩٨٨١a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٨٨٥e) {
                ie.a.s(th);
            } else {
                this.f١٩٨٨٥e = true;
                this.f١٩٨٨١a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٨٨٥e) {
                return;
            }
            if (this.f١٩٨٨٤d != null) {
                this.f١٩٨٨٥e = true;
                this.f١٩٨٨٣c.dispose();
                this.f١٩٨٨١a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f١٩٨٨٤d = obj;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٨٨٣c, cVar)) {
                this.f١٩٨٨٣c = cVar;
                this.f١٩٨٨١a.onSubscribe(this);
            }
        }
    }

    public i3(io.reactivex.rxjava3.core.e0 e0Var, Object obj) {
        this.f١٩٨٧٩a = e0Var;
        this.f١٩٨٨٠b = obj;
    }

    @Override // io.reactivex.rxjava3.core.i0
    public void o(io.reactivex.rxjava3.core.k0 k0Var) {
        this.f١٩٨٧٩a.subscribe(new a(k0Var, this.f١٩٨٨٠b));
    }
}
