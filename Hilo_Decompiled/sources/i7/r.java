package i7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import c7.g;
import e7.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import k7.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٤٦٥٨a;

    /* renamed from: b, reason: collision with root package name */
    private final c7.e f١٤٦٥٩b;

    /* renamed from: c, reason: collision with root package name */
    private final j7.d f١٤٦٦٠c;

    /* renamed from: d, reason: collision with root package name */
    private final x f١٤٦٦١d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f١٤٦٦٢e;

    /* renamed from: f, reason: collision with root package name */
    private final k7.b f١٤٦٦٣f;

    /* renamed from: g, reason: collision with root package name */
    private final l7.a f١٤٦٦٤g;

    /* renamed from: h, reason: collision with root package name */
    private final l7.a f١٤٦٦٥h;

    /* renamed from: i, reason: collision with root package name */
    private final j7.c f١٤٦٦٦i;

    public r(Context context, c7.e eVar, j7.d dVar, x xVar, Executor executor, k7.b bVar, l7.a aVar, l7.a aVar2, j7.c cVar) {
        this.f١٤٦٥٨a = context;
        this.f١٤٦٥٩b = eVar;
        this.f١٤٦٦٠c = dVar;
        this.f١٤٦٦١d = xVar;
        this.f١٤٦٦٢e = executor;
        this.f١٤٦٦٣f = bVar;
        this.f١٤٦٦٤g = aVar;
        this.f١٤٦٦٥h = aVar2;
        this.f١٤٦٦٦i = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l(b7.p pVar) {
        return Boolean.valueOf(this.f١٤٦٦٠c.v(pVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterable m(b7.p pVar) {
        return this.f١٤٦٦٠c.i(pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable, b7.p pVar, long j10) {
        this.f١٤٦٦٠c.y(iterable);
        this.f١٤٦٦٠c.n(pVar, this.f١٤٦٦٤g.a() + j10);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(Iterable iterable) {
        this.f١٤٦٦٠c.f(iterable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p() {
        this.f١٤٦٦٦i.a();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.f١٤٦٦٦i.b(((Integer) r0.getValue()).intValue(), c.b.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(b7.p pVar, long j10) {
        this.f١٤٦٦٠c.n(pVar, this.f١٤٦٦٤g.a() + j10);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(b7.p pVar, int i10) {
        this.f١٤٦٦١d.b(pVar, i10 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final b7.p pVar, final int i10, Runnable runnable) {
        try {
            try {
                k7.b bVar = this.f١٤٦٦٣f;
                final j7.d dVar = this.f١٤٦٦٠c;
                Objects.requireNonNull(dVar);
                bVar.c(new b.a() { // from class: i7.q
                    @Override // k7.b.a
                    public final Object execute() {
                        return Integer.valueOf(j7.d.this.e());
                    }
                });
                if (!k()) {
                    this.f١٤٦٦٣f.c(new b.a() { // from class: i7.h
                        @Override // k7.b.a
                        public final Object execute() {
                            Object s10;
                            s10 = r.this.s(pVar, i10);
                            return s10;
                        }
                    });
                } else {
                    u(pVar, i10);
                }
            } catch (k7.a unused) {
                this.f١٤٦٦١d.b(pVar, i10 + 1);
            }
            runnable.run();
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public b7.i j(c7.m mVar) {
        k7.b bVar = this.f١٤٦٦٣f;
        final j7.c cVar = this.f١٤٦٦٦i;
        Objects.requireNonNull(cVar);
        return mVar.b(b7.i.a().i(this.f١٤٦٦٤g.a()).o(this.f١٤٦٦٥h.a()).n("GDT_CLIENT_METRICS").h(new b7.h(z6.c.b("proto"), ((e7.a) bVar.c(new b.a() { // from class: i7.p
            @Override // k7.b.a
            public final Object execute() {
                return j7.c.this.g();
            }
        })).f())).d());
    }

    boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f١٤٦٥٨a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public c7.g u(final b7.p pVar, int i10) {
        c7.g a10;
        c7.m mVar = this.f١٤٦٥٩b.get(pVar.b());
        long j10 = 0;
        c7.g e10 = c7.g.e(0L);
        while (true) {
            final long j11 = j10;
            while (((Boolean) this.f١٤٦٦٣f.c(new b.a() { // from class: i7.g
                @Override // k7.b.a
                public final Object execute() {
                    Boolean l10;
                    l10 = r.this.l(pVar);
                    return l10;
                }
            })).booleanValue()) {
                final Iterable iterable = (Iterable) this.f١٤٦٦٣f.c(new b.a() { // from class: i7.i
                    @Override // k7.b.a
                    public final Object execute() {
                        Iterable m10;
                        m10 = r.this.m(pVar);
                        return m10;
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return e10;
                }
                if (mVar == null) {
                    f7.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                    a10 = c7.g.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((j7.k) it.next()).b());
                    }
                    if (pVar.e()) {
                        arrayList.add(j(mVar));
                    }
                    a10 = mVar.a(c7.f.a().b(arrayList).c(pVar.c()).a());
                }
                e10 = a10;
                if (e10.c() == g.a.TRANSIENT_ERROR) {
                    this.f١٤٦٦٣f.c(new b.a() { // from class: i7.j
                        @Override // k7.b.a
                        public final Object execute() {
                            Object n10;
                            n10 = r.this.n(iterable, pVar, j11);
                            return n10;
                        }
                    });
                    this.f١٤٦٦١d.a(pVar, i10 + 1, true);
                    return e10;
                }
                this.f١٤٦٦٣f.c(new b.a() { // from class: i7.k
                    @Override // k7.b.a
                    public final Object execute() {
                        Object o10;
                        o10 = r.this.o(iterable);
                        return o10;
                    }
                });
                if (e10.c() == g.a.OK) {
                    j10 = Math.max(j11, e10.b());
                    if (pVar.e()) {
                        this.f١٤٦٦٣f.c(new b.a() { // from class: i7.l
                            @Override // k7.b.a
                            public final Object execute() {
                                Object p10;
                                p10 = r.this.p();
                                return p10;
                            }
                        });
                    }
                } else if (e10.c() == g.a.INVALID_PAYLOAD) {
                    final HashMap hashMap = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String n10 = ((j7.k) it2.next()).b().n();
                        if (!hashMap.containsKey(n10)) {
                            hashMap.put(n10, 1);
                        } else {
                            hashMap.put(n10, Integer.valueOf(((Integer) hashMap.get(n10)).intValue() + 1));
                        }
                    }
                    this.f١٤٦٦٣f.c(new b.a() { // from class: i7.m
                        @Override // k7.b.a
                        public final Object execute() {
                            Object q10;
                            q10 = r.this.q(hashMap);
                            return q10;
                        }
                    });
                }
            }
            this.f١٤٦٦٣f.c(new b.a() { // from class: i7.n
                @Override // k7.b.a
                public final Object execute() {
                    Object r10;
                    r10 = r.this.r(pVar, j11);
                    return r10;
                }
            });
            return e10;
        }
    }

    public void v(final b7.p pVar, final int i10, final Runnable runnable) {
        this.f١٤٦٦٢e.execute(new Runnable() { // from class: i7.o
            @Override // java.lang.Runnable
            public final void run() {
                r.this.t(pVar, i10, runnable);
            }
        });
    }
}
