package ud;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class l extends AtomicReference implements io.reactivex.rxjava3.core.d, nd.c {
    private static final long serialVersionUID = -7545121636549663526L;

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

    @Override // io.reactivex.rxjava3.core.d
    public void onComplete() {
        lazySet(qd.c.DISPOSED);
    }

    @Override // io.reactivex.rxjava3.core.d
    public void onError(Throwable th) {
        lazySet(qd.c.DISPOSED);
        ie.a.s(new od.d(th));
    }

    @Override // io.reactivex.rxjava3.core.d
    public void onSubscribe(nd.c cVar) {
        qd.c.g(this, cVar);
    }
}
