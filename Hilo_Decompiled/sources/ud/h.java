package ud;

import io.reactivex.rxjava3.core.g0;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class h extends AtomicReference implements g0, nd.c {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f١٨٢٩٥b = new Object();
    private static final long serialVersionUID = -4875965440900746268L;

    /* renamed from: a, reason: collision with root package name */
    final Queue f١٨٢٩٦a;

    public h(Queue queue) {
        this.f١٨٢٩٦a = queue;
    }

    @Override // nd.c
    public void dispose() {
        if (qd.c.a(this)) {
            this.f١٨٢٩٦a.offer(f١٨٢٩٥b);
        }
    }

    @Override // nd.c
    public boolean isDisposed() {
        if (get() == qd.c.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        this.f١٨٢٩٦a.offer(fe.m.e());
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        this.f١٨٢٩٦a.offer(fe.m.g(th));
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        this.f١٨٢٩٦a.offer(fe.m.l(obj));
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        qd.c.g(this, cVar);
    }
}
