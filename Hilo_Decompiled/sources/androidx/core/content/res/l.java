package androidx.core.content.res;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class l {

    /* renamed from: k, reason: collision with root package name */
    static final l f٢٧٨١k = k(b.f٢٧٤٦c, (float) ((b.h(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a, reason: collision with root package name */
    private final float f٢٧٨٢a;

    /* renamed from: b, reason: collision with root package name */
    private final float f٢٧٨٣b;

    /* renamed from: c, reason: collision with root package name */
    private final float f٢٧٨٤c;

    /* renamed from: d, reason: collision with root package name */
    private final float f٢٧٨٥d;

    /* renamed from: e, reason: collision with root package name */
    private final float f٢٧٨٦e;

    /* renamed from: f, reason: collision with root package name */
    private final float f٢٧٨٧f;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f٢٧٨٨g;

    /* renamed from: h, reason: collision with root package name */
    private final float f٢٧٨٩h;

    /* renamed from: i, reason: collision with root package name */
    private final float f٢٧٩٠i;

    /* renamed from: j, reason: collision with root package name */
    private final float f٢٧٩١j;

    private l(float f10, float f11, float f12, float f13, float f14, float f15, float[] fArr, float f16, float f17, float f18) {
        this.f٢٧٨٧f = f10;
        this.f٢٧٨٢a = f11;
        this.f٢٧٨٣b = f12;
        this.f٢٧٨٤c = f13;
        this.f٢٧٨٥d = f14;
        this.f٢٧٨٦e = f15;
        this.f٢٧٨٨g = fArr;
        this.f٢٧٨٩h = f16;
        this.f٢٧٩٠i = f17;
        this.f٢٧٩١j = f18;
    }

    static l k(float[] fArr, float f10, float f11, float f12, boolean z10) {
        float d10;
        float exp;
        float[][] fArr2 = b.f٢٧٤٤a;
        float f13 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f14 = fArr3[0] * f13;
        float f15 = fArr[1];
        float f16 = f14 + (fArr3[1] * f15);
        float f17 = fArr[2];
        float f18 = f16 + (fArr3[2] * f17);
        float[] fArr4 = fArr2[1];
        float f19 = (fArr4[0] * f13) + (fArr4[1] * f15) + (fArr4[2] * f17);
        float[] fArr5 = fArr2[2];
        float f20 = (f13 * fArr5[0]) + (f15 * fArr5[1]) + (f17 * fArr5[2]);
        float f21 = (f12 / 10.0f) + 0.8f;
        if (f21 >= 0.9d) {
            d10 = b.d(0.59f, 0.69f, (f21 - 0.9f) * 10.0f);
        } else {
            d10 = b.d(0.525f, 0.59f, (f21 - 0.8f) * 10.0f);
        }
        float f22 = d10;
        if (z10) {
            exp = 1.0f;
        } else {
            exp = (1.0f - (((float) Math.exp(((-f10) - 42.0f) / 92.0f)) * 0.2777778f)) * f21;
        }
        double d11 = exp;
        if (d11 > 1.0d) {
            exp = 1.0f;
        } else if (d11 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            exp = DownloadProgress.UNKNOWN_PROGRESS;
        }
        float[] fArr6 = {(((100.0f / f18) * exp) + 1.0f) - exp, (((100.0f / f19) * exp) + 1.0f) - exp, (((100.0f / f20) * exp) + 1.0f) - exp};
        float f23 = 1.0f / ((5.0f * f10) + 1.0f);
        float f24 = f23 * f23 * f23 * f23;
        float f25 = 1.0f - f24;
        float cbrt = (f24 * f10) + (0.1f * f25 * f25 * ((float) Math.cbrt(f10 * 5.0d)));
        float h10 = b.h(f11) / fArr[1];
        double d12 = h10;
        float sqrt = ((float) Math.sqrt(d12)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d12, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f18) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f19) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * cbrt) * f20) / 100.0d, 0.42d)};
        float f26 = fArr7[0];
        float f27 = (f26 * 400.0f) / (f26 + 27.13f);
        float f28 = fArr7[1];
        float f29 = (f28 * 400.0f) / (f28 + 27.13f);
        float f30 = fArr7[2];
        float[] fArr8 = {f27, f29, (400.0f * f30) / (f30 + 27.13f)};
        return new l(h10, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * pow, pow, pow, f22, f21, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.f٢٧٨٢a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f٢٧٨٥d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f٢٧٨٩h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f٢٧٩٠i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f٢٧٨٧f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.f٢٧٨٣b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f٢٧٨٦e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        return this.f٢٧٨٤c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float[] i() {
        return this.f٢٧٨٨g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f٢٧٩١j;
    }
}
