package q8;

import androidx.appcompat.app.a0;
import com.google.gson.reflect.TypeToken;
import com.google.gson.t;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map f١٧١٨١a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f١٧١٨٢b;

    /* renamed from: c, reason: collision with root package name */
    private final List f١٧١٨٣c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements q8.i {
        a() {
        }

        @Override // q8.i
        public Object a() {
            return new TreeSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements q8.i {
        b() {
        }

        @Override // q8.i
        public Object a() {
            return new LinkedHashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q8.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class C٠٢١٢c implements q8.i {
        C٠٢١٢c() {
        }

        @Override // q8.i
        public Object a() {
            return new ArrayDeque();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d implements q8.i {
        d() {
        }

        @Override // q8.i
        public Object a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class e implements q8.i {
        e() {
        }

        @Override // q8.i
        public Object a() {
            return new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class f implements q8.i {
        f() {
        }

        @Override // q8.i
        public Object a() {
            return new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class g implements q8.i {
        g() {
        }

        @Override // q8.i
        public Object a() {
            return new TreeMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class h implements q8.i {
        h() {
        }

        @Override // q8.i
        public Object a() {
            return new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class i implements q8.i {
        i() {
        }

        @Override // q8.i
        public Object a() {
            return new q8.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class j implements q8.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f١٧١٨٤a;

        j(Class cls) {
            this.f١٧١٨٤a = cls;
        }

        @Override // q8.i
        public Object a() {
            try {
                return q8.n.f١٧٢٤٤a.d(this.f١٧١٨٤a);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to create instance of " + this.f١٧١٨٤a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class k implements q8.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f١٧١٨٦a;

        k(String str) {
            this.f١٧١٨٦a = str;
        }

        @Override // q8.i
        public Object a() {
            throw new com.google.gson.j(this.f١٧١٨٦a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class l implements q8.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f١٧١٨٨a;

        l(String str) {
            this.f١٧١٨٨a = str;
        }

        @Override // q8.i
        public Object a() {
            throw new com.google.gson.j(this.f١٧١٨٨a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class m implements q8.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f١٧١٩٠a;

        m(String str) {
            this.f١٧١٩٠a = str;
        }

        @Override // q8.i
        public Object a() {
            throw new com.google.gson.j(this.f١٧١٩٠a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class n implements q8.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f١٧١٩٢a;

        n(Type type) {
            this.f١٧١٩٢a = type;
        }

        @Override // q8.i
        public Object a() {
            Type type = this.f١٧١٩٢a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new com.google.gson.j("Invalid EnumSet type: " + this.f١٧١٩٢a.toString());
            }
            throw new com.google.gson.j("Invalid EnumSet type: " + this.f١٧١٩٢a.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class o implements q8.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f١٧١٩٣a;

        o(Type type) {
            this.f١٧١٩٣a = type;
        }

        @Override // q8.i
        public Object a() {
            Type type = this.f١٧١٩٣a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return new EnumMap((Class) type2);
                }
                throw new com.google.gson.j("Invalid EnumMap type: " + this.f١٧١٩٣a.toString());
            }
            throw new com.google.gson.j("Invalid EnumMap type: " + this.f١٧١٩٣a.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class p implements q8.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f١٧١٩٤a;

        p(String str) {
            this.f١٧١٩٤a = str;
        }

        @Override // q8.i
        public Object a() {
            throw new com.google.gson.j(this.f١٧١٩٤a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class q implements q8.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f١٧١٩٥a;

        q(String str) {
            this.f١٧١٩٥a = str;
        }

        @Override // q8.i
        public Object a() {
            throw new com.google.gson.j(this.f١٧١٩٥a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class r implements q8.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f١٧١٩٦a;

        r(Constructor constructor) {
            this.f١٧١٩٦a = constructor;
        }

        @Override // q8.i
        public Object a() {
            try {
                return this.f١٧١٩٦a.newInstance(null);
            } catch (IllegalAccessException e10) {
                throw t8.a.e(e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + t8.a.c(this.f١٧١٩٦a) + "' with no args", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + t8.a.c(this.f١٧١٩٦a) + "' with no args", e12.getCause());
            }
        }
    }

    public c(Map map, boolean z10, List list) {
        this.f١٧١٨١a = map;
        this.f١٧١٨٢b = z10;
        this.f١٧١٨٣c = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
        }
        return null;
    }

    private static q8.i c(Class cls, t tVar) {
        String m10;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            t tVar2 = t.ALLOW;
            if (tVar != tVar2 && (!q8.l.a(declaredConstructor, null) || (tVar == t.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return new p("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
            }
            if (tVar == tVar2 && (m10 = t8.a.m(declaredConstructor)) != null) {
                return new q(m10);
            }
            return new r(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static q8.i d(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new C٠٢١٢c();
            }
            return new d();
        }
        if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new e();
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new f();
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new g();
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new h();
            }
            return new i();
        }
        return null;
    }

    private static q8.i e(Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new n(type);
        }
        if (cls == EnumMap.class) {
            return new o(type);
        }
        return null;
    }

    private q8.i f(Class cls) {
        if (this.f١٧١٨٢b) {
            return new j(cls);
        }
        return new k("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public q8.i b(TypeToken typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        a0.a(this.f١٧١٨١a.get(type));
        a0.a(this.f١٧١٨١a.get(rawType));
        q8.i e10 = e(type, rawType);
        if (e10 != null) {
            return e10;
        }
        t b10 = q8.l.b(this.f١٧١٨٣c, rawType);
        q8.i c10 = c(rawType, b10);
        if (c10 != null) {
            return c10;
        }
        q8.i d10 = d(type, rawType);
        if (d10 != null) {
            return d10;
        }
        String a10 = a(rawType);
        if (a10 != null) {
            return new l(a10);
        }
        if (b10 == t.ALLOW) {
            return f(rawType);
        }
        return new m("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.f١٧١٨١a.toString();
    }
}
