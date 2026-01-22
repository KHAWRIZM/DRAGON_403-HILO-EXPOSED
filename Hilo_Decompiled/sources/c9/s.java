package c9;

import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class s extends q {
    @Override // c9.n, v8.g
    public y8.b a(String str, v8.a aVar, int i10, int i11, Map map) {
        if (aVar == v8.a.UPC_E) {
            return super.a(str, aVar, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(aVar)));
    }

    @Override // c9.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length != 7) {
            if (length == 8) {
                try {
                    if (!p.a(str)) {
                        throw new IllegalArgumentException("Contents do not pass checksum");
                    }
                } catch (v8.d unused) {
                    throw new IllegalArgumentException("Illegal contents");
                }
            } else {
                throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
            }
        } else {
            try {
                str = str + p.b(r.c(str));
            } catch (v8.d e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        int digit = Character.digit(str.charAt(0), 10);
        if (digit != 0 && digit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i10 = r.f٦٠١٥g[digit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int b10 = n.b(zArr, 0, p.f٦٠٠٩a, true);
        for (int i11 = 1; i11 <= 6; i11++) {
            int digit2 = Character.digit(str.charAt(i11), 10);
            if (((i10 >> (6 - i11)) & 1) == 1) {
                digit2 += 10;
            }
            b10 += n.b(zArr, b10, p.f٦٠١٣e[digit2], false);
        }
        n.b(zArr, b10, p.f٦٠١١c, false);
        return zArr;
    }
}
