package p4;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class i implements p4.b {

    /* renamed from: a, reason: collision with root package name */
    private final g f١٦٨٦٢a = new g();

    /* renamed from: b, reason: collision with root package name */
    private final b f١٦٨٦٣b = new b();

    /* renamed from: c, reason: collision with root package name */
    private final Map f١٦٨٦٤c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map f١٦٨٦٥d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final int f١٦٨٦٦e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٦٨٦٧f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a implements l {

        /* renamed from: a, reason: collision with root package name */
        private final b f١٦٨٦٨a;

        /* renamed from: b, reason: collision with root package name */
        int f١٦٨٦٩b;

        /* renamed from: c, reason: collision with root package name */
        private Class f١٦٨٧٠c;

        a(b bVar) {
            this.f١٦٨٦٨a = bVar;
        }

        @Override // p4.l
        public void a() {
            this.f١٦٨٦٨a.c(this);
        }

        void b(int i10, Class cls) {
            this.f١٦٨٦٩b = i10;
            this.f١٦٨٧٠c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f١٦٨٦٩b != aVar.f١٦٨٦٩b || this.f١٦٨٧٠c != aVar.f١٦٨٧٠c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i10;
            int i11 = this.f١٦٨٦٩b * 31;
            Class cls = this.f١٦٨٧٠c;
            if (cls != null) {
                i10 = cls.hashCode();
            } else {
                i10 = 0;
            }
            return i11 + i10;
        }

        public String toString() {
            return "Key{size=" + this.f١٦٨٦٩b + "array=" + this.f١٦٨٧٠c + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b extends c {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // p4.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a e(int i10, Class cls) {
            a aVar = (a) b();
            aVar.b(i10, cls);
            return aVar;
        }
    }

    public i(int i10) {
        this.f١٦٨٦٦e = i10;
    }

    private void f(int i10, Class cls) {
        NavigableMap m10 = m(cls);
        Integer num = (Integer) m10.get(Integer.valueOf(i10));
        if (num != null) {
            if (num.intValue() == 1) {
                m10.remove(Integer.valueOf(i10));
                return;
            } else {
                m10.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
    }

    private void g() {
        h(this.f١٦٨٦٦e);
    }

    private void h(int i10) {
        while (this.f١٦٨٦٧f > i10) {
            Object f10 = this.f١٦٨٦٢a.f();
            f5.k.d(f10);
            p4.a i11 = i(f10);
            this.f١٦٨٦٧f -= i11.b(f10) * i11.a();
            f(i11.b(f10), f10.getClass());
            if (Log.isLoggable(i11.getTag(), 2)) {
                Log.v(i11.getTag(), "evicted: " + i11.b(f10));
            }
        }
    }

    private p4.a i(Object obj) {
        return j(obj.getClass());
    }

    private p4.a j(Class cls) {
        p4.a aVar = (p4.a) this.f١٦٨٦٥d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new h();
            } else if (cls.equals(byte[].class)) {
                aVar = new f();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f١٦٨٦٥d.put(cls, aVar);
        }
        return aVar;
    }

    private Object k(a aVar) {
        return this.f١٦٨٦٢a.a(aVar);
    }

    private Object l(a aVar, Class cls) {
        p4.a j10 = j(cls);
        Object k10 = k(aVar);
        if (k10 != null) {
            this.f١٦٨٦٧f -= j10.b(k10) * j10.a();
            f(j10.b(k10), cls);
        }
        if (k10 == null) {
            if (Log.isLoggable(j10.getTag(), 2)) {
                Log.v(j10.getTag(), "Allocated " + aVar.f١٦٨٦٩b + " bytes");
            }
            return j10.newArray(aVar.f١٦٨٦٩b);
        }
        return k10;
    }

    private NavigableMap m(Class cls) {
        NavigableMap navigableMap = (NavigableMap) this.f١٦٨٦٤c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f١٦٨٦٤c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private boolean n() {
        int i10 = this.f١٦٨٦٧f;
        if (i10 != 0 && this.f١٦٨٦٦e / i10 < 2) {
            return false;
        }
        return true;
    }

    private boolean o(int i10) {
        if (i10 <= this.f١٦٨٦٦e / 2) {
            return true;
        }
        return false;
    }

    private boolean p(int i10, Integer num) {
        if (num != null && (n() || num.intValue() <= i10 * 8)) {
            return true;
        }
        return false;
    }

    @Override // p4.b
    public synchronized void a(int i10) {
        try {
            if (i10 >= 40) {
                b();
            } else if (i10 >= 20 || i10 == 15) {
                h(this.f١٦٨٦٦e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // p4.b
    public synchronized void b() {
        h(0);
    }

    @Override // p4.b
    public synchronized Object c(int i10, Class cls) {
        a e10;
        try {
            Integer num = (Integer) m(cls).ceilingKey(Integer.valueOf(i10));
            if (p(i10, num)) {
                e10 = this.f١٦٨٦٣b.e(num.intValue(), cls);
            } else {
                e10 = this.f١٦٨٦٣b.e(i10, cls);
            }
        } catch (Throwable th) {
            throw th;
        }
        return l(e10, cls);
    }

    @Override // p4.b
    public synchronized Object d(int i10, Class cls) {
        return l(this.f١٦٨٦٣b.e(i10, cls), cls);
    }

    @Override // p4.b
    public void e(Object obj, Class cls) {
        put(obj);
    }

    @Override // p4.b
    public synchronized void put(Object obj) {
        Class<?> cls = obj.getClass();
        p4.a j10 = j(cls);
        int b10 = j10.b(obj);
        int a10 = j10.a() * b10;
        if (!o(a10)) {
            return;
        }
        a e10 = this.f١٦٨٦٣b.e(b10, cls);
        this.f١٦٨٦٢a.d(e10, obj);
        NavigableMap m10 = m(cls);
        Integer num = (Integer) m10.get(Integer.valueOf(e10.f١٦٨٦٩b));
        Integer valueOf = Integer.valueOf(e10.f١٦٨٦٩b);
        int i10 = 1;
        if (num != null) {
            i10 = 1 + num.intValue();
        }
        m10.put(valueOf, Integer.valueOf(i10));
        this.f١٦٨٦٧f += a10;
        g();
    }
}
