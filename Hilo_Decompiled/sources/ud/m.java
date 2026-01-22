package ud;

import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class m extends AtomicReference implements g0, nd.c {
    private static final long serialVersionUID = -4403180040475402120L;

    /* renamed from: a, reason: collision with root package name */
    final pd.q f١٨٣٠٥a;

    /* renamed from: b, reason: collision with root package name */
    final pd.g f١٨٣٠٦b;

    /* renamed from: c, reason: collision with root package name */
    final pd.a f١٨٣٠٧c;

    /* renamed from: d, reason: collision with root package name */
    boolean f١٨٣٠٨d;

    public m(pd.q qVar, pd.g gVar, pd.a aVar) {
        this.f١٨٣٠٥a = qVar;
        this.f١٨٣٠٦b = gVar;
        this.f١٨٣٠٧c = aVar;
    }

    @Override // nd.c
    public void dispose() {
        qd.c.a(this);
    }

    @Override // nd.c
    public boolean isDisposed() {
        return qd.c.c((nd.c) get());
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        if (this.f١٨٣٠٨d) {
            return;
        }
        this.f١٨٣٠٨d = true;
        try {
            this.f١٨٣٠٧c.run();
        } catch (Throwable th) {
            od.b.b(th);
            ie.a.s(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        if (this.f١٨٣٠٨d) {
            ie.a.s(th);
            return;
        }
        this.f١٨٣٠٨d = true;
        try {
            this.f١٨٣٠٦b.accept(th);
        } catch (Throwable th2) {
            od.b.b(th2);
            ie.a.s(new od.a(th, th2));
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        if (this.f١٨٣٠٨d) {
            return;
        }
        try {
            if (!this.f١٨٣٠٥a.test(obj)) {
                dispose();
                onComplete();
            }
        } catch (Throwable th) {
            od.b.b(th);
            dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        qd.c.g(this, cVar);
    }
}
