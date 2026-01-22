package a2;

import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    float f٢١٧a;

    /* renamed from: b, reason: collision with root package name */
    float f٢١٨b;

    /* renamed from: c, reason: collision with root package name */
    float f٢١٩c;

    /* renamed from: d, reason: collision with root package name */
    float f٢٢٠d;

    /* renamed from: e, reason: collision with root package name */
    float f٢٢١e;

    /* renamed from: f, reason: collision with root package name */
    float f٢٢٢f;

    public void a(float f10, float f11, int i10, int i11, float[] fArr) {
        float f12 = fArr[0];
        float f13 = fArr[1];
        float f14 = (f11 - 0.5f) * 2.0f;
        float f15 = f12 + this.f٢١٩c;
        float f16 = f13 + this.f٢٢٠d;
        float f17 = f15 + (this.f٢١٧a * (f10 - 0.5f) * 2.0f);
        float f18 = f16 + (this.f٢١٨b * f14);
        float radians = (float) Math.toRadians(this.f٢٢٢f);
        float radians2 = (float) Math.toRadians(this.f٢٢١e);
        double d10 = radians;
        double d11 = i11 * f14;
        float sin = f17 + (((float) ((((-i10) * r7) * Math.sin(d10)) - (Math.cos(d10) * d11))) * radians2);
        float cos = f18 + (radians2 * ((float) (((i10 * r7) * Math.cos(d10)) - (d11 * Math.sin(d10)))));
        fArr[0] = sin;
        fArr[1] = cos;
    }

    public void b() {
        this.f٢٢١e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢٠d = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢١٩c = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢١٨b = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢١٧a = DownloadProgress.UNKNOWN_PROGRESS;
    }

    public void c(e eVar, float f10) {
        if (eVar != null) {
            this.f٢٢١e = eVar.b(f10);
        }
    }

    public void d(j jVar, float f10) {
        if (jVar != null) {
            this.f٢٢١e = jVar.b(f10);
            this.f٢٢٢f = jVar.a(f10);
        }
    }

    public void e(e eVar, e eVar2, float f10) {
        if (eVar != null) {
            this.f٢١٧a = eVar.b(f10);
        }
        if (eVar2 != null) {
            this.f٢١٨b = eVar2.b(f10);
        }
    }

    public void f(j jVar, j jVar2, float f10) {
        if (jVar != null) {
            this.f٢١٧a = jVar.b(f10);
        }
        if (jVar2 != null) {
            this.f٢١٨b = jVar2.b(f10);
        }
    }

    public void g(e eVar, e eVar2, float f10) {
        if (eVar != null) {
            this.f٢١٩c = eVar.b(f10);
        }
        if (eVar2 != null) {
            this.f٢٢٠d = eVar2.b(f10);
        }
    }

    public void h(j jVar, j jVar2, float f10) {
        if (jVar != null) {
            this.f٢١٩c = jVar.b(f10);
        }
        if (jVar2 != null) {
            this.f٢٢٠d = jVar2.b(f10);
        }
    }
}
