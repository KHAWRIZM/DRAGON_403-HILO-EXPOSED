package com.google.android.material.carousel;

import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final int f٨٦٤٦a;

    /* renamed from: b, reason: collision with root package name */
    float f٨٦٤٧b;

    /* renamed from: c, reason: collision with root package name */
    int f٨٦٤٨c;

    /* renamed from: d, reason: collision with root package name */
    int f٨٦٤٩d;

    /* renamed from: e, reason: collision with root package name */
    float f٨٦٥٠e;

    /* renamed from: f, reason: collision with root package name */
    float f٨٦٥١f;

    /* renamed from: g, reason: collision with root package name */
    final int f٨٦٥٢g;

    /* renamed from: h, reason: collision with root package name */
    final float f٨٦٥٣h;

    public a(int i10, float f10, float f11, float f12, int i11, float f13, int i12, float f14, int i13, float f15) {
        this.f٨٦٤٦a = i10;
        this.f٨٦٤٧b = j2.a.a(f10, f11, f12);
        this.f٨٦٤٨c = i11;
        this.f٨٦٥٠e = f13;
        this.f٨٦٤٩d = i12;
        this.f٨٦٥١f = f14;
        this.f٨٦٥٢g = i13;
        d(f15, f11, f12, f14);
        this.f٨٦٥٣h = b(f14);
    }

    private float a(float f10, int i10, float f11, int i11, int i12) {
        if (i10 <= 0) {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        float f12 = i11 / 2.0f;
        return (f10 - ((i10 + f12) * f11)) / (i12 + f12);
    }

    private float b(float f10) {
        if (!g()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(f10 - this.f٨٦٥١f) * this.f٨٦٤٦a;
    }

    public static a c(float f10, float f11, float f12, float f13, int[] iArr, float f14, int[] iArr2, float f15, int[] iArr3) {
        a aVar = null;
        int i10 = 1;
        for (int i11 : iArr3) {
            int length = iArr2.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = iArr2[i12];
                int length2 = iArr.length;
                int i14 = 0;
                while (i14 < length2) {
                    int i15 = i14;
                    int i16 = length2;
                    int i17 = i12;
                    int i18 = length;
                    a aVar2 = new a(i10, f11, f12, f13, iArr[i14], f14, i13, f15, i11, f10);
                    if (aVar == null || aVar2.f٨٦٥٣h < aVar.f٨٦٥٣h) {
                        if (aVar2.f٨٦٥٣h == DownloadProgress.UNKNOWN_PROGRESS) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    i10++;
                    i14 = i15 + 1;
                    length2 = i16;
                    i12 = i17;
                    length = i18;
                }
                i12++;
            }
        }
        return aVar;
    }

    private void d(float f10, float f11, float f12, float f13) {
        float f14;
        float f15 = f10 - f();
        int i10 = this.f٨٦٤٨c;
        if (i10 > 0 && f15 > DownloadProgress.UNKNOWN_PROGRESS) {
            float f16 = this.f٨٦٤٧b;
            this.f٨٦٤٧b = f16 + Math.min(f15 / i10, f12 - f16);
        } else if (i10 > 0 && f15 < DownloadProgress.UNKNOWN_PROGRESS) {
            float f17 = this.f٨٦٤٧b;
            this.f٨٦٤٧b = f17 + Math.max(f15 / i10, f11 - f17);
        }
        int i11 = this.f٨٦٤٨c;
        if (i11 > 0) {
            f14 = this.f٨٦٤٧b;
        } else {
            f14 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        this.f٨٦٤٧b = f14;
        float a10 = a(f10, i11, f14, this.f٨٦٤٩d, this.f٨٦٥٢g);
        this.f٨٦٥١f = a10;
        float f18 = (this.f٨٦٤٧b + a10) / 2.0f;
        this.f٨٦٥٠e = f18;
        int i12 = this.f٨٦٤٩d;
        if (i12 > 0 && a10 != f13) {
            float f19 = (f13 - a10) * this.f٨٦٥٢g;
            float min = Math.min(Math.abs(f19), f18 * 0.1f * i12);
            if (f19 > DownloadProgress.UNKNOWN_PROGRESS) {
                this.f٨٦٥٠e -= min / this.f٨٦٤٩d;
                this.f٨٦٥١f += min / this.f٨٦٥٢g;
            } else {
                this.f٨٦٥٠e += min / this.f٨٦٤٩d;
                this.f٨٦٥١f -= min / this.f٨٦٥٢g;
            }
        }
    }

    private float f() {
        return (this.f٨٦٥١f * this.f٨٦٥٢g) + (this.f٨٦٥٠e * this.f٨٦٤٩d) + (this.f٨٦٤٧b * this.f٨٦٤٨c);
    }

    private boolean g() {
        int i10 = this.f٨٦٥٢g;
        if (i10 > 0 && this.f٨٦٤٨c > 0 && this.f٨٦٤٩d > 0) {
            float f10 = this.f٨٦٥١f;
            float f11 = this.f٨٦٥٠e;
            if (f10 <= f11 || f11 <= this.f٨٦٤٧b) {
                return false;
            }
            return true;
        }
        if (i10 > 0 && this.f٨٦٤٨c > 0 && this.f٨٦٥١f <= this.f٨٦٤٧b) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f٨٦٤٨c + this.f٨٦٤٩d + this.f٨٦٥٢g;
    }

    public String toString() {
        return "Arrangement [priority=" + this.f٨٦٤٦a + ", smallCount=" + this.f٨٦٤٨c + ", smallSize=" + this.f٨٦٤٧b + ", mediumCount=" + this.f٨٦٤٩d + ", mediumSize=" + this.f٨٦٥٠e + ", largeCount=" + this.f٨٦٥٢g + ", largeSize=" + this.f٨٦٥١f + ", cost=" + this.f٨٦٥٣h + "]";
    }
}
