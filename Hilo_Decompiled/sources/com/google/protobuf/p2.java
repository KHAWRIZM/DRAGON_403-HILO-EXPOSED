package com.google.protobuf;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.KotlinVersion;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class p2 {

    /* renamed from: a, reason: collision with root package name */
    private static final Unsafe f١١٨٦٥a = I();

    /* renamed from: b, reason: collision with root package name */
    private static final Class f١١٨٦٦b = com.google.protobuf.e.b();

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f١١٨٦٧c = q(Long.TYPE);

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f١١٨٦٨d = q(Integer.TYPE);

    /* renamed from: e, reason: collision with root package name */
    private static final e f١١٨٦٩e = F();

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f١١٨٧٠f = Z();

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f١١٨٧١g = Y();

    /* renamed from: h, reason: collision with root package name */
    static final long f١١٨٧٢h;

    /* renamed from: i, reason: collision with root package name */
    private static final long f١١٨٧٣i;

    /* renamed from: j, reason: collision with root package name */
    private static final long f١١٨٧٤j;

    /* renamed from: k, reason: collision with root package name */
    private static final long f١١٨٧٥k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f١١٨٧٦l;

    /* renamed from: m, reason: collision with root package name */
    private static final long f١١٨٧٧m;

    /* renamed from: n, reason: collision with root package name */
    private static final long f١١٨٧٨n;

    /* renamed from: o, reason: collision with root package name */
    private static final long f١١٨٧٩o;

    /* renamed from: p, reason: collision with root package name */
    private static final long f١١٨٨٠p;

    /* renamed from: q, reason: collision with root package name */
    private static final long f١١٨٨١q;

    /* renamed from: r, reason: collision with root package name */
    private static final long f١١٨٨٢r;

    /* renamed from: s, reason: collision with root package name */
    private static final long f١١٨٨٣s;

    /* renamed from: t, reason: collision with root package name */
    private static final long f١١٨٨٤t;

    /* renamed from: u, reason: collision with root package name */
    private static final long f١١٨٨٥u;

    /* renamed from: v, reason: collision with root package name */
    private static final int f١١٨٨٦v;

    /* renamed from: w, reason: collision with root package name */
    static final boolean f١١٨٨٧w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
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
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b extends e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.p2.e
        public void c(long j10, byte[] bArr, long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.p2.e
        public boolean d(Object obj, long j10) {
            return p2.f١١٨٨٧w ? p2.u(obj, j10) : p2.v(obj, j10);
        }

        @Override // com.google.protobuf.p2.e
        public byte e(long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.p2.e
        public byte f(Object obj, long j10) {
            return p2.f١١٨٨٧w ? p2.y(obj, j10) : p2.z(obj, j10);
        }

        @Override // com.google.protobuf.p2.e
        public double g(Object obj, long j10) {
            return Double.longBitsToDouble(k(obj, j10));
        }

        @Override // com.google.protobuf.p2.e
        public float h(Object obj, long j10) {
            return Float.intBitsToFloat(i(obj, j10));
        }

        @Override // com.google.protobuf.p2.e
        public long j(long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.p2.e
        public Object m(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.protobuf.p2.e
        public void o(Object obj, long j10, boolean z10) {
            if (p2.f١١٨٨٧w) {
                p2.O(obj, j10, z10);
            } else {
                p2.P(obj, j10, z10);
            }
        }

        @Override // com.google.protobuf.p2.e
        public void p(Object obj, long j10, byte b10) {
            if (p2.f١١٨٨٧w) {
                p2.R(obj, j10, b10);
            } else {
                p2.S(obj, j10, b10);
            }
        }

        @Override // com.google.protobuf.p2.e
        public void q(Object obj, long j10, double d10) {
            t(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.protobuf.p2.e
        public void r(Object obj, long j10, float f10) {
            s(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.protobuf.p2.e
        public boolean w() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.p2.e
        public void c(long j10, byte[] bArr, long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.p2.e
        public boolean d(Object obj, long j10) {
            return p2.f١١٨٨٧w ? p2.u(obj, j10) : p2.v(obj, j10);
        }

        @Override // com.google.protobuf.p2.e
        public byte e(long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.p2.e
        public byte f(Object obj, long j10) {
            return p2.f١١٨٨٧w ? p2.y(obj, j10) : p2.z(obj, j10);
        }

        @Override // com.google.protobuf.p2.e
        public double g(Object obj, long j10) {
            return Double.longBitsToDouble(k(obj, j10));
        }

        @Override // com.google.protobuf.p2.e
        public float h(Object obj, long j10) {
            return Float.intBitsToFloat(i(obj, j10));
        }

        @Override // com.google.protobuf.p2.e
        public long j(long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.p2.e
        public Object m(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.protobuf.p2.e
        public void o(Object obj, long j10, boolean z10) {
            if (p2.f١١٨٨٧w) {
                p2.O(obj, j10, z10);
            } else {
                p2.P(obj, j10, z10);
            }
        }

        @Override // com.google.protobuf.p2.e
        public void p(Object obj, long j10, byte b10) {
            if (p2.f١١٨٨٧w) {
                p2.R(obj, j10, b10);
            } else {
                p2.S(obj, j10, b10);
            }
        }

        @Override // com.google.protobuf.p2.e
        public void q(Object obj, long j10, double d10) {
            t(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.protobuf.p2.e
        public void r(Object obj, long j10, float f10) {
            s(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.protobuf.p2.e
        public boolean w() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.p2.e
        public void c(long j10, byte[] bArr, long j11, long j12) {
            this.f١١٨٨٨a.copyMemory((Object) null, j10, bArr, p2.f١١٨٧٢h + j11, j12);
        }

        @Override // com.google.protobuf.p2.e
        public boolean d(Object obj, long j10) {
            return this.f١١٨٨٨a.getBoolean(obj, j10);
        }

        @Override // com.google.protobuf.p2.e
        public byte e(long j10) {
            return this.f١١٨٨٨a.getByte(j10);
        }

        @Override // com.google.protobuf.p2.e
        public byte f(Object obj, long j10) {
            return this.f١١٨٨٨a.getByte(obj, j10);
        }

        @Override // com.google.protobuf.p2.e
        public double g(Object obj, long j10) {
            return this.f١١٨٨٨a.getDouble(obj, j10);
        }

        @Override // com.google.protobuf.p2.e
        public float h(Object obj, long j10) {
            return this.f١١٨٨٨a.getFloat(obj, j10);
        }

        @Override // com.google.protobuf.p2.e
        public long j(long j10) {
            return this.f١١٨٨٨a.getLong(j10);
        }

        @Override // com.google.protobuf.p2.e
        public Object m(Field field) {
            return l(this.f١١٨٨٨a.staticFieldBase(field), this.f١١٨٨٨a.staticFieldOffset(field));
        }

        @Override // com.google.protobuf.p2.e
        public void o(Object obj, long j10, boolean z10) {
            this.f١١٨٨٨a.putBoolean(obj, j10, z10);
        }

        @Override // com.google.protobuf.p2.e
        public void p(Object obj, long j10, byte b10) {
            this.f١١٨٨٨a.putByte(obj, j10, b10);
        }

        @Override // com.google.protobuf.p2.e
        public void q(Object obj, long j10, double d10) {
            this.f١١٨٨٨a.putDouble(obj, j10, d10);
        }

        @Override // com.google.protobuf.p2.e
        public void r(Object obj, long j10, float f10) {
            this.f١١٨٨٨a.putFloat(obj, j10, f10);
        }

        @Override // com.google.protobuf.p2.e
        public boolean v() {
            if (!super.v()) {
                return false;
            }
            try {
                Class<?> cls = this.f١١٨٨٨a.getClass();
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
                p2.L(th);
                return false;
            }
        }

        @Override // com.google.protobuf.p2.e
        public boolean w() {
            if (!super.w()) {
                return false;
            }
            try {
                Class<?> cls = this.f١١٨٨٨a.getClass();
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
                p2.L(th);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f١١٨٨٨a;

        e(Unsafe unsafe) {
            this.f١١٨٨٨a = unsafe;
        }

        public final int a(Class cls) {
            return this.f١١٨٨٨a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f١١٨٨٨a.arrayIndexScale(cls);
        }

        public abstract void c(long j10, byte[] bArr, long j11, long j12);

        public abstract boolean d(Object obj, long j10);

        public abstract byte e(long j10);

        public abstract byte f(Object obj, long j10);

        public abstract double g(Object obj, long j10);

        public abstract float h(Object obj, long j10);

        public final int i(Object obj, long j10) {
            return this.f١١٨٨٨a.getInt(obj, j10);
        }

        public abstract long j(long j10);

        public final long k(Object obj, long j10) {
            return this.f١١٨٨٨a.getLong(obj, j10);
        }

        public final Object l(Object obj, long j10) {
            return this.f١١٨٨٨a.getObject(obj, j10);
        }

        public abstract Object m(Field field);

        public final long n(Field field) {
            return this.f١١٨٨٨a.objectFieldOffset(field);
        }

        public abstract void o(Object obj, long j10, boolean z10);

        public abstract void p(Object obj, long j10, byte b10);

        public abstract void q(Object obj, long j10, double d10);

        public abstract void r(Object obj, long j10, float f10);

        public final void s(Object obj, long j10, int i10) {
            this.f١١٨٨٨a.putInt(obj, j10, i10);
        }

        public final void t(Object obj, long j10, long j11) {
            this.f١١٨٨٨a.putLong(obj, j10, j11);
        }

        public final void u(Object obj, long j10, Object obj2) {
            this.f١١٨٨٨a.putObject(obj, j10, obj2);
        }

        public boolean v() {
            Unsafe unsafe = this.f١١٨٨٨a;
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
                p2.L(th);
                return false;
            }
        }

        public boolean w() {
            Unsafe unsafe = this.f١١٨٨٨a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                if (p2.b() != null) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                p2.L(th);
                return false;
            }
        }
    }

    static {
        boolean z10;
        long m10 = m(byte[].class);
        f١١٨٧٢h = m10;
        f١١٨٧٣i = m(boolean[].class);
        f١١٨٧٤j = n(boolean[].class);
        f١١٨٧٥k = m(int[].class);
        f١١٨٧٦l = n(int[].class);
        f١١٨٧٧m = m(long[].class);
        f١١٨٧٨n = n(long[].class);
        f١١٨٧٩o = m(float[].class);
        f١١٨٨٠p = n(float[].class);
        f١١٨٨١q = m(double[].class);
        f١١٨٨٢r = n(double[].class);
        f١١٨٨٣s = m(Object[].class);
        f١١٨٨٤t = n(Object[].class);
        f١١٨٨٥u = s(o());
        f١١٨٨٦v = (int) (m10 & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z10 = true;
        } else {
            z10 = false;
        }
        f١١٨٨٧w = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double A(Object obj, long j10) {
        return f١١٨٦٩e.g(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float B(Object obj, long j10) {
        return f١١٨٦٩e.h(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(Object obj, long j10) {
        return f١١٨٦٩e.i(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long D(long j10) {
        return f١١٨٦٩e.j(j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long E(Object obj, long j10) {
        return f١١٨٦٩e.k(obj, j10);
    }

    private static e F() {
        Unsafe unsafe = f١١٨٦٥a;
        if (unsafe == null) {
            return null;
        }
        if (com.google.protobuf.e.c()) {
            if (f١١٨٦٧c) {
                return new c(unsafe);
            }
            if (!f١١٨٦٨d) {
                return null;
            }
            return new b(unsafe);
        }
        return new d(unsafe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object G(Object obj, long j10) {
        return f١١٨٦٩e.l(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object H(Field field) {
        return f١١٨٦٩e.m(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe I() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean J() {
        return f١١٨٧١g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean K() {
        return f١١٨٧٠f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void L(Throwable th) {
        Logger.getLogger(p2.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long M(Field field) {
        return f١١٨٦٩e.n(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void N(Object obj, long j10, boolean z10) {
        f١١٨٦٩e.o(obj, j10, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(Object obj, long j10, boolean z10) {
        R(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(Object obj, long j10, boolean z10) {
        S(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Q(byte[] bArr, long j10, byte b10) {
        f١١٨٦٩e.p(bArr, f١١٨٧٢h + j10, b10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int C = C(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        V(obj, j11, ((255 & b10) << i10) | (C & (~(KotlinVersion.MAX_COMPONENT_VALUE << i10))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        V(obj, j11, ((255 & b10) << i10) | (C(obj, j11) & (~(KotlinVersion.MAX_COMPONENT_VALUE << i10))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void T(Object obj, long j10, double d10) {
        f١١٨٦٩e.q(obj, j10, d10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void U(Object obj, long j10, float f10) {
        f١١٨٦٩e.r(obj, j10, f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void V(Object obj, long j10, int i10) {
        f١١٨٦٩e.s(obj, j10, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void W(Object obj, long j10, long j11) {
        f١١٨٦٩e.t(obj, j10, j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void X(Object obj, long j10, Object obj2) {
        f١١٨٦٩e.u(obj, j10, obj2);
    }

    private static boolean Y() {
        e eVar = f١١٨٦٩e;
        if (eVar == null) {
            return false;
        }
        return eVar.v();
    }

    private static boolean Z() {
        e eVar = f١١٨٦٩e;
        if (eVar == null) {
            return false;
        }
        return eVar.w();
    }

    static /* synthetic */ Field b() {
        return o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long k(ByteBuffer byteBuffer) {
        return f١١٨٦٩e.k(byteBuffer, f١١٨٨٥u);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object l(Class cls) {
        try {
            return f١١٨٦٥a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    private static int m(Class cls) {
        if (f١١٨٧١g) {
            return f١١٨٦٩e.a(cls);
        }
        return -1;
    }

    private static int n(Class cls) {
        if (f١١٨٧١g) {
            return f١١٨٦٩e.b(cls);
        }
        return -1;
    }

    private static Field o() {
        Field r10;
        if (com.google.protobuf.e.c() && (r10 = r(Buffer.class, "effectiveDirectAddress")) != null) {
            return r10;
        }
        Field r11 = r(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (r11 == null || r11.getType() != Long.TYPE) {
            return null;
        }
        return r11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p(long j10, byte[] bArr, long j11, long j12) {
        f١١٨٦٩e.c(j10, bArr, j11, j12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean q(Class cls) {
        if (!com.google.protobuf.e.c()) {
            return false;
        }
        try {
            Class cls2 = f١١٨٦٦b;
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

    private static Field r(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long s(Field field) {
        e eVar;
        if (field != null && (eVar = f١١٨٦٩e) != null) {
            return eVar.n(field);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t(Object obj, long j10) {
        return f١١٨٦٩e.d(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean u(Object obj, long j10) {
        if (y(obj, j10) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(Object obj, long j10) {
        if (z(obj, j10) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte w(long j10) {
        return f١١٨٦٩e.e(j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte x(byte[] bArr, long j10) {
        return f١١٨٦٩e.f(bArr, f١١٨٧٢h + j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte y(Object obj, long j10) {
        return (byte) ((C(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & KotlinVersion.MAX_COMPONENT_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte z(Object obj, long j10) {
        return (byte) ((C(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & KotlinVersion.MAX_COMPONENT_VALUE);
    }
}
