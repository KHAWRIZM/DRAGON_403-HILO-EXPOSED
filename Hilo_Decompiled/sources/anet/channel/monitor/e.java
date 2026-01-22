package anet.channel.monitor;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private double f٤٨٣٠b;

    /* renamed from: c, reason: collision with root package name */
    private double f٤٨٣١c;

    /* renamed from: d, reason: collision with root package name */
    private double f٤٨٣٢d;

    /* renamed from: e, reason: collision with root package name */
    private double f٤٨٣٣e;

    /* renamed from: f, reason: collision with root package name */
    private double f٤٨٣٤f;

    /* renamed from: g, reason: collision with root package name */
    private double f٤٨٣٥g;

    /* renamed from: h, reason: collision with root package name */
    private double f٤٨٣٦h;

    /* renamed from: a, reason: collision with root package name */
    private long f٤٨٢٩a = 0;

    /* renamed from: i, reason: collision with root package name */
    private double f٤٨٣٧i = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    /* renamed from: j, reason: collision with root package name */
    private double f٤٨٣٨j = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    /* renamed from: k, reason: collision with root package name */
    private double f٤٨٣٩k = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    public double a(double d10, double d11) {
        char c10;
        double d12 = d10 / d11;
        if (d12 < 8.0d) {
            if (this.f٤٨٢٩a != 0) {
                return this.f٤٨٣٩k;
            }
            this.f٤٨٣٩k = d12;
            return d12;
        }
        long j10 = this.f٤٨٢٩a;
        if (j10 == 0) {
            this.f٤٨٣٧i = d12;
            this.f٤٨٣٦h = d12;
            this.f٤٨٣٢d = d12 * 0.1d;
            this.f٤٨٣١c = 0.02d * d12;
            this.f٤٨٣٣e = 0.1d * d12 * d12;
        } else if (j10 == 1) {
            this.f٤٨٣٨j = d12;
            this.f٤٨٣٦h = d12;
        } else {
            double d13 = this.f٤٨٣٨j;
            double d14 = d12 - d13;
            this.f٤٨٣٧i = d13;
            this.f٤٨٣٨j = d12;
            double d15 = d12 / 0.95d;
            this.f٤٨٣٠b = d15;
            this.f٤٨٣٥g = d15 - (this.f٤٨٣٦h * 0.95d);
            double sqrt = Math.sqrt(this.f٤٨٣٢d);
            double d16 = this.f٤٨٣٥g;
            if (d16 >= 4.0d * sqrt) {
                this.f٤٨٣٥g = (d16 * 0.75d) + (sqrt * 2.0d);
                c10 = 1;
            } else if (d16 <= (-4.0d) * sqrt) {
                this.f٤٨٣٥g = (sqrt * (-1.0d)) + (d16 * 0.75d);
                c10 = 2;
            } else {
                c10 = 0;
            }
            double d17 = this.f٤٨٣٢d * 1.05d;
            double d18 = this.f٤٨٣٥g;
            double min = Math.min(Math.max(Math.abs(d17 - ((0.0025d * d18) * d18)), this.f٤٨٣٢d * 0.8d), this.f٤٨٣٢d * 1.25d);
            this.f٤٨٣٢d = min;
            double d19 = this.f٤٨٣٣e;
            double d20 = d19 / ((0.9025d * d19) + min);
            this.f٤٨٣٤f = d20;
            double d21 = this.f٤٨٣٦h + (1.0526315789473684d * d14) + (d20 * this.f٤٨٣٥g);
            this.f٤٨٣٦h = d21;
            if (c10 == 1) {
                this.f٤٨٣٦h = Math.min(d21, this.f٤٨٣٠b);
            } else if (c10 == 2) {
                this.f٤٨٣٦h = Math.max(d21, this.f٤٨٣٠b);
            }
            this.f٤٨٣٣e = (1.0d - (0.95d * this.f٤٨٣٤f)) * (this.f٤٨٣٣e + this.f٤٨٣١c);
        }
        double d22 = this.f٤٨٣٦h;
        if (d22 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double d23 = this.f٤٨٣٨j * 0.7d;
            this.f٤٨٣٩k = d23;
            this.f٤٨٣٦h = d23;
        } else {
            this.f٤٨٣٩k = d22;
        }
        return this.f٤٨٣٩k;
    }

    public void a() {
        this.f٤٨٢٩a = 0L;
        this.f٤٨٣٩k = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }
}
