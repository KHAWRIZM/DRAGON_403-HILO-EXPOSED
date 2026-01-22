package o4;

import androidx.core.util.Pools;
import g5.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import o4.h;
import o4.p;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class l implements h.b, a.f {

    /* renamed from: z, reason: collision with root package name */
    private static final c f١٦٦٦٧z = new c();

    /* renamed from: a, reason: collision with root package name */
    final e f١٦٦٦٨a;

    /* renamed from: b, reason: collision with root package name */
    private final g5.c f١٦٦٦٩b;

    /* renamed from: c, reason: collision with root package name */
    private final p.a f١٦٦٧٠c;

    /* renamed from: d, reason: collision with root package name */
    private final Pools.Pool f١٦٦٧١d;

    /* renamed from: e, reason: collision with root package name */
    private final c f١٦٦٧٢e;

    /* renamed from: f, reason: collision with root package name */
    private final m f١٦٦٧٣f;

    /* renamed from: g, reason: collision with root package name */
    private final r4.a f١٦٦٧٤g;

    /* renamed from: h, reason: collision with root package name */
    private final r4.a f١٦٦٧٥h;

    /* renamed from: i, reason: collision with root package name */
    private final r4.a f١٦٦٧٦i;

    /* renamed from: j, reason: collision with root package name */
    private final r4.a f١٦٦٧٧j;

    /* renamed from: k, reason: collision with root package name */
    private final AtomicInteger f١٦٦٧٨k;

    /* renamed from: l, reason: collision with root package name */
    private m4.f f١٦٦٧٩l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٦٦٨٠m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٦٦٨١n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f١٦٦٨٢o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f١٦٦٨٣p;

    /* renamed from: q, reason: collision with root package name */
    private v f١٦٦٨٤q;

    /* renamed from: r, reason: collision with root package name */
    m4.a f١٦٦٨٥r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f١٦٦٨٦s;

    /* renamed from: t, reason: collision with root package name */
    q f١٦٦٨٧t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f١٦٦٨٨u;

    /* renamed from: v, reason: collision with root package name */
    p f١٦٦٨٩v;

    /* renamed from: w, reason: collision with root package name */
    private h f١٦٦٩٠w;

    /* renamed from: x, reason: collision with root package name */
    private volatile boolean f١٦٦٩١x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f١٦٦٩٢y;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final c5.i f١٦٦٩٣a;

        a(c5.i iVar) {
            this.f١٦٦٩٣a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f١٦٦٩٣a.getLock()) {
                synchronized (l.this) {
                    try {
                        if (l.this.f١٦٦٦٨a.e(this.f١٦٦٩٣a)) {
                            l.this.f(this.f١٦٦٩٣a);
                        }
                        l.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final c5.i f١٦٦٩٥a;

        b(c5.i iVar) {
            this.f١٦٦٩٥a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f١٦٦٩٥a.getLock()) {
                synchronized (l.this) {
                    try {
                        if (l.this.f١٦٦٦٨a.e(this.f١٦٦٩٥a)) {
                            l.this.f١٦٦٨٩v.a();
                            l.this.g(this.f١٦٦٩٥a);
                            l.this.r(this.f١٦٦٩٥a);
                        }
                        l.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c {
        c() {
        }

        public p a(v vVar, boolean z10, m4.f fVar, p.a aVar) {
            return new p(vVar, z10, true, fVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        final c5.i f١٦٦٩٧a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f١٦٦٩٨b;

        d(c5.i iVar, Executor executor) {
            this.f١٦٦٩٧a = iVar;
            this.f١٦٦٩٨b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f١٦٦٩٧a.equals(((d) obj).f١٦٦٩٧a);
            }
            return false;
        }

        public int hashCode() {
            return this.f١٦٦٩٧a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class e implements Iterable {

        /* renamed from: a, reason: collision with root package name */
        private final List f١٦٦٩٩a;

        e() {
            this(new ArrayList(2));
        }

        private static d h(c5.i iVar) {
            return new d(iVar, f5.e.a());
        }

        void clear() {
            this.f١٦٦٩٩a.clear();
        }

        void d(c5.i iVar, Executor executor) {
            this.f١٦٦٩٩a.add(new d(iVar, executor));
        }

        boolean e(c5.i iVar) {
            return this.f١٦٦٩٩a.contains(h(iVar));
        }

        e f() {
            return new e(new ArrayList(this.f١٦٦٩٩a));
        }

        void i(c5.i iVar) {
            this.f١٦٦٩٩a.remove(h(iVar));
        }

        boolean isEmpty() {
            return this.f١٦٦٩٩a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f١٦٦٩٩a.iterator();
        }

        int size() {
            return this.f١٦٦٩٩a.size();
        }

        e(List list) {
            this.f١٦٦٩٩a = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(r4.a aVar, r4.a aVar2, r4.a aVar3, r4.a aVar4, m mVar, p.a aVar5, Pools.Pool pool) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, pool, f١٦٦٦٧z);
    }

    private r4.a j() {
        if (this.f١٦٦٨١n) {
            return this.f١٦٦٧٦i;
        }
        if (this.f١٦٦٨٢o) {
            return this.f١٦٦٧٧j;
        }
        return this.f١٦٦٧٥h;
    }

    private boolean m() {
        if (!this.f١٦٦٨٨u && !this.f١٦٦٨٦s && !this.f١٦٦٩١x) {
            return false;
        }
        return true;
    }

    private synchronized void q() {
        if (this.f١٦٦٧٩l != null) {
            this.f١٦٦٦٨a.clear();
            this.f١٦٦٧٩l = null;
            this.f١٦٦٨٩v = null;
            this.f١٦٦٨٤q = null;
            this.f١٦٦٨٨u = false;
            this.f١٦٦٩١x = false;
            this.f١٦٦٨٦s = false;
            this.f١٦٦٩٢y = false;
            this.f١٦٦٩٠w.x(false);
            this.f١٦٦٩٠w = null;
            this.f١٦٦٨٧t = null;
            this.f١٦٦٨٥r = null;
            this.f١٦٦٧١d.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // g5.a.f
    public g5.c a() {
        return this.f١٦٦٦٩b;
    }

    @Override // o4.h.b
    public void b(v vVar, m4.a aVar, boolean z10) {
        synchronized (this) {
            this.f١٦٦٨٤q = vVar;
            this.f١٦٦٨٥r = aVar;
            this.f١٦٦٩٢y = z10;
        }
        o();
    }

    @Override // o4.h.b
    public void c(q qVar) {
        synchronized (this) {
            this.f١٦٦٨٧t = qVar;
        }
        n();
    }

    @Override // o4.h.b
    public void d(h hVar) {
        j().execute(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void e(c5.i iVar, Executor executor) {
        try {
            this.f١٦٦٦٩b.c();
            this.f١٦٦٦٨a.d(iVar, executor);
            if (this.f١٦٦٨٦s) {
                k(1);
                executor.execute(new b(iVar));
            } else if (this.f١٦٦٨٨u) {
                k(1);
                executor.execute(new a(iVar));
            } else {
                f5.k.a(!this.f١٦٦٩١x, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    void f(c5.i iVar) {
        try {
            iVar.c(this.f١٦٦٨٧t);
        } catch (Throwable th) {
            throw new o4.b(th);
        }
    }

    void g(c5.i iVar) {
        try {
            iVar.b(this.f١٦٦٨٩v, this.f١٦٦٨٥r, this.f١٦٦٩٢y);
        } catch (Throwable th) {
            throw new o4.b(th);
        }
    }

    void h() {
        if (m()) {
            return;
        }
        this.f١٦٦٩١x = true;
        this.f١٦٦٩٠w.f();
        this.f١٦٦٧٣f.a(this, this.f١٦٦٧٩l);
    }

    void i() {
        boolean z10;
        p pVar;
        synchronized (this) {
            try {
                this.f١٦٦٦٩b.c();
                f5.k.a(m(), "Not yet complete!");
                int decrementAndGet = this.f١٦٦٧٨k.decrementAndGet();
                if (decrementAndGet >= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                f5.k.a(z10, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    pVar = this.f١٦٦٨٩v;
                    q();
                } else {
                    pVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (pVar != null) {
            pVar.d();
        }
    }

    synchronized void k(int i10) {
        p pVar;
        f5.k.a(m(), "Not yet complete!");
        if (this.f١٦٦٧٨k.getAndAdd(i10) == 0 && (pVar = this.f١٦٦٨٩v) != null) {
            pVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized l l(m4.f fVar, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f١٦٦٧٩l = fVar;
        this.f١٦٦٨٠m = z10;
        this.f١٦٦٨١n = z11;
        this.f١٦٦٨٢o = z12;
        this.f١٦٦٨٣p = z13;
        return this;
    }

    void n() {
        synchronized (this) {
            try {
                this.f١٦٦٦٩b.c();
                if (this.f١٦٦٩١x) {
                    q();
                    return;
                }
                if (!this.f١٦٦٦٨a.isEmpty()) {
                    if (!this.f١٦٦٨٨u) {
                        this.f١٦٦٨٨u = true;
                        m4.f fVar = this.f١٦٦٧٩l;
                        e f10 = this.f١٦٦٦٨a.f();
                        k(f10.size() + 1);
                        this.f١٦٦٧٣f.d(this, fVar, null);
                        Iterator it = f10.iterator();
                        while (it.hasNext()) {
                            d dVar = (d) it.next();
                            dVar.f١٦٦٩٨b.execute(new a(dVar.f١٦٦٩٧a));
                        }
                        i();
                        return;
                    }
                    throw new IllegalStateException("Already failed once");
                }
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void o() {
        synchronized (this) {
            try {
                this.f١٦٦٦٩b.c();
                if (this.f١٦٦٩١x) {
                    this.f١٦٦٨٤q.recycle();
                    q();
                    return;
                }
                if (!this.f١٦٦٦٨a.isEmpty()) {
                    if (!this.f١٦٦٨٦s) {
                        this.f١٦٦٨٩v = this.f١٦٦٧٢e.a(this.f١٦٦٨٤q, this.f١٦٦٨٠m, this.f١٦٦٧٩l, this.f١٦٦٧٠c);
                        this.f١٦٦٨٦s = true;
                        e f10 = this.f١٦٦٦٨a.f();
                        k(f10.size() + 1);
                        this.f١٦٦٧٣f.d(this, this.f١٦٦٧٩l, this.f١٦٦٨٩v);
                        Iterator it = f10.iterator();
                        while (it.hasNext()) {
                            d dVar = (d) it.next();
                            dVar.f١٦٦٩٨b.execute(new b(dVar.f١٦٦٩٧a));
                        }
                        i();
                        return;
                    }
                    throw new IllegalStateException("Already have resource");
                }
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f١٦٦٨٣p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void r(c5.i iVar) {
        try {
            this.f١٦٦٦٩b.c();
            this.f١٦٦٦٨a.i(iVar);
            if (this.f١٦٦٦٨a.isEmpty()) {
                h();
                if (!this.f١٦٦٨٦s) {
                    if (this.f١٦٦٨٨u) {
                    }
                }
                if (this.f١٦٦٧٨k.get() == 0) {
                    q();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(h hVar) {
        r4.a j10;
        try {
            this.f١٦٦٩٠w = hVar;
            if (hVar.E()) {
                j10 = this.f١٦٦٧٤g;
            } else {
                j10 = j();
            }
            j10.execute(hVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    l(r4.a aVar, r4.a aVar2, r4.a aVar3, r4.a aVar4, m mVar, p.a aVar5, Pools.Pool pool, c cVar) {
        this.f١٦٦٦٨a = new e();
        this.f١٦٦٦٩b = g5.c.a();
        this.f١٦٦٧٨k = new AtomicInteger();
        this.f١٦٦٧٤g = aVar;
        this.f١٦٦٧٥h = aVar2;
        this.f١٦٦٧٦i = aVar3;
        this.f١٦٦٧٧j = aVar4;
        this.f١٦٦٧٣f = mVar;
        this.f١٦٦٧٠c = aVar5;
        this.f١٦٦٧١d = pool;
        this.f١٦٦٧٢e = cVar;
    }
}
