package yc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import yc.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class s {
    public final c a;
    public final String b;
    public final f c;
    public final f d;
    public final List e;
    public final Set f;
    public final List g;
    public final r h;
    public final List i;
    public final Map j;
    public final List k;
    public final f l;
    public final f m;
    public final List n;
    public final List o;
    final Set p;
    public final List q;
    public final Set r;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class b {
        private final c a;
        private final String b;
        private final f c;
        private final f.b d;
        private r e;
        private final f.b f;
        private final f.b g;
        public final Map h;
        public final List i;
        public final List j;
        public final List k;
        public final List l;
        public final List m;
        public final List n;
        public final List o;
        public final List p;
        public final Set q;

        public b h(yc.a aVar) {
            u.c(aVar, "annotationSpec == null", new Object[0]);
            this.i.add(aVar);
            return this;
        }

        public b i(l lVar) {
            this.m.add(lVar);
            return this;
        }

        public b j(o oVar) {
            this.n.add(oVar);
            return this;
        }

        public b k(Iterable iterable) {
            boolean z;
            if (iterable != null) {
                z = true;
            } else {
                z = false;
            }
            u.b(z, "methodSpecs == null", new Object[0]);
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                j((o) it.next());
            }
            return this;
        }

        public b l(Modifier... modifierArr) {
            Collections.addAll(this.j, modifierArr);
            return this;
        }

        public b m(Element element) {
            this.p.add(element);
            return this;
        }

        public b n(r rVar) {
            boolean z;
            if (rVar != null) {
                z = true;
            } else {
                z = false;
            }
            u.b(z, "superinterface == null", new Object[0]);
            this.l.add(rVar);
            return this;
        }

        public s o() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12 = true;
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                u.c((yc.a) it.next(), "annotationSpec == null", new Object[0]);
            }
            if (!this.j.isEmpty()) {
                if (this.c == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                u.d(z10, "forbidden on anonymous types.", new Object[0]);
                Iterator it2 = this.j.iterator();
                while (it2.hasNext()) {
                    if (((Modifier) it2.next()) != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    u.b(z11, "modifiers contain null", new Object[0]);
                }
            }
            if (this.a == c.ENUM && this.h.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            u.b(z, "at least one enum constant is required for %s", this.b);
            Iterator it3 = this.l.iterator();
            while (it3.hasNext()) {
                if (((r) it3.next()) != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                u.b(z9, "superinterfaces contains null", new Object[0]);
            }
            if (!this.k.isEmpty()) {
                if (this.c == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                u.d(z7, "typevariables are forbidden on anonymous types.", new Object[0]);
                Iterator it4 = this.k.iterator();
                while (it4.hasNext()) {
                    if (((t) it4.next()) != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    u.b(z8, "typeVariables contain null", new Object[0]);
                }
            }
            for (Map.Entry entry : this.h.entrySet()) {
                if (this.a == c.ENUM) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                u.d(z5, "%s is not enum", this.b);
                if (((s) entry.getValue()).c != null) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                u.b(z6, "enum constants must have anonymous type arguments", new Object[0]);
                u.b(SourceVersion.isName(this.b), "not a valid enum constant: %s", this.b);
            }
            for (l lVar : this.m) {
                c cVar = this.a;
                if (cVar == c.INTERFACE || cVar == c.ANNOTATION) {
                    u.i(lVar.e, Modifier.PUBLIC, Modifier.PRIVATE);
                    EnumSet of2 = EnumSet.of(Modifier.STATIC, Modifier.FINAL);
                    u.d(lVar.e.containsAll(of2), "%s %s.%s requires modifiers %s", this.a, this.b, lVar.b, of2);
                }
            }
            for (o oVar : this.n) {
                c cVar2 = this.a;
                c cVar3 = c.INTERFACE;
                if (cVar2 == cVar3) {
                    u.i(oVar.d, Modifier.ABSTRACT, Modifier.STATIC, Modifier.DEFAULT);
                    u.i(oVar.d, Modifier.PUBLIC, Modifier.PRIVATE);
                } else if (cVar2 == c.ANNOTATION) {
                    boolean equals = oVar.d.equals(cVar2.b);
                    c cVar4 = this.a;
                    u.d(equals, "%s %s.%s requires modifiers %s", cVar4, this.b, oVar.a, cVar4.b);
                }
                c cVar5 = this.a;
                if (cVar5 != c.ANNOTATION) {
                    if (oVar.k == null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    u.d(z4, "%s %s.%s cannot have a default value", cVar5, this.b, oVar.a);
                }
                if (this.a != cVar3) {
                    u.d(!oVar.c(Modifier.DEFAULT), "%s %s.%s cannot be default", this.a, this.b, oVar.a);
                }
            }
            for (s sVar : this.o) {
                boolean containsAll = sVar.f.containsAll(this.a.c);
                c cVar6 = this.a;
                u.b(containsAll, "%s %s.%s requires modifiers %s", cVar6, this.b, sVar.b, cVar6.c);
            }
            if (!this.j.contains(Modifier.ABSTRACT) && this.a == c.CLASS) {
                z2 = false;
            } else {
                z2 = true;
            }
            for (o oVar2 : this.n) {
                if (!z2 && oVar2.c(Modifier.ABSTRACT)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                u.b(z3, "non-abstract type %s cannot declare abstract method %s", this.b, oVar2.a);
            }
            int size = (!this.e.equals(e.B) ? 1 : 0) + this.l.size();
            if (this.c != null && size > 1) {
                z12 = false;
            }
            u.b(z12, "anonymous type has too many supertypes", new Object[0]);
            return new s(this);
        }

        private b(c cVar, String str, f fVar) {
            this.d = f.a();
            this.e = e.B;
            this.f = f.a();
            this.g = f.a();
            this.h = new LinkedHashMap();
            this.i = new ArrayList();
            this.j = new ArrayList();
            this.k = new ArrayList();
            this.l = new ArrayList();
            this.m = new ArrayList();
            this.n = new ArrayList();
            this.o = new ArrayList();
            this.p = new ArrayList();
            this.q = new LinkedHashSet();
            u.b(str == null || SourceVersion.isName(str), "not a valid name: %s", str);
            this.a = cVar;
            this.b = str;
            this.c = fVar;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum c {
        CLASS(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.emptySet()),
        INTERFACE(u.h(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), u.h(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), u.h(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), u.h(Collections.singletonList(Modifier.STATIC))),
        ENUM(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.singleton(Modifier.STATIC)),
        ANNOTATION(u.h(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), u.h(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), u.h(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), u.h(Collections.singletonList(Modifier.STATIC)));

        private final Set a;
        private final Set b;
        private final Set c;
        private final Set d;

        c(Set set, Set set2, Set set3, Set set4) {
            this.a = set;
            this.b = set2;
            this.c = set3;
            this.d = set4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b a(String str) {
        return new b(c.CLASS, (String) u.c(str, "name == null", new Object[0]), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar, String str, Set set) {
        List<r> singletonList;
        List<r> list;
        r rVar;
        boolean z = true;
        int i = jVar.p;
        jVar.p = -1;
        try {
            if (str != null) {
                jVar.k(this.d);
                jVar.h(this.e, false);
                jVar.d("$L", str);
                if (!this.c.a.isEmpty()) {
                    jVar.c("(");
                    jVar.e(this.c);
                    jVar.c(")");
                }
                if (this.k.isEmpty() && this.n.isEmpty() && this.o.isEmpty()) {
                    jVar.p = i;
                    return;
                }
                jVar.c(" {\n");
            } else if (this.c != null) {
                if (!this.i.isEmpty()) {
                    rVar = (r) this.i.get(0);
                } else {
                    rVar = this.h;
                }
                jVar.d("new $T(", rVar);
                jVar.e(this.c);
                jVar.c(") {\n");
            } else {
                jVar.D(new s(this));
                jVar.k(this.d);
                jVar.h(this.e, false);
                jVar.n(this.f, u.k(set, this.a.d));
                c cVar = this.a;
                if (cVar == c.ANNOTATION) {
                    jVar.d("$L $L", "@interface", this.b);
                } else {
                    jVar.d("$L $L", cVar.name().toLowerCase(Locale.US), this.b);
                }
                jVar.p(this.g);
                if (this.a == c.INTERFACE) {
                    singletonList = this.i;
                    list = Collections.emptyList();
                } else {
                    if (this.h.equals(e.B)) {
                        singletonList = Collections.emptyList();
                    } else {
                        singletonList = Collections.singletonList(this.h);
                    }
                    list = this.i;
                }
                if (!singletonList.isEmpty()) {
                    jVar.c(" extends");
                    boolean z2 = true;
                    for (r rVar2 : singletonList) {
                        if (!z2) {
                            jVar.c(",");
                        }
                        jVar.d(" $T", rVar2);
                        z2 = false;
                    }
                }
                if (!list.isEmpty()) {
                    jVar.c(" implements");
                    boolean z3 = true;
                    for (r rVar3 : list) {
                        if (!z3) {
                            jVar.c(",");
                        }
                        jVar.d(" $T", rVar3);
                        z3 = false;
                    }
                }
                jVar.A();
                jVar.c(" {\n");
            }
            jVar.D(this);
            jVar.u();
            Iterator it = this.j.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!z) {
                    jVar.c("\n");
                }
                ((s) entry.getValue()).b(jVar, (String) entry.getKey(), Collections.emptySet());
                if (it.hasNext()) {
                    jVar.c(",\n");
                } else {
                    if (this.k.isEmpty() && this.n.isEmpty() && this.o.isEmpty()) {
                        jVar.c("\n");
                    }
                    jVar.c(";\n");
                }
                z = false;
            }
            for (l lVar : this.k) {
                if (lVar.c(Modifier.STATIC)) {
                    if (!z) {
                        jVar.c("\n");
                    }
                    lVar.b(jVar, this.a.a);
                    z = false;
                }
            }
            if (!this.l.b()) {
                if (!z) {
                    jVar.c("\n");
                }
                jVar.e(this.l);
                z = false;
            }
            for (l lVar2 : this.k) {
                if (!lVar2.c(Modifier.STATIC)) {
                    if (!z) {
                        jVar.c("\n");
                    }
                    lVar2.b(jVar, this.a.a);
                    z = false;
                }
            }
            if (!this.m.b()) {
                if (!z) {
                    jVar.c("\n");
                }
                jVar.e(this.m);
                z = false;
            }
            for (o oVar : this.n) {
                if (oVar.d()) {
                    if (!z) {
                        jVar.c("\n");
                    }
                    oVar.b(jVar, this.b, this.a.b);
                    z = false;
                }
            }
            for (o oVar2 : this.n) {
                if (!oVar2.d()) {
                    if (!z) {
                        jVar.c("\n");
                    }
                    oVar2.b(jVar, this.b, this.a.b);
                    z = false;
                }
            }
            for (s sVar : this.o) {
                if (!z) {
                    jVar.c("\n");
                }
                sVar.b(jVar, null, this.a.c);
                z = false;
            }
            jVar.H();
            jVar.A();
            jVar.B(this.g);
            jVar.c("}");
            if (str == null && this.c == null) {
                jVar.c("\n");
            }
            jVar.p = i;
        } catch (Throwable th) {
            jVar.p = i;
            throw th;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
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
            b(new j(sb2), null, Collections.emptySet());
            return sb2.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private s(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d.i();
        this.e = u.e(bVar.i);
        this.f = u.h(bVar.j);
        this.g = u.e(bVar.k);
        this.h = bVar.e;
        this.i = u.e(bVar.l);
        this.j = u.f(bVar.h);
        this.k = u.e(bVar.m);
        this.l = bVar.f.i();
        this.m = bVar.g.i();
        this.n = u.e(bVar.n);
        this.o = u.e(bVar.o);
        this.r = u.h(bVar.q);
        this.p = new HashSet(bVar.o.size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(bVar.p);
        for (s sVar : bVar.o) {
            this.p.add(sVar.b);
            arrayList.addAll(sVar.q);
        }
        this.q = u.e(arrayList);
    }

    private s(s sVar) {
        this.a = sVar.a;
        this.b = sVar.b;
        this.c = null;
        this.d = sVar.d;
        this.e = Collections.emptyList();
        this.f = Collections.emptySet();
        this.g = Collections.emptyList();
        this.h = null;
        this.i = Collections.emptyList();
        this.j = Collections.emptyMap();
        this.k = Collections.emptyList();
        this.l = sVar.l;
        this.m = sVar.m;
        this.n = Collections.emptyList();
        this.o = Collections.emptyList();
        this.q = Collections.emptyList();
        this.p = Collections.emptySet();
        this.r = Collections.emptySet();
    }
}
