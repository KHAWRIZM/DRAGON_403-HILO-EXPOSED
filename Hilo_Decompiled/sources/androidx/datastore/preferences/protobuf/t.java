package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.u;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class t extends androidx.datastore.preferences.protobuf.a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, t> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected f1 unknownFields = f1.c();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class a extends a.AbstractC٠٠٣٤a {

        /* renamed from: a, reason: collision with root package name */
        private final t f٣٤٩٣a;

        /* renamed from: b, reason: collision with root package name */
        protected t f٣٤٩٤b;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(t tVar) {
            this.f٣٤٩٣a = tVar;
            if (!tVar.y()) {
                this.f٣٤٩٤b = l();
                return;
            }
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private static void k(Object obj, Object obj2) {
            t0.a().d(obj).a(obj, obj2);
        }

        private t l() {
            return this.f٣٤٩٣a.E();
        }

        public final t e() {
            t buildPartial = buildPartial();
            if (buildPartial.w()) {
                return buildPartial;
            }
            throw a.AbstractC٠٠٣٤a.d(buildPartial);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public t buildPartial() {
            if (!this.f٣٤٩٤b.y()) {
                return this.f٣٤٩٤b;
            }
            this.f٣٤٩٤b.z();
            return this.f٣٤٩٤b;
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a newBuilderForType = getDefaultInstanceForType().newBuilderForType();
            newBuilderForType.f٣٤٩٤b = buildPartial();
            return newBuilderForType;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void h() {
            if (!this.f٣٤٩٤b.y()) {
                i();
            }
        }

        protected void i() {
            t l10 = l();
            k(l10, this.f٣٤٩٤b);
            this.f٣٤٩٤b = l10;
        }

        @Override // androidx.datastore.preferences.protobuf.k0
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public t getDefaultInstanceForType() {
            return this.f٣٤٩٣a;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    protected static class b extends androidx.datastore.preferences.protobuf.b {

        /* renamed from: b, reason: collision with root package name */
        private final t f٣٤٩٥b;

        public b(t tVar) {
            this.f٣٤٩٥b = tVar;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends k {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum d {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static u.b B(u.b bVar) {
        int i10;
        int size = bVar.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size * 2;
        }
        return bVar.a(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object D(j0 j0Var, String str, Object[] objArr) {
        return new v0(j0Var, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static t F(t tVar, InputStream inputStream) {
        return g(G(tVar, g.g(inputStream), m.b()));
    }

    static t G(t tVar, g gVar, m mVar) {
        t E = tVar.E();
        try {
            x0 d10 = t0.a().d(E);
            d10.e(E, h.N(gVar), mVar);
            d10.b(E);
            return E;
        } catch (d1 e10) {
            throw e10.a().k(E);
        } catch (v e11) {
            e = e11;
            if (e.a()) {
                e = new v(e);
            }
            throw e.k(E);
        } catch (IOException e12) {
            if (e12.getCause() instanceof v) {
                throw ((v) e12.getCause());
            }
            throw new v(e12).k(E);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof v) {
                throw ((v) e13.getCause());
            }
            throw e13;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void H(Class cls, t tVar) {
        tVar.A();
        defaultInstanceMap.put(cls, tVar);
    }

    private static t g(t tVar) {
        if (tVar != null && !tVar.w()) {
            throw tVar.d().a().k(tVar);
        }
        return tVar;
    }

    private int k(x0 x0Var) {
        if (x0Var == null) {
            return t0.a().d(this).c(this);
        }
        return x0Var.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static u.b p() {
        return u0.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t q(Class cls) {
        t tVar = defaultInstanceMap.get(cls);
        if (tVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                tVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (tVar == null) {
            tVar = ((t) h1.i(cls)).getDefaultInstanceForType();
            if (tVar != null) {
                defaultInstanceMap.put(cls, tVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object v(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    protected static final boolean x(t tVar, boolean z10) {
        Object obj;
        byte byteValue = ((Byte) tVar.m(d.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean f10 = t0.a().d(tVar).f(tVar);
        if (z10) {
            d dVar = d.SET_MEMOIZED_IS_INITIALIZED;
            if (f10) {
                obj = tVar;
            } else {
                obj = null;
            }
            tVar.n(dVar, obj);
        }
        return f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // androidx.datastore.preferences.protobuf.j0
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public final a newBuilderForType() {
        return (a) m(d.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t E() {
        return (t) m(d.NEW_MUTABLE_INSTANCE);
    }

    void I(int i10) {
        this.memoizedHashCode = i10;
    }

    void J(int i10) {
        if (i10 >= 0) {
            this.memoizedSerializedSize = (i10 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.j0
    public void a(i iVar) {
        t0.a().d(this).h(this, j.P(iVar));
    }

    @Override // androidx.datastore.preferences.protobuf.a
    int c(x0 x0Var) {
        if (y()) {
            int k10 = k(x0Var);
            if (k10 >= 0) {
                return k10;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + k10);
        }
        if (t() != Integer.MAX_VALUE) {
            return t();
        }
        int k11 = k(x0Var);
        J(k11);
        return k11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return t0.a().d(this).i(this, (t) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object f() {
        return m(d.BUILD_MESSAGE_INFO);
    }

    @Override // androidx.datastore.preferences.protobuf.j0
    public int getSerializedSize() {
        return c(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.memoizedHashCode = 0;
    }

    public int hashCode() {
        if (y()) {
            return j();
        }
        if (u()) {
            I(j());
        }
        return s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        J(Integer.MAX_VALUE);
    }

    int j() {
        return t0.a().d(this).g(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a l() {
        return (a) m(d.NEW_BUILDER);
    }

    protected Object m(d dVar) {
        return o(dVar, null, null);
    }

    protected Object n(d dVar, Object obj) {
        return o(dVar, obj, null);
    }

    protected abstract Object o(d dVar, Object obj, Object obj2);

    @Override // androidx.datastore.preferences.protobuf.k0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final t getDefaultInstanceForType() {
        return (t) m(d.GET_DEFAULT_INSTANCE);
    }

    int s() {
        return this.memoizedHashCode;
    }

    int t() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    public String toString() {
        return l0.f(this, super.toString());
    }

    boolean u() {
        if (s() == 0) {
            return true;
        }
        return false;
    }

    public final boolean w() {
        return x(this, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        if ((this.memoizedSerializedSize & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z() {
        t0.a().d(this).b(this);
        A();
    }
}
