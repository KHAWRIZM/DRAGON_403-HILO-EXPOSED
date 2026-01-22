package yd;

import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.l;
import io.reactivex.rxjava3.core.n;
import io.reactivex.rxjava3.core.z;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import pd.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e extends z {

    /* renamed from: a, reason: collision with root package name */
    final z f١٩٢٩٩a;

    /* renamed from: b, reason: collision with root package name */
    final o f١٩٣٠٠b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f١٩٣٠١c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements g0, nd.c {

        /* renamed from: i, reason: collision with root package name */
        static final C٠٢٥٣a f١٩٣٠٢i = new C٠٢٥٣a(null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: a, reason: collision with root package name */
        final g0 f١٩٣٠٣a;

        /* renamed from: b, reason: collision with root package name */
        final o f١٩٣٠٤b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f١٩٣٠٥c;

        /* renamed from: d, reason: collision with root package name */
        final fe.c f١٩٣٠٦d = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference f١٩٣٠٧e = new AtomicReference();

        /* renamed from: f, reason: collision with root package name */
        nd.c f١٩٣٠٨f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f١٩٣٠٩g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f١٩٣١٠h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: yd.e$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class C٠٢٥٣a extends AtomicReference implements l {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: a, reason: collision with root package name */
            final a f١٩٣١١a;

            /* renamed from: b, reason: collision with root package name */
            volatile Object f١٩٣١٢b;

            C٠٢٥٣a(a aVar) {
                this.f١٩٣١١a = aVar;
            }

            void a() {
                qd.c.a(this);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                this.f١٩٣١١a.c(this);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                this.f١٩٣١١a.d(this, th);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }

            @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSuccess(Object obj) {
                this.f١٩٣١٢b = obj;
                this.f١٩٣١١a.b();
            }
        }

        a(g0 g0Var, o oVar, boolean z10) {
            this.f١٩٣٠٣a = g0Var;
            this.f١٩٣٠٤b = oVar;
            this.f١٩٣٠٥c = z10;
        }

        void a() {
            AtomicReference atomicReference = this.f١٩٣٠٧e;
            C٠٢٥٣a r12 = f١٩٣٠٢i;
            C٠٢٥٣a r02 = (C٠٢٥٣a) atomicReference.getAndSet(r12);
            if (r02 != null && r02 != r12) {
                r02.a();
            }
        }

        void b() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            g0 g0Var = this.f١٩٣٠٣a;
            fe.c cVar = this.f١٩٣٠٦d;
            AtomicReference atomicReference = this.f١٩٣٠٧e;
            int i10 = 1;
            while (!this.f١٩٣١٠h) {
                if (cVar.get() != null && !this.f١٩٣٠٥c) {
                    cVar.f(g0Var);
                    return;
                }
                boolean z11 = this.f١٩٣٠٩g;
                C٠٢٥٣a r62 = (C٠٢٥٣a) atomicReference.get();
                if (r62 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z11 && z10) {
                    cVar.f(g0Var);
                    return;
                } else if (!z10 && r62.f١٩٣١٢b != null) {
                    androidx.lifecycle.a.a(atomicReference, r62, null);
                    g0Var.onNext(r62.f١٩٣١٢b);
                } else {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            }
        }

        void c(C٠٢٥٣a r32) {
            if (androidx.lifecycle.a.a(this.f١٩٣٠٧e, r32, null)) {
                b();
            }
        }

        void d(C٠٢٥٣a r32, Throwable th) {
            if (androidx.lifecycle.a.a(this.f١٩٣٠٧e, r32, null)) {
                if (this.f١٩٣٠٦d.c(th)) {
                    if (!this.f١٩٣٠٥c) {
                        this.f١٩٣٠٨f.dispose();
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
            this.f١٩٣١٠h = true;
            this.f١٩٣٠٨f.dispose();
            a();
            this.f١٩٣٠٦d.d();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٣١٠h;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٣٠٩g = true;
            b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٣٠٦d.c(th)) {
                if (!this.f١٩٣٠٥c) {
                    a();
                }
                this.f١٩٣٠٩g = true;
                b();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            C٠٢٥٣a r12;
            C٠٢٥٣a r02 = (C٠٢٥٣a) this.f١٩٣٠٧e.get();
            if (r02 != null) {
                r02.a();
            }
            try {
                Object apply = this.f١٩٣٠٤b.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                n nVar = (n) apply;
                C٠٢٥٣a r03 = new C٠٢٥٣a(this);
                do {
                    r12 = (C٠٢٥٣a) this.f١٩٣٠٧e.get();
                    if (r12 == f١٩٣٠٢i) {
                        return;
                    }
                } while (!androidx.lifecycle.a.a(this.f١٩٣٠٧e, r12, r03));
                nVar.a(r03);
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٣٠٨f.dispose();
                this.f١٩٣٠٧e.getAndSet(f١٩٣٠٢i);
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٣٠٨f, cVar)) {
                this.f١٩٣٠٨f = cVar;
                this.f١٩٣٠٣a.onSubscribe(this);
            }
        }
    }

    public e(z zVar, o oVar, boolean z10) {
        this.f١٩٢٩٩a = zVar;
        this.f١٩٣٠٠b = oVar;
        this.f١٩٣٠١c = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        if (!g.b(this.f١٩٢٩٩a, this.f١٩٣٠٠b, g0Var)) {
            this.f١٩٢٩٩a.subscribe(new a(g0Var, this.f١٩٣٠٠b, this.f١٩٣٠١c));
        }
    }
}
