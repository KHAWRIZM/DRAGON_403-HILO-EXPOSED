package yc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;
import yc.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class l {
    public final r a;
    public final String b;
    public final f c;
    public final List d;
    public final Set e;
    public final f f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class b {
        private final r a;
        private final String b;
        private final f.b c;
        private f d;
        public final List e;
        public final List f;

        public b e(Modifier... modifierArr) {
            Collections.addAll(this.f, modifierArr);
            return this;
        }

        public l f() {
            return new l(this);
        }

        private b(r rVar, String str) {
            this.c = f.a();
            this.d = null;
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.a = rVar;
            this.b = str;
        }
    }

    public static b a(r rVar, String str, Modifier... modifierArr) {
        u.c(rVar, "type == null", new Object[0]);
        u.b(SourceVersion.isName(str), "not a valid name: %s", str);
        return new b(rVar, str).e(modifierArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar, Set set) {
        jVar.k(this.c);
        jVar.h(this.d, false);
        jVar.n(this.e, set);
        jVar.d("$T $L", this.a, this.b);
        if (!this.f.b()) {
            jVar.c(" = ");
            jVar.e(this.f);
        }
        jVar.c(";\n");
    }

    public boolean c(Modifier modifier) {
        return this.e.contains(modifier);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
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
            b(new j(sb2), Collections.emptySet());
            return sb2.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private l(b bVar) {
        f fVar;
        this.a = (r) u.c(bVar.a, "type == null", new Object[0]);
        this.b = (String) u.c(bVar.b, "name == null", new Object[0]);
        this.c = bVar.c.i();
        this.d = u.e(bVar.e);
        this.e = u.h(bVar.f);
        if (bVar.d != null) {
            fVar = bVar.d;
        } else {
            fVar = f.a().i();
        }
        this.f = fVar;
    }
}
