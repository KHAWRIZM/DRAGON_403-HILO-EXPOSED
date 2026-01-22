package yc;

import com.tencent.liteav.TXLiteAVCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class j {
    private static final String q = new String();
    private final String a;
    private final n b;
    private int c;
    private boolean d;
    private boolean e;
    private String f;
    private final List g;
    private final Set h;
    private final Set i;
    private final Set j;
    private final Map k;
    private final Map l;
    private final Set m;
    private final b n;
    private boolean o;
    int p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class b {
        private final Map a;

        private b() {
            this.a = new LinkedHashMap();
        }

        void a(Object obj) {
            Object orDefault;
            orDefault = this.a.getOrDefault(obj, 0);
            this.a.put(obj, Integer.valueOf(((Integer) orDefault).intValue() + 1));
        }

        boolean b(Object obj) {
            Object orDefault;
            orDefault = this.a.getOrDefault(obj, 0);
            if (((Integer) orDefault).intValue() <= 0) {
                return false;
            }
            return true;
        }

        void c(Object obj) {
            Object orDefault;
            orDefault = this.a.getOrDefault(obj, 0);
            int intValue = ((Integer) orDefault).intValue();
            if (intValue != 0) {
                this.a.put(obj, Integer.valueOf(intValue - 1));
                return;
            }
            throw new IllegalStateException(obj + " is not in the multiset");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Appendable appendable) {
        this(appendable, "  ", Collections.emptySet(), Collections.emptySet());
    }

    private e E(String str) {
        for (int size = this.g.size() - 1; size >= 0; size--) {
            if (((s) this.g.get(size)).p.contains(str)) {
                return F(size, str);
            }
        }
        if (this.g.size() > 0 && Objects.equals(((s) this.g.get(0)).b, str)) {
            return e.r(this.f, str, new String[0]);
        }
        e eVar = (e) this.k.get(str);
        if (eVar != null) {
            return eVar;
        }
        return null;
    }

    private e F(int i, String str) {
        e r = e.r(this.f, ((s) this.g.get(0)).b, new String[0]);
        for (int i2 = 1; i2 <= i; i2++) {
            r = r.t(((s) this.g.get(i2)).b);
        }
        return r.t(str);
    }

    private void j() {
        for (int i = 0; i < this.c; i++) {
            this.b.a(this.a);
        }
    }

    private void l(Object obj) {
        if (obj instanceof s) {
            ((s) obj).b(this, null, Collections.emptySet());
            return;
        }
        if (obj instanceof yc.a) {
            ((yc.a) obj).b(this, true);
        } else if (obj instanceof f) {
            e((f) obj);
        } else {
            g(String.valueOf(obj));
        }
    }

    private boolean o(String str, String str2) {
        String substring = str2.substring(1);
        if (substring.isEmpty() || !Character.isJavaIdentifierStart(substring.charAt(0))) {
            return false;
        }
        String str3 = str + "." + r(substring);
        String str4 = str + ".*";
        if (!this.i.contains(str3) && !this.i.contains(str4)) {
            return false;
        }
        g(substring);
        return true;
    }

    private static String r(String str) {
        u.b(Character.isJavaIdentifierStart(str.charAt(0)), "not an identifier: %s", str);
        for (int i = 1; i <= str.length(); i++) {
            if (!SourceVersion.isIdentifier(str.substring(0, i))) {
                return str.substring(0, i - 1);
            }
        }
        return str;
    }

    private void s(e eVar) {
        if (eVar.u().isEmpty() || this.j.contains(eVar.y)) {
            return;
        }
        e x = eVar.x();
        String v = x.v();
        e eVar2 = (e) this.l.put(v, x);
        if (eVar2 != null) {
            this.l.put(v, eVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(t tVar) {
        this.n.a(tVar.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(t tVar) {
        this.n.c(tVar.w);
    }

    public j A() {
        this.g.remove(r0.size() - 1);
        return this;
    }

    public void B(List list) {
        list.forEach(new Consumer() { // from class: yc.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                j.this.x((t) obj);
            }
        });
    }

    public j C(String str) {
        boolean z;
        String str2 = this.f;
        if (str2 == q) {
            z = true;
        } else {
            z = false;
        }
        u.d(z, "package already set: %s", str2);
        this.f = (String) u.c(str, "packageName == null", new Object[0]);
        return this;
    }

    public j D(s sVar) {
        this.g.add(sVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map G() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.l);
        linkedHashMap.keySet().removeAll(this.m);
        return linkedHashMap;
    }

    public j H() {
        return I(1);
    }

    public j I(int i) {
        boolean z;
        if (this.c - i >= 0) {
            z = true;
        } else {
            z = false;
        }
        u.b(z, "cannot unindent %s from %s", Integer.valueOf(i), Integer.valueOf(this.c));
        this.c -= i;
        return this;
    }

    public j c(String str) {
        return g(str);
    }

    public j d(String str, Object... objArr) {
        return e(f.c(str, objArr));
    }

    public j e(f fVar) {
        return f(fVar, false);
    }

    public j f(f fVar, boolean z) {
        char c;
        int i;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        ListIterator listIterator = fVar.a.listIterator();
        e eVar = null;
        int i2 = 0;
        while (listIterator.hasNext()) {
            String str2 = (String) listIterator.next();
            str2.hashCode();
            switch (str2.hashCode()) {
                case 1152:
                    if (str2.equals("$$")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1176:
                    if (str2.equals("$<")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1178:
                    if (str2.equals("$>")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1192:
                    if (str2.equals("$L")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1194:
                    if (str2.equals("$N")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1199:
                    if (str2.equals("$S")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1200:
                    if (str2.equals("$T")) {
                        c = 6;
                        break;
                    }
                    break;
                case TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED /* 1203 */:
                    if (str2.equals("$W")) {
                        c = 7;
                        break;
                    }
                    break;
                case TXLiteAVCode.WARNING_SCREEN_CAPTURE_NOT_AUTHORIZED /* 1206 */:
                    if (str2.equals("$Z")) {
                        c = '\b';
                        break;
                    }
                    break;
                case TXLiteAVCode.WARNING_BLUETOOTH_DEVICE_CONNECT_FAIL /* 1207 */:
                    if (str2.equals("$[")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1209:
                    if (str2.equals("$]")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    g("$");
                    continue;
                case 1:
                    H();
                    continue;
                case 2:
                    u();
                    continue;
                case 3:
                    i = i2 + 1;
                    l(fVar.b.get(i2));
                    break;
                case 4:
                    i = i2 + 1;
                    g((String) fVar.b.get(i2));
                    break;
                case 5:
                    i = i2 + 1;
                    String str3 = (String) fVar.b.get(i2);
                    if (str3 != null) {
                        str = u.j(str3, this.a);
                    } else {
                        str = "null";
                    }
                    g(str);
                    break;
                case 6:
                    int i3 = i2 + 1;
                    r rVar = (r) fVar.b.get(i2);
                    if ((rVar instanceof e) && listIterator.hasNext() && !((String) fVar.a.get(listIterator.nextIndex())).startsWith("$")) {
                        e eVar2 = (e) rVar;
                        if (this.h.contains(eVar2.A)) {
                            if (eVar == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            u.d(z2, "pending type for static import?!", new Object[0]);
                            eVar = eVar2;
                            i2 = i3;
                            continue;
                        }
                    }
                    rVar.d(this);
                    i2 = i3;
                    continue;
                case 7:
                    this.b.d(this.c + 2);
                    continue;
                case '\b':
                    this.b.e(this.c + 2);
                    continue;
                case '\t':
                    if (this.p == -1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    u.d(z3, "statement enter $[ followed by statement enter $[", new Object[0]);
                    this.p = 0;
                    continue;
                case '\n':
                    if (this.p != -1) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    u.d(z4, "statement exit $] has no matching statement enter $[", new Object[0]);
                    if (this.p > 0) {
                        I(2);
                    }
                    this.p = -1;
                    continue;
                default:
                    if (eVar != null) {
                        if (str2.startsWith(".") && o(eVar.A, str2)) {
                            eVar = null;
                            break;
                        } else {
                            eVar.d(this);
                            eVar = null;
                        }
                    }
                    g(str2);
                    continue;
            }
            i2 = i;
        }
        if (z && this.b.c() != '\n') {
            c("\n");
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j g(String str) {
        String str2;
        String[] split = str.split("\\R", -1);
        int length = split.length;
        int i = 0;
        boolean z = true;
        while (i < length) {
            String str3 = split[i];
            if (!z) {
                if ((this.d || this.e) && this.o) {
                    j();
                    n nVar = this.b;
                    if (this.d) {
                        str2 = " *";
                    } else {
                        str2 = "//";
                    }
                    nVar.a(str2);
                }
                this.b.a("\n");
                this.o = true;
                int i2 = this.p;
                if (i2 != -1) {
                    if (i2 == 0) {
                        v(2);
                    }
                    this.p++;
                }
            }
            if (!str3.isEmpty()) {
                if (this.o) {
                    j();
                    if (this.d) {
                        this.b.a(" * ");
                    } else if (this.e) {
                        this.b.a("// ");
                    }
                }
                this.b.a(str3);
                this.o = false;
            }
            i++;
            z = false;
        }
        return this;
    }

    public void h(List list, boolean z) {
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((yc.a) it.next()).b(this, z);
            if (z) {
                str = " ";
            } else {
                str = "\n";
            }
            c(str);
        }
    }

    public void i(f fVar) {
        this.o = true;
        this.e = true;
        try {
            e(fVar);
            c("\n");
        } finally {
            this.e = false;
        }
    }

    public void k(f fVar) {
        if (fVar.b()) {
            return;
        }
        c("/**\n");
        this.d = true;
        try {
            f(fVar, true);
            this.d = false;
            c(" */\n");
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }

    public void m(Set set) {
        n(set, Collections.emptySet());
    }

    public void n(Set set, Set set2) {
        if (set.isEmpty()) {
            return;
        }
        Iterator it = EnumSet.copyOf((Collection) set).iterator();
        while (it.hasNext()) {
            Modifier modifier = (Modifier) it.next();
            if (!set2.contains(modifier)) {
                g(modifier.name().toLowerCase(Locale.US));
                g(" ");
            }
        }
    }

    public void p(List list) {
        String str;
        if (!list.isEmpty()) {
            list.forEach(new Consumer() { // from class: yc.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    j.this.w((t) obj);
                }
            });
            c("<");
            Iterator it = list.iterator();
            boolean z = true;
            while (it.hasNext()) {
                t tVar = (t) it.next();
                if (!z) {
                    c(", ");
                }
                h(tVar.b, true);
                d("$L", tVar.w);
                boolean z2 = true;
                for (r rVar : tVar.x) {
                    if (z2) {
                        str = " extends $T";
                    } else {
                        str = " & $T";
                    }
                    d(str, rVar);
                    z2 = false;
                }
                z = false;
            }
            c(">");
        }
    }

    public j q() {
        this.b.d(this.c + 2);
        return this;
    }

    public Map t() {
        return this.k;
    }

    public j u() {
        return v(1);
    }

    public j v(int i) {
        this.c += i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String y(e eVar) {
        boolean z;
        String v = eVar.x().v();
        if (this.n.b(v)) {
            return eVar.A;
        }
        e eVar2 = eVar;
        boolean z2 = false;
        while (eVar2 != null) {
            e E = E(eVar2.v());
            if (E != null) {
                z = true;
            } else {
                z = false;
            }
            if (E != null && Objects.equals(E.A, eVar2.A)) {
                return com.google.android.gms.measurement.internal.a.a(".", eVar.w().subList(eVar2.w().size() - 1, eVar.w().size()));
            }
            eVar2 = eVar2.o();
            z2 = z;
        }
        if (z2) {
            return eVar.A;
        }
        if (Objects.equals(this.f, eVar.u())) {
            this.m.add(v);
            return com.google.android.gms.measurement.internal.a.a(".", eVar.w());
        }
        if (!this.d) {
            s(eVar);
        }
        return eVar.A;
    }

    public j z() {
        boolean z;
        String str = this.f;
        String str2 = q;
        if (str != str2) {
            z = true;
        } else {
            z = false;
        }
        u.d(z, "package not set", new Object[0]);
        this.f = str2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Appendable appendable, String str, Set set, Set set2) {
        this(appendable, str, Collections.emptyMap(), set, set2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Appendable appendable, String str, Map map, Set set, Set set2) {
        this.d = false;
        this.e = false;
        this.f = q;
        this.g = new ArrayList();
        this.l = new LinkedHashMap();
        this.m = new LinkedHashSet();
        this.n = new b();
        this.p = -1;
        this.b = new n(appendable, str, 100);
        this.a = (String) u.c(str, "indent == null", new Object[0]);
        this.k = (Map) u.c(map, "importedTypes == null", new Object[0]);
        this.i = (Set) u.c(set, "staticImports == null", new Object[0]);
        this.j = (Set) u.c(set2, "alwaysQualify == null", new Object[0]);
        this.h = new LinkedHashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            this.h.add(str2.substring(0, str2.lastIndexOf(46)));
        }
    }
}
