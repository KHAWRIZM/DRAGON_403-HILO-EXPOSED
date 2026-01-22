package e9;

import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import v8.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class f {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f١٣٩٦٥c;

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f١٣٩٦٣a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, Base64.padSymbol, 94, 0, 32, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f١٣٩٦٤b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, Utf8.REPLACEMENT_BYTE, 123, 125, 39, 0};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f١٣٩٦٦d = new byte[128];

    /* renamed from: e, reason: collision with root package name */
    private static final Charset f١٣٩٦٧e = StandardCharsets.ISO_8859_1;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٣٩٦٨a;

        static {
            int[] iArr = new int[c.values().length];
            f١٣٩٦٨a = iArr;
            try {
                iArr[c.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٣٩٦٨a[c.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٣٩٦٨a[c.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        int i10 = 0;
        byte[] bArr = new byte[128];
        f١٣٩٦٥c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i11 = 0;
        while (true) {
            byte[] bArr2 = f١٣٩٦٣a;
            if (i11 >= bArr2.length) {
                break;
            }
            byte b10 = bArr2[i11];
            if (b10 > 0) {
                f١٣٩٦٥c[b10] = (byte) i11;
            }
            i11++;
        }
        Arrays.fill(f١٣٩٦٦d, (byte) -1);
        while (true) {
            byte[] bArr3 = f١٣٩٦٤b;
            if (i10 < bArr3.length) {
                byte b11 = bArr3[i10];
                if (b11 > 0) {
                    f١٣٩٦٦d[b11] = (byte) i10;
                }
                i10++;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0028, code lost:
    
        return r1 - r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(String str, int i10, Charset charset) {
        int i11;
        CharsetEncoder newEncoder = charset.newEncoder();
        int length = str.length();
        int i12 = i10;
        while (i12 < length) {
            char charAt = str.charAt(i12);
            int i13 = 0;
            while (i13 < 13 && k(charAt) && (i11 = i12 + (i13 = i13 + 1)) < length) {
                charAt = str.charAt(i11);
            }
            char charAt2 = str.charAt(i12);
            if (newEncoder.canEncode(charAt2)) {
                i12++;
            } else {
                throw new h("Non-encodable character detected: " + charAt2 + " (Unicode: " + ((int) charAt2) + ')');
            }
        }
        return i12 - i10;
    }

    private static int b(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        if (i10 < length) {
            char charAt = charSequence.charAt(i10);
            while (k(charAt) && i10 < length) {
                i11++;
                i10++;
                if (i10 < length) {
                    charAt = charSequence.charAt(i10);
                }
            }
        }
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0027, code lost:
    
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int c(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = i10;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            int i12 = 0;
            while (i12 < 13 && k(charAt) && i11 < length) {
                i12++;
                i11++;
                if (i11 < length) {
                    charAt = charSequence.charAt(i11);
                }
            }
            if (i12 <= 0) {
                if (!n(charSequence.charAt(i11))) {
                    break;
                }
                i11++;
            }
        }
        return i11 - i10;
    }

    private static void d(byte[] bArr, int i10, int i11, int i12, StringBuilder sb) {
        int i13;
        if (i11 == 1 && i12 == 0) {
            sb.append((char) 913);
        } else if (i11 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i11 >= 6) {
            char[] cArr = new char[5];
            i13 = i10;
            while ((i10 + i11) - i13 >= 6) {
                long j10 = 0;
                for (int i14 = 0; i14 < 6; i14++) {
                    j10 = (j10 << 8) + (bArr[i13 + i14] & UByte.MAX_VALUE);
                }
                for (int i15 = 0; i15 < 5; i15++) {
                    cArr[i15] = (char) (j10 % 900);
                    j10 /= 900;
                }
                for (int i16 = 4; i16 >= 0; i16--) {
                    sb.append(cArr[i16]);
                }
                i13 += 6;
            }
        } else {
            i13 = i10;
        }
        while (i13 < i10 + i11) {
            sb.append((char) (bArr[i13] & UByte.MAX_VALUE));
            i13++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str, c cVar, Charset charset) {
        y8.c a10;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = f١٣٩٦٧e;
        } else if (!f١٣٩٦٧e.equals(charset) && (a10 = y8.c.a(charset.name())) != null) {
            h(a10.c(), sb);
        }
        int length = str.length();
        int i10 = a.f١٣٩٦٨a[cVar.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    int i11 = 0;
                    int i12 = 0;
                    int i13 = 0;
                    while (i11 < length) {
                        int b10 = b(str, i11);
                        if (b10 >= 13) {
                            sb.append((char) 902);
                            f(str, i11, b10, sb);
                            i11 += b10;
                            i12 = 0;
                            i13 = 2;
                        } else {
                            int c10 = c(str, i11);
                            if (c10 < 5 && b10 != length) {
                                int a11 = a(str, i11, charset);
                                if (a11 == 0) {
                                    a11 = 1;
                                }
                                int i14 = a11 + i11;
                                byte[] bytes = str.substring(i11, i14).getBytes(charset);
                                if (bytes.length == 1 && i13 == 0) {
                                    d(bytes, 0, 1, 0, sb);
                                } else {
                                    d(bytes, 0, bytes.length, i13, sb);
                                    i12 = 0;
                                    i13 = 1;
                                }
                                i11 = i14;
                            } else {
                                if (i13 != 0) {
                                    sb.append((char) 900);
                                    i12 = 0;
                                    i13 = 0;
                                }
                                i12 = g(str, i11, c10, sb, i12);
                                i11 += c10;
                            }
                        }
                    }
                } else {
                    sb.append((char) 902);
                    f(str, 0, length, sb);
                }
            } else {
                byte[] bytes2 = str.getBytes(charset);
                d(bytes2, 0, bytes2.length, 1, sb);
            }
        } else {
            g(str, 0, length, sb, 0);
        }
        return sb.toString();
    }

    private static void f(String str, int i10, int i11, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i11 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i12 = 0;
        while (i12 < i11) {
            sb2.setLength(0);
            int min = Math.min(44, i11 - i12);
            StringBuilder sb3 = new StringBuilder("1");
            int i13 = i10 + i12;
            sb3.append(str.substring(i13, i13 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i12 += min;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f4 A[EDGE_INSN: B:21:0x00f4->B:22:0x00f4 BREAK  A[LOOP:0: B:2:0x000f->B:16:0x000f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int g(CharSequence charSequence, int i10, int i11, StringBuilder sb, int i12) {
        StringBuilder sb2 = new StringBuilder(i11);
        int i13 = i12;
        int i14 = 0;
        while (true) {
            int i15 = i10 + i14;
            char charAt = charSequence.charAt(i15);
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (m(charAt)) {
                            sb2.append((char) f١٣٩٦٦d[charAt]);
                        } else {
                            sb2.append((char) 29);
                            i13 = 0;
                        }
                    } else if (l(charAt)) {
                        sb2.append((char) f١٣٩٦٥c[charAt]);
                    } else if (j(charAt)) {
                        sb2.append((char) 28);
                        i13 = 0;
                    } else if (i(charAt)) {
                        sb2.append((char) 27);
                        i13 = 1;
                    } else {
                        int i16 = i15 + 1;
                        if (i16 < i11 && m(charSequence.charAt(i16))) {
                            sb2.append((char) 25);
                            i13 = 3;
                        } else {
                            sb2.append((char) 29);
                            sb2.append((char) f١٣٩٦٦d[charAt]);
                        }
                    }
                } else if (i(charAt)) {
                    if (charAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (charAt - 'a'));
                    }
                } else if (j(charAt)) {
                    sb2.append((char) 27);
                    sb2.append((char) (charAt - 'A'));
                } else if (l(charAt)) {
                    sb2.append((char) 28);
                    i13 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) f١٣٩٦٦d[charAt]);
                }
                i14++;
                if (i14 < i11) {
                    break;
                }
            } else {
                if (j(charAt)) {
                    if (charAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (charAt - 'A'));
                    }
                } else if (i(charAt)) {
                    sb2.append((char) 27);
                    i13 = 1;
                } else if (l(charAt)) {
                    sb2.append((char) 28);
                    i13 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) f١٣٩٦٦d[charAt]);
                }
                i14++;
                if (i14 < i11) {
                }
            }
        }
        int length = sb2.length();
        char c10 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            if (i17 % 2 != 0) {
                c10 = (char) ((c10 * 30) + sb2.charAt(i17));
                sb.append(c10);
            } else {
                c10 = sb2.charAt(i17);
            }
        }
        if (length % 2 != 0) {
            sb.append((char) ((c10 * 30) + 29));
        }
        return i13;
    }

    private static void h(int i10, StringBuilder sb) {
        if (i10 >= 0 && i10 < 900) {
            sb.append((char) 927);
            sb.append((char) i10);
        } else if (i10 < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i10 / STSAssumeRoleSessionCredentialsProvider.DEFAULT_DURATION_SECONDS) - 1));
            sb.append((char) (i10 % STSAssumeRoleSessionCredentialsProvider.DEFAULT_DURATION_SECONDS));
        } else {
            if (i10 < 811800) {
                sb.append((char) 925);
                sb.append((char) (810900 - i10));
                return;
            }
            throw new h("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i10)));
        }
    }

    private static boolean i(char c10) {
        if (c10 != ' ') {
            if (c10 < 'a' || c10 > 'z') {
                return false;
            }
            return true;
        }
        return true;
    }

    private static boolean j(char c10) {
        if (c10 != ' ') {
            if (c10 < 'A' || c10 > 'Z') {
                return false;
            }
            return true;
        }
        return true;
    }

    private static boolean k(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return true;
        }
        return false;
    }

    private static boolean l(char c10) {
        if (f١٣٩٦٥c[c10] != -1) {
            return true;
        }
        return false;
    }

    private static boolean m(char c10) {
        if (f١٣٩٦٦d[c10] != -1) {
            return true;
        }
        return false;
    }

    private static boolean n(char c10) {
        if (c10 != '\t' && c10 != '\n' && c10 != '\r') {
            if (c10 < ' ' || c10 > '~') {
                return false;
            }
            return true;
        }
        return true;
    }
}
