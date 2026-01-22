package yc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.lang.model.SourceVersion;
import yc.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class a {
    public final r a;
    public final Map b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class b {
        private final r a;
        public final Map b;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List f(String str) {
            return new ArrayList();
        }

        public b c(String str, String str2, Object... objArr) {
            return d(str, f.c(str2, objArr));
        }

        public b d(String str, f fVar) {
            Object computeIfAbsent;
            computeIfAbsent = this.b.computeIfAbsent(str, new Function() { // from class: yc.c
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    List f;
                    f = a.b.f((String) obj);
                    return f;
                }
            });
            ((List) computeIfAbsent).add(fVar);
            return this;
        }

        public a e() {
            for (String str : this.b.keySet()) {
                u.c(str, "name == null", new Object[0]);
                u.b(SourceVersion.isName(str), "not a valid name: %s", str);
            }
            return new a(this);
        }

        private b(r rVar) {
            this.b = new LinkedHashMap();
            this.a = rVar;
        }
    }

    public static b a(e eVar) {
        u.c(eVar, "type == null", new Object[0]);
        return new b(eVar);
    }

    private void c(j jVar, String str, String str2, List list) {
        boolean z = true;
        if (list.size() == 1) {
            jVar.v(2);
            jVar.e((f) list.get(0));
            jVar.I(2);
            return;
        }
        jVar.c("{" + str);
        jVar.v(2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z) {
                jVar.c(str2);
            }
            jVar.e(fVar);
            z = false;
        }
        jVar.I(2);
        jVar.c(str + "}");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar, boolean z) {
        String str;
        String str2;
        if (z) {
            str = "";
        } else {
            str = "\n";
        }
        if (z) {
            str2 = ", ";
        } else {
            str2 = ",\n";
        }
        if (this.b.isEmpty()) {
            jVar.d("@$T", this.a);
            return;
        }
        if (this.b.size() == 1 && this.b.containsKey("value")) {
            jVar.d("@$T(", this.a);
            c(jVar, str, str2, (List) this.b.get("value"));
            jVar.c(")");
            return;
        }
        jVar.d("@$T(" + str, this.a);
        jVar.v(2);
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            jVar.d("$L = ", entry.getKey());
            c(jVar, str, str2, (List) entry.getValue());
            if (it.hasNext()) {
                jVar.c(str2);
            }
        }
        jVar.I(2);
        jVar.c(str + ")");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            new j(sb2).d("$L", this);
            return sb2.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private a(b bVar) {
        this.a = bVar.a;
        this.b = u.g(bVar.b);
    }
}
