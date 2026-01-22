package xd;

import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.k;
import io.reactivex.rxjava3.core.l;
import io.reactivex.rxjava3.core.m;
import java.util.concurrent.atomic.AtomicReference;
import pd.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b extends j {

    /* renamed from: a, reason: collision with root package name */
    final m f١٩٠٣٧a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements k, nd.c {
        private static final long serialVersionUID = -2467358622224974244L;

        /* renamed from: a, reason: collision with root package name */
        final l f١٩٠٣٨a;

        a(l lVar) {
            this.f١٩٠٣٨a = lVar;
        }

        @Override // io.reactivex.rxjava3.core.k
        public void a(f fVar) {
            d(new qd.b(fVar));
        }

        @Override // io.reactivex.rxjava3.core.k
        public boolean b(Throwable th) {
            nd.c cVar;
            if (th == null) {
                th = fe.j.b("onError called with a null Throwable.");
            }
            Object obj = get();
            qd.c cVar2 = qd.c.DISPOSED;
            if (obj != cVar2 && (cVar = (nd.c) getAndSet(cVar2)) != cVar2) {
                try {
                    this.f١٩٠٣٨a.onError(th);
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

        @Override // io.reactivex.rxjava3.core.k
        public void onComplete() {
            nd.c cVar;
            Object obj = get();
            qd.c cVar2 = qd.c.DISPOSED;
            if (obj != cVar2 && (cVar = (nd.c) getAndSet(cVar2)) != cVar2) {
                try {
                    this.f١٩٠٣٨a.onComplete();
                } finally {
                    if (cVar != null) {
                        cVar.dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.k
        public void onSuccess(Object obj) {
            nd.c cVar;
            Object obj2 = get();
            qd.c cVar2 = qd.c.DISPOSED;
            if (obj2 != cVar2 && (cVar = (nd.c) getAndSet(cVar2)) != cVar2) {
                try {
                    if (obj == null) {
                        this.f١٩٠٣٨a.onError(fe.j.b("onSuccess called with a null value."));
                    } else {
                        this.f١٩٠٣٨a.onSuccess(obj);
                    }
                    if (cVar != null) {
                        cVar.dispose();
                    }
                } catch (Throwable th) {
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }
    }

    public b(m mVar) {
        this.f١٩٠٣٧a = mVar;
    }

    @Override // io.reactivex.rxjava3.core.j
    protected void e(l lVar) {
        a aVar = new a(lVar);
        lVar.onSubscribe(aVar);
        try {
            this.f١٩٠٣٧a.a(aVar);
        } catch (Throwable th) {
            od.b.b(th);
            aVar.c(th);
        }
    }
}
