package com.google.protobuf;

import com.google.protobuf.j0;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class a2 {

    /* renamed from: a, reason: collision with root package name */
    private static final Class f١٠٨٧٩a = A();

    /* renamed from: b, reason: collision with root package name */
    private static final j2 f١٠٨٨٠b = C(false);

    /* renamed from: c, reason: collision with root package name */
    private static final j2 f١٠٨٨١c = C(true);

    /* renamed from: d, reason: collision with root package name */
    private static final j2 f١٠٨٨٢d = new m2();

    private static Class A() {
        try {
            boolean z10 = h0.alwaysUseFieldBuilders;
            return h0.class;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object B(Class cls, String str) {
        try {
            Field[] declaredFields = Class.forName(cls.getName() + "$" + L(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return p2.H(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private static j2 C(boolean z10) {
        try {
            Class D = D();
            if (D == null) {
                return null;
            }
            return (j2) D.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z10));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class D() {
        return n2.class;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void E(w wVar, Object obj, Object obj2) {
        b0 b10 = wVar.b(obj2);
        if (!b10.y()) {
            wVar.c(obj).G(b10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void F(x0 x0Var, Object obj, Object obj2, long j10) {
        p2.X(obj, j10, x0Var.a(p2.G(obj, j10), p2.G(obj2, j10)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void G(j2 j2Var, Object obj, Object obj2) {
        j2Var.p(obj, j2Var.k(j2Var.g(obj), j2Var.g(obj2)));
    }

    public static j2 H() {
        return f١٠٨٨٠b;
    }

    public static j2 I() {
        return f١٠٨٨١c;
    }

    public static void J(Class cls) {
        Class cls2;
        if (!g0.class.isAssignableFrom(cls) && (cls2 = f١٠٨٧٩a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object K(Object obj, int i10, int i11, Object obj2, j2 j2Var) {
        if (obj2 == null) {
            obj2 = j2Var.f(obj);
        }
        j2Var.e(obj2, i10, i11);
        return obj2;
    }

    static String L(String str, boolean z10) {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if ('a' <= charAt && charAt <= 'z') {
                if (z10) {
                    sb.append((char) (charAt - ' '));
                } else {
                    sb.append(charAt);
                }
            } else if ('A' <= charAt && charAt <= 'Z') {
                if (i10 == 0 && !z10) {
                    sb.append((char) (charAt + ' '));
                } else {
                    sb.append(charAt);
                }
            } else {
                if ('0' <= charAt && charAt <= '9') {
                    sb.append(charAt);
                }
                z10 = true;
            }
            z10 = false;
        }
        return sb.toString();
    }

    public static j2 M() {
        return f١٠٨٨٢d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z10) {
            return k.W(i10) + k.E(size);
        }
        return size * k.e(i10, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int W = size * k.W(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            W += k.i((h) list.get(i11));
        }
        return W;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e10 = e(list);
        if (z10) {
            return k.W(i10) + k.E(e10);
        }
        return e10 + (size * k.W(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += k.m(i0Var.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += k.m(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z10) {
            return k.W(i10) + k.E(size * 4);
        }
        return size * k.n(i10, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z10) {
            return k.W(i10) + k.E(size * 8);
        }
        return size * k.p(i10, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i10, List list, y1 y1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += k.u(i10, (e1) list.get(i12), y1Var);
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l10 = l(list);
        if (z10) {
            return k.W(i10) + k.E(l10);
        }
        return l10 + (size * k.W(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += k.y(i0Var.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += k.y(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i10, List list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        int n10 = n(list);
        if (z10) {
            return k.W(i10) + k.E(n10);
        }
        return n10 + (list.size() * k.W(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += k.A(r0Var.getLong(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += k.A(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(int i10, Object obj, y1 y1Var) {
        if (obj instanceof n0) {
            return k.C(i10, (n0) obj);
        }
        return k.H(i10, (e1) obj, y1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i10, List list, y1 y1Var) {
        int J;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int W = k.W(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof n0) {
                J = k.D((n0) obj);
            } else {
                J = k.J((e1) obj, y1Var);
            }
            W += J;
        }
        return W;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r10 = r(list);
        if (z10) {
            return k.W(i10) + k.E(r10);
        }
        return r10 + (size * k.W(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += k.R(i0Var.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += k.R(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t10 = t(list);
        if (z10) {
            return k.W(i10) + k.E(t10);
        }
        return t10 + (size * k.W(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += k.T(r0Var.getLong(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += k.T(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i10, List list) {
        int V;
        int V2;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int W = k.W(i10) * size;
        if (list instanceof p0) {
            p0 p0Var = (p0) list;
            while (i11 < size) {
                Object S = p0Var.S(i11);
                if (S instanceof h) {
                    V2 = k.i((h) S);
                } else {
                    V2 = k.V((String) S);
                }
                W += V2;
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                if (obj instanceof h) {
                    V = k.i((h) obj);
                } else {
                    V = k.V((String) obj);
                }
                W += V;
                i11++;
            }
        }
        return W;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w10 = w(list);
        if (z10) {
            return k.W(i10) + k.E(w10);
        }
        return w10 + (size * k.W(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += k.Y(i0Var.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += k.Y(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y10 = y(list);
        if (z10) {
            return k.W(i10) + k.E(y10);
        }
        return y10 + (size * k.W(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            i10 = 0;
            while (i11 < size) {
                i10 += k.a0(r0Var.getLong(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += k.a0(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object z(Object obj, int i10, List list, j0.e eVar, Object obj2, j2 j2Var) {
        if (eVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Integer num = (Integer) list.get(i12);
                int intValue = num.intValue();
                if (eVar.a(intValue)) {
                    if (i12 != i11) {
                        list.set(i11, num);
                    }
                    i11++;
                } else {
                    obj2 = K(obj, i10, intValue, obj2, j2Var);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!eVar.a(intValue2)) {
                    obj2 = K(obj, i10, intValue2, obj2, j2Var);
                    it.remove();
                }
            }
        }
        return obj2;
    }
}
