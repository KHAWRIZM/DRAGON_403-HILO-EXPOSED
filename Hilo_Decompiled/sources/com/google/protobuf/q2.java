package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class q2 {

    /* renamed from: a, reason: collision with root package name */
    private static final b f١١٩٠٥a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void h(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) {
            if (!m(b11) && (((b10 << 28) + (b11 + 112)) >> 30) == 0 && !m(b12) && !m(b13)) {
                int r10 = ((b10 & 7) << 18) | (r(b11) << 12) | (r(b12) << 6) | r(b13);
                cArr[i10] = l(r10);
                cArr[i10 + 1] = q(r10);
                return;
            }
            throw k0.c();
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
            throw k0.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k(byte b10, byte b11, char[] cArr, int i10) {
            if (b10 >= -62 && !m(b11)) {
                cArr[i10] = (char) (((b10 & 31) << 6) | r(b11));
                return;
            }
            throw k0.c();
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
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class b {
        b() {
        }

        private static int j(ByteBuffer byteBuffer, int i10, int i11) {
            int l10 = i10 + q2.l(byteBuffer, i10, i11);
            while (l10 < i11) {
                int i12 = l10 + 1;
                byte b10 = byteBuffer.get(l10);
                if (b10 < 0) {
                    if (b10 < -32) {
                        if (i12 >= i11) {
                            return b10;
                        }
                        if (b10 < -62 || byteBuffer.get(i12) > -65) {
                            return -1;
                        }
                        l10 += 2;
                    } else if (b10 < -16) {
                        if (i12 >= i11 - 1) {
                            return q2.p(byteBuffer, b10, i12, i11 - i12);
                        }
                        int i13 = l10 + 2;
                        byte b11 = byteBuffer.get(i12);
                        if (b11 > -65 || ((b10 == -32 && b11 < -96) || ((b10 == -19 && b11 >= -96) || byteBuffer.get(i13) > -65))) {
                            return -1;
                        }
                        l10 += 3;
                    } else {
                        if (i12 >= i11 - 2) {
                            return q2.p(byteBuffer, b10, i12, i11 - i12);
                        }
                        int i14 = l10 + 2;
                        byte b12 = byteBuffer.get(i12);
                        if (b12 <= -65 && (((b10 << 28) + (b12 + 112)) >> 30) == 0) {
                            int i15 = l10 + 3;
                            if (byteBuffer.get(i14) <= -65) {
                                l10 += 4;
                                if (byteBuffer.get(i15) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                } else {
                    l10 = i12;
                }
            }
            return 0;
        }

        final String a(ByteBuffer byteBuffer, int i10, int i11) {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), byteBuffer.arrayOffset() + i10, i11);
            }
            if (byteBuffer.isDirect()) {
                return d(byteBuffer, i10, i11);
            }
            return c(byteBuffer, i10, i11);
        }

        abstract String b(byte[] bArr, int i10, int i11);

        final String c(ByteBuffer byteBuffer, int i10, int i11) {
            if ((i10 | i11 | ((byteBuffer.limit() - i10) - i11)) >= 0) {
                int i12 = i10 + i11;
                char[] cArr = new char[i11];
                int i13 = 0;
                while (i10 < i12) {
                    byte b10 = byteBuffer.get(i10);
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
                    byte b11 = byteBuffer.get(i10);
                    if (a.n(b11)) {
                        int i16 = i14 + 1;
                        a.i(b11, cArr, i14);
                        while (i15 < i12) {
                            byte b12 = byteBuffer.get(i15);
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
                            a.k(b11, byteBuffer.get(i15), cArr, i14);
                            i14++;
                        } else {
                            throw k0.c();
                        }
                    } else if (a.o(b11)) {
                        if (i15 < i12 - 1) {
                            int i17 = i10 + 2;
                            i10 += 3;
                            a.j(b11, byteBuffer.get(i15), byteBuffer.get(i17), cArr, i14);
                            i14++;
                        } else {
                            throw k0.c();
                        }
                    } else if (i15 < i12 - 2) {
                        byte b13 = byteBuffer.get(i15);
                        int i18 = i10 + 3;
                        byte b14 = byteBuffer.get(i10 + 2);
                        i10 += 4;
                        a.h(b11, b13, b14, byteBuffer.get(i18), cArr, i14);
                        i14 += 2;
                    } else {
                        throw k0.c();
                    }
                }
                return new String(cArr, 0, i14);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i10), Integer.valueOf(i11)));
        }

        abstract String d(ByteBuffer byteBuffer, int i10, int i11);

        abstract int e(CharSequence charSequence, byte[] bArr, int i10, int i11);

        final boolean f(ByteBuffer byteBuffer, int i10, int i11) {
            if (h(0, byteBuffer, i10, i11) != 0) {
                return false;
            }
            return true;
        }

        final boolean g(byte[] bArr, int i10, int i11) {
            if (i(0, bArr, i10, i11) != 0) {
                return false;
            }
            return true;
        }

        final int h(int i10, ByteBuffer byteBuffer, int i11, int i12) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return i(i10, byteBuffer.array(), i11 + arrayOffset, arrayOffset + i12);
            }
            if (byteBuffer.isDirect()) {
                return l(i10, byteBuffer, i11, i12);
            }
            return k(i10, byteBuffer, i11, i12);
        }

        abstract int i(int i10, byte[] bArr, int i11, int i12);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L١٣;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        
            if (r8.get(r9) > (-65)) goto L٣٢;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
        
            if (r8.get(r7) > (-65)) goto L٥٣;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final int k(int i10, ByteBuffer byteBuffer, int i11, int i12) {
            byte b10;
            int i13;
            int i14;
            if (i10 != 0) {
                if (i11 >= i12) {
                    return i10;
                }
                byte b11 = (byte) i10;
                if (b11 < -32) {
                    if (b11 >= -62) {
                        i14 = i11 + 1;
                    }
                    return -1;
                }
                if (b11 < -16) {
                    byte b12 = (byte) (~(i10 >> 8));
                    if (b12 == 0) {
                        int i15 = i11 + 1;
                        byte b13 = byteBuffer.get(i11);
                        if (i15 >= i12) {
                            return q2.n(b11, b13);
                        }
                        i11 = i15;
                        b12 = b13;
                    }
                    if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                        i14 = i11 + 1;
                    }
                    return -1;
                }
                byte b14 = (byte) (~(i10 >> 8));
                if (b14 == 0) {
                    i13 = i11 + 1;
                    b14 = byteBuffer.get(i11);
                    if (i13 >= i12) {
                        return q2.n(b11, b14);
                    }
                    b10 = 0;
                } else {
                    b10 = (byte) (i10 >> 16);
                    i13 = i11;
                }
                if (b10 == 0) {
                    int i16 = i13 + 1;
                    byte b15 = byteBuffer.get(i13);
                    if (i16 >= i12) {
                        return q2.o(b11, b14, b15);
                    }
                    b10 = b15;
                    i13 = i16;
                }
                if (b14 <= -65 && (((b11 << 28) + (b14 + 112)) >> 30) == 0 && b10 <= -65) {
                    i11 = i13 + 1;
                }
                return -1;
                i11 = i14;
            }
            return j(byteBuffer, i11, i12);
        }

        abstract int l(int i10, ByteBuffer byteBuffer, int i11, int i12);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class c extends b {
        c() {
        }

        private static int m(byte[] bArr, int i10, int i11) {
            while (i10 < i11 && bArr[i10] >= 0) {
                i10++;
            }
            if (i10 >= i11) {
                return 0;
            }
            return n(bArr, i10, i11);
        }

        private static int n(byte[] bArr, int i10, int i11) {
            while (i10 < i11) {
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 < 0) {
                    if (b10 < -32) {
                        if (i12 >= i11) {
                            return b10;
                        }
                        if (b10 >= -62) {
                            i10 += 2;
                            if (bArr[i12] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b10 < -16) {
                        if (i12 >= i11 - 1) {
                            return q2.q(bArr, i12, i11);
                        }
                        int i13 = i10 + 2;
                        byte b11 = bArr[i12];
                        if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                            i10 += 3;
                            if (bArr[i13] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i12 >= i11 - 2) {
                        return q2.q(bArr, i12, i11);
                    }
                    int i14 = i10 + 2;
                    byte b12 = bArr[i12];
                    if (b12 <= -65 && (((b10 << 28) + (b12 + 112)) >> 30) == 0) {
                        int i15 = i10 + 3;
                        if (bArr[i14] <= -65) {
                            i10 += 4;
                            if (bArr[i15] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                i10 = i12;
            }
            return 0;
        }

        @Override // com.google.protobuf.q2.b
        String b(byte[] bArr, int i10, int i11) {
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
                            throw k0.c();
                        }
                    } else if (a.o(b11)) {
                        if (i15 < i12 - 1) {
                            int i17 = i10 + 2;
                            i10 += 3;
                            a.j(b11, bArr[i15], bArr[i17], cArr, i14);
                            i14++;
                        } else {
                            throw k0.c();
                        }
                    } else if (i15 < i12 - 2) {
                        byte b13 = bArr[i15];
                        int i18 = i10 + 3;
                        byte b14 = bArr[i10 + 2];
                        i10 += 4;
                        a.h(b11, b13, b14, bArr[i18], cArr, i14);
                        i14 += 2;
                    } else {
                        throw k0.c();
                    }
                }
                return new String(cArr, 0, i14);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
        }

        @Override // com.google.protobuf.q2.b
        String d(ByteBuffer byteBuffer, int i10, int i11) {
            return c(byteBuffer, i10, i11);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // com.google.protobuf.q2.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int e(CharSequence charSequence, byte[] bArr, int i10, int i11) {
            int i12;
            int i13;
            char charAt;
            int length = charSequence.length();
            int i14 = i11 + i10;
            int i15 = 0;
            while (i15 < length && (i13 = i15 + i10) < i14 && (charAt = charSequence.charAt(i15)) < 128) {
                bArr[i13] = (byte) charAt;
                i15++;
            }
            int i16 = i10 + i15;
            while (i15 < length) {
                char charAt2 = charSequence.charAt(i15);
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
                        if (i19 != charSequence.length()) {
                            char charAt3 = charSequence.charAt(i19);
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
                    if (55296 <= charAt2 && charAt2 <= 57343 && ((i12 = i15 + 1) == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i12)))) {
                        throw new d(i15, length);
                    }
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i16);
                }
                i15++;
            }
            return i16;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L١٣;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L٣٢;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L٥٣;
         */
        @Override // com.google.protobuf.q2.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int i(int i10, byte[] bArr, int i11, int i12) {
            byte b10;
            int i13;
            int i14;
            if (i10 != 0) {
                if (i11 >= i12) {
                    return i10;
                }
                byte b11 = (byte) i10;
                if (b11 < -32) {
                    if (b11 >= -62) {
                        i14 = i11 + 1;
                    }
                    return -1;
                }
                if (b11 < -16) {
                    byte b12 = (byte) (~(i10 >> 8));
                    if (b12 == 0) {
                        int i15 = i11 + 1;
                        byte b13 = bArr[i11];
                        if (i15 >= i12) {
                            return q2.n(b11, b13);
                        }
                        i11 = i15;
                        b12 = b13;
                    }
                    if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                        i14 = i11 + 1;
                    }
                    return -1;
                }
                byte b14 = (byte) (~(i10 >> 8));
                if (b14 == 0) {
                    i13 = i11 + 1;
                    b14 = bArr[i11];
                    if (i13 >= i12) {
                        return q2.n(b11, b14);
                    }
                    b10 = 0;
                } else {
                    b10 = (byte) (i10 >> 16);
                    i13 = i11;
                }
                if (b10 == 0) {
                    int i16 = i13 + 1;
                    byte b15 = bArr[i13];
                    if (i16 >= i12) {
                        return q2.o(b11, b14, b15);
                    }
                    b10 = b15;
                    i13 = i16;
                }
                if (b14 <= -65 && (((b11 << 28) + (b14 + 112)) >> 30) == 0 && b10 <= -65) {
                    i11 = i13 + 1;
                }
                return -1;
                i11 = i14;
            }
            return m(bArr, i11, i12);
        }

        @Override // com.google.protobuf.q2.b
        int l(int i10, ByteBuffer byteBuffer, int i11, int i12) {
            return k(i10, byteBuffer, i11, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d extends IllegalArgumentException {
        d(int i10, int i11) {
            super("Unpaired surrogate at index " + i10 + " of " + i11);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class e extends b {
        e() {
        }

        static boolean m() {
            if (p2.J() && p2.K()) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static int n(long j10, int i10) {
            int p10 = p(j10, i10);
            long j11 = j10 + p10;
            int i11 = i10 - p10;
            while (true) {
                byte b10 = 0;
                while (true) {
                    if (i11 <= 0) {
                        break;
                    }
                    long j12 = j11 + 1;
                    b10 = p2.w(j11);
                    if (b10 >= 0) {
                        i11--;
                        j11 = j12;
                    } else {
                        j11 = j12;
                        break;
                    }
                }
                if (i11 == 0) {
                    return 0;
                }
                int i12 = i11 - 1;
                if (b10 < -32) {
                    if (i12 == 0) {
                        return b10;
                    }
                    i11 -= 2;
                    if (b10 < -62) {
                        break;
                    }
                    long j13 = 1 + j11;
                    if (p2.w(j11) > -65) {
                        break;
                    }
                    j11 = j13;
                } else if (b10 < -16) {
                    if (i12 < 2) {
                        return r(j11, b10, i12);
                    }
                    i11 -= 3;
                    long j14 = 1 + j11;
                    byte w10 = p2.w(j11);
                    if (w10 > -65 || ((b10 == -32 && w10 < -96) || (b10 == -19 && w10 >= -96))) {
                        break;
                    }
                    j11 += 2;
                    if (p2.w(j14) > -65) {
                        break;
                    }
                } else {
                    if (i12 < 3) {
                        return r(j11, b10, i12);
                    }
                    i11 -= 4;
                    long j15 = 1 + j11;
                    byte w11 = p2.w(j11);
                    if (w11 > -65 || (((b10 << 28) + (w11 + 112)) >> 30) != 0) {
                        break;
                    }
                    long j16 = 2 + j11;
                    if (p2.w(j15) > -65) {
                        break;
                    }
                    j11 += 3;
                    if (p2.w(j16) > -65) {
                        break;
                    }
                }
            }
            return -1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static int o(byte[] bArr, long j10, int i10) {
            int q10 = q(bArr, j10, i10);
            int i11 = i10 - q10;
            long j11 = j10 + q10;
            while (true) {
                byte b10 = 0;
                while (true) {
                    if (i11 <= 0) {
                        break;
                    }
                    long j12 = j11 + 1;
                    b10 = p2.x(bArr, j11);
                    if (b10 >= 0) {
                        i11--;
                        j11 = j12;
                    } else {
                        j11 = j12;
                        break;
                    }
                }
                if (i11 == 0) {
                    return 0;
                }
                int i12 = i11 - 1;
                if (b10 < -32) {
                    if (i12 == 0) {
                        return b10;
                    }
                    i11 -= 2;
                    if (b10 < -62) {
                        break;
                    }
                    long j13 = 1 + j11;
                    if (p2.x(bArr, j11) > -65) {
                        break;
                    }
                    j11 = j13;
                } else if (b10 < -16) {
                    if (i12 < 2) {
                        return s(bArr, b10, j11, i12);
                    }
                    i11 -= 3;
                    long j14 = 1 + j11;
                    byte x10 = p2.x(bArr, j11);
                    if (x10 > -65 || ((b10 == -32 && x10 < -96) || (b10 == -19 && x10 >= -96))) {
                        break;
                    }
                    j11 += 2;
                    if (p2.x(bArr, j14) > -65) {
                        break;
                    }
                } else {
                    if (i12 < 3) {
                        return s(bArr, b10, j11, i12);
                    }
                    i11 -= 4;
                    long j15 = 1 + j11;
                    byte x11 = p2.x(bArr, j11);
                    if (x11 > -65 || (((b10 << 28) + (x11 + 112)) >> 30) != 0) {
                        break;
                    }
                    long j16 = 2 + j11;
                    if (p2.x(bArr, j15) > -65) {
                        break;
                    }
                    j11 += 3;
                    if (p2.x(bArr, j16) > -65) {
                        break;
                    }
                }
            }
            return -1;
        }

        private static int p(long j10, int i10) {
            if (i10 < 16) {
                return 0;
            }
            int i11 = (int) ((-j10) & 7);
            int i12 = i11;
            while (i12 > 0) {
                long j11 = 1 + j10;
                if (p2.w(j10) < 0) {
                    return i11 - i12;
                }
                i12--;
                j10 = j11;
            }
            int i13 = i10 - i11;
            while (i13 >= 8 && (p2.D(j10) & (-9187201950435737472L)) == 0) {
                j10 += 8;
                i13 -= 8;
            }
            return i10 - i13;
        }

        private static int q(byte[] bArr, long j10, int i10) {
            int i11 = 0;
            if (i10 < 16) {
                return 0;
            }
            int i12 = 8 - (((int) j10) & 7);
            while (i11 < i12) {
                long j11 = 1 + j10;
                if (p2.x(bArr, j10) < 0) {
                    return i11;
                }
                i11++;
                j10 = j11;
            }
            while (true) {
                int i13 = i11 + 8;
                if (i13 > i10 || (p2.E(bArr, p2.f١١٨٧٢h + j10) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j10 += 8;
                i11 = i13;
            }
            while (i11 < i10) {
                long j12 = j10 + 1;
                if (p2.x(bArr, j10) < 0) {
                    return i11;
                }
                i11++;
                j10 = j12;
            }
            return i10;
        }

        private static int r(long j10, int i10, int i11) {
            if (i11 == 0) {
                return q2.m(i10);
            }
            if (i11 == 1) {
                return q2.n(i10, p2.w(j10));
            }
            if (i11 == 2) {
                return q2.o(i10, p2.w(j10), p2.w(j10 + 1));
            }
            throw new AssertionError();
        }

        private static int s(byte[] bArr, int i10, long j10, int i11) {
            if (i11 == 0) {
                return q2.m(i10);
            }
            if (i11 == 1) {
                return q2.n(i10, p2.x(bArr, j10));
            }
            if (i11 == 2) {
                return q2.o(i10, p2.x(bArr, j10), p2.x(bArr, j10 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.q2.b
        String b(byte[] bArr, int i10, int i11) {
            Charset charset = j0.f١١١٦٢b;
            String str = new String(bArr, i10, i11, charset);
            if (!str.contains("�")) {
                return str;
            }
            if (Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i10, i11 + i10))) {
                return str;
            }
            throw k0.c();
        }

        @Override // com.google.protobuf.q2.b
        String d(ByteBuffer byteBuffer, int i10, int i11) {
            if ((i10 | i11 | ((byteBuffer.limit() - i10) - i11)) >= 0) {
                long k10 = p2.k(byteBuffer) + i10;
                long j10 = i11 + k10;
                char[] cArr = new char[i11];
                int i12 = 0;
                while (k10 < j10) {
                    byte w10 = p2.w(k10);
                    if (!a.n(w10)) {
                        break;
                    }
                    k10++;
                    a.i(w10, cArr, i12);
                    i12++;
                }
                while (k10 < j10) {
                    long j11 = k10 + 1;
                    byte w11 = p2.w(k10);
                    if (a.n(w11)) {
                        int i13 = i12 + 1;
                        a.i(w11, cArr, i12);
                        while (j11 < j10) {
                            byte w12 = p2.w(j11);
                            if (!a.n(w12)) {
                                break;
                            }
                            j11++;
                            a.i(w12, cArr, i13);
                            i13++;
                        }
                        i12 = i13;
                        k10 = j11;
                    } else if (a.p(w11)) {
                        if (j11 < j10) {
                            k10 += 2;
                            a.k(w11, p2.w(j11), cArr, i12);
                            i12++;
                        } else {
                            throw k0.c();
                        }
                    } else if (a.o(w11)) {
                        if (j11 < j10 - 1) {
                            long j12 = 2 + k10;
                            k10 += 3;
                            a.j(w11, p2.w(j11), p2.w(j12), cArr, i12);
                            i12++;
                        } else {
                            throw k0.c();
                        }
                    } else if (j11 < j10 - 2) {
                        byte w13 = p2.w(j11);
                        long j13 = k10 + 3;
                        byte w14 = p2.w(2 + k10);
                        k10 += 4;
                        a.h(w11, w13, w14, p2.w(j13), cArr, i12);
                        i12 += 2;
                    } else {
                        throw k0.c();
                    }
                }
                return new String(cArr, 0, i12);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i10), Integer.valueOf(i11)));
        }

        @Override // com.google.protobuf.q2.b
        int e(CharSequence charSequence, byte[] bArr, int i10, int i11) {
            long j10;
            String str;
            String str2;
            int i12;
            long j11;
            long j12;
            char charAt;
            long j13 = i10;
            long j14 = i11 + j13;
            int length = charSequence.length();
            String str3 = " at index ";
            String str4 = "Failed writing ";
            if (length <= i11 && bArr.length - i11 >= i10) {
                int i13 = 0;
                while (true) {
                    j10 = 1;
                    if (i13 >= length || (charAt = charSequence.charAt(i13)) >= 128) {
                        break;
                    }
                    p2.Q(bArr, j13, (byte) charAt);
                    i13++;
                    j13 = 1 + j13;
                }
                if (i13 == length) {
                    return (int) j13;
                }
                while (i13 < length) {
                    char charAt2 = charSequence.charAt(i13);
                    if (charAt2 < 128 && j13 < j14) {
                        p2.Q(bArr, j13, (byte) charAt2);
                        j12 = j14;
                        str2 = str4;
                        j11 = j10;
                        j13 += j10;
                        str = str3;
                    } else {
                        if (charAt2 < 2048 && j13 <= j14 - 2) {
                            str = str3;
                            str2 = str4;
                            long j15 = j13 + j10;
                            p2.Q(bArr, j13, (byte) ((charAt2 >>> 6) | 960));
                            j13 += 2;
                            p2.Q(bArr, j15, (byte) ((charAt2 & '?') | 128));
                        } else {
                            str = str3;
                            str2 = str4;
                            if ((charAt2 < 55296 || 57343 < charAt2) && j13 <= j14 - 3) {
                                p2.Q(bArr, j13, (byte) ((charAt2 >>> '\f') | 480));
                                long j16 = j13 + 2;
                                p2.Q(bArr, j13 + 1, (byte) (((charAt2 >>> 6) & 63) | 128));
                                j13 += 3;
                                p2.Q(bArr, j16, (byte) ((charAt2 & '?') | 128));
                            } else {
                                if (j13 <= j14 - 4) {
                                    int i14 = i13 + 1;
                                    if (i14 != length) {
                                        char charAt3 = charSequence.charAt(i14);
                                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                                            j11 = 1;
                                            p2.Q(bArr, j13, (byte) ((codePoint >>> 18) | 240));
                                            j12 = j14;
                                            p2.Q(bArr, j13 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                            long j17 = j13 + 3;
                                            p2.Q(bArr, j13 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                            j13 += 4;
                                            p2.Q(bArr, j17, (byte) ((codePoint & 63) | 128));
                                            i13 = i14;
                                        } else {
                                            i13 = i14;
                                        }
                                    }
                                    throw new d(i13 - 1, length);
                                }
                                if (55296 <= charAt2 && charAt2 <= 57343 && ((i12 = i13 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i12)))) {
                                    throw new d(i13, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str2 + charAt2 + str + j13);
                            }
                        }
                        j12 = j14;
                        j11 = 1;
                    }
                    i13++;
                    str3 = str;
                    str4 = str2;
                    j10 = j11;
                    j14 = j12;
                }
                return (int) j13;
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i10 + i11));
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        
            if (com.google.protobuf.p2.x(r13, r1) > (-65)) goto L٣٨;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
        
            if (com.google.protobuf.p2.x(r13, r1) > (-65)) goto L٥٩;
         */
        @Override // com.google.protobuf.q2.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int i(int i10, byte[] bArr, int i11, int i12) {
            long j10;
            byte b10 = 0;
            if ((i11 | i12 | (bArr.length - i12)) >= 0) {
                long j11 = i11;
                long j12 = i12;
                if (i10 != 0) {
                    if (j11 >= j12) {
                        return i10;
                    }
                    byte b11 = (byte) i10;
                    if (b11 < -32) {
                        if (b11 >= -62) {
                            long j13 = 1 + j11;
                            if (p2.x(bArr, j11) <= -65) {
                                j11 = j13;
                            }
                        }
                        return -1;
                    }
                    if (b11 < -16) {
                        byte b12 = (byte) (~(i10 >> 8));
                        if (b12 == 0) {
                            long j14 = j11 + 1;
                            b12 = p2.x(bArr, j11);
                            if (j14 >= j12) {
                                return q2.n(b11, b12);
                            }
                            j11 = j14;
                        }
                        if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                            j10 = j11 + 1;
                        }
                        return -1;
                    }
                    byte b13 = (byte) (~(i10 >> 8));
                    if (b13 == 0) {
                        long j15 = j11 + 1;
                        b13 = p2.x(bArr, j11);
                        if (j15 >= j12) {
                            return q2.n(b11, b13);
                        }
                        j11 = j15;
                    } else {
                        b10 = (byte) (i10 >> 16);
                    }
                    if (b10 == 0) {
                        long j16 = j11 + 1;
                        b10 = p2.x(bArr, j11);
                        if (j16 >= j12) {
                            return q2.o(b11, b13, b10);
                        }
                        j11 = j16;
                    }
                    if (b13 <= -65 && (((b11 << 28) + (b13 + 112)) >> 30) == 0 && b10 <= -65) {
                        j10 = j11 + 1;
                    }
                    return -1;
                    j11 = j10;
                }
                return o(bArr, j11, (int) (j12 - j11));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)));
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        
            if (com.google.protobuf.p2.w(r1) > (-65)) goto L١٧;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
        
            if (com.google.protobuf.p2.w(r1) > (-65)) goto L٣٦;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a3, code lost:
        
            if (com.google.protobuf.p2.w(r1) > (-65)) goto L٥٧;
         */
        @Override // com.google.protobuf.q2.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int l(int i10, ByteBuffer byteBuffer, int i11, int i12) {
            long j10;
            byte b10 = 0;
            if ((i11 | i12 | (byteBuffer.limit() - i12)) >= 0) {
                long k10 = p2.k(byteBuffer) + i11;
                long j11 = (i12 - i11) + k10;
                if (i10 != 0) {
                    if (k10 >= j11) {
                        return i10;
                    }
                    byte b11 = (byte) i10;
                    if (b11 < -32) {
                        if (b11 >= -62) {
                            j10 = 1 + k10;
                        }
                        return -1;
                    }
                    if (b11 < -16) {
                        byte b12 = (byte) (~(i10 >> 8));
                        if (b12 == 0) {
                            long j12 = k10 + 1;
                            b12 = p2.w(k10);
                            if (j12 >= j11) {
                                return q2.n(b11, b12);
                            }
                            k10 = j12;
                        }
                        if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                            j10 = 1 + k10;
                        }
                        return -1;
                    }
                    byte b13 = (byte) (~(i10 >> 8));
                    if (b13 == 0) {
                        long j13 = k10 + 1;
                        b13 = p2.w(k10);
                        if (j13 >= j11) {
                            return q2.n(b11, b13);
                        }
                        k10 = j13;
                    } else {
                        b10 = (byte) (i10 >> 16);
                    }
                    if (b10 == 0) {
                        long j14 = k10 + 1;
                        b10 = p2.w(k10);
                        if (j14 >= j11) {
                            return q2.o(b11, b13, b10);
                        }
                        k10 = j14;
                    }
                    if (b13 <= -65 && (((b11 << 28) + (b13 + 112)) >> 30) == 0 && b10 <= -65) {
                        j10 = 1 + k10;
                    }
                    return -1;
                    k10 = j10;
                }
                return n(k10, (int) (j11 - k10));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    static {
        b cVar;
        if (e.m() && !com.google.protobuf.e.c()) {
            cVar = new e();
        } else {
            cVar = new c();
        }
        f١١٩٠٥a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(ByteBuffer byteBuffer, int i10, int i11) {
        return f١١٩٠٥a.a(byteBuffer, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(byte[] bArr, int i10, int i11) {
        return f١١٩٠٥a.b(bArr, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        return f١١٩٠٥a.e(charSequence, bArr, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length && charSequence.charAt(i10) < 128) {
            i10++;
        }
        int i11 = length;
        while (true) {
            if (i10 < length) {
                char charAt = charSequence.charAt(i10);
                if (charAt < 2048) {
                    i11 += (127 - charAt) >>> 31;
                    i10++;
                } else {
                    i11 += k(charSequence, i10);
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

    private static int k(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt < 2048) {
                i11 += (127 - charAt) >>> 31;
            } else {
                i11 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i10) >= 65536) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(ByteBuffer byteBuffer, int i10, int i11) {
        int i12 = i11 - 7;
        int i13 = i10;
        while (i13 < i12 && (byteBuffer.getLong(i13) & (-9187201950435737472L)) == 0) {
            i13 += 8;
        }
        return i13 - i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(int i10) {
        if (i10 > -12) {
            return -1;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(ByteBuffer byteBuffer, int i10, int i11, int i12) {
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 == 2) {
                    return o(i10, byteBuffer.get(i11), byteBuffer.get(i11 + 1));
                }
                throw new AssertionError();
            }
            return n(i10, byteBuffer.get(i11));
        }
        return m(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 == 2) {
                    return o(b10, bArr[i10], bArr[i10 + 1]);
                }
                throw new AssertionError();
            }
            return n(b10, bArr[i10]);
        }
        return m(b10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r(ByteBuffer byteBuffer) {
        return f١١٩٠٥a.f(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s(byte[] bArr) {
        return f١١٩٠٥a.g(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t(byte[] bArr, int i10, int i11) {
        return f١١٩٠٥a.g(bArr, i10, i11);
    }
}
