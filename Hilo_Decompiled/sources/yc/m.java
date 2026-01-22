package yc;

import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.JavaFileObject;
import yc.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class m {
    private static final Appendable h = new a();
    public final f a;
    public final String b;
    public final s c;
    public final boolean d;
    private final Set e;
    private final Set f;
    private final String g;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class a implements Appendable {
        a() {
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) {
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) {
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class b {
        private final String a;
        private final s b;
        private final f.b c;
        private boolean d;
        private String e;
        public final Set f;

        /* synthetic */ b(String str, s sVar, a aVar) {
            this(str, sVar);
        }

        public m f() {
            return new m(this, null);
        }

        private b(String str, s sVar) {
            this.c = f.a();
            this.e = "  ";
            this.f = new TreeSet();
            this.a = str;
            this.b = sVar;
        }
    }

    /* synthetic */ m(b bVar, a aVar) {
        this(bVar);
    }

    private static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                return;
            }
        }
        autoCloseable.close();
    }

    public static b b(String str, s sVar) {
        u.c(str, "packageName == null", new Object[0]);
        u.c(sVar, "typeSpec == null", new Object[0]);
        return new b(str, sVar, null);
    }

    private void c(j jVar) {
        jVar.C(this.b);
        if (!this.a.b()) {
            jVar.i(this.a);
        }
        if (!this.b.isEmpty()) {
            jVar.d("package $L;\n", this.b);
            jVar.c("\n");
        }
        if (!this.e.isEmpty()) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                jVar.d("import static $L;\n", (String) it.next());
            }
            jVar.c("\n");
        }
        Iterator it2 = new TreeSet(jVar.t().values()).iterator();
        int i = 0;
        while (it2.hasNext()) {
            e eVar = (e) it2.next();
            if (!this.d || !eVar.u().equals("java.lang") || this.f.contains(eVar.y)) {
                jVar.d("import $L;\n", eVar.y());
                i++;
            }
        }
        if (i > 0) {
            jVar.c("\n");
        }
        this.c.b(jVar, null, Collections.emptySet());
        jVar.z();
    }

    private void d(s sVar, Set set) {
        set.addAll(sVar.r);
        Iterator it = sVar.o.iterator();
        while (it.hasNext()) {
            d((s) it.next(), set);
        }
    }

    public void e(Appendable appendable) {
        j jVar = new j(h, this.g, this.e, this.f);
        c(jVar);
        c(new j(appendable, this.g, jVar.G(), this.e, this.f));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public void f(Filer filer) {
        String str;
        if (this.b.isEmpty()) {
            str = this.c.b;
        } else {
            str = this.b + "." + this.c.b;
        }
        List list = this.c.q;
        JavaFileObject createSourceFile = filer.createSourceFile(str, (Element[]) list.toArray(new Element[list.size()]));
        try {
            Writer openWriter = createSourceFile.openWriter();
            try {
                e(openWriter);
                if (openWriter != null) {
                    a(null, openWriter);
                }
            } finally {
            }
        } catch (Exception e) {
            try {
                createSourceFile.delete();
            } catch (Exception unused) {
            }
            throw e;
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        try {
            StringBuilder sb2 = new StringBuilder();
            e(sb2);
            return sb2.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private m(b bVar) {
        this.a = bVar.c.i();
        this.b = bVar.a;
        this.c = bVar.b;
        this.d = bVar.d;
        this.e = u.h(bVar.f);
        this.g = bVar.e;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        d(bVar.b, linkedHashSet);
        this.f = u.h(linkedHashSet);
    }
}
