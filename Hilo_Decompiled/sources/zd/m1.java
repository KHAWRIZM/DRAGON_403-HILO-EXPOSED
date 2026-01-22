package zd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class m1 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٠٥٩b;

    /* renamed from: c, reason: collision with root package name */
    final pd.o f٢٠٠٦٠c;

    /* renamed from: d, reason: collision with root package name */
    final int f٢٠٠٦١d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f٢٠٠٦٢e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: i, reason: collision with root package name */
        static final Object f٢٠٠٦٣i = new Object();
        private static final long serialVersionUID = -3688291656102519502L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٠٦٤a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f٢٠٠٦٥b;

        /* renamed from: c, reason: collision with root package name */
        final pd.o f٢٠٠٦٦c;

        /* renamed from: d, reason: collision with root package name */
        final int f٢٠٠٦٧d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f٢٠٠٦٨e;

        /* renamed from: g, reason: collision with root package name */
        nd.c f٢٠٠٧٠g;

        /* renamed from: h, reason: collision with root package name */
        final AtomicBoolean f٢٠٠٧١h = new AtomicBoolean();

        /* renamed from: f, reason: collision with root package name */
        final Map f٢٠٠٦٩f = new ConcurrentHashMap();

        public a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, pd.o oVar2, int i10, boolean z10) {
            this.f٢٠٠٦٤a = g0Var;
            this.f٢٠٠٦٥b = oVar;
            this.f٢٠٠٦٦c = oVar2;
            this.f٢٠٠٦٧d = i10;
            this.f٢٠٠٦٨e = z10;
            lazySet(1);
        }

        public void a(Object obj) {
            if (obj == null) {
                obj = f٢٠٠٦٣i;
            }
            this.f٢٠٠٦٩f.remove(obj);
            if (decrementAndGet() == 0) {
                this.f٢٠٠٧٠g.dispose();
            }
        }

        @Override // nd.c
        public void dispose() {
            if (this.f٢٠٠٧١h.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f٢٠٠٧٠g.dispose();
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٠٧١h.get();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.f٢٠٠٦٩f.values());
            this.f٢٠٠٦٩f.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onComplete();
            }
            this.f٢٠٠٦٤a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.f٢٠٠٦٩f.values());
            this.f٢٠٠٦٩f.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onError(th);
            }
            this.f٢٠٠٦٤a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            Object obj2;
            boolean z10;
            try {
                Object apply = this.f٢٠٠٦٥b.apply(obj);
                if (apply != null) {
                    obj2 = apply;
                } else {
                    obj2 = f٢٠٠٦٣i;
                }
                b bVar = (b) this.f٢٠٠٦٩f.get(obj2);
                if (bVar == null) {
                    if (this.f٢٠٠٧١h.get()) {
                        return;
                    }
                    bVar = b.d(apply, this.f٢٠٠٦٧d, this, this.f٢٠٠٦٨e);
                    this.f٢٠٠٦٩f.put(obj2, bVar);
                    getAndIncrement();
                    z10 = true;
                } else {
                    z10 = false;
                }
                try {
                    Object apply2 = this.f٢٠٠٦٦c.apply(obj);
                    Objects.requireNonNull(apply2, "The value supplied is null");
                    bVar.onNext(apply2);
                    if (z10) {
                        this.f٢٠٠٦٤a.onNext(bVar);
                        if (bVar.f٢٠٠٧٢b.g()) {
                            a(apply);
                            bVar.onComplete();
                        }
                    }
                } catch (Throwable th) {
                    od.b.b(th);
                    this.f٢٠٠٧٠g.dispose();
                    if (z10) {
                        this.f٢٠٠٦٤a.onNext(bVar);
                    }
                    onError(th);
                }
            } catch (Throwable th2) {
                od.b.b(th2);
                this.f٢٠٠٧٠g.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٠٧٠g, cVar)) {
                this.f٢٠٠٧٠g = cVar;
                this.f٢٠٠٦٤a.onSubscribe(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b extends ge.b {

        /* renamed from: b, reason: collision with root package name */
        final c f٢٠٠٧٢b;

        protected b(Object obj, c cVar) {
            super(obj);
            this.f٢٠٠٧٢b = cVar;
        }

        public static b d(Object obj, int i10, a aVar, boolean z10) {
            return new b(obj, new c(i10, aVar, obj, z10));
        }

        public void onComplete() {
            this.f٢٠٠٧٢b.d();
        }

        public void onError(Throwable th) {
            this.f٢٠٠٧٢b.e(th);
        }

        public void onNext(Object obj) {
            this.f٢٠٠٧٢b.f(obj);
        }

        @Override // io.reactivex.rxjava3.core.z
        protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٠٧٢b.subscribe(g0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class c extends AtomicInteger implements nd.c, io.reactivex.rxjava3.core.e0 {
        private static final long serialVersionUID = -3852313036005250360L;

        /* renamed from: a, reason: collision with root package name */
        final Object f٢٠٠٧٣a;

        /* renamed from: b, reason: collision with root package name */
        final be.c f٢٠٠٧٤b;

        /* renamed from: c, reason: collision with root package name */
        final a f٢٠٠٧٥c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f٢٠٠٧٦d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f٢٠٠٧٧e;

        /* renamed from: f, reason: collision with root package name */
        Throwable f٢٠٠٧٨f;

        /* renamed from: g, reason: collision with root package name */
        final AtomicBoolean f٢٠٠٧٩g = new AtomicBoolean();

        /* renamed from: h, reason: collision with root package name */
        final AtomicReference f٢٠٠٨٠h = new AtomicReference();

        /* renamed from: i, reason: collision with root package name */
        final AtomicInteger f٢٠٠٨١i = new AtomicInteger();

        c(int i10, a aVar, Object obj, boolean z10) {
            this.f٢٠٠٧٤b = new be.c(i10);
            this.f٢٠٠٧٥c = aVar;
            this.f٢٠٠٧٣a = obj;
            this.f٢٠٠٧٦d = z10;
        }

        void a() {
            if ((this.f٢٠٠٨١i.get() & 2) == 0) {
                this.f٢٠٠٧٥c.a(this.f٢٠٠٧٣a);
            }
        }

        boolean b(boolean z10, boolean z11, io.reactivex.rxjava3.core.g0 g0Var, boolean z12) {
            if (this.f٢٠٠٧٩g.get()) {
                this.f٢٠٠٧٤b.clear();
                this.f٢٠٠٨٠h.lazySet(null);
                a();
                return true;
            }
            if (z10) {
                if (z12) {
                    if (z11) {
                        Throwable th = this.f٢٠٠٧٨f;
                        this.f٢٠٠٨٠h.lazySet(null);
                        if (th != null) {
                            g0Var.onError(th);
                        } else {
                            g0Var.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f٢٠٠٧٨f;
                if (th2 != null) {
                    this.f٢٠٠٧٤b.clear();
                    this.f٢٠٠٨٠h.lazySet(null);
                    g0Var.onError(th2);
                    return true;
                }
                if (z11) {
                    this.f٢٠٠٨٠h.lazySet(null);
                    g0Var.onComplete();
                    return true;
                }
                return false;
            }
            return false;
        }

        void c() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            be.c cVar = this.f٢٠٠٧٤b;
            boolean z11 = this.f٢٠٠٧٦d;
            io.reactivex.rxjava3.core.g0 g0Var = (io.reactivex.rxjava3.core.g0) this.f٢٠٠٨٠h.get();
            int i10 = 1;
            while (true) {
                if (g0Var != null) {
                    while (true) {
                        boolean z12 = this.f٢٠٠٧٧e;
                        Object poll = cVar.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (b(z12, z10, g0Var, z11)) {
                            return;
                        }
                        if (z10) {
                            break;
                        } else {
                            g0Var.onNext(poll);
                        }
                    }
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
                if (g0Var == null) {
                    g0Var = (io.reactivex.rxjava3.core.g0) this.f٢٠٠٨٠h.get();
                }
            }
        }

        public void d() {
            this.f٢٠٠٧٧e = true;
            c();
        }

        @Override // nd.c
        public void dispose() {
            if (this.f٢٠٠٧٩g.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f٢٠٠٨٠h.lazySet(null);
                a();
            }
        }

        public void e(Throwable th) {
            this.f٢٠٠٧٨f = th;
            this.f٢٠٠٧٧e = true;
            c();
        }

        public void f(Object obj) {
            this.f٢٠٠٧٤b.offer(obj);
            c();
        }

        boolean g() {
            if (this.f٢٠٠٨١i.get() != 0 || !this.f٢٠٠٨١i.compareAndSet(0, 2)) {
                return false;
            }
            return true;
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٠٧٩g.get();
        }

        @Override // io.reactivex.rxjava3.core.e0
        public void subscribe(io.reactivex.rxjava3.core.g0 g0Var) {
            int i10;
            do {
                i10 = this.f٢٠٠٨١i.get();
                if ((i10 & 1) != 0) {
                    qd.d.f(new IllegalStateException("Only one Observer allowed!"), g0Var);
                    return;
                }
            } while (!this.f٢٠٠٨١i.compareAndSet(i10, i10 | 1));
            g0Var.onSubscribe(this);
            this.f٢٠٠٨٠h.lazySet(g0Var);
            if (this.f٢٠٠٧٩g.get()) {
                this.f٢٠٠٨٠h.lazySet(null);
            } else {
                c();
            }
        }
    }

    public m1(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, pd.o oVar2, int i10, boolean z10) {
        super(e0Var);
        this.f٢٠٠٥٩b = oVar;
        this.f٢٠٠٦٠c = oVar2;
        this.f٢٠٠٦١d = i10;
        this.f٢٠٠٦٢e = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٠٥٩b, this.f٢٠٠٦٠c, this.f٢٠٠٦١d, this.f٢٠٠٦٢e));
    }
}
