package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import g3.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f٤١٣٧d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f٤١٣٨e = new Object();

    /* renamed from: c, reason: collision with root package name */
    final Context f٤١٤١c;

    /* renamed from: b, reason: collision with root package name */
    final Set f٤١٤٠b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    final Map f٤١٣٩a = new HashMap();

    a(Context context) {
        this.f٤١٤١c = context.getApplicationContext();
    }

    private Object d(Class cls, Set set) {
        Object obj;
        if (h3.a.d()) {
            try {
                h3.a.a(cls.getSimpleName());
            } catch (Throwable th) {
                h3.a.b();
                throw th;
            }
        }
        if (!set.contains(cls)) {
            if (!this.f٤١٣٩a.containsKey(cls)) {
                set.add(cls);
                try {
                    g3.a aVar = (g3.a) cls.getDeclaredConstructor(null).newInstance(null);
                    List<Class> dependencies = aVar.dependencies();
                    if (!dependencies.isEmpty()) {
                        for (Class cls2 : dependencies) {
                            if (!this.f٤١٣٩a.containsKey(cls2)) {
                                d(cls2, set);
                            }
                        }
                    }
                    obj = aVar.create(this.f٤١٤١c);
                    set.remove(cls);
                    this.f٤١٣٩a.put(cls, obj);
                } catch (Throwable th2) {
                    throw new b(th2);
                }
            } else {
                obj = this.f٤١٣٩a.get(cls);
            }
            h3.a.b();
            return obj;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
    }

    public static a e(Context context) {
        if (f٤١٣٧d == null) {
            synchronized (f٤١٣٨e) {
                try {
                    if (f٤١٣٧d == null) {
                        f٤١٣٧d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f٤١٣٧d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        try {
            try {
                h3.a.a("Startup");
                b(this.f٤١٤١c.getPackageManager().getProviderInfo(new ComponentName(this.f٤١٤١c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e10) {
                throw new b(e10);
            }
        } finally {
            h3.a.b();
        }
    }

    void b(Bundle bundle) {
        String string = this.f٤١٤١c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (g3.a.class.isAssignableFrom(cls)) {
                            this.f٤١٤٠b.add(cls);
                        }
                    }
                }
                Iterator it = this.f٤١٤٠b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e10) {
                throw new b(e10);
            }
        }
    }

    Object c(Class cls) {
        Object obj;
        synchronized (f٤١٣٨e) {
            try {
                obj = this.f٤١٣٩a.get(cls);
                if (obj == null) {
                    obj = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.f٤١٤٠b.contains(cls);
    }
}
