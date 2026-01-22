package he;

import fe.j;
import io.reactivex.rxjava3.core.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d implements g0, nd.c {

    /* renamed from: a, reason: collision with root package name */
    final g0 f١٤٥٧٥a;

    /* renamed from: b, reason: collision with root package name */
    nd.c f١٤٥٧٦b;

    /* renamed from: c, reason: collision with root package name */
    boolean f١٤٥٧٧c;

    public d(g0 g0Var) {
        this.f١٤٥٧٥a = g0Var;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f١٤٥٧٥a.onSubscribe(qd.d.INSTANCE);
            try {
                this.f١٤٥٧٥a.onError(nullPointerException);
            } catch (Throwable th) {
                od.b.b(th);
                ie.a.s(new od.a(nullPointerException, th));
            }
        } catch (Throwable th2) {
            od.b.b(th2);
            ie.a.s(new od.a(nullPointerException, th2));
        }
    }

    void b() {
        this.f١٤٥٧٧c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f١٤٥٧٥a.onSubscribe(qd.d.INSTANCE);
            try {
                this.f١٤٥٧٥a.onError(nullPointerException);
            } catch (Throwable th) {
                od.b.b(th);
                ie.a.s(new od.a(nullPointerException, th));
            }
        } catch (Throwable th2) {
            od.b.b(th2);
            ie.a.s(new od.a(nullPointerException, th2));
        }
    }

    @Override // nd.c
    public void dispose() {
        this.f١٤٥٧٦b.dispose();
    }

    @Override // nd.c
    public boolean isDisposed() {
        return this.f١٤٥٧٦b.isDisposed();
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        if (this.f١٤٥٧٧c) {
            return;
        }
        this.f١٤٥٧٧c = true;
        if (this.f١٤٥٧٦b == null) {
            a();
            return;
        }
        try {
            this.f١٤٥٧٥a.onComplete();
        } catch (Throwable th) {
            od.b.b(th);
            ie.a.s(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        if (this.f١٤٥٧٧c) {
            ie.a.s(th);
            return;
        }
        this.f١٤٥٧٧c = true;
        if (this.f١٤٥٧٦b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f١٤٥٧٥a.onSubscribe(qd.d.INSTANCE);
                try {
                    this.f١٤٥٧٥a.onError(new od.a(th, nullPointerException));
                    return;
                } catch (Throwable th2) {
                    od.b.b(th2);
                    ie.a.s(new od.a(th, nullPointerException, th2));
                    return;
                }
            } catch (Throwable th3) {
                od.b.b(th3);
                ie.a.s(new od.a(th, nullPointerException, th3));
                return;
            }
        }
        if (th == null) {
            th = j.b("onError called with a null Throwable.");
        }
        try {
            this.f١٤٥٧٥a.onError(th);
        } catch (Throwable th4) {
            od.b.b(th4);
            ie.a.s(new od.a(th, th4));
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        if (this.f١٤٥٧٧c) {
            return;
        }
        if (this.f١٤٥٧٦b == null) {
            b();
            return;
        }
        if (obj == null) {
            NullPointerException b10 = j.b("onNext called with a null value.");
            try {
                this.f١٤٥٧٦b.dispose();
                onError(b10);
                return;
            } catch (Throwable th) {
                od.b.b(th);
                onError(new od.a(b10, th));
                return;
            }
        }
        try {
            this.f١٤٥٧٥a.onNext(obj);
        } catch (Throwable th2) {
            od.b.b(th2);
            try {
                this.f١٤٥٧٦b.dispose();
                onError(th2);
            } catch (Throwable th3) {
                od.b.b(th3);
                onError(new od.a(th2, th3));
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        if (qd.c.i(this.f١٤٥٧٦b, cVar)) {
            this.f١٤٥٧٦b = cVar;
            try {
                this.f١٤٥٧٥a.onSubscribe(this);
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٤٥٧٧c = true;
                try {
                    cVar.dispose();
                    ie.a.s(th);
                } catch (Throwable th2) {
                    od.b.b(th2);
                    ie.a.s(new od.a(th, th2));
                }
            }
        }
    }
}
