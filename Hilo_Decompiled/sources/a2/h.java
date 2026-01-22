package a2;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    double[] f١٦٦c;

    /* renamed from: d, reason: collision with root package name */
    String f١٦٧d;

    /* renamed from: e, reason: collision with root package name */
    g f١٦٨e;

    /* renamed from: f, reason: collision with root package name */
    int f١٦٩f;

    /* renamed from: a, reason: collision with root package name */
    float[] f١٦٤a = new float[0];

    /* renamed from: b, reason: collision with root package name */
    double[] f١٦٥b = new double[0];

    /* renamed from: g, reason: collision with root package name */
    double f١٧٠g = 6.283185307179586d;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٧١h = false;

    public void a(double d10, float f10) {
        int length = this.f١٦٤a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f١٦٥b, d10);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f١٦٥b = Arrays.copyOf(this.f١٦٥b, length);
        this.f١٦٤a = Arrays.copyOf(this.f١٦٤a, length);
        this.f١٦٦c = new double[length];
        double[] dArr = this.f١٦٥b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f١٦٥b[binarySearch] = d10;
        this.f١٦٤a[binarySearch] = f10;
        this.f١٧١h = false;
    }

    double b(double d10) {
        if (d10 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d10 = 1.0E-5d;
        } else if (d10 >= 1.0d) {
            d10 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f١٦٥b, d10);
        if (binarySearch > 0 || binarySearch == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        int i10 = -binarySearch;
        int i11 = i10 - 1;
        float[] fArr = this.f١٦٤a;
        float f10 = fArr[i11];
        int i12 = i10 - 2;
        float f11 = fArr[i12];
        double[] dArr = this.f١٦٥b;
        double d11 = dArr[i11];
        double d12 = dArr[i12];
        double d13 = (f10 - f11) / (d11 - d12);
        return (d10 * d13) + (f11 - (d13 * d12));
    }

    double c(double d10) {
        if (d10 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d10 = 0.0d;
        } else if (d10 > 1.0d) {
            d10 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f١٦٥b, d10);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        int i10 = -binarySearch;
        int i11 = i10 - 1;
        float[] fArr = this.f١٦٤a;
        float f10 = fArr[i11];
        int i12 = i10 - 2;
        float f11 = fArr[i12];
        double[] dArr = this.f١٦٥b;
        double d11 = dArr[i11];
        double d12 = dArr[i12];
        double d13 = (f10 - f11) / (d11 - d12);
        return this.f١٦٦c[i12] + ((f11 - (d13 * d12)) * (d10 - d12)) + ((d13 * ((d10 * d10) - (d12 * d12))) / 2.0d);
    }

    public double d(double d10, double d11, double d12) {
        double c10 = d11 + c(d10);
        double b10 = b(d10) + d12;
        switch (this.f١٦٩f) {
            case 1:
                return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            case 2:
                return b10 * 4.0d * Math.signum((((c10 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return b10 * 2.0d;
            case 4:
                return (-b10) * 2.0d;
            case 5:
                double d13 = this.f١٧٠g;
                return (-d13) * b10 * Math.sin(d13 * c10);
            case 6:
                return b10 * 4.0d * ((((c10 * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.f١٦٨e.f(c10 % 1.0d, 0);
            default:
                double d14 = this.f١٧٠g;
                return b10 * d14 * Math.cos(d14 * c10);
        }
    }

    public double e(double d10, double d11) {
        double abs;
        double c10 = c(d10) + d11;
        switch (this.f١٦٩f) {
            case 1:
                return Math.signum(0.5d - (c10 % 1.0d));
            case 2:
                abs = Math.abs((((c10 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((c10 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((c10 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f١٧٠g * (d11 + c10));
            case 6:
                double abs2 = 1.0d - Math.abs(((c10 * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.f١٦٨e.c(c10 % 1.0d, 0);
            default:
                return Math.sin(this.f١٧٠g * c10);
        }
        return 1.0d - abs;
    }

    public void f() {
        double d10 = 0.0d;
        int i10 = 0;
        while (true) {
            if (i10 >= this.f١٦٤a.length) {
                break;
            }
            d10 += r7[i10];
            i10++;
        }
        double d11 = 0.0d;
        int i11 = 1;
        while (true) {
            float[] fArr = this.f١٦٤a;
            if (i11 >= fArr.length) {
                break;
            }
            int i12 = i11 - 1;
            float f10 = (fArr[i12] + fArr[i11]) / 2.0f;
            double[] dArr = this.f١٦٥b;
            d11 += (dArr[i11] - dArr[i12]) * f10;
            i11++;
        }
        int i13 = 0;
        while (true) {
            float[] fArr2 = this.f١٦٤a;
            if (i13 >= fArr2.length) {
                break;
            }
            fArr2[i13] = (float) (fArr2[i13] * (d10 / d11));
            i13++;
        }
        this.f١٦٦c[0] = 0.0d;
        int i14 = 1;
        while (true) {
            float[] fArr3 = this.f١٦٤a;
            if (i14 < fArr3.length) {
                int i15 = i14 - 1;
                float f11 = (fArr3[i15] + fArr3[i14]) / 2.0f;
                double[] dArr2 = this.f١٦٥b;
                double d12 = dArr2[i14] - dArr2[i15];
                double[] dArr3 = this.f١٦٦c;
                dArr3[i14] = dArr3[i15] + (d12 * f11);
                i14++;
            } else {
                this.f١٧١h = true;
                return;
            }
        }
    }

    public void g(int i10, String str) {
        this.f١٦٩f = i10;
        this.f١٦٧d = str;
        if (str != null) {
            this.f١٦٨e = g.i(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f١٦٥b) + " period=" + Arrays.toString(this.f١٦٤a);
    }
}
