package gb;

import android.graphics.Path;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private Path f١٤٤٦٤a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private c f١٤٤٦٥b;

    @Override // gb.b
    public Path a(c cVar) {
        double radians = Math.toRadians(cVar.i());
        this.f١٤٤٦٥b = cVar;
        this.f١٤٤٦٤a.reset();
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        int i10 = 0;
        while (true) {
            double d10 = i10 * 6.283185307179586d;
            float d11 = cVar.d() + ((cVar.g() / 2.0f) * ((float) Math.cos(d10 / cVar.h())));
            float e10 = cVar.e() + ((cVar.g() / 2.0f) * ((float) Math.sin(d10 / cVar.h())));
            float cos = (float) (((Math.cos(radians) * (d11 - cVar.d())) - (Math.sin(radians) * (e10 - cVar.e()))) + cVar.d());
            float sin = (float) ((Math.sin(radians) * (d11 - cVar.d())) + (Math.cos(radians) * (e10 - cVar.e())) + cVar.e());
            if (i10 == 0) {
                this.f١٤٤٦٤a.moveTo(cos, sin);
            } else {
                b(f10, f11, cos, sin);
            }
            i10++;
            if (i10 > cVar.h()) {
                this.f١٤٤٦٤a.close();
                return this.f١٤٤٦٤a;
            }
            f11 = sin;
            f10 = cos;
        }
    }

    protected abstract void b(float f10, float f11, float f12, float f13);

    public Path c() {
        return this.f١٤٤٦٤a;
    }
}
