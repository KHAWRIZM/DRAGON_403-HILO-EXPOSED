package c9;

import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class h extends n {
    private static int f(boolean[] zArr, int i10, int[] iArr) {
        boolean z10;
        int length = iArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i10 + 1;
            if (iArr[i11] != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            zArr[i10] = z10;
            i11++;
            i10 = i12;
        }
        return 9;
    }

    private static int g(String str, int i10) {
        int i11 = 0;
        int i12 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i11 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i12;
            i12++;
            if (i12 > i10) {
                i12 = 1;
            }
        }
        return i11 % 47;
    }

    private static void h(int i10, int[] iArr) {
        for (int i11 = 0; i11 < 9; i11++) {
            int i12 = 1;
            if (((1 << (8 - i11)) & i10) == 0) {
                i12 = 0;
            }
            iArr[i11] = i12;
        }
    }

    @Override // c9.n, v8.g
    public y8.b a(String str, v8.a aVar, int i10, int i11, Map map) {
        if (aVar == v8.a.CODE_93) {
            return super.a(str, aVar, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(aVar)));
    }

    @Override // c9.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int length2 = ((str.length() + 4) * 9) + 1;
            h(g.f٦٠٠٢b[47], iArr);
            boolean[] zArr = new boolean[length2];
            int f10 = f(zArr, 0, iArr);
            for (int i10 = 0; i10 < length; i10++) {
                h(g.f٦٠٠٢b["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i10))], iArr);
                f10 += f(zArr, f10, iArr);
            }
            int g10 = g(str, 20);
            int[] iArr2 = g.f٦٠٠٢b;
            h(iArr2[g10], iArr);
            int f11 = f10 + f(zArr, f10, iArr);
            h(iArr2[g(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(g10), 15)], iArr);
            int f12 = f11 + f(zArr, f11, iArr);
            h(iArr2[47], iArr);
            zArr[f12 + f(zArr, f12, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }
}
