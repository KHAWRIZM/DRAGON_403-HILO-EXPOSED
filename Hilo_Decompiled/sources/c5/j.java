package c5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.b;
import f5.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import o4.k;
import o4.q;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class j implements d, com.bumptech.glide.request.target.i, i {
    private static final boolean E = Log.isLoggable("GlideRequest", 2);
    private int A;

    /* renamed from: B, reason: collision with root package name */
    private int f٥٨٨٦B;
    private boolean C;
    private RuntimeException D;

    /* renamed from: a, reason: collision with root package name */
    private int f٥٨٨٧a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٥٨٨٨b;

    /* renamed from: c, reason: collision with root package name */
    private final g5.c f٥٨٨٩c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f٥٨٩٠d;

    /* renamed from: e, reason: collision with root package name */
    private final g f٥٨٩١e;

    /* renamed from: f, reason: collision with root package name */
    private final e f٥٨٩٢f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f٥٨٩٣g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.c f٥٨٩٤h;

    /* renamed from: i, reason: collision with root package name */
    private final Object f٥٨٩٥i;

    /* renamed from: j, reason: collision with root package name */
    private final Class f٥٨٩٦j;

    /* renamed from: k, reason: collision with root package name */
    private final c5.a f٥٨٩٧k;

    /* renamed from: l, reason: collision with root package name */
    private final int f٥٨٩٨l;

    /* renamed from: m, reason: collision with root package name */
    private final int f٥٨٩٩m;

    /* renamed from: n, reason: collision with root package name */
    private final com.bumptech.glide.f f٥٩٠٠n;

    /* renamed from: o, reason: collision with root package name */
    private final com.bumptech.glide.request.target.j f٥٩٠١o;

    /* renamed from: p, reason: collision with root package name */
    private final List f٥٩٠٢p;

    /* renamed from: q, reason: collision with root package name */
    private final d5.c f٥٩٠٣q;

    /* renamed from: r, reason: collision with root package name */
    private final Executor f٥٩٠٤r;

    /* renamed from: s, reason: collision with root package name */
    private v f٥٩٠٥s;

    /* renamed from: t, reason: collision with root package name */
    private k.d f٥٩٠٦t;

    /* renamed from: u, reason: collision with root package name */
    private long f٥٩٠٧u;

    /* renamed from: v, reason: collision with root package name */
    private volatile o4.k f٥٩٠٨v;

    /* renamed from: w, reason: collision with root package name */
    private a f٥٩٠٩w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f٥٩١٠x;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f٥٩١١y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f٥٩١٢z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private j(Context context, com.bumptech.glide.c cVar, Object obj, Object obj2, Class cls, c5.a aVar, int i10, int i11, com.bumptech.glide.f fVar, com.bumptech.glide.request.target.j jVar, g gVar, List list, e eVar, o4.k kVar, d5.c cVar2, Executor executor) {
        String str;
        if (E) {
            str = String.valueOf(super.hashCode());
        } else {
            str = null;
        }
        this.f٥٨٨٨b = str;
        this.f٥٨٨٩c = g5.c.a();
        this.f٥٨٩٠d = obj;
        this.f٥٨٩٣g = context;
        this.f٥٨٩٤h = cVar;
        this.f٥٨٩٥i = obj2;
        this.f٥٨٩٦j = cls;
        this.f٥٨٩٧k = aVar;
        this.f٥٨٩٨l = i10;
        this.f٥٨٩٩m = i11;
        this.f٥٩٠٠n = fVar;
        this.f٥٩٠١o = jVar;
        this.f٥٨٩١e = gVar;
        this.f٥٩٠٢p = list;
        this.f٥٨٩٢f = eVar;
        this.f٥٩٠٨v = kVar;
        this.f٥٩٠٣q = cVar2;
        this.f٥٩٠٤r = executor;
        this.f٥٩٠٩w = a.PENDING;
        if (this.D == null && cVar.g().a(b.c.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    private void A() {
        Drawable drawable;
        if (!k()) {
            return;
        }
        if (this.f٥٨٩٥i == null) {
            drawable = p();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            drawable = o();
        }
        if (drawable == null) {
            drawable = q();
        }
        this.f٥٩٠١o.onLoadFailed(drawable);
    }

    private void h() {
        if (!this.C) {
        } else {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean i() {
        e eVar = this.f٥٨٩٢f;
        if (eVar != null && !eVar.c(this)) {
            return false;
        }
        return true;
    }

    private boolean k() {
        e eVar = this.f٥٨٩٢f;
        if (eVar != null && !eVar.i(this)) {
            return false;
        }
        return true;
    }

    private boolean l() {
        e eVar = this.f٥٨٩٢f;
        if (eVar != null && !eVar.b(this)) {
            return false;
        }
        return true;
    }

    private void m() {
        h();
        this.f٥٨٨٩c.c();
        this.f٥٩٠١o.removeCallback(this);
        k.d dVar = this.f٥٩٠٦t;
        if (dVar != null) {
            dVar.a();
            this.f٥٩٠٦t = null;
        }
    }

    private void n(Object obj) {
        List<g> list = this.f٥٩٠٢p;
        if (list == null) {
            return;
        }
        for (g gVar : list) {
        }
    }

    private Drawable o() {
        if (this.f٥٩١٠x == null) {
            Drawable n10 = this.f٥٨٩٧k.n();
            this.f٥٩١٠x = n10;
            if (n10 == null && this.f٥٨٩٧k.m() > 0) {
                this.f٥٩١٠x = s(this.f٥٨٩٧k.m());
            }
        }
        return this.f٥٩١٠x;
    }

    private Drawable p() {
        if (this.f٥٩١٢z == null) {
            Drawable o10 = this.f٥٨٩٧k.o();
            this.f٥٩١٢z = o10;
            if (o10 == null && this.f٥٨٩٧k.p() > 0) {
                this.f٥٩١٢z = s(this.f٥٨٩٧k.p());
            }
        }
        return this.f٥٩١٢z;
    }

    private Drawable q() {
        if (this.f٥٩١١y == null) {
            Drawable u10 = this.f٥٨٩٧k.u();
            this.f٥٩١١y = u10;
            if (u10 == null && this.f٥٨٩٧k.v() > 0) {
                this.f٥٩١١y = s(this.f٥٨٩٧k.v());
            }
        }
        return this.f٥٩١١y;
    }

    private boolean r() {
        e eVar = this.f٥٨٩٢f;
        if (eVar != null && eVar.getRoot().a()) {
            return false;
        }
        return true;
    }

    private Drawable s(int i10) {
        Resources.Theme theme;
        if (this.f٥٨٩٧k.A() != null) {
            theme = this.f٥٨٩٧k.A();
        } else {
            theme = this.f٥٨٩٣g.getTheme();
        }
        return com.bumptech.glide.load.resource.drawable.h.a(this.f٥٨٩٣g, i10, theme);
    }

    private void t(String str) {
        Log.v("GlideRequest", str + " this: " + this.f٥٨٨٨b);
    }

    private static int u(int i10, float f10) {
        if (i10 != Integer.MIN_VALUE) {
            return Math.round(f10 * i10);
        }
        return i10;
    }

    private void v() {
        e eVar = this.f٥٨٩٢f;
        if (eVar != null) {
            eVar.h(this);
        }
    }

    private void w() {
        e eVar = this.f٥٨٩٢f;
        if (eVar != null) {
            eVar.d(this);
        }
    }

    public static j x(Context context, com.bumptech.glide.c cVar, Object obj, Object obj2, Class cls, c5.a aVar, int i10, int i11, com.bumptech.glide.f fVar, com.bumptech.glide.request.target.j jVar, g gVar, List list, e eVar, o4.k kVar, d5.c cVar2, Executor executor) {
        return new j(context, cVar, obj, obj2, cls, aVar, i10, i11, fVar, jVar, gVar, list, eVar, kVar, cVar2, executor);
    }

    private void y(q qVar, int i10) {
        boolean z10;
        this.f٥٨٨٩c.c();
        synchronized (this.f٥٨٩٠d) {
            try {
                qVar.k(this.D);
                int h10 = this.f٥٨٩٤h.h();
                if (h10 <= i10) {
                    Log.w("Glide", "Load failed for [" + this.f٥٨٩٥i + "] with dimensions [" + this.A + "x" + this.f٥٨٨٦B + "]", qVar);
                    if (h10 <= 4) {
                        qVar.g("Glide");
                    }
                }
                this.f٥٩٠٦t = null;
                this.f٥٩٠٩w = a.FAILED;
                v();
                boolean z11 = true;
                this.C = true;
                try {
                    List list = this.f٥٩٠٢p;
                    if (list != null) {
                        Iterator it = list.iterator();
                        z10 = false;
                        while (it.hasNext()) {
                            z10 |= ((g) it.next()).onLoadFailed(qVar, this.f٥٨٩٥i, this.f٥٩٠١o, r());
                        }
                    } else {
                        z10 = false;
                    }
                    g gVar = this.f٥٨٩١e;
                    if (gVar == null || !gVar.onLoadFailed(qVar, this.f٥٨٩٥i, this.f٥٩٠١o, r())) {
                        z11 = false;
                    }
                    if (!(z10 | z11)) {
                        A();
                    }
                    this.C = false;
                    g5.b.f("GlideRequest", this.f٥٨٨٧a);
                } catch (Throwable th) {
                    this.C = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void z(v vVar, Object obj, m4.a aVar, boolean z10) {
        boolean z11;
        boolean r10 = r();
        this.f٥٩٠٩w = a.COMPLETE;
        this.f٥٩٠٥s = vVar;
        if (this.f٥٨٩٤h.h() <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + aVar + " for " + this.f٥٨٩٥i + " with size [" + this.A + "x" + this.f٥٨٨٦B + "] in " + f5.g.a(this.f٥٩٠٧u) + " ms");
        }
        w();
        boolean z12 = true;
        this.C = true;
        try {
            List list = this.f٥٩٠٢p;
            if (list != null) {
                Iterator it = list.iterator();
                z11 = false;
                while (it.hasNext()) {
                    z11 |= ((g) it.next()).onResourceReady(obj, this.f٥٨٩٥i, this.f٥٩٠١o, aVar, r10);
                }
            } else {
                z11 = false;
            }
            g gVar = this.f٥٨٩١e;
            if (gVar == null || !gVar.onResourceReady(obj, this.f٥٨٩٥i, this.f٥٩٠١o, aVar, r10)) {
                z12 = false;
            }
            if (!(z12 | z11)) {
                this.f٥٩٠١o.onResourceReady(obj, this.f٥٩٠٣q.a(aVar, r10));
            }
            this.C = false;
            g5.b.f("GlideRequest", this.f٥٨٨٧a);
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    @Override // c5.d
    public boolean a() {
        boolean z10;
        synchronized (this.f٥٨٩٠d) {
            if (this.f٥٩٠٩w == a.COMPLETE) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // c5.i
    public void b(v vVar, m4.a aVar, boolean z10) {
        Object obj;
        String str;
        this.f٥٨٨٩c.c();
        v vVar2 = null;
        try {
            synchronized (this.f٥٨٩٠d) {
                try {
                    this.f٥٩٠٦t = null;
                    if (vVar == null) {
                        c(new q("Expected to receive a Resource<R> with an object of " + this.f٥٨٩٦j + " inside, but instead got null."));
                        return;
                    }
                    Object entity = vVar.getEntity();
                    try {
                        if (entity != null && this.f٥٨٩٦j.isAssignableFrom(entity.getClass())) {
                            if (!l()) {
                                this.f٥٩٠٥s = null;
                                this.f٥٩٠٩w = a.COMPLETE;
                                g5.b.f("GlideRequest", this.f٥٨٨٧a);
                                this.f٥٩٠٨v.l(vVar);
                                return;
                            }
                            z(vVar, entity, aVar, z10);
                            return;
                        }
                        this.f٥٩٠٥s = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.f٥٨٩٦j);
                        sb.append(" but instead got ");
                        if (entity != null) {
                            obj = entity.getClass();
                        } else {
                            obj = "";
                        }
                        sb.append(obj);
                        sb.append("{");
                        sb.append(entity);
                        sb.append("} inside Resource{");
                        sb.append(vVar);
                        sb.append("}.");
                        if (entity != null) {
                            str = "";
                        } else {
                            str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                        }
                        sb.append(str);
                        c(new q(sb.toString()));
                        this.f٥٩٠٨v.l(vVar);
                    } catch (Throwable th) {
                        vVar2 = vVar;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (vVar2 != null) {
                this.f٥٩٠٨v.l(vVar2);
            }
            throw th3;
        }
    }

    @Override // c5.i
    public void c(q qVar) {
        y(qVar, 5);
    }

    @Override // c5.d
    public void clear() {
        synchronized (this.f٥٨٩٠d) {
            try {
                h();
                this.f٥٨٨٩c.c();
                a aVar = this.f٥٩٠٩w;
                a aVar2 = a.CLEARED;
                if (aVar == aVar2) {
                    return;
                }
                m();
                v vVar = this.f٥٩٠٥s;
                if (vVar != null) {
                    this.f٥٩٠٥s = null;
                } else {
                    vVar = null;
                }
                if (i()) {
                    this.f٥٩٠١o.onLoadCleared(q());
                }
                g5.b.f("GlideRequest", this.f٥٨٨٧a);
                this.f٥٩٠٩w = aVar2;
                if (vVar != null) {
                    this.f٥٩٠٨v.l(vVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.target.i
    public void d(int i10, int i11) {
        Object obj;
        this.f٥٨٨٩c.c();
        Object obj2 = this.f٥٨٩٠d;
        synchronized (obj2) {
            try {
                try {
                    boolean z10 = E;
                    if (z10) {
                        t("Got onSizeReady in " + f5.g.a(this.f٥٩٠٧u));
                    }
                    if (this.f٥٩٠٩w == a.WAITING_FOR_SIZE) {
                        a aVar = a.RUNNING;
                        this.f٥٩٠٩w = aVar;
                        float z11 = this.f٥٨٩٧k.z();
                        this.A = u(i10, z11);
                        this.f٥٨٨٦B = u(i11, z11);
                        if (z10) {
                            t("finished setup for calling load in " + f5.g.a(this.f٥٩٠٧u));
                        }
                        obj = obj2;
                        try {
                            this.f٥٩٠٦t = this.f٥٩٠٨v.g(this.f٥٨٩٤h, this.f٥٨٩٥i, this.f٥٨٩٧k.y(), this.A, this.f٥٨٨٦B, this.f٥٨٩٧k.x(), this.f٥٨٩٦j, this.f٥٩٠٠n, this.f٥٨٩٧k.l(), this.f٥٨٩٧k.B(), this.f٥٨٩٧k.M(), this.f٥٨٩٧k.I(), this.f٥٨٩٧k.r(), this.f٥٨٩٧k.G(), this.f٥٨٩٧k.D(), this.f٥٨٩٧k.C(), this.f٥٨٩٧k.q(), this, this.f٥٩٠٤r);
                            if (this.f٥٩٠٩w != aVar) {
                                this.f٥٩٠٦t = null;
                            }
                            if (z10) {
                                t("finished onSizeReady in " + f5.g.a(this.f٥٩٠٧u));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    @Override // c5.d
    public boolean e() {
        boolean z10;
        synchronized (this.f٥٨٩٠d) {
            if (this.f٥٩٠٩w == a.CLEARED) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // c5.d
    public boolean f(d dVar) {
        int i10;
        int i11;
        Object obj;
        Class cls;
        c5.a aVar;
        com.bumptech.glide.f fVar;
        int i12;
        int i13;
        int i14;
        Object obj2;
        Class cls2;
        c5.a aVar2;
        com.bumptech.glide.f fVar2;
        int i15;
        if (!(dVar instanceof j)) {
            return false;
        }
        synchronized (this.f٥٨٩٠d) {
            try {
                i10 = this.f٥٨٩٨l;
                i11 = this.f٥٨٩٩m;
                obj = this.f٥٨٩٥i;
                cls = this.f٥٨٩٦j;
                aVar = this.f٥٨٩٧k;
                fVar = this.f٥٩٠٠n;
                List list = this.f٥٩٠٢p;
                if (list != null) {
                    i12 = list.size();
                } else {
                    i12 = 0;
                }
            } finally {
            }
        }
        j jVar = (j) dVar;
        synchronized (jVar.f٥٨٩٠d) {
            try {
                i13 = jVar.f٥٨٩٨l;
                i14 = jVar.f٥٨٩٩m;
                obj2 = jVar.f٥٨٩٥i;
                cls2 = jVar.f٥٨٩٦j;
                aVar2 = jVar.f٥٨٩٧k;
                fVar2 = jVar.f٥٩٠٠n;
                List list2 = jVar.f٥٩٠٢p;
                if (list2 != null) {
                    i15 = list2.size();
                } else {
                    i15 = 0;
                }
            } finally {
            }
        }
        if (i10 == i13 && i11 == i14 && l.d(obj, obj2) && cls.equals(cls2) && l.c(aVar, aVar2) && fVar == fVar2 && i12 == i15) {
            return true;
        }
        return false;
    }

    @Override // c5.d
    public boolean g() {
        boolean z10;
        synchronized (this.f٥٨٩٠d) {
            if (this.f٥٩٠٩w == a.COMPLETE) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // c5.i
    public Object getLock() {
        this.f٥٨٨٩c.c();
        return this.f٥٨٩٠d;
    }

    @Override // c5.d
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f٥٨٩٠d) {
            try {
                a aVar = this.f٥٩٠٩w;
                if (aVar != a.RUNNING && aVar != a.WAITING_FOR_SIZE) {
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    @Override // c5.d
    public void j() {
        int i10;
        synchronized (this.f٥٨٩٠d) {
            try {
                h();
                this.f٥٨٨٩c.c();
                this.f٥٩٠٧u = f5.g.b();
                Object obj = this.f٥٨٩٥i;
                if (obj == null) {
                    if (l.v(this.f٥٨٩٨l, this.f٥٨٩٩m)) {
                        this.A = this.f٥٨٩٨l;
                        this.f٥٨٨٦B = this.f٥٨٩٩m;
                    }
                    if (p() == null) {
                        i10 = 5;
                    } else {
                        i10 = 3;
                    }
                    y(new q("Received null model"), i10);
                    return;
                }
                a aVar = this.f٥٩٠٩w;
                a aVar2 = a.RUNNING;
                if (aVar != aVar2) {
                    if (aVar == a.COMPLETE) {
                        b(this.f٥٩٠٥s, m4.a.MEMORY_CACHE, false);
                        return;
                    }
                    n(obj);
                    this.f٥٨٨٧a = g5.b.b("GlideRequest");
                    a aVar3 = a.WAITING_FOR_SIZE;
                    this.f٥٩٠٩w = aVar3;
                    if (l.v(this.f٥٨٩٨l, this.f٥٨٩٩m)) {
                        d(this.f٥٨٩٨l, this.f٥٨٩٩m);
                    } else {
                        this.f٥٩٠١o.getSize(this);
                    }
                    a aVar4 = this.f٥٩٠٩w;
                    if ((aVar4 == aVar2 || aVar4 == aVar3) && k()) {
                        this.f٥٩٠١o.onLoadStarted(q());
                    }
                    if (E) {
                        t("finished run method in " + f5.g.a(this.f٥٩٠٧u));
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot restart a running request");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // c5.d
    public void pause() {
        synchronized (this.f٥٨٩٠d) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        Object obj;
        Class cls;
        synchronized (this.f٥٨٩٠d) {
            obj = this.f٥٨٩٥i;
            cls = this.f٥٨٩٦j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
