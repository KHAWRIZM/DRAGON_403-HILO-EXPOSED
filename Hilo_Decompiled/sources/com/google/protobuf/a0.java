package com.google.protobuf;

import com.google.protobuf.j0;
import java.lang.reflect.Field;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class a0 implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    private final Field f١٠٨٦٣a;

    /* renamed from: b, reason: collision with root package name */
    private final c0 f١٠٨٦٤b;

    /* renamed from: c, reason: collision with root package name */
    private final Class f١٠٨٦٥c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٠٨٦٦d;

    /* renamed from: e, reason: collision with root package name */
    private final Field f١٠٨٦٧e;

    /* renamed from: f, reason: collision with root package name */
    private final int f١٠٨٦٨f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f١٠٨٦٩g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f١٠٨٧٠h;

    /* renamed from: i, reason: collision with root package name */
    private final q1 f١٠٨٧١i;

    /* renamed from: j, reason: collision with root package name */
    private final Field f١٠٨٧٢j;

    /* renamed from: k, reason: collision with root package name */
    private final Class f١٠٨٧٣k;

    /* renamed from: l, reason: collision with root package name */
    private final Object f١٠٨٧٤l;

    /* renamed from: m, reason: collision with root package name */
    private final j0.e f١٠٨٧٥m;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٠٨٧٦a;

        static {
            int[] iArr = new int[c0.values().length];
            f١٠٨٧٦a = iArr;
            try {
                iArr[c0.f١٠٩١٥o.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٠٨٧٦a[c0.f١٠٩٢٣w.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٠٨٧٦a[c0.G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٠٨٧٦a[c0.f١٠٩٠١c0.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private a0(Field field, int i10, c0 c0Var, Class cls, Field field2, int i11, boolean z10, boolean z11, q1 q1Var, Class cls2, Object obj, j0.e eVar, Field field3) {
        this.f١٠٨٦٣a = field;
        this.f١٠٨٦٤b = c0Var;
        this.f١٠٨٦٥c = cls;
        this.f١٠٨٦٦d = i10;
        this.f١٠٨٦٧e = field2;
        this.f١٠٨٦٨f = i11;
        this.f١٠٨٦٩g = z10;
        this.f١٠٨٧٠h = z11;
        this.f١٠٨٧١i = q1Var;
        this.f١٠٨٧٣k = cls2;
        this.f١٠٨٧٤l = obj;
        this.f١٠٨٧٥m = eVar;
        this.f١٠٨٧٢j = field3;
    }

    private static void a(int i10) {
        if (i10 > 0) {
            return;
        }
        throw new IllegalArgumentException("fieldNumber must be positive: " + i10);
    }

    public static a0 d(Field field, int i10, c0 c0Var, boolean z10) {
        a(i10);
        j0.b(field, "field");
        j0.b(c0Var, "fieldType");
        if (c0Var != c0.G && c0Var != c0.f١٠٩٠١c0) {
            return new a0(field, i10, c0Var, null, null, 0, false, z10, null, null, null, null, null);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static a0 e(Field field, int i10, c0 c0Var, j0.e eVar) {
        a(i10);
        j0.b(field, "field");
        return new a0(field, i10, c0Var, null, null, 0, false, false, null, null, null, eVar, null);
    }

    public static a0 f(Field field, int i10, Object obj, j0.e eVar) {
        j0.b(obj, "mapDefaultEntry");
        a(i10);
        j0.b(field, "field");
        return new a0(field, i10, c0.f١٠٩٠٢d0, null, null, 0, false, true, null, null, obj, eVar, null);
    }

    public static a0 g(int i10, c0 c0Var, q1 q1Var, Class cls, boolean z10, j0.e eVar) {
        a(i10);
        j0.b(c0Var, "fieldType");
        j0.b(q1Var, "oneof");
        j0.b(cls, "oneofStoredType");
        if (c0Var.g()) {
            return new a0(null, i10, c0Var, null, null, 0, false, z10, q1Var, cls, null, eVar, null);
        }
        throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + i10 + " is of type " + c0Var);
    }

    public static a0 h(Field field, int i10, c0 c0Var, Field field2) {
        a(i10);
        j0.b(field, "field");
        j0.b(c0Var, "fieldType");
        if (c0Var != c0.G && c0Var != c0.f١٠٩٠١c0) {
            return new a0(field, i10, c0Var, null, null, 0, false, false, null, null, null, null, field2);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static a0 i(Field field, int i10, c0 c0Var, j0.e eVar, Field field2) {
        a(i10);
        j0.b(field, "field");
        return new a0(field, i10, c0Var, null, null, 0, false, false, null, null, null, eVar, field2);
    }

    public static a0 j(Field field, int i10, c0 c0Var, Field field2, int i11, boolean z10, j0.e eVar) {
        a(i10);
        j0.b(field, "field");
        j0.b(c0Var, "fieldType");
        j0.b(field2, "presenceField");
        if (field2 != null && !x(i11)) {
            throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i11);
        }
        return new a0(field, i10, c0Var, null, field2, i11, false, z10, null, null, null, eVar, null);
    }

    public static a0 k(Field field, int i10, c0 c0Var, Field field2, int i11, boolean z10, j0.e eVar) {
        a(i10);
        j0.b(field, "field");
        j0.b(c0Var, "fieldType");
        j0.b(field2, "presenceField");
        if (field2 != null && !x(i11)) {
            throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i11);
        }
        return new a0(field, i10, c0Var, null, field2, i11, true, z10, null, null, null, eVar, null);
    }

    public static a0 l(Field field, int i10, c0 c0Var, Class cls) {
        a(i10);
        j0.b(field, "field");
        j0.b(c0Var, "fieldType");
        j0.b(cls, "messageClass");
        return new a0(field, i10, c0Var, cls, null, 0, false, false, null, null, null, null, null);
    }

    private static boolean x(int i10) {
        return i10 != 0 && (i10 & (i10 + (-1))) == 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(a0 a0Var) {
        return this.f١٠٨٦٦d - a0Var.f١٠٨٦٦d;
    }

    public Field m() {
        return this.f١٠٨٧٢j;
    }

    public j0.e n() {
        return this.f١٠٨٧٥m;
    }

    public Field o() {
        return this.f١٠٨٦٣a;
    }

    public int p() {
        return this.f١٠٨٦٦d;
    }

    public Object q() {
        return this.f١٠٨٧٤l;
    }

    public Class r() {
        int i10 = a.f١٠٨٧٦a[this.f١٠٨٦٤b.ordinal()];
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3 && i10 != 4) {
                return null;
            }
            return this.f١٠٨٦٥c;
        }
        Field field = this.f١٠٨٦٣a;
        if (field != null) {
            return field.getType();
        }
        return this.f١٠٨٧٣k;
    }

    public q1 s() {
        return this.f١٠٨٧١i;
    }

    public Field t() {
        return this.f١٠٨٦٧e;
    }

    public int u() {
        return this.f١٠٨٦٨f;
    }

    public c0 v() {
        return this.f١٠٨٦٤b;
    }

    public boolean w() {
        return this.f١٠٨٧٠h;
    }

    public boolean y() {
        return this.f١٠٨٦٩g;
    }
}
