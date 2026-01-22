package com.alibaba.sdk.android.tool;

import io.agora.rtc.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f٦٨٥٦a = true;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f٦٨٥٧b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f٦٨٥٨c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f٦٨٥٩d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f٦٨٦٠e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f٦٨٦١f = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: g, reason: collision with root package name */
    private static final byte[] f٦٨٦٢g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: com.alibaba.sdk.android.tool.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠٠٨٦a extends FilterOutputStream {

        /* renamed from: a, reason: collision with root package name */
        private boolean f٦٨٦٣a;

        /* renamed from: b, reason: collision with root package name */
        private int f٦٨٦٤b;

        /* renamed from: c, reason: collision with root package name */
        private byte[] f٦٨٦٥c;

        /* renamed from: d, reason: collision with root package name */
        private int f٦٨٦٦d;

        /* renamed from: e, reason: collision with root package name */
        private int f٦٨٦٧e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f٦٨٦٨f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f٦٨٦٩g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f٦٨٧٠h;

        /* renamed from: i, reason: collision with root package name */
        private int f٦٨٧١i;

        /* renamed from: j, reason: collision with root package name */
        private byte[] f٦٨٧٢j;

        public C٠٠٨٦a(OutputStream outputStream, int i10) {
            super(outputStream);
            this.f٦٨٦٨f = (i10 & 8) != 0;
            boolean z10 = (i10 & 1) != 0;
            this.f٦٨٦٣a = z10;
            int i11 = z10 ? 3 : 4;
            this.f٦٨٦٦d = i11;
            this.f٦٨٦٥c = new byte[i11];
            this.f٦٨٦٤b = 0;
            this.f٦٨٦٧e = 0;
            this.f٦٨٧٠h = false;
            this.f٦٨٦٩g = new byte[4];
            this.f٦٨٧١i = i10;
            this.f٦٨٧٢j = a.c(i10);
        }

        public void a() throws IOException {
            int i10 = this.f٦٨٦٤b;
            if (i10 > 0) {
                if (!this.f٦٨٦٣a) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(a.b(this.f٦٨٦٩g, this.f٦٨٦٥c, i10, this.f٦٨٧١i));
                this.f٦٨٦٤b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.f٦٨٦٥c = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i10) throws IOException {
            if (this.f٦٨٧٠h) {
                ((FilterOutputStream) this).out.write(i10);
                return;
            }
            if (this.f٦٨٦٣a) {
                byte[] bArr = this.f٦٨٦٥c;
                int i11 = this.f٦٨٦٤b;
                int i12 = i11 + 1;
                this.f٦٨٦٤b = i12;
                bArr[i11] = (byte) i10;
                int i13 = this.f٦٨٦٦d;
                if (i12 < i13) {
                    return;
                }
                ((FilterOutputStream) this).out.write(a.b(this.f٦٨٦٩g, bArr, i13, this.f٦٨٧١i));
                int i14 = this.f٦٨٦٧e + 4;
                this.f٦٨٦٧e = i14;
                if (this.f٦٨٦٨f && i14 >= 76) {
                    ((FilterOutputStream) this).out.write(10);
                    this.f٦٨٦٧e = 0;
                }
            } else {
                byte b10 = this.f٦٨٧٢j[i10 & Constants.ERR_WATERMARKR_INFO];
                if (b10 <= -5) {
                    if (b10 != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr2 = this.f٦٨٦٥c;
                int i15 = this.f٦٨٦٤b;
                int i16 = i15 + 1;
                this.f٦٨٦٤b = i16;
                bArr2[i15] = (byte) i10;
                if (i16 < this.f٦٨٦٦d) {
                    return;
                }
                ((FilterOutputStream) this).out.write(this.f٦٨٦٩g, 0, a.b(bArr2, 0, this.f٦٨٦٩g, 0, this.f٦٨٧١i));
            }
            this.f٦٨٦٤b = 0;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            if (this.f٦٨٧٠h) {
                ((FilterOutputStream) this).out.write(bArr, i10, i11);
                return;
            }
            for (int i12 = 0; i12 < i11; i12++) {
                write(bArr[i10 + i12]);
            }
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        int i13;
        int i14;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i10 < 0 || (i13 = i10 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i10)));
        }
        if (i11 < 0 || (i14 = i11 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i11)));
        }
        byte[] c10 = c(i12);
        byte b10 = bArr[i10 + 2];
        if (b10 == 61) {
            bArr2[i11] = (byte) ((((c10[bArr[i10 + 1]] & UByte.MAX_VALUE) << 12) | ((c10[bArr[i10]] & UByte.MAX_VALUE) << 18)) >>> 16);
            return 1;
        }
        byte b11 = bArr[i13];
        if (b11 == 61) {
            int i15 = ((c10[bArr[i10 + 1]] & UByte.MAX_VALUE) << 12) | ((c10[bArr[i10]] & UByte.MAX_VALUE) << 18) | ((c10[b10] & UByte.MAX_VALUE) << 6);
            bArr2[i11] = (byte) (i15 >>> 16);
            bArr2[i11 + 1] = (byte) (i15 >>> 8);
            return 2;
        }
        int i16 = ((c10[bArr[i10 + 1]] & UByte.MAX_VALUE) << 12) | ((c10[bArr[i10]] & UByte.MAX_VALUE) << 18) | ((c10[b10] & UByte.MAX_VALUE) << 6) | (c10[b11] & UByte.MAX_VALUE);
        bArr2[i11] = (byte) (i16 >> 16);
        bArr2[i11 + 1] = (byte) (i16 >> 8);
        bArr2[i14] = (byte) i16;
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] c(int i10) {
        return (i10 & 16) == 16 ? f٦٨٦٠e : (i10 & 32) == 32 ? f٦٨٦٢g : f٦٨٥٨c;
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e10) {
            if (!f٦٨٥٦a) {
                throw new AssertionError(e10.getMessage());
            }
            str = null;
        }
        if (f٦٨٥٦a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String b(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "" : a(bArr);
    }

    public static byte[] c(byte[] bArr, int i10, int i11, int i12) throws IOException {
        int i13;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i10 < 0 || (i13 = i10 + i11) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        if (i11 == 0) {
            return new byte[0];
        }
        if (i11 < 4) {
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i11);
        }
        byte[] c10 = c(i12);
        byte[] bArr2 = new byte[(i11 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i14 = 0;
        int i15 = 0;
        while (i10 < i13) {
            byte b10 = bArr[i10];
            byte b11 = c10[b10 & UByte.MAX_VALUE];
            if (b11 < -5) {
                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i10] & UByte.MAX_VALUE), Integer.valueOf(i10)));
            }
            if (b11 >= -1) {
                int i16 = i14 + 1;
                bArr3[i14] = b10;
                if (i16 > 3) {
                    i15 += b(bArr3, 0, bArr2, i15, i12);
                    if (bArr[i10] == 61) {
                        break;
                    }
                    i14 = 0;
                } else {
                    i14 = i16;
                }
            }
            i10++;
        }
        byte[] bArr4 = new byte[i15];
        System.arraycopy(bArr2, 0, bArr4, 0, i15);
        return bArr4;
    }

    public static String a(byte[] bArr, int i10, int i11, int i12) throws IOException {
        byte[] b10 = b(bArr, i10, i11, i12);
        try {
            return new String(b10, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(b10);
        }
    }

    private static final byte[] b(int i10) {
        return (i10 & 16) == 16 ? f٦٨٥٩d : (i10 & 32) == 32 ? f٦٨٦١f : f٦٨٥٧b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static byte[] b(byte[] bArr, int i10, int i11, int i12) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        C٠٠٨٦a r32;
        ?? r42;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i10);
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i11);
        }
        if (i10 + i11 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(bArr.length)));
        }
        if ((i12 & 2) == 0) {
            boolean z10 = (i12 & 8) != 0;
            int i13 = ((i11 / 3) * 4) + (i11 % 3 > 0 ? 4 : 0);
            if (z10) {
                i13 += i13 / 76;
            }
            int i14 = i13;
            byte[] bArr2 = new byte[i14];
            int i15 = i11 - 2;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i16 < i15) {
                int i19 = i16;
                int i20 = i15;
                byte[] bArr3 = bArr2;
                a(bArr, i16 + i10, 3, bArr2, i17, i12);
                int i21 = i18 + 4;
                if (!z10 || i21 < 76) {
                    i18 = i21;
                } else {
                    bArr3[i17 + 4] = 10;
                    i17++;
                    i18 = 0;
                }
                i16 = i19 + 3;
                i17 += 4;
                bArr2 = bArr3;
                i15 = i20;
            }
            int i22 = i16;
            byte[] bArr4 = bArr2;
            if (i22 < i11) {
                a(bArr, i22 + i10, i11 - i22, bArr4, i17, i12);
                i17 += 4;
            }
            int i23 = i17;
            if (i23 > i14 - 1) {
                return bArr4;
            }
            byte[] bArr5 = new byte[i23];
            System.arraycopy(bArr4, 0, bArr5, 0, i23);
            return bArr5;
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                r32 = new C٠٠٨٦a(byteArrayOutputStream, i12 | 1);
                try {
                    r42 = new GZIPOutputStream(r32);
                    try {
                        r42.write(bArr, i10, i11);
                        r42.close();
                        try {
                            r42.close();
                        } catch (Exception unused) {
                        }
                        try {
                            r32.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused3) {
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e10) {
                        e = e10;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        r42 = r42;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            byteArrayOutputStream2 = r42;
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception unused4) {
                            }
                            try {
                                r32.close();
                            } catch (Exception unused5) {
                            }
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (Exception unused6) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = r42;
                        byteArrayOutputStream2.close();
                        r32.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                    r42 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream2.close();
                    r32.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e12) {
                e = e12;
                r32 = null;
                r42 = 0;
            } catch (Throwable th4) {
                th = th4;
                r32 = null;
            }
        } catch (IOException e13) {
            e = e13;
            r32 = null;
            r42 = 0;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            r32 = null;
        }
    }

    public static byte[] a(String str) throws IOException {
        return a(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i10, int i11) {
        a(bArr2, 0, i10, bArr, 0, i11);
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static byte[] a(String str, int i10) throws IOException {
        byte[] bytes;
        ?? length;
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        if (str == null) {
            throw new NullPointerException("Input string was null.");
        }
        try {
            bytes = str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] c10 = c(bytes, 0, bytes.length, i10);
        boolean z10 = (i10 & 4) != 0;
        if (c10 != null && (length = c10.length) >= 4 && !z10 && 35615 == ((c10[0] & UByte.MAX_VALUE) | ((c10[1] << 8) & 65280))) {
            byte[] bArr = new byte[2048];
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(c10);
                        try {
                            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                            while (true) {
                                try {
                                    int read = gZIPInputStream.read(bArr);
                                    if (read < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bArr, 0, read);
                                } catch (IOException e10) {
                                    e = e10;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayInputStream = byteArrayInputStream;
                                    try {
                                        e.printStackTrace();
                                        byteArrayOutputStream.close();
                                        length = byteArrayInputStream;
                                        gZIPInputStream.close();
                                        length.close();
                                        return c10;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                        try {
                                            gZIPInputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                            throw th;
                                        } catch (Exception unused4) {
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    throw th;
                                }
                            }
                            c10 = byteArrayOutputStream2.toByteArray();
                            byteArrayOutputStream2.close();
                            length = byteArrayInputStream;
                        } catch (IOException e11) {
                            e = e11;
                            gZIPInputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            gZIPInputStream = null;
                        }
                    } catch (IOException e12) {
                        e = e12;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    }
                } catch (Exception unused5) {
                }
            } catch (IOException e13) {
                e = e13;
                byteArrayInputStream = null;
                gZIPInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                byteArrayInputStream = null;
                gZIPInputStream = null;
            }
            try {
                gZIPInputStream.close();
            } catch (Exception unused6) {
            }
            try {
                length.close();
            } catch (Exception unused7) {
            }
        }
        return c10;
    }

    private static byte[] a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        byte[] b10 = b(i13);
        int i14 = (i11 > 0 ? (bArr[i10] << 24) >>> 8 : 0) | (i11 > 1 ? (bArr[i10 + 1] << 24) >>> 16 : 0) | (i11 > 2 ? (bArr[i10 + 2] << 24) >>> 24 : 0);
        if (i11 == 1) {
            bArr2[i12] = b10[i14 >>> 18];
            bArr2[i12 + 1] = b10[(i14 >>> 12) & 63];
            bArr2[i12 + 2] = Base64.padSymbol;
            bArr2[i12 + 3] = Base64.padSymbol;
            return bArr2;
        }
        if (i11 == 2) {
            bArr2[i12] = b10[i14 >>> 18];
            bArr2[i12 + 1] = b10[(i14 >>> 12) & 63];
            bArr2[i12 + 2] = b10[(i14 >>> 6) & 63];
            bArr2[i12 + 3] = Base64.padSymbol;
            return bArr2;
        }
        if (i11 != 3) {
            return bArr2;
        }
        bArr2[i12] = b10[i14 >>> 18];
        bArr2[i12 + 1] = b10[(i14 >>> 12) & 63];
        bArr2[i12 + 2] = b10[(i14 >>> 6) & 63];
        bArr2[i12 + 3] = b10[i14 & 63];
        return bArr2;
    }
}
