package v2;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import v2.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    double f١٨٣٩٠a;

    /* renamed from: b, reason: collision with root package name */
    double f١٨٣٩١b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٨٣٩٢c;

    /* renamed from: d, reason: collision with root package name */
    private double f١٨٣٩٣d;

    /* renamed from: e, reason: collision with root package name */
    private double f١٨٣٩٤e;

    /* renamed from: f, reason: collision with root package name */
    private double f١٨٣٩٥f;

    /* renamed from: g, reason: collision with root package name */
    private double f١٨٣٩٦g;

    /* renamed from: h, reason: collision with root package name */
    private double f١٨٣٩٧h;

    /* renamed from: i, reason: collision with root package name */
    private double f١٨٣٩٨i;

    /* renamed from: j, reason: collision with root package name */
    private final h.p f١٨٣٩٩j;

    public m() {
        this.f١٨٣٩٠a = Math.sqrt(1500.0d);
        this.f١٨٣٩١b = 0.5d;
        this.f١٨٣٩٢c = false;
        this.f١٨٣٩٨i = Double.MAX_VALUE;
        this.f١٨٣٩٩j = new h.p();
    }

    private void d() {
        if (this.f١٨٣٩٢c) {
            return;
        }
        if (this.f١٨٣٩٨i != Double.MAX_VALUE) {
            double d10 = this.f١٨٣٩١b;
            if (d10 > 1.0d) {
                double d11 = this.f١٨٣٩٠a;
                this.f١٨٣٩٥f = ((-d10) * d11) + (d11 * Math.sqrt((d10 * d10) - 1.0d));
                double d12 = this.f١٨٣٩١b;
                double d13 = this.f١٨٣٩٠a;
                this.f١٨٣٩٦g = ((-d12) * d13) - (d13 * Math.sqrt((d12 * d12) - 1.0d));
            } else if (d10 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d10 < 1.0d) {
                this.f١٨٣٩٧h = this.f١٨٣٩٠a * Math.sqrt(1.0d - (d10 * d10));
            }
            this.f١٨٣٩٢c = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    public float a() {
        return (float) this.f١٨٣٩١b;
    }

    public float b() {
        return (float) this.f١٨٣٩٨i;
    }

    public float c() {
        double d10 = this.f١٨٣٩٠a;
        return (float) (d10 * d10);
    }

    public boolean e(float f10, float f11) {
        if (Math.abs(f11) < this.f١٨٣٩٤e && Math.abs(f10 - b()) < this.f١٨٣٩٣d) {
            return true;
        }
        return false;
    }

    public m f(float f10) {
        if (f10 >= DownloadProgress.UNKNOWN_PROGRESS) {
            this.f١٨٣٩١b = f10;
            this.f١٨٣٩٢c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public m g(float f10) {
        this.f١٨٣٩٨i = f10;
        return this;
    }

    public m h(float f10) {
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
            this.f١٨٣٩٠a = Math.sqrt(f10);
            this.f١٨٣٩٢c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(double d10) {
        double abs = Math.abs(d10);
        this.f١٨٣٩٣d = abs;
        this.f١٨٣٩٤e = abs * 62.5d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h.p j(double d10, double d11, long j10) {
        double cos;
        double d12;
        d();
        double d13 = j10 / 1000.0d;
        double d14 = d10 - this.f١٨٣٩٨i;
        double d15 = this.f١٨٣٩١b;
        if (d15 > 1.0d) {
            double d16 = this.f١٨٣٩٦g;
            double d17 = this.f١٨٣٩٥f;
            double d18 = d14 - (((d16 * d14) - d11) / (d16 - d17));
            double d19 = ((d14 * d16) - d11) / (d16 - d17);
            d12 = (Math.pow(2.718281828459045d, d16 * d13) * d18) + (Math.pow(2.718281828459045d, this.f١٨٣٩٥f * d13) * d19);
            double d20 = this.f١٨٣٩٦g;
            double pow = d18 * d20 * Math.pow(2.718281828459045d, d20 * d13);
            double d21 = this.f١٨٣٩٥f;
            cos = pow + (d19 * d21 * Math.pow(2.718281828459045d, d21 * d13));
        } else if (d15 == 1.0d) {
            double d22 = this.f١٨٣٩٠a;
            double d23 = d11 + (d22 * d14);
            double d24 = d14 + (d23 * d13);
            d12 = Math.pow(2.718281828459045d, (-d22) * d13) * d24;
            double pow2 = d24 * Math.pow(2.718281828459045d, (-this.f١٨٣٩٠a) * d13);
            double d25 = this.f١٨٣٩٠a;
            cos = (d23 * Math.pow(2.718281828459045d, (-d25) * d13)) + (pow2 * (-d25));
        } else {
            double d26 = 1.0d / this.f١٨٣٩٧h;
            double d27 = this.f١٨٣٩٠a;
            double d28 = d26 * ((d15 * d27 * d14) + d11);
            double pow3 = Math.pow(2.718281828459045d, (-d15) * d27 * d13) * ((Math.cos(this.f١٨٣٩٧h * d13) * d14) + (Math.sin(this.f١٨٣٩٧h * d13) * d28));
            double d29 = this.f١٨٣٩٠a;
            double d30 = this.f١٨٣٩١b;
            double d31 = (-d29) * pow3 * d30;
            double pow4 = Math.pow(2.718281828459045d, (-d30) * d29 * d13);
            double d32 = this.f١٨٣٩٧h;
            double sin = (-d32) * d14 * Math.sin(d32 * d13);
            double d33 = this.f١٨٣٩٧h;
            cos = d31 + (pow4 * (sin + (d28 * d33 * Math.cos(d33 * d13))));
            d12 = pow3;
        }
        h.p pVar = this.f١٨٣٩٩j;
        pVar.f١٨٣٨٥a = (float) (d12 + this.f١٨٣٩٨i);
        pVar.f١٨٣٨٦b = (float) cos;
        return pVar;
    }

    public m(float f10) {
        this.f١٨٣٩٠a = Math.sqrt(1500.0d);
        this.f١٨٣٩١b = 0.5d;
        this.f١٨٣٩٢c = false;
        this.f١٨٣٩٨i = Double.MAX_VALUE;
        this.f١٨٣٩٩j = new h.p();
        this.f١٨٣٩٨i = f10;
    }
}
