package yd;

import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.z;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import pd.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d extends io.reactivex.rxjava3.core.b {

    /* renamed from: a, reason: collision with root package name */
    final z f١٩٢٨٧a;

    /* renamed from: b, reason: collision with root package name */
    final o f١٩٢٨٨b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f١٩٢٨٩c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements g0, nd.c {

        /* renamed from: h, reason: collision with root package name */
        static final C٠٢٥٢a f١٩٢٩٠h = new C٠٢٥٢a(null);

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.d f١٩٢٩١a;

        /* renamed from: b, reason: collision with root package name */
        final o f١٩٢٩٢b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f١٩٢٩٣c;

        /* renamed from: d, reason: collision with root package name */
        final fe.c f١٩٢٩٤d = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference f١٩٢٩٥e = new AtomicReference();

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f١٩٢٩٦f;

        /* renamed from: g, reason: collision with root package name */
        nd.c f١٩٢٩٧g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: yd.d$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class C٠٢٥٢a extends AtomicReference implements io.reactivex.rxjava3.core.d {
            private static final long serialVersionUID = -8003404460084760287L;

            /* renamed from: a, reason: collision with root package name */
            final a f١٩٢٩٨a;

            C٠٢٥٢a(a aVar) {
                this.f١٩٢٩٨a = aVar;
            }

            void a() {
                qd.c.a(this);
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onComplete() {
                this.f١٩٢٩٨a.b(this);
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onError(Throwable th) {
                this.f١٩٢٩٨a.c(this, th);
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onSubscribe(nd.c cVar) {
                qd.c.g(this, cVar);
            }
        }

        a(io.reactivex.rxjava3.core.d dVar, o oVar, boolean z10) {
            this.f١٩٢٩١a = dVar;
            this.f١٩٢٩٢b = oVar;
            this.f١٩٢٩٣c = z10;
        }

        void a() {
            AtomicReference atomicReference = this.f١٩٢٩٥e;
            C٠٢٥٢a r12 = f١٩٢٩٠h;
            C٠٢٥٢a r02 = (C٠٢٥٢a) atomicReference.getAndSet(r12);
            if (r02 != null && r02 != r12) {
                r02.a();
            }
        }

        void b(C٠٢٥٢a r32) {
            if (androidx.lifecycle.a.a(this.f١٩٢٩٥e, r32, null) && this.f١٩٢٩٦f) {
                this.f١٩٢٩٤d.e(this.f١٩٢٩١a);
            }
        }

        void c(C٠٢٥٢a r32, Throwable th) {
            if (androidx.lifecycle.a.a(this.f١٩٢٩٥e, r32, null)) {
                if (this.f١٩٢٩٤d.c(th)) {
                    if (this.f١٩٢٩٣c) {
                        if (this.f١٩٢٩٦f) {
                            this.f١٩٢٩٤d.e(this.f١٩٢٩١a);
                            return;
                        }
                        return;
                    } else {
                        this.f١٩٢٩٧g.dispose();
                        a();
                        this.f١٩٢٩٤d.e(this.f١٩٢٩١a);
                        return;
                    }
                }
                return;
            }
            ie.a.s(th);
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٢٩٧g.dispose();
            a();
            this.f١٩٢٩٤d.d();
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (this.f١٩٢٩٥e.get() == f١٩٢٩٠h) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٢٩٦f = true;
            if (this.f١٩٢٩٥e.get() == null) {
                this.f١٩٢٩٤d.e(this.f١٩٢٩١a);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٢٩٤d.c(th)) {
                if (this.f١٩٢٩٣c) {
                    onComplete();
                } else {
                    a();
                    this.f١٩٢٩٤d.e(this.f١٩٢٩١a);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            C٠٢٥٢a r12;
            try {
                Object apply = this.f١٩٢٩٢b.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                io.reactivex.rxjava3.core.f fVar = (io.reactivex.rxjava3.core.f) apply;
                C٠٢٥٢a r02 = new C٠٢٥٢a(this);
                do {
                    r12 = (C٠٢٥٢a) this.f١٩٢٩٥e.get();
                    if (r12 == f١٩٢٩٠h) {
                        return;
                    }
                } while (!androidx.lifecycle.a.a(this.f١٩٢٩٥e, r12, r02));
                if (r12 != null) {
                    r12.a();
                }
                fVar.a(r02);
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٢٩٧g.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٢٩٧g, cVar)) {
                this.f١٩٢٩٧g = cVar;
                this.f١٩٢٩١a.onSubscribe(this);
            }
        }
    }

    public d(z zVar, o oVar, boolean z10) {
        this.f١٩٢٨٧a = zVar;
        this.f١٩٢٨٨b = oVar;
        this.f١٩٢٨٩c = z10;
    }

    @Override // io.reactivex.rxjava3.core.b
    protected void e(io.reactivex.rxjava3.core.d dVar) {
        if (!g.a(this.f١٩٢٨٧a, this.f١٩٢٨٨b, dVar)) {
            this.f١٩٢٨٧a.subscribe(new a(dVar, this.f١٩٢٨٨b, this.f١٩٢٨٩c));
        }
    }
}
