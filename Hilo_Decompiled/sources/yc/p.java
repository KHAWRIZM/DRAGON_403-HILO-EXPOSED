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
public final class p {
    public final String a;
    public final List b;
    public final Set c;
    public final r d;
    public final f e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class b {
        private final r a;
        private final String b;
        private final f.b c;
        public final List d;
        public final List e;

        public b d(Modifier... modifierArr) {
            Collections.addAll(this.e, modifierArr);
            return this;
        }

        public p e() {
            return new p(this);
        }

        private b(r rVar, String str) {
            this.c = f.a();
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.a = rVar;
            this.b = str;
        }
    }

    public static b a(r rVar, String str, Modifier... modifierArr) {
        u.c(rVar, "type == null", new Object[0]);
        u.b(c(str), "not a valid name: %s", str);
        return new b(rVar, str).d(modifierArr);
    }

    private static boolean c(String str) {
        if (str.endsWith(".this")) {
            return SourceVersion.isIdentifier(str.substring(0, str.length() - 5));
        }
        if (!str.equals("this") && !SourceVersion.isName(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar, boolean z) {
        jVar.h(this.b, true);
        jVar.m(this.c);
        if (z) {
            r.a(this.d).m(jVar, true);
        } else {
            this.d.d(jVar);
        }
        jVar.d(" $L", this.a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
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
            b(new j(sb2), false);
            return sb2.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private p(b bVar) {
        this.a = (String) u.c(bVar.b, "name == null", new Object[0]);
        this.b = u.e(bVar.d);
        this.c = u.h(bVar.e);
        this.d = (r) u.c(bVar.a, "type == null", new Object[0]);
        this.e = bVar.c.i();
    }
}
