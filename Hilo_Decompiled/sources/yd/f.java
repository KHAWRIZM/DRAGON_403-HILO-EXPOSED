package yd;

import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.m0;
import io.reactivex.rxjava3.core.z;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import pd.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class f extends z {

    /* renamed from: a, reason: collision with root package name */
    final z f١٩٣١٣a;

    /* renamed from: b, reason: collision with root package name */
    final o f١٩٣١٤b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f١٩٣١٥c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements g0, nd.c {

        /* renamed from: i, reason: collision with root package name */
        static final C٠٢٥٤a f١٩٣١٦i = new C٠٢٥٤a(null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: a, reason: collision with root package name */
        final g0 f١٩٣١٧a;

        /* renamed from: b, reason: collision with root package name */
        final o f١٩٣١٨b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f١٩٣١٩c;

        /* renamed from: d, reason: collision with root package name */
        final fe.c f١٩٣٢٠d = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference f١٩٣٢١e = new AtomicReference();

        /* renamed from: f, reason: collision with root package name */
        nd.c f١٩٣٢٢f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f١٩٣٢٣g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f١٩٣٢٤h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: yd.f$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class C٠٢٥٤a extends AtomicReference implements k0 {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: a, reason: collision with root package name */
            final a f١٩٣٢٥a;

            /* renamed from: b, reason: collision with root package name */
            volatile Object f١٩٣٢٦b;

            C٠٢٥٤a(a aVar) {
                this.f١٩٣٢٥a = aVar;
            }

            void a() {
                qd.c.a(this);
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                this.f١٩٣٢٥a.c(this, th);
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }

            @Override // io.reactivex.rxjava3.core.k0
            public void onSuccess(Object obj) {
                this.f١٩٣٢٦b = obj;
                this.f١٩٣٢٥a.b();
            }
        }

        a(g0 g0Var, o oVar, boolean z10) {
            this.f١٩٣١٧a = g0Var;
            this.f١٩٣١٨b = oVar;
            this.f١٩٣١٩c = z10;
        }

        void a() {
            AtomicReference atomicReference = this.f١٩٣٢١e;
            C٠٢٥٤a r12 = f١٩٣١٦i;
            C٠٢٥٤a r02 = (C٠٢٥٤a) atomicReference.getAndSet(r12);
            if (r02 != null && r02 != r12) {
                r02.a();
            }
        }

        void b() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            g0 g0Var = this.f١٩٣١٧a;
            fe.c cVar = this.f١٩٣٢٠d;
            AtomicReference atomicReference = this.f١٩٣٢١e;
            int i10 = 1;
            while (!this.f١٩٣٢٤h) {
                if (cVar.get() != null && !this.f١٩٣١٩c) {
                    cVar.f(g0Var);
                    return;
                }
                boolean z11 = this.f١٩٣٢٣g;
                C٠٢٥٤a r62 = (C٠٢٥٤a) atomicReference.get();
                if (r62 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z11 && z10) {
                    cVar.f(g0Var);
                    return;
                } else if (!z10 && r62.f١٩٣٢٦b != null) {
                    androidx.lifecycle.a.a(atomicReference, r62, null);
                    g0Var.onNext(r62.f١٩٣٢٦b);
                } else {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            }
        }

        void c(C٠٢٥٤a r32, Throwable th) {
            if (androidx.lifecycle.a.a(this.f١٩٣٢١e, r32, null)) {
                if (this.f١٩٣٢٠d.c(th)) {
                    if (!this.f١٩٣١٩c) {
                        this.f١٩٣٢٢f.dispose();
                        a();
                    }
                    b();
                    return;
                }
                return;
            }
            ie.a.s(th);
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٣٢٤h = true;
            this.f١٩٣٢٢f.dispose();
            a();
            this.f١٩٣٢٠d.d();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٣٢٤h;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٣٢٣g = true;
            b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٣٢٠d.c(th)) {
                if (!this.f١٩٣١٩c) {
                    a();
                }
                this.f١٩٣٢٣g = true;
                b();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            C٠٢٥٤a r12;
            C٠٢٥٤a r02 = (C٠٢٥٤a) this.f١٩٣٢١e.get();
            if (r02 != null) {
                r02.a();
            }
            try {
                Object apply = this.f١٩٣١٨b.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                m0 m0Var = (m0) apply;
                C٠٢٥٤a r03 = new C٠٢٥٤a(this);
                do {
                    r12 = (C٠٢٥٤a) this.f١٩٣٢١e.get();
                    if (r12 == f١٩٣١٦i) {
                        return;
                    }
                } while (!androidx.lifecycle.a.a(this.f١٩٣٢١e, r12, r03));
                m0Var.a(r03);
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٣٢٢f.dispose();
                this.f١٩٣٢١e.getAndSet(f١٩٣١٦i);
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٣٢٢f, cVar)) {
                this.f١٩٣٢٢f = cVar;
                this.f١٩٣١٧a.onSubscribe(this);
            }
        }
    }

    public f(z zVar, o oVar, boolean z10) {
        this.f١٩٣١٣a = zVar;
        this.f١٩٣١٤b = oVar;
        this.f١٩٣١٥c = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        if (!g.c(this.f١٩٣١٣a, this.f١٩٣١٤b, g0Var)) {
            this.f١٩٣١٣a.subscribe(new a(g0Var, this.f١٩٣١٤b, this.f١٩٣١٥c));
        }
    }
}
