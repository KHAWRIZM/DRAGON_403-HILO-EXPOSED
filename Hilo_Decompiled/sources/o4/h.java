package o4;

import android.os.Build;
import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.g;
import g5.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o4.f;
import o4.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class h implements f.a, Runnable, Comparable, a.f {
    private m4.a A;

    /* renamed from: B, reason: collision with root package name */
    private com.bumptech.glide.load.data.d f١٦٥٨٢B;
    private volatile o4.f C;
    private volatile boolean D;
    private volatile boolean E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private final e f١٦٥٨٦d;

    /* renamed from: e, reason: collision with root package name */
    private final Pools.Pool f١٦٥٨٧e;

    /* renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.c f١٦٥٩٠h;

    /* renamed from: i, reason: collision with root package name */
    private m4.f f١٦٥٩١i;

    /* renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.f f١٦٥٩٢j;

    /* renamed from: k, reason: collision with root package name */
    private n f١٦٥٩٣k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٦٥٩٤l;

    /* renamed from: m, reason: collision with root package name */
    private int f١٦٥٩٥m;

    /* renamed from: n, reason: collision with root package name */
    private j f١٦٥٩٦n;

    /* renamed from: o, reason: collision with root package name */
    private m4.i f١٦٥٩٧o;

    /* renamed from: p, reason: collision with root package name */
    private b f١٦٥٩٨p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٦٥٩٩q;

    /* renamed from: r, reason: collision with root package name */
    private EnumC٠٢٠١h f١٦٦٠٠r;

    /* renamed from: s, reason: collision with root package name */
    private g f١٦٦٠١s;

    /* renamed from: t, reason: collision with root package name */
    private long f١٦٦٠٢t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f١٦٦٠٣u;

    /* renamed from: v, reason: collision with root package name */
    private Object f١٦٦٠٤v;

    /* renamed from: w, reason: collision with root package name */
    private Thread f١٦٦٠٥w;

    /* renamed from: x, reason: collision with root package name */
    private m4.f f١٦٦٠٦x;

    /* renamed from: y, reason: collision with root package name */
    private m4.f f١٦٦٠٧y;

    /* renamed from: z, reason: collision with root package name */
    private Object f١٦٦٠٨z;

    /* renamed from: a, reason: collision with root package name */
    private final o4.g f١٦٥٨٣a = new o4.g();

    /* renamed from: b, reason: collision with root package name */
    private final List f١٦٥٨٤b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final g5.c f١٦٥٨٥c = g5.c.a();

    /* renamed from: f, reason: collision with root package name */
    private final d f١٦٥٨٨f = new d();

    /* renamed from: g, reason: collision with root package name */
    private final f f١٦٥٨٩g = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٦٦٠٩a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f١٦٦١٠b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f١٦٦١١c;

        static {
            int[] iArr = new int[m4.c.values().length];
            f١٦٦١١c = iArr;
            try {
                iArr[m4.c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٦٦١١c[m4.c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC٠٢٠١h.values().length];
            f١٦٦١٠b = iArr2;
            try {
                iArr2[EnumC٠٢٠١h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٦٦١٠b[EnumC٠٢٠١h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٦٦١٠b[EnumC٠٢٠١h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١٦٦١٠b[EnumC٠٢٠١h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f١٦٦١٠b[EnumC٠٢٠١h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            f١٦٦٠٩a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f١٦٦٠٩a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f١٦٦٠٩a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void b(v vVar, m4.a aVar, boolean z10);

        void c(q qVar);

        void d(h hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public final class c implements i.a {

        /* renamed from: a, reason: collision with root package name */
        private final m4.a f١٦٦١٢a;

        c(m4.a aVar) {
            this.f١٦٦١٢a = aVar;
        }

        @Override // o4.i.a
        public v a(v vVar) {
            return h.this.w(this.f١٦٦١٢a, vVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private m4.f f١٦٦١٤a;

        /* renamed from: b, reason: collision with root package name */
        private m4.l f١٦٦١٥b;

        /* renamed from: c, reason: collision with root package name */
        private u f١٦٦١٦c;

        d() {
        }

        void a() {
            this.f١٦٦١٤a = null;
            this.f١٦٦١٥b = null;
            this.f١٦٦١٦c = null;
        }

        void b(e eVar, m4.i iVar) {
            g5.b.a("DecodeJob.encode");
            try {
                eVar.a().b(this.f١٦٦١٤a, new o4.e(this.f١٦٦١٥b, this.f١٦٦١٦c, iVar));
            } finally {
                this.f١٦٦١٦c.e();
                g5.b.e();
            }
        }

        boolean c() {
            if (this.f١٦٦١٦c != null) {
                return true;
            }
            return false;
        }

        void d(m4.f fVar, m4.l lVar, u uVar) {
            this.f١٦٦١٤a = fVar;
            this.f١٦٦١٥b = lVar;
            this.f١٦٦١٦c = uVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface e {
        q4.a a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f١٦٦١٧a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f١٦٦١٨b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١٦٦١٩c;

        f() {
        }

        private boolean a(boolean z10) {
            if ((this.f١٦٦١٩c || z10 || this.f١٦٦١٨b) && this.f١٦٦١٧a) {
                return true;
            }
            return false;
        }

        synchronized boolean b() {
            this.f١٦٦١٨b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f١٦٦١٩c = true;
            return a(false);
        }

        synchronized boolean d(boolean z10) {
            this.f١٦٦١٧a = true;
            return a(z10);
        }

        synchronized void e() {
            this.f١٦٦١٨b = false;
            this.f١٦٦١٧a = false;
            this.f١٦٦١٩c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o4.h$h, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum EnumC٠٢٠١h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, Pools.Pool pool) {
        this.f١٦٥٨٦d = eVar;
        this.f١٦٥٨٧e = pool;
    }

    private void A() {
        this.f١٦٦٠٥w = Thread.currentThread();
        this.f١٦٦٠٢t = f5.g.b();
        boolean z10 = false;
        while (!this.E && this.C != null && !(z10 = this.C.a())) {
            this.f١٦٦٠٠r = l(this.f١٦٦٠٠r);
            this.C = k();
            if (this.f١٦٦٠٠r == EnumC٠٢٠١h.SOURCE) {
                z(g.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.f١٦٦٠٠r == EnumC٠٢٠١h.FINISHED || this.E) && !z10) {
            t();
        }
    }

    private v B(Object obj, m4.a aVar, t tVar) {
        m4.i m10 = m(aVar);
        com.bumptech.glide.load.data.e l10 = this.f١٦٥٩٠h.i().l(obj);
        try {
            return tVar.a(l10, m10, this.f١٦٥٩٤l, this.f١٦٥٩٥m, new c(aVar));
        } finally {
            l10.cleanup();
        }
    }

    private void C() {
        int i10 = a.f١٦٦٠٩a[this.f١٦٦٠١s.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    j();
                    return;
                }
                throw new IllegalStateException("Unrecognized run reason: " + this.f١٦٦٠١s);
            }
            A();
            return;
        }
        this.f١٦٦٠٠r = l(EnumC٠٢٠١h.INITIALIZE);
        this.C = k();
        A();
    }

    private void D() {
        Throwable th;
        this.f١٦٥٨٥c.c();
        if (this.D) {
            if (this.f١٦٥٨٤b.isEmpty()) {
                th = null;
            } else {
                List list = this.f١٦٥٨٤b;
                th = (Throwable) list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.D = true;
    }

    private v h(com.bumptech.glide.load.data.d dVar, Object obj, m4.a aVar) {
        if (obj == null) {
            dVar.cleanup();
            return null;
        }
        try {
            long b10 = f5.g.b();
            v i10 = i(obj, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                p("Decoded result " + i10, b10);
            }
            return i10;
        } finally {
            dVar.cleanup();
        }
    }

    private v i(Object obj, m4.a aVar) {
        return B(obj, aVar, this.f١٦٥٨٣a.h(obj.getClass()));
    }

    private void j() {
        v vVar;
        if (Log.isLoggable("DecodeJob", 2)) {
            q("Retrieved data", this.f١٦٦٠٢t, "data: " + this.f١٦٦٠٨z + ", cache key: " + this.f١٦٦٠٦x + ", fetcher: " + this.f١٦٥٨٢B);
        }
        try {
            vVar = h(this.f١٦٥٨٢B, this.f١٦٦٠٨z, this.A);
        } catch (q e10) {
            e10.i(this.f١٦٦٠٧y, this.A);
            this.f١٦٥٨٤b.add(e10);
            vVar = null;
        }
        if (vVar != null) {
            s(vVar, this.A, this.F);
        } else {
            A();
        }
    }

    private o4.f k() {
        int i10 = a.f١٦٦١٠b[this.f١٦٦٠٠r.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: " + this.f١٦٦٠٠r);
                }
                return new z(this.f١٦٥٨٣a, this);
            }
            return new o4.c(this.f١٦٥٨٣a, this);
        }
        return new w(this.f١٦٥٨٣a, this);
    }

    private EnumC٠٢٠١h l(EnumC٠٢٠١h r42) {
        int i10 = a.f١٦٦١٠b[r42.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3 && i10 != 4) {
                    if (i10 == 5) {
                        if (this.f١٦٥٩٦n.b()) {
                            return EnumC٠٢٠١h.RESOURCE_CACHE;
                        }
                        return l(EnumC٠٢٠١h.RESOURCE_CACHE);
                    }
                    throw new IllegalArgumentException("Unrecognized stage: " + r42);
                }
                return EnumC٠٢٠١h.FINISHED;
            }
            if (this.f١٦٦٠٣u) {
                return EnumC٠٢٠١h.FINISHED;
            }
            return EnumC٠٢٠١h.SOURCE;
        }
        if (this.f١٦٥٩٦n.a()) {
            return EnumC٠٢٠١h.DATA_CACHE;
        }
        return l(EnumC٠٢٠١h.DATA_CACHE);
    }

    private m4.i m(m4.a aVar) {
        boolean z10;
        m4.i iVar = this.f١٦٥٩٧o;
        if (Build.VERSION.SDK_INT < 26) {
            return iVar;
        }
        if (aVar != m4.a.RESOURCE_DISK_CACHE && !this.f١٦٥٨٣a.x()) {
            z10 = false;
        } else {
            z10 = true;
        }
        m4.h hVar = v4.u.f١٨٥٥٠j;
        Boolean bool = (Boolean) iVar.a(hVar);
        if (bool != null && (!bool.booleanValue() || z10)) {
            return iVar;
        }
        m4.i iVar2 = new m4.i();
        iVar2.b(this.f١٦٥٩٧o);
        iVar2.d(hVar, Boolean.valueOf(z10));
        return iVar2;
    }

    private int n() {
        return this.f١٦٥٩٢j.ordinal();
    }

    private void p(String str, long j10) {
        q(str, j10, null);
    }

    private void q(String str, long j10, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(f5.g.a(j10));
        sb.append(", load key: ");
        sb.append(this.f١٦٥٩٣k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void r(v vVar, m4.a aVar, boolean z10) {
        D();
        this.f١٦٥٩٨p.b(vVar, aVar, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s(v vVar, m4.a aVar, boolean z10) {
        u uVar;
        g5.b.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (vVar instanceof r) {
                ((r) vVar).initialize();
            }
            if (this.f١٦٥٨٨f.c()) {
                vVar = u.c(vVar);
                uVar = vVar;
            } else {
                uVar = 0;
            }
            r(vVar, aVar, z10);
            this.f١٦٦٠٠r = EnumC٠٢٠١h.ENCODE;
            try {
                if (this.f١٦٥٨٨f.c()) {
                    this.f١٦٥٨٨f.b(this.f١٦٥٨٦d, this.f١٦٥٩٧o);
                }
                u();
                g5.b.e();
            } finally {
                if (uVar != 0) {
                    uVar.e();
                }
            }
        } catch (Throwable th) {
            g5.b.e();
            throw th;
        }
    }

    private void t() {
        D();
        this.f١٦٥٩٨p.c(new q("Failed to load resource", new ArrayList(this.f١٦٥٨٤b)));
        v();
    }

    private void u() {
        if (this.f١٦٥٨٩g.b()) {
            y();
        }
    }

    private void v() {
        if (this.f١٦٥٨٩g.c()) {
            y();
        }
    }

    private void y() {
        this.f١٦٥٨٩g.e();
        this.f١٦٥٨٨f.a();
        this.f١٦٥٨٣a.a();
        this.D = false;
        this.f١٦٥٩٠h = null;
        this.f١٦٥٩١i = null;
        this.f١٦٥٩٧o = null;
        this.f١٦٥٩٢j = null;
        this.f١٦٥٩٣k = null;
        this.f١٦٥٩٨p = null;
        this.f١٦٦٠٠r = null;
        this.C = null;
        this.f١٦٦٠٥w = null;
        this.f١٦٦٠٦x = null;
        this.f١٦٦٠٨z = null;
        this.A = null;
        this.f١٦٥٨٢B = null;
        this.f١٦٦٠٢t = 0L;
        this.E = false;
        this.f١٦٦٠٤v = null;
        this.f١٦٥٨٤b.clear();
        this.f١٦٥٨٧e.release(this);
    }

    private void z(g gVar) {
        this.f١٦٦٠١s = gVar;
        this.f١٦٥٩٨p.d(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E() {
        EnumC٠٢٠١h l10 = l(EnumC٠٢٠١h.INITIALIZE);
        if (l10 != EnumC٠٢٠١h.RESOURCE_CACHE && l10 != EnumC٠٢٠١h.DATA_CACHE) {
            return false;
        }
        return true;
    }

    @Override // g5.a.f
    public g5.c a() {
        return this.f١٦٥٨٥c;
    }

    @Override // o4.f.a
    public void c(m4.f fVar, Object obj, com.bumptech.glide.load.data.d dVar, m4.a aVar, m4.f fVar2) {
        this.f١٦٦٠٦x = fVar;
        this.f١٦٦٠٨z = obj;
        this.f١٦٥٨٢B = dVar;
        this.A = aVar;
        this.f١٦٦٠٧y = fVar2;
        boolean z10 = false;
        if (fVar != this.f١٦٥٨٣a.c().get(0)) {
            z10 = true;
        }
        this.F = z10;
        if (Thread.currentThread() != this.f١٦٦٠٥w) {
            z(g.DECODE_DATA);
            return;
        }
        g5.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            j();
        } finally {
            g5.b.e();
        }
    }

    @Override // o4.f.a
    public void d() {
        z(g.SWITCH_TO_SOURCE_SERVICE);
    }

    @Override // o4.f.a
    public void e(m4.f fVar, Exception exc, com.bumptech.glide.load.data.d dVar, m4.a aVar) {
        dVar.cleanup();
        q qVar = new q("Fetching data failed", exc);
        qVar.j(fVar, aVar, dVar.getDataClass());
        this.f١٦٥٨٤b.add(qVar);
        if (Thread.currentThread() != this.f١٦٦٠٥w) {
            z(g.SWITCH_TO_SOURCE_SERVICE);
        } else {
            A();
        }
    }

    public void f() {
        this.E = true;
        o4.f fVar = this.C;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        int n10 = n() - hVar.n();
        if (n10 == 0) {
            return this.f١٦٥٩٩q - hVar.f١٦٥٩٩q;
        }
        return n10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h o(com.bumptech.glide.c cVar, Object obj, n nVar, m4.f fVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.f fVar2, j jVar, Map map, boolean z10, boolean z11, boolean z12, m4.i iVar, b bVar, int i12) {
        this.f١٦٥٨٣a.v(cVar, obj, fVar, i10, i11, jVar, cls, cls2, fVar2, iVar, map, z10, z11, this.f١٦٥٨٦d);
        this.f١٦٥٩٠h = cVar;
        this.f١٦٥٩١i = fVar;
        this.f١٦٥٩٢j = fVar2;
        this.f١٦٥٩٣k = nVar;
        this.f١٦٥٩٤l = i10;
        this.f١٦٥٩٥m = i11;
        this.f١٦٥٩٦n = jVar;
        this.f١٦٦٠٣u = z12;
        this.f١٦٥٩٧o = iVar;
        this.f١٦٥٩٨p = bVar;
        this.f١٦٥٩٩q = i12;
        this.f١٦٦٠١s = g.INITIALIZE;
        this.f١٦٦٠٤v = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        g5.b.c("DecodeJob#run(reason=%s, model=%s)", this.f١٦٦٠١s, this.f١٦٦٠٤v);
        com.bumptech.glide.load.data.d dVar = this.f١٦٥٨٢B;
        try {
            try {
                try {
                    if (this.E) {
                        t();
                        if (dVar != null) {
                            dVar.cleanup();
                        }
                        g5.b.e();
                        return;
                    }
                    C();
                    if (dVar != null) {
                        dVar.cleanup();
                    }
                    g5.b.e();
                } catch (o4.b e10) {
                    throw e10;
                }
            } catch (Throwable th) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.f١٦٦٠٠r, th);
                }
                if (this.f١٦٦٠٠r != EnumC٠٢٠١h.ENCODE) {
                    this.f١٦٥٨٤b.add(th);
                    t();
                }
                if (!this.E) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.cleanup();
            }
            g5.b.e();
            throw th2;
        }
    }

    v w(m4.a aVar, v vVar) {
        v vVar2;
        m4.m mVar;
        m4.c cVar;
        m4.f dVar;
        Class<?> cls = vVar.getEntity().getClass();
        m4.l lVar = null;
        if (aVar != m4.a.RESOURCE_DISK_CACHE) {
            m4.m s10 = this.f١٦٥٨٣a.s(cls);
            mVar = s10;
            vVar2 = s10.transform(this.f١٦٥٩٠h, vVar, this.f١٦٥٩٤l, this.f١٦٥٩٥m);
        } else {
            vVar2 = vVar;
            mVar = null;
        }
        if (!vVar.equals(vVar2)) {
            vVar.recycle();
        }
        if (this.f١٦٥٨٣a.w(vVar2)) {
            lVar = this.f١٦٥٨٣a.n(vVar2);
            cVar = lVar.a(this.f١٦٥٩٧o);
        } else {
            cVar = m4.c.NONE;
        }
        m4.l lVar2 = lVar;
        if (this.f١٦٥٩٦n.d(!this.f١٦٥٨٣a.y(this.f١٦٦٠٦x), aVar, cVar)) {
            if (lVar2 != null) {
                int i10 = a.f١٦٦١١c[cVar.ordinal()];
                if (i10 != 1) {
                    if (i10 == 2) {
                        dVar = new x(this.f١٦٥٨٣a.b(), this.f١٦٦٠٦x, this.f١٦٥٩١i, this.f١٦٥٩٤l, this.f١٦٥٩٥m, mVar, cls, this.f١٦٥٩٧o);
                    } else {
                        throw new IllegalArgumentException("Unknown strategy: " + cVar);
                    }
                } else {
                    dVar = new o4.d(this.f١٦٦٠٦x, this.f١٦٥٩١i);
                }
                u c10 = u.c(vVar2);
                this.f١٦٥٨٨f.d(dVar, lVar2, c10);
                return c10;
            }
            throw new g.d(vVar2.getEntity().getClass());
        }
        return vVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(boolean z10) {
        if (this.f١٦٥٨٩g.d(z10)) {
            y();
        }
    }
}
