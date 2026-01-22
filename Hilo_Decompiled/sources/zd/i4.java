package zd;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class i4 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f١٩٨٨٦b;

    /* renamed from: c, reason: collision with root package name */
    final long f١٩٨٨٧c;

    /* renamed from: d, reason: collision with root package name */
    final int f١٩٨٨٨d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٨٩a;

        /* renamed from: b, reason: collision with root package name */
        final long f١٩٨٩٠b;

        /* renamed from: c, reason: collision with root package name */
        final int f١٩٨٩١c;

        /* renamed from: d, reason: collision with root package name */
        long f١٩٨٩٢d;

        /* renamed from: e, reason: collision with root package name */
        nd.c f١٩٨٩٣e;

        /* renamed from: f, reason: collision with root package name */
        le.d f١٩٨٩٤f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f١٩٨٩٥g;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, int i10) {
            this.f١٩٨٨٩a = g0Var;
            this.f١٩٨٩٠b = j10;
            this.f١٩٨٩١c = i10;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٨٩٥g = true;
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٨٩٥g;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            le.d dVar = this.f١٩٨٩٤f;
            if (dVar != null) {
                this.f١٩٨٩٤f = null;
                dVar.onComplete();
            }
            this.f١٩٨٨٩a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            le.d dVar = this.f١٩٨٩٤f;
            if (dVar != null) {
                this.f١٩٨٩٤f = null;
                dVar.onError(th);
            }
            this.f١٩٨٨٩a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            l4 l4Var;
            le.d dVar = this.f١٩٨٩٤f;
            if (dVar == null && !this.f١٩٨٩٥g) {
                dVar = le.d.f(this.f١٩٨٩١c, this);
                this.f١٩٨٩٤f = dVar;
                l4Var = new l4(dVar);
                this.f١٩٨٨٩a.onNext(l4Var);
            } else {
                l4Var = null;
            }
            if (dVar != null) {
                dVar.onNext(obj);
                long j10 = this.f١٩٨٩٢d + 1;
                this.f١٩٨٩٢d = j10;
                if (j10 >= this.f١٩٨٩٠b) {
                    this.f١٩٨٩٢d = 0L;
                    this.f١٩٨٩٤f = null;
                    dVar.onComplete();
                    if (this.f١٩٨٩٥g) {
                        this.f١٩٨٩٣e.dispose();
                    }
                }
                if (l4Var != null && l4Var.d()) {
                    dVar.onComplete();
                    this.f١٩٨٩٤f = null;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٨٩٣e, cVar)) {
                this.f١٩٨٩٣e = cVar;
                this.f١٩٨٨٩a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f١٩٨٩٥g) {
                this.f١٩٨٩٣e.dispose();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicBoolean implements io.reactivex.rxjava3.core.g0, nd.c, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٩٦a;

        /* renamed from: b, reason: collision with root package name */
        final long f١٩٨٩٧b;

        /* renamed from: c, reason: collision with root package name */
        final long f١٩٨٩٨c;

        /* renamed from: d, reason: collision with root package name */
        final int f١٩٨٩٩d;

        /* renamed from: f, reason: collision with root package name */
        long f١٩٩٠١f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f١٩٩٠٢g;

        /* renamed from: h, reason: collision with root package name */
        long f١٩٩٠٣h;

        /* renamed from: i, reason: collision with root package name */
        nd.c f١٩٩٠٤i;

        /* renamed from: j, reason: collision with root package name */
        final AtomicInteger f١٩٩٠٥j = new AtomicInteger();

        /* renamed from: e, reason: collision with root package name */
        final ArrayDeque f١٩٩٠٠e = new ArrayDeque();

        b(io.reactivex.rxjava3.core.g0 g0Var, long j10, long j11, int i10) {
            this.f١٩٨٩٦a = g0Var;
            this.f١٩٨٩٧b = j10;
            this.f١٩٨٩٨c = j11;
            this.f١٩٨٩٩d = i10;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٩٠٢g = true;
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٩٠٢g;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            ArrayDeque arrayDeque = this.f١٩٩٠٠e;
            while (!arrayDeque.isEmpty()) {
                ((le.d) arrayDeque.poll()).onComplete();
            }
            this.f١٩٨٩٦a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            ArrayDeque arrayDeque = this.f١٩٩٠٠e;
            while (!arrayDeque.isEmpty()) {
                ((le.d) arrayDeque.poll()).onError(th);
            }
            this.f١٩٨٩٦a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            l4 l4Var;
            ArrayDeque arrayDeque = this.f١٩٩٠٠e;
            long j10 = this.f١٩٩٠١f;
            long j11 = this.f١٩٨٩٨c;
            if (j10 % j11 == 0 && !this.f١٩٩٠٢g) {
                this.f١٩٩٠٥j.getAndIncrement();
                le.d f10 = le.d.f(this.f١٩٨٩٩d, this);
                l4Var = new l4(f10);
                arrayDeque.offer(f10);
                this.f١٩٨٩٦a.onNext(l4Var);
            } else {
                l4Var = null;
            }
            long j12 = this.f١٩٩٠٣h + 1;
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((le.d) it.next()).onNext(obj);
            }
            if (j12 >= this.f١٩٨٩٧b) {
                ((le.d) arrayDeque.poll()).onComplete();
                if (arrayDeque.isEmpty() && this.f١٩٩٠٢g) {
                    this.f١٩٩٠٤i.dispose();
                    return;
                }
                this.f١٩٩٠٣h = j12 - j11;
            } else {
                this.f١٩٩٠٣h = j12;
            }
            this.f١٩٩٠١f = j10 + 1;
            if (l4Var != null && l4Var.d()) {
                l4Var.f٢٠٠٣٣a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٩٠٤i, cVar)) {
                this.f١٩٩٠٤i = cVar;
                this.f١٩٨٩٦a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f١٩٩٠٥j.decrementAndGet() == 0 && this.f١٩٩٠٢g) {
                this.f١٩٩٠٤i.dispose();
            }
        }
    }

    public i4(io.reactivex.rxjava3.core.e0 e0Var, long j10, long j11, int i10) {
        super(e0Var);
        this.f١٩٨٨٦b = j10;
        this.f١٩٨٨٧c = j11;
        this.f١٩٨٨٨d = i10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        if (this.f١٩٨٨٦b == this.f١٩٨٨٧c) {
            this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٨٨٦b, this.f١٩٨٨٨d));
        } else {
            this.f١٩٥٣٢a.subscribe(new b(g0Var, this.f١٩٨٨٦b, this.f١٩٨٨٧c, this.f١٩٨٨٨d));
        }
    }
}
