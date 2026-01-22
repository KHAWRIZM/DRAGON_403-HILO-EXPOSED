package androidx.datastore.preferences.protobuf;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.KotlinVersion;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class h1 {

    /* renamed from: a, reason: collision with root package name */
    private static final Unsafe f٣٣٣١a = A();

    /* renamed from: b, reason: collision with root package name */
    private static final Class f٣٣٣٢b = androidx.datastore.preferences.protobuf.d.b();

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f٣٣٣٣c = m(Long.TYPE);

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f٣٣٣٤d = m(Integer.TYPE);

    /* renamed from: e, reason: collision with root package name */
    private static final e f٣٣٣٥e = y();

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f٣٣٣٦f = Q();

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f٣٣٣٧g = P();

    /* renamed from: h, reason: collision with root package name */
    static final long f٣٣٣٨h;

    /* renamed from: i, reason: collision with root package name */
    private static final long f٣٣٣٩i;

    /* renamed from: j, reason: collision with root package name */
    private static final long f٣٣٤٠j;

    /* renamed from: k, reason: collision with root package name */
    private static final long f٣٣٤١k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f٣٣٤٢l;

    /* renamed from: m, reason: collision with root package name */
    private static final long f٣٣٤٣m;

    /* renamed from: n, reason: collision with root package name */
    private static final long f٣٣٤٤n;

    /* renamed from: o, reason: collision with root package name */
    private static final long f٣٣٤٥o;

    /* renamed from: p, reason: collision with root package name */
    private static final long f٣٣٤٦p;

    /* renamed from: q, reason: collision with root package name */
    private static final long f٣٣٤٧q;

    /* renamed from: r, reason: collision with root package name */
    private static final long f٣٣٤٨r;

    /* renamed from: s, reason: collision with root package name */
    private static final long f٣٣٤٩s;

    /* renamed from: t, reason: collision with root package name */
    private static final long f٣٣٥٠t;

    /* renamed from: u, reason: collision with root package name */
    private static final long f٣٣٥١u;

    /* renamed from: v, reason: collision with root package name */
    private static final int f٣٣٥٢v;

    /* renamed from: w, reason: collision with root package name */
    static final boolean f٣٣٥٣w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements PrivilegedExceptionAction {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class b extends e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean c(Object obj, long j10) {
            return h1.f٣٣٥٣w ? h1.q(obj, j10) : h1.r(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public double d(Object obj, long j10) {
            return Double.longBitsToDouble(g(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public float e(Object obj, long j10) {
            return Float.intBitsToFloat(f(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void j(Object obj, long j10, boolean z10) {
            if (h1.f٣٣٥٣w) {
                h1.F(obj, j10, z10);
            } else {
                h1.G(obj, j10, z10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void k(Object obj, long j10, byte b10) {
            if (h1.f٣٣٥٣w) {
                h1.I(obj, j10, b10);
            } else {
                h1.J(obj, j10, b10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void l(Object obj, long j10, double d10) {
            o(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void m(Object obj, long j10, float f10) {
            n(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean r() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean c(Object obj, long j10) {
            return h1.f٣٣٥٣w ? h1.q(obj, j10) : h1.r(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public double d(Object obj, long j10) {
            return Double.longBitsToDouble(g(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public float e(Object obj, long j10) {
            return Float.intBitsToFloat(f(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void j(Object obj, long j10, boolean z10) {
            if (h1.f٣٣٥٣w) {
                h1.F(obj, j10, z10);
            } else {
                h1.G(obj, j10, z10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void k(Object obj, long j10, byte b10) {
            if (h1.f٣٣٥٣w) {
                h1.I(obj, j10, b10);
            } else {
                h1.J(obj, j10, b10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void l(Object obj, long j10, double d10) {
            o(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void m(Object obj, long j10, float f10) {
            n(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean r() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean c(Object obj, long j10) {
            return this.f٣٣٥٤a.getBoolean(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public double d(Object obj, long j10) {
            return this.f٣٣٥٤a.getDouble(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public float e(Object obj, long j10) {
            return this.f٣٣٥٤a.getFloat(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void j(Object obj, long j10, boolean z10) {
            this.f٣٣٥٤a.putBoolean(obj, j10, z10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void k(Object obj, long j10, byte b10) {
            this.f٣٣٥٤a.putByte(obj, j10, b10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void l(Object obj, long j10, double d10) {
            this.f٣٣٥٤a.putDouble(obj, j10, d10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public void m(Object obj, long j10, float f10) {
            this.f٣٣٥٤a.putFloat(obj, j10, f10);
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean q() {
            if (!super.q()) {
                return false;
            }
            try {
                Class<?> cls = this.f٣٣٥٤a.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                h1.D(th);
                return false;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h1.e
        public boolean r() {
            if (!super.r()) {
                return false;
            }
            try {
                Class<?> cls = this.f٣٣٥٤a.getClass();
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th) {
                h1.D(th);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f٣٣٥٤a;

        e(Unsafe unsafe) {
            this.f٣٣٥٤a = unsafe;
        }

        public final int a(Class cls) {
            return this.f٣٣٥٤a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f٣٣٥٤a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j10);

        public abstract double d(Object obj, long j10);

        public abstract float e(Object obj, long j10);

        public final int f(Object obj, long j10) {
            return this.f٣٣٥٤a.getInt(obj, j10);
        }

        public final long g(Object obj, long j10) {
            return this.f٣٣٥٤a.getLong(obj, j10);
        }

        public final Object h(Object obj, long j10) {
            return this.f٣٣٥٤a.getObject(obj, j10);
        }

        public final long i(Field field) {
            return this.f٣٣٥٤a.objectFieldOffset(field);
        }

        public abstract void j(Object obj, long j10, boolean z10);

        public abstract void k(Object obj, long j10, byte b10);

        public abstract void l(Object obj, long j10, double d10);

        public abstract void m(Object obj, long j10, float f10);

        public final void n(Object obj, long j10, int i10) {
            this.f٣٣٥٤a.putInt(obj, j10, i10);
        }

        public final void o(Object obj, long j10, long j11) {
            this.f٣٣٥٤a.putLong(obj, j10, j11);
        }

        public final void p(Object obj, long j10, Object obj2) {
            this.f٣٣٥٤a.putObject(obj, j10, obj2);
        }

        public boolean q() {
            Unsafe unsafe = this.f٣٣٥٤a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                h1.D(th);
                return false;
            }
        }

        public boolean r() {
            Unsafe unsafe = this.f٣٣٥٤a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                if (h1.b() != null) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                h1.D(th);
                return false;
            }
        }
    }

    static {
        boolean z10;
        long j10 = j(byte[].class);
        f٣٣٣٨h = j10;
        f٣٣٣٩i = j(boolean[].class);
        f٣٣٤٠j = k(boolean[].class);
        f٣٣٤١k = j(int[].class);
        f٣٣٤٢l = k(int[].class);
        f٣٣٤٣m = j(long[].class);
        f٣٣٤٤n = k(long[].class);
        f٣٣٤٥o = j(float[].class);
        f٣٣٤٦p = k(float[].class);
        f٣٣٤٧q = j(double[].class);
        f٣٣٤٨r = k(double[].class);
        f٣٣٤٩s = j(Object[].class);
        f٣٣٥٠t = k(Object[].class);
        f٣٣٥١u = o(l());
        f٣٣٥٢v = (int) (j10 & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z10 = true;
        } else {
            z10 = false;
        }
        f٣٣٥٣w = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe A() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean B() {
        return f٣٣٣٧g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean C() {
        return f٣٣٣٦f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(Throwable th) {
        Logger.getLogger(h1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void E(Object obj, long j10, boolean z10) {
        f٣٣٣٥e.j(obj, j10, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(Object obj, long j10, boolean z10) {
        I(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Object obj, long j10, boolean z10) {
        J(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void H(byte[] bArr, long j10, byte b10) {
        f٣٣٣٥e.k(bArr, f٣٣٣٨h + j10, b10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int w10 = w(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        M(obj, j11, ((255 & b10) << i10) | (w10 & (~(KotlinVersion.MAX_COMPONENT_VALUE << i10))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        M(obj, j11, ((255 & b10) << i10) | (w(obj, j11) & (~(KotlinVersion.MAX_COMPONENT_VALUE << i10))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void K(Object obj, long j10, double d10) {
        f٣٣٣٥e.l(obj, j10, d10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void L(Object obj, long j10, float f10) {
        f٣٣٣٥e.m(obj, j10, f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void M(Object obj, long j10, int i10) {
        f٣٣٣٥e.n(obj, j10, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void N(Object obj, long j10, long j11) {
        f٣٣٣٥e.o(obj, j10, j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void O(Object obj, long j10, Object obj2) {
        f٣٣٣٥e.p(obj, j10, obj2);
    }

    private static boolean P() {
        e eVar = f٣٣٣٥e;
        if (eVar == null) {
            return false;
        }
        return eVar.q();
    }

    private static boolean Q() {
        e eVar = f٣٣٣٥e;
        if (eVar == null) {
            return false;
        }
        return eVar.r();
    }

    static /* synthetic */ Field b() {
        return l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object i(Class cls) {
        try {
            return f٣٣٣١a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    private static int j(Class cls) {
        if (f٣٣٣٧g) {
            return f٣٣٣٥e.a(cls);
        }
        return -1;
    }

    private static int k(Class cls) {
        if (f٣٣٣٧g) {
            return f٣٣٣٥e.b(cls);
        }
        return -1;
    }

    private static Field l() {
        Field n10;
        if (androidx.datastore.preferences.protobuf.d.c() && (n10 = n(Buffer.class, "effectiveDirectAddress")) != null) {
            return n10;
        }
        Field n11 = n(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (n11 == null || n11.getType() != Long.TYPE) {
            return null;
        }
        return n11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean m(Class cls) {
        if (!androidx.datastore.preferences.protobuf.d.c()) {
            return false;
        }
        try {
            Class cls2 = f٣٣٣٢b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field n(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long o(Field field) {
        e eVar;
        if (field != null && (eVar = f٣٣٣٥e) != null) {
            return eVar.i(field);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p(Object obj, long j10) {
        return f٣٣٣٥e.c(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean q(Object obj, long j10) {
        if (s(obj, j10) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean r(Object obj, long j10) {
        if (t(obj, j10) != 0) {
            return true;
        }
        return false;
    }

    private static byte s(Object obj, long j10) {
        return (byte) ((w(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & KotlinVersion.MAX_COMPONENT_VALUE);
    }

    private static byte t(Object obj, long j10) {
        return (byte) ((w(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & KotlinVersion.MAX_COMPONENT_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double u(Object obj, long j10) {
        return f٣٣٣٥e.d(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float v(Object obj, long j10) {
        return f٣٣٣٥e.e(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(Object obj, long j10) {
        return f٣٣٣٥e.f(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long x(Object obj, long j10) {
        return f٣٣٣٥e.g(obj, j10);
    }

    private static e y() {
        Unsafe unsafe = f٣٣٣١a;
        if (unsafe == null) {
            return null;
        }
        if (androidx.datastore.preferences.protobuf.d.c()) {
            if (f٣٣٣٣c) {
                return new c(unsafe);
            }
            if (!f٣٣٣٤d) {
                return null;
            }
            return new b(unsafe);
        }
        return new d(unsafe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object z(Object obj, long j10) {
        return f٣٣٣٥e.h(obj, j10);
    }
}
