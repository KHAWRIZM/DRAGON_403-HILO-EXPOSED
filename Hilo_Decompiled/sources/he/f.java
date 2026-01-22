package he;

import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.l;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class f extends he.a implements g0, nd.c, l, k0, io.reactivex.rxjava3.core.d {

    /* renamed from: g, reason: collision with root package name */
    private final g0 f١٤٥٨٤g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicReference f١٤٥٨٥h;

    public f() {
        this(a.INSTANCE);
    }

    @Override // nd.c
    public final void dispose() {
        qd.c.a(this.f١٤٥٨٥h);
    }

    @Override // nd.c
    public final boolean isDisposed() {
        return qd.c.c((nd.c) this.f١٤٥٨٥h.get());
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        if (!this.f١٤٥٧٢f) {
            this.f١٤٥٧٢f = true;
            if (this.f١٤٥٨٥h.get() == null) {
                this.f١٤٥٦٩c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f١٤٥٧١e = Thread.currentThread();
            this.f١٤٥٧٠d++;
            this.f١٤٥٨٤g.onComplete();
        } finally {
            this.f١٤٥٦٧a.countDown();
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        if (!this.f١٤٥٧٢f) {
            this.f١٤٥٧٢f = true;
            if (this.f١٤٥٨٥h.get() == null) {
                this.f١٤٥٦٩c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f١٤٥٧١e = Thread.currentThread();
            if (th == null) {
                this.f١٤٥٦٩c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f١٤٥٦٩c.add(th);
            }
            this.f١٤٥٨٤g.onError(th);
            this.f١٤٥٦٧a.countDown();
        } catch (Throwable th2) {
            this.f١٤٥٦٧a.countDown();
            throw th2;
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        if (!this.f١٤٥٧٢f) {
            this.f١٤٥٧٢f = true;
            if (this.f١٤٥٨٥h.get() == null) {
                this.f١٤٥٦٩c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f١٤٥٧١e = Thread.currentThread();
        this.f١٤٥٦٨b.add(obj);
        if (obj == null) {
            this.f١٤٥٦٩c.add(new NullPointerException("onNext received a null value"));
        }
        this.f١٤٥٨٤g.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        this.f١٤٥٧١e = Thread.currentThread();
        if (cVar == null) {
            this.f١٤٥٦٩c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!androidx.lifecycle.a.a(this.f١٤٥٨٥h, null, cVar)) {
            cVar.dispose();
            if (this.f١٤٥٨٥h.get() != qd.c.DISPOSED) {
                this.f١٤٥٦٩c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + cVar));
                return;
            }
            return;
        }
        this.f١٤٥٨٤g.onSubscribe(cVar);
    }

    @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSuccess(Object obj) {
        onNext(obj);
        onComplete();
    }

    public f(g0 g0Var) {
        this.f١٤٥٨٥h = new AtomicReference();
        this.f١٤٥٨٤g = g0Var;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    enum a implements g0 {
        INSTANCE;

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
        }
    }
}
