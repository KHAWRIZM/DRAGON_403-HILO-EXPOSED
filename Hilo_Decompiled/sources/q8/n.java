package q8;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f١٧٢٤٤a = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends n {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f١٧٢٤٥b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f١٧٢٤٦c;

        a(Method method, Object obj) {
            this.f١٧٢٤٥b = method;
            this.f١٧٢٤٦c = obj;
        }

        @Override // q8.n
        public Object d(Class cls) {
            n.b(cls);
            return this.f١٧٢٤٥b.invoke(this.f١٧٢٤٦c, cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends n {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f١٧٢٤٧b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f١٧٢٤٨c;

        b(Method method, int i10) {
            this.f١٧٢٤٧b = method;
            this.f١٧٢٤٨c = i10;
        }

        @Override // q8.n
        public Object d(Class cls) {
            n.b(cls);
            return this.f١٧٢٤٧b.invoke(null, cls, Integer.valueOf(this.f١٧٢٤٨c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c extends n {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f١٧٢٤٩b;

        c(Method method) {
            this.f١٧٢٤٩b = method;
        }

        @Override // q8.n
        public Object d(Class cls) {
            n.b(cls);
            return this.f١٧٢٤٩b.invoke(null, cls, Object.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d extends n {
        d() {
        }

        @Override // q8.n
        public Object d(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Class cls) {
        String a10 = q8.c.a(cls);
        if (a10 == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + a10);
    }

    private static n c() {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod.setAccessible(true);
                    return new c(declaredMethod);
                }
            } catch (Exception unused2) {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod2.setAccessible(true);
                int intValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
                Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod3.setAccessible(true);
                return new b(declaredMethod3, intValue);
            }
        } catch (Exception unused3) {
            return new d();
        }
    }

    public abstract Object d(Class cls);
}
