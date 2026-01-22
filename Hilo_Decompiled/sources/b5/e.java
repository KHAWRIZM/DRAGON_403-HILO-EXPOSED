package b5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m4.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final List f٥٤١٨a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Map f٥٤١٩b = new HashMap();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Class f٥٤٢٠a;

        /* renamed from: b, reason: collision with root package name */
        final Class f٥٤٢١b;

        /* renamed from: c, reason: collision with root package name */
        final k f٥٤٢٢c;

        public a(Class cls, Class cls2, k kVar) {
            this.f٥٤٢٠a = cls;
            this.f٥٤٢١b = cls2;
            this.f٥٤٢٢c = kVar;
        }

        public boolean a(Class cls, Class cls2) {
            if (this.f٥٤٢٠a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f٥٤٢١b)) {
                return true;
            }
            return false;
        }
    }

    private synchronized List c(String str) {
        List list;
        try {
            if (!this.f٥٤١٨a.contains(str)) {
                this.f٥٤١٨a.add(str);
            }
            list = (List) this.f٥٤١٩b.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f٥٤١٩b.put(str, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return list;
    }

    public synchronized void a(String str, k kVar, Class cls, Class cls2) {
        c(str).add(new a(cls, cls2, kVar));
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f٥٤١٨a.iterator();
        while (it.hasNext()) {
            List<a> list = (List) this.f٥٤١٩b.get((String) it.next());
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f٥٤٢٢c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized List d(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f٥٤١٨a.iterator();
        while (it.hasNext()) {
            List<a> list = (List) this.f٥٤١٩b.get((String) it.next());
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f٥٤٢١b)) {
                        arrayList.add(aVar.f٥٤٢١b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(String str, k kVar, Class cls, Class cls2) {
        c(str).add(0, new a(cls, cls2, kVar));
    }

    public synchronized void f(List list) {
        try {
            ArrayList<String> arrayList = new ArrayList(this.f٥٤١٨a);
            this.f٥٤١٨a.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f٥٤١٨a.add((String) it.next());
            }
            for (String str : arrayList) {
                if (!list.contains(str)) {
                    this.f٥٤١٨a.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
