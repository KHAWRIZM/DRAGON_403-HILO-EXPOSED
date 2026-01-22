package vd;

import fe.j;
import io.reactivex.rxjava3.core.d;
import io.reactivex.rxjava3.core.e;
import java.util.concurrent.atomic.AtomicReference;
import pd.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a extends io.reactivex.rxjava3.core.b {

    /* renamed from: a, reason: collision with root package name */
    final e f١٨٦٢٨a;

    /* renamed from: vd.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class C٠٢٣٩a extends AtomicReference implements io.reactivex.rxjava3.core.c, nd.c {
        private static final long serialVersionUID = -2467358622224974244L;

        /* renamed from: a, reason: collision with root package name */
        final d f١٨٦٢٩a;

        C٠٢٣٩a(d dVar) {
            this.f١٨٦٢٩a = dVar;
        }

        @Override // io.reactivex.rxjava3.core.c
        public void a(f fVar) {
            d(new qd.b(fVar));
        }

        @Override // io.reactivex.rxjava3.core.c
        public boolean b(Throwable th) {
            nd.c cVar;
            if (th == null) {
                th = j.b("onError called with a null Throwable.");
            }
            Object obj = get();
            qd.c cVar2 = qd.c.DISPOSED;
            if (obj != cVar2 && (cVar = (nd.c) getAndSet(cVar2)) != cVar2) {
                try {
                    this.f١٨٦٢٩a.onError(th);
                } finally {
                    if (cVar != null) {
                        cVar.dispose();
                    }
                }
            }
            return false;
        }

        public void c(Throwable th) {
            if (!b(th)) {
                ie.a.s(th);
            }
        }

        public void d(nd.c cVar) {
            qd.c.f(this, cVar);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // io.reactivex.rxjava3.core.c
        public void onComplete() {
            nd.c cVar;
            Object obj = get();
            qd.c cVar2 = qd.c.DISPOSED;
            if (obj != cVar2 && (cVar = (nd.c) getAndSet(cVar2)) != cVar2) {
                try {
                    this.f١٨٦٢٩a.onComplete();
                } finally {
                    if (cVar != null) {
                        cVar.dispose();
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", C٠٢٣٩a.class.getSimpleName(), super.toString());
        }
    }

    public a(e eVar) {
        this.f١٨٦٢٨a = eVar;
    }

    @Override // io.reactivex.rxjava3.core.b
    protected void e(d dVar) {
        C٠٢٣٩a r02 = new C٠٢٣٩a(dVar);
        dVar.onSubscribe(r02);
        try {
            this.f١٨٦٢٨a.a(r02);
        } catch (Throwable th) {
            od.b.b(th);
            r02.c(th);
        }
    }
}
