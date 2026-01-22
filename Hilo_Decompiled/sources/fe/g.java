package fe;

import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.k0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public enum g implements io.reactivex.rxjava3.core.i, g0, io.reactivex.rxjava3.core.l, k0, io.reactivex.rxjava3.core.d, kf.c, nd.c {
    INSTANCE;

    public static g0 a() {
        return INSTANCE;
    }

    @Override // nd.c
    public boolean isDisposed() {
        return true;
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        ie.a.s(th);
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        cVar.dispose();
    }

    @Override // io.reactivex.rxjava3.core.i
    public void onSubscribe(kf.c cVar) {
        cVar.cancel();
    }

    public void cancel() {
    }

    @Override // nd.c
    public void dispose() {
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
    }

    @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSuccess(Object obj) {
    }

    public void request(long j10) {
    }
}
