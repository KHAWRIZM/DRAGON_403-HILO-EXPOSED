package tf;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class h {
    private final f a = new f();
    private final b b = new b();
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final int e;
    private int f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class a implements i {
        private final b a;
        int b;
        private Class c;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // tf.i
        public void a() {
            this.a.d(this);
        }

        void b(int i, Class cls) {
            this.b = i;
            this.c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b != aVar.b || this.c != aVar.c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            int i2 = this.b * 31;
            Class cls = this.c;
            if (cls != null) {
                i = cls.hashCode();
            } else {
                i = 0;
            }
            return i2 + i;
        }

        public String toString() {
            return "Key{size=" + this.b + "array=" + this.c + '}';
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    private static final class b extends c {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // tf.c
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a f(int i, Class cls) {
            a aVar = (a) c();
            aVar.b(i, cls);
            return aVar;
        }
    }

    public h(int i) {
        this.e = i;
    }

    private void b(int i, Class cls) {
        NavigableMap j = j(cls);
        Integer num = (Integer) j.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                j.remove(Integer.valueOf(i));
                return;
            } else {
                j.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    private void c() {
        d(this.e);
    }

    private void d(int i) {
        while (this.f > i) {
            Object f = this.a.f();
            tf.a f2 = f(f);
            this.f -= f2.b(f) * f2.a();
            b(f2.b(f), f.getClass());
            if (Log.isLoggable(f2.getTag(), 2)) {
                Log.v(f2.getTag(), "evicted: " + f2.b(f));
            }
        }
    }

    private tf.a f(Object obj) {
        return g(obj.getClass());
    }

    private tf.a g(Class cls) {
        tf.a aVar = (tf.a) this.d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new g();
            } else if (cls.equals(byte[].class)) {
                aVar = new e();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.d.put(cls, aVar);
        }
        return aVar;
    }

    private Object h(a aVar) {
        return this.a.a(aVar);
    }

    private Object i(a aVar, Class cls) {
        tf.a g = g(cls);
        Object h = h(aVar);
        if (h != null) {
            this.f -= g.b(h) * g.a();
            b(g.b(h), cls);
        }
        if (h == null) {
            if (Log.isLoggable(g.getTag(), 2)) {
                Log.v(g.getTag(), "Allocated " + aVar.b + " bytes");
            }
            return g.newArray(aVar.b);
        }
        return h;
    }

    private NavigableMap j(Class cls) {
        NavigableMap navigableMap = (NavigableMap) this.c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private boolean k() {
        int i = this.f;
        if (i != 0 && this.e / i < 2) {
            return false;
        }
        return true;
    }

    private boolean l(int i) {
        if (i <= this.e / 2) {
            return true;
        }
        return false;
    }

    private boolean m(int i, Integer num) {
        if (num != null && (k() || num.intValue() <= i * 8)) {
            return true;
        }
        return false;
    }

    public synchronized void a() {
        d(0);
    }

    public synchronized Object e(int i, Class cls) {
        a f;
        try {
            Integer num = (Integer) j(cls).ceilingKey(Integer.valueOf(i));
            if (m(i, num)) {
                f = this.b.f(num.intValue(), cls);
            } else {
                f = this.b.f(i, cls);
            }
        } catch (Throwable th) {
            throw th;
        }
        return i(f, cls);
    }

    public synchronized void n(Object obj) {
        Class<?> cls = obj.getClass();
        tf.a g = g(cls);
        int b2 = g.b(obj);
        int a2 = g.a() * b2;
        if (!l(a2)) {
            return;
        }
        a f = this.b.f(b2, cls);
        this.a.d(f, obj);
        NavigableMap j = j(cls);
        Integer num = (Integer) j.get(Integer.valueOf(f.b));
        Integer valueOf = Integer.valueOf(f.b);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        j.put(valueOf, Integer.valueOf(i));
        this.f += a2;
        c();
    }
}
