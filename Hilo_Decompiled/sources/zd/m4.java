package zd;

import io.reactivex.rxjava3.core.h0;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class m4 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٠٩٩b;

    /* renamed from: c, reason: collision with root package name */
    final long f٢٠١٠٠c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f٢٠١٠١d;

    /* renamed from: e, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠١٠٢e;

    /* renamed from: f, reason: collision with root package name */
    final long f٢٠١٠٣f;

    /* renamed from: g, reason: collision with root package name */
    final int f٢٠١٠٤g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f٢٠١٠٥h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static abstract class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 5724293814035355511L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠١٠٦a;

        /* renamed from: c, reason: collision with root package name */
        final long f٢٠١٠٨c;

        /* renamed from: d, reason: collision with root package name */
        final TimeUnit f٢٠١٠٩d;

        /* renamed from: e, reason: collision with root package name */
        final int f٢٠١١٠e;

        /* renamed from: f, reason: collision with root package name */
        long f٢٠١١١f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f٢٠١١٢g;

        /* renamed from: h, reason: collision with root package name */
        Throwable f٢٠١١٣h;

        /* renamed from: i, reason: collision with root package name */
        nd.c f٢٠١١٤i;

        /* renamed from: k, reason: collision with root package name */
        volatile boolean f٢٠١١٦k;

        /* renamed from: b, reason: collision with root package name */
        final sd.i f٢٠١٠٧b = new be.a();

        /* renamed from: j, reason: collision with root package name */
        final AtomicBoolean f٢٠١١٥j = new AtomicBoolean();

        /* renamed from: l, reason: collision with root package name */
        final AtomicInteger f٢٠١١٧l = new AtomicInteger(1);

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, int i10) {
            this.f٢٠١٠٦a = g0Var;
            this.f٢٠١٠٨c = j10;
            this.f٢٠١٠٩d = timeUnit;
            this.f٢٠١١٠e = i10;
        }

        abstract void a();

        abstract void b();

        abstract void c();

        final void d() {
            if (this.f٢٠١١٧l.decrementAndGet() == 0) {
                a();
                this.f٢٠١١٤i.dispose();
                this.f٢٠١١٦k = true;
                c();
            }
        }

        @Override // nd.c
        public final void dispose() {
            if (this.f٢٠١١٥j.compareAndSet(false, true)) {
                d();
            }
        }

        @Override // nd.c
        public final boolean isDisposed() {
            return this.f٢٠١١٥j.get();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public final void onComplete() {
            this.f٢٠١١٢g = true;
            c();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public final void onError(Throwable th) {
            this.f٢٠١١٣h = th;
            this.f٢٠١١٢g = true;
            c();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public final void onNext(Object obj) {
            this.f٢٠١٠٧b.offer(obj);
            c();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public final void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠١١٤i, cVar)) {
                this.f٢٠١١٤i = cVar;
                this.f٢٠١٠٦a.onSubscribe(this);
                b();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends a implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;

        /* renamed from: m, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f٢٠١١٨m;

        /* renamed from: n, reason: collision with root package name */
        final boolean f٢٠١١٩n;

        /* renamed from: o, reason: collision with root package name */
        final long f٢٠١٢٠o;

        /* renamed from: p, reason: collision with root package name */
        final h0.c f٢٠١٢١p;

        /* renamed from: q, reason: collision with root package name */
        long f٢٠١٢٢q;

        /* renamed from: r, reason: collision with root package name */
        le.d f٢٠١٢٣r;

        /* renamed from: s, reason: collision with root package name */
        final qd.f f٢٠١٢٤s;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final b f٢٠١٢٥a;

            /* renamed from: b, reason: collision with root package name */
            final long f٢٠١٢٦b;

            a(b bVar, long j10) {
                this.f٢٠١٢٥a = bVar;
                this.f٢٠١٢٦b = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f٢٠١٢٥a.e(this);
            }
        }

        b(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, int i10, long j11, boolean z10) {
            super(g0Var, j10, timeUnit, i10);
            this.f٢٠١١٨m = h0Var;
            this.f٢٠١٢٠o = j11;
            this.f٢٠١١٩n = z10;
            if (z10) {
                this.f٢٠١٢١p = h0Var.createWorker();
            } else {
                this.f٢٠١٢١p = null;
            }
            this.f٢٠١٢٤s = new qd.f();
        }

        @Override // zd.m4.a
        void a() {
            this.f٢٠١٢٤s.dispose();
            h0.c cVar = this.f٢٠١٢١p;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        @Override // zd.m4.a
        void b() {
            if (!this.f٢٠١١٥j.get()) {
                this.f٢٠١١١f = 1L;
                this.f٢٠١١٧l.getAndIncrement();
                le.d f10 = le.d.f(this.f٢٠١١٠e, this);
                this.f٢٠١٢٣r = f10;
                l4 l4Var = new l4(f10);
                this.f٢٠١٠٦a.onNext(l4Var);
                a aVar = new a(this, 1L);
                if (this.f٢٠١١٩n) {
                    qd.f fVar = this.f٢٠١٢٤s;
                    h0.c cVar = this.f٢٠١٢١p;
                    long j10 = this.f٢٠١٠٨c;
                    fVar.a(cVar.schedulePeriodically(aVar, j10, j10, this.f٢٠١٠٩d));
                } else {
                    qd.f fVar2 = this.f٢٠١٢٤s;
                    io.reactivex.rxjava3.core.h0 h0Var = this.f٢٠١١٨m;
                    long j11 = this.f٢٠١٠٨c;
                    fVar2.a(h0Var.schedulePeriodicallyDirect(aVar, j11, j11, this.f٢٠١٠٩d));
                }
                if (l4Var.d()) {
                    this.f٢٠١٢٣r.onComplete();
                }
            }
        }

        @Override // zd.m4.a
        void c() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            sd.i iVar = this.f٢٠١٠٧b;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠١٠٦a;
            le.d dVar = this.f٢٠١٢٣r;
            int i10 = 1;
            while (true) {
                if (this.f٢٠١١٦k) {
                    iVar.clear();
                    dVar = null;
                    this.f٢٠١٢٣r = null;
                } else {
                    boolean z11 = this.f٢٠١١٢g;
                    Object poll = iVar.poll();
                    if (poll == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z11 && z10) {
                        Throwable th = this.f٢٠١١٣h;
                        if (th != null) {
                            if (dVar != null) {
                                dVar.onError(th);
                            }
                            g0Var.onError(th);
                        } else {
                            if (dVar != null) {
                                dVar.onComplete();
                            }
                            g0Var.onComplete();
                        }
                        a();
                        this.f٢٠١١٦k = true;
                    } else if (!z10) {
                        if (poll instanceof a) {
                            if (((a) poll).f٢٠١٢٦b == this.f٢٠١١١f || !this.f٢٠١١٩n) {
                                this.f٢٠١٢٢q = 0L;
                                dVar = f(dVar);
                            }
                        } else if (dVar != null) {
                            dVar.onNext(poll);
                            long j10 = this.f٢٠١٢٢q + 1;
                            if (j10 == this.f٢٠١٢٠o) {
                                this.f٢٠١٢٢q = 0L;
                                dVar = f(dVar);
                            } else {
                                this.f٢٠١٢٢q = j10;
                            }
                        }
                    }
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }

        void e(a aVar) {
            this.f٢٠١٠٧b.offer(aVar);
            c();
        }

        le.d f(le.d dVar) {
            if (dVar != null) {
                dVar.onComplete();
                dVar = null;
            }
            if (this.f٢٠١١٥j.get()) {
                a();
            } else {
                long j10 = this.f٢٠١١١f + 1;
                this.f٢٠١١١f = j10;
                this.f٢٠١١٧l.getAndIncrement();
                dVar = le.d.f(this.f٢٠١١٠e, this);
                this.f٢٠١٢٣r = dVar;
                l4 l4Var = new l4(dVar);
                this.f٢٠١٠٦a.onNext(l4Var);
                if (this.f٢٠١١٩n) {
                    qd.f fVar = this.f٢٠١٢٤s;
                    h0.c cVar = this.f٢٠١٢١p;
                    a aVar = new a(this, j10);
                    long j11 = this.f٢٠١٠٨c;
                    fVar.b(cVar.schedulePeriodically(aVar, j11, j11, this.f٢٠١٠٩d));
                }
                if (l4Var.d()) {
                    dVar.onComplete();
                }
            }
            return dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class c extends a implements Runnable {

        /* renamed from: q, reason: collision with root package name */
        static final Object f٢٠١٢٧q = new Object();
        private static final long serialVersionUID = 1155822639622580836L;

        /* renamed from: m, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f٢٠١٢٨m;

        /* renamed from: n, reason: collision with root package name */
        le.d f٢٠١٢٩n;

        /* renamed from: o, reason: collision with root package name */
        final qd.f f٢٠١٣٠o;

        /* renamed from: p, reason: collision with root package name */
        final Runnable f٢٠١٣١p;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d();
            }
        }

        c(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, int i10) {
            super(g0Var, j10, timeUnit, i10);
            this.f٢٠١٢٨m = h0Var;
            this.f٢٠١٣٠o = new qd.f();
            this.f٢٠١٣١p = new a();
        }

        @Override // zd.m4.a
        void a() {
            this.f٢٠١٣٠o.dispose();
        }

        @Override // zd.m4.a
        void b() {
            if (!this.f٢٠١١٥j.get()) {
                this.f٢٠١١٧l.getAndIncrement();
                le.d f10 = le.d.f(this.f٢٠١١٠e, this.f٢٠١٣١p);
                this.f٢٠١٢٩n = f10;
                this.f٢٠١١١f = 1L;
                l4 l4Var = new l4(f10);
                this.f٢٠١٠٦a.onNext(l4Var);
                qd.f fVar = this.f٢٠١٣٠o;
                io.reactivex.rxjava3.core.h0 h0Var = this.f٢٠١٢٨m;
                long j10 = this.f٢٠١٠٨c;
                fVar.a(h0Var.schedulePeriodicallyDirect(this, j10, j10, this.f٢٠١٠٩d));
                if (l4Var.d()) {
                    this.f٢٠١٢٩n.onComplete();
                }
            }
        }

        @Override // zd.m4.a
        void c() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            sd.i iVar = this.f٢٠١٠٧b;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠١٠٦a;
            le.d dVar = this.f٢٠١٢٩n;
            int i10 = 1;
            while (true) {
                if (this.f٢٠١١٦k) {
                    iVar.clear();
                    this.f٢٠١٢٩n = null;
                    dVar = null;
                } else {
                    boolean z11 = this.f٢٠١١٢g;
                    Object poll = iVar.poll();
                    if (poll == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z11 && z10) {
                        Throwable th = this.f٢٠١١٣h;
                        if (th != null) {
                            if (dVar != null) {
                                dVar.onError(th);
                            }
                            g0Var.onError(th);
                        } else {
                            if (dVar != null) {
                                dVar.onComplete();
                            }
                            g0Var.onComplete();
                        }
                        a();
                        this.f٢٠١١٦k = true;
                    } else if (!z10) {
                        if (poll == f٢٠١٢٧q) {
                            if (dVar != null) {
                                dVar.onComplete();
                                this.f٢٠١٢٩n = null;
                                dVar = null;
                            }
                            if (this.f٢٠١١٥j.get()) {
                                this.f٢٠١٣٠o.dispose();
                            } else {
                                this.f٢٠١١١f++;
                                this.f٢٠١١٧l.getAndIncrement();
                                dVar = le.d.f(this.f٢٠١١٠e, this.f٢٠١٣١p);
                                this.f٢٠١٢٩n = dVar;
                                l4 l4Var = new l4(dVar);
                                g0Var.onNext(l4Var);
                                if (l4Var.d()) {
                                    dVar.onComplete();
                                }
                            }
                        } else if (dVar != null) {
                            dVar.onNext(poll);
                        }
                    }
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f٢٠١٠٧b.offer(f٢٠١٢٧q);
            c();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class d extends a implements Runnable {

        /* renamed from: p, reason: collision with root package name */
        static final Object f٢٠١٣٣p = new Object();

        /* renamed from: q, reason: collision with root package name */
        static final Object f٢٠١٣٤q = new Object();
        private static final long serialVersionUID = -7852870764194095894L;

        /* renamed from: m, reason: collision with root package name */
        final long f٢٠١٣٥m;

        /* renamed from: n, reason: collision with root package name */
        final h0.c f٢٠١٣٦n;

        /* renamed from: o, reason: collision with root package name */
        final List f٢٠١٣٧o;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final d f٢٠١٣٨a;

            /* renamed from: b, reason: collision with root package name */
            final boolean f٢٠١٣٩b;

            a(d dVar, boolean z10) {
                this.f٢٠١٣٨a = dVar;
                this.f٢٠١٣٩b = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f٢٠١٣٨a.e(this.f٢٠١٣٩b);
            }
        }

        d(io.reactivex.rxjava3.core.g0 g0Var, long j10, long j11, TimeUnit timeUnit, h0.c cVar, int i10) {
            super(g0Var, j10, timeUnit, i10);
            this.f٢٠١٣٥m = j11;
            this.f٢٠١٣٦n = cVar;
            this.f٢٠١٣٧o = new LinkedList();
        }

        @Override // zd.m4.a
        void a() {
            this.f٢٠١٣٦n.dispose();
        }

        @Override // zd.m4.a
        void b() {
            if (!this.f٢٠١١٥j.get()) {
                this.f٢٠١١١f = 1L;
                this.f٢٠١١٧l.getAndIncrement();
                le.d f10 = le.d.f(this.f٢٠١١٠e, this);
                this.f٢٠١٣٧o.add(f10);
                l4 l4Var = new l4(f10);
                this.f٢٠١٠٦a.onNext(l4Var);
                this.f٢٠١٣٦n.schedule(new a(this, false), this.f٢٠١٠٨c, this.f٢٠١٠٩d);
                h0.c cVar = this.f٢٠١٣٦n;
                a aVar = new a(this, true);
                long j10 = this.f٢٠١٣٥m;
                cVar.schedulePeriodically(aVar, j10, j10, this.f٢٠١٠٩d);
                if (l4Var.d()) {
                    f10.onComplete();
                    this.f٢٠١٣٧o.remove(f10);
                }
            }
        }

        @Override // zd.m4.a
        void c() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            sd.i iVar = this.f٢٠١٠٧b;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠١٠٦a;
            List list = this.f٢٠١٣٧o;
            int i10 = 1;
            while (true) {
                if (this.f٢٠١١٦k) {
                    iVar.clear();
                    list.clear();
                } else {
                    boolean z11 = this.f٢٠١١٢g;
                    Object poll = iVar.poll();
                    if (poll == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z11 && z10) {
                        Throwable th = this.f٢٠١١٣h;
                        if (th != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                ((le.d) it.next()).onError(th);
                            }
                            g0Var.onError(th);
                        } else {
                            Iterator it2 = list.iterator();
                            while (it2.hasNext()) {
                                ((le.d) it2.next()).onComplete();
                            }
                            g0Var.onComplete();
                        }
                        a();
                        this.f٢٠١١٦k = true;
                    } else if (!z10) {
                        if (poll == f٢٠١٣٣p) {
                            if (!this.f٢٠١١٥j.get()) {
                                this.f٢٠١١١f++;
                                this.f٢٠١١٧l.getAndIncrement();
                                le.d f10 = le.d.f(this.f٢٠١١٠e, this);
                                list.add(f10);
                                l4 l4Var = new l4(f10);
                                g0Var.onNext(l4Var);
                                this.f٢٠١٣٦n.schedule(new a(this, false), this.f٢٠١٠٨c, this.f٢٠١٠٩d);
                                if (l4Var.d()) {
                                    f10.onComplete();
                                }
                            }
                        } else if (poll == f٢٠١٣٤q) {
                            if (!list.isEmpty()) {
                                ((le.d) list.remove(0)).onComplete();
                            }
                        } else {
                            Iterator it3 = list.iterator();
                            while (it3.hasNext()) {
                                ((le.d) it3.next()).onNext(poll);
                            }
                        }
                    }
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }

        void e(boolean z10) {
            Object obj;
            sd.i iVar = this.f٢٠١٠٧b;
            if (z10) {
                obj = f٢٠١٣٣p;
            } else {
                obj = f٢٠١٣٤q;
            }
            iVar.offer(obj);
            c();
        }

        @Override // java.lang.Runnable
        public void run() {
            d();
        }
    }

    public m4(io.reactivex.rxjava3.core.z zVar, long j10, long j11, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, long j12, int i10, boolean z10) {
        super(zVar);
        this.f٢٠٠٩٩b = j10;
        this.f٢٠١٠٠c = j11;
        this.f٢٠١٠١d = timeUnit;
        this.f٢٠١٠٢e = h0Var;
        this.f٢٠١٠٣f = j12;
        this.f٢٠١٠٤g = i10;
        this.f٢٠١٠٥h = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        if (this.f٢٠٠٩٩b == this.f٢٠١٠٠c) {
            if (this.f٢٠١٠٣f == LongCompanionObject.MAX_VALUE) {
                this.f١٩٥٣٢a.subscribe(new c(g0Var, this.f٢٠٠٩٩b, this.f٢٠١٠١d, this.f٢٠١٠٢e, this.f٢٠١٠٤g));
                return;
            } else {
                this.f١٩٥٣٢a.subscribe(new b(g0Var, this.f٢٠٠٩٩b, this.f٢٠١٠١d, this.f٢٠١٠٢e, this.f٢٠١٠٤g, this.f٢٠١٠٣f, this.f٢٠١٠٥h));
                return;
            }
        }
        this.f١٩٥٣٢a.subscribe(new d(g0Var, this.f٢٠٠٩٩b, this.f٢٠١٠٠c, this.f٢٠١٠١d, this.f٢٠١٠٢e.createWorker(), this.f٢٠١٠٤g));
    }
}
