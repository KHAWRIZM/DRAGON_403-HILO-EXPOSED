package zd;

import io.reactivex.rxjava3.core.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class o extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٢٠٤b;

    /* renamed from: c, reason: collision with root package name */
    final long f٢٠٢٠٥c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f٢٠٢٠٦d;

    /* renamed from: e, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠٢٠٧e;

    /* renamed from: f, reason: collision with root package name */
    final pd.r f٢٠٢٠٨f;

    /* renamed from: g, reason: collision with root package name */
    final int f٢٠٢٠٩g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f٢٠٢١٠h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.r implements Runnable, nd.c {

        /* renamed from: g, reason: collision with root package name */
        final pd.r f٢٠٢١١g;

        /* renamed from: h, reason: collision with root package name */
        final long f٢٠٢١٢h;

        /* renamed from: i, reason: collision with root package name */
        final TimeUnit f٢٠٢١٣i;

        /* renamed from: j, reason: collision with root package name */
        final int f٢٠٢١٤j;

        /* renamed from: k, reason: collision with root package name */
        final boolean f٢٠٢١٥k;

        /* renamed from: l, reason: collision with root package name */
        final h0.c f٢٠٢١٦l;

        /* renamed from: m, reason: collision with root package name */
        Collection f٢٠٢١٧m;

        /* renamed from: n, reason: collision with root package name */
        nd.c f٢٠٢١٨n;

        /* renamed from: o, reason: collision with root package name */
        nd.c f٢٠٢١٩o;

        /* renamed from: p, reason: collision with root package name */
        long f٢٠٢٢٠p;

        /* renamed from: q, reason: collision with root package name */
        long f٢٠٢٢١q;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.r rVar, long j10, TimeUnit timeUnit, int i10, boolean z10, h0.c cVar) {
            super(g0Var, new be.a());
            this.f٢٠٢١١g = rVar;
            this.f٢٠٢١٢h = j10;
            this.f٢٠٢١٣i = timeUnit;
            this.f٢٠٢١٤j = i10;
            this.f٢٠٢١٥k = z10;
            this.f٢٠٢١٦l = cVar;
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f١٨٣٢٣d) {
                this.f١٨٣٢٣d = true;
                this.f٢٠٢١٩o.dispose();
                this.f٢٠٢١٦l.dispose();
                synchronized (this) {
                    this.f٢٠٢١٧m = null;
                }
            }
        }

        @Override // ud.r, fe.n
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void e(io.reactivex.rxjava3.core.g0 g0Var, Collection collection) {
            g0Var.onNext(collection);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٨٣٢٣d;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            Collection collection;
            this.f٢٠٢١٦l.dispose();
            synchronized (this) {
                collection = this.f٢٠٢١٧m;
                this.f٢٠٢١٧m = null;
            }
            if (collection != null) {
                this.f١٨٣٢٢c.offer(collection);
                this.f١٨٣٢٤e = true;
                if (a()) {
                    fe.q.c(this.f١٨٣٢٢c, this.f١٨٣٢١b, false, this, this);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            synchronized (this) {
                this.f٢٠٢١٧m = null;
            }
            this.f١٨٣٢١b.onError(th);
            this.f٢٠٢١٦l.dispose();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.f٢٠٢١٧m;
                    if (collection == null) {
                        return;
                    }
                    collection.add(obj);
                    if (collection.size() < this.f٢٠٢١٤j) {
                        return;
                    }
                    this.f٢٠٢١٧m = null;
                    this.f٢٠٢٢٠p++;
                    if (this.f٢٠٢١٥k) {
                        this.f٢٠٢١٨n.dispose();
                    }
                    c(collection, false, this);
                    try {
                        Object obj2 = this.f٢٠٢١١g.get();
                        Objects.requireNonNull(obj2, "The buffer supplied is null");
                        Collection collection2 = (Collection) obj2;
                        synchronized (this) {
                            this.f٢٠٢١٧m = collection2;
                            this.f٢٠٢٢١q++;
                        }
                        if (this.f٢٠٢١٥k) {
                            h0.c cVar = this.f٢٠٢١٦l;
                            long j10 = this.f٢٠٢١٢h;
                            this.f٢٠٢١٨n = cVar.schedulePeriodically(this, j10, j10, this.f٢٠٢١٣i);
                        }
                    } catch (Throwable th) {
                        od.b.b(th);
                        this.f١٨٣٢١b.onError(th);
                        dispose();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٢١٩o, cVar)) {
                this.f٢٠٢١٩o = cVar;
                try {
                    Object obj = this.f٢٠٢١١g.get();
                    Objects.requireNonNull(obj, "The buffer supplied is null");
                    this.f٢٠٢١٧m = (Collection) obj;
                    this.f١٨٣٢١b.onSubscribe(this);
                    h0.c cVar2 = this.f٢٠٢١٦l;
                    long j10 = this.f٢٠٢١٢h;
                    this.f٢٠٢١٨n = cVar2.schedulePeriodically(this, j10, j10, this.f٢٠٢١٣i);
                } catch (Throwable th) {
                    od.b.b(th);
                    cVar.dispose();
                    qd.d.f(th, this.f١٨٣٢١b);
                    this.f٢٠٢١٦l.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Object obj = this.f٢٠٢١١g.get();
                Objects.requireNonNull(obj, "The bufferSupplier returned a null buffer");
                Collection collection = (Collection) obj;
                synchronized (this) {
                    Collection collection2 = this.f٢٠٢١٧m;
                    if (collection2 != null && this.f٢٠٢٢٠p == this.f٢٠٢٢١q) {
                        this.f٢٠٢١٧m = collection;
                        c(collection2, false, this);
                    }
                }
            } catch (Throwable th) {
                od.b.b(th);
                dispose();
                this.f١٨٣٢١b.onError(th);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends ud.r implements Runnable, nd.c {

        /* renamed from: g, reason: collision with root package name */
        final pd.r f٢٠٢٢٢g;

        /* renamed from: h, reason: collision with root package name */
        final long f٢٠٢٢٣h;

        /* renamed from: i, reason: collision with root package name */
        final TimeUnit f٢٠٢٢٤i;

        /* renamed from: j, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f٢٠٢٢٥j;

        /* renamed from: k, reason: collision with root package name */
        nd.c f٢٠٢٢٦k;

        /* renamed from: l, reason: collision with root package name */
        Collection f٢٠٢٢٧l;

        /* renamed from: m, reason: collision with root package name */
        final AtomicReference f٢٠٢٢٨m;

        b(io.reactivex.rxjava3.core.g0 g0Var, pd.r rVar, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
            super(g0Var, new be.a());
            this.f٢٠٢٢٨m = new AtomicReference();
            this.f٢٠٢٢٢g = rVar;
            this.f٢٠٢٢٣h = j10;
            this.f٢٠٢٢٤i = timeUnit;
            this.f٢٠٢٢٥j = h0Var;
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f٢٠٢٢٨m);
            this.f٢٠٢٢٦k.dispose();
        }

        @Override // ud.r, fe.n
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void e(io.reactivex.rxjava3.core.g0 g0Var, Collection collection) {
            this.f١٨٣٢١b.onNext(collection);
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (this.f٢٠٢٢٨m.get() == qd.c.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            Collection collection;
            synchronized (this) {
                collection = this.f٢٠٢٢٧l;
                this.f٢٠٢٢٧l = null;
            }
            if (collection != null) {
                this.f١٨٣٢٢c.offer(collection);
                this.f١٨٣٢٤e = true;
                if (a()) {
                    fe.q.c(this.f١٨٣٢٢c, this.f١٨٣٢١b, false, null, this);
                }
            }
            qd.c.a(this.f٢٠٢٢٨m);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            synchronized (this) {
                this.f٢٠٢٢٧l = null;
            }
            this.f١٨٣٢١b.onError(th);
            qd.c.a(this.f٢٠٢٢٨m);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.f٢٠٢٢٧l;
                    if (collection == null) {
                        return;
                    }
                    collection.add(obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٢٢٦k, cVar)) {
                this.f٢٠٢٢٦k = cVar;
                try {
                    Object obj = this.f٢٠٢٢٢g.get();
                    Objects.requireNonNull(obj, "The buffer supplied is null");
                    this.f٢٠٢٢٧l = (Collection) obj;
                    this.f١٨٣٢١b.onSubscribe(this);
                    if (!qd.c.c((nd.c) this.f٢٠٢٢٨m.get())) {
                        io.reactivex.rxjava3.core.h0 h0Var = this.f٢٠٢٢٥j;
                        long j10 = this.f٢٠٢٢٣h;
                        qd.c.f(this.f٢٠٢٢٨m, h0Var.schedulePeriodicallyDirect(this, j10, j10, this.f٢٠٢٢٤i));
                    }
                } catch (Throwable th) {
                    od.b.b(th);
                    dispose();
                    qd.d.f(th, this.f١٨٣٢١b);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Collection collection;
            try {
                Object obj = this.f٢٠٢٢٢g.get();
                Objects.requireNonNull(obj, "The bufferSupplier returned a null buffer");
                Collection collection2 = (Collection) obj;
                synchronized (this) {
                    try {
                        collection = this.f٢٠٢٢٧l;
                        if (collection != null) {
                            this.f٢٠٢٢٧l = collection2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (collection == null) {
                    qd.c.a(this.f٢٠٢٢٨m);
                } else {
                    b(collection, false, this);
                }
            } catch (Throwable th2) {
                od.b.b(th2);
                this.f١٨٣٢١b.onError(th2);
                dispose();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class c extends ud.r implements Runnable, nd.c {

        /* renamed from: g, reason: collision with root package name */
        final pd.r f٢٠٢٢٩g;

        /* renamed from: h, reason: collision with root package name */
        final long f٢٠٢٣٠h;

        /* renamed from: i, reason: collision with root package name */
        final long f٢٠٢٣١i;

        /* renamed from: j, reason: collision with root package name */
        final TimeUnit f٢٠٢٣٢j;

        /* renamed from: k, reason: collision with root package name */
        final h0.c f٢٠٢٣٣k;

        /* renamed from: l, reason: collision with root package name */
        final List f٢٠٢٣٤l;

        /* renamed from: m, reason: collision with root package name */
        nd.c f٢٠٢٣٥m;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final Collection f٢٠٢٣٦a;

            a(Collection collection) {
                this.f٢٠٢٣٦a = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.f٢٠٢٣٤l.remove(this.f٢٠٢٣٦a);
                }
                c cVar = c.this;
                cVar.c(this.f٢٠٢٣٦a, false, cVar.f٢٠٢٣٣k);
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final Collection f٢٠٢٣٨a;

            b(Collection collection) {
                this.f٢٠٢٣٨a = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.f٢٠٢٣٤l.remove(this.f٢٠٢٣٨a);
                }
                c cVar = c.this;
                cVar.c(this.f٢٠٢٣٨a, false, cVar.f٢٠٢٣٣k);
            }
        }

        c(io.reactivex.rxjava3.core.g0 g0Var, pd.r rVar, long j10, long j11, TimeUnit timeUnit, h0.c cVar) {
            super(g0Var, new be.a());
            this.f٢٠٢٢٩g = rVar;
            this.f٢٠٢٣٠h = j10;
            this.f٢٠٢٣١i = j11;
            this.f٢٠٢٣٢j = timeUnit;
            this.f٢٠٢٣٣k = cVar;
            this.f٢٠٢٣٤l = new LinkedList();
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f١٨٣٢٣d) {
                this.f١٨٣٢٣d = true;
                l();
                this.f٢٠٢٣٥m.dispose();
                this.f٢٠٢٣٣k.dispose();
            }
        }

        @Override // ud.r, fe.n
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void e(io.reactivex.rxjava3.core.g0 g0Var, Collection collection) {
            g0Var.onNext(collection);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٨٣٢٣d;
        }

        void l() {
            synchronized (this) {
                this.f٢٠٢٣٤l.clear();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f٢٠٢٣٤l);
                this.f٢٠٢٣٤l.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f١٨٣٢٢c.offer((Collection) it.next());
            }
            this.f١٨٣٢٤e = true;
            if (a()) {
                fe.q.c(this.f١٨٣٢٢c, this.f١٨٣٢١b, false, this.f٢٠٢٣٣k, this);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f١٨٣٢٤e = true;
            l();
            this.f١٨٣٢١b.onError(th);
            this.f٢٠٢٣٣k.dispose();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            synchronized (this) {
                try {
                    Iterator it = this.f٢٠٢٣٤l.iterator();
                    while (it.hasNext()) {
                        ((Collection) it.next()).add(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٢٣٥m, cVar)) {
                this.f٢٠٢٣٥m = cVar;
                try {
                    Object obj = this.f٢٠٢٢٩g.get();
                    Objects.requireNonNull(obj, "The buffer supplied is null");
                    Collection collection = (Collection) obj;
                    this.f٢٠٢٣٤l.add(collection);
                    this.f١٨٣٢١b.onSubscribe(this);
                    h0.c cVar2 = this.f٢٠٢٣٣k;
                    long j10 = this.f٢٠٢٣١i;
                    cVar2.schedulePeriodically(this, j10, j10, this.f٢٠٢٣٢j);
                    this.f٢٠٢٣٣k.schedule(new b(collection), this.f٢٠٢٣٠h, this.f٢٠٢٣٢j);
                } catch (Throwable th) {
                    od.b.b(th);
                    cVar.dispose();
                    qd.d.f(th, this.f١٨٣٢١b);
                    this.f٢٠٢٣٣k.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f١٨٣٢٣d) {
                return;
            }
            try {
                Object obj = this.f٢٠٢٢٩g.get();
                Objects.requireNonNull(obj, "The bufferSupplier returned a null buffer");
                Collection collection = (Collection) obj;
                synchronized (this) {
                    try {
                        if (this.f١٨٣٢٣d) {
                            return;
                        }
                        this.f٢٠٢٣٤l.add(collection);
                        this.f٢٠٢٣٣k.schedule(new a(collection), this.f٢٠٢٣٠h, this.f٢٠٢٣٢j);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                od.b.b(th2);
                this.f١٨٣٢١b.onError(th2);
                dispose();
            }
        }
    }

    public o(io.reactivex.rxjava3.core.e0 e0Var, long j10, long j11, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, pd.r rVar, int i10, boolean z10) {
        super(e0Var);
        this.f٢٠٢٠٤b = j10;
        this.f٢٠٢٠٥c = j11;
        this.f٢٠٢٠٦d = timeUnit;
        this.f٢٠٢٠٧e = h0Var;
        this.f٢٠٢٠٨f = rVar;
        this.f٢٠٢٠٩g = i10;
        this.f٢٠٢١٠h = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        if (this.f٢٠٢٠٤b == this.f٢٠٢٠٥c && this.f٢٠٢٠٩g == Integer.MAX_VALUE) {
            this.f١٩٥٣٢a.subscribe(new b(new he.e(g0Var), this.f٢٠٢٠٨f, this.f٢٠٢٠٤b, this.f٢٠٢٠٦d, this.f٢٠٢٠٧e));
            return;
        }
        h0.c createWorker = this.f٢٠٢٠٧e.createWorker();
        if (this.f٢٠٢٠٤b == this.f٢٠٢٠٥c) {
            this.f١٩٥٣٢a.subscribe(new a(new he.e(g0Var), this.f٢٠٢٠٨f, this.f٢٠٢٠٤b, this.f٢٠٢٠٦d, this.f٢٠٢٠٩g, this.f٢٠٢١٠h, createWorker));
        } else {
            this.f١٩٥٣٢a.subscribe(new c(new he.e(g0Var), this.f٢٠٢٠٨f, this.f٢٠٢٠٤b, this.f٢٠٢٠٥c, this.f٢٠٢٠٦d, createWorker));
        }
    }
}
