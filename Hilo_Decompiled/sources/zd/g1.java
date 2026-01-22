package zd;

import java.util.Iterator;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class g1 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final Iterable f١٩٨٠٤a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٠٥a;

        /* renamed from: b, reason: collision with root package name */
        final Iterator f١٩٨٠٦b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f١٩٨٠٧c;

        /* renamed from: d, reason: collision with root package name */
        boolean f١٩٨٠٨d;

        /* renamed from: e, reason: collision with root package name */
        boolean f١٩٨٠٩e;

        /* renamed from: f, reason: collision with root package name */
        boolean f١٩٨١٠f;

        a(io.reactivex.rxjava3.core.g0 g0Var, Iterator it) {
            this.f١٩٨٠٥a = g0Var;
            this.f١٩٨٠٦b = it;
        }

        @Override // sd.f
        public int a(int i10) {
            if ((i10 & 1) != 0) {
                this.f١٩٨٠٨d = true;
                return 1;
            }
            return 0;
        }

        void b() {
            while (!isDisposed()) {
                try {
                    Object next = this.f١٩٨٠٦b.next();
                    Objects.requireNonNull(next, "The iterator returned a null value");
                    this.f١٩٨٠٥a.onNext(next);
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f١٩٨٠٦b.hasNext()) {
                            if (!isDisposed()) {
                                this.f١٩٨٠٥a.onComplete();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        od.b.b(th);
                        this.f١٩٨٠٥a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    od.b.b(th2);
                    this.f١٩٨٠٥a.onError(th2);
                    return;
                }
            }
        }

        @Override // sd.j
        public void clear() {
            this.f١٩٨٠٩e = true;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٨٠٧c = true;
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٨٠٧c;
        }

        @Override // sd.j
        public boolean isEmpty() {
            return this.f١٩٨٠٩e;
        }

        @Override // sd.j
        public Object poll() {
            if (this.f١٩٨٠٩e) {
                return null;
            }
            if (this.f١٩٨١٠f) {
                if (!this.f١٩٨٠٦b.hasNext()) {
                    this.f١٩٨٠٩e = true;
                    return null;
                }
            } else {
                this.f١٩٨١٠f = true;
            }
            Object next = this.f١٩٨٠٦b.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            return next;
        }
    }

    public g1(Iterable iterable) {
        this.f١٩٨٠٤a = iterable;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        try {
            Iterator it = this.f١٩٨٠٤a.iterator();
            try {
                if (!it.hasNext()) {
                    qd.d.d(g0Var);
                    return;
                }
                a aVar = new a(g0Var, it);
                g0Var.onSubscribe(aVar);
                if (!aVar.f١٩٨٠٨d) {
                    aVar.b();
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
