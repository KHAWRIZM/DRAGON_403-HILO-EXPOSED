package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class i1 {

    /* renamed from: a, reason: collision with root package name */
    private static final b f٣٣٦٤a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void h(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) {
            if (!m(b11) && (((b10 << 28) + (b11 + 112)) >> 30) == 0 && !m(b12) && !m(b13)) {
                int r10 = ((b10 & 7) << 18) | (r(b11) << 12) | (r(b12) << 6) | r(b13);
                cArr[i10] = l(r10);
                cArr[i10 + 1] = q(r10);
                return;
            }
            throw v.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void i(byte b10, char[] cArr, int i10) {
            cArr[i10] = (char) b10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(byte b10, byte b11, byte b12, char[] cArr, int i10) {
            if (!m(b11) && ((b10 != -32 || b11 >= -96) && ((b10 != -19 || b11 < -96) && !m(b12)))) {
                cArr[i10] = (char) (((b10 & 15) << 12) | (r(b11) << 6) | r(b12));
                return;
            }
            throw v.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k(byte b10, byte b11, char[] cArr, int i10) {
            if (b10 >= -62 && !m(b11)) {
                cArr[i10] = (char) (((b10 & 31) << 6) | r(b11));
                return;
            }
            throw v.d();
        }

        private static char l(int i10) {
            return (char) ((i10 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean m(byte b10) {
            return b10 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n(byte b10) {
            return b10 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean o(byte b10) {
            return b10 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean p(byte b10) {
            return b10 < -32;
        }

        private static char q(int i10) {
            return (char) ((i10 & 1023) + Utf8.LOG_SURROGATE_HEADER);
        }

        private static int r(byte b10) {
            return b10 & Utf8.REPLACEMENT_BYTE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class b {
        b() {
        }

        abstract String a(byte[] bArr, int i10, int i11);

        abstract int b(String str, byte[] bArr, int i10, int i11);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static final class c extends b {
        c() {
        }

        @Override // androidx.datastore.preferences.protobuf.i1.b
        String a(byte[] bArr, int i10, int i11) {
            if ((i10 | i11 | ((bArr.length - i10) - i11)) >= 0) {
                int i12 = i10 + i11;
                char[] cArr = new char[i11];
                int i13 = 0;
                while (i10 < i12) {
                    byte b10 = bArr[i10];
                    if (!a.n(b10)) {
                        break;
                    }
                    i10++;
                    a.i(b10, cArr, i13);
                    i13++;
                }
                int i14 = i13;
                while (i10 < i12) {
                    int i15 = i10 + 1;
                    byte b11 = bArr[i10];
                    if (a.n(b11)) {
                        int i16 = i14 + 1;
                        a.i(b11, cArr, i14);
                        while (i15 < i12) {
                            byte b12 = bArr[i15];
                            if (!a.n(b12)) {
                                break;
                            }
                            i15++;
                            a.i(b12, cArr, i16);
                            i16++;
                        }
                        i14 = i16;
                        i10 = i15;
                    } else if (a.p(b11)) {
                        if (i15 < i12) {
                            i10 += 2;
                            a.k(b11, bArr[i15], cArr, i14);
                            i14++;
                        } else {
                            throw v.d();
                        }
                    } else if (a.o(b11)) {
                        if (i15 < i12 - 1) {
                            int i17 = i10 + 2;
                            i10 += 3;
                            a.j(b11, bArr[i15], bArr[i17], cArr, i14);
                            i14++;
                        } else {
                            throw v.d();
                        }
                    } else if (i15 < i12 - 2) {
                        byte b13 = bArr[i15];
                        int i18 = i10 + 3;
                        byte b14 = bArr[i10 + 2];
                        i10 += 4;
                        a.h(b11, b13, b14, bArr[i18], cArr, i14);
                        i14 += 2;
                    } else {
                        throw v.d();
                    }
                }
                return new String(cArr, 0, i14);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // androidx.datastore.preferences.protobuf.i1.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int b(String str, byte[] bArr, int i10, int i11) {
            int i12;
            int i13;
            char charAt;
            int length = str.length();
            int i14 = i11 + i10;
            int i15 = 0;
            while (i15 < length && (i13 = i15 + i10) < i14 && (charAt = str.charAt(i15)) < 128) {
                bArr[i13] = (byte) charAt;
                i15++;
            }
            int i16 = i10 + i15;
            while (i15 < length) {
                char charAt2 = str.charAt(i15);
                if (charAt2 < 128 && i16 < i14) {
                    bArr[i16] = (byte) charAt2;
                    i16++;
                } else if (charAt2 < 2048 && i16 <= i14 - 2) {
                    int i17 = i16 + 1;
                    bArr[i16] = (byte) ((charAt2 >>> 6) | 960);
                    i16 += 2;
                    bArr[i17] = (byte) ((charAt2 & '?') | 128);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i16 <= i14 - 3) {
                    bArr[i16] = (byte) ((charAt2 >>> '\f') | 480);
                    int i18 = i16 + 2;
                    bArr[i16 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i16 += 3;
                    bArr[i18] = (byte) ((charAt2 & '?') | 128);
                } else {
                    if (i16 <= i14 - 4) {
                        int i19 = i15 + 1;
                        if (i19 != str.length()) {
                            char charAt3 = str.charAt(i19);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                bArr[i16] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i16 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i20 = i16 + 3;
                                bArr[i16 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i16 += 4;
                                bArr[i20] = (byte) ((codePoint & 63) | 128);
                                i15 = i19;
                            } else {
                                i15 = i19;
                            }
                        }
                        throw new d(i15 - 1, length);
                    }
                    if (55296 <= charAt2 && charAt2 <= 57343 && ((i12 = i15 + 1) == str.length() || !Character.isSurrogatePair(charAt2, str.charAt(i12)))) {
                        throw new d(i15, length);
                    }
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i16);
                }
                i15++;
            }
            return i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d extends IllegalArgumentException {
        d(int i10, int i11) {
            super("Unpaired surrogate at index " + i10 + " of " + i11);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static final class e extends b {
        e() {
        }

        static boolean c() {
            if (h1.B() && h1.C()) {
                return true;
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.i1.b
        String a(byte[] bArr, int i10, int i11) {
            Charset charset = u.f٣٥٠٩b;
            String str = new String(bArr, i10, i11, charset);
            if (str.indexOf(Utf8.REPLACEMENT_CODE_POINT) < 0) {
                return str;
            }
            if (Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i10, i11 + i10))) {
                return str;
            }
            throw v.d();
        }

        @Override // androidx.datastore.preferences.protobuf.i1.b
        int b(String str, byte[] bArr, int i10, int i11) {
            long j10;
            String str2;
            String str3;
            int i12;
            long j11;
            long j12;
            char charAt;
            long j13 = i10;
            long j14 = i11 + j13;
            int length = str.length();
            String str4 = " at index ";
            String str5 = "Failed writing ";
            if (length <= i11 && bArr.length - i11 >= i10) {
                int i13 = 0;
                while (true) {
                    j10 = 1;
                    if (i13 >= length || (charAt = str.charAt(i13)) >= 128) {
                        break;
                    }
                    h1.H(bArr, j13, (byte) charAt);
                    i13++;
                    j13 = 1 + j13;
                }
                if (i13 == length) {
                    return (int) j13;
                }
                while (i13 < length) {
                    char charAt2 = str.charAt(i13);
                    if (charAt2 < 128 && j13 < j14) {
                        h1.H(bArr, j13, (byte) charAt2);
                        j12 = j14;
                        str3 = str5;
                        j11 = j10;
                        j13 += j10;
                        str2 = str4;
                    } else {
                        if (charAt2 < 2048 && j13 <= j14 - 2) {
                            str2 = str4;
                            str3 = str5;
                            long j15 = j13 + j10;
                            h1.H(bArr, j13, (byte) ((charAt2 >>> 6) | 960));
                            j13 += 2;
                            h1.H(bArr, j15, (byte) ((charAt2 & '?') | 128));
                        } else {
                            str2 = str4;
                            str3 = str5;
                            if ((charAt2 < 55296 || 57343 < charAt2) && j13 <= j14 - 3) {
                                h1.H(bArr, j13, (byte) ((charAt2 >>> '\f') | 480));
                                long j16 = j13 + 2;
                                h1.H(bArr, j13 + 1, (byte) (((charAt2 >>> 6) & 63) | 128));
                                j13 += 3;
                                h1.H(bArr, j16, (byte) ((charAt2 & '?') | 128));
                            } else {
                                if (j13 <= j14 - 4) {
                                    int i14 = i13 + 1;
                                    if (i14 != length) {
                                        char charAt3 = str.charAt(i14);
                                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                                            j11 = 1;
                                            h1.H(bArr, j13, (byte) ((codePoint >>> 18) | 240));
                                            j12 = j14;
                                            h1.H(bArr, j13 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                            long j17 = j13 + 3;
                                            h1.H(bArr, j13 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                            j13 += 4;
                                            h1.H(bArr, j17, (byte) ((codePoint & 63) | 128));
                                            i13 = i14;
                                        } else {
                                            i13 = i14;
                                        }
                                    }
                                    throw new d(i13 - 1, length);
                                }
                                if (55296 <= charAt2 && charAt2 <= 57343 && ((i12 = i13 + 1) == length || !Character.isSurrogatePair(charAt2, str.charAt(i12)))) {
                                    throw new d(i13, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str3 + charAt2 + str2 + j13);
                            }
                        }
                        j12 = j14;
                        j11 = 1;
                    }
                    i13++;
                    str4 = str2;
                    str5 = str3;
                    j10 = j11;
                    j14 = j12;
                }
                return (int) j13;
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length - 1) + " at index " + (i10 + i11));
        }
    }

    static {
        b cVar;
        if (e.c() && !androidx.datastore.preferences.protobuf.d.c()) {
            cVar = new e();
        } else {
            cVar = new c();
        }
        f٣٣٦٤a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(byte[] bArr, int i10, int i11) {
        return f٣٣٦٤a.a(bArr, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(String str, byte[] bArr, int i10, int i11) {
        return f٣٣٦٤a.b(str, bArr, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length && str.charAt(i10) < 128) {
            i10++;
        }
        int i11 = length;
        while (true) {
            if (i10 < length) {
                char charAt = str.charAt(i10);
                if (charAt < 2048) {
                    i11 += (127 - charAt) >>> 31;
                    i10++;
                } else {
                    i11 += d(str, i10);
                    break;
                }
            } else {
                break;
            }
        }
        if (i11 >= length) {
            return i11;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i11 + 4294967296L));
    }

    private static int d(String str, int i10) {
        int length = str.length();
        int i11 = 0;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt < 2048) {
                i11 += (127 - charAt) >>> 31;
            } else {
                i11 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(str, i10) >= 65536) {
                        i10++;
                    } else {
                        throw new d(i10, length);
                    }
                }
            }
            i10++;
        }
        return i11;
    }
}
