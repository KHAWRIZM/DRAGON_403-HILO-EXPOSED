package ud;

import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class o extends AtomicReference implements g0, nd.c {
    private static final long serialVersionUID = -5417183359794346637L;

    /* renamed from: a, reason: collision with root package name */
    final p f١٨٣١٢a;

    /* renamed from: b, reason: collision with root package name */
    final int f١٨٣١٣b;

    /* renamed from: c, reason: collision with root package name */
    sd.j f١٨٣١٤c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f١٨٣١٥d;

    /* renamed from: e, reason: collision with root package name */
    int f١٨٣١٦e;

    public o(p pVar, int i10) {
        this.f١٨٣١٢a = pVar;
        this.f١٨٣١٣b = i10;
    }

    public boolean a() {
        return this.f١٨٣١٥d;
    }

    public sd.j b() {
        return this.f١٨٣١٤c;
    }

    public void c() {
        this.f١٨٣١٥d = true;
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
        this.f١٨٣١٢a.c(this);
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        this.f١٨٣١٢a.d(this, th);
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        if (this.f١٨٣١٦e == 0) {
            this.f١٨٣١٢a.a(this, obj);
        } else {
            this.f١٨٣١٢a.b();
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        if (qd.c.g(this, cVar)) {
            if (cVar instanceof sd.e) {
                sd.e eVar = (sd.e) cVar;
                int a10 = eVar.a(3);
                if (a10 == 1) {
                    this.f١٨٣١٦e = a10;
                    this.f١٨٣١٤c = eVar;
                    this.f١٨٣١٥d = true;
                    this.f١٨٣١٢a.c(this);
                    return;
                }
                if (a10 == 2) {
                    this.f١٨٣١٦e = a10;
                    this.f١٨٣١٤c = eVar;
                    return;
                }
            }
            this.f١٨٣١٤c = fe.q.b(-this.f١٨٣١٣b);
        }
    }
}
