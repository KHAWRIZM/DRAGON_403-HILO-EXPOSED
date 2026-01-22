package c9;

import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class k extends q {
    @Override // c9.n, v8.g
    public y8.b a(String str, v8.a aVar, int i10, int i11, Map map) {
        if (aVar == v8.a.EAN_8) {
            return super.a(str, aVar, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(aVar)));
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
                str = str + p.b(str);
            } catch (v8.d e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        boolean[] zArr = new boolean[67];
        int b10 = n.b(zArr, 0, p.f٦٠٠٩a, true);
        for (int i10 = 0; i10 <= 3; i10++) {
            b10 += n.b(zArr, b10, p.f٦٠١٢d[Character.digit(str.charAt(i10), 10)], false);
        }
        int b11 = b10 + n.b(zArr, b10, p.f٦٠١٠b, false);
        for (int i11 = 4; i11 <= 7; i11++) {
            b11 += n.b(zArr, b11, p.f٦٠١٢d[Character.digit(str.charAt(i11), 10)], true);
        }
        n.b(zArr, b11, p.f٦٠٠٩a, true);
        return zArr;
    }
}
