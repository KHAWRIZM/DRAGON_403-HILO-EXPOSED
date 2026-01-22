package cf;

import androidx.appcompat.app.a0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class p {
    private static final Map d = new ConcurrentHashMap();
    private static final a[] e = new a[4];
    private List a;
    private final boolean b;
    private final boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class a {
        final List a = new ArrayList();
        final Map b = new HashMap();
        final Map c = new HashMap();
        final StringBuilder d = new StringBuilder(128);
        Class e;
        Class f;
        boolean g;

        a() {
        }

        private boolean b(Method method, Class cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder sb2 = this.d;
            sb2.append('>');
            sb2.append(cls.getName());
            String sb3 = this.d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class cls2 = (Class) this.c.put(sb3, declaringClass);
            if (cls2 != null && !cls2.isAssignableFrom(declaringClass)) {
                this.c.put(sb3, cls2);
                return false;
            }
            return true;
        }

        boolean a(Method method, Class cls) {
            Object put = this.b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        void c(Class cls) {
            this.f = cls;
            this.e = cls;
            this.g = false;
        }

        void d() {
            if (this.g) {
                this.f = null;
                return;
            }
            Class superclass = this.f.getSuperclass();
            this.f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.f = null;
            }
        }

        void e() {
            this.a.clear();
            this.b.clear();
            this.c.clear();
            this.d.setLength(0);
            this.e = null;
            this.f = null;
            this.g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(List list, boolean z, boolean z2) {
        this.a = list;
        this.b = z;
        this.c = z2;
    }

    private List b(Class cls) {
        a g = g();
        g.c(cls);
        while (g.f != null) {
            f(g);
            d(g);
            g.d();
        }
        return e(g);
    }

    private List c(Class cls) {
        a g = g();
        g.c(cls);
        while (g.f != null) {
            d(g);
            g.d();
        }
        return e(g);
    }

    private void d(a aVar) {
        String str;
        Method[] methods;
        try {
            try {
                methods = aVar.f.getDeclaredMethods();
            } catch (Throwable unused) {
                methods = aVar.f.getMethods();
                aVar.g = true;
            }
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        m mVar = (m) method.getAnnotation(m.class);
                        if (mVar != null) {
                            Class<?> cls = parameterTypes[0];
                            if (aVar.a(method, cls)) {
                                aVar.a.add(new o(method, cls, mVar.threadMode(), mVar.priority(), mVar.sticky()));
                            }
                        }
                    } else if (this.b && method.isAnnotationPresent(m.class)) {
                        throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                    }
                } else if (this.b && method.isAnnotationPresent(m.class)) {
                    throw new e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
                }
            }
        } catch (LinkageError e2) {
            String str2 = "Could not inspect methods of " + aVar.f.getName();
            if (this.c) {
                str = str2 + ". Please consider using EventBus annotation processor to avoid reflection.";
            } else {
                str = str2 + ". Please make this class visible to EventBus annotation processor to avoid reflection.";
            }
            throw new e(str, e2);
        }
    }

    private List e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.a);
        aVar.e();
        synchronized (e) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                try {
                    a[] aVarArr = e;
                    if (aVarArr[i] == null) {
                        aVarArr[i] = aVar;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    private ef.a f(a aVar) {
        aVar.getClass();
        List list = this.a;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                a0.a(it.next());
                throw null;
            }
        }
        return null;
    }

    private a g() {
        synchronized (e) {
            for (int i = 0; i < 4; i++) {
                try {
                    a[] aVarArr = e;
                    a aVar = aVarArr[i];
                    if (aVar != null) {
                        aVarArr[i] = null;
                        return aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List a(Class cls) {
        List b;
        Map map = d;
        List list = (List) map.get(cls);
        if (list != null) {
            return list;
        }
        if (this.c) {
            b = c(cls);
        } else {
            b = b(cls);
        }
        if (!b.isEmpty()) {
            map.put(cls, b);
            return b;
        }
        throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }
}
