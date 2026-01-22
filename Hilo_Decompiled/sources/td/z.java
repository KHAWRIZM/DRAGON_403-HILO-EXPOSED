package td;

import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
abstract class z extends CompletableFuture implements g0 {

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference f١٨٢١٣a = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    Object f١٨٢١٤b;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.f١٨٢١٤b = null;
        this.f١٨٢١٣a.lazySet(qd.c.DISPOSED);
    }

    protected final void b() {
        qd.c.a(this.f١٨٢١٣a);
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        b();
        return super.cancel(z10);
    }

    @Override // java.util.concurrent.CompletableFuture
    public final boolean complete(Object obj) {
        b();
        return super.complete(obj);
    }

    @Override // java.util.concurrent.CompletableFuture
    public final boolean completeExceptionally(Throwable th) {
        b();
        return super.completeExceptionally(th);
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public final void onError(Throwable th) {
        a();
        if (!completeExceptionally(th)) {
            ie.a.s(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public final void onSubscribe(nd.c cVar) {
        qd.c.g(this.f١٨٢١٣a, cVar);
    }
}
