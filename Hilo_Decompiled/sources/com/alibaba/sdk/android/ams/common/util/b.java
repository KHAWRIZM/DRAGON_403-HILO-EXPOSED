package com.alibaba.sdk.android.ams.common.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f٦٣٣١a = {ByteCompanionObject.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    private static final b f٦٣٣٢b = new b();

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f٦٣٣٣c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: d, reason: collision with root package name */
    private final long[] f٦٣٣٤d = new long[4];

    /* renamed from: e, reason: collision with root package name */
    private final long[] f٦٣٣٥e = new long[2];

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f٦٣٣٦f = new byte[64];

    /* renamed from: g, reason: collision with root package name */
    private final byte[] f٦٣٣٧g = new byte[16];

    private b() {
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(byte b10) {
        byte b11;
        if (b10 < 0) {
            b11 = b10 & UByte.MAX_VALUE;
        }
        return b11;
    }

    private long b(long j10, long j11, long j12) {
        return (j10 & j12) | (j11 & (~j12));
    }

    private long c(long j10, long j11, long j12) {
        return (j10 ^ j11) ^ j12;
    }

    private long d(long j10, long j11, long j12) {
        return (j10 | (~j12)) ^ j11;
    }

    private long a(long j10, long j11, long j12) {
        return ((~j10) & j12) | (j11 & j10);
    }

    private long b(long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        int b10 = (int) (b(j11, j12, j13) + j14 + j16 + j10);
        return ((b10 >>> ((int) (32 - j15))) | (b10 << ((int) j15))) + j11;
    }

    private long c(long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        int c10 = (int) (c(j11, j12, j13) + j14 + j16 + j10);
        return ((c10 >>> ((int) (32 - j15))) | (c10 << ((int) j15))) + j11;
    }

    private long d(long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        int d10 = (int) (d(j11, j12, j13) + j14 + j16 + j10);
        return ((d10 >>> ((int) (32 - j15))) | (d10 << ((int) j15))) + j11;
    }

    private long a(long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        int a10 = (int) (a(j11, j12, j13) + j14 + j16 + j10);
        return ((a10 >>> ((int) (32 - j15))) | (a10 << ((int) j15))) + j11;
    }

    public static String b(byte b10) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        return new String(new char[]{cArr[(b10 >>> 4) & 15], cArr[b10 & 15]});
    }

    private void c() {
        byte[] bArr = new byte[8];
        a(bArr, this.f٦٣٣٥e, 8);
        int i10 = ((int) (this.f٦٣٣٥e[0] >>> 3)) & 63;
        a(f٦٣٣١a, i10 < 56 ? 56 - i10 : 120 - i10);
        a(bArr, 8);
        a(this.f٦٣٣٧g, this.f٦٣٣٤d, 16);
    }

    public static b a() {
        return f٦٣٣٢b;
    }

    public String b(String str) {
        b();
        a(str.getBytes(Charset.forName("UTF-8")), str.length());
        c();
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < 16; i10++) {
            sb.append(b(this.f٦٣٣٧g[i10]));
        }
        return sb.toString();
    }

    private void b() {
        long[] jArr = this.f٦٣٣٥e;
        jArr[0] = 0;
        jArr[1] = 0;
        long[] jArr2 = this.f٦٣٣٤d;
        jArr2[0] = 1732584193;
        jArr2[1] = 4023233417L;
        jArr2[2] = 2562383102L;
        jArr2[3] = 271733878;
    }

    public String a(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            messageDigest = null;
        }
        messageDigest.update(str.getBytes(Charset.forName("UTF-8")));
        return a(messageDigest.digest());
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            char[] cArr = f٦٣٣٣c;
            sb.append(cArr[(b10 & 240) >>> 4]);
            sb.append(cArr[b10 & 15]);
        }
        return sb.toString();
    }

    private void b(byte[] bArr) {
        long[] jArr = this.f٦٣٣٤d;
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr[2];
        long j13 = jArr[3];
        long[] jArr2 = new long[16];
        a(jArr2, bArr, 64);
        long a10 = a(j10, j11, j12, j13, jArr2[0], 7L, 3614090360L);
        long a11 = a(j13, a10, j11, j12, jArr2[1], 12L, 3905402710L);
        long a12 = a(j12, a11, a10, j11, jArr2[2], 17L, 606105819L);
        long a13 = a(j11, a12, a11, a10, jArr2[3], 22L, 3250441966L);
        long a14 = a(a10, a13, a12, a11, jArr2[4], 7L, 4118548399L);
        long a15 = a(a11, a14, a13, a12, jArr2[5], 12L, 1200080426L);
        long a16 = a(a12, a15, a14, a13, jArr2[6], 17L, 2821735955L);
        long a17 = a(a13, a16, a15, a14, jArr2[7], 22L, 4249261313L);
        long a18 = a(a14, a17, a16, a15, jArr2[8], 7L, 1770035416L);
        long a19 = a(a15, a18, a17, a16, jArr2[9], 12L, 2336552879L);
        long a20 = a(a16, a19, a18, a17, jArr2[10], 17L, 4294925233L);
        long a21 = a(a17, a20, a19, a18, jArr2[11], 22L, 2304563134L);
        long a22 = a(a18, a21, a20, a19, jArr2[12], 7L, 1804603682L);
        long a23 = a(a19, a22, a21, a20, jArr2[13], 12L, 4254626195L);
        long a24 = a(a20, a23, a22, a21, jArr2[14], 17L, 2792965006L);
        long a25 = a(a21, a24, a23, a22, jArr2[15], 22L, 1236535329L);
        long b10 = b(a22, a25, a24, a23, jArr2[1], 5L, 4129170786L);
        long b11 = b(a23, b10, a25, a24, jArr2[6], 9L, 3225465664L);
        long b12 = b(a24, b11, b10, a25, jArr2[11], 14L, 643717713L);
        long b13 = b(a25, b12, b11, b10, jArr2[0], 20L, 3921069994L);
        long b14 = b(b10, b13, b12, b11, jArr2[5], 5L, 3593408605L);
        long b15 = b(b11, b14, b13, b12, jArr2[10], 9L, 38016083L);
        long b16 = b(b12, b15, b14, b13, jArr2[15], 14L, 3634488961L);
        long b17 = b(b13, b16, b15, b14, jArr2[4], 20L, 3889429448L);
        long b18 = b(b14, b17, b16, b15, jArr2[9], 5L, 568446438L);
        long b19 = b(b15, b18, b17, b16, jArr2[14], 9L, 3275163606L);
        long b20 = b(b16, b19, b18, b17, jArr2[3], 14L, 4107603335L);
        long b21 = b(b17, b20, b19, b18, jArr2[8], 20L, 1163531501L);
        long b22 = b(b18, b21, b20, b19, jArr2[13], 5L, 2850285829L);
        long b23 = b(b19, b22, b21, b20, jArr2[2], 9L, 4243563512L);
        long b24 = b(b20, b23, b22, b21, jArr2[7], 14L, 1735328473L);
        long b25 = b(b21, b24, b23, b22, jArr2[12], 20L, 2368359562L);
        long c10 = c(b22, b25, b24, b23, jArr2[5], 4L, 4294588738L);
        long c11 = c(b23, c10, b25, b24, jArr2[8], 11L, 2272392833L);
        long c12 = c(b24, c11, c10, b25, jArr2[11], 16L, 1839030562L);
        long c13 = c(b25, c12, c11, c10, jArr2[14], 23L, 4259657740L);
        long c14 = c(c10, c13, c12, c11, jArr2[1], 4L, 2763975236L);
        long c15 = c(c11, c14, c13, c12, jArr2[4], 11L, 1272893353L);
        long c16 = c(c12, c15, c14, c13, jArr2[7], 16L, 4139469664L);
        long c17 = c(c13, c16, c15, c14, jArr2[10], 23L, 3200236656L);
        long c18 = c(c14, c17, c16, c15, jArr2[13], 4L, 681279174L);
        long c19 = c(c15, c18, c17, c16, jArr2[0], 11L, 3936430074L);
        long c20 = c(c16, c19, c18, c17, jArr2[3], 16L, 3572445317L);
        long c21 = c(c17, c20, c19, c18, jArr2[6], 23L, 76029189L);
        long c22 = c(c18, c21, c20, c19, jArr2[9], 4L, 3654602809L);
        long c23 = c(c19, c22, c21, c20, jArr2[12], 11L, 3873151461L);
        long c24 = c(c20, c23, c22, c21, jArr2[15], 16L, 530742520L);
        long c25 = c(c21, c24, c23, c22, jArr2[2], 23L, 3299628645L);
        long d10 = d(c22, c25, c24, c23, jArr2[0], 6L, 4096336452L);
        long d11 = d(c23, d10, c25, c24, jArr2[7], 10L, 1126891415L);
        long d12 = d(c24, d11, d10, c25, jArr2[14], 15L, 2878612391L);
        long d13 = d(c25, d12, d11, d10, jArr2[5], 21L, 4237533241L);
        long d14 = d(d10, d13, d12, d11, jArr2[12], 6L, 1700485571L);
        long d15 = d(d11, d14, d13, d12, jArr2[3], 10L, 2399980690L);
        long d16 = d(d12, d15, d14, d13, jArr2[10], 15L, 4293915773L);
        long d17 = d(d13, d16, d15, d14, jArr2[1], 21L, 2240044497L);
        long d18 = d(d14, d17, d16, d15, jArr2[8], 6L, 1873313359L);
        long d19 = d(d15, d18, d17, d16, jArr2[15], 10L, 4264355552L);
        long d20 = d(d16, d19, d18, d17, jArr2[6], 15L, 2734768916L);
        long d21 = d(d17, d20, d19, d18, jArr2[13], 21L, 1309151649L);
        long d22 = d(d18, d21, d20, d19, jArr2[4], 6L, 4149444226L);
        long d23 = d(d19, d22, d21, d20, jArr2[11], 10L, 3174756917L);
        long d24 = d(d20, d23, d22, d21, jArr2[2], 15L, 718787259L);
        long d25 = d(d21, d24, d23, d22, jArr2[9], 21L, 3951481745L);
        long[] jArr3 = this.f٦٣٣٤d;
        jArr3[0] = jArr3[0] + d22;
        jArr3[1] = jArr3[1] + d25;
        jArr3[2] = jArr3[2] + d24;
        jArr3[3] = jArr3[3] + d23;
    }

    private void a(byte[] bArr, int i10) {
        int i11;
        byte[] bArr2 = new byte[64];
        long[] jArr = this.f٦٣٣٥e;
        long j10 = jArr[0];
        int i12 = ((int) (j10 >>> 3)) & 63;
        long j11 = i10 << 3;
        long j12 = j10 + j11;
        jArr[0] = j12;
        if (j12 < j11) {
            jArr[1] = jArr[1] + 1;
        }
        jArr[1] = jArr[1] + (i10 >>> 29);
        int i13 = 64 - i12;
        if (i10 >= i13) {
            a(this.f٦٣٣٦f, bArr, i12, 0, i13);
            b(this.f٦٣٣٦f);
            while (i13 + 63 < i10) {
                a(bArr2, bArr, 0, i13, 64);
                b(bArr2);
                i13 += 64;
            }
            i11 = i13;
            i12 = 0;
        } else {
            i11 = 0;
        }
        a(this.f٦٣٣٦f, bArr, i12, i11, i10 - i11);
    }

    private void a(byte[] bArr, byte[] bArr2, int i10, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[i10 + i13] = bArr2[i11 + i13];
        }
    }

    private void a(byte[] bArr, long[] jArr, int i10) {
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12 += 4) {
            long j10 = jArr[i11];
            bArr[i12] = (byte) (j10 & 255);
            bArr[i12 + 1] = (byte) ((j10 >>> 8) & 255);
            bArr[i12 + 2] = (byte) ((j10 >>> 16) & 255);
            bArr[i12 + 3] = (byte) ((j10 >>> 24) & 255);
            i11++;
        }
    }

    private void a(long[] jArr, byte[] bArr, int i10) {
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12 += 4) {
            jArr[i11] = a(bArr[i12]) | (a(bArr[i12 + 1]) << 8) | (a(bArr[i12 + 2]) << 16) | (a(bArr[i12 + 3]) << 24);
            i11++;
        }
    }
}
