package androidx.datastore.preferences.protobuf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class g {

    /* renamed from: f, reason: collision with root package name */
    private static volatile int f٣٣٠١f = 100;

    /* renamed from: a, reason: collision with root package name */
    int f٣٣٠٢a;

    /* renamed from: b, reason: collision with root package name */
    int f٣٣٠٣b;

    /* renamed from: c, reason: collision with root package name */
    int f٣٣٠٤c;

    /* renamed from: d, reason: collision with root package name */
    h f٣٣٠٥d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٣٣٠٦e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class b extends g {

        /* renamed from: g, reason: collision with root package name */
        private final byte[] f٣٣٠٧g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f٣٣٠٨h;

        /* renamed from: i, reason: collision with root package name */
        private int f٣٣٠٩i;

        /* renamed from: j, reason: collision with root package name */
        private int f٣٣١٠j;

        /* renamed from: k, reason: collision with root package name */
        private int f٣٣١١k;

        /* renamed from: l, reason: collision with root package name */
        private int f٣٣١٢l;

        /* renamed from: m, reason: collision with root package name */
        private int f٣٣١٣m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f٣٣١٤n;

        /* renamed from: o, reason: collision with root package name */
        private int f٣٣١٥o;

        private void O() {
            int i10 = this.f٣٣٠٩i + this.f٣٣١٠j;
            this.f٣٣٠٩i = i10;
            int i11 = i10 - this.f٣٣١٢l;
            int i12 = this.f٣٣١٥o;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f٣٣١٠j = i13;
                this.f٣٣٠٩i = i10 - i13;
                return;
            }
            this.f٣٣١٠j = 0;
        }

        private void Q() {
            if (this.f٣٣٠٩i - this.f٣٣١١k >= 10) {
                R();
            } else {
                S();
            }
        }

        private void R() {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.f٣٣٠٧g;
                int i11 = this.f٣٣١١k;
                this.f٣٣١١k = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw v.f();
        }

        private void S() {
            for (int i10 = 0; i10 < 10; i10++) {
                if (H() >= 0) {
                    return;
                }
            }
            throw v.f();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public String A() {
            int L = L();
            if (L > 0) {
                int i10 = this.f٣٣٠٩i;
                int i11 = this.f٣٣١١k;
                if (L <= i10 - i11) {
                    String str = new String(this.f٣٣٠٧g, i11, L, u.f٣٥٠٩b);
                    this.f٣٣١١k += L;
                    return str;
                }
            }
            if (L == 0) {
                return "";
            }
            if (L < 0) {
                throw v.g();
            }
            throw v.m();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public String B() {
            int L = L();
            if (L > 0) {
                int i10 = this.f٣٣٠٩i;
                int i11 = this.f٣٣١١k;
                if (L <= i10 - i11) {
                    String a10 = i1.a(this.f٣٣٠٧g, i11, L);
                    this.f٣٣١١k += L;
                    return a10;
                }
            }
            if (L == 0) {
                return "";
            }
            if (L <= 0) {
                throw v.g();
            }
            throw v.m();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int C() {
            if (f()) {
                this.f٣٣١٣m = 0;
                return 0;
            }
            int L = L();
            this.f٣٣١٣m = L;
            if (j1.a(L) != 0) {
                return this.f٣٣١٣m;
            }
            throw v.c();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int D() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public long E() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public boolean F(int i10) {
            int b10 = j1.b(i10);
            if (b10 != 0) {
                if (b10 != 1) {
                    if (b10 != 2) {
                        if (b10 != 3) {
                            if (b10 != 4) {
                                if (b10 == 5) {
                                    P(4);
                                    return true;
                                }
                                throw v.e();
                            }
                            return false;
                        }
                        G();
                        a(j1.c(j1.a(i10), 4));
                        return true;
                    }
                    P(L());
                    return true;
                }
                P(8);
                return true;
            }
            Q();
            return true;
        }

        public byte H() {
            int i10 = this.f٣٣١١k;
            if (i10 != this.f٣٣٠٩i) {
                byte[] bArr = this.f٣٣٠٧g;
                this.f٣٣١١k = i10 + 1;
                return bArr[i10];
            }
            throw v.m();
        }

        public byte[] I(int i10) {
            if (i10 > 0) {
                int i11 = this.f٣٣٠٩i;
                int i12 = this.f٣٣١١k;
                if (i10 <= i11 - i12) {
                    int i13 = i10 + i12;
                    this.f٣٣١١k = i13;
                    return Arrays.copyOfRange(this.f٣٣٠٧g, i12, i13);
                }
            }
            if (i10 <= 0) {
                if (i10 == 0) {
                    return u.f٣٥١١d;
                }
                throw v.g();
            }
            throw v.m();
        }

        public int J() {
            int i10 = this.f٣٣١١k;
            if (this.f٣٣٠٩i - i10 >= 4) {
                byte[] bArr = this.f٣٣٠٧g;
                this.f٣٣١١k = i10 + 4;
                return ((bArr[i10 + 3] & UByte.MAX_VALUE) << 24) | (bArr[i10] & UByte.MAX_VALUE) | ((bArr[i10 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i10 + 2] & UByte.MAX_VALUE) << 16);
            }
            throw v.m();
        }

        public long K() {
            int i10 = this.f٣٣١١k;
            if (this.f٣٣٠٩i - i10 >= 8) {
                byte[] bArr = this.f٣٣٠٧g;
                this.f٣٣١١k = i10 + 8;
                return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
            }
            throw v.m();
        }

        public int L() {
            int i10;
            int i11 = this.f٣٣١١k;
            int i12 = this.f٣٣٠٩i;
            if (i12 != i11) {
                byte[] bArr = this.f٣٣٠٧g;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f٣٣١١k = i13;
                    return b10;
                }
                if (i12 - i13 >= 9) {
                    int i14 = i11 + 2;
                    int i15 = (bArr[i13] << 7) ^ b10;
                    if (i15 < 0) {
                        i10 = i15 ^ (-128);
                    } else {
                        int i16 = i11 + 3;
                        int i17 = (bArr[i14] << 14) ^ i15;
                        if (i17 >= 0) {
                            i10 = i17 ^ 16256;
                        } else {
                            int i18 = i11 + 4;
                            int i19 = i17 ^ (bArr[i16] << 21);
                            if (i19 < 0) {
                                i10 = (-2080896) ^ i19;
                            } else {
                                i16 = i11 + 5;
                                byte b11 = bArr[i18];
                                int i20 = (i19 ^ (b11 << 28)) ^ 266354560;
                                if (b11 < 0) {
                                    i18 = i11 + 6;
                                    if (bArr[i16] < 0) {
                                        i16 = i11 + 7;
                                        if (bArr[i18] < 0) {
                                            i18 = i11 + 8;
                                            if (bArr[i16] < 0) {
                                                i16 = i11 + 9;
                                                if (bArr[i18] < 0) {
                                                    int i21 = i11 + 10;
                                                    if (bArr[i16] >= 0) {
                                                        i14 = i21;
                                                        i10 = i20;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i10 = i20;
                                }
                                i10 = i20;
                            }
                            i14 = i18;
                        }
                        i14 = i16;
                    }
                    this.f٣٣١١k = i14;
                    return i10;
                }
            }
            return (int) N();
        }

        public long M() {
            long j10;
            long j11;
            long j12;
            int i10 = this.f٣٣١١k;
            int i11 = this.f٣٣٠٩i;
            if (i11 != i10) {
                byte[] bArr = this.f٣٣٠٧g;
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    this.f٣٣١١k = i12;
                    return b10;
                }
                if (i11 - i12 >= 9) {
                    int i13 = i10 + 2;
                    int i14 = (bArr[i12] << 7) ^ b10;
                    if (i14 < 0) {
                        j10 = i14 ^ (-128);
                    } else {
                        int i15 = i10 + 3;
                        int i16 = (bArr[i13] << 14) ^ i14;
                        if (i16 >= 0) {
                            j10 = i16 ^ 16256;
                            i13 = i15;
                        } else {
                            int i17 = i10 + 4;
                            int i18 = i16 ^ (bArr[i15] << 21);
                            if (i18 < 0) {
                                long j13 = (-2080896) ^ i18;
                                i13 = i17;
                                j10 = j13;
                            } else {
                                long j14 = i18;
                                i13 = i10 + 5;
                                long j15 = j14 ^ (bArr[i17] << 28);
                                if (j15 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    int i19 = i10 + 6;
                                    long j16 = j15 ^ (bArr[i13] << 35);
                                    if (j16 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        i13 = i10 + 7;
                                        j15 = j16 ^ (bArr[i19] << 42);
                                        if (j15 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            i19 = i10 + 8;
                                            j16 = j15 ^ (bArr[i13] << 49);
                                            if (j16 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                i13 = i10 + 9;
                                                long j17 = (j16 ^ (bArr[i19] << 56)) ^ 71499008037633920L;
                                                if (j17 < 0) {
                                                    int i20 = i10 + 10;
                                                    if (bArr[i13] >= 0) {
                                                        i13 = i20;
                                                    }
                                                }
                                                j10 = j17;
                                            }
                                        }
                                    }
                                    j10 = j16 ^ j11;
                                    i13 = i19;
                                }
                                j10 = j15 ^ j12;
                            }
                        }
                    }
                    this.f٣٣١١k = i13;
                    return j10;
                }
            }
            return N();
        }

        long N() {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & ByteCompanionObject.MAX_VALUE) << i10;
                if ((H() & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j10;
                }
            }
            throw v.f();
        }

        public void P(int i10) {
            if (i10 >= 0) {
                int i11 = this.f٣٣٠٩i;
                int i12 = this.f٣٣١١k;
                if (i10 <= i11 - i12) {
                    this.f٣٣١١k = i12 + i10;
                    return;
                }
            }
            if (i10 < 0) {
                throw v.g();
            }
            throw v.m();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public void a(int i10) {
            if (this.f٣٣١٣m == i10) {
            } else {
                throw v.b();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int e() {
            return this.f٣٣١١k - this.f٣٣١٢l;
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public boolean f() {
            if (this.f٣٣١١k == this.f٣٣٠٩i) {
                return true;
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public void l(int i10) {
            this.f٣٣١٥o = i10;
            O();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int m(int i10) {
            if (i10 >= 0) {
                int e10 = i10 + e();
                if (e10 >= 0) {
                    int i11 = this.f٣٣١٥o;
                    if (e10 <= i11) {
                        this.f٣٣١٥o = e10;
                        O();
                        return i11;
                    }
                    throw v.m();
                }
                throw v.h();
            }
            throw v.g();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public boolean n() {
            if (M() != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public f o() {
            f k10;
            int L = L();
            if (L > 0) {
                int i10 = this.f٣٣٠٩i;
                int i11 = this.f٣٣١١k;
                if (L <= i10 - i11) {
                    if (this.f٣٣٠٨h && this.f٣٣١٤n) {
                        k10 = f.w(this.f٣٣٠٧g, i11, L);
                    } else {
                        k10 = f.k(this.f٣٣٠٧g, i11, L);
                    }
                    this.f٣٣١١k += L;
                    return k10;
                }
            }
            if (L == 0) {
                return f.f٣٢٨٥b;
            }
            return f.v(I(L));
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public double p() {
            return Double.longBitsToDouble(K());
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int q() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int r() {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public long s() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public float t() {
            return Float.intBitsToFloat(J());
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int u() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public long v() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int w() {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public long x() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int y() {
            return g.c(L());
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public long z() {
            return g.d(M());
        }

        private b(byte[] bArr, int i10, int i11, boolean z10) {
            super();
            this.f٣٣١٥o = Integer.MAX_VALUE;
            this.f٣٣٠٧g = bArr;
            this.f٣٣٠٩i = i11 + i10;
            this.f٣٣١١k = i10;
            this.f٣٣١٢l = i10;
            this.f٣٣٠٨h = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class c extends g {

        /* renamed from: g, reason: collision with root package name */
        private final InputStream f٣٣١٦g;

        /* renamed from: h, reason: collision with root package name */
        private final byte[] f٣٣١٧h;

        /* renamed from: i, reason: collision with root package name */
        private int f٣٣١٨i;

        /* renamed from: j, reason: collision with root package name */
        private int f٣٣١٩j;

        /* renamed from: k, reason: collision with root package name */
        private int f٣٣٢٠k;

        /* renamed from: l, reason: collision with root package name */
        private int f٣٣٢١l;

        /* renamed from: m, reason: collision with root package name */
        private int f٣٣٢٢m;

        /* renamed from: n, reason: collision with root package name */
        private int f٣٣٢٣n;

        private static int H(InputStream inputStream) {
            try {
                return inputStream.available();
            } catch (v e10) {
                e10.j();
                throw e10;
            }
        }

        private static int I(InputStream inputStream, byte[] bArr, int i10, int i11) {
            try {
                return inputStream.read(bArr, i10, i11);
            } catch (v e10) {
                e10.j();
                throw e10;
            }
        }

        private f J(int i10) {
            byte[] M = M(i10);
            if (M != null) {
                return f.i(M);
            }
            int i11 = this.f٣٣٢٠k;
            int i12 = this.f٣٣١٨i;
            int i13 = i12 - i11;
            this.f٣٣٢٢m += i12;
            this.f٣٣٢٠k = 0;
            this.f٣٣١٨i = 0;
            List<byte[]> N = N(i10 - i13);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f٣٣١٧h, i11, bArr, 0, i13);
            for (byte[] bArr2 : N) {
                System.arraycopy(bArr2, 0, bArr, i13, bArr2.length);
                i13 += bArr2.length;
            }
            return f.v(bArr);
        }

        private byte[] L(int i10, boolean z10) {
            byte[] M = M(i10);
            if (M != null) {
                if (z10) {
                    return (byte[]) M.clone();
                }
                return M;
            }
            int i11 = this.f٣٣٢٠k;
            int i12 = this.f٣٣١٨i;
            int i13 = i12 - i11;
            this.f٣٣٢٢m += i12;
            this.f٣٣٢٠k = 0;
            this.f٣٣١٨i = 0;
            List<byte[]> N = N(i10 - i13);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f٣٣١٧h, i11, bArr, 0, i13);
            for (byte[] bArr2 : N) {
                System.arraycopy(bArr2, 0, bArr, i13, bArr2.length);
                i13 += bArr2.length;
            }
            return bArr;
        }

        private byte[] M(int i10) {
            if (i10 == 0) {
                return u.f٣٥١١d;
            }
            if (i10 >= 0) {
                int i11 = this.f٣٣٢٢m;
                int i12 = this.f٣٣٢٠k;
                int i13 = i11 + i12 + i10;
                if (i13 - this.f٣٣٠٤c <= 0) {
                    int i14 = this.f٣٣٢٣n;
                    if (i13 <= i14) {
                        int i15 = this.f٣٣١٨i - i12;
                        int i16 = i10 - i15;
                        if (i16 >= 4096 && i16 > H(this.f٣٣١٦g)) {
                            return null;
                        }
                        byte[] bArr = new byte[i10];
                        System.arraycopy(this.f٣٣١٧h, this.f٣٣٢٠k, bArr, 0, i15);
                        this.f٣٣٢٢m += this.f٣٣١٨i;
                        this.f٣٣٢٠k = 0;
                        this.f٣٣١٨i = 0;
                        while (i15 < i10) {
                            int I = I(this.f٣٣١٦g, bArr, i15, i10 - i15);
                            if (I != -1) {
                                this.f٣٣٢٢m += I;
                                i15 += I;
                            } else {
                                throw v.m();
                            }
                        }
                        return bArr;
                    }
                    W((i14 - i11) - i12);
                    throw v.m();
                }
                throw v.l();
            }
            throw v.g();
        }

        private List N(int i10) {
            ArrayList arrayList = new ArrayList();
            while (i10 > 0) {
                int min = Math.min(i10, 4096);
                byte[] bArr = new byte[min];
                int i11 = 0;
                while (i11 < min) {
                    int read = this.f٣٣١٦g.read(bArr, i11, min - i11);
                    if (read != -1) {
                        this.f٣٣٢٢m += read;
                        i11 += read;
                    } else {
                        throw v.m();
                    }
                }
                i10 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void T() {
            int i10 = this.f٣٣١٨i + this.f٣٣١٩j;
            this.f٣٣١٨i = i10;
            int i11 = this.f٣٣٢٢m + i10;
            int i12 = this.f٣٣٢٣n;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f٣٣١٩j = i13;
                this.f٣٣١٨i = i10 - i13;
                return;
            }
            this.f٣٣١٩j = 0;
        }

        private void U(int i10) {
            if (!b0(i10)) {
                if (i10 > (this.f٣٣٠٤c - this.f٣٣٢٢m) - this.f٣٣٢٠k) {
                    throw v.l();
                }
                throw v.m();
            }
        }

        private static long V(InputStream inputStream, long j10) {
            try {
                return inputStream.skip(j10);
            } catch (v e10) {
                e10.j();
                throw e10;
            }
        }

        private void X(int i10) {
            if (i10 >= 0) {
                int i11 = this.f٣٣٢٢m;
                int i12 = this.f٣٣٢٠k;
                int i13 = i11 + i12 + i10;
                int i14 = this.f٣٣٢٣n;
                if (i13 <= i14) {
                    this.f٣٣٢٢m = i11 + i12;
                    int i15 = this.f٣٣١٨i - i12;
                    this.f٣٣١٨i = 0;
                    this.f٣٣٢٠k = 0;
                    while (i15 < i10) {
                        try {
                            long j10 = i10 - i15;
                            long V = V(this.f٣٣١٦g, j10);
                            if (V >= 0 && V <= j10) {
                                if (V == 0) {
                                    break;
                                } else {
                                    i15 += (int) V;
                                }
                            } else {
                                throw new IllegalStateException(this.f٣٣١٦g.getClass() + "#skip returned invalid result: " + V + "\nThe InputStream implementation is buggy.");
                            }
                        } finally {
                            this.f٣٣٢٢m += i15;
                            T();
                        }
                    }
                    if (i15 < i10) {
                        int i16 = this.f٣٣١٨i;
                        int i17 = i16 - this.f٣٣٢٠k;
                        this.f٣٣٢٠k = i16;
                        U(1);
                        while (true) {
                            int i18 = i10 - i17;
                            int i19 = this.f٣٣١٨i;
                            if (i18 > i19) {
                                i17 += i19;
                                this.f٣٣٢٠k = i19;
                                U(1);
                            } else {
                                this.f٣٣٢٠k = i18;
                                return;
                            }
                        }
                    }
                } else {
                    W((i14 - i11) - i12);
                    throw v.m();
                }
            } else {
                throw v.g();
            }
        }

        private void Y() {
            if (this.f٣٣١٨i - this.f٣٣٢٠k >= 10) {
                Z();
            } else {
                a0();
            }
        }

        private void Z() {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.f٣٣١٧h;
                int i11 = this.f٣٣٢٠k;
                this.f٣٣٢٠k = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw v.f();
        }

        private void a0() {
            for (int i10 = 0; i10 < 10; i10++) {
                if (K() >= 0) {
                    return;
                }
            }
            throw v.f();
        }

        private boolean b0(int i10) {
            int i11 = this.f٣٣٢٠k;
            int i12 = i11 + i10;
            int i13 = this.f٣٣١٨i;
            if (i12 > i13) {
                int i14 = this.f٣٣٠٤c;
                int i15 = this.f٣٣٢٢m;
                if (i10 > (i14 - i15) - i11 || i15 + i11 + i10 > this.f٣٣٢٣n) {
                    return false;
                }
                if (i11 > 0) {
                    if (i13 > i11) {
                        byte[] bArr = this.f٣٣١٧h;
                        System.arraycopy(bArr, i11, bArr, 0, i13 - i11);
                    }
                    this.f٣٣٢٢m += i11;
                    this.f٣٣١٨i -= i11;
                    this.f٣٣٢٠k = 0;
                }
                InputStream inputStream = this.f٣٣١٦g;
                byte[] bArr2 = this.f٣٣١٧h;
                int i16 = this.f٣٣١٨i;
                int I = I(inputStream, bArr2, i16, Math.min(bArr2.length - i16, (this.f٣٣٠٤c - this.f٣٣٢٢m) - i16));
                if (I != 0 && I >= -1 && I <= this.f٣٣١٧h.length) {
                    if (I <= 0) {
                        return false;
                    }
                    this.f٣٣١٨i += I;
                    T();
                    if (this.f٣٣١٨i >= i10) {
                        return true;
                    }
                    return b0(i10);
                }
                throw new IllegalStateException(this.f٣٣١٦g.getClass() + "#read(byte[]) returned invalid result: " + I + "\nThe InputStream implementation is buggy.");
            }
            throw new IllegalStateException("refillBuffer() called when " + i10 + " bytes were already available in buffer");
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public String A() {
            int Q = Q();
            if (Q > 0) {
                int i10 = this.f٣٣١٨i;
                int i11 = this.f٣٣٢٠k;
                if (Q <= i10 - i11) {
                    String str = new String(this.f٣٣١٧h, i11, Q, u.f٣٥٠٩b);
                    this.f٣٣٢٠k += Q;
                    return str;
                }
            }
            if (Q == 0) {
                return "";
            }
            if (Q >= 0) {
                if (Q <= this.f٣٣١٨i) {
                    U(Q);
                    String str2 = new String(this.f٣٣١٧h, this.f٣٣٢٠k, Q, u.f٣٥٠٩b);
                    this.f٣٣٢٠k += Q;
                    return str2;
                }
                return new String(L(Q, false), u.f٣٥٠٩b);
            }
            throw v.g();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public String B() {
            byte[] L;
            int Q = Q();
            int i10 = this.f٣٣٢٠k;
            int i11 = this.f٣٣١٨i;
            if (Q <= i11 - i10 && Q > 0) {
                L = this.f٣٣١٧h;
                this.f٣٣٢٠k = i10 + Q;
            } else {
                if (Q == 0) {
                    return "";
                }
                if (Q >= 0) {
                    i10 = 0;
                    if (Q <= i11) {
                        U(Q);
                        L = this.f٣٣١٧h;
                        this.f٣٣٢٠k = Q;
                    } else {
                        L = L(Q, false);
                    }
                } else {
                    throw v.g();
                }
            }
            return i1.a(L, i10, Q);
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int C() {
            if (f()) {
                this.f٣٣٢١l = 0;
                return 0;
            }
            int Q = Q();
            this.f٣٣٢١l = Q;
            if (j1.a(Q) != 0) {
                return this.f٣٣٢١l;
            }
            throw v.c();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int D() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public long E() {
            return R();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public boolean F(int i10) {
            int b10 = j1.b(i10);
            if (b10 != 0) {
                if (b10 != 1) {
                    if (b10 != 2) {
                        if (b10 != 3) {
                            if (b10 != 4) {
                                if (b10 == 5) {
                                    W(4);
                                    return true;
                                }
                                throw v.e();
                            }
                            return false;
                        }
                        G();
                        a(j1.c(j1.a(i10), 4));
                        return true;
                    }
                    W(Q());
                    return true;
                }
                W(8);
                return true;
            }
            Y();
            return true;
        }

        public byte K() {
            if (this.f٣٣٢٠k == this.f٣٣١٨i) {
                U(1);
            }
            byte[] bArr = this.f٣٣١٧h;
            int i10 = this.f٣٣٢٠k;
            this.f٣٣٢٠k = i10 + 1;
            return bArr[i10];
        }

        public int O() {
            int i10 = this.f٣٣٢٠k;
            if (this.f٣٣١٨i - i10 < 4) {
                U(4);
                i10 = this.f٣٣٢٠k;
            }
            byte[] bArr = this.f٣٣١٧h;
            this.f٣٣٢٠k = i10 + 4;
            return ((bArr[i10 + 3] & UByte.MAX_VALUE) << 24) | (bArr[i10] & UByte.MAX_VALUE) | ((bArr[i10 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i10 + 2] & UByte.MAX_VALUE) << 16);
        }

        public long P() {
            int i10 = this.f٣٣٢٠k;
            if (this.f٣٣١٨i - i10 < 8) {
                U(8);
                i10 = this.f٣٣٢٠k;
            }
            byte[] bArr = this.f٣٣١٧h;
            this.f٣٣٢٠k = i10 + 8;
            return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
        }

        public int Q() {
            int i10;
            int i11 = this.f٣٣٢٠k;
            int i12 = this.f٣٣١٨i;
            if (i12 != i11) {
                byte[] bArr = this.f٣٣١٧h;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f٣٣٢٠k = i13;
                    return b10;
                }
                if (i12 - i13 >= 9) {
                    int i14 = i11 + 2;
                    int i15 = (bArr[i13] << 7) ^ b10;
                    if (i15 < 0) {
                        i10 = i15 ^ (-128);
                    } else {
                        int i16 = i11 + 3;
                        int i17 = (bArr[i14] << 14) ^ i15;
                        if (i17 >= 0) {
                            i10 = i17 ^ 16256;
                        } else {
                            int i18 = i11 + 4;
                            int i19 = i17 ^ (bArr[i16] << 21);
                            if (i19 < 0) {
                                i10 = (-2080896) ^ i19;
                            } else {
                                i16 = i11 + 5;
                                byte b11 = bArr[i18];
                                int i20 = (i19 ^ (b11 << 28)) ^ 266354560;
                                if (b11 < 0) {
                                    i18 = i11 + 6;
                                    if (bArr[i16] < 0) {
                                        i16 = i11 + 7;
                                        if (bArr[i18] < 0) {
                                            i18 = i11 + 8;
                                            if (bArr[i16] < 0) {
                                                i16 = i11 + 9;
                                                if (bArr[i18] < 0) {
                                                    int i21 = i11 + 10;
                                                    if (bArr[i16] >= 0) {
                                                        i14 = i21;
                                                        i10 = i20;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i10 = i20;
                                }
                                i10 = i20;
                            }
                            i14 = i18;
                        }
                        i14 = i16;
                    }
                    this.f٣٣٢٠k = i14;
                    return i10;
                }
            }
            return (int) S();
        }

        public long R() {
            long j10;
            long j11;
            long j12;
            int i10 = this.f٣٣٢٠k;
            int i11 = this.f٣٣١٨i;
            if (i11 != i10) {
                byte[] bArr = this.f٣٣١٧h;
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    this.f٣٣٢٠k = i12;
                    return b10;
                }
                if (i11 - i12 >= 9) {
                    int i13 = i10 + 2;
                    int i14 = (bArr[i12] << 7) ^ b10;
                    if (i14 < 0) {
                        j10 = i14 ^ (-128);
                    } else {
                        int i15 = i10 + 3;
                        int i16 = (bArr[i13] << 14) ^ i14;
                        if (i16 >= 0) {
                            j10 = i16 ^ 16256;
                            i13 = i15;
                        } else {
                            int i17 = i10 + 4;
                            int i18 = i16 ^ (bArr[i15] << 21);
                            if (i18 < 0) {
                                long j13 = (-2080896) ^ i18;
                                i13 = i17;
                                j10 = j13;
                            } else {
                                long j14 = i18;
                                i13 = i10 + 5;
                                long j15 = j14 ^ (bArr[i17] << 28);
                                if (j15 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    int i19 = i10 + 6;
                                    long j16 = j15 ^ (bArr[i13] << 35);
                                    if (j16 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        i13 = i10 + 7;
                                        j15 = j16 ^ (bArr[i19] << 42);
                                        if (j15 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            i19 = i10 + 8;
                                            j16 = j15 ^ (bArr[i13] << 49);
                                            if (j16 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                i13 = i10 + 9;
                                                long j17 = (j16 ^ (bArr[i19] << 56)) ^ 71499008037633920L;
                                                if (j17 < 0) {
                                                    int i20 = i10 + 10;
                                                    if (bArr[i13] >= 0) {
                                                        i13 = i20;
                                                    }
                                                }
                                                j10 = j17;
                                            }
                                        }
                                    }
                                    j10 = j16 ^ j11;
                                    i13 = i19;
                                }
                                j10 = j15 ^ j12;
                            }
                        }
                    }
                    this.f٣٣٢٠k = i13;
                    return j10;
                }
            }
            return S();
        }

        long S() {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & ByteCompanionObject.MAX_VALUE) << i10;
                if ((K() & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j10;
                }
            }
            throw v.f();
        }

        public void W(int i10) {
            int i11 = this.f٣٣١٨i;
            int i12 = this.f٣٣٢٠k;
            if (i10 <= i11 - i12 && i10 >= 0) {
                this.f٣٣٢٠k = i12 + i10;
            } else {
                X(i10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public void a(int i10) {
            if (this.f٣٣٢١l == i10) {
            } else {
                throw v.b();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int e() {
            return this.f٣٣٢٢m + this.f٣٣٢٠k;
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public boolean f() {
            if (this.f٣٣٢٠k == this.f٣٣١٨i && !b0(1)) {
                return true;
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public void l(int i10) {
            this.f٣٣٢٣n = i10;
            T();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int m(int i10) {
            if (i10 >= 0) {
                int i11 = i10 + this.f٣٣٢٢m + this.f٣٣٢٠k;
                if (i11 >= 0) {
                    int i12 = this.f٣٣٢٣n;
                    if (i11 <= i12) {
                        this.f٣٣٢٣n = i11;
                        T();
                        return i12;
                    }
                    throw v.m();
                }
                throw v.h();
            }
            throw v.g();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public boolean n() {
            if (R() != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public f o() {
            int Q = Q();
            int i10 = this.f٣٣١٨i;
            int i11 = this.f٣٣٢٠k;
            if (Q <= i10 - i11 && Q > 0) {
                f k10 = f.k(this.f٣٣١٧h, i11, Q);
                this.f٣٣٢٠k += Q;
                return k10;
            }
            if (Q == 0) {
                return f.f٣٢٨٥b;
            }
            if (Q >= 0) {
                return J(Q);
            }
            throw v.g();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public double p() {
            return Double.longBitsToDouble(P());
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int q() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int r() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public long s() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public float t() {
            return Float.intBitsToFloat(O());
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int u() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public long v() {
            return R();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int w() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public long x() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public int y() {
            return g.c(Q());
        }

        @Override // androidx.datastore.preferences.protobuf.g
        public long z() {
            return g.d(R());
        }

        private c(InputStream inputStream, int i10) {
            super();
            this.f٣٣٢٣n = Integer.MAX_VALUE;
            u.b(inputStream, "input");
            this.f٣٣١٦g = inputStream;
            this.f٣٣١٧h = new byte[i10];
            this.f٣٣١٨i = 0;
            this.f٣٣٢٠k = 0;
            this.f٣٣٢٢m = 0;
        }
    }

    public static int c(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long d(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static g g(InputStream inputStream) {
        return h(inputStream, 4096);
    }

    public static g h(InputStream inputStream, int i10) {
        if (i10 > 0) {
            if (inputStream == null) {
                return i(u.f٣٥١١d);
            }
            return new c(inputStream, i10);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static g i(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public static g j(byte[] bArr, int i10, int i11) {
        return k(bArr, i10, i11, false);
    }

    static g k(byte[] bArr, int i10, int i11, boolean z10) {
        b bVar = new b(bArr, i10, i11, z10);
        try {
            bVar.m(i11);
            return bVar;
        } catch (v e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public abstract String A();

    public abstract String B();

    public abstract int C();

    public abstract int D();

    public abstract long E();

    public abstract boolean F(int i10);

    public void G() {
        int C;
        do {
            C = C();
            if (C == 0) {
                return;
            }
            b();
            this.f٣٣٠٢a++;
            this.f٣٣٠٢a--;
        } while (F(C));
    }

    public abstract void a(int i10);

    public void b() {
        if (this.f٣٣٠٢a < this.f٣٣٠٣b) {
        } else {
            throw v.i();
        }
    }

    public abstract int e();

    public abstract boolean f();

    public abstract void l(int i10);

    public abstract int m(int i10);

    public abstract boolean n();

    public abstract f o();

    public abstract double p();

    public abstract int q();

    public abstract int r();

    public abstract long s();

    public abstract float t();

    public abstract int u();

    public abstract long v();

    public abstract int w();

    public abstract long x();

    public abstract int y();

    public abstract long z();

    private g() {
        this.f٣٣٠٣b = f٣٣٠١f;
        this.f٣٣٠٤c = Integer.MAX_VALUE;
        this.f٣٣٠٦e = false;
    }
}
