package zd;

import java.util.Iterator;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class q4 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.z f٢٠٣٦٨a;

    /* renamed from: b, reason: collision with root package name */
    final Iterable f٢٠٣٦٩b;

    /* renamed from: c, reason: collision with root package name */
    final pd.c f٢٠٣٧٠c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٣٧١a;

        /* renamed from: b, reason: collision with root package name */
        final Iterator f٢٠٣٧٢b;

        /* renamed from: c, reason: collision with root package name */
        final pd.c f٢٠٣٧٣c;

        /* renamed from: d, reason: collision with root package name */
        nd.c f٢٠٣٧٤d;

        /* renamed from: e, reason: collision with root package name */
        boolean f٢٠٣٧٥e;

        a(io.reactivex.rxjava3.core.g0 g0Var, Iterator it, pd.c cVar) {
            this.f٢٠٣٧١a = g0Var;
            this.f٢٠٣٧٢b = it;
            this.f٢٠٣٧٣c = cVar;
        }

        void a(Throwable th) {
            this.f٢٠٣٧٥e = true;
            this.f٢٠٣٧٤d.dispose();
            this.f٢٠٣٧١a.onError(th);
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٣٧٤d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٣٧٤d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f٢٠٣٧٥e) {
                return;
            }
            this.f٢٠٣٧٥e = true;
            this.f٢٠٣٧١a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٣٧٥e) {
                ie.a.s(th);
            } else {
                this.f٢٠٣٧٥e = true;
                this.f٢٠٣٧١a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٣٧٥e) {
                return;
            }
            try {
                Object next = this.f٢٠٣٧٢b.next();
                Objects.requireNonNull(next, "The iterator returned a null value");
                try {
                    Object apply = this.f٢٠٣٧٣c.apply(obj, next);
                    Objects.requireNonNull(apply, "The zipper function returned a null value");
                    this.f٢٠٣٧١a.onNext(apply);
                    try {
                        if (!this.f٢٠٣٧٢b.hasNext()) {
                            this.f٢٠٣٧٥e = true;
                            this.f٢٠٣٧٤d.dispose();
                            this.f٢٠٣٧١a.onComplete();
                        }
                    } catch (Throwable th) {
                        od.b.b(th);
                        a(th);
                    }
                } catch (Throwable th2) {
                    od.b.b(th2);
                    a(th2);
                }
            } catch (Throwable th3) {
                od.b.b(th3);
                a(th3);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٣٧٤d, cVar)) {
                this.f٢٠٣٧٤d = cVar;
                this.f٢٠٣٧١a.onSubscribe(this);
            }
        }
    }

    public q4(io.reactivex.rxjava3.core.z zVar, Iterable iterable, pd.c cVar) {
        this.f٢٠٣٦٨a = zVar;
        this.f٢٠٣٦٩b = iterable;
        this.f٢٠٣٧٠c = cVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        try {
            Iterator it = this.f٢٠٣٦٩b.iterator();
            Objects.requireNonNull(it, "The iterator returned by other is null");
            Iterator it2 = it;
            try {
                if (!it2.hasNext()) {
                    qd.d.d(g0Var);
                } else {
                    this.f٢٠٣٦٨a.subscribe(new a(g0Var, it2, this.f٢٠٣٧٠c));
                }
            } catch (Throwable th) {
                od.b.b(th);
                qd.d.f(th, g0Var);
            }
        } catch (Throwable th2) {
            od.b.b(th2);
            qd.d.f(th2, g0Var);
        }
    }
}
