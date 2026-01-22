package z0;

import e0.m;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import kotlin.io.encoding.Base64;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f١٩٣٢٩a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f١٩٣٣٠b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f١٩٣٣١c = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f١٩٣٣٢d = true;

    public static String a(byte[] bArr) {
        String str;
        try {
            str = b(bArr, bArr.length);
        } catch (IOException e10) {
            if (f١٩٣٣٢d) {
                str = null;
            } else {
                throw new AssertionError(e10.getMessage());
            }
        }
        if (!f١٩٣٣٢d && str == null) {
            throw new AssertionError();
        }
        return str;
    }

    public static String b(byte[] bArr, int i10) {
        int i11;
        if (bArr != null) {
            if (i10 >= 0) {
                if (i10 <= bArr.length) {
                    int i12 = (i10 / 3) * 4;
                    if (i10 % 3 > 0) {
                        i11 = 4;
                    } else {
                        i11 = 0;
                    }
                    int i13 = i12 + i11;
                    byte[] bArr2 = new byte[i13];
                    int i14 = i10 - 2;
                    int i15 = 0;
                    int i16 = 0;
                    while (i15 < i14) {
                        c(bArr, i15, 3, bArr2, i16, 0);
                        i15 += 3;
                        i16 += 4;
                    }
                    if (i15 < i10) {
                        c(bArr, i15, i10 - i15, bArr2, i16, 0);
                        i16 += 4;
                    }
                    int i17 = i16;
                    if (i17 <= i13 - 1) {
                        byte[] bArr3 = new byte[i17];
                        System.arraycopy(bArr2, 0, bArr3, 0, i17);
                        bArr2 = bArr3;
                    }
                    try {
                        return new String(bArr2, "US-ASCII");
                    } catch (UnsupportedEncodingException unused) {
                        return new String(bArr2);
                    }
                }
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i10), Integer.valueOf(bArr.length)));
            }
            throw new IllegalArgumentException(m.a(i10, "Cannot have length offset: "));
        }
        throw new IllegalArgumentException("Cannot serialize a null array.");
    }

    public static void c(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        byte[] bArr3;
        int i14;
        int i15;
        if ((i13 & 16) == 16) {
            bArr3 = f١٩٣٣٠b;
        } else if ((i13 & 32) == 32) {
            bArr3 = f١٩٣٣١c;
        } else {
            bArr3 = f١٩٣٢٩a;
        }
        int i16 = 0;
        if (i11 > 0) {
            i14 = (bArr[i10] << 24) >>> 8;
        } else {
            i14 = 0;
        }
        if (i11 > 1) {
            i15 = (bArr[i10 + 1] << 24) >>> 16;
        } else {
            i15 = 0;
        }
        int i17 = i15 | i14;
        if (i11 > 2) {
            i16 = (bArr[i10 + 2] << 24) >>> 24;
        }
        int i18 = i17 | i16;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    return;
                }
                bArr2[i12] = bArr3[i18 >>> 18];
                bArr2[i12 + 1] = bArr3[(i18 >>> 12) & 63];
                bArr2[i12 + 2] = bArr3[(i18 >>> 6) & 63];
                bArr2[i12 + 3] = bArr3[i18 & 63];
                return;
            }
            bArr2[i12] = bArr3[i18 >>> 18];
            bArr2[i12 + 1] = bArr3[(i18 >>> 12) & 63];
            bArr2[i12 + 2] = bArr3[(i18 >>> 6) & 63];
            bArr2[i12 + 3] = Base64.padSymbol;
            return;
        }
        bArr2[i12] = bArr3[i18 >>> 18];
        bArr2[i12 + 1] = bArr3[(i18 >>> 12) & 63];
        bArr2[i12 + 2] = Base64.padSymbol;
        bArr2[i12 + 3] = Base64.padSymbol;
    }
}
