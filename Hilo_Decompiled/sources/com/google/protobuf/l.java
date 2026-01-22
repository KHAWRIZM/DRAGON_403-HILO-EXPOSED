package com.google.protobuf;

import com.google.protobuf.d2;
import com.google.protobuf.j0;
import com.google.protobuf.n;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class l implements d1 {

    /* renamed from: a, reason: collision with root package name */
    private static final l f١١١٩٦a = new l();

    /* renamed from: b, reason: collision with root package name */
    private static final Set f١١١٩٧b = new HashSet(Arrays.asList("Class", "DefaultInstanceForType", "ParserForType", "SerializedSize", "AllFields", "DescriptorForType", "InitializationErrorString", "UnknownFields", "CachedSize"));

    /* renamed from: c, reason: collision with root package name */
    private static d f١١١٩٨c = new d();

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f١١١٩٩d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements j0.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.g f١١٢٠٠a;

        a(n.g gVar) {
            this.f١١٢٠٠a = gVar;
        }

        @Override // com.google.protobuf.j0.e
        public boolean a(int i10) {
            if (this.f١١٢٠٠a.n().h(i10) != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements j0.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.g f١١٢٠١a;

        b(n.g gVar) {
            this.f١١٢٠١a = gVar;
        }

        @Override // com.google.protobuf.j0.e
        public boolean a(int i10) {
            if (this.f١١٢٠١a.n().h(i10) != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١١٢٠٢a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f١١٢٠٣b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f١١٢٠٤c;

        static {
            int[] iArr = new int[n.g.c.values().length];
            f١١٢٠٤c = iArr;
            try {
                iArr[n.g.c.f١١٨٠٤i.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨٠٨m.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٧٩٧b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨١٠o.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨٠٣h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨٠٢g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٧٩٨c.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨٠٦k.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨٠١f.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٧٩٩d.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨٠٧l.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨١١p.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨١٢q.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨١٣r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨١٤s.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨٠٥j.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨٠٩n.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f١١٢٠٤c[n.g.c.f١١٨٠٠e.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[l0.values().length];
            f١١٢٠٣b = iArr2;
            try {
                iArr2[l0.f١١٢٢١i.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f١١٢٠٣b[l0.f١١٢٢٣k.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f١١٢٠٣b[l0.f١١٢٢٠h.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f١١٢٠٣b[l0.f١١٢١٩g.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f١١٢٠٣b[l0.f١١٢٢٤l.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f١١٢٠٣b[l0.f١١٢١٧e.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f١١٢٠٣b[l0.f١١٢١٨f.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f١١٢٠٣b[l0.f١١٢٢٢j.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f١١٢٠٣b[l0.f١١٢٢٥m.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
            int[] iArr3 = new int[n.h.a.values().length];
            f١١٢٠٢a = iArr3;
            try {
                iArr3[n.h.a.PROTO2.ordinal()] = 1;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f١١٢٠٢a[n.h.a.PROTO3.ordinal()] = 2;
            } catch (NoSuchFieldError unused29) {
            }
        }
    }

    private l() {
    }

    private static Field e(Class cls, int i10) {
        return m(cls, "bitField" + i10 + "_");
    }

    private static a0 f(Class cls, n.g gVar, e eVar, boolean z10, j0.e eVar2) {
        q1 a10 = eVar.a(cls, gVar.k());
        c0 q10 = q(gVar);
        return a0.g(gVar.getNumber(), q10, a10, r(cls, gVar, q10), z10, eVar2);
    }

    private static Field g(Class cls, n.g gVar) {
        return m(cls, n(gVar));
    }

    private static c1 h(Class cls, n.b bVar) {
        int i10 = c.f١١٢٠٢a[bVar.a().n().ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return j(cls, bVar);
            }
            throw new IllegalArgumentException("Unsupported syntax: " + bVar.a().n());
        }
        return i(cls, bVar);
    }

    private static d2 i(Class cls, n.b bVar) {
        j0.e eVar;
        List j10 = bVar.j();
        d2.a e10 = d2.e(j10.size());
        e10.c(o(cls));
        e10.f(t1.PROTO2);
        e10.e(bVar.m().D());
        a aVar = null;
        e eVar2 = new e(aVar);
        Field field = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (i10 < j10.size()) {
            n.g gVar = (n.g) j10.get(i10);
            boolean l02 = gVar.a().k().l0();
            n.g.b q10 = gVar.q();
            n.g.b bVar2 = n.g.b.ENUM;
            if (q10 == bVar2) {
                eVar = new a(gVar);
            } else {
                eVar = aVar;
            }
            if (gVar.k() != null) {
                e10.d(f(cls, gVar, eVar2, l02, eVar));
            } else {
                Field l10 = l(cls, gVar);
                int number = gVar.getNumber();
                c0 q11 = q(gVar);
                if (gVar.w()) {
                    n.g i13 = gVar.r().i(2);
                    if (i13.q() == bVar2) {
                        eVar = new b(i13);
                    }
                    e10.d(a0.f(l10, number, a2.B(cls, gVar.d()), eVar));
                } else if (gVar.isRepeated()) {
                    if (eVar != null) {
                        if (gVar.isPacked()) {
                            e10.d(a0.i(l10, number, q11, eVar, g(cls, gVar)));
                        } else {
                            e10.d(a0.e(l10, number, q11, eVar));
                        }
                    } else if (gVar.q() == n.g.b.MESSAGE) {
                        e10.d(a0.l(l10, number, q11, t(cls, gVar)));
                    } else if (gVar.isPacked()) {
                        e10.d(a0.h(l10, number, q11, g(cls, gVar)));
                    } else {
                        e10.d(a0.d(l10, number, q11, l02));
                    }
                } else {
                    if (field == null) {
                        field = e(cls, i11);
                    }
                    if (gVar.z()) {
                        e10.d(a0.k(l10, number, q11, field, i12, l02, eVar));
                    } else {
                        e10.d(a0.j(l10, number, q11, field, i12, l02, eVar));
                    }
                }
                i10++;
                aVar = null;
            }
            i12 <<= 1;
            if (i12 == 0) {
                i11++;
                field = null;
                i12 = 1;
            }
            i10++;
            aVar = null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i14 = 0; i14 < j10.size(); i14++) {
            n.g gVar2 = (n.g) j10.get(i14);
            if (gVar2.z() || (gVar2.q() == n.g.b.MESSAGE && v(gVar2.r()))) {
                arrayList.add(Integer.valueOf(gVar2.getNumber()));
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            iArr[i15] = ((Integer) arrayList.get(i15)).intValue();
        }
        e10.b(iArr);
        return e10.a();
    }

    private static d2 j(Class cls, n.b bVar) {
        List j10 = bVar.j();
        d2.a e10 = d2.e(j10.size());
        e10.c(o(cls));
        e10.f(t1.PROTO3);
        e eVar = new e(null);
        for (int i10 = 0; i10 < j10.size(); i10++) {
            n.g gVar = (n.g) j10.get(i10);
            if (gVar.k() != null && !gVar.k().n()) {
                e10.d(f(cls, gVar, eVar, true, null));
            } else if (gVar.w()) {
                e10.d(a0.f(l(cls, gVar), gVar.getNumber(), a2.B(cls, gVar.d()), null));
            } else if (gVar.isRepeated() && gVar.q() == n.g.b.MESSAGE) {
                e10.d(a0.l(l(cls, gVar), gVar.getNumber(), q(gVar), t(cls, gVar)));
            } else if (gVar.isPacked()) {
                e10.d(a0.h(l(cls, gVar), gVar.getNumber(), q(gVar), g(cls, gVar)));
            } else {
                e10.d(a0.d(l(cls, gVar), gVar.getNumber(), q(gVar), true));
            }
        }
        return e10.a();
    }

    private static n.b k(Class cls) {
        return o(cls).getDescriptorForType();
    }

    private static Field l(Class cls, n.g gVar) {
        return m(cls, p(gVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field m(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unable to find field " + str + " in message class " + cls.getName());
        }
    }

    private static String n(n.g gVar) {
        return x(gVar.d()) + "MemoizedSerializedSize";
    }

    private static b1 o(Class cls) {
        try {
            return (b1) cls.getDeclaredMethod("getDefaultInstance", null).invoke(null, null);
        } catch (Exception e10) {
            throw new IllegalArgumentException("Unable to get default instance for message class " + cls.getName(), e10);
        }
    }

    static String p(n.g gVar) {
        String d10;
        String str;
        if (gVar.t() == n.g.c.f١١٨٠٦k) {
            d10 = gVar.r().d();
        } else {
            d10 = gVar.d();
        }
        if (f١١١٩٧b.contains(y(d10))) {
            str = "__";
        } else {
            str = "_";
        }
        return x(d10) + str;
    }

    private static c0 q(n.g gVar) {
        switch (c.f١١٢٠٤c[gVar.t().ordinal()]) {
            case 1:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩١٣m;
                }
                if (gVar.isPacked()) {
                    return c0.V;
                }
                return c0.E;
            case 2:
                if (gVar.isRepeated()) {
                    return c0.H;
                }
                return c0.f١٠٩١٦p;
            case 3:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩٠٤f;
                }
                if (gVar.isPacked()) {
                    return c0.O;
                }
                return c0.f١٠٩٢٤x;
            case 4:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩١٨r;
                }
                if (gVar.isPacked()) {
                    return c0.X;
                }
                return c0.J;
            case 5:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩١٢l;
                }
                if (gVar.isPacked()) {
                    return c0.U;
                }
                return c0.D;
            case 6:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩١١k;
                }
                if (gVar.isPacked()) {
                    return c0.T;
                }
                return c0.C;
            case 7:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩٠٦g;
                }
                if (gVar.isPacked()) {
                    return c0.P;
                }
                return c0.f١٠٩٢٥y;
            case 8:
                if (gVar.isRepeated()) {
                    return c0.f١٠٩٠١c0;
                }
                return c0.f١٠٩٢٣w;
            case 9:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩١٠j;
                }
                if (gVar.isPacked()) {
                    return c0.S;
                }
                return c0.f١٠٨٩٨B;
            case 10:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩٠٨h;
                }
                if (gVar.isPacked()) {
                    return c0.Q;
                }
                return c0.f١٠٩٢٦z;
            case 11:
                if (gVar.w()) {
                    return c0.f١٠٩٠٢d0;
                }
                if (gVar.isRepeated()) {
                    return c0.G;
                }
                return c0.f١٠٩١٥o;
            case 12:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩١٩s;
                }
                if (gVar.isPacked()) {
                    return c0.Y;
                }
                return c0.K;
            case 13:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩٢٠t;
                }
                if (gVar.isPacked()) {
                    return c0.Z;
                }
                return c0.L;
            case 14:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩٢١u;
                }
                if (gVar.isPacked()) {
                    return c0.f١٠٨٩٩a0;
                }
                return c0.M;
            case 15:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩٢٢v;
                }
                if (gVar.isPacked()) {
                    return c0.f١٠٩٠٠b0;
                }
                return c0.N;
            case 16:
                if (gVar.isRepeated()) {
                    return c0.F;
                }
                return c0.f١٠٩١٤n;
            case 17:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩١٧q;
                }
                if (gVar.isPacked()) {
                    return c0.W;
                }
                return c0.I;
            case 18:
                if (!gVar.isRepeated()) {
                    return c0.f١٠٩٠٩i;
                }
                if (gVar.isPacked()) {
                    return c0.R;
                }
                return c0.A;
            default:
                throw new IllegalArgumentException("Unsupported field type: " + gVar.t());
        }
    }

    private static Class r(Class cls, n.g gVar, c0 c0Var) {
        switch (c.f١١٢٠٣b[c0Var.c().ordinal()]) {
            case 1:
                return Boolean.class;
            case 2:
                return h.class;
            case 3:
                return Double.class;
            case 4:
                return Float.class;
            case 5:
            case 6:
                return Integer.class;
            case 7:
                return Long.class;
            case 8:
                return String.class;
            case 9:
                return s(cls, gVar);
            default:
                throw new IllegalArgumentException("Invalid type for oneof: " + c0Var);
        }
    }

    private static Class s(Class cls, n.g gVar) {
        String d10;
        try {
            if (gVar.t() == n.g.c.f١١٨٠٦k) {
                d10 = gVar.r().d();
            } else {
                d10 = gVar.d();
            }
            return cls.getDeclaredMethod(u(d10), null).getReturnType();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    private static Class t(Class cls, n.g gVar) {
        String d10;
        try {
            if (gVar.t() == n.g.c.f١١٨٠٦k) {
                d10 = gVar.r().d();
            } else {
                d10 = gVar.d();
            }
            return cls.getDeclaredMethod(u(d10), Integer.TYPE).getReturnType();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    private static String u(String str) {
        String x10 = x(str);
        return "get" + Character.toUpperCase(x10.charAt(0)) + x10.substring(1, x10.length());
    }

    private static boolean v(n.b bVar) {
        return f١١١٩٨c.c(bVar);
    }

    private static String w(String str, boolean z10) {
        StringBuilder sb = new StringBuilder(str.length() + 1);
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != '_') {
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else {
                    if (z10) {
                        sb.append(Character.toUpperCase(charAt));
                        z10 = false;
                    } else if (i10 == 0) {
                        sb.append(Character.toLowerCase(charAt));
                    } else {
                        sb.append(charAt);
                    }
                }
            }
            z10 = true;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String x(String str) {
        return w(str, false);
    }

    private static String y(String str) {
        return w(str, true);
    }

    @Override // com.google.protobuf.d1
    public c1 a(Class cls) {
        if (h0.class.isAssignableFrom(cls)) {
            return h(cls, k(cls));
        }
        throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
    }

    @Override // com.google.protobuf.d1
    public boolean b(Class cls) {
        return h0.class.isAssignableFrom(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final Map f١١٢٠٥a = new ConcurrentHashMap();

        /* renamed from: b, reason: collision with root package name */
        private int f١١٢٠٦b = 0;

        /* renamed from: c, reason: collision with root package name */
        private final Stack f١١٢٠٧c = new Stack();

        /* renamed from: d, reason: collision with root package name */
        private final Map f١١٢٠٨d = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            final n.b f١١٢٠٩a;

            /* renamed from: b, reason: collision with root package name */
            final int f١١٢١٠b;

            /* renamed from: c, reason: collision with root package name */
            int f١١٢١١c;

            /* renamed from: d, reason: collision with root package name */
            b f١١٢١٢d = null;

            a(n.b bVar, int i10) {
                this.f١١٢٠٩a = bVar;
                this.f١١٢١٠b = i10;
                this.f١١٢١١c = i10;
            }
        }

        d() {
        }

        private void a(b bVar) {
            boolean z10;
            b bVar2;
            Iterator it = bVar.f١١٢١٣a.iterator();
            loop0: while (true) {
                if (it.hasNext()) {
                    n.b bVar3 = (n.b) it.next();
                    z10 = true;
                    if (bVar3.n()) {
                        break;
                    }
                    for (n.g gVar : bVar3.j()) {
                        if (gVar.z() || (gVar.q() == n.g.b.MESSAGE && (bVar2 = ((a) this.f١١٢٠٨d.get(gVar.r())).f١١٢١٢d) != bVar && bVar2.f١١٢١٤b)) {
                            break loop0;
                        }
                    }
                } else {
                    z10 = false;
                    break;
                }
            }
            bVar.f١١٢١٤b = z10;
            Iterator it2 = bVar.f١١٢١٣a.iterator();
            while (it2.hasNext()) {
                this.f١١٢٠٥a.put((n.b) it2.next(), Boolean.valueOf(bVar.f١١٢١٤b));
            }
        }

        private a b(n.b bVar) {
            a aVar;
            int i10 = this.f١١٢٠٦b;
            this.f١١٢٠٦b = i10 + 1;
            a aVar2 = new a(bVar, i10);
            this.f١١٢٠٧c.push(aVar2);
            this.f١١٢٠٨d.put(bVar, aVar2);
            for (n.g gVar : bVar.j()) {
                if (gVar.q() == n.g.b.MESSAGE) {
                    a aVar3 = (a) this.f١١٢٠٨d.get(gVar.r());
                    if (aVar3 == null) {
                        aVar2.f١١٢١١c = Math.min(aVar2.f١١٢١١c, b(gVar.r()).f١١٢١١c);
                    } else if (aVar3.f١١٢١٢d == null) {
                        aVar2.f١١٢١١c = Math.min(aVar2.f١١٢١١c, aVar3.f١١٢١١c);
                    }
                }
            }
            if (aVar2.f١١٢١٠b == aVar2.f١١٢١١c) {
                b bVar2 = new b(null);
                do {
                    aVar = (a) this.f١١٢٠٧c.pop();
                    aVar.f١١٢١٢d = bVar2;
                    bVar2.f١١٢١٣a.add(aVar.f١١٢٠٩a);
                } while (aVar != aVar2);
                a(bVar2);
            }
            return aVar2;
        }

        public boolean c(n.b bVar) {
            Boolean bool = (Boolean) this.f١١٢٠٥a.get(bVar);
            if (bool != null) {
                return bool.booleanValue();
            }
            synchronized (this) {
                try {
                    Boolean bool2 = (Boolean) this.f١١٢٠٥a.get(bVar);
                    if (bool2 != null) {
                        return bool2.booleanValue();
                    }
                    return b(bVar).f١١٢١٢d.f١١٢١٤b;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            final List f١١٢١٣a;

            /* renamed from: b, reason: collision with root package name */
            boolean f١١٢١٤b;

            private b() {
                this.f١١٢١٣a = new ArrayList();
                this.f١١٢١٤b = false;
            }

            /* synthetic */ b(a aVar) {
                this();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private q1[] f١١٢١٥a;

        private e() {
            this.f١١٢١٥a = new q1[2];
        }

        private static q1 b(Class cls, n.l lVar) {
            String x10 = l.x(lVar.d());
            return new q1(lVar.m(), l.m(cls, x10 + "Case_"), l.m(cls, x10 + "_"));
        }

        q1 a(Class cls, n.l lVar) {
            int m10 = lVar.m();
            q1[] q1VarArr = this.f١١٢١٥a;
            if (m10 >= q1VarArr.length) {
                this.f١١٢١٥a = (q1[]) Arrays.copyOf(q1VarArr, m10 * 2);
            }
            q1 q1Var = this.f١١٢١٥a[m10];
            if (q1Var == null) {
                q1 b10 = b(cls, lVar);
                this.f١١٢١٥a[m10] = b10;
                return b10;
            }
            return q1Var;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }
}
