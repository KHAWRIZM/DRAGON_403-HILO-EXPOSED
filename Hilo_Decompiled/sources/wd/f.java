package wd;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class f extends wd.a {

    /* renamed from: c, reason: collision with root package name */
    final h0 f١٨٧٤٨c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f١٨٧٤٩d;

    /* renamed from: e, reason: collision with root package name */
    final int f١٨٧٥٠e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static abstract class a extends ee.a implements io.reactivex.rxjava3.core.i, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;

        /* renamed from: a, reason: collision with root package name */
        final h0.c f١٨٧٥١a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f١٨٧٥٢b;

        /* renamed from: c, reason: collision with root package name */
        final int f١٨٧٥٣c;

        /* renamed from: d, reason: collision with root package name */
        final int f١٨٧٥٤d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicLong f١٨٧٥٥e = new AtomicLong();

        /* renamed from: f, reason: collision with root package name */
        kf.c f١٨٧٥٦f;

        /* renamed from: g, reason: collision with root package name */
        sd.j f١٨٧٥٧g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f١٨٧٥٨h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f١٨٧٥٩i;

        /* renamed from: j, reason: collision with root package name */
        Throwable f١٨٧٦٠j;

        /* renamed from: k, reason: collision with root package name */
        int f١٨٧٦١k;

        /* renamed from: l, reason: collision with root package name */
        long f١٨٧٦٢l;

        /* renamed from: m, reason: collision with root package name */
        boolean f١٨٧٦٣m;

        a(h0.c cVar, boolean z10, int i10) {
            this.f١٨٧٥١a = cVar;
            this.f١٨٧٥٢b = z10;
            this.f١٨٧٥٣c = i10;
            this.f١٨٧٥٤d = i10 - (i10 >> 2);
        }

        @Override // sd.f
        public final int a(int i10) {
            if ((i10 & 2) != 0) {
                this.f١٨٧٦٣m = true;
                return 2;
            }
            return 0;
        }

        final boolean b(boolean z10, boolean z11, kf.b bVar) {
            if (this.f١٨٧٥٨h) {
                clear();
                return true;
            }
            if (z10) {
                if (this.f١٨٧٥٢b) {
                    if (z11) {
                        this.f١٨٧٥٨h = true;
                        Throwable th = this.f١٨٧٦٠j;
                        if (th != null) {
                            bVar.onError(th);
                        } else {
                            bVar.onComplete();
                        }
                        this.f١٨٧٥١a.dispose();
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f١٨٧٦٠j;
                if (th2 != null) {
                    this.f١٨٧٥٨h = true;
                    clear();
                    bVar.onError(th2);
                    this.f١٨٧٥١a.dispose();
                    return true;
                }
                if (z11) {
                    this.f١٨٧٥٨h = true;
                    bVar.onComplete();
                    this.f١٨٧٥١a.dispose();
                    return true;
                }
                return false;
            }
            return false;
        }

        public final void cancel() {
            if (this.f١٨٧٥٨h) {
                return;
            }
            this.f١٨٧٥٨h = true;
            this.f١٨٧٥٦f.cancel();
            this.f١٨٧٥١a.dispose();
            if (!this.f١٨٧٦٣m && getAndIncrement() == 0) {
                this.f١٨٧٥٧g.clear();
            }
        }

        @Override // sd.j
        public final void clear() {
            this.f١٨٧٥٧g.clear();
        }

        abstract void d();

        abstract void e();

        abstract void f();

        final void g() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.f١٨٧٥١a.schedule(this);
        }

        @Override // sd.j
        public final boolean isEmpty() {
            return this.f١٨٧٥٧g.isEmpty();
        }

        public final void onComplete() {
            if (!this.f١٨٧٥٩i) {
                this.f١٨٧٥٩i = true;
                g();
            }
        }

        public final void onError(Throwable th) {
            if (this.f١٨٧٥٩i) {
                ie.a.s(th);
                return;
            }
            this.f١٨٧٦٠j = th;
            this.f١٨٧٥٩i = true;
            g();
        }

        public final void onNext(Object obj) {
            if (this.f١٨٧٥٩i) {
                return;
            }
            if (this.f١٨٧٦١k == 2) {
                g();
                return;
            }
            if (!this.f١٨٧٥٧g.offer(obj)) {
                this.f١٨٧٥٦f.cancel();
                this.f١٨٧٦٠j = new od.c("Queue is full?!");
                this.f١٨٧٥٩i = true;
            }
            g();
        }

        public final void request(long j10) {
            if (ee.c.g(j10)) {
                fe.d.a(this.f١٨٧٥٥e, j10);
                g();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f١٨٧٦٣m) {
                e();
            } else if (this.f١٨٧٦١k == 1) {
                f();
            } else {
                d();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends a {
        private static final long serialVersionUID = 644624475404284533L;

        /* renamed from: n, reason: collision with root package name */
        final sd.c f١٨٧٦٤n;

        /* renamed from: o, reason: collision with root package name */
        long f١٨٧٦٥o;

        b(sd.c cVar, h0.c cVar2, boolean z10, int i10) {
            super(cVar2, z10, i10);
            this.f١٨٧٦٤n = cVar;
        }

        @Override // wd.f.a
        void d() {
            boolean z10;
            sd.c cVar = this.f١٨٧٦٤n;
            sd.j jVar = this.f١٨٧٥٧g;
            long j10 = this.f١٨٧٦٢l;
            long j11 = this.f١٨٧٦٥o;
            int i10 = 1;
            do {
                long j12 = this.f١٨٧٥٥e.get();
                while (j10 != j12) {
                    boolean z11 = this.f١٨٧٥٩i;
                    try {
                        Object poll = jVar.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (b(z11, z10, cVar)) {
                            return;
                        }
                        if (z10) {
                            break;
                        }
                        if (cVar.c(poll)) {
                            j10++;
                        }
                        j11++;
                        if (j11 == this.f١٨٧٥٤d) {
                            this.f١٨٧٥٦f.request(j11);
                            j11 = 0;
                        }
                    } catch (Throwable th) {
                        od.b.b(th);
                        this.f١٨٧٥٨h = true;
                        this.f١٨٧٥٦f.cancel();
                        jVar.clear();
                        cVar.onError(th);
                        this.f١٨٧٥١a.dispose();
                        return;
                    }
                }
                if (j10 == j12 && b(this.f١٨٧٥٩i, jVar.isEmpty(), cVar)) {
                    return;
                }
                this.f١٨٧٦٢l = j10;
                this.f١٨٧٦٥o = j11;
                i10 = addAndGet(-i10);
            } while (i10 != 0);
        }

        @Override // wd.f.a
        void e() {
            int i10 = 1;
            while (!this.f١٨٧٥٨h) {
                boolean z10 = this.f١٨٧٥٩i;
                this.f١٨٧٦٤n.onNext((Object) null);
                if (z10) {
                    this.f١٨٧٥٨h = true;
                    Throwable th = this.f١٨٧٦٠j;
                    if (th != null) {
                        this.f١٨٧٦٤n.onError(th);
                    } else {
                        this.f١٨٧٦٤n.onComplete();
                    }
                    this.f١٨٧٥١a.dispose();
                    return;
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }

        @Override // wd.f.a
        void f() {
            sd.c cVar = this.f١٨٧٦٤n;
            sd.j jVar = this.f١٨٧٥٧g;
            long j10 = this.f١٨٧٦٢l;
            int i10 = 1;
            do {
                long j11 = this.f١٨٧٥٥e.get();
                while (j10 != j11) {
                    try {
                        Object poll = jVar.poll();
                        if (this.f١٨٧٥٨h) {
                            return;
                        }
                        if (poll == null) {
                            this.f١٨٧٥٨h = true;
                            cVar.onComplete();
                            this.f١٨٧٥١a.dispose();
                            return;
                        } else if (cVar.c(poll)) {
                            j10++;
                        }
                    } catch (Throwable th) {
                        od.b.b(th);
                        this.f١٨٧٥٨h = true;
                        this.f١٨٧٥٦f.cancel();
                        cVar.onError(th);
                        this.f١٨٧٥١a.dispose();
                        return;
                    }
                }
                if (this.f١٨٧٥٨h) {
                    return;
                }
                if (jVar.isEmpty()) {
                    this.f١٨٧٥٨h = true;
                    cVar.onComplete();
                    this.f١٨٧٥١a.dispose();
                    return;
                }
                this.f١٨٧٦٢l = j10;
                i10 = addAndGet(-i10);
            } while (i10 != 0);
        }

        @Override // io.reactivex.rxjava3.core.i
        public void onSubscribe(kf.c cVar) {
            if (ee.c.h(this.f١٨٧٥٦f, cVar)) {
                this.f١٨٧٥٦f = cVar;
                if (cVar instanceof sd.g) {
                    sd.g gVar = (sd.g) cVar;
                    int a10 = gVar.a(7);
                    if (a10 == 1) {
                        this.f١٨٧٦١k = 1;
                        this.f١٨٧٥٧g = gVar;
                        this.f١٨٧٥٩i = true;
                        this.f١٨٧٦٤n.onSubscribe(this);
                        return;
                    }
                    if (a10 == 2) {
                        this.f١٨٧٦١k = 2;
                        this.f١٨٧٥٧g = gVar;
                        this.f١٨٧٦٤n.onSubscribe(this);
                        cVar.request(this.f١٨٧٥٣c);
                        return;
                    }
                }
                this.f١٨٧٥٧g = new be.b(this.f١٨٧٥٣c);
                this.f١٨٧٦٤n.onSubscribe(this);
                cVar.request(this.f١٨٧٥٣c);
            }
        }

        @Override // sd.j
        public Object poll() {
            Object poll = this.f١٨٧٥٧g.poll();
            if (poll != null && this.f١٨٧٦١k != 1) {
                long j10 = this.f١٨٧٦٥o + 1;
                if (j10 == this.f١٨٧٥٤d) {
                    this.f١٨٧٦٥o = 0L;
                    this.f١٨٧٥٦f.request(j10);
                } else {
                    this.f١٨٧٦٥o = j10;
                }
            }
            return poll;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class c extends a implements io.reactivex.rxjava3.core.i {
        private static final long serialVersionUID = -4547113800637756442L;

        /* renamed from: n, reason: collision with root package name */
        final kf.b f١٨٧٦٦n;

        c(kf.b bVar, h0.c cVar, boolean z10, int i10) {
            super(cVar, z10, i10);
            this.f١٨٧٦٦n = bVar;
        }

        @Override // wd.f.a
        void d() {
            boolean z10;
            kf.b bVar = this.f١٨٧٦٦n;
            sd.j jVar = this.f١٨٧٥٧g;
            long j10 = this.f١٨٧٦٢l;
            int i10 = 1;
            while (true) {
                long j11 = this.f١٨٧٥٥e.get();
                while (j10 != j11) {
                    boolean z11 = this.f١٨٧٥٩i;
                    try {
                        Object poll = jVar.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (b(z11, z10, bVar)) {
                            return;
                        }
                        if (z10) {
                            break;
                        }
                        bVar.onNext(poll);
                        j10++;
                        if (j10 == this.f١٨٧٥٤d) {
                            if (j11 != LongCompanionObject.MAX_VALUE) {
                                j11 = this.f١٨٧٥٥e.addAndGet(-j10);
                            }
                            this.f١٨٧٥٦f.request(j10);
                            j10 = 0;
                        }
                    } catch (Throwable th) {
                        od.b.b(th);
                        this.f١٨٧٥٨h = true;
                        this.f١٨٧٥٦f.cancel();
                        jVar.clear();
                        bVar.onError(th);
                        this.f١٨٧٥١a.dispose();
                        return;
                    }
                }
                if (j10 == j11 && b(this.f١٨٧٥٩i, jVar.isEmpty(), bVar)) {
                    return;
                }
                int i11 = get();
                if (i10 == i11) {
                    this.f١٨٧٦٢l = j10;
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    i10 = i11;
                }
            }
        }

        @Override // wd.f.a
        void e() {
            int i10 = 1;
            while (!this.f١٨٧٥٨h) {
                boolean z10 = this.f١٨٧٥٩i;
                this.f١٨٧٦٦n.onNext((Object) null);
                if (z10) {
                    this.f١٨٧٥٨h = true;
                    Throwable th = this.f١٨٧٦٠j;
                    if (th != null) {
                        this.f١٨٧٦٦n.onError(th);
                    } else {
                        this.f١٨٧٦٦n.onComplete();
                    }
                    this.f١٨٧٥١a.dispose();
                    return;
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }

        @Override // wd.f.a
        void f() {
            kf.b bVar = this.f١٨٧٦٦n;
            sd.j jVar = this.f١٨٧٥٧g;
            long j10 = this.f١٨٧٦٢l;
            int i10 = 1;
            do {
                long j11 = this.f١٨٧٥٥e.get();
                while (j10 != j11) {
                    try {
                        Object poll = jVar.poll();
                        if (this.f١٨٧٥٨h) {
                            return;
                        }
                        if (poll == null) {
                            this.f١٨٧٥٨h = true;
                            bVar.onComplete();
                            this.f١٨٧٥١a.dispose();
                            return;
                        }
                        bVar.onNext(poll);
                        j10++;
                    } catch (Throwable th) {
                        od.b.b(th);
                        this.f١٨٧٥٨h = true;
                        this.f١٨٧٥٦f.cancel();
                        bVar.onError(th);
                        this.f١٨٧٥١a.dispose();
                        return;
                    }
                }
                if (this.f١٨٧٥٨h) {
                    return;
                }
                if (jVar.isEmpty()) {
                    this.f١٨٧٥٨h = true;
                    bVar.onComplete();
                    this.f١٨٧٥١a.dispose();
                    return;
                }
                this.f١٨٧٦٢l = j10;
                i10 = addAndGet(-i10);
            } while (i10 != 0);
        }

        @Override // io.reactivex.rxjava3.core.i
        public void onSubscribe(kf.c cVar) {
            if (ee.c.h(this.f١٨٧٥٦f, cVar)) {
                this.f١٨٧٥٦f = cVar;
                if (cVar instanceof sd.g) {
                    sd.g gVar = (sd.g) cVar;
                    int a10 = gVar.a(7);
                    if (a10 == 1) {
                        this.f١٨٧٦١k = 1;
                        this.f١٨٧٥٧g = gVar;
                        this.f١٨٧٥٩i = true;
                        this.f١٨٧٦٦n.onSubscribe(this);
                        return;
                    }
                    if (a10 == 2) {
                        this.f١٨٧٦١k = 2;
                        this.f١٨٧٥٧g = gVar;
                        this.f١٨٧٦٦n.onSubscribe(this);
                        cVar.request(this.f١٨٧٥٣c);
                        return;
                    }
                }
                this.f١٨٧٥٧g = new be.b(this.f١٨٧٥٣c);
                this.f١٨٧٦٦n.onSubscribe(this);
                cVar.request(this.f١٨٧٥٣c);
            }
        }

        @Override // sd.j
        public Object poll() {
            Object poll = this.f١٨٧٥٧g.poll();
            if (poll != null && this.f١٨٧٦١k != 1) {
                long j10 = this.f١٨٧٦٢l + 1;
                if (j10 == this.f١٨٧٥٤d) {
                    this.f١٨٧٦٢l = 0L;
                    this.f١٨٧٥٦f.request(j10);
                } else {
                    this.f١٨٧٦٢l = j10;
                }
            }
            return poll;
        }
    }

    public f(io.reactivex.rxjava3.core.h hVar, h0 h0Var, boolean z10, int i10) {
        super(hVar);
        this.f١٨٧٤٨c = h0Var;
        this.f١٨٧٤٩d = z10;
        this.f١٨٧٥٠e = i10;
    }

    @Override // io.reactivex.rxjava3.core.h
    public void p(kf.b bVar) {
        h0.c createWorker = this.f١٨٧٤٨c.createWorker();
        if (bVar instanceof sd.c) {
            this.f١٨٧٣٨b.o(new b((sd.c) bVar, createWorker, this.f١٨٧٤٩d, this.f١٨٧٥٠e));
        } else {
            this.f١٨٧٣٨b.o(new c(bVar, createWorker, this.f١٨٧٤٩d, this.f١٨٧٥٠e));
        }
    }
}
