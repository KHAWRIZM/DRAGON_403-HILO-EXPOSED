package tf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class f {
    private final a a = new a();
    private final Map b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class a {
        final Object a;
        private List b;
        a c;
        a d;

        a() {
            this(null);
        }

        public void a(Object obj) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(obj);
        }

        public Object b() {
            int c = c();
            if (c > 0) {
                return this.b.remove(c - 1);
            }
            return null;
        }

        public int c() {
            List list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(Object obj) {
            this.d = this;
            this.c = this;
            this.a = obj;
        }
    }

    private void b(a aVar) {
        e(aVar);
        a aVar2 = this.a;
        aVar.d = aVar2;
        aVar.c = aVar2.c;
        g(aVar);
    }

    private void c(a aVar) {
        e(aVar);
        a aVar2 = this.a;
        aVar.d = aVar2.d;
        aVar.c = aVar2;
        g(aVar);
    }

    private static void e(a aVar) {
        a aVar2 = aVar.d;
        aVar2.c = aVar.c;
        aVar.c.d = aVar2;
    }

    private static void g(a aVar) {
        aVar.c.d = aVar;
        aVar.d.c = aVar;
    }

    public Object a(i iVar) {
        a aVar = (a) this.b.get(iVar);
        if (aVar == null) {
            aVar = new a(iVar);
            this.b.put(iVar, aVar);
        } else {
            iVar.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(i iVar, Object obj) {
        a aVar = (a) this.b.get(iVar);
        if (aVar == null) {
            aVar = new a(iVar);
            c(aVar);
            this.b.put(iVar, aVar);
        } else {
            iVar.a();
        }
        aVar.a(obj);
    }

    public Object f() {
        for (a aVar = this.a.d; !aVar.equals(this.a); aVar = aVar.d) {
            Object b = aVar.b();
            if (b != null) {
                return b;
            }
            e(aVar);
            this.b.remove(aVar.a);
            ((i) aVar.a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.a.c;
        boolean z = false;
        while (!aVar.equals(this.a)) {
            sb2.append('{');
            sb2.append(aVar.a);
            sb2.append(':');
            sb2.append(aVar.c());
            sb2.append("}, ");
            aVar = aVar.c;
            z = true;
        }
        if (z) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        sb2.append(" )");
        return sb2.toString();
    }
}
