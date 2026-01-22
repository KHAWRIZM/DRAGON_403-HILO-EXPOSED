package o4;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o4.h;
import t4.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final List f١٦٥٦٤a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List f١٦٥٦٥b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.c f١٦٥٦٦c;

    /* renamed from: d, reason: collision with root package name */
    private Object f١٦٥٦٧d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٦٥٦٨e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٦٥٦٩f;

    /* renamed from: g, reason: collision with root package name */
    private Class f١٦٥٧٠g;

    /* renamed from: h, reason: collision with root package name */
    private h.e f١٦٥٧١h;

    /* renamed from: i, reason: collision with root package name */
    private m4.i f١٦٥٧٢i;

    /* renamed from: j, reason: collision with root package name */
    private Map f١٦٥٧٣j;

    /* renamed from: k, reason: collision with root package name */
    private Class f١٦٥٧٤k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f١٦٥٧٥l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٦٥٧٦m;

    /* renamed from: n, reason: collision with root package name */
    private m4.f f١٦٥٧٧n;

    /* renamed from: o, reason: collision with root package name */
    private com.bumptech.glide.f f١٦٥٧٨o;

    /* renamed from: p, reason: collision with root package name */
    private j f١٦٥٧٩p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٦٥٨٠q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f١٦٥٨١r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f١٦٥٦٦c = null;
        this.f١٦٥٦٧d = null;
        this.f١٦٥٧٧n = null;
        this.f١٦٥٧٠g = null;
        this.f١٦٥٧٤k = null;
        this.f١٦٥٧٢i = null;
        this.f١٦٥٧٨o = null;
        this.f١٦٥٧٣j = null;
        this.f١٦٥٧٩p = null;
        this.f١٦٥٦٤a.clear();
        this.f١٦٥٧٥l = false;
        this.f١٦٥٦٥b.clear();
        this.f١٦٥٧٦m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p4.b b() {
        return this.f١٦٥٦٦c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List c() {
        if (!this.f١٦٥٧٦m) {
            this.f١٦٥٧٦m = true;
            this.f١٦٥٦٥b.clear();
            List g10 = g();
            int size = g10.size();
            for (int i10 = 0; i10 < size; i10++) {
                n.a aVar = (n.a) g10.get(i10);
                if (!this.f١٦٥٦٥b.contains(aVar.f١٨٠٨٤a)) {
                    this.f١٦٥٦٥b.add(aVar.f١٨٠٨٤a);
                }
                for (int i11 = 0; i11 < aVar.f١٨٠٨٥b.size(); i11++) {
                    if (!this.f١٦٥٦٥b.contains(aVar.f١٨٠٨٥b.get(i11))) {
                        this.f١٦٥٦٥b.add(aVar.f١٨٠٨٥b.get(i11));
                    }
                }
            }
        }
        return this.f١٦٥٦٥b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q4.a d() {
        return this.f١٦٥٧١h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j e() {
        return this.f١٦٥٧٩p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f١٦٥٦٩f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List g() {
        if (!this.f١٦٥٧٥l) {
            this.f١٦٥٧٥l = true;
            this.f١٦٥٦٤a.clear();
            List i10 = this.f١٦٥٦٦c.i().i(this.f١٦٥٦٧d);
            int size = i10.size();
            for (int i11 = 0; i11 < size; i11++) {
                n.a buildLoadData = ((t4.n) i10.get(i11)).buildLoadData(this.f١٦٥٦٧d, this.f١٦٥٦٨e, this.f١٦٥٦٩f, this.f١٦٥٧٢i);
                if (buildLoadData != null) {
                    this.f١٦٥٦٤a.add(buildLoadData);
                }
            }
        }
        return this.f١٦٥٦٤a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t h(Class cls) {
        return this.f١٦٥٦٦c.i().h(cls, this.f١٦٥٧٠g, this.f١٦٥٧٤k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class i() {
        return this.f١٦٥٦٧d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List j(File file) {
        return this.f١٦٥٦٦c.i().i(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m4.i k() {
        return this.f١٦٥٧٢i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.f l() {
        return this.f١٦٥٧٨o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List m() {
        return this.f١٦٥٦٦c.i().j(this.f١٦٥٦٧d.getClass(), this.f١٦٥٧٠g, this.f١٦٥٧٤k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m4.l n(v vVar) {
        return this.f١٦٥٦٦c.i().k(vVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.data.e o(Object obj) {
        return this.f١٦٥٦٦c.i().l(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m4.f p() {
        return this.f١٦٥٧٧n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m4.d q(Object obj) {
        return this.f١٦٥٦٦c.i().m(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class r() {
        return this.f١٦٥٧٤k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m4.m s(Class cls) {
        m4.m mVar = (m4.m) this.f١٦٥٧٣j.get(cls);
        if (mVar == null) {
            Iterator it = this.f١٦٥٧٣j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    mVar = (m4.m) entry.getValue();
                    break;
                }
            }
        }
        if (mVar == null) {
            if (this.f١٦٥٧٣j.isEmpty() && this.f١٦٥٨٠q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return com.bumptech.glide.load.resource.l.a();
        }
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t() {
        return this.f١٦٥٦٨e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u(Class cls) {
        if (h(cls) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(com.bumptech.glide.c cVar, Object obj, m4.f fVar, int i10, int i11, j jVar, Class cls, Class cls2, com.bumptech.glide.f fVar2, m4.i iVar, Map map, boolean z10, boolean z11, h.e eVar) {
        this.f١٦٥٦٦c = cVar;
        this.f١٦٥٦٧d = obj;
        this.f١٦٥٧٧n = fVar;
        this.f١٦٥٦٨e = i10;
        this.f١٦٥٦٩f = i11;
        this.f١٦٥٧٩p = jVar;
        this.f١٦٥٧٠g = cls;
        this.f١٦٥٧١h = eVar;
        this.f١٦٥٧٤k = cls2;
        this.f١٦٥٧٨o = fVar2;
        this.f١٦٥٧٢i = iVar;
        this.f١٦٥٧٣j = map;
        this.f١٦٥٨٠q = z10;
        this.f١٦٥٨١r = z11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w(v vVar) {
        return this.f١٦٥٦٦c.i().n(vVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return this.f١٦٥٨١r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(m4.f fVar) {
        List g10 = g();
        int size = g10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((n.a) g10.get(i10)).f١٨٠٨٤a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
