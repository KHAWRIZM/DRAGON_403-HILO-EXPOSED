package ud;

import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class q extends AtomicReference implements g0, nd.c {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: a, reason: collision with root package name */
    final pd.g f١٨٣١٧a;

    /* renamed from: b, reason: collision with root package name */
    final pd.g f١٨٣١٨b;

    /* renamed from: c, reason: collision with root package name */
    final pd.a f١٨٣١٩c;

    /* renamed from: d, reason: collision with root package name */
    final pd.g f١٨٣٢٠d;

    public q(pd.g gVar, pd.g gVar2, pd.a aVar, pd.g gVar3) {
        this.f١٨٣١٧a = gVar;
        this.f١٨٣١٨b = gVar2;
        this.f١٨٣١٩c = aVar;
        this.f١٨٣٢٠d = gVar3;
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

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        if (!isDisposed()) {
            lazySet(qd.c.DISPOSED);
            try {
                this.f١٨٣١٩c.run();
            } catch (Throwable th) {
                od.b.b(th);
                ie.a.s(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        if (!isDisposed()) {
            lazySet(qd.c.DISPOSED);
            try {
                this.f١٨٣١٨b.accept(th);
                return;
            } catch (Throwable th2) {
                od.b.b(th2);
                ie.a.s(new od.a(th, th2));
                return;
            }
        }
        ie.a.s(th);
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        if (!isDisposed()) {
            try {
                this.f١٨٣١٧a.accept(obj);
            } catch (Throwable th) {
                od.b.b(th);
                ((nd.c) get()).dispose();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        if (qd.c.g(this, cVar)) {
            try {
                this.f١٨٣٢٠d.accept(this);
            } catch (Throwable th) {
                od.b.b(th);
                cVar.dispose();
                onError(th);
            }
        }
    }
}
