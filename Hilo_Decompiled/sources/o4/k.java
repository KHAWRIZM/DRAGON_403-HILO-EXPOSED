package o4;

import android.util.Log;
import androidx.core.util.Pools;
import g5.a;
import java.util.Map;
import java.util.concurrent.Executor;
import o4.h;
import o4.p;
import q4.a;
import q4.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class k implements m, h.a, p.a {

    /* renamed from: i, reason: collision with root package name */
    private static final boolean f١٦٦٤١i = Log.isLoggable("Engine", 2);

    /* renamed from: a, reason: collision with root package name */
    private final s f١٦٦٤٢a;

    /* renamed from: b, reason: collision with root package name */
    private final o f١٦٦٤٣b;

    /* renamed from: c, reason: collision with root package name */
    private final q4.h f١٦٦٤٤c;

    /* renamed from: d, reason: collision with root package name */
    private final b f١٦٦٤٥d;

    /* renamed from: e, reason: collision with root package name */
    private final y f١٦٦٤٦e;

    /* renamed from: f, reason: collision with root package name */
    private final c f١٦٦٤٧f;

    /* renamed from: g, reason: collision with root package name */
    private final a f١٦٦٤٨g;

    /* renamed from: h, reason: collision with root package name */
    private final o4.a f١٦٦٤٩h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final h.e f١٦٦٥٠a;

        /* renamed from: b, reason: collision with root package name */
        final Pools.Pool f١٦٦٥١b = g5.a.d(150, new C٠٢٠٢a());

        /* renamed from: c, reason: collision with root package name */
        private int f١٦٦٥٢c;

        /* renamed from: o4.k$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class C٠٢٠٢a implements a.d {
            C٠٢٠٢a() {
            }

            @Override // g5.a.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h a() {
                a aVar = a.this;
                return new h(aVar.f١٦٦٥٠a, aVar.f١٦٦٥١b);
            }
        }

        a(h.e eVar) {
            this.f١٦٦٥٠a = eVar;
        }

        h a(com.bumptech.glide.c cVar, Object obj, n nVar, m4.f fVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.f fVar2, j jVar, Map map, boolean z10, boolean z11, boolean z12, m4.i iVar, h.b bVar) {
            h hVar = (h) f5.k.d((h) this.f١٦٦٥١b.acquire());
            int i12 = this.f١٦٦٥٢c;
            this.f١٦٦٥٢c = i12 + 1;
            return hVar.o(cVar, obj, nVar, fVar, i10, i11, cls, cls2, fVar2, jVar, map, z10, z11, z12, iVar, bVar, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final r4.a f١٦٦٥٤a;

        /* renamed from: b, reason: collision with root package name */
        final r4.a f١٦٦٥٥b;

        /* renamed from: c, reason: collision with root package name */
        final r4.a f١٦٦٥٦c;

        /* renamed from: d, reason: collision with root package name */
        final r4.a f١٦٦٥٧d;

        /* renamed from: e, reason: collision with root package name */
        final m f١٦٦٥٨e;

        /* renamed from: f, reason: collision with root package name */
        final p.a f١٦٦٥٩f;

        /* renamed from: g, reason: collision with root package name */
        final Pools.Pool f١٦٦٦٠g = g5.a.d(150, new a());

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements a.d {
            a() {
            }

            @Override // g5.a.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public l a() {
                b bVar = b.this;
                return new l(bVar.f١٦٦٥٤a, bVar.f١٦٦٥٥b, bVar.f١٦٦٥٦c, bVar.f١٦٦٥٧d, bVar.f١٦٦٥٨e, bVar.f١٦٦٥٩f, bVar.f١٦٦٦٠g);
            }
        }

        b(r4.a aVar, r4.a aVar2, r4.a aVar3, r4.a aVar4, m mVar, p.a aVar5) {
            this.f١٦٦٥٤a = aVar;
            this.f١٦٦٥٥b = aVar2;
            this.f١٦٦٥٦c = aVar3;
            this.f١٦٦٥٧d = aVar4;
            this.f١٦٦٥٨e = mVar;
            this.f١٦٦٥٩f = aVar5;
        }

        l a(m4.f fVar, boolean z10, boolean z11, boolean z12, boolean z13) {
            return ((l) f5.k.d((l) this.f١٦٦٦٠g.acquire())).l(fVar, z10, z11, z12, z13);
        }

        void b() {
            f5.e.c(this.f١٦٦٥٤a);
            f5.e.c(this.f١٦٦٥٥b);
            f5.e.c(this.f١٦٦٥٦c);
            f5.e.c(this.f١٦٦٥٧d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c implements h.e {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC٠٢١٠a f١٦٦٦٢a;

        /* renamed from: b, reason: collision with root package name */
        private volatile q4.a f١٦٦٦٣b;

        c(a.InterfaceC٠٢١٠a r12) {
            this.f١٦٦٦٢a = r12;
        }

        @Override // o4.h.e
        public q4.a a() {
            if (this.f١٦٦٦٣b == null) {
                synchronized (this) {
                    try {
                        if (this.f١٦٦٦٣b == null) {
                            this.f١٦٦٦٣b = this.f١٦٦٦٢a.build();
                        }
                        if (this.f١٦٦٦٣b == null) {
                            this.f١٦٦٦٣b = new q4.b();
                        }
                    } finally {
                    }
                }
            }
            return this.f١٦٦٦٣b;
        }

        synchronized void b() {
            if (this.f١٦٦٦٣b == null) {
                return;
            }
            this.f١٦٦٦٣b.clear();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        private final l f١٦٦٦٤a;

        /* renamed from: b, reason: collision with root package name */
        private final c5.i f١٦٦٦٥b;

        d(c5.i iVar, l lVar) {
            this.f١٦٦٦٥b = iVar;
            this.f١٦٦٦٤a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.f١٦٦٦٤a.r(this.f١٦٦٦٥b);
            }
        }
    }

    public k(q4.h hVar, a.InterfaceC٠٢١٠a r16, r4.a aVar, r4.a aVar2, r4.a aVar3, r4.a aVar4, boolean z10) {
        this(hVar, r16, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z10);
    }

    private p f(m4.f fVar) {
        v g10 = this.f١٦٦٤٤c.g(fVar);
        if (g10 == null) {
            return null;
        }
        if (g10 instanceof p) {
            return (p) g10;
        }
        return new p(g10, true, true, fVar, this);
    }

    private p h(m4.f fVar) {
        p e10 = this.f١٦٦٤٩h.e(fVar);
        if (e10 != null) {
            e10.a();
        }
        return e10;
    }

    private p i(m4.f fVar) {
        p f10 = f(fVar);
        if (f10 != null) {
            f10.a();
            this.f١٦٦٤٩h.a(fVar, f10);
        }
        return f10;
    }

    private p j(n nVar, boolean z10, long j10) {
        if (!z10) {
            return null;
        }
        p h10 = h(nVar);
        if (h10 != null) {
            if (f١٦٦٤١i) {
                k("Loaded resource from active resources", j10, nVar);
            }
            return h10;
        }
        p i10 = i(nVar);
        if (i10 == null) {
            return null;
        }
        if (f١٦٦٤١i) {
            k("Loaded resource from cache", j10, nVar);
        }
        return i10;
    }

    private static void k(String str, long j10, m4.f fVar) {
        Log.v("Engine", str + " in " + f5.g.a(j10) + "ms, key: " + fVar);
    }

    private d n(com.bumptech.glide.c cVar, Object obj, m4.f fVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.f fVar2, j jVar, Map map, boolean z10, boolean z11, m4.i iVar, boolean z12, boolean z13, boolean z14, boolean z15, c5.i iVar2, Executor executor, n nVar, long j10) {
        l a10 = this.f١٦٦٤٢a.a(nVar, z15);
        if (a10 != null) {
            a10.e(iVar2, executor);
            if (f١٦٦٤١i) {
                k("Added to existing load", j10, nVar);
            }
            return new d(iVar2, a10);
        }
        l a11 = this.f١٦٦٤٥d.a(nVar, z12, z13, z14, z15);
        h a12 = this.f١٦٦٤٨g.a(cVar, obj, nVar, fVar, i10, i11, cls, cls2, fVar2, jVar, map, z10, z11, z15, iVar, a11);
        this.f١٦٦٤٢a.c(nVar, a11);
        a11.e(iVar2, executor);
        a11.s(a12);
        if (f١٦٦٤١i) {
            k("Started new load", j10, nVar);
        }
        return new d(iVar2, a11);
    }

    @Override // o4.m
    public synchronized void a(l lVar, m4.f fVar) {
        this.f١٦٦٤٢a.d(fVar, lVar);
    }

    @Override // q4.h.a
    public void b(v vVar) {
        this.f١٦٦٤٦e.a(vVar, true);
    }

    @Override // o4.p.a
    public void c(m4.f fVar, p pVar) {
        this.f١٦٦٤٩h.d(fVar);
        if (pVar.c()) {
            this.f١٦٦٤٤c.f(fVar, pVar);
        } else {
            this.f١٦٦٤٦e.a(pVar, false);
        }
    }

    @Override // o4.m
    public synchronized void d(l lVar, m4.f fVar, p pVar) {
        if (pVar != null) {
            try {
                if (pVar.c()) {
                    this.f١٦٦٤٩h.a(fVar, pVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f١٦٦٤٢a.d(fVar, lVar);
    }

    public void e() {
        this.f١٦٦٤٧f.a().clear();
    }

    public d g(com.bumptech.glide.c cVar, Object obj, m4.f fVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.f fVar2, j jVar, Map map, boolean z10, boolean z11, m4.i iVar, boolean z12, boolean z13, boolean z14, boolean z15, c5.i iVar2, Executor executor) {
        long b10 = f١٦٦٤١i ? f5.g.b() : 0L;
        n a10 = this.f١٦٦٤٣b.a(obj, fVar, i10, i11, map, cls, cls2, iVar);
        synchronized (this) {
            try {
                p j10 = j(a10, z12, b10);
                if (j10 == null) {
                    return n(cVar, obj, fVar, i10, i11, cls, cls2, fVar2, jVar, map, z10, z11, iVar, z12, z13, z14, z15, iVar2, executor, a10, b10);
                }
                iVar2.b(j10, m4.a.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void l(v vVar) {
        if (vVar instanceof p) {
            ((p) vVar).d();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void m() {
        this.f١٦٦٤٥d.b();
        this.f١٦٦٤٧f.b();
        this.f١٦٦٤٩h.g();
    }

    k(q4.h hVar, a.InterfaceC٠٢١٠a r13, r4.a aVar, r4.a aVar2, r4.a aVar3, r4.a aVar4, s sVar, o oVar, o4.a aVar5, b bVar, a aVar6, y yVar, boolean z10) {
        this.f١٦٦٤٤c = hVar;
        c cVar = new c(r13);
        this.f١٦٦٤٧f = cVar;
        o4.a aVar7 = aVar5 == null ? new o4.a(z10) : aVar5;
        this.f١٦٦٤٩h = aVar7;
        aVar7.f(this);
        this.f١٦٦٤٣b = oVar == null ? new o() : oVar;
        this.f١٦٦٤٢a = sVar == null ? new s() : sVar;
        this.f١٦٦٤٥d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.f١٦٦٤٨g = aVar6 == null ? new a(cVar) : aVar6;
        this.f١٦٦٤٦e = yVar == null ? new y() : yVar;
        hVar.h(this);
    }
}
