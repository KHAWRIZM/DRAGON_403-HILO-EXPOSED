package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class z0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Class f٣٥٣٨a = A();

    /* renamed from: b, reason: collision with root package name */
    private static final e1 f٣٥٣٩b = B();

    /* renamed from: c, reason: collision with root package name */
    private static final e1 f٣٥٤٠c = new g1();

    private static Class A() {
        if (t0.f٣٥٠٥d) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static e1 B() {
        try {
            Class C = C();
            if (C == null) {
                return null;
            }
            return (e1) C.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class C() {
        if (t0.f٣٥٠٥d) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void D(n nVar, Object obj, Object obj2) {
        q c10 = nVar.c(obj2);
        if (!c10.j()) {
            nVar.d(obj).p(c10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void E(e0 e0Var, Object obj, Object obj2, long j10) {
        h1.O(obj, j10, e0Var.a(h1.z(obj, j10), h1.z(obj2, j10)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void F(e1 e1Var, Object obj, Object obj2) {
        e1Var.p(obj, e1Var.k(e1Var.g(obj), e1Var.g(obj2)));
    }

    public static void G(Class cls) {
        Class cls2;
        if (!t.class.isAssignableFrom(cls) && !t0.f٣٥٠٥d && (cls2 = f٣٥٣٨a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean H(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    static Object I(Object obj, int i10, int i11, Object obj2, e1 e1Var) {
        if (obj2 == null) {
            obj2 = e1Var.f(obj);
        }
        e1Var.e(obj2, i10, i11);
        return obj2;
    }

    public static e1 J() {
        return f٣٥٣٩b;
    }

    public static e1 K() {
        return f٣٥٤٠c;
    }

    public static void L(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.G(i10, list, z10);
        }
    }

    public static void M(int i10, List list, k1 k1Var) {
        if (list != null && !list.isEmpty()) {
            k1Var.O(i10, list);
        }
    }

    public static void N(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.M(i10, list, z10);
        }
    }

    public static void O(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.q(i10, list, z10);
        }
    }

    public static void P(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.l(i10, list, z10);
        }
    }

    public static void Q(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.E(i10, list, z10);
        }
    }

    public static void R(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.a(i10, list, z10);
        }
    }

    public static void S(int i10, List list, k1 k1Var, x0 x0Var) {
        if (list != null && !list.isEmpty()) {
            k1Var.e(i10, list, x0Var);
        }
    }

    public static void T(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.h(i10, list, z10);
        }
    }

    public static void U(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.L(i10, list, z10);
        }
    }

    public static void V(int i10, List list, k1 k1Var, x0 x0Var) {
        if (list != null && !list.isEmpty()) {
            k1Var.z(i10, list, x0Var);
        }
    }

    public static void W(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.F(i10, list, z10);
        }
    }

    public static void X(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.v(i10, list, z10);
        }
    }

    public static void Y(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.J(i10, list, z10);
        }
    }

    public static void Z(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.o(i10, list, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z10) {
            return i.O(i10) + i.y(size);
        }
        return size * i.c(i10, true);
    }

    public static void a0(int i10, List list, k1 k1Var) {
        if (list != null && !list.isEmpty()) {
            k1Var.d(i10, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List list) {
        return list.size();
    }

    public static void b0(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.n(i10, list, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int O = size * i.O(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            O += i.g((f) list.get(i11));
        }
        return O;
    }

    public static void c0(int i10, List list, k1 k1Var, boolean z10) {
        if (list != null && !list.isEmpty()) {
            k1Var.w(i10, list, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e10 = e(list);
        if (z10) {
            return i.O(i10) + i.y(e10);
        }
        return e10 + (size * i.O(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += i.k(((Integer) list.get(i11)).intValue());
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
            return i.O(i10) + i.y(size * 4);
        }
        return size * i.l(i10, 0);
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
            return i.O(i10) + i.y(size * 8);
        }
        return size * i.n(i10, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i10, List list, x0 x0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += i.r(i10, (j0) list.get(i12), x0Var);
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
            return i.O(i10) + i.y(l10);
        }
        return l10 + (size * i.O(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += i.v(((Integer) list.get(i11)).intValue());
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
            return i.O(i10) + i.y(n10);
        }
        return n10 + (list.size() * i.O(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += i.x(((Long) list.get(i11)).longValue());
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(int i10, Object obj, x0 x0Var) {
        return i.z(i10, (j0) obj, x0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i10, List list, x0 x0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int O = i.O(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            O += i.B((j0) list.get(i11), x0Var);
        }
        return O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r10 = r(list);
        if (z10) {
            return i.O(i10) + i.y(r10);
        }
        return r10 + (size * i.O(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += i.J(((Integer) list.get(i11)).intValue());
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
            return i.O(i10) + i.y(t10);
        }
        return t10 + (size * i.O(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += i.L(((Long) list.get(i11)).longValue());
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i10, List list) {
        int N;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int O = i.O(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof f) {
                N = i.g((f) obj);
            } else {
                N = i.N((String) obj);
            }
            O += N;
        }
        return O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w10 = w(list);
        if (z10) {
            return i.O(i10) + i.y(w10);
        }
        return w10 + (size * i.O(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += i.Q(((Integer) list.get(i11)).intValue());
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
            return i.O(i10) + i.y(y10);
        }
        return y10 + (size * i.O(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += i.S(((Long) list.get(i11)).longValue());
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object z(Object obj, int i10, List list, u.a aVar, Object obj2, e1 e1Var) {
        if (aVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Integer num = (Integer) list.get(i12);
                int intValue = num.intValue();
                if (aVar.a(intValue)) {
                    if (i12 != i11) {
                        list.set(i11, num);
                    }
                    i11++;
                } else {
                    obj2 = I(obj, i10, intValue, obj2, e1Var);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!aVar.a(intValue2)) {
                    obj2 = I(obj, i10, intValue2, obj2, e1Var);
                    it.remove();
                }
            }
        }
        return obj2;
    }
}
