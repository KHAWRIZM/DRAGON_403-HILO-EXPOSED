package a2;

import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class n implements m {

    /* renamed from: a, reason: collision with root package name */
    private float f١٩١a;

    /* renamed from: b, reason: collision with root package name */
    private float f١٩٢b;

    /* renamed from: c, reason: collision with root package name */
    private float f١٩٣c;

    /* renamed from: d, reason: collision with root package name */
    private float f١٩٤d;

    /* renamed from: e, reason: collision with root package name */
    private float f١٩٥e;

    /* renamed from: f, reason: collision with root package name */
    private float f١٩٦f;

    /* renamed from: g, reason: collision with root package name */
    private float f١٩٧g;

    /* renamed from: h, reason: collision with root package name */
    private float f١٩٨h;

    /* renamed from: i, reason: collision with root package name */
    private float f١٩٩i;

    /* renamed from: j, reason: collision with root package name */
    private int f٢٠٠j;

    /* renamed from: k, reason: collision with root package name */
    private String f٢٠١k;

    /* renamed from: m, reason: collision with root package name */
    private float f٢٠٣m;

    /* renamed from: n, reason: collision with root package name */
    private float f٢٠٤n;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٢٠٢l = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٢٠٥o = false;

    private float c(float f10) {
        this.f٢٠٥o = false;
        float f11 = this.f١٩٤d;
        if (f10 <= f11) {
            float f12 = this.f١٩١a;
            return (f12 * f10) + ((((this.f١٩٢b - f12) * f10) * f10) / (f11 * 2.0f));
        }
        int i10 = this.f٢٠٠j;
        if (i10 == 1) {
            return this.f١٩٧g;
        }
        float f13 = f10 - f11;
        float f14 = this.f١٩٥e;
        if (f13 < f14) {
            float f15 = this.f١٩٧g;
            float f16 = this.f١٩٢b;
            return f15 + (f16 * f13) + ((((this.f١٩٣c - f16) * f13) * f13) / (f14 * 2.0f));
        }
        if (i10 == 2) {
            return this.f١٩٨h;
        }
        float f17 = f13 - f14;
        float f18 = this.f١٩٦f;
        if (f17 <= f18) {
            float f19 = this.f١٩٨h;
            float f20 = this.f١٩٣c;
            return (f19 + (f20 * f17)) - (((f20 * f17) * f17) / (f18 * 2.0f));
        }
        this.f٢٠٥o = true;
        return this.f١٩٩i;
    }

    private void f(float f10, float f11, float f12, float f13, float f14) {
        this.f٢٠٥o = false;
        if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
            f10 = 1.0E-4f;
        }
        this.f١٩١a = f10;
        float f15 = f10 / f12;
        float f16 = (f15 * f10) / 2.0f;
        if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
            float sqrt = (float) Math.sqrt((f11 - ((((-f10) / f12) * f10) / 2.0f)) * f12);
            if (sqrt < f13) {
                this.f٢٠١k = "backward accelerate, decelerate";
                this.f٢٠٠j = 2;
                this.f١٩١a = f10;
                this.f١٩٢b = sqrt;
                this.f١٩٣c = DownloadProgress.UNKNOWN_PROGRESS;
                float f17 = (sqrt - f10) / f12;
                this.f١٩٤d = f17;
                this.f١٩٥e = sqrt / f12;
                this.f١٩٧g = ((f10 + sqrt) * f17) / 2.0f;
                this.f١٩٨h = f11;
                this.f١٩٩i = f11;
                return;
            }
            this.f٢٠١k = "backward accelerate cruse decelerate";
            this.f٢٠٠j = 3;
            this.f١٩١a = f10;
            this.f١٩٢b = f13;
            this.f١٩٣c = f13;
            float f18 = (f13 - f10) / f12;
            this.f١٩٤d = f18;
            float f19 = f13 / f12;
            this.f١٩٦f = f19;
            float f20 = ((f10 + f13) * f18) / 2.0f;
            float f21 = (f19 * f13) / 2.0f;
            this.f١٩٥e = ((f11 - f20) - f21) / f13;
            this.f١٩٧g = f20;
            this.f١٩٨h = f11 - f21;
            this.f١٩٩i = f11;
            return;
        }
        if (f16 >= f11) {
            this.f٢٠١k = "hard stop";
            this.f٢٠٠j = 1;
            this.f١٩١a = f10;
            this.f١٩٢b = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٩٧g = f11;
            this.f١٩٤d = (2.0f * f11) / f10;
            return;
        }
        float f22 = f11 - f16;
        float f23 = f22 / f10;
        if (f23 + f15 < f14) {
            this.f٢٠١k = "cruse decelerate";
            this.f٢٠٠j = 2;
            this.f١٩١a = f10;
            this.f١٩٢b = f10;
            this.f١٩٣c = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٩٧g = f22;
            this.f١٩٨h = f11;
            this.f١٩٤d = f23;
            this.f١٩٥e = f15;
            return;
        }
        float sqrt2 = (float) Math.sqrt((f12 * f11) + ((f10 * f10) / 2.0f));
        float f24 = (sqrt2 - f10) / f12;
        this.f١٩٤d = f24;
        float f25 = sqrt2 / f12;
        this.f١٩٥e = f25;
        if (sqrt2 < f13) {
            this.f٢٠١k = "accelerate decelerate";
            this.f٢٠٠j = 2;
            this.f١٩١a = f10;
            this.f١٩٢b = sqrt2;
            this.f١٩٣c = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٩٤d = f24;
            this.f١٩٥e = f25;
            this.f١٩٧g = ((f10 + sqrt2) * f24) / 2.0f;
            this.f١٩٨h = f11;
            return;
        }
        this.f٢٠١k = "accelerate cruse decelerate";
        this.f٢٠٠j = 3;
        this.f١٩١a = f10;
        this.f١٩٢b = f13;
        this.f١٩٣c = f13;
        float f26 = (f13 - f10) / f12;
        this.f١٩٤d = f26;
        float f27 = f13 / f12;
        this.f١٩٦f = f27;
        float f28 = ((f10 + f13) * f26) / 2.0f;
        float f29 = (f27 * f13) / 2.0f;
        this.f١٩٥e = ((f11 - f28) - f29) / f13;
        this.f١٩٧g = f28;
        this.f١٩٨h = f11 - f29;
        this.f١٩٩i = f11;
    }

    @Override // a2.m
    public float a() {
        if (this.f٢٠٢l) {
            return -e(this.f٢٠٤n);
        }
        return e(this.f٢٠٤n);
    }

    @Override // a2.m
    public boolean b() {
        if (a() < 1.0E-5f && Math.abs(this.f١٩٩i - this.f٢٠٤n) < 1.0E-5f) {
            return true;
        }
        return false;
    }

    public void d(float f10, float f11, float f12, float f13, float f14, float f15) {
        boolean z10 = false;
        this.f٢٠٥o = false;
        this.f٢٠٣m = f10;
        if (f10 > f11) {
            z10 = true;
        }
        this.f٢٠٢l = z10;
        if (z10) {
            f(-f12, f10 - f11, f14, f15, f13);
        } else {
            f(f12, f11 - f10, f14, f15, f13);
        }
    }

    public float e(float f10) {
        float f11 = this.f١٩٤d;
        if (f10 <= f11) {
            float f12 = this.f١٩١a;
            return f12 + (((this.f١٩٢b - f12) * f10) / f11);
        }
        int i10 = this.f٢٠٠j;
        if (i10 == 1) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        float f13 = f10 - f11;
        float f14 = this.f١٩٥e;
        if (f13 < f14) {
            float f15 = this.f١٩٢b;
            return f15 + (((this.f١٩٣c - f15) * f13) / f14);
        }
        if (i10 == 2) {
            return this.f١٩٨h;
        }
        float f16 = f13 - f14;
        float f17 = this.f١٩٦f;
        if (f16 < f17) {
            float f18 = this.f١٩٣c;
            return f18 - ((f16 * f18) / f17);
        }
        return this.f١٩٩i;
    }

    @Override // a2.m
    public float getInterpolation(float f10) {
        float c10 = c(f10);
        this.f٢٠٤n = f10;
        if (this.f٢٠٢l) {
            return this.f٢٠٣m - c10;
        }
        return this.f٢٠٣m + c10;
    }
}
