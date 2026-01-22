package com.google.android.material.bottomappbar;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.g;
import f8.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d extends g implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private float f٨٤٠٠a;

    /* renamed from: b, reason: collision with root package name */
    private float f٨٤٠١b;

    /* renamed from: c, reason: collision with root package name */
    private float f٨٤٠٢c;

    /* renamed from: d, reason: collision with root package name */
    private float f٨٤٠٣d;

    /* renamed from: e, reason: collision with root package name */
    private float f٨٤٠٤e;

    /* renamed from: f, reason: collision with root package name */
    private float f٨٤٠٥f = -1.0f;

    public d(float f10, float f11, float f12) {
        this.f٨٤٠١b = f10;
        this.f٨٤٠٠a = f11;
        i(f12);
        this.f٨٤٠٤e = DownloadProgress.UNKNOWN_PROGRESS;
    }

    @Override // f8.g
    public void b(float f10, float f11, float f12, q qVar) {
        boolean z10;
        float f13;
        float f14;
        float f15 = this.f٨٤٠٢c;
        if (f15 == DownloadProgress.UNKNOWN_PROGRESS) {
            qVar.m(f10, DownloadProgress.UNKNOWN_PROGRESS);
            return;
        }
        float f16 = ((this.f٨٤٠١b * 2.0f) + f15) / 2.0f;
        float f17 = f12 * this.f٨٤٠٠a;
        float f18 = f11 + this.f٨٤٠٤e;
        float f19 = (this.f٨٤٠٣d * f12) + ((1.0f - f12) * f16);
        if (f19 / f16 >= 1.0f) {
            qVar.m(f10, DownloadProgress.UNKNOWN_PROGRESS);
            return;
        }
        float f20 = this.f٨٤٠٥f;
        float f21 = f20 * f12;
        if (f20 != -1.0f && Math.abs((f20 * 2.0f) - f15) >= 0.1f) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            f14 = 1.75f;
            f13 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f13 = f19;
            f14 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        float f22 = f16 + f17;
        float f23 = f13 + f17;
        float sqrt = (float) Math.sqrt((f22 * f22) - (f23 * f23));
        float f24 = f18 - sqrt;
        float f25 = f18 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f23));
        float f26 = (90.0f - degrees) + f14;
        qVar.m(f24, DownloadProgress.UNKNOWN_PROGRESS);
        float f27 = f17 * 2.0f;
        qVar.a(f24 - f17, DownloadProgress.UNKNOWN_PROGRESS, f24 + f17, f27, 270.0f, degrees);
        if (z10) {
            qVar.a(f18 - f16, (-f16) - f13, f18 + f16, f16 - f13, 180.0f - f26, (f26 * 2.0f) - 180.0f);
        } else {
            float f28 = this.f٨٤٠١b;
            float f29 = f21 * 2.0f;
            float f30 = f18 - f16;
            qVar.a(f30, -(f21 + f28), f30 + f28 + f29, f28 + f21, 180.0f - f26, ((f26 * 2.0f) - 180.0f) / 2.0f);
            float f31 = f18 + f16;
            float f32 = this.f٨٤٠١b;
            qVar.m(f31 - ((f32 / 2.0f) + f21), f32 + f21);
            float f33 = this.f٨٤٠١b;
            qVar.a(f31 - (f29 + f33), -(f21 + f33), f31, f33 + f21, 90.0f, f26 - 90.0f);
        }
        qVar.a(f25 - f17, DownloadProgress.UNKNOWN_PROGRESS, f25 + f17, f27, 270.0f - degrees, degrees);
        qVar.m(f10, DownloadProgress.UNKNOWN_PROGRESS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f٨٤٠٣d;
    }

    public float d() {
        return this.f٨٤٠٥f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f٨٤٠١b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.f٨٤٠٠a;
    }

    public float g() {
        return this.f٨٤٠٢c;
    }

    public float h() {
        return this.f٨٤٠٤e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(float f10) {
        if (f10 >= DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٨٤٠٣d = f10;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void j(float f10) {
        this.f٨٤٠٥f = f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(float f10) {
        this.f٨٤٠١b = f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(float f10) {
        this.f٨٤٠٠a = f10;
    }

    public void m(float f10) {
        this.f٨٤٠٢c = f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f10) {
        this.f٨٤٠٤e = f10;
    }
}
