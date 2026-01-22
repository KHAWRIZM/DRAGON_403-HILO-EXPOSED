package c9;

import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class n implements v8.g {
    /* JADX INFO: Access modifiers changed from: protected */
    public static int b(boolean[] zArr, int i10, int[] iArr, boolean z10) {
        int i11 = 0;
        for (int i12 : iArr) {
            int i13 = 0;
            while (i13 < i12) {
                zArr[i10] = z10;
                i13++;
                i10++;
            }
            i11 += i12;
            z10 = !z10;
        }
        return i11;
    }

    private static y8.b e(boolean[] zArr, int i10, int i11, int i12) {
        int length = zArr.length;
        int i13 = i12 + length;
        int max = Math.max(i10, i13);
        int max2 = Math.max(1, i11);
        int i14 = max / i13;
        int i15 = (max - (length * i14)) / 2;
        y8.b bVar = new y8.b(max, max2);
        int i16 = 0;
        while (i16 < length) {
            if (zArr[i16]) {
                bVar.h(i15, 0, i14, max2);
            }
            i16++;
            i15 += i14;
        }
        return bVar;
    }

    @Override // v8.g
    public y8.b a(String str, v8.a aVar, int i10, int i11, Map map) {
        if (!str.isEmpty()) {
            if (i10 >= 0 && i11 >= 0) {
                int d10 = d();
                if (map != null) {
                    v8.c cVar = v8.c.MARGIN;
                    if (map.containsKey(cVar)) {
                        d10 = Integer.parseInt(map.get(cVar).toString());
                    }
                }
                return e(c(str), i10, i11, d10);
            }
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i10 + 'x' + i11);
        }
        throw new IllegalArgumentException("Found empty contents");
    }

    public abstract boolean[] c(String str);

    public int d() {
        return 10;
    }
}
