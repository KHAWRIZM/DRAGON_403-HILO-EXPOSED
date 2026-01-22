package j9;

import kotlin.KotlinVersion;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.apache.commons.codec.binary.StringUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a extends b {

    /* renamed from: r, reason: collision with root package name */
    static final byte[] f١٥٣٤٤r = {13, 10};

    /* renamed from: s, reason: collision with root package name */
    private static final byte[] f١٥٣٤٥s = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: t, reason: collision with root package name */
    private static final byte[] f١٥٣٤٦t = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: u, reason: collision with root package name */
    private static final byte[] f١٥٣٤٧u = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* renamed from: l, reason: collision with root package name */
    private final byte[] f١٥٣٤٨l;

    /* renamed from: m, reason: collision with root package name */
    private final byte[] f١٥٣٤٩m;

    /* renamed from: n, reason: collision with root package name */
    private final byte[] f١٥٣٥٠n;

    /* renamed from: o, reason: collision with root package name */
    private final int f١٥٣٥١o;

    /* renamed from: p, reason: collision with root package name */
    private final int f١٥٣٥٢p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٥٣٥٣q;

    public a() {
        this(0);
    }

    public static byte[] l(String str) {
        return new a().d(str);
    }

    @Override // j9.b
    void c(byte[] bArr, int i10, int i11) {
        byte b10;
        if (this.f١٥٣٦٢i) {
            return;
        }
        if (i11 < 0) {
            this.f١٥٣٦٢i = true;
        }
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            f(this.f١٥٣٥١o);
            int i13 = i10 + 1;
            byte b11 = bArr[i10];
            if (b11 == 61) {
                this.f١٥٣٦٢i = true;
                break;
            }
            if (b11 >= 0) {
                byte[] bArr2 = f١٥٣٤٧u;
                if (b11 < bArr2.length && (b10 = bArr2[b11]) >= 0) {
                    int i14 = (this.f١٥٣٦٤k + 1) % 4;
                    this.f١٥٣٦٤k = i14;
                    int i15 = (this.f١٥٣٥٣q << 6) + b10;
                    this.f١٥٣٥٣q = i15;
                    if (i14 == 0) {
                        byte[] bArr3 = this.f١٥٣٥٩f;
                        int i16 = this.f١٥٣٦٠g;
                        int i17 = i16 + 1;
                        this.f١٥٣٦٠g = i17;
                        bArr3[i16] = (byte) ((i15 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
                        int i18 = i16 + 2;
                        this.f١٥٣٦٠g = i18;
                        bArr3[i17] = (byte) ((i15 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
                        this.f١٥٣٦٠g = i16 + 3;
                        bArr3[i18] = (byte) (i15 & KotlinVersion.MAX_COMPONENT_VALUE);
                    }
                }
            }
            i12++;
            i10 = i13;
        }
        if (this.f١٥٣٦٢i && this.f١٥٣٦٤k != 0) {
            f(this.f١٥٣٥١o);
            int i19 = this.f١٥٣٦٤k;
            if (i19 != 2) {
                if (i19 == 3) {
                    int i20 = this.f١٥٣٥٣q;
                    int i21 = i20 >> 2;
                    this.f١٥٣٥٣q = i21;
                    byte[] bArr4 = this.f١٥٣٥٩f;
                    int i22 = this.f١٥٣٦٠g;
                    int i23 = i22 + 1;
                    this.f١٥٣٦٠g = i23;
                    bArr4[i22] = (byte) ((i20 >> 10) & KotlinVersion.MAX_COMPONENT_VALUE);
                    this.f١٥٣٦٠g = i22 + 2;
                    bArr4[i23] = (byte) (i21 & KotlinVersion.MAX_COMPONENT_VALUE);
                    return;
                }
                return;
            }
            int i24 = this.f١٥٣٥٣q >> 4;
            this.f١٥٣٥٣q = i24;
            byte[] bArr5 = this.f١٥٣٥٩f;
            int i25 = this.f١٥٣٦٠g;
            this.f١٥٣٦٠g = i25 + 1;
            bArr5[i25] = (byte) (i24 & KotlinVersion.MAX_COMPONENT_VALUE);
        }
    }

    @Override // j9.b
    void e(byte[] bArr, int i10, int i11) {
        if (this.f١٥٣٦٢i) {
            return;
        }
        if (i11 < 0) {
            this.f١٥٣٦٢i = true;
            if (this.f١٥٣٦٤k == 0 && this.f١٥٣٥٧d == 0) {
                return;
            }
            f(this.f١٥٣٥٢p);
            int i12 = this.f١٥٣٦٠g;
            int i13 = this.f١٥٣٦٤k;
            if (i13 != 1) {
                if (i13 == 2) {
                    byte[] bArr2 = this.f١٥٣٥٩f;
                    int i14 = i12 + 1;
                    this.f١٥٣٦٠g = i14;
                    byte[] bArr3 = this.f١٥٣٤٨l;
                    int i15 = this.f١٥٣٥٣q;
                    bArr2[i12] = bArr3[(i15 >> 10) & 63];
                    int i16 = i12 + 2;
                    this.f١٥٣٦٠g = i16;
                    bArr2[i14] = bArr3[(i15 >> 4) & 63];
                    int i17 = i12 + 3;
                    this.f١٥٣٦٠g = i17;
                    bArr2[i16] = bArr3[(i15 << 2) & 63];
                    if (bArr3 == f١٥٣٤٥s) {
                        this.f١٥٣٦٠g = i12 + 4;
                        bArr2[i17] = Base64.padSymbol;
                    }
                }
            } else {
                byte[] bArr4 = this.f١٥٣٥٩f;
                int i18 = i12 + 1;
                this.f١٥٣٦٠g = i18;
                byte[] bArr5 = this.f١٥٣٤٨l;
                int i19 = this.f١٥٣٥٣q;
                bArr4[i12] = bArr5[(i19 >> 2) & 63];
                int i20 = i12 + 2;
                this.f١٥٣٦٠g = i20;
                bArr4[i18] = bArr5[(i19 << 4) & 63];
                if (bArr5 == f١٥٣٤٥s) {
                    int i21 = i12 + 3;
                    this.f١٥٣٦٠g = i21;
                    bArr4[i20] = Base64.padSymbol;
                    this.f١٥٣٦٠g = i12 + 4;
                    bArr4[i21] = Base64.padSymbol;
                }
            }
            int i22 = this.f١٥٣٦٣j;
            int i23 = this.f١٥٣٦٠g;
            int i24 = i22 + (i23 - i12);
            this.f١٥٣٦٣j = i24;
            if (this.f١٥٣٥٧d > 0 && i24 > 0) {
                byte[] bArr6 = this.f١٥٣٥٠n;
                System.arraycopy(bArr6, 0, this.f١٥٣٥٩f, i23, bArr6.length);
                this.f١٥٣٦٠g += this.f١٥٣٥٠n.length;
                return;
            }
            return;
        }
        int i25 = 0;
        while (i25 < i11) {
            f(this.f١٥٣٥٢p);
            int i26 = (this.f١٥٣٦٤k + 1) % 3;
            this.f١٥٣٦٤k = i26;
            int i27 = i10 + 1;
            int i28 = bArr[i10];
            if (i28 < 0) {
                i28 += 256;
            }
            int i29 = (this.f١٥٣٥٣q << 8) + i28;
            this.f١٥٣٥٣q = i29;
            if (i26 == 0) {
                byte[] bArr7 = this.f١٥٣٥٩f;
                int i30 = this.f١٥٣٦٠g;
                int i31 = i30 + 1;
                this.f١٥٣٦٠g = i31;
                byte[] bArr8 = this.f١٥٣٤٨l;
                bArr7[i30] = bArr8[(i29 >> 18) & 63];
                int i32 = i30 + 2;
                this.f١٥٣٦٠g = i32;
                bArr7[i31] = bArr8[(i29 >> 12) & 63];
                int i33 = i30 + 3;
                this.f١٥٣٦٠g = i33;
                bArr7[i32] = bArr8[(i29 >> 6) & 63];
                int i34 = i30 + 4;
                this.f١٥٣٦٠g = i34;
                bArr7[i33] = bArr8[i29 & 63];
                int i35 = this.f١٥٣٦٣j + 4;
                this.f١٥٣٦٣j = i35;
                int i36 = this.f١٥٣٥٧d;
                if (i36 > 0 && i36 <= i35) {
                    byte[] bArr9 = this.f١٥٣٥٠n;
                    System.arraycopy(bArr9, 0, bArr7, i34, bArr9.length);
                    this.f١٥٣٦٠g += this.f١٥٣٥٠n.length;
                    this.f١٥٣٦٣j = 0;
                }
            }
            i25++;
            i10 = i27;
        }
    }

    @Override // j9.b
    protected boolean h(byte b10) {
        if (b10 >= 0) {
            byte[] bArr = this.f١٥٣٤٩m;
            if (b10 < bArr.length && bArr[b10] != -1) {
                return true;
            }
        }
        return false;
    }

    public a(int i10) {
        this(i10, f١٥٣٤٤r);
    }

    public a(int i10, byte[] bArr) {
        this(i10, bArr, false);
    }

    public a(int i10, byte[] bArr, boolean z10) {
        super(3, 4, i10, bArr == null ? 0 : bArr.length);
        this.f١٥٣٤٩m = f١٥٣٤٧u;
        if (bArr != null) {
            if (b(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + StringUtils.newStringUtf8(bArr) + "]");
            }
            if (i10 > 0) {
                this.f١٥٣٥٢p = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.f١٥٣٥٠n = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.f١٥٣٥٢p = 4;
                this.f١٥٣٥٠n = null;
            }
        } else {
            this.f١٥٣٥٢p = 4;
            this.f١٥٣٥٠n = null;
        }
        this.f١٥٣٥١o = this.f١٥٣٥٢p - 1;
        this.f١٥٣٤٨l = z10 ? f١٥٣٤٦t : f١٥٣٤٥s;
    }
}
