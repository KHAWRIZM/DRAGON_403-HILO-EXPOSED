package a2;

import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class k implements m {

    /* renamed from: c, reason: collision with root package name */
    private double f١٨١c;

    /* renamed from: d, reason: collision with root package name */
    private double f١٨٢d;

    /* renamed from: e, reason: collision with root package name */
    private double f١٨٣e;

    /* renamed from: f, reason: collision with root package name */
    private float f١٨٤f;

    /* renamed from: g, reason: collision with root package name */
    private float f١٨٥g;

    /* renamed from: h, reason: collision with root package name */
    private float f١٨٦h;

    /* renamed from: i, reason: collision with root package name */
    private float f١٨٧i;

    /* renamed from: j, reason: collision with root package name */
    private float f١٨٨j;

    /* renamed from: a, reason: collision with root package name */
    double f١٧٩a = 0.5d;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٨٠b = false;

    /* renamed from: k, reason: collision with root package name */
    private int f١٨٩k = 0;

    private void c(double d10) {
        double d11 = this.f١٨١c;
        double d12 = this.f١٧٩a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d11 / this.f١٨٧i) * d10) * 4.0d)) + 1.0d);
        double d13 = d10 / sqrt;
        int i10 = 0;
        while (i10 < sqrt) {
            float f10 = this.f١٨٥g;
            double d14 = this.f١٨٢d;
            float f11 = this.f١٨٦h;
            double d15 = d11;
            double d16 = ((-d11) * (f10 - d14)) - (f11 * d12);
            float f12 = this.f١٨٧i;
            double d17 = d12;
            double d18 = f11 + (((d16 / f12) * d13) / 2.0d);
            double d19 = ((((-((f10 + ((d13 * d18) / 2.0d)) - d14)) * d15) - (d18 * d17)) / f12) * d13;
            float f13 = (float) (f11 + d19);
            this.f١٨٦h = f13;
            float f14 = (float) (f10 + ((f11 + (d19 / 2.0d)) * d13));
            this.f١٨٥g = f14;
            int i11 = this.f١٨٩k;
            if (i11 > 0) {
                if (f14 < DownloadProgress.UNKNOWN_PROGRESS && (i11 & 1) == 1) {
                    this.f١٨٥g = -f14;
                    this.f١٨٦h = -f13;
                }
                float f15 = this.f١٨٥g;
                if (f15 > 1.0f && (i11 & 2) == 2) {
                    this.f١٨٥g = 2.0f - f15;
                    this.f١٨٦h = -this.f١٨٦h;
                }
            }
            i10++;
            d11 = d15;
            d12 = d17;
        }
    }

    @Override // a2.m
    public float a() {
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    @Override // a2.m
    public boolean b() {
        double d10 = this.f١٨٥g - this.f١٨٢d;
        double d11 = this.f١٨١c;
        double d12 = this.f١٨٦h;
        if (Math.sqrt((((d12 * d12) * this.f١٨٧i) + ((d11 * d10) * d10)) / d11) <= this.f١٨٨j) {
            return true;
        }
        return false;
    }

    public void d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i10) {
        this.f١٨٢d = f11;
        this.f١٧٩a = f15;
        this.f١٨٠b = false;
        this.f١٨٥g = f10;
        this.f١٨٣e = f12;
        this.f١٨١c = f14;
        this.f١٨٧i = f13;
        this.f١٨٨j = f16;
        this.f١٨٩k = i10;
        this.f١٨٤f = DownloadProgress.UNKNOWN_PROGRESS;
    }

    @Override // a2.m
    public float getInterpolation(float f10) {
        c(f10 - this.f١٨٤f);
        this.f١٨٤f = f10;
        return this.f١٨٥g;
    }
}
