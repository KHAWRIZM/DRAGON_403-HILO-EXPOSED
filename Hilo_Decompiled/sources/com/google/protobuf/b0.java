package com.google.protobuf;

import com.google.protobuf.e1;
import com.google.protobuf.j0;
import com.google.protobuf.m0;
import com.google.protobuf.r2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b0 {

    /* renamed from: d, reason: collision with root package name */
    private static final b0 f١٠٨٨٤d = new b0(true);

    /* renamed from: a, reason: collision with root package name */
    private final c2 f١٠٨٨٥a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٠٨٨٦b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٠٨٨٧c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٠٨٨٨a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f١٠٨٨٩b;

        static {
            int[] iArr = new int[r2.b.values().length];
            f١٠٨٨٩b = iArr;
            try {
                iArr[r2.b.f١١٩١٤c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩١٥d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩١٦e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩١٧f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩١٨g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩١٩h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٢٠i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٢١j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٢٣l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٢٤m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٢٢k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٢٥n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٢٦o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٢٨q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٢٩r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٣٠s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٣١t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f١٠٨٨٩b[r2.b.f١١٩٢٧p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[r2.c.values().length];
            f١٠٨٨٨a = iArr2;
            try {
                iArr2[r2.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f١٠٨٨٨a[r2.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f١٠٨٨٨a[r2.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f١٠٨٨٨a[r2.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f١٠٨٨٨a[r2.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f١٠٨٨٨a[r2.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f١٠٨٨٨a[r2.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f١٠٨٨٨a[r2.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f١٠٨٨٨a[r2.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private c2 f١٠٨٩٠a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f١٠٨٩١b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١٠٨٩٢c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١٠٨٩٣d;

        /* synthetic */ b(a aVar) {
            this();
        }

        private b0 c(boolean z10) {
            if (this.f١٠٨٩٠a.isEmpty()) {
                return b0.o();
            }
            this.f١٠٨٩٢c = false;
            c2 c2Var = this.f١٠٨٩٠a;
            if (this.f١٠٨٩٣d) {
                c2Var = b0.i(c2Var, false);
                s(c2Var, z10);
            }
            b0 b0Var = new b0(c2Var, null);
            b0Var.f١٠٨٨٧c = this.f١٠٨٩١b;
            return b0Var;
        }

        private void f() {
            if (!this.f١٠٨٩٢c) {
                this.f١٠٨٩٠a = b0.i(this.f١٠٨٩٠a, true);
                this.f١٠٨٩٢c = true;
            }
        }

        private void p(Map.Entry entry) {
            c cVar = (c) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof m0) {
                value = ((m0) value).d();
            }
            if (cVar.isRepeated()) {
                List list = (List) i(cVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f١٠٨٩٠a.r(cVar, list);
                }
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    list.add(b0.k(it.next()));
                }
                return;
            }
            if (cVar.getLiteJavaType() == r2.c.MESSAGE) {
                Object i10 = i(cVar);
                if (i10 == null) {
                    this.f١٠٨٩٠a.r(cVar, b0.k(value));
                    return;
                } else if (i10 instanceof e1.a) {
                    cVar.b((e1.a) i10, (e1) value);
                    return;
                } else {
                    this.f١٠٨٩٠a.r(cVar, cVar.b(((e1) i10).toBuilder(), (e1) value).build());
                    return;
                }
            }
            this.f١٠٨٩٠a.r(cVar, b0.k(value));
        }

        private static Object q(Object obj, boolean z10) {
            if (!(obj instanceof e1.a)) {
                return obj;
            }
            e1.a aVar = (e1.a) obj;
            if (z10) {
                return aVar.buildPartial();
            }
            return aVar.build();
        }

        private static Object r(c cVar, Object obj, boolean z10) {
            if (obj == null) {
                return obj;
            }
            if (cVar.getLiteJavaType() == r2.c.MESSAGE) {
                if (cVar.isRepeated()) {
                    if (obj instanceof List) {
                        List list = (List) obj;
                        for (int i10 = 0; i10 < list.size(); i10++) {
                            Object obj2 = list.get(i10);
                            Object q10 = q(obj2, z10);
                            if (q10 != obj2) {
                                if (list == obj) {
                                    list = new ArrayList(list);
                                }
                                list.set(i10, q10);
                            }
                        }
                        return list;
                    }
                    throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + obj.getClass());
                }
                return q(obj, z10);
            }
            return obj;
        }

        private static void s(c2 c2Var, boolean z10) {
            for (int i10 = 0; i10 < c2Var.k(); i10++) {
                t(c2Var.j(i10), z10);
            }
            Iterator it = c2Var.m().iterator();
            while (it.hasNext()) {
                t((Map.Entry) it.next(), z10);
            }
        }

        private static void t(Map.Entry entry, boolean z10) {
            entry.setValue(r((c) entry.getKey(), entry.getValue(), z10));
        }

        private void w(c cVar, Object obj) {
            if (!b0.D(cVar.getLiteType(), obj)) {
                if (cVar.getLiteType().c() == r2.c.MESSAGE && (obj instanceof e1.a)) {
                } else {
                    throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(cVar.getNumber()), cVar.getLiteType().c(), obj.getClass().getName()));
                }
            }
        }

        public void a(c cVar, Object obj) {
            boolean z10;
            List list;
            f();
            if (cVar.isRepeated()) {
                if (!this.f١٠٨٩٣d && !(obj instanceof e1.a)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                this.f١٠٨٩٣d = z10;
                w(cVar, obj);
                Object i10 = i(cVar);
                if (i10 == null) {
                    list = new ArrayList();
                    this.f١٠٨٩٠a.r(cVar, list);
                } else {
                    list = (List) i10;
                }
                list.add(obj);
                return;
            }
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }

        public b0 b() {
            return c(false);
        }

        public b0 d() {
            return c(true);
        }

        public void e(c cVar) {
            f();
            this.f١٠٨٩٠a.remove(cVar);
            if (this.f١٠٨٩٠a.isEmpty()) {
                this.f١٠٨٩١b = false;
            }
        }

        public Map g() {
            if (this.f١٠٨٩١b) {
                c2 i10 = b0.i(this.f١٠٨٩٠a, false);
                if (this.f١٠٨٩٠a.o()) {
                    i10.p();
                } else {
                    s(i10, true);
                }
                return i10;
            }
            if (this.f١٠٨٩٠a.o()) {
                return this.f١٠٨٩٠a;
            }
            return Collections.unmodifiableMap(this.f١٠٨٩٠a);
        }

        public Object h(c cVar) {
            return r(cVar, i(cVar), true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Object i(c cVar) {
            Object obj = this.f١٠٨٩٠a.get(cVar);
            if (obj instanceof m0) {
                return ((m0) obj).d();
            }
            return obj;
        }

        public Object j(c cVar, int i10) {
            if (this.f١٠٨٩٣d) {
                f();
            }
            return q(k(cVar, i10), true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Object k(c cVar, int i10) {
            if (cVar.isRepeated()) {
                Object i11 = i(cVar);
                if (i11 != null) {
                    return ((List) i11).get(i10);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public int l(c cVar) {
            if (cVar.isRepeated()) {
                Object i10 = i(cVar);
                if (i10 == null) {
                    return 0;
                }
                return ((List) i10).size();
            }
            throw new IllegalArgumentException("getRepeatedFieldCount() can only be called on repeated fields.");
        }

        public boolean m(c cVar) {
            if (!cVar.isRepeated()) {
                if (this.f١٠٨٩٠a.get(cVar) != null) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public boolean n() {
            for (int i10 = 0; i10 < this.f١٠٨٩٠a.k(); i10++) {
                if (!b0.B(this.f١٠٨٩٠a.j(i10))) {
                    return false;
                }
            }
            Iterator it = this.f١٠٨٩٠a.m().iterator();
            while (it.hasNext()) {
                if (!b0.B((Map.Entry) it.next())) {
                    return false;
                }
            }
            return true;
        }

        public void o(b0 b0Var) {
            f();
            for (int i10 = 0; i10 < b0Var.f١٠٨٨٥a.k(); i10++) {
                p(b0Var.f١٠٨٨٥a.j(i10));
            }
            Iterator it = b0Var.f١٠٨٨٥a.m().iterator();
            while (it.hasNext()) {
                p((Map.Entry) it.next());
            }
        }

        public void u(c cVar, Object obj) {
            boolean z10;
            f();
            boolean z11 = false;
            if (cVar.isRepeated()) {
                if (obj instanceof List) {
                    ArrayList arrayList = new ArrayList((List) obj);
                    for (Object obj2 : arrayList) {
                        w(cVar, obj2);
                        if (!this.f١٠٨٩٣d && !(obj2 instanceof e1.a)) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        this.f١٠٨٩٣d = z10;
                    }
                    obj = arrayList;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            } else {
                w(cVar, obj);
            }
            if (obj instanceof m0) {
                this.f١٠٨٩١b = true;
            }
            if (this.f١٠٨٩٣d || (obj instanceof e1.a)) {
                z11 = true;
            }
            this.f١٠٨٩٣d = z11;
            this.f١٠٨٩٠a.r(cVar, obj);
        }

        public void v(c cVar, int i10, Object obj) {
            boolean z10;
            f();
            if (cVar.isRepeated()) {
                if (!this.f١٠٨٩٣d && !(obj instanceof e1.a)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                this.f١٠٨٩٣d = z10;
                Object i11 = i(cVar);
                if (i11 != null) {
                    w(cVar, obj);
                    ((List) i11).set(i10, obj);
                    return;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        private b() {
            this(c2.q(16));
        }

        private b(c2 c2Var) {
            this.f١٠٨٩٠a = c2Var;
            this.f١٠٨٩٢c = true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c extends Comparable {
        e1.a b(e1.a aVar, e1 e1Var);

        r2.c getLiteJavaType();

        r2.b getLiteType();

        int getNumber();

        boolean isPacked();

        boolean isRepeated();
    }

    /* synthetic */ b0(c2 c2Var, a aVar) {
        this(c2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean B(Map.Entry entry) {
        c cVar = (c) entry.getKey();
        if (cVar.getLiteJavaType() == r2.c.MESSAGE) {
            if (cVar.isRepeated()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!C(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            return C(entry.getValue());
        }
        return true;
    }

    private static boolean C(Object obj) {
        if (obj instanceof f1) {
            return ((f1) obj).isInitialized();
        }
        if (obj instanceof m0) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean D(r2.b bVar, Object obj) {
        j0.a(obj);
        switch (a.f١٠٨٨٨a[bVar.c().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                if ((obj instanceof h) || (obj instanceof byte[])) {
                    return true;
                }
                return false;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof j0.c)) {
                    return true;
                }
                return false;
            case 9:
                if ((obj instanceof e1) || (obj instanceof m0)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    private void H(Map.Entry entry) {
        c cVar = (c) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof m0) {
            value = ((m0) value).d();
        }
        if (cVar.isRepeated()) {
            Object q10 = q(cVar);
            if (q10 == null) {
                q10 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) q10).add(k(it.next()));
            }
            this.f١٠٨٨٥a.r(cVar, q10);
            return;
        }
        if (cVar.getLiteJavaType() == r2.c.MESSAGE) {
            Object q11 = q(cVar);
            if (q11 == null) {
                this.f١٠٨٨٥a.r(cVar, k(value));
                return;
            } else {
                this.f١٠٨٨٥a.r(cVar, cVar.b(((e1) q11).toBuilder(), (e1) value).build());
                return;
            }
        }
        this.f١٠٨٨٥a.r(cVar, k(value));
    }

    public static b I() {
        return new b((a) null);
    }

    public static b0 J() {
        return new b0();
    }

    private void L(c cVar, Object obj) {
        if (D(cVar.getLiteType(), obj)) {
        } else {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(cVar.getNumber()), cVar.getLiteType().c(), obj.getClass().getName()));
        }
    }

    static void M(k kVar, r2.b bVar, int i10, Object obj) {
        if (bVar == r2.b.f١١٩٢٣l) {
            kVar.B0(i10, (e1) obj);
        } else {
            kVar.R0(i10, w(bVar, false));
            N(kVar, bVar, obj);
        }
    }

    static void N(k kVar, r2.b bVar, Object obj) {
        switch (a.f١٠٨٨٩b[bVar.ordinal()]) {
            case 1:
                kVar.s0(((Double) obj).doubleValue());
                return;
            case 2:
                kVar.A0(((Float) obj).floatValue());
                return;
            case 3:
                kVar.G0(((Long) obj).longValue());
                return;
            case 4:
                kVar.V0(((Long) obj).longValue());
                return;
            case 5:
                kVar.E0(((Integer) obj).intValue());
                return;
            case 6:
                kVar.y0(((Long) obj).longValue());
                return;
            case 7:
                kVar.w0(((Integer) obj).intValue());
                return;
            case 8:
                kVar.m0(((Boolean) obj).booleanValue());
                return;
            case 9:
                kVar.C0((e1) obj);
                return;
            case 10:
                kVar.I0((e1) obj);
                return;
            case 11:
                if (obj instanceof h) {
                    kVar.q0((h) obj);
                    return;
                } else {
                    kVar.Q0((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof h) {
                    kVar.q0((h) obj);
                    return;
                } else {
                    kVar.n0((byte[]) obj);
                    return;
                }
            case 13:
                kVar.T0(((Integer) obj).intValue());
                return;
            case 14:
                kVar.L0(((Integer) obj).intValue());
                return;
            case 15:
                kVar.M0(((Long) obj).longValue());
                return;
            case 16:
                kVar.N0(((Integer) obj).intValue());
                return;
            case 17:
                kVar.O0(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof j0.c) {
                    kVar.u0(((j0.c) obj).getNumber());
                    return;
                } else {
                    kVar.u0(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void O(c cVar, Object obj, k kVar) {
        r2.b liteType = cVar.getLiteType();
        int number = cVar.getNumber();
        if (cVar.isRepeated()) {
            List list = (List) obj;
            if (cVar.isPacked()) {
                kVar.R0(number, 2);
                Iterator it = list.iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    i10 += m(liteType, it.next());
                }
                kVar.T0(i10);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    N(kVar, liteType, it2.next());
                }
                return;
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                M(kVar, liteType, number, it3.next());
            }
            return;
        }
        if (obj instanceof m0) {
            M(kVar, liteType, number, ((m0) obj).d());
        } else {
            M(kVar, liteType, number, obj);
        }
    }

    private void Q(Map.Entry entry, k kVar) {
        c cVar = (c) entry.getKey();
        if (cVar.getLiteJavaType() == r2.c.MESSAGE && !cVar.isRepeated() && !cVar.isPacked()) {
            Object value = entry.getValue();
            if (value instanceof m0) {
                value = ((m0) value).d();
            }
            kVar.J0(((c) entry.getKey()).getNumber(), (e1) value);
            return;
        }
        O(cVar, entry.getValue(), kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c2 i(c2 c2Var, boolean z10) {
        c2 q10 = c2.q(16);
        for (int i10 = 0; i10 < c2Var.k(); i10++) {
            j(q10, c2Var.j(i10), z10);
        }
        Iterator it = c2Var.m().iterator();
        while (it.hasNext()) {
            j(q10, (Map.Entry) it.next(), z10);
        }
        return q10;
    }

    private static void j(Map map, Map.Entry entry, boolean z10) {
        c cVar = (c) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof m0) {
            map.put(cVar, ((m0) value).d());
        } else if (z10 && (value instanceof List)) {
            map.put(cVar, new ArrayList((List) value));
        } else {
            map.put(cVar, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object k(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    static int l(r2.b bVar, int i10, Object obj) {
        int W = k.W(i10);
        if (bVar == r2.b.f١١٩٢٣l) {
            W *= 2;
        }
        return W + m(bVar, obj);
    }

    static int m(r2.b bVar, Object obj) {
        switch (a.f١٠٨٨٩b[bVar.ordinal()]) {
            case 1:
                return k.k(((Double) obj).doubleValue());
            case 2:
                return k.s(((Float) obj).floatValue());
            case 3:
                return k.A(((Long) obj).longValue());
            case 4:
                return k.a0(((Long) obj).longValue());
            case 5:
                return k.y(((Integer) obj).intValue());
            case 6:
                return k.q(((Long) obj).longValue());
            case 7:
                return k.o(((Integer) obj).intValue());
            case 8:
                return k.f(((Boolean) obj).booleanValue());
            case 9:
                return k.v((e1) obj);
            case 10:
                if (obj instanceof m0) {
                    return k.D((m0) obj);
                }
                return k.I((e1) obj);
            case 11:
                if (obj instanceof h) {
                    return k.i((h) obj);
                }
                return k.V((String) obj);
            case 12:
                if (obj instanceof h) {
                    return k.i((h) obj);
                }
                return k.g((byte[]) obj);
            case 13:
                return k.Y(((Integer) obj).intValue());
            case 14:
                return k.N(((Integer) obj).intValue());
            case 15:
                return k.P(((Long) obj).longValue());
            case 16:
                return k.R(((Integer) obj).intValue());
            case 17:
                return k.T(((Long) obj).longValue());
            case 18:
                if (obj instanceof j0.c) {
                    return k.m(((j0.c) obj).getNumber());
                }
                return k.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int n(c cVar, Object obj) {
        r2.b liteType = cVar.getLiteType();
        int number = cVar.getNumber();
        if (cVar.isRepeated()) {
            int i10 = 0;
            if (cVar.isPacked()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i10 += m(liteType, it.next());
                }
                return k.W(number) + i10 + k.Y(i10);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i10 += l(liteType, number, it2.next());
            }
            return i10;
        }
        return l(liteType, number, obj);
    }

    public static b0 o() {
        return f١٠٨٨٤d;
    }

    private int s(Map.Entry entry) {
        c cVar = (c) entry.getKey();
        Object value = entry.getValue();
        if (cVar.getLiteJavaType() == r2.c.MESSAGE && !cVar.isRepeated() && !cVar.isPacked()) {
            if (value instanceof m0) {
                return k.B(((c) entry.getKey()).getNumber(), (m0) value);
            }
            return k.F(((c) entry.getKey()).getNumber(), (e1) value);
        }
        return n(cVar, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(r2.b bVar, boolean z10) {
        if (z10) {
            return 2;
        }
        return bVar.d();
    }

    public boolean A() {
        for (int i10 = 0; i10 < this.f١٠٨٨٥a.k(); i10++) {
            if (!B(this.f١٠٨٨٥a.j(i10))) {
                return false;
            }
        }
        Iterator it = this.f١٠٨٨٥a.m().iterator();
        while (it.hasNext()) {
            if (!B((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator E() {
        if (this.f١٠٨٨٧c) {
            return new m0.c(this.f١٠٨٨٥a.entrySet().iterator());
        }
        return this.f١٠٨٨٥a.entrySet().iterator();
    }

    public void F() {
        if (this.f١٠٨٨٦b) {
            return;
        }
        for (int i10 = 0; i10 < this.f١٠٨٨٥a.k(); i10++) {
            this.f١٠٨٨٥a.j(i10).getValue();
        }
        this.f١٠٨٨٥a.p();
        this.f١٠٨٨٦b = true;
    }

    public void G(b0 b0Var) {
        for (int i10 = 0; i10 < b0Var.f١٠٨٨٥a.k(); i10++) {
            H(b0Var.f١٠٨٨٥a.j(i10));
        }
        Iterator it = b0Var.f١٠٨٨٥a.m().iterator();
        while (it.hasNext()) {
            H((Map.Entry) it.next());
        }
    }

    public void K(c cVar, Object obj) {
        if (cVar.isRepeated()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    L(cVar, it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            L(cVar, obj);
        }
        if (obj instanceof m0) {
            this.f١٠٨٨٧c = true;
        }
        this.f١٠٨٨٥a.r(cVar, obj);
    }

    public void P(k kVar) {
        for (int i10 = 0; i10 < this.f١٠٨٨٥a.k(); i10++) {
            Q(this.f١٠٨٨٥a.j(i10), kVar);
        }
        Iterator it = this.f١٠٨٨٥a.m().iterator();
        while (it.hasNext()) {
            Q((Map.Entry) it.next(), kVar);
        }
    }

    public void R(k kVar) {
        for (int i10 = 0; i10 < this.f١٠٨٨٥a.k(); i10++) {
            Map.Entry j10 = this.f١٠٨٨٥a.j(i10);
            O((c) j10.getKey(), j10.getValue(), kVar);
        }
        for (Map.Entry entry : this.f١٠٨٨٥a.m()) {
            O((c) entry.getKey(), entry.getValue(), kVar);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        return this.f١٠٨٨٥a.equals(((b0) obj).f١٠٨٨٥a);
    }

    public void g(c cVar, Object obj) {
        List list;
        if (cVar.isRepeated()) {
            L(cVar, obj);
            Object q10 = q(cVar);
            if (q10 == null) {
                list = new ArrayList();
                this.f١٠٨٨٥a.r(cVar, list);
            } else {
                list = (List) q10;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public b0 clone() {
        b0 J = J();
        for (int i10 = 0; i10 < this.f١٠٨٨٥a.k(); i10++) {
            Map.Entry j10 = this.f١٠٨٨٥a.j(i10);
            J.K((c) j10.getKey(), j10.getValue());
        }
        for (Map.Entry entry : this.f١٠٨٨٥a.m()) {
            J.K((c) entry.getKey(), entry.getValue());
        }
        J.f١٠٨٨٧c = this.f١٠٨٨٧c;
        return J;
    }

    public int hashCode() {
        return this.f١٠٨٨٥a.hashCode();
    }

    public Map p() {
        if (this.f١٠٨٨٧c) {
            c2 i10 = i(this.f١٠٨٨٥a, false);
            if (this.f١٠٨٨٥a.o()) {
                i10.p();
            }
            return i10;
        }
        if (this.f١٠٨٨٥a.o()) {
            return this.f١٠٨٨٥a;
        }
        return Collections.unmodifiableMap(this.f١٠٨٨٥a);
    }

    public Object q(c cVar) {
        Object obj = this.f١٠٨٨٥a.get(cVar);
        if (obj instanceof m0) {
            return ((m0) obj).d();
        }
        return obj;
    }

    public int r() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f١٠٨٨٥a.k(); i11++) {
            i10 += s(this.f١٠٨٨٥a.j(i11));
        }
        Iterator it = this.f١٠٨٨٥a.m().iterator();
        while (it.hasNext()) {
            i10 += s((Map.Entry) it.next());
        }
        return i10;
    }

    public Object t(c cVar, int i10) {
        if (cVar.isRepeated()) {
            Object q10 = q(cVar);
            if (q10 != null) {
                return ((List) q10).get(i10);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int u(c cVar) {
        if (cVar.isRepeated()) {
            Object q10 = q(cVar);
            if (q10 == null) {
                return 0;
            }
            return ((List) q10).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int v() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f١٠٨٨٥a.k(); i11++) {
            Map.Entry j10 = this.f١٠٨٨٥a.j(i11);
            i10 += n((c) j10.getKey(), j10.getValue());
        }
        for (Map.Entry entry : this.f١٠٨٨٥a.m()) {
            i10 += n((c) entry.getKey(), entry.getValue());
        }
        return i10;
    }

    public boolean x(c cVar) {
        if (!cVar.isRepeated()) {
            if (this.f١٠٨٨٥a.get(cVar) != null) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        return this.f١٠٨٨٥a.isEmpty();
    }

    public boolean z() {
        return this.f١٠٨٨٦b;
    }

    private b0() {
        this.f١٠٨٨٥a = c2.q(16);
    }

    private b0(boolean z10) {
        this(c2.q(0));
        F();
    }

    private b0(c2 c2Var) {
        this.f١٠٨٨٥a = c2Var;
        F();
    }
}
