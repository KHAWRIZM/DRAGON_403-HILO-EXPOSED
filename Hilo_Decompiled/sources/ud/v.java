package ud;

import io.reactivex.rxjava3.core.k0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class v implements k0 {

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference f١٨٣٢٧a;

    /* renamed from: b, reason: collision with root package name */
    final k0 f١٨٣٢٨b;

    public v(AtomicReference atomicReference, k0 k0Var) {
        this.f١٨٣٢٧a = atomicReference;
        this.f١٨٣٢٨b = k0Var;
    }

    @Override // io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        this.f١٨٣٢٨b.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        qd.c.d(this.f١٨٣٢٧a, cVar);
    }

    @Override // io.reactivex.rxjava3.core.k0
    public void onSuccess(Object obj) {
        this.f١٨٣٢٨b.onSuccess(obj);
    }
}
