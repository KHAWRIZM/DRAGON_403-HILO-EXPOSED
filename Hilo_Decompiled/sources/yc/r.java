package yc;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleTypeVisitor8;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class r {
    public static final r d = new r("void");
    public static final r e = new r("boolean");
    public static final r f = new r("byte");
    public static final r g = new r("short");
    public static final r h = new r("int");
    public static final r i = new r("long");
    public static final r j = new r("char");
    public static final r k = new r("float");
    public static final r l = new r("double");
    public static final e m = e.r("java.lang", "Object", new String[0]);
    private static final e n = e.r("java.lang", "Void", new String[0]);
    private static final e o = e.r("java.lang", "Boolean", new String[0]);
    private static final e p = e.r("java.lang", "Byte", new String[0]);
    private static final e q = e.r("java.lang", "Short", new String[0]);
    private static final e r = e.r("java.lang", "Integer", new String[0]);
    private static final e s = e.r("java.lang", "Long", new String[0]);
    private static final e t = e.r("java.lang", "Character", new String[0]);
    private static final e u = e.r("java.lang", "Float", new String[0]);
    private static final e v = e.r("java.lang", "Double", new String[0]);
    private final String a;
    public final List b;
    private String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class a extends SimpleTypeVisitor8 {
        final /* synthetic */ Map a;

        a(Map map) {
            this.a = map;
        }
    }

    private r(String str) {
        this(str, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(r rVar) {
        if (rVar instanceof d) {
            return (d) rVar;
        }
        return null;
    }

    public static r f(Type type) {
        return g(type, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r g(Type type, Map map) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (type == Void.TYPE) {
                return d;
            }
            if (type == Boolean.TYPE) {
                return e;
            }
            if (type == Byte.TYPE) {
                return f;
            }
            if (type == Short.TYPE) {
                return g;
            }
            if (type == Integer.TYPE) {
                return h;
            }
            if (type == Long.TYPE) {
                return i;
            }
            if (type == Character.TYPE) {
                return j;
            }
            if (type == Float.TYPE) {
                return k;
            }
            if (type == Double.TYPE) {
                return l;
            }
            if (cls.isArray()) {
                return d.q(g(cls.getComponentType(), map));
            }
            return e.q(cls);
        }
        if (type instanceof ParameterizedType) {
            return q.m((ParameterizedType) type, map);
        }
        if (type instanceof WildcardType) {
            return v.m((WildcardType) type, map);
        }
        if (type instanceof TypeVariable) {
            return t.m((TypeVariable) type, map);
        }
        if (type instanceof GenericArrayType) {
            return d.p((GenericArrayType) type, map);
        }
        throw new IllegalArgumentException("unexpected type: " + type);
    }

    public static r h(TypeMirror typeMirror) {
        return i(typeMirror, new LinkedHashMap());
    }

    static r i(TypeMirror typeMirror, Map map) {
        return (r) typeMirror.accept(new a(map), (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List l(Type[] typeArr, Map map) {
        ArrayList arrayList = new ArrayList(typeArr.length);
        for (Type type : typeArr) {
            arrayList.add(g(type, map));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List c(List list) {
        ArrayList arrayList = new ArrayList(this.b);
        arrayList.addAll(list);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j d(j jVar) {
        if (this.a != null) {
            if (j()) {
                jVar.c("");
                e(jVar);
            }
            return jVar.g(this.a);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j e(j jVar) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((yc.a) it.next()).b(jVar, true);
            jVar.c(" ");
        }
        return jVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public boolean j() {
        return !this.b.isEmpty();
    }

    public boolean k() {
        if (this.a != null && this != d) {
            return true;
        }
        return false;
    }

    public final String toString() {
        String str = this.c;
        if (str == null) {
            try {
                StringBuilder sb2 = new StringBuilder();
                d(new j(sb2));
                String sb3 = sb2.toString();
                this.c = sb3;
                return sb3;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }
        return str;
    }

    private r(String str, List list) {
        this.a = str;
        this.b = u.e(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(List list) {
        this(null, list);
    }
}
