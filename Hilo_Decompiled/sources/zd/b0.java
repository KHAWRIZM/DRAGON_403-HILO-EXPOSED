package zd;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b0 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.c0 f١٩٥٧٢a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements io.reactivex.rxjava3.core.b0, nd.c {
        private static final long serialVersionUID = -3434801548987643227L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٥٧٣a;

        a(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f١٩٥٧٣a = g0Var;
        }

        @Override // io.reactivex.rxjava3.core.b0
        public void a(pd.f fVar) {
            c(new qd.b(fVar));
        }

        @Override // io.reactivex.rxjava3.core.b0
        public boolean b(Throwable th) {
            if (th == null) {
                th = fe.j.b("onError called with a null Throwable.");
            }
            if (!isDisposed()) {
                try {
                    this.f١٩٥٧٣a.onError(th);
                    dispose();
                    return true;
                } catch (Throwable th2) {
                    dispose();
                    throw th2;
                }
            }
            return false;
        }

        public void c(nd.c cVar) {
            qd.c.f(this, cVar);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
        }

        @Override // io.reactivex.rxjava3.core.b0, nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // io.reactivex.rxjava3.core.g
        public void onComplete() {
            if (!isDisposed()) {
                try {
                    this.f١٩٥٧٣a.onComplete();
                } finally {
                    dispose();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g
        public void onError(Throwable th) {
            if (!b(th)) {
                ie.a.s(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g
        public void onNext(Object obj) {
            if (obj == null) {
                onError(fe.j.b("onNext called with a null value."));
            } else if (!isDisposed()) {
                this.f١٩٥٧٣a.onNext(obj);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }
    }

    public b0(io.reactivex.rxjava3.core.c0 c0Var) {
        this.f١٩٥٧٢a = c0Var;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var);
        g0Var.onSubscribe(aVar);
        try {
            this.f١٩٥٧٢a.a(aVar);
        } catch (Throwable th) {
            od.b.b(th);
            aVar.onError(th);
        }
    }
}
