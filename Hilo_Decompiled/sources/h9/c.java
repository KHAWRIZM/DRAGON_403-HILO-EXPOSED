package h9;

import g9.c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.UByte;
import v8.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f١٤٥٤٤a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٤٥٤٥a;

        static {
            int[] iArr = new int[g9.b.values().length];
            f١٤٥٤٥a = iArr;
            try {
                iArr[g9.b.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٤٥٤٥a[g9.b.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٤٥٤٥a[g9.b.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٤٥٤٥a[g9.b.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void a(String str, y8.a aVar, String str2) {
        try {
            for (byte b10 : str.getBytes(str2)) {
                aVar.c(b10, 8);
            }
        } catch (UnsupportedEncodingException e10) {
            throw new h(e10);
        }
    }

    static void b(CharSequence charSequence, y8.a aVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int p10 = p(charSequence.charAt(i10));
            if (p10 != -1) {
                int i11 = i10 + 1;
                if (i11 < length) {
                    int p11 = p(charSequence.charAt(i11));
                    if (p11 != -1) {
                        aVar.c((p10 * 45) + p11, 11);
                        i10 += 2;
                    } else {
                        throw new h();
                    }
                } else {
                    aVar.c(p10, 6);
                    i10 = i11;
                }
            } else {
                throw new h();
            }
        }
    }

    static void c(String str, g9.b bVar, y8.a aVar, String str2) {
        int i10 = a.f١٤٥٤٥a[bVar.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4) {
                        e(str, aVar);
                        return;
                    }
                    throw new h("Invalid mode: ".concat(String.valueOf(bVar)));
                }
                a(str, aVar, str2);
                return;
            }
            b(str, aVar);
            return;
        }
        h(str, aVar);
    }

    private static void d(y8.c cVar, y8.a aVar) {
        aVar.c(g9.b.ECI.a(), 4);
        aVar.c(cVar.c(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[LOOP:0: B:4:0x0008->B:11:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void e(String str, y8.a aVar) {
        int i10;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i11 = 0; i11 < length; i11 += 2) {
                int i12 = ((bytes[i11] & UByte.MAX_VALUE) << 8) | (bytes[i11 + 1] & UByte.MAX_VALUE);
                int i13 = 33088;
                if (i12 < 33088 || i12 > 40956) {
                    if (i12 >= 57408 && i12 <= 60351) {
                        i13 = 49472;
                    } else {
                        i10 = -1;
                        if (i10 == -1) {
                            aVar.c(((i10 >> 8) * 192) + (i10 & KotlinVersion.MAX_COMPONENT_VALUE), 13);
                        } else {
                            throw new h("Invalid byte sequence");
                        }
                    }
                }
                i10 = i12 - i13;
                if (i10 == -1) {
                }
            }
        } catch (UnsupportedEncodingException e10) {
            throw new h(e10);
        }
    }

    static void f(int i10, g9.c cVar, g9.b bVar, y8.a aVar) {
        int c10 = bVar.c(cVar);
        int i11 = 1 << c10;
        if (i10 < i11) {
            aVar.c(i10, c10);
            return;
        }
        throw new h(i10 + " is bigger than " + (i11 - 1));
    }

    static void g(g9.b bVar, y8.a aVar) {
        aVar.c(bVar.a(), 4);
    }

    static void h(CharSequence charSequence, y8.a aVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int charAt = charSequence.charAt(i10) - '0';
            int i11 = i10 + 2;
            if (i11 < length) {
                aVar.c((charAt * 100) + ((charSequence.charAt(i10 + 1) - '0') * 10) + (charSequence.charAt(i11) - '0'), 10);
                i10 += 3;
            } else {
                i10++;
                if (i10 < length) {
                    aVar.c((charAt * 10) + (charSequence.charAt(i10) - '0'), 7);
                    i10 = i11;
                } else {
                    aVar.c(charAt, 4);
                }
            }
        }
    }

    private static int i(g9.b bVar, y8.a aVar, y8.a aVar2, g9.c cVar) {
        return aVar.g() + bVar.c(cVar) + aVar2.g();
    }

    private static int j(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    private static int k(y8.a aVar, g9.a aVar2, g9.c cVar, b bVar) {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            e.a(aVar, aVar2, cVar, i12, bVar);
            int j10 = j(bVar);
            if (j10 < i10) {
                i11 = i12;
                i10 = j10;
            }
        }
        return i11;
    }

    private static g9.b l(String str, String str2) {
        if ("Shift_JIS".equals(str2) && s(str)) {
            return g9.b.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt >= '0' && charAt <= '9') {
                z11 = true;
            } else if (p(charAt) != -1) {
                z10 = true;
            } else {
                return g9.b.BYTE;
            }
        }
        if (z10) {
            return g9.b.ALPHANUMERIC;
        }
        if (z11) {
            return g9.b.NUMERIC;
        }
        return g9.b.BYTE;
    }

    private static g9.c m(int i10, g9.a aVar) {
        for (int i11 = 1; i11 <= 40; i11++) {
            g9.c e10 = g9.c.e(i11);
            if (v(i10, e10, aVar)) {
                return e10;
            }
        }
        throw new h("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f n(String str, g9.a aVar, Map map) {
        boolean z10;
        String str2;
        g9.c t10;
        int length;
        y8.c a10;
        if (map != null && map.containsKey(v8.c.CHARACTER_SET)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            str2 = map.get(v8.c.CHARACTER_SET).toString();
        } else {
            str2 = "ISO-8859-1";
        }
        g9.b l10 = l(str, str2);
        y8.a aVar2 = new y8.a();
        g9.b bVar = g9.b.BYTE;
        if (l10 == bVar && z10 && (a10 = y8.c.a(str2)) != null) {
            d(a10, aVar2);
        }
        if (map != null) {
            v8.c cVar = v8.c.GS1_FORMAT;
            if (map.containsKey(cVar) && Boolean.valueOf(map.get(cVar).toString()).booleanValue()) {
                g(g9.b.FNC1_FIRST_POSITION, aVar2);
            }
        }
        g(l10, aVar2);
        y8.a aVar3 = new y8.a();
        c(str, l10, aVar3, str2);
        if (map != null) {
            v8.c cVar2 = v8.c.QR_VERSION;
            if (map.containsKey(cVar2)) {
                t10 = g9.c.e(Integer.parseInt(map.get(cVar2).toString()));
                if (!v(i(l10, aVar2, aVar3, t10), t10, aVar)) {
                    throw new h("Data too big for requested version");
                }
                y8.a aVar4 = new y8.a();
                aVar4.b(aVar2);
                if (l10 != bVar) {
                    length = aVar3.h();
                } else {
                    length = str.length();
                }
                f(length, t10, l10, aVar4);
                aVar4.b(aVar3);
                c.b c10 = t10.c(aVar);
                int d10 = t10.d() - c10.d();
                u(d10, aVar4);
                y8.a r10 = r(aVar4, t10.d(), d10, c10.c());
                f fVar = new f();
                fVar.c(aVar);
                fVar.f(l10);
                fVar.g(t10);
                int b10 = t10.b();
                b bVar2 = new b(b10, b10);
                int k10 = k(r10, aVar, t10, bVar2);
                fVar.d(k10);
                e.a(r10, aVar, t10, k10, bVar2);
                fVar.e(bVar2);
                return fVar;
            }
        }
        t10 = t(aVar, l10, aVar2, aVar3);
        y8.a aVar42 = new y8.a();
        aVar42.b(aVar2);
        if (l10 != bVar) {
        }
        f(length, t10, l10, aVar42);
        aVar42.b(aVar3);
        c.b c102 = t10.c(aVar);
        int d102 = t10.d() - c102.d();
        u(d102, aVar42);
        y8.a r102 = r(aVar42, t10.d(), d102, c102.c());
        f fVar2 = new f();
        fVar2.c(aVar);
        fVar2.f(l10);
        fVar2.g(t10);
        int b102 = t10.b();
        b bVar22 = new b(b102, b102);
        int k102 = k(r102, aVar, t10, bVar22);
        fVar2.d(k102);
        e.a(r102, aVar, t10, k102, bVar22);
        fVar2.e(bVar22);
        return fVar2;
    }

    static byte[] o(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length + i10];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & UByte.MAX_VALUE;
        }
        new z8.c(z8.a.f١٩٥٠٦l).b(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    static int p(int i10) {
        int[] iArr = f١٤٥٤٤a;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    static void q(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) {
        if (i13 < i12) {
            int i14 = i10 % i12;
            int i15 = i12 - i14;
            int i16 = i10 / i12;
            int i17 = i16 + 1;
            int i18 = i11 / i12;
            int i19 = i18 + 1;
            int i20 = i16 - i18;
            int i21 = i17 - i19;
            if (i20 == i21) {
                if (i12 == i15 + i14) {
                    if (i10 == ((i18 + i20) * i15) + ((i19 + i21) * i14)) {
                        if (i13 < i15) {
                            iArr[0] = i18;
                            iArr2[0] = i20;
                            return;
                        } else {
                            iArr[0] = i19;
                            iArr2[0] = i21;
                            return;
                        }
                    }
                    throw new h("Total bytes mismatch");
                }
                throw new h("RS blocks mismatch");
            }
            throw new h("EC bytes mismatch");
        }
        throw new h("Block ID too large");
    }

    static y8.a r(y8.a aVar, int i10, int i11, int i12) {
        if (aVar.h() == i11) {
            ArrayList arrayList = new ArrayList(i12);
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < i12; i16++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                q(i10, i11, i12, i16, iArr, iArr2);
                int i17 = iArr[0];
                byte[] bArr = new byte[i17];
                aVar.j(i13 << 3, bArr, 0, i17);
                byte[] o10 = o(bArr, iArr2[0]);
                arrayList.add(new h9.a(bArr, o10));
                i14 = Math.max(i14, i17);
                i15 = Math.max(i15, o10.length);
                i13 += iArr[0];
            }
            if (i11 == i13) {
                y8.a aVar2 = new y8.a();
                for (int i18 = 0; i18 < i14; i18++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] a10 = ((h9.a) it.next()).a();
                        if (i18 < a10.length) {
                            aVar2.c(a10[i18], 8);
                        }
                    }
                }
                for (int i19 = 0; i19 < i15; i19++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] b10 = ((h9.a) it2.next()).b();
                        if (i19 < b10.length) {
                            aVar2.c(b10[i19], 8);
                        }
                    }
                }
                if (i10 == aVar2.h()) {
                    return aVar2;
                }
                throw new h("Interleaving error: " + i10 + " and " + aVar2.h() + " differ.");
            }
            throw new h("Data bytes does not match offset");
        }
        throw new h("Number of bits and data bytes does not match");
    }

    private static boolean s(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i10 = 0; i10 < length; i10 += 2) {
                int i11 = bytes[i10] & UByte.MAX_VALUE;
                if ((i11 < 129 || i11 > 159) && (i11 < 224 || i11 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static g9.c t(g9.a aVar, g9.b bVar, y8.a aVar2, y8.a aVar3) {
        return m(i(bVar, aVar2, aVar3, m(i(bVar, aVar2, aVar3, g9.c.e(1)), aVar)), aVar);
    }

    static void u(int i10, y8.a aVar) {
        int i11;
        int i12 = i10 << 3;
        if (aVar.g() <= i12) {
            for (int i13 = 0; i13 < 4 && aVar.g() < i12; i13++) {
                aVar.a(false);
            }
            int g10 = aVar.g() & 7;
            if (g10 > 0) {
                while (g10 < 8) {
                    aVar.a(false);
                    g10++;
                }
            }
            int h10 = i10 - aVar.h();
            for (int i14 = 0; i14 < h10; i14++) {
                if ((i14 & 1) == 0) {
                    i11 = 236;
                } else {
                    i11 = 17;
                }
                aVar.c(i11, 8);
            }
            if (aVar.g() == i12) {
                return;
            } else {
                throw new h("Bits size does not equal capacity");
            }
        }
        throw new h("data bits cannot fit in the QR Code" + aVar.g() + " > " + i12);
    }

    private static boolean v(int i10, g9.c cVar, g9.a aVar) {
        if (cVar.d() - cVar.c(aVar).d() >= (i10 + 7) / 8) {
            return true;
        }
        return false;
    }
}
