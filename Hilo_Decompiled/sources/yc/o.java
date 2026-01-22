package yc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;
import yc.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class o {
    public final String a;
    public final f b;
    public final List c;
    public final Set d;
    public final List e;
    public final r f;
    public final List g;
    public final boolean h;
    public final List i;
    public final f j;
    public final f k;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class b {
        private String a;
        private final f.b b;
        private r c;
        private final Set d;
        private final f.b e;
        private boolean f;
        private f g;
        public final List h;
        public final List i;
        public final List j;
        public final List k;

        public b h(Class cls) {
            return i(e.q(cls));
        }

        public b i(e eVar) {
            this.i.add(yc.a.a(eVar).e());
            return this;
        }

        public b j(Modifier... modifierArr) {
            u.c(modifierArr, "modifiers == null", new Object[0]);
            Collections.addAll(this.j, modifierArr);
            return this;
        }

        public b k(p pVar) {
            this.k.add(pVar);
            return this;
        }

        public b l(String str, Object... objArr) {
            this.e.c(str, objArr);
            return this;
        }

        public b m(String str, Object... objArr) {
            this.e.h(str, objArr);
            return this;
        }

        public o n() {
            return new o(this);
        }

        public b o() {
            this.e.j();
            return this;
        }

        public b p(r rVar) {
            u.d(!this.a.equals("<init>"), "constructor cannot have return type.", new Object[0]);
            this.c = rVar;
            return this;
        }

        public b q(String str) {
            boolean z;
            r rVar;
            u.c(str, "name == null", new Object[0]);
            if (!str.equals("<init>") && !SourceVersion.isName(str)) {
                z = false;
            } else {
                z = true;
            }
            u.b(z, "not a valid name: %s", str);
            this.a = str;
            if (str.equals("<init>")) {
                rVar = null;
            } else {
                rVar = r.d;
            }
            this.c = rVar;
            return this;
        }

        private b(String str) {
            this.b = f.a();
            this.d = new LinkedHashSet();
            this.e = f.a();
            this.h = new ArrayList();
            this.i = new ArrayList();
            this.j = new ArrayList();
            this.k = new ArrayList();
            q(str);
        }
    }

    public static b a() {
        return new b("<init>");
    }

    private f e() {
        f.b d = this.b.d();
        boolean z = true;
        for (p pVar : this.g) {
            if (!pVar.e.b()) {
                if (z && !this.b.b()) {
                    d.a("\n", new Object[0]);
                }
                d.a("@param $L $L", pVar.a, pVar.e);
                z = false;
            }
        }
        return d.i();
    }

    private boolean f(List list) {
        if (!list.isEmpty() && r.a(((p) list.get(list.size() - 1)).d) != null) {
            return true;
        }
        return false;
    }

    public static b g(String str) {
        return new b(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar, String str, Set set) {
        boolean z;
        jVar.k(e());
        jVar.h(this.c, false);
        jVar.n(this.d, set);
        if (!this.e.isEmpty()) {
            jVar.p(this.e);
            jVar.c(" ");
        }
        if (d()) {
            jVar.d("$L($Z", str);
        } else {
            jVar.d("$T $L($Z", this.f, this.a);
        }
        Iterator it = this.g.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (!z2) {
                jVar.c(",").q();
            }
            if (!it.hasNext() && this.h) {
                z = true;
            } else {
                z = false;
            }
            pVar.b(jVar, z);
            z2 = false;
        }
        jVar.c(")");
        f fVar = this.k;
        if (fVar != null && !fVar.b()) {
            jVar.c(" default ");
            jVar.e(this.k);
        }
        if (!this.i.isEmpty()) {
            jVar.q().c("throws");
            boolean z3 = true;
            for (r rVar : this.i) {
                if (!z3) {
                    jVar.c(",");
                }
                jVar.q().d("$T", rVar);
                z3 = false;
            }
        }
        if (c(Modifier.ABSTRACT)) {
            jVar.c(";\n");
        } else if (c(Modifier.NATIVE)) {
            jVar.e(this.j);
            jVar.c(";\n");
        } else {
            jVar.c(" {\n");
            jVar.u();
            jVar.f(this.j, true);
            jVar.H();
            jVar.c("}\n");
        }
        jVar.B(this.e);
    }

    public boolean c(Modifier modifier) {
        return this.d.contains(modifier);
    }

    public boolean d() {
        return this.a.equals("<init>");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
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
            b(new j(sb2), "Constructor", Collections.emptySet());
            return sb2.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private o(b bVar) {
        f i = bVar.e.i();
        u.b(i.b() || !bVar.j.contains(Modifier.ABSTRACT), "abstract method %s cannot have code", bVar.a);
        u.b(!bVar.f || f(bVar.k), "last parameter of varargs method %s must be an array", bVar.a);
        this.a = (String) u.c(bVar.a, "name == null", new Object[0]);
        this.b = bVar.b.i();
        this.c = u.e(bVar.i);
        this.d = u.h(bVar.j);
        this.e = u.e(bVar.h);
        this.f = bVar.c;
        this.g = u.e(bVar.k);
        this.h = bVar.f;
        this.i = u.e(bVar.d);
        this.k = bVar.g;
        this.j = i;
    }
}
