package yd;

import fe.i;
import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.z;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import pd.o;
import sd.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a extends io.reactivex.rxjava3.core.b {

    /* renamed from: a, reason: collision with root package name */
    final z f١٩٢٣٩a;

    /* renamed from: b, reason: collision with root package name */
    final o f١٩٢٤٠b;

    /* renamed from: c, reason: collision with root package name */
    final i f١٩٢٤١c;

    /* renamed from: d, reason: collision with root package name */
    final int f١٩٢٤٢d;

    /* renamed from: yd.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class C٠٢٤٨a extends AtomicInteger implements g0, nd.c {
        private static final long serialVersionUID = 3610901111000061034L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.d f١٩٢٤٣a;

        /* renamed from: b, reason: collision with root package name */
        final o f١٩٢٤٤b;

        /* renamed from: c, reason: collision with root package name */
        final i f١٩٢٤٥c;

        /* renamed from: d, reason: collision with root package name */
        final fe.c f١٩٢٤٦d = new fe.c();

        /* renamed from: e, reason: collision with root package name */
        final C٠٢٤٩a f١٩٢٤٧e = new C٠٢٤٩a(this);

        /* renamed from: f, reason: collision with root package name */
        final int f١٩٢٤٨f;

        /* renamed from: g, reason: collision with root package name */
        j f١٩٢٤٩g;

        /* renamed from: h, reason: collision with root package name */
        nd.c f١٩٢٥٠h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f١٩٢٥١i;

        /* renamed from: j, reason: collision with root package name */
        volatile boolean f١٩٢٥٢j;

        /* renamed from: k, reason: collision with root package name */
        volatile boolean f١٩٢٥٣k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: yd.a$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class C٠٢٤٩a extends AtomicReference implements io.reactivex.rxjava3.core.d {
            private static final long serialVersionUID = 5638352172918776687L;

            /* renamed from: a, reason: collision with root package name */
            final C٠٢٤٨a f١٩٢٥٤a;

            C٠٢٤٩a(C٠٢٤٨a r12) {
                this.f١٩٢٥٤a = r12;
            }

            void a() {
                qd.c.a(this);
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onComplete() {
                this.f١٩٢٥٤a.b();
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onError(Throwable th) {
                this.f١٩٢٥٤a.c(th);
            }

            @Override // io.reactivex.rxjava3.core.d
            public void onSubscribe(nd.c cVar) {
                qd.c.d(this, cVar);
            }
        }

        C٠٢٤٨a(io.reactivex.rxjava3.core.d dVar, o oVar, i iVar, int i10) {
            this.f١٩٢٤٣a = dVar;
            this.f١٩٢٤٤b = oVar;
            this.f١٩٢٤٥c = iVar;
            this.f١٩٢٤٨f = i10;
        }

        void a() {
            io.reactivex.rxjava3.core.f fVar;
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            fe.c cVar = this.f١٩٢٤٦d;
            i iVar = this.f١٩٢٤٥c;
            while (!this.f١٩٢٥٣k) {
                if (!this.f١٩٢٥١i) {
                    if (iVar == i.BOUNDARY && cVar.get() != null) {
                        this.f١٩٢٥٣k = true;
                        this.f١٩٢٤٩g.clear();
                        cVar.e(this.f١٩٢٤٣a);
                        return;
                    }
                    boolean z11 = this.f١٩٢٥٢j;
                    try {
                        Object poll = this.f١٩٢٤٩g.poll();
                        if (poll != null) {
                            Object apply = this.f١٩٢٤٤b.apply(poll);
                            Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                            fVar = (io.reactivex.rxjava3.core.f) apply;
                            z10 = false;
                        } else {
                            fVar = null;
                            z10 = true;
                        }
                        if (z11 && z10) {
                            this.f١٩٢٥٣k = true;
                            cVar.e(this.f١٩٢٤٣a);
                            return;
                        } else if (!z10) {
                            this.f١٩٢٥١i = true;
                            fVar.a(this.f١٩٢٤٧e);
                        }
                    } catch (Throwable th) {
                        od.b.b(th);
                        this.f١٩٢٥٣k = true;
                        this.f١٩٢٤٩g.clear();
                        this.f١٩٢٥٠h.dispose();
                        cVar.c(th);
                        cVar.e(this.f١٩٢٤٣a);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f١٩٢٤٩g.clear();
        }

        void b() {
            this.f١٩٢٥١i = false;
            a();
        }

        void c(Throwable th) {
            if (this.f١٩٢٤٦d.c(th)) {
                if (this.f١٩٢٤٥c == i.IMMEDIATE) {
                    this.f١٩٢٥٣k = true;
                    this.f١٩٢٥٠h.dispose();
                    this.f١٩٢٤٦d.e(this.f١٩٢٤٣a);
                    if (getAndIncrement() == 0) {
                        this.f١٩٢٤٩g.clear();
                        return;
                    }
                    return;
                }
                this.f١٩٢٥١i = false;
                a();
            }
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٢٥٣k = true;
            this.f١٩٢٥٠h.dispose();
            this.f١٩٢٤٧e.a();
            this.f١٩٢٤٦d.d();
            if (getAndIncrement() == 0) {
                this.f١٩٢٤٩g.clear();
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٢٥٣k;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٢٥٢j = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٢٤٦d.c(th)) {
                if (this.f١٩٢٤٥c == i.IMMEDIATE) {
                    this.f١٩٢٥٣k = true;
                    this.f١٩٢٤٧e.a();
                    this.f١٩٢٤٦d.e(this.f١٩٢٤٣a);
                    if (getAndIncrement() == 0) {
                        this.f١٩٢٤٩g.clear();
                        return;
                    }
                    return;
                }
                this.f١٩٢٥٢j = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (obj != null) {
                this.f١٩٢٤٩g.offer(obj);
            }
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٢٥٠h, cVar)) {
                this.f١٩٢٥٠h = cVar;
                if (cVar instanceof sd.e) {
                    sd.e eVar = (sd.e) cVar;
                    int a10 = eVar.a(3);
                    if (a10 == 1) {
                        this.f١٩٢٤٩g = eVar;
                        this.f١٩٢٥٢j = true;
                        this.f١٩٢٤٣a.onSubscribe(this);
                        a();
                        return;
                    }
                    if (a10 == 2) {
                        this.f١٩٢٤٩g = eVar;
                        this.f١٩٢٤٣a.onSubscribe(this);
                        return;
                    }
                }
                this.f١٩٢٤٩g = new be.c(this.f١٩٢٤٨f);
                this.f١٩٢٤٣a.onSubscribe(this);
            }
        }
    }

    public a(z zVar, o oVar, i iVar, int i10) {
        this.f١٩٢٣٩a = zVar;
        this.f١٩٢٤٠b = oVar;
        this.f١٩٢٤١c = iVar;
        this.f١٩٢٤٢d = i10;
    }

    @Override // io.reactivex.rxjava3.core.b
    protected void e(io.reactivex.rxjava3.core.d dVar) {
        if (!g.a(this.f١٩٢٣٩a, this.f١٩٢٤٠b, dVar)) {
            this.f١٩٢٣٩a.subscribe(new C٠٢٤٨a(dVar, this.f١٩٢٤٠b, this.f١٩٢٤١c, this.f١٩٢٤٢d));
        }
    }
}
