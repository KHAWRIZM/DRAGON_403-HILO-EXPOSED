package ud;

import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class d extends CountDownLatch implements g0, nd.c {

    /* renamed from: a, reason: collision with root package name */
    Object f١٨٢٨٧a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f١٨٢٨٨b;

    /* renamed from: c, reason: collision with root package name */
    nd.c f١٨٢٨٩c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f١٨٢٩٠d;

    public d() {
        super(1);
    }

    public final Object a() {
        if (getCount() != 0) {
            try {
                fe.e.b();
                await();
            } catch (InterruptedException e10) {
                dispose();
                throw fe.j.g(e10);
            }
        }
        Throwable th = this.f١٨٢٨٨b;
        if (th == null) {
            return this.f١٨٢٨٧a;
        }
        throw fe.j.g(th);
    }

    @Override // nd.c
    public final void dispose() {
        this.f١٨٢٩٠d = true;
        nd.c cVar = this.f١٨٢٨٩c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // nd.c
    public final boolean isDisposed() {
        return this.f١٨٢٩٠d;
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public final void onSubscribe(nd.c cVar) {
        this.f١٨٢٨٩c = cVar;
        if (this.f١٨٢٩٠d) {
            cVar.dispose();
        }
    }
}
