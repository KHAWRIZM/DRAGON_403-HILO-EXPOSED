package pa;

import android.view.animation.Interpolator;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import pa.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class c extends f {

    /* renamed from: g, reason: collision with root package name */
    private float f١٦٩٨٦g;

    /* renamed from: h, reason: collision with root package name */
    private float f١٦٩٨٧h;

    /* renamed from: i, reason: collision with root package name */
    private float f١٦٩٨٨i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٦٩٨٩j;

    public c(e.a... aVarArr) {
        super(aVarArr);
        this.f١٦٩٨٩j = true;
    }

    @Override // pa.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c clone() {
        ArrayList arrayList = this.f١٦٩٩٩e;
        int size = arrayList.size();
        e.a[] aVarArr = new e.a[size];
        for (int i10 = 0; i10 < size; i10++) {
            aVarArr[i10] = (e.a) ((e) arrayList.get(i10)).clone();
        }
        return new c(aVarArr);
    }

    public float e(float f10) {
        int i10 = this.f١٦٩٩٥a;
        if (i10 == 2) {
            if (this.f١٦٩٨٩j) {
                this.f١٦٩٨٩j = false;
                this.f١٦٩٨٦g = ((e.a) this.f١٦٩٩٩e.get(0)).i();
                float i11 = ((e.a) this.f١٦٩٩٩e.get(1)).i();
                this.f١٦٩٨٧h = i11;
                this.f١٦٩٨٨i = i11 - this.f١٦٩٨٦g;
            }
            Interpolator interpolator = this.f١٦٩٩٨d;
            if (interpolator != null) {
                f10 = interpolator.getInterpolation(f10);
            }
            h hVar = this.f١٧٠٠٠f;
            if (hVar == null) {
                return this.f١٦٩٨٦g + (f10 * this.f١٦٩٨٨i);
            }
            return ((Number) hVar.evaluate(f10, Float.valueOf(this.f١٦٩٨٦g), Float.valueOf(this.f١٦٩٨٧h))).floatValue();
        }
        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
            e.a aVar = (e.a) this.f١٦٩٩٩e.get(0);
            e.a aVar2 = (e.a) this.f١٦٩٩٩e.get(1);
            float i12 = aVar.i();
            float i13 = aVar2.i();
            float b10 = aVar.b();
            float b11 = aVar2.b();
            Interpolator c10 = aVar2.c();
            if (c10 != null) {
                f10 = c10.getInterpolation(f10);
            }
            float f11 = (f10 - b10) / (b11 - b10);
            h hVar2 = this.f١٧٠٠٠f;
            if (hVar2 == null) {
                return i12 + (f11 * (i13 - i12));
            }
            return ((Number) hVar2.evaluate(f11, Float.valueOf(i12), Float.valueOf(i13))).floatValue();
        }
        if (f10 >= 1.0f) {
            e.a aVar3 = (e.a) this.f١٦٩٩٩e.get(i10 - 2);
            e.a aVar4 = (e.a) this.f١٦٩٩٩e.get(this.f١٦٩٩٥a - 1);
            float i14 = aVar3.i();
            float i15 = aVar4.i();
            float b12 = aVar3.b();
            float b13 = aVar4.b();
            Interpolator c11 = aVar4.c();
            if (c11 != null) {
                f10 = c11.getInterpolation(f10);
            }
            float f12 = (f10 - b12) / (b13 - b12);
            h hVar3 = this.f١٧٠٠٠f;
            if (hVar3 == null) {
                return i14 + (f12 * (i15 - i14));
            }
            return ((Number) hVar3.evaluate(f12, Float.valueOf(i14), Float.valueOf(i15))).floatValue();
        }
        e.a aVar5 = (e.a) this.f١٦٩٩٩e.get(0);
        int i16 = 1;
        while (true) {
            int i17 = this.f١٦٩٩٥a;
            if (i16 < i17) {
                e.a aVar6 = (e.a) this.f١٦٩٩٩e.get(i16);
                if (f10 < aVar6.b()) {
                    Interpolator c12 = aVar6.c();
                    if (c12 != null) {
                        f10 = c12.getInterpolation(f10);
                    }
                    float b14 = (f10 - aVar5.b()) / (aVar6.b() - aVar5.b());
                    float i18 = aVar5.i();
                    float i19 = aVar6.i();
                    h hVar4 = this.f١٧٠٠٠f;
                    if (hVar4 == null) {
                        return i18 + (b14 * (i19 - i18));
                    }
                    return ((Number) hVar4.evaluate(b14, Float.valueOf(i18), Float.valueOf(i19))).floatValue();
                }
                i16++;
                aVar5 = aVar6;
            } else {
                return ((Number) ((e) this.f١٦٩٩٩e.get(i17 - 1)).d()).floatValue();
            }
        }
    }
}
