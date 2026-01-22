package com.google.protobuf;

import com.google.protobuf.e1;
import io.agora.rtc.Constants;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class i {

    /* renamed from: f, reason: collision with root package name */
    private static volatile int f١١١٠١f = 100;

    /* renamed from: a, reason: collision with root package name */
    int f١١١٠٢a;

    /* renamed from: b, reason: collision with root package name */
    int f١١١٠٣b;

    /* renamed from: c, reason: collision with root package name */
    int f١١١٠٤c;

    /* renamed from: d, reason: collision with root package name */
    j f١١١٠٥d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١١١٠٦e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b extends i {

        /* renamed from: g, reason: collision with root package name */
        private final byte[] f١١١٠٧g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f١١١٠٨h;

        /* renamed from: i, reason: collision with root package name */
        private int f١١١٠٩i;

        /* renamed from: j, reason: collision with root package name */
        private int f١١١١٠j;

        /* renamed from: k, reason: collision with root package name */
        private int f١١١١١k;

        /* renamed from: l, reason: collision with root package name */
        private int f١١١١٢l;

        /* renamed from: m, reason: collision with root package name */
        private int f١١١١٣m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f١١١١٤n;

        /* renamed from: o, reason: collision with root package name */
        private int f١١١١٥o;

        private void V() {
            int i10 = this.f١١١٠٩i + this.f١١١١٠j;
            this.f١١١٠٩i = i10;
            int i11 = i10 - this.f١١١١٢l;
            int i12 = this.f١١١١٥o;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f١١١١٠j = i13;
                this.f١١١٠٩i = i10 - i13;
                return;
            }
            this.f١١١١٠j = 0;
        }

        private void Y() {
            if (this.f١١١٠٩i - this.f١١١١١k >= 10) {
                Z();
            } else {
                a0();
            }
        }

        private void Z() {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.f١١١٠٧g;
                int i11 = this.f١١١١١k;
                this.f١١١١١k = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw k0.e();
        }

        private void a0() {
            for (int i10 = 0; i10 < 10; i10++) {
                if (P() >= 0) {
                    return;
                }
            }
            throw k0.e();
        }

        @Override // com.google.protobuf.i
        public e1 A(r1 r1Var, v vVar) {
            int C = C();
            b();
            int p10 = p(C);
            this.f١١١٠٢a++;
            e1 e1Var = (e1) r1Var.parsePartialFrom(this, vVar);
            a(0);
            this.f١١١٠٢a--;
            if (e() == 0) {
                o(p10);
                return e1Var;
            }
            throw k0.l();
        }

        @Override // com.google.protobuf.i
        public void B(e1.a aVar, v vVar) {
            int C = C();
            b();
            int p10 = p(C);
            this.f١١١٠٢a++;
            aVar.mergeFrom(this, vVar);
            a(0);
            this.f١١١٠٢a--;
            if (e() == 0) {
                o(p10);
                return;
            }
            throw k0.l();
        }

        @Override // com.google.protobuf.i
        public int C() {
            int i10;
            int i11 = this.f١١١١١k;
            int i12 = this.f١١١٠٩i;
            if (i12 != i11) {
                byte[] bArr = this.f١١١٠٧g;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f١١١١١k = i13;
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
                    this.f١١١١١k = i14;
                    return i10;
                }
            }
            return (int) U();
        }

        @Override // com.google.protobuf.i
        public int E() {
            return R();
        }

        @Override // com.google.protobuf.i
        public long F() {
            return S();
        }

        @Override // com.google.protobuf.i
        public int G() {
            return i.c(C());
        }

        @Override // com.google.protobuf.i
        public long H() {
            return i.d(T());
        }

        @Override // com.google.protobuf.i
        public String I() {
            int C = C();
            if (C > 0) {
                int i10 = this.f١١١٠٩i;
                int i11 = this.f١١١١١k;
                if (C <= i10 - i11) {
                    String str = new String(this.f١١١٠٧g, i11, C, j0.f١١١٦٢b);
                    this.f١١١١١k += C;
                    return str;
                }
            }
            if (C == 0) {
                return "";
            }
            if (C < 0) {
                throw k0.f();
            }
            throw k0.l();
        }

        @Override // com.google.protobuf.i
        public String J() {
            int C = C();
            if (C > 0) {
                int i10 = this.f١١١٠٩i;
                int i11 = this.f١١١١١k;
                if (C <= i10 - i11) {
                    String h10 = q2.h(this.f١١١٠٧g, i11, C);
                    this.f١١١١١k += C;
                    return h10;
                }
            }
            if (C == 0) {
                return "";
            }
            if (C <= 0) {
                throw k0.f();
            }
            throw k0.l();
        }

        @Override // com.google.protobuf.i
        public int K() {
            if (g()) {
                this.f١١١١٣m = 0;
                return 0;
            }
            int C = C();
            this.f١١١١٣m = C;
            if (r2.a(C) != 0) {
                return this.f١١١١٣m;
            }
            throw k0.b();
        }

        @Override // com.google.protobuf.i
        public int L() {
            return C();
        }

        @Override // com.google.protobuf.i
        public long M() {
            return T();
        }

        @Override // com.google.protobuf.i
        public boolean O(int i10) {
            int b10 = r2.b(i10);
            if (b10 != 0) {
                if (b10 != 1) {
                    if (b10 != 2) {
                        if (b10 != 3) {
                            if (b10 != 4) {
                                if (b10 == 5) {
                                    X(4);
                                    return true;
                                }
                                throw k0.d();
                            }
                            return false;
                        }
                        W();
                        a(r2.c(r2.a(i10), 4));
                        return true;
                    }
                    X(C());
                    return true;
                }
                X(8);
                return true;
            }
            Y();
            return true;
        }

        public byte P() {
            int i10 = this.f١١١١١k;
            if (i10 != this.f١١١٠٩i) {
                byte[] bArr = this.f١١١٠٧g;
                this.f١١١١١k = i10 + 1;
                return bArr[i10];
            }
            throw k0.l();
        }

        public byte[] Q(int i10) {
            if (i10 > 0) {
                int i11 = this.f١١١٠٩i;
                int i12 = this.f١١١١١k;
                if (i10 <= i11 - i12) {
                    int i13 = i10 + i12;
                    this.f١١١١١k = i13;
                    return Arrays.copyOfRange(this.f١١١٠٧g, i12, i13);
                }
            }
            if (i10 <= 0) {
                if (i10 == 0) {
                    return j0.f١١١٦٤d;
                }
                throw k0.f();
            }
            throw k0.l();
        }

        public int R() {
            int i10 = this.f١١١١١k;
            if (this.f١١١٠٩i - i10 >= 4) {
                byte[] bArr = this.f١١١٠٧g;
                this.f١١١١١k = i10 + 4;
                return ((bArr[i10 + 3] & UByte.MAX_VALUE) << 24) | (bArr[i10] & UByte.MAX_VALUE) | ((bArr[i10 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i10 + 2] & UByte.MAX_VALUE) << 16);
            }
            throw k0.l();
        }

        public long S() {
            int i10 = this.f١١١١١k;
            if (this.f١١١٠٩i - i10 >= 8) {
                byte[] bArr = this.f١١١٠٧g;
                this.f١١١١١k = i10 + 8;
                return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
            }
            throw k0.l();
        }

        public long T() {
            long j10;
            long j11;
            long j12;
            int i10 = this.f١١١١١k;
            int i11 = this.f١١١٠٩i;
            if (i11 != i10) {
                byte[] bArr = this.f١١١٠٧g;
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    this.f١١١١١k = i12;
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
                    this.f١١١١١k = i13;
                    return j10;
                }
            }
            return U();
        }

        long U() {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & ByteCompanionObject.MAX_VALUE) << i10;
                if ((P() & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j10;
                }
            }
            throw k0.e();
        }

        public void W() {
            int K;
            do {
                K = K();
                if (K == 0) {
                    return;
                }
            } while (O(K));
        }

        public void X(int i10) {
            if (i10 >= 0) {
                int i11 = this.f١١١٠٩i;
                int i12 = this.f١١١١١k;
                if (i10 <= i11 - i12) {
                    this.f١١١١١k = i12 + i10;
                    return;
                }
            }
            if (i10 < 0) {
                throw k0.f();
            }
            throw k0.l();
        }

        @Override // com.google.protobuf.i
        public void a(int i10) {
            if (this.f١١١١٣m == i10) {
            } else {
                throw k0.a();
            }
        }

        @Override // com.google.protobuf.i
        public int e() {
            int i10 = this.f١١١١٥o;
            if (i10 == Integer.MAX_VALUE) {
                return -1;
            }
            return i10 - f();
        }

        @Override // com.google.protobuf.i
        public int f() {
            return this.f١١١١١k - this.f١١١١٢l;
        }

        @Override // com.google.protobuf.i
        public boolean g() {
            if (this.f١١١١١k == this.f١١١٠٩i) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.i
        public void o(int i10) {
            this.f١١١١٥o = i10;
            V();
        }

        @Override // com.google.protobuf.i
        public int p(int i10) {
            if (i10 >= 0) {
                int f10 = i10 + f();
                if (f10 >= 0) {
                    int i11 = this.f١١١١٥o;
                    if (f10 <= i11) {
                        this.f١١١١٥o = f10;
                        V();
                        return i11;
                    }
                    throw k0.l();
                }
                throw k0.g();
            }
            throw k0.f();
        }

        @Override // com.google.protobuf.i
        public boolean q() {
            if (T() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.i
        public h r() {
            h n10;
            int C = C();
            if (C > 0) {
                int i10 = this.f١١١٠٩i;
                int i11 = this.f١١١١١k;
                if (C <= i10 - i11) {
                    if (this.f١١١٠٨h && this.f١١١١٤n) {
                        n10 = h.H(this.f١١١٠٧g, i11, C);
                    } else {
                        n10 = h.n(this.f١١١٠٧g, i11, C);
                    }
                    this.f١١١١١k += C;
                    return n10;
                }
            }
            if (C == 0) {
                return h.f١١٠١١b;
            }
            return h.G(Q(C));
        }

        @Override // com.google.protobuf.i
        public double s() {
            return Double.longBitsToDouble(S());
        }

        @Override // com.google.protobuf.i
        public int t() {
            return C();
        }

        @Override // com.google.protobuf.i
        public int u() {
            return R();
        }

        @Override // com.google.protobuf.i
        public long v() {
            return S();
        }

        @Override // com.google.protobuf.i
        public float w() {
            return Float.intBitsToFloat(R());
        }

        @Override // com.google.protobuf.i
        public void x(int i10, e1.a aVar, v vVar) {
            b();
            this.f١١١٠٢a++;
            aVar.mergeFrom(this, vVar);
            a(r2.c(i10, 4));
            this.f١١١٠٢a--;
        }

        @Override // com.google.protobuf.i
        public int y() {
            return C();
        }

        @Override // com.google.protobuf.i
        public long z() {
            return T();
        }

        private b(byte[] bArr, int i10, int i11, boolean z10) {
            super();
            this.f١١١١٥o = Integer.MAX_VALUE;
            this.f١١١٠٧g = bArr;
            this.f١١١٠٩i = i11 + i10;
            this.f١١١١١k = i10;
            this.f١١١١٢l = i10;
            this.f١١١٠٨h = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c extends i {

        /* renamed from: g, reason: collision with root package name */
        private final InputStream f١١١١٦g;

        /* renamed from: h, reason: collision with root package name */
        private final byte[] f١١١١٧h;

        /* renamed from: i, reason: collision with root package name */
        private int f١١١١٨i;

        /* renamed from: j, reason: collision with root package name */
        private int f١١١١٩j;

        /* renamed from: k, reason: collision with root package name */
        private int f١١١٢٠k;

        /* renamed from: l, reason: collision with root package name */
        private int f١١١٢١l;

        /* renamed from: m, reason: collision with root package name */
        private int f١١١٢٢m;

        /* renamed from: n, reason: collision with root package name */
        private int f١١١٢٣n;

        private static int P(InputStream inputStream) {
            try {
                return inputStream.available();
            } catch (k0 e10) {
                e10.i();
                throw e10;
            }
        }

        private static int Q(InputStream inputStream, byte[] bArr, int i10, int i11) {
            try {
                return inputStream.read(bArr, i10, i11);
            } catch (k0 e10) {
                e10.i();
                throw e10;
            }
        }

        private h R(int i10) {
            byte[] U = U(i10);
            if (U != null) {
                return h.m(U);
            }
            int i11 = this.f١١١٢٠k;
            int i12 = this.f١١١١٨i;
            int i13 = i12 - i11;
            this.f١١١٢٢m += i12;
            this.f١١١٢٠k = 0;
            this.f١١١١٨i = 0;
            List<byte[]> V = V(i10 - i13);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f١١١١٧h, i11, bArr, 0, i13);
            for (byte[] bArr2 : V) {
                System.arraycopy(bArr2, 0, bArr, i13, bArr2.length);
                i13 += bArr2.length;
            }
            return h.G(bArr);
        }

        private byte[] T(int i10, boolean z10) {
            byte[] U = U(i10);
            if (U != null) {
                if (z10) {
                    return (byte[]) U.clone();
                }
                return U;
            }
            int i11 = this.f١١١٢٠k;
            int i12 = this.f١١١١٨i;
            int i13 = i12 - i11;
            this.f١١١٢٢m += i12;
            this.f١١١٢٠k = 0;
            this.f١١١١٨i = 0;
            List<byte[]> V = V(i10 - i13);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f١١١١٧h, i11, bArr, 0, i13);
            for (byte[] bArr2 : V) {
                System.arraycopy(bArr2, 0, bArr, i13, bArr2.length);
                i13 += bArr2.length;
            }
            return bArr;
        }

        private byte[] U(int i10) {
            if (i10 == 0) {
                return j0.f١١١٦٤d;
            }
            if (i10 >= 0) {
                int i11 = this.f١١١٢٢m;
                int i12 = this.f١١١٢٠k;
                int i13 = i11 + i12 + i10;
                if (i13 - this.f١١١٠٤c <= 0) {
                    int i14 = this.f١١١٢٣n;
                    if (i13 <= i14) {
                        int i15 = this.f١١١١٨i - i12;
                        int i16 = i10 - i15;
                        if (i16 >= 4096 && i16 > P(this.f١١١١٦g)) {
                            return null;
                        }
                        byte[] bArr = new byte[i10];
                        System.arraycopy(this.f١١١١٧h, this.f١١١٢٠k, bArr, 0, i15);
                        this.f١١١٢٢m += this.f١١١١٨i;
                        this.f١١١٢٠k = 0;
                        this.f١١١١٨i = 0;
                        while (i15 < i10) {
                            int Q = Q(this.f١١١١٦g, bArr, i15, i10 - i15);
                            if (Q != -1) {
                                this.f١١١٢٢m += Q;
                                i15 += Q;
                            } else {
                                throw k0.l();
                            }
                        }
                        return bArr;
                    }
                    e0((i14 - i11) - i12);
                    throw k0.l();
                }
                throw k0.k();
            }
            throw k0.f();
        }

        private List V(int i10) {
            ArrayList arrayList = new ArrayList();
            while (i10 > 0) {
                int min = Math.min(i10, 4096);
                byte[] bArr = new byte[min];
                int i11 = 0;
                while (i11 < min) {
                    int read = this.f١١١١٦g.read(bArr, i11, min - i11);
                    if (read != -1) {
                        this.f١١١٢٢m += read;
                        i11 += read;
                    } else {
                        throw k0.l();
                    }
                }
                i10 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void a0() {
            int i10 = this.f١١١١٨i + this.f١١١١٩j;
            this.f١١١١٨i = i10;
            int i11 = this.f١١١٢٢m + i10;
            int i12 = this.f١١١٢٣n;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f١١١١٩j = i13;
                this.f١١١١٨i = i10 - i13;
                return;
            }
            this.f١١١١٩j = 0;
        }

        private void b0(int i10) {
            if (!j0(i10)) {
                if (i10 > (this.f١١١٠٤c - this.f١١١٢٢m) - this.f١١١٢٠k) {
                    throw k0.k();
                }
                throw k0.l();
            }
        }

        private static long c0(InputStream inputStream, long j10) {
            try {
                return inputStream.skip(j10);
            } catch (k0 e10) {
                e10.i();
                throw e10;
            }
        }

        private void f0(int i10) {
            if (i10 >= 0) {
                int i11 = this.f١١١٢٢m;
                int i12 = this.f١١١٢٠k;
                int i13 = i11 + i12 + i10;
                int i14 = this.f١١١٢٣n;
                if (i13 <= i14) {
                    this.f١١١٢٢m = i11 + i12;
                    int i15 = this.f١١١١٨i - i12;
                    this.f١١١١٨i = 0;
                    this.f١١١٢٠k = 0;
                    while (i15 < i10) {
                        try {
                            long j10 = i10 - i15;
                            long c02 = c0(this.f١١١١٦g, j10);
                            if (c02 >= 0 && c02 <= j10) {
                                if (c02 == 0) {
                                    break;
                                } else {
                                    i15 += (int) c02;
                                }
                            } else {
                                throw new IllegalStateException(this.f١١١١٦g.getClass() + "#skip returned invalid result: " + c02 + "\nThe InputStream implementation is buggy.");
                            }
                        } finally {
                            this.f١١١٢٢m += i15;
                            a0();
                        }
                    }
                    if (i15 < i10) {
                        int i16 = this.f١١١١٨i;
                        int i17 = i16 - this.f١١١٢٠k;
                        this.f١١١٢٠k = i16;
                        b0(1);
                        while (true) {
                            int i18 = i10 - i17;
                            int i19 = this.f١١١١٨i;
                            if (i18 > i19) {
                                i17 += i19;
                                this.f١١١٢٠k = i19;
                                b0(1);
                            } else {
                                this.f١١١٢٠k = i18;
                                return;
                            }
                        }
                    }
                } else {
                    e0((i14 - i11) - i12);
                    throw k0.l();
                }
            } else {
                throw k0.f();
            }
        }

        private void g0() {
            if (this.f١١١١٨i - this.f١١١٢٠k >= 10) {
                h0();
            } else {
                i0();
            }
        }

        private void h0() {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.f١١١١٧h;
                int i11 = this.f١١١٢٠k;
                this.f١١١٢٠k = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw k0.e();
        }

        private void i0() {
            for (int i10 = 0; i10 < 10; i10++) {
                if (S() >= 0) {
                    return;
                }
            }
            throw k0.e();
        }

        private boolean j0(int i10) {
            int i11 = this.f١١١٢٠k;
            int i12 = i11 + i10;
            int i13 = this.f١١١١٨i;
            if (i12 > i13) {
                int i14 = this.f١١١٠٤c;
                int i15 = this.f١١١٢٢m;
                if (i10 > (i14 - i15) - i11 || i15 + i11 + i10 > this.f١١١٢٣n) {
                    return false;
                }
                if (i11 > 0) {
                    if (i13 > i11) {
                        byte[] bArr = this.f١١١١٧h;
                        System.arraycopy(bArr, i11, bArr, 0, i13 - i11);
                    }
                    this.f١١١٢٢m += i11;
                    this.f١١١١٨i -= i11;
                    this.f١١١٢٠k = 0;
                }
                InputStream inputStream = this.f١١١١٦g;
                byte[] bArr2 = this.f١١١١٧h;
                int i16 = this.f١١١١٨i;
                int Q = Q(inputStream, bArr2, i16, Math.min(bArr2.length - i16, (this.f١١١٠٤c - this.f١١١٢٢m) - i16));
                if (Q != 0 && Q >= -1 && Q <= this.f١١١١٧h.length) {
                    if (Q <= 0) {
                        return false;
                    }
                    this.f١١١١٨i += Q;
                    a0();
                    if (this.f١١١١٨i >= i10) {
                        return true;
                    }
                    return j0(i10);
                }
                throw new IllegalStateException(this.f١١١١٦g.getClass() + "#read(byte[]) returned invalid result: " + Q + "\nThe InputStream implementation is buggy.");
            }
            throw new IllegalStateException("refillBuffer() called when " + i10 + " bytes were already available in buffer");
        }

        @Override // com.google.protobuf.i
        public e1 A(r1 r1Var, v vVar) {
            int C = C();
            b();
            int p10 = p(C);
            this.f١١١٠٢a++;
            e1 e1Var = (e1) r1Var.parsePartialFrom(this, vVar);
            a(0);
            this.f١١١٠٢a--;
            if (e() == 0) {
                o(p10);
                return e1Var;
            }
            throw k0.l();
        }

        @Override // com.google.protobuf.i
        public void B(e1.a aVar, v vVar) {
            int C = C();
            b();
            int p10 = p(C);
            this.f١١١٠٢a++;
            aVar.mergeFrom(this, vVar);
            a(0);
            this.f١١١٠٢a--;
            if (e() == 0) {
                o(p10);
                return;
            }
            throw k0.l();
        }

        @Override // com.google.protobuf.i
        public int C() {
            int i10;
            int i11 = this.f١١١٢٠k;
            int i12 = this.f١١١١٨i;
            if (i12 != i11) {
                byte[] bArr = this.f١١١١٧h;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f١١١٢٠k = i13;
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
                    this.f١١١٢٠k = i14;
                    return i10;
                }
            }
            return (int) Z();
        }

        @Override // com.google.protobuf.i
        public int E() {
            return W();
        }

        @Override // com.google.protobuf.i
        public long F() {
            return X();
        }

        @Override // com.google.protobuf.i
        public int G() {
            return i.c(C());
        }

        @Override // com.google.protobuf.i
        public long H() {
            return i.d(Y());
        }

        @Override // com.google.protobuf.i
        public String I() {
            int C = C();
            if (C > 0) {
                int i10 = this.f١١١١٨i;
                int i11 = this.f١١١٢٠k;
                if (C <= i10 - i11) {
                    String str = new String(this.f١١١١٧h, i11, C, j0.f١١١٦٢b);
                    this.f١١١٢٠k += C;
                    return str;
                }
            }
            if (C == 0) {
                return "";
            }
            if (C <= this.f١١١١٨i) {
                b0(C);
                String str2 = new String(this.f١١١١٧h, this.f١١١٢٠k, C, j0.f١١١٦٢b);
                this.f١١١٢٠k += C;
                return str2;
            }
            return new String(T(C, false), j0.f١١١٦٢b);
        }

        @Override // com.google.protobuf.i
        public String J() {
            byte[] T;
            int C = C();
            int i10 = this.f١١١٢٠k;
            int i11 = this.f١١١١٨i;
            if (C <= i11 - i10 && C > 0) {
                T = this.f١١١١٧h;
                this.f١١١٢٠k = i10 + C;
            } else {
                if (C == 0) {
                    return "";
                }
                i10 = 0;
                if (C <= i11) {
                    b0(C);
                    T = this.f١١١١٧h;
                    this.f١١١٢٠k = C;
                } else {
                    T = T(C, false);
                }
            }
            return q2.h(T, i10, C);
        }

        @Override // com.google.protobuf.i
        public int K() {
            if (g()) {
                this.f١١١٢١l = 0;
                return 0;
            }
            int C = C();
            this.f١١١٢١l = C;
            if (r2.a(C) != 0) {
                return this.f١١١٢١l;
            }
            throw k0.b();
        }

        @Override // com.google.protobuf.i
        public int L() {
            return C();
        }

        @Override // com.google.protobuf.i
        public long M() {
            return Y();
        }

        @Override // com.google.protobuf.i
        public boolean O(int i10) {
            int b10 = r2.b(i10);
            if (b10 != 0) {
                if (b10 != 1) {
                    if (b10 != 2) {
                        if (b10 != 3) {
                            if (b10 != 4) {
                                if (b10 == 5) {
                                    e0(4);
                                    return true;
                                }
                                throw k0.d();
                            }
                            return false;
                        }
                        d0();
                        a(r2.c(r2.a(i10), 4));
                        return true;
                    }
                    e0(C());
                    return true;
                }
                e0(8);
                return true;
            }
            g0();
            return true;
        }

        public byte S() {
            if (this.f١١١٢٠k == this.f١١١١٨i) {
                b0(1);
            }
            byte[] bArr = this.f١١١١٧h;
            int i10 = this.f١١١٢٠k;
            this.f١١١٢٠k = i10 + 1;
            return bArr[i10];
        }

        public int W() {
            int i10 = this.f١١١٢٠k;
            if (this.f١١١١٨i - i10 < 4) {
                b0(4);
                i10 = this.f١١١٢٠k;
            }
            byte[] bArr = this.f١١١١٧h;
            this.f١١١٢٠k = i10 + 4;
            return ((bArr[i10 + 3] & UByte.MAX_VALUE) << 24) | (bArr[i10] & UByte.MAX_VALUE) | ((bArr[i10 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i10 + 2] & UByte.MAX_VALUE) << 16);
        }

        public long X() {
            int i10 = this.f١١١٢٠k;
            if (this.f١١١١٨i - i10 < 8) {
                b0(8);
                i10 = this.f١١١٢٠k;
            }
            byte[] bArr = this.f١١١١٧h;
            this.f١١١٢٠k = i10 + 8;
            return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
        }

        public long Y() {
            long j10;
            long j11;
            long j12;
            int i10 = this.f١١١٢٠k;
            int i11 = this.f١١١١٨i;
            if (i11 != i10) {
                byte[] bArr = this.f١١١١٧h;
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    this.f١١١٢٠k = i12;
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
                    this.f١١١٢٠k = i13;
                    return j10;
                }
            }
            return Z();
        }

        long Z() {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & ByteCompanionObject.MAX_VALUE) << i10;
                if ((S() & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j10;
                }
            }
            throw k0.e();
        }

        @Override // com.google.protobuf.i
        public void a(int i10) {
            if (this.f١١١٢١l == i10) {
            } else {
                throw k0.a();
            }
        }

        public void d0() {
            int K;
            do {
                K = K();
                if (K == 0) {
                    return;
                }
            } while (O(K));
        }

        @Override // com.google.protobuf.i
        public int e() {
            int i10 = this.f١١١٢٣n;
            if (i10 == Integer.MAX_VALUE) {
                return -1;
            }
            return i10 - (this.f١١١٢٢m + this.f١١١٢٠k);
        }

        public void e0(int i10) {
            int i11 = this.f١١١١٨i;
            int i12 = this.f١١١٢٠k;
            if (i10 <= i11 - i12 && i10 >= 0) {
                this.f١١١٢٠k = i12 + i10;
            } else {
                f0(i10);
            }
        }

        @Override // com.google.protobuf.i
        public int f() {
            return this.f١١١٢٢m + this.f١١١٢٠k;
        }

        @Override // com.google.protobuf.i
        public boolean g() {
            if (this.f١١١٢٠k == this.f١١١١٨i && !j0(1)) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.i
        public void o(int i10) {
            this.f١١١٢٣n = i10;
            a0();
        }

        @Override // com.google.protobuf.i
        public int p(int i10) {
            if (i10 >= 0) {
                int i11 = i10 + this.f١١١٢٢m + this.f١١١٢٠k;
                int i12 = this.f١١١٢٣n;
                if (i11 <= i12) {
                    this.f١١١٢٣n = i11;
                    a0();
                    return i12;
                }
                throw k0.l();
            }
            throw k0.f();
        }

        @Override // com.google.protobuf.i
        public boolean q() {
            if (Y() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.i
        public h r() {
            int C = C();
            int i10 = this.f١١١١٨i;
            int i11 = this.f١١١٢٠k;
            if (C <= i10 - i11 && C > 0) {
                h n10 = h.n(this.f١١١١٧h, i11, C);
                this.f١١١٢٠k += C;
                return n10;
            }
            if (C == 0) {
                return h.f١١٠١١b;
            }
            return R(C);
        }

        @Override // com.google.protobuf.i
        public double s() {
            return Double.longBitsToDouble(X());
        }

        @Override // com.google.protobuf.i
        public int t() {
            return C();
        }

        @Override // com.google.protobuf.i
        public int u() {
            return W();
        }

        @Override // com.google.protobuf.i
        public long v() {
            return X();
        }

        @Override // com.google.protobuf.i
        public float w() {
            return Float.intBitsToFloat(W());
        }

        @Override // com.google.protobuf.i
        public void x(int i10, e1.a aVar, v vVar) {
            b();
            this.f١١١٠٢a++;
            aVar.mergeFrom(this, vVar);
            a(r2.c(i10, 4));
            this.f١١١٠٢a--;
        }

        @Override // com.google.protobuf.i
        public int y() {
            return C();
        }

        @Override // com.google.protobuf.i
        public long z() {
            return Y();
        }

        private c(InputStream inputStream, int i10) {
            super();
            this.f١١١٢٣n = Integer.MAX_VALUE;
            j0.b(inputStream, "input");
            this.f١١١١٦g = inputStream;
            this.f١١١١٧h = new byte[i10];
            this.f١١١١٨i = 0;
            this.f١١١٢٠k = 0;
            this.f١١١٢٢m = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class d extends i {

        /* renamed from: g, reason: collision with root package name */
        private final ByteBuffer f١١١٢٤g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f١١١٢٥h;

        /* renamed from: i, reason: collision with root package name */
        private final long f١١١٢٦i;

        /* renamed from: j, reason: collision with root package name */
        private long f١١١٢٧j;

        /* renamed from: k, reason: collision with root package name */
        private long f١١١٢٨k;

        /* renamed from: l, reason: collision with root package name */
        private long f١١١٢٩l;

        /* renamed from: m, reason: collision with root package name */
        private int f١١١٣٠m;

        /* renamed from: n, reason: collision with root package name */
        private int f١١١٣١n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f١١١٣٢o;

        /* renamed from: p, reason: collision with root package name */
        private int f١١١٣٣p;

        private int P(long j10) {
            return (int) (j10 - this.f١١١٢٦i);
        }

        static boolean Q() {
            return p2.K();
        }

        private void W() {
            long j10 = this.f١١١٢٧j + this.f١١١٣٠m;
            this.f١١١٢٧j = j10;
            int i10 = (int) (j10 - this.f١١١٢٩l);
            int i11 = this.f١١١٣٣p;
            if (i10 > i11) {
                int i12 = i10 - i11;
                this.f١١١٣٠m = i12;
                this.f١١١٢٧j = j10 - i12;
                return;
            }
            this.f١١١٣٠m = 0;
        }

        private int X() {
            return (int) (this.f١١١٢٧j - this.f١١١٢٨k);
        }

        private void a0() {
            if (X() >= 10) {
                b0();
            } else {
                c0();
            }
        }

        private void b0() {
            for (int i10 = 0; i10 < 10; i10++) {
                long j10 = this.f١١١٢٨k;
                this.f١١١٢٨k = 1 + j10;
                if (p2.w(j10) >= 0) {
                    return;
                }
            }
            throw k0.e();
        }

        private void c0() {
            for (int i10 = 0; i10 < 10; i10++) {
                if (R() >= 0) {
                    return;
                }
            }
            throw k0.e();
        }

        private ByteBuffer d0(long j10, long j11) {
            int position = this.f١١١٢٤g.position();
            int limit = this.f١١١٢٤g.limit();
            ByteBuffer byteBuffer = this.f١١١٢٤g;
            try {
                try {
                    byteBuffer.position(P(j10));
                    byteBuffer.limit(P(j11));
                    return this.f١١١٢٤g.slice();
                } catch (IllegalArgumentException e10) {
                    k0 l10 = k0.l();
                    l10.initCause(e10);
                    throw l10;
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        @Override // com.google.protobuf.i
        public e1 A(r1 r1Var, v vVar) {
            int C = C();
            b();
            int p10 = p(C);
            this.f١١١٠٢a++;
            e1 e1Var = (e1) r1Var.parsePartialFrom(this, vVar);
            a(0);
            this.f١١١٠٢a--;
            if (e() == 0) {
                o(p10);
                return e1Var;
            }
            throw k0.l();
        }

        @Override // com.google.protobuf.i
        public void B(e1.a aVar, v vVar) {
            int C = C();
            b();
            int p10 = p(C);
            this.f١١١٠٢a++;
            aVar.mergeFrom(this, vVar);
            a(0);
            this.f١١١٠٢a--;
            if (e() == 0) {
                o(p10);
                return;
            }
            throw k0.l();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (com.google.protobuf.p2.w(r3) < 0) goto L٣٤;
         */
        @Override // com.google.protobuf.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int C() {
            int i10;
            long j10 = this.f١١١٢٨k;
            if (this.f١١١٢٧j != j10) {
                long j11 = 1 + j10;
                byte w10 = p2.w(j10);
                if (w10 >= 0) {
                    this.f١١١٢٨k = j11;
                    return w10;
                }
                if (this.f١١١٢٧j - j11 >= 9) {
                    long j12 = 2 + j10;
                    int w11 = (p2.w(j11) << 7) ^ w10;
                    if (w11 < 0) {
                        i10 = w11 ^ (-128);
                    } else {
                        long j13 = 3 + j10;
                        int w12 = w11 ^ (p2.w(j12) << 14);
                        if (w12 >= 0) {
                            i10 = w12 ^ 16256;
                        } else {
                            j12 = 4 + j10;
                            int w13 = w12 ^ (p2.w(j13) << 21);
                            if (w13 < 0) {
                                i10 = (-2080896) ^ w13;
                            } else {
                                j13 = 5 + j10;
                                byte w14 = p2.w(j12);
                                int i11 = (w13 ^ (w14 << 28)) ^ 266354560;
                                if (w14 < 0) {
                                    j12 = 6 + j10;
                                    if (p2.w(j13) < 0) {
                                        j13 = 7 + j10;
                                        if (p2.w(j12) < 0) {
                                            j12 = 8 + j10;
                                            if (p2.w(j13) < 0) {
                                                j13 = j10 + 9;
                                                if (p2.w(j12) < 0) {
                                                    j12 = 10 + j10;
                                                }
                                            }
                                        }
                                    }
                                    i10 = i11;
                                }
                                i10 = i11;
                            }
                        }
                        j12 = j13;
                    }
                    this.f١١١٢٨k = j12;
                    return i10;
                }
            }
            return (int) V();
        }

        @Override // com.google.protobuf.i
        public int E() {
            return S();
        }

        @Override // com.google.protobuf.i
        public long F() {
            return T();
        }

        @Override // com.google.protobuf.i
        public int G() {
            return i.c(C());
        }

        @Override // com.google.protobuf.i
        public long H() {
            return i.d(U());
        }

        @Override // com.google.protobuf.i
        public String I() {
            int C = C();
            if (C > 0 && C <= X()) {
                byte[] bArr = new byte[C];
                long j10 = C;
                p2.p(this.f١١١٢٨k, bArr, 0L, j10);
                String str = new String(bArr, j0.f١١١٦٢b);
                this.f١١١٢٨k += j10;
                return str;
            }
            if (C == 0) {
                return "";
            }
            if (C < 0) {
                throw k0.f();
            }
            throw k0.l();
        }

        @Override // com.google.protobuf.i
        public String J() {
            int C = C();
            if (C > 0 && C <= X()) {
                String g10 = q2.g(this.f١١١٢٤g, P(this.f١١١٢٨k), C);
                this.f١١١٢٨k += C;
                return g10;
            }
            if (C == 0) {
                return "";
            }
            if (C <= 0) {
                throw k0.f();
            }
            throw k0.l();
        }

        @Override // com.google.protobuf.i
        public int K() {
            if (g()) {
                this.f١١١٣١n = 0;
                return 0;
            }
            int C = C();
            this.f١١١٣١n = C;
            if (r2.a(C) != 0) {
                return this.f١١١٣١n;
            }
            throw k0.b();
        }

        @Override // com.google.protobuf.i
        public int L() {
            return C();
        }

        @Override // com.google.protobuf.i
        public long M() {
            return U();
        }

        @Override // com.google.protobuf.i
        public boolean O(int i10) {
            int b10 = r2.b(i10);
            if (b10 != 0) {
                if (b10 != 1) {
                    if (b10 != 2) {
                        if (b10 != 3) {
                            if (b10 != 4) {
                                if (b10 == 5) {
                                    Z(4);
                                    return true;
                                }
                                throw k0.d();
                            }
                            return false;
                        }
                        Y();
                        a(r2.c(r2.a(i10), 4));
                        return true;
                    }
                    Z(C());
                    return true;
                }
                Z(8);
                return true;
            }
            a0();
            return true;
        }

        public byte R() {
            long j10 = this.f١١١٢٨k;
            if (j10 != this.f١١١٢٧j) {
                this.f١١١٢٨k = 1 + j10;
                return p2.w(j10);
            }
            throw k0.l();
        }

        public int S() {
            long j10 = this.f١١١٢٨k;
            if (this.f١١١٢٧j - j10 >= 4) {
                this.f١١١٢٨k = 4 + j10;
                return ((p2.w(j10 + 3) & UByte.MAX_VALUE) << 24) | (p2.w(j10) & UByte.MAX_VALUE) | ((p2.w(1 + j10) & UByte.MAX_VALUE) << 8) | ((p2.w(2 + j10) & UByte.MAX_VALUE) << 16);
            }
            throw k0.l();
        }

        public long T() {
            long j10 = this.f١١١٢٨k;
            if (this.f١١١٢٧j - j10 >= 8) {
                this.f١١١٢٨k = 8 + j10;
                return ((p2.w(j10 + 7) & 255) << 56) | (p2.w(j10) & 255) | ((p2.w(1 + j10) & 255) << 8) | ((p2.w(2 + j10) & 255) << 16) | ((p2.w(3 + j10) & 255) << 24) | ((p2.w(4 + j10) & 255) << 32) | ((p2.w(5 + j10) & 255) << 40) | ((p2.w(6 + j10) & 255) << 48);
            }
            throw k0.l();
        }

        public long U() {
            long j10;
            long j11;
            long j12;
            int i10;
            long j13 = this.f١١١٢٨k;
            if (this.f١١١٢٧j != j13) {
                long j14 = 1 + j13;
                byte w10 = p2.w(j13);
                if (w10 >= 0) {
                    this.f١١١٢٨k = j14;
                    return w10;
                }
                if (this.f١١١٢٧j - j14 >= 9) {
                    long j15 = 2 + j13;
                    int w11 = (p2.w(j14) << 7) ^ w10;
                    if (w11 < 0) {
                        i10 = w11 ^ (-128);
                    } else {
                        long j16 = 3 + j13;
                        int w12 = w11 ^ (p2.w(j15) << 14);
                        if (w12 >= 0) {
                            j10 = w12 ^ 16256;
                            j15 = j16;
                        } else {
                            j15 = 4 + j13;
                            int w13 = w12 ^ (p2.w(j16) << 21);
                            if (w13 < 0) {
                                i10 = (-2080896) ^ w13;
                            } else {
                                long j17 = 5 + j13;
                                long w14 = w13 ^ (p2.w(j15) << 28);
                                if (w14 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    long j18 = 6 + j13;
                                    long w15 = w14 ^ (p2.w(j17) << 35);
                                    if (w15 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        j17 = 7 + j13;
                                        w14 = w15 ^ (p2.w(j18) << 42);
                                        if (w14 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            j18 = 8 + j13;
                                            w15 = w14 ^ (p2.w(j17) << 49);
                                            if (w15 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                long j19 = j13 + 9;
                                                long w16 = (w15 ^ (p2.w(j18) << 56)) ^ 71499008037633920L;
                                                if (w16 < 0) {
                                                    long j20 = j13 + 10;
                                                    if (p2.w(j19) >= 0) {
                                                        j15 = j20;
                                                        j10 = w16;
                                                    }
                                                } else {
                                                    j10 = w16;
                                                    j15 = j19;
                                                }
                                            }
                                        }
                                    }
                                    j10 = j11 ^ w15;
                                    j15 = j18;
                                }
                                j10 = j12 ^ w14;
                                j15 = j17;
                            }
                        }
                        this.f١١١٢٨k = j15;
                        return j10;
                    }
                    j10 = i10;
                    this.f١١١٢٨k = j15;
                    return j10;
                }
            }
            return V();
        }

        long V() {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & ByteCompanionObject.MAX_VALUE) << i10;
                if ((R() & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j10;
                }
            }
            throw k0.e();
        }

        public void Y() {
            int K;
            do {
                K = K();
                if (K == 0) {
                    return;
                }
            } while (O(K));
        }

        public void Z(int i10) {
            if (i10 >= 0 && i10 <= X()) {
                this.f١١١٢٨k += i10;
            } else {
                if (i10 < 0) {
                    throw k0.f();
                }
                throw k0.l();
            }
        }

        @Override // com.google.protobuf.i
        public void a(int i10) {
            if (this.f١١١٣١n == i10) {
            } else {
                throw k0.a();
            }
        }

        @Override // com.google.protobuf.i
        public int e() {
            int i10 = this.f١١١٣٣p;
            if (i10 == Integer.MAX_VALUE) {
                return -1;
            }
            return i10 - f();
        }

        @Override // com.google.protobuf.i
        public int f() {
            return (int) (this.f١١١٢٨k - this.f١١١٢٩l);
        }

        @Override // com.google.protobuf.i
        public boolean g() {
            if (this.f١١١٢٨k == this.f١١١٢٧j) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.i
        public void o(int i10) {
            this.f١١١٣٣p = i10;
            W();
        }

        @Override // com.google.protobuf.i
        public int p(int i10) {
            if (i10 >= 0) {
                int f10 = i10 + f();
                int i11 = this.f١١١٣٣p;
                if (f10 <= i11) {
                    this.f١١١٣٣p = f10;
                    W();
                    return i11;
                }
                throw k0.l();
            }
            throw k0.f();
        }

        @Override // com.google.protobuf.i
        public boolean q() {
            if (U() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.i
        public h r() {
            int C = C();
            if (C > 0 && C <= X()) {
                if (this.f١١١٢٥h && this.f١١١٣٢o) {
                    long j10 = this.f١١١٢٨k;
                    long j11 = C;
                    ByteBuffer d02 = d0(j10, j10 + j11);
                    this.f١١١٢٨k += j11;
                    return h.F(d02);
                }
                byte[] bArr = new byte[C];
                long j12 = C;
                p2.p(this.f١١١٢٨k, bArr, 0L, j12);
                this.f١١١٢٨k += j12;
                return h.G(bArr);
            }
            if (C == 0) {
                return h.f١١٠١١b;
            }
            if (C < 0) {
                throw k0.f();
            }
            throw k0.l();
        }

        @Override // com.google.protobuf.i
        public double s() {
            return Double.longBitsToDouble(T());
        }

        @Override // com.google.protobuf.i
        public int t() {
            return C();
        }

        @Override // com.google.protobuf.i
        public int u() {
            return S();
        }

        @Override // com.google.protobuf.i
        public long v() {
            return T();
        }

        @Override // com.google.protobuf.i
        public float w() {
            return Float.intBitsToFloat(S());
        }

        @Override // com.google.protobuf.i
        public void x(int i10, e1.a aVar, v vVar) {
            b();
            this.f١١١٠٢a++;
            aVar.mergeFrom(this, vVar);
            a(r2.c(i10, 4));
            this.f١١١٠٢a--;
        }

        @Override // com.google.protobuf.i
        public int y() {
            return C();
        }

        @Override // com.google.protobuf.i
        public long z() {
            return U();
        }

        private d(ByteBuffer byteBuffer, boolean z10) {
            super();
            this.f١١١٣٣p = Integer.MAX_VALUE;
            this.f١١١٢٤g = byteBuffer;
            long k10 = p2.k(byteBuffer);
            this.f١١١٢٦i = k10;
            this.f١١١٢٧j = byteBuffer.limit() + k10;
            long position = k10 + byteBuffer.position();
            this.f١١١٢٨k = position;
            this.f١١١٢٩l = position;
            this.f١١١٢٥h = z10;
        }
    }

    public static int D(int i10, InputStream inputStream) {
        if ((i10 & 128) == 0) {
            return i10;
        }
        int i11 = i10 & Constants.ERR_WATERMARKR_INFO;
        int i12 = 7;
        while (i12 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i11 |= (read & Constants.ERR_WATERMARKR_INFO) << i12;
                if ((read & 128) == 0) {
                    return i11;
                }
                i12 += 7;
            } else {
                throw k0.l();
            }
        }
        while (i12 < 64) {
            int read2 = inputStream.read();
            if (read2 != -1) {
                if ((read2 & 128) == 0) {
                    return i11;
                }
                i12 += 7;
            } else {
                throw k0.l();
            }
        }
        throw k0.e();
    }

    public static int c(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long d(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static i h(InputStream inputStream) {
        return i(inputStream, 4096);
    }

    public static i i(InputStream inputStream, int i10) {
        if (i10 > 0) {
            if (inputStream == null) {
                return l(j0.f١١١٦٤d);
            }
            return new c(inputStream, i10);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static i j(ByteBuffer byteBuffer) {
        return k(byteBuffer, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i k(ByteBuffer byteBuffer, boolean z10) {
        if (byteBuffer.hasArray()) {
            return n(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z10);
        }
        if (byteBuffer.isDirect() && d.Q()) {
            return new d(byteBuffer, z10);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return n(bArr, 0, remaining, true);
    }

    public static i l(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    public static i m(byte[] bArr, int i10, int i11) {
        return n(bArr, i10, i11, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i n(byte[] bArr, int i10, int i11, boolean z10) {
        b bVar = new b(bArr, i10, i11, z10);
        try {
            bVar.p(i11);
            return bVar;
        } catch (k0 e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public abstract e1 A(r1 r1Var, v vVar);

    public abstract void B(e1.a aVar, v vVar);

    public abstract int C();

    public abstract int E();

    public abstract long F();

    public abstract int G();

    public abstract long H();

    public abstract String I();

    public abstract String J();

    public abstract int K();

    public abstract int L();

    public abstract long M();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean N() {
        return this.f١١١٠٦e;
    }

    public abstract boolean O(int i10);

    public abstract void a(int i10);

    public void b() {
        if (this.f١١١٠٢a < this.f١١١٠٣b) {
        } else {
            throw k0.h();
        }
    }

    public abstract int e();

    public abstract int f();

    public abstract boolean g();

    public abstract void o(int i10);

    public abstract int p(int i10);

    public abstract boolean q();

    public abstract h r();

    public abstract double s();

    public abstract int t();

    public abstract int u();

    public abstract long v();

    public abstract float w();

    public abstract void x(int i10, e1.a aVar, v vVar);

    public abstract int y();

    public abstract long z();

    private i() {
        this.f١١١٠٣b = f١١١٠١f;
        this.f١١١٠٤c = Integer.MAX_VALUE;
        this.f١١١٠٦e = false;
    }
}
