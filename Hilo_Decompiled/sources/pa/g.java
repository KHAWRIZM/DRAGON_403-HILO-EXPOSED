package pa;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class g implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    private static final h f١٧٠٠١i = new d();

    /* renamed from: j, reason: collision with root package name */
    private static final h f١٧٠٠٢j = new pa.b();

    /* renamed from: k, reason: collision with root package name */
    private static Class[] f١٧٠٠٣k;

    /* renamed from: l, reason: collision with root package name */
    private static Class[] f١٧٠٠٤l;

    /* renamed from: m, reason: collision with root package name */
    private static Class[] f١٧٠٠٥m;

    /* renamed from: n, reason: collision with root package name */
    private static final HashMap f١٧٠٠٦n;

    /* renamed from: o, reason: collision with root package name */
    private static final HashMap f١٧٠٠٧o;

    /* renamed from: a, reason: collision with root package name */
    String f١٧٠٠٨a;

    /* renamed from: b, reason: collision with root package name */
    Method f١٧٠٠٩b;

    /* renamed from: c, reason: collision with root package name */
    private Method f١٧٠١٠c;

    /* renamed from: d, reason: collision with root package name */
    Class f١٧٠١١d;

    /* renamed from: e, reason: collision with root package name */
    f f١٧٠١٢e;

    /* renamed from: f, reason: collision with root package name */
    final ReentrantReadWriteLock f١٧٠١٣f;

    /* renamed from: g, reason: collision with root package name */
    final Object[] f١٧٠١٤g;

    /* renamed from: h, reason: collision with root package name */
    private h f١٧٠١٥h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class b extends g {

        /* renamed from: p, reason: collision with root package name */
        c f١٧٠١٦p;

        /* renamed from: q, reason: collision with root package name */
        float f١٧٠١٧q;

        public b(String str, float... fArr) {
            super(str);
            g(fArr);
        }

        @Override // pa.g
        void a(float f10) {
            this.f١٧٠١٧q = this.f١٧٠١٦p.e(f10);
        }

        @Override // pa.g
        Object c() {
            return Float.valueOf(this.f١٧٠١٧q);
        }

        @Override // pa.g
        public void g(float... fArr) {
            super.g(fArr);
            this.f١٧٠١٦p = (c) this.f١٧٠١٢e;
        }

        @Override // pa.g
        /* renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public b clone() {
            b bVar = (b) super.clone();
            bVar.f١٧٠١٦p = (c) bVar.f١٧٠١٢e;
            return bVar;
        }
    }

    static {
        Class cls = Float.TYPE;
        Class cls2 = Double.TYPE;
        Class cls3 = Integer.TYPE;
        f١٧٠٠٣k = new Class[]{cls, Float.class, cls2, cls3, Double.class, Integer.class};
        f١٧٠٠٤l = new Class[]{cls3, Integer.class, cls, cls2, Float.class, Double.class};
        f١٧٠٠٥m = new Class[]{cls2, Double.class, cls, cls3, Float.class, Integer.class};
        f١٧٠٠٦n = new HashMap();
        f١٧٠٠٧o = new HashMap();
    }

    public static g f(String str, float... fArr) {
        return new b(str, fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(float f10);

    /* renamed from: b */
    public g clone() {
        try {
            g gVar = (g) super.clone();
            gVar.f١٧٠٠٨a = this.f١٧٠٠٨a;
            gVar.f١٧٠١٢e = this.f١٧٠١٢e.clone();
            gVar.f١٧٠١٥h = this.f١٧٠١٥h;
            return gVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object c();

    public String d() {
        return this.f١٧٠٠٨a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        h hVar;
        if (this.f١٧٠١٥h == null) {
            Class cls = this.f١٧٠١١d;
            if (cls == Integer.class) {
                hVar = f١٧٠٠١i;
            } else if (cls == Float.class) {
                hVar = f١٧٠٠٢j;
            } else {
                hVar = null;
            }
            this.f١٧٠١٥h = hVar;
        }
        h hVar2 = this.f١٧٠١٥h;
        if (hVar2 != null) {
            this.f١٧٠١٢e.c(hVar2);
        }
    }

    public void g(float... fArr) {
        this.f١٧٠١١d = Float.TYPE;
        this.f١٧٠١٢e = f.b(fArr);
    }

    public String toString() {
        return this.f١٧٠٠٨a + ": " + this.f١٧٠١٢e.toString();
    }

    private g(String str) {
        this.f١٧٠٠٩b = null;
        this.f١٧٠١٠c = null;
        this.f١٧٠١٢e = null;
        this.f١٧٠١٣f = new ReentrantReadWriteLock();
        this.f١٧٠١٤g = new Object[1];
        this.f١٧٠٠٨a = str;
    }
}
