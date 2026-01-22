package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.k1;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f1 {

    /* renamed from: f, reason: collision with root package name */
    private static final f1 f٣٢٩٥f = new f1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    private int f٣٢٩٦a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f٣٢٩٧b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f٣٢٩٨c;

    /* renamed from: d, reason: collision with root package name */
    private int f٣٢٩٩d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٣٣٠٠e;

    private f1() {
        this(0, new int[8], new Object[8], true);
    }

    private void b(int i10) {
        int[] iArr = this.f٣٢٩٧b;
        if (i10 > iArr.length) {
            int i11 = this.f٣٢٩٦a;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.f٣٢٩٧b = Arrays.copyOf(iArr, i10);
            this.f٣٢٩٨c = Arrays.copyOf(this.f٣٢٩٨c, i10);
        }
    }

    public static f1 c() {
        return f٣٢٩٥f;
    }

    private static int f(int[] iArr, int i10) {
        int i11 = 17;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        return i11;
    }

    private static int g(Object[] objArr, int i10) {
        int i11 = 17;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 = (i11 * 31) + objArr[i12].hashCode();
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f1 j(f1 f1Var, f1 f1Var2) {
        int i10 = f1Var.f٣٢٩٦a + f1Var2.f٣٢٩٦a;
        int[] copyOf = Arrays.copyOf(f1Var.f٣٢٩٧b, i10);
        System.arraycopy(f1Var2.f٣٢٩٧b, 0, copyOf, f1Var.f٣٢٩٦a, f1Var2.f٣٢٩٦a);
        Object[] copyOf2 = Arrays.copyOf(f1Var.f٣٢٩٨c, i10);
        System.arraycopy(f1Var2.f٣٢٩٨c, 0, copyOf2, f1Var.f٣٢٩٦a, f1Var2.f٣٢٩٦a);
        return new f1(i10, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f1 k() {
        return new f1();
    }

    private static boolean l(Object[] objArr, Object[] objArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (!objArr[i11].equals(objArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    private static boolean o(int[] iArr, int[] iArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    private static void q(int i10, Object obj, k1 k1Var) {
        int a10 = j1.a(i10);
        int b10 = j1.b(i10);
        if (b10 != 0) {
            if (b10 != 1) {
                if (b10 != 2) {
                    if (b10 != 3) {
                        if (b10 == 5) {
                            k1Var.c(a10, ((Integer) obj).intValue());
                            return;
                        }
                        throw new RuntimeException(v.e());
                    }
                    if (k1Var.y() == k1.a.ASCENDING) {
                        k1Var.D(a10);
                        ((f1) obj).r(k1Var);
                        k1Var.I(a10);
                        return;
                    } else {
                        k1Var.I(a10);
                        ((f1) obj).r(k1Var);
                        k1Var.D(a10);
                        return;
                    }
                }
                k1Var.j(a10, (f) obj);
                return;
            }
            k1Var.x(a10, ((Long) obj).longValue());
            return;
        }
        k1Var.A(a10, ((Long) obj).longValue());
    }

    void a() {
        if (this.f٣٣٠٠e) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public int d() {
        int R;
        int i10 = this.f٣٢٩٩d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f٣٢٩٦a; i12++) {
            int i13 = this.f٣٢٩٧b[i12];
            int a10 = j1.a(i13);
            int b10 = j1.b(i13);
            if (b10 != 0) {
                if (b10 != 1) {
                    if (b10 != 2) {
                        if (b10 != 3) {
                            if (b10 == 5) {
                                R = i.l(a10, ((Integer) this.f٣٢٩٨c[i12]).intValue());
                            } else {
                                throw new IllegalStateException(v.e());
                            }
                        } else {
                            R = (i.O(a10) * 2) + ((f1) this.f٣٢٩٨c[i12]).d();
                        }
                    } else {
                        R = i.f(a10, (f) this.f٣٢٩٨c[i12]);
                    }
                } else {
                    R = i.n(a10, ((Long) this.f٣٢٩٨c[i12]).longValue());
                }
            } else {
                R = i.R(a10, ((Long) this.f٣٢٩٨c[i12]).longValue());
            }
            i11 += R;
        }
        this.f٣٢٩٩d = i11;
        return i11;
    }

    public int e() {
        int i10 = this.f٣٢٩٩d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f٣٢٩٦a; i12++) {
            i11 += i.D(j1.a(this.f٣٢٩٧b[i12]), (f) this.f٣٢٩٨c[i12]);
        }
        this.f٣٢٩٩d = i11;
        return i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f1)) {
            return false;
        }
        f1 f1Var = (f1) obj;
        int i10 = this.f٣٢٩٦a;
        if (i10 == f1Var.f٣٢٩٦a && o(this.f٣٢٩٧b, f1Var.f٣٢٩٧b, i10) && l(this.f٣٢٩٨c, f1Var.f٣٢٩٨c, this.f٣٢٩٦a)) {
            return true;
        }
        return false;
    }

    public void h() {
        if (this.f٣٣٠٠e) {
            this.f٣٣٠٠e = false;
        }
    }

    public int hashCode() {
        int i10 = this.f٣٢٩٦a;
        return ((((527 + i10) * 31) + f(this.f٣٢٩٧b, i10)) * 31) + g(this.f٣٢٩٨c, this.f٣٢٩٦a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f1 i(f1 f1Var) {
        if (f1Var.equals(c())) {
            return this;
        }
        a();
        int i10 = this.f٣٢٩٦a + f1Var.f٣٢٩٦a;
        b(i10);
        System.arraycopy(f1Var.f٣٢٩٧b, 0, this.f٣٢٩٧b, this.f٣٢٩٦a, f1Var.f٣٢٩٦a);
        System.arraycopy(f1Var.f٣٢٩٨c, 0, this.f٣٢٩٨c, this.f٣٢٩٦a, f1Var.f٣٢٩٦a);
        this.f٣٢٩٦a = i10;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < this.f٣٢٩٦a; i11++) {
            l0.d(sb, i10, String.valueOf(j1.a(this.f٣٢٩٧b[i11])), this.f٣٢٩٨c[i11]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i10, Object obj) {
        a();
        b(this.f٣٢٩٦a + 1);
        int[] iArr = this.f٣٢٩٧b;
        int i11 = this.f٣٢٩٦a;
        iArr[i11] = i10;
        this.f٣٢٩٨c[i11] = obj;
        this.f٣٢٩٦a = i11 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(k1 k1Var) {
        if (k1Var.y() == k1.a.DESCENDING) {
            for (int i10 = this.f٣٢٩٦a - 1; i10 >= 0; i10--) {
                k1Var.b(j1.a(this.f٣٢٩٧b[i10]), this.f٣٢٩٨c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f٣٢٩٦a; i11++) {
            k1Var.b(j1.a(this.f٣٢٩٧b[i11]), this.f٣٢٩٨c[i11]);
        }
    }

    public void r(k1 k1Var) {
        if (this.f٣٢٩٦a == 0) {
            return;
        }
        if (k1Var.y() == k1.a.ASCENDING) {
            for (int i10 = 0; i10 < this.f٣٢٩٦a; i10++) {
                q(this.f٣٢٩٧b[i10], this.f٣٢٩٨c[i10], k1Var);
            }
            return;
        }
        for (int i11 = this.f٣٢٩٦a - 1; i11 >= 0; i11--) {
            q(this.f٣٢٩٧b[i11], this.f٣٢٩٨c[i11], k1Var);
        }
    }

    private f1(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f٣٢٩٩d = -1;
        this.f٣٢٩٦a = i10;
        this.f٣٢٩٧b = iArr;
        this.f٣٢٩٨c = objArr;
        this.f٣٣٠٠e = z10;
    }
}
