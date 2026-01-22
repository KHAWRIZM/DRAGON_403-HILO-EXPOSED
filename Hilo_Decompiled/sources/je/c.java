package je;

import fe.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c extends a {

    /* renamed from: b, reason: collision with root package name */
    final a f١٥٣٨٨b;

    /* renamed from: c, reason: collision with root package name */
    boolean f١٥٣٨٩c;

    /* renamed from: d, reason: collision with root package name */
    fe.a f١٥٣٩٠d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f١٥٣٩١e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f١٥٣٨٨b = aVar;
    }

    public void onComplete() {
        if (this.f١٥٣٩١e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f١٥٣٩١e) {
                    return;
                }
                this.f١٥٣٩١e = true;
                if (this.f١٥٣٨٩c) {
                    fe.a aVar = this.f١٥٣٩٠d;
                    if (aVar == null) {
                        aVar = new fe.a(4);
                        this.f١٥٣٩٠d = aVar;
                    }
                    aVar.c(m.e());
                    return;
                }
                this.f١٥٣٨٩c = true;
                this.f١٥٣٨٨b.onComplete();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onError(Throwable th) {
        if (this.f١٥٣٩١e) {
            ie.a.s(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z10 = true;
                if (!this.f١٥٣٩١e) {
                    this.f١٥٣٩١e = true;
                    if (this.f١٥٣٨٩c) {
                        fe.a aVar = this.f١٥٣٩٠d;
                        if (aVar == null) {
                            aVar = new fe.a(4);
                            this.f١٥٣٩٠d = aVar;
                        }
                        aVar.e(m.g(th));
                        return;
                    }
                    this.f١٥٣٨٩c = true;
                    z10 = false;
                }
                if (z10) {
                    ie.a.s(th);
                } else {
                    this.f١٥٣٨٨b.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void onNext(Object obj) {
        if (this.f١٥٣٩١e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f١٥٣٩١e) {
                    return;
                }
                if (this.f١٥٣٨٩c) {
                    fe.a aVar = this.f١٥٣٩٠d;
                    if (aVar == null) {
                        aVar = new fe.a(4);
                        this.f١٥٣٩٠d = aVar;
                    }
                    aVar.c(m.l(obj));
                    return;
                }
                this.f١٥٣٨٩c = true;
                this.f١٥٣٨٨b.onNext(obj);
                t();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.i
    public void onSubscribe(kf.c cVar) {
        boolean z10 = true;
        if (!this.f١٥٣٩١e) {
            synchronized (this) {
                try {
                    if (!this.f١٥٣٩١e) {
                        if (this.f١٥٣٨٩c) {
                            fe.a aVar = this.f١٥٣٩٠d;
                            if (aVar == null) {
                                aVar = new fe.a(4);
                                this.f١٥٣٩٠d = aVar;
                            }
                            aVar.c(m.m(cVar));
                            return;
                        }
                        this.f١٥٣٨٩c = true;
                        z10 = false;
                    }
                } finally {
                }
            }
        }
        if (z10) {
            cVar.cancel();
        } else {
            this.f١٥٣٨٨b.onSubscribe(cVar);
            t();
        }
    }

    @Override // io.reactivex.rxjava3.core.h
    protected void p(kf.b bVar) {
        this.f١٥٣٨٨b.subscribe(bVar);
    }

    void t() {
        fe.a aVar;
        while (true) {
            synchronized (this) {
                try {
                    aVar = this.f١٥٣٩٠d;
                    if (aVar == null) {
                        this.f١٥٣٨٩c = false;
                        return;
                    }
                    this.f١٥٣٩٠d = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            aVar.b(this.f١٥٣٨٨b);
        }
    }
}
