package yc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.SimpleElementVisitor8;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class e extends r implements Comparable {
    public static final e B = q(Object.class);
    final String A;
    final String w;
    final e x;
    final String y;
    private List z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class a extends SimpleElementVisitor8 {
        final /* synthetic */ String a;
        final /* synthetic */ TypeElement b;

        a(String str, TypeElement typeElement) {
            this.a = str;
            this.b = typeElement;
        }
    }

    private e(String str, e eVar, String str2) {
        this(str, eVar, str2, Collections.emptyList());
    }

    private List p() {
        ArrayList arrayList = new ArrayList();
        for (e eVar = this; eVar != null; eVar = eVar.x) {
            arrayList.add(eVar);
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static e q(Class cls) {
        u.c(cls, "clazz == null", new Object[0]);
        u.b(!cls.isPrimitive(), "primitive types cannot be represented as a ClassName", new Object[0]);
        u.b(!Void.TYPE.equals(cls), "'void' type cannot be represented as a ClassName", new Object[0]);
        u.b(!cls.isArray(), "array types cannot be represented as a ClassName", new Object[0]);
        String str = "";
        String str2 = "";
        while (cls.isAnonymousClass()) {
            str2 = cls.getName().substring(cls.getName().lastIndexOf(36)) + str2;
            cls = cls.getEnclosingClass();
        }
        String str3 = cls.getSimpleName() + str2;
        if (cls.getEnclosingClass() == null) {
            int lastIndexOf = cls.getName().lastIndexOf(46);
            if (lastIndexOf != -1) {
                str = cls.getName().substring(0, lastIndexOf);
            }
            return new e(str, null, str3);
        }
        return q(cls.getEnclosingClass()).t(str3);
    }

    public static e r(String str, String str2, String... strArr) {
        e eVar = new e(str, null, str2);
        for (String str3 : strArr) {
            eVar = eVar.t(str3);
        }
        return eVar;
    }

    public static e s(TypeElement typeElement) {
        u.c(typeElement, "element == null", new Object[0]);
        return (e) typeElement.getEnclosingElement().accept(new a(typeElement.getSimpleName().toString(), typeElement), (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // yc.r
    public j d(j jVar) {
        String str;
        boolean z = false;
        for (e eVar : p()) {
            if (z) {
                jVar.c(".");
                str = eVar.y;
            } else if (eVar.j() || eVar == this) {
                str = jVar.y(eVar);
                int lastIndexOf = str.lastIndexOf(46);
                if (lastIndexOf != -1) {
                    int i = lastIndexOf + 1;
                    jVar.g(str.substring(0, i));
                    str = str.substring(i);
                    z = true;
                }
            }
            if (eVar.j()) {
                if (z) {
                    jVar.c(" ");
                }
                eVar.e(jVar);
            }
            jVar.c(str);
            z = true;
        }
        return jVar;
    }

    @Override // yc.r
    public boolean j() {
        e eVar;
        if (!super.j() && ((eVar = this.x) == null || !eVar.j())) {
            return false;
        }
        return true;
    }

    public e m(List list) {
        return new e(this.w, this.x, this.y, c(list));
    }

    @Override // java.lang.Comparable
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        return this.A.compareTo(eVar.A);
    }

    public e o() {
        return this.x;
    }

    public e t(String str) {
        return new e(this.w, this, str);
    }

    public String u() {
        return this.w;
    }

    public String v() {
        return this.y;
    }

    public List w() {
        List list = this.z;
        if (list != null) {
            return list;
        }
        if (this.x == null) {
            this.z = Collections.singletonList(this.y);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(o().w());
            arrayList.add(this.y);
            this.z = Collections.unmodifiableList(arrayList);
        }
        return this.z;
    }

    public e x() {
        e eVar = this.x;
        if (eVar != null) {
            return eVar.x();
        }
        return this;
    }

    public e y() {
        e eVar;
        if (!j()) {
            return this;
        }
        e eVar2 = this.x;
        if (eVar2 != null) {
            eVar = eVar2.y();
        } else {
            eVar = null;
        }
        return new e(this.w, eVar, this.y);
    }

    private e(String str, e eVar, String str2, List list) {
        super(list);
        Objects.requireNonNull(str, "packageName == null");
        this.w = str;
        this.x = eVar;
        this.y = str2;
        if (eVar != null) {
            str2 = eVar.A + '.' + str2;
        } else if (!str.isEmpty()) {
            str2 = str + '.' + str2;
        }
        this.A = str2;
    }
}
