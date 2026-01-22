package v3;

import android.graphics.Color;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.KotlinVersion;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class o implements n0 {

    /* renamed from: a, reason: collision with root package name */
    private int f١٨٤٤٣a;

    public o(int i10) {
        this.f١٨٤٤٣a = i10;
    }

    private s3.d b(s3.d dVar, List list) {
        int i10 = this.f١٨٤٤٣a * 4;
        if (list.size() <= i10) {
            return dVar;
        }
        float[] e10 = dVar.e();
        int[] d10 = dVar.d();
        int size = (list.size() - i10) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i11 = 0;
        while (i10 < list.size()) {
            if (i10 % 2 == 0) {
                fArr[i11] = ((Float) list.get(i10)).floatValue();
            } else {
                fArr2[i11] = ((Float) list.get(i10)).floatValue();
                i11++;
            }
            i10++;
        }
        float[] e11 = e(dVar.e(), fArr);
        int length = e11.length;
        int[] iArr = new int[length];
        for (int i12 = 0; i12 < length; i12++) {
            float f10 = e11[i12];
            int binarySearch = Arrays.binarySearch(e10, f10);
            int binarySearch2 = Arrays.binarySearch(fArr, f10);
            if (binarySearch >= 0 && binarySearch2 <= 0) {
                iArr[i12] = d(f10, d10[binarySearch], fArr, fArr2);
            } else {
                if (binarySearch2 < 0) {
                    binarySearch2 = -(binarySearch2 + 1);
                }
                iArr[i12] = c(f10, fArr2[binarySearch2], e10, d10);
            }
        }
        return new s3.d(e11, iArr);
    }

    private int d(float f10, int i10, float[] fArr, float[] fArr2) {
        float i11;
        if (fArr2.length >= 2 && f10 > fArr[0]) {
            for (int i12 = 1; i12 < fArr.length; i12++) {
                float f11 = fArr[i12];
                if (f11 >= f10 || i12 == fArr.length - 1) {
                    if (f11 <= f10) {
                        i11 = fArr2[i12];
                    } else {
                        int i13 = i12 - 1;
                        float f12 = fArr[i13];
                        i11 = x3.k.i(fArr2[i13], fArr2[i12], (f10 - f12) / (f11 - f12));
                    }
                    return Color.argb((int) (i11 * 255.0f), Color.red(i10), Color.green(i10), Color.blue(i10));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    protected static float[] e(float[] fArr, float[] fArr2) {
        float f10;
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            float f11 = Float.NaN;
            if (i11 < fArr.length) {
                f10 = fArr[i11];
            } else {
                f10 = Float.NaN;
            }
            if (i12 < fArr2.length) {
                f11 = fArr2[i12];
            }
            if (!Float.isNaN(f11) && f10 >= f11) {
                if (!Float.isNaN(f10) && f11 >= f10) {
                    fArr3[i13] = f10;
                    i11++;
                    i12++;
                    i10++;
                } else {
                    fArr3[i13] = f11;
                    i12++;
                }
            } else {
                fArr3[i13] = f10;
                i11++;
            }
        }
        if (i10 == 0) {
            return fArr3;
        }
        return Arrays.copyOf(fArr3, length - i10);
    }

    int c(float f10, float f11, float[] fArr, int[] iArr) {
        if (iArr.length >= 2 && f10 != fArr[0]) {
            for (int i10 = 1; i10 < fArr.length; i10++) {
                float f12 = fArr[i10];
                if (f12 >= f10 || i10 == fArr.length - 1) {
                    if (i10 == fArr.length - 1 && f10 >= f12) {
                        return Color.argb((int) (f11 * 255.0f), Color.red(iArr[i10]), Color.green(iArr[i10]), Color.blue(iArr[i10]));
                    }
                    int i11 = i10 - 1;
                    float f13 = fArr[i11];
                    int c10 = x3.d.c((f10 - f13) / (f12 - f13), iArr[i11], iArr[i10]);
                    return Color.argb((int) (f11 * 255.0f), Color.red(c10), Color.green(c10), Color.blue(c10));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return iArr[0];
    }

    @Override // v3.n0
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public s3.d a(w3.c cVar, float f10) {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        if (cVar.u() == c.b.BEGIN_ARRAY) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            cVar.b();
        }
        while (cVar.j()) {
            arrayList.add(Float.valueOf((float) cVar.m()));
        }
        if (arrayList.size() == 4 && ((Float) arrayList.get(0)).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add((Float) arrayList.get(1));
            arrayList.add((Float) arrayList.get(2));
            arrayList.add((Float) arrayList.get(3));
            this.f١٨٤٤٣a = 2;
        }
        if (z10) {
            cVar.g();
        }
        if (this.f١٨٤٤٣a == -1) {
            this.f١٨٤٤٣a = arrayList.size() / 4;
        }
        int i10 = this.f١٨٤٤٣a;
        float[] fArr = new float[i10];
        int[] iArr = new int[i10];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f١٨٤٤٣a * 4; i13++) {
            int i14 = i13 / 4;
            double floatValue = ((Float) arrayList.get(i13)).floatValue();
            int i15 = i13 % 4;
            if (i15 != 0) {
                if (i15 != 1) {
                    if (i15 != 2) {
                        if (i15 == 3) {
                            iArr[i14] = Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, i11, i12, (int) (floatValue * 255.0d));
                        }
                    } else {
                        i12 = (int) (floatValue * 255.0d);
                    }
                } else {
                    i11 = (int) (floatValue * 255.0d);
                }
            } else {
                if (i14 > 0) {
                    float f11 = (float) floatValue;
                    if (fArr[i14 - 1] >= f11) {
                        fArr[i14] = f11 + 0.01f;
                    }
                }
                fArr[i14] = (float) floatValue;
            }
        }
        return b(new s3.d(fArr, iArr), arrayList);
    }
}
