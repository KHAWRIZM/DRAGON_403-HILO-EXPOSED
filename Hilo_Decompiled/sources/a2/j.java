package a2;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    protected b f١٧٤a;

    /* renamed from: b, reason: collision with root package name */
    protected int[] f١٧٥b = new int[10];

    /* renamed from: c, reason: collision with root package name */
    protected float[] f١٧٦c = new float[10];

    /* renamed from: d, reason: collision with root package name */
    private int f١٧٧d;

    /* renamed from: e, reason: collision with root package name */
    private String f١٧٨e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a {
        static void a(int[] iArr, float[] fArr, int i10, int i11) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i11;
            iArr2[1] = i10;
            int i12 = 2;
            while (i12 > 0) {
                int i13 = iArr2[i12 - 1];
                int i14 = i12 - 2;
                int i15 = iArr2[i14];
                if (i13 < i15) {
                    int b10 = b(iArr, fArr, i13, i15);
                    iArr2[i14] = b10 - 1;
                    iArr2[i12 - 1] = i13;
                    int i16 = i12 + 1;
                    iArr2[i12] = i15;
                    i12 += 2;
                    iArr2[i16] = b10 + 1;
                } else {
                    i12 = i14;
                }
            }
        }

        private static int b(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i11];
            int i13 = i10;
            while (i10 < i11) {
                if (iArr[i10] <= i12) {
                    c(iArr, fArr, i13, i10);
                    i13++;
                }
                i10++;
            }
            c(iArr, fArr, i13, i11);
            return i13;
        }

        private static void c(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float f10 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = f10;
        }
    }

    public float a(float f10) {
        return (float) this.f١٧٤a.c(f10, 0);
    }

    public float b(float f10) {
        return (float) this.f١٧٤a.f(f10, 0);
    }

    public void c(int i10, float f10) {
        int[] iArr = this.f١٧٥b;
        if (iArr.length < this.f١٧٧d + 1) {
            this.f١٧٥b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f١٧٦c;
            this.f١٧٦c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f١٧٥b;
        int i11 = this.f١٧٧d;
        iArr2[i11] = i10;
        this.f١٧٦c[i11] = f10;
        this.f١٧٧d = i11 + 1;
    }

    public void d(String str) {
        this.f١٧٨e = str;
    }

    public void e(int i10) {
        int i11 = this.f١٧٧d;
        if (i11 == 0) {
            return;
        }
        a.a(this.f١٧٥b, this.f١٧٦c, 0, i11 - 1);
        int i12 = 1;
        for (int i13 = 1; i13 < this.f١٧٧d; i13++) {
            int[] iArr = this.f١٧٥b;
            if (iArr[i13 - 1] != iArr[i13]) {
                i12++;
            }
        }
        double[] dArr = new double[i12];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i12, 1);
        int i14 = 0;
        for (int i15 = 0; i15 < this.f١٧٧d; i15++) {
            if (i15 > 0) {
                int[] iArr2 = this.f١٧٥b;
                if (iArr2[i15] == iArr2[i15 - 1]) {
                }
            }
            dArr[i14] = this.f١٧٥b[i15] * 0.01d;
            dArr2[i14][0] = this.f١٧٦c[i15];
            i14++;
        }
        this.f١٧٤a = b.a(i10, dArr, dArr2);
    }

    public String toString() {
        String str = this.f١٧٨e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f١٧٧d; i10++) {
            str = str + "[" + this.f١٧٥b[i10] + " , " + decimalFormat.format(this.f١٧٦c[i10]) + "] ";
        }
        return str;
    }
}
