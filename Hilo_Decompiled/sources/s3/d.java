package s3;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f١٧٧٢٤a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f١٧٧٢٥b;

    public d(float[] fArr, int[] iArr) {
        this.f١٧٧٢٤a = fArr;
        this.f١٧٧٢٥b = iArr;
    }

    private void a(d dVar) {
        int i10 = 0;
        while (true) {
            int[] iArr = dVar.f١٧٧٢٥b;
            if (i10 < iArr.length) {
                this.f١٧٧٢٤a[i10] = dVar.f١٧٧٢٤a[i10];
                this.f١٧٧٢٥b[i10] = iArr[i10];
                i10++;
            } else {
                return;
            }
        }
    }

    private int c(float f10) {
        int binarySearch = Arrays.binarySearch(this.f١٧٧٢٤a, f10);
        if (binarySearch >= 0) {
            return this.f١٧٧٢٥b[binarySearch];
        }
        int i10 = -(binarySearch + 1);
        if (i10 == 0) {
            return this.f١٧٧٢٥b[0];
        }
        int[] iArr = this.f١٧٧٢٥b;
        if (i10 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f١٧٧٢٤a;
        int i11 = i10 - 1;
        float f11 = fArr[i11];
        return x3.d.c((f10 - f11) / (fArr[i10] - f11), iArr[i11], iArr[i10]);
    }

    public d b(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            iArr[i10] = c(fArr[i10]);
        }
        return new d(fArr, iArr);
    }

    public int[] d() {
        return this.f١٧٧٢٥b;
    }

    public float[] e() {
        return this.f١٧٧٢٤a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (Arrays.equals(this.f١٧٧٢٤a, dVar.f١٧٧٢٤a) && Arrays.equals(this.f١٧٧٢٥b, dVar.f١٧٧٢٥b)) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f١٧٧٢٥b.length;
    }

    public void g(d dVar, d dVar2, float f10) {
        int[] iArr;
        if (dVar.equals(dVar2)) {
            a(dVar);
            return;
        }
        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
            a(dVar);
            return;
        }
        if (f10 >= 1.0f) {
            a(dVar2);
            return;
        }
        if (dVar.f١٧٧٢٥b.length == dVar2.f١٧٧٢٥b.length) {
            int i10 = 0;
            while (true) {
                iArr = dVar.f١٧٧٢٥b;
                if (i10 >= iArr.length) {
                    break;
                }
                this.f١٧٧٢٤a[i10] = x3.k.i(dVar.f١٧٧٢٤a[i10], dVar2.f١٧٧٢٤a[i10], f10);
                this.f١٧٧٢٥b[i10] = x3.d.c(f10, dVar.f١٧٧٢٥b[i10], dVar2.f١٧٧٢٥b[i10]);
                i10++;
            }
            int length = iArr.length;
            while (true) {
                float[] fArr = this.f١٧٧٢٤a;
                if (length < fArr.length) {
                    int[] iArr2 = dVar.f١٧٧٢٥b;
                    fArr[length] = fArr[iArr2.length - 1];
                    int[] iArr3 = this.f١٧٧٢٥b;
                    iArr3[length] = iArr3[iArr2.length - 1];
                    length++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + dVar.f١٧٧٢٥b.length + " vs " + dVar2.f١٧٧٢٥b.length + ")");
        }
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f١٧٧٢٤a) * 31) + Arrays.hashCode(this.f١٧٧٢٥b);
    }
}
