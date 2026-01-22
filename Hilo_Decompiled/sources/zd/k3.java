package zd;

import java.util.ArrayDeque;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class k3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final int f١٩٩٥٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ArrayDeque implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -3807491841935125653L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٩٥٧a;

        /* renamed from: b, reason: collision with root package name */
        final int f١٩٩٥٨b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٩٥٩c;

        a(io.reactivex.rxjava3.core.g0 g0Var, int i10) {
            super(i10);
            this.f١٩٩٥٧a = g0Var;
            this.f١٩٩٥٨b = i10;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٩٥٩c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٩٥٩c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٩٥٧a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٩٩٥٧a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٩٥٨b == size()) {
                this.f١٩٩٥٧a.onNext(poll());
            }
            offer(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٩٥٩c, cVar)) {
                this.f١٩٩٥٩c = cVar;
                this.f١٩٩٥٧a.onSubscribe(this);
            }
        }
    }

    public k3(io.reactivex.rxjava3.core.e0 e0Var, int i10) {
        super(e0Var);
        this.f١٩٩٥٦b = i10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٩٥٦b));
    }
}
