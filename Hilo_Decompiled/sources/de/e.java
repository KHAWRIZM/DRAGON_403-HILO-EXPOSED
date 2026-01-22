package de;

import io.reactivex.rxjava3.core.i;
import java.util.concurrent.atomic.AtomicReference;
import pd.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e extends AtomicReference implements i, kf.c, nd.c {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: a, reason: collision with root package name */
    final g f١٣٧٠٧a;

    /* renamed from: b, reason: collision with root package name */
    final g f١٣٧٠٨b;

    /* renamed from: c, reason: collision with root package name */
    final pd.a f١٣٧٠٩c;

    /* renamed from: d, reason: collision with root package name */
    final g f١٣٧١٠d;

    public e(g gVar, g gVar2, pd.a aVar, g gVar3) {
        this.f١٣٧٠٧a = gVar;
        this.f١٣٧٠٨b = gVar2;
        this.f١٣٧٠٩c = aVar;
        this.f١٣٧١٠d = gVar3;
    }

    public void cancel() {
        ee.c.a(this);
    }

    @Override // nd.c
    public void dispose() {
        cancel();
    }

    @Override // nd.c
    public boolean isDisposed() {
        if (get() == ee.c.CANCELLED) {
            return true;
        }
        return false;
    }

    public void onComplete() {
        Object obj = get();
        ee.c cVar = ee.c.CANCELLED;
        if (obj != cVar) {
            lazySet(cVar);
            try {
                this.f١٣٧٠٩c.run();
            } catch (Throwable th) {
                od.b.b(th);
                ie.a.s(th);
            }
        }
    }

    public void onError(Throwable th) {
        Object obj = get();
        ee.c cVar = ee.c.CANCELLED;
        if (obj != cVar) {
            lazySet(cVar);
            try {
                this.f١٣٧٠٨b.accept(th);
                return;
            } catch (Throwable th2) {
                od.b.b(th2);
                ie.a.s(new od.a(th, th2));
                return;
            }
        }
        ie.a.s(th);
    }

    public void onNext(Object obj) {
        if (!isDisposed()) {
            try {
                this.f١٣٧٠٧a.accept(obj);
            } catch (Throwable th) {
                od.b.b(th);
                ((kf.c) get()).cancel();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.i
    public void onSubscribe(kf.c cVar) {
        if (ee.c.f(this, cVar)) {
            try {
                this.f١٣٧١٠d.accept(this);
            } catch (Throwable th) {
                od.b.b(th);
                cVar.cancel();
                onError(th);
            }
        }
    }

    public void request(long j10) {
        ((kf.c) get()).request(j10);
    }
}
