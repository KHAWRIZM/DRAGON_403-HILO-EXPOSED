package he;

import fe.j;
import fe.m;
import io.reactivex.rxjava3.core.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e implements g0, nd.c {

    /* renamed from: a, reason: collision with root package name */
    final g0 f١٤٥٧٨a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f١٤٥٧٩b;

    /* renamed from: c, reason: collision with root package name */
    nd.c f١٤٥٨٠c;

    /* renamed from: d, reason: collision with root package name */
    boolean f١٤٥٨١d;

    /* renamed from: e, reason: collision with root package name */
    fe.a f١٤٥٨٢e;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f١٤٥٨٣f;

    public e(g0 g0Var) {
        this(g0Var, false);
    }

    void a() {
        fe.a aVar;
        do {
            synchronized (this) {
                try {
                    aVar = this.f١٤٥٨٢e;
                    if (aVar == null) {
                        this.f١٤٥٨١d = false;
                        return;
                    }
                    this.f١٤٥٨٢e = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (!aVar.a(this.f١٤٥٧٨a));
    }

    @Override // nd.c
    public void dispose() {
        this.f١٤٥٨٣f = true;
        this.f١٤٥٨٠c.dispose();
    }

    @Override // nd.c
    public boolean isDisposed() {
        return this.f١٤٥٨٠c.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        if (this.f١٤٥٨٣f) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f١٤٥٨٣f) {
                    return;
                }
                if (this.f١٤٥٨١d) {
                    fe.a aVar = this.f١٤٥٨٢e;
                    if (aVar == null) {
                        aVar = new fe.a(4);
                        this.f١٤٥٨٢e = aVar;
                    }
                    aVar.c(m.e());
                    return;
                }
                this.f١٤٥٨٣f = true;
                this.f١٤٥٨١d = true;
                this.f١٤٥٧٨a.onComplete();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        if (this.f١٤٥٨٣f) {
            ie.a.s(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z10 = true;
                if (!this.f١٤٥٨٣f) {
                    if (this.f١٤٥٨١d) {
                        this.f١٤٥٨٣f = true;
                        fe.a aVar = this.f١٤٥٨٢e;
                        if (aVar == null) {
                            aVar = new fe.a(4);
                            this.f١٤٥٨٢e = aVar;
                        }
                        Object g10 = m.g(th);
                        if (this.f١٤٥٧٩b) {
                            aVar.c(g10);
                        } else {
                            aVar.e(g10);
                        }
                        return;
                    }
                    this.f١٤٥٨٣f = true;
                    this.f١٤٥٨١d = true;
                    z10 = false;
                }
                if (z10) {
                    ie.a.s(th);
                } else {
                    this.f١٤٥٧٨a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        if (this.f١٤٥٨٣f) {
            return;
        }
        if (obj == null) {
            this.f١٤٥٨٠c.dispose();
            onError(j.b("onNext called with a null value."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f١٤٥٨٣f) {
                    return;
                }
                if (this.f١٤٥٨١d) {
                    fe.a aVar = this.f١٤٥٨٢e;
                    if (aVar == null) {
                        aVar = new fe.a(4);
                        this.f١٤٥٨٢e = aVar;
                    }
                    aVar.c(m.l(obj));
                    return;
                }
                this.f١٤٥٨١d = true;
                this.f١٤٥٧٨a.onNext(obj);
                a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        if (qd.c.i(this.f١٤٥٨٠c, cVar)) {
            this.f١٤٥٨٠c = cVar;
            this.f١٤٥٧٨a.onSubscribe(this);
        }
    }

    public e(g0 g0Var, boolean z10) {
        this.f١٤٥٧٨a = g0Var;
        this.f١٤٥٧٩b = z10;
    }
}
