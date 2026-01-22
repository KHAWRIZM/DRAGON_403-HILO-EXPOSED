package w8;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import v8.g;
import x8.c;
import y8.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a implements g {
    private static b b(String str, v8.a aVar, int i10, int i11, Charset charset, int i12, int i13) {
        if (aVar == v8.a.AZTEC) {
            return c(c.d(str.getBytes(charset), i12, i13), i10, i11);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
    }

    private static b c(x8.a aVar, int i10, int i11) {
        b a10 = aVar.a();
        if (a10 != null) {
            int f10 = a10.f();
            int e10 = a10.e();
            int max = Math.max(i10, f10);
            int max2 = Math.max(i11, e10);
            int min = Math.min(max / f10, max2 / e10);
            int i12 = (max - (f10 * min)) / 2;
            int i13 = (max2 - (e10 * min)) / 2;
            b bVar = new b(max, max2);
            int i14 = 0;
            while (i14 < e10) {
                int i15 = i12;
                int i16 = 0;
                while (i16 < f10) {
                    if (a10.d(i16, i14)) {
                        bVar.h(i15, i13, min, min);
                    }
                    i16++;
                    i15 += min;
                }
                i14++;
                i13 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    @Override // v8.g
    public b a(String str, v8.a aVar, int i10, int i11, Map map) {
        Charset charset;
        int i12;
        int i13;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        int i14 = 33;
        if (map != null) {
            v8.c cVar = v8.c.CHARACTER_SET;
            if (map.containsKey(cVar)) {
                charset2 = Charset.forName(map.get(cVar).toString());
            }
            v8.c cVar2 = v8.c.ERROR_CORRECTION;
            if (map.containsKey(cVar2)) {
                i14 = Integer.parseInt(map.get(cVar2).toString());
            }
            v8.c cVar3 = v8.c.AZTEC_LAYERS;
            if (map.containsKey(cVar3)) {
                charset = charset2;
                i12 = i14;
                i13 = Integer.parseInt(map.get(cVar3).toString());
                return b(str, aVar, i10, i11, charset, i12, i13);
            }
            charset = charset2;
            i12 = i14;
        } else {
            charset = charset2;
            i12 = 33;
        }
        i13 = 0;
        return b(str, aVar, i10, i11, charset, i12, i13);
    }
}
