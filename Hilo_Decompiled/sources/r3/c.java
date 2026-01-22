package r3;

import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c extends n {
    public c(List list) {
        super(d(list));
    }

    private static y3.a c(y3.a aVar) {
        s3.d dVar = (s3.d) aVar.f١٩١١٧b;
        s3.d dVar2 = (s3.d) aVar.f١٩١١٨c;
        if (dVar != null && dVar2 != null && dVar.e().length != dVar2.e().length) {
            float[] e10 = e(dVar.e(), dVar2.e());
            return aVar.b(dVar.b(e10), dVar2.b(e10));
        }
        return aVar;
    }

    private static List d(List list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            list.set(i10, c((y3.a) list.get(i10)));
        }
        return list;
    }

    static float[] e(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f10 = Float.NaN;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            float f11 = fArr3[i11];
            if (f11 != f10) {
                fArr3[i10] = f11;
                i10++;
                f10 = fArr3[i11];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i10);
    }

    @Override // r3.m
    public o3.a a() {
        return new o3.e(this.f١٧٣٣٩a);
    }

    @Override // r3.n, r3.m
    public /* bridge */ /* synthetic */ List b() {
        return super.b();
    }

    @Override // r3.n, r3.m
    public /* bridge */ /* synthetic */ boolean isStatic() {
        return super.isStatic();
    }

    @Override // r3.n
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
