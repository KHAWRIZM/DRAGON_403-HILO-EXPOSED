package ud;

import io.reactivex.rxjava3.core.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class k implements g0, nd.c {

    /* renamed from: a, reason: collision with root package name */
    final g0 f١٨٣٠١a;

    /* renamed from: b, reason: collision with root package name */
    final pd.g f١٨٣٠٢b;

    /* renamed from: c, reason: collision with root package name */
    final pd.a f١٨٣٠٣c;

    /* renamed from: d, reason: collision with root package name */
    nd.c f١٨٣٠٤d;

    public k(g0 g0Var, pd.g gVar, pd.a aVar) {
        this.f١٨٣٠١a = g0Var;
        this.f١٨٣٠٢b = gVar;
        this.f١٨٣٠٣c = aVar;
    }

    @Override // nd.c
    public void dispose() {
        nd.c cVar = this.f١٨٣٠٤d;
        qd.c cVar2 = qd.c.DISPOSED;
        if (cVar != cVar2) {
            this.f١٨٣٠٤d = cVar2;
            try {
                this.f١٨٣٠٣c.run();
            } catch (Throwable th) {
                od.b.b(th);
                ie.a.s(th);
            }
            cVar.dispose();
        }
    }

    @Override // nd.c
    public boolean isDisposed() {
        return this.f١٨٣٠٤d.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        nd.c cVar = this.f١٨٣٠٤d;
        qd.c cVar2 = qd.c.DISPOSED;
        if (cVar != cVar2) {
            this.f١٨٣٠٤d = cVar2;
            this.f١٨٣٠١a.onComplete();
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        nd.c cVar = this.f١٨٣٠٤d;
        qd.c cVar2 = qd.c.DISPOSED;
        if (cVar != cVar2) {
            this.f١٨٣٠٤d = cVar2;
            this.f١٨٣٠١a.onError(th);
        } else {
            ie.a.s(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        this.f١٨٣٠١a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        try {
            this.f١٨٣٠٢b.accept(cVar);
            if (qd.c.i(this.f١٨٣٠٤d, cVar)) {
                this.f١٨٣٠٤d = cVar;
                this.f١٨٣٠١a.onSubscribe(this);
            }
        } catch (Throwable th) {
            od.b.b(th);
            cVar.dispose();
            this.f١٨٣٠٤d = qd.c.DISPOSED;
            qd.d.f(th, this.f١٨٣٠١a);
        }
    }
}
