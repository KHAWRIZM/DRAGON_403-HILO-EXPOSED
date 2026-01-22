package ud;

import io.reactivex.rxjava3.core.k0;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class g extends CountDownLatch implements k0, io.reactivex.rxjava3.core.d, io.reactivex.rxjava3.core.l {

    /* renamed from: a, reason: collision with root package name */
    Object f١٨٢٩١a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f١٨٢٩٢b;

    /* renamed from: c, reason: collision with root package name */
    nd.c f١٨٢٩٣c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f١٨٢٩٤d;

    public g() {
        super(1);
    }

    public Object a() {
        if (getCount() != 0) {
            try {
                fe.e.b();
                await();
            } catch (InterruptedException e10) {
                b();
                throw fe.j.g(e10);
            }
        }
        Throwable th = this.f١٨٢٩٢b;
        if (th == null) {
            return this.f١٨٢٩١a;
        }
        throw fe.j.g(th);
    }

    void b() {
        this.f١٨٢٩٤d = true;
        nd.c cVar = this.f١٨٢٩٣c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.d
    public void onComplete() {
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        this.f١٨٢٩٢b = th;
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        this.f١٨٢٩٣c = cVar;
        if (this.f١٨٢٩٤d) {
            cVar.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.k0
    public void onSuccess(Object obj) {
        this.f١٨٢٩١a = obj;
        countDown();
    }
}
