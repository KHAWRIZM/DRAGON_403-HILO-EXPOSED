package com.google.protobuf;

import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class l2 {

    /* renamed from: f, reason: collision with root package name */
    private static final l2 f١١٢٣٠f = new l2(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    private int f١١٢٣١a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f١١٢٣٢b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f١١٢٣٣c;

    /* renamed from: d, reason: collision with root package name */
    private int f١١٢٣٤d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١١٢٣٥e;

    private l2() {
        this(0, new int[8], new Object[8], true);
    }

    private void b(int i10) {
        int[] iArr = this.f١١٢٣٢b;
        if (i10 > iArr.length) {
            int i11 = this.f١١٢٣١a;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.f١١٢٣٢b = Arrays.copyOf(iArr, i10);
            this.f١١٢٣٣c = Arrays.copyOf(this.f١١٢٣٣c, i10);
        }
    }

    public static l2 c() {
        return f١١٢٣٠f;
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
    public static l2 j(l2 l2Var, l2 l2Var2) {
        int i10 = l2Var.f١١٢٣١a + l2Var2.f١١٢٣١a;
        int[] copyOf = Arrays.copyOf(l2Var.f١١٢٣٢b, i10);
        System.arraycopy(l2Var2.f١١٢٣٢b, 0, copyOf, l2Var.f١١٢٣١a, l2Var2.f١١٢٣١a);
        Object[] copyOf2 = Arrays.copyOf(l2Var.f١١٢٣٣c, i10);
        System.arraycopy(l2Var2.f١١٢٣٣c, 0, copyOf2, l2Var.f١١٢٣١a, l2Var2.f١١٢٣١a);
        return new l2(i10, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l2 k() {
        return new l2();
    }

    private static boolean l(Object[] objArr, Object[] objArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (!objArr[i11].equals(objArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    private static boolean n(int[] iArr, int[] iArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    void a() {
        if (this.f١١٢٣٥e) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public int d() {
        int Z;
        int i10 = this.f١١٢٣٤d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f١١٢٣١a; i12++) {
            int i13 = this.f١١٢٣٢b[i12];
            int a10 = r2.a(i13);
            int b10 = r2.b(i13);
            if (b10 != 0) {
                if (b10 != 1) {
                    if (b10 != 2) {
                        if (b10 != 3) {
                            if (b10 == 5) {
                                Z = k.n(a10, ((Integer) this.f١١٢٣٣c[i12]).intValue());
                            } else {
                                throw new IllegalStateException(k0.d());
                            }
                        } else {
                            Z = (k.W(a10) * 2) + ((l2) this.f١١٢٣٣c[i12]).d();
                        }
                    } else {
                        Z = k.h(a10, (h) this.f١١٢٣٣c[i12]);
                    }
                } else {
                    Z = k.p(a10, ((Long) this.f١١٢٣٣c[i12]).longValue());
                }
            } else {
                Z = k.Z(a10, ((Long) this.f١١٢٣٣c[i12]).longValue());
            }
            i11 += Z;
        }
        this.f١١٢٣٤d = i11;
        return i11;
    }

    public int e() {
        int i10 = this.f١١٢٣٤d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f١١٢٣١a; i12++) {
            i11 += k.L(r2.a(this.f١١٢٣٢b[i12]), (h) this.f١١٢٣٣c[i12]);
        }
        this.f١١٢٣٤d = i11;
        return i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof l2)) {
            return false;
        }
        l2 l2Var = (l2) obj;
        int i10 = this.f١١٢٣١a;
        if (i10 == l2Var.f١١٢٣١a && n(this.f١١٢٣٢b, l2Var.f١١٢٣٢b, i10) && l(this.f١١٢٣٣c, l2Var.f١١٢٣٣c, this.f١١٢٣١a)) {
            return true;
        }
        return false;
    }

    public void h() {
        this.f١١٢٣٥e = false;
    }

    public int hashCode() {
        int i10 = this.f١١٢٣١a;
        return ((((527 + i10) * 31) + f(this.f١١٢٣٢b, i10)) * 31) + g(this.f١١٢٣٣c, this.f١١٢٣١a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l2 i(l2 l2Var) {
        if (l2Var.equals(c())) {
            return this;
        }
        a();
        int i10 = this.f١١٢٣١a + l2Var.f١١٢٣١a;
        b(i10);
        System.arraycopy(l2Var.f١١٢٣٢b, 0, this.f١١٢٣٢b, this.f١١٢٣١a, l2Var.f١١٢٣١a);
        System.arraycopy(l2Var.f١١٢٣٣c, 0, this.f١١٢٣٣c, this.f١١٢٣١a, l2Var.f١١٢٣١a);
        this.f١١٢٣١a = i10;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i10, Object obj) {
        a();
        b(this.f١١٢٣١a + 1);
        int[] iArr = this.f١١٢٣٢b;
        int i11 = this.f١١٢٣١a;
        iArr[i11] = i10;
        this.f١١٢٣٣c[i11] = obj;
        this.f١١٢٣١a = i11 + 1;
    }

    private l2(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f١١٢٣٤d = -1;
        this.f١١٢٣١a = i10;
        this.f١١٢٣٢b = iArr;
        this.f١١٢٣٣c = objArr;
        this.f١١٢٣٥e = z10;
    }
}
