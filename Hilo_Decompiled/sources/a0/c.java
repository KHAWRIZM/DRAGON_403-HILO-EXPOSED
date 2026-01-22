package a0;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import k0.l;
import k0.n;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c extends y.a {

    /* renamed from: a, reason: collision with root package name */
    public int f٥٧a;

    /* renamed from: b, reason: collision with root package name */
    public int f٥٨b;

    /* renamed from: c, reason: collision with root package name */
    public int f٥٩c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f٦٠d;

    /* renamed from: f, reason: collision with root package name */
    public int f٦٢f;

    /* renamed from: g, reason: collision with root package name */
    public l f٦٣g;

    /* renamed from: i, reason: collision with root package name */
    public int f٦٥i;

    /* renamed from: j, reason: collision with root package name */
    public int f٦٦j;

    /* renamed from: k, reason: collision with root package name */
    public int f٦٧k;

    /* renamed from: l, reason: collision with root package name */
    public int f٦٨l;

    /* renamed from: m, reason: collision with root package name */
    public int f٦٩m;

    /* renamed from: n, reason: collision with root package name */
    public int f٧٠n;

    /* renamed from: o, reason: collision with root package name */
    public int f٧١o;

    /* renamed from: p, reason: collision with root package name */
    public int f٧٢p;

    /* renamed from: q, reason: collision with root package name */
    public int f٧٣q;

    /* renamed from: r, reason: collision with root package name */
    public int f٧٤r;

    /* renamed from: s, reason: collision with root package name */
    public int f٧٥s;

    /* renamed from: t, reason: collision with root package name */
    public char f٧٦t;

    /* renamed from: u, reason: collision with root package name */
    public a f٧٧u;

    /* renamed from: e, reason: collision with root package name */
    public final b f٦١e = new b();

    /* renamed from: h, reason: collision with root package name */
    public int f٦٤h = 1;

    public c(InputStream inputStream) {
        l lVar = new l(inputStream == System.in ? new n(inputStream) : inputStream, ByteOrder.BIG_ENDIAN);
        this.f٦٣g = lVar;
        int readBits = (int) lVar.readBits(8);
        int readBits2 = (int) this.f٦٣g.readBits(8);
        int readBits3 = (int) this.f٦٣g.readBits(8);
        if (readBits == 66 && readBits2 == 90 && readBits3 == 104) {
            int readBits4 = (int) this.f٦٣g.readBits(8);
            if (readBits4 >= 49 && readBits4 <= 57) {
                this.f٥٩c = readBits4 - 48;
                this.f٦٧k = 0;
                b();
                return;
            }
            throw new IOException("BZip2 block size is invalid");
        }
        throw new IOException("Stream is not in the BZip2 format");
    }

    public static int a(l lVar, int i10) {
        long readBits = lVar.readBits(i10);
        if (readBits >= 0) {
            return (int) readBits;
        }
        throw new IOException("Unexpected end of stream");
    }

    public static void c(int i10, int i11, String str) {
        if (i10 >= 0) {
            if (i10 < i11) {
                return;
            }
            throw new IOException("Corrupted input, " + str + " value too big");
        }
        throw new IOException("Corrupted input, " + str + " value negative");
    }

    public final void b() {
        boolean z10;
        String str;
        int i10;
        int i11;
        char[] cArr;
        char c10;
        int i12;
        int i13;
        int i14;
        c cVar = this;
        l lVar = cVar.f٦٣g;
        char a10 = (char) a(lVar, 8);
        char a11 = (char) a(lVar, 8);
        char a12 = (char) a(lVar, 8);
        char a13 = (char) a(lVar, 8);
        char a14 = (char) a(lVar, 8);
        char a15 = (char) a(lVar, 8);
        int i15 = 0;
        if (a10 == 23 && a11 == 'r' && a12 == 'E' && a13 == '8' && a14 == 'P' && a15 == 144) {
            int a16 = a(cVar.f٦٣g, 32);
            cVar.f٦٦j = a16;
            cVar.f٦٤h = 0;
            cVar.f٧٧u = null;
            if (a16 == cVar.f٦٧k) {
                return;
            } else {
                throw new IOException("BZip2 CRC error");
            }
        }
        if (a10 == '1' && a11 == 'A' && a12 == 'Y' && a13 == '&' && a14 == 'S' && a15 == 'Y') {
            cVar.f٦٥i = a(lVar, 32);
            if (a(lVar, 1) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            cVar.f٦٠d = z10;
            if (cVar.f٧٧u == null) {
                cVar.f٧٧u = new a(cVar.f٥٩c);
            }
            l lVar2 = cVar.f٦٣g;
            cVar.f٥٨b = a(lVar2, 24);
            l lVar3 = cVar.f٦٣g;
            a aVar = cVar.f٧٧u;
            boolean[] zArr = aVar.f٤٠a;
            byte[] bArr = aVar.f٥٢m;
            byte[] bArr2 = aVar.f٤٢c;
            byte[] bArr3 = aVar.f٤٣d;
            int i16 = 0;
            for (int i17 = 0; i17 < 16; i17++) {
                if (a(lVar3, 1) != 0) {
                    i16 |= 1 << i17;
                }
            }
            Arrays.fill(zArr, false);
            for (int i18 = 0; i18 < 16; i18++) {
                if ((i16 & (1 << i18)) != 0) {
                    int i19 = i18 << 4;
                    for (int i20 = 0; i20 < 16; i20++) {
                        if (a(lVar3, 1) != 0) {
                            zArr[i19 + i20] = true;
                        }
                    }
                }
            }
            a aVar2 = cVar.f٧٧u;
            boolean[] zArr2 = aVar2.f٤٠a;
            byte[] bArr4 = aVar2.f٤١b;
            int i21 = 0;
            for (int i22 = 0; i22 < 256; i22++) {
                if (zArr2[i22]) {
                    bArr4[i21] = (byte) i22;
                    i21++;
                }
            }
            cVar.f٦٢f = i21;
            int i23 = i21 + 2;
            int a17 = a(lVar3, 3);
            int a18 = a(lVar3, 15);
            if (a18 >= 0) {
                c(i23, 259, "alphaSize");
                c(a17, 7, "nGroups");
                for (int i24 = 0; i24 < a18; i24++) {
                    int i25 = 0;
                    while (a(lVar3, 1) != 0) {
                        i25++;
                    }
                    if (i24 < 18002) {
                        bArr3[i24] = (byte) i25;
                    }
                }
                if (a18 > 18002) {
                    a18 = 18002;
                }
                int i26 = a17;
                while (true) {
                    i26--;
                    if (i26 < 0) {
                        break;
                    } else {
                        bArr[i26] = (byte) i26;
                    }
                }
                for (int i27 = 0; i27 < a18; i27++) {
                    int i28 = bArr3[i27] & UByte.MAX_VALUE;
                    c(i28, 6, "selectorMtf");
                    byte b10 = bArr[i28];
                    while (i28 > 0) {
                        bArr[i28] = bArr[i28 - 1];
                        i28--;
                    }
                    bArr[0] = b10;
                    bArr2[i27] = b10;
                }
                char[][] cArr2 = aVar.f٥١l;
                for (int i29 = 0; i29 < a17; i29++) {
                    int a19 = a(lVar3, 5);
                    char[] cArr3 = cArr2[i29];
                    for (int i30 = 0; i30 < i23; i30++) {
                        while (a(lVar3, 1) != 0) {
                            if (a(lVar3, 1) != 0) {
                                i14 = -1;
                            } else {
                                i14 = 1;
                            }
                            a19 += i14;
                        }
                        cArr3[i30] = (char) a19;
                    }
                }
                a aVar3 = cVar.f٧٧u;
                char[][] cArr4 = aVar3.f٥١l;
                int[] iArr = aVar3.f٤٨i;
                int[][] iArr2 = aVar3.f٤٥f;
                int[][] iArr3 = aVar3.f٤٦g;
                int[][] iArr4 = aVar3.f٤٧h;
                int i31 = 0;
                while (i31 < a17) {
                    char[] cArr5 = cArr4[i31];
                    int i32 = i23;
                    int i33 = 0;
                    int i34 = 32;
                    while (true) {
                        int i35 = i32 - 1;
                        if (i35 < 0) {
                            break;
                        }
                        char c11 = cArr5[i35];
                        if (c11 > i33) {
                            i33 = c11;
                        }
                        if (c11 < i34) {
                            i34 = c11;
                        }
                        i32 = i35;
                    }
                    int[] iArr5 = iArr2[i31];
                    int[] iArr6 = iArr3[i31];
                    int[] iArr7 = iArr4[i31];
                    char[] cArr6 = cArr4[i31];
                    int i36 = i34;
                    int i37 = 0;
                    while (i36 <= i33) {
                        while (i15 < i23) {
                            int[][] iArr8 = iArr4;
                            if (cArr6[i15] == i36) {
                                iArr7[i37] = i15;
                                i37++;
                            }
                            i15++;
                            iArr4 = iArr8;
                        }
                        i36++;
                        i15 = 0;
                    }
                    int[][] iArr9 = iArr4;
                    int i38 = -1;
                    int i39 = 23;
                    while (true) {
                        i39 += i38;
                        if (i39 <= 0) {
                            break;
                        }
                        iArr6[i39] = 0;
                        iArr5[i39] = 0;
                        i38 = -1;
                    }
                    int i40 = 0;
                    while (i40 < i23) {
                        char c12 = cArr6[i40];
                        c(c12, 258, "length");
                        int i41 = c12 + 1;
                        iArr6[i41] = iArr6[i41] + 1;
                        i40++;
                        cArr4 = cArr4;
                    }
                    char[][] cArr7 = cArr4;
                    int i42 = iArr6[0];
                    for (int i43 = 1; i43 < 23; i43++) {
                        i42 += iArr6[i43];
                        iArr6[i43] = i42;
                    }
                    int i44 = iArr6[i34];
                    int i45 = i34;
                    int i46 = 0;
                    while (i45 <= i33) {
                        int i47 = i45 + 1;
                        int i48 = iArr6[i47];
                        int i49 = (i48 - i44) + i46;
                        iArr5[i45] = i49 - 1;
                        i46 = i49 << 1;
                        i45 = i47;
                        i44 = i48;
                    }
                    int i50 = 1;
                    int i51 = i34 + 1;
                    while (i51 <= i33) {
                        iArr6[i51] = ((iArr5[i51 - 1] + i50) << i50) - iArr6[i51];
                        i51++;
                        i50 = 1;
                    }
                    iArr[i31] = i34;
                    i31++;
                    cArr4 = cArr7;
                    iArr4 = iArr9;
                    i15 = 0;
                }
                a aVar4 = cVar.f٧٧u;
                byte[] bArr5 = aVar4.f٥٤o;
                int[] iArr10 = aVar4.f٤٤e;
                byte[] bArr6 = aVar4.f٤٢c;
                byte[] bArr7 = aVar4.f٤١b;
                char[] cArr8 = aVar4.f٥٠k;
                int[] iArr11 = aVar4.f٤٨i;
                int[][] iArr12 = aVar4.f٤٥f;
                int[][] iArr13 = aVar4.f٤٦g;
                int[][] iArr14 = aVar4.f٤٧h;
                int i52 = cVar.f٥٩c * 100000;
                int i53 = 256;
                while (true) {
                    i53--;
                    if (i53 < 0) {
                        break;
                    }
                    cArr8[i53] = (char) i53;
                    iArr10[i53] = 0;
                }
                int i54 = cVar.f٦٢f + 1;
                a aVar5 = cVar.f٧٧u;
                int i55 = aVar5.f٤٢c[0] & UByte.MAX_VALUE;
                l lVar4 = lVar2;
                c(i55, 6, "zt");
                byte[] bArr8 = bArr5;
                int i56 = aVar5.f٤٨i[i55];
                c(i56, 258, "zn");
                int a20 = a(cVar.f٦٣g, i56);
                char[] cArr9 = cArr8;
                for (int[] iArr15 = aVar5.f٤٥f[i55]; a20 > iArr15[i56]; iArr15 = iArr15) {
                    i56++;
                    c(i56, 258, "zn");
                    a20 = (a20 << 1) | a(cVar.f٦٣g, 1);
                }
                int i57 = a20 - aVar5.f٤٦g[i55][i56];
                c(i57, 258, "zvec");
                int i58 = aVar5.f٤٧h[i55][i57];
                int i59 = bArr6[0] & UByte.MAX_VALUE;
                c(i59, 6, "zt");
                int[] iArr16 = iArr13[i59];
                int[] iArr17 = iArr12[i59];
                int[] iArr18 = iArr14[i59];
                int i60 = iArr11[i59];
                int[] iArr19 = iArr18;
                int i61 = 0;
                int i62 = 49;
                int[] iArr20 = iArr17;
                int i63 = -1;
                while (i58 != i54) {
                    int i64 = i60;
                    String str2 = " exceeds ";
                    int[] iArr21 = iArr16;
                    int i65 = i54;
                    int[] iArr22 = iArr20;
                    if (i58 == 0 || i58 == 1) {
                        l lVar5 = lVar4;
                        char[] cArr10 = cArr9;
                        int i66 = 1;
                        int i67 = -1;
                        while (true) {
                            if (i58 == 0) {
                                i67 += i66;
                                str = str2;
                            } else {
                                str = str2;
                                if (i58 != 1) {
                                    break;
                                } else {
                                    i67 += i66 << 1;
                                }
                            }
                            if (i62 == 0) {
                                int i68 = i61 + 1;
                                c(i68, 18002, "groupNo");
                                int i69 = bArr6[i68] & UByte.MAX_VALUE;
                                c(i69, 6, "zt");
                                iArr21 = iArr13[i69];
                                iArr22 = iArr12[i69];
                                int[] iArr23 = iArr14[i69];
                                i61 = i68;
                                i10 = iArr11[i69];
                                i11 = 258;
                                i62 = 49;
                                iArr19 = iArr23;
                            } else {
                                i62--;
                                i10 = i64;
                                i11 = 258;
                            }
                            c(i10, i11, "zn");
                            int[][] iArr24 = iArr14;
                            int a21 = a(lVar5, i10);
                            int i70 = i10;
                            while (a21 > iArr22[i70]) {
                                int i71 = i70 + 1;
                                c(i71, 258, "zn");
                                a21 = (a21 << 1) | a(lVar5, 1);
                                i70 = i71;
                                bArr6 = bArr6;
                            }
                            int i72 = a21 - iArr21[i70];
                            c(i72, 258, "zvec");
                            i58 = iArr19[i72];
                            i66 <<= 1;
                            i64 = i10;
                            str2 = str;
                            iArr14 = iArr24;
                        }
                        int[][] iArr25 = iArr14;
                        byte[] bArr9 = bArr6;
                        int i73 = i58;
                        char c13 = cArr10[0];
                        c(c13, 256, "yy");
                        byte b11 = bArr7[c13];
                        int i74 = b11 & UByte.MAX_VALUE;
                        iArr10[i74] = i67 + 1 + iArr10[i74];
                        int i75 = i63 + 1;
                        int i76 = i75 + i67;
                        byte[] bArr10 = bArr8;
                        Arrays.fill(bArr10, i75, i76 + 1, b11);
                        if (i76 < i52) {
                            cArr9 = cArr10;
                            bArr8 = bArr10;
                            i58 = i73;
                            i63 = i76;
                            lVar4 = lVar5;
                            i60 = i64;
                            iArr16 = iArr21;
                            i54 = i65;
                            iArr20 = iArr22;
                            iArr14 = iArr25;
                            bArr6 = bArr9;
                        } else {
                            throw new IOException("Block overrun while expanding RLE in MTF, " + i76 + str + i52);
                        }
                    } else {
                        i63++;
                        if (i63 < i52) {
                            c(i58, 257, "nextSym");
                            int i77 = i58 - 1;
                            char c14 = cArr9[i77];
                            c(c14, 256, "yy");
                            byte b12 = bArr7[c14];
                            int i78 = b12 & UByte.MAX_VALUE;
                            iArr10[i78] = iArr10[i78] + 1;
                            bArr8[i63] = b12;
                            if (i58 <= 16) {
                                while (i77 > 0) {
                                    int i79 = i77 - 1;
                                    cArr9[i77] = cArr9[i79];
                                    i77 = i79;
                                }
                                cArr = cArr9;
                                c10 = 0;
                            } else {
                                cArr = cArr9;
                                c10 = 0;
                                System.arraycopy(cArr, 0, cArr, 1, i77);
                            }
                            cArr[c10] = c14;
                            if (i62 == 0) {
                                int i80 = i61 + 1;
                                c(i80, 18002, "groupNo");
                                int i81 = bArr6[i80] & UByte.MAX_VALUE;
                                c(i81, 6, "zt");
                                iArr16 = iArr13[i81];
                                int[] iArr26 = iArr12[i81];
                                int[] iArr27 = iArr14[i81];
                                i12 = iArr11[i81];
                                i61 = i80;
                                iArr19 = iArr27;
                                i13 = 258;
                                i62 = 49;
                                iArr20 = iArr26;
                            } else {
                                i62--;
                                i12 = i64;
                                iArr16 = iArr21;
                                iArr20 = iArr22;
                                i13 = 258;
                            }
                            c(i12, i13, "zn");
                            l lVar6 = lVar4;
                            int i82 = i12;
                            int a22 = a(lVar6, i12);
                            int i83 = i82;
                            while (a22 > iArr20[i83]) {
                                int i84 = i83 + 1;
                                c(i84, 258, "zn");
                                a22 = (a22 << 1) | a(lVar6, 1);
                                i83 = i84;
                                iArr20 = iArr20;
                            }
                            int i85 = a22 - iArr16[i83];
                            c(i85, 258, "zvec");
                            i58 = iArr19[i85];
                            lVar4 = lVar6;
                            i60 = i82;
                            i54 = i65;
                            cArr9 = cArr;
                        } else {
                            throw new IOException("Block overrun in MTF, " + i63 + " exceeds " + i52);
                        }
                    }
                    cVar = this;
                }
                cVar.f٥٧a = i63;
                cVar.f٦١e.f٥٦a = -1;
                cVar.f٦٤h = 1;
                return;
            }
            throw new IOException("Corrupted input, nSelectors value negative");
        }
        cVar.f٦٤h = 0;
        throw new IOException("Bad block header");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        l lVar = this.f٦٣g;
        if (lVar != null) {
            try {
                lVar.close();
            } finally {
                this.f٧٧u = null;
                this.f٦٣g = null;
            }
        }
    }

    public final int g() {
        a aVar;
        if (this.f٦٤h != 0 && (aVar = this.f٧٧u) != null) {
            int[] iArr = aVar.f٤٩j;
            int i10 = this.f٥٧a + 1;
            int[] iArr2 = aVar.f٥٣n;
            if (iArr2 == null || iArr2.length < i10) {
                iArr2 = new int[i10];
                aVar.f٥٣n = iArr2;
            }
            byte[] bArr = aVar.f٥٤o;
            iArr[0] = 0;
            System.arraycopy(aVar.f٤٤e, 0, iArr, 1, 256);
            int i11 = iArr[0];
            for (int i12 = 1; i12 <= 256; i12++) {
                i11 += iArr[i12];
                iArr[i12] = i11;
            }
            int i13 = this.f٥٧a;
            for (int i14 = 0; i14 <= i13; i14++) {
                int i15 = bArr[i14] & UByte.MAX_VALUE;
                int i16 = iArr[i15];
                iArr[i15] = i16 + 1;
                c(i16, i10, "tt index");
                iArr2[i16] = i14;
            }
            int i17 = this.f٥٨b;
            if (i17 >= 0 && i17 < iArr2.length) {
                this.f٧٥s = iArr2[i17];
                this.f٦٨l = 0;
                this.f٧١o = 0;
                this.f٦٩m = 256;
                if (this.f٦٠d) {
                    this.f٧٣q = 0;
                    this.f٧٤r = 0;
                    return k();
                }
                return j();
            }
            throw new IOException("Stream corrupted");
        }
        return -1;
    }

    public final int h() {
        switch (this.f٦٤h) {
            case 0:
                return -1;
            case 1:
                return g();
            case 2:
                throw new IllegalStateException();
            case 3:
                if (this.f٦٩m != this.f٧٠n) {
                    this.f٦٤h = 2;
                    this.f٦٨l = 1;
                    return k();
                }
                int i10 = this.f٦٨l + 1;
                this.f٦٨l = i10;
                if (i10 >= 4) {
                    a aVar = this.f٧٧u;
                    byte[] bArr = aVar.f٥٤o;
                    int i11 = this.f٧٥s;
                    this.f٧٦t = (char) (bArr[i11] & UByte.MAX_VALUE);
                    c(i11, aVar.f٥٣n.length, "su_tPos");
                    this.f٧٥s = this.f٧٧u.f٥٣n[this.f٧٥s];
                    int i12 = this.f٧٣q;
                    if (i12 == 0) {
                        int i13 = this.f٧٤r;
                        this.f٧٣q = d.f٧٨a[i13] - 1;
                        int i14 = i13 + 1;
                        this.f٧٤r = i14;
                        if (i14 == 512) {
                            this.f٧٤r = 0;
                        }
                    } else {
                        this.f٧٣q = i12 - 1;
                    }
                    this.f٧٢p = 0;
                    this.f٦٤h = 4;
                    if (this.f٧٣q == 1) {
                        this.f٧٦t = (char) (this.f٧٦t ^ 1);
                    }
                    if (this.f٧٦t > 0) {
                        this.f٦١e.a(this.f٦٩m);
                        this.f٧٢p++;
                        return this.f٦٩m;
                    }
                    this.f٦٤h = 2;
                    this.f٧١o++;
                    this.f٦٨l = 0;
                    return k();
                }
                this.f٦٤h = 2;
                return k();
            case 4:
                if (this.f٧٢p < this.f٧٦t) {
                    this.f٦١e.a(this.f٦٩m);
                    this.f٧٢p++;
                    return this.f٦٩m;
                }
                this.f٦٤h = 2;
                this.f٧١o++;
                this.f٦٨l = 0;
                return k();
            case 5:
                throw new IllegalStateException();
            case 6:
                if (this.f٦٩m != this.f٧٠n) {
                    this.f٦٨l = 1;
                    return j();
                }
                int i15 = this.f٦٨l + 1;
                this.f٦٨l = i15;
                if (i15 >= 4) {
                    c(this.f٧٥s, this.f٧٧u.f٥٤o.length, "su_tPos");
                    a aVar2 = this.f٧٧u;
                    byte[] bArr2 = aVar2.f٥٤o;
                    int i16 = this.f٧٥s;
                    char c10 = (char) (bArr2[i16] & UByte.MAX_VALUE);
                    this.f٧٦t = c10;
                    this.f٧٥s = aVar2.f٥٣n[i16];
                    this.f٧٢p = 0;
                    if (c10 > 0) {
                        int i17 = this.f٦٩m;
                        this.f٦١e.a(i17);
                        this.f٧٢p++;
                        this.f٦٤h = 7;
                        return i17;
                    }
                    this.f٧١o++;
                    this.f٦٨l = 0;
                    return j();
                }
                return j();
            case 7:
                if (this.f٧٢p < this.f٧٦t) {
                    int i18 = this.f٦٩m;
                    this.f٦١e.a(i18);
                    this.f٧٢p++;
                    this.f٦٤h = 7;
                    return i18;
                }
                this.f٧١o++;
                this.f٦٨l = 0;
                return j();
            default:
                throw new IllegalStateException();
        }
    }

    public final int j() {
        if (this.f٧١o <= this.f٥٧a) {
            this.f٧٠n = this.f٦٩m;
            a aVar = this.f٧٧u;
            byte[] bArr = aVar.f٥٤o;
            int i10 = this.f٧٥s;
            int i11 = bArr[i10] & UByte.MAX_VALUE;
            this.f٦٩m = i11;
            c(i10, aVar.f٥٣n.length, "su_tPos");
            this.f٧٥s = this.f٧٧u.f٥٣n[this.f٧٥s];
            this.f٧١o++;
            this.f٦٤h = 6;
            this.f٦١e.a(i11);
            return i11;
        }
        this.f٦٤h = 5;
        int i12 = ~this.f٦١e.f٥٦a;
        int i13 = this.f٦٥i;
        if (i13 == i12) {
            int i14 = this.f٦٧k;
            this.f٦٧k = i12 ^ ((i14 >>> 31) | (i14 << 1));
            b();
            return g();
        }
        int i15 = this.f٦٦j;
        this.f٦٧k = ((i15 >>> 31) | (i15 << 1)) ^ i13;
        throw new IOException("BZip2 CRC error");
    }

    public final int k() {
        if (this.f٧١o <= this.f٥٧a) {
            this.f٧٠n = this.f٦٩m;
            a aVar = this.f٧٧u;
            byte[] bArr = aVar.f٥٤o;
            int i10 = this.f٧٥s;
            int i11 = bArr[i10] & UByte.MAX_VALUE;
            c(i10, aVar.f٥٣n.length, "su_tPos");
            this.f٧٥s = this.f٧٧u.f٥٣n[this.f٧٥s];
            int i12 = this.f٧٣q;
            int i13 = 0;
            if (i12 == 0) {
                int i14 = this.f٧٤r;
                this.f٧٣q = d.f٧٨a[i14] - 1;
                int i15 = i14 + 1;
                this.f٧٤r = i15;
                if (i15 == 512) {
                    this.f٧٤r = 0;
                }
            } else {
                this.f٧٣q = i12 - 1;
            }
            if (this.f٧٣q == 1) {
                i13 = 1;
            }
            int i16 = i11 ^ i13;
            this.f٦٩m = i16;
            this.f٧١o++;
            this.f٦٤h = 3;
            this.f٦١e.a(i16);
            return i16;
        }
        int i17 = ~this.f٦١e.f٥٦a;
        int i18 = this.f٦٥i;
        if (i18 == i17) {
            int i19 = this.f٦٧k;
            this.f٦٧k = i17 ^ ((i19 >>> 31) | (i19 << 1));
            b();
            return g();
        }
        int i20 = this.f٦٦j;
        this.f٦٧k = ((i20 >>> 31) | (i20 << 1)) ^ i18;
        throw new IOException("BZip2 CRC error");
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.f٦٣g != null) {
            int h10 = h();
            count(h10 < 0 ? -1 : 1);
            return h10;
        }
        throw new IOException("Stream closed");
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("offs(" + i10 + ") < 0.");
        }
        if (i11 >= 0) {
            int i12 = i10 + i11;
            if (i12 <= bArr.length) {
                if (this.f٦٣g == null) {
                    throw new IOException("Stream closed");
                }
                if (i11 == 0) {
                    return 0;
                }
                int i13 = i10;
                while (i13 < i12) {
                    int h10 = h();
                    if (h10 < 0) {
                        break;
                    }
                    bArr[i13] = (byte) h10;
                    count(1);
                    i13++;
                }
                if (i13 == i10) {
                    return -1;
                }
                return i13 - i10;
            }
            throw new IndexOutOfBoundsException("offs(" + i10 + ") + len(" + i11 + ") > dest.length(" + bArr.length + ").");
        }
        throw new IndexOutOfBoundsException("len(" + i11 + ") < 0.");
    }
}
