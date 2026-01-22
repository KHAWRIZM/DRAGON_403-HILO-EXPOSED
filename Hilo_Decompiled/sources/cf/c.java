package cf;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class c {
    static volatile c s;
    private static final d t = new d();
    private static final Map u = new HashMap();
    private final Map a;
    private final Map b;
    private final Map c;
    private final ThreadLocal d;
    private final h e;
    private final l f;
    private final cf.b g;
    private final cf.a h;
    private final p i;
    private final ExecutorService j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final int q;
    private final g r;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C٠٠٠٠c initialValue() {
            return new C٠٠٠٠c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cf.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class C٠٠٠٠c {
        final List a = new ArrayList();
        boolean b;
        boolean c;
        q d;
        Object e;
        boolean f;

        C٠٠٠٠c() {
        }
    }

    public c() {
        this(t);
    }

    static void a(List list, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    private void b(q qVar, Object obj) {
        if (obj != null) {
            o(qVar, obj, i());
        }
    }

    public static c c() {
        c cVar = s;
        if (cVar == null) {
            synchronized (c.class) {
                try {
                    cVar = s;
                    if (cVar == null) {
                        cVar = new c();
                        s = cVar;
                    }
                } finally {
                }
            }
        }
        return cVar;
    }

    private void f(q qVar, Object obj, Throwable th) {
        if (obj instanceof n) {
            if (this.l) {
                g gVar = this.r;
                Level level = Level.SEVERE;
                gVar.a(level, "SubscriberExceptionEvent subscriber " + qVar.a.getClass() + " threw an exception", th);
                n nVar = (n) obj;
                this.r.a(level, "Initial event " + nVar.c + " caused exception in " + nVar.d, nVar.b);
                return;
            }
            return;
        }
        if (!this.k) {
            if (this.l) {
                this.r.a(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + qVar.a.getClass(), th);
            }
            if (this.n) {
                l(new n(this, th, obj, qVar.a));
                return;
            }
            return;
        }
        throw new e("Invoking subscriber failed", th);
    }

    private boolean i() {
        h hVar = this.e;
        if (hVar != null && !hVar.a()) {
            return false;
        }
        return true;
    }

    private static List k(Class cls) {
        List list;
        Map map = u;
        synchronized (map) {
            try {
                list = (List) map.get(cls);
                if (list == null) {
                    list = new ArrayList();
                    for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                        list.add(cls2);
                        a(list, cls2.getInterfaces());
                    }
                    u.put(cls, list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    private void m(Object obj, C٠٠٠٠c r8) {
        boolean n;
        Class<?> cls = obj.getClass();
        if (this.p) {
            List k = k(cls);
            int size = k.size();
            n = false;
            for (int i = 0; i < size; i++) {
                n |= n(obj, r8, (Class) k.get(i));
            }
        } else {
            n = n(obj, r8, cls);
        }
        if (!n) {
            if (this.m) {
                this.r.b(Level.FINE, "No subscribers registered for event " + cls);
            }
            if (this.o && cls != i.class && cls != n.class) {
                l(new i(this, obj));
            }
        }
    }

    private boolean n(Object obj, C٠٠٠٠c r6, Class cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            r6.e = obj;
            r6.d = qVar;
            try {
                o(qVar, obj, r6.c);
                if (r6.f) {
                    return true;
                }
            } finally {
                r6.e = null;
                r6.d = null;
                r6.f = false;
            }
        }
        return true;
    }

    private void o(q qVar, Object obj, boolean z) {
        int i = b.a[qVar.b.b.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            this.h.a(qVar, obj);
                            return;
                        }
                        throw new IllegalStateException("Unknown thread mode: " + qVar.b.b);
                    }
                    if (z) {
                        this.g.a(qVar, obj);
                        return;
                    } else {
                        h(qVar, obj);
                        return;
                    }
                }
                l lVar = this.f;
                if (lVar != null) {
                    lVar.a(qVar, obj);
                    return;
                } else {
                    h(qVar, obj);
                    return;
                }
            }
            if (z) {
                h(qVar, obj);
                return;
            } else {
                this.f.a(qVar, obj);
                return;
            }
        }
        h(qVar, obj);
    }

    private void q(Object obj, o oVar) {
        Class cls = oVar.c;
        q qVar = new q(obj, oVar);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || oVar.d > ((q) copyOnWriteArrayList.get(i)).b.d) {
                copyOnWriteArrayList.add(i, qVar);
                break;
            }
        }
        List list = (List) this.b.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.b.put(obj, list);
        }
        list.add(cls);
        if (oVar.e) {
            if (this.p) {
                for (Map.Entry entry : this.c.entrySet()) {
                    if (cls.isAssignableFrom((Class) entry.getKey())) {
                        b(qVar, entry.getValue());
                    }
                }
                return;
            }
            b(qVar, this.c.get(cls));
        }
    }

    private void s(Object obj, Class cls) {
        List list = (List) this.a.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                q qVar = (q) list.get(i);
                if (qVar.a == obj) {
                    qVar.c = false;
                    list.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorService d() {
        return this.j;
    }

    public g e() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(j jVar) {
        Object obj = jVar.a;
        q qVar = jVar.b;
        j.b(jVar);
        if (qVar.c) {
            h(qVar, obj);
        }
    }

    void h(q qVar, Object obj) {
        try {
            qVar.b.a.invoke(qVar.a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            f(qVar, obj, e2.getCause());
        }
    }

    public synchronized boolean j(Object obj) {
        return this.b.containsKey(obj);
    }

    public void l(Object obj) {
        C٠٠٠٠c r0 = (C٠٠٠٠c) this.d.get();
        List list = r0.a;
        list.add(obj);
        if (!r0.b) {
            r0.c = i();
            r0.b = true;
            if (r0.f) {
                throw new e("Internal error. Abort state was not reset");
            }
            while (true) {
                try {
                    if (!list.isEmpty()) {
                        m(list.remove(0), r0);
                    } else {
                        return;
                    }
                } finally {
                    r0.b = false;
                    r0.c = false;
                }
            }
        }
    }

    public void p(Object obj) {
        if (df.b.c() && !df.b.a()) {
            throw new RuntimeException("It looks like you are using EventBus on Android, make sure to add the \"eventbus\" Android library to your dependencies.");
        }
        List a2 = this.i.a(obj.getClass());
        synchronized (this) {
            try {
                Iterator it = a2.iterator();
                while (it.hasNext()) {
                    q(obj, (o) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void r(Object obj) {
        try {
            List list = (List) this.b.get(obj);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    s(obj, (Class) it.next());
                }
                this.b.remove(obj);
            } else {
                this.r.b(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.q + ", eventInheritance=" + this.p + "]";
    }

    c(d dVar) {
        this.d = new a();
        this.r = dVar.a();
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        h b2 = dVar.b();
        this.e = b2;
        this.f = b2 != null ? b2.b(this) : null;
        this.g = new cf.b(this);
        this.h = new cf.a(this);
        List list = dVar.j;
        this.q = list != null ? list.size() : 0;
        this.i = new p(dVar.j, dVar.h, dVar.g);
        this.l = dVar.a;
        this.m = dVar.b;
        this.n = dVar.c;
        this.o = dVar.d;
        this.k = dVar.e;
        this.p = dVar.f;
        this.j = dVar.i;
    }
}
