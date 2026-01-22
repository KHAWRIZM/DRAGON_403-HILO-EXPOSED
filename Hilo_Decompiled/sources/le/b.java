package le;

import fe.a;
import fe.m;
import io.reactivex.rxjava3.core.g0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b extends c implements a.InterfaceC٠١٦٢a {

    /* renamed from: a, reason: collision with root package name */
    final c f١٥٨٨٣a;

    /* renamed from: b, reason: collision with root package name */
    boolean f١٥٨٨٤b;

    /* renamed from: c, reason: collision with root package name */
    fe.a f١٥٨٨٥c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f١٥٨٨٦d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.f١٥٨٨٣a = cVar;
    }

    void e() {
        fe.a aVar;
        while (true) {
            synchronized (this) {
                try {
                    aVar = this.f١٥٨٨٥c;
                    if (aVar == null) {
                        this.f١٥٨٨٤b = false;
                        return;
                    }
                    this.f١٥٨٨٥c = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            aVar.d(this);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        if (this.f١٥٨٨٦d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f١٥٨٨٦d) {
                    return;
                }
                this.f١٥٨٨٦d = true;
                if (this.f١٥٨٨٤b) {
                    fe.a aVar = this.f١٥٨٨٥c;
                    if (aVar == null) {
                        aVar = new fe.a(4);
                        this.f١٥٨٨٥c = aVar;
                    }
                    aVar.c(m.e());
                    return;
                }
                this.f١٥٨٨٤b = true;
                this.f١٥٨٨٣a.onComplete();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        if (this.f١٥٨٨٦d) {
            ie.a.s(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z10 = true;
                if (!this.f١٥٨٨٦d) {
                    this.f١٥٨٨٦d = true;
                    if (this.f١٥٨٨٤b) {
                        fe.a aVar = this.f١٥٨٨٥c;
                        if (aVar == null) {
                            aVar = new fe.a(4);
                            this.f١٥٨٨٥c = aVar;
                        }
                        aVar.e(m.g(th));
                        return;
                    }
                    this.f١٥٨٨٤b = true;
                    z10 = false;
                }
                if (z10) {
                    ie.a.s(th);
                } else {
                    this.f١٥٨٨٣a.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        if (this.f١٥٨٨٦d) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f١٥٨٨٦d) {
                    return;
                }
                if (this.f١٥٨٨٤b) {
                    fe.a aVar = this.f١٥٨٨٥c;
                    if (aVar == null) {
                        aVar = new fe.a(4);
                        this.f١٥٨٨٥c = aVar;
                    }
                    aVar.c(m.l(obj));
                    return;
                }
                this.f١٥٨٨٤b = true;
                this.f١٥٨٨٣a.onNext(obj);
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        boolean z10 = true;
        if (!this.f١٥٨٨٦d) {
            synchronized (this) {
                try {
                    if (!this.f١٥٨٨٦d) {
                        if (this.f١٥٨٨٤b) {
                            fe.a aVar = this.f١٥٨٨٥c;
                            if (aVar == null) {
                                aVar = new fe.a(4);
                                this.f١٥٨٨٥c = aVar;
                            }
                            aVar.c(m.f(cVar));
                            return;
                        }
                        this.f١٥٨٨٤b = true;
                        z10 = false;
                    }
                } finally {
                }
            }
        }
        if (z10) {
            cVar.dispose();
        } else {
            this.f١٥٨٨٣a.onSubscribe(cVar);
            e();
        }
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        this.f١٥٨٨٣a.subscribe(g0Var);
    }

    @Override // fe.a.InterfaceC٠١٦٢a, pd.q
    public boolean test(Object obj) {
        return m.c(obj, this.f١٥٨٨٣a);
    }
}
