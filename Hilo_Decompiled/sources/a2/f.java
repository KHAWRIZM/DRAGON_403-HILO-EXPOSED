package a2;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f extends b {

    /* renamed from: a, reason: collision with root package name */
    private double[] f١٥٤a;

    /* renamed from: b, reason: collision with root package name */
    private double[][] f١٥٥b;

    /* renamed from: c, reason: collision with root package name */
    private double f١٥٦c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٥٧d = true;

    /* renamed from: e, reason: collision with root package name */
    double[] f١٥٨e;

    public f(double[] dArr, double[][] dArr2) {
        this.f١٥٦c = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f١٥٨e = new double[length2];
        this.f١٥٤a = dArr;
        this.f١٥٥b = dArr2;
        if (length2 > 2) {
            double d10 = 0.0d;
            double d11 = 0.0d;
            int i10 = 0;
            while (i10 < dArr.length) {
                double d12 = dArr2[i10][0];
                if (i10 > 0) {
                    Math.hypot(d12 - d10, d12 - d11);
                }
                i10++;
                d10 = d12;
                d11 = d10;
            }
            this.f١٥٦c = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
    }

    @Override // a2.b
    public double c(double d10, int i10) {
        double d11;
        double d12;
        double f10;
        double[] dArr = this.f١٥٤a;
        int length = dArr.length;
        int i11 = 0;
        if (this.f١٥٧d) {
            double d13 = dArr[0];
            if (d10 <= d13) {
                d11 = this.f١٥٥b[0][i10];
                d12 = d10 - d13;
                f10 = f(d13, i10);
            } else {
                int i12 = length - 1;
                double d14 = dArr[i12];
                if (d10 >= d14) {
                    d11 = this.f١٥٥b[i12][i10];
                    d12 = d10 - d14;
                    f10 = f(d14, i10);
                }
            }
            return d11 + (d12 * f10);
        }
        if (d10 <= dArr[0]) {
            return this.f١٥٥b[0][i10];
        }
        int i13 = length - 1;
        if (d10 >= dArr[i13]) {
            return this.f١٥٥b[i13][i10];
        }
        while (i11 < length - 1) {
            double[] dArr2 = this.f١٥٤a;
            double d15 = dArr2[i11];
            if (d10 == d15) {
                return this.f١٥٥b[i11][i10];
            }
            int i14 = i11 + 1;
            double d16 = dArr2[i14];
            if (d10 < d16) {
                double d17 = (d10 - d15) / (d16 - d15);
                double[][] dArr3 = this.f١٥٥b;
                return (dArr3[i11][i10] * (1.0d - d17)) + (dArr3[i14][i10] * d17);
            }
            i11 = i14;
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @Override // a2.b
    public void d(double d10, double[] dArr) {
        double[] dArr2 = this.f١٥٤a;
        int length = dArr2.length;
        int i10 = 0;
        int length2 = this.f١٥٥b[0].length;
        if (this.f١٥٧d) {
            double d11 = dArr2[0];
            if (d10 <= d11) {
                g(d11, this.f١٥٨e);
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = this.f١٥٥b[0][i11] + ((d10 - this.f١٥٤a[0]) * this.f١٥٨e[i11]);
                }
                return;
            }
            int i12 = length - 1;
            double d12 = dArr2[i12];
            if (d10 >= d12) {
                g(d12, this.f١٥٨e);
                while (i10 < length2) {
                    dArr[i10] = this.f١٥٥b[i12][i10] + ((d10 - this.f١٥٤a[i12]) * this.f١٥٨e[i10]);
                    i10++;
                }
                return;
            }
        } else {
            if (d10 <= dArr2[0]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    dArr[i13] = this.f١٥٥b[0][i13];
                }
                return;
            }
            int i14 = length - 1;
            if (d10 >= dArr2[i14]) {
                while (i10 < length2) {
                    dArr[i10] = this.f١٥٥b[i14][i10];
                    i10++;
                }
                return;
            }
        }
        int i15 = 0;
        while (i15 < length - 1) {
            if (d10 == this.f١٥٤a[i15]) {
                for (int i16 = 0; i16 < length2; i16++) {
                    dArr[i16] = this.f١٥٥b[i15][i16];
                }
            }
            double[] dArr3 = this.f١٥٤a;
            int i17 = i15 + 1;
            double d13 = dArr3[i17];
            if (d10 < d13) {
                double d14 = dArr3[i15];
                double d15 = (d10 - d14) / (d13 - d14);
                while (i10 < length2) {
                    double[][] dArr4 = this.f١٥٥b;
                    dArr[i10] = (dArr4[i15][i10] * (1.0d - d15)) + (dArr4[i17][i10] * d15);
                    i10++;
                }
                return;
            }
            i15 = i17;
        }
    }

    @Override // a2.b
    public void e(double d10, float[] fArr) {
        double[] dArr = this.f١٥٤a;
        int length = dArr.length;
        int i10 = 0;
        int length2 = this.f١٥٥b[0].length;
        if (this.f١٥٧d) {
            double d11 = dArr[0];
            if (d10 <= d11) {
                g(d11, this.f١٥٨e);
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) (this.f١٥٥b[0][i11] + ((d10 - this.f١٥٤a[0]) * this.f١٥٨e[i11]));
                }
                return;
            }
            int i12 = length - 1;
            double d12 = dArr[i12];
            if (d10 >= d12) {
                g(d12, this.f١٥٨e);
                while (i10 < length2) {
                    fArr[i10] = (float) (this.f١٥٥b[i12][i10] + ((d10 - this.f١٥٤a[i12]) * this.f١٥٨e[i10]));
                    i10++;
                }
                return;
            }
        } else {
            if (d10 <= dArr[0]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    fArr[i13] = (float) this.f١٥٥b[0][i13];
                }
                return;
            }
            int i14 = length - 1;
            if (d10 >= dArr[i14]) {
                while (i10 < length2) {
                    fArr[i10] = (float) this.f١٥٥b[i14][i10];
                    i10++;
                }
                return;
            }
        }
        int i15 = 0;
        while (i15 < length - 1) {
            if (d10 == this.f١٥٤a[i15]) {
                for (int i16 = 0; i16 < length2; i16++) {
                    fArr[i16] = (float) this.f١٥٥b[i15][i16];
                }
            }
            double[] dArr2 = this.f١٥٤a;
            int i17 = i15 + 1;
            double d13 = dArr2[i17];
            if (d10 < d13) {
                double d14 = dArr2[i15];
                double d15 = (d10 - d14) / (d13 - d14);
                while (i10 < length2) {
                    double[][] dArr3 = this.f١٥٥b;
                    fArr[i10] = (float) ((dArr3[i15][i10] * (1.0d - d15)) + (dArr3[i17][i10] * d15));
                    i10++;
                }
                return;
            }
            i15 = i17;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0012, code lost:
    
        if (r8 >= r3) goto L٤;
     */
    @Override // a2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double f(double d10, int i10) {
        double[] dArr = this.f١٥٤a;
        int length = dArr.length;
        int i11 = 0;
        double d11 = dArr[0];
        if (d10 >= d11) {
            d11 = dArr[length - 1];
        }
        d10 = d11;
        while (i11 < length - 1) {
            double[] dArr2 = this.f١٥٤a;
            int i12 = i11 + 1;
            double d12 = dArr2[i12];
            if (d10 <= d12) {
                double d13 = d12 - dArr2[i11];
                double[][] dArr3 = this.f١٥٥b;
                return (dArr3[i12][i10] - dArr3[i11][i10]) / d13;
            }
            i11 = i12;
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0017, code lost:
    
        if (r13 >= r4) goto L٤;
     */
    @Override // a2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(double d10, double[] dArr) {
        double[] dArr2 = this.f١٥٤a;
        int length = dArr2.length;
        int length2 = this.f١٥٥b[0].length;
        double d11 = dArr2[0];
        if (d10 > d11) {
            d11 = dArr2[length - 1];
        }
        d10 = d11;
        int i10 = 0;
        while (i10 < length - 1) {
            double[] dArr3 = this.f١٥٤a;
            int i11 = i10 + 1;
            double d12 = dArr3[i11];
            if (d10 <= d12) {
                double d13 = d12 - dArr3[i10];
                for (int i12 = 0; i12 < length2; i12++) {
                    double[][] dArr4 = this.f١٥٥b;
                    dArr[i12] = (dArr4[i11][i12] - dArr4[i10][i12]) / d13;
                }
                return;
            }
            i10 = i11;
        }
    }

    @Override // a2.b
    public double[] h() {
        return this.f١٥٤a;
    }
}
