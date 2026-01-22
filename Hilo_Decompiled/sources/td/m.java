package td;

import io.reactivex.rxjava3.core.e0;
import io.reactivex.rxjava3.core.g0;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class m extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.z f١٨١٩٠a;

    /* renamed from: b, reason: collision with root package name */
    final pd.o f١٨١٩١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements g0, nd.c {
        private static final long serialVersionUID = -5127032662980523968L;

        /* renamed from: a, reason: collision with root package name */
        final g0 f١٨١٩٢a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f١٨١٩٣b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٨١٩٤c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f١٨١٩٥d;

        /* renamed from: e, reason: collision with root package name */
        boolean f١٨١٩٦e;

        a(g0 g0Var, pd.o oVar) {
            this.f١٨١٩٢a = g0Var;
            this.f١٨١٩٣b = oVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٨١٩٥d = true;
            this.f١٨١٩٤c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٨١٩٥d;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f١٨١٩٦e) {
                this.f١٨١٩٦e = true;
                this.f١٨١٩٢a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٨١٩٦e) {
                ie.a.s(th);
            } else {
                this.f١٨١٩٦e = true;
                this.f١٨١٩٢a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            Iterator it;
            if (this.f١٨١٩٦e) {
                return;
            }
            try {
                Object apply = this.f١٨١٩٣b.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null Stream");
                Stream a10 = io.reactivex.rxjava3.core.v.a(apply);
                try {
                    it = a10.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (this.f١٨١٩٥d) {
                            this.f١٨١٩٦e = true;
                            break;
                        }
                        Object next = it.next();
                        Objects.requireNonNull(next, "The Stream's Iterator.next returned a null value");
                        if (this.f١٨١٩٥d) {
                            this.f١٨١٩٦e = true;
                            break;
                        }
                        this.f١٨١٩٢a.onNext(next);
                        if (this.f١٨١٩٥d) {
                            this.f١٨١٩٦e = true;
                            break;
                        }
                    }
                    if (a10 != null) {
                        a10.close();
                    }
                } finally {
                }
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٨١٩٤c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٨١٩٤c, cVar)) {
                this.f١٨١٩٤c = cVar;
                this.f١٨١٩٢a.onSubscribe(this);
            }
        }
    }

    public m(io.reactivex.rxjava3.core.z zVar, pd.o oVar) {
        this.f١٨١٩٠a = zVar;
        this.f١٨١٩١b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        Stream stream;
        e0 e0Var = this.f١٨١٩٠a;
        if (e0Var instanceof pd.r) {
            try {
                Object obj = ((pd.r) e0Var).get();
                if (obj != null) {
                    Object apply = this.f١٨١٩١b.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    stream = io.reactivex.rxjava3.core.v.a(apply);
                } else {
                    stream = null;
                }
                if (stream != null) {
                    q.e(g0Var, stream);
                    return;
                } else {
                    qd.d.d(g0Var);
                    return;
                }
            } catch (Throwable th) {
                od.b.b(th);
                qd.d.f(th, g0Var);
                return;
            }
        }
        e0Var.subscribe(new a(g0Var, this.f١٨١٩١b));
    }
}
