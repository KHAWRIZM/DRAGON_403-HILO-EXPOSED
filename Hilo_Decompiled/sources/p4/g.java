package p4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private final a f١٦٨٥٦a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final Map f١٦٨٥٧b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Object f١٦٨٥٨a;

        /* renamed from: b, reason: collision with root package name */
        private List f١٦٨٥٩b;

        /* renamed from: c, reason: collision with root package name */
        a f١٦٨٦٠c;

        /* renamed from: d, reason: collision with root package name */
        a f١٦٨٦١d;

        a() {
            this(null);
        }

        public void a(Object obj) {
            if (this.f١٦٨٥٩b == null) {
                this.f١٦٨٥٩b = new ArrayList();
            }
            this.f١٦٨٥٩b.add(obj);
        }

        public Object b() {
            int c10 = c();
            if (c10 > 0) {
                return this.f١٦٨٥٩b.remove(c10 - 1);
            }
            return null;
        }

        public int c() {
            List list = this.f١٦٨٥٩b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(Object obj) {
            this.f١٦٨٦١d = this;
            this.f١٦٨٦٠c = this;
            this.f١٦٨٥٨a = obj;
        }
    }

    private void b(a aVar) {
        e(aVar);
        a aVar2 = this.f١٦٨٥٦a;
        aVar.f١٦٨٦١d = aVar2;
        aVar.f١٦٨٦٠c = aVar2.f١٦٨٦٠c;
        g(aVar);
    }

    private void c(a aVar) {
        e(aVar);
        a aVar2 = this.f١٦٨٥٦a;
        aVar.f١٦٨٦١d = aVar2.f١٦٨٦١d;
        aVar.f١٦٨٦٠c = aVar2;
        g(aVar);
    }

    private static void e(a aVar) {
        a aVar2 = aVar.f١٦٨٦١d;
        aVar2.f١٦٨٦٠c = aVar.f١٦٨٦٠c;
        aVar.f١٦٨٦٠c.f١٦٨٦١d = aVar2;
    }

    private static void g(a aVar) {
        aVar.f١٦٨٦٠c.f١٦٨٦١d = aVar;
        aVar.f١٦٨٦١d.f١٦٨٦٠c = aVar;
    }

    public Object a(l lVar) {
        a aVar = (a) this.f١٦٨٥٧b.get(lVar);
        if (aVar == null) {
            aVar = new a(lVar);
            this.f١٦٨٥٧b.put(lVar, aVar);
        } else {
            lVar.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(l lVar, Object obj) {
        a aVar = (a) this.f١٦٨٥٧b.get(lVar);
        if (aVar == null) {
            aVar = new a(lVar);
            c(aVar);
            this.f١٦٨٥٧b.put(lVar, aVar);
        } else {
            lVar.a();
        }
        aVar.a(obj);
    }

    public Object f() {
        for (a aVar = this.f١٦٨٥٦a.f١٦٨٦١d; !aVar.equals(this.f١٦٨٥٦a); aVar = aVar.f١٦٨٦١d) {
            Object b10 = aVar.b();
            if (b10 != null) {
                return b10;
            }
            e(aVar);
            this.f١٦٨٥٧b.remove(aVar.f١٦٨٥٨a);
            ((l) aVar.f١٦٨٥٨a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f١٦٨٥٦a.f١٦٨٦٠c;
        boolean z10 = false;
        while (!aVar.equals(this.f١٦٨٥٦a)) {
            sb.append('{');
            sb.append(aVar.f١٦٨٥٨a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
            aVar = aVar.f١٦٨٦٠c;
            z10 = true;
        }
        if (z10) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
