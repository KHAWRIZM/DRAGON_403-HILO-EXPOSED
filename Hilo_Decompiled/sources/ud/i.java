package ud;

import io.reactivex.rxjava3.core.k0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class i extends AtomicReference implements k0, nd.c {
    private static final long serialVersionUID = -7012088219455310787L;

    /* renamed from: a, reason: collision with root package name */
    final pd.g f١٨٢٩٧a;

    /* renamed from: b, reason: collision with root package name */
    final pd.g f١٨٢٩٨b;

    public i(pd.g gVar, pd.g gVar2) {
        this.f١٨٢٩٧a = gVar;
        this.f١٨٢٩٨b = gVar2;
    }

    @Override // nd.c
    public void dispose() {
        qd.c.a(this);
    }

    @Override // nd.c
    public boolean isDisposed() {
        if (get() == qd.c.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        lazySet(qd.c.DISPOSED);
        try {
            this.f١٨٢٩٨b.accept(th);
        } catch (Throwable th2) {
            od.b.b(th2);
            ie.a.s(new od.a(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        qd.c.g(this, cVar);
    }

    @Override // io.reactivex.rxjava3.core.k0
    public void onSuccess(Object obj) {
        lazySet(qd.c.DISPOSED);
        try {
            this.f١٨٢٩٧a.accept(obj);
        } catch (Throwable th) {
            od.b.b(th);
            ie.a.s(th);
        }
    }
}
